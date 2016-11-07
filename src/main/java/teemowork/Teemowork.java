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

import static js.lang.Global.*;
import static teemowork.TeemoworkTheme.*;

import java.util.function.Supplier;

import jsx.application.Application;
import jsx.application.ApplicationRouter;
import jsx.application.Route;
import jsx.ui.Widget;
import kiss.I;
import teemowork.Teemowork.Router;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2015/10/27 14:10:47
 */
public class Teemowork extends Application<Router> {

    /**
     * 
     */
    private Teemowork() {
        document.documentElement().add(HTML);
        document.contentElement().add(Content);

        Navi navi = new Navi();
        navi.menu("< ^ v ^ > Teemowork", router::champion);
        navi.menu("Patch");
        navi.menu("Champion", router::champion, sub -> {
            sub.menu("Compare", router::championCompare);
            sub.menu("Item", router::item);
            sub.menu("Mastery", router::mastery);
            sub.menu("Rune");
        });
        navi.menu("Record", router::record);
        navi.menu("About");
        navi.menu("Setting", router::setting);

        navi.renderIn(document.headerElement());
    }

    /**
     * @version 2016/11/06 11:18:15
     */
    public interface Router extends ApplicationRouter {

        /**
         * {@inheritDoc}
         */
        @Override
        default Supplier<Widget> defaultWidget() {
            return this::champion;
        }

        @Route
        default Widget champion() {
            return I.make(ChampionSelect.class);
        }

        @Route
        default Widget champion(Champion champion) {
            return new ChampionDetail(new Build(champion));
        }

        @Route
        default Widget championCompare() {
            return I.make(ChampionComparing.class);
        }

        @Route
        default Widget item() {
            return new ItemCatalog();
        }

        @Route
        default Widget mastery() {
            return new MasteryBuilder();
        }

        @Route
        default Widget record() {
            return new Record();
        }

        @Route
        default Widget setting() {
            return new Setting();
        }

    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        initialize(Teemowork.class);
    }
}
