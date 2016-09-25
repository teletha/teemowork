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

import js.dom.User;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.LinearGradient;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.ViewDSL;
import jsx.ui.Widget;
import kiss.Events;
import teemowork.MasteryBuilder.Styles;
import teemowork.model.DescriptionView;
import teemowork.model.Mastery;
import teemowork.model.MasterySet;
import teemowork.model.MasteryType;
import teemowork.model.Version;

/**
 * @version 2015/08/19 13:41:08
 */
public class MasteryBuilder extends Widget<Styles> {

    private MasteryManager masteryManager;

    private final MasterySet masterySet = new MasterySet("");

    private final Events<Mastery> up = when(User.Click).at($.MasteryPane, Mastery.class);

    private final Events<Mastery> down = when(User.ClickRight).at($.MasteryPane, Mastery.class);

    /**
     * 
     */
    public MasteryBuilder() {
        // masteryManager = Global.localStorage.get(MasteryManager.class);

        if (masteryManager == null) {
            masteryManager = new MasteryManager();
        }

        up.to(mastery -> {
            masterySet.up(mastery);
            update();
        });
        down.to(mastery -> {
            masterySet.down(mastery);
            update();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final ViewDSL virtualize() {
        return new View();
    }

    /**
     * @version 2016/09/25 13:58:55
     */
    private class View extends ViewDSL {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            box($.Information, () -> {

            });

            Mastery[][][] masteries = Mastery.getMasteryTree(Version.Latest);

            build($.Offense, masteries[0], MasteryType.Offense);
            build($.Defense, masteries[1], MasteryType.Defense);
            build($.Utility, masteries[2], MasteryType.Utility);
        }

        /**
         * <p>
         * Helper method to build view.
         * </p>
         * 
         * @param root
         * @param set
         */
        private void build(Style style, Mastery[][] set, MasteryType type) {
            box(style, () -> {
                box(contents(set, masteries -> {
                    box($.RankPane, contents(masteries, mastery -> {
                        if (mastery == null) {
                            box($.MasteryPane, $.EmptyPane);
                            System.out.println("");
                        } else {
                            boolean available = masterySet.getLevel(mastery) != 0 || masterySet.isAvailable(mastery);

                            box($.MasteryPane, If(!available, $.Unavailable), () -> {
                                svg("svg", $.IconImage, attr("size", "45 45"), () -> {
                                    svg("image", attr("position", "0 0"), attr("size", "45 45"), attr("xlink:href", mastery
                                            .getIcon()), attr("preserveAspectRatio", "xMinYMin slice"), attr("filter", available ? ""
                                                    : "url('#test')"));
                                    svg("filter", $.NBox, id("test"), () -> {
                                        svg("feColorMatrix", attr("type", "matrix"), attr("values", grayscale(0.4)));
                                    });
                                });
                                box($.LevelPane, () -> {
                                    text($.LevelValue, masterySet.getLevel(mastery));
                                    text($.LevelSeparator, "/");
                                    text($.LevelValue, mastery.getMaxLevel());
                                });

                                box($.PopupPane, () -> {
                                    text($.MasteryName, mastery.name);
                                    widget(Widget
                                            .of(MasteryWidget.class, mastery, null, mastery.getDescriptor(Version.Latest).getPassive()));
                                });
                            });
                        }
                    }));
                }));
                text($.SumPoint, type.name().toUpperCase(), "　", masterySet.getSum(type));
            });
        }
    }

    private String grayscale(double amount) {
        return amount + " " + amount + " " + amount + " 0 0 " + amount + " " + amount + " " + amount + " 0 0 " + amount + " " + amount + " " + amount + " 0 0 0 0 0 1 0";
    }

    /**
     * @version 2015/08/19 14:19:47
     */
    private class MasteryWidget extends DescriptionView<Mastery> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return masterySet.getLevel(model1);
        }
    }

    /**
     * @version 2015/08/19 18:29:05
     */
    private static class MasteryManager {
    }

    /**
     * @version 2013/03/13 15:05:12
     */
    static class Styles extends StyleDSL {

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

        private static LinearGradient transparent = new LinearGradient().color(new Color(0, 100, 100, 0.6), new Color(0, 100, 100, 0));

        private static String noise = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkAQMAAABKLAcXAAAABlBMVEUAAAAAAAClZ7nPAAAAAnRSTlMAGovxNEIAAAAoSURBVDhPYxBEAgIMSkhAgcEFCTgwdCCBBoZRfaP6RvWN6hvVR5Y+APADQlQnmrINAAAAAElFTkSuQmCC";

