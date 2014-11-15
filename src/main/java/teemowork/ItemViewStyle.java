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
import jsx.style.value.Font;

/**
 * @version 2013/06/09 19:05:20
 */
public class ItemViewStyle extends StyleRuleDescriptor {

    private static Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

    /** The skill icon size. */
    private static final int IconSize = 45;

    /**
     * @version 2013/02/16 9:52:23
     */
    static Style Root = () ->

    {
        display.flex();
        margin.bottom(25, px);
        box.maxWidth(600, px);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style IconArea = () -> {
        display.flex().direction.column();
        margin.right(1.2, em);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Icon = () -> {
        display.block();
        margin.bottom(IconSize / 5, px);
        cursor.pointer();
        box.size(44, px);
        border.radius(5, px).color(rgb(50, 50, 50)).width(1, px).solid();
    };

    /**
     * @version 2013/06/13 13:57:38
     */
    static Style Materials = () ->

    {
        display.flex().wrap.enable();
        box.width(IconSize, px);
    };

    /**
     * @version 2013/06/13 13:57:38
     */
    static Style Material = () ->

    {
        display.block();
        cursor.pointer();
        box.size(22, px).opacity(0.7);
        border.radius(3, px).color(rgb(50, 50, 50)).width(1, px).solid();

        transit().duration(0.3, s).easeInOut().whenHover(() -> {
            box.opacity(1);
        });
    };

    /**
     * @version 2013/02/16 9:52:23
     */
    static Style DescriptionArea = () ->

    {
        box.maxWidth(290, px);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Heading = () ->

    {
        display.block();
        margin.bottom(0.4, em);
        font.family(Sans.name);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Name = () ->

    {
        margin.right(0.5, em);
        font.weight.bold();
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style TotalCost = () ->

    {
        margin.right(0.5, em);
    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style Cost = () ->

    {

    };

    /**
     * @version 2013/02/16 10:00:01
     */
    static Style StatusValue = () ->

    {
        display.block();
        margin.bottom(0.2, em);
        font.size.smaller().family(Sans.name);
    };

    /**
     * @version 2013/06/04 23:24:52
     */
    static Style AbilityArea = () ->

    {
        display.block();
        font.size.smaller();
        margin.top(0.4, em);
    };

    /**
     * @version 2013/06/04 23:24:52
     */
    static Style UniqueAbility = () ->

    {
        font.color(205, 146, 0).weight.bolder();
        padding.right(0.5, em);
    };
}
