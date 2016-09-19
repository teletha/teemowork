/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool.riot;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import teemowork.model.Version;

/**
 * @version 2015/07/13 14:46:04
 */
class ChampionDefinition implements Comparable<ChampionDefinition> {

    /** The champion id. */
    public int key;

    /** The base name. */
    public String name;

    /** The localized name. */
    public String localizedName;

    /** The localized popular name. */
    public String title;

    /** The localized roar. */
    public String blurb;

    /** The status definition. */
    public Status stats;

    /** The image location. */
    public Image image;

    /** The identical name. */
    public String id;

    /** The skill names. */
    public List<String> skill = new ArrayList();

    /** The loclized skill names. */
    public List<String> skillLocalized = new ArrayList();

    /** The skill names for skillSystem. */
    public List<String> skillSystem = new ArrayList();

    /**
     * <p>
     * Check whether this champion can transform or not.
     * </p>
     * 
     * @return
     */
    public boolean isTransformer() {
        return id.equals("Elise") || id.equals("Jayce") || id.equals("Nidalee") || id.equals("RekSai");
    }

    /**
     * <p>
     * Retrieve the valid transformed name.
     * </p>
     * 
     * @return
     */
    public String getTransformedName() {
        return id + "Transformed";
    }

    /**
     * Analyze data in detail.
     */
    final void analyze() {
        String path = "champion/" + id;
        Detail info = RiotAPI.parse(path, Details.class, Version.Latest, Locale.US).data.get(id);
        Detail local = RiotAPI.parse(path, Details.class, Version.Latest, Locale.JAPAN).data.get(id);

        // passive
        addSkill(info.passive.name, local.passive.name, info.passive.image.full);

        for (int i = 0; i < info.spells.size(); i++) {
            Spell spell = info.spells.get(i);

            addSkill(spell.name, local.spells.get(i).name, spell.image.full);
        }

        // extra
        if (isTransformer()) {
            for (int i = 0; i < info.spells.size(); i++) {
                Spell spell = info.spells.get(i);

                addSkill(spell.getSecondary(), local.spells.get(i).getSecondary(), spell.getSecondaryImage());
            }
        }

    }

    /**
     * <p>
     * List up all extra skills.
     * </p>
     * 
     * @return
     */
    private int[] findExtra() {
        switch (id) {
        case "Elise":
        case "Jayce":
        case "Nidalee":
        case "RekSai":
            return new int[] {0, 1, 2, 3};

        default:
            return new int[0];
        }
    }

    /**
     * <p>
     * Register skill.
     * </p>
     * 
     * @param name
     * @param localized
     * @param system
     */
    private void addSkill(String name, String localized, String system) {
        skill.add(skill(name));
        skillLocalized.add(skill(localized));
        skillSystem.add(system.replaceAll("\\.png", ""));
    }

    /**
     * <p>
     * Normalize skill name.
     * </p>
     * 
     * @param name
     * @return
     */
    private String skill(String name) {
        if (!isTransformer()) {
            return name;
        }

        int index = name.indexOf("/");

        if (index != -1) {
            name = name.substring(0, index).trim();
        }
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(ChampionDefinition o) {
        return name.compareTo(o.name);
    }

    /**
     * @version 2015/07/13 14:52:56
     */
    static class Status {

        /** The status. */
        public float hp;

        /** The status. */
        public float hpperlevel;

        /** The status. */
        public float mp;

        /** The status. */
        public float mpperlevel;

        /** The status. */
        public float movespeed;

        /** The status. */
        public float armor;

        /** The status. */
        public float armorperlevel;

        /** The status. */
        public float spellblock;

        /** The status. */
        public float spellblockperlevel;

        /** The status. */
        public float attackrange;

        /** The status. */
        public float hpregen;

        /** The status. */
        public float hpregenperlevel;

        /** The status. */
        public float mpregen;

        /** The status. */
        public float mpregenperlevel;

        /** The status. */
        public float crit;

        /** The status. */
        public float critperlevel;

        /** The status. */
        public float attackdamage;

        /** The status. */
        public float attackdamageperlevel;

        /** The status. */
        public float attackspeedoffset;

        /** The status. */
        public float attackspeedperlevel;

        /**
         * <p>
         * Calculate base attack speed.
         * </p>
         * 
         * @return
         */
        public float attackspeed() {
            return new BigDecimal(0.625).divide(BigDecimal.ONE.add(new BigDecimal(attackspeedoffset)), 3, RoundingMode.HALF_UP)
                    .floatValue();
        }
    }

    /**
     * @version 2015/07/20 20:53:27
     */
    private static class Image {

        public String full;

        public String sprite;

        public int h;

        public int w;

        public int x;

        public int y;
    }

    /**
     * @version 2015/07/20 21:41:00
     */
    private static class Details {

        public Map<String, Detail> data;
    }

    /**
     * @version 2015/07/20 21:42:06
     */
    private static class Detail {

        public String allytips;

        public String blurb;

        public String enemytips;

        public String lore;

        public String name;

        public String id;

        public String partype;

        public Spell passive;

        public List<Spell> spells;

    }

    /**
     * @version 2015/07/20 21:47:28
     */
    private class Spell {

        public Image image;

        public List<Image> altimages;

        public String name;

        public List<Float> cooldown;

        public List<Float> cost;

        public List<Float> range;

        public String costType;

        public String description;

        public String id;

        public int maxrank;

        private String getSecondary() {
            int index = name.indexOf("/");

            return index == -1 ? name : name.substring(index + 1).trim();
        }

        private String getSecondaryImage() {
            return altimages == null ? image.full : altimages.get(0).full;
        }
    }
}
