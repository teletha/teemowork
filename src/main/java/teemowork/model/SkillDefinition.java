/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

/**
 * @version 2015/07/23 12:26:01
 */
public interface SkillDefinition {

    /**
     * <p>
     * Write champion's skill definition.
     * </p>
     * 
     * @param passive
     * @param q
     * @param w
     * @param e
     * @param r
     */
    void define(Skill passive, Skill q, Skill w, Skill e, Skill r);
}
