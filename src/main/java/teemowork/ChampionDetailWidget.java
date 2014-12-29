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

import static jsx.style.StyleDescriptor.*;
import static teemowork.ChampionDetailStyle.*;
import static teemowork.model.Status.*;

import java.util.ArrayList;
import java.util.List;

import js.dom.DocumentFragment;
import js.dom.Element;
import js.dom.UIAction;
import js.math.Mathematics;
import jsx.bwt.UI;
import jsx.event.Subscribe;
import jsx.event.SubscribeUI;
import jsx.style.MultipleStyle;
import jsx.style.Style;
import jsx.style.property.Background.BackgroundImage;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import jsx.ui.Widget2;
import jsx.ui.piece.Output;
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
public class ChampionDetailWidget extends Widget1<Build> {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV,
            AR, MR, MS, Range, Tenacity};

    /** The status box. */
    private List<StatusView> statuses = new ArrayList();

    /** The item box. */
    private List<ItemBox> items = new ArrayList();

    /** The your custom build. */
    private final Build build = model1;

    private final Champion champion = build.champion;

    /** The status. */
    private Element level;

    /** The skill view. */
    private Element skillView;

    @SubscribeUI(type = UIAction.Click, abort = true)
    private void levelUp() {
        build.setLevel(build.getLevel() + 1);
    }

    @SubscribeUI(type = UIAction.ClickRight, abort = true)
    private void levelDown() {
        build.setLevel(build.getLevel() - 1);
    }

    private final Output levelText = jsx.ui.piece.UI.output(build.level)
            .style(ChampionIconBox, () -> {
                background.image(BackgroundImage.url("src/main/resources/teemowork/champions.jpg")
                        .horizontal(champion.id / (Champion.size() - 1) * 100, percent));
            })
            .click(() -> {
                build.setLevel(build.getLevel() + 1);
            });

    /** The item image. */
    private final ItemBoxWidget item1 = Widget.of(ItemBoxWidget.class, build.getItem(0));

    /** The item image. */
    private final ItemBoxWidget item2 = Widget.of(ItemBoxWidget.class, build.getItem(1));

    /** The item image. */
    private final ItemBoxWidget item3 = Widget.of(ItemBoxWidget.class, build.getItem(2));

    /** The item image. */
    private final ItemBoxWidget item4 = Widget.of(ItemBoxWidget.class, build.getItem(3));

    /** The item image. */
    private final ItemBoxWidget item5 = Widget.of(ItemBoxWidget.class, build.getItem(4));

    /** The item image. */
    private final ItemBoxWidget item6 = Widget.of(ItemBoxWidget.class, build.getItem(5));

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure 〡) {
        〡.hbox.〡(UpperInfo, () -> {
            〡.asis.〡$(levelText);
            〡.hbox.〡(ItemViewBox, item1, item2, item3, item4, item5, item6);
        });

        〡.hbox.〡(Container, () -> {
            〡.vbox.〡(StatusViewBox, VISIBLE, status -> {
                〡.hbox.〡(StatusBox, () -> {
                    〡.hbox.〡(StatusName, status.name());
                    〡.hbox.〡(StatusValue, computeStatusValue(status));
                });
            });

            〡.vbox.〡(SkillTable, build.champion.skills, skill -> {
                〡.hbox.〡(SkillRow, () -> {
                    〡.vbox.〡(IconBox, () -> {
                        〡.〡(SkillBoxWidget.class, skill);

                        if (skill.key != SkillKey.Passive) {
                            〡.nbox.〡(LevelBox, skill.getMaxLevel(), level -> {
                                〡.nbox.〡(LevelMark);
                            });
                        }
                    });

                    〡.vbox.〡(() -> {
                        SkillDescriptor status = skill.getDescriptor(build.getVersion());
                        〡.nbox.〡(Name, skill.name);
                        〡.nbox.〡(() -> {
                            writeStatusValue(〡, skill, status, status.getRange());
                            writeStatusValue(〡, skill, status, status.getCooldown());
                            writeStatusValue(〡, skill, status, status.getCost());
                        });

                        if (!status.getPassive().isEmpty()) {
                            〡.nbox.〡(Text, () -> {
                                〡.nbox.〡(SkillTypeInfo, "PASSIVE");
                                〡.nbox.〡(null, Widget.of(SkillTextWidget.class, skill, status.getPassive()));
                            });
                        }

                        if (!status.getActive().isEmpty()) {
                            〡.nbox.〡(Text, () -> {
                                〡.nbox.〡(SkillTypeInfo, status.getType().toString());
                                〡.nbox.〡(null, Widget.of(SkillTextWidget.class, skill, status.getActive()));
                            });
                        }
                    });
                });
            });
        });
    }

    /**
     * @version 2014/12/18 16:51:00
     */
    private class SkillTextWidget extends Widget2<Skill, List> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            int level = build.getLevel(model1);

            $〡.nbox.〡(null, model2, text -> {
                if (text instanceof Variable) {
                    writeVariable($〡, (Variable) text, level);
                } else {
                    $〡.〡(text);
                }
            });
        }
    }

    /**
     * <p>
     * Compute the specified status and make it human readable.
     * </p>
     * 
     * @param status
     * @return
     */
    private Object[] computeStatusValue(Status status) {
        String value = build.getQualified(status);

        if (status == ARPen) {
            return new String[] {value, " | ", build.getQualified(ARPenRatio)};
        } else if (status == MRPen) {
            return new String[] {value, " | ", build.getQualified(MRPenRatio)};
        } else {
            return new String[] {value};
        }
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
    private void writeStatusValue(VirtualStructure $〡, Skill sss, SkillDescriptor skill, Variable variable) {
        if (variable != null) {
            $〡.hbox.〡(StatusBlock, () -> {
                Status status = variable.getStatus();
                VariableResolver resolver = variable.getResolver();

                int level = build.getLevel(sss);

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

                $〡.nbox.〡(StatusLabel, label);

                // write values
                int size = resolver.estimateSize();
                int current = level;

                $〡.nbox.〡(null, size, i -> {
                    double value = status.round(variable.calculate(i + 1, build));

                    $〡.style.〡(size != 1 && i + 1 == current, Current);
                    $〡.style.〡("title", resolver.getLevelDescription(i + 1), ChampionLevelIndicator);
                    $〡.nbox.〡(SkillStatusValue, value == -1 ? "∞" : value);

                    if (i + 1 != size) {
                        $〡.nbox.〡(Separator, "/");
                    }
                });

                // write amplifiers
                writeAmplifier($〡, variable.getAmplifiers(), 0);

                // write unit
                $〡.〡(status.getUnit());
            });
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
    private void writeVariable(VirtualStructure $〡, Variable variable, int level) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.getAmplifiers();

        if (!resolver.isSkillLevelBased()) {
            level = resolver.convertLevel(build);
        }

        // compute current value
        $〡.nbox.〡(ComputedValue, status.format(variable.calculate(Math.max(1, level), build)));

        // All values
        int size = resolver.estimateSize();
        int current = level;

        if (1 < size || !amplifiers.isEmpty()) {
            $〡.〡("(");
            $〡.nbox.〡(null, size, i -> {
                $〡.style.〡(i + 1 == current, Current);
                $〡.style.〡("title", resolver.getLevelDescription(i + 1), ChampionLevelIndicator);
                $〡.nbox.〡(NormalValue, Mathematics.round(resolver.compute(i + 1), 2));

                if (i + 1 != size) {
                    $〡.nbox.〡(Separator, "/");
                }
            });

            writeAmplifier($〡, amplifiers, level);
            $〡.〡(")");
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
    private void writeAmplifier(VirtualStructure $〡, List<Variable> amplifiers, int level) {
        $〡.nbox.〡(null, amplifiers, amplifier -> {
            $〡.nbox.〡(Amplifier, () -> {
                int amp = level;

                $〡.〡("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    amp = resolver.convertLevel(build);
                }

                int size = resolver.estimateSize();
                int current = amp;

                $〡.nbox.〡(null, size, i -> {
                    $〡.style.〡(size != 1 && i + 1 == current, Current);
                    $〡.style.〡("title", resolver.getLevelDescription(i + 1), ChampionLevelIndicator);
                    $〡.nbox.〡(NormalValue, Mathematics.round(amplifier.calculate(i + 1, build), 4));

                    if (i + 1 != size) {
                        $〡.nbox.〡(Separator, "/");
                    }
                });

                $〡.〡(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    $〡.〡("(");
                    writeAmplifier($〡, amplifier.getAmplifiers(), current);
                    $〡.〡(")");
                }
                $〡.〡(amplifier.getStatus().name);
            });
        });
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
    public void load(DocumentFragment root) {
        Element container = root.child(Container);
    }

    /**
     * {@inheritDoc}
     */
    protected String getPageId() {
        return "Champion2/" + build.champion.systemName;
    }

    /**
     * @version 2014/12/19 9:25:49
     */
    private static class SkillBoxWidget extends Widget1<Skill> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            MultipleStyle icon = new MultipleStyle(SkillIcon, () -> {
                background.image(BackgroundImage.url(model1.getIcon()));
            });

            $〡.hbox.〡(icon);
        }
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
                build.up(skill);
            }).subscribe(UIAction.ClickRight, event -> {
                event.preventDefault();
                build.down(skill);
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
                    levels[i].addClass(Assigned);
                } else {
                    levels[i].removeClass(Assigned);
                }
            }

            if (build.isActive(skill)) {
                icon.addClass(Active);
            } else {
                icon.removeClass(Active);
            }

            write(cooldown, status, status.getCooldown());
            write(cost, status, status.getCost());
            write(range, status, status.getRange());

            // avoid circular dependency
            DependencyManager.use(skill);

            // PASSIVE
            passive.empty();

            if (!status.getPassive().isEmpty()) {
                passive.child(SkillTypeInfo).text(status.getType());

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

            active.child(SkillTypeInfo).text(status.getType());

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
                        element.attr("title", title).addClass(ChampionLevelIndicator);
                    }

                    if (size != 1 && i == level) {
                        element.addClass(Current);
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
                        element.attr("title", title).addClass(ChampionLevelIndicator);
                    }

                    if (i == level) {
                        element.addClass(Current);
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
                        value.attr("title", resolver.getLevelDescription(i)).addClass(ChampionLevelIndicator);
                    }

                    if (size != 1 && i == level) {
                        value.addClass(Current);
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
     * @version 2014/11/21 21:07:52
     */
    private static class ItemBoxWidget extends Widget1<Item> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.hbox.〡(ItemIconBase, () -> {
                $〡.hbox.〡((Style) () -> {
                    background.image(BackgroundImage.url("src/main/resources/teemowork/items.jpg")
                            .horizontal(model1.position / (Item.size() - 1) * 100, percent)
                            .cover()
                            .borderBox()
                            .noRepeat());
                    display.block();
                    box.size(100, percent);
                });
            });
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
            this.icon = root.addClass(ItemIconBase).child(ItemIcon);
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
