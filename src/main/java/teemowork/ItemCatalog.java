/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static teemowork.model.Status.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javafx.beans.property.SetProperty;

import js.dom.User;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.ui.ModelValue;
import jsx.ui.StructureDSL;
import jsx.ui.Widget;
import jsx.ui.piece.UI;
import kiss.Events;
import kiss.I;
import teemowork.ItemCatalog.Styles;
import teemowork.model.Ability;
import teemowork.model.AbilityDescriptor;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;

/**
 * @version 2015/10/12 21:46:39
 */
public class ItemCatalog extends Widget<Styles> {

    private static final Status[] VISIBLE = {Health, BounusHealthRatio, Hreg, HregRatio, Mana, Mreg, MregRatio, AD, ASRatio, ARPen, LS,
            Critical, AP, CDR, SV, MRPen, AR, MR, MSRatio, GoldPer10Sec};

    private final FilterGroup[] groups = {
            new FilterGroup("Defense", type(Status.Health), type(Status.AR), type(Status.MR), type(Status.Hreg, Status.HregRatio), type(Status.Tenacity)),
            new FilterGroup("Attack", type(Status.AD, Status.ADRatio, Status.BaseAD), type(Status.Critical), type(Status.ASRatio), type(Status.LS)),
            new FilterGroup("Magic", type(Status.AP), type(Status.CDR), type(Status.SV), type(Status.Mana), type(Status.Mreg, Status.MregRatio)),
            new FilterGroup("Boots", type(Status.MS)),
            new FilterGroup("Other", type(Status.PhysicalDamage), type(Status.MagicDamage), type(Status.TrueDamage), type(Status.Shield, Status.MagicShield, Status.SpellShield), type(Status.MSSlowRatio))};

    /** The user select item. */
    public final Events<Item> selectItem = when(User.Click).at($.Item, Item.class);

    private final @ModelValue SetProperty<ItemFilter> activeFilters = I.make(SetProperty.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected StructureDSL virtualize() {
        return new StructureDSL() {

            {
                box($.Root, () -> {
                    box($.Groups, contents(groups, group -> {
                        text($.GroupName, group.name);
                        box($.Filters, contents(group.filters, filter -> {
                            widget(UI.checkbox(activeFilters, filter, filter.status.getName()).style($.FilterName));
                        }));
                    }));
                    box($.Items, contents(Item.all(), item -> {
                        if (show(item)) {
                            box($.Item, () -> {
                                widget(Widget.of(ItemView.class, item));
                            });
                        }

                        // box($.Item, If(show(item), $.Selected), () -> {
                        // widget(Widget.of(ItemView.class, item));
                        // });
                    }));
                });
            }
        };
    }

    /**
     * <p>
     * Apply filter.
     * </p>
     * 
     * @param item
     * @return
     */
    private boolean show(Item item) {
        if (activeFilters.isEmpty()) {
            return false;
        }

        for (ItemFilter filter : activeFilters) {
            if (!filter.filter.test(item)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @version 2015/10/12 21:55:48
     */
    static class Styles extends StyleDSL {

        private final Color BorderColor = rgb(220, 220, 220);

        private final Numeric itemGap = new Numeric(5, px);

        private final Numeric ItemAreaWidth = new Numeric(580, px);

        Style Root = () -> {
            display.flex();
            font.size.small();
        };

        Style Groups = () -> {
            display.block();
            margin.right(30, px);
            position.fixed();
        };

        Style GroupName = () -> {
            display.block();
            font.weight.bold();
        };

        Style Filters = () -> {
            display.flex().direction.column();
            display.width(130, px);
            margin.bottom(1, em);
        };

        Style FilterName = () -> {
            display.block();
        };

        Style Items = () -> {
            display.flex().wrap.enable().alignContent.start();
            display.width(ItemAreaWidth);
            margin.left(160, px);
        };

        Style Item = () -> {
            display.flex();
            display.width(ItemAreaWidth.divide(2).subtract(itemGap.multiply(2)));
            border.solid().color(BorderColor).width(1, px);
            margin.right(10, px).bottom(10, px);
            padding.size(itemGap);
            cursor.pointer();
        };
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static ItemFilter type(Status... statuses) {
        return new ItemFilter(statuses[0], item -> {
            Info info = Info.of(item);

            for (Status status : statuses) {
                if (info.types.contains(status)) {
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * @version 2015/10/12 21:48:13
     */
    private static class FilterGroup {

        /** The group name. */
        private String name;

        /** The managed filters. */
        private ItemFilter[] filters;

        /**
         * @param name
         * @param filters
         */
        private FilterGroup(String name, ItemFilter... filters) {
            this.name = name;
            this.filters = filters;
        }
    }

    /**
     * @version 2015/10/12 21:48:33
     */
    private static class ItemFilter {

        /** The filter name. */
        private final Status status;

        /** The actual filter. */
        private final Predicate<Item> filter;

        /**
         * @param status
         * @param filter
         */
        private ItemFilter(Status status, Predicate<Item> filter) {
            this.status = status;
            this.filter = filter;
        }
    }

    /**
     * @version 2015/10/12 21:51:19
     */
    private static class Info {

        /** The cache. */
        private static final Map<Item, Info> infos = new HashMap();

        /** The status index. */
        private final Set<Status> types = new HashSet();

        /** The status index. */
        private final Set<Status> amplifiers = new HashSet();

        /**
         * @param item
         */
        private Info(Item item) {
            ItemDescriptor descriptor = item.getDescriptor(Version.Latest);

            for (Status status : VISIBLE) {
                double value = descriptor.get(status);

                if (value != 0) {
                    types.add(status);
                }
            }

            for (Ability ability : descriptor.getAbilities()) {
                AbilityDescriptor abilityDescriptor = ability.getDescriptor(Version.Latest);
                parse(abilityDescriptor.getPassive());
                parse(abilityDescriptor.getActive());
            }
        }

        /**
         * <p>
         * Helper method to parse status.
         * </p>
         * 
         * @param tokens
         */
        private void parse(List tokens) {
            for (Object token : tokens) {
                if (token instanceof Variable) {
                    Variable variable = (Variable) token;
                    Status status = variable.getStatus();
                    types.add(status);

                    List<Variable> amplifiers = variable.getAmplifiers();

                    for (Variable amplifier : amplifiers) {
                        this.amplifiers.add(amplifier.getStatus());
                    }
                }
            }
        }

        /**
         * <p>
         * Retrieve {@link Info} for the specified champion.
         * </p>
         * 
         * @param item
         * @return
         */
        private static Info of(Item item) {
            return infos.computeIfAbsent(item, Info::new);
        }
    }
}
