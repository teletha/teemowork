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

import static jsx.ui.Declarables.*;

import js.dom.UIAction;
import jsx.style.Style;
import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.ui.Widget;
import jsx.ui.piece.Input;
import jsx.ui.piece.UI;
import kiss.Events;
import kiss.I;
import teemowork.model.Champion;

/**
 * @version 2015/09/18 14:05:30
 */
public class ChampionSelect extends Widget {

    private final Teemowork application = I.make(Teemowork.class);

    private Input input = UI.input().placeholder("Champion Name").style($.SearchByName);

    public Events<Champion> select = when(UIAction.Click, $.Container, Champion.class);

    /**
     * 
     */
    public ChampionSelect() {
        select.to(champion -> application.champion(champion));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize2() {
        box($.Root, () -> {
            widget(input);
            box($.ImageSet, contents(Champion.getAll(), champion -> {
                box($.Container, If(!champion.match(input.value.get()), $.Unselected), () -> {
                    box($.IconImage, $.IconPosition.of(champion));
                    text($.Title, champion.name);
                });
            }));
        });
    }

    /**
     * @version 2015/01/30 14:32:48
     */
    private static class $ extends StyleDescriptor {

        private static final Color backColor = new Color(0, 10, 10);

        private static final Numeric ImageSize = new Numeric(70, px);

        private static Style Root = () -> {
            display.block();
            margin.auto();
            line.height(0);
            box.width(ImageSize.multiply(10).add(2));
        };

        private static Style ImageSet = () -> {
            display.inlineFlex().direction.row().wrap.enable();
            border.top.solid().width(2, px).color(backColor);
            border.left.solid().width(2, px).color(backColor);
        };

        private static Style Container = () -> {
            position.relative();
            display.block();
        };

        private static Style Unselected = () -> {
            box.opacity(0);
            margin.right(-70, px);
        };

        private static Style IconImage = () -> {
            display.block();
            box.size(ImageSize);
            border.bottom.solid().width(2, px).color(backColor);
            border.right.solid().width(2, px).color(backColor);
            cursor.pointer();
            background.image("src/main/resources/teemowork/champions.jpg").cover().borderBox();

            after(() -> {
                content.text("");
                display.block();
                position.absolute();
                box.width(100, percent).height(100, percent).opacity(1);
                background.color(hsla(0, 100, 100, 0.2));

                transit().duration(0.2, s).easeInOut().whenHover(() -> {
                    box.opacity(0);
                });
            });
        };

        private static ValueStyle<Champion> IconPosition = chmapion -> {
            background.horizontal(chmapion.getIconPosition());
        };

        private static Style Title = () -> {
            Numeric boxWidth = ImageSize.add(40);
            Color color = new Color(0, 98, 97, 1);

            font.weight.bold().size(18, px);
            text.align.center();
            line.height(20, px);
            padding.size(5, px);
            background.image(BackgroundImage.of(linear(color.opacify(-0.4), color)));
            position.absolute().left(50, percent).bottom(ImageSize.add(20));
            margin.left(boxWidth.divide(-2));
            box.minWidth(boxWidth).zIndex(1).opacity(0);
            border.width(4, px).solid().color(color.lighten(-100)).radius(5, px);
            pointerEvents.none();

            // createBottomBubble(7);
            createBottomBubble(7, new Numeric(4, px), color.lighten(-100), color);

            transit().duration(0.2, s).delay(100, ms).easeInOut().whenSiblingHover(() -> {
                box.opacity(1);
                position.bottom(ImageSize);
            });
        };

        private static Style SearchByName = () -> {
            display.block();
            margin.bottom(10, px);
        };
    }
}
