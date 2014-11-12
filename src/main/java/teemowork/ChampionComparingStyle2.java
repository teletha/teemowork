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

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2013/03/23 14:49:35
 */
class ChampionComparingStyle2 extends StyleRuleDescriptor {

    /**
     * @version 2013/02/16 9:52:23
     */
    static Style Table = () -> {
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Head = () -> {
    };

    /**
     * @version 2013/02/16 9:52:23
     */
    static Style Body = () -> {
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style RowLine = () -> {
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Name = () -> {
        display.inlineBlock();
        box.width(7, em);
        text.verticalAlign.middle();
        padding.left(20, px);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Icon = () -> {

        int size = 44;
        display.inlineBlock();
        box.size(size, px);
        border.radius(5, px).color(rgb(50, 50, 50)).width(1, px).solid();
        text.verticalAlign.middle();
        cursor.pointer();
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style NoIcon = () -> {
        display.inlineBlock();
        box.size(40, px);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style StatusView = () -> {
        display.inlineBlock();
        box.width(4, em);
        text.verticalAlign.middle();
    };
}