/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static jsx.ui.StructureDescriptor.*;
import static teemowork.model.Status.*;

import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import teemowork.model.Ability;
import teemowork.model.AbilityDescriptor;
import teemowork.model.DescriptionView;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/10/14 11:02:40
 */
public class ItemView extends Widget1<Item> {

    private static final Status[] VISIBLE = {Health, BounusHealthRatio, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV,
            MRPen, AR, MR, MSRatio, GoldPer10Sec};

    private final Item item = model1;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        ItemDescriptor descriptor = item.getDescriptor(Version.Latest);

        box($.Root, () -> {
            box($.IconArea, () -> {
                box($.Icon, $.ItemImage.of(item));
                box($.Materials, contents(descriptor.getBuildItem(), material -> {
                    box($.Material, $.ItemImage.of(material));
                }));
            });
            box($.DescriptionArea, () -> {
                // Name and Cost
                double cost = item.getBaseCost();
                double total = item.getTotalCost();

                box($.Heading, () -> {
                    text($.Name, item);
                    text($.TotalCost, total);
                    if (cost != total) {
                        text($.Cost, "(", cost, ")");
                    }
                });

                // Status
                box($.StatusSet, contents(VISIBLE, status -> {
                    double value = descriptor.get(status);

                    if (value != 0) {
                        text($.StatusValue, value, status.getUnit(), " ", status);
                    }
                }));

                box($.DescriptionArea, () -> {
                    box(contents(descriptor.getAbilities(), ability -> {
                        AbilityDescriptor desc = ability.getDescriptor(Version.Latest);

                        box($.AbilityArea, () -> {
                            if (ability.name.startsWith("#")) {
                                text($.AbilityInfo, desc.isUnique() ? "Unique " : "", desc.isActive() ? "Active" : "Passive");
                            } else {
                                text($.AbilityInfo, ability.name);
                            }
                            widget(Widget.of(AbilityDescriptionView.class, ability, null, desc.getDescription()));
                        });
                    }));
                });
            });
        });
    }

    /**
     * @version 2015/08/19 13:16:08
     */
    private static class AbilityDescriptionView extends DescriptionView<Ability> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return calculator == null ? 0 : 1;
        }
    }

    /**
     * @version 2015/10/14 11:02:34
     */
    static class $ extends StyleDescriptor {

        /** The icon color. */
        static final Color IconBorderColor = rgb(100, 100, 100);

        /** The icon size. */
        private static final Numeric IconSize = new Numeric(40, px);

        private static final Numeric gap = new Numeric(0.8, em);

        static ValueStyle<Item> ItemImage = item -> {
            background.image(BackgroundImage.url(item.getIcon()).horizontal(item.getIconPosition()).cover().borderBox().noRepeat());
        };

        static Style Root = () -> {
            display.flex();
            box.maxWidth(600, px);
        };

        static Style IconArea = () -> {
            display.flex().direction.column();
            margin.right(gap);
        };

        static Style Icon = () -> {
            display.block();
            margin.bottom(IconSize.divide(5));
            cursor.pointer();
            box.size(IconSize);
            border.radius(5, px).color(IconBorderColor).width(1, px).solid();
        };

        static Style Materials = () -> {
            display.flex().wrap.enable();
            box.width(IconSize);
        };

        static Style Material = () -> {
            display.block();
            box.size(IconSize.divide(2));
            border.color(IconBorderColor).width(1, px).solid();
        };

        static Style DescriptionArea = () -> {
            box.maxWidth(290, px);
        };

        static Style Heading = () -> {
            display.block();
            font.family(TeemoworkTheme.Main);
        };

        static Style Name = () -> {
            margin.right(0.5, em);
            font.weight.bold();
        };

        static Style TotalCost = () -> {
            margin.right(0.5, em);
        };

        static Style Cost = () -> {
        };

        static Style StatusSet = () -> {
            display.block();
            line.height(1.1);
            margin.top(gap);
        };

        static Style StatusValue = () -> {
            display.block();
            font.size.small().family(TeemoworkTheme.Main);
        };

        static Style AbilityArea = () -> {
            display.block();
            font.size.small();
            margin.top(gap);
        };

        static Style AbilityInfo = () -> {
            font.color(205, 146, 0).weight.bolder();
            padding.right(0.5, em);
        };
    }
}
