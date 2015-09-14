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

import static teemowork.model.Status.*;

import java.util.Comparator;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.ValueStyle;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import jsx.ui.piece.Select;
import jsx.ui.piece.UI;
import kiss.I;
import teemowork.model.Champion;
import teemowork.model.ChampionGroup;
import teemowork.model.ChampionStatus;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/08/20 15:47:10
 */
public class ChampionComparing extends Widget {

    private static final Status[] STATUS = {Health, Hreg, HregPerLv, Mana, AD, ADPerLv, AS, AR, MR, MS, Range};

    /** The filter. */
    private Property<ChampionGroup> group = new SimpleObjectProperty(ChampionGroup.RANGED);

    /** The sort order. */
    private ListProperty<Header> order = I.make(ListProperty.class);

    private final Select<ChampionGroup> groups = UI.select(ChampionGroup.class);

    /** The sort comparator. */
    private Comparator<Champion> comparator = (one, other) -> {
        for (Header header : order) {
            int result = header.compare(one, other);

            if (result != 0) {
                return result;
            }
        }
        return 0;
    };

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.nbox.〡(null, groups);
        〡.nbox.〡($.Table, () -> {
            〡.nbox.〡($.Head, () -> {
                〡.nbox.〡($.NoIcon);
                〡.nbox.〡(null, Header.class, STATUS);
            });

            〡.nbox.〡($.Body, () -> {
                〡.nbox.〡($.VBox, group.getValue().sortBy(comparator), champion -> {
                    〡.nbox.〡($.RowLine, () -> {
                        ChampionStatus championStatus = champion.getStatus(Version.Latest);

                        〡.nbox.〡($.Icon.of(champion));
                        〡.nbox.〡(null, STATUS, status -> {
                            〡.nbox.〡($.StatusView, championStatus.get(status));
                        });
                    });
                });
            });
        });
    }

    /**
     * @version 2015/03/02 10:58:34
     */
    private class Header extends Widget1<Status>implements Comparator<Champion> {

        /** The champion status. */
        private final Status status = model1;

        /** The sort order of this header. */
        private boolean decending = status != null;

        /**
         * 
         */
        private Header() {
            // listen(UIAction.Click).to(v -> {
            // if (order.get(0) == this) {
            // this.decending = !decending;
            // }
            //
            // // push this at top
            // order.remove(this);
            // order.add(0, this);
            // });
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(Champion one, Champion other) {
            double oneValue = one.getStatus(Version.Latest).get(status);
            double otherValue = other.getStatus(Version.Latest).get(status);

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
        protected void virtualize(VirtualStructure 〡) {
            〡.nbox.〡($.StatusView, status.name);
        }
    }

    /**
     * @version 2015/08/20 15:44:41
     */
    private static class $ extends StyleRuleDescriptor {

        private static Style Table = () -> {
            display.verticalBox();
        };

        private static Style Head = () -> {
        };

        private static Style Body = () -> {
        };

        private static Style RowLine = () -> {
            display.flex();
        };

        private static ValueStyle<Champion> Icon = champion -> {
            display.inlineBlock();
            background.image("src/main/resources/teemowork/champions.jpg").cover().horizontal(champion.getIconPosition());
            box.size(44, px);
            border.radius(5, px).color(rgb(50, 50, 50)).width(1, px).solid();
            cursor.pointer();
        };

        private static Style NoIcon = () -> {
            display.inlineBlock();
            box.size(40, px);
        };

        private static Style StatusView = () -> {
            display.inlineBlock();
            box.width(4, em);
            text.verticalAlign.middle();
        };
    }
}
