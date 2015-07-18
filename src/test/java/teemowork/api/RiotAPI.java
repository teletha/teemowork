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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonValue;

import kiss.I;
import kiss.model.Model;
import kiss.model.Property;
import teemowork.model.Version;

/**
 * @version 2015/07/13 12:31:40
 */
public class RiotAPI {

    /** The URI of data dragon site. */
    private static final String DRAGON_URL = "http://ddragon.leagueoflegends.com/cdn/";

    /** The Riot API key. */
    private static final String key = "ad37a9e0-2e34-4849-979b-effce8a8a477";

    /**
     * <p>
     * Parse defined data of the specified version and locale.
     * </p>
     * 
     * @param modelClass
     * @param version
     * @param locale
     * @return
     */
    public static <M> M parse(Class<M> modelClass, Version version, Locale locale) {
        try {
            String uri = DRAGON_URL + version.name + ".1/data/" + locale + "/" + modelClass.getSimpleName()
                    .replaceAll("Definition[s]?", ".json")
                    .toLowerCase();

            M m = I.make(modelClass);
            Model model = Model.load(m.getClass());
            return parase(model, m, Json
                    .createReader(new InputStreamReader(new URL(uri).openConnection().getInputStream())).readObject());
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Helper method to traverse json structure using Java Object {@link Model}.
     * </p>
     *
     * @param <M> A current model type.
     * @param model A java object model.
     * @param java A java value.
     * @param js A javascript value.
     * @return A restored java object.
     */
    private static <M> M parase(Model model, M java, JsonValue js) {
        switch (js.getValueType()) {
        case ARRAY:
            JsonArray array = (JsonArray) js;

            for (int i = 0; i < array.size(); i++) {
                parse(model, java, array.get(i), model.getProperty(String.valueOf(i)));
            }
            break;

        case OBJECT:
            JsonObject object = (JsonObject) js;

            for (String id : object.keySet()) {
                parse(model, java, object.get(id), model.getProperty(id));
            }
            break;
        }

        // API definition
        return java;
    }

    private static void parse(Model model, Object java, JsonValue js, Property property) {
        if (property != null) {
            // calculate value
            Object value;
            Class type = property.model.type;

            // convert value
            if (property.isAttribute()) {

                if (js instanceof JsonString) {
                    value = I.transform(((JsonString) js).getString(), type);
                } else {
                    value = I.transform(js.toString(), type);
                }
            } else {
                value = parase(property.model, I.make(type), js);
            }

            model.set(java, property, value);
        }
    }

    public static ChampionList getChampionList() {
        try {
            URL url = new URL("https://na.api.pvp.net/api/lol/static-data/na/v1.2/champion?api_key=" + key);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

            return I.read(reader, I.make(ChampionList.class));
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2015/07/13 12:39:15
     */
    public static class ChampionList {

        public String type;

        public String version;

        public Map<String, ChampionInfo> data = new TreeMap();
    }

    /**
     * @version 2015/07/13 12:40:52
     */
    public static class ChampionInfo {

        public int id;

        public String key;

        public String name;

        public String title;

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ChampionInfo [id=" + id + ", name=" + name + "]";
        }
    }
}