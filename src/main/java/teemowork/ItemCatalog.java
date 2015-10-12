/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static jsx.ui.StructureDescriptor.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javafx.beans.property.SetProperty;

import jsx.style.StyleDescriptor;
import jsx.ui.Model;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.piece.UI;
import kiss.I;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;

/**
 * @version 2015/10/12 21:46:39
 */
public class ItemCatalog extends Widget {

    private final FilterGroup[] groups = {
            new FilterGroup("Defense", type(Status.Health), type(Status.AR), type(Status.MR), type(Status.Hreg), type(Status.Tenacity)),
            new FilterGroup("Attack", type(Status.AD), type(Status.Critical), type(Status.AS), type(Status.LS)),
            new FilterGroup("Magic", type(Status.AP), type(Status.CDR), type(Status.SV), type(Status.Mana), type(Status.Mreg)),
            new FilterGroup("Boots", type(Status.MS))};

    private final @Model SetProperty<ItemFilter> activeFilters = I.make(SetProperty.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        box($.Groups, contents(groups, group -> {
            text($.GroupName, group.name);
            box($.Filters, contents(group.filters, filter -> {
                widget(UI.checkbox(activeFilters, filter, filter.name).style($.FilterName));
            }));
        }));
    }

    /**
     * @version 2015/10/12 21:55:48
     */
    static class $ extends StyleDescriptor {

        static Style Groups = () -> {
            display.block();
        };

        static Style GroupName = () -> {
            display.block();
            font.weight.bold();
        };

        static Style Filters = () -> {
            display.block();
        };

        static Style FilterName = () -> {
            margin.left(1, em);
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
        return type(statuses[0].name, statuses);
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static ItemFilter type(String name, Status... statuses) {
        return new ItemFilter(name, champion -> {
            Info info = Info.of(champion);

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
        private final String name;

        /** The actual filter. */
        private final Predicate<Item> filter;

        /**
         * @param name
         * @param filter
         */
        private ItemFilter(String name, Predicate<Item> filter) {
            this.name = name;
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

            parse(descriptor.getPassive());
            parse(descriptor.getActive());
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
