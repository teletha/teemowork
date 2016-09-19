/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.variable;

import teemowork.model.Skill;
import teemowork.model.StatusCalculator;

/**
 * @version 2013/02/12 10:33:59
 */
public abstract class VariableResolver {

    /**
     * <p>
     * Compute value by skill level.
     * </p>
     * 
     * @param level A target skill level to compute.
     * @return A computed value.
     */
    public abstract double compute(int level);

    /**
     * <p>
     * Retrieve the size of associated variable.
     * </p>
     * 
     * @return
     */
    public abstract int estimateSize();

    /**
     * <p>
     * Check whether this variable relies on skill level or not.
     * </p>
     * 
     * @return
     */
    public boolean isSkillLevelBased() {
        return true;
    }

    /**
     * Compute champion level as human readable text.
     * 
     * @param skillLevel
     * @return
     */
    public String getLevelDescription(int skillLevel) {
        if (isSkillLevelBased()) {
            return "";
        }
        return "Champion Level " + convertChampionLevel(skillLevel);
    }

    /**
     * <p>
     * Compute champion level from skill level.
     * </p>
     * 
     * @param skillLevel
     * @return
     */
    protected int convertChampionLevel(int skillLevel) {
        return -1;
    }

    /**
     * <p>
     * Compute skill level.
     * </p>
     * 
     * @return
     */
    public int convertLevel(StatusCalculator calculator) {
        return 0;
    }

    /**
     * @version 2013/02/12 13:10:53
     */
    public static class PerLevel extends VariableResolver {

        /** The level pattern. */
        public final int[] levels;

        /** The values. */
        private final double[] values;

        /**
         * @param base
         * @param diff
         */
        public PerLevel(double base, double diff) {
            this(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, base, diff);
        }

        /**
         * @param levels
         * @param base
         * @param diff
         */
        public PerLevel(int[] levels, double base, double diff) {
            this.levels = levels;
            this.values = new double[levels.length];

            for (int i = 0; i < levels.length; i++) {
                this.values[i] = base + diff * i;
            }
        }

        /**
         * @param levels
         * @param values
         */
        public PerLevel(int[] levels, double... values) {
            this.levels = levels;
            this.values = values;
        }

        /**
         * @param values
         */
        public PerLevel(double... values) {
            this(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, values);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return levels.length;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return values[skillLevel - 1];
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected int convertChampionLevel(int skillLevel) {
            return levels[skillLevel - 1];
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int convertLevel(StatusCalculator calculator) {
            int level = calculator.getLevel();

            for (int i = 0; i < levels.length; i++) {
                if (level < levels[i]) {
                    return i;
                }
            }
            return levels.length;
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per6Level extends PerLevel {

        /**
         * @param values
         */
        public Per6Level(double base, double diff) {
            super(new int[] {1, 7, 13}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per5Level extends PerLevel {

        /**
         * @param values
         */
        public Per5Level(double base, double diff) {
            super(new int[] {1, 6, 11, 16}, base, diff);
        }

        /**
         * @param values
         */
        public Per5Level(double... values) {
            super(new int[] {1, 6, 11, 16}, values);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per4Level extends PerLevel {

        /**
         * @param values
         */
        public Per4Level(double base, double diff) {
            super(new int[] {1, 5, 9, 13, 17}, base, diff);
        }
    }

    /**
     * @version 2013/02/12 11:37:34
     */
    public static class Per3Level extends PerLevel {

        /**
         * @param values
         */
        public Per3Level(double base, double diff) {
            super(new int[] {1, 4, 7, 10, 13, 16}, base, diff);
        }
    }

    /**
     * @version 2013/11/28 23:05:56
     */
    public static class Per2Level extends PerLevel {

        /**
         * @param values
         */
        public Per2Level(double base, double diff) {
            super(new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17}, base, diff);
        }
    }

    /**
     * @version 2015/09/02 22:52:13
     */
    public static class PerSkillLevel extends VariableResolver {

        /** The fixed values. */
        private final double[] values;

        /**
         * @param values
         */
        public PerSkillLevel(double... values) {
            this.values = values;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return skillLevel == 0 ? 0 : values[skillLevel - 1];
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return values.length;
        }
    }

    /**
     * @version 2015/09/02 22:57:51
     */
    public static class PerReferedSkillLevel extends PerSkillLevel {

        /** The referenced skill. */
        public final Skill reference;

        /**
         * @param reference
         * @param base
         * @param diff
         */
        public PerReferedSkillLevel(Skill reference, double... values) {
            super(values);

            this.reference = reference;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int convertLevel(StatusCalculator calculator) {
            return calculator.getLevel(reference);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getLevelDescription(int skillLevel) {
            return reference + " Level " + skillLevel;
        }
    }

    /**
     * @version 2015/09/02 22:56:34
     */
    public static class BardChimes extends PerSkillLevel {

        /** The fixed values. */
        private final int[] number;

        /**
         * @param values
         */
        public BardChimes(int[] number, double[] values) {
            super(values);
            this.number = number;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getLevelDescription(int skillLevel) {
            return "取得した鐘の数 " + number[skillLevel - 1] + "個";
        }
    }

    /**
     * @version 2015/09/02 22:56:31
     */
    public static class PerChampion extends PerSkillLevel {

        /**
         * @param values
         */
        public PerChampion(double... values) {
            super(values);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getLevelDescription(int skillLevel) {
            return "敵チャンピオン" + skillLevel + "人";
        }
    }

    /**
     * @version 2013/02/15 13:05:53
     */
    public static class Diff extends VariableResolver {

        /** The base value of amplifier rate. */
        private final double base;

        /** The diff value of amplifier rate. */
        private final double diff;

        /** The variable size. */
        private final int size;

        /**
         * @param base
         * @param diff
         * @param size
         */
        public Diff(double base, double diff, int size) {
            this.base = base;
            this.diff = diff;
            this.size = size;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public double compute(int skillLevel) {
            return base + diff * (skillLevel - 1);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int estimateSize() {
            return base == 0 ? 0 : diff == 0 ? 1 : size;
        }
    }

    /**
     * @version 2013/03/28 23:27:41
     */
    public static class Refer extends Diff {

        /** The referenced skill. */
        public final Skill reference;

        /**
         * @param reference
         * @param base
         * @param diff
         */
        public Refer(Skill reference, double base, double diff) {
            super(base, diff, reference.getMaxLevel());

            this.reference = reference;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int convertLevel(StatusCalculator calculator) {
            return calculator.getLevel(reference);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getLevelDescription(int skillLevel) {
            return reference + " Level " + skillLevel;
        }
    }

    /**
     * @version 2015/07/24 18:23:21
     */
    public static class ReferPlus extends Diff {

        /** The referenced skill. */
        public final Skill reference;

        /**
         * @param reference
         * @param base
         * @param diff
         */
        public ReferPlus(Skill reference, double base, double diff) {
            super(base, diff, reference.getMaxLevel() + 1);

            this.reference = reference;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isSkillLevelBased() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int convertLevel(StatusCalculator calculator) {
            return calculator.getLevel(reference) + 1;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getLevelDescription(int skillLevel) {
            return reference + " Level " + (skillLevel - 1);
        }
    }
}
