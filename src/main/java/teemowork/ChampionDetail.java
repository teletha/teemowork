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
import static jsx.ui.Declarables.*;
import static teemowork.model.Status.*;

import jsx.style.BinaryStyle;
import jsx.style.Style;
import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import kiss.Events;
import teemowork.model.Build;
import teemowork.model.Champion;
import teemowork.model.DescriptionView;
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
public class ChampionDetail extends Widget1<Build> {

    private static final CSS $ = new CSS();

    /** The displayable status. */
    private static final Status[] VISIBLE = {Health, Hreg, Mana, Mreg, AD, ARPen, AS, LS, Critical, AP, MRPen, CDR, SV, AR, MR, MS, Range,
            Tenacity};

    /** The your custom build. */
    private final Build build = model1;

    public final Events<Champion> levelUp = when(Click, $.ChampionIconBox).merge(when(MouseWheelUp, $.ChampionIconBox));

    public final Events<Champion> levelDown = when(ClickRight, $.ChampionIconBox).merge(when(MouseWheelDown, $.ChampionIconBox));

    public final Events<Skill> skillUp = when(Click, $.IconBox, Skill.class);

    public final Events<Skill> skillDown = when(ClickRight, $.IconBox, Skill.class);

    public ChampionDetail() {
        levelUp.to(v -> build.levelUp());
        levelDown.to(v -> build.levelDown());
        skillUp.to(v -> build.levelUp(v));
        skillDown.to(v -> build.levelDown(v));

        // TODO FIXME
        when(Key_R, $.ChampionIconBox).to(e -> {
            build.active(SkillKey.R);
            build.active(SkillKey.W);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize2() {
        box($.UpperInfo, () -> {
            box($.ChampionIconBox.of(build.champion), () -> {
                text($.Level, build.getLevel());
            });
            box($.ItemViewBox, contents(ItemBoxWidget.class, build.items));
        });

        box($.Container, () -> {
            box($.StatusViewBox, contents(VISIBLE, status -> {
                box($.StatusBox, () -> {
                    text($.StatusName, status.name());
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
                                widget(Widget.of(SkillWidget.class, skill, build, status.getPassive()));
                            });
                        }

                        if (!status.getActive().isEmpty()) {
                            box($.Text, () -> {
                                text($.SkillTypeInfo, status.getType());
                                widget(Widget.of(SkillWidget.class, skill, build, status.getActive()));
                            });
                        }
                    });
                });
            }));
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
                String label = status.name;

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
                    double value = status.round(variable.calculate(i, build));
                    String desc = resolver.getLevelDescription(i);

                    box($.Value, If(size != 1 && i == current, $.Current), If(desc, title(desc), $.Indicator), () -> {
                        text(value == -1 ? "∞" : value);
                    });
                }));

                // write amplifiers
                DescriptionView.writeAmplifier(variable.getAmplifiers(), 0, build);

                // write unit
                text(status.getUnit());
            });
        }
    }

    /**
     * @version 2015/09/18 13:28:55
     */
    private static class ItemBoxWidget extends Widget1<Item> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize2() {
            box($.ItemIconBase, () -> {
                if (model1 != null) {
                    box($.ItemIcon.of(model1.position));
                }
            });
        }
    }

    /**
     * @version 2015/08/23 2:42:26
     */
    private class SkillWidget extends DescriptionView<Skill> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected int getLevel() {
            return build.getLevel(model1);
        }
    }

    /**
     * @version 2015/08/20 15:49:48
     */
    private static class CSS extends StyleDescriptor {

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
            box.opacity(0.7);

            notLastChild(() -> {
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
            display.block();
            box.size(SkillIconSize, px);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            background.image(BackgroundImage.url(skill.getIcon()).horizontal(skill.getIconPosition()).cover().borderBox().noRepeat());
        };

        Style LevelBox = () -> {
            display.flex();
            box.width(SkillIconSize, px).height(LevelBoxHeight + 2, px);
            border.width(1, px).solid().color(Color.Black);
            border.left.none();
            margin.top(2, px).bottom(5, px);
        };

        BinaryStyle LevelMark = state -> {
            display.block();
            flexItem.grow(1);
            box.height(LevelBoxHeight, px);
            border.left.solid().color(Color.Black).width(1, px);
            background.image(BackgroundImage.of(linear(rgba(240, 192, 28, state ? 1 : 0.5), rgba(160, 123, 1, state ? 1 : 0.5))));
        };

        Style IconBox = () -> {
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
            display.flex();
            box.size(ChampionIconSize);
            border.radius(10, px).color(rgb(50, 50, 50)).width(2, px).solid();
            cursor.pointer();
            position.relative();
            background.image(champion.getIcon()).horizontal(champion.getIconPosition());

        };

        Style Level = () -> {
            display.block();
            box.size(22, px);
            font.size(20, px).color(240, 240, 240).weight.bold().family("Arial");
            text.align.center().unselectable().outline(rgb(240, 240, 240), 0.8);
            position.absolute().bottom(4, px).right(4, px);
            cursor.pointer();
        };

        Style StatusViewBox = () -> {
            display.block();
            box.width(13, em);
            flexItem.shrink(0);
        };

        Style StatusBox = () -> {
            display.flex();
            margin.bottom(4, px);
        };

        Style StatusName = () -> {
            box.width(5, em);
        };

        Style StatusValue = () -> {
            box.width(50, px);
        };

        Numeric ItemIconSize = ChampionIconSize.divide(5).multiply(3);

        Style ItemViewBox = () -> {
            display.flex();
            box.width(ItemIconSize.multiply(6));
            margin.left(137, px);
        };

        Style ItemIconBase = () -> {
            display.block();
            box.size(ItemIconSize);
            background.image(BackgroundImage.url("src/main/resources/teemowork/empty.png").contain().noRepeat());
            padding.size(3, px);
        };

        ValueStyle<Integer> ItemIcon = id -> {
            display.block();
            box.size(100, percent);
            background.horizontal(id / (Item.size() - 1) * 100, percent)
                    .image(BackgroundImage.url("src/main/resources/teemowork/items.jpg").cover().borderBox().noRepeat());
        };
    }
}
