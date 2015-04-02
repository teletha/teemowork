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
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2013/01/10 2:36:58
 */
public class ChampionDetail2 extends Page {

    /** The your custom build. */
    private Build build;

    /**
     * Build page.
     * 
     * @param champion
     */
    @PageInfo(path = "Champion2/*")
    public ChampionDetail2(String name) {
        this(Champion.getByName(name));
    }

    /**
     * Build page.
     * 
     * @param champion
     */
    public ChampionDetail2(Champion champion) {
        if (champion == null) {
            throw new Error();
        }
        this.build = new Build(champion);

        build.subscribe(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        Element child = root.child("div");

        ChampionDetailWidget widget = Widget.of(ChampionDetailWidget.class, build);
        widget.renderIn(child);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Champion2/" + build.champion.systemName;
    }
}
