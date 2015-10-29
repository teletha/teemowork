/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.api.RiotChampionData.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @version 2013/08/25 17:10:19
 */
public enum ChampionGroup {

    /** The built-in group. */
    Ranged(Ashe, Caitlyn, Corki, Draven, Ezreal, Graves, Jayce, Jinx, Kennen, Kindred, KogMaw, MissFortune, Quinn, Sivir, Teemo, Thresh,
            Tristana, TwistedFate, Twitch, Urgot, Varus, Vayne),

    Assasin(Ahri, Akali, Diana, Ekko, Evelynn, Fiora, Fizz, Kassadin, Katarina, Khazix, Leblanc, LeeSin, Malzahar, Nidalee, Pantheon,
            Rengar, Shaco, Talon, XinZhao, Yasuo, Zed),

    /** The built-in group. */
    ALL(Champion.getAll());

    /** The group members. */
    private final List<Build> members = new ArrayList();

    /**
     * @param members
     */
    private ChampionGroup(List<Champion> members) {
        for (Champion champion : members) {
            this.members.add(new Build(champion));
        }
    }

    /**
     * @param members
     */
    private ChampionGroup(Champion... members) {
        this(Arrays.asList(members));
    }

    /**
     * <p>
     * List up all champions by the specified sort.
     * </p>
     * 
     * @param health
     * @return
     */
    public List<Build> sortBy(Comparator<Build> sorter) {
        List<Build> sorted = new ArrayList(members);
        Collections.sort(sorted, sorter);
        return sorted;
    }
}
