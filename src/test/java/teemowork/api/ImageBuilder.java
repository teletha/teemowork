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

import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kiss.I;
import teemowork.api.ChampionDataBuilder.ChampionDefinition;
import teemowork.api.ChampionDataBuilder.ChampionDefinitions;
import teemowork.model.Champion;
import teemowork.model.Item;
import teemowork.model.MasterySeason4;
import teemowork.model.Version;
import teemowork.tool.image.EditableImage;

/**
 * @version 2015/07/19 22:25:30
 */
public class ImageBuilder {

    /** The resource root. */
    private static final Path Resources = I.locate("src/main/resources/teemowork");

    /** The target version. */
    private final Version version;

    /**
     * @param latest
     */
    public ImageBuilder(Version version) {
        this.version = version;
    }

    /**
     * <p>
     * Create item icon set.
     * </p>
     */
    public void buildItemIconSet() throws Exception {
        List<Item> items = new ArrayList();

        for (Field field : Item.class.getFields()) {
            if (field.getType() == Item.class) {
                try {
                    items.add((Item) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        Path temporary = I.locateTemporary();
        Files.createDirectories(temporary);

        EditableImage container = new EditableImage();

        for (Item item : items) {
            String file = item.id + ".png";

            try {
                Path local = temporary.resolve(file);
                URL url = new URL("http://ddragon.leagueoflegends.com/cdn/" + version.name + ".1/img/item/" + file);

                I.copy(url.openStream(), Files.newOutputStream(local), true);

                EditableImage image = new EditableImage(local);
                image.trim(2).resize(45);

                container.concat(image);
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
        container.write(Resources.resolve("items.jpg"));
    }

    /**
     * <p>
     * Create champion icon set.
     * </p>
     */
    public void buildChampionIconSet() throws Exception {
        List<Champion> champions = new ArrayList();

        for (Field field : Champion.class.getFields()) {
            if (field.getType() == Champion.class) {
                try {
                    champions.add((Champion) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        Path temporary = I.locateTemporary();
        Files.createDirectories(temporary);

        EditableImage container = new EditableImage();

        for (Champion champion : champions) {
            String file = champion.systemName + ".png";

            Path local = temporary.resolve(file);
            URL url = new URL("http://ddragon.leagueoflegends.com/cdn/" + version.name + ".1/img/champion/" + file);

            I.copy(url.openStream(), Files.newOutputStream(local), true);

            EditableImage image = new EditableImage(local);
            image.trim(7).resize(70);

            container.concat(image);
        }
        container.write(Resources.resolve("champions.jpg"));
    }

    /**
     * <p>
     * Create champion icon set.
     * </p>
     */
    public void buildSkillIconSet() throws Exception {
        List<Champion> champions = new ArrayList();

        for (Field field : Champion.class.getFields()) {
            if (field.getType() == Champion.class) {
                try {
                    champions.add((Champion) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        Path temporary = I.locateTemporary();
        Files.createDirectories(temporary);

        ChampionDefinitions definitions = RiotAPI.parse(ChampionDefinitions.class, Version.Latest, Locale.US);

        for (ChampionDefinition definition : definitions.data.values()) {
            definition.analyze();

            EditableImage container = new EditableImage();

            for (int i = 0; i < definition.skillSystem.size(); i++) {
                String file = (definition.skillSystem.get(i) + ".png").replaceAll("\\s", "%20");

                Path local = temporary.resolve(file);
                URL url = new URL("http://ddragon.leagueoflegends.com/cdn/" + version.name + ".1/img/" + (i == 0
                        ? "passive" : "spell") + "/" + file);

                I.copy(url.openStream(), Files.newOutputStream(local), true);

                EditableImage image = new EditableImage(local);
                image.resize(45);

                container.concat(image);
            }
            container.write(Resources.resolve("skill/" + definition.id + ".jpg"));
        }
    }

    /**
     * <p>
     * Create mastery icon set.
     * </p>
     */
    public void buildMasteryIconSet() {
        List<MasterySeason4> masteries = new ArrayList();

        for (Field field : MasterySeason4.class.getFields()) {
            if (field.getType() == MasterySeason4.class) {
                try {
                    masteries.add((MasterySeason4) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        EditableImage container = new EditableImage();

        for (MasterySeason4 mastery : masteries) {
            EditableImage image = new EditableImage(I.locate(mastery.getIcon()));
            image.resize(45);

            container.concat(image);
        }
        container.write(Resources.resolve("masteryS4.jpg"));
    }

    /**
     * Build resources.
     */
    public static void main(String[] args) throws Exception {
        ImageBuilder builder = new ImageBuilder(Version.Latest);
        // builder.buildItemIconSet();
        // builder.buildChampionIconSet();
        builder.buildSkillIconSet();
    }
}
