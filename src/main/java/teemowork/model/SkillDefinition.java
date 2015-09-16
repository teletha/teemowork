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
import teemowork.model.variable.VariableResolver.Per2Level;
import teemowork.model.variable.VariableResolver.Per3Level;
import teemowork.model.variable.VariableResolver.Per4Level;
import teemowork.model.variable.VariableResolver.Per5Level;
import teemowork.model.variable.VariableResolver.Per6Level;
import teemowork.model.variable.VariableResolver.PerChampion;
import teemowork.model.variable.VariableResolver.PerLevel;
import teemowork.model.variable.VariableResolver.PerLevel;
import teemowork.model.variable.VariableResolver.PerReferedSkillLevel;
import teemowork.model.variable.VariableResolver.PerSkillLevel;
import teemowork.model.variable.VariableResolver.Refer;
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
        P.update(P511)
                .passive("スキルを使用時に消費した" + Health + "をBlood Wellとしてスタックし(最大スタック量は{1})、5秒間戦闘状態でなくなると毎秒2%ずつ失われていく。スタックが1%貯まる毎に{2}する(最大で{3})。Healthが0になると3秒かけて最大スタック量の35% + 現在のスタック量分の" + Health + "を持って復活する。{6}。")
                .variable(1, Stack, new PerLevel(105, 138, 171, 207, 244, 283, 323, 365, 408, 453, 500, 548, 598, 649, 702, 756, 813, 870))
                .variable(-2, ASRatio, new Per3Level(0.3, 0.05))
                .variable(-3, ASRatio, new Per3Level(30, 5))
                .variable(6, CDRUnaware)
                .cd(new Per5Level(-225, 25));

        Q.update(P308)
                .active("指定地点に飛びかかり、{1}の敵ユニットに{2}を与える。{4}にいる敵ユニットに対しては更に{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, PhysicalDamage, 70, 45, bounusAD(0.6))
                .variable(3, Knockup, 1)
                .variable(4, Radius, 75)
                .cd(16, -1)
                .cost(CurrentHealthRatio, 10, 0)
                .range(650);

        W.update(P406)
                .passive("通常攻撃3回ごとに{1}する。Healthが50%以下の場合、{2}する。ToggleOnの間、この効果は失われる。")
                .variable(1, RestoreHealth, 20, 5, bounusAD(0.25))
                .variable(2, RestoreHealth, 60, 15, bounusAD(0.75))
                .active("通常攻撃3回ごとに{3}を与えて{4}する。")
                .variable(3, PhysicalDamage, 60, 35, bounusAD(1))
                .variable(4, LoseHealth, 15, 8.75, bounusAD(0.25))
                .cd(0.5)
                .type(SkillType.Toggle);

        E.update(P313)
                .active("指定方向に貫通するエネルギーを放ち、当たった敵ユニットに{1}と{2}間{3}を与える。")
                .variable(1, MagicDamage, 75, 35, ap(0.6), bounusAD(0.6))
                .variable(2, Time, 1.75, 0.25)
                .variable(3, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 5, 0)
                .cd(12, -1)
                .range(1000);

        R.update(P506)
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
        P.update(P516)
                .passive("スキルが敵ユニットに当たる度に" + P + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルが敵に当たる毎に{1}する。")
                .variable(1, RestoreHealth, new Per5Level(3, 5, 9, 18));

        Q.update(P503)
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。オーブを射出している間{3}する。（0.5秒かけて80まで減衰）")
                .variable(1, MagicDamage, 40, 25, ap(0.35))
                .variable(2, TrueDamage, 40, 25, ap(0.35))
                .variable(3, MS, 215)
                .cd(7)
                .mana(65, 5)
                .range(880);

        W.update(P503)
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

        R.update(P503)
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
        P.update(P302)
                .passive("{1}を得る。また通常攻撃に{2}が付与される。")
                .variable(1, SV, 6, 0, bounusAD(0.167))
                .variable(2, MagicDamage, amplify(AD, 0.06, 0, ap(0.00167)));

        Q.update(P305)
                .active("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃でダメージを与えたとき、マークを消費して{1}を与え、{3}する。")
                .variable(1, MagicDamage, 35, 20, ap(0.4))
                .variable(3, RestoreEnergy, 20, 5)
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(600);

        W.update(P418)
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。自身は{2}と{3}を得て、敵ユニットには{4}を与える。ステルスはスキル使用または通常攻撃時に解除され、再度ステルス化するのに0.65秒かかる。")
                .variable(1, Radius, 400)
                .variable(2, Stealth)
                .variable(3, MSRatio, 20, 20)
                .variable(4, MSSlowRatio, 14, 4)
                .variable(5, Visionable)
                .cd(20)
                .cost(Energy, 80, -5)
                .range(700);

        E.update(P509)
                .active("{2}の敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 30, 25, ap(0.4), ad(0.6))
                .variable(2, Radius, 325)
                .cd(5, -1)
                .cost(Energy, 60, -5);

        R.update(P510)
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
        P.update(P412)
                .passive("スキルを使用すると3秒間{1}を得て、{2}の敵ユニットと建物に毎秒{3}を与える。ミニオンに対してはダメージが2倍になる。")
                .variable(1, IgnoreUnitCollision)
                .variable(2, Radius, 300)
                .variable(3, MagicDamage, 6, 0, ap(0.1), level(1));

        Q.update(P412)
                .active("{4}の敵ユニットに{1}を与え、{2}後に{3}を与える。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, Knockup, 1)
                .variable(3, Stun, 0.5, 0)
                .variable(4, Radius, 365)
                .cd(17, -1)
                .mana(65, 5);

        W.update(P516)
                .active("対象の敵ユニットに突撃（速度1200）し{1}と{2}、{3}を与える。")
                .variable(1, MagicDamage, 55, 55, ap(0.7))
                .variable(2, Knockback)
                .variable(3, Stun, 1)
                .cd(14, -1)
                .mana(65, 5)
                .range(650);

        E.update(P412)
                .active("{1}する。{3}の味方ユニットは{2}する。近くの敵ユニットが死ぬと{4}する。")
                .variable(1, RestoreHealth, 60, 30, ap(0.2))
                .variable(2, RestoreHealth, 30, 15, ap(0.1))
                .variable(3, Radius, 575)
                .variable(4, CDDecrease, 2)
                .cd(12, 0)
                .mana(40, 10);

        R.update(P412)
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
        P.update(P301).passive("通常攻撃した対象に3秒間{1}を与える。").variable(1, MRReduction, new Per6Level(15, 5));

        Q.update(P303)
                .active("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Stun, 1)
                .mana(80, 10)
                .cd(16, -2)
                .range(1100);

        W.update(P506)
                .active("毎秒、{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 8, 4, amplify(TargetMaxHealthRatio, 1, 0.5, ap(0.01)))
                .variable(2, Radius, 300)
                .mana(8)
                .cd(1)
                .type(SkillType.Toggle);

        E.update(P301)
                .passive("{1}する。")
                .variable(1, PhysicalDamageReduction, 2, 2)
                .active("{3}の敵ユニットに{2}を与える。通常攻撃でダメージを受けるたびに{4}。")
                .variable(2, MagicDamage, 75, 25, ap(0.5))
                .variable(3, Radius, 350)
                .variable(4, CDDecrease, 0.5)
                .mana(35)
                .cd(10, -1);

        R.update(P303)
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
        P.update(P302)
                .passive("死亡時に卵になり6秒かけて復活する。復活中は{1}及び{2}を得る。復活中にHPが0になった場合は死亡する。{3}。")
                .variable(-1, AR, new PerLevel(new int[] {1, 5, 8, 12, 15}, -40, 15))
                .variable(-2, MR, new PerLevel(new int[] {1, 5, 8, 12, 15}, -40, 15))
                .variable(3, CDRUnaware)
                .cd(-240);

        Q.update(P419)
                .active("指定方向に貫通する氷を飛ばし、氷に触れた敵ユニットに{1}と3秒間{2}を与え、{4}状態にする。氷が飛んでいる最中に再度スキルを使用するか、最大距離まで飛ぶと氷が破裂し、破裂地点の{6}の敵ユニットにさらに{1}と{5}と3秒間{2}を与え、{4}状態にする。")
                .variable(1, MagicDamage, 60, 30, ap(0.5))
                .variable(2, MSSlowRatio, 20)
                .variable(4, Chill)
                .variable(5, Stun, 1)
                .variable(6, Radius, 75)
                .mana(80, 10)
                .cd(12, -1)
                .range(1075);

        W.update(P401)
                .active("指定地点に5秒間{1}の壁を作りユニットを通れなくする。また、指定地点の{2}。")
                .variable(1, Length, 400, 100)
                .variable(2, Visionable)
                .mana(70)
                .cd(25)
                .range(1000);

        E.update(P301)
                .active("対象の敵ユニットに{1}を与える。対象が" + Chill + "の場合は{2}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MagicDamage, 110, 60, ap(1.0))
                .mana(50, 10)
                .cd(5)
                .range(650);

        R.update(P405)
                .active("指定地点の{1}の敵ユニットに毎秒{2}、1秒間の{3}を与え、{4}状態にする。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 80, 40, ap(0.25))
                .variable(3, SlowRatio, 20)
                .variable(4, Chill)
                .mana(40, 10)
                .cd(6)
                .range(625)
                .type(SkillType.Toggle);
    }

    /**
     * Define skill.
     */
    public static void Annie(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P401)
                .passive("スキルを使用するたびにスタックが1貯まり、4スタック時に" + E + "以外のスキルを使用すると、スタックを全て消費してそのスキルに{1}が追加される。")
                .variable(1, Stun, new PerLevel(new int[] {1, 6, 11}, 1.25, 0.25));

        Q.update(P404)
                .active("対象の敵ユニットに{1}を与える。このスキルでキルを取ると{2}し、{3}する。")
                .variable(1, MagicDamage, 80, 35, ap(0.8))
                .variable(2, RestoreMana, 60, 5)
                .variable(3, CDDecrease, 2)
                .mana(60, 5)
                .cd(4)
                .range(625);

        W.update(P404)
                .active("指定方向扇形50°の{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 625)
                .variable(2, MagicDamage, 70, 45, ap(0.85))
                .mana(70, 10)
                .cd(8);

        E.update(P502)
                .active("5秒間{2}と{3}を得て、効果時間中に通常攻撃をしてきた敵ユニットに{4}を与える。また" + R + "が召喚されている間は、" + R + "にも" + E + "の効果が付加され移動速度が300増加する(0.75sで減衰)。")
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .variable(4, MagicDamage, 20, 10, ap(0.2))
                .mana(20)
                .cd(10);

        R.update(P506)
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
        P.update(P512)
                .passive("スキルと通常攻撃は対象に2秒間{1}を与える。またこのスキルで" + MSSlow + "を付与した対象に通常攻撃を行う場合、常にクリティカルが発生する。この" + Damage + "は" + Critical + "によって上昇する。その代わり通常状態の敵へのクリティカルは発生しない。")
                .variable(1, MSSlowRatio, new Per3Level(5, 6));

        Q.update(P511)
                .passive("スキルもしくは通常攻撃が敵に命中することで4秒間「フォーカス」のチャージを獲得。最大で5チャージ。")
                .active("「フォーカス」の全チャージを消費して4秒間" + P + "による" + MSSlow + "効果が{1}になり、{2}する。5チャージ消費されると、通常攻撃が5回に分けて合計{3}を与えるようになる。On-Hit Effectsは5連射の初撃のみ有効(Hurricaneは5回発動)。")
                .variable(1, MSSlowRatio, new Per3Level(6, 7.2))
                .variable(2, ASRatio, 20, 5)
                .variable(3, PhysicalDamage, amplify(AD, 1.15, 0.05))
                .mana(50)
                .cd(12, -2)
                .range(1200);

        W.update(P511)
                .active("非貫通の矢を扇状に発射し、それぞれ敵に命中するごとに{1}を与える。敵はこのスキルによって放たれる矢を複数遮ることができるが、ダメージは最初に当たった矢の分のみ受ける。")
                .variable(1, PhysicalDamage, 20, 15, ad(1))
                .range(1200)
                .cd(12, -2)
                .mana(40);

        E.update(P511)
                .active("マップ上どこでも、ターゲット位置まで鷹を飛ばすことができ5秒間通過した{2}の{1}。スタックは最大2で{3}毎に増加する。")
                .variable(1, Visionable)
                .variable(2, Radius, 1000)
                .variable(3, CDRAwareTime, 90, -10)
                .cost(Stack, 1, 0)
                .cd(5)
                .range(-1);

        R.update(P511)
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

        Q.update(P503)
                .active("全ての砂兵士を指定した地点に集結させる。砂兵士は進路上でぶつかった敵に{1}と1秒間{2}を与える。このスロー効果は累積する。")
                .variable(1, MagicDamage, 65, 20, ap(0.5))
                .variable(2, MSSlowRatio, 25)
                .range(875)
                .cd(10, -1)
                .mana(70);

        W.update(P514)
                .passive("{4}する。")
                .variable(4, ASRatio, 20, 10)
                .active("9秒持続する砂兵士1体を召喚する。自身が兵士の射程距離内にいる敵を攻撃すると、兵士が自身に代わってその敵を攻撃し、直線上にいる敵に{1}を与える。複数の兵士が同じ敵を攻撃した場合、2人目以降の兵士のダメージは25%になる。たとえ標的が自身の通常攻撃の射程内にいなくても、兵士自身の射程に入っていれば兵士が攻撃を行う。兵士は最大2体まで、{2}毎に補充される。兵士から離れすぎるとその兵士は動かなくなる。敵タワーの近くでは、兵士の持続時間は通常の半分になる。兵士をタワーの真上に召喚することで、その兵士を犠牲にしてタワーに{3}を与える。")
                .variable(1, MagicDamage, new PerLevel(new double[] {45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 100, 110, 120, 130, 140, 150,
                        160, 170}), ap(0.6), null)
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

        R.update(P421)
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
        P.update(P508)
                .passive("鐘が50秒毎に2個ずつ、自身から一定の範囲内に出現する(2回目と3回目は1個のみ。また、試合開始から5分経過すると、敵ジャングル内にも出現し始める)。鐘を取ると、非戦闘時に7秒間{1}し(5回までスタック)、{2}（経過時間に比例）を得て、{3}する。鐘は10分経つと消滅する。<br>通常攻撃の際、スタックを消費して{4}を与える。<br>5個: 1秒間{5}<br>25: ターゲットの後方にも追加効果<br>65: 効果範囲が拡大")
                .variable(-1, MSRatio)
                .variable(2, Experiment, 20)
                .variable(3, RestoreMana, amplify(Mana, 0.12))
                .variable(4, MagicDamage, new BardChimes(new int[] {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140,
                        150}, new double[] {35, 55, 80, 110, 140, 175, 210, 245, 280, 315, 345, 375, 400, 425, 445, 465}), ap(0.3), null)
                .variable(5, MSSlowRatio, new BardChimes(new int[] {5, 45, 85, 115, 135}, new double[] {25, 45, 60, 75, 80}));

        Q.update(P507)
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

        W.update(P517)
                .active("治癒効果のある結界を設置し、接触した味方は{1}する。設置から10秒間かけて治癒効果が向上して、最大で{2}するとともに{3}する。この効果は1.5秒かけて減衰する。結界は一度に3個まで発生させることができ、味方のチャンピオンが接触するか、敵が通過すると消滅する。")
                .variable(1, RestoreHealth, 30, 30, ap(0.2))
                .variable(2, RestoreHealth, 70, 40, ap(0.45))
                .variable(3, MSRatio, 50)
                .range(1000)
                .mana(90)
                .cd(5);

        E.update(P517)
                .active("付近の壁に一方通行の穴を開け、近くで穴のどこかを右クリックすると通り抜けられる。敵も使用できるが、味方のほうが{1}速く通り抜ける。")
                .variable(1, Percentage, 10, 10)
                .range(900)
                .mana(30)
                .cd(18, -1);

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
        P.update(P301).passive(" HPが20%以下になると、10秒間{1}を張る。").variable(1, Shield, amplify(CurrentManaRatio, 50)).cd(90);

        Q.update(P408)
                .active("指定方向に腕を飛ばし、当たった敵ユニットに{1}と{2}を与え自分の位置まで引き寄せる。またこのスキル命中時に対象の{3}。")
                .variable(1, MagicDamage, 80, 55, ap(1))
                .variable(2, Stun, 0.5)
                .variable(3, Visionable)
                .mana(100)
                .cd(20, -1)
                .range(925);

        W.update(P508)
                .active("5秒間{1}、{2}する。" + MS + "上昇量は時間と共に10%まで減衰し、効果終了時に自身に1.5秒間{3}を与える。")
                .variable(1, MSRatio, 70, 5)
                .variable(2, ASRatio, 30, 8)
                .variable(3, MSSlowRatio, 30)
                .mana(75)
                .cd(15);

        E.update(P301)
                .active("次の通常攻撃に{1}を付与し、対象に{2}を与える。{3}。")
                .variable(1, PhysicalDamage, 0, 0, ad(1))
                .variable(2, Knockup, 1, 0)
                .variable(3, ResetAATimer)
                .mana(25)
                .cd(9, -1);

        R.update(P408)
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
        P.update(P301)
                .passive("スキルが当たった敵ユニットを炎上させ、4秒間毎秒{1}与える。炎上している敵ユニットにスキルが命中すると追加効果が発生する。(ミニオンやモンスターに対しては毎秒80ダメージが上限)")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 2));

        Q.update(P301)
                .active("指定方向に火球を投射し、当たった敵ユニットに{1}を与える。敵が炎上していた場合、{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.65))
                .variable(2, Stun, 2)
                .mana(50)
                .cd(8, -0.5)
                .range(1050);

        W.update(P309)
                .active("指定地点に炎の柱を作り出し、0.625秒後に{1}の敵ユニットに{2}を与える。敵が炎上していた場合、代わりに{3}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 75, 45, ap(0.6))
                .variable(3, MagicDamage, 94, 56, ap(0.75))
                .mana(70, 5)
                .cd(10)
                .range(900);

        E.update(P315)
                .active("対象の敵ユニットに{1}を与える。敵が炎上していた場合、{2}の敵にも{1}を与える。")
                .variable(1, MagicDamage, 70, 35, ap(0.55))
                .variable(2, Radius, 300)
                .mana(70, 5)
                .cd(12, -1)
                .range(625);

        R.update(P511)
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
        P.update(P413)
                .passive("通常攻撃時に対象にスタックを付与する。自身を含む味方チャンピオンがスタック付きの対象に通常攻撃を行う度にスタックが1増加し、4スタックになるとスタックを全て消費し対象に{1}と{2}を与える。スタックは4秒間増加が無いと0になる。" + Stun + "が発動すると、その対象が{3}間耐性を得て、スタックが付与できなくなる。代わりに自身が耐性がついた対象に通常攻撃するか" + Q + "を当てると{4}を与える。")
                .variable(1, Stun, new Per6Level(1.25, 0.25))
                .variable(2, MagicDamage, 32, 0, level(8))
                .variable(3, Time, 8, -1)
                .variable(4, MagicDamage, 6.4, 0, level(1.6));

        Q.update(P518)
                .active("盾から氷の塊を発射し、命中した敵に" + P + "のスタック、{1}と2秒間かけて減衰する{2}を与える。")
                .variable(1, MagicDamage, 70, 45, amplify(Health, 0.025))
                .variable(2, MSSlowRatio, 70)
                .range(1000)
                .mana(55, 5)
                .cd(10, -1);

        W.update(P413)
                .active("対象の味方のユニットのそばに素早く移動する。移動完了後3秒間、自分と味方は{1}と{2}を得る。")
                .variable(1, AR, 15, 2.5, amplify(BounusAR, 0.1, 0.015))
                .variable(2, MR, 15, 2.5, amplify(BounusMR, 0.1, 0.015))
                .range(650)
                .mana(50, 5)
                .cd(14, -1);

        E.update(P409)
                .active("{1}間、盾を掲げて{3}を得て{4}する。盾を向けている方向から受けた最初の攻撃のダメージを無効化する。それ以降も効果時間中は受ける攻撃のダメージを{2}する。敵の遠距離攻撃を盾によって、食い止める。効果時間中はブラームの移動速度が10％上昇する")
                .variable(1, Time, 3, 0.25)
                .variable(2, DamageReductionRatio, 30, 2.5)
                .variable(3, IgnoreUnitCollision)
                .variable(4, MSRatio, 10)
                .mana(30, 5)
                .cd(18, -2);

        R.update(P413)
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
        P.update(P511)
                .passive("通常攻撃{1}回毎にダメージが増加する(ミニオンには150%増加、チャンピオンには50%増加して{2}を付与、建物への攻撃は無効)。茂みから通常攻撃を行うと2回分としてカウントされる。")
                .variable(1, Count, new Per6Level(7, -1))
                .variable(2, BounusARPenRatio, 50);

        Q.update(P301)
                .active("1秒詠唱後、指定方向に貫通する弾を発射し当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%減少していき最小で{2}を与える。")
                .variable(1, PhysicalDamage, 20, 40, ad(1.3))
                .variable(2, PhysicalDamage, 10, 20, ad(0.65))
                .mana(50, 10)
                .cd(10, -1)
                .range(1250);

        W.update(P517)
                .active("指定地点に罠を仕掛ける。敵チャンピオンが罠の{4}に入ると発動して、対象に1.5秒かけて{2}と{3}を与え、9秒間対象の{5}。罠は3個まで置け、4分間持続する。")
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Snare, 1.5)
                .variable(4, Radius, 67.5)
                .variable(5, Visionable)
                .mana(30)
                .cd(16, -2)
                .range(800);

        E.update(P301)
                .active("指定方向にネットを飛ばし当たった敵ユニットに{1}と{3}間{2}を与え、Caitlynはネットを飛ばした方向の反対側にジャンプ({4})する。")
                .variable(1, MagicDamage, 80, 50, ap(0.8))
                .variable(2, MSSlowRatio, 50)
                .variable(3, Time, 1, 0.25)
                .variable(4, Distance, 400)
                .mana(75)
                .cd(18, -2)
                .range(950);

        R.update(P511)
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
        P.update(P510)
                .passive("6秒毎に1スタックを得る。敵チャンピオンに毒を与えている間は毎秒1スタックを得る。スタック数に応じて能力を得る。<br>100: {1}する。" + E + "を敵に当てるたびに{2}する。<br>250: {3}する。{4}を得る。<br>500: {5}する。")
                .variable(-1, APRatio, 5)
                .variable(2, RestoreHealth, new Refer(E, 6, 2), ap(0.06), null)
                .variable(-3, APRatio, 5)
                .variable(-4, CDR, 25)
                .variable(-5, APRatio, 20);

        Q.update(P502)
                .active("指定地点に0.4秒後に毒を発生させ、{1}の敵ユニットに毒を与え3秒かけて{2}を与える。このスキルがチャンピオンにヒットした場合、3秒間{3}する。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 75, 40, ap(0.45))
                .variable(3, MSRatio, 20)
                .mana(40, 10)
                .cd(4)
                .range(850);

        W.update(P416)
                .active("指定地点に7秒間持続する毒霧を吹き出す。毒霧は徐々に範囲(125～250)が広がり、毒霧の上を通過した敵に2秒間持続する毒を付与し毎秒{1}と2秒間{3}を与える。また指定地点の{4}。")
                .variable(1, MagicDamage, 10, 5, ap(0.1))
                .variable(3, MSSlowRatio, 25, 5)
                .variable(4, Visionable)
                .mana(40, 10)
                .cd(14, -1)
                .range(850);

        E.update(P510)
                .active("対象の敵ユニットに{1}を与え、" + champion + "の毒による{3}する（この効果は2回まで累積する）。対象が毒を受けている場合、{2}。")
                .variable(1, MagicDamage, 55, 25, ap(0.55))
                .variable(2, CD, 0.5)
                .variable(3, DamageRatio, 20)
                .mana(50, 10)
                .cd(5)
                .range(700);

        R.update(P416)
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
        P.update(P301)
                .passive("敵ユニットを倒すと{1}、{2}する。")
                .variable(1, RestoreHealth, 17, 0, level(3))
                .variable(2, RestoreMana, 3.25, 0, level(0.25));

        Q.update(P315)
                .active("指定地点に0.5秒後にトゲを出現させ、{1}の敵ユニットに{2}、{3}を与えて、1.5秒間{5}にする。また指定地点の{4}。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(3, Knockup, 1)
                .variable(4, Visionable)
                .variable(5, MSSlowRatio, 60)
                .mana(90)
                .cd(9)
                .range(950);

        W.update(P301)
                .active("前方扇形60°の領域の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 50, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 10)
                .cd(13)
                .range(700);

        E.update(P301)
                .active("通常攻撃時に前方にトゲを飛ばし当たった敵ユニットに{1}を与える。トゲを飛ばす範囲はUltのスタック数に比例し増加する。")
                .variable(1, MagicDamage, 20, 15, ap(0.3))
                .cd(0.5)
                .range(500)
                .type(SkillType.Toggle);

        R.update(P421)
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
        P.update(P301).passive("通常攻撃に{1}が付与される。建物には無効。").variable(1, TrueDamage, 0, 0, ad(0.1));

        Q.update(P421)
                .active("指定地点に爆弾を発射し、着弾時に{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。爆弾にも視界がある。また、チャンピオンに当たった場合、6秒間そのチャンピオンの{3}。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 80, 50, ap(0.5), bounusAD(0.5))
                .variable(3, Visionable)
                .cd(8)
                .mana(60, 10)
                .range(825);

        W.update(P501)
                .active("指定地点まで高速で移動し、通過地点を2.5秒間炎上させる。炎上地点の上にいる敵ユニットに0.5秒毎に{2}を与える。")
                .variable(2, MagicDamage, 30, 15, ap(0.2))
                .mana(100)
                .cd(26, -3)
                .range(800);

        E.update(P314)
                .active("4秒間、Corkiの前方扇形35°にいる敵ユニットに0.5秒毎に{1}を与える(最大8hit)。ダメージを与える度に対象ユニットに{2}を与える。この効果は2秒間持続し、8回までスタックする。")
                .variable(1, PhysicalDamage, 10, 6, bounusAD(0.02))
                .variable(2, ARReduction, 1, 1)
                .mana(50)
                .cd(16)
                .range(600);

        R.update(P314)
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
        P.update(P503)
                .passive("{1}する。通常攻撃3回毎に周囲にいる敵ユニットに{2}を与える。")
                .variable(1, ASRatio, 20)
                .variable(2, MagicDamage, new PerLevel(new double[] {20, 25, 30, 35, 40, 50, 60, 70, 80, 90, 105, 120, 135, 155, 175, 200,
                        225, 250}), ap(0.8), null);

        Q.update(P301)
                .active("指定地点に弧を描くエネルギーを放ち、当たった敵ユニットと{2}のユニットに{1}とMoonlight(3秒)を与える。またMoonlightが付与されている敵ユニットの{3}。")
                .variable(1, MagicDamage, 60, 35, ap(0.7))
                .variable(2, Radius, 50)
                .variable(3, Visionable)
                .mana(55)
                .cd(10, -1)
                .range(830);

        W.update(P503)
                .active("5秒間{1}を張ると同時に、自身の周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発すると{1}が追加される。")
                .variable(1, Shield, 40, 15, ap(0.3))
                .variable(2, Radius, 200)
                .variable(3, MagicDamage, 22, 12, ap(0.2))
                .mana(60, 10)
                .cd(10);

        E.update(P418)
                .active("{1}にいる全ての敵ユニットを自身がいる方向に引き寄せ、2秒間{2}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 35, 5)
                .mana(70)
                .cd(26, -2);

        R.update(P421)
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
        P.update(P516)
                .passive("通常攻撃または" + Q + "の刃でダメージを与えた敵ユニットに出血スタックを付与する。出血スタックが付与された敵ユニットに1.25秒毎に5秒間かけて{1}を与える。出血スタックは5秒間持続して最大5回までスタックし最大{2}を与える。敵チャンピオンへのスタックが5になるか" + R + "で倒すと、" + champion + "は5秒間{3}を得て、常に5スタックを付与するようになる。")
                .variable(1, PhysicalDamage, 9, 0, level(1), amplify(BounusAD, 0.3))
                .variable(2, PhysicalDamage, 45, 0, level(5), amplify(BounusAD, 1.5))
                .variable(-3, AD, new PerLevel(new int[] {1, 3, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                        18}, 40, 45, 50, 60, 70, 80, 90, 100, 110, 120, 140, 160, 180, 200));

        Q.update(P518)
                .active("0.75秒後斧を振り回し{3}の敵ユニットに{1}を与える。斧の刃に当たった敵チャンピオンに対しては{2}を与え、1体毎に{4}する（最大36%）。")
                .variable(1, PhysicalDamage, 20, 12.5, amplify(AD, 0.5, 0.05))
                .variable(2, PhysicalDamage, 40, 25, amplify(AD, 1, 0.1))
                .variable(3, Radius, 425)
                .variable(4, RestoreHealth, amplify(MissingHealthRatio, 12))
                .mana(30, 5)
                .cd(9, -1);

        W.update(P517)
                .active("次の通常攻撃に{1}を追加し、1秒間{2}が付与される。その攻撃で敵を倒した場合{5}し、このスキルの{6}する。{4}。")
                .variable(1, PhysicalDamage, ad(0.4))
                .variable(2, SlowRatio, 90)
                .variable(4, ResetAATimer)
                .variable(5, RestoreMana, 30)
                .variable(6, CDDecreaseRatio, 50)
                .mana(30)
                .cd(9, -1);

        E.update(P516)
                .passive("{1}を得る。")
                .variable(1, ARPenRatio, 5, 5)
                .active("前方範囲内の敵ユニットをDariusがいる方向に引き寄せ1秒間{3}を与え、{2}。")
                .variable(2, Visionable)
                .variable(3, MSSlowRatio, 90)
                .mana(45)
                .cd(24, -3)
                .range(550);

        R.update(P516)
                .active("対象の敵チャンピオンに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵チャンピオンのキルを取った場合、周囲のミニオンとモンスターに{2}を与え、20秒間マナを消費せずに再使用することが出来る（ランク3であれば{4}）。この効果はキルを取るたびに適用される。")
                .variable(1, TrueDamage, 100, 100, bounusAD(0.75))
                .variable(2, Fear)
                .variable(3, Time, 20)
                .variable(4, CDDecrease)
                .cost(Mana, new PerSkillLevel(100, 100, 0), null)
                .cd(120, -20)
                .range(475);
    }

    /**
     * Define skill.
     */
    public static void DrMundo(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P508).passive("毎秒{1}する。").variable(1, RestoreHealth, amplify(Health, 0.003));

        Q.update(P508)
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

        W.update(P301)
                .active("{1}の敵ユニットに毎秒{2}を与える。また{3}を得る。")
                .variable(1, Radius, 162.5)
                .variable(2, MagicDamage, 35, 15, ap(0.2))
                .variable(3, Tenacity, 10, 5)
                .cost(Health, 10, 5)
                .cd(4)
                .type(SkillType.Toggle);

        E.update(P306).active("5秒間{1}を得る。").variable(1, AD, 40, 15, amplify(MissingHealthPercentage, 0.4, 0.15)).cost(Health, 25, 10).cd(7);

        R.update(P508)
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
        P.update(P517)
                .passive(P + "をキャッチするかミニオンかモンスターを倒すか建物を破壊するとスタックを得る。斧を落とすこと無く6体のミニオンを倒すと追加の2スタックを得る。敵チャンピオンを倒すと、スタックを消費して{1}を得る。死亡時にスタックを半分失う。")
                .variable(1, Gold, 50, 0, amplify(ConsumedStack, 2));

        Q.update(P306)
                .active("次に行う通常攻撃に{1}を付与する。このスキルによる通常攻撃が敵ユニットに命中すると、斧が近くに跳ね返る。その斧をキャッチすると" + W + "の{2}し、更に次の通常攻撃も" + Q + "の効果を受けるようになる。このスキルは連続で使用する事で最大2回分までチャージできる。")
                .variable(1, PhysicalDamage, amplify(AD, 0.45, 0.1))
                .variable(2, CDDecrease)
                .mana(45)
                .cd(12, -1);

        W.update(P301)
                .active("1.5秒間{1}し、3秒間{2}する。移動速度増加は1.5秒かけて元に戻る。")
                .variable(1, MSRatio, 40, 5)
                .variable(2, ASRatio, 20, 5)
                .mana(40)
                .cd(12);

        E.update(P301)
                .active("指定方向に貫通する斧を投げ、当たった敵ユニットに{1}と{2}と2秒間{3}を与える。このノックバックは斧から弾かれる形で左右に吹き飛ぶ。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.5))
                .variable(2, Knockback, 0)
                .variable(3, MSSlowRatio, 20, 5)
                .mana(70)
                .cd(18, -1)
                .range(1050);

        R.update(P301)
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
        P.update(P515)
                .passive("通常攻撃かスキルでダメージを与えた敵ユニットにスタックを付与する。スタックは4秒間持続し、スタック数が3になるとスタックを消費し対象に{1}と{2}間{3}を与える。対象がチャンピオンの場合、更に{2}間{4}する。同一の対象には3秒に一度しか発動しない。建物には無効。")
                .variable(1, MagicDamage, 10, 0, ap(0.8), level(10))
                .variable(2, Time, new PerLevel(new int[] {1, 6, 11}, 2, 0.5))
                .variable(3, MSSlowRatio, new Per5Level(30, 10))
                .variable(-4, MSRatio, new Per5Level(40, 10));

        Q.update(P514)
                .active("特殊な装置を投げ、貫通した敵に{1}を与える。投げられた装置は最初に命中したチャンピオンの位置にフィールドを展開し、この範囲を通過するすべての対象に{2}を与える。その一瞬後、装置は自身のいる位置に戻り、その際貫通した敵に{3}を与える。2回とも当たった場合は合計{4}となる。")
                .variable(1, MagicDamage, 60, 15, ap(0.1))
                .variable(2, MSSlowRatio, 32, 7)
                .variable(3, MagicDamage, 60, 25, ap(0.6))
                .variable(4, MagicDamage, 120, 40, ap(0.7))
                .range(1075)
                .mana(50, 10)
                .cd(11, -1);

        W.update(P515)
                .passive("通常攻撃時、体力が最大値の30％未満の敵に対し、{1}を与える。ミニオンやモンスターに対しては最大150ダメージ。")
                .variable(1, MagicDamage, amplify(TargetMissingHealthRatio, 5, 0, ap(0.0222)))
                .active("発動3秒後、指定した地点の{2}の敵に{3}を与える。自身がこの地点に入ると起爆し、2秒間{4}を得て、全ての敵に{5}を与える。")
                .variable(2, Radius)
                .variable(3, MSSlowRatio, 40)
                .variable(4, Shield, 80, 20, ap(1.5))
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

        R.update(P515)
                .active("自身が無敵状態になり、敵からターゲット不能になる。さらに時間を撒き戻し、4秒前にいた地点にテレポートする。その際、{1}し、到着地点の{2}にいる敵に{3}を与える。")
                .variable(1, RestoreHealth, 100, 50, amplify(ReceivedDamage4SecRatio, 20, 0, ap(0.0666)))
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
        P.update(P512).passive("使用したスキルが敵ユニットに命中すると子蜘蛛のチャージが1増加する。");

        Q.update(P516)
                .active("対象の敵ユニットに毒を放ち{1}を与える。ミニオンとモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 40, 35, amplify(TargetCurrentHealthRatio, 4, 0, ap(0.03)))
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

        R.update(P512)
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
        P.update(P512)
                .passive("{3}し{4}する。通常攻撃は追加で{1}を与え、{2}する。")
                .variable(1, MagicDamage, new Refer(R, 10, 10), ap(0.3), null)
                .variable(2, RestoreHealth, new Refer(R, 4, 2), ap(0.1), null)
                .variable(3, MS, 25)
                .variable(4, Range, -425);

        Q.update(P501)
                .active("対象の敵ユニットに飛びつき{1}を与える。ミニオンとモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 60, 40, amplify(TargetMissingHealthRatio, 8, 0, ap(0.03)))
                .variable(2, MagicDamage, 135, 65)
                .cd(6)
                .range(475);

        W.update(P514).passive("子蜘蛛の{1}する。").variable(1, ASRatio, 5, 5).active("3秒間自身と子蜘蛛の{2}する。").variable(2, ASRatio, 60, 20).cd(12);

        E.update(P514)
                .active("自身と子蜘蛛が上空に退避し(ターゲット不可になる)指定の方法で降下する。上空にいる間は射程内の{1}。<br>地面をクリックした場合: 最大2秒間上空に待機し、初期位置へ降下する。この間、敵ユニットをターゲットし裏側に降下できる。<br>敵ユニットをクリックした場合: 即座に下降し裏側に降り立つ。")
                .variable(1, Visionable)
                .cd(26, -3)
                .range(750);

        R.update(P518)
                .passive("変身時にチャージ数に応じた子蜘蛛を召喚する。召喚された子蜘蛛は死亡するとチャージが減るが、Human Formに戻ると再度チャージ状態に戻る。<br>Health: {1}<br>AD: {2}<br>AS: 0.665<br>AR: {3}<br>MR: {4}<br>MS: 355<br>AoEスキルのダメージを{5}低減")
                .variable(1, Value, 85, 0, level(10))
                .variable(2, Value, 10, 5, ap(0.15))
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
        P.update(P506)
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

        W.update(P506)
                .passive("敵チャンピオンにスキルを当てるたびにこのスキルの{1}する。")
                .variable(1, CDDecrease, 1)
                .active("{3}して、3秒間{2}し{4}を得る。敵チャンピオンを{6}たびに、このスキルの{5}する。")
                .variable(2, MSRatio, 30, 10)
                .variable(3, IgnoreSlow)
                .variable(4, IgnoreUnitCollision)
                .variable(6, Takedown)
                .variable(5, CDDecrease)
                .cd(15);

        E.update(P501)
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
        P.update(P418).passive("ユニット(敵味方問わず)にスキルを当てる度に6秒間{1}する。この効果は5回まで累積する。").variable(-1, ASRatio, 10);

        Q.update(P513)
                .active("指定方向に魔法の矢を飛ばし、当たった敵ユニットに{1}を与える。このスキルが命中すると、全てのスキルの{2}。{3}。")
                .variable(1, PhysicalDamage, 35, 20, ap(0.4), ad(1.1))
                .variable(2, CDDecrease, 1)
                .variable(3, OnHitEffect)
                .mana(28, 3)
                .cd(6, -0.5)
                .range(1150);

        W.update(P412)
                .active("指定方向にチャンピオンにのみ当たる貫通するエネルギーを飛ばし、当たった味方チャンピオンは5秒間{1}し、敵チャンピオンには{2}を与える。")
                .variable(1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .mana(50, 10)
                .cd(9)
                .range(1000);

        E.update(P518)
                .active("指定地点にテレポートし、テレポート先から一番近い敵ユニット({1})1体に{2}を与える。")
                .variable(1, Radius, 750)
                .variable(2, MagicDamage, 75, 50, bounusAD(0.5), ap(0.75))
                .mana(90)
                .cd(19, -2)
                .range(475);

        R.update(P301)
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
        P.update(P421).passive(MagicDamage + "を与えるか" + Q + "を使用した敵ユニットに2.5秒間{1}を与える。").variable(1, MRReduction, 10);

        Q.update(P421).active("対象の敵ユニットに{1}を与える。").variable(1, Fear, 1.25, 0.25).mana(65).cd(15, -1).range(575);

        W.update(P503)
                .active("対象の敵ユニットに5秒間毎秒{1}を与え、{2}する。敵が離れる({3})と詠唱が中断される。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 60, 5))
                .variable(3, Radius, 650)
                .mana(80, 10)
                .cd(10, -1)
                .range(575)
                .type(SkillType.Channel);

        E.update(P421)
                .active("対象の敵ユニットにカラスを飛ばし{1}と{2}を与える。カラスは{4}の敵ユニットに4回まで跳ね返り、同一対象にも跳ね返る。ミニオンとモンスターに対しては{3}を与える。")
                .variable(1, MagicDamage, 65, 20, ap(0.45))
                .variable(2, Silence, 1.25)
                .variable(3, MagicDamage, 97.5, 30, ap(0.675))
                .variable(4, Radius, 450)
                .mana(50, 20)
                .cd(15, -1)
                .range(750);

        R.update(P419)
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
        P.update(P515)
                .passive("近くの敵チャンピオンの急所が見えるようになる。急所に通常攻撃を加えると{1}を与え{2}し、1.75秒かけて減衰しながら{3}する。急所は15秒間持続し、一定時間毎に再度見えるようになる。")
                .variable(1, TrueDamage, amplify(TargetMaxHealthRatio, 3, 0, amplify(BounusAD, 0.027, 0, level(0.001))))
                .variable(2, RestoreHealth, 14, 0, level(5.9))
                .variable(3, MSRatio, new ReferPlus(R, 20, 10));

        Q.update(P515)
                .active("指定方向へダッシュし当たった敵に{1}を与える。敵に当たるとこのスキルの{2}する。{3}。")
                .variable(1, PhysicalDamage, 65, 10, amplify(BounusAD, 0.55, 0.15))
                .variable(2, CDDecreaseRatio, 60)
                .variable(3, OnHitEffect)
                .mana(20, 5)
                .cd(16, -2)
                .range(400);

        W.update(P515)
                .active("指定方向に向き剣を構えて0.75秒間無敵になり、その後剣を突き出して当たった全ての敵に{1}を与える。最初に当たった敵チャンピオンには1.5秒間{2}を与える。もし無敵状態の間になんらかの移動阻害効果を受けていた場合、代わりに{3}を与える。")
                .variable(1, MagicDamage, 90, 40, ap(1))
                .variable(2, SlowRatio, 50)
                .variable(3, Stun)
                .mana(50)
                .cd(19, -1);

        E.update(P515)
                .active("2回通常攻撃するまで{1}する。一度目の攻撃はクリティカルにならない代わりに1秒間{2}を与える。二度目の攻撃は必ずクリティカルになり{3}を与える。{4}。")
                .variable(1, ASRatio, 50)
                .variable(2, MSSlowRatio, 25, 10)
                .variable(3, PhysicalDamage, amplify(AD, 1.4, 0.15))
                .variable(4, ResetAATimer)
                .mana(40, 5)
                .cd(15, -2);

        R.update(P515)
                .active("8秒間対象の敵チャンピオンの全ての急所(4箇所)が見えるようになる(この効果中は対象への" + P + "の効果は発動しない)。全ての急所を攻撃するか最低一つの急所を攻撃した上で対象が死ぬと聖なる泉が発生して、{1}の全て味方は5秒間毎秒{2}する。対象の近くにいるか泉の範囲内にいる場合、" + champion + "は{3}する。")
                .variable(1, Radius, 600)
                .variable(2, RestoreHealth, 80, 30, bounusAD(0.6))
                .variable(3, MSRatio, 30, 10)
                .mana(100)
                .cd(110, -20)
                .range(500);
    }

    /**
     * Define skill.
     */
    public static void Fizz(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("{2}を得て、{1}する。この軽減は防御力計算後に行われる。")
                .variable(1, AttackDamageReduction, new Per3Level(4, 2))
                .variable(2, IgnoreUnitCollision);

        Q.update(P517)
                .active("対象の敵ユニットに{1}が付与された通常攻撃を与え、その方向に駆け抜ける。移動距離は固定。{2}。")
                .variable(1, MagicDamage, 10, 15, ap(0.35))
                .variable(2, OnHitEffect)
                .mana(50, 5)
                .cd(10, -1)
                .range(550);

        W.update(P517)
                .passive("通常攻撃に{1}が付与される。このダメージは0.5秒毎に3秒間かけて与えられる。")
                .variable(1, MagicDamage, 20, 10, ap(0.45), amplify(TargetMissingHealthRatio, 4, 1))
                .active("6秒間通常攻撃に{2}を付与する。")
                .variable(2, MagicDamage, 10, 5, ap(0.3))
                .mana(40)
                .cd(10);

        E.update(P413)
                .active("指定地点にジャンプする。ジャンプ中はターゲットされない状態になる。0.75秒後にその場に降下し、{1}の敵ユニットに{2}と2秒間{3}を与える。また、ジャンプ中に再使用することで降下する場所を別の指定地点に変更しできる。その場合、{4}の敵ユニットに{5}を与える。")
                .variable(1, Radius, 330)
                .variable(2, MagicDamage, 70, 50, ap(0.75))
                .variable(3, MSSlowRatio, 40, 5)
                .variable(4, Radius, 270)
                .variable(5, MagicDamage, 70, 50, ap(0.75))
                .mana(90, 10)
                .cd(16, -2)
                .range(400);

        R.update(P517)
                .active("指定地点に敵チャンピオンのみに命中する魚を投げ、命中した敵チャンピオンに魚がくっつき、1.5秒間{1}を与え、6秒間" + champion + "の与える魔法{3}する。1.5秒後に地面から鮫が現れ、魚が命中した対象を襲い、対象とその{4}の敵ユニットに{5}を与え、{6}後に1.5秒間{1}を与える。魚がくっついていた敵チャンピオン以外のユニットには{6}の代わりに{8}を与える。魚がチャンピオンに当たらなかった場合は指定地点に魚が残り、その地点に鮫が現れる。また魚は視界を確保し、その上を敵チャンピオンが通り過ぎると、当たった場合と同様にその敵チャンピオンにくっつき、鮫が襲いかかる。")
                .variable(1, SlowRatio, 50, 10)
                .variable(3, DamageRatio, 20)
                .variable(4, Radius, 250)
                .variable(5, MagicDamage, 200, 125, ap(1))
                .variable(6, Knockup)
                .variable(8, Knockback)
                .mana(100)
                .cd(100, -15)
                .range(1275);
    }

    /**
     * Define skill.
     */
    public static void Galio(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("{1}を得る。").variable(1, AP, amplify(MR, 0.5));

        Q.update(P301)
                .active("指定地点に魔法弾を飛ばし、{1}の敵ユニットに{2}と2.5秒間{3}を与える。")
                .variable(1, Radius, 235)
                .variable(2, MagicDamage, 80, 55, ap(0.6))
                .variable(3, MSSlowRatio, 24, 4)
                .mana(60, 5)
                .cd(7)
                .range(940);

        W.update(P515)
                .active("4秒間対象のチャンピオンは{1}と{2}を得て、効果中にその対象のチャンピオンがダメージを受ける度に自身の{3}する。自身に使用した場合はダメージを受けてから回復される。")
                .variable(1, AR, 30, 15)
                .variable(2, MR, 30, 15)
                .variable(3, RestoreHealth, 25, 15, ap(0.3))
                .mana(60)
                .cd(13)
                .range(800);

        E.update(P506)
                .active("指定方向に風を発生させ、当たった敵ユニットに{1}を与える。このスキルを使用すると指定した方向に5秒間持続する風が残り、その風の進行方向上にいる味方ユニットは{2}する。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, MSRatio, 20, 8)
                .mana(70, 5)
                .cd(13, -1)
                .range(1180);

        R.update(P512)
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

        Q.update(P515)
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

        E.update(P518)
                .passive("{1}毎に火薬樽が貯まる。最大値は{2}。")
                .variable(1, Time, 18, -1)
                .variable(2, Value, new ReferPlus(R, 2, 1))
                .active("60秒間火薬樽を指定の位置に設置する。樽はHP3を持ち、自身か敵チャンピオンが攻撃する若しくは{3}毎にHP1まで1ずつ減少する。HP1の樽を敵が攻撃すると樽は解除される。自身が攻撃すると爆発して、その攻撃が{4}の敵への" + ARPen + "40%を持つ物理範囲攻撃となり、2秒間{5}を与える。敵チャンピオンに対しては追加で{6}を与える。{7}に火薬樽がある場合、爆発は連鎖していく。")
                .variable(3, Time, new Per6Level(2, -0.5))
                .variable(4, Radius, 400)
                .variable(5, Status.MSSlowRatio, 60)
                .variable(6, PhysicalDamage, 60, 30)
                .variable(7, Radius, 650)
                .range(1000)
                .cd(0.25);

        R.update(P514)
                .passive(E + "のスタック最大値が{1}増加する。")
                .variable(1, Value, 1, 1)
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
        P.update(P417)
                .passive("{1}間敵ミニオン以外からダメージを受けない状態が続くと、以降敵ミニオン（Lv11からはバロン・ドラゴン以外のモンスター）以外からダメージを受けるまで毎秒{2}する。")
                .variable(1, Time, new PerLevel(new int[] {1, 11, 16}, new double[] {9, 6, 4}))
                .variable(2, RestoreHealth, amplify(Health, new PerLevel(new int[] {1, 11, 16}, 0.004, 0.008, 0.02)));

        Q.update(P517)
                .active("{1}間{2}し、スキル使用後6秒間に行った次の通常攻撃に追加{3}と{4}が付与される。またこのスキル使用時に自身にかかっているスローを解除する。{5}。")
                .variable(1, Time, 1.5, 0.5)
                .variable(2, MSRatio, 30)
                .variable(3, PhysicalDamage, 30, 25, ad(0.4))
                .variable(4, Silence, 1.5)
                .variable(5, ResetAATimer)
                .cd(8);

        W.update(P516)
                .passive("敵を倒すとスタックが増加する（最大120、チャンピオンや大型モンスターを倒すと4スタック増加）。{1}と{2}を得る。")
                .variable(1, AR, amplify(Stack, 0.25))
                .variable(2, MR, amplify(Stack, 0.25))
                .active("{3}間{4}する。")
                .variable(3, Time, 2, 1)
                .variable(4, DamageReductionRatio, 30)
                .cd(24, -1);

        E.update(P516)
                .active("3秒間回転し{1}を得て、{2}の敵ユニットに一定時間毎に{3}を与える（最大{5}回）。このスキルにはクリティカル判定がある。単一の敵に当たった場合、ダメージが33%増加し{4}を与える。")
                .variable(1, IgnoreUnitCollision)
                .variable(2, Radius, 300)
                .variable(3, PhysicalDamage, 14, 4, amplify(AD, 0.34, 0.01))
                .variable(4, PhysicalDamage, 20, 5, amplify(AD, 0.46, 0.01))
                .variable(5, Value, new Per3Level(5, 1))
                .cd(9);

        R.update(P518)
                .passive(champion + "以外の味方チャンピオンを倒した敵は『悪役』になる（直近の1体のみ）。悪役に対する通常攻撃及び" + E + "は追加で{1}を与える。悪役との戦闘中に悪役が変更されることはない。")
                .variable(1, TrueDamage, amplify(TargetMaxHealthRatio, 1))
                .active("対象の敵チャンピオンに{3}を与える。悪役に対しては{4}を与える。")
                .variable(3, MagicDamage, 175, 175, amplify(TargetMissingHealthRatio, new PerSkillLevel(28.6, 33.3, 40)))
                .variable(4, TrueDamage, 175, 175, amplify(TargetMissingHealthRatio, new PerSkillLevel(28.6, 33.3, 40)))
                .cd(120, -20)
                .range(400);
    }

    /**
     * Define skill.
     */
    public static void Gnar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P503)
                .passive("Mini Gnarの時に戦闘を行うと3秒間かけてRage{1}を得る。通常攻撃と" + Q + "で" + Damage + "を与えると追加で{2}のRageを得る(ミニオン、モンスター及び建物との戦闘の場合は25%)。13秒間戦闘を行わないとRageは減衰していく。Rageが100になった時にスキルを使用または5秒経過すると、Mega Gnarに変身する。Mega Gnarでは近接攻撃になり、スキルが変化する。15秒間経過するとMini Gnarに戻り、Rageは0になる。Mini Gnarに戻ると15秒間Rageが増加しなくなる。<br>Mini Gnar<br>MS: {3}<br>Range: {4}<br>AS: {5}<br>Mega Gnar<br>HP: {6}<br>AR: {7}<br>MR: {8}<br>Hreg: {9}<br>AD: {10}")
                .variable(1, Value, new PerLevel(new int[] {1, 6, 11}, 4, 7, 11))
                .variable(2, Value, new PerLevel(new int[] {1, 6, 11}, 2, 3, 5))
                .variable(3, MS, 9, 0, level(1))
                .variable(4, Range, 245, 0, level(5))
                .variable(5, ASRatio, level(5.5))
                .variable(-6, Health, level(43))
                .variable(-7, AR, level(2))
                .variable(-8, MR, level(2))
                .variable(-9, Hreg, level(2.5))
                .variable(-10, AD, level(2.5));

        Q.update(P501)
                .active("Mini Gnar<br>指定方向にブーメランを投げ、当たった敵ユニットに{1}と2秒間{2}を与える。ブーメランは2hit目以降の敵ユニットには50%のダメージを与える。ブーメランは最大距離まで飛んだ後、自身がいる位置に戻ってくるが、敵ユニットに当たる度に戻るまでの間隔が早くなる。戻ってきたブーメランは少しずつ加速し、戻り始めた位置から距離2500まで飛ぶ。これをキャッチすると、このスキルの{3}する。またブーメランは同一の対象には一度しか命中しない。<br>Mega Gnar<br>指定方向に岩を投げ、当たった敵ユニットと{4}の敵ユニットに{5}と2秒間{2}を与える。投げた岩はその場に留まり、岩を回収するとこのスキルの{6}する。")
                .variable(1, PhysicalDamage, 5, 30, ad(1.15))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, CDDecreaseRatio, new ReferPlus(R, 45, 5))
                .variable(4, Radius, 250)
                .variable(5, PhysicalDamage, 5, 40, ad(1.2))
                .variable(6, CDDecreaseRatio, 60)
                .cd(20, -2.5)
                .range(1100);

        W.update(P420)
                .passive("<br>Mini Gnar<br>通常攻撃かスキルで" + Damage + "を与えた敵ユニットにスタックを付与する。スタック数が3になるとスタックを消費し{1}を与え、3秒間{2}する。この移動速度増加は時間と共に減衰する。建物には無効。また、この移動速度増加はMega GnarからMini Gnarに戻った時にも発動する。")
                .variable(1, MagicDamage, 10, 10, amplify(TargetMaxHealthRatio, 6, 2), ap(1))
                .variable(2, MSRatio, new ReferPlus(R, 30, 15))
                .active("Mega Gnar<br>指定方向に腕を叩き付け{3}の敵ユニットに{4}と{5}を与える。")
                .variable(3, Radius)
                .variable(4, PhysicalDamage, 25, 20, ad(1))
                .variable(5, Stun, 1.25)
                .cd(15, -2);

        E.update(P420)
                .active("Mini Gnar<br>指定地点にジャンプし、3秒間{1}する。指定した地点にユニット(味方可)がいた場合、そのユニットを踏みつけ更にもう一度ジャンプを行う。踏みつけた対象が敵ユニットの場合、対象に{2}と0.5秒{3}を与える。<br>Mega Gnar<br>指定地点にジャンプし、{4}の敵ユニットに{2}を与える。範囲内の中心点にいる敵ユニットには、0.5秒間{3}を与える。")
                .variable(1, ASRatio, 20, 10)
                .variable(2, PhysicalDamage, 20, 40, amplify(Health, 0.06))
                .variable(3, MSSlowRatio, 60)
                .variable(4, Radius)
                .cd(18, -1.5)
                .range(475);

        R.update(P501)
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
        P.update(P405).passive("スキルを使用すると{1}する。").variable(1, RestoreHealth, amplify(Health, 0.04)).cd(-8);

        Q.update(P512)
                .active("指定地点に樽を転がし、爆発時に{1}の敵ユニットに{2}と1.3秒間{3}を与える。樽は4秒経つか、スキルを再度使用すると爆発する。樽は設置後、2秒かけて" + Damage + "と" + Slow + "の効果が最大50%まで増加していく。樽は設置場所の{4}。ミニオンに対しては70％の" + Damage + "を与える。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 80, 40, ap(0.6))
                .variable(3, SlowRatio, 40, 5)
                .variable(4, Visionable)
                .mana(60, 5)
                .cd(11, -1)
                .range(850);

        W.update(P517)
                .active("2.5秒間{1}を得る。1秒詠唱後に次の5秒以内の通常攻撃に{2}が付与される。モンスターに対しては上限300。")
                .variable(1, DamageReductionRatio, 10, 2)
                .variable(2, MagicDamage, 20, 30, ap(0.3), amplify(TargetMaxHealthRatio, 8))
                .cd(8, -1)
                .mana(30);

        E.update(P510)
                .active("指定方向に突進し、衝突した敵ユニットと{4}の敵ユニットに{1}と{2}、{3}を与える。衝突時に突進は止まる。ユニットに当たった場合{4}する。")
                .variable(1, MagicDamage, 80, 40, ap(0.6))
                .variable(2, Knockback)
                .variable(3, Stun, 1)
                .variable(4, CDDecrease, 3)
                .mana(50)
                .cd(12)
                .range(600);

        R.update(P405)
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
        P.update(P301)
                .passive("戦闘状態になると1秒ごとにスタックが1増加し、スタック数に比例して{1}と{2}を得る。スタックは10回まで累積し、3秒間戦闘を行わないと0になる。")
                .variable(1, AR, new Per6Level(1, 1))
                .variable(2, MR, new Per6Level(1, 1));

        Q.update(P508)
                .active("指定方向扇形の範囲に貫通する弾を3発発射し、当たった敵ユニットに{1}を与える。同一対象に対して複数hitし、2発目以降は本来の50%分の" + Damage + "を与える(3発hitで合計{2})。")
                .variable(1, PhysicalDamage, 60, 30, bounusAD(0.75))
                .variable(2, PhysicalDamage, 120, 60, bounusAD(1.5))
                .mana(60, 10)
                .cd(12, -1)
                .range(950);

        W.update(P301)
                .active("指定地点にスモーク弾を発射し{3}の敵ユニットに{1}を与え、4秒間持続する煙幕を残す。煙幕内にいる敵チャンピオンに視界低下と{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.6))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, Radius, 250)
                .mana(70, 5)
                .cd(20, -1)
                .range(950);

        E.update(P405)
                .active("指定方向にダッシュし4秒間{1}する。このスキルは自身が通常攻撃を行う毎に{2}する。対象が建物の場合は無効。")
                .variable(1, ASRatio, 30, 10)
                .variable(2, CDDecrease, 1)
                .mana(40)
                .cd(22, -2)
                .range(425);

        R.update(P415)
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
        P.update(P511)
                .passive("{2}と{1}を得る。")
                .variable(1, AD, amplify(BounusMS, new PerLevel(new int[] {1, 3, 6, 9, 12, 15, 18}, 0.15, 0.025)))
                .variable(2, IgnoreUnitCollision);

        Q.update(P509)
                .active("武器を振り回し{2}の敵ユニットに{1}を与える。このスキルが敵ユニットに命中した場合1スタックを得て、1スタックにつきこのスキルの{4}する(最大2スタック)。スタックは8秒間増加がないと0になる。ミニオンには{3}を与える。")
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.6))
                .variable(2, Radius, 350)
                .variable(3, PhysicalDamage, 40, 23.3, bounusAD(0.4))
                .variable(4, CDDecrease, 1)
                .mana(32, 2)
                .cd(4);

        W.update(P501)
                .active("4秒間{1}の敵ユニットに毎秒{2}を与える。この効果を受けている敵ユニットがダメージを受けた場合、{3}する（ミニオン及びモンスターに対しては{4}が上限）。")
                .variable(1, Radius, 525)
                .variable(2, MagicDamage, 20, 10, ap(0.2))
                .variable(3, RestoreHealth, amplify(DealtDamageRatio, 20))
                .variable(4, Value, 90, 30)
                .mana(50, 10)
                .cd(22, -1);

        E.update(P511)
                .active("3秒間{1}して(最大75%)、その後1秒間その移動速度を維持する。また次の通常攻撃のダメージはこのスキルを使用してから移動した距離に比例し最小で{3}、最大で{4}を与えるようになり、{2}が付与される。")
                .variable(1, MSRatio, 20, 0, amplify(Duration, 18.3))
                .variable(2, Knockback, 300)
                .variable(3, PhysicalDamage, 40, 35, bounusAD(0.5))
                .variable(4, PhysicalDamage, 80, 70, bounusAD(1))
                .mana(60)
                .cd(24, -2);

        R.update(P308)
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
        P.update(P420).passive("{1}の味方ユニットと" + P + "は{2}を得る。").variable(1, Radius, 1000).variable(2, Hreg, new Per4Level(10, 5));

        Q.update(P411)
                .active("スタックを消費して指定地点にTurretを最大3つまで設置する。スタックは{1}毎に増加し、最大{2}まで貯めることが出来る。塔に与えるダメージは半分。Heimerdingerが攻撃する若しくは攻撃されている場合、その対象を優先で攻撃。8秒間砲台と距離1000以上離れていた場合、砲台の動作が停止する。<br>HP: {3}<br>砲撃: {4}　{5}<br>ビーム: {6}　{7}　（16秒毎）<br>AR: {8}<br>MR: {9}<br>AS: 1.75<br>視界: 525")
                .variable(1, CDRAwareTime, 24, -1)
                .variable(2, Stack, new PerSkillLevel(1, 1, 2, 2, 3))
                .variable(3, Value, 125, 0, level(25), amplify(AP, new PerLevel(new int[] {1, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                        18}, 5, 3.5)))
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

        W.update(P313)
                .active("指定地点に目掛けて、5本のミサイルを扇状に発射する。ミサイルが指定地点を通過する後も一直線に飛行し続ける。命中すると{1}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に5発命中すると{2})。ミニオンに対しては60%のダメージを与える。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, MagicDamage, 108, 54, ap(0.81))
                .mana(70, 10)
                .cd(11)
                .range(1100);

        E.update(P301)
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

        R.update(P417)
                .active("次に使用するスキルの効果を強化する。強化されたスキルは一切のコストなしで使用でき、効果はこのスキルのLvに依存する。発動してから3秒間何も使わない場合は再発動可能になり、もう一度使用するとCD3秒でキャンセルする。<br>" + Q + "<br>Turretの上限を無視する特殊なTurretを1個設置する。8秒間持続する。砲撃に100%のスプラッシュダメージと1秒間{1}が付与される。<br>HP: {3}<br>砲撃: {4}　{5}<br>ビーム: {6}　{7}　（6秒毎）<br><br>" + W + "<br>指定地点に目掛けて、5本のミサイルを扇状に4回発射する。命中すると{8}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に20発命中すると{9})。<br><br>" + E + "<br>2回までバウンドしつつ3回放電する手榴弾を投げる。作動した箇所にいる{10}にいる敵ユニットに{11}と2秒間{12}を与え、真ん中のユニットにはさらに{13}を与える。")
                .variable(1, MSSlowRatio, 25)
                .variable(3, Value, 550, 0, level(50), amplify(AP, new PerLevel(new int[] {1, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                        18}, 0.25, 0.175)))
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
        P.update(P301).passive("視界内の敵チャンピオン数に応じて{1}を得る。").variable(-1, Tenacity, new PerChampion(10, 25, 40)).range(1200);

        Q.update(P416)
                .active("対象の敵ユニットに突進し、{1}を与える。このスキルで敵を倒したとき、このスキルの{2}され{3}する。{4}。")
                .variable(1, PhysicalDamage, 20, 30, ad(1))
                .variable(2, CDDecrease)
                .variable(3, RestoreMana, 35)
                .variable(4, OnHitEffect)
                .mana(60, 5)
                .cd(14, -2)
                .range(650);

        W.update(P301)
                .passive("通常攻撃を行う度に{1}する。")
                .variable(1, RestoreHealth, 5, 2)
                .active("6秒間通常攻撃に{2}が付与され、PassiveのHP回復量が倍になる。")
                .variable(2, TrueDamage, 15, 15)
                .mana(40)
                .cd(15);

        E.update(P506)
                .active("対象の敵ユニットに{1}を与える。対象の残HPの割合がIreliaより高かった場合{2}間{3}を与え、低かった場合は{4}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.5))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 60, 0)
                .variable(4, Stun, 1, 0.25)
                .mana(50, 5)
                .cd(8)
                .range(425);

        R.update(P301)
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
        P.update(P504).passive("{1}の全ての味方チャンピオンは{2}する。").variable(1, Range, 1250).variable(2, MSRatio, 8);

        Q.update(P517)
                .active("指定方向に竜巻を発生させ、触れた敵ユニットに{1}と{2}を与える。竜巻は3秒経過するか再度スキル使用で飛ばすことができるが、溜めた時間に比例して" + MagicDamage + "、射程距離、打ち上げ時間が増加する。")
                .variable(1, MagicDamage, 60, 25, ap(0.35), amplify(Duration, 15, 5, ap(0.1)))
                .variable(2, Knockup, 0.5, 0, amplify(Duration, 0.25))
                .mana(90, 15)
                .cd(14, -1)
                .range(new Diff(850, 0, 1), amplify(Duration, 297.5));

        W.update(P504)
                .passive("{1}し{2}を得る。")
                .variable(1, MSRatio, 9, 2, ap(0.02))
                .variable(2, IgnoreUnitCollision)
                .active("対象の敵ユニットに{3}と3秒間{4}を与える（最大で80%）。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .variable(3, MagicDamage, 60, 55, ap(0.5))
                .variable(4, MSSlowRatio, 24, 4, ap(0.06))
                .mana(40, 10)
                .cd(12)
                .range(600);

        E.update(P301)
                .active("対象の味方チャンピオンか塔に5秒間{1}を付与する。シールドが持続している間は対象は{2}を得る。")
                .variable(1, Shield, 80, 40, ap(0.7))
                .variable(2, AD, 14, 9, ap(0.1))
                .mana(70, 10)
                .cd(10)
                .range(725);

        R.update(P517)
                .active("{1}の敵ユニットを{2}して3秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。最大で{4}する。")
                .variable(1, Radius, 725)
                .variable(2, Knockback, 875)
                .variable(3, RestoreHealth, 100, 50, ap(0.5))
                .variable(4, RestoreHealth, 300, 150, ap(1.5))
                .mana(100)
                .cd(150, -15)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void JarvanIV(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P415)
                .passive("通常攻撃に{1}を付与する（400" + Damage + "が上限）。同一の対象には{2}に一度しか発動しない。")
                .variable(1, PhysicalDamage, amplify(TargetCurrentHealthRatio, 10))
                .variable(2, Time, new Per6Level(10, -2));

        Q.update(P504)
                .active("槍を突き出して直線上の敵ユニットに{1}を与え、3秒間{2}を与える。" + E + "の旗にヒットした場合、旗の位置まで突進し、進路上の敵ユニット({4})に{3}を与える。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1.2))
                .variable(2, ARReductionRatio, 10, 4)
                .variable(3, Knockup, 0.75)
                .variable(4, Radius, 180)
                .mana(45, 5)
                .cd(10, -1)
                .range(770);

        W.update(P407)
                .active("5秒間{1}を得て、{2}の敵ユニットに２秒間{3}を与える。")
                .variable(1, Shield, 50, 40, amplify(EnemyChampion, 20, 10))
                .variable(2, Radius, 300)
                .variable(3, MSSlowRatio, 15, 5)
                .mana(30)
                .cd(20, -2);

        E.update(P513)
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

        R.update(P421)
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
        P.update(P301)
                .passive("通常攻撃を行う度にスタックが1増加し、スタック数に比例して{1}する(最大6スタック)。スタックは2.5秒増加がないと0になる。")
                .variable(-1, ASRatio, new Per3Level(4, 2));

        Q.update(P301)
                .active("対象のユニットまで飛びかかる。対象が敵ユニットの場合、{1}を与える。")
                .variable(1, PhysicalDamage, 70, 40, ap(0.6), bounusAD(1))
                .mana(65)
                .cd(10, -1)
                .range(700);

        W.update(P301)
                .active("次の通常攻撃か" + Q + "に{1}を付与する。建物には無効。{2}。")
                .variable(1, MagicDamage, 40, 35, ap(0.6))
                .variable(2, ResetAATimer)
                .mana(30)
                .cd(7, -1);

        E.update(P517)
                .active("2秒間、Jaxが受けるタワー以外の通常攻撃を無効化し、AoEダメージを25%低減、さらに効果終了時に{1}の敵ユニットに{2}と{3}を与える。スキルを使用してから1秒経つと再使用できるようになり、任意に効果を終了できる。通常攻撃を回避する度にこのスキルのダメージが20%ずつ増加する(上限は100%、最大で2倍ダメージ)。")
                .variable(1, Radius, 187.5)
                .variable(2, PhysicalDamage, 50, 25, bounusAD(0.5))
                .variable(3, Stun, 1)
                .mana(50, 10)
                .cd(16, -2);

        R.update(P512)
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
        P.update(P301)
                .passive("{1}と{2}を得る。" + R + "を使用すると1.25秒間{3}し{4}を得る。")
                .variable(1, AR, new Refer(R, 5, 10))
                .variable(2, MR, new Refer(R, 5, 10))
                .variable(-3, MS, 40)
                .variable(4, IgnoreUnitCollision);

        Q.update(P511)
                .active("対象の敵ユニットに飛びかかり、対象と{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 30, 40, bounusAD(1))
                .variable(3, MSSlowRatio, 30, 5)
                .mana(40, 5)
                .cd(16, -2)
                .range(600);

        W.update(P511)
                .passive("通常攻撃すると{1}する。")
                .variable(1, RestoreMana, 6, 2)
                .active("4秒間雷のオーラを身にまとい、{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 285)
                .variable(3, MagicDamage, 25, 15, ap(0.25))
                .mana(40)
                .cd(10);

        E.update(P511)
                .active("対象の敵ユニットに{1}と0.75秒{3}を与える。ミニオンやモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 0, 0, bounusAD(1), amplify(TargetMaxHealthRatio, 8, 2.4))
                .variable(2, MagicDamage, 200, 100)
                .variable(3, Knockback)
                .mana(40, 10)
                .cd(15, -1)
                .range(240);

        R.update(P301)
                .active("射撃形態に変身する。射程が500になり、次の通常攻撃は５秒間{1}と{2}を与える。{3}。")
                .variable(1, ARPenRatio, 10, 5)
                .variable(2, MRPenRatio, 10, 5)
                .variable(3, NotSpellCast);
    }

    /**
     * Define skill.
     */
    public static void JayceTransformed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("{1}する。" + R + "を使用すると1.25秒間{2}し{3}を得る。")
                .variable(1, Range, 375)
                .variable(-2, MS, 40)
                .variable(3, IgnoreUnitCollision);

        Q.update(P511)
                .active("指定方向に{3}の雷のオーブを飛ばし、敵ユニットに命中するか一定距離で爆発し、{4}の敵ユニットに{1}を与える。オーブがAcceleration Gateによって生成されたゲートを通過した場合、弾速、射程距離、爆発範囲、ダメージが各40%増加し{2}を与える。")
                .variable(1, PhysicalDamage, 70, 50, bounusAD(1.2))
                .variable(2, PhysicalDamage, 98, 70, bounusAD(1.68))
                .variable(3, MissileSpeed, 1450)
                .variable(4, Radius)
                .mana(55, 5)
                .cd(8)
                .range(1050);

        W.update(P511)
                .active("４秒間攻撃速度が最大まで上昇する。3回通常攻撃を行うと効果が終了する。また効果中は通常攻撃で与えるダメージが{1}%になる。")
                .variable(1, Percentage, 70, 8)
                .mana(40)
                .cd(13, -1.6);

        E.update(P511)
                .active("4秒間持続するゲート(通りぬけ可能)を生成し、触れた味方ユニットは3秒間{1}する。移動速度は3秒かけて元に戻る。")
                .variable(1, MSRatio, 30, 5)
                .mana(50)
                .cd(16)
                .range(650);

        R.update(P301)
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
        P.update(P413).passive("攻撃した敵チャンピオンまたはタワーが3秒以内に死亡/破壊された場合、4秒間{1}する。移動速度は4秒かけて減衰する。").variable(-1, MSRatio, 175);

        Q.update(P510)
                .passive("通常攻撃毎にスタックが貯まる。スタック2.5秒持続して最大3スタックで{1}し、また{2}する。" + AS + "の増加量はスタック1で5割、スタック2で7割5分、スタック3で10割となる。攻撃を行わないと、2.5秒毎に1つずつ減少していく。このスキルを使用するとスタックによる攻撃速度増加は無効になる。")
                .variable(-1, ASRatio, 30, 10)
                .variable(-2, ASRatio, new PerLevel(0, 2, 4, 6, 8, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70))
                .active("通常攻撃は{3}し{4}が付与され、対象の{5}にいる敵にも同様のダメージを与えるようになる。")
                .variable(3, Range, 75, 25)
                .variable(4, PhysicalDamage, 0, 0, ad(0.1))
                .variable(5, Radius, 150)
                .mana(20)
                .cd(0.9)
                .type(SkillType.ToggleForAttack);

        W.update(P313)
                .active("0.6秒詠唱後、指定方向に電撃を放ち、当たった敵ユニットに{1}と2秒間{2}を与え、2秒間そのユニットの{3}。")
                .variable(1, PhysicalDamage, 10, 50, ad(1.4))
                .variable(2, MSSlowRatio, 30, 10)
                .variable(3, Visionable)
                .mana(50, 10)
                .cd(10, -1)
                .range(1500);

        E.update(P401)
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

        R.update(P508)
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
        P.update(P513)
                .passive("専用アイテムを使用して、味方チャンピオンに使用すると「魂盟の同志」となる。この効果は試合開始3分までは、他のチャンピオンに付け直すことができる。通常攻撃の" + Damage + "が10%低下しキャンセル不可能になるが、通常攻撃を行った直後、又は" + P + "を使用した直後に移動を行うと、移動の代わりに一定距離ステップする。ステップの距離は所有している靴アイテムのランクにより増加する。<br>靴なし: 250<br>" + Item.BootsOfSpeed + ": 300<br>それ以外: 350");

        Q.update(P514)
                .active("槍を投げ、命中した敵に{1}を与える。このスキルの攻撃は、" + P + "、" + W + "、および" + E + "の効果を発動する。命中した敵を倒すと槍が貫通し、次に命中した敵に{1}と倒した敵に貯まっていた" + E + "のスタックを与える。")
                .variable(1, PhysicalDamage, 10, 60, ad(1))
                .cd(8)
                .mana(50, 5)
                .range(1200);

        W.update(P517)
                .passive("自身と「魂盟の同志」が同じ対象に対し2秒以内に通常攻撃をすると、{1}を与える。ミニオンとモンスターに対しては{2}が上限。この効果は同一の対象には10秒に一度しか発動しない。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 10, 2.5))
                .variable(2, MagicDamage, 75, 50)
                .active("スタックを1消費し、指定地点を偵察する霊魂を放つ。霊魂は攻撃能力を持たないが、スキルを使用した地点から指定した地点の間を巡回し、敵チャンピオンに接触した場合、4秒間対象の{3}。スタックの最大値は2、{4}ごとに1増加する。霊魂は7往復後に消滅。")
                .variable(3, Visionable)
                .variable(4, CDRAwareTime, 90, -10)
                .mana(25)
                .cd(30)
                .range(5000);

        E.update(P421)
                .passive("通常攻撃か" + P + "が命中すると対象に4秒間槍スタックが貯まる。(CD中を除く)。")
                .active("槍スタックが付与されている全ての敵のスタックを消費し、{1}と2秒間{2}を与える。槍スタックが2以上の場合、それぞれにつきダメージが50％上昇する。このスキルで敵ユニットを倒した場合、このスキルの{3}、倒した敵ユニット一体につき{4}する（上限40）。")
                .variable(1, PhysicalDamage, 20, 10, ad(0.6))
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, CDDecrease)
                .variable(4, RestoreMana, 20)
                .mana(40)
                .cd(14, -1.5);

        R.update(P517)
                .active("「魂盟の同志」を自分の元へ引き寄せる。引き寄せられた同士はその後4秒間敵からターゲットされなくなるが、その間は行動不能になる。 魂盟の同志はマウスでクリックした地点({3})に向かって跳躍する。このとき、最初に命中した敵のチャンピオンの位置で停止し、{1}の敵全員に{2}を与える。同士はその後、敵の射程距離の限界点に着地する。自身と魂盟の同志の間の距離が1400以内のときのみ発動できる。")
                .variable(1, Radius)
                .variable(2, Knockup, 1.5, 0.25)
                .variable(3, Radius, 1200)
                .mana(100)
                .cd(120, -30)
                .range(1400);
    }

    /**
     * Define skill.
     */
    public static void Karma(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P510)
                .passive("敵チャンピオンにスキルでダメージを与えた場合" + R + "の{1}し、通常攻撃でダメージを与えた場合は{2}する。")
                .variable(1, CDDecrease, new Per6Level(2, 0.5))
                .variable(2, CDDecrease, new Per6Level(1, 0.25));

        Q.update(P308)
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

        W.update(P517)
                .active("対象の敵チャンピオンかモンスターと自身を繋ぐビームを発生させる。0.66秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。" + R + "を付与した場合、{3}する。2秒間ビームが持続していた場合、追加で{3}し、" + Snare + "の時間が{4}増加する。")
                .variable(1, MagicDamage, 20, 50 / 3, ap(0.3))
                .variable(2, Snare, 1, 0.25)
                .variable(3, RestoreHealth, amplify(MissingHealthRatio, 20, 0, ap(0.01)))
                .variable(4, Time, new Refer(R, 0.5, 0.25))
                .mana(65, 10)
                .cd(12)
                .range(675);

        E.update(P510)
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

        R.update(P417).active("8秒以内に使用する次のスキルに" + R + "を付与する。").cd(45, -3);
    }

    /**
     * Define skill.
     */
    public static void Karthus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P404).passive("死亡後7秒間スキルが使用可能。この状態ではスキルコストがなくなる。");

        Q.update(P410)
                .active("指定地点を0.5秒後に爆発させ{1}の敵ユニットに{2}を与える。対象が1体の場合は{3}を与える。また、指定地点の{4}。")
                .variable(1, Radius, 50)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 80, 40, ap(0.6))
                .variable(4, Visionable)
                .mana(20, 6)
                .cd(1)
                .range(875);

        W.update(P505)
                .active("指定地点に{3}の通りぬけ可能な壁を5秒間生成し、触れた敵ユニットに５秒間{1}と{2}を与える。スローの効果は5秒かけて元に戻る。また、指定地点の{4}。")
                .variable(1, MRReductionRatio, 15)
                .variable(2, MSSlowRatio, 40, 10)
                .variable(3, Length, 800, 100)
                .variable(4, Visionable)
                .mana(100)
                .cd(18)
                .range(1000);

        E.update(P310)
                .passive("敵ユニットを倒すと{1}する。")
                .variable(1, RestoreMana, 20, 7)
                .active("{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 425)
                .variable(3, MagicDamage, 30, 20, ap(0.2))
                .mana(30, 12)
                .cd(0.5)
                .type(SkillType.Toggle);

        R.update(P411)
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
        P.update(P404).passive("{1}を得て、{2}する。").variable(1, IgnoreUnitCollision).variable(2, MagicDamageReductionRatio, 15);

        Q.update(P503)
                .active("対象の敵ユニットに{1}を与え、詠唱及びチャネリングを解除する。1.5秒間{2}を得る。")
                .variable(1, MagicDamage, 70, 25, ap(0.7))
                .variable(2, MagicShield, 40, 30, ap(0.3))
                .mana(70, 5)
                .cd(9)
                .range(650);

        W.update(P412)
                .passive("通常攻撃に{1}を付与する。建物には無効。")
                .variable(1, MagicDamage, 20, 0, ap(0.1))
                .active("次の通常攻撃は射程が50伸び、{2}を与え{3}する。対象がチャンピオンの場合は回復量が5倍になる。建物には無効。")
                .variable(2, MagicDamage, 40, 25, ap(0.6))
                .variable(3, RestoreMana, 0, 0, amplify(MissingManaRatio, 4, 1))
                .cd(9);

        E.update(P412)
                .active("指定方向扇形80°の{1}の敵ユニットに{2}と1秒間{3}を与える。近くのチャンピオン(敵味方自分問わず)がスキルを使用するとスタックが増え、6スタックまで溜まると使用可能。スキル使用時にスタックは0になる。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 80, 25, ap(0.7))
                .variable(3, MSSlowRatio, 50, 10)
                .mana(80)
                .cd(6);

        R.update(P516)
                .active("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに追加で{3}を与え、マナコストが倍増する(最大4スタック)。スタックは15秒間増加がないと0になる。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 80, 20, ap(0.2), amplify(Mana, 0.02))
                .variable(3, MagicDamage, 40, 10, ap(0.1), amplify(Mana, 0.01))
                .mana(50)
                .cd(6, -2)
                .range(500);
    }

    /**
     * Define skill.
     */
    public static void Katarina(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P504).passive(Damage + "を与えてから3秒以内に敵チャンピオンが死亡すると、全てのスキルの{1}する。").variable(1, CDDecrease, 15);

        Q.update(P301)
                .active("対象の敵ユニットにナイフを飛ばし{1}と４秒間Debuffを与える。ナイフは近くの敵ユニット({2})に4回まで跳ね返り、その度にダメージとDebuffを与える。ナイフが与えるダメージは跳ね返る度に10%低下する。Debuffが付与された敵ユニットに通常攻撃またはスキルでダメージを与えると、付与されたDebuffを消費して{3}を与える。")
                .variable(1, MagicDamage, 60, 25, ap(0.45))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 15, 15, ap(0.15))
                .cd(10, -0.5)
                .range(675);

        W.update(P301)
                .active("{1}にいる敵ユニットに{2}を与える。このスキルが敵チャンピオンに命中した場合、1秒間{3}する。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 40, 35, ap(0.25), bounusAD(0.6))
                .variable(3, MSRatio, 15, 5)
                .cd(4);

        E.update(P511)
                .active("対象のユニットの後方までワープし、それが敵ユニットの場合は{1}を与える。また1.5秒間{2}する。")
                .variable(1, MagicDamage, 40, 30, ap(0.25))
                .variable(2, DamageReductionRatio, 15)
                .cd(12, -1.5)
                .range(700);

        R.update(P420)
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
        P.update(P303)
                .passive("敵チャンピオンに通常攻撃を行う度に、{1}と{2}を与える。この効果は5秒間持続し、5回までスタックする。")
                .variable(1, ARReductionRatio, 3)
                .variable(2, MRReductionRatio, 3);

        Q.update(P402)
                .active("{1}の光の弾を放ち、対象の敵ユニットに{2}、3秒間{3}と" + P + "のDebuffを与える。")
                .variable(1, MissileSpeed, 1500)
                .variable(2, MagicDamage, 60, 50, ap(0.6), bounusAD(1))
                .variable(3, MSSlowRatio, 35, 5)
                .mana(70, 5)
                .cd(8)
                .range(650);

        W.update(P402)
                .active("対象の味方チャンピオンは{1}し、3秒間{2}する。")
                .variable(1, RestoreHealth, 60, 45, ap(0.45))
                .variable(2, MSRatio, 18, 3, ap(0.07))
                .mana(60, 10)
                .cd(15)
                .range(900);

        E.update(P513)
                .passive("通常攻撃に{1}を付与する。")
                .variable(1, MagicDamage, 10, 5, ap(0.15))
                .active("10秒間{2}する。更に通常攻撃に{1}が付与され、{3}のスプラッシュ効果が付く。塔を攻撃する時はスプラッシュ効果は発生しない。")
                .variable(2, Range, 400)
                .variable(3, Radius, 150)
                .mana(45)
                .cd(16);

        R.update(P413).active("対象の味方チャンピオンを{1}間無敵(ダメージ無効)にする。").variable(1, Time, 2, 0.5).cd(90, -15).range(900);
    }

    /**
     * Define skill.
     */
    public static void Kennen(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P513)
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは6秒間増加がないと0になる。同一の敵チャンピオンを7秒以内に2度スタンさせると、{3}を与える。")
                .variable(1, Stun, 1.25)
                .variable(2, RestoreEnergy, 25)
                .variable(3, Stun, 0.5);

        Q.update(P301)
                .active("指定方向に手裏剣を飛ばし、当たった敵ユニットに{1}と雷スタックを与える。")
                .variable(1, MagicDamage, 75, 40, ap(0.75))
                .cd(8, -1)
                .range(1050)
                .cost(Energy, 65, -5);

        W.update(P513)
                .passive("通常攻撃5回毎に{1}と雷スタックを与える。")
                .variable(1, MagicDamage, 0, 0, ad(0.4))
                .active("{3}の雷スタックの付与されている敵ユニットに{2}と雷スタックを与える。")
                .variable(3, Radius, 800)
                .variable(2, MagicDamage, 65, 30, ap(0.55))
                .cd(14, -2)
                .cost(Energy, 45, 0);

        E.update(P301)
                .active("2秒間{1}し{6}を得る。この間は通常攻撃が不可能になり、" + champion + "に触れた敵ユニットに{2}と雷スタックを与え、一度だけ{3}する。また、4秒間{4}と{5}を得る。ミニオンやモンスターに与えるダメージは半分になる。")
                .variable(1, MSRatio, 100)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .variable(3, RestoreEnergy, 40)
                .variable(4, AR, 10, 10)
                .variable(5, MR, 10, 10)
                .variable(6, IgnoreUnitCollision)
                .cd(10, -1)
                .cost(Energy, 100, -5);

        R.update(P503)
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
        P.update(P308)
                .passive(champion + "が敵チームの視界から消えた時に発動する。敵チャンピオンに対する次の通常攻撃に{1}と2秒間{2}を付与する。この効果は敵チームの視界に現れても効果が消費されるまでは失われない。")
                .variable(1, MagicDamage, new PerLevel(15, 20, 25, 35, 45, 55, 65, 75, 85, 95, 110, 125, 140, 150, 160, 170, 180, 190), ap(0.5), null)
                .variable(2, MSSlowRatio, 25);

        Q.update(P511)
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

        W.update(P508)
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

        E.update(P403)
                .active("指定地点にジャンプし、{1}の敵ユニットに{2}を与える。<br>進化すると射程が300増加し、{3}場合にこのスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 65, 35, bounusAD(0.2))
                .variable(3, Takedown)
                .variable(4, CDDecrease)
                .mana(50)
                .cd(20, -2)
                .range(600);

        R.update(P407)
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
        P.update(P301)
                .passive("死亡すると4秒後に自爆して{2}の敵ユニットに{1}を与える。自爆するまでの間は徐々に移動速度が増加する(最大時40%増加)。")
                .variable(1, TrueDamage, 100, 0, level(25))
                .variable(2, Radius);

        Q.update(P413)
                .passive("{1}する。")
                .variable(1, ASRatio, 10, 5)
                .active("対象の敵ユニットに{2}を与え、4秒間{3}と{4}を与える。")
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .variable(3, ARReductionRatio, 12, 4)
                .variable(4, MRReductionRatio, 12, 4)
                .mana(60)
                .cd(8)
                .range(1000);

        W.update(P404)
                .active("8秒間通常攻撃の{1}し、通常攻撃時に{2}を追加で与える。")
                .variable(1, Range, 130, 20)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 2, 1, ap(0.01)))
                .mana(50)
                .cd(17);

        E.update(P414)
                .active("指定方向に貫通する弾を発射し、当たった敵ユニットに{1}と1秒間{2}を与える。弾の通過点に4秒間持続する液体が残り、その上にいる敵ユニットに{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, MSSlowRatio, 20, 8)
                .mana(80, 10)
                .cd(12)
                .range(1280);

        R.update(P414)
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
        P.update(P419)
                .passive("HPが40%以下になったとき{2}状態になり、自分の分身を作り出す。分身は8秒間持続し、分身が敵にダメージを与えることはできない。{1}。")
                .variable(1, CDRUnaware)
                .variable(2, Stealth, 1)
                .cd(-60);

        Q.update(P301)
                .active("対象の敵ユニットに{1}と3.5秒間持続するマークを付与する。マークが付いている間に再度スキルでダメージを与えると、マークを消費して{1}を与える。")
                .variable(1, MagicDamage, 55, 25, ap(0.4))
                .mana(50, 10)
                .cd(6)
                .range(700);

        W.update(P516)
                .active("指定地点まで高速で移動し（速度1450）、移動先の{1}にいる敵ユニットに{2}を与える。3秒間以内にもう一度このスキルを使用すると元居た地点に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .mana(80, 5)
                .cd(18, -2)
                .range(600);

        E.update(P511)
                .active("指定方向に鎖を放ち、当たった敵ユニットに{1}を与え対象と鎖で繋がれ、その間{2}を与える。1.5秒間対象が鎖の範囲内(範囲1000)に留まっていた場合、対象に{1}と{3}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.5))
                .variable(2, MSSlowRatio, 25)
                .variable(3, Snare, 1.5)
                .mana(80)
                .cd(14, -1.5)
                .range(950);

        R.update(P506)
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
        P.update(P516)
                .passive("スキルを使用すると{1}し通常攻撃の度に{2}する（一撃目は20、二撃目は10）。この効果は3秒経つか2回通常攻撃を行うと解消される。")
                .variable(-1, ASRatio, 40)
                .variable(2, RestoreEnergy);

        Q.update(P301)
                .active("指定方向に気を飛ばし当たった敵ユニットに{1}を与える。このスキルが敵ユニットに当たった場合、3秒間対象の{5}、下記のスキルを使用できる。<br><br>{2}を消費して、" + Q + "が当たった{3}の敵ユニットにダッシュし、{4}を与える。(追加ダメージはミニオンやモンスターに対して400ダメージが上限)")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.9))
                .variable(2, Energy, 30)
                .variable(3, Radius, 1300)
                .variable(4, PhysicalDamage, 50, 30, bounusAD(0.9), amplify(Status.TargetMissingHealthRatio, 8))
                .variable(5, Visionable)
                .cd(11, -1)
                .range(1100)
                .cost(Energy, 50, 0);

        W.update(P413)
                .active("対象の味方ユニットまで移動する。自身及び対象（味方チャンピオンに限る）は５秒間{1}を得る。このスキル使用後3秒間、下記のスキルが使用できる。<br><br>{2}を消費して、5秒間{3}と{4}を得る。")
                .variable(1, Shield, 40, 40, ap(0.8))
                .variable(2, Energy, 30)
                .variable(3, LS, 5, 5)
                .variable(4, SV, 5, 5)
                .cd(14)
                .cost(Energy, 50, 0)
                .range(700);

        E.update(P413)
                .active("{1}の敵ユニットに{2}を与え、4秒間そのユニットの{3}。このスキルが敵ユニットに当たった場合、3秒間下記のスキルが使用できる。<br><br>{4}を消費して、" + E + "が当たった{5}の敵ユニットに４秒間かけて減衰する{6}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 60, 35, bounusAD(1))
                .variable(3, Visionable)
                .variable(4, Energy, 30)
                .variable(5, Radius, 500)
                .variable(6, MSSlowRatio, 20, 10)
                .cd(10)
                .cost(Energy, 50, 0);

        R.update(P301)
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
        P.update(P301)
                .passive("スキルでダメージを与えた敵ユニットに、3.5秒間持続するDebuffを付与する。この敵ユニットに対して" + champion + "以外の味方チャンピオンがダメージを与えると、付与されたDebuffを消費して{1}を与える。")
                .variable(1, MagicDamage, new Per2Level(20, 15));

        Q.update(P301)
                .active("次の通常攻撃に{1}と{2}を付与する。")
                .variable(1, MagicDamage, 40, 30, ap(0.3))
                .variable(2, Stun, 1.25)
                .mana(45, 5)
                .cd(11, -1);

        W.update(P405)
                .active("3秒間{1}と{2}を得て、効果終了時に{3}の敵ユニットに{4}を与える。" + MagicDamage + "が敵ユニットに命中した場合、効果時間が3秒延長される。")
                .variable(1, AR, 20, 10, amplify(BounusAR, 0.2))
                .variable(2, MR, 30, 10, amplify(BounusMR, 0.2))
                .variable(3, Radius, 275)
                .variable(4, MagicDamage, 60, 50, ap(0.4))
                .mana(60)
                .cd(14);

        E.update(P510)
                .active("指定方向に貫通するエネルギーを飛ばし当たった敵ユニットに{1}を与える。このスキルが敵チャンピオンに命中した場合、その敵チャンピオンの元まで移動する。また移動中は対象の敵チャンピオンに" + Snare + "を与える。複数の敵チャンピオンに命中した場合は最後に命中した敵チャンピオンの元に移動する。")
                .variable(1, MagicDamage, 60, 40, ap(0.4))
                .mana(60)
                .cd(13, -1)
                .range(875);

        R.update(P415)
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
        P.update(P306).passive("次に使うスキルのコストが0になる。" + E + "以外のスキルを敵ユニットに命中させるたびに、このスキルの{1}。").variable(1, CDDecrease, 1).cd(-18);

        Q.update(P505)
                .active("指定方向に敵に当たると砕ける氷の槍を飛ばし、当たった敵ユニットに{1}と1.5秒間{2}を与える。槍の破片は貫通し、後方{3}の敵に{1}を与える。")
                .variable(1, MagicDamage, 70, 30, ap(0.65))
                .variable(2, MSSlowRatio, 16, 3)
                .variable(3, Radius, 100)
                .mana(85)
                .cd(6, -0.75)
                .range(725);

        W.update(P413)
                .active("{1}にいる全ての敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 70, 40, ap(0.4))
                .variable(3, Snare, 1.1, 0.1)
                .mana(50)
                .cd(14, -1);

        E.update(P504)
                .active("指定方向に貫通する氷の爪を飛ばし、当たった敵ユニットに{1}を与える。氷の爪が出ている間にこのスキルを再度使用すると、氷の爪の位置までワープし氷の爪が消滅する。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .mana(80, 5)
                .cd(24, -3)
                .range(1050);

        R.update(P516)
                .active("対象の敵チャンピオンに{1}と{2}を与え、同時に対象の周囲に3秒間持続するDark Iceを呼び出し、Dark Iceに触れた敵ユニットに{1}と{3}を与える。このスキルは自身を対象とする事が可能で、自身を対象とした場合は{4}間行動出来なくなる代わりに、ダメージを無効化かつターゲット不可状態になり、自身の周囲からDark Iceが出現し、{5}する（この効果は失った" + Health + "1%毎に効果量が1%上昇する）。")
                .variable(1, MagicDamage, 150, 100, ap(0.7))
                .variable(2, Stun, 1.5)
                .variable(3, MSSlowRatio, 30, 15)
                .variable(4, Time, 2.5)
                .variable(5, RestoreHealth, 100, 50, ap(0.3))
                .mana(100)
                .cd(130, -25)
                .range(550);
    }

    /**
     * Define skill.
     */
    public static void Lucian(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P516)
                .passive("スキルを使用した次の通常攻撃が2回攻撃になる。この効果は通常攻撃を行うか、3秒経過すると解消される。2回目の攻撃は{1}を与えるが、対象がミニオンかモンスターの場合は2倍になる。2回攻撃の1発目で対象が死亡した場合、2発目は近くのユニットを攻撃する。")
                .variable(1, PhysicalDamage, amplify(AD, new Per5Level(0.3, 0.1)));

        Q.update(P412)
                .active("対象の敵ユニットに向けて0.35秒後に光のボルトを放ち、対象とその直線状({1})にいるすべての敵ユニットに{2}を与える。")
                .variable(1, Length, 1100)
                .variable(2, PhysicalDamage, 80, 30, amplify(BounusAD, 0.6, 0.15))
                .mana(50, 5)
                .cd(9, -1)
                .range(550);

        W.update(P516)
                .active("指定方向に爆発する弾を放つ。敵ユニットに当たるか最大距離まで飛ぶと十字型に爆風が広がり、範囲内の敵ユニットに{1}と6秒間マークを与える。マークが付いた敵ユニット味方がダメージを与えると、その味方は1秒間{2}する。また爆風が発生した地点の{3}。")
                .variable(1, MagicDamage, 60, 40, ap(0.9))
                .variable(2, MS, 60, 5)
                .variable(3, Visionable)
                .mana(50)
                .cd(14, -1)
                .range(1000);

        E.update(P418)
                .active("指定方向にダッシュする。" + P + "による通常攻撃がヒットする度に、このスキルの{2}し、対象が敵チャンピオンの場合は{3}。{4}。")
                .variable(1, CDDecrease)
                .variable(2, CDDecrease, 1)
                .variable(3, CDDecrease, 2)
                .variable(4, ResetAATimer)
                .mana(40, -10)
                .cd(18, -1)
                .range(425);

        R.update(P419)
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
        P.update(P315)
                .passive("Pixという妖精がお供になる。Pixが付いている味方チャンピオンが通常攻撃を行った場合、Pixは同一の敵ユニットの方向に3発の弾を放ち1発毎に{1}を与える。この弾は敵ユニットを追尾するが、弾の進行方向上にいる敵ユニットにも当たる。建物を攻撃した場合はPixは弾を撃たない。")
                .variable(1, MagicDamage, new Per2Level(3, 4), ap(0.05), null);

        Q.update(P413)
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間かけて減衰する{3}を与える。Pixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .variable(1, MagicDamage, 80, 45, ap(0.5))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 80)
                .mana(60, 5)
                .cd(7)
                .range(925);

        W.update(P414)
                .active("味方チャンピオンに使用した場合、対象の味方チャンピオンは{1}間{2}を得る。敵チャンピオンに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、{4}する。")
                .variable(1, Time, 3, 0.5)
                .variable(2, MSRatio, 30, 0, ap(0.1))
                .variable(3, Time, 1.25, 0.25)
                .variable(4, MSReduction, 60)
                .mana(65)
                .cd(18, -1.5)
                .range(650);

        E.update(P405)
                .active("味方ユニットに使用した場合、6秒間対象の味方ユニットにPixを付けると同時に{1}を付与する。敵ユニットに使用した場合、Pixが敵ユニットに付くと同時に{2}を与え、4秒間その敵ユニットの{3}。")
                .variable(1, Shield, 80, 40, ap(0.6))
                .variable(2, MagicDamage, 80, 30, ap(0.4))
                .variable(3, Visionable)
                .mana(60, 10)
                .cd(10)
                .range(650);

        R.update(P315)
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
        P.update(P413)
                .passive("スキルでダメージを与えた敵ユニットに6秒間持続するDebuffを付与する。この敵ユニットに対して通常攻撃か" + R + "でダメージを与えると、付与されたDebuffを消費して{1}を与える。")
                .variable(1, MagicDamage, 10, 0, level(8), ap(0.2));

        Q.update(P517)
                .active("指定方向に光の玉を飛ばし、当たった敵ユニットに{1}と{2}を与える。光の玉は一度だけ敵ユニットを貫通し、2体目のユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, Snare, 2)
                .mana(50, 5)
                .cd(15, -1)
                .range(1175);

        W.update(P512)
                .active("指定方向に杖を投げ、自身と当たった味方チャンピオンに{1}を付与する。行きと帰りそれぞれに判定があり、シールドは3秒間持続する。このシールドはスタックしない。")
                .variable(1, Shield, 80, 25, ap(0.35))
                .mana(60)
                .cd(14, -1)
                .range(1075);

        E.update(P512)
                .active("指定地点に光の玉を設置し、{1}の敵ユニットに{2}を与える。光の玉は5秒経つか再度スキルを使用する事で爆発し、{1}の敵ユニットに{3}を与える。光の玉は{4}。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 20, 4)
                .variable(3, MagicDamage, 60, 45, ap(0.6))
                .variable(4, Visionable)
                .mana(70, 15)
                .cd(10)
                .range(1100);

        R.update(P506)
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
        P.update(P407).passive("{2}間ダメージを受けないと{1}を得る。").variable(1, Shield, amplify(Health, 0.1)).variable(2, Time, new Per6Level(10, -2));

        Q.update(P301)
                .active("対象の敵ユニットに{1}と4秒間{2}を与える。また、このスキルで減少させた移動速度を自身の移動速度に加算する。")
                .variable(1, MagicDamage, 70, 50, ap(0.6))
                .variable(2, MSSlowRatio, 14, 3)
                .mana(70, 5)
                .cd(8)
                .range(625);

        W.update(P512)
                .passive("{1}する。")
                .variable(1, ARRatio, 10, 5)
                .variable(2, PhysicalDamage, amplify(AD, 0.3, 0.08))
                .active("6秒間、通常攻撃時に対象と{2}のユニットに対して、{3}を与える。")
                .variable(2, Radius, 225)
                .variable(3, PhysicalDamage, 15, 15, ap(0.1), amplify(AR, 0.1))
                .mana(25)
                .cd(14);

        E.update(P301)
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 40, ap(0.2), amplify(AR, 0.3))
                .variable(3, ASSlowRatio, 30, 5)
                .mana(50, 5)
                .cd(7);

        R.update(P301)
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
        P.update(P405)
                .passive("スキルを4回使う度にVoidlingを召喚する。Voidlingは21秒間持続し、7秒後にADとARが1.5倍、14秒後にASが2倍に増加する。任意の操作不可。攻撃対象は、" + R + "を掛けた相手、" + E + "を掛けた相手、" + champion + "がターゲットしている相手の順。<br>Health: {1}<br>AD: {2}<br>AR: 30<br>MR: 50<br>AS: 0.831<br>MS: 451")
                .variable(1, Value, 200, 0, level(50))
                .variable(2, Value, 20, 0, level(5), bounusAD(1));

        Q.update(P310)
                .active("指定した地点の左右から挟み込む様に2本の波動が出現し、当たった敵ユニットに{1}と{2}を与える。また、指定した場所の{3}。")
                .variable(1, MagicDamage, 80, 55, ap(0.8))
                .variable(2, Silence, 1.4, 0.4)
                .variable(3, Visionable)
                .mana(80, 5)
                .cd(9)
                .range(900);

        W.update(P306)
                .active("指定地点に5秒間持続する{1}のダメージゾーンを発生させ、上にいる敵ユニットに毎秒{2}を与える。(ミニオンやモンスターに対しては毎秒120ダメージが上限)")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 4, 1, ap(0.01)))
                .mana(90, 5)
                .cd(14)
                .range(800);

        E.update(P310)
                .active("対象の敵ユニットに4秒間0.5秒毎に{1}を与える（合計{2}）。効果中に敵ユニットが死亡した場合、{3}し、近くの敵ユニットに効果が移り変わる。移る度に4秒のタイマーはリセットされる。")
                .variable(1, MagicDamage, 10, 7.5, ap(0.1))
                .variable(2, MagicDamage, 80, 60, ap(0.8))
                .variable(3, RestoreMana, 10, 4)
                .mana(60, 15)
                .cd(15, -2)
                .range(650);

        R.update(P408)
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
        P.update(P507)
                .passive("近くのチャンピオン(敵味方自分問わず)がスキルを使用するとスタックが増え、5スタックまで溜まった状態で通常攻撃を行うとスタックを消費して{1}する。建物を攻撃した場合は発動しない。")
                .variable(1, RestoreHealth, amplify(Health, new Per6Level(0.05, 0.01)));

        Q.update(P411)
                .active("{1}の敵ユニットと指定方向の敵ユニットに{2}と1.5秒間{3}を与える。{4}の敵ユニットには更に{5}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, MSSlowRatio, 20, 7)
                .variable(4, Radius, 100)
                .variable(5, Knockback)
                .mana(45)
                .cd(6)
                .range(600);

        W.update(P414)
                .active("対象の敵ユニットまで高速移動し{1}と{2}を与える（ミニオンやモンスターに対しては300ダメージが上限）。移動中はターゲット不可状態になる。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 9, 1, ap(0.03)))
                .variable(2, Snare, 1, 0.25)
                .mana(75)
                .cd(13, -1)
                .range(525);

        E.update(P411)
                .active("指定地点に苗木を投げ、{1}の敵ユニットに{2}を与える。苗木は最大35秒間その場で待機し、敵ユニットが近付く({4})と相手に向かって移動を開始する、敵に接触するか数秒経つと爆発して{1}に{3}と1秒間{5}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 40, 20, ap(0.4))
                .variable(3, MagicDamage, 80, 40, ap(0.6))
                .variable(4, Radius, 350)
                .variable(5, MSSlowRatio, 50)
                .mana(60, 10)
                .cd(12)
                .range(1100);

        R.update(P517)
                .passive("指定地点の{1}にシールドを展開し、範囲内の味方チャンピオンは{2}を得る(タワーからの攻撃以外)。10秒経過するか再度スキルを使用すると解除され、範囲内の敵ユニットに{3}を与える（増加ダメージは{4}が上限）。")
                .variable(1, Radius)
                .variable(2, DamageReductionRatio, 20)
                .variable(3, MagicDamage, 100, 50, ap(0.5), amplify(ReceivedDamageRatio, 0.1))
                .variable(4, Value, 100, 50)
                .cost(Mana, new PerSkillLevel(40), amplify(Duration, 30))
                .cd(60, -10)
                .range(475);
    }

    /**
     * Define skill.
     */
    public static void MasterYi(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P310).passive("通常攻撃4回毎に2回連続で攻撃を行い{1}を与える。対象が建物の場合も有効。通常攻撃を4秒間しなかった場合、カウントがリセットされる。").variable(1, PhysicalDamage, ad(0.5));

        Q.update(P313)
                .active("ターゲット不可状態になり対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え(クリティカル発生時は{5})、対象の近くにワープする。ミニオンやモンスターには{3}を追加で与える。通常攻撃をする毎に{4}する。")
                .variable(1, Radius, 600)
                .variable(2, PhysicalDamage, 25, 35, ad(1))
                .variable(3, PhysicalDamage, 75, 25)
                .variable(4, CDDecrease, 1)
                .variable(5, PhysicalDamage, 25, 35, ad(1.6))
                .mana(70, 10)
                .cd(18, -1)
                .range(600);

        W.update(P313)
                .active("4秒間詠唱し、毎秒{1}する。この効果は自分の体力欠損分1％ごとに1％増加する。詠唱中は{2}する（タワーに対しては効果半減）。")
                .variable(1, RestoreHealth, 30, 20, ap(0.3))
                .variable(2, DamageReductionRatio, 50, 5)
                .cd(35)
                .mana(50)
                .type(SkillType.Channel);

        E.update(P310)
                .passive("{1}を得る。CD中この効果は失われる。")
                .variable(1, AD, ad(0.1))
                .active("5秒間通常攻撃に{2}が追加される。建物に対しては無効。")
                .variable(2, TrueDamage, 10, 5, amplify(AD, 0.1, 0.025))
                .cd(18, -1);

        R.update(P310)
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
        P.update(P514).passive("5秒間ダメージを受けないと{1}する。以後徐々に増加して8秒後に{2}する。ダメージを受けると解除される。").variable(-1, MS, 25).variable(-2, MS, 70);

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
        P.update(P516)
                .passive("スキルでダメージを与えると{1}を得る（チャンピオンに対しては{2}）。" + Shield + "の最大値は{3}で、1秒毎に{4}ずつ減少するが、{5}になると減少は止まる。")
                .variable(1, Shield, amplify(DealtDamageRatio, 12.5))
                .variable(2, Shield, amplify(DealtDamageRatio, 25))
                .variable(3, Value, amplify(Health, 0.25))
                .variable(4, Value, amplify(BaseHealth, 0.015));

        Q.update(P516)
                .active("次の3回の通常攻撃は追加{1}を与える。このタメージは攻撃するたびに{2}倍になり、3発で合計{3}を与える。{4}。")
                .variable(1, MagicDamage, 4, 4, amplify(AD, 0.25, 0.0125), ap(0.2))
                .variable(2, Value, 2, 0.25)
                .variable(3, MagicDamage, new PerSkillLevel(28, 66.5, 117, 181, 260), amplify(AD, new PerSkillLevel(1.75, 2.182, 2.681, 3.196, 3.9)), amplify(AP, new PerSkillLevel(1.4, 1.663, 1.95, 2.263, 2.6)))
                .variable(4, ResetAATimer)
                .cd(10, -1.5)
                .cost(Health, 20, 3);

        W.update(P518)
                .passive(champion + "が倒したミニオンから得る経験値は、周りに味方チャンピオンがいても減少することがない。味方チャンピオンは通常通り減少した経験値を得る。")
                .active("4秒間 " + champion + "と対象の味方はお互いに向かって移動する時{1}する。それぞれの{2}にフィールドを生成し毎秒{3}を与える（このダメージは重複しない）。スキルを再度使用するとそれぞれのフィールドが消失し、最寄りの2体の敵に{4}を与え、" + champion + "と味方は{5}する（ミニオンに当たった場合回復量は25%になる）。")
                .variable(1, MS, 75)
                .variable(2, Radius, 250)
                .variable(3, MagicDamage, 35, 10, ap(0.225))
                .variable(4, MagicDamage, 70, 25, ap(0.3))
                .variable(5, RestoreHealth, amplify(DealtDamageRatio, 100))
                .cost(Health, 25, 10)
                .cd(12, -1);

        E.update(P516)
                .active("指定方向扇形の{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 35, 30, ad(0.6), ap(0.6))
                .variable(2, Radius)
                .cd(6, -0.25)
                .range(675)
                .cost(Health, 24, 12);

        R.update(P516)
                .passive("通常攻撃とスキルは10秒間ドラゴンに対して呪いをかける。")
                .active("対象の敵チャンピオンを呪い{1}を与え、その後10秒間、毎秒{2}を与える。10秒間で総計{4}を与え、{3}する。呪われた対象が死ぬと幽霊を生成し{5}秒間従わせる。<br>Child of the Grave<br>AD: 対象のAD + {7}<br>AP: 対象のAP<br>HP: 対象のHP + " + champion + "のHPの15%<br>行動範囲: 1125<br>従えている間、" + champion + "は{8}と{9}を得る。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 12.5, 2.5, ap(0.02)))
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 1.3, 0.25, ap(0.002)))
                .variable(3, RestoreHealth, amplify(DealtDamageRatio, 100))
                .variable(4, MagicDamage, amplify(TargetMaxHealthRatio, 25, 5, ap(0.04)))
                .variable(5, Value, 45, 15)
                .variable(7, Value, new PerSkillLevel(10, 25, 50))
                .variable(8, Health, amplify(TargetBounusHealthRatio, 25))
                .variable(9, AP, amplify(TargetAP, 0.3))
                .cd(120, -15)
                .range(650);
    }

    /**
     * Define skill.
     */
    public static void Morgana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("{1}を得る。").variable(1, SV, new Per6Level(10, 5));

        Q.update(P518)
                .active("指定方向に魔法弾を飛ばし、当たった敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 55, ap(0.9))
                .variable(2, Snare, 2, 0.25)
                .mana(50, 5)
                .cd(11)
                .range(1175);

        W.update(P509)
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに0.5秒毎に{1}を与える（最大で{2}）。対象が失っているHP1%につき、このスキルのダメージが0.5%上昇する(最大で1.5倍)。")
                .variable(1, MagicDamage, 8, 8, ap(0.11))
                .variable(2, MagicDamage, 80, 80, ap(1.1))
                .variable(3, Radius, 175)
                .mana(70, 15)
                .cd(10)
                .range(900);

        E.update(P414)
                .active("対象の味方チャンピオンは5秒間{1}と{2}を得る。")
                .variable(1, MagicShield, 70, 70, ap(0.7))
                .variable(2, IgnoreCC)
                .mana(55)
                .cd(23, -2)
                .range(750);

        R.update(P414)
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
        P.update(P516)
                .passive("スキルが味方チャンピオンに命中した際に、対象は1.5秒間{1}する。" + R + "の場合には{2}する。")
                .variable(-1, MS, 60, 0, ap(0.1))
                .variable(-2, MS, 120, 0, ap(0.2));

        Q.update(P314)
                .active("指定地点に泡を投げ、範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 55, ap(0.5))
                .variable(2, Suspension, 1.5)
                .mana(60)
                .cd(14, -1)
                .range(875);

        W.update(P413)
                .active("味方チャンピオンと敵チャンピオンの間で交互に跳ね返る水流を発射する。<br>味方命中時: {1}し、{2}の敵のチャンピオンに跳ね返る。<br>敵命中時: {3}を与え、{2}の味方のチャンピオンに跳ね返る。<br>同じターゲットに2回以上命中することはなく、最大3体に命中。1度跳ね返るごとに、効果量に{4} の補正がかかる。")
                .variable(1, RestoreHealth, 65, 30, ap(0.3))
                .variable(2, Radius, 875)
                .variable(3, MagicDamage, 70, 40, ap(0.5))
                .variable(4, Percentage, -15, 0, ap(0.075))
                .mana(70, 15)
                .cd(10)
                .range(725);

        E.update(P314)
                .active("対象の味方のチャンピオンは6秒間 (または通常攻撃3回分) 通常攻撃に{1}が付与され、ターゲットを1秒間{2}にする。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MSSlowRatio, 15, 5, ap(0.05))
                .mana(55, 5)
                .cd(11)
                .range(800);

        R.update(P401)
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
        P.update(P314).passive("{1}を得る。").variable(1, LS, new Per6Level(10, 5));

        Q.update(P516)
                .active("次に行う通常攻撃に{1}を付与する。このスキルを使用しLHをとると増加ダメージが+3されていく。対象が敵チャンピオン/SiegeまたはSuperミニオン/Buffを持った中立クリープの場合、増加値は+6になる。")
                .variable(1, PhysicalDamage, 30, 20, amplify(Stack, 3))
                .mana(20)
                .cd(8, -1)
                .range(150);

        W.update(P401)
                .active("対象の敵チャンピオンに5秒間{1}と{2}を与える。")
                .variable(1, ASSlowRatio, 17.5, 0, amplify(Duration, 1.5, 1.5))
                .variable(2, MSSlowRatio, 35, 0, amplify(Duration, 3, 3))
                .mana(80)
                .cd(15, -1)
                .range(600);

        E.update(P301)
                .active("指定地点に魔法陣を呼び出し{1}の敵ユニットに{2}を与える。魔方陣は5秒間持続し、上にいる敵ユニットに{3}と毎秒{4}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 55, 40, ap(0.6))
                .variable(3, ARReduction, 20, 5)
                .variable(4, MagicDamage, 11, 8, ap(0.12))
                .mana(70, 15)
                .cd(12)
                .range(650);

        R.update(P509)
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
        P.update(P412)
                .passive("通常攻撃に{1}と{2}が付与される。同一の対象には{3}に一度しか発動しない。")
                .variable(1, PhysicalDamage, 2, 0, level(6))
                .variable(2, Snare, new PerLevel(new int[] {1, 6, 11, 16, 18}, 0.5, 0.25))
                .variable(3, Time, new Per5Level(9, -1));

        Q.update(P417)
                .active("指定方向に錨を投げ、最初に命中した敵ユニットに{1}を与え自身の方向に引き寄せる。また自身も敵ユニットの方向に移動する。錨が壁に命中した場合、壁の方向に移動しこのスキルの{2}。")
                .variable(1, MagicDamage, 60, 45, ap(0.75))
                .variable(2, CDDecreaseRatio, 50)
                .mana(60, 10)
                .cd(18, -2)
                .range(1100);

        W.update(P505)
                .active("10秒間{1}を得る。シールドが持続している間は通常攻撃時に対象とその周囲({2})にいる敵ユニットに2秒かけて{3}を与える。")
                .variable(1, Shield, 65, 5, amplify(Health, 0.09, 0.02))
                .variable(2, Radius, 175)
                .variable(3, MagicDamage, 30, 10, ap(0.4))
                .mana(80)
                .cd(18);

        E.update(P513)
                .active("{1}を爆発させ命中した敵ユニットに{1}と1.5秒かけて減衰する{2}を与える。爆発は3回発生し、同一対象に対して複数hitする。2発目以降は本来の50%分の" + MagicDamage + "を与える(3発hitで{3})。")
                .variable(1, Radius, 600)
                .variable(1, MagicDamage, 60, 35, ap(0.3))
                .variable(2, MSSlowRatio, 30, 5)
                .variable(3, MagicDamage, 120, 70, ap(0.6))
                .mana(60, 10)
                .cd(10);

        R.update(P301)
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

        Q.update(P515)
                .active("0.25秒後、指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍が投げた距離に比例して与えるダメージが増加する。最大で{2}。")
                .variable(1, MagicDamage, 50, 20, ap(0.4))
                .variable(2, MagicDamage, 150, 60, ap(1.2))
                .mana(50, 10)
                .cd(6)
                .range(1500);

        W.update(P515)
                .active("指定地点に罠を仕掛け、0.5秒間{1}の{2}。敵ユニットが罠を踏むと発動し、対象の敵ユニットとその周囲の敵ユニットに4秒かけて{3}を与え、{2}。罠は2分間持続する。")
                .variable(1, Radius, 400)
                .variable(3, MagicDamage, 40, 40, ap(0.2))
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
                .variable(2, MagicDamage, new PerReferedSkillLevel(R, new double[] {4, 16, 50, 90}), ad(0.75), ap(0.36))
                .variable(3, MagicDamage, new PerReferedSkillLevel(R, new double[] {10, 50, 125, 225}), ad(1.875), ap(0.9))
                .variable(4, MagicDamage, new PerReferedSkillLevel(R, new double[] {13, 67, 167, 300}), ad(2.5), ap(1.2))
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
        P.update(P301)
                .passive("10秒に1度、通常攻撃のダメージが120%に増加し、{1}の敵ユニットにダメージを与える範囲攻撃になる。この効果がヒットした敵の数に応じて{2}する。また、通常攻撃を行うごとに、このスキルの{3}する。建物を攻撃する時はこの効果は発生しない。")
                .variable(1, Radius, 200)
                .variable(2, RestoreHealth, new Per6Level(10, 8))
                .variable(3, CDDecrease, 1)
                .cd(-10);

        Q.update(P415)
                .active("指定方向に影の刃を投げて当たった敵ユニットに{1}を与える。刃の軌跡には5秒間持続するDusk Trailが残り、刃がヒットした敵チャンピオンの動いた軌道上にもDusk Trailが残るようになる。Dusk Trailの上ではNocturneは{2}と{3}を得て、{4}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.75))
                .variable(2, AD, 15, 10)
                .variable(3, IgnoreUnitCollision)
                .variable(4, ASRatio, 15, 5)
                .mana(60, 5)
                .cd(10)
                .range(1200);

        W.update(P301)
                .passive("{1}する。")
                .variable(1, ASRatio, 20, 5)
                .active("1.5秒間{2}を付与し、その間一度だけ敵のスキルを無効化する。無効化した場合、5秒間Passiveの増加攻撃速度が2倍になる。")
                .variable(2, SpellShield)
                .mana(50)
                .cd(20, -2);

        E.update(P509)
                .passive("恐怖状態の敵に向かっていく際、{1}する。")
                .variable(-1, MS, 335)
                .active("対象の敵ユニットに2秒間0.5秒毎に{2}、合計で{4}を与え、2秒間対象が一定範囲内(範囲465)に留まり続けていれば、更に{3}を与える。")
                .variable(2, MagicDamage, 20, 10, ap(0.25))
                .variable(3, Fear, 1, 0.25)
                .variable(4, MagicDamage, 80, 40, ap(1))
                .mana(60, 5)
                .cd(15, -1)
                .range(425);

        R.update(P517)
                .active("4秒間すべての敵チャンピオンに{1}を与え、また自分以外の視界を得られなくする。再度スキルを使用すると、指定した敵チャンピオンの位置まで移動し、{2}を与える。")
                .variable(1, Foggy, 300)
                .variable(2, PhysicalDamage, 150, 100, bounusAD(1.2))
                .mana(100)
                .cd(150, -25)
                .range(2500, 750);
    }

    /**
     * Define skill.
     */
    public static void Nunu(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("通常攻撃を行うたびにスタックが増加する(最大5スタック)。5スタックの状態でスキルを使用すると、スタックを消費してスキルの消費マナが0になる。");

        Q.update(P420)
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

        W.update(P508)
                .active("12秒間自身と指定した味方は{1}し{2}する。自分に対し発動した場合、もっとも近くにいる味方のチャンピオンを対象とする。")
                .variable(1, ASRatio, 25, 5)
                .variable(2, MSRatio, 8, 1)
                .mana(50)
                .cd(15)
                .range(700);

        E.update(P301)
                .active("対象の敵ユニットに{1}と3秒間{2}、{3}を与える。")
                .variable(1, MagicDamage, 85, 45, ap(1))
                .variable(2, ASSlowRatio, 25)
                .variable(3, MSSlowRatio, 20, 10)
                .mana(75, 10)
                .cd(6)
                .range(550);

        R.update(P418)
                .active("{1}の熱を最大3秒まで吸い込み、エリア内の全て敵に{2}と{3}を与える。詠唱終了時（もしくは移動、中断された時）にエリア内の敵に{4}、３秒間{2}と{3}を与える。ダメージ量は詠唱した時間に比例し下限は{5}。")
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
        P.update(P301).passive("{1}する。").variable(1, ASRatio, amplify(MissingHealthPercentage, 1));

        Q.update(P413)
                .active("指定地点に貫通する斧を投げ(最短飛距離400)、当たった敵ユニットに{1}と{4}間{2}を与える。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルの{3}する。また" + champion + "は斧に当たったモンスターをすり抜けることができる。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 29, 4)
                .variable(3, CDDecrease, 4.5)
                .variable(4, Time, 1.5, 0, amplify(Distance, 1))
                .mana(60)
                .cd(7)
                .range(1000);

        W.update(P413)
                .active("6秒間{1}し、{2}を得る。また{3}する。")
                .variable(1, ASRatio, 40, 10)
                .variable(2, LS, 9, 3)
                .variable(3, RestoreHealthRatio, amplify(MissingHealthPercentage, 0.5))
                .cd(16)
                .mana(30);

        E.update(P313)
                .active("対象の敵ユニットに{1}を与える。このスキルで対象を倒した場合、{2}する。通常攻撃をする度にこのスキルの{3}する。")
                .variable(1, TrueDamage, 70, 45, ad(0.4))
                .variable(2, RestoreHealth, new Diff(21, 13.5, 5), ad(0.12))
                .variable(3, CDDecrease, 1)
                .cost(Health, new Diff(21, 13.5, 5), ad(0.12))
                .range(325)
                .cd(12, -1);

        R.update(P509)
                .passive("{1}と{2}を得る。")
                .variable(1, AR, 10, 10)
                .variable(2, MR, 10, 10)
                .active("6秒間パッシブの効果が消失して、{3}と{4}を得る。また、最初の1秒間は敵チャンピオンに向かって移動する際に{5}する。")
                .variable(3, IgnoreCC)
                .variable(4, AD, 40, 20)
                .variable(5, MSRatio, 50, 10)
                .cd(100, -10);
    }

    /**
     * Define skill.
     */
    public static void Orianna(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("通常攻撃に{1}が付与される。4秒以内に同一の対象を連続して攻撃すると、" + MagicDamage + "が20%上昇する(最大40%)。建物には無効。")
                .variable(1, MagicDamage, new Per3Level(10, 8), ap(0.15));

        Q.update(P301)
                .active("指定した地点にBallを移動させ、移動中のBallに触れた敵ユニットと指定{1}にいる敵ユニットに{2}を与える。ダメージは敵に当たるごとに10%づつ減少する(最大60%減少)。Ballは" + champion + "から一定距離離れなければその場に待機して{3}。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 60, 30, ap(0.5))
                .variable(3, Visionable)
                .mana(50)
                .cd(6, -0.75)
                .range(825);

        W.update(P301)
                .active("Ballの存在する地点にフィールドを展開しBallの{1}にいる敵ユニットに{2}を与える。フィールドは3秒間持続し、フィールドの上の味方ユニットは{3}し、敵ユニットには{4}を与える。フィールドから出た場合、この効果は2秒かけて減衰する。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 45, ap(0.7))
                .variable(3, MSRatio, 20, 5)
                .variable(4, MSSlowRatio, 20, 5)
                .mana(70, 10)
                .cd(9);

        E.update(P309)
                .passive("Ballが付いている味方チャンピオンは{1}と{2}を得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("対象の味方チャンピオンまでBallを移動させ、4秒間持続する{3}を付与する。また、移動中のBallに触れた敵ユニットに{4}を与える。Ballは対象が" + champion + "から一定距離離れなければ貼り付き続ける。")
                .variable(3, Shield, 80, 40, ap(0.4))
                .variable(4, MagicDamage, 60, 30, ap(0.3))
                .mana(60)
                .cd(9)
                .range(1100);

        R.update(P511)
                .active("0.75秒詠唱後にBallから衝撃波を発生させ、Ballの{1}にいる敵ユニットに{2}を与えると共に、Ballの方向に{3}させる。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 150, 75, ap(0.7))
                .variable(3, Knockback, 350)
                .mana(100, 25)
                .cd(120, -15);
    }

    /**
     * Define skill.
     */
    public static void Pantheon(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P415).passive("通常攻撃を行うかスキルを使用するたびにスタックが1増加し、4スタック時に40" + Damage + "以上の通常攻撃またはタワーの攻撃を受けるとスタックを消費してダメージを無効化する。");

        Q.update(P301).active("対象の敵ユニットに槍を投げ{1}を与える。").variable(1, PhysicalDamage, 65, 40, bounusAD(1.4)).mana(45).cd(4).range(600);

        W.update(P315)
                .active("対象の敵ユニットに飛びかかり{1}と{2}を与え、" + P + "を発動する。")
                .variable(1, MagicDamage, 50, 25, ap(1))
                .variable(2, Stun, 1)
                .mana(55)
                .cd(13, -1)
                .range(600);

        E.update(P410)
                .passive("敵ユニットのHPが15%以下の時は通常攻撃が必ずクリティカルになり、また" + Q + "のダメージが1.5倍になる。")
                .active("指定方向に槍を突き出し、範囲内の敵ユニットに0.75秒間0.25秒毎に{1}を与える。対象がチャンピオンの場合、{2}を与える。")
                .variable(1, PhysicalDamage, 13, 10, bounusAD(0.6))
                .variable(2, PhysicalDamage, 26, 20, bounusAD(1.2))
                .mana(45, 5)
                .cd(10, -1)
                .range(600)
                .type(SkillType.Channel);

        R.update(P508)
                .active("地点を指定して2秒後にジャンプし、その1.5秒後に指定地点の{1}に{2}と1秒間{3}を与えつつ落下する。" + Damage + "は指定地点から離れるほど低減され、範囲最端では50%となる。ジャンプ前にキャンセルすると、消費した分のマナが回復し、このスキルのCDは10秒になる。")
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
        P.update(P301).passive("現在HPの10%を超えるダメージを受けた際、その超過分のダメージを50%低減する。塔の攻撃には無効。");

        Q.update(P301)
                .active("次の通常攻撃が" + MagicDamage + "になり、{1}が付与される。{2}。")
                .variable(1, MagicDamage, 20, 20, ap(0.6), amplify(TargetMaxHealthRatio, 8))
                .variable(2, ResetAATimer)
                .mana(55)
                .cd(8, -1);

        W.update(P301)
                .passive("通常攻撃を行うか、通常攻撃を受ける度にスタックが1増加する(最大10)。スタック数に比例して{1}と{2}を得る。スタックは5秒間増加がないと0になる。")
                .variable(-1, AD, 0, 0, amplify(Stack, 1.5, 0.5))
                .variable(-2, AR, 0, 0, amplify(Stack, 1.5, 0.5))
                .active("スタックを最大(10)まで増加させ、5秒間{3}する。")
                .variable(3, MSRatio, 17, 2)
                .mana(70, 5)
                .cd(12);

        E.update(P416)
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。ノックバック時に壁にぶつかった場合、追加{3}と{4}を与える。")
                .variable(1, Knockback, 300)
                .variable(2, MagicDamage, 50, 25, ap(0.4))
                .variable(3, MagicDamage, 75, 50, ap(0.4))
                .variable(4, Stun, 1.5)
                .mana(60, 5)
                .cd(12, -1)
                .range(525);

        R.update(P301)
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
        P.update(P305)
                .passive("Valorが" + champion + "の周辺に存在する敵ユニット一体(チャンピオン優先)に自動的に4.5秒間持続するマークを付与する。マークが付与された敵ユニットに" + champion + "が通常攻撃を行うと、付与されたマークを消費して{1}を与える。またマークが付与された敵ユニットの{2}。Valorと交代している間はこのスキルは無効になる。")
                .variable(1, PhysicalDamage, new PerLevel(25, 35, 45, 55, 65, 75, 85, 95, 105, 115, 125, 135, 145, 155, 170, 185, 190, 215), bounusAD(0.5))
                .variable(2, Visionable)
                .cd(-10);

        Q.update(P306)
                .active("指定方向にValorを突撃させ、最初に当たった敵ユニットと{1}の敵ユニットに{2}と{3}を与える。<br>Tag Team時は自身の{4}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 210)
                .variable(2, PhysicalDamage, 70, 40, bounusAD(0.65), ap(0.5))
                .variable(3, Blind, 1.5)
                .variable(4, Radius, 275)
                .mana(50, 5)
                .cd(11, -1)
                .range(1025);

        W.update(P306)
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}、{3}する。Tag Team時は{2}する。")
                .variable(-1, ASRatio, 20, 5)
                .variable(-2, ASRatio, 40, 10)
                .variable(3, MS, 20, 10)
                .active("2秒間{4}の視界を得る。")
                .variable(4, Radius, 2100)
                .cd(50, -5);

        E.update(P506)
                .active("対象の敵ユニットまでダッシュし{1}と2秒かけて減衰する{2}を与える。ダッシュ後、" + champion + "の通常攻撃の最大射程(距離525)までジャンプして対象と距離を離す。また、同時に対象には" + P + "のマークが付与される。Tag Team時はダッシュ後に距離を離さなくなる。")
                .variable(1, PhysicalDamage, 40, 30, bounusAD(0.2))
                .variable(2, MSSlowRatio, 50)
                .range(700)
                .mana(50)
                .cd(12, -1);

        R.update(P306)
                .active("20秒間Valorが" + champion + "と入れ替わり戦闘に参加する。Valorは射程125のMeleeであり、専用のスキルが与えられるがスキルのCDは" + champion + "と共有する。Valorは{1}を得て{2}する。戦闘状態に入ると{3}する。このスキルを再度使用するか、20秒経過するとValorが" + champion + "と入れ替わり、{4}に敵ユニットに{5}を与える。対象が受けているダメージに比例して与えるダメージが増加し、最大で{6}を与える。")
                .variable(1, IgnoreUnitCollision)
                .variable(-2, MSRatio, 80, 10)
                .variable(3, MSRatio, 20, 10)
                .variable(4, Radius, 700)
                .variable(5, PhysicalDamage, 100, 50, bounusAD(0.5))
                .variable(6, PhysicalDamage, 200, 100, bounusAD(1))
                .mana(100)
                .cd(140, -30);
    }

    /**
     * Define skill.
     */
    public static void Rammus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("{1}を得る。").variable(1, AD, amplify(AR, 0.25));

        Q.update(P506)
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。" + W + "を使用するとキャンセルされる。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Knockup, 0.75)
                .variable(4, MSSlowRatio, 20, 5)
                .variable(5, MSRatio, 85)
                .mana(60, 5)
                .cd(16, -1.5);

        W.update(P516)
                .active("6秒間{1}と{2}を得て、" + champion + "を通常攻撃した敵ユニットに{3}を与える。効果中に" + Q + "を使用すると効果がキャンセルされる。また、このスキルを再使用することで効果をキャンセルできる。")
                .variable(1, AR, 40, 20)
                .variable(2, MR, 40, 20)
                .variable(3, MagicDamage, 25, 10, amplify(AR, 0.1))
                .mana(40)
                .cd(14);

        E.update(P420)
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, Taunt, 1.25, 0.25)
                .variable(2, ARReduction, 5, 5)
                .cd(12)
                .range(325)
                .mana(50);

        R.update(P315)
                .active("8秒間地震を発生させ{1}の敵ユニット及び建物に毎秒{2}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 65, 65, ap(0.3))
                .cd(60)
                .mana(100);
    }

    /**
     * Define skill.
     */
    public static void RekSai(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P517)
                .passive("通常攻撃で敵ユニットに" + Damage + "を与える度に5、スキルで敵ユニットに" + Damage + "を与える度に10の" + Fury + "を得る。一定時間戦闘を行わないと、" + Fury + "は毎秒20ずつ減少していく。");

        Q.update(P507)
                .active("5秒以内に発動される3回の通常攻撃は{1}の敵に{2}を与える。")
                .variable(1, Radius, 325)
                .variable(2, PhysicalDamage, 15, 10, bounusAD(0.2))
                .cd(4);

        W.update(P421)
                .active("地中に潜る。この間は通常攻撃が不可能になり、視界が大幅に狭まるが、" + R + "以外のスキルが変化し、{1}にいる移動中の敵ユニットの場所にソナーが発生し位置を特定できるようになる。また{2}を得て{3}する。")
                .variable(1, Radius, 1300)
                .variable(2, IgnoreUnitCollision)
                .variable(3, MS, new Per5Level(15, 5))
                .cd(4);

        E.update(P421)
                .active("ターゲットにかみつき{1}を与える。" + Damage + "は得ている" + Fury + "1につき1%増加し(最大2倍)、" + Fury + "が100の場合は" + PhysicalDamage + "の代わりに" + TrueDamage + "を与える。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.8, 0.1))
                .cd(12)
                .range(250);

        R.update(P421)
                .passive("{1}する。")
                .variable(1, ASRatio, 20, 20)
                .active("MAP上にあるトンネルを指定すると、1.5秒詠唱後に指定したトンネルの元まで高速で移動する。スキル発動後は地面に潜った状態となる。このスキルによる詠唱は敵チャンピオンまたは敵タワーから" + Damage + "を受けると中断される。")
                .cd(150, -40)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void RekSaiTransformed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P421).passive("毎秒20" + Fury + "を消費して{1}する。").variable(1, RestoreHealth, 0, 0, level(5));

        Q.update(P501)
                .active("ビームを放ち、最初に命中したユニットとその{1}の敵ユニットに{2}を与え、{3}。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 60, 30, ap(0.7))
                .variable(3, Visionable)
                .cd(11, -1)
                .range(1650);

        W.update(P513)
                .active("地上に飛び出し、{1}にいる敵に{2}と{3}を与える。打ち上げ時間は、" + champion + "に近い敵ほど長くなる。一度" + W + "の効果を受けたユニットは、以後{4}経過するまで再度効果を受けない。")
                .variable(1, Radius, 160)
                .variable(2, PhysicalDamage, 40, 40, bounusAD(0.4))
                .variable(3, Knockup, 1)
                .variable(4, Time, 10, -0.5)
                .cd(1);

        E.update(P505)
                .active("指定した地点まで一定距離掘り進んだ後、スキルを使用した地点と止まった地点にトンネルの出入り口を作成する。" + champion + "がトンネルの出入り口をクリックすると、トンネルを経由してもう一つの出入り口まで移動できる。移動には1.5秒かかり、一度トンネルによる移動を行うと、{1}間はトンネルが使用できなくなる。トンネルは10分間持続し、一度に8箇所まで作成できるが、敵チャンピオンが出入り口の上に立ち1.5秒経過すると、トンネルは破壊される。")
                .variable(1, Time, 10, -1)
                .cd(20, -0.5)
                .range(250);

        R.update(P421)
                .passive("{1}する。")
                .variable(1, ASRatio, 20, 20)
                .active("MAP上にあるトンネルを指定すると、1.5秒詠唱後に指定したトンネルの元まで高速で移動する。スキル発動後は地面に潜った状態となる。このスキルによる詠唱は敵チャンピオンまたは敵タワーから" + Damage + "を受けると中断される。")
                .cd(150, -40)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Renekton(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P501)
                .passive("通常攻撃ごとに" + Fury + "が5増加する。12秒間戦闘を行わないと" + Fury + "は毎秒4減少する。" + Fury + "の最大値は100、" + Fury + "が50以上ある場合にスキルを使用すると、" + Fury + "を50消費してスキルが強化される。また、" + champion + "の" + Health + "が50%以下になると" + Fury + "の増加量が50%増加する。建物を攻撃した場合は" + Fury + "は増加しない。");

        Q.update(P501)
                .active("武器を振り回し{1}の敵ユニットに{2}を与え、{3}する。対象がチャンピオンの場合は{4}する。回復値の上限は{5}。当たったユニット1体につき" + Fury + "が2.5（チャンピオンの場合は10）増加する(最大25)。<br><br>" + Fury + "50以上時: {6}を与え、{7}する。対象がチャンピオンの場合は{8}する。回復値の上限は{9}。" + Fury + "増加効果は無くなる。")
                .variable(1, Radius, 225)
                .variable(2, PhysicalDamage, 60, 30, bounusAD(0.8))
                .variable(3, RestoreHealth, 3, 1.5, bounusAD(0.04))
                .variable(4, RestoreHealth, 9, 4.5, bounusAD(0.12))
                .variable(5, Value, 50, 25)
                .variable(6, PhysicalDamage, 90, 45, bounusAD(1.2))
                .variable(7, RestoreHealth, 9, 4.5, bounusAD(0.12))
                .variable(8, RestoreHealth, 27, 13.5, bounusAD(0.36))
                .variable(9, Value, 150, 75)
                .cd(8);

        W.update(P509)
                .active("次の通常攻撃は{1}して2回攻撃になり、1撃ごとに{2}を与え（合計{3}）、さらに{4}を与える。{5}。対象がチャンピオンであった場合、追加で" + Fury + "10を得る。<br><br>" + Fury + "50以上時: 攻撃回数が3回に増え、ターゲットに合計{6}と{7}を与える。" + Fury + "増加効果は無くなる。")
                .variable(1, Range, 50)
                .variable(2, PhysicalDamage, 5, 10, ad(0.75))
                .variable(3, PhysicalDamage, 10, 20, ad(1.5))
                .variable(4, Stun, 0.75)
                .variable(5, OnHitEffect)
                .variable(6, PhysicalDamage, 15, 30, ad(2.25))
                .variable(7, Stun, 1.5)
                .cd(13, -1);

        E.update(P501)
                .active("一撃目: " + champion + "がダッシュして敵を斬りつけ{1}を与える。攻撃命中後は4秒以内に「二撃目」の発動が可能になる。<br><br>二撃目: " + champion + "がダッシュして敵を斬りつけ{1}を与える。さらに攻撃が敵1体に命中するごとに" + Fury + "2.5 (対象がチャンピオンの場合は10で最大で30)を生成する。<br><br>" + Fury + "50以上時の二撃目: {3}と4秒間{2}を与える。" + Fury + "増加効果はなくなる。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.9))
                .variable(2, ARReductionRatio, 15, 5)
                .variable(3, PhysicalDamage, 45, 45, bounusAD(1.35))
                .cd(18, -1)
                .range(450);

        R.update(P509)
                .active("15秒間{4}、{1}を得て{2}の敵ユニットに毎秒{3}を与える。また、毎秒5" + Fury + "を得る。")
                .variable(1, Health, new PerSkillLevel(200, 400, 800))
                .variable(2, Radius, 175)
                .variable(3, MagicDamage, 40, 30, ap(0.1))
                .variable(4, Grow)
                .cd(120);
    }

    /**
     * Define skill.
     */
    public static void Rengar(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P409)
                .passive("スキルで敵ユニットにダメージを与える度に1 スタックを得て、5 スタック貯まると全てを消費して強化されたスキルを使用することが出来る。<br>ステルス状態または茂みの中から相手を攻撃する際には、通常攻撃の{1}して相手に飛びつくようになる。この効果はステルス状態が解除された、また茂みから出た後0.5秒の間でも発生し、またステルス状態や茂みの中の視界が取られていた場合でも発生する。<br>敵チャンピオンを{2}と1Trophyを得る。得たTrophyの数に応じて以下の効果を得る。<br>3: 戦闘外または茂みに入っている間は{3}を得る。<br>6: " + P + "の{4}する。<br>12: " + R + "の効果時間が5秒増加する。<br>20: " + R + "の増加移動速度が2倍になる。")
                .variable(-1, Range, 600)
                .variable(2, Takedown)
                .variable(-3, MS, 25)
                .variable(-4, Range, 125);

        Q.update(P412)
                .active("3秒以内の次の通常攻撃に{1}を付与する。<br>強化スキル: 3秒以内の次の通常攻撃に{2}を付与し、5秒間{3}を得て{4}する。")
                .variable(1, PhysicalDamage, 30, 30, amplify(AD, 0.0, 0.05))
                .variable(2, PhysicalDamage, new PerLevel(30, 45, 60, 75, 90, 105, 120, 135, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240), ad(0.5))
                .variable(3, AD, ad(0.1))
                .variable(4, ASRatio, 47, 0, level(3))
                .cd(6, -0.5);

        W.update(P405)
                .active("{1}の敵ユニットに{2}を与え、4秒間{3}と{4}を得る。<br>強化スキル: {1}の敵ユニットに{5}を与え、4秒間{3}と{4}を得る（通常スキルの効果と重複する）。また、{6}する（自身が失っているHP1%につき、回復量が6.25%上昇して最大で{7}）。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 50, 30, ap(0.8))
                .variable(3, AR, 10, 5, amplify(DamagedChampion, 5, 2.5))
                .variable(4, MR, 10, 5, amplify(DamagedChampion, 5, 2.5))
                .variable(5, MagicDamage, new PerLevel(40, 55, 70, 85, 100, 115, 130, 145, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250), ap(0.8))
                .variable(6, RestoreHealth, 8, 0, level(4))
                .variable(7, RestoreHealth, 50, 0, level(25))
                .cd(12);

        E.update(P405)
                .active("指定方向に投げ縄を投げ、当たった敵に{1}と2.5秒かけて減衰する{2}を与える。<br>強化スキル: 指定方向に投げ縄を投げ、当たった敵に{3}と{4}を与える。")
                .variable(1, PhysicalDamage, 50, 50, bounusAD(0.7))
                .variable(2, MSSlowRatio, 60, 5)
                .variable(3, PhysicalDamage, new PerLevel(50, 75, 100, 125, 150, 175, 200, 225, 250, 260, 270, 280, 290, 300, 310, 320, 330, 340), bounusAD(0.7))
                .variable(4, Snare, 1.75)
                .cd(10)
                .range(1000);

        R.update(P415)
                .active("1秒後に{1}になり{4}して、{2}の敵チャンピオン全員の{3}。ステルス準備中に攻撃を行うかダメージを受ける度に、ステルス状態になるのに必要な時間が1秒増加する。ステルス準備開始から3秒経過するとダメージを受けていてもステルス状態になる。ステルスが解除されると5秒間{5}して1秒毎に1 Ferocityを得る。")
                .variable(1, Stealth, 7)
                .variable(2, Radius, 2000, 1000)
                .variable(3, Visionable)
                .variable(-4, MSRatio, 15)
                .variable(5, MSRatio, 25, 10)
                .cd(150, -40);
    }

    /**
     * Define skill.
     */
    public static void Riven(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P302)
                .passive("スキルを使用するごとに1チャージを得る。チャージがある状態で通常攻撃を行うと、チャージを消費して通常攻撃に{1}が付与される。チャージは最大3スタックされ、通常攻撃ごとに1チャージずつ消費される。チャージは5秒間増加または消費がないと0になる。建物には無効。")
                .variable(1, PhysicalDamage, amplify(AD, new PerLevel(new int[] {1, 3, 6, 9, 12, 15, 18}, 0.2, 0.05)));

        Q.update(P401)
                .active("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。3度目のジャンプのみ壁を飛び越えられる。")
                .variable(1, Radius, 112.5)
                .variable(2, PhysicalDamage, 10, 20, amplify(AD, 0.4, 0.05))
                .variable(3, Radius, 150)
                .variable(4, Knockup)
                .variable(5, PhysicalDamage, 30, 60, amplify(AD, 1.2, 0.15))
                .cd(1)
                .range(260);

        W.update(P301)
                .active("{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 125)
                .variable(2, PhysicalDamage, 50, 30, bounusAD(1))
                .variable(3, Stun, 0.75)
                .cd(11, -1);

        E.update(P402)
                .active("指定方向にダッシュし、{3}間{2}が付与される。")
                .variable(2, Shield, 90, 30, bounusAD(1))
                .variable(3, Time, 1.5)
                .cd(10, -1)
                .range(325);

        R.update(P301)
                .active("15秒間折れた剣の刃を再生させ、{1}を得て{2}する。また、このスキルを再度使用することで一度だけ0.5秒後に指定方向に巨大な衝撃波を発生させ、{3}の敵ユニットに{5}与える。対象が受けているダメージに比例して与えるダメージが増加して、最大" + Damage + "は{6}。")
                .variable(1, AD, ad(0.2))
                .variable(2, Range, 75)
                .variable(3, Radius, 900)
                .variable(5, PhysicalDamage, 80, 40, bounusAD(0.6))
                .variable(6, PhysicalDamage, 240, 120, bounusAD(1.8))
                .cd(110, -30);
    }

    /**
     * Define skill.
     */
    public static void Rumble(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive(R + "以外のスキルを使うとHeatが20増加し、それが50以上になると「Danger Zone」状態に入り全てのスキルに追加効果がつくようになる。Heatが100になると6秒間スキルが使用不可能になり、通常攻撃に{1}が付与される（建物には無効）。4秒間スキルを使用しないとHeatは減少していく。")
                .variable(1, MagicDamage, 20, 0, ap(0.25), level(5));

        Q.update(P514)
                .active("目の前の敵を焼き払い、3秒間毎秒{1}を与える。ミニオンやモンスターに対してはダメージが半減。Danger Zone中は{2}を与える。")
                .variable(1, MagicDamage, 25, 20, ap(0.33))
                .variable(2, MagicDamage, 37.5, 30, ap(0.5))
                .cd(6)
                .range(600);

        W.update(P415)
                .active("2秒間{1}を得て1秒間{2}する。Danger Zone中は2秒間{3}を得て1秒間{4}する。")
                .variable(1, Shield, 50, 30, ap(0.4))
                .variable(2, MSRatio, 10, 5)
                .variable(3, Shield, 75, 45, ap(0.6))
                .variable(4, MSRatio, 15, 7.5)
                .cd(6);

        E.update(P301)
                .active("指定方向に銛を放ち当たった敵ユニットに{1}と3秒間{2}を与える。このスキルは3秒間、再使用できる(但し、一度使用する度に1秒のCDが発生する)。2発目はHeatが増加しない。また、このスキルによるスローはスタックする。Danger Zone中では{3}と3秒間{4}を与える。")
                .variable(1, MagicDamage, 45, 25, ap(0.4))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, MagicDamage, 67.5, 37.5, ap(0.6))
                .variable(4, MSSlowRatio, 22.5, 7.5)
                .cd(10)
                .range(850);

        R.update(P516)
                .active("指定した位置から指定方向({4})にロケットを打ち出し、当たった地面を5秒間炎上させる。炎上した地面の上にいる敵ユニットに毎秒{3}と{2}を与える。")
                .variable(2, MSSlowRatio, 35)
                .variable(3, MagicDamage, 130, 55, ap(0.3))
                .variable(4, Distance, 1000)
                .cd(120, -10)
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

        W.update(P512)
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

        R.update(P510)
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
        P.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、2秒間{1}と{2}を得る。この効果時間は最大8秒までスタックする。")
                .variable(1, AR, new PerLevel(new int[] {1, 7, 12, 17}, 10, 5))
                .variable(2, MSSlowReductionRatio, new PerLevel(new int[] {1, 7, 12, 17}, 10, 5));

        Q.update(P421)
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}と{2}を与える。敵チャンピオンに当たると突進は止まる。")
                .variable(1, Knockup)
                .variable(2, MagicDamage, 80, 55, ap(0.4))
                .mana(80, 5)
                .cd(15, -1)
                .range(650);

        W.update(P511)
                .active("次の通常攻撃は、対象と{1}の敵に{2}を与える。また通常攻撃するか4秒経過するか再度スキルを使用すると4秒間{1}の敵に毎秒{3}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 4, 0.5, ap(0.03)))
                .variable(3, MagicDamage, 10, 7.5, ap(0.15), amplify(Health, 0.01, 0.005))
                .cd(11, -1)
                .mana(40, -5);

        E.update(P421)
                .passive("通常攻撃かスキルによりダメージを与えると、対象を4秒間Frost状態にする。")
                .active("{0}のFrost状態の敵ユニットに{1}と1.5秒間{2}を与える。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 30, ap(0.5))
                .variable(2, MSSlowRatio, 50, 5)
                .range(1000)
                .mana(55)
                .cd(10, -1);

        R.update(P506)
                .active("指定方向に武器を投げ、敵チャンピオンに命中するとその場で爆発し、{1}の敵ユニットに{2}と{3}を与える。命中しなかった場合、最大射程で爆発し{1}の敵ユニットに{2}と{5}間{4}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1.25, 0.25)
                .variable(4, MSSlowRatio, 30)
                .variable(5, Time, 1.25, 0.25)
                .range(1175)
                .mana(100)
                .cd(130, -15);
    }

    /**
     * Define skill.
     */
    public static void Shaco(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("対象の背後から攻撃した場合に{1}する。").variable(1, DamageRatio, 20);

        Q.update(P301)
                .active("指定地点にテレポートし、{1}になる。また、スキル使用後6秒以内に通常攻撃を行うと必ずクリティカルになる。その際のクリティカルダメージは{2}になる。")
                .variable(1, Stealth, 3.5)
                .variable(2, Percentage, 140, 20)
                .cd(11)
                .mana(90, -10)
                .range(400);

        W.update(P402)
                .active("指定地点に60秒持続する人形を設置する。人形は設置後2秒で{1}となり、敵ユニットがステルス状態の人形から範囲300以内に近づくと、人形のステルスが解除されると同時に近くの敵ユニットに{2}を与え、5秒間通常攻撃({3})を行った後に破壊される。")
                .variable(1, Stealth)
                .variable(2, Fear, 0.5, 0.25)
                .variable(3, MagicDamage, 35, 15, ap(0.2))
                .mana(50, 5)
                .cd(16)
                .range(425);

        E.update(P301)
                .passive("通常攻撃に2秒間の{1}を付与する。対象がチャンピオン以外の場合、更に命中率低下(値はスローと同じ)を与える。命中率低下を受けたユニットは一定確率で通常攻撃が外れる(ブラインドと同じ)。")
                .variable(1, MSSlowRatio, 10, 5)
                .active("対象の敵ユニットに{2}と3秒間{1}を与える。効果後はCDが解消されるまでPassiveの効果が無くなる。")
                .variable(2, MagicDamage, 50, 40, ap(1), bounusAD(1))
                .mana(50, 5)
                .cd(8)
                .range(625);

        R.update(P301)
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
        P.update(P511)
                .passive("{3}に1度通常攻撃に追加{1}が付与され、{2}する。通常攻撃を行う度に{4}する（建物には無効、" + W + "の効果時間中は2倍）。")
                .variable(1, MagicDamage, 4, 0, level(4), amplify(BounusHealth, 0.1))
                .variable(2, RestoreEnergy, new Per6Level(10, 10))
                .variable(3, Time, new Per6Level(9, -1))
                .variable(4, CDDecrease, 1);

        Q.update(P517)
                .active("対象の敵ユニットに{1}と5秒間持続するDebuffを与える。Debuffが付与された対象に通常攻撃またはダメージスペルで攻撃をすると、攻撃した味方チャンピオンは3秒かけて{2}する。このスキルでLHを取った場合、{3}する。")
                .variable(1, MagicDamage, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 6, 4, amplify(Health, 0.015))
                .variable(3, RestoreHealth, 1, 1, amplify(Health, 0.005))
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(475);

        W.update(P310)
                .active("3秒間{1}を得る。シールドが持続している間は" + P + "のCD解消効果が1秒から2秒になる。")
                .variable(1, Shield, 60, 45, ap(0.6))
                .cd(9, -1)
                .cost(Energy, 50, 0);

        E.update(P511)
                .active("指定地点まで素早く移動し接触した敵チャンピオンに{1}と{2}を与える。" + champion + "は" + Taunt + "効果中の対象から受ける{4}する。またこのスキルが敵チャンピオンに命中する度に{3}する。")
                .variable(1, MagicDamage, 50, 35, ap(0.5))
                .variable(2, Taunt, 1.5)
                .variable(3, RestoreEnergy, 40)
                .variable(4, DamageReductionRatio, 50)
                .cd(16, -2)
                .cost(Energy, 100, -5)
                .range(600);

        R.update(P508)
                .active("対象の味方チャンピオンに5秒間{1}を付与し、3秒詠唱後そこまでワープする。詠唱中にスロー以外のCCを受けると中断される。")
                .variable(1, Shield, 250, 300, ap(1.35))
                .cd(180, -20)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Shyvana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P309)
                .passive("{1}と{2}を得る。この効果はDragon Form時には2倍になる。")
                .variable(1, AR, new Per5Level(5, 5))
                .variable(2, MR, new Per5Level(5, 5));

        Q.update(P421)
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の前方にいる敵ユニットにも同様の効果を与える。建物以外の対象を通常攻撃する毎に{2}する。{3}。")
                .variable(1, PhysicalDamage, amplify(AD, 0.8, 0.05))
                .variable(2, CDDecrease, 0.5)
                .variable(3, OnHitEffect)
                .cd(10, -1);

        W.update(P513)
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する（モンスターに対してはダメージが20％増加）。通常攻撃をする毎に効果時間が1秒延長し最大4秒延長でき{4}を与える。移動速度上昇は時間経過と共に減少する。Dragon Form時" + champion + "の通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 20, 13, bounusAD(0.2))
                .variable(3, MSRatio, 30, 5)
                .variable(4, MagicDamage, 5, 3.25, bounusAD(0.05))
                .cd(12);

        E.update(P505)
                .active("指定方向に貫通する火球を放ち当たった敵ユニットに{1}と5秒間Debuffを与える。Debuffを受けている敵に通常攻撃をする毎に{2}を与える（モンスターに対しては100ダメージが上限）。Dragon Form時" + champion + "の前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 60, 40, ap(0.6))
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 2.5))
                .cd(12, -1)
                .range(925);

        R.update(P401)
                .passive("Human Formの時には1.5秒毎に{1}Furyを得る。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, Value, 1, 1)
                .active("このスキルはHuman Formで" + Fury + "が100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒5Fury減少し、0になるとHuman Formに戻る。")
                .variable(3, MagicDamage, 175, 125, ap(0.7))
                .variable(4, Knockback)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Singed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("{1}を得る。").variable(1, Health, amplify(Mana, 0.25));

        Q.update(P301)
                .active("Singedの通り道に3.25秒間持続する毒を撒き、触れた敵ユニットに3秒間毎秒{1}を与える。")
                .variable(1, MagicDamage, 22, 0, ap(0.3))
                .mana(13)
                .cd(1)
                .type(SkillType.Toggle);

        W.update(P513)
                .active("指定地点に5秒間持続する粘着剤を撒き、{1}の敵ユニットに{2}を与え続ける。この効果は範囲外に出てからも1秒間持続する。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 35, 10)
                .mana(70, 10)
                .cd(14)
                .range(1000);

        E.update(P513)
                .active("対象の敵ユニット{1}を与え、後ろに投げ飛ばす({2})。もし対象を" + W + "の範囲内に投げ飛ばした場合、対象に{3}を与える。")
                .variable(1, MagicDamage, 50, 15, ap(0.75), amplify(TargetMaxHealthRatio, 6, 0.5))
                .variable(2, Distance, 550)
                .variable(3, Snare, 1, 0.25)
                .mana(100, 10)
                .cd(10)
                .range(125);

        R.update(P419)
                .active("25秒間{1}、{2}、{3}、{4}、{5}を得て、{6}する。")
                .variable(1, AP, 35, 15)
                .variable(2, AR, 35, 15)
                .variable(3, MR, 35, 15)
                .variable(4, Hreg, 35, 15)
                .variable(5, Mreg, 35, 15)
                .variable(6, MS, 35, 15)
                .mana(150)
                .cd(100);
    }

    /**
     * Define skill.
     */
    public static void Sion(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P501)
                .passive("死亡後にHPが最大の状態で復活する。復活後は移動と通常攻撃のみが可能でHPが毎秒{1}減少する。また、{2}し、ASが1.75に固定され、通常攻撃に{3}が付与される（チャンピオン以外には75ダメージが上限）。復活中はすべてのスキルがDeath Surgeに置き換わる。<br><br>Death Surge<br> 1.5秒間" + MS + "が50%増加する。この効果1.5秒かけて減衰する。")
                .variable(1, Value, 4, 0, level(4))
                .variable(-2, LSRatio, 100)
                .variable(3, PhysicalDamage, amplify(TargetMaxHealthRatio, 10));

        Q.update(P506)
                .active("最初にスキルを使用するとチャージを行い、この間は移動できなくなる。再度スキルを使用するか2秒経過すると斧を振り下ろし、{1}の敵ユニットに{2}と0.25秒{3}を与える（2秒チャージすると{5}）。チャージを行って1秒間経過した場合は" + MSSlow + "の代わりに{4}を与える。ミニオンに対しては" + Damage + "が40%減少し、モンスターに対しては" + Damage + "が20%減少する。")
                .variable(1, Radius, 300, 0, amplify(Duration, 150))
                .variable(2, PhysicalDamage, 16, 16, amplify(AD, 0.52))
                .variable(3, MSSlowRatio, 50)
                .variable(4, Knockup, 1.25, 0, amplify(Duration, 0.5))
                .variable(5, PhysicalDamage, 48, 48, ad(1.56))
                .mana(45)
                .cd(10, -1)
                .range(new PerSkillLevel(300), amplify(Duration, 150));

        W.update(P508)
                .passive("敵を倒す度に" + Health + "が2増加する。大型ミニオンやモンスター、敵チャンピオンを{1}と10増加する。")
                .variable(1, Takedown)
                .active("6秒間{2}を得る。3秒後以降に再度スキルを使用するか6秒経過するとシールドが破裂し{3}の敵ユニットに{4}を与える。")
                .variable(2, Shield, 30, 25, ap(0.4), amplify(Health, 0.06, 0.01))
                .variable(3, Radius, 550)
                .variable(4, MagicDamage, 40, 25, ap(0.4), amplify(TargetMaxHealthRatio, 10, 1))
                .mana(65, 5)
                .cd(13);

        E.update(P506)
                .active("指定方向に咆哮を放ち、最初に命中した敵ユニットに{1}、2.5秒間{2}と{3}を与える。このスキルが敵チャンピオン以外に命中した場合、対象の敵ユニットに{4}を与え、衝突した敵ユニットに{5}と2.5秒間{2}を与える。")
                .variable(1, MagicDamage, 70, 35, ap(0.4))
                .variable(2, MSSlowRatio, 40, 5)
                .variable(3, ARReductionRatio, 20)
                .variable(4, Knockback)
                .variable(5, MagicDamage, 91, 45.5, ap(0.52))
                .mana(35, 5)
                .cd(12, -1)
                .range(1500);

        R.update(P510)
                .active("マウスカーソルの方向へ最大8秒間突進する。突進中はサモナースペルの使用が不可能になる代わりに、" + MS + "が950になり、{1}を得る。このスキルを再使用するか、敵チャンピオンまたは壁に衝突すると{2}の敵ユニットに{3}と{4}を与える（移動距離に比例して最大で{6}と{7}）。衝突地点から離れた敵ユニットには" + Knockup + "の代わりに3秒間{5}を与える。")
                .variable(1, IgnoreCC)
                .variable(2, Radius)
                .variable(3, PhysicalDamage, 150, 150, bounusAD(0.4))
                .variable(4, Knockup, 1.25)
                .variable(5, MSSlowRatio, 40, 5)
                .variable(6, PhysicalDamage, 300, 300, bounusAD(0.8))
                .variable(7, Knockup, 2.25)
                .mana(100)
                .cd(140, -40);
    }

    /**
     * Define skill.
     */
    public static void Sivir(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P315)
                .passive("敵チャンピオンに通常攻撃かスキルでダメージを与えると、2秒間{1}する。")
                .variable(-1, MSRatio, new PerLevel(new int[] {1, 6, 11, 16, 18}, 30, 5));

        Q.update(P415)
                .active("指定方向にブーメランを投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに{2}ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定がある。")
                .variable(1, PhysicalDamage, 25, 20, amplify(AD, 0.7, 0.1), ap(0.5))
                .variable(2, Percentage, 10)
                .mana(70, 10)
                .cd(9)
                .range(1250);

        W.update(P404)
                .active("次の3回の通常攻撃が{1}の全ての敵に跳ねるようになる。この跳ねは一番近くのユニットに跳ね、同一ユニットには一度しか当たらない。2匹目以降の敵には{2}を与える。{3}。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, amplify(AD, 0.5, 0.05))
                .variable(3, ResetAATimer)
                .mana(60)
                .cd(9, -1);

        E.update(P404)
                .active("1.5秒間、一度だけ敵のスキルを無効化する{1}を得る。無効化した場合{2}する。")
                .variable(1, SpellShield)
                .variable(2, RestoreMana, 80, 15)
                .cd(22, -3);

        R.update(P511)
                .passive(W + "の起動中は{1}する。")
                .variable(-1, ASRatio, 40, 20)
                .active("8秒間{2}の味方は{3}する。一度範囲内に入れば、" + champion + "から離れても効果が持続する。詠唱後に" + R + "の効果範囲内に入った味方は" + champion + "と等しい移動速度増加と効果時間が付与される。増加移動速度は{3}かけて20%まで減少する。")
                .variable(2, Radius, 1000)
                .variable(3, MSRatio, 40, 10)
                .variable(3, Time, 2, 1)
                .mana(100)
                .cd(120, -20)
                .range(1000);
    }

    /**
     * Define skill.
     */
    public static void Skarner(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P517)
                .passive("マップ上にクリスタルが6箇所発生し、敵味方問わず2秒間立っていると占領出来る。占領下のクリスタルの{1}にいる時、" + E + "のスタン効果時間中及び" + R + "の効果時間中、次の効果を受ける。<br><br>Crystal Charge<br>{2}、{3}して毎秒{4}する。")
                .variable(1, Radius, 1150)
                .variable(2, MS, 67, 0, level(3))
                .variable(3, ASRatio, 36.12, 0, level(6.88))
                .variable(4, RestoreMana, amplify(Mana, 0.02));

        Q.update(P516)
                .active("{1}の敵ユニットに{2}を与える。このスキルが命中した場合、4秒間チャージ状態になる。チャージ状態で再度このスキルを使用すると、追加{3}を与える。通常攻撃を行うたびに、このスキルの{4}する(対象がチャンピオンの場合は{5})。")
                .variable(1, Radius, 350)
                .variable(2, PhysicalDamage, amplify(AD, 0.33, 0.03))
                .variable(3, MagicDamage, 0, 0, amplify(AD, 0.33, 0.03), ap(0.2))
                .variable(4, CDDecrease, 0.25)
                .variable(5, CDDecrease, 1)
                .mana(10, 1)
                .cd(3.5, -0.25)
                .range(350);

        W.update(P516)
                .active("6秒間{1}を張る。シールドが残っている間3秒かけて{2}する。")
                .variable(1, Shield, 0, 0, ap(0.8), amplify(Health, 0.1, 0.01))
                .variable(2, MSRatio, 16)
                .mana(60)
                .cd(13, -0.5);

        E.update(P518)
                .active("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに{1}と2秒間{2}与え、5秒間マークする。マークされた敵に通常攻撃をするとマークを消費して、{3}と{4}を与える。スタンを与えるとこのスキルの{5}する。" + R + "を使用するとこのスキルの{6}する。")
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .variable(2, MSSlowRatio, 30, 5)
                .variable(3, PhysicalDamage, 25, 10)
                .variable(4, Stun, 1)
                .variable(5, CDDecrease, 1)
                .variable(6, CDDecrease, 1.75)
                .cd(14, -0.5)
                .mana(55)
                .range(1000);

        R.update(P516)
                .active("対象の敵チャンピオンに{1}を与えた後、{2}と{3}、{4}与える。効果中は対象の敵チャンピオンを引っ張る事が出来き、効果終了時に{2}と{3}を与える。")
                .variable(1, Snare, 0.25)
                .variable(2, PhysicalDamage, ad(1))
                .variable(3, MagicDamage, 20, 40, ap(0.5))
                .variable(4, Suppression, 1.75)
                .mana(100)
                .cd(120, -20)
                .range(350);
    }

    /**
     * Define skill.
     */
    public static void Sona(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P505)
                .passive(R + "以外のスキル使用時に3秒間オーラを纏い、{1}の味方を1人支援するたび持続時間が0.5秒延びる。<br>スキルを使用する度にスタックが増加し、3スタック時に通常攻撃を行うと、スタックを消費して通常攻撃に{2}と、そのとき展開しているオーラに応じた追加効果が発生する。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, new PerLevel(13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112, 122, 132, 147, 162, 177, 192), ap(0.2));

        Q.update(P501)
                .active("{1}の敵2体 (チャンピオンを優先) に{2}を与える。<br>オーラ: 味方の3秒以内の次の通常攻撃に{3}を付与する。<br>追加効果: オーラの" + Damage + "が{4}になる。")
                .variable(1, Radius, 850)
                .variable(2, MagicDamage, 40, 40, ap(0.5))
                .variable(3, MagicDamage, 20, 10, ap(0.2), new PerReferedSkillLevel(R, 10, 20, 40))
                .variable(4, MagicDamage, 28, 14, ap(0.28), new PerReferedSkillLevel(R, 14, 28, 56))
                .mana(45, 5)
                .cd(8)
                .range(850);

        W.update(P420)
                .active("近くにいる最も" + Health + "が減っている味方チャンピオン1体と" + champion + "は{1}する。回復する対象の減少している" + Health + "1%につき回復量が0.5%増加し最大で{2}する。<br>オーラ: 味方チャンピオンは1.5秒間{3}得る。<br>追加効果: 対象は3秒間{4}する。")
                .variable(1, RestoreHealth, 30, 20, ap(0.2))
                .variable(2, RestoreHealth, 45, 30, ap(0.3))
                .variable(3, Shield, 35, 20, ap(0.2), new PerReferedSkillLevel(R, 10, 20, 40))
                .variable(4, DamageDecreaseRatio, 20, 0, ap(0.02))
                .mana(80, 5)
                .cd(10)
                .range(1000);

        E.update(P413)
                .active("3秒間{1}する。この効果は3秒かけて減衰する。<br>オーラ: " + champion + "以外の味方チャンピオンは1.5秒間{2}する。<br>追加効果: 対象に2秒間{3}を与える。")
                .variable(1, MSRatio, 13, 1, ap(0.075), new Refer(R, 2, 2))
                .variable(2, MSRatio, 10, 1, ap(0.035), new Refer(R, 2, 2))
                .variable(3, MSSlowRatio, 40, 0, ap(0.04))
                .mana(65)
                .cd(12);

        R.update(P505)
                .active("前方{1}の敵チャンピオンに{2}と{3}を与える。")
                .variable(1, Radius, 900)
                .variable(2, MagicDamage, 150, 100, ap(0.5))
                .variable(3, Stun, 1.5)
                .mana(100)
                .cd(140, -20)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void Soraka(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P417).passive(W + "の範囲外かつ範囲2500以内の" + Health + "が40%未満になっている味方チャンピオンに向かって移動する時、{1}する。").variable(1, MSRatio, 70);

        Q.update(P505)
                .active("指定した地点に流星を落下させ、{1}の敵に{2}を与える。中心部の敵には{3}と2秒間{4}を与える。星が降ってくる速度は距離に比例する(近距離ほど発動が早く、遠距離ほど遅い)。指定地点の{5}。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 40, ap(0.35))
                .variable(3, MagicDamage, 105, 60, ap(0.525))
                .variable(4, MSSlowRatio, 30, 5)
                .variable(5, Visionable)
                .mana(70, 5)
                .cd(7, -0.5)
                .range(970);

        W.update(P421)
                .passive(Q + "が敵のチャンピオンにヒットするたび、{1}する。" + champion + "が失っている" + Health + "1%につき回復量が1%増加し最大で{2}する。")
                .variable(1, RestoreHealth, 25, 10, ap(0.4))
                .variable(2, RestoreHealth, 50, 20, ap(0.8))
                .active("指定した味方は{3}する。" + champion + "の" + Health + "が5％以下の時は発動できない。このスキルは自身には使用出来ず、使用時に" + Health + "を{4}を失う。")
                .variable(3, RestoreHealth, 120, 30, ap(0.6))
                .variable(4, Value, amplify(Health, 0.1))
                .mana(20, 5)
                .cd(4, -0.5)
                .range(550);

        E.update(P420)
                .active("指定した地点に1.5秒間、時空の渦を発生させ、{1}の敵のチャンピオンに{2}を与える。敵のチャンピオンが範囲内にいる間、{3}を与える。渦が消滅した瞬間、範囲内にいるすべての敵のチャンピオンに{2}と{4}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, Silence)
                .variable(4, Snare, 1, 0.25)
                .cd(24, -2)
                .mana(70)
                .range(925);

        R.update(P417)
                .active("すべての味方のチャンピオンは{1}する。" + Wounds + "を受けている場合はその効果も解消する。" + Health + "が40％以下のチャンピオンに対しては{2}する。")
                .variable(1, RestoreHealth, 150, 100, ap(0.55))
                .variable(2, RestoreHealth, 225, 150, ap(0.825))
                .mana(100)
                .cd(160, -15)
                .range(-1);
    }

    /**
     * Define skill.
     */
    public static void Swain(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P313)
                .passive("敵ユニットを倒す毎に{1}する。{3}ごとに{2}する。")
                .variable(1, RestoreMana, 9, 0, level(1))
                .variable(2, RestoreMana, amplify(Mana, 0.09))
                .variable(3, Takedown);

        Q.update(P301)
                .active(champion + "の位置にビームを吐くカラスを設置し、対象の敵ユニットに毎秒{1}と{2}を与える。3秒経つか対象のユニットがカラスの有効範囲外({3})に移動すると効果が切れる。")
                .variable(1, MagicDamage, 25, 15, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, Radius, 900)
                .mana(60, 10)
                .cd(8)
                .range(625);

        W.update(P301)
                .active("地点を指定した0.875秒後に{3}の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.7))
                .variable(2, Snare, 2)
                .variable(3, Radius, 250)
                .mana(80, 10)
                .cd(18, -2)
                .range(900);

        E.update(P301)
                .active("対象の敵ユニットに4秒かけて{1}を与える。また、効果中は" + champion + "が対象のユニットに与える{2}する。")
                .variable(1, MagicDamage, 75, 40, ap(0.8))
                .variable(2, DamageRatio, 8, 3)
                .mana(65, 5)
                .cd(10)
                .range(625);

        R.update(P301)
                .active("カラスに変身し、{0}の敵ユニット3体(敵チャンピオンを優先)に毎秒{1}を与える。また、{2}して敵チャンピオンの場合は{3}する。")
                .variable(0, Radius, 700)
                .variable(1, MagicDamage, 50, 25, ap(0.2))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 0.25))
                .variable(3, RestoreHealth, amplify(DealtDamage, 0.75))
                .cd(8)
                .range(700)
                .cost(Mana, new Diff(25, 0, 1), amplify(Duration, 5, 1))
                .type(SkillType.Toggle);
    }

    /**
     * Define skill.
     */
    public static void Syndra(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("各スキルを最高ランクまで上げると追加効果が発生する。");

        Q.update(P513)
                .active("指定地点にDark Sphereを召喚し、{1}の敵ユニットに{2}を与える。Dark Sphereはその後6秒間持続する。Lv5になるとチャンピオンに対して{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 50, 45, ap(0.6))
                .variable(3, MagicDamage, 264.5, 0, ap(0.69))
                .mana(40, 10)
                .cd(4)
                .range(800);

        W.update(P514)
                .active("指定したDark Sphereか敵ミニオンまたはモンスター(DragonとBaronには無効)のいずれかを自身まで引き寄せ、最大5秒間引っ張り続ける。この際Dark Sphereを引き寄せた場合、そのDark Sphereの持続時間は引き寄せてから6秒間に更新される。その後再度地点を指定({5})することで指定地点に引き寄せたものを投げ、{1}の敵ユニットに{2}と1.5秒間{3}を与える。また指定地点の{4}。Lv5になるとスローの効果時間が2秒になる。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 80, 40, ap(0.7))
                .variable(3, MSSlowRatio, 25, 5)
                .variable(4, Visionable)
                .variable(5, Radius, 950)
                .mana(60, 10)
                .cd(12, -1)
                .range(925);

        E.update(P513)
                .active("指定方向扇形の{1}にいる敵ユニットに{2}と{3}を与える。ノックバック距離は" + champion + "に近い地点にいるほど増加する。扇形の範囲内にDark Sphereがあった場合同様にノックバックさせ、それに当たった敵ユニットに{2}(このスキルの" + Damage + "とは重複しない)と{4}を与える。Lv5になると範囲の横幅が50%増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, Knockback)
                .variable(4, Stun, 1.5)
                .mana(50)
                .cd(18, -1.5)
                .range(700);

        R.update(P513)
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
    public static void TahmKench(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P517)
                .passive("通常攻撃もしくはスキルで" + Damage + "を与えた敵チャンピオンに対して、「舌慣らし」スタックを付与する(最大3スタック)。3スタックが付与された対象にスキルを使用すると、各スキルは追加効果を得る。7秒後から0.5秒おきにスタックが減少する。");

        Q.update(P514)
                .active("最初に命中した敵に{1}と2秒間{2}を与える。「舌慣らし」が3スタック溜まっている敵のチャンピオンには、さらに{3}を与える。舌が飛び出している最中に" + W + "を発動することで、遠くにいるモンスターやミニオンを食らうことができる。")
                .variable(1, MagicDamage, 80, 45, ap(0.7))
                .variable(2, MSSlowRatio, 30, 10)
                .variable(3, Stun, 1.5)
                .mana(50)
                .cd(6)
                .range(800);

        W.update(P517)
                .active("対象を{1}間食らう。対象が敵の場合、{2}を与える(ミニオンと中立モンスターへは{3}が上限)。食べた対象は吐き出すまでの間、行動不能かつターゲット不可になる。また、食べたユニットに応じて以下の効果を与える。<br>敵ミニオン及びモンスター: 指定した方向に({6})吐き出し{7}を与え、命中した敵ユニットに{4}を与える。<br>味方チャンピオン: 敵チャンピオンに向かって移動する際に{5}を得る。<br>敵チャンピオン: 要「舌慣らし」3スタック。効果時間が半分になり、自身は95％のスローになる。指定した方向に({8})吐き出し{7}を与える。")
                .variable(1, Time, 4, 0.5)
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 20, 3, ap(0.02)))
                .variable(3, MagicDamage, 400, 50)
                .variable(4, MagicDamage, 100, 50, ap(0.6))
                .variable(-5, MSRatio, 30, 5)
                .variable(6, Distance, 650)
                .variable(7, Stun, 0.25)
                .variable(8, Distance, 200)
                .mana(90)
                .cd(14, -1)
                .range(250);

        E.update(P513)
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
    public static void Talon(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("スロー、スタン、スネア、サプレッションを受けている状態の敵ユニットに対しては{1}する。").variable(1, AttackDamageRatio, 10);

        Q.update(P417)
                .active("次の通常攻撃に{1}が付与される。対象がチャンピオンの場合、更に6秒間対象を出血させその間毎秒{2}を与える。また出血中の対象の{3}。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.3))
                .variable(2, PhysicalDamage, 10, 10, bounusAD(1))
                .variable(3, Visionable)
                .mana(40, 5)
                .cd(8, -1);

        W.update(P301)
                .active("前方指定範囲に飛んだ後すぐ戻る刃を投げ当たった敵ユニットに{1}と2秒間{2}を与える。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 30, 25, bounusAD(0.6))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(10)
                .range(600);

        E.update(P418)
                .active("対象の敵ユニットの背後に跳躍し0.25秒{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。")
                .variable(1, MSSlowRatio, 90)
                .variable(2, DamageRatio, 3, 3)
                .mana(35, 5)
                .cd(18, -2)
                .range(700);

        R.update(P417)
                .active("{4}に8本の刃を投げ当たった敵ユニットに{1}を与え、同時に{2}になり{3}する。ステルスが解除されるか敵ユニットを攻撃すると刃が" + champion + "の元に戻ってきて、当たった敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 120, 50, bounusAD(0.75))
                .variable(2, Stealth, 2.5)
                .variable(3, MSRatio, 40)
                .variable(4, Radius, 500)
                .mana(80, 10)
                .cd(75, -10);
    }

    /**
     * Define skill.
     */
    public static void Taric(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P315)
                .passive("スキルを使用した次の通常攻撃は追加{1}を与え、全スキルの{2}する。この効果は通常攻撃を行うか、一定時間経過すると解消される。建物には無効。")
                .variable(1, MagicDamage, amplify(AR, 0.2))
                .variable(2, CDDecrease, 2);

        Q.update(P510)
                .active("対象の味方ユニットと" + champion + "の{1}する。自身に使用した場合は{2}する。")
                .variable(1, RestoreHealth, 60, 40, ap(0.3), amplify(BounusHealth, 0.05))
                .variable(2, RestoreHealth, 84, 56, ap(0.42), amplify(BounusHealth, 0.07))
                .mana(60, 10)
                .cd(18, -1)
                .range(750);

        W.update(P315)
                .passive("{1}を得る（CD中は効果が消滅）。{2}の味方チャンピオンは{3}をを得る。自身は両方の効果を得る。")
                .variable(1, AR, 10, 5)
                .variable(2, Radius, 500)
                .variable(3, AR, amplify(AR, 0.12))
                .active("{4}の敵ユニットに{5}を与え、4秒間{6}を与える。")
                .variable(4, Radius, 375)
                .variable(5, MagicDamage, 40, 40, amplify(AR, 0.2))
                .variable(6, ARReduction, 5, 5, amplify(AR, 0.05))
                .mana(50)
                .cd(10)
                .range(375);

        E.update(P314)
                .active("対象の敵ユニットに{1}と{2}を与える。" + Damage + "は対象との距離が近いほど増加し、距離が遠いほど低下し、最大で{3}。")
                .variable(1, MagicDamage, 40, 30, ap(0.2))
                .variable(2, Stun, 1.2, 0.1)
                .variable(3, MagicDamage, 80, 60, ap(0.4))
                .mana(75)
                .cd(1, -1)
                .range(625);

        R.update(P314)
                .active("{1}の敵ユニットに{2}を与える。スキル使用後の10秒間、{3}と{4}を得て、{7}の味方チャンピオンは{5}と{6}を得る。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 150, 100, ap(0.5))
                .variable(3, AD, 30, 20)
                .variable(4, AP, 30, 20)
                .variable(-5, AD, 15, 10)
                .variable(-6, AP, 15, 10)
                .variable(7, Radius, 500)
                .mana(100)
                .cd(75)
                .range(375);
    }

    /**
     * Define skill.
     */
    public static void Teemo(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P515)
                .passive("1.5秒間（茂みにいる場合は0.75秒間）動かないと{1}になる。何か行動を行うか、強制的に移動させられると" + Stealth + "が解除され、" + Stealth + "解除後3秒間{2}する。茂みの中は移動しても" + Stealth + "は解除されない。")
                .variable(1, Stealth)
                .variable(-2, ASRatio, new PerLevel(new int[] {1, 5, 10, 15}, 20, 20));

        Q.update(P301)
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 45, ap(0.8))
                .variable(2, Blind, 1.5, 0.25)
                .mana(70, 10)
                .cd(8)
                .range(580);

        W.update(P313)
                .passive("{1}する。敵チャンピオンかタワーからダメージを受けると5秒間効果が切れる。")
                .variable(1, MSRatio, 10, 4)
                .active("3秒間{1}し、Passiveの効果が切れることがなくなる。")
                .mana(40)
                .cd(17);

        E.update(P402)
                .passive("通常攻撃時に{1}と毒が付与される。毒は4秒間持続し、毎秒{2}を与える。合計で{3}。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, MagicDamage, 6, 6, ap(0.1))
                .variable(3, MagicDamage, 34, 34, ap(0.7));

        R.update(P516)
                .active("指定地点に5分間持続するキノコの罠を投げる(設置後1.5秒で{1}になる)。設置されているキノコに投げつけた場合、バウンドしてさらに{7}離れた位置へ飛んでいく。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と{4}を与え{8}。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。設置したキノコはチャンピオンの通常攻撃でのみ破壊でき(近接2回、遠距離3回)、破壊すると{6}を得る。")
                .variable(1, Stealth)
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 200, 125, ap(0.5))
                .variable(4, MSSlowRatio, 30, 10)
                .variable(5, CDRAwareTime, 35, -4)
                .variable(6, Gold, 10)
                .variable(7, Distance, 300, 100)
                .variable(8, Visionable)
                .cd(1)
                .mana(75, 25)
                .range(300, 300);
    }

    /**
     * Define skill.
     */
    public static void Thresh(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update()
                .passive("{1}で敵ユニットが死んだ場合、一定の確率で魂を落とす。魂へ近づくか" + W + "のランタンを魂の近くに置くとその魂を回収し、{2}と{3}を得る。落とした魂は15秒間持続し、敵チームがThreshの視界を得ていた場合、敵チームからも視認することができる。")
                .variable(1, Radius, 1900)
                .variable(2, AR, amplify(Stack, 0.75))
                .variable(3, AP, amplify(Stack, 0.75));

        Q.update(P514)
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。鎌が敵に命中した場合、このスキルの{3}する。")
                .variable(1, MagicDamage, 80, 40, ap(0.5))
                .variable(2, Stack, 1.5)
                .variable(3, CDDecrease, 3)
                .cd(20, -2)
                .mana(80)
                .range(1100);

        W.update(P514)
                .active("指定地点に6秒間持続するランタンを設置する。味方チャンピオンがランタンを指定すると、ランタンとその味方チャンピオンが自身の方へと引き寄せられる。更にランタンの周囲にいる魂を自動的に回収し、{1}の味方チャンピオンは{2}を得る。。シールドを得られるのは1ユニットにつき1回のみ。自身がランタンから距離1500以上離れるとランタンは自動的に自身の下へと戻る。")
                .variable(1, Radius)
                .variable(2, Shield, 60, 35, ap(0.4))
                .mana(50, 5)
                .cd(22, -1.5)
                .range(950);

        E.update(P514)
                .passive("通常攻撃に{3}を付与する。この" + Damage + "は" + P + "のスタック数と、自身が前回敵ユニットに通常攻撃をしてから経過した時間に比例して増加し最大で{4}。建物を攻撃した場合は追加" + MagicDamage + "は発生せず、時間がリセットされる事もない。")
                .variable(3, MagicDamage, amplify(Stack, 1))
                .variable(4, MagicDamage, 0, 0, amplify(Stack, 1), amplify(AD, 0.8, 0.3))
                .active("自身後方から前方への帯状領域内の敵ユニットに{1}を与える。また自身後方にいる敵ユニットは自身に近づく向きに、自身前方にいる敵ユニットには自身から遠ざかる向きにノックバックさせ、1.5秒間{2}を与える。")
                .variable(1, MagicDamage, 65, 30, ap(0.4))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(9)
                .range(400);

        R.update(P514)
                .active("0.75秒後、{4}に五角形の壁を創り出し、最初に壁に触れた敵チャンピオンに{1}と2秒間{2}を与える。2つ目以降の壁に触れた敵チャンピオンには1秒間{2}を与える。敵が触れた部分の壁は破壊され消滅する。")
                .variable(1, MagicDamage, 250, 150, ap(1))
                .variable(2, MSSlowRatio, 99)
                .variable(4, Radius, 450)
                .mana(100)
                .cd(150, -10)
                .range(450);
    }

    /**
     * Define skill.
     */
    public static void Tristana(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P502).passive("通常攻撃、" + E + "と" + R + "は{1}する。").variable(1, Range, new PerSkillLevel(-7), level(7));

        Q.update(P507)
                .passive(E + "がスタックしている敵に" + champion + "の通常攻撃が命中するたび、このスキルの{1}する。" + Q + "を発動中、" + champion + "の通常攻撃が命中するたび、" + E + "の{2}する (チャンピオンへの攻撃時は{1}する)。")
                .variable(1, CDDecrease, 1)
                .variable(2, CDDecrease, 0.5)
                .active("5秒間{1}する。")
                .variable(1, ASRatio, 30, 20)
                .cd(20);

        W.update(P502)
                .active("地面を砲撃して指定した地点へジャンプし、着地と同時に{1}の敵ユニットに{2}と{3}間{4}を与える。" + E + "のスタックが付与されている敵に対しては1スタックごとに20%ダメージが増加し最大で{5}。{6}とこのスキルの{7}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 80, 25, ap(0.5))
                .variable(3, Time, 1, 0.5)
                .variable(4, MSSlowRatio, 60)
                .variable(5, MagicDamage, 160, 50, ap(1))
                .variable(6, Takedown)
                .variable(7, CDDecrease)
                .mana(60)
                .cd(22, -2)
                .range(900);

        E.update(P509)
                .passive("通常攻撃で敵ユニットを倒した時にそのユニットの{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 50, 25, ap(0.25))
                .active("詠唱後、対象の敵ユニット・タワーにグレネードを投げる。グレネードは4秒後に爆発し対象と{3}の敵ユニットに{4}を与える。爆発までの4秒間に対象に通常攻撃を行うと、最大で4スタックするDebuffを付与し、1スタック毎に爆発時の" + Damage + "が30%増加し最大で{5}。既に4スタック溜まっている対象に" + W + "または通常攻撃を行うと、即座に爆発させる。詠唱時間はASによって減少する。")
                .variable(3, Radius)
                .variable(4, PhysicalDamage, 60, 10, ap(0.5), amplify(BounusAD, 0.5, 0.15))
                .variable(5, PhysicalDamage, 132, 22, ap(1.1), amplify(BounusAD, 1.1, 0.33))
                .mana(75, 5)
                .cd(16, -0.5)
                .range(new PerSkillLevel(543), level(7));

        R.update(P502)
                .active("対象の敵ユニットに{1}を与え、対象と{2}の敵ユニットを{3}させる。")
                .variable(1, MagicDamage, 300, 100, ap(1))
                .variable(2, Radius, 200)
                .variable(3, Knockback, 600, 200)
                .mana(100)
                .cd(100, -15)
                .range(new PerSkillLevel(543), level(7));
    }

    /**
     * Define skill.
     */
    public static void Trundle(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P505)
                .passive("{1}で敵ユニットが死んだとき、{2}する。")
                .variable(1, Radius, 1400)
                .variable(2, RestoreHealth, amplify(TargetMaxHealthRatio, new PerLevel(new int[] {1, 5, 9, 12, 15}, 2, 1)));

        Q.update(P301)
                .active("次の通常攻撃は{1}と0.1秒間{4}を与える。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 20, 20, amplify(AD, 1, 0.05))
                .variable(2, AD, 20, 5)
                .variable(3, ADReduction, 10, 2.5)
                .variable(4, MSSlowRatio, 75)
                .mana(30)
                .cd(4);

        W.update(P505)
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}、{4}する。")
                .variable(1, Radius, 500)
                .variable(2, ASRatio, 20, 15)
                .variable(3, MSRatio, 20, 5)
                .variable(4, RestoreHealthRatio, 20)
                .mana(60)
                .cd(15)
                .range(900);

        E.update(P509)
                .active("指定地点に6秒間持続する通行不可能なビーコンを設置し、ビーコンの{1}にいる敵ユニットに{2}を与える。また、{3}の視界を得る。")
                .variable(1, Radius, 375)
                .variable(2, MSSlowRatio, 30, 5)
                .variable(3, Radius, 1200)
                .mana(60)
                .cd(23, -3)
                .range(1000);

        R.update(P512)
                .active("敵のチャンピオン1体に{1}、{2}と{3}を与え、続けて4秒かけて{1}、{2}と{3}を与える。 " + champion + "は全ての効果を吸収する({4}し、減少させた" + AR + "及び" + MR + "に等しい量の{5}と{6}を得る)。吸収効果は4秒かけて元に戻る。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, 10, 3.75, ap(0.01)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, MRReductionRatio, 20)
                .variable(4, RestoreHealth, amplify(DealtDamage, 1))
                .variable(5, AR)
                .variable(6, MR)
                .mana(80)
                .cd(80, -10)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Tryndamere(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("{1}する。通常攻撃時に5Fury、クリティカル時に10Fury、" + E + "が敵ユニットに命中するたびに2Furyを得る。敵ユニットを倒すと追加で10Furyを得る。Furyの上限は100、8秒間戦闘を行わないと毎秒5Furyずつ減少していく。建物を攻撃した場合はFuryは増加しない。")
                .variable(-1, Critical, amplify(Stack, 0.35));

        Q.update(P303)
                .passive("{1}を得る。")
                .variable(1, AD, 5, 5, amplify(MissingHealthPercentage, 0.15, 0.05))
                .active("Furyをすべて消費し{2}する。")
                .variable(2, RestoreHealth, 30, 10, ap(0.3), amplify(Stack, 0.5, 0.45, ap(0.012)))
                .cd(12);

        W.update(P301)
                .active("4秒間近くの敵チャンピオンは{1}し、後ろを向いている敵チャンピオンには更に4秒間{2}を与える。")
                .variable(1, ADReduction, 20, 15)
                .variable(2, SlowRatio, 30, 7.5)
                .cd(14)
                .range(400);

        E.update(P420)
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。(敵チャンピオンの場合は{3}する)")
                .variable(1, PhysicalDamage, 70, 30, ap(1), bounusAD(1.2))
                .variable(2, CDDecrease, 1)
                .variable(3, CDDecrease, 2)
                .cd(13, -1)
                .range(660);

        R.update(P312)
                .active("5秒間HPが1未満にならなくなる(死ななくなる)。また、このスキル使用時にFuryが{1}増加する。このスキルの使用は状態異常によって阻害されない。5秒後、" + champion + "の" + Health + "が3%以下の場合{2}する。")
                .variable(1, Count, 50, 25)
                .variable(2, RestoreHealth, amplify(Health, 0.05))
                .cd(110, -10);
    }

    /**
     * Define skill.
     */
    public static void TwistedFate(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P310).passive("ユニットを倒すたびに追加の{1}(1~6でランダム、但し期待値は3.5よりも大きくなる)を得る。").variable(1, Gold);

        Q.update(P401)
                .active("指定向き3方向に貫通するカードを飛ばし、当たった敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.65))
                .mana(60, 10)
                .cd(6)
                .range(1450);

        W.update(P405)
                .active("3種類のカードが順番に出現し、6秒以内に再度使用してカードを決定する。6秒以内の次の通常攻撃が" + MagicDamage + "に変換され、以下の効果になる。<br>Blue Card: {2}を与え{3}する。<br>Red Card: {4}の敵に{5}と2.5秒間{6}を与える。<br>Gold Card: {7}と{8}を与える。")
                .variable(2, MagicDamage, 40, 20, ap(0.5), ad(1))
                .variable(3, RestoreMana, 50, 25)
                .variable(4, Radius, 100)
                .variable(5, MagicDamage, 30, 15, ap(0.5), ad(1))
                .variable(6, MSSlowRatio, 30, 5)
                .variable(7, MagicDamage, 15, 7.5, ap(0.5), ad(1))
                .variable(8, Stun, 1.2, 0.2)
                .mana(40, 15)
                .cd(6);

        E.update(P503).passive("{1}する。通常攻撃4回毎に追加{2}を与える。").variable(1, ASRatio, 10, 5).variable(2, MagicDamage, 55, 25, ap(0.5));

        R.update(P503)
                .active("{1}間すべての敵チャンピオン(ステルス中のチャンピオン含む)の{2}。0.5秒後に再度使用することができるようになり、効果時間内に使用すると1.5秒間移動・攻撃が不可能になった後、指定地点にワープする。")
                .variable(1, Time, 6, 2)
                .variable(2, Visionable)
                .mana(150, -25)
                .cd(180, -30)
                .range(5500);
    }

    /**
     * Define skill.
     */
    public static void Twitch(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P506).passive("通常攻撃時に毒を付与し、6秒間毎秒{1}を与える。毒は6回までスタックする。").variable(1, TrueDamage, new Per4Level(2, 1));

        Q.update(P518)
                .active("使用から1.5秒後に{1}になる。ステルス状態では{2}し、ステルスを解除すると5秒間{3}する。ステルス準備中に攻撃を行うかダメージを受けると、ステルス状態になるのに再度1.25秒必要になる。ステルス準備開始から4.5秒経過するとダメージを受けていてもステルス状態になる。")
                .variable(1, Stealth, 4, 1)
                .variable(2, MSRatio, 20)
                .variable(3, ASRatio, 30, 10)
                .mana(40)
                .cd(16);

        W.update(P301)
                .active("指定地点に{1}で毒の入った瓶を投げつけ、範囲内の敵ユニットに3秒間{2}と毒を2スタック分与える。また、指定した地点の{3}。")
                .variable(1, MissileSpeed, 1400)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Visionable)
                .mana(50)
                .cd(13, -1)
                .range(950);

        E.update(P406)
                .active("毒をスタックされている{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 1200)
                .variable(2, PhysicalDamage, 20, 15, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)))
                .mana(50, 10)
                .cd(12, -1)
                .range(1200);

        R.update(P516)
                .active("7秒間{2}し{1}を得て、通常攻撃が敵ユニットを貫通するようになる。対象との直線上にいる敵ユニットにもダメージと毒スタックを与える。ダメージは敵に当たるごとに20%減少する。最小で40%。")
                .variable(1, AD, 20, 10)
                .variable(2, Range, 300)
                .mana(100, 25)
                .cd(120, -10);
    }

    /**
     * Define skill.
     */
    public static void Udyr(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P305)
                .passive("スキルを使用する度に{1}、{2}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒CDになる。")
                .variable(-1, ASRatio, 10)
                .variable(-2, MS, 5);

        Q.update(P307)
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで通常攻撃は追加{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.15))
                .variable(2, PhysicalDamage, 30, 50, amplify(AD, 1.2, 0.1))
                .variable(3, ASRatio, 30, 10)
                .mana(47, -3)
                .cd(6);

        W.update(P305).active("5秒間{1}を得る。別のスキルを使うまで{2}を得る。").variable(1, Shield, 60, 40, ap(0.5)).variable(2, LS, 10, 2).mana(47, -3).cd(6);

        E.update(P408)
                .active("{1}間{2}し{4}を得る。別のスキルを使うまで通常攻撃は{3}を与える。敵チャンピオンに" + Stun + "を与える際、対象に向かって短い距離をダッシュする。この効果は同一の対象に5秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.25)
                .variable(2, MSRatio, 15, 5)
                .variable(3, Stun, 1)
                .variable(4, IgnoreUnitCollision)
                .mana(47, -3)
                .cd(6);

        R.update(P305)
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、次の通常攻撃に前方の敵ユニットに{4}を与える効果を付与する。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(1, MagicDamage, 15, 10, ap(0.25))
                .variable(2, AD, 8, 4)
                .variable(3, AP, 16, 8)
                .variable(4, MagicDamage, 40, 40, ap(0.45))
                .mana(47, -3)
                .cd(6);
    }

    /**
     * Define skill.
     */
    public static void Urgot(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("通常攻撃または" + Q + "でダメージを与えた対象は2.5秒間{1}する。").variable(1, DamageDecreaseRatio, 15);

        Q.update(P415)
                .active("指定方向にミサイルを飛ばし当たった敵ユニットに{1}を与える。" + E + "の効果を受けている敵ユニットの近くを指定して使用すると、その敵ユニット目掛けてミサイルが飛んでいく。")
                .variable(1, PhysicalDamage, 10, 30, ad(0.85))
                .mana(40)
                .cd(2)
                .range(1000);

        W.update(P505)
                .active("7秒間{1}を得る。シールドが残っている間は通常攻撃と" + Q + "は1.5秒間{2}を与える。")
                .variable(1, Shield, 60, 40, ap(0.8), amplify(Mana, 0.08))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(55, 5)
                .cd(16, -1);

        E.update(P415)
                .active("指定地点に爆弾を飛ばし{1}の敵ユニットに5秒間かけて{2}と{3}を与える。また指定地点の{4}。")
                .variable(1, Radius, 300)
                .variable(2, PhysicalDamage, 75, 55, bounusAD(0.6))
                .variable(3, ARReductionRatio, 12, 2)
                .variable(4, Visionable)
                .mana(50, 5)
                .cd(15, -1)
                .range(900);

        R.update(P505)
                .active("対象の敵チャンピオンに{1}を与え、5秒間{2}と{3}を得る。1秒詠唱後に敵チャンピオンと自分の位置を入れ替え、敵チャンピオンに3秒間{4}を与える。")
                .variable(1, Suppression, 1)
                .variable(2, AR, 60, 30)
                .variable(3, MR, 60, 30)
                .variable(4, MSSlowRatio, 40)
                .mana(100)
                .cd(120, -20)
                .range(550, 150);
    }

    /**
     * Define skill.
     */
    public static void Varus(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("敵ユニットを倒すと3秒間{1}する。{3}と6秒間{2}する。この効果はスタックしない。")
                .variable(-1, ASRatio, 20)
                .variable(-2, ASRatio, 40)
                .variable(3, Takedown);

        Q.update(P505)
                .active("最初にスキルを使用すると狙いを付ける。この間は通常攻撃や他のスキルを使用できなくなり、" + champion + "の移動速度が20%低下するが、狙いを付けている間は徐々にこのスキルのダメージと射程距離が増加していく(2秒で最大)。再度このスキルを使用することで指定方向に貫通する矢を放ち、当たった敵ユニットに{1}を与える(最大で{2})。ダメージは敵に当たるごとに15%減少する。最小で33%。狙いを付けて4秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, PhysicalDamage, 10, 37, ad(1))
                .variable(2, PhysicalDamage, 15, 55, ad(1.65))
                .mana(70, 5)
                .cd(16, -2)
                .range(new PerSkillLevel(925), amplify(Duration, 350));

        W.update(P301)
                .passive("通常攻撃に追加{1}と6秒間持続する疫病が付与される。疫病は3回までスタックする。疫病のスタックが付与されている敵ユニットにVarusの他のスキルが命中した場合、疫病のスタックを全て消費して1スタック毎に{2}を与える。")
                .variable(1, MagicDamage, 10, 4, ap(0.25))
                .variable(2, MagicDamage, amplify(TargetMaxHealthRatio, 2, 0.75, ap(0.02)));

        E.update(P308)
                .active("指定地点に矢の雨を放ち、範囲内の敵ユニットに{1}を与える。指定地点は4秒間呪われ、範囲内の敵ユニットに{2}と{3}を付与する。")
                .variable(1, PhysicalDamage, 65, 35, bounusAD(0.6))
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Wounds)
                .mana(80)
                .cd(18, -2)
                .range(925);

        R.update(P503)
                .active("指定方向に腐敗の蔓を投げつけ、当たった敵チャンピオンに{1}と{2}を与える。当たった敵チャンピオンからは徐々に腐敗が広がり({3})、腐敗に触れた敵チャンピオンにも同様の効果を与える。")
                .variable(1, MagicDamage, 150, 100, ap(1))
                .variable(2, Snare, 2)
                .variable(3, Radius, 550)
                .mana(100)
                .cd(120, -15)
                .range(1075);
    }

    /**
     * Define skill.
     */
    public static void Vayne(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("敵チャンピオンに向かって移動する際に{1}する。").variable(-1, MS, 30);

        Q.update(P514)
                .active("指定地点にローリングし、次の通常攻撃に{1}を付与する。6秒間攻撃を行わないとCDになる。")
                .variable(1, PhysicalDamage, amplify(AD, 0.3, 0.05))
                .range(300)
                .mana(30)
                .cd(6, -1);

        W.update(P301)
                .passive("同じターゲットに3回連続して通常攻撃またはスキルで攻撃すると、{1}を与える。（モンスターやミニオンに対しては上限200）")
                .variable(1, TrueDamage, 20, 10, amplify(TargetMaxHealthRatio, 4, 1));

        E.update(P416)
                .active("対象の敵ユニットをヘビークロスボウで狙撃し{1}と{2}を与える。ノックバックした敵が壁等に当たると追加で{1}と{3}を与える。")
                .variable(1, PhysicalDamage, 45, 35, bounusAD(0.5))
                .variable(2, Knockback, 470)
                .variable(3, Stun, 1.5)
                .mana(90)
                .cd(20, -2)
                .range(550);

        R.update(P413)
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
        P.update(P506).passive("{1}する。").variable(1, MregRatio, amplify(MissingManaPercentage, 0.01));

        Q.update(P506)
                .passive("敵チャンピオンを倒すと{1}を得る。")
                .variable(-1, AP, 1, 1)
                .active("闇のエネルギーを発射し、命中した最初の2体の敵に{2}を与える。倒した敵1体につき{3}を得る。倒したターゲットがチャンピオン、大型ミニオンまたは大型モンスターの場合は{4}を得る。")
                .variable(2, MagicDamage, 80, 45, ap(0.6))
                .variable(-3, AP, 1)
                .variable(-4, AP, 2)
                .mana(60, 5)
                .cd(7, -0.5)
                .range(950);

        W.update(P504)
                .active("指定地点に1.25秒後に隕石を降らし、{1}の敵ユニットに{2}を与える。また隕石が落下するまでの間、指定地点の{3}。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 120, 50, ap(1))
                .variable(3, Visionable)
                .mana(70, 5)
                .cd(10, -0.5)
                .range(900);

        E.update(P506)
                .active("0.5秒後に指定した{1}に3秒間魔法陣を呼び出し、魔法陣の縁に触れた敵ユニットに{2}を与える。")
                .variable(1, Radius, 425)
                .variable(2, Stun, 1.5, 0.25)
                .mana(80, 5)
                .cd(18, -1)
                .range(700);

        R.update(P513)
                .active("対象の敵チャンピオンに{1}を与える。")
                .variable(1, MagicDamage, 250, 125, ap(1), amplify(TargetAP, 0.8))
                .mana(125)
                .cd(120, -20)
                .range(650);
    }

    /**
     * Define skill.
     */
    public static void Velkoz(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P412)
                .passive("スキルで敵ユニットにダメージを与える度に対象にスタックを付与し、対象のスタックが3になるとスタックを全て消費して{1}を与える。スタックは7秒間持続する。通常攻撃を行うと、既に存在しているスタックの持続時間を7秒に戻す。")
                .variable(1, TrueDamage, 25, 0, level(10));

        Q.update(P516)
                .active("指定方向にプラズマを放ち、当たった敵ユニットに{1}と{2}かけて減衰する{3}を与える。スキルを再使用するか、プラズマが敵ユニットに命中するとプラズマが90度の方向に分裂し、分裂したプラズマ（{4}）に当たった敵ユニットにも同様の効果を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.6))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 70)
                .variable(4, Distance, 1100)
                .mana(40, 5)
                .cd(7)
                .range(1050);

        W.update(P413)
                .active("スタックを1消費して、ビームで指定方向に裂け目を発生させ、直線状にいる敵ユニットに{1}を与える。裂け目は0.25秒後に爆発し、{2}にいる敵ユニットに{3}を与える。スタックは{4}毎に増加する（最大2）。")
                .variable(1, MagicDamage, 30, 20, ap(0.25))
                .variable(2, Radius)
                .variable(3, MagicDamage, 45, 30, ap(0.375))
                .variable(4, CDRAwareTime, 19, -1)
                .mana(50, 5)
                .cd(-1.5)
                .range(1050);

        E.update(P412)
                .active("指定地点を爆発させ、{1}の敵ユニットに{2}と{3}を与える。命中した敵は" + champion + "から遠ざかるように吹き飛ぶ。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 30, ap(0.5))
                .variable(3, Suspension, 0.75)
                .mana(50, 5)
                .cd(16, -1)
                .range(850);

        R.update(P506)
                .active("最大2.5秒間カーソルの場所目掛けて貫通するレーザーを放ち、0.25秒毎に{1}にいる敵ユニットに{2}と1秒間{3}を与える（2.5秒間当て続けた場合は{4}）。また0.5秒毎に" + P + "のスタックが増加する。スキルを再使用することで中断できる。ミニオン(モンスターには無効)に対しては500%のダメージを与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 50, 20, ap(0.06))
                .variable(3, MSSlowRatio, 20)
                .variable(4, MagicDamage, 500, 200, ap(0.6))
                .mana(100)
                .cd(130, -20)
                .range(1550)
                .type(SkillType.Channel);
    }

    /**
     * Define skill.
     */
    public static void Vi(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P517)
                .passive("敵ユニットにスキルでダメージを与えると、3秒間{1}を得る。この効果は{2}に一度発動する。")
                .variable(1, Shield, amplify(Health, 0.1))
                .variable(2, Time, new PerLevel(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8));

        Q.update(P404)
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵チャンピオンに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、ミニオンや中立クリープに与えるダメージは75%に減少する。途中で詠唱を停止させられた場合、このスキルのCDは3秒になり、消費したmanaの半分が回復する。")
                .variable(1, PhysicalDamage, 50, 25, bounusAD(0.8))
                .variable(2, PhysicalDamage, 100, 50, bounusAD(1.6))
                .variable(3, Distance, 250)
                .variable(4, Distance, 725)
                .mana(50, 10)
                .cd(18, -2.5)
                .range(250);

        W.update(P303)
                .passive("同一対象に3回連続して通常攻撃を行うと、{1}と4秒間{2}を与え、4秒間{3}する。(ミニオンやモンスターへは最大300ダメージが上限)")
                .variable(1, PhysicalDamage, amplify(TargetMaxHealthRatio, 4, 1.5, bounusAD(0.03)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, ASRatio, 30, 5);

        E.update(P419)
                .active("チャージを1つ消費することで、次の通常攻撃は{1}し対象とその後方扇形{2}にいる敵ユニットに{3}を与る。チャージは{4}毎に増加し、最大2つまでスタックされる。")
                .variable(1, Range, 50)
                .variable(2, Radius, 600)
                .variable(3, PhysicalDamage, 5, 15, ad(1.15), ap(0.7))
                .variable(4, CDRAwareTime, 14, -1.5)
                .mana(60)
                .cd(1);

        R.update(P505)
                .active("対象の敵チャンピオンに突撃し、{1}と{2}を与える。一連の動作中は{4}を得て、また対象のチャンピオン以外で" + champion + "に触れた敵ユニットには{3}を与え、左右に吹き飛ばす。")
                .variable(1, PhysicalDamage, 150, 150, bounusAD(1.4))
                .variable(2, Knockup, 1.25)
                .variable(3, PhysicalDamage, 117.5, 126.25, bounusAD(1.05))
                .variable(4, IgnoreCC)
                .mana(100, 25)
                .cd(150, -35)
                .range(800);
    }

    /**
     * Define skill.
     */
    public static void Viktor(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P404)
                .passive(champion + "は最初から" + Item.PrototypeHexCore + "という、自身のステータスを強化するアイテムを所持している。" + Item.PrototypeHexCore + "はショップで1000Gを消費して3回アップグレードでき、その都度スキルを一回強化できる。" + Item.PrototypeHexCore + "はアイテムスロットを1つ占有し、売却することは出来ない。<br>" + Item.PrototypeHexCore + " : {1}を得る。<br>" + Item.TheHexCoremk1 + " : {2}、{3}を得る。<br>" + Item.TheHexCoremk2 + " : {4}、{5}を得る。<br>" + Item.PerfectHexCore + " : {6}、{7}を得る。")
                .variable(-1, AP, level(3))
                .variable(-2, AP, 20, 0, level(4))
                .variable(-3, Mana, 150)
                .variable(-4, AP, 40, 0, level(5))
                .variable(-5, Mana, 300)
                .variable(-6, AP, 60, 0, level(6))
                .variable(-7, Mana, 500);

        Q.update(P404)
                .active("対象の敵ユニットに{1}を与え、2.5秒間{2}を得る。また、次の3.5秒以内の通常攻撃が" + MagicDamage + "に変換され{3}を与える。<br>強化: スキル使用時に{4}する。")
                .variable(1, MagicDamage, 40, 20, ap(0.2))
                .variable(2, Shield, 30, 20, ap(0.2))
                .variable(3, MagicDamage, new PerLevel(20, 25, 30, 35, 40, 45, 50, 55, 60, 70, 80, 90, 110, 130, 150, 170, 190, 210), ap(0.5), ad(1))
                .variable(4, MSRatio, 30)
                .mana(45, 5)
                .cd(10, -1.5)
                .range(600);

        W.update(P303)
                .active("0.25秒詠唱後、指定範囲に4秒間持続する重力束縛装置を呼び出し、{3}の敵ユニットに{1}を与え、0.5秒毎にスタックを付与する。スタックが3溜まった敵ユニットに{2}を与える。<br>強化: " + Stun + "した敵を中心部へ{4}する。")
                .variable(1, MSSlowRatio, 28, 4)
                .variable(2, Stun, 1.5)
                .variable(3, Radius)
                .variable(4, Knockback)
                .mana(65)
                .cd(17, -1)
                .range(700);

        E.update(P419)
                .active("指定地点から指定方向にビームを発射し、ビームが通過する線上の敵ユニットに{1}を与える。また、ビームが通過した地点の{2}。<br>強化: " + E + "の通過した場所で爆発が発生し{3}の敵ユニットに{1}を与える。既に" + E + "に当たった敵ユニットには40%のダメージを与える(合計{4})。")
                .variable(1, MagicDamage, 70, 45, ap(0.7))
                .variable(2, Visionable)
                .variable(3, Radius)
                .variable(4, MagicDamage, 98, 63, ap(0.98))
                .mana(70, 10)
                .cd(13, -1)
                .range(525);

        R.update(P505)
                .active("指定地点に7秒間持続する特異点を呼び出し、{1}の敵ユニットに{2}と{3}を与える。特異点は周囲の敵ユニットに毎秒{4}を与え、また近くにいる敵チャンピオンを自動的に追尾する。このスキルがActiveの間に再度地点を指定することで、特異点を指定した地点に手動で移動させる事が出来る。最大で{5}を与える。<br>強化: " + R + "の移動速度が20%増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 150, 100, ap(0.55))
                .variable(3, Silence, 0.5)
                .variable(4, MagicDamage, 30, 30, ap(0.2))
                .variable(5, MagicDamage, 360, 310, ap(1.95))
                .mana(100)
                .cd(120, -10)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Vladimir(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301).passive("{1}と{2}を得る。").variable(1, AP, amplify(BounusHealth, 0.025)).variable(2, Health, ap(1.4));

        Q.update(P301)
                .active("対象の敵ユニットに{1}を与え、{2}する。")
                .variable(1, MagicDamage, 90, 35, ap(0.6))
                .variable(2, RestoreHealth, 15, 10, ap(0.25))
                .cd(10, -1.5)
                .range(600);

        W.update(P411)
                .active("2秒間血の海に沈む。その間はターゲットされなくなり、{1}内にいる敵ユニットに0.5秒毎に{2}と{3}間の{4}を与え続ける。また、与えたダメージの12.5%Healthが回復する。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 20, 13.75, amplify(BounusHealth, 0.00375))
                .variable(3, Time, 1)
                .variable(4, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 20, 0)
                .cd(26, -3);

        E.update(P416)
                .active("{1}の敵ユニットに{2}を与える。使用する度にスタックが1ずつ最大4まで増加し、10秒増加が無いと0になる。このスキルは周囲に敵ユニットがいなくても使用可能。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 60, 25, ap(0.45), amplify(Stack, 15, 6.25))
                .variable(4, RestoreHealthRatio, 4, 1)
                .cost(Health, new Diff(30, 10, 5), amplify(Stack, 7.5, 2.5))
                .cd(4.5)
                .range(610);

        R.update(P313)
                .active("指定地点の{1}の敵ユニットに疫病を付与し、その敵ユニットは5秒間受けるダメージが12%増加する。効果終了時に{2}を与える。ダメージ増加効果のため実際には{3}を与える。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MagicDamage, 168, 112, ap(0.784))
                .cd(150, -15)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void Volibear(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive(champion + "の" + Health + "が30%以下になったとき、6秒間かけて{1}する。{2}。")
                .variable(1, RestoreHealth, amplify(Health, 0.3))
                .variable(2, CDRUnaware)
                .cd(-120);

        Q.update(P409)
                .active("4秒間{1}する。敵チャンピオンに向かって移動する場合は{2}する。また次の通常攻撃に追加{3}を付与し、対象をVolibearの後ろに投げ飛ばす。4秒間攻撃を行わないとCDになる。")
                .variable(1, MSRatio, 15)
                .variable(-2, MSRatio, 30, 5)
                .variable(3, PhysicalDamage, 30, 30)
                .mana(40)
                .cd(12, -1);

        W.update(P505)
                .passive("通常攻撃でダメージを与える度にスタックが1増加し(最大3スタック)、{1}する。スタックは4秒持続する。")
                .variable(-1, ASRatio, amplify(Stack, 8, 3))
                .active("スタックが最大まで溜まった時のみ使用可能。対象の敵ユニットに{2}を与える。対象が失っているHP1%につきダメージが1%上昇する。")
                .variable(2, PhysicalDamage, 80, 45, amplify(BounusHealth, 0.15))
                .mana(35)
                .cd(18)
                .range(400);

        E.update(P301)
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。対象がミニオンの場合、さらに{4}を与える。")
                .variable(1, Radius, 425)
                .variable(2, MagicDamage, 60, 45, ap(0.6))
                .variable(3, MSSlowRatio, 30, 5)
                .variable(4, Fear, 3)
                .mana(60, 5)
                .cd(11);

        R.update(P516)
                .active("雷を放ち{2}の敵1体に{1}を与え、以後12秒間通常攻撃した対象に雷を放ち{1}を与える。雷は対象の{2}の敵ユニット(敵チャンピオンを優先)3体にも連鎖し同様のダメージを与える。建物を攻撃する時は効果は発生しない。")
                .variable(1, MagicDamage, 75, 40, ap(0.3))
                .variable(2, Radius, 300)
                .mana(100)
                .cd(100, -10);
    }

    /**
     * Define skill.
     */
    public static void Warwick(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("通常攻撃で対象にスタックを付与し、追加{1}を与え{2}する。スタックは4秒持続し、最大3つまでスタックされる。建物を攻撃した場合は無効。")
                .variable(1, MagicDamage, amplify(Stack, new PerLevel(3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)))
                .variable(2, RestoreHealth, amplify(Stack, new PerLevel(3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)));

        Q.update(P301)
                .active("対象の敵ユニットに{1}を与え、{2}する。対象がチャンピオンの場合は{3}と比較し大きいほうのDMを与える。")
                .variable(1, MagicDamage, 75, 50, ap(1))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 80))
                .variable(3, MagicDamage, 0, 0, ap(1), amplify(TargetMaxHealthRatio, 8, 2))
                .mana(70, 10)
                .cd(10, -1)
                .range(400);

        W.update(P421)
                .active("6秒間{2}し、{1}の味方チャンピオンは{3}する。")
                .variable(1, Radius, 1250)
                .variable(2, ASRatio, 40, 10)
                .variable(-3, ASRatio, 20, 5)
                .mana(35)
                .cd(24, -2);

        E.update(P508)
                .active("{2}に" + Health + "が50%以下の敵チャンピオンがいると{1}して、対象の{3}。このスキルで敵のステルスを看破する事はできず、ステルス中の敵チャンピオンの視界を得ることもできない。")
                .variable(1, MSRatio, 20, 5)
                .variable(2, Radius, 1500, 800)
                .variable(3, Visionable)
                .cd(4)
                .type(SkillType.Toggle);

        R.update(P421)
                .active("対象の敵チャンピオンに突撃し{2}を与えて、その間{3}を得て0.3秒毎に{1}を、計5回で{4}を与える。{5}。")
                .variable(1, MagicDamage, 30, 20, bounusAD(0.4))
                .variable(2, Suppression, 1.8)
                .variable(3, LS, 30)
                .variable(4, MagicDamage, 150, 100, bounusAD(2))
                .variable(5, OnHitEffect)
                .type(SkillType.Channel)
                .mana(100, 25)
                .cd(110, -20)
                .range(700);
    }

    /**
     * Define skill.
     */
    public static void MonkeyKing(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P312)
                .passive("視界内{1}にいる敵チャンピオンの数に比例して、{2}と{3}を得る。")
                .variable(1, Radius, 1400)
                .variable(2, AR, amplify(EnemyChampion, new Per6Level(4, 2)))
                .variable(3, MR, amplify(EnemyChampion, new Per6Level(4, 2)));

        Q.update(P405)
                .active("次の通常攻撃は{3}して追加の{1}と3秒間{2}を与える。")
                .variable(1, PhysicalDamage, 30, 30, ad(0.1))
                .variable(2, ARReductionRatio, 10, 5)
                .variable(3, Range, 125)
                .mana(40)
                .cd(9, -1);

        W.update(P301)
                .active("{1}になり{2}を得る。同時に" + champion + "がいた場所に分身(操作不可能)を作り出す。分身は1.5秒経過すると消滅し、その際に分身の{3}の敵に{4}を与える。")
                .variable(1, Stealth, 1.5)
                .variable(2, IgnoreUnitCollision)
                .variable(3, Radius, 175)
                .variable(4, MagicDamage, 70, 45, ap(0.6))
                .mana(50, 5)
                .cd(18, -2);

        E.update(P418)
                .active("対象の敵ユニットまでダッシュし{1}を与える。対象の敵ユニットの{3}の敵ユニット2体にも" + champion + "の幻影が飛び、{1}を与える。また、スキル使用後4秒間{2}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.8))
                .variable(2, ASRatio, 30, 5)
                .variable(3, Radius, 325)
                .mana(45, 5)
                .cd(8)
                .range(625);

        R.update(P405)
                .active("4秒間" + champion + "が回転する。回転中は{1}の敵ユニットに1秒毎に{2}と{3}を与える。" + Knockup + "は同一の対象に1度までしか発生しない。また、このスキルを使用してから0.5秒毎に{5}する。最大で{4}を与え、{6}する。")
                .variable(1, Radius, 325)
                .variable(2, PhysicalDamage, 20, 90, ad(1.1))
                .variable(3, Knockup, 1.5)
                .variable(4, PhysicalDamage, 80, 360, ad(4.4))
                .variable(-5, MSRatio, 5)
                .variable(6, MSRatio, 40)
                .mana(100)
                .cd(120, -15);
    }

    /**
     * Define skill.
     */
    public static void Xerath(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P402)
                .passive("通常攻撃を行うと{1}する。チャンピオンを攻撃した場合は回復量が2倍になる。建物に対しては無効。")
                .variable(1, RestoreMana, new PerLevel(30, 33, 36, 42, 48, 54, 63, 72, 81, 90, 102, 114, 126, 138, 150, 165, 180, 195))
                .cd(-12);

        Q.update(P402)
                .active("最初にスキルを使用するとチャージを行う。この間は通常攻撃や他のスキルを使用できなくなり、移動速度が徐々に低下(最大で-50%)するが、チャージしている間は徐々にこのスキルの射程距離が増加していき、1.5秒後に最大射程1400に到達。再度このスキルを使用することで指定方向に電撃を放ち、直線状にいる敵ユニットに{1}を与える。チャージを行って3秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, MagicDamage, 80, 40, ap(0.75))
                .cd(9, -1)
                .mana(80, 10)
                .range(750);

        W.update(P415)
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

        E.update(P504)
                .active("指定方向に雷のオーブを放ち、当たった敵ユニットに{1}と{2}を与える。飛距離に比例してスタンの効果時間が延長する（0.75秒から2秒）。")
                .variable(1, MagicDamage, 80, 30, ap(0.45))
                .variable(2, Stun)
                .cd(13, -0.5)
                .mana(60, 5)
                .range(1050);

        R.update(P508)
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
    public static void XinZhao(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("通常攻撃または" + E + "で指定した敵ユニットに{1}を与える。この効果はスタックせず、3秒間持続し、また1体の敵ユニットにしか発動しない。")
                .variable(1, ARReductionRatio, 15);

        Q.update(P301)
                .active("次の3回の通常攻撃に{1}が追加され、3回目の攻撃で{2}を与える。効果中に通常攻撃を行う度に、このスキル以外のCDが1秒解消される。")
                .variable(1, PhysicalDamage, 15, 15, ad(0.2))
                .variable(2, Knockup, 1)
                .mana(30)
                .cd(9, -1);

        W.update(P514)
                .passive("通常攻撃3回ごとに{1}する。")
                .variable(1, RestoreHealth, 30, 5, ap(0.6))
                .active("5秒間{2}増加する。")
                .variable(2, ASRatio, 40, 10)
                .mana(40)
                .cd(16, -1);

        E.update(P505)
                .active("対象の敵ユニットに突進し、{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MSSlowRatio, 25, 5)
                .mana(60)
                .cd(14, -1)
                .range(600);

        R.update(P509)
                .active("槍を振り回し{3}の敵ユニットに{1}と{2}を与え、このスキルを命中させた敵チャンピオンの数に比例して6秒間{4}と{5}を得る。" + P + "効果中の敵ユニットに対しては" + Knockback + "は発動しない。")
                .variable(1, PhysicalDamage, 75, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .variable(2, Knockback, 0)
                .variable(3, Radius, 375)
                .variable(4, AR, 15, 5)
                .variable(5, MR, 15, 5)
                .mana(100)
                .cd(120, -10);
    }

    /**
     * Define skill.
     */
    public static void Yasuo(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P508)
                .passive("一定距離({1})を移動すると最大値の1%のFlowを得る。{2}するがクリティカルダメージは10%減少する。この減少効果はダメージ増減算の前に適用される。(例: 本来200%のクリティカルダメージは(100 - 10) x 2 = 180%になり、" + Item.InfinityEdge.name + "を持った場合本来250%のダメージが(100 - 10) * 2.5 = 225%になる)。Flowが最大値の時、敵チャンピオンかモンスターからダメージを受けると全てのFlowを消費して{5}間{3}を得る。")
                .variable(1, Value, new Per6Level(59, -7))
                .variable(2, Critical, amplify(Critical, 1))
                .variable(3, Shield, new PerLevel(new double[] {100, 105, 110, 115, 120, 130, 140, 150, 165, 180, 200, 225, 255, 290, 330,
                        380, 440, 510}))
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

        W.update(P413).active("3.75秒間持続する{1}の壁を作り出す。この壁はタワー攻撃を除く全ての投射物をブロックする。").variable(1, Length, 300, 50).cd(26, -2).range(400);

        E.update(P417)
                .active("マークの付いていない対象の敵の方向に飛び込み({2})移動する。対象に{1}を与え{3}間マークを付与する。スキル使用時にスタックが増加し、1スタックごとに基礎ダメージが25%増加していく。(最大2スタックで{4})")
                .variable(1, MagicDamage, 70, 20, ap(0.6))
                .variable(2, Distance, 475)
                .variable(3, Time, 10, -1)
                .variable(4, MagicDamage, 105, 35, ap(0.6))
                .cd(-0.5, 0.1)
                .range(475);

        R.update(P402)
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
        P.update(P301)
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}")
                .variable(1, DamageReductionRatio, amplify(Stack, 5))
                .variable(2, AttackDamageRatio, amplify(Stack, 5))
                .variable(3, Value, amplify(Health, 0.35))
                .variable(4, Value, 0, 0, ad(0.35))
                .variable(5, Value, 10, 0, level(2))
                .variable(6, Value, 20, 0, level(2))
                .variable(7, Value, new PerLevel(new int[] {1, 6, 9, 12}, 300, 40))
                .variable(8, Gold, 5);

        Q.update(P506)
                .active("次の通常攻撃は{4}し{1}を与えると同時にSpectral Ghoulを召喚する。Spectral Ghoulは{3}を得る。Spectral Ghoulが生存している間、Ghoulと自身の{q2}する。")
                .variable(1, PhysicalDamage, 30, 30, ad(1.2))
                .variable(2, MSRatio, 15, 5)
                .variable(-3, AD, 8, 8)
                .variable(4, Range, 50)
                .mana(40)
                .cd(9, -1);

        W.update(P301)
                .active("指定地点を爆発させ{1}の敵ユニットに{2}と1.5秒{3}を与え、同時にその地点にDecaying Ghoulを召喚する。Decaying Ghoulは近くの敵ユニットに継続的に{4}与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 35, ap(1))
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, MSSlowRatio, 10, 2.5)
                .mana(55, 5)
                .cd(12)
                .range(600);

        E.update(P402)
                .active("対象の敵ユニットに{1}を与え、{2}し対象の背後にRavenous Ghoulを召喚する。Ravenous Ghoulが通常攻撃を行うたびに{3}する。敵チャンピオンを攻撃した場合は{4}する。")
                .variable(1, MagicDamage, 55, 30, bounusAD(1))
                .variable(2, RestoreHealth, amplify(DealtDamageRatio, 40))
                .variable(3, RestoreHealth, 0, 0, ad(0.175))
                .variable(4, RestoreHealth, 0, 0, ad(0.35))
                .mana(55, 5)
                .cd(10, -1)
                .range(550);

        R.update(P404)
                .active("対象の味方チャンピオン一人の姿形を持ったRevenantを召喚する(ALT押しながら右クリックで任意の操作可能)。Revenantは10秒間持続し、対象の{1}の攻撃力を持つ。Revenantが生存している間に対象となった味方チャンピオンが死亡した場合、Revenantが消滅し、死亡した味方チャンピオンはHPとMNが最大の状態で蘇生される。蘇生した味方チャンピオンは10秒経過すると消滅する。")
                .variable(1, Percentage, 45, 15)
                .mana(100)
                .cd(120, -15)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void Zac(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P403)
                .passive("スキルが敵ユニットに命中する度に小型のスライムが出現する。スライム({5})を自身が回収すると{1}し、敵が回収すると消滅する。また、" + Health + "が0になった時4つのスライムに分裂し一定時間かけて復活する。復活中にすべてのスライムが死亡すると" + champion + "も死亡する。復活時の" + Health + "は生きているスライムの数に比例し増加(10-50%)する。スライムは以下のステータスを持つ。<br>Health : {2}<br>AR : {3}<br>MR : {4}")
                .variable(1, RestoreHealth, amplify(Health, 0.04))
                .variable(2, Value, amplify(Health, 0.12))
                .variable(3, Value, amplify(AR, 0.5))
                .variable(4, Value, amplify(MR, 0.5))
                .variable(5, Radius, 50)
                .cd(300);

        Q.update(P305)
                .active("指定方向に腕を伸ばし範囲内にいる敵ユニットに{1}と2秒間{2}を与える。")
                .variable(1, MagicDamage, 70, 40, ap(0.5))
                .variable(2, MSSlowRatio, 20, 5)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(9, -0.5)
                .range(550);

        W.update(P505)
                .active("{1}にいる敵ユニットに{2}を与える。(ミニオンに対しては200ダメージが上限)")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 15, amplify(TargetMaxHealthRatio, 4, 1, ap(0.02)))
                .cost(CurrentHealthRatio, 4, 0)
                .cd(4);

        E.update(P516)
                .active("その場で停止しチャージを行う。チャージした時間に比例して射程が前方扇形範囲で徐々に増加する。再度使用で指定した地点にジャンプし、着地時に範囲内にいる敵ユニットに{1}と{2}を与える。チャージは移動を行う事でキャンセルできる。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Knockback)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(24, -3)
                .range(1200, 150);

        R.update(P512)
                .active("4回飛び跳ね、その度に{6}にいる敵ユニットに{1}と{2}と1秒間{3}を与える。ノックバックは同一の対象に1度までしか発生せず、同一ユニットに複数回DMを与える場合、2回目以降は50%のダメージになる。このスキルが発動している間は" + W + "と移動のみが可能であり、また徐々に移動速度が増加する(20-50%増加)。{5}。")
                .variable(1, MagicDamage, 140, 70, ap(0.4))
                .variable(2, Knockback, 400)
                .variable(3, MSSlowRatio, 20)
                .variable(4, Tenacity, 75)
                .variable(5, IgnoreSlow)
                .variable(6, Radius, 300)
                .cd(130, -15)
                .range(300);
    }

    /**
     * Define skill.
     */
    public static void Zed(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive(Health + "が50%以下の敵ユニットへの通常攻撃に{1}を付与する。同一の対象には10秒に一度しか発動しない。")
                .variable(1, MagicDamage, amplify(TargetMaxHealthRatio, new PerLevel(new int[] {1, 7, 17}, 6, 2)));

        Q.update(P307)
                .active(champion + "と「影」から指定方向に貫通する手裏剣を飛ばし、当たった敵ユニットに{1}を与える。手裏剣は一度敵ユニットに当たるとそれ以降の敵ユニットには{3}を与える。" + champion + "と「影」が同一の対象に手裏剣を命中させた場合、2発目以降は{2}を与える。")
                .variable(1, PhysicalDamage, 75, 40, bounusAD(1))
                .variable(2, PhysicalDamage, 37.5, 20, bounusAD(0.5))
                .variable(3, PhysicalDamage, 45, 24, bounusAD(0.6))
                .cost(Energy, 75, -5)
                .cd(6)
                .range(900);

        W.update(P415)
                .passive("{1}を得る。")
                .variable(1, AD, amplify(BounusAD, 0.05, 0.05))
                .active("「影」が指定方向にダッシュし({5})、4秒間その場に留まり{2}の{3}。再度このスキルを使用すると" + champion + "と「影」の位置が入れ替わる。「影」は" + champion + "が通常スキルを使用すると同時に同じスキルを使用する。この時スキルが" + champion + "のスキルと同一の敵ユニットに命中した場合、{4}する。回復効果はスキル1回毎に1度のみ発動する。")
                .variable(2, Radius, 700)
                .variable(3, Visionable)
                .variable(4, RestoreEnergy, 20, 5)
                .variable(5, MissileSpeed, 1500)
                .cost(Energy, 40, -5)
                .cd(18, -1)
                .range(550);

        E.update(P307)
                .active(champion + "と「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。" + champion + "の" + E + "は敵チャンピオンに当たる度に" + W + "の{4}。「影」の" + E + "はダメージと共に敵ユニットに1.5秒間{3}を与える。" + champion + "と「影」が同一の対象にShadow Slashを命中させた場合、" + Damage + "は重複しないがスローの効果が上昇する。")
                .variable(1, Radius, 290)
                .variable(2, PhysicalDamage, 60, 30, bounusAD(0.9))
                .variable(3, MSSlowRatio, 30, 7.5)
                .variable(4, CDDecrease, 2)
                .cost(Energy, 50, 0)
                .cd(4)
                .range(290);

        R.update(P516)
                .active("対象の敵チャンピオンにダッシュしマークを付与する。ダッシュ中は0.75秒間ターゲット不可状態になる。また詠唱地点に6秒間持続する「影」を召喚する。0.5秒経過後、再度このスキルを使用すると" + champion + "と「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間に" + champion + "と「影」が与えた" + TrueDamage + "以外のダメージの合計に比例し{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1), amplify(DealtDamageRatio, 20, 15))
                .variable(2, Radius, 2000)
                .cd(120, -20)
                .range(625);
    }

    /**
     * Define skill.
     */
    public static void Ziggs(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P412)
                .passive("12秒毎に通常攻撃に追加{1}が付与される。スキルを使う度に{2}する。建物に対しては1.5倍の" + Damage + "を与える。")
                .variable(1, MagicDamage, new PerLevel(20, 24, 28, 32, 36, 40, 48, 56, 64, 72, 80, 88, 100, 112, 124, 136, 148, 160), amplify(AP, new Per6Level(0.25, 0.05)))
                .variable(2, CDDecrease, 4)
                .cd(-12);

        Q.update(P506)
                .active("指定地点に跳ねながら転がる爆弾を投げ、爆発時に{1}の敵ユニットに{2}を与える。敵に当たらなかった場合には投げた方向に2回までバウンドする。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 75, 45, ap(0.65))
                .mana(50, 10)
                .cd(6, -0.5)
                .range(850);

        W.update(P412)
                .active("指定地点に{6}で火薬を投げ、爆発時に{1}の敵ユニットに{2}を与え、{3}させる。" + champion + "が範囲内にいた場合は自分も{3}する(" + champion + "にダメージは無し)。火薬は4秒経つか、スキルを再度使用すると爆発する。また火薬は{5}。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 70, 35, ap(0.35))
                .variable(3, Knockback, 400)
                .variable(5, Visionable)
                .variable(6, MissileSpeed, 1750)
                .mana(65)
                .cd(26, -2)
                .range(1000);

        E.update(P402)
                .active("指定地点の{4}に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れる({5})と{1}と1.5秒間{2}を与える。同ユニットが2個目以降に踏むと{3}を与える。地雷は爆発するか10秒経つと消滅する。")
                .variable(1, MagicDamage, 40, 25, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, MagicDamage, 16, 10, ap(0.12))
                .variable(4, Radius, 400)
                .variable(5, Radius, 150)
                .mana(70, 10)
                .cd(16)
                .range(900);

        R.update(P413)
                .active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。ミニオンやモンスターには2倍のダメージを与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 250, 125, ap(0.9))
                .variable(3, Radius, 750)
                .variable(4, MagicDamage, 200, 100, ap(0.72))
                .mana(100)
                .cd(120)
                .range(5300);
    }

    /**
     * Define skill.
     */
    public static void Zilean(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P419).passive("{2}の味方チャンピオンが取得する{1}する。").variable(1, ExperimentRatio, 8).variable(2, Radius, 1500);

        Q.update(P514)
                .active("指定した場所に時限式の爆弾を投げ、{1}に入った最初のユニットに爆弾がくっつく（チャンピオン優先）。3秒後に爆発し、{2}にいるすべての敵に{3}を与える。同じユニットに2個目の爆弾を仕掛けると1個目の爆弾はすぐに爆発し、爆風の中ににいるすべての敵に{4}を与える。")
                .variable(1, Radius, 100)
                .variable(2, Radius, 300)
                .variable(3, MagicDamage, 75, 40, ap(0.9))
                .variable(4, Stun, 1.1, 0.1)
                .mana(60, 5)
                .cd(10, -0.5)
                .range(900);

        W.update(P513).active(Q + "と" + E + "の{1}する。このスキルはどちらかのスキルがCD中のみ使用できる。").variable(1, CDDecrease, 10).mana(35).cd(14, -2);

        E.update(P506)
                .active("味方チャンピオンに使用した場合は2.5秒間{1}増加し、敵チャンピオンに使用した場合は2.5秒間{2}を与える。")
                .variable(1, MSRatio, 40, 15)
                .variable(2, MSSlowRatio, 40, 15)
                .mana(50)
                .cd(15)
                .range(550);

        R.update(P301)
                .active("対象の味方チャンピオンが使用してから7秒以内に死亡した場合、2秒後にその場で{1}して復活する。")
                .variable(1, RestoreHealth, 600, 150, ap(2))
                .mana(125, 25)
                .cd(120, -30)
                .range(900);
    }

    /**
     * Define skill.
     */
    public static void Zyra(Champion champion, Skill P, Skill Q, Skill W, Skill E, Skill R) {
        P.update(P301)
                .passive("死亡すると2秒後にその場で植物に変形し、指定方向に一度だけ貫通する光線を放つことができる。光線に当たった敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 80, 0, level(20))
                .range(1500);

        Q.update(P313)
                .active("地面から棘を出現させ、指定範囲内の敵ユニットに{1}を与える。種にHitした場合Thorn Spitterに成長し、{3}の敵を自動攻撃して{2}を与える。Thorn Spitterは10秒間持続する。")
                .variable(1, MagicDamage, 70, 35, ap(0.65))
                .variable(2, MagicDamage, 23, 0, level(6.5), ap(0.2))
                .variable(3, Radius, 750)
                .mana(75, 5)
                .cd(7, -0.5)
                .range(800);

        W.update(P313)
                .passive("{1}を得る。")
                .variable(1, CDR, 2, 2)
                .active("指定地点に30秒持続する種を植える。他のスキルを種に当てることで成長させることができる。敵チャンピオンが種を踏んだ場合、視界を2秒間得る。{2}毎にチャージが1つ増加し最大2つまでチャージされる。種が植物に成長し、同一ユニットに複数の植物が" + Damage + "を与える場合、2体目以降は50%の" + Damage + "を与える。")
                .variable(2, CDRAwareTime, 17, -1)
                .range(850)
                .cost(Charge, 1, 0);

        E.update(P301)
                .active("指定方向に蔓を放ち、当たった全ての敵ユニットに{1}と{2}を与える。種にHitした場合Vine Lasherに成長し、{3}の敵を自動攻撃して{4}と2秒間{5}を与える。Vine Lasherは10秒間持続する。")
                .variable(1, MagicDamage, 60, 35, ap(0.5))
                .variable(2, Snare, 0.75, 0.25)
                .variable(3, Radius, 400)
                .variable(4, MagicDamage, 23, 0, level(6.5), ap(0.2))
                .variable(5, MSSlowRatio, 30)
                .mana(70, 5)
                .cd(12)
                .range(1100);

        R.update(P313)
                .active("指定地点に藪を召還し、{1}の全ての敵に{2}を与え、2秒後に{3}。成長した植物にHitした場合、その植物の攻撃速度が50%増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 180, 85, ap(0.7))
                .variable(3, Knockup, 1)
                .mana(100, 20)
                .cd(130, -10)
                .range(700);
    }
}
