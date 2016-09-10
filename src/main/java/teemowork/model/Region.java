/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

/**
 * @version 2015/10/20 17:04:54
 */
public enum Region {

    BR("Brazil"),

    EUNE("Europa East"), EUW("Europa West"), JP("Japan"), KR("Korea"), LAN("Latin America North"), LAS("Latin America South"),

    NA("North America"), OCE("Oceania"), RU("Russia"), TR("Turkey");

    /** The human-readable name. */
    public final String name;

    /** The region code. */
    public final String code;

    /**
     * <p>
     * Create Region with human-readable name.
     * </p>
     * 
     * @param label
     */
    private Region(String name) {
        this.name = name;
        this.code = name().toLowerCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
