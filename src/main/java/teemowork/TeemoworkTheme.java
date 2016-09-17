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

import jsx.style.StyleDescriptor;
import jsx.style.value.Font;
import jsx.ui.Style;

/**
 * @version 2015/09/28 21:54:41
 */
public class TeemoworkTheme extends StyleDescriptor {

    /** The main font. */
    public static final Font Main = Font.fromGoogle("Source Sans Pro", "400", "600");

    /** The header font. */
    public static final Font Header = Main;

    /** The title/heading font. */
    public static final Font Title = Font.fromGoogle("Yanone Kaffeesatz");

    static Style HTML = () -> {
        font.family(Main, Font.SansSerif);
        padding.horizontal(10, percent).top(10, px);
    };

    static Style Content = () -> {
        padding.top(20, px);
    };
}
