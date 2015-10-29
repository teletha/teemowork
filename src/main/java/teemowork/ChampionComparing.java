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

import static jsx.ui.StructureDescriptor.*;
import static teemowork.model.Status.*;

import java.util.Comparator;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import js.dom.UIAction;
import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.value.Numeric;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import jsx.ui.piece.Select;
import jsx.ui.piece.UI;
import kiss.I;
import teemowork.model.Build;
import teemowork.model.Champion;
import teemowork.model.ChampionGroup;
import teemowork.model.ChampionStatus;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/08/20 15:47:10
 */
public class ChampionComparing extends Widget {

    private static final Status[] STATUS = {Health, Hreg, Mana, Mreg, AD, AS, AR, MR, MS, Range};

    /** The filter. */
    private Property<ChampionGroup> group = new SimpleObjectProperty(ChampionGroup.ALL);

    /** The sort order. */
    private ListProperty<Header> order = I.make(ListProperty.class);

    private final Select<ChampionGroup> groups = UI.select(group, ChampionGroup.class);

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
    private ChampionComparing(Teemowork teemowork) {
        when(UIAction.Click).at($.Icon, Build.class).to(build -> {
            teemowork.champion(build.champion);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        widget(groups);
        box($.Table, () -> {
            box($.Head, () -> {
                box($.NoIcon);
                box(contents(Header.class, STATUS));
            });

            box($.Body, () -> {
                box($.VBox, contents(group.getValue().sortBy(comparator), build -> {
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

    /**
     * @version 2015/03/02 10:58:34
     */
    private class Header extends Widget1<Status>implements Comparator<Build> {

        /** The champion status. */
        private final Status status = model1;

        /** The sort order of this header. */
        private boolean decending = status != null;

        /**
         * 
         */
        private Header() {
            when(UIAction.Click).at($.StatusHeader).to(update(v -> {
                if (order.get(0) == this) {
                    this.decending = !decending;
                }

                // push this at top
                order.remove(this);
                order.add(0, this);
            }));
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
            text($.StatusHeader, status);
        }
    }

    /**
     * @version 2015/08/20 15:44:41
     */
    private static class $ extends StyleDescriptor {

        private static final Numeric itemWidth = new Numeric(6.5, em);

        private static final Numeric IconSize = new Numeric(22, px);

        private static final Numeric IconMargin = new Numeric(10, px);

        private static Style Table = () -> {
            display.verticalBox();
            font.size.small();
            margin.top(IconMargin);
        };

        private static Style Head = () -> {
        };

        private static Style Body = () -> {
        };

        private static Style RowLine = () -> {
            display.flex().alignItems.center();
            margin.top(0.5, em);
        };

        private static ValueStyle<Champion> Icon = champion -> {
            display.inlineBlock();
            background.image("src/main/resources/teemowork/champions.jpg").cover().horizontal(champion.getIconPosition());
            box.size(IconSize);
            border.radius(2, px).color(rgb(50, 50, 50)).width(1, px).solid();
            cursor.pointer();
            margin.right(IconMargin);
        };

        static Style NoIcon = () -> {
            display.inlineBlock();
            box.width(IconSize.add(IconMargin));
        };

        static Style Status = () -> {
            display.inlineBlock();
            box.width(itemWidth);
        };

        static Style StatusHeader = Status.with(() -> {
            cursor.pointer();
        });

        static Style StatusBase = () -> {
        };

        static Style StatusPerLevel = () -> {
            font.color(rgb(180, 180, 180));
        };
    }
}
