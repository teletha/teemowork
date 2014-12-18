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

/**
 * @version 2013/02/14 13:09:54
 */
public enum SkillType {

    Passive,

    Active(""),

    Toggle,

    ToggleForAttack("TOGGLE"),

    Channel;

    private String name;

    /**
     */
    private SkillType() {
        name = name().toUpperCase();
    }

    /**
     * @param name
     */
    private SkillType(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
