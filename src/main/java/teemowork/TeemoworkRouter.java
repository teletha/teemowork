/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.util.function.Supplier;

import jsx.application.Route;
import jsx.application.Router;
import jsx.ui.Widget;
import kiss.I;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2016/11/06 11:18:15
 */
public interface TeemoworkRouter extends Router {

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