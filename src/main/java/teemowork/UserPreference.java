/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.util.Locale;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.Manageable;
import kiss.Preference;
import kiss.Variable;
import teemowork.model.Region;

/**
 * @version 2015/10/19 18:43:13
 */
@Manageable(lifestyle = Preference.class)
public class UserPreference {

    /** The available locales. */
    public static final Locale[] AvailableLocales = {Locale.ENGLISH, Locale.JAPANESE};

    /** The user. */
    public final Variable<Region> region = Variable.of(Region.NA);

    /** The user. */
    public final StringProperty name = new SimpleStringProperty();

    /** The user language. */
    public final Variable<Locale> localeChampion = Variable.of(Locale.ENGLISH);

    /** The user language. */
    public final Variable<Locale> localeSkill = Variable.of(Locale.ENGLISH);

    /** The user language. */
    public final Variable<Locale> localeItem = Variable.of(Locale.ENGLISH);

    /** The user language. */
    public final Variable<Locale> localeStatus = Variable.of(Locale.ENGLISH);
}
