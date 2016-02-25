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

/**
 * @version 2013/12/13 9:11:59
 */
public enum Version {

    P301("3.1", 2013, 2, 1),

    P302("3.2", 2013, 2, 13),

    P303("3.3", 2013, 3, 1),

    P304("3.4", 2013, 3, 19),

    P305("3.5", 2013, 3, 28),

    P306("3.6", 2013, 4, 30),

    P307("3.7", 2013, 5, 15),

    P308("3.8", 2013, 6, 13),

    P309("3.9", 2013, 7, 9),

    P310("3.10", 2013, 7, 30),

    P311("3.11", 2013, 9, 4),

    P312("3.12", 2013, 10, 1),

    P313("3.13", 2013, 10, 29),

    P314("3.14", 2013, 11, 20),

    P315("3.15", 2013, 12, 13),

    P401("4.1", 2014, 1, 15),

    P402("4.2", 2014, 2, 10),

    P403("4.3", 2014, 2, 27),

    P404("4.4", 2014, 3, 18),

    P405("4.5", 2014, 4, 3),

    P406("4.6", 2014, 4, 21),

    P407("4.7", 2014, 5, 8),

    P408("4.8", 2014, 5, 22),

    P409("4.9", 2014, 6, 4),

    P410("4.12", 2014, 6, 18),

    P411("4.11", 2014, 7, 2),

    P412("4.12", 2014, 7, 16),

    P413("4.13", 2014, 7, 30),

    P414("4.14", 2014, 8, 13),

    P415("4.15", 2014, 8, 27),

    P416("4.16", 2014, 9, 10),

    P417("4.17", 2014, 9, 25),

    P418("4.18", 2014, 10, 9),

    P419("4.19", 2014, 11, 5),

    P420("4.20", 2014, 11, 20),

    P421("4.21", 2014, 12, 10),

    P501("5.1", 2015, 1, 15),

    P502("5.2", 2015, 1, 28),

    P503("5.3", 2015, 2, 11),

    P504("5.4", 2015, 2, 25),

    P505("5.5", 2015, 3, 12),

    P506("5.6", 2015, 3, 25),

    P507("5.7", 2015, 3, 25),

    P508("5.8", 2015, 4, 8),

    P509("5.9", 2015, 4, 28),

    P510("5.10", 2015, 5, 28),

    P511("5.11", 2015, 6, 10),

    P512("5.12", 2015, 6, 24),

    P513("5.13", 2015, 7, 9),

    P514("5.14", 2015, 7, 22),

    P515("5.15", 2015, 8, 5),

    P516("5.16", 2015, 8, 20),

    P517("5.17", 2015, 9, 2),

    P518("5.18", 2015, 9, 16),

    P519("5.19", 2015, 9, 30),

    P520("5.20", 2015, 10, 14),

    P521("5.21", 2015, 10, 29),

    P522("5.22", 2015, 11, 11),

    P523("5.23", 2015, 11, 24),

    P524("5.24", 2015, 12, 9),

    P601("6.1", 2016, 1, 14),

    P602("6.2", 2016, 1, 28),

    P603("6.3", 2016, 2, 10),

    P604("6.4", 2016, 2, 25),

    PBE("Public Beta Environment", 2013, 1, 26);

    /** The latest stable version. */
    public static final Version Latest = P604;

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
