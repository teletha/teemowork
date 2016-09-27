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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import js.dom.User;
import jsx.style.BinaryStyle;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.ui.StructureDSL;
import jsx.ui.Widget;
import kiss.Events;
import teemowork.Navi.Styles;

/**
 * @version 2015/10/19 2:56:06
 */
public class Navi extends Widget<Styles> {

    /** The top-level menus. */
    private Menu menus = new Menu("", null);

    /** The menu selection. */
    private final Events<Menu> selectMenu = when(User.Click).at($.MenuLink, Menu.class);

    /**
     * 
     */
    Navi() {
        selectMenu.to(menu -> {
            if (menu.action != null) {
                menu.action.run();
            }
        });
    }

    /**
     * @param id
     */
    private Navi(int id) {
        super(id);
    }

    /**
     * <p>
     * Define menu without link.
     * </p>
     * 
     * @param label
     */
    public void menu(String label) {
        menus.add(new Menu(label, null));
    }

    /**
     * <p>
     * Define menu with sub menu.
     * </p>
     * 
     * @param label
     * @param sub
     */
    public void menu(String label, Runnable action) {
        menus.add(new Menu(label, action));
    }

    /**
     * <p>
     * Define menu with sub menu.
     * </p>
     * 
     * @param label
     * @param sub
     */
    public void menu(String label, Runnable action, Consumer<Navi> sub) {
        Menu parent = menus;
        Menu menu = new Menu(label, action);
        menus.add(menu);
        menus = menu;
        sub.accept(this);
        menus = parent;
    }

    /**
     * @version 2016/09/25 13:58:55
     */
    private class View extends StructureDSL {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            box($.TopMenuGroup, contents(menus.items, item -> {
                html("li", $.TopMenu, () -> {
                    text($.MenuLink.of(item.action != null), item.label);

                    box($.SubMenuGroup, contents(item.items, sub -> {
                        html("li", $.SubMenu, () -> {
                            text($.MenuLink.of(item.action != null), sub.label);
                        });
                    }));
                });
            }));
        }
    }

    /**
     * @version 2015/10/19 11:30:23
     */
    private static class Menu {

        /** The menu label. */
        private final String label;

        /** The menu action. */
        private final Runnable action;

        /** The menu list. */
        private final List<Menu> items = new ArrayList();

        /**
         * @param label
         * @param action
         */
        private Menu(String label, Runnable action) {
            this.label = label;
            this.action = action;
        }

        /**
         * <p>
         * Append menu item.
         * </p>
         * 
         * @param item
         */
        private void add(Menu item) {
            items.add(item);
        }
    }

    /**
     * @version 2015/10/19 11:36:50
     */
    static class Styles extends StyleDSL {

        /** The background color. */
        private static final Color LightBack = new Color(0, 0, 27);

        /** The background color. */
        private static final Color DarkBack = LightBack.lighten(-20);

        /** The minimum menu width. */
        private static final int MenuWidth = 120;

        /** The menu radius. */
        private static final int Radius = 3;

        Style TopMenuGroup = () -> {
            display.block().shadow(shadow().offset(0, 1, px).blurRadius(1, px).color(hsla(0, 0, 0, 0.15)));
            margin.vertical(30, px);
            border.width(1, px).solid().color(DarkBack).radius(6, px);
            background.image(BackgroundImage.of(linear(LightBack, DarkBack)));
        };

        Style TopMenu = () -> {
            position.relative();
            display.inlineBlock().minWidth(MenuWidth, px).zIndex(1);
            border.right.width(1, px).solid().color(DarkBack);
            text.align.center();
        };

        BinaryStyle MenuLink = action -> {
            display.block();
            padding.vertical(12, px).horizontal(20, px);
            font.color(153, 153, 153).weight.bold().size(14, px);
            text.decoration.none().shadow();

            if (action) {
                cursor.pointer();

                hover(() -> {
                    font.color(Color.Whity);
                });
            }
        };

        Style SubMenuGroup = () -> {
            listStyle.none();
            margin.top(20, px);
            padding.size(0, px);
            visibility.hidden();
            position.absolute().top(42, px).left(0, px);
            background.color(rgb(68, 68, 68)).image(BackgroundImage.of(linear(LightBack, DarkBack)));
            display.width(MenuWidth, px).shadow(shadow().offset(0, -1, px).color(rgba(255, 255, 255, 0.3))).opacity(0);
            border.radius(Radius, px);

            transit().duration(0.2, s).delay(80, ms).easeInOut().when().parent().hover(() -> {
                display.opacity(1);
                visibility.visible();
                margin.size(0, px);
            });
        };

        Style SubMenu = () -> {
            display.block();
            border.bottom.width(1, px).solid().color(rgb(81, 81, 81));

            hover(() -> {
                background.color(rgb(1, 134, 186)).image(BackgroundImage.of(linear(rgba(4, 172, 236, 1), rgba(1, 134, 186, 1))));

                firstChild(() -> {
                    border.top.radius(Radius, px);
                });

                lastChild(() -> {
                    border.bottom.radius(Radius, px);
                });
            });
        };
    }
}
