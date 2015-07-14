/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.api;

import static teemowork.api.ClassWriter.*;

import java.util.LinkedHashMap;
import java.util.Locale;

import kiss.I;
import teemowork.model.Version;

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

        ClassWriter code = new ClassWriter("teemowork.api", "ChampionData");
        code.write("public enum ", code.className, " {");
        code.writeConstants(en.data.values(), champion -> {
            ChampionStatus status = champion.stats;
            ChampionDefinition localized = ja.data.get(champion.id);

            code.write();
            code.write("/** ", champion.name, " Definition", " */");
            code.write(champion.id, param(string(champion.name), string(localized.name), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status.attackspeedoffset, status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperle, status.movespeed, status.attackrange), ",");
        });

        // Properties
        Object[] properties = {String.class, "name", String.class, "jp", float.class, "hp", float.class, "hpPer",
                float.class, "hreg", float.class, "hregPer", float.class, "mp", float.class, "mpPer", float.class,
                "mreg", float.class, "mregPer", float.class, "ad", float.class, "adPer", float.class, "as", float.class,
                "asPer", float.class, "crit", float.class, "critPer", float.class, "ar", float.class, "arPer",
                float.class, "mr", float.class, "mrPer", float.class, "ms", float.class, "range"};

        // Field
        for (int i = 0; i < properties.length; i++) {
            code.write();
            code.write("/** Champion status. */");
            code.write("public final ", properties[i], " ", properties[++i], ";");
        }

        // constructor
        code.write();
        code.write("/**");
        code.write(" * The champion definition.");
        code.write(" */");
        code.write("private ", code.className, paramDef(properties), " {");
        for (int i = 0; i < properties.length; i++) {
            code.write("this.", properties[++i], " = ", properties[i], ";");
        }
        code.write("}");
        code.write("}");

        code.writeTo(I.locate("src/main/java"));
    }

    /**
     * @version 2015/07/13 14:31:48
     */
    private static class ChampionDefinitions {

        /** The champion data store. */
        public LinkedHashMap<String, ChampionDefinition> data;
    }

    /**
     * @version 2015/07/13 14:46:04
     */
    private static class ChampionDefinition {

        /** The champion id. */
        public int key;

        /** The identical name. */
        public String id;

        /** The localized name. */
        public String name;

        /** The localized popular name. */
        public String title;

        /** The localized roar. */
        public String blurb;

        /** The status definition. */
        public ChampionStatus stats;
    }

    /**
     * @version 2015/07/13 14:52:56
     */
    private static class ChampionStatus {

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
}
