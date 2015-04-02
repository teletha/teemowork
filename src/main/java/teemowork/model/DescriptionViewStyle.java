/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2013/03/17 0:05:57
 */
class DescriptionViewStyle extends StyleRuleDescriptor {

    /** The skill icon size. */
    private static int SkillIconSize = 45;

    /** The level box height. */
    private static int LevelBoxHeight = 5;

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style ComputedValue = () ->

    {
        font.weight.bolder();
    };

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style Value = () ->

    {
        text.align.center();
    };

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style Separator = () ->

    {
        box.opacity(0.4);
        margin.horizontal(1, px);
    };

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style Current = () ->

    {
        font.color(rgba(160, 123, 1, 1));
    };

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style Passive = () ->

    {
        margin.right(1, em);
    };

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style Amplifier = () ->

    {
        font.color(25, 111, 136);

        inBackOf(Value, () -> {
            margin.left(0.4, em);
        });

        // inBackOf(Amplifier, () -> {
        // margin.left(0.4, em);
        // });
    };
}
