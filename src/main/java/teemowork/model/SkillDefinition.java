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

import static teemowork.model.Describable.*;
import static teemowork.model.Status.*;
import static teemowork.model.Version.*;

import teemowork.model.variable.VariableResolver.BardChimes;
import teemowork.model.variable.VariableResolver.Diff;
import teemowork.model.variable.VariableResolver.Fixed;
import teemowork.model.variable.VariableResolver.Per1Level;
import teemowork.model.variable.VariableResolver.Per2Level;
import teemowork.model.variable.VariableResolver.Per3Level;
import teemowork.model.variable.VariableResolver.Per3LevelAdditional;
import teemowork.model.variable.VariableResolver.Per4Level;
import teemowork.model.variable.VariableResolver.Per4LevelForAnivia;
import teemowork.model.variable.VariableResolver.Per4LevelForTrundle;
import teemowork.model.variable.VariableResolver.Per5Level;
import teemowork.model.variable.VariableResolver.Per5Level3Times;
import teemowork.model.variable.VariableResolver.Per5LevelForSejuani;
import teemowork.model.variable.VariableResolver.Per5LevelForYoric;
import teemowork.model.variable.VariableResolver.Per5LevelWith18;
import teemowork.model.variable.VariableResolver.Per6Level;
import teemowork.model.variable.VariableResolver.Per6LevelForVi;
import teemowork.model.variable.VariableResolver.Per6LevelForZed;
import teemowork.model.variable.VariableResolver.PerChampion;
import teemowork.model.variable.VariableResolver.PerLevel;
import teemowork.model.variable.VariableResolver.Refer;
import teemowork.model.variable.VariableResolver.ReferFixed;
import teemowork.model.variable.VariableResolver.ReferPlus;

/**
 * @version 2015/07/23 12:26:01
 */
public interface SkillDefinition {

    /**
     * <p>
     * Write チャンピオン's skill definition.
     * </p>
     * 
     * @param champion TODO
     * @param passive
     * @param q
     * @param w
     * @param e
     * @param r
     */
    void define(Champion champion, Skill passive, Skill q, Skill w, Skill e, Skill r);

    /**
     * Define skill.
     */
    public static void Aatrox(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルを使用時に消費した" + Health + "をBlood Wellとしてスタックし(最大スタック量は{1})、5秒間戦闘状態でなくなると毎秒2%ずつ失われていく。スタックが1%貯まる毎に{2}する(最大で{3})。Healthが0になると3秒かけて最大スタック量の35% + 現在のスタック量分の" + Health + "を持って復活する。{6}。")
                .variable(1, Stack, new Per1Level(105, 138, 171, 207, 244, 283, 323, 365, 408, 453, 500, 548, 598, 649, 702, 756, 813, 870))
                .variable(-2, ASRatio, new Per3Level(0.3, 0.05))
                .variable(-3, ASRatio, new Per3Level(30, 5))
                .variable(6, CDRUnaware)
                .cd(new Per5Level(-225, 25));

        Q.update(P514)
                .active("指定地点に飛びかかり、{1}の敵ユニットに{2}を与える。{4}にいる敵ユニットに対しては更に{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, PhysicalDamage, 70, 45, bounusAD(0.6))
                .variable(3, Knockup, 1)
                .variable(4, Radius, 75)
                .cd(16, -1)
                .cost(CurrentHealthRatio, 10, 0)
                .range(650);

        W.update(P514)
                .passive("通常攻撃3回ごとに{1}する。Healthが50%以下の場合、{2}する。ToggleOnの間、この効果は失われる。")
                .variable(1, RestoreHealth, 20, 5, bounusAD(0.25))
                .variable(2, RestoreHealth, 60, 15, bounusAD(0.75))
                .active("通常攻撃3回ごとに{3}を与えて{4}する。")
                .variable(3, PhysicalDamage, 60, 35, bounusAD(1))
                .variable(4, LoseHealth, 15, 8.75, bounusAD(0.25))
                .cd(0.5)
                .type(SkillType.Toggle);

        E.update(P514)
                .active("指定方向に貫通するエネルギーを放ち、当たった敵ユニットに{1}と{2}間{3}を与える。")
                .variable(1, MagicDamage, 75, 35, ap(0.6), bounusAD(0.6))
                .variable(2, Time, 1.75, 0.25)
                .variable(3, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 5, 0)
                .cd(12, -1)
                .range(1000);

        R.update(P514)
                .active("{1}の敵チャンピオンに{2}を与え、12秒間{3}し、通常攻撃の{4}。当たった敵毎に20%の" + P + "を得る。")
                .variable(1, Radius, 550)
                .variable(2, MagicDamage, 200, 100, ap(1))
                .variable(3, ASRatio, 40, 10)
                .variable(4, Range, 200)
                .cd(100, -15);
    }

    /**
     * Define skill.
     */
    public static void Ahri(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルが敵ユニットに当たる度に" + P + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルが敵に当たる毎に{1}する。")
                .variable(1, RestoreHealth, 2, 0, ap(0.09), level(1));

        Q.update(P514)
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。オーブを射出している間{3}する。（0.5秒かけて80まで減衰）")
                .variable(1, MagicDamage, 40, 25, ap(0.35))
                .variable(2, TrueDamage, 40, 25, ap(0.35))
                .variable(3, MS, 215)
                .cd(7)
                .mana(65, 5)
                .range(880);

        W.update(P514)
                .active("周囲を回る3本の鬼火を放つ。鬼火は5秒間持続し、近くの敵ユニットに自動的に突撃して{1}を与える。鬼火が同一対象に突撃した場合、2発目以降は本来の30%の" + MagicDamage + "を与える(同一対象に3発命中すると{3})。通常攻撃範囲内に敵チャンピオンがいる場合、それらを優先して狙う。")
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .variable(3, MagicDamage, 64, 40, ap(0.64))
                .cd(9, -1)
                .mana(50)
                .range(550);

        E.update(P514)
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。")
                .variable(1, MagicDamage, 60, 35, ap(0.5))
                .variable(2, Charm, 1, 0.25)
                .cd(12)
                .mana(85)
                .range(975);

        R.update(P514)
                .active("指定方向にダッシュした後、{2}の敵ユニット(敵チャンピオンを優先)3体に{1}を与える。このスキルは10秒の間、3回まで連続して使用できる(但し、一度使用する度に1秒の" + CD + "が発生する)。2～3発目はマナコスト無しで使用可能。同一対象に3発命中すると{3}。")
                .variable(1, MagicDamage, 70, 40, ap(0.3))
                .variable(2, Radius, 600)
                .variable(3, MagicDamage, 210, 120, ap(0.9))
                .cd(110, -15)
                .mana(100)
                .range(450);
    }

    /**
     * Define skill.
     */
    public static void Akali(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}を得る。また通常攻撃に{2}が付与される。")
                .variable(1, SV, 6, 0, bounusAD(0.167))
                .variable(2, MagicDamage, amplify(AD, 0.06, 0, ap(0.00167)));

        Q.update(P514)
                .active("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃でダメージを与えたとき、マークを消費して{1}を与え、{3}する。")
                .variable(1, MagicDamage, 35, 20, ap(0.4))
                .variable(3, RestoreEnergy, 20, 5)
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(600);

        W.update(P514)
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。自身は{2}と{3}を得て、敵ユニットには{4}を与える。ステルスはスキル使用または通常攻撃時に解除され、再度ステルス化するのに0.65秒かかる。")
                .variable(1, Radius, 400)
                .variable(2, Stealth)
                .variable(3, MSRatio, 20, 20)
                .variable(4, MSSlowRatio, 14, 4)
                .variable(5, Visionable)
                .cd(20)
                .cost(Energy, 80, -5)
                .range(700);

