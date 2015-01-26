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

import static js.lang.Global.*;
import static teemowork.TeemoworkTheme.*;
import jsx.application.Application;
import jsx.application.Header;
import jsx.application.Header.Menu;

/**
 * @version 2012/12/11 14:23:57
 */
public class Teemowork extends Application {

    public static void main(String[] args) {
        new Teemowork().main();
    }

    public void main() {
        document.documentElement().add(HTML);
        document.getElementById("Content").add(Content);

        Header nav = new Header();
        nav.add("< ^ v ^ > Teemowork", "");
        nav.add("Patch", "#history");

        Menu sub = nav.add("Champion", "#");
        sub.add("Compare", "#ChampionComparing");
        sub.add("Item", "#ItemCatalog");
        sub.add("Mastery", "#Mastery");
        sub.add("Rune", "#");

        nav.add("Builder", "#GridTest");
        nav.add("About", "#");
        nav.add("Contact", "#");
        // nav.add(new Select(Version.class, selected -> {
        // Version.setSelection(selected);
        // }));
    }
}
