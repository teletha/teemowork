/*
 * Copyright (C) 2012 Nameless Production Committee
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
 * @version 2012/12/26 13:06:59
 */
public class ChampionSelect extends Page {

    @PageInfo(path = "")
    public ChampionSelect() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        Element e = root.child("div");

        Widget widget = Widget.of(ChampionSelectWidget.class);

        widget.renderIn(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "";
    }
}
