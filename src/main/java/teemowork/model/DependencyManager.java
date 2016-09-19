/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 2013/03/12 10:43:36
 */
public class DependencyManager {

    /** The circular dependency manager. */
    private static final Set<Skill> dependencies = new HashSet();

    /**
     * <p>
     * Manage status dependency graph.
     * </p>
     * 
     * @param skill A target skill.
     * @return A result.
     */
    public static boolean use(Skill skill) {
        if (!dependencies.add(skill)) {
            if (skill == Champion.Vladimir.P || skill == Champion.Zed.W) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Manage status dependency graph.
     * </p>
     * 
     * @param skill A target skill.
     */
    public static void unuse(Skill skill) {
        dependencies.remove(skill);
    }
}
