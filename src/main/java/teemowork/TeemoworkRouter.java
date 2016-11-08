/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import jsx.ui.Widget;
import teemowork.model.Build;
import teemowork.model.Champion;

/**
 * @version 2016/11/06 11:18:15
 */
public interface TeemoworkRouter {

    default Widget champion() {
        return new ChampionSelect(this);
    }

    default Widget champion(Champion champion) {
        return new ChampionDetail(new Build(champion));
    }

    default Widget championCompare() {
        return new ChampionComparing(this);
    }

    default Widget item() {
        return new ItemCatalog();
    }

    default Widget mastery() {
        return new MasteryBuilder();
    }

    default Widget record() {
        return new Record();
    }

    default Widget setting() {
        return new Setting();
    }
}