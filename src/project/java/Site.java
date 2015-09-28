
/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import bee.api.Command;
import bee.api.Task;
import booton.util.HTMLWriter;
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
        I.copy(I.locate("application.js"), I.locate("site.js"));

        XML xml = I.xml(I.locate("application.html"));

        for (XML js : xml.find("script[src=\"application.js\"]")) {
            js.attr("src", "site.js");
        }
        xml.to(new HTMLWriter(Files.newBufferedWriter(I.locate("index.html"), StandardCharsets.UTF_8)));

        ui.talk("Update application related files, plz commit these files.");
    }
}
