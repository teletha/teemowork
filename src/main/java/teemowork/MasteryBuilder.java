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

import static js.lang.Global.*;
import static teemowork.MasteryBuilderStyle.*;

import js.dom.DocumentFragment;
import js.dom.Element;
import js.dom.Image;
import js.dom.UIAction;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.Button;
import jsx.bwt.Select;
import jsx.event.Subscribe;
import jsx.model.SelectableModel;
import kiss.I;
import teemowork.model.Describable;
import teemowork.model.DescriptionView;
import teemowork.model.Mastery;
import teemowork.model.MasterySeason4;
import teemowork.model.MasterySet;
import teemowork.model.Version;

/**
 * @version 2013/10/10 9:47:05
 */
public class MasteryBuilder extends Page {

    private MasteryManager masteryManager;

    private final MasterySet masterySet;

    /** The sum. */
    private Element sum;

    /** The offense value. */
    private Element offense;

    /** The offense value. */
    private Element defense;

    /** The offense value. */
    private Element utility;

    /** The reset button. */
    private Button reset;

    /** The add button. */
    private Button add;

    private Element name;

    private Select<MasterySet> menu;

    @PageInfo(path = "Mastery")
    public MasteryBuilder() {
        this("");
    }

    @PageInfo(path = "Mastery/*")
    public MasteryBuilder(String levels) {
        masterySet = new MasterySet(levels);
        masterySet.subscribe(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        masteryManager = localStorage.get(MasteryManager.class);

        if (masteryManager == null) {
            masteryManager = new MasteryManager();
        }

        Element infomation = root.child(Information);
        menu = infomation.child(new Select(masteryManager));
        menu.model.subscribe(this);

        reset = infomation.child(new Button("30", masterySet::reset));

        add = infomation.child(new Button("ADD", event -> {
            menu.model.add(new MasterySet(masterySet.getCode()));
            save();
        }));

        Mastery[][][] masteries = Mastery.getMasteryTree(Version.Latest);

        offense = build(root.child(Offense), masteries[0]);
        defense = build(root.child(Defense), masteries[1]);
        utility = build(root.child(Utility), masteries[2]);

        masterySet.publish(masterySet);
    }

    /**
     * <p>
     * Helper method to build view.
     * </p>
     * 
     * @param root
     * @param set
     */
    private Element build(Element root, Mastery[][] set) {
        for (Mastery[] masteries : set) {
            Element rank = root.child(RankPane);

            for (final Mastery mastery : masteries) {
                Element pane = rank.child(MasteryPane);

                if (mastery == null) {
                    pane.add(EmptyPane);
                } else {
                    masterySet.subscribe(new MasteryView(pane, mastery));
                }
            }
        }
        return root.child(SumPoint);
    }

    /**
     * 
     */
    @Subscribe(MasterySet.class)
    public void receive() {
        reset.label(String.valueOf(30 - masterySet.getSum()));

        offense.text("OFFENSE　" + masterySet.getSum(MasterySeason4.Offense));
        defense.text("DEFENSE　" + masterySet.getSum(MasterySeason4.Defense));
        utility.text("UTILITY　" + masterySet.getSum(MasterySeason4.Utility));

        history.replaceState("", "", "#" + getPageId());
    }

    private void save() {
        System.out.println("save mastery");
        StringBuilder builder = new StringBuilder();
        I.write(masteryManager, builder, true);
        localStorage.set(masteryManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Mastery/" + masterySet.toString();
    }

    @Subscribe
    private void select(jsx.model.SelectableModel.Select<MasterySet> event) {
        masterySet.setCode(event.item.getCode());
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
            image = root.image(IconImage).src(mastery.getSpriteImage()).clip(mastery.id * size, 0, size, size);

            // Mastery Level Pane
            Element levelPane = root.child(LevelPane);
            currentLevel = levelPane.child(LevelValue).text(0);
            levelPane.child(LevelSeparator).text("/");
            levelPane.child(LevelValue).text(mastery.getMaxLevel());

            // Mastery Description Pane
            popup = root.child(PopupPane);
            popup.child(MasteryName).text(mastery.name);
            masterySet.subscribe(new MasteryDescriptionView(popup, mastery));

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

        /**
         * @version 2013/03/23 12:30:51
         */
        private class MasteryDescriptionView extends DescriptionView {

            /**
             * @param root
             * @param describable
             */
            private MasteryDescriptionView(Element root, Describable describable) {
                super(root, describable, null, true);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected int getLevel() {
                return masterySet.getLevel(mastery);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected Version getVersion() {
                return Version.Latest;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            @Subscribe(MasterySet.class)
            public void receive() {
                super.receive();
            }
        }
    }

    /**
     * @version 2013/10/04 13:04:34
     */
    private static class MasteryManager extends SelectableModel<MasterySet> {
    }
}
