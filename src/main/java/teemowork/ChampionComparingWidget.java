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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import js.dom.UIAction;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import teemowork.model.Champion;
import teemowork.model.ChampionStatus;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/03/02 9:57:52
 */
public class ChampionComparingWidget extends Widget {

    private static final Status[] STATUS = {Health, AD};

    /** The sort type. */
    public Property<Status> sortType = new SimpleObjectProperty();

    /** The sort order. */
    private BooleanProperty sortDecending = new SimpleBooleanProperty();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.vbox.〡(Table, () -> {
            〡.nbox.〡(Head, () -> {
                〡.nbox.〡(NoIcon);
                〡.nbox.〡(StatusView, "Name");
                〡.nbox.〡(null, Header.class, STATUS);
            });

            〡.nbox.〡(Body, () -> {
                〡.vbox.〡(null, Champion.sortBy(sortType.getValue(), sortDecending.get()), champion -> {
                    〡.hbox.〡(RowLine, () -> {
                        ChampionStatus championStatus = champion.getStatus(Version.Latest);

                        〡.nbox.〡(Icon.with(() -> {
                            background.horizontal(champion.id / (Champion.size() - 1) * 100, percent);
                        }));
                        〡.nbox.〡(StatusView, champion.name);
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
        private boolean decending = false;

        /**
         * 
         */
        private Header() {
            listen(UIAction.Click).to(v -> {
                sortType.setValue(status);
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
}
