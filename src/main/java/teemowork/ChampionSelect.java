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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SetProperty;

import js.dom.User;
import jsx.style.BinaryStyle;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.ui.LowLevelWidget;
import jsx.ui.ModelValue;
import jsx.ui.ViewDSL;
import jsx.ui.Widget;
import jsx.ui.piece.Input;
import jsx.ui.piece.UI;
import kiss.I;
import teemowork.ChampionSelect.Styles;
import teemowork.model.Champion;
import teemowork.model.Skill;
import teemowork.model.SkillDescriptor;
import teemowork.model.Status;
import teemowork.model.Version;
import teemowork.model.variable.Variable;

/**
 * @version 2015/10/15 19:26:07
 */
public class ChampionSelect extends Widget<Styles> {

    /** The skill filters. */
    private final FilterGroup[] groups = {
            new FilterGroup("ダメージ", type(Status.PhysicalDamage), type(Status.MagicDamage), type(Status.TrueDamage), type("範囲攻撃", Status.Radius)),
            new FilterGroup("参照", referSelf(Status.Health, Status.HealthRatio, Status.BounusHealth, Status.BaseHealth), referSelf(Status.Mana, Status.ManaRatio, Status.BounusMana), referSelf(Status.AD, Status.ADRatio, Status.BounusAD, Status.BaseAD), referSelf(Status.AP, Status.APRatio), referSelf(Status.AR, Status.ARRatio, Status.BounusAR), referSelf(Status.MR, Status.MRRatio, Status.BounusMR), referSelf(Status.MS, Status.MSRatio, Status.BounusMS), referSelf(Status.CurrentHealthRatio), referSelf(Status.CurrentManaRatio), referSelf(Status.MissingHealthRatio), referSelf(Status.MissingManaRatio), referSelf(Status.MissingHealthPercentage), referSelf(Status.MissingManaPercentage), addReferEnemy(Status.TargetMaxHealthRatio), addReferEnemy(Status.TargetCurrentHealthRatio), addReferEnemy(Status.TargetBounusHealthRatio), addReferEnemy(Status.TargetMissingHealthRatio), addReferEnemy(Status.TargetAP)),
            new FilterGroup("Buff", type(Status.Health, Status.HealthRatio), type(Status.Mana, Status.ManaRatio), type(Status.AD, Status.ADRatio), type(Status.AP, Status.APRatio), type(Status.AR, Status.ARRatio), type(Status.MR, Status.MRRatio), type(Status.MS, Status.MSRatio), type(Status.AS, Status.ASRatio), type(Status.CDR, Status.CDRRatio), type(Status.LS, Status.LSRatio), type(Status.SV, Status.SVRatio), type(Status.ARPen, Status.ARPenRatio, Status.ARReduction, Status.ARReductionRatio), type(Status.MRPen, Status.MRPenRatio, Status.MRReduction, Status.MRReductionRatio), type(Status.Shield, Status.PhysicalShield, Status.MagicShield), type("スキル無効", Status.SpellShield), type(Status.IgnoreDamage), type(Status.IgnoreCC, Status.RemoveCC), type(Status.IgnoreSlow), type(Status.IgnoreUnitCollision)),
            new FilterGroup("Debuff", type(Status.MSSlow, Status.MSSlowRatio, Status.Slow, Status.SlowRatio), type(Status.ASSlow, Status.ASSlowRatio, Status.Slow, Status.SlowRatio), type(Status.Stun), type(Status.Snare), type(Status.Taunt), type(Status.Knockback), type(Status.Knockup), type(Status.Charm), type(Status.Fear), type(Status.Terrified), type(Status.Suppression), type(Status.Suspension), type(Status.Silence), type(Status.Blind)),
            new FilterGroup("回復", type(Status.RestoreHealth, Status.RestoreHealthRatio, Status.Hreg, Status.HregPerLv, Status.HregRatio), type(Status.RestoreMana, Status.Mreg, Status.MregPerLv, Status.MregRatio), type(Status.RestoreEnergy, Status.EnergyPerLv, Status.EnergyRatio)),
            new FilterGroup("その他", type("AAタイマー解消", Status.ResetAATimer), type("オンヒット効果", Status.OnHitEffect), type("CD解消", Status.CDDecrease, Status.CDDecreaseRatio, Status.CD), type(Status.Visionable), type(Status.Stasis), type(Status.Untargetable), type("移動", Status.Blink, Status.BlinkExchange, Status.Dash), type("移動(要対象)", Status.BlinkTarget, Status.DashTarget)),
            new FilterGroup("ステータス", status(Status.MS))};

