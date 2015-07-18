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
import java.util.List;
import java.util.Locale;
import java.util.Map;

import kiss.I;
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

        ClassWriter code = new ClassWriter("teemowork.api", "ItemData");
        code.write("public enum ", code.className, " {");
        code.writeConstants(en.data.entrySet(), entry -> {
            int id = entry.getKey();

            ItemDefinition item = entry.getValue();
            ItemDefinition localized = ja.data.get(id);
            ItemGold gold = item.gold;
            ItemStatus status = item.stats;

            if (id != 2009 && (item.maps == null || item.maps.get(1) == null)) {
                code.write();
                code.write("/** ", item.name, " Definition", " */");

                String name = name(item, en.data);
                String localizedName = name(localized, ja.data);

                code.write(name
                        .replaceAll("[\\s'-\\.:]", ""), param(string(name), string(localizedName), id, gold.base, gold.total, gold.sell), ",");
            }
        });

        // Properties
        Object[] properties = {String.class, "name", String.class, "localizedName", int.class, "id", int.class,
                "buyBase", int.class, "buyTotal", int.class, "sell"};

        // Field
        for (int i = 0; i < properties.length; i++) {
            code.write();
            code.write("/** Item status. */");
            code.write("public final ", properties[i], " ", properties[++i], ";");
        }

        // constructor
        code.write();
        code.write("/**");
        code.write(" * The item definition.");
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
     * <p>
     * Normalize name.
     * </p>
     * 
     * @param item
     * @param data
     * @return
     */
    private static String name(ItemDefinition item, Map<Integer, ItemDefinition> data) {
        String name = item.name;

        if (name.startsWith("Enchantment: Sated Devourer") && item.from != null) {
            name = data.get(data.get(item.from.get(0)).from.get(0)).name + " " + name;
        } else if (item.from != null && (name.startsWith("Enchantment") || name.startsWith("追加特性"))) {
            name = data.get(item.from.get(0)).name + " " + name;
        }
        return name;
    }

    /**
     * @version 2015/07/14 11:47:37
     */
    private static class ItemDefinitions {

        public LinkedHashMap<Integer, ItemDefinition> data;
    }

    /**
     * @version 2015/07/17 17:56:25
     */
    private static class ItemDefinition {

        public int depth;

        public String colloq;

        public String name;

        public String group;

        public String description;

        public ItemGold gold;

        public List<Integer> into;

        public List<Integer> from;

        public Map<Integer, Boolean> maps;

        public ItemStatus stats;
    }

    /**
     * @version 2015/07/18 0:10:31
     */
    private static class ItemGold {

        public int base;

        public int sell;

        public int total;
    }

    /**
     * @version 2015/07/18 0:11:39
     */
    private static class ItemStatus {

        public float FlatArmorMod;

        public float FlatAttackSpeedMod;

        public float FlatBlockMod;

        public float FlatCritChanceMod;

        public float FlatCritDamageMod;

        public float FlatEXPBonus;

        public float FlatEnergyPoolMod;

        public float FlatEnergyRegenMod;

        public float FlatHPPoolMod;

        public float FlatHPRegenMod;

        public float FlatMPPoolMod;

        public float FlatMPRegenMod;

        public float FlatMagicDamageMod;

        public float FlatMovementSpeedMod;

        public float FlatPhysicalDamageMod;

        public float FlatSpellBlockMod;

        public float PercentArmorMod;

        public float PercentAttackSpeedMod;

        public float PercentBlockMod;

        public float PercentCritChanceMod;

        public float PercentCritDamageMod;

        public float PercentDodgeMod;

        public float PercentEXPBonus;

        public float PercentHPPoolMod;

        public float PercentHPRegenMod;

        public float PercentLifeStealMod;

        public float PercentMPPoolMod;

        public float PercentMPRegenMod;

        public float PercentMagicDamageMod;

        public float PercentMovementSpeedMod;

        public float PercentPhysicalDamageMod;

        public float PercentSpellBlockMod;

        public float PercentSpellVampMod;

        public float rFlatArmorModPerLevel;

        public float rFlatArmorPenetrationMod;

        public float rFlatArmorPenetrationModPerLevel;

        public float rFlatCritChanceModPerLevel;

        public float rFlatCritDamageModPerLevel;

        public float rFlatDodgeMod;

        public float rFlatDodgeModPerLevel;

        public float rFlatEnergyModPerLevel;

        public float rFlatEnergyRegenModPerLevel;

        public float rFlatGoldPer10Mod;

        public float rFlatHPModPerLevel;

        public float rFlatHPRegenModPerLevel;

        public float rFlatMPModPerLevel;

        public float rFlatMPRegenModPerLevel;

        public float rFlatMagicDamageModPerLevel;

        public float rFlatMagicPenetrationMod;

        public float rFlatMagicPenetrationModPerLevel;

        public float rFlatMovementSpeedModPerLevel;

        public float rFlatPhysicalDamageModPerLevel;

        public float rFlatSpellBlockModPerLevel;

        public float rFlatTimeDeadMod;

        public float rFlatTimeDeadModPerLevel;

        public float rPercentArmorPenetrationMod;

        public float rPercentArmorPenetrationModPerLevel;

        public float rPercentAttackSpeedModPerLevel;

        public float rPercentCooldownMod;

        public float rPercentCooldownModPerLevel;

        public float rPercentMagicPenetrationMod;

        public float rPercentMagicPenetrationModPerLevel;

        public float rPercentMovementSpeedModPerLevel;

        public float rPercentTimeDeadMod;

        public float rPercentTimeDeadModPerLevel;

    }
}
