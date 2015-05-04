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

import static jsx.style.value.Color.*;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import teemowork.model.Champion;
import teemowork.model.Item;

/**
 * @version 2013/02/26 23:49:51
 */
class ChampionDetailStyle extends StyleRuleDescriptor {

    /** The skill icon size. */
    private static int SkillIconSize = 45;

    /** The level box height. */
    private static int LevelBoxHeight = 5;

    static Style UpperInfo = () -> {
        display.flex().alignItems.end();
        margin.bottom(1, em);
    };

    static Style StatusLabel = () -> {
        font.size.smaller();
    };

    static Style StatusBlock = () -> {
        display.inlineBlock();
        margin.right(0.8, em);
    };

    static Style SkillStatusValues = () -> {
        display.inlineBlock();
        margin.left(0.7, em);
    };

    static Style SkillStatusValue = () -> {
        text.align.center();
        box.opacity(0.7);
        margin.horizontal(3, px);
    };

    static Style SkillTable = () -> {
        display.block();
        flexItem.basis(100, percent);
    };

    static Style Container = () -> {
        display.flex();
    };

    static Style SkillRow = () -> {
        display.flex();
        margin.bottom(1, em);
    };

    static Style SkillIcon = () -> {
        display.block();
        box.size(SkillIconSize, px);
        background.image(BackgroundImage.none().contain().size(SkillIconSize, px)).borderBox();
        border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
    };

    static Style LevelBox = () -> {
        display.flex();
        box.width(SkillIconSize, px).height(LevelBoxHeight + 2, px);
        border.width(1, px).solid().color(Black);
        margin.top(2, px).bottom(5, px);
    };

    static Style LevelMark = () -> {
        display.block();
        flexItem.grow(1);
        box.height(LevelBoxHeight, px);
        border.left.solid().color(Black).width(1, px);
        background.image(BackgroundImage.of(linear(rgba(240, 192, 28, 0.5), rgba(160, 123, 1, 0.5))));

        firstChild(() -> {
            border.none();
        });
    };

    static Style Assigned = () -> {
        background.image(BackgroundImage.of(linear(rgba(240, 192, 28, 1), rgba(160, 123, 1, 1))));
    };

    /**
     * @version 2013/02/02 11:27:13
     */
    static Style IconBox = () -> {
        margin.right(SkillIconSize / 5, px);
        cursor.pointer();
        flexItem.shrink(0);
    };

    static Style Name = () -> {
        margin.right(0.5, em);
        font.weight.bold();
    };

    static Style Info = () -> {
    };

    static Style Text = () -> {
        display.block();
        margin.top(0.4, em);
        line.height(140, percent);
        font.size.smaller();
    };

    /**
     * @version 2013/02/06 20:03:25
     */
    static Style ComputedValue = () -> {
        font.weight.bolder();
    };

    static Style NormalValue = () -> {
        text.align.center();
    };

    static Style ChampionLevelIndicator = () -> {
        cursor.help();
    };

    static Style Separator = () -> {
        box.opacity(0.4);
        margin.horizontal(1, px);
    };

    static Style Current = () -> {
        font.color(rgba(160, 123, 1, 1));
    };

    static Style SkillTypeInfo = () -> {
        margin.right(1, em);
    };

    static Style Amplifier = () -> {
        font.color(25, 111, 136);

        inBackOf(NormalValue, () -> {
            margin.left(0.4, em);
        });

        // inBackOf(Amplifier, () -> {
        // margin.left(0.4, em);
        // });
    };

    static Style Active = () -> {
        box.opacity(0.5);
    };

    private static Numeric ChampionIconSize = new Numeric(70, Unit.px);

    static Style ChampionIcon = () -> {
        display.block();
        background.image(BackgroundImage.url("src/main/resources/teemowork/champions.jpg").cover().borderBox());
        box.size(ChampionIconSize);
        border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
        position.relative();
        cursor.pointer();
    };

    static ValueStyle<Integer> ChampionIconBox = value -> {
        box.size(ChampionIconSize);
        border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
        cursor.pointer();
        position.relative();
        background.image("src/main/resources/teemowork/champions.jpg")
                .horizontal(value / (Champion.size() - 1) * 100, percent);

    };

    static Style Level = () -> {
        display.block();
        box.size(22, px);
        font.size(20, px).color(240, 240, 240).weight.bold().family("Arial");
        text.align.center().shadow(shadow().blurRadius(1, px).color(rgba(0, 0, 0, 1))).unselectable();
        position.absolute().bottom(4, px).right(4, px);
        cursor.pointer();
    };

    static Style StatusViewBox = () -> {
        display.block();
        box.width(13, em);
        flexItem.shrink(0);
    };

    static Style StatusBox = () -> {
        display.flex();
        margin.bottom(4, px);
    };

    static Style StatusName = () -> {
        box.width(5, em);
    };

    static Style StatusValue = () -> {
        box.width(50, px);
    };

    private static Numeric ItemIconSize = ChampionIconSize.divide(5).multiply(3);

    static Style ItemViewBox = () -> {
        display.flex();
        box.width(ItemIconSize.multiply(6));
        margin.left(137, px);
    };

    static Style ItemIconBase = () -> {
        display.block();
        box.size(ItemIconSize);
        background.image(BackgroundImage.url("src/main/resources/teemowork/item/empty.png").contain().noRepeat());
        padding.size(3, px);
    };

    static ValueStyle<Integer> ItemIcon = id -> {
        display.block();
        box.size(100, percent);
        background.horizontal(id / (Item.size() - 1) * 100, percent)
                .image(BackgroundImage.url("src/main/resources/teemowork/items.jpg").cover().borderBox().noRepeat());
    };

    static Style ItemIconBox = () -> {
        box.size(ItemIconSize);
        padding.size(3, px);
    };

}