        E.update(P514)
                .active("{2}の敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 30, 25, ap(0.4), ad(0.6))
                .variable(2, Radius, 325)
                .cd(5, -1)
                .cost(Energy, 60, -5);

        R.update(P514)
                .active("対象の敵ユニットを通過して後方200の位置に移動し（" + Q + "のマークが付いている場合は後方100の位置）{1}を与える。使用時にチャージを消費する。チャージは{2}毎に又は敵チャンピオンを{3}で増加し最大で3つまでチャージされる。")
                .variable(1, MagicDamage, 100, 75, ap(0.5))
                .variable(2, CDRAwareTime, 30, -7.5)
                .variable(3, Takedown)
                .cd(2, -0.5)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Alistar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルを使用すると3秒間{1}を得て、{2}の敵ユニットと建物に毎秒{3}を与える。ミニオンに対してはダメージが2倍になる。")
                .variable(1, IgnoreUnitCollision)
                .variable(2, Radius, 300)
                .variable(3, MagicDamage, 6, 0, ap(0.1), level(1));

        Q.update(P514)
                .active("{4}の敵ユニットに{1}を与え、{2}後に{3}を与える。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, Knockup, 1)
                .variable(3, Stun, 0.5, 0)
                .variable(4, Radius, 365)
                .cd(17, -1)
                .mana(65, 5);

        W.update(P514)
                .active("対象の敵ユニットに突撃し{1}と{2}、{3}を与える。")
                .variable(1, MagicDamage, 55, 55, ap(0.7))
                .variable(2, Knockback)
                .variable(3, Stun, 1)
                .cd(14, -1)
                .mana(65, 5)
                .range(650);

        E.update(P514)
                .active("{1}する。{3}の味方ユニットは{2}する。近くの敵ユニットが死ぬと{4}する。")
                .variable(1, RestoreHealth, 60, 30, ap(0.2))
                .variable(2, RestoreHealth, 30, 15, ap(0.1))
                .variable(3, Radius, 575)
                .variable(4, CDDecrease, 2)
                .cd(12, 0)
                .mana(40, 10);

        R.update(P514)
                .active("7秒間{1}を得て、{2}する。Disable中でも使用可能。使用時に自身にかかっているCCを全て解除する。")
                .variable(1, AD, 60, 15)
                .variable(2, DamageReductionRatio, 70)
                .cd(120, -20)
                .mana(100, 0);
    }

    /**
     * Define skill.
     */
    public static void Amumu(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("通常攻撃した対象に3秒間{1}を与える。").variable(1, MRReduction, new Per6Level(15, 5));

        Q.update(P514)
                .active("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Stun, 1)
                .mana(80, 10)
                .cd(16, -2)
                .range(1100);

        W.update(P514)
                .active("毎秒、{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 8, 4, amplify(TargetMaxHealthRatio, 1, 0.5, ap(0.01)))
                .variable(2, Radius, 300)
                .mana(8)
                .cd(1)
                .type(SkillType.Toggle);

        E.update(P514)
                .passive("{1}する。")
                .variable(1, PhysicalDamageReduction, 2, 2)
                .active("{3}の敵ユニットに{2}を与える。通常攻撃でダメージを受けるたびに{4}。")
                .variable(2, MagicDamage, 75, 25, ap(0.5))
                .variable(3, Radius, 350)
                .variable(4, CDDecrease, 0.5)
                .mana(35)
                .cd(10, -1);

        R.update(P514)
                .active("{1}の敵ユニットに{2}と{3}を与え、通常攻撃を封じる。")
                .variable(1, Radius, 550)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Snare, 2)
                .mana(100, 50)
                .cd(150, -20);
    }

    /**
     * Define skill.
     */
    public static void Anivia(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("死亡時に卵になり6秒かけて復活する。復活中は{1}及び{2}を得る。復活中にHPが0になった場合は死亡する。{3}。")
                .variable(-1, AR, new Per4LevelForAnivia(-40, 15))
                .variable(-2, MR, new Per4LevelForAnivia(-40, 15))
                .variable(3, CDRUnaware)
                .cd(-240);

        Q.update(P514)
                .active("指定方向に貫通する氷を飛ばし、氷に触れた敵ユニットに{1}と3秒間{2}を与え、{4}状態にする。氷が飛んでいる最中に再度スキルを使用するか、最大距離まで飛ぶと氷が破裂し、破裂地点の{6}の敵ユニットにさらに{1}と{5}と3秒間{2}を与え、{4}状態にする。")
                .variable(1, MagicDamage, 60, 30, ap(0.5))
                .variable(2, MSSlowRatio, 20)
                .variable(4, Chill, 0)
                .variable(5, Stun, 1)
                .variable(6, Radius, 75)
                .mana(80, 10)
                .cd(12, -1)
                .range(1075);

        W.update(P514)
                .active("指定地点に5秒間{1}の壁を作りユニットを通れなくする。また、指定地点の{2}。")
                .variable(1, Length, 400, 100)
                .variable(2, Visionable)
                .mana(70)
                .cd(25)
                .range(1000);

        E.update(P514)
                .active("対象の敵ユニットに{1}を与える。対象が" + Chill + "の場合は{2}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MagicDamage, 110, 60, ap(1.0))
                .mana(50, 10)
                .cd(5)
                .range(650);

        R.update(P514)
                .active("指定地点の{6}の敵ユニットに毎秒{1}、1秒間の{2}と{3}を与え、{5}状態にする。")
                .variable(1, MagicDamage, 80, 40, ap(0.25))
                .variable(2, ASSlowRatio, 20, 0)
                .variable(3, MSSlowRatio, 20)
                .variable(5, Chill, 0)
                .variable(6, Radius, 300)
                .mana(40, 10)
                .cd(6)
                .range(625)
                .type(SkillType.Toggle);
    }

    /**
     * Define skill.
     */
    public static void Annie(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルを使用するたびにスタックが1貯まり、4スタック時に" + E + "以外のスキルを使用すると、スタックを全て消費してそのスキルに{1}が追加される。")
                .variable(1, Stun, new Per5Level3Times(1.25, 0.25));

        Q.update(P514)
                .active("対象の敵ユニットに{1}を与える。このスキルでキルを取ると{2}し、{3}する。")
                .variable(1, MagicDamage, 80, 35, ap(0.8))
                .variable(2, RestoreMana, 60, 5)
                .variable(3, CDDecrease, 2)
                .mana(60, 5)
                .cd(4)
                .range(625);

        W.update(P514)
                .active("指定方向扇形50°の{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 625)
                .variable(2, MagicDamage, 70, 45, ap(0.85))
                .mana(70, 10)
                .cd(8);

        E.update(P514)
                .active("5秒間{2}と{3}を得て、効果時間中に通常攻撃をしてきた敵ユニットに{4}を与える。また" + R + "が召喚されている間は、" + R + "にも" + E + "の効果が付加され移動速度が300増加する(0.75sで減衰)。")
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .variable(4, MagicDamage, 20, 10, ap(0.2))
                .mana(20)
                .cd(10);

        R.update(P514)
                .active("指定地点の{1}の敵ユニットに{2}を与え、操作可能なTibbersを召喚する。Tibbersは{3}間持続し、{4}の敵ユニットに毎秒{5}を与える。<br>Health : {6}<br>通常攻撃 : {7}<br>AR : {8}<br>MR : {9}<br>MS : {10}")
                .variable(1, Radius, 290)
                .variable(2, MagicDamage, 175, 125, ap(0.8))
                .variable(3, Time, 45, 0)
                .variable(4, Radius, 200)
                .variable(5, MagicDamage, 20, 10, ap(0.2))
                .variable(6, Value, 1200, 900)
                .variable(7, MagicDamage, 80, 25)
                .variable(8, Value, 30, 20)
                .variable(9, Value, 30, 20)
                .variable(10, Value, 350)
                .range(600)
                .mana(100)
                .cd(120, -20);
    }

    /**
     * Define skill.
     */
    public static void Ashe(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルと通常攻撃は対象に2秒間{1}を与える。またこのスキルで" + MSSlow + "を付与した対象に通常攻撃を行う場合、常にクリティカルが発生する。この" + Damage + "は" + Critical + "によって上昇する。その代わり通常状態の敵へのクリティカルは発生しない。")
                .variable(1, MSSlowRatio, new Per3Level(5, 6));

        Q.update(P514)
                .passive("スキルもしくは通常攻撃が敵に命中することで4秒間「フォーカス」のチャージを獲得。最大で5チャージ。")
                .active("「フォーカス」の全チャージを消費して4秒間" + P + "による" + MSSlow + "効果が{1}になり、{2}する。5チャージ消費されると、通常攻撃が5回に分けて合計{3}を与えるようになる。On-Hit Effectsは5連射の初撃のみ有効(Hurricaneは5回発動)。")
                .variable(1, MSSlowRatio, new Per3Level(6, 7.2))
                .variable(2, ASRatio, 20, 5)
                .variable(3, PhysicalDamage, amplify(AD, 1.15, 0.05))
                .mana(50)
                .cd(12, -2)
                .range(1200);

        W.update(P514)
                .active("非貫通の矢を扇状に発射し、それぞれ敵に命中するごとに{1}を与える。敵はこのスキルによって放たれる矢を複数遮ることができるが、ダメージは最初に当たった矢の分のみ受ける。")
                .variable(1, PhysicalDamage, 20, 15, ad(1))
                .range(1200)
                .cd(12, -2)
                .mana(40);

        E.update(P514)
                .active("マップ上どこでも、ターゲット位置まで鷹を飛ばすことができ5秒間通過した{2}の{1}。スタックは最大2で{3}毎に増加する。")
                .variable(1, Visionable)
                .variable(2, Radius, 1000)
                .variable(3, CDRAwareTime, 90, -10)
                .cost(Stack, 1, 0)
                .cd(5)
                .range(-1);

        R.update(P514)
                .active("指定方向に敵チャンピオンにのみ当たる矢を飛ばし、当たった敵チャンピオンに{1}と{2}(飛距離に比例して１～3.5秒)と3秒間の{4}を与える。また敵チャンピオン命中時に矢が爆発し、{5}の敵ユニットに{6}と3秒間の{4}を与える。飛行中の矢は{3}。")
                .variable(1, MagicDamage, 250, 175, ap(1))
                .variable(2, Stun, 0)
                .variable(3, Visionable)
                .variable(4, MSSlowRatio, 50)
                .variable(5, Radius, 250)
                .variable(6, MagicDamage, 125, 87.5, ap(0.5))
                .mana(100)
                .cd(100, -10)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Azir(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}にある味方もしくは敵のタワーの跡地を右クリックすると、その跡地にThe Sun Discを召喚する。The Sun Discは通常のタワーのように振る舞い、60秒後に消失する。敵のNexusおよびInhibitor Turretに対してはこのスキルは使用できない。{2}。")
                .variable(1, Radius, 400)
                .variable(2, CDRUnaware)
                .cd(-180);

        Q.update(P514)
                .active("全ての砂兵士を指定した地点に集結させる。砂兵士は進路上でぶつかった敵に{1}と1秒間{2}を与える。このスロー効果は累積する。")
                .variable(1, MagicDamage, 65, 20, ap(0.5))
                .variable(2, MSSlowRatio, 25)
                .range(875)
                .cd(10, -1)
                .mana(70);

        W.update(P514)
                .passive("{4}する。")
                .variable(4, AS, 20, 10)
                .active("9秒持続する砂兵士1体を召喚する。自身が兵士の射程距離内にいる敵を攻撃すると、兵士が自身に代わってその敵を攻撃し、直線上にいる敵に{1}を与える。複数の兵士が同じ敵を攻撃した場合、2人目以降の兵士のダメージは25%になる。たとえ標的が自身の通常攻撃の射程内にいなくても、兵士自身の射程に入っていれば兵士が攻撃を行う。兵士は最大2体まで、{2}毎に補充される。兵士から離れすぎるとその兵士は動かなくなる。敵タワーの近くでは、兵士の持続時間は通常の半分になる。兵士をタワーの真上に召喚することで、その兵士を犠牲にしてタワーに{3}を与える。")
                .variable(1, MagicDamage, new Per1Level(new double[] {45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 100, 110,
                        120, 130, 140, 150, 160, 170}), ap(0.6), null)
                .variable(2, CDRAwareTime, 12, -1)
                .variable(3, MagicDamage, 50, 0, ap(0.4), level(10))
                .range(450)
                .mana(40)
                .cd(1.5);

        E.update(P514)
                .active("砂兵士1体に向かってダッシュし、進路上にいる敵に{1}を与える。敵チャンピオンに衝突した場合、そこで停止して4秒間{2}を得る。")
                .variable(1, MagicDamage, 60, 30, ap(0.4))
                .variable(2, Shield, 80, 40, amplify(BounusHealth, 0.15))
                .range(1100)
                .cd(19, -1)
                .mana(60);

        R.update(P514)
                .active("兵士{1}体の壁を召喚する。兵士たちは前方に突進し、衝突した敵に{2}と{3}を与える。壁その後{4}間持続し、敵はブリンク以外の手段でこの壁をすり抜けることはできないが、味方は自由に壁を通過でき、また壁を通過した際に1秒間{5}する。")
                .variable(1, Value, 4, 1)
                .variable(2, Knockback)
                .variable(3, MagicDamage, 150, 75, ap(0.6))
                .variable(4, Time, 5, 1)
                .variable(5, MSRatio, 20)
                .range(250)
                .mana(100)
                .cd(140, -20);
    }

    /**
     * Define skill.
     */
    public static void Bard(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("鐘が50秒毎に2個ずつ、自身から一定の範囲内に出現する(2回目と3回目は1個のみ。また、試合開始から5分経過すると、敵ジャングル内にも出現し始める)。鐘を取ると、非戦闘時に7秒間{1}し(5回までスタック)、{2}（経過時間に比例）を得て、{3}する。鐘は10分経つと消滅する。<br>通常攻撃の際、スタックを消費して{4}を与える。取得した鐘の数で性能が強化される。<br>5個: 1秒間{5}<br>25: ターゲットの後方にも追加効果<br>65: 効果範囲が拡大")
                .variable(-1, MSRatio)
                .variable(2, Experiment, 20)
                .variable(3, RestoreMana, amplify(Mana, 0.12))
                .variable(4, MagicDamage, new BardChimes(new double[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110,
                        120, 130, 140, 150}, new double[] {35, 55, 80, 110, 140, 175, 210, 245, 280, 315, 345, 375, 400,
                                425, 445, 465}), ap(0.3), null)
                .variable(5, MSSlowRatio, new BardChimes(new double[] {5, 45, 85, 115, 135}, new double[] {25, 45, 60,
                        75, 80}));

        Q.update(P514)
                .active("{1}の貫通するエネルギー弾を飛ばし、1体目のターゲットに{2}と{3}間{4}を与える。エネルギー弾が別の敵にも命中するか({5})、壁に当たった場合、スキルが命中したすべての敵に{6}を与える。")
                .variable(1, MissileSpeed, 1500)
                .variable(2, MagicDamage, 80, 45, ap(0.65))
                .variable(3, Time, 1, 0.2)
                .variable(4, MSSlowRatio, 60)
                .variable(5, Radius, 450)
                .variable(6, Stun, 1, 0.2)
                .range(950)
                .mana(60)
                .cd(10, -1);

        W.update(P514)
                .active("治癒効果のある結界を設置し、接触した味方は{1}する。設置から10秒間かけて治癒効果が向上して、最大で{2}するとともに{3}する。この効果は1.5秒かけて減衰する。結界は一度に3個まで発生させることができ、味方のチャンピオンが接触するか、敵が通過すると消滅する。")
                .variable(1, RestoreHealth, 30, 30, ap(0.2))
                .variable(2, RestoreHealth, 70, 40, ap(0.45))
                .variable(3, MSRatio, 50)
                .range(1000)
                .mana(100, 5)
                .cd(5);

        E.update(P514)
                .active("付近の壁に一方通行の穴を開け、近くで穴のどこかを右クリックすると通り抜けられる。敵も使用できるが、味方のほうが{1}速く通り抜ける。")
                .variable(1, Percentage, 10, 10)
                .range(900)
                .mana(30)
                .cd(20, -1);

        R.update(P514)
                .active("指定した地点へ弓なりに魔力を射出し、着弾と同時に{1}のすべてのチャンピオン、ミニオン、モンスター、タワーを2.5秒間、行動不能にする。ただし、その間、対象ユニットは無敵状態となり、ターゲットもされなくなる。")
                .variable(1, Radius, 350)
                .range(3400)
                .mana(100)
                .cd(130, -15);
    }

    /**
     * Define skill.
     */
    public static void Blitzcrank(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive(" HPが20%以下になると、10秒間{1}を張る。").variable(1, Shield, amplify(CurrentManaRatio, 50)).cd(90);

        Q.update(P514)
                .active("指定方向に腕を飛ばし、当たった敵ユニットに{1}と{2}を与え自分の位置まで引き寄せる。またこのスキル命中時に対象の{3}。")
                .variable(1, MagicDamage, 80, 55, ap(1))
                .variable(2, Stun, 0.5)
                .variable(3, Visionable)
                .mana(100)
                .cd(20, -1)
                .range(925);

        W.update(P514)
                .active("5秒間{1}、{2}する。" + MS + "上昇量は時間と共に10%まで減衰し、効果終了時に自身に1.5秒間{3}を与える。")
                .variable(1, MSRatio, 70, 5)
                .variable(2, ASRatio, 30, 8)
                .variable(3, MSSlowRatio, 30)
                .mana(75)
                .cd(15);

        E.update(P514)
                .active("次の通常攻撃に{1}を付与し、対象に{2}を与える。{3}。")
                .variable(1, PhysicalDamage, 0, 0, ad(1))
                .variable(2, Knockup, 1, 0)
                .variable(3, ResetAATimer)
                .mana(25)
                .cd(9, -1);

        R.update(P514)
                .passive("{1}の敵ユニット1体(対象はランダム)に2.5秒ごとに{2}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 100, 100, ap(0.2))
                .active("{3}の敵ユニットに{4}と{5}を与える。効果後はCDが解消されるまでPassiveの効果がなくなる。")
                .variable(3, Radius, 600)
                .variable(4, MagicDamage, 250, 125, ap(1))
                .variable(5, Silence, 0.5)
                .mana(100)
                .cd(30);
    }

    /**
     * Define skill.
     */
    public static void Brand(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルが当たった敵ユニットを炎上させ、4秒間毎秒{1}与える。炎上している敵ユニットにスキルが命中すると追加効果が発生する。(ミニオンやモンスターに対しては毎秒80ダメージが上限)")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 2));

        Q.update(P514)
                .active("指定方向に火球を投射し、当たった敵ユニットに{1}を与える。敵が炎上していた場合、{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.65))
                .variable(2, Stun, 2)
                .mana(50)
                .cd(8, -0.5)
                .range(1050);

        W.update(P514)
                .active("指定地点に炎の柱を作り出し、0.625秒後に{1}の敵ユニットに{2}を与える。敵が炎上していた場合、代わりに{3}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 75, 45, ap(0.6))
                .variable(3, MagicDamage, 94, 56, ap(0.75))
                .mana(70, 5)
                .cd(10)
                .range(900);

        E.update(P514)
                .active("対象の敵ユニットに{1}を与える。敵が炎上していた場合、{2}の敵にも{1}を与える。")
                .variable(1, MagicDamage, 70, 35, ap(0.55))
                .variable(2, Radius, 300)
                .mana(70, 5)
                .cd(12, -1)
                .range(625);

        R.update(P514)
                .active("対象の敵ユニットに火炎弾を放つ。火炎弾は近くの敵ユニットに4回まで跳ね、その度に{1}を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。敵が炎上していた場合、敵チャンピオンに優先して跳ね返るようになる。")
                .variable(1, MagicDamage, 150, 100, ap(0.5))
                .mana(100)
                .cd(105, -15)
                .range(750);
    }

    /**
     * Define skill.
     */
    public static void Braum(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃時に対象にスタックを付与する。自身を含む味方チャンピオンがスタック付きの対象に通常攻撃を行う度にスタックが1増加し、4スタックになるとスタックを全て消費し対象に{1}と{2}を与える。スタックは4秒間増加が無いと0になる。" + Stun + "が発動すると、その対象が{3}間耐性を得て、スタックが付与できなくなる。代わりに自身が耐性がついた対象に通常攻撃するか" + Q + "を当てると{4}を与える。")
                .variable(1, Stun, new Per6Level(1.25, 0.25))
                .variable(2, MagicDamage, 32, 0, level(8))
                .variable(3, Time, 8, -1)
                .variable(4, MagicDamage, 6.4, 0, level(1.6));

        Q.update(P514)
                .active("盾から氷の塊を発射し、命中した敵に" + P + "のスタック、{1}と2秒間かけて減衰する{2}を与える。")
                .variable(1, MagicDamage, 70, 45, amplify(Health, 0.025))
                .variable(2, MSSlowRatio, 70)
                .range(1000)
                .mana(45, 5)
                .cd(10, -1);

        W.update(P514)
                .active("対象の味方のユニットのそばに素早く移動する。移動完了後3秒間、自分と味方は{1}と{2}を得る。")
                .variable(1, AR, 15, 2.5, amplify(BounusAR, 0.1, 0.015))
                .variable(2, MR, 15, 2.5, amplify(BounusMR, 0.1, 0.015))
                .range(650)
                .mana(50, 5)
                .cd(14, -1);

        E.update(P514)
                .active("{1}間、盾を掲げて{3}を得て{4}する。盾を向けている方向から受けた最初の攻撃のダメージを無効化する。それ以降も効果時間中は受ける攻撃のダメージを{2}する。敵の遠距離攻撃を盾によって、食い止める。効果時間中はブラームの移動速度が10％上昇する")
                .variable(1, Time, 3, 0.25)
                .variable(2, DamageReductionRatio, 30, 2.5)
                .variable(3, IgnoreUnitCollision)
                .variable(4, MSRatio, 10)
                .mana(30, 5)
                .cd(18, -2);

        R.update(P514)
                .active("盾を地面にたたきつけて地割れを起こし、{1}にいる敵と前方のライン上にいる敵に{2}と{3}を与える。前方に伸びた地割れは4間持続し、触れた敵に{5}を与える。最初に命中した敵チャンピオンには{4}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 150, 100, ap(0.6))
                .variable(3, Knockup, 0.25)
                .variable(4, Knockup, 1.5)
                .variable(5, MSSlowRatio, 40, 10)
                .range(1250)
                .mana(100)
                .cd(140, -20);
    }

    /**
     * Define skill.
     */
    public static void Caitlyn(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃{1}回毎にダメージが増加する(Minionには150%増加、チャンピオンには50%増加して{2}を付与、建物への攻撃は無効)。茂みから通常攻撃を行うと2回分としてカウントされる。")
                .variable(1, Count, new Per6Level(7, -1))
                .variable(2, BounusARPenRatio, 50)
                .update(P307);

        Q.update(P514)
                .active("1秒詠唱後、指定方向に貫通する弾を発射し当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%減少していき最小で{2}を与える。")
                .variable(1, PhysicalDamage, 20, 40, ad(1.3))
                .variable(2, PhysicalDamage, 10, 20, ad(0.65))
                .mana(50, 10)
                .cd(10, -1)
                .range(1250);

        W.update(P514)
                .active("指定地点に罠を仕掛ける。敵チャンピオンが罠の{4}に入ると発動して、対象に1.5秒かけて{2}と{3}を与え、9秒間対象の{5}。罠は3個まで置け、4分間持続する。")
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Snare, 1.5)
                .variable(4, Radius, 67.5)
                .variable(5, Visionable)
                .mana(50)
                .cd(20, -3)
                .range(800);

        E.update(P514)
                .active("指定方向にネットを飛ばし当たった敵ユニットに{1}と{3}間{2}を与え、Caitlynはネットを飛ばした方向の反対側にジャンプ({4})する。")
                .variable(1, MagicDamage, 80, 50, ap(0.8))
                .variable(2, MSSlowRatio, 50)
                .variable(3, Time, 1, 0.25)
                .variable(4, Distance, 400)
                .mana(75)
                .cd(18, -2)
                .range(950);

        R.update(P514)
                .active("0.5秒詠唱後に対象の敵チャンピオンの視界を得て、更に1秒詠唱後対象に目掛けて敵チャンピオンにのみ当たる弾を発射し、当たった敵チャンピオンに{1}を与える。ターゲットとの射線を遮ると間に入った敵チャンピオンに当たる。")
                .variable(1, PhysicalDamage, 250, 225, bounusAD(2))
                .mana(100)
                .cd(90, -15)
                .range(2000, 500);
    }

    /**
     * Define skill.
     */
    public static void Cassiopeia(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("6秒毎に1スタックを得る。敵チャンピオンに毒を与えている間は毎秒1スタックを得る。スタック数に応じて能力を得る。<br>100: {1}する。" + E + "を敵に当てるたびに{2}する。<br>250: {3}する。{4}を得る。<br>500: {5}する。")
                .variable(-1, APRatio, 5)
                .variable(2, RestoreHealth, new Refer(E, 6, 2), ap(0.06), null)
                .variable(-3, APRatio, 5)
                .variable(-4, CDR, 25)
                .variable(-5, APRatio, 20);

        Q.update(P514)
                .active("指定地点に0.4秒後に毒を発生させ、{1}の敵ユニットに毒を与え3秒かけて{2}を与える。このスキルがチャンピオンにヒットした場合、3秒間{3}する。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 75, 40, ap(0.45))
                .variable(3, MSRatio, 20)
                .mana(40, 10)
                .cd(4)
                .range(850);

        W.update(P514)
                .active("指定地点に7秒間持続する毒霧を吹き出す。毒霧は徐々に範囲(125～250)が広がり、毒霧の上を通過した敵に2秒間持続する毒を付与し毎秒{1}と2秒間{3}を与える。また指定地点の{4}。")
                .variable(1, MagicDamage, 10, 5, ap(0.1))
                .variable(3, MSSlowRatio, 25, 5)
                .variable(4, Visionable)
                .mana(40, 10)
                .cd(14, -1)
                .range(850);

        E.update(P514)
                .active("対象の敵ユニットに{1}を与える。対象が毒を受けている場合、{2}。")
                .variable(1, MagicDamage, 55, 25, ap(0.55))
                .variable(2, CD, 0.5)
                .mana(50, 10)
                .cd(5)
                .range(700);

        R.update(P514)
                .active("眼からビームを放ち、指定方向扇形80°の範囲内の敵ユニットに{1}を与え、こちらを向いている敵に更に{2}を与える。後ろを向いていた場合2秒間{4}を与える。")
                .variable(1, MagicDamage, 150, 100, ap(0.5))
                .variable(2, Stun, 2)
                .variable(4, MSSlowRatio, 60)
                .mana(100)
                .cd(120, -10)
                .range(825);
    }

    /**
     * Define skill.
     */
    public static void Chogath(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("敵ユニットを倒すと{1}、{2}する。")
                .variable(1, RestoreHealth, 17, 0, level(3))
                .variable(2, RestoreMana, 3.25, 0, level(0.25));

        Q.update(P514)
                .active("指定地点に0.5秒後にトゲを出現させ、{1}の敵ユニットに{2}、{3}を与えて、1.5秒間{5}にする。また指定地点の{4}。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(3, Knockup, 1)
                .variable(4, Visionable)
                .variable(5, MSSlowRatio, 60)
                .mana(90)
                .cd(9)
                .range(950);

        W.update(P514)
                .active("前方扇形60°の領域の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 50, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 10)
                .cd(13)
                .range(700);

        E.update(P514)
                .active("通常攻撃時に前方にトゲを飛ばし当たった敵ユニットに{1}を与える。トゲを飛ばす範囲はUltのスタック数に比例し増加する。")
                .variable(1, MagicDamage, 20, 15, ap(0.3))
                .cd(0.5)
                .range(500)
                .type(SkillType.Toggle);

        R.update(P514)
                .active("対象の敵ユニットに{1}を与える。対象がチャンピオン以外の場合は{2}を与える。このスキルで敵を倒すとスタックが1増えて{3}と{4}する。最大スタック数は6で、死亡するとスタックが半分(端数切り上げ)消失する。")
                .variable(1, TrueDamage, 300, 175, ap(0.7))
                .variable(2, TrueDamage, 1000, 0, ap(0.7))
                .variable(3, Health, amplify(Stack, 90, 30))
                .variable(4, Range, amplify(Stack, 3.8, 2.25))
                .mana(100)
                .cd(80)
                .range(175);
    }

    /**
     * Define skill.
     */
    public static void Corki(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("通常攻撃に{1}が付与される。建物には無効。").variable(1, TrueDamage, 0, 0, ad(0.1));

        Q.update(P514)
                .active("指定地点に爆弾を発射し、着弾時に{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。爆弾にも視界がある。また、チャンピオンに当たった場合、6秒間そのチャンピオンの{3}。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 80, 50, ap(0.5), bounusAD(0.5))
                .variable(3, Visionable)
                .cd(8)
                .mana(60, 10)
                .range(825);

        W.update(P514)
                .active("指定地点まで高速で移動し、通過地点を2.5秒間炎上させる。炎上地点の上にいる敵ユニットに0.5秒毎に{2}を与える。")
                .variable(2, MagicDamage, 30, 15, ap(0.2))
                .mana(100)
                .cd(26, -3)
                .range(800);

        E.update(P514)
                .active("4秒間、Corkiの前方扇形35°にいる敵ユニットに0.5秒毎に{1}を与える(最大8hit)。ダメージを与える度に対象ユニットに{2}を与える。この効果は2秒間持続し、8回までスタックする。")
                .variable(1, PhysicalDamage, 10, 6, bounusAD(0.02))
                .variable(2, ARReduction, 1, 1)
                .mana(50)
                .cd(16)
                .range(600);

        R.update(P514)
                .active("スタックを消費して、指定方向にミサイルを発射し当たった敵ユニットの{1}に{2}を与える。スタックは{3}毎に増加する（最大数7）。3発毎に大きいミサイル({4}に{5})を発射する。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 100, 80, ap(0.3), amplify(AD, 0.2, 0.1))
                .variable(3, CDRAwareTime, 12, -2)
                .variable(4, Radius, 150)
                .variable(5, MagicDamage, 150, 120, ap(0.45), amplify(AD, 0.3, 0.15))
                .mana(20)
                .cd(-2)
                .range(1225);
    }

    /**
     * Define skill.
     */
    public static void Diana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}する。通常攻撃3回毎に周囲にいる敵ユニットに{2}を与える。")
                .variable(1, ASRatio, 20)
                .variable(2, MagicDamage, new Per1Level(new double[] {20, 25, 30, 35, 40, 50, 60, 70, 80, 90, 105, 120,
                        135, 155, 175, 200, 225, 250}), ap(0.8), null);

        Q.update(P514)
                .active("指定地点に弧を描くエネルギーを放ち、当たった敵ユニットと{2}のユニットに{1}とMoonlight(3秒)を与える。またMoonlightが付与されている敵ユニットの{3}。")
                .variable(1, MagicDamage, 60, 35, ap(0.7))
                .variable(2, Radius, 50)
                .variable(3, Visionable)
                .mana(55)
                .cd(10, -1)
                .range(830);

        W.update(P514)
                .active("5秒間{1}を張ると同時に、自身の周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発すると{1}が追加される。")
                .variable(1, Shield, 40, 15, ap(0.3))
                .variable(2, Radius, 200)
                .variable(3, MagicDamage, 22, 12, ap(0.2))
                .mana(60, 10)
                .cd(10);

        E.update(P514)
                .active("{1}にいる全ての敵ユニットを自身がいる方向に引き寄せ、2秒間{2}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 35, 5)
                .mana(70)
                .cd(26, -2);

        R.update(P514)
                .active("対象の敵ユニットの元までテレポートし、{1}を与える。対象にMoonlightが付与されていた場合、全ての敵ユニットに付与されたMoonlightを消費してこのスキルの{2}する。")
                .variable(1, MagicDamage, 100, 60, ap(0.6))
                .variable(2, CDDecrease)
                .mana(50, 15)
                .cd(25, -5)
                .range(825);
    }

    /**
     * Define skill.
     */
    public static void Darius(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃またはスキルでダメージを与えた敵ユニットに出血スタックを付与する。出血スタックが付与された敵ユニットに5秒間かけて{1}を与える。出血スタックは5秒間持続して最大5回までスタックし最大{2}を与える。また、出血スタックを受けている敵チャンピオン数に応じて{3}する。")
                .variable(1, MagicDamage, new Per2Level(12, 3), amplify(BounusAD, 0.3), null)
                .variable(2, MagicDamage, new Per2Level(60, 15), amplify(BounusAD, 1.5), null)
                .variable(-3, MSRatio, 5);

        Q.update(P514)
                .active("斧を振り回し{3}の敵ユニットに{1}を与える。斧の刃に当たった敵チャンピオンに対しては{2}を与える。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.7))
                .variable(2, PhysicalDamage, 105, 52.5, bounusAD(1.05))
                .variable(3, Radius, 425)
                .mana(40)
                .cd(9, -1);

        W.update(P514)
                .active("次の通常攻撃に{1}を追加し、2秒間{2}と{3}が付与される。対象の出血スタック数1個につき、このスキルの{4}する。")
                .variable(1, PhysicalDamage, amplify(AD, 0.2, 0.2))
                .variable(2, ASSlowRatio, 20, 5)
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, CDDecrease, 1)
                .mana(30, 5)
                .cd(8)
                .range(145);

        E.update(P514)
                .passive("{1}を得る。")
                .variable(1, ARPenRatio, 5, 5)
                .active("前方範囲内の敵ユニットをDariusがいる方向に引き寄せ、{2}。")
                .variable(2, Visionable)
                .mana(45)
                .cd(24, -3)
                .range(550);

        R.update(P514)
                .active("対象の敵チャンピオンに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵チャンピオンのキルを取った場合、{2}し{3}間再使用することが出来る（ランク3であれば{4}）。この効果はキルを取るたびに適用される。")
                .variable(1, TrueDamage, 160, 90, bounusAD(0.75))
                .variable(2, RestoreMana, new Fixed(new double[] {25, 50, 100}))
                .variable(3, Time, 20)
                .variable(4, CDDecrease)
                .mana(100)
                .cd(120, -20)
                .range(475);
    }

    /**
     * Define skill.
     */
    public static void DrMundo(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("毎秒{1}する。").variable(1, RestoreHealth, amplify(Health, 0.003));

        Q.update(P514)
                .active("指定方向に包丁を投げ（{7}）、当たった敵ユニットに{1}と2秒間{3}を与える。最小で{4}。ミニオンやモンスターへは{5}が上限。命中すると{6}する。")
                .variable(1, MagicDamage, amplify(TargetCurrentHealthRatio, 15, 3))
                .variable(3, MSSlowRatio, 40)
                .variable(4, MagicDamage, 80, 50)
                .variable(5, MagicDamage, 300, 100)
                .variable(6, RestoreHealth, 25, 5)
                .variable(7, MissileWidth, 60)
                .cost(Health, 50, 10)
                .cd(4)
                .range(1000);

        W.update(P514)
                .active("{1}の敵ユニットに毎秒{2}を与える。また{3}を得る。")
                .variable(1, Radius, 162.5)
                .variable(2, MagicDamage, 35, 15, ap(0.2))
                .variable(3, Tenacity, 10, 5)
                .cost(Health, 10, 5)
                .cd(4)
                .type(SkillType.Toggle);

        E.update(P514)
                .active("5秒間{1}を得る。")
                .variable(1, AD, 40, 15, amplify(MissingHealthPercentage, 0.4, 0.15))
                .cost(Health, 25, 10)
                .cd(7);

        R.update(P514)
                .active("12秒かけて{1}し、{2}する。")
                .variable(1, RestoreHealth, amplify(Health, 0.4, 0.1))
                .variable(2, MSRatio, 15, 10)
                .cd(75)
                .cost(CurrentHealthRatio, 20, 0);
    }

    /**
     * Define skill.
     */
    public static void Draven(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive(P + "をキャッチするかミニオンかモンスターを倒すか建物を破壊するとスタックを得る。敵チャンピオンを倒すと、スタックを消費して{1}を得る。死亡時にスタックを半分失う。")
                .variable(1, Gold, 50, 0, amplify(ConsumedStack, 2));

        Q.update(P514)
                .active("次に行う通常攻撃に{1}を付与する。このスキルによる通常攻撃が敵ユニットに命中すると、斧が近くに跳ね返る。その斧をキャッチすると" + W + "の{2}し、更に次の通常攻撃も" + Q + "の効果を受けるようになる。このスキルは連続で使用する事で最大2回分までチャージできる。")
                .variable(1, PhysicalDamage, amplify(AD, 0.45, 0.1))
                .variable(2, CDDecrease)
                .mana(45)
                .cd(12, -1);

        W.update(P514)
                .active("1.5秒間{1}し、3秒間{2}する。移動速度増加は1.5秒かけて元に戻る。")
                .variable(1, MSRatio, 40, 5)
                .variable(2, ASRatio, 20, 5)
                .mana(40)
                .cd(12);

        E.update(P514)
                .active("指定方向に貫通する斧を投げ、当たった敵ユニットに{1}と{2}と2秒間{3}を与える。このノックバックは斧から弾かれる形で左右に吹き飛ぶ。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.5))
                .variable(2, Knockback, 0)
                .variable(3, MSSlowRatio, 20, 5)
                .mana(70)
                .cd(18, -1)
                .range(1050);

        R.update(P514)
                .active("指定方向に地面を這う貫通する斧を投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに8%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定があり、斧が飛んでいる最中に再度このスキルを使用するか、敵チャンピオンに命中した時点で斧が反転して自身の元に戻ってくる。反転した際、低下ダメージはリセットされる。また移動中の斧は{2}。")
                .variable(1, PhysicalDamage, 175, 100, bounusAD(1.1))
                .variable(2, Visionable)
                .mana(120)
                .cd(110, -10)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Ekko(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃かスキルでダメージを与えた敵ユニットにスタックを付与する。スタックは4秒間持続し、スタック数が3になるとスタックを消費し対象に{1}と{2}間{3}を与える。対象がチャンピオンの場合、更に{2}間{4}する。同一の対象には3秒に一度しか発動しない。建物には無効。")
                .variable(1, MagicDamage, 10, 0, ap(0.7), level(10))
                .variable(2, Time, new Per5Level3Times(2, 0.5))
                .variable(3, MSSlowRatio, new Per5Level(40, 10))
                .variable(-4, MSRatio, new Per5Level(40, 40));

        Q.update(P514)
                .active("特殊な装置を投げ、貫通した敵に{1}を与える。投げられた装置は最初に命中したチャンピオンの位置にフィールドを展開し、この範囲を通過するすべての対象に{2}を与える。その一瞬後、装置は自身のいる位置に戻り、その際貫通した敵に{3}を与える。2回とも当たった場合は合計{4}となる。")
                .variable(1, MagicDamage, 60, 15, ap(0.1))
                .variable(2, MSSlowRatio, 32, 7)
                .variable(3, MagicDamage, 60, 25, ap(0.6))
                .variable(4, MagicDamage, 120, 40, ap(0.7))
                .range(1075)
                .mana(50, 10)
                .cd(11, -1);

        W.update(P514)
                .passive("通常攻撃時、体力が最大値の30％未満の敵に対し、{1}を与える。ミニオンやモンスターに対しては最大150ダメージ。")
                .variable(1, MagicDamage, amplify(TargetMissingHealthRatio, 5, 0, ap(0.0222)))
                .active("発動3秒後、指定した地点の{2}の敵に{3}を与える。自身がこの地点に入ると起爆し、2秒間{4}を得て、全ての敵に{5}を与える。")
                .variable(2, Radius)
                .variable(3, MSSlowRatio, 40)
                .variable(4, Shield, 150, 45, ap(0.8))
                .variable(5, Stun, 2.25)
                .range(1600)
                .mana(50, 5)
                .cd(22, -2);

        E.update(P514)
                .active("指定した方向にダッシュする。次の通常攻撃に{1}を付与し{2}する。攻撃が命中すると対象の元までテレポートする。")
                .variable(1, MagicDamage, 50, 30, ap(0.2))
                .variable(2, Range, 300)
                .range(325)
                .mana(40, 10)
                .cd(13, -1.5);

        R.update()
                .active("自身が無敵状態になり、敵からターゲット不能になる。さらに時間を撒き戻し、4秒前にいた地点にテレポートする。その際、{1}し、到着地点の{2}にいる敵に{3}を与える。")
                .variable(1, RestoreHealth, 100, 50, amplify(ReceivedDamage4SecRatio, 20, 5, ap(0.0333)))
                .variable(2, Radius)
                .variable(3, MagicDamage, 200, 150, ap(1.3))
                .range(-1)
                .mana(100)
                .cd(110, -20);
    }

    /**
     * Define skill.
     */
    public static void Elise(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("使用したスキルが敵ユニットに命中すると子蜘蛛のチャージが1増加する。");

        Q.update(P514)
                .active("対象の敵ユニットに毒を放ち{1}を与える。ミニオンとモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 40, 35, amplify(TargetCurrentHealthRatio, 8, 0, ap(0.03)))
                .variable(2, MagicDamage, 110, 60)
                .mana(80, 5)
                .cd(6)
                .range(625);

        W.update(P514)
                .active("指定地点に蜘蛛を放つ。蜘蛛は敵ユニットに当たるか3秒間経過すると爆発し、範囲内の敵ユニットに{1}を与える。蜘蛛は指定地点に移動した後、最も近くにいる敵ユニットに向かって移動する。{2}。")
                .variable(1, MagicDamage, 75, 50, ap(0.8))
                .variable(2, Visionable)
                .mana(60, 10)
                .cd(12)
                .range(950);

        E.update(P514)
                .active("指定方向に糸を飛ばし当たった敵ユニットに{1}を与え、1秒間{2}。")
                .variable(1, Stun, 1.6, 0.1)
                .variable(2, Visionable)
                .mana(50)
                .cd(14, -1)
                .range(1075);

        R.update(P514)
                .passive("子蜘蛛の最大チャージ数は{1}。")
                .variable(1, Value, 2, 1)
                .active("Spider Formに変身する。射程が125、移動速度が555になる。また通常攻撃に追加効果を付与する。{2}。")
                .variable(2, NotSpellCast)
                .cd(4);
    }

    /**
     * Define skill.
     */
    public static void EliseTransformed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{3}し{4}する。通常攻撃は追加で{1}を与え、{2}する。")
                .variable(1, MagicDamage, new Refer(R, 10, 10), ap(0.3), null)
                .variable(2, RestoreHealth, new Refer(R, 4, 2), ap(0.1), null)
                .variable(3, MS, 25)
                .variable(4, Range, -425);

        Q.update(P514)
                .active("対象の敵ユニットに飛びつき{1}を与える。ミニオンとモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 60, 40, amplify(TargetMissingHealthRatio, 8, 0, ap(0.03)))
                .variable(2, MagicDamage, 135, 65)
                .cd(6)
                .range(475);

        W.update(P514)
                .passive("子蜘蛛の{1}する。")
                .variable(1, ASRatio, 5, 5)
                .active("3秒間自身と子蜘蛛の{2}する。")
                .variable(2, ASRatio, 60, 20)
                .cd(12);

        E.update(P514)
                .active("自身と子蜘蛛が上空に退避し(ターゲット不可になる)指定の方法で降下する。上空にいる間は射程内の{1}。<br>地面をクリックした場合: 最大2秒間上空に待機し、初期位置へ降下する。この間、敵ユニットをターゲットし裏側に降下できる。<br>敵ユニットをクリックした場合: 即座に下降し裏側に降り立つ。")
                .variable(1, Visionable)
                .cd(26, -3)
                .range(750);

        R.update(P514)
                .passive("変身時にチャージ数に応じた子蜘蛛を召喚する。召喚された子蜘蛛は死亡するとチャージが減るが、Human Formに戻ると再度チャージ状態に戻る。<br>Health: {1}<br>AD: {2}<br>AS: 0.665<br>AR: {3}<br>MR: {4}<br>MS: 355<br>AoEスキルのダメージを{5}低減")
                .variable(1, Value, 85, 0, level(10))
                .variable(2, Value, 10, 10, ap(0.15))
                .variable(3, Value, 30, 20)
                .variable(4, Value, 50, 20)
                .variable(5, Percentage, 20, 5)
                .active("Human Formに変身する。射程が550、移動速度が530になる。また通常攻撃の追加効果がなくなる。{6}。")
                .variable(6, NotSpellCast);
    }

    /**
     * Define skill.
     */
    public static void Evelynn(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}間非戦闘状態の場合、{2}になる。敵チャンピオンに範囲700まで近づくとステルス状態でも視認されるようになる。また、ステルス中は毎秒{3}し、{4}を得る。")
                .variable(1, Time, new Per5Level(6, -1))
                .variable(2, Stealth)
                .variable(3, RestoreMana, amplify(MissingManaRatio, 2))
                .variable(4, IgnoreUnitCollision);

        Q.update(P514)
                .active("視界内にいる最も近くにいる敵ユニット1体に向けて棘を放ち({2})、直線状にいる敵ユニットに{1}を与える。Evelynnが敵ユニットをターゲットしている場合は、その対象に向けて棘が放たれる。")
                .variable(1, MagicDamage, 40, 10, amplify(AP, 0.35, 0.05), amplify(BounusAD, 0.5, 0.05))
                .variable(2, MissileSpeed, 2000)
                .mana(12, 6)
                .cd(1.5)
                .range(500);

        W.update(P514)
                .passive("敵チャンピオンにスキルを当てるたびにこのスキルの{1}する。")
                .variable(1, CDDecrease, 1)
                .active("{3}して、3秒間{2}し{4}を得る。敵チャンピオンを{6}たびに、このスキルの{5}する。")
                .variable(2, MSRatio, 30, 10)
                .variable(3, IgnoreSlow)
                .variable(4, IgnoreUnitCollision)
                .variable(6, Takedown)
                .variable(5, CDDecrease)
                .cd(15);

        E.update(P514)
                .active("対象の敵ユニットに2回連続で{1}を与え、3秒間{2}する。{3}。")
                .variable(1, PhysicalDamage, 35, 20, ap(0.5), bounusAD(0.5))
                .variable(2, ASRatio, 60, 15)
                .variable(3, OnHitEffect)
                .mana(50, 5)
                .cd(9)
                .range(225);

        R.update(P514)
                .active("指定地点の{1}の敵ユニットに{2}と2秒間の{3}を与え、このスキルを命中させた敵チャンピオンごとに6秒間{4}を得る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, amplify(TargetCurrentHealthRatio, 15, 5, ap(0.01)))
                .variable(3, MSSlowRatio, 40, 20)
                .variable(4, Shield, 150, 75)
                .mana(100)
                .cd(150, -30)
                .range(650);
    }

    /**
     * Define skill.
     */
    public static void Ezreal(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("ユニット(敵味方問わず)にスキルを当てる度に6秒間{1}する。この効果は5回まで累積する。").variable(-1, ASRatio, 10);

        Q.update(P514)
                .active("指定方向に魔法の矢を飛ばし、当たった敵ユニットに{1}を与える。このスキルが命中すると、全てのスキルの{2}。{3}")
                .variable(1, PhysicalDamage, 35, 20, ap(0.4), ad(1.1))
                .variable(2, CDDecrease, 1)
                .variable(3, OnHitEffect)
                .mana(28, 3)
                .cd(6, -0.5)
                .range(1150);

        W.update(P514)
                .active("指定方向にチャンピオンにのみ当たる貫通するエネルギーを飛ばし、当たった味方チャンピオンは5秒間{1}し、敵チャンピオンには{2}を与える。")
                .variable(1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .mana(50, 10)
                .cd(9)
                .range(1000);

        E.update(P514)
                .active("指定地点にテレポートし、テレポート先から一番近い敵ユニット({1})1体に{2}を与える。")
                .variable(1, Radius, 750)
                .variable(2, MagicDamage, 75, 50, ap(0.75))
                .mana(90)
                .cd(19, -2)
                .range(475);

        R.update(P514)
                .active("1秒詠唱後、指定方向に射程無限の貫通する魔法の矢を飛ばし当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%ずつ減り、最大で30%まで低下する。また飛行中の矢は{2}。")
                .variable(1, MagicDamage, 350, 150, ap(0.9), bounusAD(1))
                .variable(2, Visionable)
                .mana(100)
                .cd(80)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void FiddleSticks(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive(MagicDamage + "を与えるか" + Q + "を使用した敵ユニットに2.5秒間{1}を与える。").variable(1, MRReduction, 10);

        Q.update(P514).active("対象の敵ユニットに{1}を与える。").variable(1, Fear, 1.25, 0.25).mana(65).cd(15, -1).range(575);

        W.update(P514)
                .active("対象の敵ユニットに5秒間毎秒{1}を与え、{2}する。敵が離れる({3})と詠唱が中断される。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 60, 5))
                .variable(3, Radius, 650)
                .mana(80, 10)
                .cd(10, -1)
                .range(575)
                .type(SkillType.Channel);

        E.update(P514)
                .active("対象の敵ユニットにカラスを飛ばし{1}と{2}を与える。カラスは{4}の敵ユニットに4回まで跳ね返り、同一対象にも跳ね返る。ミニオンとモンスターに対しては{3}を与える。")
                .variable(1, MagicDamage, 65, 20, ap(0.45))
                .variable(2, Silence, 1.25)
                .variable(3, MagicDamage, 97.5, 30, ap(0.675))
                .variable(4, Radius, 450)
                .mana(50, 20)
                .cd(15, -1)
                .range(750);

        R.update(P514)
                .active("1.5秒詠唱後に指定地点にテレポートし、{1}の敵ユニットに5秒間毎秒{2}を与える。最大ダメージは{3}。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 125, 100, ap(0.45))
                .variable(3, MagicDamage, 625, 500, ap(2.25))
                .mana(100)
                .cd(150, -10)
                .range(800)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Fiora(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃または" + Q + "でダメージを与えると、6秒かけて{1}する。対象がチャンピオンの場合、この効果は4回までスタックする。")
                .variable(1, RestoreHealth, 7, 0, level(1));

        Q.update(P514)
                .active("対象の敵ユニットへダッシュし{1}を与える。このスキルは4秒の間、もう1度だけ使用できる。2度目は消費MN無しで使用可能。")
                .variable(1, PhysicalDamage, 40, 25, bounusAD(0.6))
                .mana(60)
                .cd(16, -2)
                .range(600);

        W.update(P514)
                .passive("{1}を得る。")
                .variable(1, AD, 15, 5)
                .active("1.5秒の間に受ける通常攻撃を一度だけ無効化し、その相手に{2}を与える。この効果は一部のミニオンとモンスターには発生しない。")
                .variable(2, MagicDamage, 60, 50, ap(1))
                .mana(45)
                .cd(10, -1);

        E.update(P514)
                .active("3秒間{1}する。効果中に通常攻撃を行うかまたはLungeを使用すると3秒間{2}する。移動速度の増加は3回までスタックする。敵チャンピオンを倒すとこのスキルの{3}する。")
                .variable(1, ASRatio, 60, 15)
                .variable(2, MSRatio, 7, 2)
                .variable(3, CDDecrease)
                .mana(55)
                .cd(15, -1);

        R.update(P514)
                .active("対象の敵チャンピオンにダッシュし{1}を与え、範囲内にいる敵チャンピオンをランダムに対象とし4回{1}を与える(合計5回)。最後の攻撃は最初に対象とした敵チャンピオンで固定。同一ユニットに複数回ダメージを与える場合、2回目以降は40%のダメージになる。単一対象への最大ダメージは{2}。{3}。")
                .variable(1, PhysicalDamage, 120, 130, bounusAD(0.9))
                .variable(2, PhysicalDamage, 312, 338, bounusAD(2.34))
                .variable(3, OnHitEffect)
                .mana(100)
                .cd(130, -10)
                .range(400);
    }

    /**
     * Define skill.
     */
    public static void Fizz(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{2}を得て、{1}する。この軽減は防御力計算後に行われる。")
                .variable(1, AttackDamageReduction, new Per3Level(4, 2))
                .variable(2, IgnoreUnitCollision);

        Q.update(P514)
                .active("対象の敵ユニットに{1}が付与された通常攻撃を与え、その方向に駆け抜ける。移動距離は固定。{2}。")
                .variable(1, MagicDamage, 10, 15, ap(0.3))
                .variable(2, OnHitEffect)
                .mana(50, 5)
                .cd(10, -1)
                .range(550);

        W.update(P514)
                .passive("通常攻撃に{1}が付与される。このダメージは0.5秒毎に3秒間かけて与えられる。")
                .variable(1, MagicDamage, 20, 10, ap(0.45), amplify(TargetMissingHealthRatio, 4, 1))
                .active("6秒間通常攻撃に{2}を付与する。")
                .variable(2, MagicDamage, 10, 10, ap(0.25))
                .mana(40)
                .cd(10);

        E.update(P514)
                .active("指定地点にジャンプする。ジャンプ中はターゲットされない状態になる。0.75秒後にその場に降下し、{1}の敵ユニットに{2}と2秒間{3}を与える。また、ジャンプ中に再使用することで降下する場所を別の指定地点に変更しできる。その場合、{4}の敵ユニットに{5}を与える。")
                .variable(1, Radius, 330)
                .variable(2, MagicDamage, 70, 50, ap(0.75))
                .variable(3, MSSlowRatio, 40, 5)
                .variable(4, Radius, 270)
                .variable(5, MagicDamage, 70, 50, ap(0.75))
                .mana(90, 10)
                .cd(16, -2)
                .range(400);

        R.update(P514)
                .active("指定地点に敵チャンピオンのみに命中する魚を投げ、命中した敵チャンピオンに魚がくっつき、{1}を与える。その1.5秒後に地面から鮫が現れ、魚が命中した対象を襲い、対象とその周囲({2})の敵ユニットに{3}を与え、{4}後に1.5秒間{5}を与える。魚がくっついていた敵チャンピオン以外のユニットには{4}の代わりに{6}を与える。魚がチャンピオンに当たらなかった場合は指定地点に魚が残り、その地点に鮫が現れる。また魚は視界を確保し、その上を敵チャンピオンが通り過ぎると、当たった場合と同様にその敵チャンピオンにくっつき、鮫が襲いかかる。")
                .variable(1, MSSlowRatio, 50, 10)
                .variable(2, Radius, 250)
                .variable(3, MagicDamage, 200, 125, ap(1))
                .variable(4, Knockup)
                .variable(5, MSSlowRatio, 50, 10)
                .variable(6, Knockback)
                .mana(100)
                .cd(100, -15)
                .range(1275);
    }

    /**
     * Define skill.
     */
    public static void Galio(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("{1}を得る。").variable(1, AP, amplify(MR, 0.5));

        Q.update(P514)
                .active("指定地点に魔法弾を飛ばし、{1}の敵ユニットに{2}と2.5秒間{3}を与える。")
                .variable(1, Radius, 235)
                .variable(2, MagicDamage, 80, 55, ap(0.6))
                .variable(3, MSSlowRatio, 24, 4)
                .mana(60, 5)
                .cd(7)
                .range(940);

        W.update(P514)
                .active("4秒間対象のチャンピオンは{1}と{2}を得て、効果中にその対象のチャンピオンがダメージを受ける度に自身の{3}する。自身に使用した場合はダメージを受けてから回復される。")
                .variable(1, AR, 30, 15)
                .variable(2, MR, 30, 15)
                .variable(3, RestoreHealth, 25, 15, ap(0.3))
                .mana(60)
                .cd(13)
                .range(800);

        E.update(P514)
                .active("指定方向に風を発生させ、当たった敵ユニットに{1}を与える。このスキルを使用すると指定した方向に5秒間持続する風が残り、その風の進行方向上にいる味方ユニットは{2}する。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, MSRatio, 20, 8)
                .mana(70, 5)
                .cd(13, -1)
                .range(1180);

        R.update(P514)
                .active("{1}の敵ユニットに{2}を与え、さらに2秒間詠唱を行う。詠唱中は{3}して、ダメージを受ける度にこのスキルのダメージが最大80％まで10%ずつ増加していく。詠唱中に" + W + "を使用することが出来る。詠唱完了またはキャンセル時に、周囲の敵ユニットの" + Taunt + "を解除するとともに{4}を与える。最大ダメージは{5}。キャンセル時は効果範囲が575に減少する。なお、このスキルの" + Taunt + "の効果時間は" + Tenacity + "の影響を受けない。")
                .variable(1, Radius, 600)
                .variable(2, Taunt, 2)
                .variable(3, DamageReductionRatio, 50)
                .variable(4, MagicDamage, 200, 100, ap(0.6))
                .variable(5, MagicDamage, 360, 540, ap(1.08))
                .mana(100)
                .cd(150, -15)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Gangplank(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃時に1.5秒間かけて{1}を与え、2秒間{2}する。" + E + "を破壊するとこのスキルの{3}し、2秒間{2}する。{4}。")
                .variable(1, TrueDamage, 20, 0, ad(1.2), level(10))
                .variable(-2, MSRatio, 30)
                .variable(3, CDDecrease)
                .variable(4, CDRUnaware)
                .cd(-15);

        Q.update(P514)
                .active("対象の敵ユニットに{1}(クリティカルあり)を与える。このスキルで敵ユニットを倒すと{4}し、{2}を得る。{3}(ただし" + P + "は除く)。")
                .variable(1, PhysicalDamage, 20, 25, ad(1))
                .variable(2, Gold, 4, 1)
                .variable(3, OnHitEffect)
                .variable(4, RestoreMana, 25)
                .mana(50)
                .cd(5)
                .range(625);

        W.update(P514)
                .active("自身のDebuffを取り除き{1}する。StunなどのDisable中でも使用可能。")
                .variable(1, RestoreHealth, 50, 25, ap(0.9), amplify(MissingHealthRatio, 15))
                .mana(60, 10)
                .cd(22, -2);

        E.update(P514)
                .passive("{1}毎に火薬樽が貯まる。最大値は{2}。")
                .variable(1, Time, 18, -1)
                .variable(2, Value, new Refer(R, 2, 1))
                .active("60秒間火薬樽を指定の位置に設置する。樽はHP3を持ち、自身か敵チャンピオンが攻撃する若しくは{3}毎にHP1まで1ずつ減少する。HP1の樽を敵が攻撃すると樽は解除される。自身が攻撃すると爆発して、その攻撃が{4}の敵への" + ARPen + "60%を持つ物理範囲攻撃となり、2秒間{5}を与える。敵チャンピオンに対しては追加で{6}を与える。{7}に火薬樽がある場合、爆発は連鎖していく。")
                .variable(3, Time, new Per6Level(2, -0.5))
                .variable(4, Radius, 400)
                .variable(5, Status.MSSlowRatio, 60)
                .variable(6, PhysicalDamage, 80, 30)
                .variable(7, Radius, 650)
                .range(1000)
                .cd(25);

        R.update(P514)
                .passive(E + "のスタック最大値が{1]増加する。")
                .variable(1, Value, 0, 1)
                .active("MAP内の指定した地点に砲撃を行い、{3}の{2}。8秒間2秒に3回砲弾が降り注ぎ、{4}と0.5秒間{5}を与える。全段命中すると{6}。")
                .variable(2, Status.Visionable)
                .variable(3, Radius, 600)
                .variable(4, MagicDamage, 50, 20, ap(0.1))
                .variable(5, MSSlowRatio, 30)
                .variable(6, MagicDamage, 600, 240, ap(1.2))
                .mana(100)
                .cd(120, -5)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Garen(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}間敵Minion以外からダメージを受けない状態が続くと、以降敵ミニオン（Lv11からはバロン・ドラゴン以外のモンスター）以外からダメージを受けるまで毎秒{2}する。")
                .variable(1, Time, new PerLevel(new int[] {1, 11, 16}, new double[] {9, 6, 4}))
                .variable(2, RestoreHealth, amplify(Health, new PerLevel(new int[] {1, 11, 16}, 0.004, 0.008, 0.02)));

        Q.update(P514)
                .active("{1}間{2}し、スキル使用後6秒間に行った次の通常攻撃に追加{3}と{4}が付与される。またこのスキル使用時に自身にかかっているスローを解除する。")
                .variable(1, Time, 1.5, 0.75)
                .variable(2, MSRatio, 35)
                .variable(3, PhysicalDamage, 30, 25, ad(0.4))
                .variable(4, Silence, 1.5, 0.25)
                .cd(8);

        W.update(P514)
                .passive("{1}し{2}する。")
                .variable(1, AR, amplify(BounusAR, 0.2))
                .variable(2, MR, amplify(BounusMR, 0.2))
                .active("{3}間{4}し、{5}を得る。")
                .variable(3, Time, 2, 1)
                .variable(4, DamageReductionRatio, 30)
                .variable(5, Tenacity, 30)
                .cd(24, -1);

        E.update(P514)
                .active("Garenが3秒間回転し、{5}の敵ユニットに0.5秒毎に{1}を与える(最大6hitで{2})。このスキルにはクリティカル判定があり、クリティカル時は追加{3}を与える。回転中は{4}を得るが、敵ミニオンをすり抜けている間は移動速度が20%低下し、ミニオンに与えるダメージは通常の75%。")
                .variable(1, PhysicalDamage, 10, 12.5, amplify(AD, 0.35, 0.05))
                .variable(2, PhysicalDamage, 60, 75, amplify(AD, 2.1, 0.3))
                .variable(3, PhysicalDamage, amplify(AD, 0.175, 0.025))
                .variable(4, IgnoreUnitCollision)
                .variable(5, Radius, 300)
                .cd(13, -1);

        R.update(P514)
                .active("対象の敵チャンピオンに{1}を与える。")
                .variable(1, MagicDamage, 175, 175, amplify(TargetMissingHealthRatio, new Fixed(28.57, 33.3, 40)))
                .cd(160, -40)
                .range(400);
    }

    /**
     * Define skill.
     */
    public static void Gnar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("Mini Gnarの時に戦闘を行うと3秒間かけてRage{1}を得る。通常攻撃と" + Q + "で" + Damage + "を与えると追加で{2}のRageを得る(ミニオン、モンスター及び建物との戦闘の場合は25%)。13秒間戦闘を行わないとRageは減衰していく。Rageが100になった時にスキルを使用または5秒経過すると、Mega Gnarに変身する。Mega Gnarでは近接攻撃になり、スキルが変化する。15秒間経過するとMini Gnarに戻り、Rageは0になる。Mini Gnarに戻ると15秒間Rageが増加しなくなる。<br>Mini Gnar<br>MS: {3}<br>Range: {4}<br>AS: {5}<br>Mega Gnar<br>HP: {6}<br>AR: {7}<br>MR: {8}<br>Hreg: {9}<br>AD: {10}")
                .variable(1, Value, new Per5Level3Times(4, 7, 11))
                .variable(2, Value, new Per5Level3Times(2, 3, 5))
                .variable(3, MS, 9, 0, level(1))
                .variable(4, Range, 245, 0, level(5))
                .variable(5, ASRatio, level(5.5))
                .variable(-6, Health, level(43))
                .variable(-7, AR, level(2))
                .variable(-8, MR, level(2))
                .variable(-9, Hreg, level(2.5))
                .variable(-10, AD, level(2.5));

        Q.update(P514)
                .active("Mini Gnar<br>指定方向にブーメランを投げ、当たった敵ユニットに{1}と2秒間{2}を与える。ブーメランは2hit目以降の敵ユニットには50%のダメージを与える。ブーメランは最大距離まで飛んだ後、自身がいる位置に戻ってくるが、敵ユニットに当たる度に戻るまでの間隔が早くなる。戻ってきたブーメランは少しずつ加速し、戻り始めた位置から距離2500まで飛ぶ。これをキャッチすると、このスキルの{3}する。またブーメランは同一の対象には一度しか命中しない。<br>Mega Gnar<br>指定方向に岩を投げ、当たった敵ユニットと{4}の敵ユニットに{5}と2秒間{2}を与える。投げた岩はその場に留まり、岩を回収するとこのスキルの{6}する。")
                .variable(1, PhysicalDamage, 5, 30, ad(1.15))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, CDDecreaseRatio, new ReferPlus(R, 45, 5))
                .variable(4, Radius, 250)
                .variable(5, PhysicalDamage, 5, 40, ad(1.2))
                .variable(6, CDDecreaseRatio, 60)
                .cd(20, -2.5)
                .range(1100);

        W.update(P514)
                .passive("<br>Mini Gnar<br>通常攻撃かスキルで" + Damage + "を与えた敵ユニットにスタックを付与する。スタック数が3になるとスタックを消費し{1}を与え、3秒間{2}する。この移動速度増加は時間と共に減衰する。建物には無効。また、この移動速度増加はMega GnarからMini Gnarに戻った時にも発動する。")
                .variable(1, MagicDamage, 10, 10, amplify(TargetMaxHealthRatio, 6, 2), ap(1))
                .variable(2, MSRatio, new ReferPlus(R, 30, 15))
                .active("Mega Gnar<br>指定方向に腕を叩き付け{3}の敵ユニットに{4}と{5}を与える。")
                .variable(3, Radius)
                .variable(4, PhysicalDamage, 25, 20, ad(1))
                .variable(5, Stun, 1.25)
                .cd(15, -2);

        E.update(P514)
                .active("Mini Gnar<br>指定地点にジャンプし、3秒間{1}する。指定した地点にユニット(味方可)がいた場合、そのユニットを踏みつけ更にもう一度ジャンプを行う。踏みつけた対象が敵ユニットの場合、対象に{2}と0.5秒{3}を与える。<br>Mega Gnar<br>指定地点にジャンプし、{4}の敵ユニットに{2}を与える。範囲内の中心点にいる敵ユニットには、0.5秒間{3}を与える。")
                .variable(1, ASRatio, 20, 10)
                .variable(2, PhysicalDamage, 20, 40, amplify(Health, 0.06))
                .variable(3, MSSlowRatio, 60)
                .variable(4, Radius)
                .cd(18, -1.5)
                .range(475);

        R.update(P514)
                .active("Mega Gnar<br>{1}にいる敵ユニットを指定した方向に{2}し{3}と{4}間{5}を与える。" + Knockback + "した敵ユニットが壁等に当たると{6}と{7}を与える。")
                .variable(1, Radius, 590)
                .variable(2, Knockback)
                .variable(3, PhysicalDamage, 200, 100, bounusAD(0.2), ap(0.5))
                .variable(4, Time, 1.25, 0.25)
                .variable(5, MSSlowRatio, 45)
                .variable(6, PhysicalDamage, 350, 150, bounusAD(0.3), ap(0.75))
                .variable(7, Stun, 1.25, 0.25)
                .cd(120, -20);
    }

    /**
     * Define skill.
     */
    public static void Gragas(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("スキルを使用すると{1}する。").variable(1, RestoreHealth, amplify(Health, 0.04)).cd(-8);

        Q.update(P514)
                .active("指定地点に樽を転がし、爆発時に{1}の敵ユニットに{2}と1.3秒間{3}及び{4}を与える。樽は4秒経つか、スキルを再度使用すると爆発する。樽は設置後、2秒かけて" + Damage + "と" + MSSlow + "及び" + ASSlow + "の効果が最大50%まで増加していく。樽は設置場所の{5}。ミニオンに対しては70％の" + Damage + "を与える。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 80, 40, ap(0.6))
                .variable(3, MSSlowRatio, 40, 5)
                .variable(4, ASSlowRatio, 40, 5)
                .variable(5, Visionable)
                .mana(60, 5)
                .cd(11, -1)
                .range(850);

        W.update(P514)
                .active("2.5秒間{1}を得る。1s詠唱後に次の5秒以内の通常攻撃に{2}が付与される。モンスターに対しては上限300。")
                .variable(1, DamageReductionRatio, 10, 2)
                .variable(2, MagicDamage, 20, 30, ap(0.3), amplify(TargetMaxHealthRatio, 8, 1))
                .cd(8, -1)
                .mana(30);

        E.update(P514)
                .active("指定方向に突進し、衝突した敵ユニットと{4}の敵ユニットに{1}と{2}、{3}を与える。衝突時に突進は止まる。ユニットに当たった場合{4}する。")
                .variable(1, MagicDamage, 80, 40, ap(0.6))
                .variable(2, Knockback)
                .variable(3, Stun, 1)
                .variable(4, CDDecrease, 3)
                .mana(50)
                .cd(12)
                .range(600);

        R.update(P514)
                .active("指定地点に爆発する樽を投げ、{1}内の敵ユニットに{2}を与え、{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 200, 100, ap(0.7))
                .variable(3, Knockback, 600)
                .mana(100)
                .cd(100, -10)
                .range(1150);
    }

    /**
     * Define skill.
     */
    public static void Graves(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("戦闘状態になると1秒ごとにスタックが1増加し、スタック数に比例して{1}と{2}を得る。スタックは10回まで累積し、3秒間戦闘を行わないと0になる。")
                .variable(1, AR, new Per6Level(1, 1))
                .variable(2, MR, new Per6Level(1, 1));

        Q.update(P514)
                .active("指定方向扇形の範囲に貫通する弾を3発発射し、当たった敵ユニットに{1}を与える。同一対象に対して複数hitし、2発目以降は本来の50%分の" + Damage + "を与える(3発hitで合計{2})。")
                .variable(1, PhysicalDamage, 60, 30, bounusAD(0.75))
                .variable(2, PhysicalDamage, 120, 60, bounusAD(1.5))
                .mana(60, 10)
                .cd(12, -1)
                .range(950);

        W.update(P514)
                .active("指定地点にスモーク弾を発射し{3}の敵ユニットに{1}を与え、4秒間持続する煙幕を残す。煙幕内にいる敵チャンピオンに視界低下と{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.6))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, Radius, 250)
                .mana(70, 5)
                .cd(20, -1)
                .range(950);

        E.update(P514)
                .active("指定方向にダッシュし4秒間{1}する。このスキルは自身が通常攻撃を行う毎に{2}する。対象が建物の場合は無効。")
                .variable(1, ASRatio, 30, 10)
                .variable(2, CDDecrease, 1)
                .mana(40)
                .cd(22, -2)
                .range(425);

        R.update(P514)
                .active("指定方向にミニオンを貫通する爆発弾を発射し、hitした敵ユニットに{1}を与える。敵チャンピオンにhitするか最大距離飛ぶとターゲット後方に扇形に爆発が広がり、{3}の敵ユニットに{2}を与える。")
                .variable(1, PhysicalDamage, 250, 150, bounusAD(1.5))
                .variable(2, PhysicalDamage, 200, 120, bounusAD(1.2))
                .variable(3, Radius, 800)
                .mana(100)
                .cd(100, -10)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Hecarim(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{2}と{1}を得る。")
                .variable(1, AD, amplify(BounusMS, new Per3LevelAdditional(0.15, 0.025)))
                .variable(2, IgnoreUnitCollision);

        Q.update(P514)
                .active("武器を振り回し{2}の敵ユニットに{1}を与える。このスキルが敵ユニットに命中した場合1スタックを得て、1スタックにつきこのスキルの{4}する(最大2スタック)。スタックは8秒間増加がないと0になる。ミニオンには{3}を与える。")
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.6))
                .variable(2, Radius, 350)
                .variable(3, PhysicalDamage, 40, 23.3, bounusAD(0.4))
                .variable(4, CDDecrease, 1)
                .mana(32, 2)
                .cd(4);

        W.update(P514)
                .active("4秒間{1}の敵ユニットに毎秒{2}を与える。この効果を受けている敵ユニットがダメージを受けた場合、{3}する（ミニオン及びモンスターに対しては{4}が上限）。")
                .variable(1, Radius, 525)
                .variable(2, MagicDamage, 20, 10, ap(0.2))
                .variable(3, RestoreHealth, amplify(DealtDamageRatio, 20))
                .variable(4, Value, 90, 30)
                .mana(50, 10)
                .cd(22, -1);

        E.update(P514)
                .active("3秒間{1}して(最大75%)、その後1秒間その移動速度を維持する。また次の通常攻撃のダメージはこのスキルを使用してから移動した距離に比例し最小で{3}、最大で{4}を与えるようになり、{2}が付与される。")
                .variable(1, MSRatio, 20, 0, amplify(Duration, 18.3))
                .variable(2, Knockback, 300)
                .variable(3, PhysicalDamage, 40, 35, bounusAD(0.5))
                .variable(4, PhysicalDamage, 80, 70, bounusAD(1))
                .mana(60)
                .cd(24, -2);

        R.update(P514)
                .active("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに{1}を与える。指定した地点に到着すると衝撃波を放ち、{2}の敵ユニットに{4}を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。" + Terrified + "に陥ったユニットは強制的にHecarimから遠ざかるように移動する。この時、Hecarimとの距離に比例して移動速度が変化する。")
                .variable(1, MagicDamage, 150, 100, ap(1))
                .variable(2, Radius)
                .variable(4, Terrified, 1)
                .mana(100)
                .cd(140, -20)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Heimerdinger(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}の味方ユニットと" + P + "は{2}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, Hreg, new Per4Level(10, 5));

        Q.update(P514)
                .active("スタックを消費して指定地点にTurretを最大3つまで設置する。スタックは{1}毎に増加し、最大{2}まで貯めることが出来る。塔に与えるダメージは半分。Heimerdingerが攻撃する若しくは攻撃されている場合、その対象を優先で攻撃。8秒間砲台と距離1000以上離れていた場合、砲台の動作が停止する。<br>HP: {3}<br>砲撃: {4}　{5}<br>ビーム: {6}　{7}　（16秒毎）<br>AR: {8}<br>MR: {9}<br>AS: 1.75<br>視界: 525")
                .variable(1, CDRAwareTime, 24, -1)
                .variable(2, Stack, new Fixed(new double[] {1, 1, 2, 2, 3}))
                .variable(3, Value, 125, 0, level(25), amplify(AP, new PerLevel(new int[] {1, 9, 10, 11, 12, 13, 14, 15,
                        16, 17, 18}, 5, 3.5)))
                .variable(4, Radius, 525)
                .variable(5, MagicDamage, 12, 6, ap(0.15))
                .variable(6, Radius, 1100)
                .variable(7, MagicDamage, 40, 20, ap(0.55))
                .variable(8, AR, new PerLevel(new int[] {1, 7, 9, 11, 12, 13, 14, 15, 16, 17,
                        18}, 10, 15, 20, 25, 30, 35, 40, 50, 60, 70, 80))
                .variable(9, MR, new PerLevel(new int[] {1, 9, 11, 13, 14, 15, 16, 17, 18}, 25, 5))
                .mana(20)
                .cd(1)
                .range(450);

        W.update(P514)
                .active("指定地点に目掛けて、5本のミサイルを扇状に発射する。ミサイルが指定地点を通過する後も一直線に飛行し続ける。命中すると{1}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に5発命中すると{2})。Minionに対しては60%のダメージを与える。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, MagicDamage, 108, 54, ap(0.81))
                .mana(70, 10)
                .cd(11)
                .range(1100);

        E.update(P514)
                .active("指定地点に手榴弾を投げ、破裂した{1}にいる敵ユニットに{2}と2秒間{3}を与え、{6}のユニットにはさらに{4}を与える。また指定地点の{5}。")
                .variable(1, Radius, 210)
                .variable(2, MagicDamage, 60, 40, ap(0.6))
                .variable(3, MSSlowRatio, 35)
                .variable(4, Stun, 1.25)
                .variable(5, Visionable)
                .variable(6, Radius, 135)
                .mana(85)
                .cd(18, -2)
                .range(925);

        R.update(P514)
                .active("次に使用するスキルの効果を強化する。強化されたスキルは一切のコストなしで使用でき、効果はこのスキルのLvに依存する。発動してから3秒間何も使わない場合は再発動可能になり、もう一度使用するとCD3秒でキャンセルする。<br>" + Q + "<br>Turretの上限を無視する特殊なTurretを1個設置する。8秒間持続する。砲撃に100%のスプラッシュダメージと1秒間{1}が付与される。<br>HP: {3}<br>砲撃: {4}　{5}<br>ビーム: {6}　{7}　（6秒毎）<br><br>" + W + "<br>指定地点に目掛けて、5本のミサイルを扇状に4回発射する。命中すると{8}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に20発命中すると{9})。<br><br>" + E + "<br>2回までバウンドしつつ3回放電する手榴弾を投げる。作動した箇所にいる{10}にいる敵ユニットに{11}と2秒間{12}を与え、真ん中のユニットにはさらに{13}を与える。")
                .variable(1, MSSlowRatio, 25)
                .variable(3, Value, 550, 0, level(50), amplify(AP, new PerLevel(new int[] {1, 9, 10, 11, 12, 13, 14, 15,
                        16, 17, 18}, 0.25, 0.175)))
                .variable(4, Radius, 525)
                .variable(5, MagicDamage, 70, 20, ap(0.3))
                .variable(6, Radius, 1100)
                .variable(7, MagicDamage, 180, 60, ap(0.7))
                .variable(8, MagicDamage, 135, 45, ap(0.45))
                .variable(9, MagicDamage, 648, 216, ap(2.16))
                .variable(10, Radius, 420)
                .variable(11, MagicDamage, 150, 50, ap(0.6))
                .variable(12, MSSlowRatio, 80)
                .variable(13, Stun, 1.25)
                .mana(100)
                .cd(100, -20);
    }

    /**
     * Define skill.
     */
    public static void Irelia(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("視界内の敵チャンピオン数に応じて{1}を得る。")
                .variable(-1, Tenacity, new PerChampion(10, 25, 40))
                .range(1200);

        Q.update(P514)
                .active("対象の敵ユニットに突進し、{1}を与える。このスキルで敵を倒したとき、このスキルの{2}され{3}する。{4}。")
                .variable(1, PhysicalDamage, 20, 30, ad(1))
                .variable(2, CDDecrease)
                .variable(3, RestoreMana, 35)
                .variable(4, OnHitEffect)
                .mana(60, 5)
                .cd(14, -2)
                .range(650);

        W.update(P514)
                .passive("通常攻撃を行う度に{1}する。")
                .variable(1, RestoreHealth, 5, 2)
                .active("6秒間通常攻撃に{2}が付与され、PassiveのHP回復量が倍になる。")
                .variable(2, TrueDamage, 15, 15)
                .mana(40)
                .cd(15);

        E.update(P514)
                .active("対象の敵ユニットに{1}を与える。対象の残HPの割合がIreliaより高かった場合{2}間{3}を与え、低かった場合は{4}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.5))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 60, 0)
                .variable(4, Stun, 1, 0.25)
                .mana(50, 5)
                .cd(8)
                .range(425);

        R.update(P514)
                .active("指定方向に貫通する刃を飛ばし、当たった敵ユニットに{1}を与える。このスキルは15秒の間、4回まで連続して使用できる(但し、一度使用する度に0.5秒のCDが発生する)。2〜4発目はマナコスト無しで使用可能。ミニオンやモンスターにダメージを与えると{2}し、チャンピオンにダメージを与えると{3}する。")
                .variable(1, PhysicalDamage, 80, 40, ap(0.5), bounusAD(0.6))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 10))
                .variable(3, RestoreHealth, amplify(DealtDamageRatio, 25))
                .mana(100)
                .cd(70, -10)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Janna(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("{1}の全ての味方チャンピオンは{2}する。").variable(1, Range, 1250).variable(2, MSRatio, 8);

        Q.update(P514)
                .active("指定方向に竜巻を発生させ、触れた敵ユニットに{1}と{2}を与える。竜巻は3秒経過するか再度スキル使用で飛ばすことができるが、溜めた時間に比例して" + MagicDamage + "、射程距離、打ち上げ時間が増加する。")
                .variable(1, MagicDamage, 60, 25, ap(0.35), amplify(Duration, 15, 5, ap(0.1)))
                .variable(2, Knockup, 0.5, 0, amplify(Duration, 0.25))
                .mana(90, 15)
                .cd(14, -1)
                .range(new Diff(1100, 0, 1), amplify(Duration, 200));

        W.update(P514)
                .passive("{1}し{2}を得る。")
                .variable(1, MSRatio, 9, 2, ap(0.02))
                .variable(2, IgnoreUnitCollision)
                .active("対象の敵ユニットに{3}と3秒間{4}を与える（最大で80%）。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .variable(3, MagicDamage, 60, 55, ap(0.5))
                .variable(4, MSSlowRatio, 24, 4, ap(0.06))
                .mana(40, 10)
                .cd(12)
                .range(600);

        E.update(P514)
                .active("対象の味方チャンピオンか塔に5秒間{1}を付与する。シールドが持続している間は対象は{2}を得る。")
                .variable(1, Shield, 80, 40, ap(0.7))
                .variable(2, AD, 14, 9, ap(0.1))
                .mana(70, 10)
                .cd(10)
                .range(725);

        R.update(P514)
                .active("{1}の敵ユニットを{2}して3秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。最大で{4}する。")
                .variable(1, Radius, 725)
                .variable(2, Knockback, 875)
                .variable(3, RestoreHealth, 100, 50, ap(0.6))
                .variable(4, RestoreHealth, 300, 150, ap(1.8))
                .mana(100)
                .cd(150, -15)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void JarvanIV(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃に{1}を付与する（400" + Damage + "が上限）。同一の対象には{2}に一度しか発動しない。")
                .variable(1, PhysicalDamage, amplify(TargetCurrentHealthRatio, 10))
                .variable(2, Time, new Per6Level(10, -2));

        Q.update(P514)
                .active("槍を突き出して直線上の敵ユニットに{1}を与え、3秒間{2}を与える。" + E + "の旗にヒットした場合、旗の位置まで突進し、進路上の敵ユニット({4})に{3}を与える。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1.2))
                .variable(2, ARReductionRatio, 10, 4)
                .variable(3, Knockup, 0.75)
                .variable(4, Radius, 180)
                .mana(45, 5)
                .cd(10, -1)
                .range(770);

        W.update(P514)
                .active("5秒間{1}を得て、{2}の敵ユニットに２秒間{3}を与える。")
                .variable(1, Shield, 50, 40, amplify(EnemyChampion, 20, 10))
                .variable(2, Radius, 300)
                .variable(3, MSSlowRatio, 15, 5)
                .mana(30)
                .cd(20, -2);

        E.update(P514)
                .passive("{1}する。")
                .variable(1, ASRatio, 10, 3)
                .active("指定地点に旗を投げ、{3}の敵ユニットに{4}を与える。旗は8秒間その場に残り{6}の{7}ともに、{5}の味方チャンピオンは{1}する。(自身はPassiveと合わせて倍の効果を受ける)")
                .variable(3, Radius, 75)
                .variable(4, MagicDamage, 60, 45, ap(0.8))
                .variable(5, Radius, 600)
                .variable(6, Radius, 700)
                .variable(7, Visionable)
                .mana(55)
                .cd(13, -0.5)
                .range(830);

        R.update(P514)
                .active("対象の敵チャンピオンまで跳躍して{1}を与え、3.5秒間その周囲に通行不可能の円形の地形を作る。再度このスキルを使用すると地形を破壊できる。")
                .variable(1, PhysicalDamage, 200, 125, bounusAD(1.5))
                .mana(100, 25)
                .cd(120, -15)
                .range(650);
    }

    /**
     * Define skill.
     */
    public static void Jax(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃を行う度にスタックが1増加し、スタック数に比例して{1}する(最大6スタック)。スタックは2.5秒増加がないと0になる。")
                .variable(-1, ASRatio, new Per3Level(4, 2));

        Q.update(P514)
                .active("対象のユニットまで飛びかかる。対象が敵ユニットの場合、{1}を与える。")
                .variable(1, PhysicalDamage, 70, 40, ap(0.6), bounusAD(1))
                .mana(65)
                .cd(10, -1)
                .range(700);

        W.update(P514)
                .active("次の通常攻撃か" + Q + "に{1}を付与する。建物には無効。{2}。")
                .variable(1, MagicDamage, 40, 35, ap(0.6))
                .variable(2, ResetAATimer)
                .mana(30)
                .cd(7, -1);

        E.update(P514)
                .active("2秒間、Jaxが受けるタワー以外の通常攻撃を無効化し、AoEダメージを25%低減、さらに効果終了時に{1}の敵ユニットに{2}と{3}を与える。スキルを使用してから1秒経つと再使用できるようになり、任意に効果を終了できる。通常攻撃を回避する度にこのスキルのダメージが20%ずつ増加する(上限は100%、最大で2倍ダメージ)。")
                .variable(1, Radius, 187.5)
                .variable(2, PhysicalDamage, 50, 25, bounusAD(0.5))
                .variable(3, Stun, 1)
                .mana(70, 5)
                .cd(16, -2);

        R.update(P514)
                .passive("通常攻撃3回毎に{1}を与える。建物には無効。")
                .variable(1, MagicDamage, 100, 60, ap(0.7))
                .active("8秒間{2}と{3}を得る。")
                .variable(2, AR, 30, 20, bounusAD(0.5))
                .variable(3, MR, 30, 20, ap(0.2))
                .mana(100)
                .cd(80);
    }

    /**
     * Define skill.
     */
    public static void Jayce(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}と{2}を得る。" + R + "を使用すると1.25秒間{3}し{4}を得る。")
                .variable(1, AR, new Refer(R, 5, 10))
                .variable(2, MR, new Refer(R, 5, 10))
                .variable(-3, MS, 40)
                .variable(4, IgnoreUnitCollision);

        Q.update(P514)
                .active("対象の敵ユニットに飛びかかり、対象と{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 30, 40, bounusAD(1))
                .variable(3, MSSlowRatio, 30, 5)
                .mana(40, 5)
                .cd(16, -2)
                .range(600);

        W.update(P514)
                .passive("通常攻撃すると{1}する。")
                .variable(1, RestoreMana, 6, 2)
                .active("4秒間雷のオーラを身にまとい、{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 285)
                .variable(3, MagicDamage, 25, 15, ap(0.25))
                .mana(40)
                .cd(10);

        E.update(P514)
                .active("対象の敵ユニットに{1}と0.75秒{3}を与える。ミニオンやモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 0, 0, bounusAD(1), amplify(TargetMaxHealthRatio, 8, 2.4))
                .variable(2, MagicDamage, 200, 100)
                .variable(3, Knockback)
                .mana(40, 10)
                .cd(15, -1)
                .range(240);

        R.update(P514)
                .active("射程が500(Ranged)になる。また、次の通常攻撃は５秒間{1}と{2}を与える。")
                .variable(1, ARReductionRatio, 10, 5)
                .variable(2, MRReductionRatio, 10, 5)
                .cd(6);

        R.update(P514)
                .active("射撃形態に変身する。射程が500になり、次の通常攻撃は５秒間{1}と{2}を与える。{3}。")
                .variable(1, ARPenRatio, 10, 5)
                .variable(2, MRPenRatio, 10, 5)
                .variable(3, NotSpellCast);
    }

    /**
     * Define skill.
     */
    public static void JayceTransformed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}する。" + R + "を使用すると1.25秒間{2}し{3}を得る。")
                .variable(1, Range, 375)
                .variable(-2, MS, 40)
                .variable(3, IgnoreUnitCollision);

        Q.update(P514)
                .active("指定方向に{3}の雷のオーブを飛ばし、敵ユニットに命中するか一定距離で爆発し、{4}の敵ユニットに{1}を与える。オーブがAcceleration Gateによって生成されたゲートを通過した場合、弾速、射程距離、爆発範囲、ダメージが各40%増加し{2}を与える。")
                .variable(1, PhysicalDamage, 70, 50, bounusAD(1.2))
                .variable(2, PhysicalDamage, 98, 70, bounusAD(1.68))
                .variable(3, MissileSpeed, 1450)
                .variable(4, Radius)
                .mana(55, 5)
                .cd(8)
                .range(1050);

        W.update(P514)
                .active("４秒間攻撃速度が最大まで上昇する。3回通常攻撃を行うと効果が終了する。また効果中は通常攻撃で与えるダメージが{1}%になる。")
                .variable(1, Percentage, 70, 8)
                .mana(40)
                .cd(13, -1.6);

        E.update(P514)
                .active("4秒間持続するゲート(通りぬけ可能)を生成し、触れた味方ユニットは3秒間{1}する。移動速度は3秒かけて元に戻る。")
                .variable(1, MSRatio, 30, 5)
                .mana(50)
                .cd(16)
                .range(650);

        R.update(P514)
                .active("近接形態に変身する。射程が125になり、その間は{1}と{2}を得る。また、次の通常攻撃に{3}を付与する。{4}。")
                .variable(-1, AR, 5, 10)
                .variable(-2, MR, 5, 10)
                .variable(3, MagicDamage, 20, 40, ap(0.4))
                .variable(4, NotSpellCast)
                .cd(6);
    }

    /**
     * Define skill.
     */
    public static void Jinx(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("攻撃した敵チャンピオンまたはタワーが3秒以内に死亡/破壊された場合、4秒間{1}する。移動速度は4秒かけて減衰する。").variable(-1, MSRatio, 175);

        Q.update(P514)
                .passive("通常攻撃毎にスタックが貯まる。スタック2.5秒持続して最大3スタックで{1}し、また{2}する。" + AS + "の増加量はスタック1で5割、スタック2で7割5分、スタック3で10割となる。攻撃を行わないと、2.5秒毎に1つずつ減少していく。このスキルを使用するとスタックによる攻撃速度増加は無効になる。")
                .variable(-1, ASRatio, 30, 10)
                .variable(-2, ASRatio, new Per1Level(0, 2, 4, 6, 8, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70))
                .active("通常攻撃は{3}し{4}が付与され、対象の{5}にいる敵にも同様のダメージを与えるようになる。")
                .variable(3, Range, 75, 25)
                .variable(4, PhysicalDamage, 0, 0, ad(0.1))
                .variable(5, Radius, 150)
                .mana(20)
                .cd(0.9)
                .type(SkillType.ToggleForAttack);

        W.update(P514)
                .active("0.6秒詠唱後、指定方向に電撃を放ち、当たった敵ユニットに{1}と2秒間{2}を与え、2秒間そのユニットの{3}。")
                .variable(1, PhysicalDamage, 10, 50, ad(1.4))
                .variable(2, MSSlowRatio, 30, 10)
                .variable(3, Visionable)
                .mana(50, 10)
                .cd(10, -1)
                .range(1500);

        E.update(P514)
                .active("指定地点に3つの罠を仕掛ける。敵チャンピオンが罠に触れると爆発し、{1}にいる敵ユニットに1.5秒かけて{2}を与え、更に罠に触れた敵チャンピオンに{3}を与える。罠は設置から{6}経過しないと反応せず、ひとつづつしか反応しない。一人のチャンピオンが３つ全ての罠にかかった場合は{5}を与える。罠は5秒経過すると自動的に爆発する。また罠は{4}。")
                .variable(1, Radius, 50)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(3, Snare, 1.5)
                .variable(4, Visionable)
                .variable(5, MagicDamage, 240, 165, ap(3))
                .variable(6, Time, 0.7)
                .mana(50)
                .cd(24, -2)
                .range(900);

        R.update(P514)
                .active("指定方向にロケットを放つ。ロケットが敵チャンピオンに命中すると爆発し、{1}の敵ユニットに{2}を与える。ロケットが発射から当たるまでの時間に比例してダメージが増加する(1秒で最大値になり{3}を与える、またミニオンに対しては300" + Damage + "が上限)。ロケットの爆風に当たった敵ユニットには80%のダメージを与える。")
                .variable(1, Radius, 225)
                .variable(2, PhysicalDamage, 25, 10, bounusAD(0.1), amplify(TargetMissingHealthRatio, 25, 5))
                .variable(3, PhysicalDamage, 250, 100, bounusAD(1), amplify(TargetMissingHealthRatio, 25, 5))
                .mana(100)
                .cd(90, -15)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Kalista(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("専用アイテムを使用して、味方チャンピオンに使用すると「魂盟の同志」となる。この効果は試合開始3分までは、他のチャンピオンに付け直すことができる。通常攻撃の" + Damage + "が10%低下しキャンセル不可能になるが、通常攻撃を行った直後、又は" + P + "を使用した直後に移動を行うと、移動の代わりに一定距離ステップする。ステップの距離は所有している靴アイテムのランクにより増加する。<br>靴なし: 250<br>" + Item.BootsOfSpeed + ": 300<br>それ以外: 350");

        Q.update(P514)
                .active("槍を投げ、命中した敵に{1}を与える。このスキルの攻撃は、" + P + "、" + W + "、および" + E + "の効果を発動する。命中した敵を倒すと槍が貫通し、次に命中した敵に{1}と倒した敵に貯まっていた" + E + "のスタックを与える。")
                .variable(1, PhysicalDamage, 10, 60, ad(1))
                .cd(8)
                .mana(50, 5)
                .range(1200);

        W.update(P514)
                .passive("自身と「魂盟の同志」が同じ対象に対し2秒以内に通常攻撃をすると、{1}を与える。ミニオンとモンスターに対しては{2}が上限。この効果は同一の対象には6秒に一度しか発動しない。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 12, 2))
                .variable(2, MagicDamage, 75, 50)
                .active("スタックを1消費し、指定地点を偵察する霊魂を放つ。霊魂は攻撃能力を持たないが、スキルを使用した地点から指定した地点の間を巡回し、敵チャンピオンに接触した場合、4秒間対象の{3}。スタックの最大値は2、{4}ごとに1増加する。霊魂は7往復後に消滅。")
                .variable(3, Visionable)
                .variable(4, CDRAwareTime, 90, -10)
                .mana(25)
                .cd(30)
                .range(5000);

        E.update(P514)
                .passive("通常攻撃か" + P + "が命中すると対象に4秒間槍スタックが貯まる。(CD中を除く)。")
                .active("槍スタックが付与されている全ての敵のスタックを消費し、{1}と2秒間{2}を与える。槍スタックが2以上の場合、それぞれにつきダメージが50％上昇する。このスキルで敵ユニットを倒した場合、このスキルの{3}、倒した敵ユニット一体につき{4}する（上限40）。")
                .variable(1, PhysicalDamage, 20, 10, ad(0.6))
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, CDDecrease)
                .variable(4, RestoreMana, 20)
                .mana(40)
                .cd(14, -1.5);

        R.update(P514)
                .active("「魂盟の同志」を自分の元へ引き寄せる。引き寄せられた同士はその後4秒間敵からターゲットされなくなるが、その間は行動不能になる。 魂盟の同志はマウスでクリックした地点({3})に向かって跳躍する。このとき、最初に命中した敵のチャンピオンの位置で停止し、{1}の敵全員に{2}を与える。同士はその後、敵の射程距離の限界点に着地する。自身と魂盟の同志の間の距離が1400以内のときのみ発動できる。")
                .variable(1, Radius)
                .variable(2, Knockup, 1.5, 0.25)
                .variable(3, Radius, 1200)
                .mana(100)
                .cd(90, -15)
                .range(1400);
    }

    /**
     * Define skill.
     */
    public static void Karma(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("敵チャンピオンにスキルでダメージを与えた場合" + R + "の{1}し、通常攻撃でダメージを与えた場合は{2}する。")
                .variable(1, CDDecrease, new Per6Level(2, 0.5))
                .variable(2, CDDecrease, new Per6Level(1, 0.25));

        Q.update(P514)
                .active("指定方向に炎を飛ばし、命中した敵と{1}の敵ユニットに{2}と1.5秒間{3}を与える。" + R + "を付与した場合、追加の{4}を与え、更に炎が命中した地点にフィールドを発生させ、フィールドの上にいる敵ユニットに{5}を与える。フィールドは1.5秒後に爆発し、フィールドの上にいる敵ユニットに{6}を与える。炎が敵ユニットに命中しなかった場合、最大距離まで飛んだ後にフィールドが発生する。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 80, 45, ap(0.6))
                .variable(3, MSSlowRatio, 25)
                .variable(4, MagicDamage, new Refer(R, 25, 50), ap(0.3))
                .variable(5, MSSlowRatio, 50)
                .variable(6, MagicDamage, new Refer(R, 50, 100), ap(0.6))
                .mana(50, 5)
                .cd(7, -0.5)
                .range(950);

        W.update(P514)
                .active("対象の敵チャンピオンかモンスターと自身を繋ぐビームを発生させる。0.66秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。" + R + "を付与した場合、{3}する。2秒間ビームが持続していた場合、追加で{3}し、" + Snare + "の時間が{4}増加する。")
                .variable(1, MagicDamage, 20, 50 / 3, ap(0.3))
                .variable(2, Snare, 1, 0.25)
                .variable(3, RestoreHealth, amplify(MissingHealthRatio, 20, 0, ap(0.01)))
                .variable(4, Time, new Refer(R, 0.5, 0.25))
                .mana(65, 10)
                .cd(15, -1)
                .range(675);

        E.update(P514)
                .active("対象の味方は4秒間{1}を得て1.5秒間{2}する。" + R + "を付与した場合、対象の味方ユニットは追加の{5}を得て、{3}の味方ユニットには最初の対象に付与された" + Shield + "の半分の量の" + Shield + "が付与される。1.5秒間、シールドを付与されたチャンピオン全員の{4}する。")
                .variable(1, Shield, 80, 30, ap(0.5))
                .variable(2, MSRatio, 40, 5)
                .variable(3, Radius, 600)
                .variable(4, MSRatio, 60)
                .variable(5, Shield, new Refer(R, 30, 60), ap(0.3))
                .variable(7, MSRatio, 60)
                .mana(60, 5)
                .cd(10, -0.5)
                .range(800);

        R.update(P514).active("8秒以内に使用する次のスキルに" + R + "を付与する。").cd(45, -3);
    }

    /**
     * Define skill.
     */
    public static void Karthus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("死亡後7秒間スキルが使用可能。この状態ではスキルコストがなくなる。");

        Q.update(P514)
                .active("指定地点を0.5秒後に爆発させ{1}の敵ユニットに{2}を与える。対象が1体の場合は{3}を与える。また、指定地点の{4}。")
                .variable(1, Radius, 50)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 80, 40, ap(0.6))
                .variable(4, Visionable)
                .mana(20, 6)
                .cd(1)
                .range(875);

        W.update(P514)
                .active("指定地点に{3}の通りぬけ可能な壁を5秒間生成し、触れた敵ユニットに５秒間{1}と{2}を与える。スローの効果は5秒かけて元に戻る。また、指定地点の{4}。")
                .variable(1, MRReductionRatio, 15)
                .variable(2, MSSlowRatio, 40, 10)
                .variable(3, Length, 800, 100)
                .variable(4, Visionable)
                .mana(100)
                .cd(18)
                .range(1000);

        E.update(P514)
                .passive("敵ユニットを倒すと{1}する。")
                .variable(1, RestoreMana, 20, 7)
                .active("{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 425)
                .variable(3, MagicDamage, 30, 20, ap(0.2))
                .mana(30, 12)
                .cd(0.5)
                .type(SkillType.Toggle);

        R.update(P514)
                .active("3秒詠唱後にすべての敵チャンピオンに{1}を与える。")
                .variable(1, MagicDamage, 250, 150, ap(0.6))
                .mana(150, 25)
                .cd(200, -20)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Kassadin(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{1}を得て、{2}する。")
                .variable(1, IgnoreUnitCollision)
                .variable(2, MagicDamageReductionRatio, 15);

        Q.update(P514)
                .active("対象の敵ユニットに{1}を与え、詠唱及びチャネリングを解除する。1.5秒間{2}を得る。")
                .variable(1, MagicDamage, 70, 25, ap(0.7))
                .variable(2, MagicShield, 40, 30, ap(0.3))
                .mana(70, 5)
                .cd(9)
                .range(650);

        W.update(P514)
                .passive("通常攻撃に{1}を付与する。建物には無効。")
                .variable(1, MagicDamage, 20, 0, ap(0.1))
                .active("次の通常攻撃は射程が50伸び、{2}を与え{3}する。対象がチャンピオンの場合は回復量が5倍になる。建物には無効。")
                .variable(2, MagicDamage, 40, 25, ap(0.6))
                .variable(3, RestoreMana, 0, 0, amplify(MissingManaRatio, 4, 1))
                .cd(9);

        E.update(P514)
                .active("指定方向扇形80°の{1}の敵ユニットに{2}と1秒間{3}を与える。近くのチャンピオン(敵味方自分問わず)がスキルを使用するとスタックが増え、6スタックまで溜まると使用可能。スキル使用時にスタックは0になる。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 80, 25, ap(0.7))
                .variable(3, MSSlowRatio, 50, 10)
                .mana(80)
                .cd(6);

        R.update(P514)
                .active("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに追加で{3}を与え、マナコストが倍増する(最大4スタック)。スタックは15秒間増加がないと0になる。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 80, 20, amplify(Mana, 0.02), amplify(Stack, 50, 5, ap(0.1)))
                .variable(3, MagicDamage, 40, 10, amplify(Mana, 0.01))
                .mana(50)
                .cd(6, -2)
                .range(500);
    }

    /**
     * Define skill.
     */
    public static void Katarina(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive(Damage + "を与えてから3秒以内に敵チャンピオンが死亡すると、全てのスキルの{1}する。").variable(1, CDDecrease, 15);

        Q.update(P514)
                .active("対象の敵ユニットにナイフを飛ばし{1}と４秒間Debuffを与える。ナイフは近くの敵ユニット({2})に4回まで跳ね返り、その度にダメージとDebuffを与える。ナイフが与えるダメージは跳ね返る度に10%低下する。Debuffが付与された敵ユニットに通常攻撃またはスキルでダメージを与えると、付与されたDebuffを消費して{3}を与える。")
                .variable(1, MagicDamage, 60, 25, ap(0.45))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 15, 15, ap(0.15))
                .cd(10, -0.5)
                .range(675);

        W.update(P514)
                .active("{1}にいる敵ユニットに{2}を与える。このスキルが敵チャンピオンに命中した場合、1秒間{3}する。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 40, 35, ap(0.25), bounusAD(0.6))
                .variable(3, MSRatio, 15, 5)
                .cd(4);

        E.update(P514)
                .active("対象のユニットの後方までワープし、それが敵ユニットの場合は{1}を与える。また1.5秒間{2}する。")
                .variable(1, MagicDamage, 40, 30, ap(0.25))
                .variable(2, DamageReductionRatio, 15)
                .cd(12, -1.5)
                .range(700);

        R.update(P514)
                .active("最大2.5秒間回転する。その間は0.25秒毎に{2}にいる最も近い敵チャンピオン3体にナイフを連続で飛ばし、都度{1}と3秒間HP回復量-50%を与える。敵一体に与える最大DMは{3}。")
                .variable(1, MagicDamage, 35, 20, ap(0.25), bounusAD(0.375))
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 350, 200, ap(2.5), bounusAD(3.75))
                .cd(90, -30)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Kayle(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("敵チャンピオンに通常攻撃を行う度に、{1}と{2}を与える。この効果は5秒間持続し、5回までスタックする。")
                .variable(1, ARReductionRatio, 3)
                .variable(2, MRReductionRatio, 3);

        Q.update(P514)
                .active("{1}の光の弾を放ち、対象の敵ユニットに{2}、3秒間{3}と" + P + "のDebuffを与える。")
                .variable(1, MissileSpeed, 1500)
                .variable(2, MagicDamage, 60, 50, ap(0.6), bounusAD(1))
                .variable(3, MSSlowRatio, 35, 5)
                .mana(70, 5)
                .cd(8)
                .range(650);

        W.update(P514)
                .active("対象の味方チャンピオンは{1}し、3秒間{2}する。")
                .variable(1, RestoreHealth, 60, 45, ap(0.45))
                .variable(2, MSRatio, 18, 3, ap(0.07))
                .mana(60, 10)
                .cd(15)
                .range(900);

        E.update(P514)
                .passive("通常攻撃に{1}を付与する。")
                .variable(1, MagicDamage, 10, 5, ap(0.15))
                .active("10秒間{2}する。更に通常攻撃に{1}が付与され、{3}のスプラッシュ効果が付く。塔を攻撃する時はスプラッシュ効果は発生しない。")
                .variable(2, Range, 400)
                .variable(3, Radius, 150)
                .mana(45)
                .cd(16);

        R.update(P514).active("対象の味方チャンピオンを{1}間無敵(ダメージ無効)にする。").variable(1, Time, 2, 0.5).cd(90, -15).range(900);
    }

    /**
     * Define skill.
     */
    public static void Kennen(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは6秒間増加がないと0になる。同一の敵チャンピオンを7秒以内に2度スタンさせると、{3}を与える。")
                .variable(1, Stun, 1.25)
                .variable(2, RestoreEnergy, 25)
                .variable(3, Stun, 0.5);

        Q.update(P514)
                .active("指定方向に手裏剣を飛ばし、当たった敵ユニットに{1}と雷スタックを与える。")
                .variable(1, MagicDamage, 75, 40, ap(0.75))
                .cd(8, -1)
                .range(1050)
                .cost(Energy, 65, -5);

        W.update(P514)
                .passive("通常攻撃5回毎に{1}と雷スタックを与える。")
                .variable(1, MagicDamage, 0, 0, ad(0.4))
                .active("{3}の雷スタックの付与されている敵ユニットに{2}と雷スタックを与える。")
                .variable(3, Radius, 800)
                .variable(2, MagicDamage, 65, 30, ap(0.55))
                .cd(14, -2)
                .cost(Energy, 45, 0);

        E.update(P514)
                .active("2秒間{1}し{6}を得る。この間は通常攻撃が不可能になり、" + champion + "に触れた敵ユニットに{2}と雷スタックを与え、一度だけ{3}する。また、4秒間{4}と{5}を得る。ミニオンやモンスターに与えるダメージは半分になる。")
                .variable(1, MSRatio, 100)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .variable(3, RestoreEnergy, 40)
                .variable(4, AR, 10, 10)
                .variable(5, MR, 10, 10)
                .variable(6, IgnoreUnitCollision)
                .cd(10, -1)
                .cost(Energy, 100, -5);

        R.update(P514)
                .active("{1}に嵐を発生させ、{4}間0.25秒毎に範囲内にいる敵チャンピオン一人をランダムに雷を落とし{3}と雷スタックを与える。同一の対象には3回までヒットし、最大" + Damage + "は{5}。また、範囲内に複数の対象がいる場合、同一の対象に連続してはヒットしない。雷スタックはヒットする毎に蓄積する。")
                .variable(1, Radius, 550)
                .variable(3, MagicDamage, 80, 65, ap(0.4))
                .variable(4, Time, 3, 1)
                .variable(5, MagicDamage, 240, 195, ap(1.2))
                .cd(120);
    }

    /**
     * Define skill.
     */
    public static void Khazix(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive(champion + "が敵チームの視界から消えた時に発動する。敵チャンピオンに対する次の通常攻撃に{1}と2秒間{2}を付与する。この効果は敵チームの視界に現れても効果が消費されるまでは失われない。")
                .variable(1, MagicDamage, new Per1Level(15, 20, 25, 35, 45, 55, 65, 75, 85, 95, 110, 125, 140, 150, 160, 170, 180, 190), ap(0.5), null)
                .variable(2, MSSlowRatio, 25);

        Q.update(P514)
                .passive("{1}に仲間がいない孤立している敵ユニットにマークを付与する。")
                .variable(1, Radius, 425)
                .active("対象の敵ユニットに{2}を与える。孤立している敵には{3}を与える。<br>進化すると孤立した敵ユニットに追加で{4}を与え、このスキルの射程と通常攻撃の{5}する。")
                .variable(2, PhysicalDamage, 70, 25, bounusAD(1.2))
                .variable(3, PhysicalDamage, 91, 32.5, bounusAD(1.56))
                .variable(4, PhysicalDamage, 0, 0, bounusAD(1.04), level(10))
                .variable(5, Range, 50)
                .mana(25)
                .cd(3.5)
                .range(325);

        W.update(P514)
                .active("指定方向に敵ユニットに命中すると爆発する針を発射し、{1}の敵ユニットに{2}と2秒間{4}を与える。自身が爆発範囲内にいる場合は更に{3}する。モンスターに対しては{5}を与える。" + E + "中には発動出来ない。<br>進化すると指定方向に対して扇形になるような3方向に針を発射するようになり、2秒間{6}を与え{7}。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 80, 30, bounusAD(1))
                .variable(3, RestoreHealth, 60, 25, ap(0.5))
                .variable(4, MSSlowRatio, 20)
                .variable(5, PhysicalDamage, 96, 36, bounusAD(1.2))
                .variable(6, MSSlowRatio, 50)
                .variable(7, Visionable)
                .cd(10)
                .mana(55, 5)
                .range(1000);

        E.update(P514)
                .active("指定地点にジャンプし、{1}の敵ユニットに{2}を与える。<br>進化すると射程が300増加し、{3}場合にこのスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 65, 35, bounusAD(0.2))
                .variable(3, Takedown)
                .variable(4, CDDecrease)
                .mana(50)
                .cd(20, -2)
                .range(600);

        R.update(P514)
                .passive("このスキルを取得、またはランクが上がる毎に、いずれかのスキルを選んで進化させることができる。")
                .active("1秒間{1}状態になり、{2}し{3}を得る。また" + P + "の効果が発動する。15秒以内であれば1回だけ再使用できる。<br>進化すると、効果時間が2秒になり、再使用回数が2回になる。")
                .variable(1, Stealth)
                .variable(2, MSRatio, 40)
                .variable(3, IgnoreUnitCollision)
                .variable(4, DamageReductionRatio, 30)
                .mana(100)
                .cd(100, -10);
    }

    /**
     * Define skill.
     */
    public static void KogMaw(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("死亡すると4秒後に自爆して{2}の敵ユニットに{1}を与える。自爆するまでの間は徐々に移動速度が増加する(最大時40%増加)。")
                .variable(1, TrueDamage, 100, 0, level(25))
                .variable(2, Radius);

        Q.update(P514)
                .passive("{1}する。")
                .variable(1, ASRatio, 10, 5)
                .active("対象の敵ユニットに{2}を与え、4秒間{3}と{4}を与える。")
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .variable(3, ARReductionRatio, 12, 4)
                .variable(4, MRReductionRatio, 12, 4)
                .mana(60)
                .cd(8)
                .range(1000);

        W.update(P514)
                .active("8秒間通常攻撃の{1}し、通常攻撃時に{2}を追加で与える。")
                .variable(1, Range, 130, 20)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 2, 1, ap(0.01)))
                .mana(50)
                .cd(17);

        E.update(P514)
                .active("指定方向に貫通する弾を発射し、当たった敵ユニットに{1}と1秒間{2}を与える。弾の通過点に4秒間持続する液体が残り、その上にいる敵ユニットに{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, MSSlowRatio, 20, 8)
                .mana(80, 10)
                .cd(12)
                .range(1280);

        R.update(P514)
                .active("指定地点を砲撃し、0.6秒後に{1}の敵ユニットに{2}を与える。敵チャンピオンには{3}を与える。4秒間そのユニットの{4}。このスキルを使うたびにスタックが増加し、1スタックにつきこのスキルの消費マナが40ずつ増加していく。スタックは6秒間持続し最大10。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 80, 40, ap(0.3), bounusAD(0.5))
                .variable(3, MagicDamage, 160, 80, ap(0.3), bounusAD(0.5))
                .variable(4, Visionable)
                .cost(Mana, new Diff(40, 0, 1), amplify(Stack, 40))
                .cd(2, -0.5)
                .range(1400, 300);
    }

    /**
     * Define skill.
     */
    public static void Leblanc(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("HPが40%以下になったとき{2}状態になり、自分の分身を作り出す。分身は8秒間持続し、分身が敵にダメージを与えることはできない。{1}。")
                .variable(1, CDRUnaware)
                .variable(2, Stealth, 1)
                .cd(-60);

        Q.update(P514)
                .active("対象の敵ユニットに{1}と3.5秒間持続するマークを付与する。マークが付いている間に再度スキルでダメージを与えると、マークを消費して{1}を与える。")
                .variable(1, MagicDamage, 55, 25, ap(0.4))
                .mana(50, 10)
                .cd(6)
                .range(700);

        W.update(P514)
                .active("指定地点まで高速で移動し、移動先の{1}にいる敵ユニットに{2}を与える。3秒間以内にもう一度このスキルを使用すると元居た地点に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .mana(80, 5)
                .cd(18, -2)
                .range(600);

        E.update(P514)
                .active("指定方向に鎖を放ち、当たった敵ユニットに{1}を与え対象と鎖で繋がれ、その間{2}を与える。1.5秒間対象が鎖の範囲内(範囲1000)に留まっていた場合、対象に{1}と{3}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.5))
                .variable(2, MSSlowRatio, 25)
                .variable(3, Snare, 1.5)
                .mana(80)
                .cd(14, -1.5)
                .range(950);

        R.update(P514)
                .active("直前に使ったスキルをコピーする。(ダメージ値が下記のように変化する)<br>" + Q + ": {1}<br>" + W + ": {2}<br>" + E + ": {3}")
                .variable(1, MagicDamage, 100, 100, ap(0.6))
                .variable(2, MagicDamage, 150, 150, ap(0.9))
                .variable(3, MagicDamage, 100, 100, ap(0.6))
                .cd(40, -8);
    }

    /**
     * Define skill.
     */
    public static void LeeSin(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルを使用すると{1}し通常攻撃の度に{2}する。この効果は3秒経つか2回通常攻撃を行うと解消される。")
                .variable(-1, ASRatio, 40)
                .variable(2, RestoreEnergy, 15);

        Q.update(P514)
                .active("指定方向に気を飛ばし当たった敵ユニットに{1}を与える。このスキルが敵ユニットに当たった場合、3秒間対象の{5}、下記のスキルを使用できる。<br><br>{2}を消費して、" + Q + "が当たった{3}の敵ユニットにダッシュし、{4}を与える。(追加ダメージはミニオンやモンスターに対して400ダメージが上限)")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.9))
                .variable(2, Energy, 30)
                .variable(3, Radius, 1300)
                .variable(4, PhysicalDamage, 50, 30, bounusAD(0.9), amplify(Status.TargetMissingHealthRatio, 8))
                .variable(5, Visionable)
                .cd(11, -1)
                .range(1100)
                .cost(Energy, 50, 0);

        W.update(P514)
                .active("対象の味方ユニットまで移動する。自身及び対象（味方チャンピオンに限る）は５秒間{1}を得る。このスキル使用後3秒間、下記のスキルが使用できる。<br><br>{2}を消費して、5秒間{3}と{4}を得る。")
                .variable(1, Shield, 40, 40, ap(0.8))
                .variable(2, Energy, 30)
                .variable(3, LS, 5, 5)
                .variable(4, SV, 5, 5)
                .cd(14)
                .cost(Energy, 50, 0)
                .range(700);

        E.update(P514)
                .active("{1}の敵ユニットに{2}を与え、4秒間そのユニットの{3}。このスキルが敵ユニットに当たった場合、3秒間下記のスキルが使用できる。<br><br>{4}を消費して、" + E + "が当たった{5}の敵ユニットに４秒間かけて減衰する{6}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 60, 35, bounusAD(1))
                .variable(3, Visionable)
                .variable(4, Energy, 30)
                .variable(5, Radius, 500)
                .variable(6, MSSlowRatio, 20, 10)
                .cd(10)
                .cost(Energy, 50, 0);

        R.update(P514)
                .active("対象の敵チャンピオンに{1}を与え、{2}させる。ノックバックした対象に触れた敵ユニットにも{1}を与え、{3}を与える。")
                .variable(1, PhysicalDamage, 200, 200, bounusAD(2))
                .variable(2, Knockback, 1200)
                .variable(3, Knockup, 0)
                .cd(90, -15)
                .range(375);
    }

    /**
     * Define skill.
     */
    public static void Leona(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルでダメージを与えた敵ユニットに、3.5秒間持続するDebuffを付与する。この敵ユニットに対して" + champion + "以外の味方チャンピオンがダメージを与えると、付与されたDebuffを消費して{1}を与える。")
                .variable(1, MagicDamage, new Per2Level(20, 15));

        Q.update(P514)
                .active("次の通常攻撃に{1}と{2}を付与する。")
                .variable(1, MagicDamage, 40, 30, ap(0.3))
                .variable(2, Stun, 1.25)
                .mana(45, 5)
                .cd(11, -1);

        W.update(P514)
                .active("3秒間{1}と{2}を得て、効果終了時に{3}の敵ユニットに{4}を与える。" + MagicDamage + "が敵ユニットに命中した場合、効果時間が3秒延長される。")
                .variable(1, AR, 20, 10, amplify(BounusAR, 0.2))
                .variable(2, MR, 30, 10, amplify(BounusMR, 0.2))
                .variable(3, Radius, 275)
                .variable(4, MagicDamage, 60, 50, ap(0.4))
                .mana(60)
                .cd(14);

        E.update(P514)
                .active("指定方向に貫通するエネルギーを飛ばし当たった敵ユニットに{1}を与える。このスキルが敵チャンピオンに命中した場合、その敵チャンピオンの元まで移動する。また移動中は対象の敵チャンピオンに" + Snare + "を与える。複数の敵チャンピオンに命中した場合は最後に命中した敵チャンピオンの元に移動する。")
                .variable(1, MagicDamage, 60, 40, ap(0.4))
                .mana(60)
                .cd(13, -1)
                .range(875);

        R.update(P514)
                .active("0.625秒後、指定地点を中心として{1}の敵ユニットに{2}と1.5秒間{3}を、{5}の敵ユニットに{4}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, MSSlowRatio, 80)
                .variable(5, Radius, 100)
                .variable(4, Stun, 1.5)
                .mana(100)
                .cd(90, -15)
                .range(1200);
    }

    /**
     * Define skill.
     */
    public static void Lissandra(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("次に使うスキルのコストが0になる。" + E + "以外のスキルを敵ユニットに命中させるたびに、このスキルの{1}。")
                .variable(1, CDDecrease, 1)
                .cd(-18);

        Q.update(P514)
                .active("指定方向に敵に当たると砕ける氷の槍を飛ばし、当たった敵ユニットに{1}と1.5秒間{2}を与える。槍の破片は貫通し、後方{3}の敵に{1}を与える。")
                .variable(1, MagicDamage, 70, 30, ap(0.65))
                .variable(2, MSSlowRatio, 16, 3)
                .variable(3, Radius, 100)
                .mana(85)
                .cd(6, -0.75)
                .range(725);

        W.update(P514)
                .active("{1}にいる全ての敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 70, 40, ap(0.4))
                .variable(3, Snare, 1.1, 0.1)
                .mana(50)
                .cd(14, -1);

        E.update(P514)
                .active("指定方向に貫通する氷の爪を飛ばし、当たった敵ユニットに{1}を与える。氷の爪が出ている間にこのスキルを再度使用すると、氷の爪の位置までワープし氷の爪が消滅する。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .mana(80, 5)
                .cd(24, -3)
                .range(1050);

        R.update(P514)
                .active("対象の敵チャンピオンに{1}と{2}を与え、同時に対象の周囲に3秒間持続するDark Iceを呼び出し、Dark Iceに触れた敵ユニットに{1}と{3}を与える。このスキルは自身を対象とする事が可能で、自身を対象とした場合は{4}間行動出来なくなる代わりに、ダメージを無効化かつターゲット不可状態になり、自身の周囲からDark Iceが出現する。")
                .variable(1, MagicDamage, 150, 100, ap(0.7))
                .variable(2, Stun, 1.5)
                .variable(3, MSSlowRatio, 30, 15)
                .variable(4, Time, 2.5)
                .mana(100)
                .cd(130, -25)
                .range(550);
    }

    /**
     * Define skill.
     */
    public static void Lucian(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルを使用した次の通常攻撃が2回攻撃になる。この効果は通常攻撃を行うか、3秒経過すると解消される。2回目の攻撃は{1}を与えるが、対象がミニオンかモンスターの場合は2倍になる。2回攻撃の1発目で対象が死亡した場合、2発目は近くのユニットを攻撃する。")
                .variable(1, PhysicalDamage, amplify(AD, new Per6Level(30, 10)));

        Q.update(P514)
                .active("対象の敵ユニットに向けて0.35秒後に光のボルトを放ち、対象とその直線状({1})にいるすべての敵ユニットに{2}を与える。")
                .variable(1, Length, 1100)
                .variable(2, PhysicalDamage, 80, 30, amplify(BounusAD, 0.6, 0.15))
                .mana(50, 5)
                .cd(9, -1)
                .range(550);

        W.update(P514)
                .active("指定方向に爆発する弾を放つ。敵ユニットに当たるか最大距離まで飛ぶと十字型に爆風が広がり、範囲内の敵ユニットに{1}と6秒間マークを与える。マークを受けている敵ユニットにダメージを与えると、2秒間{2}する。また爆風が発生した地点の{3}。")
                .variable(1, MagicDamage, 60, 40, ap(0.9))
                .variable(2, MS, 40, 5)
                .variable(3, Visionable)
                .mana(60)
                .cd(14, -1)
                .range(1000);

        E.update(P514)
                .active("指定方向にダッシュする。" + P + "による通常攻撃がヒットする度に、このスキルの{2}し、対象が敵チャンピオンの場合は{3}。{4}。")
                .variable(1, CDDecrease)
                .variable(2, CDDecrease, 1)
                .variable(3, CDDecrease, 2)
                .variable(4, ResetAATimer)
                .mana(40, -10)
                .cd(18, -1)
                .range(425);

        R.update(P514)
                .active("一定方向に3秒間高速連射する。連射中は自由に移動可能。弾は敵を貫通せず、1発あたり{1}を与える。発砲する弾数は{2}。銃を連射している間は移動と" + E + "のみが可能。また連射中にこのスキルを再使用することで連射を解除できる。ミニオンに対しては400%のダメージを与える。")
                .variable(1, PhysicalDamage, 40, 10, ap(0.1), bounusAD(0.25))
                .variable(2, Value, 7.5, 0, amplify(AS, 7.5, 1.5))
                .variable(3, PhysicalDamage, 1040, 460, amplify(AP, 2.6, 0.4), amplify(BounusAD, 6.5, 1.0))
                .mana(100)
                .cd(110, -10)
                .range(1400);
    }

    /**
     * Define skill.
     */
    public static void Lulu(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("Pixという妖精がお供になる。Pixが付いている味方チャンピオンが通常攻撃を行った場合、Pixは同一の敵ユニットの方向に3発の弾を放ち1発毎に{1}を与える。この弾は敵ユニットを追尾するが、弾の進行方向上にいる敵ユニットにも当たる。建物を攻撃した場合はPixは弾を撃たない。")
                .variable(1, MagicDamage, new Per2Level(3, 4), ap(0.05), null);

        Q.update(P514)
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間かけて減衰する{3}を与える。Pixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .variable(1, MagicDamage, 80, 45, ap(0.5))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 80)
                .mana(60, 5)
                .cd(7)
                .range(925);

        W.update(P514)
                .active("味方チャンピオンに使用した場合、対象の味方チャンピオンは{1}間{2}を得る。敵チャンピオンに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、{4}する。")
                .variable(1, Time, 3, 0.5)
                .variable(2, MSRatio, 30, 0, ap(0.1))
                .variable(3, Time, 1.25, 0.25)
                .variable(4, MSReduction, 60)
                .mana(65)
                .cd(18, -1.5)
                .range(650);

        E.update(P514)
                .active("味方ユニットに使用した場合、6秒間対象の味方ユニットにPixを付けると同時に{1}を付与する。敵ユニットに使用した場合、Pixが敵ユニットに付くと同時に{2}を与え、4秒間その敵ユニットの{3}。")
                .variable(1, Shield, 80, 40, ap(0.6))
                .variable(2, MagicDamage, 80, 30, ap(0.4))
                .variable(3, Visionable)
                .mana(60, 10)
                .cd(10)
                .range(650);

        R.update(P514)
                .active("対象の味方チャンピオンを7秒間巨大化させ、同時に対象の{3}の敵ユニットに{1}を与える。巨大化した味方チャンピオンは{2}を得て、{3}の敵ユニットに継続的に{4}を与える。スローの効果は範囲内から出ても1秒間持続する。")
                .variable(1, Knockup, 1.5)
                .variable(2, Health, 300, 150, ap(0.5))
                .variable(3, Radius, 150)
                .variable(4, MSSlowRatio, 30, 15)
                .mana(100)
                .cd(110, -15)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void Lux(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルでダメージを与えた敵ユニットに6秒間持続するDebuffを付与する。この敵ユニットに対して通常攻撃か" + R + "でダメージを与えると、付与されたDebuffを消費して{1}を与える。")
                .variable(1, MagicDamage, 10, 0, level(8), ap(0.2));

        Q.update(P514)
                .active("指定方向に光の玉を飛ばし、当たった敵ユニットに{1}と{2}を与える。光の玉は一度だけ敵ユニットを貫通し、2体目のユニットには{3}と{4}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, Snare, 2)
                .variable(3, MagicDamage, 30, 25, ap(0.35))
                .variable(4, Snare, 1)
                .mana(50, 10)
                .cd(15, -1)
                .range(1175);

        W.update(P514)
                .active("指定方向に杖を投げ、自身と当たった味方チャンピオンに{1}を付与する。行きと帰りそれぞれに判定があり、シールドは3秒間持続する。このシールドはスタックしない。")
                .variable(1, Shield, 80, 25, ap(0.35))
                .mana(60)
                .cd(14, -1)
                .range(1075);

        E.update(P514)
                .active("指定地点に光の玉を設置し、{1}の敵ユニットに{2}を与える。光の玉は5秒経つか再度スキルを使用する事で爆発し、{1}の敵ユニットに{3}を与える。光の玉は{4}。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 20, 4)
                .variable(3, MagicDamage, 60, 45, ap(0.6))
                .variable(4, Visionable)
                .mana(70, 15)
                .cd(10)
                .range(1100);

        R.update(P514)
                .active("0.5秒詠唱後、指定方向の直線状にいるすべての敵ユニットに{1}を与える。また効果範囲内の{2}。")
                .variable(1, MagicDamage, 300, 100, ap(0.75))
                .variable(2, Visionable)
                .mana(100)
                .cd(80, -15)
                .range(3340);
    }

    /**
     * Define skill.
     */
    public static void Malphite(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{2}間ダメージを受けないと{1}を得る。")
                .variable(1, Shield, amplify(Health, 0.1))
                .variable(2, Time, new Per6Level(10, -2));

        Q.update(P514)
                .active("対象の敵ユニットに{1}と4秒間{2}を与える。また、このスキルで減少させた移動速度を自身の移動速度に加算する。")
                .variable(1, MagicDamage, 70, 50, ap(0.6))
                .variable(2, MSSlowRatio, 14, 3)
                .mana(70, 5)
                .cd(8)
                .range(625);

        W.update(P514)
                .passive("{1}する。")
                .variable(1, ARRatio, 10, 5)
                .variable(2, PhysicalDamage, amplify(AD, 0.3, 0.08))
                .active("6秒間、通常攻撃時に対象と{2}のユニットに対して、{3}を与える。")
                .variable(2, Radius, 225)
                .variable(3, PhysicalDamage, 15, 15, ap(0.1), amplify(AR, 0.1))
                .mana(25)
                .cd(14);

        E.update(P514)
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 40, ap(0.2), amplify(AR, 0.3))
                .variable(3, ASSlowRatio, 30, 5)
                .mana(50, 5)
                .cd(7);

        R.update(P514)
                .active("指定地点に突撃し{1}の敵ユニットに{2}と3}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 200, 100, ap(1))
                .variable(3, Knockup, 1.5)
                .mana(100)
                .cd(130, -15)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Malzahar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルを4回使う度にVoidlingを召喚する。Voidlingは21秒間持続し、7秒後にADとARが1.5倍、14秒後にASが2倍に増加する。任意の操作不可。攻撃対象は、" + R + "を掛けた相手、" + E + "を掛けた相手、" + champion + "がターゲットしている相手の順。<br>Health: {1}<br>AD: {2}<br>AR: 30<br>MR: 50<br>AS: 0.831<br>MS: 451")
                .variable(1, Value, 200, 0, level(50))
                .variable(2, Value, 20, 0, level(5), bounusAD(1));

        Q.update(P514)
                .active("指定した地点の左右から挟み込む様に2本の波動が出現し、当たった敵ユニットに{1}と{2}を与える。また、指定した場所の{3}。")
                .variable(1, MagicDamage, 80, 55, ap(0.8))
                .variable(2, Silence, 1.4, 0.4)
                .variable(3, Visionable)
                .mana(80, 5)
                .cd(9)
                .range(900);

        W.update(P514)
                .active("指定地点に5秒間持続する{1}のダメージゾーンを発生させ、上にいる敵ユニットに毎秒{2}を与える。(ミニオンやモンスターに対しては毎秒120ダメージが上限)")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 4, 1, ap(0.01)))
                .mana(90, 5)
                .cd(14)
                .range(800);

        E.update(P514)
                .active("対象の敵ユニットに4秒間0.5秒毎に{1}を与える（合計{2}）。効果中に敵ユニットが死亡した場合、{3}し、近くの敵ユニットに効果が移り変わる。移る度に4秒のタイマーはリセットされる。")
                .variable(1, MagicDamage, 10, 7.5, ap(0.1))
                .variable(2, MagicDamage, 80, 60, ap(0.8))
                .variable(3, RestoreMana, 10, 4)
                .mana(60, 15)
                .cd(15, -2)
                .range(650);

        R.update(P514)
                .active("対象の敵チャンピオンに2.5秒間0.5秒毎に{1}を与え（合計{2}）、{3}を与える。")
                .variable(1, MagicDamage, 50, 30, ap(0.26))
                .variable(2, MagicDamage, 250, 150, ap(1.3))
                .variable(3, Suppression, 2.5)
                .mana(100)
                .cd(120, -20)
                .range(700)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Maokai(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("近くのチャンピオン(敵味方自分問わず)がスキルを使用するとスタックが増え、5スタックまで溜まった状態で通常攻撃を行うとスタックを消費して{1}する。建物を攻撃した場合は発動しない。")
                .variable(1, RestoreHealth, amplify(Health, new Per6Level(0.05, 0.01)));

        Q.update(P514)
                .active("{1}の敵ユニットと指定方向の敵ユニットに{2}と1.5秒間{3}を与える。{4}の敵ユニットには更に{5}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, MSSlowRatio, 20, 7)
                .variable(4, Radius, 100)
                .variable(5, Knockback)
                .mana(45)
                .cd(6)
                .range(600);

        W.update(P514)
                .active("対象の敵ユニットまで高速移動し{1}と{2}を与える（ミニオンやモンスターに対しては300ダメージが上限）。移動中はターゲット不可状態になる。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 9, 1, ap(0.03)))
                .variable(2, Snare, 1, 0.25)
                .mana(75)
                .cd(13, -1)
                .range(525);

        E.update(P514)
                .active("指定地点に苗木を投げ、{1}の敵ユニットに{2}を与える。苗木は最大35秒間その場で待機し、敵ユニットが近付く({4})と相手に向かって移動を開始する、敵に接触するか数秒経つと爆発して{1}に{3}と1秒間{5}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 40, 20, ap(0.4))
                .variable(3, MagicDamage, 80, 40, ap(0.6))
                .variable(4, Radius, 350)
                .variable(5, MSSlowRatio, 50)
                .mana(60, 10)
                .cd(12)
                .range(1100);

        R.update(P514)
                .passive("指定地点の{1}にシールドを展開し、範囲内の味方チャンピオンは{2}を得る(タワーからの攻撃以外)。10秒経過するか再度スキルを使用すると解除され、範囲内の敵ユニットに{3}を与える（増加ダメージは{4}が上限）。")
                .variable(1, Radius)
                .variable(2, DamageReductionRatio, 20)
                .variable(3, MagicDamage, 100, 50, ap(0.5), amplify(ReceivedDamageRatio, 0.1))
                .variable(4, Value, 100, 50)
                .cost(Mana, new Fixed(40), amplify(Duration, 30))
                .cd(40, -10)
                .range(475);
    }

    /**
     * Define skill.
     */
    public static void MasterYi(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃4回毎に2回連続で攻撃を行い{1}を与える。対象が建物の場合も有効。通常攻撃を4秒間しなかった場合、カウントがリセットされる。")
                .variable(1, PhysicalDamage, ad(0.5));

        Q.update(P514)
                .active("ターゲット不可状態になり対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え(クリティカル発生時は{5})、対象の近くにワープする。ミニオンやモンスターには{3}を追加で与える。通常攻撃をする毎に{4}する。")
                .variable(1, Radius, 600)
                .variable(2, PhysicalDamage, 25, 35, ad(1))
                .variable(3, PhysicalDamage, 75, 25)
                .variable(4, CDDecrease, 1)
                .variable(5, PhysicalDamage, 25, 35, ad(1.6))
                .mana(70, 10)
                .cd(18, -1)
                .range(600);

        W.update(P514)
                .active("4秒間詠唱し、毎秒{1}する。この効果は自分の体力欠損分1％ごとに1％増加する。詠唱中は{2}する（タワーに対しては効果半減）。")
                .variable(1, RestoreHealth, 30, 20, ap(0.3))
                .variable(2, DamageReductionRatio, 50, 5)
                .cd(35)
                .mana(50)
                .type(SkillType.Channel);

        E.update(P514)
                .passive("{1}を得る。CD中この効果は失われる。")
                .variable(1, AD, ad(0.1))
                .active("5秒間通常攻撃に{2}が追加される。建物に対しては無効。")
                .variable(2, TrueDamage, 10, 5, amplify(AD, 0.1, 0.025))
                .cd(18, -1);

        R.update(P514)
                .passive("チャンピオンを{1}と" + R + "以外のスキルは{2}する。")
                .variable(1, Takedown)
                .variable(2, CDDecreaseRatio, 70)
                .active("10秒間{3}、{4}し、{5}を得る。効果中にチャンピオンを{1}と効果時間が4秒延長する。")
                .variable(3, MSRatio, 25, 10)
                .variable(4, ASRatio, 30, 25)
                .variable(5, IgnoreSlow)
                .mana(100)
                .cd(75);
    }

    /**
     * Define skill.
     */
    public static void MissFortune(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("5秒間ダメージを受けないと{1}する。以後徐々に増加して8秒後に{2}する。ダメージを受けると解除される。")
                .variable(-1, MS, 25)
                .variable(-2, MS, 70);

        Q.update(P514)
                .active("敵1体を貫通する弾丸を発射し、1体目の敵に{1}を与え、後方（{2}）にいる2体目の敵に{3}を与える。{4}。一体目の敵を倒し場合、2体目の敵に与えるダメージは{5}になる。")
                .variable(1, PhysicalDamage, 20, 15, ad(0.85), ap(0.35))
                .variable(2, Radius, 500)
                .variable(3, PhysicalDamage, 40, 30, ad(1), ap(0.5))
                .variable(4, OnHitEffect)
                .variable(5, PhysicalDamage, 60, 45, ad(1.5), ap(0.75))
                .mana(43, 3)
                .cd(7, -1)
                .range(650);

        W.update(P514)
                .passive("通常攻撃に{1}を付与する。5秒以内の攻撃は{2}回まで累積し最大{3}を与える。")
                .variable(1, MagicDamage, 0, 0, ad(0.06))
                .variable(2, Value, new ReferPlus(R, 5, 1))
                .variable(3, MagicDamage, amplify(AD, new ReferPlus(R, 0.3, 0.06)))
                .active("6秒間{4}する。また即座に" + P + "の効果が発動する。")
                .variable(4, ASRatio, 20, 10)
                .mana(30, 5)
                .cd(12);

        E.update(P514)
                .active("0.5秒後、指定地点に2秒間0.25秒毎に銃弾の雨を降らし、{1}の敵ユニットに{2}と1秒間{3}を与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 90, 55, ap(0.8))
                .variable(3, MSSlowRatio, 40, 5)
                .mana(80)
                .cd(14, -1)
                .range(800);

        R.update(P514)
                .active("指定方向扇形の範囲に2秒間、弾幕砲火を浴びせて0.25秒毎に範囲内の敵ユニットに{1}と" + W + "のパッシブ効果を与える。同一の対象に8回までヒットし最大で{2}。")
                .variable(1, PhysicalDamage, 50, 25, ap(0.2))
                .variable(2, PhysicalDamage, 400, 200, ap(1.6))
                .mana(100)
                .cd(120, -10)
                .range(1400)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Mordekaiser(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキルで与えたダメージの17.5%(チャンピオンに対しては35%)をシールドに変換する(最大で{1})。1秒毎に3%ずつ低下していく。")
                .variable(1, Shield, 90, 0, level(30));

        Q.update(P514)
                .active("次の通常攻撃は{1}し対象とその{2}の敵3体に{3}を与える。対象が1体だけの場合は{4}与える。")
                .variable(1, Range, 75)
                .variable(2, Radius, 600)
                .variable(3, MagicDamage, 80, 30, ap(0.4), bounusAD(1))
                .variable(4, MagicDamage, 132, 49.5, ap(0.66), bounusAD(1.65))
                .cd(8, -1)
                .cost(Health, 20, 5);

        W.update(P514)
                .active("対象の味方ユニットに6秒間持続するシールドを付与する。自身へ使用した場合、最も近くに居る味方チャンピオンにもその効果を与える。付与されたユニットは{1}と{2}を得て、{3}の敵ユニットに毎秒{4}を与える。また、付与されたユニット同士が近づくと{5}する。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 20, 12, ap(0.15))
                .variable(5, MS, 60)
                .cd(20, -2)
                .range(750)
                .cost(Health, 20, 5);

        E.update(P514)
                .active("指定方向扇形の{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .variable(2, Radius)
                .cd(6)
                .range(700)
                .cost(Health, 24, 12);

        R.update(P514)
                .active("対象の敵チャンピオンに{1}を与え、その後10秒間、毎秒{2}を与える。10秒間で総計{4}を与え、{3}する。効果中に対象が死ぬとThe Spiritを生成し30秒間従わせる。(RまたはALT押しながらクリックで任意の操作可能)<br>The Spirit<br>AD: 元になったChampのAD + MordekaiserのADの75%<br>AP: 元になったChampのAP + MordekaiserのAPの75%<br>HP: 元になったChampのHP + MordekaiserのHPの15%<br>行動範囲: 1125<br>また、The Spiritを従えている間、Mordekaiserは元になったChampのADとAPの20％を得る。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 12, 2.5, ap(0.01)))
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 1.2, 0.25, ap(0.002)))
                .variable(3, RestoreHealth, amplify(DealtDamageRatio, 100))
                .variable(4, MagicDamage, amplify(TargetMaxHealthRatio, 24, 5, ap(0.03)))
                .cd(120, -15)
                .range(850);
    }

    /**
     * Define skill.
     */
    public static void Morgana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("{1}を得る。").variable(1, SV, new Per6Level(10, 5));

        Q.update(P514)
                .active("指定方向に魔法弾を飛ばし、当たった敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 55, ap(0.9))
                .variable(2, Snare, 2, 0.25)
                .mana(50, 10)
                .cd(11)
                .range(1175);

        W.update(P514)
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに0.5秒毎に{1}を与える（最大で{2}）。対象が失っているHP1%につき、このスキルのダメージが0.5%上昇する(最大で1.5倍)。")
                .variable(1, MagicDamage, 8, 8, ap(0.11))
                .variable(2, MagicDamage, 80, 80, ap(1.1))
                .variable(3, Radius, 175)
                .mana(70, 15)
                .cd(10)
                .range(900);

        E.update(P514)
                .active("対象の味方チャンピオンは5秒間{1}と{2}を得る。")
                .variable(1, MagicShield, 70, 70, ap(0.7))
                .variable(2, IgnoreCC)
                .mana(55)
                .cd(23, -2)
                .range(750);

        R.update(P514)
                .active("{1}の敵チャンピオンに{2}と３秒間{3}を与え対象と繋がれる。繋がれた対象が3秒間{4}に留まっていた場合、{1}と{5}を与える。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 175, 75, ap(0.7))
                .variable(3, MSSlowRatio, 20)
                .variable(4, Radius, 1050)
                .variable(5, Stun, 1.5)
                .mana(100)
                .cd(120, -10)
                .range(600);
    }

    /**
     * Define skill.
     */
    public static void Nami(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("スキルが味方チャンピオンに命中した際に、対象は1.5秒間{1}する。").variable(-1, MS, 40, 0, ap(0.1));

        Q.update(P514)
                .active("指定地点に泡を投げ、範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 55, ap(0.5))
                .variable(2, Stun, 1.5)
                .mana(60)
                .cd(14, -1)
                .range(875);

        W.update(P514)
                .active("味方チャンピオンと敵チャンピオンの間で交互に跳ね返る水流を発射する。<br>味方命中時: {1}し、{2}の敵のチャンピオンに跳ね返る。<br>敵命中時: {3}を与え、{2}の味方のチャンピオンに跳ね返る。<br>同じターゲットに2回以上命中することはなく、最大3体に命中。1度跳ね返るごとに、効果量に{4} の補正がかかる。")
                .variable(1, RestoreHealth, 65, 30, ap(0.3))
                .variable(2, Radius, 875)
                .variable(3, MagicDamage, 70, 40, ap(0.5))
                .variable(4, Percentage, -15, 0, ap(0.075))
                .mana(70, 15)
                .cd(10)
                .range(725);

        E.update(P514)
                .active("対象の味方のチャンピオンは6秒間 (または通常攻撃3回分) 通常攻撃に{1}が付与され、ターゲットを1秒間{2}にする。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MSSlowRatio, 15, 5, ap(0.05))
                .mana(55, 5)
                .cd(11)
                .range(800);

        R.update(P514)
                .active("指定方向に津波を発生させ、命中した敵ユニットに{1}と{2}を与えた後2～4秒間{3}与える。スローの効果時間は当たるまでの津波の移動距離に比例する。")
                .variable(1, Knockup, 1)
                .variable(2, MagicDamage, 150, 100, ap(0.6))
                .variable(3, MSSlowRatio, 50, 10)
                .mana(100)
                .cd(120, -10)
                .range(2750);
    }

    /**
     * Define skill.
     */
    public static void Nasus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("{1}を得る。").variable(1, LS, new Per6Level(10, 5));

        Q.update(P514)
                .active("次に行う通常攻撃に{1}を付与する。このスキルを使用しLHをとると増加ダメージが+3されていく。対象が敵チャンピオン/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は+6になる。")
                .variable(1, PhysicalDamage, 30, 20, amplify(Stack, 3))
                .mana(20)
                .cd(8, -1);

        W.update(P514)
                .active("対象の敵チャンピオンに5秒間{1}と{2}を与える。")
                .variable(1, ASSlowRatio, 17.5, 0, amplify(Duration, 1.5, 1.5))
                .variable(2, MSSlowRatio, 35, 0, amplify(Duration, 3, 3))
                .mana(80)
                .cd(15, -1)
                .range(600);

        E.update(P514)
                .active("指定地点に魔法陣を呼び出し{1}の敵ユニットに{2}を与える。魔方陣は5秒間持続し、上にいる敵ユニットに{3}と毎秒{4}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 55, 40, ap(0.6))
                .variable(3, ARReduction, 20, 5)
                .variable(4, MagicDamage, 11, 8, ap(0.12))
                .mana(70, 15)
                .cd(12)
                .range(650);

        R.update(P514)
                .active("15秒間{1}を得て{3}し、自身の周りに砂嵐を発生させ{5}の敵ユニットに毎秒{2}を与える。このスキルで与えたダメージの6.375%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。")
                .variable(1, Health, 300, 150)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 3, 1, ap(0.01)))
                .variable(3, Range, 50)
                .variable(5, Radius, 350)
                .mana(100)
                .cd(120);
    }

    /**
     * Define skill.
     */
    public static void Nautilus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃に{1}と{2}が付与される。同一の対象には{3}に一度しか発動しない。")
                .variable(1, PhysicalDamage, 2, 0, level(6))
                .variable(2, Snare, new Per5LevelWith18(0.5, 0.25))
                .variable(3, Time, new Per5Level(9, -1));

        Q.update(P514)
                .active("指定方向に錨を投げ、最初に命中した敵ユニットに{1}を与え自身の方向に引き寄せる。また自身も敵ユニットの方向に移動する。錨が壁に命中した場合、壁の方向に移動しこのスキルの{2}。")
                .variable(1, MagicDamage, 60, 45, ap(0.75))
                .variable(2, CDDecreaseRatio, 50)
                .mana(60, 10)
                .cd(18, -2)
                .range(1100);

        W.update(P514)
                .active("10秒間{1}を得る。シールドが持続している間は通常攻撃時に対象とその周囲({2})にいる敵ユニットに2秒かけて{3}を与える。")
                .variable(1, Shield, 65, 5, amplify(Health, 0.09, 0.02))
                .variable(2, Radius, 175)
                .variable(3, MagicDamage, 30, 10, ap(0.4))
                .mana(80)
                .cd(18);

        E.update(P514)
                .active("{1}を爆発させ命中した敵ユニットに{1}と1.5秒かけて減衰する{2}を与える。爆発は3回発生し、同一対象に対して複数hitする。2発目以降は本来の50%分の" + MagicDamage + "を与える(3発hitで{3})。")
                .variable(1, Radius, 600)
                .variable(1, MagicDamage, 60, 35, ap(0.3))
                .variable(2, MSSlowRatio, 30, 5)
                .variable(3, MagicDamage, 120, 70, ap(0.6))
                .mana(60, 10)
                .cd(10);

        R.update(P514)
                .active("敵のチャンピオン1体を追尾する衝撃波を発射し、追尾中に巻き込んだ敵全員に{1}と{2}を与える。衝撃波は発動時のターゲットに命中すると爆発し、ターゲットとその{3}にいる敵に{4}、{5}と{6}を与える。")
                .variable(1, MagicDamage, 125, 50, ap(0.4))
                .variable(2, Knockup, 0.5)
                .variable(3, Radius)
                .variable(4, MagicDamage, 200, 125, ap(0.8))
                .variable(5, Knockup, 1)
                .variable(6, Stun, 1, 0.5)
                .mana(100)
                .cd(140, -30)
                .range(825);
    }

    /**
     * Define skill.
     */
    public static void Nidalee(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("茂みに入ると{1}する。さらに敵チャンピオンの方へ移動していると{2}する({3})。この効果は茂みから出ても2秒間持続する。敵チャンピオン及びモンスターに" + Q + "で" + Damage + "を与えると、４秒間対象にHuntedを付与し、対象の{4}。対象がモンスターの場合、{5}を与える。Huntedが付与された対象に向かって移動する際は{1}し{6}を得る。")
                .variable(-1, MSRatio, 15)
                .variable(-2, MSRatio, 30)
                .variable(3, Radius, 5500)
                .variable(4, Visionable)
                .variable(5, Snare, 2)
                .variable(6, IgnoreUnitCollision);

        Q.update(P514)
                .active("指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍が投げた距離に比例して与えるダメージが増加する。最大で{2}。")
                .variable(1, MagicDamage, 50, 25, ap(0.4))
                .variable(2, MagicDamage, 150, 75, ap(1.2))
                .mana(50, 10)
                .cd(6)
                .range(1500);

        W.update(P514)
                .active("指定地点に罠を仕掛ける。敵ユニットが罠を踏むと発動し、対象の敵ユニットとその周囲の敵ユニットに4秒かけて{1}を与え、{2}。罠は2分間持続する。")
                .variable(1, MagicDamage, 40, 40, ap(0.2))
                .variable(2, Visionable)
                .variable(5, Time, 12)
                .mana(40, 5)
                .cd(13, -1)
                .range(900);

        E.update(P514)
                .active("対象の味方チャンピオンは{1}し、7秒間{2}する。")
                .variable(1, RestoreHealth, 45, 40, ap(0.5))
                .variable(2, ASRatio, 20, 10)
                .mana(60, 15)
                .cd(12)
                .range(600);

        R.update(P514).active("Cougarに変身する。射程が125になる。{1}。").variable(1, NotSpellCast).cd(3);
    }

    /**
     * Define skill.
     */
    public static void NidaleeTransformed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("{7}する。茂みに入ると{1}する。さらに敵チャンピオンの方へ移動していると{2}する({3})。この効果は茂みから出ても2秒間持続する。敵チャンピオン及びモンスターに" + Q + "で" + Damage + "を与えると、４秒間対象にHuntedを付与し、対象の{4}。対象がモンスターの場合、{5}を与える。Huntedが付与された対象に向かって移動する際は{1}し{6}を得る。")
                .variable(-1, MSRatio, 15)
                .variable(-2, MSRatio, 30)
                .variable(3, Radius, 5500)
                .variable(4, Visionable)
                .variable(5, Snare, 2)
                .variable(6, IgnoreUnitCollision)
                .variable(7, Range, -400);

        Q.update(P514)
                .active("次の通常攻撃は{1}し、{2}を与える。この攻撃は対象の失っている" + Health + "に応じて増加し、最大で{3}を与える。対象がHuntedを付与されていた場合、ダメージが33%上昇し、最大で{4}を与える。")
                .variable(1, Range, 75)
                .variable(2, MagicDamage, new ReferFixed(R, new double[] {4, 16, 50, 90}), ad(0.75), ap(0.36))
                .variable(3, MagicDamage, new ReferFixed(R, new double[] {10, 50, 125, 225}), ad(1.875), ap(0.9))
                .variable(4, MagicDamage, new ReferFixed(R, new double[] {13, 67, 167, 300}), ad(2.5), ap(1.2))
                .cd(5);

        W.update(P514)
                .active("前方に飛びかかり（飛距離375固定）着地地点{2}の敵ユニットに{1}を与える。ユニットを倒すとこのスキルのCDが{3}になるまで減少する。対象付近にHuntedを付与された敵がいた場合、飛距離が750となってその対象めがけて跳躍するようになり、このスキルのCDが{3}になるまで減少する。この効果は初撃のみ発動する。")
                .variable(1, MagicDamage, new Refer(R, 50, 50), ap(0.3), null)
                .variable(2, Radius, 75)
                .variable(3, CDRAwareTime, 1.5)
                .cd(5)
                .range(375);

        E.update(P514)
                .active("前方扇形180°{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, new Refer(R, 70, 60), ap(0.45), null)
                .variable(2, Radius, 300)
                .cd(5);

        R.update(P514).active("Humanに変身する。射程が525になる。{1}。").variable(1, NotSpellCast).cd(3);
    }

    /**
     * Define skill.
     */
    public static void Nocturne(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("10秒に1度、通常攻撃のダメージが120%に増加し、{1}の敵ユニットにダメージを与える範囲攻撃になる。この効果がヒットした敵の数に応じて{2}する。また、通常攻撃を行うごとに、このスキルの{3}する。建物を攻撃する時はこの効果は発生しない。")
                .variable(1, Radius, 200)
                .variable(2, RestoreHealth, new Per6Level(10, 8))
                .variable(3, CDDecrease, 1)
                .cd(10);
        Q.update()
                .active("指定方向に影の刃を投げて当たった敵ユニットに{1}を与える。刃の軌跡には5秒間持続するDusk Trailが残り、刃がヒットした敵チャンピオンの動いた軌道上にもDusk Trailが残るようになる。Dusk Trailの上ではNocturneは{2}と{3}を得て、{4}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.75))
                .variable(2, AD, 15, 10)
                .variable(3, IgnoreUnitCollision)
                .variable(4, ASRatio, 15, 5)
                .mana(60, 5)
                .cd(10)
                .range(1200);
        W.update()
                .passive("{1}する。")
                .variable(1, ASRatio, 20, 5)
                .active("Nocturneに1.5秒間持続する{2}を付与し、その間一度だけ敵のスキルを無効化する。無効化した場合、5秒間Passiveの増加攻撃速度が2倍になる。")
                .variable(2, Status.SpellShield)
                .mana(50)
                .cd(20, -2);
        E.update()
                .active("対象の敵ユニットに2秒間0.5秒毎に{1}、合計で{3}を与え、2秒間対象が一定範囲内(範囲465)に留まり続けていれば、更に{2}を与える。")
                .variable(1, MagicDamage, 12.5, 12.5, ap(0.25))
                .variable(2, Fear, 1, 0.25)
                .variable(3, MagicDamage, 50, 50, ap(1))
                .mana(60, 5)
                .cd(15, -1)
                .range(425);
        R.update()
                .active("4秒間すべての敵チャンピオンに{1}を与え、また自分以外の視界を得られなくする。効果中に範囲内にいる敵チャンピオンを指定すると対象の位置まで移動し、到着時に対象に{2}を与える。")
                .variable(1, Foggy, 300)
                .variable(2, PhysicalDamage, 150, 100, bounusAD(1.2))
                .mana(100)
                .cd(180, -40)
                .range(2000, 750);

    }

    /**
     * Define skill.
     */
    public static void Nunu(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("通常攻撃を行うたびにスタックが増加する(最大5スタック)。5スタックの状態でスキルを使用すると、スタックを消費してスキルの消費マナが0になる。");

        Q.update(P514)
                .active("対象の敵ミニオンかペット及びモンスターに{1}を与え、{2}する。特定のモンスターを対象とした場合{3}間、以下の追加効果を得る。<br>精霊系 : {4}を得て{5}する。<br>動物系またはアンデッド系 : 敵ユニットを倒すと3秒間{7}する。<br>それ以外 : 通常攻撃かスキルでダメージを与えると、{6}を与える。")
                .variable(1, TrueDamage, 400, 150)
                .variable(2, RestoreHealth, 70, 45, ap(0.75))
                .variable(3, Time, 120, 30)
                .variable(4, Health, amplify(Health, 0.1))
                .variable(5, Grow)
                .variable(6, MagicDamage, amplify(Health, 0.01))
                .variable(7, MSRatio, 15)
                .cd(13, -1)
                .mana(60)
                .range(125);

        W.update(P514)
                .active("12秒間自身と指定した味方は{1}し{2}する。自分に対し発動した場合、もっとも近くにいる味方のチャンピオンを対象とする。")
                .variable(1, ASRatio, 25, 5)
                .variable(2, MSRatio, 8, 1)
                .mana(50)
                .cd(15)
                .range(700);

        E.update(P514)
                .active("対象の敵ユニットに{1}と3秒間{2}、{3}を与える。")
                .variable(1, MagicDamage, 85, 45, ap(1))
                .variable(2, ASSlowRatio, 25)
                .variable(3, MSSlowRatio, 20, 10)
                .mana(75, 10)
                .cd(6)
                .range(550);

        R.update(P514)
                .active("{1}の熱を最大3秒まで吸い込み、エリア内の全て敵に{2}と{3}を与える。詠唱終了時（もしくは移動、中断された時）にエリア内の敵に{4}、３秒間{1}と{2}を与える。ダメージ量は詠唱した時間に比例し下限は{5}。")
                .variable(1, Radius, 650)
                .variable(2, ASSlowRatio, 25)
                .variable(3, MSSlowRatio, 50)
                .variable(4, MagicDamage, 625, 250, ap(2.5))
                .variable(5, MagicDamage, 78, 31, ap(0.3))
                .mana(100)
                .cd(110, -10);
    }

    /**
     * Define skill.
     */
    public static void Olaf(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("{1}する。").variable(1, ASRatio, amplify(MissingHealthPercentage, 1));
        Q.update()
                .active("指定地点に貫通する斧を投げ、当たった敵ユニットに{1}と{4}間{2}を与える。このスローは2.5秒かけて元に戻る。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルの{3}する。")
                .variable(1, PhysicalDamage, 80, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 24, 4)
                .variable(3, CDDecrease, 4.5)
                .variable(4, Time, 2.5)
                .mana(55, 5)
                .cd(8)
                .range(1000)
                .update(P312)
                .active("指定地点に貫通する斧を投げ(最短飛距離400)、当たった敵ユニットに{1}と{4}間{2}を与える。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルの{3}する。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 35, 5)
                .variable(4, Time, 1, 0, amplify(Distance, 1))
                .update(P313)
                .variable(4, Time, 1.5, 0, amplify(Distance, 1))
                .mana(60)
                .update(P401)
                .variable(2, MSSlowRatio, 29, 4);
        W.update()
                .active("6秒間{1}と{2}と{3}を得る。")
                .variable(1, AD, 7, 7, amplify(Health, 0.01))
                .variable(2, LS, 9, 3)
                .variable(3, SV, 9, 3)
                .mana(40, 5)
                .cd(16)
                .update(P312)
                .active("6秒間{4}し、{2}を得る。また{5}する。")
                .variable(4, ASRatio, 20, 15)
                .variable(5, RestoreHealthRatio, amplify(MissingHealthPercentage, 0.4))
                .mana(30)
                .update(P313)
                .variable(4, ASRatio, 40, 10);
        E.update()
                .active("対象の敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 100, 60)
                .cost(Health, 40, 24)
                .cd(9, -1)
                .range(325)
                .update(P312)
                .active("対象の敵ユニットに{1}を与える。このスキルで対象を倒した場合、使用コストとして消費したHealthは返還される。通常攻撃をする度にこのスキルの{2}する。")
                .variable(1, TrueDamage, 70, 45, ad(0.4))
                .variable(2, CDDecrease, 1)
                .cd(12, -1)
                .cost(Health, new Diff(28, 18, 5), ad(0.16))
                .update(P313)
                .cost(Health, new Diff(21, 13.5, 5), ad(0.12));
        R.update()
                .active("6秒間{1}、{2}、{3}と{4}を得る。既にCCを受けていた場合はそれらを解除する。StunなどのDisable中でも使用可能。")
                .variable(1, ARPen, 10, 10)
                .variable(2, AR, 30, 15)
                .variable(3, MR, 30, 15)
                .variable(4, IgnoreCC)
                .mana(100, -25)
                .cd(100)
                .update(P312)
                .passive("{2}と{3}を得る。")
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .active("6秒間パッシブの効果が消失して、{1}と{4}を得る。既にCCを受けていた場合はそれらを解除する。StunなどのDisable中でも使用可能。")
                .variable(1, AD, 40, 20)
                .cd(120, -20)
                .mana(0);
    }

    /**
     * Define skill.
     */
    public static void Orianna(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("通常攻撃に追加{1}が付与される。4秒以内に同一の対象を連続して攻撃すると、追加魔法DMが20%上昇していく(最大+40%)。建物には無効。")
                .variable(1, MagicDamage, new Per3Level(10, 8), ap(0.15), null);
        Q.update()
                .active("指定した地点にBallを移動させ、移動中のBallに触れた敵ユニットと指定{1}にいる敵ユニットに{2}を与える。ダメージは敵に当たるごとに10%づつ減少する(最大60%減少)。BallはOriannaから一定距離離れなければその場に待機して{3}。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 60, 30, ap(0.5))
                .variable(3, Visionable)
                .mana(50)
                .cd(6, -0.75)
                .range(825);
        W.update()
                .active("Ballの存在する地点にフィールドを展開しBallの{1}にいる敵ユニットに{2}を与える。フィールドは3秒間持続し、フィールドの上の味方ユニットは{3}し、敵ユニットには{4}を与える。フィールドから出た場合、この効果は2秒かけて元に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 45, ap(0.7))
                .variable(3, MSRatio, 20, 5)
                .variable(4, MSSlowRatio, 20, 5)
                .mana(70, 10)
                .cd(9);
        E.update()
                .passive("Ballが付いている味方チャンピオンは{1}と{2}を得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("対象の味方チャンピオンまでBallを移動させ、4秒間持続する{3}を付与する。また、移動中のBallに触れた敵ユニットに{4}を与える。Ballは対象がOriannaから一定距離離れなければ貼り付き続ける。")
                .variable(3, Shield, 80, 40, ap(0.4))
                .variable(4, MagicDamage, 60, 30, ap(0.3))
                .mana(60)
                .cd(9)
                .range(1120);
        R.update()
                .active("約0.5秒詠唱後にBallから衝撃波を発生させ、Ballの{1}にいる敵ユニットに{2}を与えると共に、Ballの方向に{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 75, ap(0.7))
                .variable(3, Knockback, 350)
                .mana(100, 25)
                .cd(120, -15);
    }

    /**
     * Define skill.
     */
    public static void Pantheon(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("通常攻撃を行うかスキルを使用するたびにスタックが1増加(最大4スタック)し、4スタック時に40DM以上の通常攻撃を受けるとスタックを消費して通常攻撃のダメージを無効化する。");
        Q.update()
                .active("対象の敵ユニットに槍を投げ{1}を与える。")
                .variable(1, PhysicalDamage, 65, 40, bounusAD(1.4))
                .mana(45)
                .cd(4)
                .range(600);
        W.update()
                .active("対象の敵チャンピオンに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。")
                .variable(1, MagicDamage, 50, 25, ap(1))
                .variable(2, Stun, 1)
                .mana(55)
                .cd(13, -1)
                .range(600)
                .update(P315)
                .active("対象の敵ユニットに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。");
        E.update()
                .passive("敵ユニットのHPが15%以下の時は通常攻撃が必ずクリティカルになり、またSpear Shotのダメージが1.5倍になる。")
                .active("指定方向に0.75秒間槍を突き出し、範囲内の敵ユニットに{1}を最大3回与える(0.25秒毎に1ヒット)。対象がチャンピオンの場合、与えるダメージが{2}になる。")
                .variable(1, PhysicalDamage, 13, 10, bounusAD(0.6))
                .variable(2, PhysicalDamage, 26, 20, bounusAD(1.2))
                .mana(45, 5)
                .cd(10, -1)
                .range(400)
                .type(SkillType.Channel);
        R.update()
                .active("地点を指定して2秒後にジャンプし、その1.5秒後に指定地点の{1}に{2}と1秒間{3}を与えつつ落下する。DMは指定地点から離れるほど低減され、範囲最端では50%となる。ジャンプ前にキャンセルすると、消費した分のマナが回復し、このスキルのCDは10秒になる。")
                .variable(1, Radius, 1000)
                .variable(2, MagicDamage, 400, 300, ap(1))
                .variable(3, MSSlowRatio, 35)
                .mana(125)
                .cd(150, -15)
                .range(5500);
    }

    /**
     * Define skill.
     */
    public static void Poppy(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("現在HPの10%を超えるダメージを受けた際、その超過分のダメージを50%低減する。塔の攻撃には無効。");
        Q.update()
                .active("次に行う通常攻撃が魔法DMになり、追加{1}が付与される。")
                .variable(1, MagicDamage, 20, 20, ap(0.6), amplify(TargetMaxHealthRatio, 8))
                .mana(55)
                .cd(8, -1);
        W.update()
                .passive("通常攻撃を行うか、ダメージを受ける度にスタックが1増加する(最大10)。スタック数に比例して{1}と{2}を得る。スタックは5秒間増加がないと0になる。")
                .variable(-1, AD, 1.5, 0, amplify(Stack, 0.5))
                .variable(-2, AR, 1.5, 0, amplify(Stack, 0.5))
                .active("スタックを最大(10)まで増加させ、5秒間{3}する。")
                .variable(3, MSRatio, 17, 2)
                .mana(70, 5)
                .cd(12);
        E.update()
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。ノックバック時に壁にぶつかった場合、追加{3}と{4}を与える。")
                .variable(1, Knockback)
                .variable(2, MagicDamage, 50, 25, ap(0.4))
                .variable(3, MagicDamage, 75, 50, ap(0.4))
                .variable(4, Stun, 1.5)
                .mana(60, 5)
                .cd(12, -1)
                .range(525);
        R.update()
                .active("対象の敵チャンピオンを{2}秒間ターゲットし、その対象に与える{1}する。効果中は対象以外からのすべての攻撃を無効化する(対象のPetからはダメージを受ける)。")
                .variable(1, DamageRatio, 20, 10)
                .variable(2, Time, 6, 1)
                .mana(100)
                .cd(140, -20)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void Quinn(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("ValorがQuinnの周辺に存在する敵ユニット一体(チャンピオン優先)に自動的に4.5秒間持続するマークを付与する。マークが付与された敵ユニットにQuinnが通常攻撃を行うと、付与されたマークを消費して{1}を与える。またマークが付与された敵ユニットの{2}。Valorと交代している間はこのスキルは無効になる。")
                .variable(1, PhysicalDamage, new Per1Level(new double[] {25, 35, 45, 55, 65, 75, 85, 95, 105, 115, 125,
                        135, 145, 155, 170, 185, 190, 215}), bounusAD(0.5), null)
                .variable(2, Visionable)
                .cd(10);
        Q.update()
                .active("指定方向にValorを突撃させ、最初に当たった敵ユニットと{1}の敵ユニットに{2}と{3}を与える。Tag Team時は自身の{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 200)
                .variable(2, PhysicalDamage, 70, 40, bounusAD(0.65))
                .variable(3, Blind, 1.5)
                .mana(60, 5)
                .cd(11, -1)
                .range(1025);
        Q.update(P306).variable(2, PhysicalDamage, 70, 40, bounusAD(0.65), ap(0.5));
        W.update()
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}する。Tag Team時は{2}する。")
                .variable(1, ASRatio, 20, 5)
                .variable(-2, ASRatio, 40, 10)
                .active("2秒間{3}の視界を得る。")
                .variable(3, Radius, 2100)
                .cd(50, -5);
        W.update(P306)
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}、{3}する。Tag Team時は{2}する。")
                .variable(3, MS, 20, 10);
        E.update()
                .active("対象の敵ユニットまでダッシュし{1}と2秒間{2}を与える。スローの効果は2秒かけて元に戻る。ダッシュ後、Quinnは自身の通常攻撃の最大射程(距離525)までジャンプして対象と距離を離す。また、同時に対象にはHarrierのマークが付与される。Tag Team時はダッシュ後に距離を離さなくなる。")
                .variable(1, PhysicalDamage, 40, 30, bounusAD(0.2))
                .variable(2, MSSlowRatio, 50)
                .range(750)
                .mana(50)
                .cd(12, -1);
        R.update()
                .active("20秒間ValorがQuinnと入れ替わり戦闘に参加する。Valorは射程125のMeleeであり、専用のスキルが与えられるがスキルのCDはQuinnと共有する。Valorは{1}を得て{2}する。戦闘状態に入ると{3}する。このスキルを再度使用するか、20秒経過するとValorがQuinnと入れ替わり、{4}に敵ユニットに{5}を与える。対象が受けているダメージに比例して与えるダメージが増加し、最大で{6}を与える。")
                .variable(1, IgnoreUnitCollision)
                .variable(-2, MSRatio, 80)
                .variable(3, MSRatio, 20)
                .variable(4, Radius, 700)
                .variable(5, PhysicalDamage, 100, 50, bounusAD(0.5))
                .variable(6, PhysicalDamage, 200, 100, bounusAD(1))
                .cd(140, -20)
                .mana(100);
        R.update(P306).variable(-2, MSRatio, 80, 10).variable(3, MSRatio, 20, 10).cd(140, -30);
    }

    /**
     * Define skill.
     */
    public static void Rammus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("{1}を得る。").variable(1, AD, amplify(AR, 0.45));
        Q.update()
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。スキルを再使用するか" + W + "を使用するとキャンセルされる。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Knockup, 0.75)
                .variable(4, MSSlowRatio, 20, 5)
                .variable(5, MSRatio, 85)
                .mana(70, 10)
                .cd(10)
                .update(P315)
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。" + W + "を使用するとキャンセルされる。");
        W.update()
                .active("6秒間{1}と{2}を得て、Rammusを通常攻撃した敵ユニットに{3}を与える。効果中にPowerballを使用すると効果がキャンセルされる。また、このスキルを再使用することで効果をキャンセルできる。")
                .variable(1, AR, 40, 20)
                .variable(2, MR, 40, 20)
                .variable(3, MagicDamage, 15, 10, amplify(AR, 0.1))
                .mana(40)
                .cd(14);
        E.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, Taunt, 1, 0.5)
                .variable(2, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(12)
                .range(325)
                .update(P315)
                .variable(1, Taunt, 1.25, 0.25)
                .mana(50);
        R.update()
                .active("8秒間地震を発生させ{1}の敵ユニット及び建物に毎秒{2}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 65, 65, ap(0.3))
                .mana(120)
                .cd(60)
                .update(P315)
                .mana(100);
    }

    /**
     * Define skill.
     */
    public static void RekSai(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {

    }

    /**
     * Define skill.
     */
    public static void Rengar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("ステルス状態または茂みの中から相手を攻撃する際には、通常攻撃は{1}になり相手に飛びつくようになる。この効果はステルス状態が解除された、また茂みから出た後0.5秒の間でも発生し、またステルス状態や茂みの中の視界が取られていた場合でも発生する。また、Rengarがスキルで敵ユニットにダメージを与える度に1 Ferocityを得て、5 Ferocity貯まると全てを消費して強化されたスキルを使用することが出来る。")
                .variable(1, Range, 600);
        Q.update()
                .active("{5}間次の通常攻撃に追加{1}を付与し、次の通常攻撃から4秒間{2}する。強化されると{5}間次の通常攻撃に追加{3}を付与し、次の通常攻撃から4秒間{4}する。")
                .variable(1, PhysicalDamage, 30, 30)
                .variable(2, ASRatio, 30, 5)
                .variable(3, PhysicalDamage, 30, 30, ad(1))
                .variable(-4, ASRatio, 90, 15)
                .variable(5, Time, 6)
                .cd(8, -0.5)
                .update(P401)
                .variable(5, Time, 2);
        W.update()
                .active("{1}の敵ユニットに{2}を与える。また、このスキルが敵ユニットに命中すると、3秒間{3}と{4}を得る。強化されると{5}する。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 50, 30, ap(0.8))
                .variable(3, AR, 15, 7)
                .variable(4, MR, 15, 7)
                .variable(5, RestoreHealth, 40, 0, level(20))
                .cd(15, -1)
                .update(P401)
                .active("{1}の敵ユニットに{2}を与える。また、このスキルが敵ユニットに命中すると、3秒間{3}と{4}を得る。強化されると{5}する。(失ったHealth1%毎に回復量が1%増加)")
                .variable(5, RestoreHealth, 20, 0, level(10));
        E.update()
                .active("対象の敵ユニットに投げ縄を投げ、{1}と2.5秒{2}を与える。スローは時間経過と共に元に戻る。強化されると{3}を与えるようになる。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.7))
                .variable(2, MSSlowRatio, 50, 5)
                .variable(3, Snare, 1)
                .cd(12, -1)
                .range(575);
        R.update()
                .active("1秒後に{1}になり、{2}の敵チャンピオン全員の{3}。ステルス準備中に攻撃を行うかダメージを受ける度に、ステルス状態になるのに必要な時間が1秒増加する。ステルス準備開始から3秒経過するとダメージを受けていてもステルス状態になる。ステルス状態の間は{4}し、0.75秒毎に1 Ferocityを得る。これらの効果はステルス状態が解除されると終了する。")
                .variable(1, Stealth, 7)
                .variable(2, Radius, 2000, 1000)
                .variable(3, Visionable)
                .variable(4, MSRatio, 20, 5)
                .cd(140, -35);
    }

    /**
     * Define skill.
     */
    public static void Renekton(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("通常攻撃ごとにFuryが5増加する。12秒間戦闘を行わないとFuryは毎秒2.5減少する。Furyの最大値は100、Furyが50以上ある場合にスキルを使用すると、Furyを50消費してスキルが強化される。また、RenektonのHPが50%以下になるとFuryの増加量が50%増加する。建物を攻撃した場合はFuryは増加しない。");
        Q.update()
                .active("武器を振り回し{1}の敵ユニットに{2}を与え、{3}する(上限あり)。対象がチャンピオンの場合、{4}する。当たったユニット1体につきFuryが5増加する(最大25)。Fury消費すると与えるダメージが50%増加し、HP回復量が2倍、回復上限が3倍に増加する。但し、Fury増加効果は無くなる。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, 60, 30, bounusAD(0.8))
                .variable(3, RestoreHealth, amplify(DealtDamageRatio, 5))
                .variable(4, RestoreHealth, amplify(DealtDamageRatio, 20))
                .cd(8);
        W.update()
                .active("次に行う通常攻撃が2回攻撃になり、{1}が付与される。Fury消費すると攻撃回数が3回に増加し、{2}を付与する。但し、Fury増加効果は無くなる。{3}。")
                .variable(1, Stun, 0.75)
                .variable(2, Stun, 1.5)
                .variable(3, OnHitEffect)
                .cd(13, -1);
        E.update()
                .active("指定方向にダッシュし触れた敵ユニットに{1}を与える(Slice)。このスキルが敵にヒットした場合、4秒間の間だけ再度使用できる(Dice)。Fury消費時:Diceで与えるダメージが50%増加し、4秒間{2}を与える。SliceではFuryを消費しない。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.9))
                .variable(2, ARReductionRatio, 15, 5)
                .cd(18, -1)
                .range(450);
        R.update()
                .active("15秒間サイズが大きくなり、スキルの射程が増加する。更に{1}を得て{2}の敵ユニットに毎秒{3}を与える。また、毎秒5Furyを得る。")
                .variable(1, Health, 300, 150)
                .variable(2, Radius, 350)
                .variable(3, MagicDamage, 40, 30, ap(0.1))
                .cd(120);
    }

    /**
     * Define skill.
     */
    public static void Riven(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("スキルを使用するごとに1チャージを得る。チャージがある状態で通常攻撃を行うと、チャージを消費して通常攻撃に{1}が付与される。チャージは最大3スタックされ、通常攻撃ごとに1チャージずつ消費される。チャージは5秒間増加または消費がないと0になる。建物には無効。")
                .variable(1, PhysicalDamage, amplify(AD, new Per3LevelAdditional(0.2, 0.05)));
        Q.update()
                .active("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。")
                .variable(1, Radius, 112.5)
                .variable(2, PhysicalDamage, 30, 25, bounusAD(0.7))
                .variable(3, Radius, 150)
                .variable(4, Knockback, 225)
                .variable(5, PhysicalDamage, 90, 75, bounusAD(2.1))
                .cd(1)
                .range(260)
                .update(P310A)
                .active("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。3度目のジャンプのみ壁を飛び越えられる。")
                .variable(4, Knockup)
                .update(P401)
                .variable(2, PhysicalDamage, 10, 20, amplify(AD, 0.4, 0.05))
                .variable(5, PhysicalDamage, 30, 60, amplify(AD, 1.2, 0.15));
        W.update()
                .active("{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 125)
                .variable(2, PhysicalDamage, 50, 30, bounusAD(1))
                .variable(3, Stun, 0.75)
                .cd(11, -1);
        E.update()
                .active("指定方向にダッシュ({1})し、{3}間{2}が付与される。")
                .variable(1, Distance, 325)
                .variable(2, Shield, 70, 30, bounusAD(1))
                .variable(3, Time, 2.5)
                .cd(10, -1)
                .range(325)
                .update(P401)
                .variable(3, Time, 1.5)
                .update(P402)
                .variable(2, Shield, 90, 30, bounusAD(1));
        R.update()
                .active("15秒間折れた剣の刃を再生させ、{1}増加し、射程が増加する(通常攻撃: {2} Broken Wings: {3} Ki Burst: {4})。また、このスキルを再度使用することで一度だけ0.5秒後に指定方向に巨大な衝撃波を発生させ、範囲内の敵ユニットに{5}与える。対象が受けているダメージに比例して与えるダメージが増加して、最大DMは{6}。")
                .variable(1, AD, 0, 0, ad(0.2))
                .variable(2, Range, 200)
                .variable(3, Range, 325)
                .variable(4, Range, 270)
                .variable(5, PhysicalDamage, 80, 40, bounusAD(0.6))
                .variable(6, PhysicalDamage, 240, 120, bounusAD(1.8))
                .cd(110, -30);
    }

    /**
     * Define skill.
     */
    public static void Rumble(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("Ult以外のスキルを使うとHeatが20増加し、それが50以上になると「Danger Zone」状態に入り全てのスキルに追加効果がつくようになる。Heatが100になると6秒間スキルが使用不可能になり、通常攻撃に{1}が付与される（建物には無効）。4秒間スキルを使用しないとHeatは減少していく。")
                .variable(1, MagicDamage, 20, 0, ap(0.25), level(5));

        Q.update(P514)
                .active("目の前の敵を焼き払い、3秒間毎秒{1}を与える。ミニオンやモンスターに対してはダメージが半減。Danger Zone中は{2}を与える。")
                .variable(1, MagicDamage, 25, 20, ap(0.33))
                .variable(2, MagicDamage, 37.5, 30, ap(0.5))
                .cd(6)
                .range(600);

        W.update(P514)
                .active("2秒間{1}を得て1秒間{2}する。Danger Zone中は2秒間{3}を得て1秒間{4}する。")
                .variable(1, Shield, 50, 30, ap(0.4))
                .variable(2, MSRatio, 10, 5)
                .variable(3, Shield, 75, 45, ap(0.6))
                .variable(4, MSRatio, 15, 7.5)
                .cd(6);

        E.update()
                .active("指定方向に銛を放ち当たった敵ユニットに{1}と3秒間{2}を与える。このスキルは3秒間、再使用できる(但し、一度使用する度に1秒のCDが発生する)。2発目はHeatが増加しない。また、このスキルによるスローはスタックする。Danger Zone中では{3}と3秒間{4}を与える。")
                .variable(1, MagicDamage, 45, 25, ap(0.4))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, MagicDamage, 67.5, 37.5, ap(0.6))
                .variable(4, MSSlowRatio, 22.5, 7.5)
                .cd(10)
                .range(850);

        R.update(P514)
                .active("指定した位置から指定方向({4})にロケットを打ち出し、当たった地面を5秒間炎上させる。炎上した地面の上にいる敵ユニットに毎秒{3}と{2}を与える。")
                .variable(2, MSSlowRatio, 35)
                .variable(3, MagicDamage, 130, 55, ap(0.3))
                .variable(4, Distance, 1000)
                .cd(105, -15)
                .range(1700);
    }

    /**
     * Define skill.
     */
    public static void Ryze(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("スキル使用時に6秒間、スタックを得る。5スタック時に、{1}間フルチャージ状態になり、{2}を得て、スキルを使用するたびに使用したスキル以外のスキルのCDが「" + Q + "のCD数値分」解消される。")
                .variable(1, Time, new ReferPlus(Q, 2.5, 0.5))
                .variable(2, Shield, 20, 0, level(5), amplify(Mana, 0.08));

        Q.update(P514)
                .passive(P + "がフルチャージした際の効果時間が{2}増加する。")
                .variable(2, Time, 0.5, 0.5)
                .active("オーブを放ち、最初に命中した敵に{1}を与える。")
                .variable(1, MagicDamage, 60, 25, ap(0.55), amplify(Mana, 0.02, 0.005))
                .mana(40)
                .cd(4)
                .range(900);

        W.update(P514)
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 20, ap(0.4), amplify(Mana, 0.025))
                .variable(2, Snare, 1, 0.1)
                .cd(14)
                .mana(60, 10)
                .range(600);

        E.update(P514)
                .active("対象の敵ユニットにオーブを放ち{1}と5秒間{2} (効果は3回まで累積)を与える。命中後、周囲の敵と自身(ターゲット以外で最大6体)に跳ね返り、最終的に最初のターゲットに戻る。最初のターゲットに命中した後は、跳ね返るごとに{3}を与える。最大で{4}。")
                .variable(1, MagicDamage, 36, 16, ap(0.2), amplify(Mana, 0.02))
                .variable(2, MRReductionRatio, 8, 1)
                .variable(3, MagicDamage, 18, 8, ap(0.1), amplify(Mana, 0.01))
                .variable(4, MagicDamage, 144, 64, ap(0.8), amplify(Mana, 0.08))
                .mana(60, 10)
                .cd(7)
                .range(600);

        R.update(P514)
                .passive("{1}を得る。")
                .variable(1, CDR, 10, 10)
                .active("6秒間{2}を得て{3}する。更にスキルに50%のスプラッシュダメージ({4})が付与される。")
                .variable(2, SV, 15, 5)
                .variable(3, MS, 80)
                .variable(4, Radius, 200)
                .cd(80, -20);
    }

    /**
     * Define skill.
     */
    public static void Sejuani(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("通常攻撃にFrostを付与する。Frost状態の敵ユニットは3秒間{1}になる。").variable(1, MSSlowRatio, 30);
        P.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、2秒間{1}と{2}を得る。この効果時間は最大8秒までスタックする。")
                .variable(1, AR, new Per5LevelForSejuani(10, 5))
                .variable(2, MSSlowReductionRatio, new Per5LevelForSejuani(10, 5));
        Q.update()
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}とFrostを与え、対象がMinionの場合は更に{2}させる。敵チャンピオンに当たるか最大距離だけ移動すると突進は止まる。")
                .variable(1, MagicDamage, 60, 30, ap(0.4))
                .variable(2, Knockback)
                .mana(70, 5)
                .cd(19, -2)
                .range(700);
        Q.update(P306)
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}と{2}を与える（モンスターには最大300ダメージ）。敵チャンピオンに当たると突進は止まる。")
                .variable(1, Knockup)
                .variable(2, MagicDamage, 40, 30, ap(0.4), amplify(TargetMaxHealthRatio, 4, 2))
                .mana(80, 5)
                .cd(15, -1)
                .range(650);
        W.update()
                .active("6秒間極寒の嵐を周囲に召還し、{1}の敵ユニットに毎秒{2}を与える。魔法DMは敵ユニットがFrostまたはPermafrostの時には50%増加する。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 12, 6, ap(0.1), amplify(Health, 0.01, 0.0025))
                .mana(40)
                .cd(10);
        W.update(P306)
                .active("次の通常攻撃は、対象と{1}の敵達に{2}を与える。また4秒間{1}の敵に毎秒{3}を与える。(最大で{4})")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 20, 10, ap(0.15), amplify(BounusHealth, 0.04))
                .variable(4, MagicDamage, 120, 60, ap(0.9), amplify(BounusHealth, 0.16))
                .cd(11, -1);
        W.update(P308).variable(4, MagicDamage, 120, 60, ap(0.9), amplify(BounusHealth, 0.1));
        E.update()
                .active("{0}の敵ユニットのFrostをPermafrostにし、{1}を与える。Permafrost状態の敵ユニットは3秒間{2}を受ける。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 50, ap(0.5))
                .variable(2, MSSlowRatio, 30, 10)
                .mana(55)
                .cd(11);
        E.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、対象を4秒間Frost状態にする。")
                .active("{0}のFrost状態の敵ユニットに{1}と{2}間{3}を与える。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 50, ap(0.5))
                .variable(2, Time, 2, 0.25)
                .variable(3, MSSlowRatio, 50, 5);
        E.update(P308).variable(2, Time, 1.5, 0.25);
        R.update()
                .active("指定方向に武器を投げ、最大距離飛ぶか敵チャンピオンに命中するとその場で氷が爆発し、{1}の敵ユニットに{2}と{3}を与え、Frostにする。武器が直撃した敵チャンピオンには{4}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1)
                .variable(4, Stun, 2)
                .mana(100)
                .cd(130, -15)
                .range(1150);
        R.update(P306)
                .active("指定方向に武器を投げ、敵チャンピオンに命中するとその場で爆発し、{1}の敵ユニットに{2}と{3}を与える。命中しなかった場合、最大射程で爆発し{1}の敵ユニットに{2}と{5}間{4}を与える。")
                .variable(3, Stun, 1.5, 0.25)
                .variable(4, MSSlowRatio, 90)
                .variable(5, Time, 1.5, 0.25);
        R.update(P308).variable(3, Stun, 1.25, 0.25).variable(5, Time, 1.25, 0.25);
    }

    /**
     * Define skill.
     */
    public static void Shaco(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("対象の背後から攻撃した場合に{1}する。").variable(1, DamageRatio, 20);
        Q.update()
                .active("指定地点にテレポートし、{1}になる。また、スキル使用後6秒以内に通常攻撃を行うと必ずクリティカルになる。その際のクリティカルダメージは{2}になる。")
                .variable(1, Stealth, 3.5)
                .variable(2, Percentage, 140, 20)
                .cd(11)
                .mana(90, -10)
                .range(400);
        W.update()
                .active("指定地点に60秒持続する人形を設置する。人形は設置後2秒で{1}となり、敵ユニットがステルス状態の人形から範囲300以内に近づくと、人形のステルスが解除されると同時に近くの敵ユニットに{2}を与え、5秒間通常攻撃({3})を行った後に破壊される。")
                .variable(1, Stealth)
                .variable(2, Fear, 0.5, 0.25)
                .variable(3, MagicDamage, 35, 15, ap(0.2))
                .mana(60)
                .cd(16)
                .range(425);
        E.update()
                .passive("通常攻撃に2秒間の{1}を付与する。対象がチャンピオン以外の場合、更に命中率低下(値はスローと同じ)を与える。命中率低下を受けたユニットは一定確率で通常攻撃が外れる(ブラインドと同じ)。")
                .variable(1, MSSlowRatio, 10, 5)
                .active("対象の敵ユニットに{2}と3秒間{1}を与える。効果後はCDが解消されるまでPassiveの効果が無くなる。")
                .variable(2, MagicDamage, 50, 40, ap(1), bounusAD(1))
                .mana(50, 5)
                .cd(8)
                .range(625);
        R.update()
                .active("18秒間持続する自身のイリュージョン(敵からの見た目は本体と同じ)を作成する。(RまたはALT押しながらクリックで任意の操作可能)イリュージョンは本体の75%の攻撃力を持ち、150%のダメージを受ける。また本体の一部アイテムの効果を引き継ぐ。イリュージョン死亡または効果時間終了時に爆発し、{1}の敵ユニットに{2}を与える。イリュージョンが塔に与えるダメージは半分。このスキルを使用してもステルスは解除されない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 300, 150, ap(1))
                .mana(100)
                .cd(100, -10);
    }

    /**
     * Define skill.
     */
    public static void Shen(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("9秒に1度通常攻撃に追加{1}が付与され、{2}する。このスキルはShenが通常攻撃を行う度にCDが1秒解消される。CD解消は建物を攻撃した場合は発生しない。LV1/7/13で「気」回復量が増加する。")
                .variable(1, MagicDamage, 4, 0, level(4), amplify(BounusHealth, 0.1))
                .variable(2, RestoreEnergy, new Per6Level(10, 10));
        Q.update()
                .active("対象の敵ユニットに{1}と5秒間持続するDebuffを与える。Debuffが付与された対象に通常攻撃またはダメージスペルで攻撃をすると、攻撃した味方チャンピオンは3秒かけて{2}する。このスキルでLHを取った場合、{3}する。")
                .variable(1, MagicDamage, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 6, 4, amplify(Health, 0.015))
                .variable(3, RestoreHealth, 2, 1.3, amplify(Health, 0.005))
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(475);
        W.update()
                .active("3秒間{1}を得る。シールドが持続している間はKi StrikeのCD解消効果が1秒から2秒になる。")
                .variable(1, Shield, 70, 45, ap(0.6))
                .cd(9, -1)
                .cost(Energy, 50, 0);
        W.update(P310A).variable(1, Shield, 60, 40, ap(0.6));
        E.update()
                .active("指定地点まで素早く移動し接触した敵チャンピオンに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける物理DMを半減する。またこのスキルが敵チャンピオンに命中する度に{3}する。")
                .variable(1, MagicDamage, 50, 35, ap(0.5))
                .variable(2, Taunt, 1.5)
                .variable(3, RestoreEnergy, 40)
                .cd(16, -2)
                .cost(Energy, 120, 0)
                .range(600);
        E.update(P312)
                .active("指定地点まで素早く移動し接触した敵チャンピオンに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける通常攻撃のDMを半減する。またこのスキルが敵チャンピオンに命中する度に{3}する。");
        R.update()
                .active("対象の味方チャンピオンに5秒間{1}を付与し、3秒詠唱後そこまでワープする。")
                .variable(1, Shield, 250, 300, ap(1.5))
                .cd(200, -20)
                .range(-1);
        R.update(P310A).active("対象の味方チャンピオンに5秒間{1}を付与し、3秒詠唱後そこまでワープする。詠唱中にスロー以外のCCを受けると中断される。");

    }

    /**
     * Define skill.
     */
    public static void Sivir(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("敵チャンピオンに通常攻撃でダメージを与えると、2秒間{1}する。")
                .variable(-1, MSRatio, 50)
                .update(P306)
                .passive(("敵チャンピオンに通常攻撃か" + Q + "もしくは" + W + "でダメージを与えると、2秒間{1}する。"))
                .update(P315)
                .variable(-1, MSRatio, new Per5LevelWith18(30, 5));
        Q.update()
                .active("指定方向にブーメランを投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに{2}ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定がある。")
                .variable(1, PhysicalDamage, 60, 45, ap(0.5), bounusAD(1.1))
                .variable(2, Percentage, 20)
                .mana(70, 10)
                .cd(9)
                .range(1200);
        Q.update(P314).variable(1, PhysicalDamage, 25, 20, amplify(AD, 0.7, 0.1)).variable(2, Percentage, 10);
        W.update()
                .active("次に行う通常攻撃に追加{1}が付与され、5回跳ね返る({2})ようになる。この追加ダメージはCriticalHitによって増幅される。On-Hit Effectsの効果は最初に当たったユニットにのみ発動し、跳ね返る毎にダメージが20%ずつ低下する。")
                .variable(1, PhysicalDamage, 20, 15)
                .variable(2, Radius, 450)
                .mana(40)
                .cd(7, -1);
        W.update(P313)
                .active("次の3回の通常攻撃が{1}の全ての敵に跳ねるようになる。この跳ねは一番近くのユニットに跳ね、同一ユニットには一度しか当たらない。2匹目以降の敵には{2}を与える。On-Hit Effectsの効果は最初に当たったユニットにのみ発動する。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, amplify(AD, 0.5, 0.1))
                .cd(9, -1);
        E.update()
                .active("{3}間、一度だけ敵のスキルを無効化する{1}を得る。無効化した場合{2}する。")
                .variable(1, Status.SpellShield)
                .variable(2, RestoreMana, 150)
                .variable(3, Time, 3)
                .mana(75)
                .cd(22, -3)
                .update(P313)
                .mana(0)
                .variable(2, RestoreMana, 60, 15)
                .update(P315)
                .variable(3, Time, 1.5);
        R.update()
                .active("{5}間以下の能力をもつ{1}のオーラを発生させる。{2}し、自身は{3}、近くの味方ユニットは{4}する。一度範囲内に入れば、Sivirから離れても効果が持続する。")
                .variable(1, Radius, 1200)
                .variable(2, MSRatio, 20)
                .variable(3, ASRatio, 30, 15)
                .variable(4, ASRatio, 15, 7.5)
                .variable(5, Time, 10)
                .mana(100)
                .cd(100, -10)
                .range(1200)
                .update(P313)
                .passive("Ricochetの起動中は{1}する。")
                .variable(-1, ASRatio, 40, 20)
                .active("{5}間{2}の味方は{3}する。一度範囲内に入れば、Sivirから離れても効果が持続する。増加移動速度は{6}かけて20%まで減少する。")
                .variable(2, Radius, 1000)
                .variable(3, MSRatio, 60)
                .variable(6, Time, 4)
                .range(0)
                .cd(120, -30)
                .update(P315)
                .variable(5, Time, 8)
                .variable(6, Time, 2, 1)
                .cd(120, -20);
    }

    /**
     * Define skill.
     */
    public static void Singed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("{1}を得る。").variable(1, Health, amplify(Mana, 0.25));
        Q.update()
                .active("Singedの通り道に3.25秒間持続する毒を撒き、触れた敵ユニットに3秒間毎秒{1}を与える。")
                .variable(1, MagicDamage, 22, 0, ap(0.3))
                .mana(13)
                .cd(1)
                .type(SkillType.Toggle);
        W.update()
                .active("指定地点に5秒間持続する粘着剤を撒き、{1}の敵ユニットに{2}を与え続ける。この効果は範囲外に出てからも1秒間持続する。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 35, 10)
                .mana(70, 10)
                .cd(14)
                .range(1000);
        E.update()
                .active("対象の敵ユニット{1}を与え、Singedの後ろに投げ飛ばす({2})。")
                .variable(1, MagicDamage, 100, 50, ap(1))
                .variable(2, Distance, 550)
                .mana(100, 10)
                .cd(10)
                .range(125);
        E.update(P304).variable(1, MagicDamage, 80, 45, ap(0.75));
        R.update()
                .active("25秒間{1}、{2}、{3}、{4}、{5}、{6}を得て、{7}する。")
                .variable(1, AP, 35, 15)
                .variable(2, AR, 35, 15)
                .variable(3, MR, 35, 15)
                .variable(4, Hreg, 35, 15)
                .variable(5, Mreg, 35, 15)
                .variable(6, Tenacity, 10, 5)
                .variable(7, MSRatio, 35, 15)
                .mana(150)
                .cd(100);
        R.update(P304).active("25秒間{1}、{2}、{3}、{4}、{5}を得て、{7}する。");
    }

    /**
     * Define skill.
     */
    public static void Sion(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("40%の確率で{1}する。この軽減は防御力計算より先に行われる。")
                .variable(1, AttackDamageReduction, new Per6Level(30, 10));
        Q.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 70, 55, ap(0.9))
                .variable(2, Stun, 1.5)
                .mana(100)
                .cd(12, -1)
                .range(550);
        W.update()
                .active("{1}を得る。10秒間シールドが残っていた場合、シールドが破裂し{2}の敵ユニットに{3}を与える。使用から4秒後以降に再度使用で、即座にシールドを破裂させる。")
                .variable(1, Shield, 100, 50, ap(0.9))
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 100, 50, ap(0.9))
                .mana(70, 10)
                .cd(8);
        E.update()
                .active("{1}を得る。使用中にLHをとるとSionの最大HPが{2}増加する。対象が敵チャンピオン/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍になる。")
                .variable(1, AD, 25, 10)
                .variable(2, Count, 1, 0.5)
                .cost(Health, 6, 2)
                .type(SkillType.Toggle);
        R.update()
                .active("20秒間{1}を得て{2}し、通常攻撃をするたびに{4}の味方ユニットは{3}する。")
                .variable(1, LS, 50, 25)
                .variable(2, ASRatio, 50)
                .variable(3, RestoreHealth, amplify(AttackDamageRatio, 25, 12.5))
                .variable(4, Radius, 200)
                .mana(100)
                .cd(90);
    }

    /**
     * Define skill.
     */
    public static void Skarner(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("通常攻撃を行うたびに、 Skarnerのすべてのスキルの{1}される(対象がチャンピオンの場合は{2})。建物に対しては無効。")
                .variable(1, CDDecrease, 0.5)
                .variable(2, CDDecrease, 1);

        Q.update()
                .active("{4}の敵ユニットに{1}を与える。このスキルが命中した場合、5秒間Crystal Energyのスタックを得る。スタックがある状態で再度このスキルを使用すると、追加{2}と2秒間{3}が付与される。")
                .variable(1, PhysicalDamage, 25, 15, bounusAD(0.8))
                .variable(2, MagicDamage, 24, 12, ap(0.4))
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, Radius, 350)
                .mana(20, 2)
                .cd(3.5)
                .update(P402)
                .active("{4}の敵ユニットに{1}を与える。このスキルが命中した場合、5秒間{3}得る。この効果は3回までスタックする。スタックがある状態で再度このスキルを使用すると、{2}を与える。")
                .variable(3, ASRatio, 8, 2)
                .update(P403)
                .mana(16, 2);

        W.update()
                .active("6秒間{1}を張る。シールドが残っている間{2}し、{3}する。")
                .variable(1, Shield, 70, 45, ap(0.6))
                .variable(2, MSRatio, 15, 2)
                .variable(3, ASRatio, 30, 5)
                .mana(60)
                .cd(18)
                .update(P402)
                .active("6秒間{1}を張る。シールドが残っている間3秒かけて{2}する。")
                .variable(1, Shield, 80, 55, ap(0.8))
                .variable(2, MSRatio, 16, 4)
                .cd(16);

        E.update()
                .active("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに{1}と6秒間持続するマークを付与する。自身がマークが付いた敵ユニットを攻撃するか、このスキルで敵ユニットを倒した場合、マークを消費して{2}する。HP回復量はマークを消費する度に50%ずつ低下していく。")
                .variable(1, MagicDamage, 80, 40, ap(0.7))
                .variable(2, RestoreHealth, 30, 15, ap(0.3))
                .mana(50, 5)
                .cd(10)
                .range(600)
                .update(P402)
                .active("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに{1}と2.5秒間{2}を付与する。")
                .variable(2, MSSlowRatio, 30, 5)
                .cd(14)
                .range(1000)
                .update(P403)
                .variable(2, MSSlowRatio, 45, 5);

        R.update()
                .active("対象の敵チャンピオンに{1}と{2}を与える。効果中は対象の敵チャンピオンを引っ張る事が出来る。また、効果終了時に追加{3}を与える。")
                .variable(1, MagicDamage, 100, 50, ap(0.5))
                .variable(2, Suppression, 1.75)
                .variable(3, MagicDamage, 100, 50, ap(0.5))
                .mana(100, 25)
                .cd(130, -10)
                .range(350);
    }

    /**
     * Define skill.
     */
    public static void Sona(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("Auraを切り替えても、以前のAuraの効果が1秒間持続する。切替時は他のAuraスキルが0.5秒間CDになる。また、3回スキルを使用した後の通常攻撃に{1}と、そのとき展開しているAuraに応じた追加効果が発生する。<br>" + Q + " : 追加{1}を与える。<br>" + W + " : {3}間対象が与えるダメージが{4}減少するDebuffを与える。<br>" + E + " : 2秒間{2}を与える。")
                .variable(1, MagicDamage, 8, 0, level(10))
                .variable(2, MSSlowRatio, 40)
                .variable(3, Time, 4)
                .variable(4, Percentage, 20);
        P.update(P308)
                .variable(1, MagicDamage, new Per1Level(new double[] {13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112,
                        122, 132, 147, 162, 177, 192}))
                .variable(3, Time, 3);
        P.update(P314)
                .variable(1, MagicDamage, new Per1Level(new double[] {13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112,
                        122, 132, 147, 162, 177, 192}), ap(0.2), null)
                .variable(4, Percentage, 20, 0, ap(0.02))
                .variable(2, MSSlowRatio, 40, 0, ap(0.04));
        Q.update()
                .active("最も近い敵ユニット2体に{4}を与える。Sonaの通常攻撃範囲内に敵チャンピオンがいる場合、それらを優先して狙う。" + R + "以外の別のスキルを使うまで{1}の味方チャンピオンは{2}と{3}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, AD, 4, 4)
                .variable(3, AP, 4, 4)
                .variable(4, MagicDamage, 50, 50, ap(0.7))
                .mana(45, 5)
                .cd(7)
                .range(700);
        Q.update(P314).variable(4, MagicDamage, 50, 50, ap(0.5));
        W.update()
                .active("近くにいる最もHPが減っている味方チャンピオン1体とSonaは{1}し、3秒間{2}と{3}を得る。" + R + "以外の別のスキルを使うまで{4}の味方チャンピオンは{5}と{6}を得る。")
                .variable(1, RestoreHealth, 40, 20, ap(0.25))
                .variable(2, AR, 8, 3)
                .variable(3, MR, 8, 3)
                .variable(4, Radius, 1000)
                .variable(5, AR, 3, 3)
                .variable(6, MR, 3, 3)
                .mana(60, 5)
                .cd(7)
                .range(1000);
        W.update(P308).variable(2, AR, 6, 1).variable(3, MR, 6, 1).variable(5, AR, 6, 1).variable(6, MR, 6, 1);
        W.update(P314).variable(1, RestoreHealth, 40, 15, ap(0.25));
        E.update()
                .active("1.5秒間{1}の味方ユニットは{2}する。" + R + "以外の別のスキルを使うまで{1}の味方チャンピオンは{3}する")
                .variable(1, Radius, 1000)
                .variable(2, MSRatio, 6, 2)
                .variable(3, MSRatio, 4, 4)
                .mana(65)
                .cd(7)
                .range(1000);
        E.update(P314).variable(2, MSRatio, 4, 2, ap(0.02));
        R.update()
                .active("前方{1}の敵チャンピオンに{2}と{3}を与える。")
                .variable(1, Radius, 1000)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1.5)
                .mana(100, 50)
                .cd(140, -20);
        R.update(P314).variable(2, MagicDamage, 150, 100, ap(0.5));
    }

    /**
     * Define skill.
     */
    public static void Soraka(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("{1}の味方チャンピオンは{2}を得る。").variable(1, Radius, 1000).variable(2, MR, 16);
        P.update(P314).passive("スキルによるHealth及びMana回復は、回復する対象の減少しているHealth/Mana2%につき、1%増加する(最大でHealth/Mana回復量1.5倍)。");
        Q.update()
                .active("{1}の敵ユニットに{2}を与え、スタックを1つ増加させる。スタック1つにつき{3}を与える。スタックは5秒間持続し最大10まで増加する。")
                .variable(1, Radius, 675)
                .variable(2, MagicDamage, 60, 25, ap(0.4))
                .variable(3, MRReduction, 8, 1)
                .mana(20, 15)
                .cd(2.5);
        Q.update(P314)
                .active("{1}の敵ユニットに{2}と{3}を与える。この減少効果は5秒間持続し最大10回まで累積する。また、このスキルが敵チャンピオンに命中すると、" + W + "の{4}する。")
                .variable(2, MagicDamage, 60, 35, ap(0.4))
                .variable(3, MRReduction, 6, 0, ap(0.01))
                .variable(4, CDDecreaseRatio, 5, 1.25)
                .mana(30, 10);
        W.update()
                .active("対象の味方ユニットは{1}し、{3}間{2}を得る。")
                .variable(1, RestoreHealth, 70, 70, ap(0.45))
                .variable(2, AR, 25, 20)
                .variable(3, Time, 3)
                .mana(80, 30)
                .cd(20)
                .range(750);
        W.update(P314)
                .variable(1, RestoreHealth, 70, 50, ap(0.35))
                .variable(2, AR, 50, 15, ap(0.15))
                .variable(3, Time, 2)
                .mana(80, 20);
        E.update()
                .active("対象の味方チャンピオンに使用すると{1}する。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .variable(1, RestoreMana, 40, 40)
                .variable(2, MagicDamage, 50, 50, ap(0.6))
                .variable(3, Silence, 1.5, 0.25)
                .cd(10)
                .range(725);
        E.update(P314)
                .active("対象の味方チャンピオンに使用すると{1}し、Sorakaは{4}を失う。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .variable(1, RestoreMana, 20, 20, amplify(Mana, 0.05))
                .variable(2, MagicDamage, 40, 30, ap(0.4), amplify(Mana, 0.05))
                .variable(4, Mana, amplify(Mana, 0.05));
        R.update()
                .active("全ての味方チャンピオンは{1}する。")
                .variable(1, RestoreHealth, 200, 120, ap(0.7))
                .mana(100, 75)
                .cd(160, -15);
        R.update(P313).mana(100);
        R.update(P314).variable(1, RestoreHealth, 150, 100, ap(0.55));
    }

    /**
     * Define skill.
     */
    public static void Swain(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        /** Swain */
        P.update().passive("敵ユニットを倒す毎に{1}する。").variable(1, RestoreMana, 9, 0, level(1));
        P.update(P313).passive("敵ユニットを倒す毎に{1}する。キルもしくはアシストする毎に{2}する。").variable(2, RestoreMana, amplify(Mana, 0.09));
        Q.update()
                .active("Swainの位置にビームを吐くカラスを設置し、対象の敵ユニットに毎秒{1}と{2}を与える。3秒経つか対象のユニットがカラスの有効範囲外({3})に移動すると効果が切れる。")
                .variable(1, MagicDamage, 25, 15, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, Radius, 900)
                .mana(60, 10)
                .cd(8)
                .range(625);
        W.update()
                .active("地点を指定した0.5秒後に範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.7))
                .variable(2, Snare, 2)
                .mana(80, 10)
                .cd(18, -2)
                .range(900);
        E.update()
                .active("対象の敵ユニットに4秒かけて{1}を与える。また、効果中はSwainが対象のユニットに与える{2}する。")
                .variable(1, MagicDamage, 75, 40, ap(0.8))
                .variable(2, DamageRatio, 8, 3)
                .mana(65, 5)
                .cd(10)
                .range(625);
        R.update()
                .active("カラスに変身し、{0}の敵ユニット3体(敵チャンピオンを優先)に毎秒{1}を与える。また、{2}して敵チャンピオンの場合は{3}する。")
                .variable(0, Radius, 700)
                .variable(1, MagicDamage, 50, 25, ap(0.2))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 0.25))
                .variable(3, RestoreHealth, amplify(DealtDamage, 0.75))
                .cd(8)
                .cost(Mana, new Diff(25, 0, 1), amplify(Duration, 5, 1))
                .type(SkillType.Toggle);
    }

    /**
     * Define skill.
     */
    public static void Syndra(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("各スキルを最高ランクまで上げると追加効果が発生する。");
        Q.update()
                .active("指定地点にDark Sphereを召喚し、{1}の敵ユニットに{2}を与える。Dark Sphereはその後6秒間持続する。Lv5になるとチャンピオンに対して{3}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MagicDamage, 264.5, 0, ap(0.69))
                .mana(40, 10)
                .cd(4)
                .range(800);
        W.update()
                .active("指定したDark Sphereか敵minionまたは中立モンスター(DragonとBaronには無効)のいずれかを自身まで引き寄せ、最大5秒間引っ張り続ける。この際Dark Sphereを引き寄せた場合、そのDark Sphereの持続時間は引き寄せてから6秒間に更新される。その後再度地点を指定({5})することで指定地点に引き寄せたものを投げ、{1}の敵ユニットに{2}と1.5秒間{3}を与える。また指定地点の{4}。Lv5になるとスローの効果時間が2秒になる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 80, 40, ap(0.7))
                .variable(3, MSSlowRatio, 25, 5)
                .variable(4, Visionable)
                .variable(5, Radius, 900)
                .mana(60, 10)
                .cd(12, -1)
                .range(925);
        E.update()
                .active("指定方向扇形の{1}にいる敵ユニットに{2}と{3}を与える。ノックバック距離はSyndraに近い地点にいるほど増加する。扇形の範囲内にDark Sphereがあった場合同様にノックバックさせ、それに当たった敵ユニットに{2}(このスキルのDMとは重複しない)と{4}を与える。Lv5になると範囲の横幅が50%増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, Knockback)
                .variable(4, Stun, 1.5)
                .mana(50)
                .cd(18, -1.5)
                .range(650);
        E.update(P313).range(700);
        R.update()
                .active("自身の周辺にDark Sphereを3つ召喚し、指定した敵チャンピオンに向けて自身の周囲に存在する全てのDark Sphereを向かわせ、{1}を与える。3個で{2}、7個で{3}になる。この際に召喚したDark Sphereは6秒間持続する。Lv3になると射程が75増加する。")
                .variable(1, MagicDamage, 90, 45, ap(0.2))
                .variable(2, MagicDamage, 270, 135, ap(0.6))
                .variable(3, MagicDamage, 630, 345, ap(1.4))
                .mana(100)
                .cd(100, -10)
                .range(675);
    }

    /**
     * Define skill.
     */
    public static void Shyvana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("Shyvanaは通常攻撃時に次の効果を得る。Twin BiteのCDを0.5秒解消する。対象が建物の場合は無効。Burnoutの効果時間が1秒延長される。最大4秒延長できる。対象が建物の場合も有効。Flame BreathのAR低下を受けている敵ユニットに対し、Flame Breathのダメージの15%分の追加魔法DMが発生する。Dragon's Descent通常攻撃時に2Furyを得る。また、Human formの時には1.5秒毎に1Furyを得る。");
        P.update(P309)
                .passive("{1}と{2}を得る。この効果はDragon Form時には2倍になる。")
                .variable(1, AR, new Per5Level(5, 5))
                .variable(2, MR, new Per5Level(5, 5));
        Q.update()
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。")
                .variable(1, PhysicalDamage, amplify(AD, 0.8, 0.05))
                .variable(2, CDDecrease, 0.5)
                .cd(10, -1);
        Q.update(P309)
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。建物以外の対象を通常攻撃する毎に{2}する。{3}。")
                .variable(3, OnHitEffect);
        W.update()
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 25, 15, bounusAD(0.2))
                .variable(3, MSRatio, 30, 5)
                .cd(12)
                .update(P309)
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。通常攻撃をする毎に効果時間が1秒延長される(最大4秒増加)。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .update(P401)
                .variable(2, MagicDamage, 20, 15, bounusAD(0.2));

        E.update()
                .active("指定方向に火球を放ち当たった敵ユニットに{1}と４秒間{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 80, 45, ap(0.6))
                .variable(2, ARReductionRatio, 15)
                .cd(12, -1)
                .range(700)
                .update(P309)
                .active("指定方向に貫通する火球を放ち当たった敵ユニットに{1}と5秒間Debuffを与える。Debuffを受けている敵に通常攻撃をする毎に{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 80, 35, ap(0.6))
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 2))
                .update(P401)
                .variable(1, MagicDamage, 60, 40, ap(0.6));
        R.update()
                .passive("{1}と{2}を得る。 Dragon Formの時は2倍になる。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒6Fury減少し、0になるとHuman Formに戻る。")
                .variable(3, MagicDamage, 175, 125, ap(0.7))
                .variable(4, Knockback)
                .range(1000);
        R.update(P309)
                .passive("Human formの時には1.5秒毎に{1}Furyを得る。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, Value, 1, 1)
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒5Fury減少し、0になるとHuman Formに戻る。");

    }

    /**
     * Define skill.
     */
    public static void TahmKench(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("通常攻撃もしくはスキルで" + Damage + "を与えた敵チャンピオンに対して、「舌慣らし」スタックを付与する(最大3スタック)。3スタックが付与された対象にスキルを使用すると、各スキルは追加効果を得る。通常攻撃で最後にスタックを与えた場合は5秒後、" + Q + "の場合は7秒後から0.5秒おきにスタックが減少する。");

        Q.update(P514)
                .active("最初に命中した敵に{1}と2秒間{2}を与える。「舌慣らし」が3スタック溜まっている敵のチャンピオンには、さらに{3}を与える。舌が飛び出している最中に" + W + "を発動することで、遠くにいるモンスターやミニオンを食らうことができる。")
                .variable(1, MagicDamage, 80, 45, ap(0.7))
                .variable(2, MSSlowRatio, 30, 10)
                .variable(3, Stun, 1.5)
                .mana(50)
                .cd(6)
                .range(800);

        W.update(P514)
                .active("対象を{1}間食らう。対象が敵の場合、{2}を与える(ミニオンと中立モンスターへは{3}が上限)。食べた対象は吐き出すまでの間、行動不能かつターゲット不可になる。また、食べたユニットに応じて以下の効果を与える。<br>敵ミニオン及びモンスター: 指定した方向に吐き出し({6})、命中した敵ユニットに{4}を与える。<br>味方チャンピオン: 敵チャンピオンに向かって移動する際に{5}を得る。<br>敵チャンピオン: 要「舌慣らし」3スタック。効果時間が半分になり、自身は95％のスローになる。")
                .variable(1, Time, 4, 0.5)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 20, 3, ap(0.02)))
                .variable(3, MagicDamage, 400, 50)
                .variable(4, MagicDamage, 100, 50, ap(0.6))
                .variable(-5, MSRatio, 30, 5)
                .variable(6, Radius, 650)
                .mana(90)
                .cd(14, -1)
                .range(250);

        E.update(P514)
                .passive("受けたダメージを灰色の体力に変換する(クールダウン中は無効)。2.5秒間" + Damage + "を受けなければ、{1}する。")
                .variable(1, RestoreHealth, amplify(ReceivedDamageRatio, 20, 6))
                .active("{2}。このシールドは6秒間持続するが時間と共に急激に減少していく。")
                .variable(2, Shield, amplify(ReceivedDamageRatio, 100))
                .mana(50)
                .cd(16, -1);

        R.update(P514)
                .passive("通常攻撃及びスキルに{1}を付与する。")
                .variable(1, MagicDamage, 20, 0, amplify(BounusHealth, 0.04, 0.02))
                .active("最大15秒間、口を大きく開けてその場で詠唱を開始する。味方チャンピオンが入るか、このスキルを再使用することで、2秒詠唱後に指定した地点までワープする。この詠唱は" + Damage + "を受けると解除される。")
                .mana(100)
                .cd(120, -10)
                .range(4000, 1000)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Taric(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("通常攻撃をすると{1}する。").variable(1, RestoreMana, amplify(DealtDamageRatio, 0.075));
        P.update(P303)
                .passive("通常攻撃に追加{1}を付与する。敵チャンピオンに対しては{2}を与える。建物には無効。")
                .variable(1, MagicDamage, amplify(Mana, 0.02))
                .variable(2, MagicDamage, amplify(Mana, 0.04));
        P.update(P314)
                .passive("スキルを使用した次の通常攻撃は追加{1}を与え、全スキルの{2}する。この効果は通常攻撃を行うか、一定時間経過すると解消される。")
                .variable(1, MagicDamage, amplify(AR, 0.3))
                .variable(2, CDDecrease, 2)
                .update(P315)
                .variable(1, MagicDamage, amplify(AR, 0.2));
        Q.update()
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。このスキルは自身が通常攻撃を行う毎にCDが1秒解消される。対象が敵チャンピオンの場合は3秒解消される。")
                .variable(1, RestoreHealth, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 84, 56, ap(0.84))
                .mana(80, 15)
                .cd(20, -1)
                .range(750);
        Q.update(P314)
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。")
                .variable(1, RestoreHealth, 60, 40, ap(0.3), amplify(BounusHealth, 0.05))
                .variable(2, RestoreHealth, 84, 56, ap(0.42), amplify(BounusHealth, 0.07))
                .mana(60, 20)
                .cd(18, -1);
        W.update()
                .passive("Taricは{1}を得て、味方チャンピオンの{1}を増加させる{2}のAuraを得る。(Taric自身はAuraと合わせて2倍の効果を得る)")
                .variable(1, AR, 10, 5)
                .variable(2, Radius, 1000)
                .active("{4}の敵ユニットに{5}を与え、4秒間{6}を与える。効果後はCDが解消されるまでPassiveのTaric自身の増加ARが無くなる。")
                .variable(4, Radius, 400)
                .variable(5, MagicDamage, 60, 45, ap(0.6))
                .variable(6, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(10);
        W.update(P303)
                .passive("Taricは{1}を得て、味方チャンピオンの{3}を増加させる{2}のAuraを得る。(Taric自身はAuraと両方の効果を得る)")
                .variable(3, AR, amplify(AR, 0.12))
                .variable(5, MagicDamage, 60, 45, ap(0.6), amplify(AR, 0.3))
                .mana(50);
        W.update(P304).variable(5, MagicDamage, 50, 40, ap(0.6), amplify(AR, 0.2));
        W.update(P314).variable(5, MagicDamage, 40, 40, amplify(AR, 0.3));
        W.update(P315)
                .variable(1, AR, 5, 5)
                .variable(3, AR, amplify(AR, 0.05))
                .variable(5, MagicDamage, 40, 40, amplify(AR, 0.2));
        E.update()
                .active("対象の敵ユニットに{1}と{2}を与える。魔法DMは対象との距離が近いほど増加し、距離が遠いほど低下する。最小DMは{3}。")
                .variable(1, MagicDamage, 80, 60, ap(0.8))
                .variable(2, Stun, 1.5)
                .variable(3, MagicDamage, 40, 30, ap(0.4))
                .mana(95)
                .cd(14, -1)
                .range(625);
        E.update(P303).mana(75);
        E.update(P304).variable(2, Stun, 1.2, 0.1);
        E.update(P314).variable(1, MagicDamage, 80, 60, ap(0.4)).variable(3, MagicDamage, 40, 30, ap(0.2)).cd(18, -1);
        R.update()
                .active("{1}の敵ユニットに{2}を与える。スキル使用後の10秒間、{3}と{4}を得て、更に近くの味方チャンピオンの{5}と{6}を増加させるAura({7})を展開する。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, AD, 30, 20)
                .variable(4, AP, 30, 20)
                .variable(5, AD, 15, 10)
                .variable(6, AP, 15, 10)
                .variable(7, Radius, 1000)
                .mana(100)
                .cd(60);
        R.update(P314).variable(2, MagicDamage, 150, 100, ap(0.5)).cd(75);
    }

    /**
     * Define skill.
     */
    public static void Talon(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("スロー、スタン、スネア、サプレッションを受けている状態の敵ユニットに対しては{1}する。").variable(1, AttackDamageRatio, 10);
        Q.update()
                .active("次の通常攻撃に{1}が付与される。対象がチャンピオンの場合、更に6秒間対象を出血させその間毎秒{2}を与える。また出血中の対象の{3}。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.3))
                .variable(2, PhysicalDamage, 10, 10, bounusAD(1))
                .variable(3, Visionable)
                .mana(40, 5)
                .cd(8, -1);
        W.update()
                .active("前方指定範囲に飛んだ後すぐ戻る刃を投げ当たった敵ユニットに{1}と2秒間{2}を与える。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 30, 25, bounusAD(0.6))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(10)
                .range(600);
        E.update()
                .active("対象の敵ユニットに跳躍し{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。")
                .variable(1, Silence, 1)
                .variable(2, DamageRatio, 3, 3)
                .mana(35, 5)
                .cd(18, -2)
                .range(700)
                .update(P401)
                .active("対象の敵ユニットの背後に跳躍し{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。");
        R.update()
                .active("周囲に8本の刃を投げ当たった敵ユニットに{1}を与え、同時に{2}になり{3}する。ステルスが解除される、または敵ユニットを攻撃すると刃がTalonの元に戻ってくる。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 120, 50, bounusAD(0.75))
                .variable(2, Stealth, 2.5)
                .variable(3, MSRatio, 40)
                .mana(80, 10)
                .cd(75, -10)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Teemo(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("2秒間動かないと{1}になる。何か行動を行うか、強制的に移動させられるとステルスが解除され、ステルス解除後3秒間{2}する。")
                .variable(1, Stealth)
                .variable(-2, ASRatio, 40);

        Q.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 45, ap(0.8))
                .variable(2, Blind, 1.5, 0.25)
                .mana(70, 10)
                .cd(8)
                .range(680);

        W.update()
                .passive("{1}する。敵チャンピオンかタワーからダメージを受けると5秒間効果が切れる。")
                .variable(1, MSRatio, 10, 4)
                .active("3秒間{1}し、Passiveの効果が切れることがなくなる。")
                .mana(40)
                .cd(17);

        E.update()
                .passive("通常攻撃時に{1}と毒が付与される。毒は4秒間持続し、毎秒{2}を与える。合計で{3}。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, MagicDamage, 6, 6, ap(0.1))
                .variable(3, MagicDamage, 34, 34, ap(0.7));

        R.update()
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒で{1}になる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と4秒間{4}を与える。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはチャンピオンの通常攻撃でのみダメージを与えられる。")
                .variable(1, Stealth)
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 200, 125, ap(0.8))
                .variable(4, MSSlowRatio, 30, 10)
                .variable(5, CDRAwareTime, 35, -4)
                .cd(1)
                .mana(75, 25)
                .range(230)
                .update(P312)
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒で{1}になる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と4秒間{4}を与える。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはチャンピオンの通常攻撃でのみダメージを与えられ、破壊すると{6}を得る。")
                .variable(6, Gold, 10)
                .update(P403)
                .variable(3, MagicDamage, 200, 125, ap(0.5));
    }

    /**
     * Define skill.
     */
    public static void Thresh(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("{1}で敵ユニットが死んだ場合、一定の確率で魂を落とす。魂へ近づくか" + W + "のランタンを魂の近くに置くとその魂を回収し、{2}と{3}を得る。落とした魂は15秒間持続し、敵チームがThreshの視界を得ていた場合、敵チームからも視認することができる。")
                .variable(1, Radius, 2000)
                .variable(2, AR, amplify(Stack, 1))
                .variable(3, AP, amplify(Stack, 1));
        P.update(P310).variable(2, AR, amplify(Stack, 0.75)).variable(3, AP, amplify(Stack, 0.75));
        Q.update()
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。")
                .variable(1, MagicDamage, 80, 30, ap(0.5))
                .variable(2, Stun, 1.5)
                .mana(80)
                .cd(18, -1.5)
                .range(1075);
        Q.update(P306).variable(1, MagicDamage, 80, 40, ap(0.5));
        Q.update(P312)
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。鎌が敵に命中した場合、このスキルの{3}する。")
                .variable(3, CDDecrease, 3)
                .cd(20, -2);
        W.update()
                .active("指定地点に6秒間持続するランタンを設置する。味方チャンピオンがランタンを指定すると、ランタンとその味方チャンピオンが自身の方へと引き寄せられる。更にランタンの周囲にいる魂を自動的に回収し、{1}の味方チャンピオンは{2}を得る。。シールドを得られるのは1ユニットにつき1回のみ。自身がランタンから距離1500以上離れるとランタンは自動的に自身の下へと戻る。")
                .variable(1, Radius)
                .variable(2, Shield, 60, 40, ap(0.4))
                .mana(40)
                .cd(22, -1.5)
                .range(950);
        E.update()
                .active("自身後方から前方への帯状領域内の敵ユニットに{1}を与える。また自身後方にいる敵ユニットは自身に近づく向きに、自身前方にいる敵ユニットには自身から遠ざかる向きにノックバックさせ、1.5秒間{2}を与える。")
                .variable(1, MagicDamage, 65, 40, ap(0.4))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(9)
                .range(400);
        E.update(P306)
                .passive("通常攻撃に{3}を付与する。このDMはDamnationのスタック数と、自身が前回敵ユニットに通常攻撃をしてから経過した時間に比例して増加する。建物を攻撃した場合は追加魔法DMは発生せず、時間がリセットされる事もない。")
                .variable(2, MagicDamage, 65, 30, ap(0.4))
                .variable(3, MagicDamage, amplify(Stack, 1));
        R.update()
                .active("{5}後、{4}に五角形の壁を創り出し、最初に壁に触れた敵チャンピオンに{1}と2秒間{2}を与える。2つ目以降の壁に触れた敵チャンピオンには{3}と1秒間{2}を与える。敵が触れた部分の壁は破壊され消滅する。")
                .variable(1, MagicDamage, 250, 150, ap(1))
                .variable(2, MSSlowRatio, 99)
                .variable(3, MagicDamage, 125, 75, ap(0.5))
                .variable(4, Radius, 450)
                .variable(5, Time, 0.5)
                .mana(100)
                .cd(150, -10)
                .update(P401)
                .variable(5, Time, 0.75);
    }

    /**
     * Define skill.
     */
    public static void Tristana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("通常攻撃とExplosive Shotは追加の{1}を得る。").variable(1, Range, new Per1Level(0, 9));
        Q.update().active("7秒間{1}する。").variable(1, ASRatio, 30, 15).mana(50).cd(20);
        W.update()
                .active("指定地点にジャンプしジャンプ先の{1}の敵ユニットに{2}と2.5秒間{3}を与える。キルかアシストをとるとこのスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .variable(3, MSSlowRatio, 60)
                .variable(4, CDDecrease)
                .mana(80)
                .cd(22, -2)
                .range(800);
        E.update()
                .passive("通常攻撃で敵ユニットを倒した時にそのユニットの{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 50, 25, ap(0.25))
                .active("対象の敵ユニットに5秒かけて{3}と{4}を与える。")
                .variable(3, MagicDamage, 110, 40, ap(1))
                .variable(4, Wounds)
                .mana(50, 10)
                .cd(16)
                .range(new Diff(616, 0, 1), level(9));
        R.update()
                .active("対象の敵ユニットに{1}を与え、対象と{2}の敵ユニットを{3}させる。")
                .variable(1, MagicDamage, 300, 100, ap(1.5))
                .variable(2, Radius, 200)
                .variable(3, Knockback, 600, 200)
                .mana(100)
                .cd(60)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Trundle(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("{1}以内で敵ユニットが死んだとき、{2}する。")
                .variable(1, Radius, 1000)
                .variable(2, RestoreHealth, amplify(TargetMaxHealthRatio, new Per4LevelForTrundle(2, 1)));
        Q.update()
                .active("次の通常攻撃で与えるダメージは{1}になる。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 30, 15, amplify(AD, 0.8, 0.1))
                .variable(2, AD, 20, 5)
                .variable(3, ADReduction, 10, 2.5)
                .mana(30)
                .cd(4);
        Q.update(P306)
                .active("次の通常攻撃は{1}と0.1秒間{4}を与える。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 20, 20, amplify(AD, 1, 0.05))
                .variable(4, MSSlowRatio, 75);
        W.update()
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}して{4}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, ASRatio, 20, 10)
                .variable(3, MSRatio, 20, 5)
                .variable(4, Tenacity, 20, 5)
                .mana(60)
                .cd(15)
                .range(900);
        W.update(P306)
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}、{4}する。")
                .variable(2, ASRatio, 20, 15)
                .variable(4, RestoreHealthRatio, 8, 3);
        E.update()
                .active("指定地点に{0}間持続する通行不可能なビーコンを設置し、ビーコンの{1}にいる敵ユニットに{2}を与える。また、{3}の視界を得る。")
                .variable(0, Time, 7)
                .variable(1, Radius, 375)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Radius, 1200)
                .mana(60)
                .cd(23, -3)
                .range(1000);
        E.update(P306).variable(0, Time, 6);
        R.update()
                .active("対象の敵ユニットに{1}を{2}、{3}を与える。その後6秒間かけて更に{1}と{2}、{3}を与える。このスキルでダメージを与えると{4}する。")
                .variable(1, MagicDamage, 100, 75, ap(0.6))
                .variable(2, ARReductionRatio, 15, 5)
                .variable(3, MRReductionRatio, 15, 5)
                .variable(4, RestoreHealth, amplify(DealtDamage, 1))
                .mana(75)
                .cd(80, -10)
                .range(700);
        R.update(P306)
                .active("対象の敵ユニットに{1}を与え、4秒間かけて{2}、{3}を与えて減少させた分の値を自身のARとMRに加算する、この効果はその後4秒間持続する。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 20, 2, ap(0.02)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, MRReductionRatio, 20);
    }

    /**
     * Define skill.
     */
    public static void Tryndamere(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("{1}する。通常攻撃時に5Fury、クリティカル時に10Fury、Spinning Slashが敵ユニットに命中するたびに2Furyを得る。敵ユニットを倒すと追加で10Furyを得る。Furyの上限は100、8秒間戦闘を行わないと毎秒5Furyずつ減少していく。建物を攻撃した場合はFuryは増加しない。")
                .variable(-1, Critical, amplify(Stack, 0.35));
        Q.update()
                .passive("{1}を得る。")
                .variable(1, AD, 5, 5, amplify(MissingHealthPercentage, 0.15, 0.05))
                .active("Furyをすべて消費し{2}する。")
                .variable(2, RestoreHealth, 30, 10, ap(1.5), amplify(Stack, 0.5, 0.45))
                .cd(12);
        Q.update(P303).variable(2, RestoreHealth, 30, 10, ap(0.3), amplify(Stack, 0.5, 0.45, ap(0.012)));
        W.update()
                .active("4秒間近くの敵チャンピオンに{1}を与え、後ろを向いている敵チャンピオンには更に4秒間{2}を与える。")
                .variable(1, ASSlowRatio, 20, 15)
                .variable(2, MSSlowRatio, 30, 7.5)
                .cd(14)
                .range(850);
        E.update()
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。")
                .variable(1, PhysicalDamage, 70, 30, ap(1), bounusAD(1.2))
                .variable(2, CDDecrease, 2)
                .cd(13, -1)
                .range(660);
        E.update(P313)
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。(ミニオンやモンスターに対して発生した場合は{3}する)")
                .variable(3, CDDecrease, 1);
        R.update()
                .active("5秒間HPが1未満にならなくなる(死ななくなる)。また、このスキル使用時にFuryが{1}増加する。このスキルの使用は状態異常によって阻害されない。")
                .variable(1, Count, 50, 25)
                .cd(110, -10);
    }

    /**
     * Define skill.
     */
    public static void TwistedFate(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("味方チャンピオンが敵を倒した時に追加で{1}を得るようになる。").variable(1, Gold, 2);
        P.update(P310).passive("ユニットを倒すたびに追加の{1}(1~6でランダム、但し期待値は3.5よりも大きくなる)を得る。").variable(1, Gold);
        Q.update()
                .active("指定向き3方向に貫通するカードを飛ばし、当たった敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.65))
                .mana(60, 10)
                .cd(6)
                .range(1450);
        W.update()
                .active("使用するとBlue、Red、Goldの3種のカードを選択し始め、再度使用でカードが決定する。決定したカードにより次の通常攻撃が魔法DMに変換され、以下の効果が追加される。<br>Blue Card: {2}を与え{3}する。<br>Red Card: {4}の敵に{5}と2.5秒間{6}を与える。<br>Gold Card: {7}と{8}を与える。")
                .variable(2, MagicDamage, 40, 20, ap(0.4), ad(1))
                .variable(3, RestoreMana, 26, 13, ad(0.65))
                .variable(4, Radius, 100)
                .variable(5, MagicDamage, 30, 15, ap(0.4), ad(1))
                .variable(6, MSSlowRatio, 30, 5)
                .variable(7, MagicDamage, 15, 7.5, ap(0.4), ad(1))
                .variable(8, Stun, 1.2, 0.2)
                .mana(40, 15)
                .cd(6);
        W.update(P307).variable(3, RestoreMana, 50, 25);
        W.update(P310)
                .active("3種類のカードが順番に出現し、8秒以内に再度使用してカードを決定する。4秒以内の次の通常攻撃が魔法DMに変換され、以下の効果が追加される。<br>Blue Card: {2}を与え{3}する。<br>Red Card: {4}の敵に{5}と2.5秒間{6}を与える。<br>Gold Card: {7}と{8}を与える。");
        E.update()
                .passive("{1}を得て{2}する。通常攻撃4回毎に追加{3}を与える。")
                .variable(1, CDR, 3, 3)
                .variable(2, ASRatio, 3, 3)
                .variable(3, MagicDamage, 55, 25, ap(0.4));
        E.update(P307).passive("{2}する。通常攻撃4回毎に追加{3}を与える。").variable(2, ASRatio, 10, 5);
        R.update()
                .active("{1}間すべての敵チャンピオン(ステルス中のチャンピオン含む)の視界を得る。効果中に再度使用すると2秒間移動・攻撃が不可能になった後、指定した地点にワープする。。効果中は敵チャンピオンの頭上にアイコンが表示される。")
                .variable(1, Time, 6, 2)
                .mana(150, -25)
                .cd(150, -15)
                .range(5500);
        R.update(P307).cd(180, -30);
    }

    /**
     * Define skill.
     */
    public static void Twitch(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("通常攻撃時に毒を付与し、６秒間かけて{1}を与える。毒は6回までスタックする。").variable(1, TrueDamage, new Per5Level(12, 12));
        Q.update()
                .active("使用から1.25秒後に{1}になる。ステルス状態では{2}し、ステルスを解除すると5秒間{3}する。ステルス準備中に攻撃を行うかダメージを受けると、ステルス状態になるのに再度1.25秒必要になる。ステルス準備開始から5秒経過するとダメージを受けていてもステルス状態になる。")
                .variable(1, Stealth, 4, 1)
                .variable(2, MSRatio, 20)
                .variable(3, ASRatio, 30, 10)
                .mana(60);
        W.update()
                .active("指定地点に{1}で毒の入った瓶を投げつけ、範囲内の敵ユニットに3秒間{2}と毒を2スタック分与える。また、指定した地点の{3}。")
                .variable(1, MissileSpeed, 1400)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Visionable)
                .mana(50)
                .cd(13, -1)
                .range(950);
        E.update()
                .active("毒をスタックされている{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 1200)
                .variable(2, PhysicalDamage, 40, 10, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)))
                .mana(50, 10)
                .cd(12, -1);
        E.update(P310A).variable(2, PhysicalDamage, 20, 15, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)));
        R.update()
                .active("7秒間射程が850になり{1}を得て、通常攻撃が敵ユニットを貫通するようになる。対象との直線上にいる敵ユニットにもダメージと毒スタックを与える。ダメージは敵に当たるごとに20%減少する。最小で40%。")
                .variable(1, AD, 20, 8)
                .mana(100, 25)
                .cd(120, -10);
    }

    /**
     * Define skill.
     */
    public static void Udyr(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("スキルを使用する度に{1}、{2}、{3}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。")
                .variable(-1, ASRatio, 10)
                .variable(-2, ARRatio, 4)
                .variable(-3, MRRatio, 4);
        P.update(P305)
                .passive("スキルを使用する度に{1}、{4}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。")
                .variable(4, MS, 5);
        Q.update()
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで{1}する。")
                .variable(-1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 30, 50, ad(1.5))
                .variable(3, ASRatio, 15, 5)
                .mana(55, -5)
                .cd(6);
        Q.update(P305).mana(47, -3);
        Q.update(P306)
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで通常攻撃は追加{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.15))
                .variable(2, PhysicalDamage, 30, 50, amplify(AD, 1.2, 0.1))
                .variable(3, ASRatio, 30, 10);
        W.update()
                .active("5秒間{1}を得る。別のスキルを使うまで通常攻撃でクリティカルが発生しなくなるが、通常攻撃するごとに{2}し{3}する。")
                .variable(1, Shield, 60, 36, ap(0.5))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 10, 2))
                .variable(3, RestoreMana, amplify(DealtDamageRatio, 5, 1))
                .mana(55, -5)
                .cd(6);
        W.update(P305).active("5秒間{1}を得る。別のスキルを使うまで通常攻撃するごとに{2}する。").variable(1, Shield, 60, 40, ap(0.5)).mana(47, -3);
        E.update()
                .active("{1}間{2}する。別のスキルを使うまで通常攻撃は{3}を与える。この効果は同一の対象に6秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.5)
                .variable(2, MSRatio, 15, 3)
                .variable(3, Stun, 1)
                .mana(55, -5)
                .cd(6);
        E.update(P305)
                .active("{1}間{2}し{4}を得る。別のスキルを使うまで通常攻撃は{3}を与える。この効果は同一の対象に6秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.25)
                .variable(2, MSRatio, 15, 5)
                .variable(4, IgnoreUnitCollision)
                .mana(47, -3);
        R.update()
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、{2}と{3}を得る。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(1, MagicDamage, 15, 10, ap(0.25))
                .variable(2, AD, 8, 4)
                .variable(3, AP, 16, 8)
                .variable(4, MagicDamage, 40, 40, ap(0.25))
                .mana(55, -5)
                .cd(6);
        R.update(P305)
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、次の通常攻撃に前方の敵ユニットに{4}を与える効果を付与する。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(4, MagicDamage, 40, 40, ap(0.45))
                .mana(47, -3);
    }

    /**
     * Define skill.
     */
    public static void Urgot(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("通常攻撃またはAcid Hunterでダメージを与えた対象に、与えるダメージを15%低下するDebuffを付与する。この効果は2.5秒間持続する。");
        Q.update()
                .active("指定方向にミサイルを飛ばし当たった敵ユニットに{1}を与える。Noxian Corrosive Chargeの効果を受けている敵ユニットの近くを指定して使用すると、その敵ユニット目掛けてミサイルが飛んでいく。")
                .variable(1, PhysicalDamage, 10, 30, ad(0.85))
                .mana(40)
                .cd(2)
                .range(1000);
        W.update()
                .active("7秒間{1}を得る。シールドが残っている間は通常攻撃とAcid Hunterに1秒間{2}が付与される。")
                .variable(1, Shield, 80, 40, ap(0.8))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(55, 5)
                .cd(16, -1);
        E.update()
                .active("指定地点に爆弾を飛ばし{1}の敵ユニットに5秒間かけて{2}と{3}を与える。また指定地点の{4}。")
                .variable(1, Radius, 300)
                .variable(2, PhysicalDamage, 75, 55, bounusAD(0.6))
                .variable(3, MSSlowRatio, 12, 2)
                .variable(4, Visionable)
                .mana(50, 5)
                .cd(15, -1)
                .range(900);
        R.update()
                .active("対象の敵チャンピオンに{1}を与え、5秒間{2}と{3}を得る。1秒詠唱後に敵チャンピオンと自分の位置を入れ替え、敵チャンピオンに3秒間{4}を与える。")
                .variable(1, Suppression, 1)
                .variable(2, AR, 60, 30)
                .variable(3, MR, 60, 30)
                .variable(4, MSSlowRatio, 40)
                .mana(120)
                .cd(120)
                .range(550, 150);
    }

    /**
     * Define skill.
     */
    public static void Varus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("敵ユニットを倒すと3秒間{1}する。敵チャンピオンをキル/アシストすると6秒間{2}する。この効果はスタックしない。")
                .variable(-1, ASRatio, 20)
                .variable(-2, ASRatio, 40);
        Q.update()
                .active("最初にスキルを使用すると狙いを付ける。この間は通常攻撃や他のスキルを使用できなくなり、Varusの移動速度が20%低下するが、狙いを付けている間は徐々にこのスキルのダメージと射程距離が増加していく(2秒で最大)。再度このスキルを使用することで指定方向に貫通する矢を放ち、当たった敵ユニットに{1}を与える(最大で{2})。ダメージは敵に当たるごとに15%減少する。最小で33%。狙いを付けて4秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, PhysicalDamage, 10, 33, ad(1))
                .variable(2, PhysicalDamage, 15, 50, ad(1.65))
                .mana(70, 5)
                .cd(16, -2)
                .range(new Diff(850, 0, 1), amplify(Duration, 200));
        Q.update(P307).variable(1, PhysicalDamage, 10, 37, ad(1)).variable(2, PhysicalDamage, 15, 55, ad(1.65));
        W.update()
                .passive("通常攻撃に追加{1}と6秒間持続する疫病が付与される。疫病は3回までスタックする。疫病のスタックが付与されている敵ユニットにVarusの他のスキルが命中した場合、疫病のスタックを全て消費して1スタック毎に{2}を与える。")
                .variable(1, MagicDamage, 10, 4, ap(0.25))
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 2, 0.75, ap(0.02)));
        E.update()
                .active("指定地点に矢の雨を放ち、範囲内の敵ユニットに{1}を与える。指定地点は4秒間呪われ、範囲内の敵ユニットに{2}と{3}を付与する。")
                .variable(1, PhysicalDamage, 65, 40, bounusAD(0.6))
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Wounds)
                .mana(80)
                .cd(18, -2)
                .range(925);
        E.update(P307).variable(1, PhysicalDamage, 65, 35, bounusAD(0.6));
        R.update()
                .active("指定方向に腐敗の蔓を投げつけ、当たった敵チャンピオンに{1}と{2}を与える。当たった敵チャンピオンからは徐々に腐敗が広がり({3})、腐敗に触れた敵チャンピオンにも同様の効果を与える。")
                .variable(1, MagicDamage, 150, 100, ap(1))
                .variable(2, Snare, 2)
                .variable(3, Radius, 550)
                .mana(120)
                .cd(120, -15)
                .range(1075);
        R.update(P313).mana(100);
    }

    /**
     * Define skill.
     */
    public static void Vayne(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514).passive("敵チャンピオンに向かって移動する際に{1}する。").variable(-1, MS, 30);

        Q.update(P514)
                .active("指定地点にローリングし、次の通常攻撃に{1}を付与する。6秒間攻撃を行わないとCDになる。")
                .variable(1, PhysicalDamage, amplify(AD, 0.3, 0.05))
                .range(300)
                .mana(30)
                .cd(6, -1);

        W.update(P514)
                .passive("同じターゲットに3回連続して通常攻撃またはスキルで攻撃すると、{1}を与える。（モンスターやミニオンに対しては上限200）")
                .variable(1, TrueDamage, 20, 10, amplify(TargetMaxHealthRatio, 4, 1));

        E.update(P514)
                .active("対象の敵ユニットをヘビークロスボウで狙撃し{1}と{2}を与える。ノックバックした敵が壁等に当たると追加で{1}と{3}を与える。")
                .variable(1, PhysicalDamage, 45, 35, bounusAD(0.5))
                .variable(2, Knockback, 470)
                .variable(3, Stun, 1.5)
                .mana(90)
                .cd(20, -2)
                .range(550);

        R.update(P514)
                .active("{1}間{2}を得て、" + Q + "を使うと{3}になり、" + P + "の移動速度増加が3倍になる。")
                .variable(1, Time, 8, 2)
                .variable(2, AD, 30, 20)
                .variable(3, Stealth, 1)
                .mana(80)
                .cd(100, -15);
    }

    /**
     * Define skill.
     */
    public static void Veigar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("{1}する。").variable(1, MregRatio, amplify(MissingManaPercentage, 0.01));
        Q.update()
                .passive("敵チャンピオンを倒すと{1}を得る。")
                .variable(-1, AP, 1, 1)
                .active("対象の敵ユニットに{2}を与える。このスキルでLHを取るとAPが1増加する。対象が敵チャンピオン/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+2)になる。")
                .variable(2, MagicDamage, 80, 45, ap(0.6))
                .mana(60, 5)
                .cd(8, -1)
                .range(650);
        W.update()
                .active("指定地点に1.2秒後に隕石を降らし、{1}の敵ユニットに{2}を与える。また隕石が落下するまでの間、指定地点の{3}。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 120, 50, ap(1))
                .variable(3, Visionable)
                .mana(70, 10)
                .cd(10)
                .range(900);
        E.update()
                .active("指定した{1}に3秒間魔法陣を呼び出し、魔法陣の縁に触れた敵ユニットに{2}を与える。")
                .variable(1, Radius, 425)
                .variable(2, Stun, 1.5, 0.25)
                .mana(80, 10)
                .cd(20, -1)
                .range(600);
        R.update()
                .active("対象の敵チャンピオンに{1}を与える。")
                .variable(1, MagicDamage, 250, 125, ap(1.2), amplify(TargetAP, 0.8))
                .mana(125, 50)
                .cd(130, -20)
                .range(650);
    }

    /**
     * Define skill.
     */
    public static void Velkoz(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P403)
                .passive("スキルで敵ユニットにダメージを与える度に対象にスタックを付与し、対象のスタックが3になるとスタックを全て消費して{1}を与える。スタックは7秒間持続する。通常攻撃を行うと、既に存在しているスタックの持続時間を7秒に戻す。")
                .variable(1, TrueDamage, 25, 0, level(10));

        Q.update(P403)
                .active("指定方向にプラズマを放ち、当たった敵ユニットに{1}と{2}かけて減衰する{3}を与える。スキルを再使用するか、プラズマが敵ユニットに命中するとプラズマが90度の方向に分裂し、分裂したプラズマに当たった敵ユニットにも同様の効果を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.6))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 70)
                .mana(40, 5)
                .cd(7)
                .range(1050);

        W.update(P403)
                .active("スタックを1消費して、ビームで指定方向に裂け目を発生させ、直線状にいる敵ユニットに{1}を与える。裂け目は0.25秒後に爆発し、{2}にいる敵ユニットに{3}を与える。スタックは{4}毎に増加する（最大2）。")
                .variable(1, MagicDamage, 30, 20, ap(0.25))
                .variable(2, Radius)
                .variable(3, MagicDamage, 45, 30, ap(0.375))
                .variable(4, CDRAwareTime, 19, -1)
                .mana(50, 5)
                .cd(-1.5)
                .range(1050);

        E.update(P403)
                .active("指定地点を爆発させ、{1}の敵ユニットに{2}と{3}を与える。命中した敵はVel'Kozから遠ざかるように吹き飛ぶ。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 30, ap(0.5))
                .variable(3, Suspension, 0.75)
                .mana(50, 5)
                .cd(16, -1)
                .range(850);

        R.update(P403)
                .active("最大2.5秒間カーソルの場所目掛けて貫通するレーザーを放ち、0.25秒毎に{1}にいる敵ユニットに{2}と1秒間{3}を与える（2.5秒間当て続けた場合は{4}）。また0.5秒毎に" + P + "のスタックが増加する。スキルを再使用することで中断できる。ミニオン(モンスターには無効)に対しては500%のダメージを与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 50, 20, ap(0.06))
                .variable(3, MSSlowRatio, 20)
                .variable(4, MagicDamage, 500, 200, ap(0.6))
                .mana(100)
                .cd(130, -20)
                .range(1575)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Viktor(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("Hex Coreという、自身のステータスとスキルの効果を強化するアイテムを所持している。Hex Coreは1度だけショップで1000Gを消費して以下の３通りのいずれかにアップグレードすることが出来る。Hex CoreはViktorのアイテムスロットを1つ占有し、売却することは出来ない。<br>Hex Core : {1}を得る。<br>Augment Power : {1}、{2}、{3}を得る。また、Power Transfer使用・命中時に移動速度が3秒間30%増加する。<br>Augment Gravity : {1}、{4}、{5}、{6}を得る。また、Gravity Fieldの射程が30%増加する。<br>Augment Death : {1}、{7}を得る。また、Death Rayにダメージの30%分の追加魔法DMが付与される。このダメージは4秒間かけて与える。")
                .variable(-1, AP, level(3))
                .variable(-2, Health, 220)
                .variable(-3, Hreg, 6)
                .variable(-4, Mana, 200)
                .variable(-5, CDR, 10)
                .variable(-6, Mreg, 5)
                .variable(-7, AP, 45);
        Q.update()
                .active("対象の敵ユニットに{1}を与え、3秒間{2}を得る。")
                .variable(1, MagicDamage, 80, 45, ap(0.65))
                .variable(2, Shield, amplify(DealtDamageRatio, 40))
                .mana(45, 5)
                .cd(9, -1)
                .range(600);
        W.update()
                .active("0.25秒詠唱後、指定範囲に4秒間持続する重力束縛装置を呼び出し、範囲内の敵ユニットに{1}を与え、0.5秒毎にスタックを付与する。スタックが3溜まった敵ユニットに{2}を与える。")
                .variable(1, MSSlowRatio, 28, 4)
                .variable(2, Stun, 1.5)
                .mana(65)
                .cd(17, -1)
                .range(625);
        E.update()
                .active("指定地点から指定方向にビームを発射し、ビームが通過する線上の敵ユニットに{1}を与える。また、ビームが通過した地点の{2}。")
                .variable(1, MagicDamage, 70, 45, ap(0.7))
                .variable(2, Visionable)
                .mana(70, 10)
                .cd(13, -1)
                .range(700);
        R.update()
                .active("指定地点に7秒間持続する特異点を呼び出し、{1}の敵ユニットに{2}と{3}を与える。特異点は周囲の敵ユニットに毎秒{4}を与え、また近くにいる敵チャンピオンを自動的に追尾する。このスキルがActiveの間に再度地点を指定することで、特異点を指定した地点に手動で移動させる事が出来る。最大で{5}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 150, 100, ap(0.55))
                .variable(3, Silence, 0.5)
                .variable(4, MagicDamage, 40, 20, ap(0.25))
                .variable(5, MagicDamage, 430, 240, ap(2.23))
                .mana(125, 50)
                .cd(120)
                .range(700);
        R.update(P313).mana(100);
    }

    /**
     * Define skill.
     */
    public static void Vi(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("敵ユニットにスキルでダメージを与えると、3秒間{1}を得る。")
                .variable(1, Shield, amplify(Health, 0.1))
                .cd(new Per6LevelForVi(18, -5));
        Q.update()
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵チャンピオンに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.7))
                .variable(2, PhysicalDamage, 100, 60, bounusAD(1.4))
                .variable(3, Distance, 50)
                .variable(4, Distance, 600)
                .mana(50, 10)
                .cd(18, -2.5)
                .range(50);
        Q.update(P303)
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵チャンピオンに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。途中で詠唱を停止させられた場合、このスキルのCDは3秒になり、消費したmanaの半分が回復する。");
        W.update()
                .passive("同一対象に3回連続して通常攻撃を行うと、{1}と4秒間{2}を与え、4秒間{3}する。(ミニオンやモンスターへは最大300DMを与える)")
                .variable(1, PhysicalDamage, amplify(TargetMaxHealthRatio, 6, 1, bounusAD(0.03)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, ASRatio, 30, 5);
        W.update(P303).variable(1, PhysicalDamage, amplify(TargetMaxHealthRatio, 4, 1.5, bounusAD(0.03)));
        E.update()
                .active("チャージを1つ消費することで、次の通常攻撃に追加{1}を付与し、対象とその後方扇形{2}にいる敵ユニットにもダメージを与える範囲攻撃になる。チャージは{3}毎に増加し、最大2つまでスタックされる。")
                .variable(1, PhysicalDamage, 5, 15, ad(1.15), ap(0.7))
                .variable(2, Radius, 600)
                .variable(3, CDRAwareTime, 14, -1.5)
                .mana(60)
                .cd(1);
        R.update()
                .active("対象の敵チャンピオンに突撃し、{1}と{2}を与える。一連の動作中は{4}を得て、また対象のチャンピオン以外でViに触れた敵ユニットには{3}を与え、左右に吹き飛ばす。")
                .variable(1, PhysicalDamage, 200, 125, bounusAD(1.4))
                .variable(2, Knockup, 1.25)
                .variable(3, PhysicalDamage, 150, 112.5, bounusAD(1.05))
                .variable(4, IgnoreCC)
                .mana(100, 25)
                .cd(130, -25)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Vladimir(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive(BounusHealth + "に比例して{1}を、" + AP + "に比例して{2}を得る。")
                .variable(1, AP, amplify(BounusHealth, 0.025))
                .variable(2, Health, 0, 0, ap(1.4));
        Q.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。")
                .variable(1, MagicDamage, 90, 35, ap(0.6))
                .variable(2, RestoreHealth, 15, 10, ap(0.25))
                .cd(10, -1.5)
                .range(600);
        W.update()
                .active("Vladimirが2秒間血の海に沈む。その間はターゲットされなくなり、{1}内にいる敵ユニットに0.5秒毎に{2}と{3}間の{4}を与え続ける。また、与えたダメージの12.5%Healthが回復する。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 20, 13.75, amplify(BounusHealth, 0.00375))
                .variable(3, Time, 1)
                .variable(4, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 20, 0)
                .cd(26, -3);
        E.update()
                .active("{1}の敵ユニットに{2}を与える。使用する度にスタックが増加し、1スタックにつきこのスキルの基礎魔法DMとHPコストが25%増加し、{4}するく(最大4スタック)。スタックは10秒増加が無いと0になる。このスキルは周囲に敵ユニットがいなくても使用可能。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 60, 25, ap(0.45))
                .variable(4, RestoreHealthRatio, 4, 1)
                .cost(Health, 30, 10)
                .cd(4.5)
                .range(620);
        R.update()
                .active("指定地点の{1}の敵ユニットに疫病を付与し、その敵ユニットは5秒間受けるダメージが12%増加する。効果終了時に{2}を与える。ダメージ増加効果のため実際には{3}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MagicDamage, 168, 112, ap(0.784))
                .cd(150, -15)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Volibear(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("VolibearのHPが30%以下になったとき、6秒間かけて{1}する。{2}。")
                .variable(1, RestoreHealth, amplify(Health, 0.3))
                .variable(2, CDRUnaware)
                .cd(-120);
        Q.update()
                .active("4秒間{1}する。敵チャンピオンに向かって移動する場合は{2}する。また次の通常攻撃に追加{3}を付与し、対象をVolibearの後ろに投げ飛ばす。4秒間攻撃を行わないとCDになる。")
                .variable(1, MSRatio, 15)
                .variable(-2, MSRatio, 45)
                .variable(3, PhysicalDamage, 30, 30)
                .mana(40)
                .cd(12, -1);
        Q.update(P3051).variable(-2, MSRatio, 30, 5);
        W.update()
                .passive("通常攻撃でダメージを与える度にスタックが1増加し(最大3スタック)、{1}する。スタックは4秒持続する。")
                .variable(-1, ASRatio, amplify(Stack, 8, 3))
                .active("スタックが最大まで溜まった時のみ使用可能。対象の敵ユニットに{2}を与える。対象が失っているHP1%につきダメージが1%上昇する。")
                .variable(2, PhysicalDamage, 80, 45, amplify(BounusHealth, 0.15))
                .mana(35)
                .cd(17)
                .range(400);
        E.update()
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。対象がMinionの場合、さらに{4}を与える。")
                .variable(1, Radius, 425)
                .variable(2, MagicDamage, 60, 45, ap(0.6))
                .variable(3, MSSlowRatio, 30, 5)
                .variable(4, Fear, 3)
                .mana(60, 5)
                .cd(11);
        R.update()
                .active("12秒間Volibearが通常攻撃した対象に雷を放ち{1}を与える。雷は対象の{2}の敵ユニット(敵チャンピオンを優先)3体にも連鎖し同様のダメージを与える。建物を攻撃する時は効果は発生しない。")
                .variable(1, MagicDamage, 75, 40, ap(0.3))
                .variable(2, Radius, 300)
                .mana(100)
                .cd(100, -10);
    }

    /**
     * Define skill.
     */
    public static void Warwick(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("通常攻撃で対象にスタックを付与し、追加{1}を与え{2}する。スタックは4秒持続し、最大3つまでスタックされる。建物を攻撃した場合は無効。")
                .variable(1, MagicDamage, amplify(Stack, new Per1Level(new double[] {3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7,
                        8, 9, 10, 11, 12, 13, 14, 15, 16})))
                .variable(2, RestoreHealth, amplify(Stack, new Per1Level(new double[] {3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5,
                        7, 8, 9, 10, 11, 12, 13, 14, 15, 16})));
        Q.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。対象がチャンピオンの場合は{3}と比較し大きいほうのDMを与える。")
                .variable(1, MagicDamage, 75, 50, ap(1))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 80))
                .variable(3, MagicDamage, 0, 0, ap(1), amplify(TargetMaxHealthRatio, 8, 2))
                .mana(70, 10)
                .cd(10, -1)
                .range(400);
        W.update()
                .active("10秒間{2}し、{1}の味方チャンピオンは{3}する。")
                .variable(1, Radius, 1200)
                .variable(2, ASRatio, 40, 10)
                .variable(-3, ASRatio, 20, 5)
                .mana(35)
                .cd(24, -2);
        E.update()
                .passive("{1}して、{2}内にいるHPが50%以下の敵チャンピオンの{3}。このスキルで敵のステルスを看破する事はできず、ステルス中の敵チャンピオンの視界を得ることもできない。")
                .variable(1, MSRatio, 20, 5)
                .variable(2, Radius, 1500, 800)
                .variable(3, Visionable)
                .cd(4);
        R.update()
                .active("対象の敵チャンピオンに突撃し{2}を与えて、その間{3}を得て0.42秒毎に{1}を、計5回で{4}を与える。{5}。")
                .variable(1, MagicDamage, 50, 17, bounusAD(0.4))
                .variable(2, Suppression, 1.8)
                .variable(3, LS, 30)
                .variable(4, MagicDamage, 250, 85, bounusAD(2))
                .variable(5, OnHitEffect)
                .type(SkillType.Channel)
                .mana(100, 25)
                .cd(90, -10)
                .range(700);
        R.update(P307).active("対象の敵チャンピオンに突撃し{2}を与えて、その間{3}を得て0.3秒毎に{1}を、計5回で{4}を与える。{5}。");

    }

    /**
     * Define skill.
     */
    public static void MonkeyKing(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("Wukongの視界内{1}にいる敵チャンピオンの数に比例して、{2}と{3}を得る。")
                .variable(1, Radius, 1400)
                .variable(2, AR, amplify(EnemyChampion, new Per6Level(4, 2)))
                .variable(3, MR, amplify(EnemyChampion, new Per6Level(4, 2)));
        Q.update()
                .active("次の通常攻撃は射程が125増加して追加の{1}と3秒間の{2}を与える。")
                .variable(1, PhysicalDamage, 30, 30, ad(0.1))
                .variable(2, ARReductionRatio, 30)
                .mana(40)
                .cd(9, -1)
                .range(300);
        W.update()
                .active("{1}になり{2}を得る。同時にWukongがいた場所に分身(操作不可能)を作り出す。分身は1.5秒経過すると消滅し、その際に分身の{3}の敵に{4}を与える。")
                .variable(1, Stealth, 1.5)
                .variable(2, IgnoreUnitCollision)
                .variable(3, Radius, 350)
                .variable(4, MagicDamage, 70, 45, ap(0.6))
                .mana(50, 5)
                .cd(18, -2);
        E.update()
                .active("対象の敵ユニットまでダッシュし{1}を与える。対象の敵ユニットの{3}の敵ユニット2体にもWukongの幻影が飛び、{1}を与える。また、スキル使用後4秒間{2}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.8))
                .variable(2, ASRatio, 30, 5)
                .variable(3, Radius, 325)
                .mana(45, 5)
                .cd(8)
                .range(625);
        R.update()
                .active("4秒間Wukongが回転する。回転中は{1}の敵ユニットに0.5秒毎に{2}と{3}を与える。打ち上げ効果は同一の対象に1度までしか発生しない。また、このスキルを使用してから0.5秒毎に{5}する。最大で{4}を与え、{6}する。")
                .variable(1, Radius, 325)
                .variable(2, PhysicalDamage, 10, 45, ad(0.6))
                .variable(3, Knockup, 1.5)
                .variable(4, PhysicalDamage, 80, 360, ad(4.8))
                .variable(-5, MSRatio, 5)
                .variable(6, MSRatio, 40)
                .mana(100)
                .cd(120, -15);
    }

    /**
     * Define skill.
     */
    public static void Xerath(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("{1}を得る。")
                .variable(1, AR, 0, 0, ap(0.15))
                .update(P402)
                .passive("通常攻撃を行うと{1}する。チャンピオンを攻撃した場合は回復量が2倍になる。建物に対しては無効。")
                .variable(1, RestoreMana, new Per1Level(new double[] {30, 33, 36, 42, 48, 54, 6372, 81, 90, 102, 114,
                        126, 138, 150, 165, 180.195}))
                .cd(-12);
        Q.update()
                .active("0.75秒詠唱後指定方向にビームを放ち、直線状の敵ユニットすべてに{1}を与える。")
                .variable(1, MagicDamage, 75, 40, ap(0.6))
                .mana(65, 5)
                .cd(7, -0.5)
                .range(900)
                .update(P402)
                .active("最初にスキルを使用するとチャージを行う。この間は通常攻撃や他のスキルを使用できなくなり、移動速度が徐々に低下(最大で-50%)するが、チャージしている間は徐々にこのスキルの射程距離が増加していき、1.5秒後に最大射程1400に到達。再度このスキルを使用することで指定方向に電撃を放ち、直線状にいる敵ユニットに{1}を与える。チャージを行って3秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, MagicDamage, 80, 40, ap(0.75))
                .cd(9, -1)
                .mana(80, 10)
                .range(750);
        W.update()
                .active("0.5秒詠唱後に移動が不可能になる代わりに、全てのスキルの射程が400増加し、{1}を得る。この効果は8秒経過するか、再度このスキルを使用する事で解除される。このスキルが解除された時に2秒間{2}する。")
                .variable(1, MRPenRatio, 16, 6)
                .variable(2, MSRatio, 35)
                .cd(20, -4)
                .update(P402)
                .active("0.5秒後に指定地点の{1}の敵ユニットに{2}と2.5秒間{3}を与える。中心点にいる敵ユニットに対しては{4}と2.5秒間{5}を与える（2.5秒かけて10%まで減衰）。また、指定地点の{6}。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 30, ap(0.6))
                .variable(3, MSSlowRatio, 10)
                .variable(4, MagicDamage, 90, 45, ap(0.9))
                .variable(5, MSSlowRatio, 60, 5)
                .variable(6, Visionable)
                .cd(14, -1)
                .mana(70, 10)
                .range(1100);
        E.update()
                .active("対象の敵ユニットに{1}と3秒間マークを与える。マークがついている敵ユニットにXerathのスキルが命中した場合、マークを消費して対象に{2}を与える。")
                .variable(1, MagicDamage, 70, 50, ap(0.8))
                .variable(2, Stun, 1.5)
                .mana(70, 5)
                .cd(12, -1)
                .range(600)
                .update(P402)
                .active("指定方向に雷のオーブを放ち、当たった敵ユニットに{1}と{2}を与える。飛距離に比例してスタンの効果時間が延長する（0.75秒から2秒）。")
                .variable(1, MagicDamage, 80, 30, ap(0.45))
                .variable(2, Stun)
                .cd(13, -0.5)
                .mana(60, 5)
                .range(1050);
        R.update()
                .active("0.5秒後に指定地点の{1}の敵ユニットに{2}を与える。このスキルは12秒の間、3回まで連続して使用できる(但し、一度使用する度に0.35秒のCDが発生する)。2〜3発目はマナコスト無しで使用可能。また、指定地点の視界{3}を得る。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 125, 75, ap(0.6))
                .variable(3, Radius, 300)
                .mana(150, 30)
                .cd(80, -10)
                .range(900)
                .update(P402)
                .active("最大10秒間通常攻撃、移動、スキル使用が不可能になる。最大3回、指定地点に砲撃を行い、0.5秒後に{1}の敵ユニットに{2}を与える。一度使用する度に0.35秒のCDが発生する。また、指定地点の{3}。砲撃を行う前に行動不可状態を解除した場合、このスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 190, 55, ap(0.43))
                .variable(3, Visionable)
                .variable(4, CDDecreaseRatio, 50)
                .cd(130, -15)
                .mana(100)
                .range(3200, 1200);
    }

    /**
     * Define skill.
     */
    public static void Yasuo(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P514)
                .passive("一定距離({1})を移動すると最大値の1%のFlowを得る。{2}するがクリティカルダメージは10%減少する。この減少効果はダメージ増減算の前に適用される。(例: 本来200%のクリティカルダメージは(100 - 10) x 2 = 180%になり、" + Item.InfinityEdge.name + "を持った場合本来250%のダメージが(100 - 10) * 2.5 = 225%になる)。Flowが最大値の時、敵チャンピオンかモンスターからダメージを受けると全てのFlowを消費して{5}間{3}を得る。")
                .variable(1, Value, new Per6Level(59, -7))
                .variable(2, Critical, amplify(Critical, 1))
                .variable(3, Shield, new Per1Level(new double[] {100, 105, 110, 115, 120, 130, 140, 150, 165, 180, 200,
                        225, 255, 290, 330, 380, 440, 510}))
                .variable(5, Time, 1);

        Q.update(P514)
                .active("指定した方向の直線上にいる全ての敵({1})に{2}を与える。" + E + "の使用中に起動した場合、{3}の敵にダメージを与える。このスキルは3回まで連続して使用でき、3度目の使用では{4}になり{5}を追加で与える。このスキルは通常攻撃として扱われ(クリティカル適用)、固定のCDを持つが、増加AS1.71%毎に再使用時間が1%減少する（最大で66%）。{6}。")
                .variable(1, Distance, 475)
                .variable(2, PhysicalDamage, 20, 20, ad(1))
                .variable(3, Radius, 375)
                .variable(4, Distance, 900)
                .variable(5, Knockup)
                .variable(6, OnHitEffect)
                .cd(4);

        W.update(P514)
                .active("3.75秒間持続する{1}の壁を作り出す。この壁はタワー攻撃を除く全ての投射物をブロックする。")
                .variable(1, Length, 300, 50)
                .cd(26, -2)
                .range(400);

        E.update(P514)
                .active("マークの付いていない対象の敵の方向に飛び込み({2})移動する。対象に{1}を与え{3}間マークを付与する。スキル使用時にスタックが増加し、1スタックごとに基礎ダメージが25%増加していく。(最大2スタックで{4})")
                .variable(1, MagicDamage, 70, 20, ap(0.6))
                .variable(2, Distance, 475)
                .variable(3, Time, 10, -1)
                .variable(4, MagicDamage, 105, 35, ap(0.6))
                .cd(-0.5, 0.1)
                .range(475);

        R.update(P514)
                .active("打ち上げられている敵チャンピオンのもとへ瞬間移動し、{1}を与える。さらに、{2}の打ち上げられ中の全ての敵をもう1秒間、打ち上げ直す。発動と同時にFlowが満タンになるが、" + Q + "のスタックは解消される。また、15秒間、{3}を得る。")
                .variable(1, PhysicalDamage, 200, 100, bounusAD(1.5))
                .variable(2, Radius, 400)
                .variable(3, BounusARPenRatio, 50)
                .cd(80, -25)
                .range(1200);
    }

    /**
     * Define skill.
     */
    public static void Yorick(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、スロー無効化、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}")
                .variable(1, DamageReductionRatio, amplify(Stack, 5))
                .variable(2, AttackDamageRatio, amplify(Stack, 5))
                .variable(3, Value, amplify(Health, 0.35))
                .variable(4, Value, 0, 0, ad(0.35))
                .variable(5, Value, 10, 0, level(2))
                .variable(6, Value, 20, 0, level(2))
                .variable(7, Value, new Per5LevelForYoric(300, 40))
                .variable(8, Gold, 5)
                .update(P402)
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}");

        Q.update()
                .active("次の通常攻撃は{1}を与えると同時にSpectral Ghoulを召喚する。Spectral Ghoulは{3}を得る。Spectral Ghoulが生存している間、Ghoulと自身の{q2}する。")
                .variable(1, PhysicalDamage, 30, 30, ad(1.2))
                .variable(2, MSRatio, 15, 5)
                .variable(-3, AD, 8, 8)
                .mana(40)
                .cd(9, -1);
        W.update()
                .active("指定地点を爆発させ{1}の敵ユニットに{2}と1.5秒{3}を与え、同時にその地点にDecaying Ghoulを召喚する。Decaying Ghoulは近くの敵ユニットに継続的に{4}与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 35, ap(1))
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, MSSlowRatio, 10, 2.5)
                .mana(55, 5)
                .cd(12)
                .range(600);
        E.update()
                .active("対象の敵ユニットに{1}を与え、{2}し対象の背後にRavenous Ghoulを召喚する。Ravenous Ghoulが通常攻撃を行うたびに{3}する。敵チャンピオンを攻撃した場合は{4}する。")
                .variable(1, MagicDamage, 55, 30, bounusAD(1))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 40))
                .variable(3, RestoreHealth, 0, 0, ad(0.175))
                .variable(4, RestoreHealth, 0, 0, ad(0.35))
                .mana(55, 5)
                .cd(10, -1)
                .range(550);
        R.update()
                .active("対象の味方チャンピオン一人の姿形を持ったRevenantを召喚する(ALT押しながら右クリックで任意の操作可能)。Revenantは10秒間持続し、対象の{1}の攻撃力を持つ。Revenantが生存している間に対象となった味方チャンピオンが死亡した場合、Revenantが消滅し、死亡した味方チャンピオンはHPとMNが最大の状態で蘇生される。蘇生した味方チャンピオンは10秒経過すると消滅する。")
                .variable(1, Percentage, 45, 15)
                .mana(100)
                .cd(120, -15)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void XinZhao(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("通常攻撃または" + E + "で指定した敵ユニットに{1}を与える。この効果はスタックせず、3秒間持続し、また1体の敵ユニットにしか発動しない。")
                .variable(1, ARReductionRatio, 15);
        Q.update()
                .active("次の3回の通常攻撃に{1}が追加され、3回目の攻撃で{2}を与える。効果中に通常攻撃を行う度に、このスキル以外のCDが1秒解消される。")
                .variable(1, PhysicalDamage, 15, 15, ad(0.2))
                .variable(2, Knockup, 1)
                .mana(30)
                .cd(9, -1);
        W.update()
                .passive("通常攻撃3回ごとに{1}する。")
                .variable(1, RestoreHealth, 26, 6, ap(0.7))
                .active("5秒間{2}増加する。")
                .variable(2, ASRatio, 40, 10)
                .mana(40)
                .cd(16, -1);
        E.update()
                .active("対象の敵ユニットに突進し、{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MSSlowRatio, 25, 5)
                .mana(70)
                .cd(13, -1)
                .range(600);
        E.update(P303).variable(2, MagicDamage, 70, 35, ap(0.6)).cd(14, -1);
        R.update()
                .active("槍を振り回し{3}の敵ユニットに{1}と{2}を与え、このスキルを命中させた敵チャンピオンの数に比例して6秒間{4}と{5}を得る。" + P + "効果中の敵ユニットに対しては" + Knockback + "は発動しない。")
                .variable(1, PhysicalDamage, 125, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .variable(2, Knockback, 0)
                .variable(3, Radius, 375)
                .variable(4, AR, 15, 5)
                .variable(5, MR, 15, 5)
                .mana(100)
                .cd(100, -10);
        R.update(P303)
                .variable(1, PhysicalDamage, 75, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .cd(120, -10);
    }

    /**
     * Define skill.
     */
    public static void Zac(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("Zacのスキルが敵ユニットに命中する度に小型のスライムが出現する。スライム({5})を自身が回収すると{1}し、敵が回収すると消滅する。また、ZacのHealthが0になった時4つのスライムに分裂し一定時間かけて復活する。復活中にすべてのスライムが死亡するとZacも死亡する。復活時のHealthは生きているスライムの数に比例し増加(10-50%)する。スライムは以下のステータスを持つ。<br>Health : {2}<br>AR : {3}<br>MR : {4}")
                .variable(1, RestoreHealth, amplify(Health, 0.04))
                .variable(2, Value, amplify(Health, 0.12))
                .variable(3, Value, amplify(AR, 0.5))
                .variable(4, Value, amplify(MR, 0.5))
                .variable(5, Radius, 100)
                .cd(300)
                .update(P310)
                .variable(5, Radius, 25)
                .update(P403)
                .variable(5, Radius, 50);

        Q.update()
                .active("指定方向に腕を伸ばし範囲内にいる敵ユニットに{1}と2秒間{2}を与える。")
                .variable(1, MagicDamage, 70, 40, ap(0.5))
                .variable(2, MSSlowRatio, 20, 5)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(9, -0.5)
                .range(550);

        W.update()
                .active("{1}にいる敵ユニットに{2}を与える。(Minionに対しては200DMが上限)")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 15, amplify(TargetMaxHealthRatio, 4, 1, ap(0.02)))
                .cost(CurrentHealthRatio, 4, 0)
                .cd(4);

        E.update()
                .active("発動するとZacがその場で停止しチャージを行う。チャージした時間に比例して射程が前方扇形範囲で徐々に増加する。再度使用で指定した地点にジャンプし、着地時に範囲内にいる敵ユニットに{1}と{2}を与える。チャージは移動を行う事でキャンセルできる。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Knockback)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(24, -3)
                .range(1150, 100)
                .update(P310)
                .variable(1, MagicDamage, 80, 40, ap(0.7));

        R.update()
                .active("Zacが4回飛び跳ね、その度に周囲にいる敵ユニットに{1}と{2}と1秒間{3}を与える。ノックバックは同一の対象に1度までしか発生せず、同一ユニットに複数回DMを与える場合、2回目以降は50%のダメージになる。このスキルが発動している間はUnstable Matterと移動のみが可能であり、また徐々に移動速度が増加する(20-50%増加)。使用中は{4}を得る。またこのスキル使用時に自身にかかっているスローを解除する。")
                .variable(1, MagicDamage, 160, 80, ap(0.25))
                .variable(2, Knockback)
                .variable(3, MSSlowRatio, 20)
                .variable(4, Tenacity, 75)
                .cd(130, -15)
                .range(300)
                .update(P307)
                .variable(1, MagicDamage, 140, 70, ap(0.4))
                .update(P310A)
                .active("Zacが4回飛び跳ね、その度に周囲にいる敵ユニットに{1}と{2}と1秒間{3}を与える。ノックバックは同一の対象に1度までしか発生せず、同一ユニットに複数回DMを与える場合、2回目以降は50%のダメージになる。このスキルが発動している間はUnstable Matterと移動のみが可能であり、また徐々に移動速度が増加する(20-50%増加)。またこのスキル使用時に自身にかかっているスローを解除する。");
    }

    /**
     * Define skill.
     */
    public static void Zed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("HPが50%以下の敵ユニットへの通常攻撃に{1}を付与する。同一の対象には10秒に一度しか発動しない。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, new Per6LevelForZed(6, 2)));
        Q.update()
                .active("Zedと「影」から指定方向に貫通する手裏剣を飛ばし、当たった敵ユニットに{1}を与える。手裏剣は一度敵ユニットに当たるとそれ以降の敵ユニットには{3}を与える。Zedと「影」が同一の対象に手裏剣を命中させた場合、2発目以降は{2}を与える。")
                .variable(1, PhysicalDamage, 75, 35, bounusAD(1))
                .variable(2, PhysicalDamage, 37.5, 20, bounusAD(0.5))
                .variable(3, PhysicalDamage, 60, 32, bounusAD(0.8))
                .cost(Energy, 75, -5)
                .cd(6)
                .range(900);
        Q.update(P303).variable(1, PhysicalDamage, 75, 40, bounusAD(1));
        Q.update(P307).variable(3, PhysicalDamage, 45, 24, bounusAD(0.6));
        W.update()
                .passive("{1}を得る。")
                .variable(1, AD, amplify(BounusAD, 0.05, 0.05))
                .active("Zedの「影」が指定方向にダッシュし({5})、4秒間その場に留まり{2}の{3}。再度このスキルを使用するとZedと「影」の位置が入れ替わる。「影」はZedが通常スキルを使用すると同時に同じスキルを使用する。この時スキルがZedのスキルと同一の敵ユニットに命中した場合、{4}する。回復効果はスキル1回毎に1度のみ発動する。")
                .variable(2, Radius, 1300)
                .variable(3, Visionable)
                .variable(4, RestoreEnergy, 20, 5)
                .variable(5, MissileSpeed, 2500)
                .cost(Energy, 40, -5)
                .cd(22, -1.5)
                .range(550);
        W.update(P306).cd(18, -1);
        W.update(P307).variable(2, Radius, 700);
        W.update(P313).variable(5, MissileSpeed, 1500);
        E.update()
                .active("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵ユニットに当たる度にLiving ShadowのCDを1秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。")
                .variable(1, Radius, 290)
                .variable(2, PhysicalDamage, 60, 35, bounusAD(0.9))
                .variable(3, MSSlowRatio, 30, 7.5)
                .cost(Energy, 50, 0)
                .cd(3);
        E.update(P303).variable(2, PhysicalDamage, 60, 30, bounusAD(0.9));
        E.update(P306)
                .active("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵チャンピオンに当たる度にLiving ShadowのCDを2秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。");
        E.update(P307).cd(4);
        R.update()
                .active("対象の敵チャンピオンにダッシュしマークを付与する。ダッシュ中は0.35秒間ターゲット不可状態になる。また対象の背後に4秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1), amplify(DealtDamageRatio, 20, 15))
                .variable(2, Radius, 1100)
                .cd(120, -20)
                .range(625);
        R.update(P313)
                .active("対象の敵チャンピオンにダッシュしマークを付与する。ダッシュ中は0.75秒間ターゲット不可状態になる。また詠唱地点に6秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。")
                .variable(2, Radius, 2000);
    }

    /**
     * Define skill.
     */
    public static void Ziggs(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("12秒毎に通常攻撃に追加{1}が付与される。Ziggsがスキルを使う度に{2}する。建物に対しては1.5倍のDMを与える。")
                .variable(1, MagicDamage, 13, 0, ap(0.35), level(7))
                .variable(2, CDDecrease, 4)
                .update(P313)
                .variable(1, MagicDamage, new Per1Level(new double[] {20, 27, 34, 41, 48, 56, 64, 72, 80, 88, 96, 105,
                        114, 123, 132, 141, 150, 160}), ap(0.35), null)
                .update(P402)
                .variable(1, MagicDamage, new Per1Level(new double[] {20, 24, 28, 32, 36, 40, 48, 56, 64, 72, 80, 88,
                        100, 112, 124, 136, 148, 160}), amplify(AP, new Per6Level(0.25, 0.05)), null);

        Q.update()
                .active("指定地点に跳ねながら転がる爆弾を投げ、爆発時に{1}の敵ユニットに{2}を与える。敵に当たらなかった場合には投げた方向に2回までバウンドする。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 75, 45, ap(0.65))
                .mana(50, 10)
                .cd(6, -0.5)
                .range(850);
        W.update()
                .active("指定地点に{6}で火薬を投げ、爆発時に{1}の敵ユニットに{2}を与え、{3}させる。Ziggsが範囲内にいた場合は自分も{3}する(Ziggsにダメージは無し)。火薬は4秒経つか、スキルを再度使用すると爆発する。また火薬は{5}。")
                .variable(1, Radius, 275)
                .variable(2, MagicDamage, 70, 35, ap(0.35))
                .variable(3, Knockback, 350)
                .variable(5, Visionable)
                .variable(6, MissileSpeed, 1600)
                .mana(65)
                .cd(26, -2)
                .range(1000);
        W.update(P309).variable(6, MissileSpeed, 1750).variable(3, Knockback, 400);
        W.update(P313).variable(1, Radius, 325);
        E.update()
                .active("指定地点の{4}に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れる({5})と{1}と1.5秒間{2}を与える。ミニオン以外の同ユニットが2個目以降に踏むと{3}を与える。地雷は爆発するか10秒経つと消滅する。")
                .variable(1, MagicDamage, 40, 25, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, MagicDamage, 16, 10, ap(0.12))
                .variable(4, Radius, 400)
                .variable(5, Radius, 135)
                .mana(70, 10)
                .cd(16)
                .range(900)
                .update(P313)
                .variable(5, Radius, 150)
                .update(P402)
                .active("指定地点の{4}に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れる({5})と{1}と1.5秒間{2}を与える。同ユニットが2個目以降に踏むと{3}を与える。地雷は爆発するか10秒経つと消滅する。");

        R.update()
                .active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 250, 125, ap(0.9))
                .variable(3, Radius, 750)
                .variable(4, MagicDamage, 200, 100, ap(0.72))
                .mana(100)
                .cd(120, -15)
                .range(5300);
        R.update(P313).active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。ミニオンやモンスターには2倍のダメージを与える。");
    }

    /**
     * Define skill.
     */
    public static void Zilean(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update().passive("すべての味方チャンピオンが取得する{1}する。").variable(1, ExperimentRatio, 8);
        Q.update()
                .active("対象のユニットに爆弾をつけ、4秒後に対象(味方ユニットの場合ダメージ無し)とその周辺{1}の敵ユニットに{2}を与える。対象が死亡した場合は即座に爆発する。")
                .variable(1, Radius, 330)
                .variable(2, MagicDamage, 90, 55, ap(0.9))
                .mana(70, 15)
                .cd(10)
                .range(700);
        W.update().active(W + "以外のスキルのCDを10秒解消する。").mana(50).cd(18, -3);
        E.update()
                .active("味方チャンピオンに使用した場合は{2}間{1}増加し、敵チャンピオンに使用した場合は{2}間{3}を与える。")
                .variable(1, MSRatio, 55)
                .variable(2, Time, 2.5, 0.75)
                .variable(3, MSSlowRatio, 55)
                .mana(80)
                .cd(20)
                .range(700);
        R.update()
                .active("対象の味方チャンピオンが使用してから7秒以内に死亡した場合、2秒後にその場で{1}して復活する。")
                .variable(1, RestoreHealth, 600, 150, ap(2))
                .mana(125, 25)
                .cd(180)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void Zyra(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("死亡すると2秒後にその場で植物に変形し、指定方向に一度だけ貫通する光線を放つことができる。光線に当たった敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 80, 0, level(20))
                .range(1500);
        Q.update()
                .active("地面から棘を出現させ、指定範囲内の敵ユニットに{1}を与える。種にHitした場合Thorn Spitterに成長し、{3}の敵を自動攻撃して{2}を与える。Thorn Spitterは10秒間持続する。")
                .variable(1, MagicDamage, 75, 40, ap(0.6))
                .variable(2, MagicDamage, 26, 0, level(6), ap(0.2))
                .variable(3, Radius, 650)
                .mana(75, 5)
                .cd(7, -0.5)
                .range(825);
        Q.update(P313)
                .variable(1, MagicDamage, 70, 35, ap(0.65))
                .variable(2, MagicDamage, 23, 0, level(6.5), ap(0.2))
                .range(800);
        W.update()
                .passive("{1}を得る。")
                .variable(1, CDR, 4, 4)
                .active("指定地点に30秒持続する種を植える。他のスキルを種に当てることで成長させることができる。敵チャンピオンが種を踏んだ場合、視界を2秒間得る。{2}毎にチャージが1つ増加し最大2つまでチャージされる。種が植物に成長し、同一ユニットに複数の植物がDMを与える場合、2体目以降は50%のダメージを与える。")
                .variable(2, CDRAwareTime, 17, -1)
                .range(825)
                .cost(Charge, 1, 0);
        W.update(P313).variable(1, CDR, 2, 2);
        E.update()
                .active("指定方向に蔓を放ち、当たった全ての敵ユニットに{1}と{2}を与える。種にHitした場合Vine Lasherに成長し、{3}の敵を自動攻撃して{4}と2秒間{5}を与える。Vine Lasherは10秒間持続する。")
                .variable(1, MagicDamage, 60, 35, ap(0.5))
                .variable(2, Snare, 0.75, 0.25)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 26, 0, level(6), ap(0.2))
                .variable(5, MSSlowRatio, 30)
                .mana(70, 5)
                .cd(14, -1)
                .range(1100);
        E.update(P313).variable(4, MagicDamage, 23, 0, level(6.5), ap(0.2));
        R.update()
                .active("指定地点に藪を召還し、{1}の全ての敵に{2}を与え、2秒後に{3}。成長した植物にHitした場合、その植物の攻撃速度が50%増加する。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 180, 85, ap(0.75))
                .variable(3, Knockup, 0)
                .mana(100, 20)
                .cd(130, -10)
                .range(700);
    }
}
