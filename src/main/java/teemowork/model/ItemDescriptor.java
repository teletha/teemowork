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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 2016/09/12 21:47:16
 */
public class ItemDescriptor extends Descriptor<ItemDescriptor> {

    /** The value store. */
    private double[] values = new double[Status.values().length];

    /** The item build. */
    private int[] build = new int[0];

    /** The ability list. */
    private List<Ability> abilities = new ArrayList<>();

    /** The item status. */
    private boolean deprecated = false;

    /**
     * @param name
     */
    ItemDescriptor(Item item, Version version) {
        super(item, version);
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return A result.
     */
    public double get(Status status) {
        return values[status.ordinal()];
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    ItemDescriptor set(Status status, double value) {
        values[status.ordinal()] = value;

        return this;
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor health(double value) {
        return set(Health, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor healthRegen(double value) {
        return set(Hreg, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor healthRegenRatio(double value) {
        return set(HregRatio, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor mana(double value) {
        return set(Mana, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor manaRegen(double value) {
        return set(Mreg, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor manaRegenRatio(double value) {
        return set(MregRatio, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor ad(double value) {
        return set(AD, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor ap(double value) {
        return set(AP, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor ar(double value) {
        return set(AR, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor magicRegist(double value) {
        return set(MR, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor attackSpeed(double value) {
        return set(ASRatio, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor ms(double value) {
        return set(MSRatio, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor cdr(double value) {
        return set(CDR, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor spellVamp(double value) {
        return set(SV, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor lifeSteal(double value) {
        return set(LS, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor critical(double value) {
        return set(Critical, value);
    }

    /**
     * <p>
     * Set status.
     * </p>
     * 
     * @return Chainable API.
     */
    ItemDescriptor goldGeneration(double value) {
        return set(GoldPer10Sec, value);
    }

    /**
     * <p>
     * Get build items.
     * </p>
     * 
     * @return items.
     */
    public int[] getBuild() {
        return build;
    }

    /**
     * <p>
     * Get build items.
     * </p>
     * 
     * @return items.
     */
    public Item[] getBuildItem() {
        Item[] items = new Item[build.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = Item.of(build[i]);
        }
        return items;
    }

    /**
     * <p>
     * Set build items.
     * </p>
     * 
     * @param items
     * @return
     */
    ItemDescriptor build(int... items) {
        if (items != null) {
            this.build = items;
        }
        return this;
    }

    /**
     * <p>
     * Get special abilities.
     * </p>
     * 
     * @return Abilities.
     */
    public List<Ability> getAbilities() {
        return abilities;
    }

    /**
     * <p>
     * Make this item deprecated.
     * </p>
     * 
     * @return
     */
    ItemDescriptor deprecated() {
        this.deprecated = true;

        return this;
    }

    /**
     * <p>
     * Check whether this item is deprecated or not.
     * </p>
     * 
     * @return A result.
     */
    public boolean isDeprecated() {
        return deprecated;
    }

    /**
     * <p>
     * Add ability.
     * </p>
     * 
     * @param descriptor
     * @return
     */
    ItemDescriptor add(Ability ability) {
        this.abilities.add(ability);

        return this;
    }

    /**
     * <p>
     * Add ability.
     * </p>
     * 
     * @param descriptor
     * @return
     */
    ItemDescriptor add(Consumer<AbilityDescriptor> descriptor) {
        return add(null, descriptor);
    }

    /**
     * <p>
     * Add ability.
     * </p>
     * 
     * @param descriptor
     * @return
     */
    ItemDescriptor add(String name, Consumer<AbilityDescriptor> descriptor) {
        Ability ability = new Ability(name, descriptor);
        this.abilities.add(ability);

        descriptor.accept(ability.update(version));

        return this;
    }

    /**
     * <p>
     * Clear all abilities.
     * </p>
     * 
     * @return
     */
    ItemDescriptor clear() {
        abilities.clear();

        return this;
    }

    /**
     * <p>
     * Remoeve the specified ability.
     * </p>
     * 
     * @param ability
     * @return
     */
    ItemDescriptor remove(Ability ability) {
        abilities.remove(ability);

        return this;
    }
}
