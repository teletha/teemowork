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

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;

import kiss.I;
import teemowork.model.Champion;
import teemowork.model.Item;
import teemowork.model.MasterySeason4;
import teemowork.model.Version;
import teemowork.tool.image.EditableImage;
import teemowork.tool.riot.ChampionDataBuilder.ChampionDefinition;
import teemowork.tool.riot.ChampionDataBuilder.ChampionDefinitions;

/**
 * @version 2015/07/19 22:25:30
 */
public class ImageBuilder {

    /** The resource root. */
    private static final Path Resources = I.locate("src/main/resources/teemowork");

    /** The target version. */
    private final Version version;

    /** The work space. */
    private final Path temporary;

    /**
     * @param latest
     */
    public ImageBuilder(Version version) {
        this.version = version;

        try {
            temporary = I.locateTemporary();
            Files.createDirectories(temporary);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Create item icon set.
     * </p>
     */
    public void buildItemIconSet() throws Exception {
        List<Item> items = collect(Item.class);
        EditableImage container = new EditableImage();

        for (Item item : items) {
            EditableImage image = new EditableImage(download("http://ddragon.leagueoflegends.com/cdn/", version.name, ".1/img/item/", item.id, ".png"));
            image.trim(2).resize(45);

            container.concat(image);
        }
        container.write(Resources.resolve("items.jpg"));

        log("Create item icon set.");
    }

    /**
     * <p>
     * Create champion icon set.
     * </p>
     */
    public void buildChampionIconSet() throws Exception {
        List<Champion> champions = collect(Champion.class);

        EditableImage container = new EditableImage();

        for (Champion champion : champions) {
            EditableImage image = new EditableImage(download("http://ddragon.leagueoflegends.com/cdn/", version.name, ".1/img/champion/", champion.systemName, ".png"));
            image.trim(7).resize(70);

            container.concat(image);
        }
        container.write(Resources.resolve("champions.jpg"));

        log("Create champion icon set.");
    }

    /**
     * <p>
     * Create champion icon set.
     * </p>
     */
    public void buildSkillIconSet() throws Exception {
        ChampionDefinitions definitions = RiotAPI.parse(ChampionDefinitions.class, version, Locale.US);

        for (ChampionDefinition definition : definitions.data.values()) {
            definition.analyze();

            EditableImage container = new EditableImage();

            for (int i = 0; i < definition.skillSystem.size(); i++) {
                String file = (definition.skillSystem.get(i) + ".png").replaceAll("\\s", "%20");
                String directory = i == 0 ? "passive" : "spell";

                EditableImage image = new EditableImage(download("http://ddragon.leagueoflegends.com/cdn/", version.name, ".1/img/", directory, "/", file));
                image.resize(45);

                container.concat(image);
            }
            container.write(Resources.resolve("skill/" + definition.id + ".jpg"));

            log("Create ", definition.id, " skill icon set.");
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
     * <p>
     * Collect all defined model in the specified definition class.
     * </p>
     * 
     * @param model
     * @return
     */
    private <M> List<M> collect(Class<M> model) {
        List<M> items = new ArrayList();

        for (Field field : model.getFields()) {
            if (field.getType() == model) {
                try {
                    items.add((M) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }
        return items;
    }

    /**
     * <p>
     * Download data from the specified uri.
     * </p>
     * 
     * @param uri
     * @return
     */
    private Path download(Object... uri) {
        try {
            StringJoiner joiner = new StringJoiner("");

            for (Object object : uri) {
                joiner.add(object.toString());
            }

            Path path = temporary.resolve("donwnloaded" + Instant.now().getEpochSecond());
            URL url = new URL(joiner.toString());

            // donwload
            I.copy(url.openStream(), Files.newOutputStream(path), true);

            return path;
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * Display message.
     * 
     * @param texts
     */
    private void log(Object... texts) {
        for (int i = 0; i < texts.length; i++) {
            System.out.print(texts[i]);
        }
        System.out.println("");
    }

    /**
     * Build resources.
     */
    public static void main(String[] args) throws Exception {
        ImageBuilder builder = new ImageBuilder(Version.Latest);
        builder.buildItemIconSet();
        builder.buildChampionIconSet();
        builder.buildSkillIconSet();
    }
}
