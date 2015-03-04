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

import static teemowork.model.Champion.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @version 2013/08/25 17:10:19
 */
public class ChampionGroup {

    /** The built-in group. */
    public static final ChampionGroup RANGED = new ChampionGroup(Ashe, Caitlyn, Corki, Draven, Ezreal, Graves, Jayce, Jinx, Kennen, KogMaw, MissFortune, Quinn, Sivir, Teemo, Thresh, Tristana, TwistedFate, Twitch, Urgot, Varus, Vayne);

    /** The built-in group. */
    public static final ChampionGroup ALL = new ChampionGroup(Champion.getAll());

    /** The group members. */
    private final List<Champion> members = new ArrayList();

    /**
     * @param members
     */
    public ChampionGroup(List<Champion> members) {
        for (Champion champion : members) {
            this.members.add(champion);
        }
    }

    /**
     * @param members
     */
    public ChampionGroup(Champion... members) {
        this(Arrays.asList(members));
    }

    /**
     * <p>
     * Detct member.
     * </p>
     * 
     * @param champion
     * @return
     */
    public boolean contains(Champion champion) {
        return members.contains(champion);
    }

    /**
     * <p>
     * List up all champions by the specified sort.
     * </p>
     * 
     * @param health
     * @return
     */
    public List<Champion> sortBy(Status status, boolean descending) {
        Comparator<Champion> sorter;

        if (status == null) {
            // by name
            sorter = Comparator.comparing(champion -> champion.name);
        } else {
            // by status
            sorter = Comparator.comparingDouble(champion -> champion.getStatus(Version.Latest).get(status));
        }

        if (descending) {
            sorter = sorter.reversed();
        }

        List<Champion> sorted = new ArrayList(members);
        Collections.sort(sorted, sorter);
        return sorted;
    }
}
