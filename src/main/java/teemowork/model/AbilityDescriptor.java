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

import java.util.List;

/**
 * @version 2016/09/12 21:46:53
 */
public class AbilityDescriptor extends Descriptor<AbilityDescriptor> {

    /** The unique flag. */
    private boolean unique = true;

    /** The aura flag. */
    private boolean aura = false;

    /**
     * <p>
     * Create new item ability.
     * </p>
     * 
     * @param name
     * @param unique
     */
    AbilityDescriptor(Ability ability, Version version) {
        super(ability, version);
    }

    /**
     * <p>
     * Make as aura.
     * </p>
     * 
     * @param range
     * @return
     */
    AbilityDescriptor aura(String text) {
        this.aura = true;
        this.unique = true;

        return passive(text);
    }

    /**
     * <p>
     * Is this ability aura?
     * </p>
     * 
     * @return
     */
    public boolean isAura() {
        return aura;
    }

    /**
     * <p>
     * Make as unique.
     * </p>
     * 
     * @return
     */
    AbilityDescriptor ununique() {
        this.unique = false;

        return this;
    }

    /**
     * <p>
     * Is this ability aura?
     * </p>
     * 
     * @return
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * <p>
     * Retrieve description.
     * </p>
     * 
     * @return
     */
    public final List getDescription() {
        return isActive() ? getActive() : getPassive();
    }
}
