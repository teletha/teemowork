/*
 * Copyright (C) 2016 Teemowork Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import java.util.Locale;

import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.ui.StructureDSL;
import jsx.ui.Widget;
import jsx.ui.piece.Button;
import jsx.ui.piece.Input;
import jsx.ui.piece.RadioBox;
import jsx.ui.piece.Select;
import jsx.ui.piece.UI;
import kiss.Events;
import kiss.I;
import teemowork.Setting.Styles;
import teemowork.api.GameAPI;
import teemowork.model.Region;

/**
 * @version 2015/10/20 16:52:02
 */
public class Setting extends Widget<Styles> {

    /** The user preference. */
    private final UserPreference preference = I.make(UserPreference.class);

    /** The configuration item. */
    private final Select<Region> summerRegion = UI.select(preference.region, Region.class);

    /** The configuration item. */
    private final Input summerName = UI.input(preference.name).invalidIf(String::isEmpty, "サモナーネームを入力して下さい。");

    /** The configuration item. */
    private final Button update = UI.button().label("次回更新可能時刻").disableIf(summerName.invalid).click(() -> {
        GameAPI.user().flatMap(GameAPI::matchList).flatMap(history -> Events.from(history.matches)).flatMap(GameAPI::match).to(t -> {
            System.out.println(t);
        });
    });

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
    protected StructureDSL virtualize() {
        return new StructureDSL() {

            {
                text($.CategoryName, "サモナー");
                box($.Item, () -> {
                    text($.ItemName, "地域");
                    box(summerRegion);
                });
                box($.Item, () -> {
                    text($.ItemName, "名前");
                    box(summerName);
                });
                box($.Item, () -> {
                    text($.ItemName, "更新");
                    box(update);
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
        };
    }

    /**
     * @version 2015/10/19 18:51:45
     */
    static class Styles extends StyleDSL {

        Style CategoryName = () -> {
            display.block();
            font.weight.bold();
            margin.bottom(0.5, em);

            not(firstChild(), () -> {
                margin.top(1, em);
            });
        };

        Style Item = () -> {
            display.flex();
            font.size.small();
            margin.top(0.5, em);
        };

        Style ItemName = () -> {
            display.block().width(10, em);
        };

        Style SettingBox = () -> {
            margin.right(2, em);
        };
    }
}
