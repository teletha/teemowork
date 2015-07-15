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

import java.util.Locale;

import teemowork.model.Version;

/**
 * @version 2015/07/14 11:46:21
 */
public class ItemDataBuilder {

    /**
     * <p>
     * Build champion defitnition class.
     * </p>
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ItemDefinitions en = RiotAPI.parse(ItemDefinitions.class, Version.Latest, Locale.US);
        ItemDefinitions ja = RiotAPI.parse(ItemDefinitions.class, Version.Latest, Locale.JAPAN);

        // ClassWriter code = new ClassWriter("teemowork.api", "ItemData");
        // code.write("public enum ", code.className, " {");
        // code.writeConstants(en.data.values(), champion -> {
        // ChampionStatus status = champion.stats;
        // ChampionDefinition localized = ja.data.get(champion.id);
        //
        // code.write();
        // code.write("/** ", champion.name, " Definition", " */");
        // code.write(champion.id, param(string(champion.name), string(localized.name), status.hp,
        // status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel,
        // status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel,
        // status.attackspeedoffset, status.attackspeedperlevel, status.crit, status.critperlevel,
        // status.armor, status.armorperlevel, status.spellblock, status.spellblockperle,
        // status.movespeed, status.attackrange), ",");
        // });
        //
        // // Properties
        // Object[] properties = {String.class, "name", String.class, "jp", float.class, "hp",
        // float.class, "hpPer",
        // float.class, "hreg", float.class, "hregPer", float.class, "mp", float.class, "mpPer",
        // float.class,
        // "mreg", float.class, "mregPer", float.class, "ad", float.class, "adPer", float.class,
        // "as", float.class,
        // "asPer", float.class, "crit", float.class, "critPer", float.class, "ar", float.class,
        // "arPer",
        // float.class, "mr", float.class, "mrPer", float.class, "ms", float.class, "range"};
        //
        // // Field
        // for (int i = 0; i < properties.length; i++) {
        // code.write();
        // code.write("/** Champion status. */");
        // code.write("public final ", properties[i], " ", properties[++i], ";");
        // }
        //
        // // constructor
        // code.write();
        // code.write("/**");
        // code.write(" * The champion definition.");
        // code.write(" */");
        // code.write("private ", code.className, paramDef(properties), " {");
        // for (int i = 0; i < properties.length; i++) {
        // code.write("this.", properties[++i], " = ", properties[i], ";");
        // }
        // code.write("}");
        // code.write("}");
        //
        // code.writeTo(I.locate("src/main/java"));
    }

    /**
     * @version 2015/07/14 11:47:37
     */
    private static class ItemDefinitions {

    }
}
