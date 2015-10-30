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

import js.lang.NativeDate;
import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.style.value.Numeric;
import jsx.ui.Style;
import jsx.ui.Widget;
import kiss.Events;
import kiss.I;
import teemowork.api.GameAPI;
import teemowork.api.GameAPI.GameDto;
import teemowork.api.GameAPI.RawStatsDto;
import teemowork.model.Champion;

/**
 * @version 2015/10/27 14:10:55
 */
public class Record extends Widget {

    /** The user preference. */
    private final UserPreference preference = I.make(UserPreference.class);

    private final Events<GameDto> matches = GameAPI.user().flatMap(GameAPI::recent).flatMap(game -> Events.from(game.games));

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        box($.MatchResultList, contents(matches, match -> {
            box($.MatchResult, () -> {
                RawStatsDto stats = match.stats;
                Champion champion = Champion.getByKey(match.championId);

                box($.MatchInfo, () -> {
                    text($.MatchType, match.subType);
                    text($.MatchDate, format(match.createDate));
                    // text($.MatchDuration, format(match.));
                    text($.MatchEnd, match.stats.win ? "勝利" : "敗北");
                });

                box(Champion.Icon50.of(champion));

                box($.Score, () -> {
                    text($.ScoreValue, stats.championsKilled);
                    text($.Separator, "/");
                    text($.ScoreValue, stats.numDeaths);
                    text($.Separator, "/");
                    text($.ScoreValue, stats.assists);
                    text("(", stats.getKDA(), ")");
                });

                // box(contents(match.participants, participant -> {
                // box($.Participant, () -> {
                // box($.Champion.of(participant.champion()));
                //
                // ParticipantStats stats = participant.stats;
                // box($.Score, () -> {
                // text($.ScoreValue, stats.kills);
                // text($.Separator, "/");
                // text($.ScoreValue, stats.deaths);
                // text($.Separator, "/");
                // text($.ScoreValue, stats.assists);
                // });
                // });
                // }));
            });
        }));
    }

    private String format(long time) {
        NativeDate date = new NativeDate(time);

        return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日" + date.getHours() + "時" + date
                .getMinutes() + "分";
    }

    private String format(int time) {
        int second = time % 60;
        int minute = (time - second) / 60;

        return minute + "分" + second + "秒";
    }

    /**
     * @version 2015/10/19 18:51:45
     */
    private static class $ extends StyleDescriptor {

        private static final Numeric IconSize = new Numeric(22, px);

        private static final Numeric IconMargin = new Numeric(10, px);

        static Style MatchResultList = () -> {
            display.block();
        };

        static Style MatchResult = () -> {
            display.block();
            font.size.small();
            margin.bottom(2, em);
        };

        static Style MatchInfo = () -> {

        };

        static Style MatchType = () -> {
            font.weight.bold();
            margin.right(1.5, em);
        };

        static Style MatchDate = () -> {
            margin.right(1.5, em);
        };

        static Style MatchDuration = () -> {
            margin.right(1.5, em);
        };

        static Style MatchEnd = () -> {
            margin.right(1.5, em);
        };

        static Style Participant = () -> {
            display.block();
            box.width(10, em);
        };

        static ValueStyle<Champion> Champion = champion -> {
            display.inlineBlock();
            background.image("src/main/resources/teemowork/champions.jpg").cover().horizontal(champion.getIconPosition());
            box.size(IconSize);
            border.radius(2, px).color(rgb(50, 50, 50)).width(1, px).solid();
            cursor.pointer();
        };

        static Style Score = () -> {

        };

        static Style ScoreValue = () -> {
            display.inlineBlock();
            box.width(1.2, em);
            padding.horizontal(0.2, em);
        };

        static Style Separator = () -> {

        };

        static Style SettingBox = () -> {
            margin.right(2, em);
        };
    }
}