    /** The name filter. */
    private final Input input = UI.input().placeholder("Champion Name").style($.SearchByName);

    /** The list of active filters. */
    private final @ModelValue SetProperty<SkillFilter> activeFilters = I.make(SetProperty.class);

    /** The view state of filters. */
    private final @ModelValue BooleanProperty showSkillFilters = when(User.Click).at($.FilterBySkill).toBinary();

    /** The view state of filters. */
    private final @ModelValue BooleanProperty showChampionFilters = when(User.Click).at($.FilterByChampion).toBinary();

    /** The view state of sorts. */
    private final @ModelValue BooleanProperty showSkillSorts = when(User.Click).at($.SortBySkill).toBinary();

    /** The list of active sorts. */
    private final @ModelValue SetProperty<SkillFilter> activeSorts = I.make(SetProperty.class);

    private final Comparator<Champion> sorter = (one, other) -> {
        double sumOne = sumRate(one, Status.AP);
        double sumOther = sumRate(other, Status.AP);

        return sumOne == sumOther ? 0 : sumOne < sumOther ? 1 : -1;
    };

    private double sumRate(Champion champion, Status status) {
        double sum = 0;

        for (Skill skill : champion.skills) {
            SkillDescriptor descriptor = skill.getDescriptor(Version.Latest);

            List list = new ArrayList();
            list.addAll(descriptor.getPassive());
            list.addAll(descriptor.getActive());

            for (Object text : list) {
                if (text instanceof Variable) {
                    Variable variable = (Variable) text;

                    switch (variable.getStatus()) {
                    case PhysicalDamage:
                    case MagicDamage:
                    case TrueDamage:
                    case Shield:
                    case MagicShield:
                        for (Variable v : variable.getAmplifiers()) {
                            if (v.getStatus() == status) {
                                sum += variable.getResolver().compute(1);
                            }
                        }
                        break;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 
     */
    public ChampionSelect(Teemowork application) {
        when(User.Click).at($.Container, Champion.class).to(name -> application.champion(name));
    }

    /**
     * @version 2016/09/25 13:58:55
     */
    private class View extends ViewDSL {

        private Predicate<Champion> bySkill = champion -> {
            if (activeFilters.isEmpty()) {
                return true;
            }

            for (SkillFilter filter : activeFilters) {
                if (!filter.filter.test(champion)) {
                    return false;
                }
            }
            return true;
        };

        private Predicate<Champion> byName = champion -> {
            String name = input.value.get();

            if (name == null || name.isEmpty()) {
                return true;
            }
            return champion.match(name);
        };

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {

            box($.Root, () -> {
                box($.Filters, input, () -> {
                    text($.FilterBySkill, "スキルで絞込");
                    // text($.FilterByChampion, "チャンピオンで絞込");
                    box($.SkillFilters.of(showSkillFilters), contents(groups, group -> {
                        box($.Group, () -> {
                            text($.GroupName, group.name);
                            box($.GroupItems, contents(group.filters, filter -> {
                                widget(filter.createUI(activeFilters).style($.Filter));
                            }));
                        });
                    }));
                    // box($.SkillFilters, If(showChampionFilters, $.ShowDetailFilter),
                    // contents(groups,
                    // group -> {
                    // box($.Group, () -> {
                    // text($.GroupName, group.name);
                    // box($.GroupItems, contents(group.filters, filter -> {
                    // widget(UI.checkbox(activeFilters, filter, filter.name).style($.Filter));
                    // }));
                    // });
                    // }));
                });
                box($.ImageSet, contents(Champion.list(bySkill.and(byName)), champion -> {
                    box($.Container, () -> {
                        box($.IconImage, $.IconPosition.of(champion));
                        text($.Title, champion);
                    });
                }));
            });
        }
    }

    /**
     * <p>
     * Sort by conditions.
     * </p>
     * 
     * @param champion
     * @return
     */
    private boolean sort(Champion champion) {
        if (activeSorts.isEmpty()) {
            return true;
        }

        for (SkillFilter filter : activeSorts) {
            if (!filter.filter.test(champion)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static SkillFilter type(Status... statuses) {
        return type(statuses[0].getName(), statuses);
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static SkillFilter type(String name, Status... statuses) {
        return new SkillFilter(name, champion -> {
            Info info = Info.of(champion);

            for (Status status : statuses) {
                if (info.types.contains(status)) {
                    return true;
                }
            }
            return false;
        });
    }

    private static SkillFilter status(Status status) {
        return new SkillFilter(status.name(), champion -> {
            return true;
        });
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static SkillFilter referSelf(Status... statuses) {
        return referSelf(statuses[0].getName(), statuses);
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static SkillFilter referSelf(String name, Status... statuses) {
        return new SkillFilter("自身の" + name, champion -> {
            Info info = Info.of(champion);

            for (Status status : statuses) {
                if (info.amplifiers.contains(status)) {
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static SkillFilter addReferEnemy(Status... statuses) {
        return addReferEnemy(statuses[0].getName(), statuses);
    }

    /**
     * <p>
     * Add filter.
     * </p>
     * 
     * @param statuses
     * @return
     */
    private static SkillFilter addReferEnemy(String name, Status... statuses) {
        return new SkillFilter(name, champion -> {
            Info info = Info.of(champion);

            for (Status status : statuses) {
                if (info.amplifiers.contains(status)) {
                    return true;
                }
            }
            return false;
        });
    }

    /**
     * @version 2015/10/08 21:55:46
     */
    private static class FilterGroup {

        /** The group name. */
        private String name;

        /** The managed filters. */
        private SkillFilter[] filters;

        /**
         * @param name
         * @param filters
         */
        private FilterGroup(String name, SkillFilter... filters) {
            this.name = name;
            this.filters = filters;
        }
    }

    /**
     * @version 2015/10/07 1:37:07
     */
    private static class SkillFilter {

        /** The filter name. */
        final String name;

        /** The actual filter. */
        final Predicate<Champion> filter;

        /**
         * @param name
         * @param filter
         */
        SkillFilter(String name, Predicate<Champion> filter) {
            this.name = name;
            this.filter = filter;
        }

        /**
         * @param activeFilters
         * @return
         */
        LowLevelWidget createUI(SetProperty<SkillFilter> activeFilters) {
            return UI.checkbox(activeFilters, this, name);
        }

    }

    /**
     * @version 2015/11/02 11:00:44
     */
    private static class SelectFilter extends SkillFilter {

        /**
         * @param name
         * @param filter
         */
        SelectFilter(String name, Predicate<Champion> filter) {
            super(name, filter);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        LowLevelWidget createUI(SetProperty<SkillFilter> activeFilters) {
            return UI.checkbox(activeFilters, this, name);
        }
    }

    /**
     * @version 2015/10/15 14:41:35
     */
    private static class Info {

        /** The cache. */
        private static final Map<Champion, Info> infos = new HashMap();

        /** The status index. */
        private final Set<Status> types = new HashSet();

        /** The status index. */
        private final Set<Status> amplifiers = new HashSet();

        /**
         * @param champion
         */
        private Info(Champion champion) {
            parse(champion);
        }

        /**
         * <p>
         * Helper method to parse champion status.
         * </p>
         * 
         * @param champion
         */
        private void parse(Champion champion) {
            for (Skill skill : champion.skills) {
                SkillDescriptor descriptor = skill.getDescriptor(Version.Latest);

                parse(descriptor.getPassive());
                parse(descriptor.getActive());
            }
            champion.getTransformed().ifPresent(this::parse);
        }

        /**
         * <p>
         * Helper method to parse status.
         * </p>
         * 
         * @param tokens
         */
        private void parse(List tokens) {
            for (Object token : tokens) {
                if (token instanceof Variable) {
                    Variable variable = (Variable) token;
                    Status status = variable.getStatus();
                    types.add(status);

                    List<Variable> amplifiers = variable.getAmplifiers();

                    for (Variable amplifier : amplifiers) {
                        this.amplifiers.add(amplifier.getStatus());
                    }
                }
            }
        }

        /**
         * <p>
         * Retrieve {@link Info} for the specified champion.
         * </p>
         * 
         * @param champion
         * @return
         */
        private static Info of(Champion champion) {
            return infos.computeIfAbsent(champion, Info::new);
        }
    }

    /**
     * @version 2015/01/30 14:32:48
     */
    static class Styles extends StyleDSL {

        private static final Color backColor = new Color(0, 10, 10);

        private static final Numeric ImageSize = new Numeric(60, px);

        private static final Numeric ImagesSize = ImageSize.multiply(11);

        Style Root = () -> {
            display.block().width(ImagesSize.add(2));
            margin.auto();
        };

        Style ImageSet = () -> {
            display.inlineFlex().direction.row().wrap.enable();
            border.top.solid().width(2, px).color(backColor);
            border.left.solid().width(2, px).color(backColor);
        };

        Style Unselected = () -> {
            display.none();
        };

        Style Container = () -> {
            position.relative();
            display.block();
        };

        Style IconImage = () -> {
            display.block().size(ImageSize);
            border.bottom.solid().width(2, px).color(backColor);
            border.right.solid().width(2, px).color(backColor);
            cursor.pointer();
            background.image("src/main/resources/teemowork/champions.jpg").cover().borderBox();

            after(() -> {
                content.text("");
                display.block().width(100, percent).height(100, percent).opacity(1);
                position.absolute();

                background.color(hsla(0, 100, 100, 0.2));

                transit().duration(0.2, s).easeInOut().when().hover(() -> {
                    display.opacity(0);
                });
            });
        };

        ValueStyle<Champion> IconPosition = chmapion -> {
            background.horizontal(chmapion.getIconPosition());
        };

        Style Title = () -> {
            Numeric boxWidth = ImageSize.add(40);
            Color color = new Color(0, 98, 97, 1);

            font.weight.bold().size(12, px);
            text.align.center();
            line.height(14, px);
            padding.size(5, px);
            background.image(BackgroundImage.of(linear(color.opacify(-0.4), color)));
            position.absolute().left(50, percent).bottom(ImageSize.add(20));
            margin.left(boxWidth.divide(-2));
            display.minWidth(boxWidth).zIndex(1).opacity(0);
            border.width(4, px).solid().color(color.lighten(-100)).radius(5, px);
            pointerEvents.none();

            // createBottomBubble(7);
            createBottomBubble(7, new Numeric(4, px), color.lighten(-100), color);

            transit().duration(0.2, s).delay(100, ms).easeInOut().when().prev().hover(() -> {
                display.opacity(1);
                position.bottom(ImageSize);
            });
        };

        Style SearchByName = () -> {

        };

        Style Filters = () -> {
            display.block();
            margin.bottom(10, px);
        };

        BinaryStyle SkillFilters = show -> {
            margin.top(1, em);
            font.size.smaller();

            if (show) {
                display.block();
            } else {
                display.none();
            }
        };

        Style FilterBy = () -> {
            font.size.small().color(Color.rgb(100, 100, 100));
            text.verticalAlign.bottom().unselectable();
            margin.left(1, em);
            cursor.pointer();
        };

        Style FilterBySkill = FilterBy.with(() -> {
        });

        Style SortBySkill = FilterBy.with(() -> {
        });

        Style FilterByChampion = FilterBy.with(() -> {
        });

        Style Group = () -> {
            display.block();
            margin.bottom(0.8, em);
        };

        Style GroupName = () -> {
            display.block();
            font.weight.bold();
            margin.bottom(0.4, em);
        };

        Style GroupItems = () -> {
            display.flex().wrap.enable();
        };

        Style Filter = () -> {
            display.width(ImagesSize.divide(4));
        };
    }
}
