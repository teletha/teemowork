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

import java.util.List;

import js.lang.NativeDate;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.style.ValueStyle;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.StructureDSL;
import jsx.ui.Widget;
import kiss.Events;
import kiss.I;
import teemowork.Record.Styles;
import teemowork.api.GameAPI;
import teemowork.api.GameAPI.GameDto;
import teemowork.api.GameAPI.RawStatsDto;
import teemowork.model.Champion;

/**
 * @version 2015/10/27 14:10:55
 */
public class Record extends Widget<Styles> {

    /** The user preference. */
    private final UserPreference preference = I.make(UserPreference.class);

    private final List<GameDto> matches = GameAPI.user().flatMap(GameAPI::recent).flatMap(game -> Events.from(game.games)).toList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected StructureDSL virtualize() {
        return new StructureDSL() {

            {
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

                        box($.Icon50.of(champion));

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
        };
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
     * @version 2016/09/18 22:46:48
     */
    static class Styles extends StyleDSL {

        private final Numeric IconSize = new Numeric(22, px);

        private final Numeric IconMargin = new Numeric(10, px);

        Style MatchResultList = () -> {
            display.block();
        };

        Style MatchResult = () -> {
            display.block();
            font.size.small();
            margin.bottom(2, em);
        };

        Style MatchInfo = () -> {

        };

        Style MatchType = () -> {
            font.weight.bold();
            margin.right(1.5, em);
        };

        Style MatchDate = () -> {
            margin.right(1.5, em);
        };

        Style MatchDuration = () -> {
            margin.right(1.5, em);
        };

        Style MatchEnd = () -> {
            margin.right(1.5, em);
        };

        Style Participant = () -> {
            display.block().width(10, em);
        };

        ValueStyle<Champion> Champion = champion -> {
            display.inlineBlock().size(IconSize);
            background.image("src/main/resources/teemowork/champions.jpg").cover().horizontal(champion.getIconPosition());
            border.radius(2, px).color(rgb(50, 50, 50)).width(1, px).solid();
            cursor.pointer();
        };

        Style Score = () -> {

        };

        Style ScoreValue = () -> {
            display.inlineBlock().width(1.2, em);
            padding.horizontal(0.2, em);
        };

        Style Separator = () -> {

        };

        Style SettingBox = () -> {
            margin.right(2, em);
        };

        ValueStyle<Champion> Icon50 = champion -> {
            display.size(50, Unit.px).flex();
            border.radius(10, Unit.px).color(Color.rgb(50, 50, 50)).width(2, Unit.px).solid();
            cursor.pointer();
            position.relative();
            background.image(champion.getIcon()).horizontal(champion.getIconPosition()).cover().borderBox();
        };
    }
}
