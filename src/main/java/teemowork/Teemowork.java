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

import jsx.application.Header;
import jsx.application.Header.Menu;
import jsx.application.NewApplication;
import jsx.application.Route;
import jsx.ui.Widget;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2015/08/18 10:28:01
 */
public class Teemowork extends NewApplication {

    /**
     * 
     */
    private Teemowork() {
        document.documentElement().add(HTML);
        document.getElementById("Content").add(Content);

        Header nav = new Header();
        nav.add("< ^ v ^ > Teemowork", "");
        nav.add("Patch", "#history");

        Menu sub = nav.add("champion", "#");
        sub.add("Compare", "#championCompare");
        sub.add("Item", "#item");
        sub.add("Mastery", "#mastery");
        sub.add("Rune", "#");

        nav.add("Builder", "#GridTest");
        nav.add("About", "#item");
        nav.add("Contact", "#");
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
        return Widget.of(ChampionSelectWidget.class);
    }

    @Route
    public Widget champion(Champion champion) {
        return Widget.of(ChampionDetailWidget.class, new Build(champion));
    }

    @Route
    public Widget championCompare() {
        return Widget.of(ChampionComparingWidget.class);
    }

    @Route
    public Widget item() {
        return Widget.of(ItemCatalogWidget.class);
    }

    @Route
    public Widget mastery() {
        return Widget.of(MasteryBuilderWidget.class);
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        initialize(Teemowork.class);
    }
}
