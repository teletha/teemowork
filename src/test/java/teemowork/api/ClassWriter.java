/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.api;

/**
 * @version 2015/07/13 14:58:21
 */
public class ClassWriter {

    /** The end of line. */
    private final String EOL = "\r\n";

    /** The code buffer. */
    private final StringBuilder code = new StringBuilder();

    /**
     * 
     */
    public void writeLicense() {
        code.append("/*").append(EOL);
        code.append(" * Copyright (C) 2015 Nameless Production Committee").append(EOL);
        code.append(" *").append(EOL);
        code.append(" * Licensed under the MIT License (the \"License\");").append(EOL);
        code.append(" * you may not use this file except in compliance with the License.").append(EOL);
        code.append(" * You may obtain a copy of the License at").append(EOL);
        code.append(" *").append(EOL);
        code.append(" *          http://opensource.org/licenses/mit-license.php").append(EOL);
        code.append(" */").append(EOL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code.toString();
    }
}
