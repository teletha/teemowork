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

import static js.lang.Global.*;
import static teemowork.MasteryBuilderStyle.*;

import js.dom.UIAction;
import jsx.model.SelectableModel;
import jsx.style.Style;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import kiss.Events;
import teemowork.model.DescriptionViewWidget;
import teemowork.model.Mastery;
import teemowork.model.MasteryDescriptor;
import teemowork.model.MasterySet;
import teemowork.model.Version;

/**
 * @version 2015/08/19 13:41:08
 */
public class MasteryBuilderWidget extends Widget {

    private MasteryManager masteryManager;

    private final MasterySet masterySet = new MasterySet("");

    private final Events<Mastery> up = when(UIAction.Click, MasteryPane, Mastery.class);

    private final Events<Mastery> down = when(UIAction.ClickRight, MasteryPane, Mastery.class);

    /**
     * 
     */
    public MasteryBuilderWidget() {
        up.to(mastery -> masterySet.up(mastery));
        down.to(mastery -> masterySet.down(mastery));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        masteryManager = localStorage.get(MasteryManager.class);

        if (masteryManager == null) {
            masteryManager = new MasteryManager();
        }

        〡.nbox.〡(Information, () -> {

        });

        Mastery[][][] masteries = Mastery.getMasteryTree(Version.Latest);

        build(〡, Offense, masteries[0]);
        build(〡, Defense, masteries[1]);
        build(〡, Utility, masteries[2]);
    }

    /**
     * <p>
     * Helper method to build view.
     * </p>
     * 
     * @param root
     * @param set
     */
    private void build(VirtualStructure 〡, Style style, Mastery[][] set) {
        〡.nbox.〡(style, () -> {
            〡.nbox.〡(null, set, masteries -> {
                〡.nbox.〡(RankPane, masteries, mastery -> {
                    if (mastery == null) {
                        〡.nbox.〡(MasteryPane.with(EmptyPane));

                        // FORMAT
                    } else {
                        〡.nbox.〡(MasteryPane, () -> {
                            〡.nbox.〡(IconImage.with(MasteryImage.of(mastery)));

                            〡.nbox.〡(LevelPane, () -> {
                                〡.nbox.〡(LevelValue, 0);
                                〡.nbox.〡(LevelSeparator, "/");
                                〡.nbox.〡(LevelValue, mastery.getMaxLevel());

                                // FORMAT
                            });

                            〡.nbox.〡(PopupPane, () -> {
                                MasteryDescriptor descriptor = mastery.getDescriptor(Version.Latest);

                                〡.nbox.〡(MasteryName, mastery.name);
                                〡.〡(Widget.of(MasteryWidget.class, mastery, null, descriptor.getPassive()));

                                // FORMAT
                            });

                            // FORMAT
                        });
                    }

                    // FORMAT
                });
            });

            〡.nbox.〡(SumPoint);

            // FORMAT
        });
    }

    /**
     * @version 2015/08/19 14:19:47
     */
    private class MasteryWidget extends DescriptionViewWidget<Mastery> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return masterySet.getLevel(model1);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected Version getVersion() {
            return Version.Latest;
        }
    }

    /**
     * @version 2015/08/19 18:29:05
     */
    private static class MasteryManager extends SelectableModel<MasterySet> {
    }
}
