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

import java.util.List;

import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Font;
import jsx.ui.StructureDescriptor.Style;
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
 * @version 2015/08/20 15:57:11
 */
public class ItemView extends Widget1<Item> {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV, MRPen, AR, MR,
            MSRatio, GoldPer10Sec};

    private final Item item = model1;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize2() {
        ItemDescriptor descriptor = item.getDescriptor(Version.Latest);

        box($.Root, () -> {
            box($.IconArea, () -> {
                box($.Icon.of(item));
                box($.Materials, contents(descriptor.getBuildItem(), material -> {
                    // 〡.nbox.〡($.Material.of(material));
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
                box(contents(VISIBLE, status -> {
                    double value = descriptor.get(status);

                    if (value != 0) {
                        text($.StatusValue, value, status.getUnit(), " ", status.name);
                    }
                }));

                box($.DescriptionArea, () -> {
                    box(contents(descriptor.getAbilities(), ability -> {
                        AbilityDescriptor abilityDescriptor = ability.getDescriptor(Version.Latest);

                        box($.AbilityArea, () -> {
                            if (abilityDescriptor.isUnique()) {
                                text($.UniqueAbility, "UNIQUE");
                            }

                            if (abilityDescriptor.isAura()) {
                                text($.UniqueAbility, "AURA");
                            }

                            text($.UniqueAbility, abilityDescriptor.isActive() ? "Active" : "Passive");

                            // if (!ability.name.startsWith("#")) {
                            text($.UniqueAbility, "[", ability.name, "]");
                            // }

                            List token = abilityDescriptor.isActive() ? abilityDescriptor.getActive() : abilityDescriptor.getPassive();
                            widget(Widget.of(AbilityDescriptionView.class, ability, null, token));
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
     * @version 2015/08/20 15:56:55
     */
    private static class $ extends StyleDescriptor {

        private static Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

        /** The skill icon size. */
        private static final int IconSize = 45;

        static Style Root = () -> {
            display.flex();
            margin.bottom(25, px);
            box.maxWidth(600, px);
        };

        static Style IconArea = () -> {
            display.flex().direction.column();
            margin.right(1.2, em);
        };

        static ValueStyle<Item> Icon = item -> {
            display.block();
            margin.bottom(IconSize / 5, px);
            cursor.pointer();
            box.size(44, px);
            border.radius(5, px).color(rgb(50, 50, 50)).width(1, px).solid();
            background.image(BackgroundImage.url(item.getIcon()).horizontal(item.getIconPosition()).cover().borderBox().noRepeat());
        };

        static Style Materials = () -> {
            display.flex().wrap.enable();
            box.width(IconSize, px);
        };

        static ValueStyle<Item> Material = item -> {
            display.block();
            cursor.pointer();
            box.size(22, px).opacity(0.7);
            border.radius(3, px).color(rgb(50, 50, 50)).width(1, px).solid();
            background.image(BackgroundImage.url(item.getIcon()).horizontal(item.getIconPosition()).cover().borderBox().noRepeat());
        };

        static Style DescriptionArea = () -> {
            box.maxWidth(290, px);
        };

        static Style Heading = () -> {
            display.block();
            margin.bottom(0.4, em);
            font.family(Sans.name);
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

        static Style StatusValue = () -> {
            display.block();
            margin.bottom(0.2, em);
            font.size.smaller().family(Sans.name);
        };

        static Style AbilityArea = () -> {
            display.block();
            font.size.smaller();
            margin.top(0.4, em);
        };

        static Style UniqueAbility = () -> {
            font.color(205, 146, 0).weight.bolder();
            padding.right(0.5, em);
        };
    }

}
