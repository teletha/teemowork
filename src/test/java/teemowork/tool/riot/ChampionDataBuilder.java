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

import kiss.I;
import teemowork.model.Champion;
import teemowork.model.SkillDefinition;
import teemowork.tool.ClassWriter;
import teemowork.tool.riot.ChampionDefinition.Status;

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
        ClassWriter code = new ClassWriter("teemowork.api", "RiotChampionData");
        code.write("public class ", code.className, " {");
        code.write();
        code.write("/** Champion Manager */");
        code.write("protected static final ", generic(List.class, Champion.class), " champions = new ", ArrayList.class, "();");

        for (ChampionDefinition champion : RiotAPI.champions()) {
            Status status = champion.stats;

            code.write();
            code.write("/** ", champion.name, " Definition", " */");
            code.write("public static final ", Champion.class, " ", champion.id, " = new ", Champion.class, param(string(champion.name), string(champion.localizedName), string(champion.id), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status
                    .attackspeed(), status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperlevel, status.movespeed, status.attackrange, skills(champion.skill, false), skills(champion.skillLocalized, false), methodRef(SkillDefinition.class, champion.id), false), ";");

            if (champion.isTransformer()) {
                String id = champion.getTransformedName();

                code.write();
                code.write("/** ", champion.name, " Definition", " */");
                code.write("public static final ", Champion.class, " ", id, " = new ", Champion.class, param(string(champion.name), string(champion.localizedName), string(id), status.hp, status.hpperlevel, status.hpregen, status.hpregenperlevel, status.mp, status.mpperlevel, status.mpregen, status.mpregenperlevel, status.attackdamage, status.attackdamageperlevel, status
                        .attackspeed(), status.attackspeedperlevel, status.crit, status.critperlevel, status.armor, status.armorperlevel, status.spellblock, status.spellblockperlevel, status.movespeed, status.attackrange, skills(champion.skill, true), skills(champion.skillLocalized, true), methodRef(SkillDefinition.class, id), true), ";");
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
     * @param spells
     * @param transformer
     * @return
     */
    private static String skills(List<String> skills, boolean transformer) {
        int size = skills.size();

        if (size == 9) {
            if (transformer) {
                return array(new String[] {skills.get(0), skills.get(5), skills.get(6), skills.get(7), skills.get(8)});
            } else {
                return array(new String[] {skills.get(0), skills.get(1), skills.get(2), skills.get(3), skills.get(4)});
            }
        }
        return array(skills.toArray(new String[size]));
    }
}
