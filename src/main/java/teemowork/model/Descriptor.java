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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;
import teemowork.model.variable.VariableResolver.Diff;

/**
 * @version 2016/09/12 21:47:06
 */
public abstract class Descriptor<T extends Descriptor> {

    /** The target object to describe. */
    protected final Describable describable;

    /** The version of this descriptor. */
    public final Version version;

    /** The ability description. */
    private List passive = new ArrayList();

    /** The ability description. */
    private List active = new ArrayList();

    /** The flag for initialization of variable pool. */
    private boolean initializable;

    /** The variable store. */
    private Map<String, Variable> variables = new HashMap();

    /**
     * <p>
     * Define descriptor.
     * </p>
     * 
     * @param previous
     */
    protected Descriptor(Describable describable, Version version) {
        this.describable = describable;
        this.version = version;
    }

    /**
     * <p>
     * Helper method to update.
     * </p>
     * 
     * @param version
     * @return
     */
    public T update(Version version) {
        return (T) describable.update(version);
    }

    /**
     * <p>
     * Retrieve passive text.
     * </p>
     * 
     * @return
     */
    public final List getPassive() {
        List tokens = new ArrayList();

        for (Object token : passive) {
            if (token instanceof VariableReference) {
                tokens.add(variables.get(token.toString()));
            } else {
                tokens.add(token);
            }
        }
        return tokens;
    }

    /**
     * <p>
     * Write passive ability.
     * </p>
     * 
     * @param text
     * @return
     */
    protected final T passive(Object... texts) {
        passive = parse(texts);

        // Chainable API
        return (T) this;
    }

    /**
     * <p>
     * Test descriptor type.
     * </p>
     * 
     * @return A result.
     */
    public final boolean isActive() {
        return active.size() != 0;
    }

    /**
     * <p>
     * Retrieve active text.
     * </p>
     * 
     * @return
     */
    public final List getActive() {
        List tokens = new ArrayList();

        for (Object token : active) {
            if (token instanceof VariableReference) {
                tokens.add(variables.get(token.toString()));
            } else {
                tokens.add(token);
            }
        }
        return tokens;
    }

    /**
     * <p>
     * Write active ability.
     * </p>
     * 
     * @param text
     * @return
     */
    protected final T active(Object... texts) {
        active = parse(texts);

        // Chainable API
        return (T) this;
    }

    /**
     * <p>
     * Parse skill text.
     * </p>
     * 
     * @param tokens A list of text tokens.
     * @param text A skill text.
     */
    private List parse(Object... texts) {
        List tokens = new ArrayList();

        for (Object text : texts) {
            if (text instanceof String) {
                for (String token : ((String) text).split("[\\{\\}<>]")) {
                    if (token.equals("br")) {
                        tokens.add("\r\n");
                    } else if (token.length() == 0 || !isDigit(token)) {
                        tokens.add(token);
                    } else {
                        tokens.add(new VariableReference(token));
                    }
                }
            } else {
                tokens.add(text);
            }
        }
        return tokens;
    }

    /**
     * <p>
     * Helper method to check text type.
     * </p>
     * 
     * @param text
     * @return
     */
    private boolean isDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @return A chainable API.
     */
    protected final T variable(int id, Status status) {
        return variable(id, status, 0);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @return A chainable API.
     */
    protected final T variable(int id, Status status, double base) {
        return variable(id, status, base, 0);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @return A chainable API.
     */
    protected final T variable(int id, Status status, double base, double diff) {
        return variable(id, status, base, diff, null, (Variable) null);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param resolver A resolver.
     * @return Chainable API.
     */
    protected final T variable(int id, Status status, VariableResolver resolver) {
        return variable(id, status, resolver, null, null);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @return A chainable API.
     */
    protected final T variable(int id, Status status, Variable amplifier) {
        return variable(id, status, 0, 0, amplifier);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param amplifiers A list of amplifiers.
     * @return Chainable API.
     */
    protected final T variable(int id, Status status, double base, double diff, Variable... amplifiers) {
        return variable(id, status, new Diff(base, diff, describable.getMaxLevel()), amplifiers);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param first A first amplifier.
     * @param second A second amplifier.
     * @return Chainable API.
     */
    protected final T variable(int id, Status status, double base, double diff, Variable first, VariableResolver second) {
        return variable(id, status, base, diff, first, new Variable(Status.Value, second));
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param resolver A resolver.
     * @param first A first amplifier.
     * @return Chainable API.
     */
    protected final T variable(int id, Status status, VariableResolver resolver, Variable first) {
        return variable(id, status, resolver, first, null);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param resolver A resolver.
     * @param first A first amplifier.
     * @param second A second amplifier.
     * @return Chainable API.
     */
    protected final T variable(int id, Status status, VariableResolver resolver, Variable... amplifiers) {
        Variable variable = new Variable(status, resolver);

        for (Variable amplifier : amplifiers) {
            variable.add(amplifier);
        }

        if (id < 0) {
            id *= -1;
            variable.setConditional();
        }

        if (initializable) {
            initializable = false;
            variables = new HashMap();
        }
        variables.put(String.valueOf(id), variable);

        return (T) this;
    }

    /**
     * @version 2013/03/16 13:53:03
     */
    private static class VariableReference {

        /** The variable name. */
        private final String name;

        /**
         * @param name
         */
        private VariableReference(String name) {
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
}
