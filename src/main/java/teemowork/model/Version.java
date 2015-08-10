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

import java.util.ArrayList;
import java.util.List;

import jsx.event.Publishable;

/**
 * @version 2013/12/13 9:11:59
 */
public enum Version {

    P0000("Release", 2009, 10, 27),

    P506("5.6", 2015, 3, 25),

    P513("5.13", 2015, 7, 9),

    P514("5.14", 2015, 7, 22),

    P515("5.15", 2015, 8, 5),

    PBE("Public Beta Environment", 2013, 1, 26);

    /** The latest stable version. */
    public static final Version Latest = P515;

    /** The selected version. */
    private static Version selection = Latest;

    /** The version name. */
    public final String name;

    /** The released year. */
    public final int year;

    /** The released month. */
    public final int month;

    /** The released day. */
    public final int day;

    /** The patch info. */
    public final List<Describable> info = new ArrayList();

    /**
     * <p>
     * Create new version.
     * </p>
     * 
     * @param name A name.
     * @param year The released year.
     * @param month The released month.
     * @param day The released day.
     */
    Version(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * <p>
     * Compare version.
     * </p>
     * 
     * @param other
     * @return
     */
    public boolean isLessThan(Version other) {
        return compareTo(other) == -1;
    }

    /**
     * <p>
     * Record patch info.
     * </p>
     * 
     * @param describable
     */
    protected void record(Describable describable) {
        info.add(describable);
    }

    /**
     * <p>
     * Set the current selected version.
     * </p>
     * 
     * @param version
     */
    public static void setSelection(Version version) {
        if (version != null) {
            selection = version;

            Publishable.Global.publish(selection);
        }
    }

    /**
     * <p>
     * Set the current selected version.
     * </p>
     */
    public static Version getSelection() {
        return selection;
    }
}
