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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
            code.write("public static final ", Champion.class, " ", champion.id, " = new ", Champion.class, param(string(champion.name), string(localized.name), string(champion.id), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status.attackspeedoffset, status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperle, status.movespeed, status.attackrange, array(champion.skill), array(champion.skillLocalized), methodRef(SkillDefinition.class, champion.id), false), ";");

            if (isTransformer(champion.name)) {
                String id = champion.id + "Transformed";

                code.write();
                code.write("/** ", champion.name, " Definition", " */");
                code.write("public static final ", Champion.class, " ", id, " = new ", Champion.class, param(string(champion.name), string(localized.name), string(champion.id), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status.attackspeedoffset, status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperle, status.movespeed, status.attackrange, array(champion.skill), array(champion.skillLocalized), methodRef(SkillDefinition.class, id), true), ";");
            }
        }
        code.write("}");
        code.writeTo(I.locate("src/main/java"));
    }

    /**
     * @param name
     * @return
     */
    private static boolean isTransformer(String name) {
        return name.equals("Elise") || name.equals("Jayce") || name.equals("Nidalee");
    }

    /**
     * @version 2015/07/13 14:31:48
     */
    static class ChampionDefinitions {

        /** The champion data store. */
        public LinkedHashMap<String, ChampionDefinition> data;
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

            skill.add(info.passive.name);
            skillLocalized.add(local.passive.name);
            skillSystem.add(info.passive.image.full.replaceAll("\\.png", ""));

            for (int i = 0; i < info.spells.size(); i++) {
                Spell spell = info.spells.get(i);

                skill.add(spell.name);
                skillLocalized.add(local.spells.get(i).name);
                skillSystem.add(spell.image.full.replaceAll("\\.png", ""));
            }
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
