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

import static jsx.style.StyleDescriptor.*;
import static jsx.style.value.Color.*;
import js.dom.UIAction;
import jsx.application.Application;
import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import teemowork.model.Champion;

/**
 * @version 2015/01/30 14:27:54
 */
public class ChampionSelectWidget extends Widget {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.nbox.〡(Class.Root, () -> {
            〡.nbox.〡(Class.ImageSet, Icon.class, Champion.getAll());
        });
    }

    /**
     * @version 2015/02/03 16:12:25
     */
    private class Icon extends Widget1<Champion> {

        /**
         * 
         */
        private Icon() {
            listen(UIAction.Click).to(e -> Application.show(new ChampionDetail2(model1.systemName)));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure 〡) {
            〡.nbox.〡(Class.Container, () -> {
                Style style = () -> {
                    background.position(model1.id / (Champion.size() - 1) * 100, percent, 0, percent);
                };

                〡.nbox.〡(Class.IconImage.with(style));
                〡.nbox.〡(Class.Title, model1.name);
            });
        }
    }

    /**
     * @version 2015/01/30 14:32:48
     */
    private static class Class extends StyleRuleDescriptor {

        private static final Color backColor = new Color(0, 10, 10);

        private static final Numeric ImageSize = new Numeric(70, px);

        private static final Shadow in = shadow().inset()
                .offset(0, 1, px)
                .blurRadius(1, px)
                .color(rgba(0, 0, 0, 0.075));

        private static final Shadow out = shadow().blurRadius(8, px).color(rgba(82, 168, 236, 0.6));

        static Style Root = () -> {
            display.block();
            margin.auto();
            line.height(0);
            box.width(ImageSize.multiply(10).add(2));
        };

        static Style ImageSet = () -> {
            display.inlineFlex().direction.row().wrap.enable();
            border.top.solid().width(2, px).color(backColor);
            border.left.solid().width(2, px).color(backColor);
        };

        static Style Container = () -> {
            position.relative();
            display.block();
        };

        static Style IconImage = () -> {
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

        static Style Title = () -> {
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

        // @Priority(100)
        static Style Unselected = () -> {
            box.opacity(0);
            margin.right(-70, px);
        };

        static Style InputStyle = () -> {
            display.block();
            box.height(20, px).width(200, px).shadow(in);
            padding.vertical(4, px).horizontal(6, px);
            margin.bottom(10, px);
            font.size(14, px).color(85, 85, 85);
            line.height(20, px);
            text.verticalAlign.middle();
            border.radius(4, px).width(1, px).solid().color(rgb(204, 204, 204));
            background.color(White);

            transit().duration(0.2, s).linear().whenFocus(() -> {
                border.color(rgba(82, 168, 236, 0.8));
                outline.none();
                box.shadow(in, out);
            });
        };
    }
}
