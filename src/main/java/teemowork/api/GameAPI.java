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
                .getValue().code + "/v2.2/matchlist/by-summoner/" + user.id, true, false);
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
        /** Ranked 5x5 */
        RANKED_SOLO_5x5("Rank Solo"), RANKED_PREMADE_5x5("Rank Duo"), RANKED_TEAM_5x5("Rank Team"),

        /** Ranked 3x3 */
        RANKED_PREMADE_3x3("Rank 3v3"), RANKED_TEAM_3x3("Rank Team 3v3"),

        /** Normal Game */
        NORMAL_5x5_BLIND("ノーマル"), NORMAL_5x5_DRAFT("ノーマル"), NORMAL_3x3("ノーマル3v3"),

        /** Custom Game */
        CUSTOM("カスタム"),

        /** Bot Game */
        BOT_5x5("ボット");

        /** The game type name. */
        public final String name;

        /**
         * @param name
         */
        private QueueType(String name) {
            this.name = name;
        }
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

        /** The duration time. */
        public int matchDuration;

        /** The list of participants. */
        public List<Participant> participants;

        /** The queue type. */
        public QueueType queueType;

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

        /** The status. */
        public ParticipantStats stats;

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

    /**
     * @version 2015/10/29 23:02:57
     */
    public static class ParticipantStats {

        /** The stats. */
        public int assists;

        /** The stats. */
        public int champLevel;

        /** The stats. */
        public int deaths;

        /** The stats. */
        public int doubleKills;

        /** The stats. */
        public int goldEarned;

        /** The stats. */
        public int goldSpent;

        /** The stats. */
        public int item0;

        /** The stats. */
        public int item1;

        /** The stats. */
        public int item2;

        /** The stats. */
        public int item3;

        /** The stats. */
        public int item4;

        /** The stats. */
        public int item5;

        /** The stats. */
        public int item6;

        /** The stats. */
        public int killingSprees;

        /** The stats. */
        public int kills;

        /** The stats. */
        public int largestCriticalStrike;

        /** The stats. */
        public int largestKillingSpree;

        /** The stats. */
        public int largestMultiKill;

        /** The stats. */
        public int magicDamageDealt;

        /** The stats. */
        public int magicDamageDealtToChampions;

        /** The stats. */
        public int magicDamageTaken;

        /** The stats. */
        public int minionsKilled;

        /** The stats. */
        public int neutralMinionsKilled;

        /** The stats. */
        public int neutralMinionsKilledEnemyJungle;

        /** The stats. */
        public int neutralMinionsKilledTeamJungle;

        /** The stats. */
        public int pentaKills;

        /** The stats. */
        public int physicalDamageDealt;

        /** The stats. */
        public int physicalDamageDealtToChampions;

        /** The stats. */
        public int physicalDamageTaken;

        /** The stats. */
        public int quadraKills;

        /** The stats. */
        public int sightWardsBoughtInGame;

        /** The stats. */
        public int totalDamageDealt;

        /** The stats. */
        public int totalDamageDealtToChampions;

        /** The stats. */
        public int totalDamageTaken;

        /** The stats. */
        public int totalHeal;

        /** The stats. */
        public int totalTimeCrowdControlDealt;

        /** The stats. */
        public int totalUnitsHealed;

        /** The stats. */
        public int towerKills;

        /** The stats. */
        public int tripleKills;

        /** The stats. */
        public int trueDamageDealt;

        /** The stats. */
        public int trueDamageDealtToChampions;

        /** The stats. */
        public int trueDamageTaken;

        /** The stats. */
        public int unrealKills;

        /** The stats. */
        public int visionWardsBoughtInGame;

        /** The stats. */
        public int wardsKilled;

        /** The stats. */
        public int wardsPlaced;

        /** The stats. */
        public boolean winner;
    }
}
