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

import jsx.application.NewApplication;
import jsx.application.Route;
import jsx.ui.Widget;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2015/08/18 10:28:01
 */
public class NewTeemowork extends NewApplication {

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        initialize(NewTeemowork.class, (config, application) -> {
            config.defaultPage(application::champion);
        });
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
}
