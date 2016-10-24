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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import js.dom.Element;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import kiss.I;
import teemowork.UserPreference;
import teemowork.api.RiotItemData;

/**
 * @version 2016/09/12 21:33:44
 */
public class Item extends RiotItemData {

    /** The user settings. */
    private static final UserPreference preference = I.make(UserPreference.class);

    /** The counter for id. */
    private static int counter = 0;

    /** The item manager. */
    private static final List<Item> items = new ArrayList();

    /** The sequencial id. */
    public final int position;

    /** The item id. */
    public final int id;

    /** The item name. */
    private final String name;

    /** The item name. */
    private final String localized;

    /** The item buy cost. */
    public final int buyBaseCost;

    /** The item total buy cost. */
    public final int buyTotalCost;

    /** The item sell cost. */
    public final int sell;

    /**
     * Iten Definition
     */
    public Item(String name, String localizedName, int id, int buyBaseCost, int buyTotalCost, int sell, int[] from, int[] to, int imageNo, int imageX, int imageY, int depth, int health, float flatHealthRegen, int mana, int ad, int ar, int ap, int mr, int as, int ms, int crit, int ls, Consumer<ItemDescriptor> definition) {
        this.name = name;
        this.localized = localizedName;
        this.position = counter++;
        this.id = id;
        this.buyBaseCost = buyBaseCost;
        this.buyTotalCost = buyTotalCost;
        this.sell = sell;

        ItemDescriptor descriptor = this.update(Version.Latest)
                .build(from)
                .health(health)
                .healthRegen(flatHealthRegen)
                .mana(mana)
                .ad(ad)
                .ar(ar)
                .ap(ap)
                .magicRegist(mr)
                .attackSpeed(as)
                .ms(ms)
                .critical(crit)
                .lifeSteal(ls);

        definition.accept(descriptor);

        items.add(this);
    }

    /**
     * <p>
     * Return the name of this item.
     * </p>
     * 
     * @return
     */
    public String getName() {
        return preference.localeItem.is(Locale.ENGLISH) ? name : localized;
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/items.jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public Numeric getIconPosition() {
        return new Numeric(position / (counter - 1) * 100, Unit.percent);
    }

    /**
     * <p>
     * Apply icon image.
     * </p>
     */
    public void applyIcon(Element element) {
        element.css("background-image", "url(src/main/resources/teemowork/items.jpg)")
                .css("background-position", position / (counter - 1) * 100 + "% 0%")
                .css("background-size", "cover")
                .css("background-origin", "border-box");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ItemDescriptor createDescriptor(Version version) {
        return new ItemDescriptor(this, version);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * <p>
     * List up all Items.
     * </p>
     * 
     * @return
     */
    public static List<Item> all() {
        return items;
    }

    /**
     * <p>
     * Find Item by name.
     * </p>
     * 
     * @param name A Item name.
     * @return A matched Item.
     */
    public static Item of(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * <p>
     * Find Item by id.
     * </p>
     * 
     * @param id A Item id.
     * @return A matched Item.
     */
    public static Item of(int id) {
        for (Item item : items) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }
}
