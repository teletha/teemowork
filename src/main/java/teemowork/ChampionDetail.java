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

import java.util.List;

import js.dom.User;
import jsx.style.BinaryStyle;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.TypeStyle;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.StructureDSL;
import jsx.ui.Widget;
import jsx.ui.piece.UI;
import kiss.Events;
import kiss.I;
import kiss.Ⅱ;
import teemowork.ChampionDetail.Styles;
import teemowork.model.Build;
import teemowork.model.Champion;
import teemowork.model.DescriptionView;
import teemowork.model.Item;
import teemowork.model.Skill;
import teemowork.model.SkillDescriptor;
import teemowork.model.SkillKey;
import teemowork.model.SkillType;
import teemowork.model.Status;
import teemowork.model.StatusCalculator;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2015/10/18 21:57:55
 */
public class ChampionDetail extends Widget<Styles> {

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV, AR, MR, MS, Range,
            Tenacity};

    /** The your custom build. */
    private final Build build;

    /** Up skill level. */
    public final Events<Skill> skillUp = when(User.Click).at($.IconBox).sideEffect(updateView);

    /** Down skill level. */
    public final Events<Skill> skillDown = when(User.ClickRight).at($.IconBox, Skill.class).sideEffect(updateView);

    /** Up champion level. */
    public final Events<Champion> championLevelUp = when(User.Click, User.MouseWheelUp).at($.ChampionIconBox).sideEffect(updateView);

    /** Down champion level. */
    public final Events<Champion> championLevelDown = when(User.ClickRight, User.MouseWheelDown).at($.ChampionIconBox)
            .sideEffect(updateView);

    /** The item selection. */
    private final Events<Ⅱ<Integer, Item>> selectItem = UI.modal()
            .open(when(User.Click).at($.ItemIconBase, Integer.class))
            .show(ItemCatalog.class)
            .closeWhen(items -> items.selectItem)
            .map(c -> I.pair(c.ⅰ, c.ⅲ))
            .sideEffect(updateView);

    /**
     * 
     */
    public ChampionDetail(Build build) {
        this.build = build;

        championLevelUp.to(build::championLevelUp);
        championLevelDown.to(build::championLevelDown);
        skillUp.to(build::levelUp);
        skillDown.to(build::levelDown);
        selectItem.to(v -> build.setItem(v.ⅰ, v.ⅱ));
    }

    /**
     * @version 2016/09/25 13:58:55
     */
    private class View extends StructureDSL {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            box($.UpperInfo, () -> {
                box($.ChampionIconBox.of(build.champion), () -> {
                    text($.Level, build.getLevel());
                });
                box($.ItemViewBox, contents(0, 6, index -> {
                    box($.ItemIconBase, () -> {
                        Item item = build.getItem(index);

                        if (item != null) {
                            box($.ItemIcon.of(item.position));
                        }
                    });
                }));
            });

            box($.Container, () -> {
                box($.StatusViewBox, contents(VISIBLE, status -> {
                    box($.StatusBox, () -> {
                        text($.StatusName, status);
                        text($.StatusValue, computeStatusValue(status));
                    });
                }));

                box($.SkillTable, contents(build.champion.skills, skill -> {
                    box($.SkillRow, () -> {
                        box($.IconBox, () -> {
                            box($.SkillIcon.of(skill));

                            if (skill.key != SkillKey.Passive) {
                                box($.LevelBox, contents(skill.getMaxLevel(), level -> {
                                    box($.LevelMark.of(level < build.getLevel(skill)));
                                }));
                            }
                        });

                        box($.VBox, () -> {
                            SkillDescriptor status = skill.getDescriptor(build.getVersion());
                            box($.HBox, () -> {
                                text($.Name, skill);
                                text($.VersionDisplay, status.version.name);
                            });
                            box(() -> {
                                writeStatusValue(skill, status, status.getRange());
                                writeStatusValue(skill, status, status.getCooldown());
                                writeStatusValue(skill, status, status.getCost());
                            });

                            if (!status.getPassive().isEmpty()) {
                                box($.Text, () -> {
                                    text($.SkillTypeInfo, SkillType.Passive);
                                    widget(new SkillWidget(skill, build, status.getPassive()));
                                });
                            }

                            if (!status.getActive().isEmpty()) {
                                box($.Text, () -> {
                                    text($.SkillTypeInfo, status.getType());
                                    widget(new SkillWidget(skill, build, status.getActive()));
                                });
                            }
                        });
                    });
                }));
            });
        }

        /**
         * <p>
         * Write skill related status.
         * </p>
         * 
         * @param root A element to write.
         * @param descriptor A current processing skill.
         * @param variable A target skill variable.
         */
        private void writeStatusValue(Skill skill, SkillDescriptor descriptor, Variable variable) {
            if (variable != null) {
                box($.StatusBlock, () -> {
                    Status status = variable.getStatus();
                    VariableResolver resolver = variable.getResolver();

                    int level = build.getLevel(skill);

                    if (!resolver.isSkillLevelBased()) {
                        level = resolver.convertLevel(build);
                    }

                    // write label
                    String label = status.getName();

                    if (status != Range && status != CD) {
                        if (descriptor.getType() == SkillType.Toggle) {
                            label = "毎秒" + label;
                        } else if (descriptor.getType() == SkillType.ToggleForAttack) {
                            label = "攻撃毎" + label;
                        }
                    }

                    text($.StatusLabel, label);

                    // write values
                    int size = resolver.estimateSize();
                    int current = level;

                    box(contents(1, size, i -> {
                        double value = status.round(variable.calculate(i, build, true));
                        String desc = resolver.getLevelDescription(i);

                        box($.Value, If(size != 1 && i == current, $.Current), If(desc, title(desc), $.Indicator), () -> {
                            text(value == -1 ? "∞" : value);
                        });
                    }));

                    // write amplifiers
                    writeAmplifier(variable.getAmplifiers(), 0, build);

                    // write unit
                    text(status.getUnit());
                });
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
        public void writeAmplifier(List<Variable> amplifiers, int level, StatusCalculator calculator) {
            if (!amplifiers.isEmpty()) {
                box($.Amplifiers, contents(amplifiers, amplifier -> {
                    box($.Amplifier, () -> {
                        int amp = level;

                        text("+", amplifier.getStatus());

                        VariableResolver resolver = amplifier.getResolver();

                        if (!resolver.isSkillLevelBased()) {
                            amp = resolver.convertLevel(calculator);
                        }

                        int estimated = resolver.estimateSize();
                        int size = estimated == 0 ? amplifier.getAmplifiers().isEmpty() ? 0 : 1 : estimated;
                        int current = amp;

                        box(contents(1, size, i -> {
                            String description = resolver.getLevelDescription(i);

                            box($.Value, If(size != 1 && i == current, $.Current), If(description, title(description), $.Indicator), () -> {
                                text(round(amplifier.calculate(i, calculator, true), 4));
                            });
                        }));

                        text(amplifier.getStatus().name().endsWith("Ratio") ? "%" : "");
                        if (!amplifier.getAmplifiers().isEmpty()) {
                            text("(");
                            writeAmplifier(amplifier.getAmplifiers(), current, calculator);
                            text(")");
                        }
                    });
                }));
            }
        }

    }

    /**
     * <p>
     * Returns the closest {@code long} to the argument, with ties rounding up.
     * </p>
     * <p>
     * Special cases:
     * <ul>
     * <li>If the argument is NaN, the result is 0.</li>
     * <li>If the argument is negative infinity or any value less than or equal to the value of
     * {@code Long.MIN_VALUE}, the result is equal to the value of {@code Long.MIN_VALUE}.</li>
     * <li>If the argument is positive infinity or any value greater than or equal to the value of
     * {@code Long.MAX_VALUE}, the result is equal to the value of {@code Long.MAX_VALUE}.</li>
     * </ul>
     * 
     * @param value A floatingpoint value to be rounded.
     * @param precision
     * @return The value of the argument rounded to the nearest {@code int} value.
     */
    private static double round(double value, int precision) {
        double factor = Math.pow(10, precision);
        return Math.round(value * factor) / factor;
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
     * @version 2015/08/23 2:42:26
     */
    private class SkillWidget extends DescriptionView<Skill> {

        /**
         * @param describable
         * @param calculator
         * @param model3
         */
        private SkillWidget(Skill describable, StatusCalculator calculator, List model3) {
            super(describable, calculator, model3);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return build.getLevel(describable);
        }
    }

    /**
     * @version 2015/08/20 15:49:48
     */
    static class Styles extends StyleDSL {

        /** The skill icon size. */
        int SkillIconSize = 45;

        /** The level box height. */
        int LevelBoxHeight = 5;

        Style UpperInfo = () -> {
            display.flex().alignItems.end();
            margin.bottom(1, em);
        };

        Style StatusLabel = () -> {
            margin.right(0.2, em);
        };

        Style StatusBlock = () -> {
            font.size.smaller();
            display.inlineBlock();
            margin.right(0.8, em);
        };

        Style Value = () -> {
            display.opacity(0.7);

            not(lastChild(), () -> {
                after(() -> {
                    content.text("/");
                    font.color(210, 210, 210);
                    margin.horizontal(1, px);
                });
            });
        };

        Style SkillTable = () -> {
            display.block();
            flexItem.basis(100, percent);
        };

        Style Container = () -> {
            display.flex();
        };

        Style SkillRow = () -> {
            display.flex();
            margin.bottom(1, em);
        };

        ValueStyle<Skill> SkillIcon = skill -> {
            display.block().size(SkillIconSize, px);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            background.image(BackgroundImage.url(skill.getIcon()).horizontal(skill.getIconPosition()).cover().borderBox().noRepeat());
        };

        Style LevelBox = () -> {
            display.width(SkillIconSize, px).height(LevelBoxHeight + 2, px).flex();
            border.width(1, px).solid().color(Color.Black);
            border.left.none();
            margin.top(2, px).bottom(5, px);
        };

        BinaryStyle LevelMark = state -> {
            display.block().height(LevelBoxHeight, px);
            flexItem.grow(1);
            border.left.solid().color(Color.Black).width(1, px);
            background.image(BackgroundImage.of(linear(rgba(240, 192, 28, state ? 1 : 0.5), rgba(160, 123, 1, state ? 1 : 0.5))));
        };

        TypeStyle<Skill> IconBox = () -> {
            display.verticalBox();
            margin.right(SkillIconSize / 5, px);
            cursor.pointer();
            flexItem.shrink(0);
        };

        Style Name = () -> {
            margin.right(0.5, em);
            font.weight.bold();
        };

        Style VersionDisplay = () -> {
            font.color(rgb(200, 200, 200)).size.smaller();
            flexItem.alignSelf.end();
        };

        Style Text = () -> {
            display.block();
            margin.top(0.3, em).bottom(0.7, em);
            line.height(140, percent);
            font.size.smaller();
        };

        Style Indicator = () -> {
            cursor.help();
        };

        Style Current = () -> {
            font.color(rgba(160, 123, 1, 1));
        };

        Style SkillTypeInfo = () -> {
            margin.right(1, em);
        };

        Numeric ChampionIconSize = new Numeric(70, Unit.px);

        ValueStyle<Champion> ChampionIconBox = champion -> {
            display.size(ChampionIconSize).flex();
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            cursor.pointer();
            position.relative();
            background.image(champion.getIcon()).horizontal(champion.getIconPosition());
        };

        Style Level = () -> {
            display.block().size(22, px);
            font.size(20, px).color(240, 240, 240).weight.bold().family("Arial");
            text.align.center().unselectable().outline(rgb(240, 240, 240), 0.8);
            position.absolute().bottom(4, px).right(4, px);
            cursor.pointer();
        };

        Style StatusViewBox = () -> {
            display.block().width(13, em);
            flexItem.shrink(0);
            font.size.small();
        };

        Style StatusBox = () -> {
            display.flex();
            margin.bottom(4, px);
        };

        Style StatusName = () -> {
            display.width(9.5, em);
        };

        Style StatusValue = () -> {
            display.width(50, px);
        };

        Numeric ItemIconSize = ChampionIconSize.divide(5).multiply(3);

        Style ItemViewBox = () -> {
            display.width(ItemIconSize.multiply(6)).flex();
            margin.left(100, px);
        };

        Style ItemIconBase = () -> {
            display.block().size(ItemIconSize);
            background.image(BackgroundImage.url("src/main/resources/teemowork/empty.png").contain().noRepeat());
            padding.size(3, px);
            cursor.pointer();
        };

        ValueStyle<Integer> ItemIcon = id -> {
            display.block().size(100, percent);
            background.horizontal(id / (Item.all().size() - 1) * 100, percent)
                    .image(BackgroundImage.url("src/main/resources/teemowork/items.jpg").cover().borderBox().noRepeat());
        };

        Style Variable = () -> {
            font.color(90, 90, 90);
        };

        Style Amplifiers = () -> {
            prev().with(Variable, () -> {
                margin.left(0.4, em);
            });
        };

        Style Amplifier = () -> {
            font.color(25, 111, 136);
            display.opacity(0.8);

            not(firstChild(), () -> {
                margin.left(0.4, em);
            });
        };
    }
}
