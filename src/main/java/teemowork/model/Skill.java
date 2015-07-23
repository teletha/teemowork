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

import static teemowork.api.RiotChampionData.*;
import static teemowork.model.SkillKey.*;

import java.util.function.Consumer;

import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2015/07/21 16:42:24
 */
public class Skill extends Describable<SkillDescriptor> {

    /** The skill data. */
    private final String name;

    /** The skill data. */
    private final String localized;

    /** The owner champion. */
    private final String owner;

    /** The icon position. */
    private final Numeric iconPosition;

    /** The skill key type. */
    public final SkillKey key;

    /**
     * The skill definition.
     */
    public Skill(String name, String localized, String owner, int id, int size) {
        this.name = name;
        this.localized = localized;
        this.owner = owner;
        this.iconPosition = new Numeric(id / (size - 1) * 100, Unit.percent);
        this.key = SkillKey.values()[id < 5 ? id : id - 4];
    }

    /**
     * The skill definition.
     */
    public Skill(String name, String localized, String owner, int id, int size, Consumer<SkillDescriptor> definition) {
        this.name = name;
        this.localized = localized;
        this.owner = owner;
        this.iconPosition = new Numeric(id / (size - 1) * 100, Unit.percent);
        this.key = SkillKey.values()[id < 5 ? id : id - 4];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SkillDescriptor createDescriptor(Version version, SkillDescriptor previous) {
        return new SkillDescriptor(this, previous, version);
    }

    /**
     * <p>
     * Retrieve the skill name.
     * </p>
     * 
     * @return A name of this skill.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/skill/" + owner + ".jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public Numeric getIconPosition() {
        return iconPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * <p>
     * Returns minimum skill level.
     * </p>
     * 
     * @return
     */
    public int getMinLevel() {
        if (key == Passive || this == Karma.R) {
            return 1;
        }

        if (key == R && (owner.startsWith("Elise") || owner.startsWith("Jayce") || owner.startsWith("Karma"))) {
            return 1;
        }
        return 0;
    }

    /**
     * <p>
     * Returns maximum skill level.
     * </p>
     * 
     * @return
     */
    @Override
    public int getMaxLevel() {
        if (key == Passive) {
            return 0;
        }

        if (key == R) {
            switch (owner) {
            case "Elise":
            case "EliseTransformed":
            case "Jayce":
            case "JayceTransformed":
            case "Karma":
                return 4;

            case "Udyr":
                break;

            default:
                return 3;
            }
        }

        if (owner.equals("NidaleeTransoformed")) {
            return 3;
        }
        return 5;
    }
}
