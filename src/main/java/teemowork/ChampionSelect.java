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

import static jsx.ui.StructureDescriptor.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.UIAction;
import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import jsx.ui.piece.CheckBox;
import jsx.ui.piece.Input;
import jsx.ui.piece.Select;
import jsx.ui.piece.UI;
import kiss.Events;
import kiss.I;
import teemowork.model.Champion;
import teemowork.model.Skill;
import teemowork.model.Status;
import teemowork.model.Version;

/**
 * @version 2015/09/18 14:05:30
 */
public class ChampionSelect extends Widget {

    private final Teemowork application = I.make(Teemowork.class);

    private Input input = UI.input().placeholder("Champion Name").style($.SearchByName);

    public Events<Champion> selectChampion = when(UIAction.Click).at($.Container, Champion.class);

    /** The damage type filter. */
    private final SkillFilterGroup damage = new SkillFilterGroup("ダメージ", SkillFilter.PhysicalDamage, SkillFilter.MagicDamage, SkillFilter.TrueDamage, SkillFilter.AoE);

    /** The damage type filter. */
    private final SkillFilterGroup CC = new SkillFilterGroup("CC", SkillFilter.MSSlow, SkillFilter.ASSlow, SkillFilter.Stun, SkillFilter.Snare, SkillFilter.Knockback, SkillFilter.Knockup, SkillFilter.Charm, SkillFilter.Fear, SkillFilter.Terrified, SkillFilter.Suppression, SkillFilter.Suspension, SkillFilter.Silence, SkillFilter.Blind);

    /** The damage type filter. */
    private final SkillFilterGroup buff = new SkillFilterGroup("Buff", SkillFilter.Health, SkillFilter.Mana, SkillFilter.AD, SkillFilter.AP, SkillFilter.AR, SkillFilter.MR, SkillFilter.MS, SkillFilter.AS, SkillFilter.IgnoreCC, SkillFilter.IgnoreSlow, SkillFilter.IgnoreUnit);

    /** The damage type filter. */
    private final SkillFilterGroup restore = new SkillFilterGroup("回復", SkillFilter.RestoreHealth, SkillFilter.RestoreMana, SkillFilter.RestoreEnegy);

    /** The damage type filter. */
    private final SkillFilterGroup others = new SkillFilterGroup("その他", SkillFilter.AAReset, SkillFilter.Onhit, SkillFilter.CDR, SkillFilter.Visionable);

    private Select<SkillFilter> condition = UI.select(SkillFilter.class);

    /**
     * 
     */
    public ChampionSelect() {
        selectChampion.to(champion -> application.champion(champion));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        box($.Root, () -> {
            box($.Filters, input, () -> {
                text($.FilterDetail, "スキルで絞込");
                box($.SkillFilters, damage, buff, CC, restore, others);
            });
            box($.ImageSet, contents(Champion.getAll(), champion -> {
                box($.Container, If(!filterBySkill(champion), $.Unselected), () -> {
                    box($.IconImage, $.IconPosition.of(champion));
                    text($.Title, champion.name);
                });
            }));
        });
    }

