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

import booton.css.CSS;

/**
 * @version 2013/03/17 0:05:57
 */
class DescriptionViewStyle {

    /** The skill icon size. */
    int SkillIconSize = 45;

    /** The level box height. */
    int LevelBoxHeight = 5;

    /**
     * @version 2013/02/06 20:03:25
     */
    class ComputedValue extends CSS {

        {
            font.weight.bolder();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Value extends CSS {

        {
            text.align.center();
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Separator extends CSS {

        {
            box.opacity(0.4);
            margin.horizontal(1, px);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Current extends CSS {

        {
            font.color(rgba(160, 123, 1, 1));
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Passive extends CSS {

        {
            margin.right(1, em);
        }
    }

    /**
     * @version 2013/02/06 20:03:25
     */
    class Amplifier extends CSS {

        {
            font.color(25, 111, 136);

            inBackOf(Value.class, () -> {
                margin.left(0.4, em);
            });

            inBackOf(Amplifier.class, () -> {
                margin.left(0.4, em);
            });
        }
    }
}
