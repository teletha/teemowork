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

import static teemowork.model.Status.*;

import java.util.Comparator;

import javafx.beans.property.ListProperty;

import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.ValueStyle;
import jsx.style.value.Numeric;
import jsx.ui.StructureDSL;
import jsx.ui.User;
import jsx.ui.Widget;
import jsx.ui.piece.Select;
import jsx.ui.piece.UI;
import kiss.I;
import kiss.Variable;
import teemowork.ChampionComparing.Styles;
import teemowork.model.Build;
import teemowork.model.Champion;
import teemowork.model.ChampionGroup;
import teemowork.model.ChampionStatus;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/08/20 15:47:10
 */
public class ChampionComparing extends Widget<Styles> {

    private static final Status[] STATUS = {Health, Hreg, Mana, Mreg, AD, AS, AR, MR, MS, Range};

    /** The filter. */
    private Variable<ChampionGroup> group = Variable.of(ChampionGroup.ALL);

    /** The sort order. */
    private ListProperty<Header> order = I.make(ListProperty.class);

    private final Select<ChampionGroup> groups = UI.select(ChampionGroup.class, group);

    private final int level = 18;

    /** The sort comparator. */
    private Comparator<Build> comparator = (one, other) -> {
        for (Header header : order) {
            int result = header.compare(one, other);

            if (result != 0) {
                return result;
            }
        }
        return 0;
    };

    /**
     * 
     */
    ChampionComparing(Teemowork teemowork) {
        when(User.Click).at($.Icon, Build.class).to(build -> {
            teemowork.router.champion(build.champion);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        new StructureDSL() {
            {
                widget(groups);
                box($.Table, () -> {
                    box($.Head, () -> {
                        box($.NoIcon);
                        box(contents(STATUS, Header::new));
                    });

                    box($.Body, () -> {
                        box($.VBox, contents(group.v.sortBy(comparator), build -> {
                            box($.RowLine, () -> {
                                ChampionStatus championStatus = build.champion.getStatus(Version.Latest);
                                build.setLevel(level);

                                box($.Icon.of(build.champion));
                                box(contents(STATUS, status -> {
                                    box($.Status, () -> {
                                        text($.StatusBase, build.get(status));
                                        text($.StatusPerLevel, "(", championStatus.get(status.per()), ")");
                                    });
                                }));
                            });
                        }));
                    });
                });
            }
        };
    }

    /**
     * @version 2015/03/02 10:58:34
     */
    private class Header extends Widget<Styles> implements Comparator<Build> {

        /** The champion status. */
        private final Status status;

        /** The sort order of this header. */
        private boolean decending;

        /**
         * 
         */
        private Header(Status status) {
            this.status = status;
            this.decending = status != null;

            when(User.Click).at($.StatusHeader).sideEffect(updateView).to(v -> {
                if (order.get(0) == this) {
                    this.decending = !decending;
                }
                System.out.println(status + "  " + decending);
                // push this at top
                order.remove(this);
                order.add(0, this);
            });
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(Build one, Build other) {
            double oneValue = one.setLevel(level).get(status).value;
            double otherValue = other.setLevel(level).get(status).value;

            if (oneValue == otherValue) {
                return 0;
            }

            if (decending) {
                return oneValue < otherValue ? 1 : -1;
            } else {
                return oneValue < otherValue ? -1 : 1;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            new StructureDSL() {
                {
                    text($.StatusHeader, status);
                }
            };
        }
    }

    /**
     * @version 2015/08/20 15:44:41
     */
    static class Styles extends StyleDSL {

        private static final Numeric itemWidth = new Numeric(6.5, em);

        private static final Numeric IconSize = new Numeric(22, px);

        private static final Numeric IconMargin = new Numeric(10, px);

        private Style Table = () -> {
            display.verticalBox();
            font.size.small();
            margin.top(IconMargin);
        };

        private Style Head = () -> {
        };

        private Style Body = () -> {
        };

        private Style RowLine = () -> {
            display.flex().alignItems.center();
            margin.top(0.5, em);
        };

        private ValueStyle<Champion> Icon = champion -> {
            display.inlineBlock().size(IconSize);
            background.image("src/main/resources/teemowork/champions.jpg").cover().horizontal(champion.getIconPosition());
            border.radius(2, px).color(rgb(50, 50, 50)).width(1, px).solid();
            cursor.pointer();
            margin.right(IconMargin);
        };

        Style NoIcon = () -> {
            display.inlineBlock().width(IconSize.add(IconMargin));
        };

        Style Status = () -> {
            display.inlineBlock().width(itemWidth);
        };

        Style StatusHeader = Status.with(() -> {
            cursor.pointer();
        });

        Style StatusBase = () -> {
        };

        Style StatusPerLevel = () -> {
            font.color(rgb(180, 180, 180));
        };
    }
}
