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
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.LinearGradient;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2013/03/13 15:05:12
 */
class MasteryBuilderStyle extends StyleRuleDescriptor {

    private static int TreeWidth = 240;

    private static int TreeHeight = 450;

    private static int TreePadding = 10;

    private static int MasterWidth = (TreeWidth - TreePadding * 2) / 4;

    private static int Gap = 5;

    private static int IconSize = MasterWidth - Gap * 2;

    private static int IconBorderSize = 1;

    private static int Corner = 5;

    private static Color AvailableColor = new Color(120, 40, 65);

    private static Color CompleteColor = new Color(50, 40, 65);

    private static Color Blue = new Color(220, 50, 85);

    private static LinearGradient transparent = new LinearGradient()
            .color(new Color(0, 100, 100, 0.6), new Color(0, 100, 100, 0));

    private static String noise = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkAQMAAABKLAcXAAAABlBMVEUAAAAAAAClZ7nPAAAAAnRSTlMAGovxNEIAAAAoSURBVDhPYxBEAgIMSkhAgcEFCTgwdCCBBoZRfaP6RvWN6hvVR5Y+APADQlQnmrINAAAAAElFTkSuQmCC";

    static Style Unavailable = () -> {
    };

    static Style Completed = () -> {
    };

    private static void MasteryBox() {
        display.inlineBlock();
        box.width(TreeWidth, px).height(TreeHeight, px);
        padding.size(TreePadding, px);
        background.image(BackgroundImage.of(transparent), BackgroundImage.url(noise));
    }

    static Style Offense = () -> {
        MasteryBox();
        background.color(Blue.adjustHue(120));
    };

    static Style Defense = () -> {
        MasteryBox();
        background.color(Blue);
    };

    static Style Utility = () -> {
        MasteryBox();
        background.color(Blue.adjustHue(-120));
    };

    static Style RankPane = () -> {
        display.block();
        margin.vertical(Gap * 2.8, px);
        text.unselectable();
    };

    static Style MasteryPane = () -> {
        display.inlineBlock();
        box.size(IconSize, px);
        margin.horizontal(Gap, px);
        position.relative();
        cursor.pointer();

        with(Unavailable, () -> {
            cursor.defaults();
        });
    };

    static Style EmptyPane = () -> {
        visibility.hidden();
    };

    static Style IconImage = () -> {
        box.size(IconSize, px);
        border.color(AvailableColor).width(IconBorderSize, px).solid().radius(Corner, px);

        insideOf(Unavailable, () -> {
            border.color(AvailableColor.grayscale());
        });

        insideOf(Completed, () -> {
            border.color(CompleteColor);
        });
    };

    static Style LevelPane = () -> {
        display.block();
        box.width(IconSize - IconBorderSize * 2, px);
        position.bottom(IconBorderSize, px).left(IconBorderSize, px).absolute();
        padding.right(5, px);
        border.bottom.radius(Corner, px);
        background.color(hsla(0, 0, 0, 0.3));
        font.color(AvailableColor).size(11, px);
        text.outline(AvailableColor, 1).align.right();

        insideOf(Unavailable, () -> {
            display.none();
        });

        insideOf(Completed, () -> {
            font.color(CompleteColor);
        });
    };

    static Style SumPoint = () -> {
        font.color(hsla(0, 0, 100, 0.7)).size(26, px);
        text.unselectable();
        padding.left(7, px);
    };

    static Style LevelValue = () -> {
        text.unselectable();
        cursor.pointer();
    };

    static Style LevelSeparator = () -> {
        margin.horizontal(2, px);
        text.unselectable();
        cursor.pointer();
    };

