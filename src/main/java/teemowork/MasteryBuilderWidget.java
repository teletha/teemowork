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

import js.dom.Element;
import js.dom.Image;
import js.dom.UIAction;
import jsx.event.Subscribe;
import jsx.model.SelectableModel;
import jsx.style.Style;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
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
                                〡.nbox.〡(null, Widget.of(MasteryDescriptionView.class, mastery, null, descriptor.getPassive()));

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
    private static class MasteryDescriptionView extends DescriptionViewWidget<Mastery> {

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
     * @version 2013/03/23 14:05:25
     */
    private class MasteryView {

        private final int size = 45;

        /** The associated mastery. */
        private final Mastery mastery;

        /** The root element. */
        private final Element root;

        /** The icon image. */
        private final Image image;

        /** The value element. */
        private final Element currentLevel;

        /** The popup element. */
        private final Element popup;

        /**
         * <p>
         * Create mastery view.
         * </p>
         * 
         * @param root
         * @param mastery
         */
        private MasteryView(final Element root, final Mastery mastery) {
            this.root = root;
            this.mastery = mastery;

            // Icon Pane
            image = root.image(IconImage).src(mastery.getIcon()).clip(mastery.id * size, 0, size, size);

            // Mastery Level Pane
            Element levelPane = root.child(LevelPane);
            currentLevel = levelPane.child(LevelValue).text(0);
            levelPane.child(LevelSeparator).text("/");
            levelPane.child(LevelValue).text(mastery.getMaxLevel());

            // Mastery Description Pane
            popup = root.child(PopupPane);
            popup.child(MasteryName).text(mastery.name);
            // masterySet.subscribe(new MasteryDescriptionView(popup, mastery));

            // Event Handlers
            root.subscribe(UIAction.Click, event -> {
                event.preventDefault();
                masterySet.up(mastery);
            }).subscribe(UIAction.ClickRight, event -> {
                event.preventDefault();
                masterySet.down(mastery);
            });
        }

        /**
         * 
         */
        @Subscribe(MasterySet.class)
        public void receive() {
            int current = masterySet.getLevel(mastery);

            // Update current level
            currentLevel.text(current);

            // Switch enable / disable
            if (current != 0 || masterySet.isAvailable(mastery)) {
                image.saturate(0.8);
                root.remove(Unavailable);
            } else {
                image.grayscale(0.4);
                root.add(Unavailable);
            }

            // Switch complete / incomplete
            if (masterySet.isMax(mastery)) {
                root.add(Completed);
            } else {
                root.remove(Completed);
            }
        }
    }

    /**
     * @version 2013/10/04 13:04:34
     */
    private static class MasteryManager extends SelectableModel<MasterySet> {
    }
}
