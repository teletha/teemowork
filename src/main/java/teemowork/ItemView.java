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

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV, MRPen, AR, MR,
            MSRatio, GoldPer10Sec};

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
                    text($.Name, item.name);
                    text($.TotalCost, total);
                    if (cost != total) {
                        text($.Cost, "(", cost, ")");
                    }
                });

                // Status
                box($.StatusSet, contents(VISIBLE, status -> {
                    double value = descriptor.get(status);

                    if (value != 0) {
                        text($.StatusValue, value, status.getUnit(), " ", status.name);
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
    private static class $ extends StyleDescriptor {

        /** The skill icon size. */
        private static final int IconSize = 45;

        private static final Numeric gap = new Numeric(0.5, em);

        static ValueStyle<Item> ItemImage = item -> {
            background.image(BackgroundImage.url(item.getIcon()).horizontal(item.getIconPosition()).cover().borderBox().noRepeat());
        };

        static Style Root = () -> {
            display.flex();
            box.maxWidth(600, px);
        };

        static Style IconArea = () -> {
            display.flex().direction.column();
            margin.right(1.2, em);
        };

        static Style Icon = () -> {
            display.block();
            margin.bottom(IconSize / 5, px);
            cursor.pointer();
            box.size(44, px);
            border.radius(5, px).color(rgb(50, 50, 50)).width(1, px).solid();
        };

        static Style Materials = () -> {
            display.flex().wrap.enable();
            box.width(IconSize, px);
        };

        static Style Material = () -> {
            display.block();
            box.size(22, px);
            border.color(rgb(50, 50, 50)).width(1, px).solid();
        };

        static Style DescriptionArea = () -> {
            box.maxWidth(290, px);
        };

        static Style Heading = () -> {
            display.block();
            margin.bottom(gap);
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
            line.height(1.1);
            margin.bottom(gap);
        };

        static Style StatusValue = () -> {
            display.block();
            font.size.small().family(TeemoworkTheme.Main);
        };

        static Style AbilityArea = () -> {
            display.block();
            font.size.small();
            margin.top(0.4, em);
        };

        static Style AbilityInfo = () -> {
            font.color(205, 146, 0).weight.bolder();
            padding.right(0.5, em);
        };
    }
}