    /**
     * <p>
     * Filter by skill description.
     * </p>
     * 
     * @param champion
     * @return
     */
    private boolean filterBySkill(Champion champion) {
        List<SkillFilter> requires = new ArrayList();

        for (SkillFilter condition : SkillFilter.values()) {
            if (condition.condition.get()) {
                requires.add(condition);
            }
        }

        if (requires.isEmpty()) {
            return true;
        }

        Set<Status> all = new HashSet();

        for (Skill skill : champion.skills) {
            all.addAll(skill.getDescriptor(Version.Latest).getAllStatusTypes());
        }

        for (SkillFilter condition : requires) {
            if (!condition.accpet(all)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @version 2015/10/05 14:12:22
     */
    private static class SkillFilterGroup extends Widget {

        /** A filter group name. */
        private final String name;

        /** The filter set. */
        private final SkillFilter[] filters;

        /**
         * @param name
         * @param filters
         */
        private SkillFilterGroup(String name, SkillFilter... filters) {
            this.name = name;
            this.filters = filters;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            box($.Group, () -> {
                text($.Name, name);

                box($.Items, contents(SkillFilterWidget.class, filters));
            });
        }

        /**
         * @version 2015/10/05 14:30:24
         */
        private static class $ extends StyleDescriptor {

            private static Style Group = () -> {
                display.block();
                margin.bottom(0.8, em);
            };

            private static Style Name = () -> {
                display.block();
                font.weight.bold();
                margin.bottom(0.4, em);
            };

            private static Style Items = () -> {

            };

        }

        /**
         * @version 2015/10/05 11:21:14
         */
        private static class SkillFilterWidget extends Widget1<SkillFilter> {

            /** The chech box. */
            private CheckBox check = UI.checkbox(model1.condition, model1.label).style($.Filter);

            /**
             * {@inheritDoc}
             */
            @Override
            protected void virtualize() {
                widget(check);
            }

            /**
             * @version 2015/10/05 14:31:07
             */
            private static class $ extends StyleDescriptor {

                private static Style Filter = () -> {
                    display.inlineFlex();
                    box.width(ChampionSelect.$.ImagesSize.divide(5));
                };
            }
        }
    }

    /**
     * @version 2015/09/30 22:23:36
     */
    private static enum SkillFilter {

        PhysicalDamage(Status.PhysicalDamage),

        MagicDamage(Status.MagicDamage),

        TrueDamage(Status.TrueDamage),

        AoE("範囲攻撃", Status.Radius),

        MSSlow(Status.MSSlow, Status.MSSlowRatio, Status.Slow, Status.SlowRatio),

        ASSlow(Status.ASSlow, Status.ASSlowRatio, Status.Slow, Status.SlowRatio),

        Stun(Status.Stun),

        Snare(Status.Snare),

        Knockup(Status.Knockup),

        Knockback(Status.Knockback),

        Charm(Status.Charm),

        Fear(Status.Fear),

        Terrified(Status.Terrified),

        Suppression(Status.Suppression),

        Suspension(Status.Suspension),

        Silence(Status.Silence),

        Blind(Status.Blind),

        Onhit("オンヒット効果", Status.OnHitEffect),

        AAReset("攻撃タイマー解消", Status.ResetAATimer),

        CDR("CD減少", Status.CDR, Status.CDRRatio, Status.CDDecrease, Status.CDDecreaseRatio),

        Visionable("視界確保", Status.Visionable),

        Health(Status.Health, Status.HealthRatio),

        Mana(Status.Mana, Status.ManaRatio),

        AD(Status.AD, Status.ADRatio),

        AP(Status.AP, Status.APRatio),

        AR(Status.AR, Status.ARRatio),

        MR(Status.MR, Status.MRRatio),

        MS("移動速度増加", Status.MS, Status.MSRatio),

        AS("攻撃速度増加", Status.AS, Status.ASRatio, Status.ASPerLv),

        IgnoreCC(Status.IgnoreCC),

        IgnoreSlow(Status.IgnoreSlow),

        IgnoreUnit(Status.IgnoreUnitCollision),

        RestoreHealth(Status.Health + "回復", Status.RestoreHealth, Status.RestoreHealthRatio, Status.Hreg, Status.HregPerLv,
                Status.HregRatio),

        RestoreMana(Status.Mana + "回復", Status.RestoreMana, Status.Mreg, Status.MregPerLv, Status.MregRatio),

        RestoreEnegy(Status.Energy + "回復", Status.RestoreEnergy, Status.EnergyPerLv, Status.EnergyRatio);

        /** The human-readable condition name. */
        private final StringProperty label;

        /** The actual conditions. */
        private final Status[] types;

        private BooleanProperty condition = new SimpleBooleanProperty();

        /**
         * <p>
         * Create Condition.
         * </p>
         * 
         * @param type
         */
        private SkillFilter(Status... types) {
            this(types[0].name, types);
        }

        /**
         * <p>
         * Create Condition.
         * </p>
         * 
         * @param label
         * @param types
         */
        private SkillFilter(String label, Status... types) {
            this.label = new SimpleStringProperty(label);
            this.types = types;
        }

        /**
         * @param all
         * @return
         */
        private boolean accpet(Set<Status> all) {
            for (Status type : types) {
                if (all.contains(type)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return label.get();
        }
    }

    /**
     * @version 2015/01/30 14:32:48
     */
    static class $ extends StyleDescriptor {

        private static final Color backColor = new Color(0, 10, 10);

        private static final Numeric ImageSize = new Numeric(70, px);

        private static final Numeric ImagesSize = ImageSize.multiply(10);

        private static Style Root = () -> {
            display.block();
            margin.auto();
            box.width(ImagesSize.add(2));
        };

        private static Style ImageSet = () -> {
            display.inlineFlex().direction.row().wrap.enable();
            border.top.solid().width(2, px).color(backColor);
            border.left.solid().width(2, px).color(backColor);
        };

        private static Style Container = () -> {
            position.relative();
            display.block();
        };

        private static Style Unselected = () -> {
            display.none();
        };

        private static Style IconImage = () -> {
            display.block();
            box.size(ImageSize);
            border.bottom.solid().width(2, px).color(backColor);
            border.right.solid().width(2, px).color(backColor);
            cursor.pointer();
            background.image("src/main/resources/teemowork/champions.jpg").cover().borderBox();

            after(() -> {
                content.text("");
                display.block();
                position.absolute();
                box.width(100, percent).height(100, percent).opacity(1);
                background.color(hsla(0, 100, 100, 0.2));

                transit().duration(0.2, s).easeInOut().whenHover(() -> {
                    box.opacity(0);
                });
            });
        };

        private static ValueStyle<Champion> IconPosition = chmapion -> {
            background.horizontal(chmapion.getIconPosition());
        };

        private static Style Title = () -> {
            Numeric boxWidth = ImageSize.add(40);
            Color color = new Color(0, 98, 97, 1);

            font.weight.bold().size(18, px);
            text.align.center();
            line.height(20, px);
            padding.size(5, px);
            background.image(BackgroundImage.of(linear(color.opacify(-0.4), color)));
            position.absolute().left(50, percent).bottom(ImageSize.add(20));
            margin.left(boxWidth.divide(-2));
            box.minWidth(boxWidth).zIndex(1).opacity(0);
            border.width(4, px).solid().color(color.lighten(-100)).radius(5, px);
            pointerEvents.none();

            // createBottomBubble(7);
            createBottomBubble(7, new Numeric(4, px), color.lighten(-100), color);

            transit().duration(0.2, s).delay(100, ms).easeInOut().whenSiblingHover(() -> {
                box.opacity(1);
                position.bottom(ImageSize);
            });
        };

        private static Style SearchByName = () -> {

        };

        private static Style Filters = () -> {
            display.block();
            margin.bottom(10, px);
        };

        private static Style SkillFilters = () -> {
            display.block();
            margin.top(1, em);
            font.size.smaller();
        };

        private static Style FilterDetail = () -> {
            font.size.small().color(Color.rgb(100, 100, 100));
            text.verticalAlign.bottom();
            margin.left(1, em);
            cursor.pointer();
        };
    }
}
