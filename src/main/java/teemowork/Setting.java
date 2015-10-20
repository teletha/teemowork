/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static jsx.ui.StructureDescriptor.*;

import java.util.Locale;

import jsx.style.StyleDescriptor;
import jsx.ui.ModelValue;
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.piece.Input;
import jsx.ui.piece.RadioBox;
import jsx.ui.piece.UI;
import kiss.I;

/**
 * @version 2015/10/19 18:42:13
 */
public class Setting extends Widget {

    /** The user preference. */
    private final @ModelValue UserPreference preference = I.make(UserPreference.class);

    /** The configuration item. */
    private final Input summerName = UI.input(preference.summonerName);

    /** The configuration item. */
    private final RadioBox championEnglish = UI.radiobox(preference.localeChampion, Locale.ENGLISH, "英語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox championJapanease = UI.radiobox(preference.localeChampion, Locale.JAPANESE, "日本語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox skillEnglish = UI.radiobox(preference.localeSkill, Locale.ENGLISH, "英語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox skillJapanease = UI.radiobox(preference.localeSkill, Locale.JAPANESE, "日本語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox itemEnglish = UI.radiobox(preference.localeItem, Locale.ENGLISH, "英語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox itemJapanease = UI.radiobox(preference.localeItem, Locale.JAPANESE, "日本語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox statusEnglish = UI.radiobox(preference.localeStatus, Locale.ENGLISH, "英語").style($.SettingBox);

    /** The configuration item. */
    private final RadioBox statusJapanease = UI.radiobox(preference.localeStatus, Locale.JAPANESE, "日本語").style($.SettingBox);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        text($.CategoryName, "サモナー");
        box($.Item, () -> {
            text($.ItemName, "名前");
            box(summerName);
        });

        text($.CategoryName, "表記言語");
        box($.Item, () -> {
            text($.ItemName, "チャンピオン名");
            box(championEnglish, championJapanease);
        });
        box($.Item, () -> {
            text($.ItemName, "スキル名");
            box(skillEnglish, skillJapanease);
        });
        box($.Item, () -> {
            text($.ItemName, "アイテム名");
            box(itemEnglish, itemJapanease);
        });
        box($.Item, () -> {
            text($.ItemName, "ステータス名");
            box(statusEnglish, statusJapanease);
        });
    }

    /**
     * @version 2015/10/19 18:51:45
     */
    private static class $ extends StyleDescriptor {

        static Style CategoryName = () -> {
            display.block();
            font.weight.bold();
            margin.bottom(0.5, em);

            notFirstChild(() -> {
                margin.top(1, em);
            });
        };

        static Style Item = () -> {
            display.flex();
            font.size.small();
            margin.top(0.5, em);
        };

        static Style ItemName = () -> {
            display.block();
            box.width(10, em);
        };

        static Style SettingBox = () -> {
            margin.right(2, em);
        };
    }
}
