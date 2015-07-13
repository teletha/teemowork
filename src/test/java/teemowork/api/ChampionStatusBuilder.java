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

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import teemowork.model.Version;

/**
 * @version 2015/07/13 12:41:51
 */
public class ChampionStatusBuilder {

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

        ClassWriter code = new ClassWriter("ChampionAPI");
        code.writeLicense();
        code.write("public enum ", code.className, " {");
        for (ChampionDefinition definition : en.data.values()) {
            ChampionDefinition localized = ja.data.get(definition.id);
            code.write("    ", definition.id, "(\"", localized.name, "\"),");
            code.write();
        }
        code.write("}");
        System.out.println(code);
    }

    /**
     * @version 2015/07/13 14:31:48
     */
    private static class ChampionDefinitions {

        /** The champion data store. */
        public Map<String, ChampionDefinition> data = new LinkedHashMap();
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

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ChampionStatus [hp=" + hp + ", hpperlevel=" + hpperlevel + ", mp=" + mp + ", mpperlevel=" + mpperlevel + ", movespeed=" + movespeed + ", armor=" + armor + ", armorperlevel=" + armorperlevel + ", spellblock=" + spellblock + ", spellblockperle=" + spellblockperle + ", attackrange=" + attackrange + ", hpregen=" + hpregen + ", hpregenperlevel=" + hpregenperlevel + ", mpregen=" + mpregen + ", mpregenperlevel=" + mpregenperlevel + ", crit=" + crit + ", critperlevel=" + critperlevel + ", attackdamage=" + attackdamage + ", attackdamageperlevel=" + attackdamageperlevel + ", attackspeedoffset=" + attackspeedoffset + ", attackspeedperlevel=" + attackspeedperlevel + "]";
        }
    }
}
