/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import org.junit.Test;

import teemowork.ChampionComparingWidget;
import teemowork.model.Status;
import antibug.powerassert.PowerAssertOff;

/**
 * @version 2015/03/02 15:01:40
 */

public class DiffTest extends DiffTestBase {

    @Test
    @PowerAssertOff
    public void testname() {
        ChampionComparingWidget widget = Widget.of(ChampionComparingWidget.class);
        VirtualElement first = virtualize(widget);

        widget.sortType.setValue(Status.Health);
        VirtualElement second = virtualize(widget);
        assertDiff(first, second, 2);

        widget.sortType.setValue(Status.AD);
        VirtualElement third = virtualize(widget);
        assertDiff(second, third, 1);
    }
}
