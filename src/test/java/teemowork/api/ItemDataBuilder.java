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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kiss.I;
import teemowork.model.Describable;
import teemowork.model.ItemDescriptor;
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

        ClassWriter code = new ClassWriter("teemowork.model", "ItemData");
        code.write("public class ", code.className, " extends ", generic(Describable.class, ItemDescriptor.class), " {");

        code.write("/** The item manager. */");
        code.write("private static final ", generic(List.class, code.className), " items = new ", ArrayList.class, "();");

        for (Entry<Integer, ItemDefinition> entry : en.data.entrySet()) {
            int id = entry.getKey();

            ItemDefinition item = entry.getValue();
            ItemDefinition localized = ja.data.get(id);
            ItemGold gold = item.gold;
            ItemImage image = item.image;

            if (canUseInSummonersRift(id, item)) {
                code.write();
                code.write("/** ", item.name, " Definition", " */");

                item.name(en.data);
                localized.name(ja.data);

                List<AbilityDefinition> abilities = AbilityDefinition.analyze(localized);

                code.write("public static final ", code.className, " ", item.identicalName, " = new ", code.className, param(string(item.name), string(localized.name), id, gold.base, gold.total, gold.sell, array(item.from), array(item.into), image.sprite
                        .charAt(4), image.x, image.y, item.depth, string(localized.description), lambda("item", () -> {
                            item.stats.describe(code);

                            for (AbilityDefinition ability : abilities) {
                                if (ability.name.isEmpty()) {
                                    code.write("item.add", param(string(ability.explain), lambda("ability", () -> {

                                    })), ";");
                                } else {
                                    code.write("item.add", param(string(ability.name), lambda("ability", () -> {

                                    })), ";");
                                }
                            }
                        })), ";");
            }
        }

        // Properties
        Object[] properties = {String.class, "name", String.class, "localizedName", int.class, "identicalName",
                int.class, "buyBase", int.class, "buyTotal", int.class, "sell", int[].class, "from", int[].class, "to",
                int.class, "imageNo", int.class, "imageX", int.class, "imageY", int.class, "depth", String.class,
                "description", generic(Consumer.class, ItemDescriptor.class), "descriptor"};

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

        code.write();
        code.write("items.add(this);");
        code.write("}");

        // methods
        code.write();
        code.write("/**");
        code.write(" * Descrive item status.");
        code.write(" */");
        code.write("void describe", paramDef(generic(Consumer.class, ItemDescriptor.class), "description"), " {");
        code.write("}");

        code.write();
        code.write("/**");
        code.write(" * {@inheritDoc}");
        code.write(" */");
        code.write("@Override");
        code.write("public int getMaxLevel()", " {");
        code.write("return 0;");
        code.write("}");

        code.write();
        code.write("/**");
        code.write(" * {@inheritDoc}");
        code.write(" */");
        code.write("@Override");
        code.write("protected ItemDescriptor createDescriptor(Version version, ItemDescriptor previous)", " {");
        // code.write("return new ItemDescriptor(this, previous, version);");
        code.write("return null;");
        code.write("}");

        code.write();
        code.write("/**");
        code.write(" * List up all Items.");
        code.write(" */");
        code.write("public static ", generic(List.class, code.className), " getAll()", " {");
        code.write("return items;");
        code.write("}");

        code.write("}");
        code.writeTo(I.locate("src/main/java"));
    }

    /**
     * 
     */
    private static class AbilityDefinition {

        /** The ability manager. */
        private static final List<AbilityDefinition> manager = new ArrayList();

        /**
         * <p>
         * Analyze ability description.
         * </p>
         * 
         * @param localizedName
         * @param item
         */
        private static List<AbilityDefinition> analyze(ItemDefinition item) {
            List<AbilityDefinition> definitions = new ArrayList();
            String description = item.description.replaceAll("</?(i|font(\\s.+?)?)>", "");

            Pattern pattern = Pattern.compile("<unique>([^<:-]+)-?([^<:]+)?: ?</unique>\\s?((<br>|[^<])+)(?!<unique>)");
            Matcher matcher = pattern.matcher(description);

            root: while (matcher.find()) {
                AbilityDefinition newer = new AbilityDefinition(item, matcher.group(1), matcher.group(2), matcher
                        .group(3));
                definitions.add(newer);

                if (!newer.name.isEmpty()) {
                    boolean hasSameName = false;

                    for (AbilityDefinition ability : manager) {
                        if (ability.name.equals(newer.name)) {
                            hasSameName = true;

                            if (ability.explain.equals(newer.explain)) {
                                continue root;
                            }
                        }
                    }

                    if (hasSameName) {
                        newer.identicalName = newer.identicalName + "_" + item.identicalName;
                    }
                    manager.add(newer);
                }
            }
            return definitions;
        }

        /** The item */
        private final ItemDefinition item;

        /** Check this ability is unique or not. */
        private final boolean unique;

        /** Check this ability is passive or not. */
        private final boolean passive;

        /** Check this ability is passive or not. */
        private final boolean active;

        /** Check this ability is passive or not. */
        private final boolean toggle;

        /** The ability identicalName. */
        private String identicalName;

        /** The abilit name. */
        private final String name;

        private String explain;

        /**
         * @param description
         */
        private AbilityDefinition(ItemDefinition item, String type, String name, String explain) {
            type = type.trim();

            this.item = item;
            this.identicalName = name(name);
            this.name = name == null ? "" : name.trim();
            this.unique = type.contains("UNIQUE") || type.contains("ユニーク");
            this.passive = type.contains("Passive") || type.contains("自動効果");
            this.active = type.contains("Active") || type.contains("発動効果");
            this.toggle = type.contains("Toggle") || type.contains("切替効果");
            this.explain = explain;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((explain == null) ? 0 : explain.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof AbilityDefinition)) {
                return false;
            }
            AbilityDefinition other = (AbilityDefinition) obj;
            if (explain == null) {
                if (other.explain != null) {
                    return false;
                }
            } else if (!explain.equals(other.explain)) {
                return false;
            }
            if (name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }
    }

    /**
     * <p>
     * Check item use condition.
     * </p>
     * 
     * @param identicalName
     * @param item
     * @return
     */
    private static boolean canUseInSummonersRift(int id, ItemDefinition item) {
        return id != 2009 && (item.maps == null || item.maps.get(1) == null);
    }

    /**
     * <p>
     * Normalize name for Java identifier.
     * </p>
     * 
     * @param name
     * @return
     */
    private static String name(String name) {
        if (name == null) {
            return "";
        }
        return name.replaceAll("[\\s'-\\.:]", "");
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

        private String identicalName;

        public int depth;

        public String colloq;

        public String name;

        public String group;

        public String description;

        public ItemGold gold;

        public ItemImage image;

        public List<Integer> into;

        public List<Integer> from;

        public Map<Integer, Boolean> maps;

        public ItemStatus stats;

        private void name(Map<Integer, ItemDefinition> data) {
            if (name.startsWith("Enchantment: Sated Devourer") && from != null) {
                name = data.get(data.get(from.get(0)).from.get(0)).name + " " + name;
            } else if (from != null && (name.startsWith("Enchantment") || name.startsWith("追加特性"))) {
                name = data.get(from.get(0)).name + " " + name;
            }
            identicalName = name.replaceAll("[\\s'-\\.:]", "");
        }
    }

    /**
     * @version 2015/07/19 3:33:27
     */
    private static class ItemImage {

        public String sprite;

        public int h;

        public int w;

        public int x;

        public int y;

        private int[] info() {
            return new int[] {sprite.charAt(4), h, w, x, y};
        }
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

        private ClassWriter code;

        private void describe(ClassWriter code) {
            this.code = code;

            set("attackDamage", FlatPhysicalDamageMod);
            setAsInt("attackSpeed", PercentAttackSpeedMod);
            setAsInt("critical", FlatCritChanceMod);
            setAsInt("lifeSteal", PercentLifeStealMod);

            set("abilityPower", FlatMagicDamageMod);
            // set("cooldownReduction", FlatMagicDamageMod);
            // set("spellVamp", FlatMagicDamageMod);

            set("health", FlatHPPoolMod);
            set("healthRegen", FlatHPRegenMod * 5);
            set("mana", FlatMPPoolMod);
            set("manaRegen", FlatMPRegenMod * 5);

            set("armor", FlatArmorMod);
            set("magicRegist", FlatSpellBlockMod);

            setAsInt("movementSpeed", PercentMovementSpeedMod);
        }

        private void set(String type, float value) {
            if (value != 0) {
                code.write("item.", type, param((int) value), ";");
            }
        }

        private void setAsInt(String type, float value) {
            if (value != 0) {
                code.write("item.", type, param((int) (value * 100)), ";");
            }
        }
    }

}
