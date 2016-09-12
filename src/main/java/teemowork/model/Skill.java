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

import java.util.Locale;

import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import kiss.I;
import teemowork.UserPreference;

/**
 * @version 2016/09/12 21:46:26
 */
public class Skill extends Describable<SkillDescriptor> {

    /** The user settings. */
    private static final UserPreference preference = I.make(UserPreference.class);

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
    public Skill(String name, String localized, String owner, int id) {
        this.name = name;
        this.localized = localized;
        this.owner = owner;
        this.iconPosition = new Numeric(id / 4 * 100, Unit.percent);
        this.key = SkillKey.values()[id];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SkillDescriptor createDescriptor(Version version) {
        return new SkillDescriptor(this, version);
    }

    /**
     * <p>
     * Retrieve the skill name.
     * </p>
     * 
     * @return A name of this skill.
     */
    public String getName() {
        return preference.localeSkill.getValue() == Locale.ENGLISH ? name : localized;
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

        if (key == R && (owner.startsWith("Elise") || owner.startsWith("Jayce") || owner.startsWith("Nidalee") || owner
                .startsWith("Karma"))) {
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

        if (owner.equals("Ryze")) {
            if (key == Q) {
                return 6;
            }

            if (key == R) {
                return 2;
            }
        }

        if (key == R) {
            switch (owner) {
            case "Elise":
            case "EliseTransformed":
            case "Jayce":
            case "JayceTransformed":
            case "Nidalee":
            case "NidaleeTransformed":
            case "Karma":
                return 4;

            case "Udyr":
                break;

            default:
                return 3;
            }
        }
        return 5;
    }
}
