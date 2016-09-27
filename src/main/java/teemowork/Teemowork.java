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

import jsx.ui.Application;
import jsx.ui.Route;
import jsx.ui.Widget;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2015/10/27 14:10:47
 */
public class Teemowork extends Application {

    /**
     * 
     */
    private Teemowork() {
        document.documentElement().add(HTML);
        document.contentElement().add(Content);

        Navi navi = new Navi();
        navi.menu("< ^ v ^ > Teemowork", this::champion);
        navi.menu("Patch");
        navi.menu("Champion", this::champion, sub -> {
            sub.menu("Compare", this::championCompare);
            sub.menu("Item", this::item);
            sub.menu("Mastery", this::mastery);
            sub.menu("Rune");
        });
        navi.menu("Record", this::record);
        navi.menu("About");
        navi.menu("Setting", this::setting);

        navi.renderIn(document.headerElement());
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
        return new ChampionSelect(this);
    }

    @Route
    public Widget champion(Champion champion) {
        return new ChampionDetail(new Build(champion));
    }

    @Route
    public Widget championCompare() {
        return new ChampionComparing(this);
    }

    @Route
    public Widget item() {
        return new ItemCatalog();
    }

    @Route
    public Widget mastery() {
        return new MasteryBuilder();
    }

    @Route
    public Widget record() {
        return new Record();
    }

    @Route
    public Widget setting() {
        return new Setting();
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        initialize(Teemowork.class);
    }
}
