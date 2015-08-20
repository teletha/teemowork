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

import static js.dom.UIAction.*;
import static teemowork.model.Status.*;

import java.util.List;

import js.dom.UIAction;
import js.math.Mathematics;
import jsx.style.BinaryStyle;
import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget1;
import kiss.Events;
import teemowork.model.Build;
import teemowork.model.Champion;
import teemowork.model.Item;
import teemowork.model.Skill;
import teemowork.model.SkillDescriptor;
import teemowork.model.SkillKey;
import teemowork.model.SkillType;
import teemowork.model.Status;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2015/08/20 15:53:24
 */
public class ChampionDetailWidget extends Widget1<Build> {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV, AR, MR, MS, Range,
            Tenacity};

    /** The your custom build. */
    private final Build build = model1;

    public final Events<Champion> levelUp = on(Click, $.ChampionIconBox).merge(on(MouseWheelUp, $.ChampionIconBox));

    public final Events<Champion> levelDown = on(ClickRight, $.ChampionIconBox).merge(on(MouseWheelDown, $.ChampionIconBox));

    public final Events<Skill> skillUp = on(Click, $.IconBox, Skill.class);

    public final Events<Skill> skillDown = on(ClickRight, $.IconBox, Skill.class);

    public ChampionDetailWidget() {
        levelUp.to(v -> build.levelUp());
        levelDown.to(v -> build.levelDown());
        skillUp.to(v -> build.levelUp(v));
        skillDown.to(v -> build.levelDown(v));

        // TODO FIXME
        on(UIAction.Key_R, $.ChampionIconBox).to(e -> {
            build.active(SkillKey.R);
            build.active(SkillKey.W);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure ⅼ) {
        ⅼ.hbox.ⅼ($.UpperInfo, () -> {
            ⅼ.hbox.ⅼ($.ChampionIconBox.of(build.champion), () -> {
                ⅼ.nbox.ⅼ($.Level, build.getLevel());
            });
            // 〡.nbox.〡(null, ChampionFace.class, build.champion);
            ⅼ.hbox.ⅼ($.ItemViewBox, ItemBoxWidget.class, build.items);
        });

        ⅼ.hbox.ⅼ($.Container, () -> {
            ⅼ.vbox.ⅼ($.StatusViewBox, VISIBLE, status -> {
                ⅼ.hbox.ⅼ($.StatusBox, () -> {
                    ⅼ.hbox.ⅼ($.StatusName, status.name());
                    ⅼ.hbox.ⅼ($.StatusValue, computeStatusValue(status));
                });
            });

            ⅼ.vbox.ⅼ($.SkillTable, build.champion.skills, skill -> {
                ⅼ.hbox.ⅼ($.SkillRow, () -> {
                    ⅼ.vbox.ⅼ($.IconBox, () -> {
                        ⅼ.hbox.ⅼ($.SkillIcon.of(skill));

                        if (skill.key != SkillKey.Passive) {
                            ⅼ.nbox.ⅼ($.LevelBox, skill.getMaxLevel(), level -> {
                                ⅼ.nbox.ⅼ($.LevelMark.of(level < build.getLevel(skill)));
                            });
                        }
                    });

                    ⅼ.vbox.ⅼ(() -> {
                        SkillDescriptor status = skill.getDescriptor(build.getVersion());
                        ⅼ.hbox.ⅼ(() -> {
                            ⅼ.nbox.ⅼ($.Name, skill);
                            ⅼ.nbox.ⅼ($.VersionDisplay, status.version.name);
                        });
                        ⅼ.nbox.ⅼ(() -> {
                            writeStatusValue(ⅼ, skill, status, status.getRange());
                            writeStatusValue(ⅼ, skill, status, status.getCooldown());
                            writeStatusValue(ⅼ, skill, status, status.getCost());
                        });

                        if (!status.getPassive().isEmpty()) {
                            ⅼ.nbox.ⅼ($.Text, () -> {
                                int level = build.getLevel(skill);

                                ⅼ.nbox.ⅼ($.SkillTypeInfo, SkillType.Passive);
                                ⅼ.nbox.ⅼ(null, status.getPassive(), text -> {
                                    if (text instanceof Variable) {
                                        writeVariable(ⅼ, (Variable) text, level);
                                    } else {
                                        ⅼ.ⅼ(text);
                                    }
                                });
                            });
                        }

                        if (!status.getActive().isEmpty()) {
                            ⅼ.nbox.ⅼ($.Text, () -> {
                                int level = build.getLevel(skill);

                                ⅼ.nbox.ⅼ($.SkillTypeInfo, status.getType());
                                ⅼ.nbox.ⅼ(null, status.getActive(), text -> {
                                    if (text instanceof Variable) {
                                        writeVariable(ⅼ, (Variable) text, level);
                                    } else {
                                        ⅼ.ⅼ(text);
                                    }
                                });
                            });
                        }
                    });
                });
            });
        });
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
    private void writeStatusValue(VirtualStructure ⅼ, Skill sss, SkillDescriptor skill, Variable variable) {
        if (variable != null) {
            ⅼ.hbox.ⅼ($.StatusBlock, () -> {
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

                ⅼ.nbox.ⅼ($.StatusLabel, label);

                // write values
                int size = resolver.estimateSize();
                int current = level;

                ⅼ.nbox.ⅼ(null, size, i -> {
                    double value = status.round(variable.calculate(i + 1, build));

                    ⅼ.nbox.ⅼ($.SkillStatusValue, () -> {
                        ⅼ.style.〡($.Current, size != 1 && i + 1 == current);
                        ⅼ.style.〡($.ChampionLevelIndicator, "title", resolver.getLevelDescription(i + 1));
                        ⅼ.ⅼ(value == -1 ? "∞" : value);
                    });

                    if (i + 1 != size) {
                        ⅼ.nbox.ⅼ($.Separator, "/");
                    }
                });

                // write amplifiers
                writeAmplifier(ⅼ, variable.getAmplifiers(), 0);

                // write unit
                ⅼ.ⅼ(status.getUnit());
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
    private void writeVariable(VirtualStructure ⅼ, Variable variable, int level) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.getAmplifiers();

        if (!resolver.isSkillLevelBased()) {
            level = resolver.convertLevel(build);
        }

        // compute current value
        ⅼ.nbox.ⅼ($.ComputedValue, status.format(variable.calculate(Math.max(1, level), build)));

        // All values
        int size = resolver.estimateSize();
        int current = level;

        if (1 < size || !amplifiers.isEmpty()) {
            ⅼ.ⅼ("(");
            ⅼ.nbox.ⅼ(null, size, i -> {
                ⅼ.nbox.ⅼ($.NormalValue, () -> {
                    ⅼ.style.〡($.Current, i + 1 == current);
                    ⅼ.style.〡($.ChampionLevelIndicator, "title", resolver.getLevelDescription(i + 1));
                    ⅼ.ⅼ(Mathematics.round(resolver.compute(i + 1), 2));
                });

                if (i + 1 != size) {
                    ⅼ.nbox.ⅼ($.Separator, "/");
                }
            });

            writeAmplifier(ⅼ, amplifiers, level);
            ⅼ.ⅼ(")");
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
    private void writeAmplifier(VirtualStructure ⅼ, List<Variable> amplifiers, int level) {
        ⅼ.nbox.ⅼ(null, amplifiers, amplifier -> {
            ⅼ.nbox.ⅼ($.Amplifier, () -> {
                int amp = level;

                ⅼ.ⅼ("+");

                VariableResolver resolver = amplifier.getResolver();

                if (!resolver.isSkillLevelBased()) {
                    amp = resolver.convertLevel(build);
                }

                int size = resolver.estimateSize();
                int current = amp;

                ⅼ.nbox.ⅼ(null, size, i -> {
                    ⅼ.nbox.ⅼ($.NormalValue, () -> {
                        ⅼ.style.〡($.Current, size != 1 && i + 1 == current);
                        ⅼ.style.〡($.ChampionLevelIndicator, "title", resolver.getLevelDescription(i + 1));
                        ⅼ.ⅼ(Mathematics.round(amplifier.calculate(i + 1, build, true), 4));
                    });

                    if (i + 1 != size) {
                        ⅼ.nbox.ⅼ($.Separator, "/");
                    }
                });

                ⅼ.ⅼ(amplifier.getStatus().getUnit());
                if (!amplifier.getAmplifiers().isEmpty()) {
                    ⅼ.ⅼ("(");
                    writeAmplifier(ⅼ, amplifier.getAmplifiers(), current);
                    ⅼ.ⅼ(")");
                }
                ⅼ.ⅼ(amplifier.getStatus().name);
            });
        });
    }

    /**
     * @version 2014/11/21 21:07:52
     */
    private static class ItemBoxWidget extends Widget1<Item> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure ⅼ) {
            ⅼ.hbox.ⅼ($.ItemIconBase, () -> {
                if (model1 != null) {
                    ⅼ.hbox.ⅼ($.ItemIcon.of(model1.position));
                }
            });
        }
    }

    /**
     * @version 2015/08/20 15:49:48
     */
    private static class $ extends StyleRuleDescriptor {

        /** The skill icon size. */
        private static int SkillIconSize = 45;

        /** The level box height. */
        private static int LevelBoxHeight = 5;

        static Style UpperInfo = () -> {
            display.flex().alignItems.end();
            margin.bottom(1, em);
        };

        static Style StatusLabel = () -> {
            font.size.smaller();
        };

        static Style StatusBlock = () -> {
            display.inlineBlock();
            margin.right(0.8, em);
        };

        static Style SkillStatusValues = () -> {
            display.inlineBlock();
            margin.left(0.7, em);
        };

        static Style SkillStatusValue = () -> {
            text.align.center();
            box.opacity(0.7);
            margin.horizontal(3, px);
        };

        static Style SkillTable = () -> {
            display.block();
            flexItem.basis(100, percent);
        };

        static Style Container = () -> {
            display.flex();
        };

        static Style SkillRow = () -> {
            display.flex();
            margin.bottom(1, em);
        };

        static ValueStyle<Skill> SkillIcon = skill -> {
            display.block();
            box.size(SkillIconSize, px);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            background.image(BackgroundImage.url(skill.getIcon()).horizontal(skill.getIconPosition()).cover().borderBox().noRepeat());
        };

        static Style LevelBox = () -> {
            display.flex();
            box.width(SkillIconSize, px).height(LevelBoxHeight + 2, px);
            border.width(1, px).solid().color(Color.Black);
            border.left.none();
            margin.top(2, px).bottom(5, px);
        };

        static BinaryStyle LevelMark = state -> {
            display.block();
            flexItem.grow(1);
            box.height(LevelBoxHeight, px);
            border.left.solid().color(Color.Black).width(1, px);
            background.image(BackgroundImage.of(linear(rgba(240, 192, 28, state ? 1 : 0.5), rgba(160, 123, 1, state ? 1 : 0.5))));
        };

        static Style IconBox = () -> {
            margin.right(SkillIconSize / 5, px);
            cursor.pointer();
            flexItem.shrink(0);
        };

        static Style Name = () -> {
            margin.right(0.5, em);
            font.weight.bold();
        };

        static Style VersionDisplay = () -> {
            font.color(rgb(200, 200, 200)).size.smaller();
            flexItem.alignSelf.end();
        };

        static Style Text = () -> {
            display.block();
            margin.top(0.3, em).bottom(0.7, em);
            line.height(140, percent);
            font.size.smaller();
        };

        static Style ComputedValue = () -> {
            font.weight.bolder();
        };

        static Style NormalValue = () -> {
            text.align.center();
        };

        static Style ChampionLevelIndicator = () -> {
            cursor.help();
        };

        static Style Separator = () -> {
            box.opacity(0.4);
            margin.horizontal(1, px);
        };

        static Style Current = () -> {
            font.color(rgba(160, 123, 1, 1));
        };

        static Style SkillTypeInfo = () -> {
            margin.right(1, em);
        };

        static Style Amplifier = () -> {
            font.color(25, 111, 136);

            inBackOf(NormalValue, () -> {
                margin.left(0.4, em);
            });

            // inBackOf(Amplifier, () -> {
            // margin.left(0.4, em);
            // });
        };

        static Style Active = () -> {
            box.opacity(0.5);
        };

        private static Numeric ChampionIconSize = new Numeric(70, Unit.px);

        static Style ChampionIcon = () -> {
            display.block();
            background.image(BackgroundImage.url("src/main/resources/teemowork/champions.jpg").cover().borderBox());
            box.size(ChampionIconSize);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            position.relative();
            cursor.pointer();
        };

        static ValueStyle<Champion> ChampionIconBox = champion -> {
            box.size(ChampionIconSize);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            cursor.pointer();
            position.relative();
            background.image(champion.getIcon()).horizontal(champion.getIconPosition());

        };

        static Style Level = () -> {
            display.block();
            box.size(22, px);
            font.size(20, px).color(240, 240, 240).weight.bold().family("Arial");
            text.align.center().unselectable().outline(rgb(240, 240, 240), 0.8);
            position.absolute().bottom(4, px).right(4, px);
            cursor.pointer();
        };

        static Style StatusViewBox = () -> {
            display.block();
            box.width(13, em);
            flexItem.shrink(0);
        };

        static Style StatusBox = () -> {
            display.flex();
            margin.bottom(4, px);
        };

        static Style StatusName = () -> {
            box.width(5, em);
        };

        static Style StatusValue = () -> {
            box.width(50, px);
        };

        private static Numeric ItemIconSize = ChampionIconSize.divide(5).multiply(3);

        static Style ItemViewBox = () -> {
            display.flex();
            box.width(ItemIconSize.multiply(6));
            margin.left(137, px);
        };

        static Style ItemIconBase = () -> {
            display.block();
            box.size(ItemIconSize);
            background.image(BackgroundImage.url("src/main/resources/teemowork/empty.png").contain().noRepeat());
            padding.size(3, px);
        };

        static ValueStyle<Integer> ItemIcon = id -> {
            display.block();
            box.size(100, percent);
            background.horizontal(id / (Item.size() - 1) * 100, percent)
                    .image(BackgroundImage.url("src/main/resources/teemowork/items.jpg").cover().borderBox().noRepeat());
        };

        static Style ItemEmptyIcon = () -> {
            display.block();
            box.size(100, percent);
        };

        static Style ItemIconBox = () -> {
            box.size(ItemIconSize);
            padding.size(3, px);
        };
    }
}
