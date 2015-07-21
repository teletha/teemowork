/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import icy.manipulator.Icy;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2015/06/08 0:29:05
 */
@Icy
public abstract class IcyBuildModel implements StatusCalculator {

    public Version version;

    public Champion champion;

    public int level;

    public int skillQLevel;

    public int skillWLevel;

    public int skillELevel;

    public int skillRLevel;

    public boolean skillQActive;

    public boolean skillWActive;

    public boolean skillEActive;

    public boolean skillRActive;

    public Item item1;

    public Item item2;

    public Item item3;

    public Item item4;

    public Item item5;

    public Item item6;

    /** The first cache for computed value. */
    private final List<Computed> cache = new ArrayList(Status.values().length);

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculate(Status status) {
        return get(status).value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel(Skill skill) {
        return computeSkillLevel(skill);
    }

    /**
     * <p>
     * Compute build status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    public Computed get(Status status) {
        switch (status) {
        case BaseAD:
            return new Computed(0, get(AD).base, status);

        case Lv:
            return new Computed(level, level, Lv);

        case DealtDamageRatio:
        case Tenacity:
            return new Computed(base(status), sum(status), status);

        case MissingManaPercentage:
        case MissingHealthPercentage:
        case MissingHealthRatio:
        case MissingManaRatio:
        case TargetAP:
        case TargetMaxHealthRatio:
        case TargetCurrentHealthRatio:
        case TargetMissingHealthRatio:
        case TargetMissingHealthPercentage:
        case AttackDamageRatio:
        case CurrentManaRatio:
        case Stack:
        case StackPercentage:
        case ConsumedStack:
        case Duration:
        case Energy:
        case Ereg:
        case EnemyChampion:
        case Time:
        case Value:
        case Distance:
        case DealtDamage:
            return new Computed(0, 0, status);

        case BounusAD:
            return new Computed(0, get(AD).increased, status);

        case BounusAR:
            return new Computed(0, get(AR).increased, status);

        case BounusMR:
            return new Computed(0, get(MR).increased, status);

        case BounusHealth:
            return new Computed(0, get(Health).increased, status);

        case BounusMS:
            return new Computed(0, get(MS).increased, status);

        case MS:
            double baseMS = base(status);
            double computedMS = (baseMS + sum(status) + sum(MSPerLv) * level) * (1 + sum(MSRatio) / 100);

            // calcurate movement speed cap
            if (490 < computedMS) {
                computedMS = computedMS * 0.5 + 230;
            } else if (415 < computedMS) {
                computedMS = computedMS * 0.8 + 83;
            } else if (computedMS < 220) {
                computedMS = computedMS * 0.5 + 110;
            }
            return new Computed(baseMS, computedMS, status);

        case AS:
            double baseAS = champion.getStatus(version).get(AS);
            double levelAS = champion.getStatus(version).get(ASPerLv) * (level - 1);

            return new Computed(baseAS * (1 + levelAS / 100), Math
                    .min(2.5, baseAS * (1 + (levelAS + sum(ASRatio)) / 100)), status);

        default:
            double base = base(status);
            double computed = (base + sum(status) + sum(status.per()) * level) * (1 + sum(status.ratio()) / 100);

            return new Computed(base, computed, status);
        }
    }

    /**
     * <p>
     * Compute champion base status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    private double base(Status status) {
        switch (status) {
        case MSRatio:
        case Energy:
        case Ereg:
        case DealtDamageRatio:
            return champion.getStatus(version).get(status);

        default:
            double value = champion.getStatus(version)
                    .get(status) + champion.getStatus(version).get(status.per()) * level;

            if (champion == Champion.EliseTransformed) {
                value += computeVariable(status, Champion.Elise.R);
            }

            if (champion == Champion.NidaleeTransformed) {
                value += computeVariable(status, Champion.Nidalee.R);
            }

            if (champion == Champion.Jayce) {
                value += computeVariable(status, Champion.Janna.R);
            }
            return value;
        }
    }

    /**
     * <p>
     * Compute status from skill variable.
     * </p>
     * 
     * @param status A target status.
     * @param skill A target skill.
     * @return A calcurated value.
     */
    private double computeVariable(Status status, Skill skill) {
        double value = 0;
        int level = computeSkillLevel(skill);

        if (0 < level) {
            SkillDescriptor skillStatus = skill.getDescriptor(version);

            for (Object token : skillStatus.getActive()) {
                if (token instanceof Variable) {
                    Variable variable = (Variable) token;

                    if (variable.getStatus() == status) {
                        value += calculateVariable(skill, variable, computeSkillLevel(skill));
                    }
                }
            }
        }

        // API definition
        return value;
    }

    /**
     * <p>
     * Compute skill variable value by using this build.
     * </p>
     * 
     * @param skill A current processing skill.
     * @param variable A current processing variable.
     * @param level A current skill level.
     * @return
     */
    public double calculateVariable(Skill skill, Variable variable, int level) {
        // avoid circular dependency
        if (DependencyManager.use(skill)) {
            return 0;
        }

        double value = variable.calculate(level, this);

        // avoid circular dependency
        DependencyManager.unuse(skill);

        // API definition
        return value;
    }

    /**
     * <p>
     * Compute sum of the specified improvements.
     * </p>
     * 
     * @param improvementType A target type.
     * @return A sum value.
     */
    private double sum(Status status) {
        if (status == null) {
            return 0;
        }

        double sum = 0;

        // ===================================
        // Item
        // ===================================
        Set<String> names = new HashSet();

        for (int i = 0; i < 6; i++) {
            Item item = computeItem(i);

            if (item != null) {
                ItemDescriptor itemDescriptor = item.getDescriptor(version);

                // compute item status
                sum = status.compute(sum, itemDescriptor.get(status));

                for (Ability ability : itemDescriptor.getAbilities()) {
                    AbilityDescriptor abilityDescriptor = ability.getDescriptor(version);

                    if (abilityDescriptor.isUnique() && !names.add(ability.name)) {
                        continue;
                    }

                    // compute ability status
                    sum = status.compute(sum, sum(abilityDescriptor.getPassive(), status));
                }
            }
        }

        // ===================================
        // Skill
        // ===================================
        for (int i = 0; i < champion.skills.length; i++) {
            Skill skill = champion.skills[i];
            SkillDescriptor skillStatus = skill.getDescriptor(version);

            // form passive
            sum = status.compute(sum, sum(skillStatus.getPassive(), skill, status));

            // from active
            if (computeSkillActive(i)) {
                sum = status.compute(sum, sum(skillStatus.getActive(), skill, status));
            }
        }
        return sum;
    }

    /**
     * <p>
     * Compute sum value from the specified skill variables.
     * </p>
     * 
     * @param tokens A descriptor tokens.
     * @param skill A current processing skill.
     * @param status A target status.
     * @return A computed value.
     */
    private double sum(List tokens, Status status) {
        double sum = 0;

        for (Object token : tokens) {
            if (token instanceof Variable) {
                Variable variable = (Variable) token;
                Status variableStatus = variable.getStatus();

                if (variableStatus == status && !variable.isConditional()) {
                    sum = variableStatus.compute(sum, variable.calculate(1, this));
                }
            }
        }
        return sum;
    }

    /**
     * <p>
     * Compute sum value from the specified skill variables.
     * </p>
     * 
     * @param tokens A descriptor tokens.
     * @param skill A current processing skill.
     * @param status A target status.
     * @return A computed value.
     */
    private double sum(List tokens, Skill skill, Status status) {
        double sum = 0;

        for (Object token : tokens) {
            if (token instanceof Variable) {
                Variable variable = (Variable) token;
                Status variableStatus = variable.getStatus();

                if (variableStatus == status && !variable.isConditional()) {
                    VariableResolver resolver = variable.getResolver();
                    int level = resolver.isSkillLevelBased() ? getLevel(skill) : resolver.convertLevel(this);

                    if (level != 0) {
                        sum = variableStatus.compute(sum, calculateVariable(skill, variable, level));
                    }
                }
            }
        }
        return sum;
    }

    private int computeSkillLevel(Skill skill) {
        switch (skill.key) {
        case Q:
            return skillQLevel;

        case W:
            return skillWLevel;

        case E:
            return skillELevel;

        case R:
        default:
            return skillRLevel;
        }
    }

    private boolean computeSkillActive(int skill) {
        switch (skill) {
        case 0:
            return skillQActive;
        case 1:
            return skillWActive;
        case 2:
            return skillEActive;

        case 3:
        default:
            return skillRActive;
        }
    }

    private Item computeItem(int item) {
        switch (item) {
        case 0:
            return item1;
        case 1:
            return item2;
        case 2:
            return item3;
        case 3:
            return item4;
        case 4:
            return item5;

        case 5:
        default:
            return item6;
        }
    }

    /**
     * @version 2013/01/25 13:42:02
     */
    public class Computed {

        /** The champion base value. */
        public final double base;

        /** The computed value. */
        public final double value;

        /** The increased value. */
        public final double increased;

        /**
         * @param base A base value.
         * @param value A computed value.
         */
        private Computed(double base, double value, Status status) {
            this.base = status.round(base);
            this.value = status.round(value);
            this.increased = status.round(value - base);

            cache.set(status.ordinal(), this);
        }

        /**
         * <p>
         * Retrieve computed value as String expression.
         * </p>
         * 
         * @return A computed value.
         */
        public String value() {
            return String.valueOf(value);
        }

        /**
         * <p>
         * Retrieve base value as String expression.
         * </p>
         * 
         * @return A base value.
         */
        public String base() {
            return String.valueOf(base);
        }

        /**
         * <p>
         * Retrieve increased value as String expression.
         * </p>
         * 
         * @return A increased value.
         */
        public String increased() {
            return String.valueOf(increased);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return value();
        }
    }
}
