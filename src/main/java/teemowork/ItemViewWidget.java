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

import static teemowork.model.Status.*;

import java.util.List;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Font;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import teemowork.model.Ability;
import teemowork.model.AbilityDescriptor;
import teemowork.model.DescriptionViewWidget;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/08/20 15:57:11
 */
public class ItemViewWidget extends Widget1<Item> {

    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ASRatio, ARPen, LS, Critical, AP, CDR, SV, MRPen, AR, MR,
            MSRatio, GoldPer10Sec};

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure ⅼ) {
        ItemDescriptor descriptor = model1.getDescriptor(Version.Latest);

        ⅼ.nbox.ⅼ($.Root, () -> {
            ⅼ.nbox.ⅼ($.IconArea, () -> {
                ⅼ.nbox.ⅼ($.Icon.of(model1));
                ⅼ.nbox.ⅼ($.Materials, descriptor.getBuildItem(), material -> {
                    ⅼ.nbox.ⅼ($.Material.of(material));
                });
            });
            ⅼ.nbox.ⅼ($.DescriptionArea, () -> {
                // Name and Cost
                double cost = model1.getBaseCost();
                double total = model1.getTotalCost();

                ⅼ.nbox.ⅼ($.Heading, () -> {
                    ⅼ.nbox.ⅼ($.Name, model1.name);
                    ⅼ.nbox.ⅼ($.TotalCost, total);
                    if (cost != total) {
                        ⅼ.nbox.ⅼ($.Cost, "(", cost, ")");
                    }
                });

                // Status
                ⅼ.nbox.ⅼ(null, VISIBLE, status -> {
                    double value = descriptor.get(status);

                    if (value != 0) {
                        ⅼ.nbox.ⅼ($.StatusValue, value, status.getUnit(), " ", status.name);
                    }
                });

                ⅼ.nbox.ⅼ($.DescriptionArea, () -> {
                    ⅼ.nbox.ⅼ(null, descriptor.getAbilities(), ability -> {
                        AbilityDescriptor abilityDescriptor = ability.getDescriptor(Version.Latest);

                        ⅼ.nbox.ⅼ($.AbilityArea, () -> {
                            if (abilityDescriptor.isUnique()) {
                                ⅼ.nbox.ⅼ($.UniqueAbility, "UNIQUE");
                            }

                            if (abilityDescriptor.isAura()) {
                                ⅼ.nbox.ⅼ($.UniqueAbility, "AURA");
                            }

                            ⅼ.nbox.ⅼ($.UniqueAbility, abilityDescriptor.isActive() ? "Active" : "Passive");

                            if (!ability.name.startsWith("#")) {
                                ⅼ.nbox.ⅼ($.UniqueAbility, "[", ability.name, "]");
                            }

                            List token = abilityDescriptor.isActive() ? abilityDescriptor.getActive() : abilityDescriptor.getPassive();
                            ⅼ.nbox.ⅼ(null, Widget.of(AbilityDescriptionView.class, ability, null, token));
                        });
                    });
                });
            });
        });
    }

    /**
     * @version 2015/08/19 13:16:08
     */
    private static class AbilityDescriptionView extends DescriptionViewWidget<Ability> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return calculator == null ? 0 : 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Version getVersion() {
            return Version.Latest;
        }
    }

    /**
     * @version 2015/08/20 15:56:55
     */
    private static class $ extends StyleRuleDescriptor {

        private static Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

        /** The skill icon size. */
        private static final int IconSize = 45;

        /**
         * @version 2013/02/16 9:52:23
         */
        static Style Root = () ->

        {
            display.flex();
            margin.bottom(25, px);
            box.maxWidth(600, px);
        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static Style IconArea = () -> {
            display.flex().direction.column();
            margin.right(1.2, em);
        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static ValueStyle<Item> Icon = item -> {
            display.block();
            margin.bottom(IconSize / 5, px);
            cursor.pointer();
            box.size(44, px);
            border.radius(5, px).color(rgb(50, 50, 50)).width(1, px).solid();
            background.image(BackgroundImage.url(item.getIcon()).horizontal(item.getIconPosition()).cover().borderBox().noRepeat());
        };

        /**
         * @version 2013/06/13 13:57:38
         */
        static Style Materials = () ->

        {
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

        /**
         * @version 2013/02/16 9:52:23
         */
        static Style DescriptionArea = () ->

        {
            box.maxWidth(290, px);
        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static Style Heading = () ->

        {
            display.block();
            margin.bottom(0.4, em);
            font.family(Sans.name);
        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static Style Name = () ->

        {
            margin.right(0.5, em);
            font.weight.bold();
        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static Style TotalCost = () ->

        {
            margin.right(0.5, em);
        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static Style Cost = () ->

        {

        };

        /**
         * @version 2013/02/16 10:00:01
         */
        static Style StatusValue = () ->

        {
            display.block();
            margin.bottom(0.2, em);
            font.size.smaller().family(Sans.name);
        };

        /**
         * @version 2013/06/04 23:24:52
         */
        static Style AbilityArea = () ->

        {
            display.block();
            font.size.smaller();
            margin.top(0.4, em);
        };

        /**
         * @version 2013/06/04 23:24:52
         */
        static Style UniqueAbility = () ->

        {
            font.color(205, 146, 0).weight.bolder();
            padding.right(0.5, em);
        };
    }

}
