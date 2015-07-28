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
import java.util.StringJoiner;

import kiss.I;
import teemowork.model.Item;
import teemowork.model.MasterySeason4;
import teemowork.model.Version;
import teemowork.tool.image.EditableImage;

/**
 * @version 2015/07/22 2:39:54
 */
public class ImageBuilder {

    /** The resource root. */
    private static final Path Resources = I.locate("src/main/resources/teemowork");

    /** The target version. */
    private final Version version;

    /** The work space. */
    private final Path temporary;

    /** The champion list. */
    private final List<ChampionDefinition> champions;

    /**
     * @param latest
     */
    public ImageBuilder(Version version) {
        this.version = version;

        try {
            temporary = I.locateTemporary();
            Files.createDirectories(temporary);

            champions = RiotAPI.champions();
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
        EditableImage container = new EditableImage();

        for (ChampionDefinition champion : champions) {
            EditableImage image = new EditableImage(download("http://ddragon.leagueoflegends.com/cdn/", version.name, ".1/img/champion/", champion.id, ".png"));
            image.trim(7).resize(70);

            container.concat(image);

            if (champion.isTransformer()) {
                container.concat(image);
            }
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
        for (ChampionDefinition champion : champions) {
            List<String> skills = champion.skillSystem;

            buildSkillIconSet(champion.id, skills.get(0), skills.get(1), skills.get(2), skills.get(3), skills.get(4));

            if (champion.isTransformer()) {
                String id = champion.getTransformedName();

                if (skills.size() == 9) {
                    buildSkillIconSet(id, skills.get(0), skills.get(5), skills.get(6), skills.get(7), skills.get(8));
                } else {
                    buildSkillIconSet(id, skills.get(0), skills.get(5), skills.get(6), skills.get(7), skills.get(4));
                }
            }
        }
    }

    /**
     * <p>
     * Create specified champion's skill icon set.
     * </p>
     * 
     * @param champion
     * @param spells
     */
    private void buildSkillIconSet(String champion, String... skills) {
        EditableImage container = new EditableImage();

        for (int i = 0; i < skills.length; i++) {
            String file = (skills[i] + ".png").replaceAll("\\s", "%20");
            String directory = i == 0 ? "passive" : "spell";

            EditableImage image = new EditableImage(download("http://ddragon.leagueoflegends.com/cdn/", version.name, ".1/img/", directory, "/", file));
            image.resize(45);

            container.concat(image);
        }
        container.write(Resources.resolve("skill/" + champion + ".jpg"));

        log("Create ", champion, " skill icon set.");
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
        return collect(model, model);
    }

    /**
     * <p>
     * Collect all defined model in the specified definition class.
     * </p>
     * 
     * @param model
     * @return
     */
    private <M> List<M> collect(Class definition, Class<M> model) {
        List<M> items = new ArrayList();

        for (Field field : definition.getFields()) {
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
        // builder.buildItemIconSet();
        builder.buildChampionIconSet();
        // builder.buildSkillIconSet();
    }
}
