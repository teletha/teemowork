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
            ItemStatus status = item.stats;

            code.write();
            code.write("/** ", item.name, " Definition", " */");

            String name = item.name;

            if (name.startsWith("Enchantment") && item.from != null) {
                name = en.data.get(item.from.get(0)).name + name;
            }
            code.write(name.replaceAll("[\\s'-\\.:]", ""), param(string(item.name), string(localized.name), id), ",");
        });

        // Properties
        Object[] properties = {String.class, "name", String.class, "jp", int.class, "id"};

        // Field
        for (int i = 0; i < properties.length; i++) {
            code.write();
            code.write("/** Champion status. */");
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

        public String description;

        public Gold gold;

        public List<Integer> into;

        public List<Integer> from;

        public ItemStatus stats;
    }

    /**
     * @version 2015/07/18 0:10:31
     */
    private static class Gold {

        public int base;

        public int sell;

        public int total;
    }

    /**
     * @version 2015/07/18 0:11:39
     */
    private static class ItemStatus {

        public float FlatMovementSpeedMod;

        public float FlatMPPoolMod;

        public float FlatHPPoolMod;

        public float FlatPhysicalDamageMod;
    }
}
