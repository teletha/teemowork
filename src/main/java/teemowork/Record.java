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
import jsx.ui.Style;
import jsx.ui.Widget;
import jsx.ui.piece.Button;
import jsx.ui.piece.Input;
import jsx.ui.piece.RadioBox;
import jsx.ui.piece.Select;
import jsx.ui.piece.UI;
import kiss.Events;
import kiss.I;
import teemowork.api.GameAPI;
import teemowork.model.Region;

/**
 * @version 2015/10/27 14:10:55
 */
public class Record extends Widget {

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
    protected void virtualize() {
        box($.MatchResultList, contents(GameAPI.getLatestMatches(), match -> {
            box($.MatchResult, () -> {
                text(match.matchType);
            });
        }));
    }

    /**
     * @version 2015/10/19 18:51:45
     */
    private static class $ extends StyleDescriptor {

        static Style MatchResultList = () -> {
            display.block();
        };

        static Style MatchResult = () -> {
            display.flex();
            font.size.small();
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
