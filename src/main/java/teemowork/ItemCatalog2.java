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

import js.dom.DocumentFragment;
import js.dom.Element;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.ui.Widget;

/**
 * @version 2013/06/12 12:45:51
 */
public class ItemCatalog2 extends Page {

    /**
     * 
     */
    @PageInfo(path = "ItemCatalog2")
    public ItemCatalog2() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        Element e = root.child("div");

        Widget widget = Widget.of(ItemCatalogWidget.class);

        widget.renderIn(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ItemCatalog2";
    }
}
