
/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */

import java.nio.file.Files;

import bee.api.Command;
import bee.api.Task;
import booton.util.HTMLWriter;
import filer.Filer;
import kiss.I;
import kiss.XML;

/**
 * @version 2015/09/29 3:02:24
 */
public class Site extends Task {

    /**
     * <p>
     * Update application related files.
     * </p>
     * 
     * @throws Exception
     */
    @Command("Update application related files.")
    public void update() throws Exception {
        Filer.copy(Filer.locate("application.js"), Filer.locate("site.js"));

        XML xml = I.xml(Filer.locate("application.html"));

        for (XML js : xml.find("script[src=\"application.js\"]")) {
            js.attr("src", "site.js");
        }

        new HTMLWriter(Files.newBufferedWriter(Filer.locate("index.html"), I.$encoding)).write(xml);

        ui.talk("Update application related files, plz commit these files.");
    }
}
