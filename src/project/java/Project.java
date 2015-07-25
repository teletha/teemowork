/*
 * Copyright (C) 2014 Teemowork Development Team
 * 
 * Licensed under the BSD License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *          http://opensource.org/licenses/BSD-2-Clause
 */
public class Project extends bee.api.Project {

    {
        product("teemowork", "Teemowork", "1.0");

        require("npc", "booton", "0.1");
        require("org.glassfish", "javax.json", "1.0.4");
        require("icy.manipulator", "IcyManipulator", "0.1");

        require("com.google.code.gson", "gson", "2.3.1");
        require("org.eclipse.mylyn.github", "org.eclipse.egit.github.core", "4.0.0.201506090130-r");

        repository("https://repo.eclipse.org/content/repositories/egit-releases/");
    }
}
