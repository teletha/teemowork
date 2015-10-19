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

import static js.lang.Global.*;
import static teemowork.TeemoworkTheme.*;

import java.util.function.Supplier;

import jsx.ui.Application;
import jsx.ui.Route;
import jsx.ui.Widget;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2015/10/15 22:32:04
 */
public class Teemowork extends Application {

    /**
     * 
     */
    private Teemowork() {
        document.documentElement().add(HTML);
        document.getElementById("Content").add(Content);

        Navi navi = Widget.of(Navi.class);
        navi.menu("< ^ v ^ > Teemowork", this::champion);
        navi.menu("Patch");
        navi.menu("Champion", this::champion, sub -> {
            sub.menu("Compare", this::championCompare);
            sub.menu("Item", this::item);
            sub.menu("Mastery", this::mastery);
            sub.menu("Rune");
        });
        navi.menu("Builder");
        navi.menu("About");
        navi.menu("Contact");

        navi.renderIn(document.getElementById("Header"));

        // Header nav = new Header();
        // nav.add("< ^ v ^ > Teemowork", "");
        // nav.add("Patch", "#history");
        //
        // Menu sub = nav.add("champion", "#");
        // sub.add("Compare", "#championCompare");
        // sub.add("Item", "#item");
        // sub.add("Mastery", "#mastery");
        // sub.add("Rune", "#");
        //
        // nav.add("Builder", "#GridTest");
        // nav.add("About", "#item");
        // nav.add("Contact", "#");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Supplier<Widget> defaultWidget() {
        return this::champion;
    }

    @Route
    public Widget champion() {
        return Widget.of(ChampionSelect.class);
    }

    @Route
    public Widget champion(Champion champion) {
        return Widget.of(ChampionDetail.class, new Build(champion));
    }

    @Route
    public Widget championCompare() {
        return Widget.of(ChampionComparing.class);
    }

    @Route
    public Widget item() {
        return Widget.of(ItemCatalog.class);
    }

    @Route
    public Widget mastery() {
        return Widget.of(MasteryBuilder.class);
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        initialize(Teemowork.class);
    }
}