        Style Unavailable = () -> {
        };

        Style Completed = () -> {
        };

        private void MasteryBox() {
            display.inlineBlock().width(TreeWidth, px).height(TreeHeight, px);
            padding.size(TreePadding, px);
            background.image(BackgroundImage.of(transparent), BackgroundImage.url(noise));
        }

        Style Offense = () -> {
            MasteryBox();
            background.color(Blue.adjustHue(120));
        };

        Style Defense = () -> {
            MasteryBox();
            background.color(Blue);
        };

        Style Utility = () -> {
            MasteryBox();
            background.color(Blue.adjustHue(-120));
        };

        Style RankPane = () -> {
            display.block();
            margin.vertical(Gap * 2.8, px);
            text.unselectable();
        };

        Style MasteryPane = () -> {
            display.inlineBlock().size(IconSize, px);
            margin.horizontal(Gap, px);
            position.relative();
            cursor.pointer();

            with(Unavailable, () -> {
                cursor.defaults();
            });
        };

        Style EmptyPane = () -> {
            visibility.hidden();
        };

        Style IconImage = () -> {
            display.block().size(IconSize, px);
            border.color(AvailableColor).width(IconBorderSize, px).solid().radius(Corner, px);

            ancestor().with(Unavailable, () -> {
                border.color(AvailableColor.grayscale());
            });

            ancestor().with(Completed, () -> {
                border.color(CompleteColor);
            });
        };

        ValueStyle<Mastery> MasteryImage = mastery -> {
            background.image(BackgroundImage.url(mastery.getIcon()).horizontal(mastery.getIconPosition()).cover().borderBox().noRepeat());
        };

        Style LevelPane = () -> {
            display.block().width(IconSize - IconBorderSize * 2, px);
            position.bottom(IconBorderSize, px).left(IconBorderSize, px).absolute();
            padding.right(5, px);
            border.bottom.radius(Corner, px);
            background.color(hsla(0, 0, 0, 0.3));
            font.color(AvailableColor).size(11, px);
            text.outline(AvailableColor, 1).align.right();

            ancestor().with(Unavailable, () -> {
                display.none();
            });

            ancestor().with(Completed, () -> {
                font.color(CompleteColor);
            });
        };

        Style SumPoint = () -> {
            font.color(hsla(0, 0, 100, 0.7)).size(26, px);
            text.unselectable();
            padding.left(7, px);
        };

        Style LevelValue = () -> {
            text.unselectable();
            cursor.pointer();
        };

        Style LevelSeparator = () -> {
            margin.horizontal(2, px);
            text.unselectable();
            cursor.pointer();
        };

        Style PopupPane = () -> {

            int Width = 220;

            int BorderWidth = 2;

            Color borderColor = new Color(0, 98, 97, 0.9);

            Color color = new Color(0, 10, 0, 1);
            display.block().width(Width, px).opacity(0).zIndex(100).shadow(shadow().blurRadius(7, px).color(color));
            position.absolute().bottom(IconSize + 35, px).left(IconSize / 2 - Width / 2, px);
            background.image(BackgroundImage.of(linear(color.opacify(-0.25), color)));
            border.radius(Corner, px).solid().width(BorderWidth, px).color(borderColor);
            padding.size(10, px);
            visibility.hidden();
            font.color(hsl(0, 99, 97)).size.smaller();
            pointerEvents.none();

            createBottomBubble(6, new Numeric(BorderWidth, px), borderColor, color);

            ancestor().with(Unavailable, () -> {
                font.color(AvailableColor.grayscale());
            });

            transit().easeInOut().when().prev().hover(() -> {
                display.opacity(1);
                visibility.visible();
                position.bottom(IconSize + 12, px);
            });
        };

        Style MasteryName = () -> {
            display.block();
            margin.bottom(0.7, em);
            text.unselectable();
            font.size(16, px).weight.bolder().color(hsl(60, 100, 85)).family(TeemoworkTheme.Title);
        };

        Style Description = () -> {
            text.unselectable();

            prev().with(Unavailable, () -> {
                font.color(hsl(0, 70, 70));
            });
        };

        Style Current = () -> {
        };

        Style ComputedValue = () -> {
        };

        Style Information = () -> {
            display.block();
            margin.bottom(10, px);
        };

        // Style ResetButton = () -> {
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

        Style Available = () -> {
        };

        private static Numeric BorderWidth = new Numeric(1, Unit.px);

        private static Numeric BorderRadius = new Numeric(4, Unit.px);

        private static Color BorderColor = new Color(0, 0, 80);

        // Style Input = () -> {
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

}
