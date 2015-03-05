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

import static jsx.style.StyleDescriptor.*;
import static teemowork.ChampionComparingStyle.*;
import static teemowork.model.Status.*;

import java.util.Comparator;
import java.util.function.Predicate;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.transformation.SortedList;

import js.dom.UIAction;
import jsx.style.Style;
import jsx.ui.Notifiable;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import kiss.I;
import teemowork.model.Champion;
import teemowork.model.ChampionGroup;
import teemowork.model.ChampionStatus;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/03/02 9:57:52
 */
public class ChampionComparingWidget2 extends Widget {

    private static final Status[] STATUS = {Health, Hreg, HregPerLv, Mana, AD, ADPerLv, AS, AR, MR, MS, Range};

    /** The sort type. */
    @Notifiable
    private Header header;

    /** The filter. */
    private ChampionGroup group = ChampionGroup.RANGED;

    private Property<Predicate<Champion>> filter = new SimpleObjectProperty();

    private Property<Comparator<Champion>> sorter = new SimpleObjectProperty();

    private SortedList<Champion> gg = I.make(ListProperty.class).filtered(filter.getValue()).sorted(sorter.getValue());

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.vbox.〡(Table, () -> {
            〡.nbox.〡(Head, () -> {
                〡.nbox.〡(NoIcon);
                〡.nbox.〡(null, Header.class, STATUS);
            });

            〡.nbox.〡(Body, () -> {
                〡.vbox.〡(null, group.sortBy(header.status, header.decending), champion -> {
                    〡.hbox.〡(RowLine, () -> {
                        ChampionStatus championStatus = champion.getStatus(Version.Latest);

                        〡.nbox.〡(Icon.with(() -> {
                            background.horizontal(champion.id / (Champion.size() - 1) * 100, percent);
                        }));
                        〡.nbox.〡(null, STATUS, status -> {
                            〡.nbox.〡(StatusView, championStatus.get(status));
                        });
                    });
                });
            });
        });
    }

    /**
     * @version 2015/03/02 10:58:34
     */
    private class Header extends Widget1<Status> {

        /** The champion status. */
        private final Status status = model1;

        /** The sort order of this header. */
        @Notifiable
        private boolean decending = true;

        /**
         * 
         */
        private Header() {
            listen(UIAction.Click).to(v -> {
                if (header == this) {
                    decending = !decending;
                } else {
                    header = this;
                    decending = true;
                }
            });
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure 〡) {
            〡.nbox.〡(StatusView, status.name);
        }
    }

    private static enum CSS implements Style {
        AAA {

            {
            }
        };

        /**
         * {@inheritDoc}
         */
        @Override
        public void declare() {
        }
    }
}
