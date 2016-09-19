/*
 * Copyright (C) 2016 Teemowork Development Team
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
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import js.dom.Element;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import kiss.Decoder;
import kiss.Encoder;
import kiss.I;
import teemowork.UserPreference;
import teemowork.api.RiotChampionData;

/**
 * @version 2015/10/15 14:33:11
 */
public class Champion extends RiotChampionData {

    /** The counter for id. */
    private static int counter = 0;

    /** The champion id. */
    public final int id;

    /** The riot champion id. */
    public final int key;

    /** The name. */
    private final String name;

    /** The localized name. */
    private final String localized;

    /** The normalized skillSystem name. */
    private final String systemName;

    /** The skill set. */
    public final Skill[] skills = new Skill[5];

    /** The skill. */
    public final Skill P;

    /** The skill. */
    public final Skill Q;

    /** The skill. */
    public final Skill W;

    /** The skill. */
    public final Skill E;

    /** The skill. */
    public final Skill R;

    /** The descriptor. */
    private final ChampionStatus[] versions = new ChampionStatus[Version.values().length];

    /** The transformed champion. */
    private Optional<Champion> transformed = Optional.empty();

    /**
     * <p>
     * Create new champion.
     * </p>
     */
    public Champion(int key, String name, String localized, String system, float hp, float hpPer, float hreg, float hregPer, float mp, float mpPer, float mreg, float mregPer, float ad, float adPer, float as, float asPer, float crit, float critPer, float ar, float arPer, float mr, float mrPer, float ms, float range, String[] skillNames, String[] skillLocalized, SkillDefinition skillDefinition, boolean transformed) {
        this.id = counter++;
        this.key = key;

        for (int i = 0; i < skills.length; i++) {
            this.skills[i] = new Skill(skillNames[i], skillLocalized[i], system, i);
        }

        this.P = this.skills[0];
        this.Q = this.skills[1];
        this.W = this.skills[2];
        this.E = this.skills[3];
        this.R = this.skills[4];

        if (!transformed) {
            champions.add(this);
        } else {
            getByName(system.substring(0, system.length() - 11)).transformed = Optional.of(this);
        }

        this.name = name;
        this.localized = localized;
        this.systemName = system;

        this.update(Version.Latest)
                .set(Health, hp, hpPer)
                .set(Hreg, hreg, hregPer)
                .set(Mana, mp, mpPer)
                .set(Mreg, mreg, mregPer)
                .set(AD, ad, adPer)
                .set(AS, as, asPer)
                .set(Critical, crit, critPer)
                .set(AR, ar, arPer)
                .set(MR, mr, mrPer)
                .set(MS, ms)
                .set(Range, range);

        // expose this instance, so we must call at last
        skillDefinition.define(this, P, Q, W, E, R);
    }

    /**
     * <p>
     * Returns skillSystem name.
     * </p>
     * 
     * @return
     */
    public String getSystemName() {
        return name.replace("\\.", "").replace("\\s", "").replace("\\'", "");
    }

    /**
     * <p>
     * Pattern natch against this champion name.
     * </p>
     * 
     * @param name A name pattern.
     * @return A result.
     */
    public boolean match(String name) {
        return name == null || name.length() == 0 || systemName.toLowerCase().contains(name.toLowerCase()) || localized.contains(name);
    }

    /**
     * <p>
     * Returns the name of this champion.
     * </p>
     * 
     * @return A champion name.
     */
    public String getName() {
        return I.make(UserPreference.class).localeChampion.getValue() == Locale.ENGLISH ? name : localized;
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/champions.jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public Numeric getIconPosition() {
        return new Numeric(id / (counter - 1) * 100, Unit.percent);
    }

    /**
     * <p>
     * Apply icon image.
     * </p>
     */
    public void applyIcon(Element element) {
        element.css("background-image", "url(src/main/resources/teemowork/champions.jpg)")
                .css("background-position", id / (counter - 1) * 100 + "% 0%")
                .css("background-size", "cover")
                .css("background-origin", "border-box");
    }

    /**
     * <p>
     * Retrieve the alternate version of this {@link Champion}.
     * </p>
     * 
     * @return
     */
    public Optional<Champion> getTransformed() {
        return transformed;
    }

    /**
     * <p>
     * Retrieve a descriptor at the specified version.
     * </p>
     */
    public ChampionStatus getStatus(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ChampionStatus status = versions[i];

            if (status != null) {
                return status;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @param version A update version.
     * @return A champion descriptor.
     */
    ChampionStatus update(Version version) {
        ChampionStatus status = new ChampionStatus(getStatus(version));
        versions[version.ordinal()] = status;

        return status;
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
     * List up all champions.
     * </p>
     * 
     * @return
     */
    public static List<Champion> getAll() {
        return champions;
    }

    /**
     * <p>
     * List up all champions.
     * </p>
     * 
     * @return
     */
    public static List<Champion> getAll(Comparator<Champion> sorter) {
        List<Champion> list = new ArrayList<>(champions);
        list.sort(sorter);

        return list;
    }

    /**
     * <p>
     * Find champion by name.
     * </p>
     * 
     * @param name A champion name.
     * @return A matched champion.
     */
    public static Champion getByName(String name) {
        for (Champion champion : getAll()) {
            if (champion.systemName.equals(name)) {
                return champion;
            }
        }
        return null;
    }

    /**
     * <p>
     * Find champion by riot key.
     * </p>
     * 
     * @param name A champion key.
     * @return A matched champion.
     */
    public static Champion getByKey(int key) {
        for (Champion champion : getAll()) {
            if (champion.key == key) {
                return champion;
            }
        }
        return null;
    }

    /**
     * @version 2015/08/18 14:39:56
     */
    @SuppressWarnings("unused")
    private static class Codec implements Decoder<Champion>, Encoder<Champion> {

        /**
         * {@inheritDoc}
         */
        @Override
        public Champion decode(String value) {
            return Champion.getByName(value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String encode(Champion value) {
            return value.systemName;
        }
    }
}
