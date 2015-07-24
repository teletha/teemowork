/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool.riot;

import static teemowork.tool.ClassWriter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import kiss.I;
import teemowork.model.Champion;
import teemowork.model.SkillDefinition;
import teemowork.model.Version;
import teemowork.tool.ClassWriter;

/**
 * @version 2015/07/13 12:41:51
 */
public class ChampionDataBuilder {

    /**
     * <p>
     * Build champion defitnition class.
     * </p>
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ChampionDefinitions en = RiotAPI.parse(ChampionDefinitions.class, Version.Latest, Locale.US);
        ChampionDefinitions ja = RiotAPI.parse(ChampionDefinitions.class, Version.Latest, Locale.JAPAN);

        ClassWriter code = new ClassWriter("teemowork.api", "RiotChampionData");
        code.write("public class ", code.className, " {");
        for (ChampionDefinition champion : en.data.values()) {
            champion.analyze();

            Status status = champion.stats;
            ChampionDefinition localized = ja.data.get(champion.id);

            code.write();
            code.write("/** ", champion.name, " Definition", " */");
            code.write("public static final ", Champion.class, " ", champion.id, " = new ", Champion.class, param(string(champion.name), string(localized.name), string(champion.id), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status.attackspeedoffset, status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperle, status.movespeed, status.attackrange, skills(champion.skill, false), skills(champion.skillLocalized, false), methodRef(SkillDefinition.class, champion.id), false), ";");

            if (champion.isTransformer()) {
                String id = champion.id + "Transformed";

                code.write();
                code.write("/** ", champion.name, " Definition", " */");
                code.write("public static final ", Champion.class, " ", id, " = new ", Champion.class, param(string(champion.name), string(localized.name), string(id), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status.attackspeedoffset, status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperle, status.movespeed, status.attackrange, skills(champion.skill, true), skills(champion.skillLocalized, true), methodRef(SkillDefinition.class, id), true), ";");
            }
        }
        code.write("}");
        code.writeTo(I.locate("src/main/java"));
    }

    /**
     * <p>
     * Choose correct skill set.
     * </p>
     * 
     * @param skills
     * @param transformer
     * @return
     */
    private static String skills(List<String> skills, boolean transformer) {
        int size = skills.size();

        if (transformer == false) {
            return array(skills.toArray(new String[size]));
        }

        if (size == 9) {
            if (transformer) {
                return array(new String[] {skills.get(0), skills.get(5), skills.get(6), skills.get(7), skills.get(8)});
            } else {
                return array(new String[] {skills.get(0), skills.get(1), skills.get(2), skills.get(3), skills.get(4)});
            }
        } else if (size == 8) {
            if (transformer) {
                return array(new String[] {skills.get(0), skills.get(5), skills.get(6), skills.get(7), skills.get(4)});
            } else {
                return array(new String[] {skills.get(0), skills.get(1), skills.get(2), skills.get(3), skills.get(4)});
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2015/07/13 14:31:48
     */
    static class ChampionDefinitions {

        /** The champion data store. */
        public ConcurrentSkipListMap<String, ChampionDefinition> data;
    }

    /**
     * @version 2015/07/13 14:46:04
     */
    static class ChampionDefinition {

        /** The champion id. */
        public int key;

        /** The localized name. */
        public String name;

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
        List<String> skill = new ArrayList();

        /** The loclized skill names. */
        List<String> skillLocalized = new ArrayList();

        /** The skill names for skillSystem. */
        List<String> skillSystem = new ArrayList();

        /**
         * Analyze data in detail.
         */
        void analyze() {
            String path = "champion/" + id;
            Detail info = RiotAPI.parse(path, Details.class, Version.Latest, Locale.US).data.get(id);
            Detail local = RiotAPI.parse(path, Details.class, Version.Latest, Locale.JAPAN).data.get(id);

            addSkill(info.passive.name, local.passive.name, info.passive.image.full);

            for (int i = 0; i < info.spells.size(); i++) {
                Spell spell = info.spells.get(i);

                addSkill(spell.name, local.spells.get(i).name, spell.image.full);
            }

            if (isTransformer()) {

            }
        }

        /**
         * <p>
         * Check whether this champion can transform or not.
         * </p>
         * 
         * @return
         */
        boolean isTransformer() {
            return name.equals("Elise") || name.equals("Jayce") || name.equals("Nidalee");
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
     * @version 2015/07/13 14:52:56
     */
    private static class Status {

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
        public float spellblockperle;

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
    private static class Spell {

        public Image image;

        public String name;

        public List<Float> cooldown;

        public List<Integer> cost;

        public List<Integer> range;

        public String costType;

        public String description;

        public String id;

        public int maxrank;

    }
}
