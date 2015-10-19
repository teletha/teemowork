/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.util.Locale;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import jsx.ui.ModelValue;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2015/10/19 18:43:13
 */
@Manageable(lifestyle = Singleton.class)
public class UserPreference {

    /** The user language. */
    public final @ModelValue Property<Locale> localeChampion = new SimpleObjectProperty(Locale.ENGLISH);

    /** The user language. */
    public final @ModelValue Property<Locale> localeSkill = new SimpleObjectProperty(Locale.ENGLISH);

    /** The user language. */
    public final @ModelValue Property<Locale> localeItem = new SimpleObjectProperty(Locale.ENGLISH);

    /**
     * <p>
     * Check user
     * </p>
     * 
     * @return
     */
    public boolean isJapaneaseChampionName() {
        return localeChampion.equals(Locale.JAPANESE);
    }

    public boolean isJapaneaseItemName() {
        return localeChampion.equals(Locale.JAPANESE);
    }

    public boolean isJapaneaseSkillName() {
        return localeChampion.equals(Locale.JAPANESE);
    }
}
