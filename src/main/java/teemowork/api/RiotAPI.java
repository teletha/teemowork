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

import js.lang.NativeFunction;
import js.lang.NativeXMLHttpRequest;
import kiss.Events;
import kiss.I;
import teemowork.UserPreference;

/**
 * @version 2015/10/20 22:22:19
 */
public class RiotAPI {

    /** The user setting. */
    private static final UserPreference preference = I.make(UserPreference.class);

    /** The API key. */
    private static final String API_KEY = "d82a93fe-1848-4692-895d-f194e928ed87";

    /**
     * <p>
     * Search user by name.
     * </p>
     * 
     * @return
     */
    public static Events<RiotUser> user() {
        return parse(RiotUser.class, "/api/lol/" + preference.region.getValue().code + "/v1.4/summoner/by-name/" + preference.name.get());
    }

    /**
     * <p>
     * Paser Riot API.
     * </p>
     * 
     * @param type
     * @param uri
     * @return
     */
    private static <M> Events<M> parse(Class<M> type, String uri) {
        return new Events<M>(observer -> {
            NativeXMLHttpRequest request = new NativeXMLHttpRequest();
            request.open("GET", "https://na.api.pvp.net/" + uri + "?api_key=" + API_KEY);
            request.send();
            request.addEventListener("load", new NativeFunction(() -> {
                String text = request.responseText();
                int start = text.indexOf(":{") + 1;
                int end = text.lastIndexOf("}}") + 1;
                observer.accept(I.read(text.subSequence(start, end), I.make(type)));
            }));

            return () -> {
                request.abort();
            };
        });
    }

    /**
     * @version 2015/10/20 22:27:30
     */
    public static class RiotUser {

        /** The user id. */
        public int id;

        /** The user name. */
        public String name;

        /** The user icon id. */
        public int profileIconId;

        /** The user level. */
        public int summonerLevel;
    }
}
