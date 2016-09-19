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

import static teemowork.model.Status.*;

import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;
import teemowork.model.variable.VariableResolver.Diff;

/**
 * @version 2016/09/12 21:46:19
 */
public abstract class Describable<T extends Descriptor> {

    /** The current processing object. */
    private static Describable current;

    /** The version manager. */
    private Descriptor descriptor;

    /**
     * <p>
     * Retrieve the maximum level of this object.
     * </p>
     * 
     * @return The maximum level.
     */
    public abstract int getMaxLevel();

    /**
     * <p>
     * Create new descriptor.
     * </p>
     * 
     * @param previous
     * @return
     */
    protected abstract T createDescriptor(Version current);

    /**
     * <p>
     * Retrieve a descriptor of the specified version.
     * </p>
     */
    public final T getDescriptor(Version version) {
        if (descriptor == null) {
            descriptor = createDescriptor(version);
        }
        return (T) descriptor;
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @return A descriptor of the specified version.
     */
    protected final T update(Version version) {
        // for helper methods
        current = this;

        // API definition
        return getDescriptor(version);
    }

    /**
     * <p>
     * Create skill AP amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AP rate.
     * @return
     */
    protected static final Variable level(double rate) {
        return amplify(Lv, rate);
    }

    /**
     * <p>
     * Create skill AP amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AP rate.
     * @return
     */
    protected static final Variable ap(double rate) {
        return amplify(AP, rate);
    }

    /**
     * <p>
     * Create skill AD amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AD rate.
     * @return
     */
    protected static final Variable ad(double rate) {
        return amplify(AD, rate);
    }

    /**
     * <p>
     * Create skill AD amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AD rate.
     * @return
     */
    protected static final Variable bounusAD(double rate) {
        return amplify(BounusAD, rate);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base) {
        return amplify(status, base, 0);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base, double diff) {
        return amplify(status, new Diff(base, diff, current.getMaxLevel()));
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, VariableResolver resolver, Variable... variables) {
        Variable variable = new Variable(status, resolver);

        if (variables != null) {
            for (Variable var : variables) {
                variable.add(var);
            }
        }
        return variable;
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base, double diff, Variable amplifier) {
        return amplify(status, base, diff, amplifier, null);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base, double diff, Variable first, Variable second) {
        Variable variable = amplify(status, base, diff);
        variable.add(first);
        variable.add(second);

        return variable;
    }
}