    static Style PopupPane = () -> {

        int Width = 220;

        int BorderWidth = 2;

        Color borderColor = new Color(0, 98, 97, 0.9);

        Color color = new Color(0, 10, 0, 1);
        display.block();
        position.absolute().bottom(IconSize + 35, px).left(IconSize / 2 - Width / 2, px);
        box.width(Width, px).opacity(0).zIndex(100).shadow(shadow().blurRadius(7, px).color(color));
        background.image(BackgroundImage.of(linear(color.opacify(-0.25), color)));
        border.radius(Corner, px).solid().width(BorderWidth, px).color(borderColor);
        padding.size(10, px);
        visibility.hidden();
        font.color(hsl(0, 99, 97)).size.smaller();
        pointerEvents.none();

        createBottomBubble(6, new Numeric(BorderWidth, px), borderColor, color);

        insideOf(Unavailable, () -> {
            font.color(AvailableColor.grayscale());
        });

        transit().duration(0.15, s).delay(0.2, s).easeInOut().whenSiblingHover(() -> {
            box.opacity(1);
            visibility.visible();
            position.bottom(IconSize + 12, px);
        });
    };

    static Style MasteryName = () -> {
        display.block();
        margin.bottom(0.7, em);
        text.unselectable();
        font.size(16, px).weight.bolder().color(hsl(60, 100, 85)).family(TeemoworkTheme.Title.name);
    };

    static Style Description = () -> {
        text.unselectable();

        inBackOf(Unavailable, () -> {
            font.color(hsl(0, 70, 70));
        });
    };

    static Style Current = () -> {
    };

    static Style ComputedValue = () -> {
    };

    static Style Information = () -> {
        display.block();
        margin.bottom(10, px);
    };

    // static Style ResetButton = () -> {
    // createButton();
    // };

    // private void createButton() {
    // Color front = new Color(0, 0, 33);
    // Color back = new Color(0, 0, 87);
    //
    // display.inlineBlock();
    // margin.size(0, px);
    // padding.vertical(4, px).horizontal(15, px);
    // cursor.pointer();
    // border.solid().width(1, px).color(hsl(0, 0, 73)).radius(3, px);
    // overflow.visible();
    // font.weight.bolder().color(front);
    // text.decoration.none().shadow(0, px, 1, px, Color.White.opacify(-0.1)).unselectable();
    // background.color(back).image(linear(Color.White, Color.White.opacify(-1)));
    // box.shadow(0, px, 1, px, hsla(0, 0, 0, 0.3))
    // .shadow(0, px, 2, px, 2, px, -1, px, hsla(0, 0, 0, 0.5))
    // .shadowInset(0, px, 1, px, 0, px, Color.White.opacify(-0.7));
    //
    // transition.property("background-color").timing.easeOut().duration(0.2, s);
    //
    // hover(() -> {
    // background.color(back.lighten(6));
    // });
    //
    // active(() -> {
    // background.color(back.lighten(4)).imageNone();
    // position.relative().top(1, px);
    // box.shadowInset(0, px, 1, px, 1, px, Color.Black.opacify(-0.7));
    // });
    // }

    static Style Available = () -> {
    };

    private static Numeric BorderWidth = new Numeric(1, Unit.px);

    private static Numeric BorderRadius = new Numeric(4, Unit.px);

    private static Color BorderColor = new Color(0, 0, 80);

    // static Style Input = () -> {
    // display.inlineBlock();
    // box.height(20, px).width(200, px).shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075));
    // padding.vertical(4, px).horizontal(6, px);
    // font.size(14, px).color(85, 85, 85);
    // line.height(20, px);
    // text.verticalAlign.middle();
    //
    // border.width(1, px).solid().color(rgb(204, 204, 204));
    // background.color(White);
    // transition.property.all().duration(0.2, s).timing.linear();
    //
    // focus(() -> {
    // border.color(rgba(82, 168, 236, 0.8));
    // outline.none();
    // box.shadowInset(0, px, 1, px, 1, px, rgba(0, 0, 0, 0.075))
    // .shadow(0, px, 0, px, 8, px, rgba(82, 168, 236, 0.6));
    // });
    // };
}
