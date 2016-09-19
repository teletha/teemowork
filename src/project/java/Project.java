/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
public class Project extends bee.api.Project {

    {
        product("npc", "Teemowork", "1.0");

        require("npc", "booton", "0.1");
        require("npc", "antibug", "0.3").atTest();
        require("org.glassfish", "javax.json", "1.0.4");
        require("icy.manipulator", "IcyManipulator", "0.1");

        repository("https://repo.eclipse.org/content/repositories/egit-releases/");
    }
}
