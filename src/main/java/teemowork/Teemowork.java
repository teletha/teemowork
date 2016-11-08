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

import jsx.Application;
import jsx.ui.Widget;

/**
 * @version 2016/11/07 14:31:33
 */
public class Teemowork extends Application<TeemoworkRouter> {

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
     * {@inheritDoc}
     */
    @Override
    protected Supplier<Widget> defaultWidget() {
        return router::champion;
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {
        initialize(Teemowork.class);
    }
}
