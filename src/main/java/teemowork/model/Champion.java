/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License"),
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;

import java.util.List;

import js.dom.Element;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import teemowork.api.RiotChampionData;

/**
 * @version 2015/07/22 2:20:21
 */
public class Champion extends RiotChampionData {

    /** The counter for id. */
    private static int counter = 0;

    /** The champion id. */
    public final int id;

    /** The name. */
    public final String name;

    /** The localized name. */
    public final String localized;

    /** The normalized skillSystem name. */
    public final String systemName;

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

    /**
     * <p>
     * Create new champion.
     * </p>
     * 
     * @param name
     */
    public Champion(String name, String localized, String system, float hp, float hpPer, float hreg, float hregPer, float mp, float mpPer, float mreg, float mregPer, float ad, float adPer, float as, float asPer, float crit, float critPer, float ar, float arPer, float mr, float mrPer, float ms, float range, String[] skillNames, String[] skillLocalized, SkillDefinition skillDefinition, boolean transformed) {
        this.id = counter++;

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
        return name != null && systemName.contains(name.toLowerCase());
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
        return name;
    }

    /**
     * <p>
     * List up all champions.
     * </p>
     * 
     * @return
     */
    public static List<Champion> getAll() {
        // if (champions.isEmpty()) {
        // Object o = new RiotChampionData();
        // }
        return champions;
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

    // /** The initialization state. */
    // private static boolean initialized;

    // /**
    // * Initialize {@link Skill}.
    // */
    // private static void initilaize() {
    // initialized = true;
    //
    // Aatrox.update(P0000)
    // .set(Health, 395, 85)
    // .set(Hreg, 5.75, 0.5)
    // .set(Mana, 0, 0)
    // .set(Mreg, 0, 0)
    // .set(AD, 55, 3.2)
    // .set(AS, 0.651, 3)
    // .set(AR, 18, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 150)
    // .set(MS, 345);
    // Ahri.update(P506)
    // .set(Health, 380, 80)
    // .set(Hreg, 5.5, 0.6)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 50, 3)
    // .set(AS, 0.668, 2)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Akali.update(P506)
    // .set(Health, 445, 85)
    // .set(Hreg, 7.25, 0.65)
    // .set(Energy, 200)
    // .set(Ereg, 50)
    // .set(AD, 53, 3.2)
    // .set(AS, 0.694, 3.1)
    // .set(AR, 20.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Alistar.update(P0000)
    // .set(Health, 442, 102)
    // .set(Hreg, 7.25, 0.85)
    // .set(Mana, 215, 38)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 55.03, 3.62)
    // .set(AS, 0.625, 3.62)
    // .set(AR, 18.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 325);
    // Amumu.update(P0000)
    // .set(Health, 472, 84)
    // .set(Hreg, 7.45, 0.85)
    // .set(Mana, 220, 40)
    // .set(Mreg, 6.5, 0.525)
    // .set(AD, 47, 3.8)
    // .set(AS, 0.638, 2.18)
    // .set(AR, 23.544, 3.3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Anivia.update(P0000)
    // .set(Health, 350, 70)
    // .set(Hreg, 4.65, 0.55)
    // .set(Mana, 257, 53)
    // .set(Mreg, 7.0, 0.6)
    // .set(AD, 48, 3.2)
    // .set(AS, 0.625, 1.68)
    // .set(AR, 17.22, 4)
    // .set(MR, 30, 0)
    // .set(Range, 600)
    // .set(MissileSpeed, 1400)
    // .set(MS, 325);
    // Annie.update(P0000)
    // .set(Health, 384, 76)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 49, 2.625)
    // .set(AS, 0.579, 1.36)
    // .set(AR, 12.5, 4)
    // .set(MR, 30, 0)
    // .set(Range, 625)
    // .set(MS, 335);
    // Ashe.update(P0000)
    // .set(Health, 395, 79)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 173, 35)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 46.3, 2.85)
    // .set(AS, 0.658, 3.34)
    // .set(AR, 11.5, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 600)
    // .set(MS, 325);
    // Ashe.update(P303).set(AS, 0.658, 4);
    // Blitzcrank.update(P0000)
    // .set(Health, 423, 95)
    // .set(Hreg, 7.25, 0.75)
    // .set(Mana, 200, 40)
    // .set(Mreg, 6.6, 0.5)
    // .set(AD, 55.66, 3.5)
    // .set(AS, 0.625, 1.13)
    // .set(AR, 14.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 325);
    // Brand.update(P0000)
    // .set(Health, 380, 76)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 51.66, 3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Caitlyn.update(P0000)
    // .set(Health, 390, 80)
    // .set(Hreg, 4.75, 0.55)
    // .set(Mana, 255, 35)
    // .set(Mreg, 6.5, 0.55)
    // .set(AD, 47, 3)
    // .set(AS, 0.668, 3)
    // .set(AR, 13, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 650)
    // .set(MS, 325);
    // Caitlyn.update(P307).set(AS, 0.625, 4);
    // Cassiopeia.update(P0000)
    // .set(Health, 380, 75)
    // .set(Hreg, 4.85, 0.5)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7.1, 0.75)
    // .set(AD, 47, 3.2)
    // .set(AS, 0.644, 1.68)
    // .set(AR, 11.5, 4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Chogath.update(P0000)
    // .set(Health, 440, 80)
    // .set(Hreg, 7.5, 0.85)
    // .set(Mana, 205, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 54.1, 4.2)
    // .set(AS, 0.625, 1.44)
    // .set(AR, 19, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Corki.update(P0000)
    // .set(Health, 375, 82)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 243, 37)
    // .set(Mreg, 6.5, 0.55)
    // .set(AD, 48.2, 3)
    // .set(AS, 0.658, 2.3)
    // .set(AR, 13.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Corki.update(P313).set(AS, 0.625, 2.3);
    // Darius.update(P0000)
    // .set(Health, 426, 93)
    // .set(Hreg, 8.25, 0.95)
    // .set(Mana, 200, 37.5)
    // .set(Mreg, 6, 0.35)
    // .set(AD, 50, 3.5)
    // .set(AS, 0.679, 2.6)
    // .set(AR, 20, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Diana.update(P0000)
    // .set(Health, 438, 90)
    // .set(Hreg, 7, 0.85)
    // .set(Mana, 230, 40)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 48, 3)
    // .set(AS, 0.625, 2.25)
    // .set(AR, 16, 3.6)
    // .set(MR, 30, 1.25)
    // .set(Range, 150)
    // .set(MS, 345);
    // DrMundo.update(P0000)
    // .set(Health, 433, 89)
    // .set(Hreg, 6.5, 0.75)
    // .set(AD, 56.23, 3)
    // .set(AS, 0.625, 2.8)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Draven.update(P0000)
    // .set(Health, 420, 82)
    // .set(Hreg, 5, 0.7)
    // .set(Mana, 240, 42)
    // .set(Mreg, 6.95, 0.65)
    // .set(AD, 46.5, 3.5)
    // .set(AS, 0.679, 2.6)
    // .set(AR, 16, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Elise.update(P0000)
    // .set(Health, 395, 80)
    // .set(Hreg, 4.7, 0.6)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 47.5, 3)
    // .set(AS, 0.625, 1.75)
    // .set(AR, 12.65, 3.35)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // EliseTransformed.update(P0000)
    // .set(Health, 395, 80)
    // .set(Hreg, 4.7, 0.6)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 47.5, 3)
    // .set(AS, 0.625, 1.75)
    // .set(AR, 12.65, 3.35)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // Evelynn.update(P0000)
    // .set(Health, 414, 86)
    // .set(Hreg, 6.95, 0.55)
    // .set(Mana, 180, 42)
    // .set(Mreg, 7.1, 0.6)
    // .set(AD, 48, 3.3)
    // .set(AS, 0.658, 3.84)
    // .set(AR, 12.5, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Ezreal.update(P0000)
    // .set(Health, 350, 80)
    // .set(Hreg, 5.5, 0.55)
    // .set(Mana, 235, 45)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 47.2, 3)
    // .set(AS, 0.625, 2.8)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // FiddleSticks.update(P0000)
    // .set(Health, 390, 80)
    // .set(Hreg, 4.6, 0.6)
    // .set(Mana, 251, 59)
    // .set(Mreg, 6.9, 0.65)
    // .set(AD, 45.95, 2.625)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 480)
    // .set(MS, 335);
    // Fiora.update(P0000)
    // .set(Health, 450, 85)
    // .set(Hreg, 6.3, 0.8)
    // .set(Mana, 220, 40)
    // .set(Mreg, 7.25, 0.5)
    // .set(AD, 54.5, 3.2)
    // .set(AS, 0.672, 3)
    // .set(AR, 15.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Fizz.update(P0000)
    // .set(Health, 414, 86)
    // .set(Hreg, 7.0, 0.7)
    // .set(Mana, 200, 40)
    // .set(Mreg, 6.15, 0.45)
    // .set(AD, 53, 3)
    // .set(AS, 0.658, 3.1)
    // .set(AR, 13, 3.4)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 335);
    // Galio.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 7.45, 0.75)
    // .set(Mana, 235, 50)
    // .set(Mreg, 7, 0.7)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 1.2)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // Gangplank.update(P0000)
    // .set(Health, 495, 81)
    // .set(Hreg, 4.25, 0.75)
    // .set(Mana, 215, 40)
    // .set(Mreg, 6.5, 0.7)
    // .set(AD, 54, 3)
    // .set(AS, 0.651, 2.75)
    // .set(AR, 16.5, 3.3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Garen.update(P0000)
    // .set(Health, 455, 96)
    // .set(Hreg, 7.5, 0.75)
    // .set(AD, 52.5, 3.5)
    // .set(AS, 0.625, 2.9)
    // .set(AR, 19, 2.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Gragas.update(P0000)
    // .set(Health, 434, 89)
    // .set(Hreg, 7.25, 0.85)
    // .set(Mana, 221, 47)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 55.78, 3.375)
    // .set(AS, 0.651, 2.05)
    // .set(AR, 16, 3.6)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 340);
    // Graves.update(P0000)
    // .set(Health, 410, 84)
    // .set(Hreg, 5.5, 0.7)
    // .set(Mana, 255, 40)
    // .set(Mreg, 6.75, 0.7)
    // .set(AD, 51, 3.1)
    // .set(AS, 0.625, 2.9)
    // .set(AR, 15, 3.2)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 330);
    // Hecarim.update(P0000)
    // .set(Health, 440, 95)
    // .set(Hreg, 8, 0.75)
    // .set(Mana, 210, 40)
    // .set(Mreg, 6.5, 0.6)
    // .set(AD, 56, 3.2)
    // .set(AS, 0.67, 2.5)
    // .set(AR, 16, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 345);
    // Heimerdinger.update(P0000)
    // .set(Health, 350, 75)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 240, 65)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 49.24, 3)
    // .set(AS, 0.625, 1.21)
    // .set(AR, 7, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Irelia.update(P0000)
    // .set(Health, 456, 90)
    // .set(Hreg, 7.5, 0.65)
    // .set(Mana, 230, 35)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 56, 3.3)
    // .set(AS, 0.665, 3.2)
    // .set(AR, 15, 3.75)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Janna.update(P0000)
    // .set(Health, 356, 78)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 302, 64)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 49, 2.95)
    // .set(AS, 0.625, 2.61)
    // .set(AR, 9, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 475)
    // .set(MS, 335);
    // JarvanIV.update(P0000)
    // .set(Health, 420, 90)
    // .set(Hreg, 7, 0.7)
    // .set(Mana, 235, 40)
    // .set(Mreg, 6, 0.45)
    // .set(AD, 50, 3.4)
    // .set(AS, 0.658, 2.5)
    // .set(AR, 14, 3)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 340);
    // Jax.update(P0000)
    // .set(Health, 463, 98)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 230, 35)
    // .set(Mreg, 6.4, 0.7)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 3.4)
    // .set(AR, 18, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Jayce.update(P0000)
    // .set(Health, 420, 90)
    // .set(Hreg, 6, 0.8)
    // .set(Mana, 240, 40)
    // .set(Mreg, 7, 0.7)
    // .set(AD, 46.5, 3.5)
    // .set(AS, 0.658, 3)
    // .set(AR, 12.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // JayceTransformed.update(P0000)
    // .set(Health, 420, 90)
    // .set(Hreg, 6, 0.8)
    // .set(Mana, 240, 40)
    // .set(Mreg, 7, 0.7)
    // .set(AD, 46.5, 3.5)
    // .set(AS, 0.658, 3)
    // .set(AR, 12.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 335);
    // Jinx.update(Version.P312)
    // .set(Health, 420, 80)
    // .set(Hreg, 5, 0.5)
    // .set(Mana, 170, 45)
    // .set(Mreg, 5, 1)
    // .set(AD, 50, 3)
    // .set(AS, 0.625, 1)
    // .set(AR, 13, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 325);
    // Jinx.update(P401).set(Health, 388, 82);
    // Karma.update(P0000)
    // .set(Health, 410, 86)
    // .set(Hreg, 4.7, 0.55)
    // .set(Mana, 240, 60)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 50, 3.3)
    // .set(AS, 0.625, 2.3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 425)
    // .set(MS, 335);
    // Karthus.update(P0000)
    // .set(Health, 390, 75)
    // .set(Hreg, 5.5, 0.55)
    // .set(Mana, 270, 61)
    // .set(Mreg, 6.5, 0.6)
    // .set(AD, 42.2, 3.25)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 450)
    // .set(MS, 335);
    // Kassadin.update(P0000)
    // .set(Health, 433, 78)
    // .set(Hreg, 6.95, 0.5)
    // .set(Mana, 230, 45)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 52.3, 3.9)
    // .set(AS, 0.638, 3.7)
    // .set(AR, 14, 3.2)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Kassadin.update(P313).set(MR, 30, 0);
    // Katarina.update(P0000)
    // .set(Health, 395, 83)
    // .set(Hreg, 6.95, 0.55)
    // .set(AD, 53, 3.2)
    // .set(AS, 0.658, 2.74)
    // .set(AR, 14.75, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Kayle.update(P0000)
    // .set(Health, 418, 93)
    // .set(Hreg, 7, 0.75)
    // .set(Mana, 255, 40)
    // .set(Mreg, 6.9, 0.525)
    // .set(AD, 53.3, 2.8)
    // .set(AS, 0.638, 2.5)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 0.75)
    // .set(Range, 125)
    // .set(MS, 335);
    // Kayle.update(P303).set(MR, 30, 0);
    // Kennen.update(P0000)
    // .set(Health, 403, 79)
    // .set(Hreg, 4.65, 0.65)
    // .set(Energy, 200)
    // .set(Ereg, 50)
    // .set(AD, 51.3, 3.3)
    // .set(AS, 0.69, 3.4)
    // .set(AR, 14, 3.75)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Kennen.update(P309).set(AD, 47.2, 3.3);
    // Khazix.update(P0000)
    // .set(Health, 430, 85)
    // .set(Hreg, 6.25, 0.75)
    // .set(Mana, 260, 40)
    // .set(Mreg, 6.75, 0.5)
    // .set(AD, 50, 3.1)
    // .set(AS, 0.665, 2.7)
    // .set(AR, 15, 3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // KogMaw.update(P0000)
    // .set(Health, 440, 84)
    // .set(Hreg, 5, 0.55)
    // .set(Mana, 295, 40)
    // .set(Mreg, 7.5, 0.7)
    // .set(AD, 46, 3)
    // .set(AS, 0.665, 2.65)
    // .set(AR, 13, 3.53)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 340);
    // Leblanc.update(P0000)
    // .set(Health, 390, 75)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 51, 3.1)
    // .set(AS, 0.625, 1.4)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 335);
    // Leblanc.update(Version.P310A).set(Hreg, 6.5, 0.55).set(AD, 51, 3.5);
    // LeeSin.update(P0000)
    // .set(Health, 428, 85)
    // .set(Hreg, 6.25, 0.7)
    // .set(Ereg, 200)
    // .set(Ereg, 50)
    // .set(AD, 55.8, 3.2)
    // .set(AS, 0.651, 3)
    // .set(AR, 16, 3.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Leona.update(P0000)
    // .set(Health, 430, 87)
    // .set(Hreg, 9, 0.85)
    // .set(Mana, 235, 40)
    // .set(Mreg, 8, 0.7)
    // .set(AD, 55, 3)
    // .set(AS, 0.625, 2.9)
    // .set(AR, 18, 3.1)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Lissandra.update(P0000)
    // .set(Health, 365, 84)
    // .set(Hreg, 6, 0.55)
    // .set(Mana, 220, 50)
    // .set(Mreg, 5, 0.4)
    // .set(AD, 48, 2.7)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 10, 3.7)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Lucian.update(P310A)
    // .set(Health, 390, 80)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 230, 41)
    // .set(Mreg, 6, 0.65)
    // .set(AD, 46, 3)
    // .set(AS, 0.638, 3.3)
    // .set(AR, 15, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Lucian.update(P312).set(Mreg, 7, 0.7);
    // Lulu.update(P0000)
    // .set(Health, 415, 82)
    // .set(Hreg, 6, 0.72)
    // .set(Mana, 200, 50)
    // .set(Mreg, 6, 0.6)
    // .set(AD, 44.4, 2.6)
    // .set(AS, 0.625, 2.2)
    // .set(AR, 9, 3.7)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Lulu.update(P306).set(Mana, 200, 55);
    // Lux.update(P0000)
    // .set(Health, 345, 79)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6, 0.6)
    // .set(AD, 50, 3.3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 8, 4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Lux.update(P3051).set(MS, 330);
    // Malphite.update(P0000)
    // .set(Health, 423, 90)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 215, 40)
    // .set(Mreg, 6.4, 0.55)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 3.4)
    // .set(AR, 18, 3.75)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Malzahar.update(P0000)
    // .set(Health, 380, 80)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 51.66, 3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Maokai.update(P0000)
    // .set(Health, 421, 90)
    // .set(Hreg, 7.25, 0.85)
    // .set(Mana, 250, 46)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 58, 3.3)
    // .set(AS, 0.694, 2.13)
    // .set(AR, 18, 4)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // MasterYi.update(P0000)
    // .set(Health, 444, 86)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 199, 36)
    // .set(Mreg, 6.5, 0.45)
    // .set(AD, 55.12, 3.1)
    // .set(AS, 0.679, 2.98)
    // .set(AR, 16.3, 3.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 355);
    // MasterYi.update(P310).set(Health, 444, 92).set(Mana, 180, 42).set(AR, 15, 3).set(AS, 0.679,
    // 2.75);
    // MasterYi.update(P310A).set(AS, 0.679, 2);
    // MissFortune.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 212, 38)
    // .set(Mreg, 6.95, 0.65)
    // .set(AD, 46.5, 3)
    // .set(AS, 0.658, 3.01)
    // .set(AR, 15, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Mordekaiser.update(P0000)
    // .set(Health, 421, 80)
    // .set(Hreg, 7.45, 0.55)
    // .set(AD, 51.7, 3.5)
    // .set(AS, 0.694, 3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Morgana.update(P0000)
    // .set(Health, 403, 86)
    // .set(Hreg, 4.7, 0.6)
    // .set(Mana, 240, 60)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 51.58, 3.5)
    // .set(AS, 0.579, 1.53)
    // .set(AR, 15, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 425)
    // .set(MS, 335);
    // Morgana.update(P313).set(Range, 450).set(AS, 0.625, 1.53);
    // Nami.update(P0000)
    // .set(Health, 365, 74)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 305, 43)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 48, 3.1)
    // .set(AS, 0.644, 2.6)
    // .set(AR, 9, 4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340)
    // .set(MissileSpeed, 1350);
    // Nami.update(P307).set(MissileSpeed, 1500);
    // Nasus.update(P0000)
    // .set(Health, 410, 90)
    // .set(Hreg, 7.5, 0.9)
    // .set(Mana, 200, 45)
    // .set(Mreg, 6.6, 0.5)
    // .set(AD, 53.3, 3.5)
    // .set(AS, 0.638, 3.48)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Nautilus.update(P0000)
    // .set(Health, 432, 86)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 200, 50)
    // .set(Mreg, 7.45, 0.7)
    // .set(AD, 52, 3.3)
    // .set(AS, 0.613, 0.98)
    // .set(AR, 12, 3.25)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 325);
    // Nautilus.update(P3051).set(AR, 19, 3.25);
    // Nidalee.update(P0000)
    // .set(Health, 370, 90)
    // .set(Hreg, 5.0, 0.6)
    // .set(Mana, 220, 45)
    // .set(Mreg, 7, 0.5)
    // .set(AD, 49, 3.5)
    // .set(AS, 0.672, 3.22)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0.75)
    // .set(Range, 525)
    // .set(MS, 335);
    // Nidalee.update(P303).set(MR, 30, 0);
    // NidaleeTransformed.update(P0000)
    // .set(Health, 370, 90)
    // .set(Hreg, 5.0, 0.6)
    // .set(Mana, 220, 45)
    // .set(Mreg, 7, 0.5)
    // .set(AD, 49, 3.5)
    // .set(AS, 0.672, 3.22)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0.75)
    // .set(Range, 125)
    // .set(MS, 335);
    // NidaleeTransformed.update(P303).set(MR, 30, 0);
    // Nocturne.update(P0000)
    // .set(Health, 430, 85)
    // .set(Hreg, 7, 0.75)
    // .set(Mana, 215, 35)
    // .set(Mreg, 6, 0.45)
    // .set(AD, 54, 3.1)
    // .set(AS, 0.668, 2.7)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Nunu.update(P0000)
    // .set(Health, 437, 108)
    // .set(Hreg, 7.05, 0.8)
    // .set(Mana, 213, 42)
    // .set(Mreg, 6.6, 0.5)
    // .set(AD, 51.6, 3.4)
    // .set(AS, 0.625, 2.25)
    // .set(AR, 16.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Nunu.update(P309).set(Health, 437, 96);
    // Olaf.update(P0000)
    // .set(Health, 441, 93)
    // .set(Hreg, 7, 0.9)
    // .set(Mana, 225, 45)
    // .set(Mreg, 6.5, 0.575)
    // .set(AD, 54.1, 3.5)
    // .set(AS, 0.694, 2.7)
    // .set(AR, 17, 3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Olaf.update(P312).set(Mana, 190, 45);
    // Orianna.update(P0000)
    // .set(Health, 385, 79)
    // .set(Hreg, 5.95, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7, 0.5)
    // .set(AD, 44, 2.6)
    // .set(AS, 0.658, 3.5)
    // .set(AR, 8, 3)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 325);
    // Pantheon.update(P0000)
    // .set(Health, 433, 87)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 210, 34)
    // .set(Mreg, 6.6, 0.45)
    // .set(AD, 50.7, 2.9)
    // .set(AS, 0.679, 2.95)
    // .set(AR, 17.1, 3.9)
    // .set(MR, 30, 1.25)
    // .set(Range, 155)
    // .set(MS, 355);
    // Poppy.update(P0000)
    // .set(Health, 423, 81)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 185, 30)
    // .set(Mreg, 6.4, 0.45)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 3.35)
    // .set(AR, 18, 4)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 345);
    // Quinn.update(P0000)
    // .set(Health, 390, 85)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 210, 35)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 48, 3)
    // .set(AS, 0.668, 3.11)
    // .set(AR, 13.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 335);
    // Rammus.update(P0000)
    // .set(Health, 420, 86)
    // .set(Hreg, 8, 0.55)
    // .set(Mana, 255, 33)
    // .set(Mreg, 4.5, 0.3)
    // .set(AD, 50, 3.5)
    // .set(AS, 0.625, 2.22)
    // .set(AR, 21, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Renekton.update(P0000)
    // .set(Health, 426, 87)
    // .set(Hreg, 6.7, 0.75)
    // .set(AD, 53.12, 3.1)
    // .set(AS, 0.665, 2.65)
    // .set(AR, 15.2, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Rengar.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 4, 0.4)
    // .set(AD, 55, 3)
    // .set(AS, 0.679, 2.85)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Riven.update(P0000)
    // .set(Health, 414, 86)
    // .set(Hreg, 5.5, 0.5)
    // .set(AD, 54, 2.7)
    // .set(AS, 0.625, 3.5)
    // .set(AR, 15, 3.1)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Riven.update(P401).set(AD, 51, 3);
    // Riven.update(P402).set(Hreg, 2.5, 0.5);
    // Rumble.update(P0000)
    // .set(Health, 450, 80)
    // .set(Hreg, 7, 0.7)
    // .set(AD, 55.32, 3.2)
    // .set(AS, 0.644, 1.85)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Ryze.update(P0000)
    // .set(Health, 360, 86)
    // .set(Hreg, 4.35, 0.55)
    // .set(Mana, 250, 55)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 52, 3)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 11, 3.9)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Ryze.update(P312).set(MS, 340);
    // Ryze.update(P403).set(Health, 414, 86);
    // Sejuani.update(P0000)
    // .set(Health, 450, 85)
    // .set(Hreg, 7.35, 0.85)
    // .set(Mana, 220, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 54, 3.4)
    // .set(AS, 0.67, 1.45)
    // .set(AR, 20.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Sejuani.update(P306).set(Health, 440, 95).set(Hreg, 7.25, 0.85).set(AD, 52, 3.3).set(AR,
    // 20.5, 3);
    // Shaco.update(P0000)
    // .set(Health, 441, 84)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 270, 40)
    // .set(Mreg, 6.4, 0.45)
    // .set(AD, 51.7, 3.5)
    // .set(AS, 0.694, 3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Shen.update(P0000)
    // .set(Health, 428, 85)
    // .set(Hreg, 7.45, 0.55)
    // .set(Energy, 200)
    // .set(Ereg, 50)
    // .set(AD, 54.5, 3.375)
    // .set(AS, 0.651, 3.4)
    // .set(AR, 15, 4)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // Shyvana.update(P0000)
    // .set(Health, 435, 95)
    // .set(Hreg, 7.2, 0.8)
    // .set(AD, 54.5, 3.4)
    // .set(AS, 0.658, 3.4)
    // .set(AR, 17.6, 3.4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Singed.update(P0000)
    // .set(Health, 405, 82)
    // .set(Hreg, 7.1, 0.55)
    // .set(Mana, 215, 45)
    // .set(Mreg, 6.6, 0.55)
    // .set(AD, 56.65, 3.375)
    // .set(AS, 0.613, 1.81)
    // .set(AR, 18, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 345);
    // Sion.update(P0000)
    // .set(Health, 403, 104)
    // .set(Hreg, 7.9, 0.95)
    // .set(Mana, 240, 40)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 55.52, 3.1875)
    // .set(AS, 0.625, 1.63)
    // .set(AR, 17.75, 3.25)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Sivir.update(P0000)
    // .set(Health, 378, 82)
    // .set(Hreg, 4.25, 0.55)
    // .set(Mana, 203, 43)
    // .set(Mreg, 6.5, 0.5)
    // .set(AD, 49, 2.9)
    // .set(AS, 0.658, 3.28)
    // .set(AR, 12.75, 3.25)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 335);
    // Sivir.update(P313).set(AS, 0.658, 1.6);
    // Skarner.update(P0000)
    // .set(Health, 440, 96)
    // .set(Hreg, 7.5, 0.85)
    // .set(Mana, 205, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 54.1, 4.2)
    // .set(AS, 0.625, 2.1)
    // .set(AR, 19, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Skarner.update(P402).set(AS, 0.619, 2.1);
    // Sona.update(P0000)
    // .set(Health, 340, 70)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 265, 45)
    // .set(Mreg, 7.0, 0.65)
    // .set(AD, 47, 3)
    // .set(AS, 0.644, 2.3)
    // .set(AR, 6, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Sona.update(P308).set(Health, 380, 70).set(AR, 8, 3.3);
    // Soraka.update(P0000)
    // .set(Health, 375, 71)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 240, 60)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 48.8, 3)
    // .set(AS, 0.625, 2.14)
    // .set(AR, 7.4, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Soraka.update(P314).set(Health, 405, 76).set(AR, 9.4, 3.8);
    // Soraka.update(P315).set(AR, 13, 3.8).set(MS, 340);
    // Swain.update(P0000)
    // .set(Health, 385, 78)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 49, 3)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 12, 4)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 335);
    // Syndra.update(P0000)
    // .set(Health, 380, 78)
    // .set(Hreg, 5.5, 0.6)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 51, 2.9)
    // .set(AS, 0.625, 2)
    // .set(AR, 15, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Talon.update(P0000)
    // .set(Health, 440, 85)
    // .set(Hreg, 7.25, 0.75)
    // .set(Mana, 260, 40)
    // .set(Mreg, 6.75, 0.5)
    // .set(AD, 50, 3.1)
    // .set(AS, 0.668, 2.7)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Taric.update(P0000)
    // .set(Health, 468, 90)
    // .set(Hreg, 7.1, 0.5)
    // .set(Mana, 255, 56)
    // .set(Mreg, 4.1, 0.4)
    // .set(AD, 58, 3.5)
    // .set(AS, 0.625, 2.02)
    // .set(AR, 16.5, 3.2)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Taric.update(P303).set(AD, 53, 3.5);
    // Teemo.update(P0000)
    // .set(Health, 383, 82)
    // .set(Hreg, 4.65, 0.65)
    // .set(Mana, 200, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 44.5, 3)
    // .set(AS, 0.690, 3.38)
    // .set(AR, 14, 3.75)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 330);
    // Thresh.update(P0000)
    // .set(Health, 452, 89)
    // .set(Hreg, 6, 0.55)
    // .set(Mana, 200, 44)
    // .set(Mreg, 5, 0.7)
    // .set(AD, 46, 2.2)
    // .set(AS, 0.625, 2.1)
    // .set(AR, 18, 0)
    // .set(MR, 30, 0)
    // .set(Range, 475)
    // .set(MS, 335);
    // Thresh.update(P310).set(Health, 411, 89).set(AR, 12, 0);
    // Thresh.update(P313).set(AS, 0.625, 3);
    // Thresh.update(P402).set(Range, 450);
    // Tristana.update(P0000)
    // .set(Health, 415, 82)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 193, 32)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 46.5, 3)
    // .set(AS, 0.658, 3.01)
    // .set(AR, 15, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Tristana.update(P303).set(AS, 0.658, 4);
    // Trundle.update(P0000)
    // .set(Health, 455, 96)
    // .set(Hreg, 8, 0.85)
    // .set(Mana, 206, 45)
    // .set(Mreg, 6.5, 0.6)
    // .set(AD, 54.66, 3)
    // .set(AS, 0.672, 2.9)
    // .set(AR, 19, 2.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Tryndamere.update(P0000)
    // .set(Health, 461, 98)
    // .set(Hreg, 7.9, 0.9)
    // .set(AD, 56, 3.2)
    // .set(AS, 0.67, 2.9)
    // .set(AR, 14.9, 3.1)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // TwistedFate.update(P0000)
    // .set(Health, 384, 82)
    // .set(Hreg, 4.5, 0.6)
    // .set(Mana, 202, 38)
    // .set(Mreg, 6.5, 0.5)
    // .set(AD, 46.61, 3.3)
    // .set(AS, 0.651, 3.22)
    // .set(AR, 11.25, 3.15)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 330);
    // Twitch.update(P0000)
    // .set(Health, 389, 81)
    // .set(Hreg, 5, 0.6)
    // .set(Mana, 220, 40)
    // .set(Mreg, 6.5, 0.45)
    // .set(AD, 49, 3)
    // .set(AS, 0.679, 3.38)
    // .set(AR, 14, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Udyr.update(P0000)
    // .set(Health, 427, 99)
    // .set(Hreg, 7.45, 0.75)
    // .set(Mana, 220, 30)
    // .set(Mreg, 6.4, 0.45)
    // .set(AD, 52.91, 3.2)
    // .set(AS, 0.658, 2.67)
    // .set(AR, 14.75, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Urgot.update(P0000)
    // .set(Health, 437, 89)
    // .set(Hreg, 5.5, 0.6)
    // .set(Mana, 220, 55)
    // .set(Mreg, 7.5, 0.65)
    // .set(AD, 48, 3.6)
    // .set(AS, 0.644, 2.9)
    // .set(AR, 15, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 425)
    // .set(MS, 335);
    // Varus.update(P0000)
    // .set(Health, 400, 82)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 36)
    // .set(Mreg, 6.5, 0.5)
    // .set(AD, 46, 3)
    // .set(AS, 0.658, 2.65)
    // .set(AR, 13.5, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 575)
    // .set(MS, 335);
    // Varus.update(P307).set(MS, 330);
    // Vayne.update(P0000)
    // .set(Health, 359, 83)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 173, 27)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 50, 3.25)
    // .set(AS, 0.658, 3.1)
    // .set(AR, 9.3, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Vayne.update(P303).set(Mana, 173, 35).set(AS, 0.658, 4);
    // Veigar.update(P0000)
    // .set(Health, 355, 82)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 55)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 48.3, 2.625)
    // .set(AS, 0.625, 2.24)
    // .set(AR, 12.25, 3.75)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 340);
    // Velkoz.update(P403)
    // .set(Health, 380, 76)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 51.7, 3.14)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 340);
    // Vi.update(P0000)
    // .set(Health, 440, 85)
    // .set(Hreg, 7.5, 0.9)
    // .set(Mana, 220, 45)
    // .set(Mreg, 7.0, 0.65)
    // .set(AD, 55, 3.5)
    // .set(AS, 0.643, 2.5)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Vi.update(P303).set(AD, 51, 3.5);
    // Viktor.update(P0000)
    // .set(Health, 385, 78)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.9, 0.45)
    // .set(AD, 49, 3)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 12, 4)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 335);
    // Vladimir.update(P0000)
    // .set(Health, 400, 85)
    // .set(Hreg, 6, 0.6)
    // .set(AD, 45, 3)
    // .set(AS, 0.6258, 2)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 450)
    // .set(MS, 335);
    // Volibear.update(P0000)
    // .set(Health, 440, 86)
    // .set(Hreg, 7.0, 0.65)
    // .set(Mana, 220, 30)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 54, 3.3)
    // .set(AS, 0.658, 2.9)
    // .set(AR, 16.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Warwick.update(P0000)
    // .set(Health, 428, 98)
    // .set(Hreg, 7.05, 0.8)
    // .set(Mana, 190, 30)
    // .set(Mreg, 7.1, 0.6)
    // .set(AD, 56.76, 3.375)
    // .set(AS, 0.679, 2.88)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // MonkeyKing.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 202, 38)
    // .set(Mreg, 6.9, 0.65)
    // .set(AD, 54, 3.2)
    // .set(AS, 0.658, 3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 345);
    // Xerath.update(P0000)
    // .set(Health, 380, 80)
    // .set(Hreg, 5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 52, 3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 12.6, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Xerath.update(P402).set(Mana, 238, 47).set(Mreg, 6, 0.65).set(Range, 525);
    // XinZhao.update(P0000)
    // .set(Health, 445, 87)
    // .set(Hreg, 7, 0.7)
    // .set(Mana, 213, 31)
    // .set(Mreg, 6.6, 0.45)
    // .set(AD, 52, 3.3)
    // .set(AS, 0.672, 2.7)
    // .set(AR, 16.2, 3.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 345);
    // Yasuo.update(P315)
    // .set(Health, 430, 82)
    // .set(Hreg, 5, 0.9)
    // .set(AD, 50, 3.2)
    // .set(AS, 0.658, 4)
    // .set(AR, 16, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 175)
    // .set(MS, 350);
    // Yorick.update(P0000)
    // .set(Health, 421, 85)
    // .set(Hreg, 8.5, 0.7)
    // .set(Mana, 235, 35)
    // .set(Mreg, 6.5, 0.45)
    // .set(AD, 51.5, 3.5)
    // .set(AS, 0.625, 3)
    // .set(AR, 18, 3.6)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Zac.update(P0000)
    // .set(Health, 455, 95)
    // .set(Hreg, 12.5, 0.55)
    // .set(AD, 54, 3.375)
    // .set(AS, 0.638, 1.6)
    // .set(AR, 14, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Zac.update(P307).set(Hreg, 7, 0.55);
    // Zed.update(P0000)
    // .set(Health, 445, 85)
    // .set(Hreg, 6, 0.65)
    // .set(Energy, 20)
    // .set(Ereg, 50)
    // .set(AD, 48.6, 3.4)
    // .set(AS, 0.658, 3.1)
    // .set(AR, 17.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Ziggs.update(P0000)
    // .set(Health, 390, 80)
    // .set(Hreg, 5.25, 0.6)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.75, 0.6)
    // .set(AD, 54, 3.1)
    // .set(AS, 0.656, 1.7)
    // .set(AR, 12, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 575)
    // .set(MS, 330);
    // Zilean.update(P0000)
    // .set(Health, 380, 71)
    // .set(Hreg, 4.6, 0.5)
    // .set(Mana, 260, 60)
    // .set(Mreg, 6.95, 0.65)
    // .set(AD, 48.6, 3)
    // .set(AS, 0.625, 2.13)
    // .set(AR, 6.75, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 600)
    // .set(MS, 335);
    // Zyra.update(P0000)
    // .set(Health, 355, 74)
    // .set(Hreg, 4.85, 0.5)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7.1, 0.75)
    // .set(AD, 50, 3.2)
    // .set(AS, 0.625, 1.8)
    // .set(AR, 11, 3)
    // .set(MR, 30, 0)
    // .set(Range, 575)
    // .set(MS, 325);
    // }
}
