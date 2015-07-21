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

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import kiss.I;
import teemowork.model.Version;
import teemowork.tool.riot.ChampionDataBuilder.ChampionDefinition;
import teemowork.tool.riot.ChampionDataBuilder.ChampionDefinitions;

/**
 * @version 2015/07/21 22:09:30
 */
public class Update {

    public static void main(String[] args) throws Exception {
        Map<String, String> mapping = new HashMap();

        ChampionDefinitions en = RiotAPI.parse(ChampionDefinitions.class, Version.Latest, Locale.US);

        for (ChampionDefinition champion : en.data.values()) {
            champion.analyze();

            for (int i = 0; i < 5; i++) {
                String key = i == 0 ? "P" : i == 1 ? "Q" : i == 2 ? "W" : i == 3 ? "E" : "R";

                mapping.put(" " + champion.skill.get(i)
                        .replaceAll(" of ", " Of ")
                        .replaceAll(" the ", " The ")
                        .replaceAll(" in ", "In")
                        .replaceAll("[\\s-,!':/]", "")
                        .replaceAll("^\\d+", "") + ".", " " + champion.id + "." + key + ".");
            }
        }

        Path file = I.locate("src/main/java/teemowork/model/Skill.java");

        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (Entry<String, String> map : mapping.entrySet()) {
                line = line.replace(map.getKey(), map.getValue());
            }
            lines.set(i, line);
        }

        Files.write(file, lines, StandardCharsets.UTF_8);
    }
}
