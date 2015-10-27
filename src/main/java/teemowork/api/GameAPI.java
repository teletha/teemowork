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

import static js.lang.Global.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import js.lang.NativeFunction;
import js.lang.NativeXMLHttpRequest;
import kiss.Events;
import kiss.I;
import kiss.Manageable;
import kiss.Preference;
import teemowork.UserPreference;
import teemowork.model.Champion;

/**
 * @version 2015/10/20 22:22:19
 */
public class GameAPI {

    /** The user setting. */
    private static final UserPreference preference = I.make(UserPreference.class);

    /** The API key. */
    private static final String API_KEY = "d82a93fe-1848-4692-895d-f194e928ed87";

    /** The cache for the latest matches. */
    private static List<RiotMatch> latestMatches = new ArrayList();

    /**
     * <p>
     * Search user by name.
     * </p>
     * 
     * @return
     */
    public static Events<RiotUser> user() {
        return parse(RiotUser.class, "/api/lol/" + preference.region.getValue().code + "/v1.4/summoner/by-name/" + preference.name
                .get(), true, true);
    }

    /**
     * <p>
     * Retrieve matche history.
     * </p>
     * 
     * @param user
     * @return
     */
    public static Events<RiotMatchHistory> matchList(RiotUser user) {
        return parse(RiotMatchHistory.class, "/api/lol/" + preference.region
                .getValue().code + "/v2.2/matchlist/by-summoner/" + user.id, false, false);
    }

    /**
     * <p>
     * Retrieve matche info.
     * </p>
     * 
     * @param user
     * @return
     */
    public static Events<RiotMatch> match(MatchHistory history) {
        return parse(RiotMatch.class, "/api/lol/" + preference.region.getValue().code + "/v2.2/match/" + history.matchId, true, false);
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
    private static <M> Events<M> parse(Class<M> type, String uri, boolean useCache, boolean trim) {
        if (useCache) {
            String cache = localStorage.getItem(uri);

            if (cache != null) {
                return Events.from(I.read(cache, I.make(type)));
            }
        }
        return Events.from(uri).interval(2000, TimeUnit.MILLISECONDS, GameAPI.class).flatMap(url -> {
            return new Events<M>(observer -> {
                NativeXMLHttpRequest request = new NativeXMLHttpRequest();
                request.open("GET", "https://na.api.pvp.net/" + uri + "?api_key=" + API_KEY);
                request.send();
                request.addEventListener("load", new NativeFunction(() -> {
                    String text = request.responseText();

                    if (trim) {
                        int start = text.indexOf(":{") + 1;
                        int end = text.lastIndexOf("}}") + 1;
                        text = text.substring(start, end);
                    }

                    // At first, parse json
                    M parsed = I.read(text, I.make(type));

                    // Then, save json to avoid error
                    localStorage.setItem(uri, text);
                    observer.accept(parsed);
                }));

                return () -> {
                    request.abort();
                };
            });
        });
    }

    public static List<RiotMatch> getLatestMatches() {
        return latestMatches;
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

    /**
     * @version 2015/10/24 9:45:21
     */
    @Manageable(lifestyle = Preference.class)
    public static class RiotMatchHistory {

        /** The match history manager. */
        public List<MatchHistory> matches = new ArrayList();
    }

    /**
     * @version 2015/10/24 9:47:40
     */
    public static class MatchHistory {

        /** The game id. */
        public long matchId;

        /** The used champion id. */
        public int champion;

        /** The played lane. */
        public LaneType lane;

        /** The queue type. */
        public QueueType queue;

        /**
         * <p>
         * Find used champion.
         * </p>
         * 
         * @return
         */
        public Champion champion() {
            return Champion.getByKey(champion);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "MatchHistory [matchId=" + matchId + ", champion=" + champion() + ", lane=" + lane + ", queue=" + queue + "]";
        }
    }

    /**
     * @version 2015/10/24 11:30:39
     */
    public static enum LaneType {

        MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM;
    }

    /**
     * @version 2015/10/24 11:33:42
     */
    public static enum QueueType {
        RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5;
    }

    /**
     * @version 2015/10/24 12:11:29
     */
    public static class RiotMatch {

        /** The region code. */
        public String region;

        /** The matching type. */
        public String matchType;

        /** The creation date. */
        public long matchCreation;

        /** The list of participants. */
        public List<Participant> participants;

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "RiotMatch [region=" + region + ", matchType=" + matchType + ", matchCreation=" + matchCreation + ", participants=" + participants + "]";
        }
    }

    /**
     * @version 2015/10/24 12:15:13
     */
    public static class Participant {

        /** The riot champion key. */
        public int championId;

        /** The summoner id. */
        public long participantId;

        /** The summoner tier. */
        public String highestAchievedSeasonTier;

        /** The summoner spell 1. */
        public int spell1Id;

        /** The summoner spell 2. */
        public int spell2Id;

        public Champion champion() {
            return Champion.getByKey(championId);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "Participant [champion=" + champion() + ", participantId=" + participantId + ", highestAchievedSeasonTier=" + highestAchievedSeasonTier + "]";
        }
    }
}
