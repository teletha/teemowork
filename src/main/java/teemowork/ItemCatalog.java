/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import jsx.ui.Declarables;
import jsx.ui.Widget;
import teemowork.model.Item;

/**
 * @version 2013/06/12 12:45:51
 */
public class ItemCatalog extends Widget {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Declarables virtualize2() {
        return new Declarables() {

            {
                box().contents(ItemView.class, Item.getAll());
            }
        };
    }
}
