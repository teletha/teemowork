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
import static teemowork.ChampionDetailStyle.*;
import static teemowork.model.Status.*;

import java.util.ArrayList;
import java.util.List;

import js.dom.DocumentFragment;
import js.dom.Element;
import js.dom.UIAction;
import js.math.Mathematics;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.UI;
import jsx.event.Subscribe;
import jsx.event.SubscribeUI;
import teemowork.model.Build;
import teemowork.model.Build.Computed;
import teemowork.model.Champion;
import teemowork.model.DependencyManager;
import teemowork.model.Item;
import teemowork.model.Skill;
import teemowork.model.SkillDescriptor;
import teemowork.model.SkillKey;
import teemowork.model.SkillType;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail extends Page {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV,
            AR, MR, MS, Range, Tenacity};

    /** The status box. */
    private List<StatusView> statuses = new ArrayList();

    /** The item box. */
    private List<ItemBox> items = new ArrayList();

    /** The your custom build. */
    private Build build;

    /** The status. */
    private Element level;

    /** The skill view. */
    private Element skillView;

    /**
     * Build page.
     * 
     * @param champion
     */
    @PageInfo(path = "Champion/*")
    public ChampionDetail(String name) {
        this(Champion.getByName(name));
    }

    /**
     * Build page.
     * 
     * @param champion
     */
    public ChampionDetail(Champion champion) {
        if (champion == null) {
            throw new Error();
        }
        this.build = new Build(champion);

        build.subscribe(this);
    }

    @SubscribeUI(type = UIAction.Click, abort = true)
    private void levelUp() {
        build.setLevel(build.getLevel() + 1);
    }

    @SubscribeUI(type = UIAction.ClickRight, abort = true)
    private void levelDown() {
        build.setLevel(build.getLevel() - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        Element upper = root.child(UpperInfo);

        // Icon
        Element icon = upper.child(ChampionIcon).subscribe(this);
        build.champion.applyIcon(icon);

        // Level
        level = icon.child(Level);

        // Items
        Element itemViewBox = upper.child(ItemViewBox);

        for (int i = 0; i < 6; i++) {
            items.add(itemViewBox.child(new ItemBox(build.getItem(i))));
        }

        Element container = root.child(Container);
        Element statusView = container.child(StatusViewBox);

        for (Status status : VISIBLE) {
            statuses.add(new StatusView(status, statusView));
        }
        skillView = container.child(SkillTable);

        window.subscribe(UIAction.KeyPress, event -> {
            switch (event.which) {
            case 113:// Q
                build.active(SkillKey.Q);
                break;

            case 119:// W
                build.active(SkillKey.W);
                break;

            case 101:// E
                build.active(SkillKey.E);
                break;

            case 114:// R
                build.active(SkillKey.R);
                break;

            default:
                break;
            }
        });

        calcurate();
    }

    /**
     * <p>
     * Calcurate current status.
     * </p>
     */
    @Subscribe(Build.class)
    private void calcurate() {
        // update each status
        level.text(String.valueOf(build.getLevel()));

        skillView.empty();

        for (Skill skill : build.champion.skills) {
            new SkillView(skill, skillView.child(SkillRow)).update();
        }

        for (StatusView box : statuses) {
            box.calculate();
        }

        for (ItemBox box : items) {
            box.calculate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Champion/" + build.champion.systemName;
    }

    /**
     * @version 2013/02/09 22:59:04
     */
    private class SkillView {

        /** The target to desiplay. */
        private final Skill skill;

        /** The icon element. */
        private final Element icon;

        /** The skill level. */
        private final Element[] levels;

        /** The skill text. */
        private final Element passive;

        /** The skill text. */
        private final Element active;

        /** The cool down. */
        private final Element cooldown;

        /** The cost. */
        private final Element cost;

        /** The cost. */
        private final Element range;

        /**
         * @param skill
         */
        private SkillView(final Skill skill, Element root) {
            int size = skill.getMaxLevel();

            this.skill = skill;
            this.levels = new Element[size];

            Element iconBox = root.child(IconBox);
            icon = iconBox.child(SkillIcon).css("background-image", "url(" + skill.getIcon() + ")");
            iconBox.subscribe(UIAction.Click, event -> {
                event.preventDefault();
                build.levelUp(skill);
            }).subscribe(UIAction.ClickRight, event -> {
                event.preventDefault();
                build.levelDown(skill);
            });

            if (skill.key != SkillKey.Passive) {
                Element levels = iconBox.child(LevelBox);

                for (int i = 0; i < size; i++) {
                    this.levels[i] = levels.child(LevelMark);
                }
            }

            Element descriptor = root.child("div");
            descriptor.child(Name).text(skill.name);

            this.range = descriptor.child(SkillStatusValues);
            this.cooldown = descriptor.child(SkillStatusValues);
            this.cost = descriptor.child(SkillStatusValues);

            this.passive = descriptor.child(Text);
            this.active = descriptor.child(Text);
        }

        /**
         * <p>
         * Update this view.
         * </p>
         */
        private void update() {
            SkillDescriptor status = skill.getDescriptor(build.getVersion());

            int level = build.getLevel(skill);

            for (int i = 0; i < levels.length; i++) {
                if (i < level) {
                    levels[i].add(Assigned);
                } else {
                    levels[i].remove(Assigned);
                }
            }

            if (build.isActive(skill)) {
                icon.add(Active);
            } else {
                icon.remove(Active);
            }

            write(cooldown, status, status.getCooldown());
            write(cost, status, status.getCost());
            write(range, status, status.getRange());

            // avoid circular dependency
            DependencyManager.use(skill);

            // PASSIVE
            passive.empty();

            if (!status.getPassive().isEmpty()) {
                passive.child(SkillTypeInfo).text("PASSIVE");

                for (Object token : status.getPassive()) {
                    if (token instanceof Variable) {
                        writeVariable(passive, (Variable) token, level);
                    } else {
                        passive.append(token);
                    }
                }
            }

            // ACTIVE
            active.empty();

            SkillType type = status.getType();

            if (type != SkillType.Active) {
                active.child(SkillTypeInfo).text(status.getType());
            }

            for (Object token : status.getActive()) {
                if (token instanceof Variable) {
                    writeVariable(active, (Variable) token, level);
                } else {
                    active.append(token);
                }
            }

            // avoid circular dependency
            DependencyManager.unuse(skill);

        }

        /**
         * <p>
         * Write skill related status.
         * </p>
         * 
         * @param root A element to write.
         * @param skill A current processing skill.
         * @param variable A target skill variable.
         */
        private void write(Element root, SkillDescriptor skill, Variable variable) {
            root.empty();

            if (variable != null) {
                Status status = variable.getStatus();
                VariableResolver resolver = variable.getResolver();

                int level = build.getLevel(this.skill);

                if (!resolver.isSkillLevelBased()) {
                    level = resolver.convertLevel(build);
                }

                // write label
                String label = status.name;

                if (status != Range && status != CD) {
                    if (skill.getType() == SkillType.Toggle) {
                        label = "毎秒" + label;
                    } else if (skill.getType() == SkillType.ToggleForAttack) {
                        label = "攻撃毎" + label;
                    }
                }
                root.child(StatusLabel).text(label);

                // write values
                int size = resolver.estimateSize();

                for (int i = 1; i <= size; i++) {
                    double value = status.round(variable.calculate(i, build));
                    Element element = root.child(SkillStatusValue).text(value == -1 ? "∞" : value);

                    if (!resolver.isSkillLevelBased()) {
                        String title = resolver.getLevelDescription(i);
                        element.attr("title", title).add(ChampionLevelIndicator);
                    }

                    if (size != 1 && i == level) {
                        element.add(Current);
                    }

                    if (i != size) {
                        root.child(Separator).text("/");
                    }
                }

                // write amplifiers
                writeAmplifier(root, variable.getAmplifiers(), 0);

                // write unit
                root.append(status.getUnit());
            }
        }

        /**
         * <p>
         * </p>
         * 
         * @param root
         * @param variable
         * @param level
         */
        private void writeVariable(Element root, Variable variable, int level) {
            VariableResolver resolver = variable.getResolver();
            Status status = variable.getStatus();
            List<Variable> amplifiers = variable.getAmplifiers();

            if (!resolver.isSkillLevelBased()) {
                level = resolver.convertLevel(build);
            }

            // compute current value
            root.child(ComputedValue).text(status.format(variable.calculate(Math.max(1, level), build)));

            // All values
            int size = resolver.estimateSize();

            if (1 < size || !amplifiers.isEmpty()) {
                root.append("(");

                for (int i = 1; i <= size; i++) {
                    Element element = root.child(NormalValue).text(Mathematics.round(resolver.compute(i), 2));

                    if (!resolver.isSkillLevelBased()) {
                        String title = resolver.getLevelDescription(i);
                        element.attr("title", title).add(ChampionLevelIndicator);
                    }

                    if (i == level) {
                        element.add(Current);
                    }

                    if (i != size) {
                        root.child(Separator).text("/");
                    }
                }

                writeAmplifier(root, amplifiers, level);
                root.append(")");
            }
        }

        /**
         * <p>
         * Write skill amplifier.
         * </p>
         * 
         * @param root A element to write.
         * @param amplifiers A list of skill amplifiers.
         * @param level A current skill level.
         */
        private void writeAmplifier(Element root, List<Variable> amplifiers, int level) {
            for (Variable amplifier : amplifiers) {
                Element element = root.child(Amplifier);
                element.append("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    level = resolver.convertLevel(build);
                }

                int size = resolver.estimateSize();

                for (int i = 1; i <= size; i++) {
                    Element value = element.child(NormalValue)
                            .text(Mathematics.round(amplifier.calculate(i, build), 4));

                    if (!resolver.isSkillLevelBased()) {
                        value.attr("title", resolver.getLevelDescription(i)).add(ChampionLevelIndicator);
                    }

                    if (size != 1 && i == level) {
                        value.add(Current);
                    }

                    if (i != size) {
                        element.child(Separator).text("/");
                    }
                }

                element.append(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    element.append("(");
                    writeAmplifier(element, amplifier.getAmplifiers(), level);
                    element.append(")");
                }
                element.append(amplifier.getStatus().name);
            }
        }
    }

    /**
     * @version 2013/01/21 16:29:15
     */
    private class StatusView {

        /** The target to display. */
        private final Status status;

        /** The value for curernt Lv. */
        private final Element current;

        /**
         */
        private StatusView(Status status, Element root) {
            Element box = root.child(StatusBox);
            box.child(StatusName).text(status.name());

            this.status = status;
            this.current = box.child(StatusValue);
        }

        /**
         * <p>
         * Calculate status and show it
         * </p>
         */
        private void calculate() {
            Computed value = build.get(status);

            this.current.text(value.value() + status.getUnit());

            if (status == ARPen) {
                current.append(" | ").append(build.get(ARPenRatio).value() + ARPenRatio.getUnit());
            }

            if (status == MRPen) {
                current.append(" | ").append(build.get(MRPenRatio).value() + MRPenRatio.getUnit());
            }
        }
    }

    /**
     * @version 2013/03/13 10:41:24
     */
    private class ItemBox extends UI {

        /** The item. */
        private Item item;

        /** The root element. */
        private final Element icon;

        /**
         * @param item
         */
        public ItemBox(Item item) {
            this.item = item;
            this.icon = root.add(ItemIconBase).child(ItemIcon);
        }

        /**
         * <p>
         * Calculate status and show it
         * </p>
         */
        private void calculate() {
            if (item != null) {
                item.applyIcon(icon);

                ItemView view = new ItemView(item, item.getDescriptor(Version.Latest), build);
                view.root.css("max-width", "350px");

                setTooltip(view);
            }
        }
    }

    private static class Component {

        public Element child() {
            return null;
        }
    }

    /**
     * @version 2013/10/22 10:00:56
     */
    private class ChampionFaceIcon {

        private Element level;

        private void render(Element me) {
            // apply champion icon

            // display level
            level = me.child(Level);
        }

        @SubscribeUI(type = UIAction.Click, abort = true)
        private void levelUp() {
            build.setLevel(build.getLevel() + 1);
        }

        @SubscribeUI(type = UIAction.ClickRight, abort = true)
        private void levelDown() {
            build.setLevel(build.getLevel() - 1);
        }

        @Subscribe
        private void modify(Build build) {
            // change level text
            level.text(build.getLevel());
        }
    }
}
