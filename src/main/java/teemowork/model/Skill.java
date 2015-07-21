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

import static teemowork.model.Champion.*;
import static teemowork.model.SkillKey.*;
import static teemowork.model.Status.*;
import static teemowork.model.Version.*;

import teemowork.model.variable.VariableResolver.Diff;
import teemowork.model.variable.VariableResolver.Fixed;
import teemowork.model.variable.VariableResolver.Per1Level;
import teemowork.model.variable.VariableResolver.Per2Level;
import teemowork.model.variable.VariableResolver.Per3Level;
import teemowork.model.variable.VariableResolver.Per3LevelAdditional;
import teemowork.model.variable.VariableResolver.Per3LevelForKarma;
import teemowork.model.variable.VariableResolver.Per4Level;
import teemowork.model.variable.VariableResolver.Per4LevelForTrundle;
import teemowork.model.variable.VariableResolver.Per5Level;
import teemowork.model.variable.VariableResolver.Per5Level3Times;
import teemowork.model.variable.VariableResolver.Per5LevelForAshe;
import teemowork.model.variable.VariableResolver.Per5LevelForHeimer;
import teemowork.model.variable.VariableResolver.Per5LevelForSejuani;
import teemowork.model.variable.VariableResolver.Per5LevelForYoric;
import teemowork.model.variable.VariableResolver.Per5LevelWith18;
import teemowork.model.variable.VariableResolver.Per6Level;
import teemowork.model.variable.VariableResolver.Per6LevelForVi;
import teemowork.model.variable.VariableResolver.Per6LevelForZed;
import teemowork.model.variable.VariableResolver.Refer;

/**
 * @version 2015/07/21 16:42:24
 */
public class Skill extends Describable<SkillDescriptor> {

    /** The owner data. */
    private final String name;

    /** The owner champion. */
    private final String owner;

    /** The icon position. */
    private final float iconPosition;

    /** The skill key type. */
    public final SkillKey key;

    /**
     * The skill definition.
     */
    public Skill(String name, String owner, int id, int size) {
        this.name = name;
        this.owner = owner;
        this.iconPosition = id / (size - 1) * 100;
        this.key = SkillKey.values()[id < 5 ? id : id - 4];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SkillDescriptor createDescriptor(Version version, SkillDescriptor previous) {
        return new SkillDescriptor(this, previous, version);
    }

    /**
     * <p>
     * Retrieve the skill name.
     * </p>
     * 
     * @return A name of this skill.
     */
    public String getName() {
        if (!initialized) initilaize();
        return name;
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/skill/" + owner + ".jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public float getIconPosition() {
        return iconPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * <p>
     * Returns minimum skill level.
     * </p>
     * 
     * @return
     */
    public int getMinLevel() {
        if (key == Passive || this == Karma.R) {
            return 1;
        }

        if (this == Elise.R || this == EliseSpider.R || this == Jayce.R || this == JayceCannon.R) {
            return 1;
        }
        return 0;
    }

    /**
     * <p>
     * Returns maximum skill level.
     * </p>
     * 
     * @return
     */
    @Override
    public int getMaxLevel() {
        if (key == Passive) {
            return 0;
        }

        if (this == Elise.R || this == EliseSpider.R || this == Jayce.R || this == JayceCannon.R || this == Karma.R) {
            return 4;
        }

        if (this != Udyr.R && (key == R || this == NidaleeCougar.Q || this == NidaleeCougar.W || this == NidaleeCougar.E)) {
            return 3;
        } else {
            return 5;
        }
    }

    /** The initialization state. */
    private static boolean initialized;

    /**
     * Initialize {@link Skill}.
     */
    private static void initilaize() {
        initialized = true;

        Aatrox();
        Ahri();
        Akali();
        Alistar();
        Amumu();
        Anivia();
        Annie();
        Ashe();
        Blitzcrank();
        Brand();
        Caitlyn();
        Ryze();
        Cassiopeia();
        ChoGath();
        Corki();
        Darius();
        Diana();
        DrMundo();
        Draven();
        Elise();
        Evelynn();
        Ezreal();
        Fiddlesticks();
        Fiora();
        Fizz();

        /** Galio */
        Galio.P.update().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(MR, 0.5));
        Galio.Q.update()
                .active("指定地点に魔法弾を飛ばし、{1}の敵ユニットに{2}と2.5秒間{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(0.6))
                .variable(3, MSSlowRatio, 24, 4)
                .mana(60, 5)
                .cd(7)
                .range(900);
        Galio.W.update()
                .active("4秒間対象のChampionは{1}と{2}を得て、効果中にその対象のChampionがダメージを受ける度にGalioの{3}する。自身に使用した場合はダメージを受けてから回復される。")
                .variable(1, AR, 30, 15)
                .variable(2, MR, 30, 15)
                .variable(3, RestoreHealth, 25, 15, ap(0.3))
                .mana(60)
                .cd(13)
                .range(800);
        Galio.E.update()
                .active("指定方向に風を発生させ、当たった敵ユニットに{1}を与える。このスキルを使用すると指定した方向に5秒間持続する風が残り、その風の進行方向上にいる味方ユニットは{2}する。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, MSRatio, 20, 8)
                .mana(70, 5)
                .cd(12)
                .range(1000);
        Galio.R.update()
                .active("{1}の敵ユニットに{2}を与え、さらに2秒間詠唱を行う。詠唱中Galioは{3}して、詠唱中にGalioがダメージを受ける度にこのスキルのダメージが5%ずつ増加していく(最大40%増加)。また詠唱中にBulwarkを使用することが出来る。詠唱完了またはキャンセル時に、周囲の敵ユニットのTauntを解除するとともに{4}を与える。最大DMは{5}。")
                .variable(1, Radius, 600)
                .variable(2, Taunt, 2)
                .variable(3, DamageReductionRatio, 50)
                .variable(4, MagicDamage, 220, 110, ap(0.6))
                .variable(5, MagicDamage, 308, 154, ap(0.84))
                .mana(100, 50)
                .cd(170, -20)
                .type(SkillType.Channel);
        Galio.R.update(P311).cd(150, -15).mana(100);

        /** Gangplank */
        Gangplank.P.update()
                .passive("通常攻撃時に対象にスタックを付与し、1スタックにつき毎秒{1}と{2}を与える。この効果は3秒間持続し、3回までスタックする。")
                .variable(1, MagicDamage, 3, 0, amplify(Lv, 1))
                .variable(2, MSSlowRatio, 7);
        Gangplank.Q.update()
                .active("対象の敵ユニットに{1}(クリティカルあり)を与える。このスキルで敵ユニットを倒すと消費マナの半分のマナが回復し、追加で{2}得る。{3}。")
                .variable(1, PhysicalDamage, 20, 25, ad(1))
                .variable(2, Gold, 4, 1)
                .variable(3, OnHitEffect)
                .mana(50, 5)
                .cd(5)
                .range(625);
        Gangplank.W.update()
                .active("自身のCC(Stun, Slow, Taunt, Fear, Snare, Silence, Suppression, Blind)を取り除き{1}する。StunなどのDisable中でも使用可能。")
                .variable(1, RestoreHealth, 80, 70, ap(1))
                .mana(65)
                .cd(22, -1);
        Gangplank.E.update()
                .passive("{1}を得て、{2}する。")
                .variable(1, AD, 8, 2)
                .variable(2, MSRatio, 3, 1)
                .active("7秒間{7}を得て、{3}する。{6}内の味方Championは{4}を得て{5}する。効果中はPassiveの効果が無効になる。")
                .variable(6, Radius, 1200)
                .variable(7, AD, 12, 7)
                .variable(3, MSRatio, 8, 3)
                .variable(4, AD, 6, 3.5)
                .variable(5, MSRatio, 4, 1.1)
                .mana(50, 5)
                .cd(25);
        Gangplank.R.update()
                .active("MAP内の指定した地点に砲撃を行い、その地点の視界({1})を得る。範囲内には7秒間砲弾が降り注ぎ(場所はランダム、計25発)、着弾した{2}にいる敵ユニットに{4}と1.25秒間{3}を与える。")
                .variable(1, Radius, 575)
                .variable(2, Radius, 275)
                .variable(3, MSSlowRatio, 25)
                .variable(4, MagicDamage, 75, 45, ap(0.2))
                .mana(100)
                .cd(120, -5)
                .range(-1);

        /** Garen */
        Garen.P.update()
                .passive("9秒間敵Minion以外からダメージを受けない状態が続くと、以降敵Minion以外からダメージを受けるまで毎秒{1}し続ける。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.005));
        Garen.P.update(P303).variable(1, RestoreHealth, 0, 0, amplify(Health, 0.004));
        Garen.Q.update()
                .active("{1}間{2}し、スキル使用後6秒間に行った次の通常攻撃に追加{3}と{4}が付与される。またこのスキル使用時に自身にかかっているスローを解除する。")
                .variable(1, Time, 1.5, 0.75)
                .variable(2, MSRatio, 35)
                .variable(3, PhysicalDamage, 30, 25, ad(0.4))
                .variable(4, Silence, 1.5, 0.25)
                .cd(8);
        Garen.W.update()
                .passive("{1}し{2}する。")
                .variable(1, AR, 0, 0, amplify(AR, 0.2))
                .variable(2, MR, 0, 0, amplify(MR, 0.2))
                .active("{3}間{4}し、{5}を得る。")
                .variable(3, Time, 2, 1)
                .variable(4, DamageReductionRatio, 30)
                .variable(5, Tenacity, 30)
                .cd(24, -1);
        Garen.W.update(P303)
                .variable(1, AR, 0, 0, amplify(BounusAR, 0.2))
                .variable(2, MR, 0, 0, amplify(BounusMR, 0.2));
        Garen.E.update()
                .active("Garenが3秒間回転し、その間近くの敵ユニットに0.5秒毎に{1}を与える(最大6hit)。このスキルにはクリティカル判定があり、クリティカル時は追加{2}を与える。回転中は{3}を得るが、敵Minionをすり抜けている間は移動速度が20%低下する。Minionに与えるダメージは通常の75%。")
                .variable(1, PhysicalDamage, 10, 12.5, ad(0.35))
                .variable(2, PhysicalDamage, 0, 0, ad(0.175))
                .variable(3, IgnoreUnitCollision)
                .cd(13, -1);
        Garen.R.update()
                .active("対象の敵Championに{1}を与える。")
                .variable(1, MagicDamage, 175, 175, amplify(TargetMissingHealthRatio, new Fixed(new double[] {28.6,
                        33.3, 40})))
                .cd(160, -40)
                .range(400);

        Gragas();

        /** Graves */
        Graves.P.update()
                .passive("戦闘状態になると1秒ごとにスタックが1増加し、スタック数に比例して{1}と{2}を得る。この効果は10回までスタックし、3秒間戦闘を行わないとスタックが0になる。")
                .variable(1, AR, new Per6Level(1, 1))
                .variable(2, MR, new Per6Level(1, 1));
        Graves.Q.update()
                .active("指定方向扇形の範囲に貫通する弾を3発発射し、当たった敵ユニットに{1}を与える。同一対象に対して複数hitし、2発目以降は本来の35%分の物理DMを与える(3発hitで合計{2})。")
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.8))
                .variable(2, PhysicalDamage, 102, 59.5, bounusAD(1.36))
                .mana(60, 10)
                .cd(12, -1)
                .range(750);
        Graves.W.update()
                .active("指定地点にスモーク弾を発射し範囲内の敵ユニットに{1}を与え、4秒間持続する煙幕を残す。煙幕内にいる敵Championに視界低下と{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.6))
                .variable(2, MSSlowRatio, 15, 5)
                .mana(70)
                .cd(20, -1)
                .range(700);
        Graves.E.update()
                .active("指定方向にダッシュし4秒間{1}する。このスキルは自身が通常攻撃を行う毎に{2}する。対象が建物の場合は無効。")
                .variable(1, ASRatio, 30, 10)
                .variable(2, CDDecrease, 1)
                .mana(50)
                .cd(22, -2)
                .range(425);
        Graves.R.update()
                .active("指定方向にMinionを貫通する爆発弾を発射し、hitした敵ユニットに{1}を与える。敵Championにhitするか最大距離飛ぶとターゲット後方に扇形に爆発が広がり、範囲内の敵ユニットに{2}を与える。")
                .variable(1, PhysicalDamage, 250, 100, bounusAD(1.4))
                .variable(2, PhysicalDamage, 140, 110, bounusAD(1.2))
                .mana(100)
                .cd(100, -10)
                .range(1000);

        Hecarim();
        Heimerdinger();

        /** Irelia */
        Irelia.P.update()
                .passive("Ireliaの視界内(範囲1200)に敵Championがいる数に応じて{1}を得る。効果の上限は最大3人まで。")
                .variable(-1, Tenacity, new Fixed(new double[] {10, 25, 40}));
        Irelia.Q.update()
                .active("対象の敵ユニットに突進し、{1}を与える。このスキルで敵を倒したとき、このスキルの{2}されManaが35回復する。{3}。")
                .variable(1, PhysicalDamage, 20, 30, ad(1))
                .variable(2, CDDecrease)
                .variable(3, OnHitEffect)
                .mana(60, 5)
                .cd(14, -2)
                .range(650);
        Irelia.W.update()
                .passive("通常攻撃を行う度に{1}する。")
                .variable(1, RestoreHealth, 5, 2)
                .active("6秒間通常攻撃に{2}が付与され、PassiveのHP回復量が倍になる。")
                .variable(2, TrueDamage, 15, 15)
                .mana(40)
                .cd(15);
        Irelia.E.update()
                .active("対象の敵ユニットに{1}を与える。対象の残HP%がIreliaより高かった場合{2}を与え、低かった場合は{4}間{3}を与える。")
                .variable(1, MagicDamage, 80, 50)
                .variable(2, Stun, 1, 0.25)
                .variable(3, MSSlowRatio, 60, 0)
                .variable(4, Time, 1, 0.25)
                .mana(50, 5)
                .cd(8)
                .range(425);
        Irelia.R.update()
                .active("指定方向に貫通する刃を飛ばし、当たった敵ユニットに{1}を与える。このスキルは15秒の間、4回まで連続して使用できる(但し、一度使用する度に0.5秒のCDが発生する)。2〜4発目はマナコスト無しで使用可能。ミニオンやモンスターにダメージを与えると{2}し、Championにダメージを与えると{3}する。")
                .variable(1, PhysicalDamage, 80, 40, ap(0.5), bounusAD(0.6))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 10))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 25))
                .mana(100)
                .cd(70, -10)
                .range(1000);

        Janna();
        Jarvan();

        /** Jax */
        Jax.P.update()
                .passive("通常攻撃を行う度にスタックが1増加し、スタック数に比例して{1}する(最大6スタック)。スタックは2.5秒増加がないと0になる。")
                .variable(-1, ASRatio, new Per3Level(4, 2));
        Jax.Q.update()
                .active("対象のユニットまで飛びかかる。対象が敵ユニットの場合、{1}を与える。")
                .variable(1, PhysicalDamage, 70, 40, ap(0.6), bounusAD(1))
                .mana(65)
                .cd(10, -1)
                .range(700);
        Jax.W.update()
                .active("使用後に最初に行った通常攻撃かLeap Strikeに追加{1}を付与する。建物には無効。")
                .variable(1, MagicDamage, 40, 35, ap(0.6))
                .mana(30)
                .cd(7, -1);
        Jax.E.update()
                .active("2秒間、Jaxが受けるタワー以外の通常攻撃を無効化し、AoEダメージを25%低減、さらに効果終了時に{1}の敵ユニットに{2}と{3}を与える。スキルを使用してから1秒経つと再使用できるようになり、任意に効果を終了できる。通常攻撃を回避する度にこのスキルのダメージが20%ずつ増加する(上限は100%、最大で2倍ダメージ)。")
                .variable(1, Radius, 375)
                .variable(2, PhysicalDamage, 50, 25, bounusAD(0.5))
                .variable(3, Stun, 1)
                .mana(70, 5)
                .cd(18, -2);
        Jax.R.update()
                .passive("通常攻撃3回目ごとに追加で{1}を与える。建物には無効。")
                .variable(1, MagicDamage, 100, 60, ap(0.7))
                .active("8秒間{2}と{3}を得る。")
                .variable(2, AR, 25, 10, bounusAD(0.3))
                .variable(3, MR, 25, 10, ap(0.2))
                .mana(100)
                .cd(80);

        Jinx();

        /** Jayce */
        Jayce.P.update()
                .passive("Transformを使用すると1.25秒の間{1}し、{2}を得る。")
                .variable(-1, MS, 40)
                .variable(2, IgnoreUnitCollision);
        Jayce.Q.update()
                .active("対象の敵ユニットに飛びかかり、対象と周囲の敵ユニットに{1}と2秒間{2}を与える。")
                .variable(1, PhysicalDamage, 20, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 30, 5)
                .mana(40, 5)
                .cd(16, -2)
                .range(600);
        JayceCannon.Q.update()
                .active("指定方向に{3}の雷のオーブを飛ばし、敵ユニットに命中するか一定距離で爆発し、周囲の敵ユニット{1}を与える。オーブがAcceleration Gateによって生成されたゲートを通過した場合、弾速、射程距離、爆発範囲、与えるDMが各40%増加する。{2}")
                .variable(1, PhysicalDamage, 60, 55, bounusAD(1.2))
                .variable(2, PhysicalDamage, 84, 77, bounusAD(1.68))
                .variable(3, MissileSpeed, 1350)
                .mana(55, 5)
                .cd(8)
                .range(1050);
        JayceCannon.Q.update(P309).variable(3, MissileSpeed, 1450);
        Jayce.W.update()
                .passive("通常攻撃ごとに{1}する。")
                .variable(1, RestoreMana, 6, 2)
                .active("4秒間雷のオーラを身にまとい、{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 285)
                .variable(3, MagicDamage, 25, 17.5, ap(0.25))
                .mana(40)
                .cd(10);
        JayceCannon.E.update()
                .active("Jayceの攻撃速度が最大まで上昇する。3回通常攻撃を行うと効果が解消される。また効果中は通常攻撃で与えるダメージが{1}%になる。")
                .variable(1, Percentage, 70, 15)
                .mana(40)
                .cd(14, -2);
        Jayce.E.update()
                .active("対象の敵ユニットに{1}と短い距離のノックバックを与える。ミニオンやモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 0, 0, bounusAD(1), amplify(TargetMaxHealthRatio, 8, 3))
                .variable(2, MagicDamage, 200, 100)
                .mana(40)
                .cd(14, -1)
                .range(240);
        JayceCannon.E.update()
                .active("4秒間持続するゲート(通りぬけ可能)を生成し、触れた味方ユニットは3秒間{1}する。移動速度は3秒かけて元に戻る。")
                .variable(1, MSRatio, 30, 5)
                .mana(50)
                .cd(14, -1)
                .range(650);
        JayceCannon.E.update(P309).cd(16);
        Jayce.R.update()
                .active("射程が500(Ranged)になる。また、次の通常攻撃は５秒間{1}と{2}を与える。")
                .variable(1, ARReductionRatio, 10, 5)
                .variable(2, MRReductionRatio, 10, 5)
                .cd(6);
        Jayce.R.update(P309).active("射程が500(Ranged)になる。また、次の通常攻撃は５秒間{1}と{2}を与える。{3}。").variable(3, NotSpellCast);
        JayceCannon.R.update()
                .active("射程が125(Melee)になり、その間は{1}と{2}を得る。また、次の通常攻撃に追加{3}を付与する。")
                .variable(1, AR, 5, 10)
                .variable(2, MR, 5, 10)
                .variable(3, MagicDamage, 20, 40)
                .cd(6);
        JayceCannon.R.update(P309)
                .active("射程が125(Melee)になり、その間は{1}と{2}を得る。また、次の通常攻撃に追加{3}を付与する。{4}。")
                .variable(4, NotSpellCast);

        /** Karma */
        Karma.P.update()
                .passive("{1}を得る。")
                .variable(1, AP, 0, 0, amplify(MissingHealthPercentage, new Per3LevelForKarma(0.3, 0.2)));
        Karma.P.update(P305)
                .passive("敵Championにスキルでダメージを与えた場合Mantraの{1}し、通常攻撃でダメージを与えた場合は{2}する。")
                .variable(1, CDDecrease, new Per6Level(1, 0.5))
                .variable(2, CDDecrease, new Per6Level(0.5, 0.25));
        Karma.P.update(P3051).variable(1, CDDecrease, 2).variable(2, CDDecrease, 1);
        Karma.Q.update()
                .active("指定方向扇形60°の{1}の敵ユニットに{2}を与える。Mantra Bonus:自身と効果範囲内の味方ユニットは{3}する。回復量は対象のHP残量によって変化する。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, RestoreHealth, 35, 20, amplify(MissingHealthRatio, 0.05, 0, ap(0.02)))
                .mana(70, 5)
                .cd(6);
        Karma.Q.update(P305)
                .active("指定方向に炎を飛ばし、命中した敵と{1}の敵ユニットに{2}と1.5秒間{3}を与える。Mantraを付与した場合、追加の{4}を与え、更に炎が命中した地点にフィールドを発生させ、フィールドの上にいる敵ユニットに{5}を与える。フィールドは1.5秒後に爆発し、フィールドの上にいる敵ユニットに{6}を与える。炎が敵ユニットに命中しなかった場合、最大距離まで飛んだ後にフィールドが発生する。")
                .variable(1, Radius, 230)
                .variable(2, MagicDamage, 60, 50, ap(0.6))
                .variable(3, MSSlowRatio, 25)
                .variable(4, MagicDamage, new Refer(Karma.R, 25, 50), ap(0.3), null)
                .variable(5, MSSlowRatio, 50)
                .variable(6, MagicDamage, new Refer(Karma.R, 50, 100), ap(0.6), null)
                .mana(50, 10)
                .cd(7, -0.5)
                .range(950);
        Karma.Q.update(P306).variable(2, MagicDamage, 80, 45, ap(0.6));
        Karma.Q.update(P308).variable(1, Radius, 250).mana(50, 5);
        Karma.W.update()
                .active("対象のユニットと自身を繋ぐビームを発生させる。ビームは5秒間持続し、自身及び味方ユニットは{1}し、敵ユニットには{2}を与える。ビームに触れたChampion(敵味方問わず)にも同様の効果を与え、それが敵ユニットだった場合は更に{3}を与える。ビームを繋ぐ対象がステルス状態または距離1000まで離れた場合、効果が途切れる。Mantra Bonus:MS増加/MS低下の効果が2倍になる。")
                .variable(1, MSRatio, 10, 2)
                .variable(2, MSSlowRatio, 10, 2)
                .variable(3, MagicDamage, 80, 45, ap(0.7))
                .mana(65, 10)
                .cd(15, -1)
                .range(800);
        Karma.W.update(P305)
                .active("対象の敵Championと自身を繋ぐビームを発生させる。0.33秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。Mantraを付与した場合、追加の{3}を与え、{4}するようになる。")
                .variable(1, MagicDamage, 10, 50 / 6, ap(0.1))
                .variable(2, Snare, 1, 0.25)
                .variable(3, MagicDamage, new Refer(Karma.R, 75 / 6, 75 / 6), ap(0.1), null)
                .variable(4, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 25, 0, ap(0.01)))
                .mana(70, 10)
                .cd(16, -0.5);
        Karma.W.update(P3051)
                .active("対象の敵Championと自身を繋ぐビームを発生させる。0.66秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。Mantraを付与した場合、追加の{3}を与え、{4}するようになる。ダメージを与えるたびにGathering Fireの効果が発生する。")
                .variable(1, MagicDamage, 20, 50 / 3, ap(0.2))
                .variable(2, Snare, 1, 0.25)
                .variable(3, MagicDamage, new Refer(Karma.R, 75 / 3, 75 / 3), ap(0.2), null)
                .variable(4, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 25, 0, ap(0.01)))
                .mana(70, 5);
        Karma.W.update(P306).cd(16, -1);
        Karma.W.update(P308)
                .active("対象の敵Championと自身を繋ぐビームを発生させる。0.66秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。Mantraを付与した場合、追加の{3}を与え、{4}するようになる。2秒間ビームが持続していた場合、追加で{4}する。ダメージを与えるたびにGathering Fireの効果が発生する。")
                .variable(4, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 20, 0, ap(0.01)));
        Karma.E.update()
                .active("対象の味方ユニットに5秒間持続する{1}を付与する。Mantra Bonus:味方ユニットにシールドを付与した際、その味方ユニットの{2}にいる敵ユニットに{3}を与える。")
                .variable(1, Shield, 80, 40, ap(0.8))
                .variable(2, Radius, 600)
                .variable(3, MagicDamage, 80, 40, ap(0.8))
                .mana(80, 10)
                .cd(10)
                .range(650);
        Karma.E.update(P305)
                .active("対象の味方は4秒間{1}を得て{6}間{2}する。Mantraを付与した場合、味方ユニットにシールドを付与した際に{3}の味方ユニットは{4}を得て{7}し、敵ユニットには{5}を与える。対象とした味方ユニットは通常のシールドとMantraによるシールド両方の効果を得られる。")
                .variable(1, Shield, 80, 40, ap(0.5))
                .variable(2, MSRatio, 20, 10)
                .variable(3, Radius, 600)
                .variable(4, Shield, new Refer(Karma.R, 30, 40), ap(0.3), null)
                .variable(5, MagicDamage, new Refer(Karma.R, 60, 80), ap(0.6), null)
                .variable(6, Time, 1.25)
                .variable(7, MSRatio, 20, 10)
                .mana(60, 10)
                .cd(12)
                .range(800);
        Karma.E.update(P3051).variable(3, Radius, 700).variable(6, Time, 1.5).variable(7, MSRatio, 60);
        Karma.E.update(P306).variable(2, MSRatio, 40, 5).cd(10);
        Karma.R.update()
                .active("次に使用するスキルにMantra Bonusを付与する。Lv1から使用でき、スキルポイントを割り振ることはできない。{1}毎にスタック数が1つ増加し最大で2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。")
                .variable(1, CDRAwareTime, new Per6Level(30, -5))
                .cd(0.25);
        Karma.R.update(P305).active("8秒以内に使用する次のスキルにMantraを付与する。追加効果はMnatraのスキルレベルを参照する。").cd(45);
        Karma.R.update(P306).cd(45, -3);

        /** Karthus */
        Karthus.P.update().passive("死亡後7秒間スキルが使用可能。この状態ではスキルコストがなくなる。");
        Karthus.Q.update()
                .active("指定地点を0.5秒後に爆発させ{1}の敵ユニットに{2}を与える。対象が1体の場合は{3}を与える。また、指定地点の{4}。")
                .variable(1, Radius, 100)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 80, 40, ap(0.6))
                .variable(4, Visionable)
                .mana(20, 6)
                .cd(1)
                .range(875);
        Karthus.W.update()
                .active("指定地点に{3}の通りぬけ可能な壁を5秒間生成し、触れた敵ユニットに５秒間{1}と{2}を与える。スローの効果は5秒かけて元に戻る。また、指定地点の{4}。")
                .variable(1, MRReductionRatio, 15)
                .variable(2, MSSlowRatio, 40, 10)
                .variable(3, Length, 800, 100)
                .variable(4, Visionable)
                .mana(100)
                .cd(18)
                .range(1000);
        Karthus.E.update()
                .passive("敵ユニットを倒すと{1}する。")
                .variable(1, RestoreMana, 20, 7)
                .active("{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 30, 20, ap(0.25))
                .mana(30, 12)
                .cd(0.5)
                .type(SkillType.Toggle);
        Karthus.E.update(P310).variable(3, MagicDamage, 30, 20, ap(0.2));
        Karthus.R.update()
                .active("3秒詠唱後にすべての敵Championに{1}を与える。")
                .variable(1, MagicDamage, 250, 150, ap(0.6))
                .mana(150, 25)
                .cd(200, -20)
                .range(-1);

        Kassadin();

        /** Katarina */
        Katarina.P.update().passive("敵Championキル/アシスト時に、すべてのスキルの{1}する。").variable(1, CDDecrease, 15);
        Katarina.Q.update()
                .active("対象の敵ユニットにナイフを飛ばし{1}と４秒間Debuffを与える。ナイフは近くの敵ユニット({2})に4回まで跳ね返り、その度にダメージとDebuffを与える。ナイフが与えるダメージは跳ね返る度に10%低下する。Debuffが付与された敵ユニットにKatarinaが通常攻撃またはスキルでダメージを与えると、付与されたDebuffを消費して{3}を与える。")
                .variable(1, MagicDamage, 60, 25, ap(0.15))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 15, 15, ap(0.15))
                .cd(10, -0.5)
                .range(675);
        Katarina.W.update()
                .active("{1}にいる敵ユニットに{2}を与える。このスキルが敵Championに命中した場合、1秒間{3}する。")
                .variable(2, MagicDamage, 40, 35, ap(0.25))
                .variable(1, Radius, 375)
                .variable(3, MSRatio, 15, 5)
                .cd(4);
        Katarina.E.update()
                .active("対象のユニットの後方までワープし、それが敵ユニットの場合は{1}を与える。またこのスキル使用後、Katarinaが受ける{2}する。この効果は1.5秒間持続する。")
                .variable(1, MagicDamage, 60, 25, ap(0.5))
                .variable(2, DamageReductionRatio, 15)
                .cd(12, -1.5)
                .range(700);
        Katarina.R.update()
                .active("最大2秒間回転する。その間は0.2秒毎に{2}にいる最も近い敵Champion3体にナイフを連続で飛ばし、都度{1}と3秒間HP回復量-50%を与える。敵一体に与える最大DMは{3}。")
                .variable(1, MagicDamage, 40, 10, ap(0.2), bounusAD(0.3))
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 400, 100, ap(2), bounusAD(3))
                .cd(60, -5)
                .type(SkillType.Channel);
        Katarina.R.update(P312)
                .active("最大2.5秒間回転する。その間は0.25秒毎に{2}にいる最も近い敵Champion3体にナイフを連続で飛ばし、都度{1}と3秒間HP回復量-50%を与える。敵一体に与える最大DMは{3}。")
                .variable(1, MagicDamage, 40, 17.5, ap(0.25), bounusAD(0.375))
                .variable(3, MagicDamage, 400, 175, ap(2.5), bounusAD(3.75))
                .cd(60, -7.5);

        Kayle();

        /** Kennen */
        Kennen.P.update()
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは8秒間増加がないと0になる。同一の敵Championを7秒以内に2度スタンさせると、{3}を与える。")
                .variable(1, Stun, 1)
                .variable(2, RestoreEnergy, 25)
                .variable(3, Stun, 0.5);
        Kennen.P.update(P309)
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは6秒間増加がないと0になる。同一の敵Championを7秒以内に2度スタンさせると、{3}を与える。");
        Kennen.Q.update()
                .active("指定方向に手裏剣を飛ばし、当たった敵ユニットに{1}と雷スタックを与える。")
                .variable(1, MagicDamage, 75, 40, ap(0.75))
                .cd(8, -1)
                .range(900)
                .cost(Energy, 65, -5);
        Kennen.W.update()
                .passive("5回毎の通常攻撃時に追加{1}と雷スタックを与える効果を追加する。")
                .variable(1, MagicDamage, 0, 0, ad(0.4))
                .active("{3}の雷スタックの付与されている敵ユニットに{2}と雷スタックを与える。")
                .variable(3, Radius, 800)
                .variable(2, MagicDamage, 65, 30, ap(0.55))
                .cd(14, -2)
                .cost(Energy, 45, 0);
        Kennen.E.update()
                .active("2.5秒間{1}し、{6}を得る。この間は通常攻撃が不可能になり、Kennenに触れた敵ユニットに{2}と雷スタックを与え、一度だけ{3}する。また、このスキルを使用すると4秒間{4}と{5}を得る。Minionに与えるダメージは半分。")
                .variable(1, MS, 230)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .variable(3, RestoreEnergy, 40)
                .variable(4, AR, 10, 10)
                .variable(5, MR, 10, 10)
                .variable(6, IgnoreUnitCollision)
                .cd(10, -1)
                .cost(Energy, 100, -5);
        Kennen.R.update()
                .active("{1}に嵐を発生させ、{4}間{2}毎に範囲内にいる敵Champion一人をランダムに雷を落とし{3}と雷スタックを与える。同一の対象には3回までヒットし、最大DMは{5}。また、範囲内に複数の対象がいる場合、同一の対象に連続してはヒットしない。雷スタックはヒットする毎に蓄積する。")
                .variable(1, Radius, 550)
                .variable(2, Time, new Fixed(new double[] {0.5, 0.4, 0.33}))
                .variable(3, MagicDamage, 80, 65, ap(0.4))
                .variable(4, Time, 3, 1)
                .variable(5, MagicDamage, 240, 195, ap(1.2))
                .cd(120);

        KhaZix();

        /** Kog'Maw */
        KogMaw.P.update()
                .passive("死亡すると4秒後に自爆して周囲の敵ユニットに{1}を与える。自爆するまでの間は徐々に移動速度が増加する(最大時40%増加)。")
                .variable(1, TrueDamage, 100, 0, amplify(Lv, 25));
        KogMaw.Q.update()
                .passive("{1}する。")
                .variable(1, ASRatio, 10, 5)
                .active("対象の敵ユニットに{2}を与え、4秒間{3}と{4}を与える。")
                .variable(2, MagicDamage, 60, 50, ap(0.7))
                .variable(3, ARReduction, 5, 5)
                .variable(4, MRReduction, 5, 5)
                .mana(60)
                .cd(8)
                .range(625);
        KogMaw.W.update()
                .active("8秒間通常攻撃の{1}し、通常攻撃時に{2}を追加で与える。")
                .variable(1, Range, 130, 20)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2, 1, ap(0.01)))
                .mana(50)
                .cd(17)
                .range(130, 20);
        KogMaw.E.update()
                .active("指定方向に貫通する弾を発射し、当たった敵ユニットに{1}を与える。弾の通過点に4秒間持続する液体が残り、その上にいる敵ユニットに{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, MSSlowRatio, 20, 8)
                .mana(80, 10)
                .cd(12)
                .range(1400);
        KogMaw.R.update()
                .active("指定地点を砲撃し、{1}の敵ユニットに{2}を敵Championには{3}を与え、4秒間そのユニットの視界を得る。このスキルを使うたびにスタックが増加し、1スタックにつきこのスキルの消費マナが40ずつ増加していく。スタックは6秒間持続する。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 80, 40, ap(0.3), bounusAD(0.5))
                .variable(3, MagicDamage, 180, 90, ap(0.3), bounusAD(0.5))
                .cost(Mana, new Diff(40, 0, 1), amplify(Stack, 40))
                .cd(2, -0.5)
                .range(1400, 300);

        /** LeBlanc */
        Leblanc.P.update()
                .passive("HPが40%以下になったとき0.5秒間ステルス状態になり、自分の分身を作り出す。分身は8秒間持続し、分身が敵にダメージを与えることはできない。{1}。")
                .variable(1, CDRUnaware)
                .cd(-60);
        Leblanc.Q.update()
                .active("対象の敵ユニットに{1}と3.5秒間持続するマークを付与する。マークが付いている間に再度スキルでダメージを与えると、マークを消費して追加{2}と{3}を付与する。")
                .variable(1, MagicDamage, 70, 40, ap(0.6))
                .variable(2, MagicDamage, 20, 20, ap(0.2))
                .variable(3, Silence, 2)
                .mana(70, 5)
                .cd(6)
                .range(700)
                .update(P309)
                .variable(1, MagicDamage, 55, 25, ap(0.4))
                .variable(2, MagicDamage, 55, 25, ap(0.4))
                .variable(3, Silence, 1.5)
                .mana(50, 10);
        Leblanc.W.update()
                .active("指定地点まで高速で移動し、移動先の{1}にいる敵ユニットに{2}を与える。3秒間以内にもう一度このスキルを使用すると元居た地点に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .mana(80)
                .cd(18, -2)
                .range(600);
        Leblanc.W.update(P309).mana(80, 10);
        Leblanc.E.update()
                .active("指定方向に鎖を放ち、当たった敵ユニットに{1}と{5}間{2}を与え対象と鎖で繋がれる。{5}間対象が鎖の範囲内(範囲1000)に留まっていた場合、対象に追加{3}と{4}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.5))
                .variable(2, MSSlowRatio, 25)
                .variable(3, MagicDamage, 40, 25, ap(0.5))
                .variable(4, Snare, 1, 0.3)
                .variable(5, Time, 2)
                .mana(80)
                .cd(10)
                .range(950);
        Leblanc.E.update(P309).variable(5, Time, 1.5).variable(4, Snare, 1.5).cd(14, -1);
        Leblanc.R.update()
                .active("直前に使ったスキルを、威力を{1}増した状態で再使用する。Distortionとして使用した場合、それぞれDistortionとDistortion:Mimicを使用した地点に戻る事ができる。")
                .variable(1, Percentage, 10, 15)
                .mana(100, -50)
                .cd(40, -8);
        Leblanc.R.update(P309)
                .active("直前に使ったスキルをコピーする。(ダメージ値が下記のように変化する)<br>Sigil of Silence: {1}<br>Distortion: {2}<br>Ethereal Chains: {3}")
                .variable(1, MagicDamage, 100, 100, ap(0.65))
                .variable(2, MagicDamage, 150, 150, ap(0.975))
                .variable(3, MagicDamage, 100, 100, ap(0.65))
                .mana(0);

        LeeSin();
        Leona();

        /** Lissandra */
        Lissandra.P.update().passive("18秒毎に次に使うスキルのコストが0になる。Glacial Path以外のスキルを敵ユニットに命中させるたびに、このスキルのCDが1秒解消される。");
        Lissandra.Q.update()
                .active("指定方向に貫通する氷の槍を飛ばし、当たった敵ユニットに{1}を与える。このスキルが最初に命中した敵ユニットには更に1.5秒間{2}を与える。")
                .variable(1, MagicDamage, 75, 35, ap(0.65))
                .variable(2, MSSlowRatio, 16, 3)
                .mana(85)
                .cd(6, -0.5)
                .range(725);
        Lissandra.W.update()
                .active("{1}にいるすべての敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, Snare, 1.1, 0.1)
                .mana(70)
                .cd(18, -2);
        Lissandra.W.update(P308).cd(14, -1).mana(50);
        Lissandra.E.update()
                .active("指定方向に貫通する氷の爪を飛ばし、当たった敵ユニットに{1}を与える。氷の爪が出ている間にこのスキルを再度使用すると、氷の爪の位置までワープし氷の爪が消滅する。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .mana(80, 5)
                .cd(24, -3)
                .range(1050);
        Lissandra.R.update()
                .active("対象の敵Championに{1}と{2}を与え、同時に対象の敵Championの周囲に3秒間持続するDark Iceを呼び出し、Dark Iceに触れた敵ユニットに{1}と{3}を与える。このスキルは自身を対象とする事が可能で、自身を対象とした場合は{4}間行動出来なくなる代わりに、ダメージを無効化かつターゲット不可状態になり、自身の周囲からDark Iceが出現する。")
                .variable(1, MagicDamage, 150, 150, ap(0.7))
                .variable(2, Stun, 1.5)
                .variable(3, MSSlowRatio, 20)
                .variable(4, Time, 1.5)
                .mana(100)
                .cd(130, -25);
        Lissandra.R.update(P308)
                .variable(1, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MSSlowRatio, 20, 10)
                .variable(4, Time, 2.5);

        Lucian();
        Lulu();

        /** Lux */
        Lux.P.update()
                .passive("スキルでダメージを与えた敵ユニットに6秒間持続するDebuffを付与する。この敵ユニットに対して通常攻撃かFinal Sparkでダメージを与えると、付与されたDebuffを消費して追加{1}を与える。")
                .variable(1, MagicDamage, 10, 0, amplify(Lv, 10));
        Lux.Q.update()
                .active("指定方向に光の玉を飛ばし、当たった敵ユニットに{1}と{2}を与える。光の玉は一度だけ敵ユニットを貫通し、2体目のユニットには{3}と{4}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, Snare, 2)
                .variable(3, MagicDamage, 50, 25, ap(0.35))
                .variable(4, Snare, 1)
                .mana(50, 10)
                .cd(15, -1)
                .range(1175);
        Lux.W.update()
                .active("指定方向に杖を投げ、自身と当たった味方Championに{1}を付与する。行きと帰りそれぞれに判定があり、シールドは3秒間持続する。")
                .variable(1, Shield, 80, 25, ap(0.35))
                .mana(60)
                .cd(14, -1)
                .range(1000);
        Lux.E.update()
                .active("指定地点に光の玉を設置し、{1}の敵ユニットに{2}を与える。光の玉は5秒経つか再度スキルを使用する事で爆発し、{1}の敵ユニットに{3}を与える。光の玉は{4}。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 20, 4)
                .variable(3, MagicDamage, 60, 45, ap(0.6))
                .variable(4, Visionable)
                .mana(70, 15)
                .cd(10)
                .range(1100);
        Lux.R.update()
                .active("1秒詠唱後、指定方向の直線状にいるすべての敵ユニットに{1}を与える。また効果範囲内の視界を確保する。Hitした敵がIlluminationのデバフを受けていた場合はその分の追加ダメージを与えたうえ、新たにIlluminationのデバフを与える。")
                .variable(1, MagicDamage, 300, 100, ap(0.75))
                .mana(100)
                .cd(80, -20)
                .range(3000);
        Lux.R.update(P3051).cd(80, -15);

        /** Malphite */
        Malphite.P.update().passive("10秒間ダメージを受けないと{1}を得る。").variable(1, Shield, 0, 0, amplify(Health, 0.1));
        Malphite.Q.update()
                .active("対象の敵ユニットに{1}と4秒間{2}を与える。また、このスキルで減少させた移動速度を自身の移動速度に加算する。移動速度増加は4秒間持続する。")
                .variable(1, MagicDamage, 70, 50, ap(0.6))
                .variable(2, MSSlowRatio, 14, 3)
                .mana(70, 5)
                .cd(8)
                .range(625);
        Malphite.W.update()
                .passive("通常攻撃時に対象の{1}にいる敵ユニットに{2}を与える。建物を攻撃する際にはスプラッシュ効果は発生しない。")
                .variable(1, Radius, 200)
                .variable(2, PhysicalDamage, 0, 0, amplify(AD, 0.3, 0.08))
                .active("6秒間{3}、{4}する。")
                .variable(3, ADRatio, 20, 5)
                .variable(4, ARRatio, 20, 5)
                .mana(50, 5)
                .cd(14);
        Malphite.E.update()
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 60, 40, ap(0.2), amplify(AR, 0.3))
                .variable(3, ASSlowRatio, 30, 5)
                .mana(50, 5)
                .cd(7);
        Malphite.R.update()
                .active("指定地点に突撃し{1}の敵ユニットに{2}を与えると共に{3}後、{4}を与える。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 200, 100, ap(1))
                .variable(3, Knockup, 1)
                .variable(4, Stun, 0.5)
                .mana(100)
                .cd(130, -15)
                .range(1000);

        /** Malzahar */
        Malzahar.P.update()
                .passive("スキルを4回使う度にVoidlingを召喚する。Voidlingは21秒間持続し、7秒後にADとARが1.5倍、14秒後にASが2倍に増加する。任意の操作不可。攻撃対象は、Ultを掛けた相手、" + Malzahar.E + "を掛けた相手、Malzaharがターゲットしている相手の順。<br>Health: {1}<br>AD: {2}<br>AR: 30<br>MR: 50<br>AS: 0.831<br>MS: 451")
                .variable(1, Value, 200, 0, amplify(Lv, 40))
                .variable(2, Value, 20, 0, amplify(Lv, 5), bounusAD(1));
        Malzahar.Q.update()
                .active("指定した地点の左右から挟み込む様に2本の波動が出現し、当たった敵ユニットに{1}と{2}を与える。また、指定した場所の視界を得る。")
                .variable(1, MagicDamage, 80, 55, ap(0.8))
                .variable(2, Silence, 1.4, 0.4)
                .mana(80, 10)
                .cd(9)
                .range(900);
        Malzahar.Q.update(P306).mana(80, 5);
        Malzahar.W.update()
                .active("指定地点に5秒間持続する{1}のダメージゾーンを発生させ、上にいる敵ユニットに毎秒{2}を与える。(Minionに対しては毎秒120DMが上限)")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 4, 1, ap(0.01)))
                .mana(90, 10)
                .cd(14)
                .range(800);
        Malzahar.W.update(P306).mana(90, 5);
        Malzahar.E.update()
                .active("対象の敵ユニットに4秒かけて{1}を与える。効果中に敵ユニットが死亡した場合、{2}し、近くの敵ユニットに効果が移り変わる。移る度に4秒のタイマーはリセットされる。")
                .variable(1, MagicDamage, 80, 60, ap(0.8))
                .variable(2, RestoreMana, 10, 4)
                .mana(60, 15)
                .cd(15, -2)
                .range(650);
        Malzahar.R.update()
                .active("対象の敵Championに2.5秒かけて{1}と{2}を与える。ダメージは0.5秒毎に計5回の判定がある。")
                .variable(1, MagicDamage, 250, 150, ap(1.3))
                .variable(2, Suppression, 2.5)
                .mana(150)
                .cd(120, -20)
                .range(700)
                .type(SkillType.Channel);

        /** Maokai */
        Maokai.P.update()
                .passive("近くのChampion(敵味方自分問わず)がスキルを使用するとスタックが増え、5スタックまで溜まった状態で通常攻撃を行うと{1}する。このスキル発動時にスタックは0になる。建物を攻撃した場合は発動しない。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.07));
        Maokai.Q.update()
                .active("{1}の敵ユニットと指定方向の敵ユニットに{2}と2秒間{3}を与える。{4}の敵ユニットには更に{5}を与える。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, MSSlowRatio, 20, 7)
                .variable(4, Radius, 200)
                .variable(5, Knockback, 0)
                .mana(55)
                .cd(6)
                .range(700);
        Maokai.W.update()
                .active("対象の敵ユニットまで高速移動し{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 35, ap(0.8))
                .variable(2, Snare, 1, 0.25)
                .mana(75, 5)
                .cd(13)
                .range(650);
        Maokai.E.update()
                .active("指定地点に苗木を投げ、{1}の敵ユニットに{2}を与える。苗木は最大35秒間その場で待機し、敵ユニットが近付く({4})と相手に向かって移動を開始する、敵に接触するか数秒経つと爆発して{1}に{3}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 35, ap(0.4))
                .variable(3, MagicDamage, 80, 50, ap(0.6))
                .variable(4, Radius, 500)
                .mana(70, 10)
                .cd(12)
                .range(1100);
        Maokai.R.update()
                .passive("指定地点の{1}にシールドを展開し、範囲内の味方Championが受けるダメージを20%低減させる(タワーからの攻撃以外)。解除すると範囲内の敵ユニットに{2}を与える。低減したダメージ量に比例して与えるダメージが増加する。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 100, 50, ap(0.5))
                .mana(75)
                .cd(40, -10)
                .range(575);

        MasterYi();

        /** Miss Fortune */
        MissFortune.P.update()
                .passive("5秒間ダメージを受けないと{1}する。以後、毎秒移動速度が9ずつ上昇し、5秒後に移動速度上昇値は上限の70に到達する。ダメージを受けると解除される。")
                .variable(-1, MS, 25);
        MissFortune.Q.update()
                .active("対象の敵ユニットに弾丸を飛ばし{1}を与える。弾は一度だけ跳ね返り、背後にいる敵ユニット一体(範囲500)を対象とし{2}を与える。{3}。")
                .variable(1, PhysicalDamage, 25, 35, ad(0.75))
                .variable(2, PhysicalDamage, 30, 42, ad(0.9))
                .variable(3, OnHitEffect)
                .mana(70, 5)
                .cd(9, -1)
                .range(625);
        MissFortune.W.update()
                .passive("通常攻撃に{1}を与え、対象にスタックを付与する。1スタックにつき追加魔法DMが倍増していく。最大{4}(最大4倍ダメージ)で5秒間持続する。")
                .variable(1, MagicDamage, 6, 2, ap(0.05))
                .active("6秒間{2}し、通常攻撃に{3}を付加する。")
                .variable(2, ASRatio, 30, 5)
                .variable(3, Wounds, 3)
                .variable(4, Stack, 4)
                .mana(50)
                .cd(16);
        MissFortune.W.update(P307).variable(1, MagicDamage, 4, 2, ap(0.05)).variable(4, Stack, 5);
        MissFortune.E.update()
                .active("地点を指定した0.5秒後に2秒間銃弾の雨を降らし、{1}の敵ユニットに{2}と1秒間{3}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 90, 55, ap(0.8))
                .variable(3, MSSlowRatio, 20, 8)
                .mana(80)
                .cd(15)
                .range(800);
        MissFortune.R.update()
                .active("指定方向扇形の範囲に2秒間、弾幕砲火を浴びせて範囲内の敵ユニットに{1}を与える。弾は0.25秒毎に一発発射され、同一の対象に8回までヒットする。最大で{2}。")
                .variable(1, PhysicalDamage, 65, 30, ap(0.2), bounusAD(0.35))
                .variable(2, PhysicalDamage, 520, 240, ap(1.6), bounusAD(2.8))
                .mana(100)
                .cd(120, -10)
                .range(1400)
                .type(SkillType.Channel);

        /** Mordekaiser */
        Mordekaiser.P.update()
                .passive("スキルで与えたダメージの17.5%(Championに対しては35%)をシールドに変換して(最大で{1})受けたダメージはHPより先にシールドがくらってくれる。1秒毎に3%ずつ低下していく。")
                .variable(1, Shield, 90, 0, amplify(Lv, 30));
        Mordekaiser.Q.update()
                .active("次に行う通常攻撃が{1}になり、更に近くの敵ユニット3体({2})にもダメージを与える。対象が1体だけの場合は{3}与える。")
                .variable(1, MagicDamage, 80, 30, ap(0.4), bounusAD(1))
                .variable(2, Radius, 600)
                .variable(3, MagicDamage, 132, 49.5, ap(0.66), bounusAD(1.65))
                .cd(8, -1)
                .cost(Health, 20, 5);
        Mordekaiser.W.update()
                .active("対象の味方ユニットに6秒間持続するシールドを付与する。付与されたユニットは{1}と{2}を得て、{3}の敵ユニットに毎秒{4}を与える。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 24, 12, ap(0.2))
                .cd(20, -2)
                .range(750)
                .cost(Health, 26, 6);
        Mordekaiser.E.update()
                .active("指定方向扇形の範囲内の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .cd(6)
                .range(700)
                .cost(Health, 24, 12);
        Mordekaiser.R.update()
                .active("対象の敵Championに{1}を与え、その後10秒間、毎秒{2}を与える。10秒間で総計{4}を与え、{3}する。効果中に対象が死ぬとThe Spiritを生成し30秒間従わせる。(RまたはALT押しながらクリックで任意の操作可能)　The Spirit AD: 元になったChampのAD + MordekaiserのADの75%AP: 元になったChampのAP + MordekaiserのAPの75%HP: 元になったChampのHP + MordekaiserのHPの15%行動範囲: 1125 また、The Spiritを従えている間、Mordekaiserは元になったChampのADとAPの20％を得る。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 12, 2.5, ap(0.02)))
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 1.2, 0.25, ap(0.002)))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 100))
                .variable(4, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 24, 5, ap(0.04)))
                .cd(120, -15)
                .range(850);

        Morgana();
        Nami();
        Nasus();
        Nautilus();
        Nidalee();

        /** Nocturne */
        Nocturne.P.update()
                .passive("10秒に1度、通常攻撃のダメージが120%に増加し、{1}の敵ユニットにダメージを与える範囲攻撃になる。この効果がヒットした敵の数に応じて{2}する。また、通常攻撃を行うごとに、このスキルの{3}する。建物を攻撃する時はこの効果は発生しない。")
                .variable(1, Radius, 200)
                .variable(2, RestoreHealth, new Per6Level(10, 8))
                .variable(3, CDDecrease, 1)
                .cd(10);
        Nocturne.Q.update()
                .active("指定方向に影の刃を投げて当たった敵ユニットに{1}を与える。刃の軌跡には5秒間持続するDusk Trailが残り、刃がヒットした敵Championの動いた軌道上にもDusk Trailが残るようになる。Dusk Trailの上ではNocturneは{2}と{3}を得て、{4}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.75))
                .variable(2, AD, 15, 10)
                .variable(3, IgnoreUnitCollision)
                .variable(4, ASRatio, 15, 5)
                .mana(60, 5)
                .cd(10)
                .range(1200);
        Nocturne.W.update()
                .passive("{1}する。")
                .variable(1, ASRatio, 20, 5)
                .active("Nocturneに1.5秒間持続する{2}を付与し、その間一度だけ敵のスキルを無効化する。無効化した場合、5秒間Passiveの増加攻撃速度が2倍になる。")
                .variable(2, Status.SpellShield)
                .mana(50)
                .cd(20, -2);
        Nocturne.E.update()
                .active("対象の敵ユニットに2秒間0.5秒毎に{1}、合計で{3}を与え、2秒間対象が一定範囲内(範囲465)に留まり続けていれば、更に{2}を与える。")
                .variable(1, MagicDamage, 12.5, 12.5, ap(0.25))
                .variable(2, Fear, 1, 0.25)
                .variable(3, MagicDamage, 50, 50, ap(1))
                .mana(60, 5)
                .cd(15, -1)
                .range(425);
        Nocturne.R.update()
                .active("4秒間すべての敵Championに{1}を与え、また自分以外の視界を得られなくする。効果中に範囲内にいる敵Championを指定すると対象の位置まで移動し、到着時に対象に{2}を与える。")
                .variable(1, Foggy, 300)
                .variable(2, PhysicalDamage, 150, 100, bounusAD(1.2))
                .mana(100)
                .cd(180, -40)
                .range(2000, 750);

        Nunu();
        Olaf();

        /** Orianna */
        Orianna.P.update()
                .passive("通常攻撃に追加{1}が付与される。4秒以内に同一の対象を連続して攻撃すると、追加魔法DMが20%上昇していく(最大+40%)。建物には無効。")
                .variable(1, MagicDamage, new Per3Level(10, 8), ap(0.15), null);
        Orianna.Q.update()
                .active("指定した地点にBallを移動させ、移動中のBallに触れた敵ユニットと指定{1}にいる敵ユニットに{2}を与える。ダメージは敵に当たるごとに10%づつ減少する(最大60%減少)。BallはOriannaから一定距離離れなければその場に待機して{3}。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 60, 30, ap(0.5))
                .variable(3, Visionable)
                .mana(50)
                .cd(6, -0.75)
                .range(825);
        Orianna.W.update()
                .active("Ballの存在する地点にフィールドを展開しBallの{1}にいる敵ユニットに{2}を与える。フィールドは3秒間持続し、フィールドの上の味方ユニットは{3}し、敵ユニットには{4}を与える。フィールドから出た場合、この効果は2秒かけて元に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 45, ap(0.7))
                .variable(3, MSRatio, 20, 5)
                .variable(4, MSSlowRatio, 20, 5)
                .mana(70, 10)
                .cd(9);
        Orianna.E.update()
                .passive("Ballが付いている味方Championは{1}と{2}を得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("対象の味方ChampionまでBallを移動させ、4秒間持続する{3}を付与する。また、移動中のBallに触れた敵ユニットに{4}を与える。Ballは対象がOriannaから一定距離離れなければ貼り付き続ける。")
                .variable(3, Shield, 80, 40, ap(0.4))
                .variable(4, MagicDamage, 60, 30, ap(0.3))
                .mana(60)
                .cd(9)
                .range(1120);
        Orianna.R.update()
                .active("約0.5秒詠唱後にBallから衝撃波を発生させ、Ballの{1}にいる敵ユニットに{2}を与えると共に、Ballの方向に{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 75, ap(0.7))
                .variable(3, Knockback, 350)
                .mana(100, 25)
                .cd(120, -15);

        Pantheon();

        /** Poppy */
        Poppy.P.update().passive("現在HPの10%を超えるダメージを受けた際、その超過分のダメージを50%低減する。塔の攻撃には無効。");
        Poppy.Q.update()
                .active("次に行う通常攻撃が魔法DMになり、追加{1}が付与される。")
                .variable(1, MagicDamage, 20, 20, ap(0.6), amplify(TargetMaxHealthRatio, 8))
                .mana(55)
                .cd(8, -1);
        Poppy.W.update()
                .passive("通常攻撃を行うか、ダメージを受ける度にスタックが1増加する(最大10)。スタック数に比例して{1}と{2}を得る。スタックは5秒間増加がないと0になる。")
                .variable(-1, AD, 1.5, 0, amplify(Stack, 0.5))
                .variable(-2, AR, 1.5, 0, amplify(Stack, 0.5))
                .active("スタックを最大(10)まで増加させ、5秒間{3}する。")
                .variable(3, MSRatio, 17, 2)
                .mana(70, 5)
                .cd(12);
        Poppy.E.update()
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。ノックバック時に壁にぶつかった場合、追加{3}と{4}を与える。")
                .variable(1, Knockback)
                .variable(2, MagicDamage, 50, 25, ap(0.4))
                .variable(3, MagicDamage, 75, 50, ap(0.4))
                .variable(4, Stun, 1.5)
                .mana(60, 5)
                .cd(12, -1)
                .range(525);
        Poppy.R.update()
                .active("対象の敵Championを{2}秒間ターゲットし、その対象に与える{1}する。効果中は対象以外からのすべての攻撃を無効化する(対象のPetからはダメージを受ける)。")
                .variable(1, DamageRatio, 20, 10)
                .variable(2, Time, 6, 1)
                .mana(100)
                .cd(140, -20)
                .range(900);

        /** Quinn */
        Quinn.P.update()
                .passive("ValorがQuinnの周辺に存在する敵ユニット一体(Champion優先)に自動的に4.5秒間持続するマークを付与する。マークが付与された敵ユニットにQuinnが通常攻撃を行うと、付与されたマークを消費して{1}を与える。またマークが付与された敵ユニットの{2}。Valorと交代している間はこのスキルは無効になる。")
                .variable(1, PhysicalDamage, new Per1Level(new double[] {25, 35, 45, 55, 65, 75, 85, 95, 105, 115, 125,
                        135, 145, 155, 170, 185, 190, 215}), bounusAD(0.5), null)
                .variable(2, Visionable)
                .cd(10);
        Quinn.Q.update()
                .active("指定方向にValorを突撃させ、最初に当たった敵ユニットと{1}の敵ユニットに{2}と{3}を与える。Tag Team時は自身の{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 200)
                .variable(2, PhysicalDamage, 70, 40, bounusAD(0.65))
                .variable(3, Blind, 1.5)
                .mana(60, 5)
                .cd(11, -1)
                .range(1025);
        Quinn.Q.update(P306).variable(2, PhysicalDamage, 70, 40, bounusAD(0.65), ap(0.5));
        Quinn.W.update()
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}する。Tag Team時は{2}する。")
                .variable(1, ASRatio, 20, 5)
                .variable(-2, ASRatio, 40, 10)
                .active("2秒間{3}の視界を得る。")
                .variable(3, Radius, 2100)
                .cd(50, -5);
        Quinn.W.update(P306)
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}、{3}する。Tag Team時は{2}する。")
                .variable(3, MS, 20, 10);
        Quinn.E.update()
                .active("対象の敵ユニットまでダッシュし{1}と2秒間{2}を与える。スローの効果は2秒かけて元に戻る。ダッシュ後、Quinnは自身の通常攻撃の最大射程(距離525)までジャンプして対象と距離を離す。また、同時に対象にはHarrierのマークが付与される。Tag Team時はダッシュ後に距離を離さなくなる。")
                .variable(1, PhysicalDamage, 40, 30, bounusAD(0.2))
                .variable(2, MSSlowRatio, 50)
                .range(750)
                .mana(50)
                .cd(12, -1);
        Quinn.R.update()
                .active("20秒間ValorがQuinnと入れ替わり戦闘に参加する。Valorは射程125のMeleeであり、専用のスキルが与えられるがスキルのCDはQuinnと共有する。Valorは{1}を得て{2}する。戦闘状態に入ると{3}する。このスキルを再度使用するか、20秒経過するとValorがQuinnと入れ替わり、{4}に敵ユニットに{5}を与える。対象が受けているダメージに比例して与えるダメージが増加し、最大で{6}を与える。")
                .variable(1, IgnoreUnitCollision)
                .variable(-2, MSRatio, 80)
                .variable(3, MSRatio, 20)
                .variable(4, Radius, 700)
                .variable(5, PhysicalDamage, 100, 50, bounusAD(0.5))
                .variable(6, PhysicalDamage, 200, 100, bounusAD(1))
                .cd(140, -20)
                .mana(100);
        Quinn.R.update(P306).variable(-2, MSRatio, 80, 10).variable(3, MSRatio, 20, 10).cd(140, -30);

        Rammus();

        /** Renekton */
        Renekton.P.update()
                .passive("通常攻撃ごとにFuryが5増加する。12秒間戦闘を行わないとFuryは毎秒2.5減少する。Furyの最大値は100、Furyが50以上ある場合にスキルを使用すると、Furyを50消費してスキルが強化される。また、RenektonのHPが50%以下になるとFuryの増加量が50%増加する。建物を攻撃した場合はFuryは増加しない。");
        Renekton.Q.update()
                .active("武器を振り回し{1}の敵ユニットに{2}を与え、{3}する(上限あり)。対象がChampionの場合、{4}する。当たったユニット1体につきFuryが5増加する(最大25)。Fury消費すると与えるダメージが50%増加し、HP回復量が2倍、回復上限が3倍に増加する。但し、Fury増加効果は無くなる。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, 60, 30, bounusAD(0.8))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 5))
                .variable(4, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 20))
                .cd(8);
        Renekton.W.update()
                .active("次に行う通常攻撃が2回攻撃になり、{1}が付与される。Fury消費すると攻撃回数が3回に増加し、{2}を付与する。但し、Fury増加効果は無くなる。{3}。")
                .variable(1, Stun, 0.75)
                .variable(2, Stun, 1.5)
                .variable(3, OnHitEffect)
                .cd(13, -1);
        Renekton.E.update()
                .active("指定方向にダッシュし触れた敵ユニットに{1}を与える(Slice)。このスキルが敵にヒットした場合、4秒間の間だけ再度使用できる(Dice)。Fury消費時:Diceで与えるダメージが50%増加し、4秒間{2}を与える。SliceではFuryを消費しない。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.9))
                .variable(2, ARReductionRatio, 15, 5)
                .cd(18, -1)
                .range(450);
        Renekton.R.update()
                .active("15秒間サイズが大きくなり、スキルの射程が増加する。更に{1}を得て{2}の敵ユニットに毎秒{3}を与える。また、毎秒5Furyを得る。")
                .variable(1, Health, 300, 150)
                .variable(2, Radius, 350)
                .variable(3, MagicDamage, 40, 30, ap(0.1))
                .cd(120);

        Rengar();
        Riven();

        /** Rumble */
        Rumble.P.update()
                .passive("Ult以外のスキルを使うとHeatが20増加し、それが50以上になると「Danger Zone」状態に入り全てのスキルに追加効果がつくようになる。Heatが100になると6秒間スキルが使用不可能になり、通常攻撃に追加{1}が付与される。Heatは時間によって減少していく。追加魔法DMは建物には無効。")
                .variable(1, MagicDamage, 20, 0, ap(0.3), amplify(Lv, 5));
        Rumble.Q.update()
                .active("3秒間前方の範囲を火炎放射器で焼き払い、範囲内の敵ユニットに毎秒{1}を与える。minionに与えるダメージは半分。Danger Zone中は{2}を与える。")
                .variable(1, MagicDamage, 30, 23.3, ap(0.45))
                .variable(2, MagicDamage, 37.5, 29.1, ap(0.56))
                .cd(6)
                .range(600);
        Rumble.Q.update(P307).variable(1, MagicDamage, 25, 20, ap(0.33)).variable(2, MagicDamage, 37.5, 30, ap(0.5));
        Rumble.W.update()
                .active("2秒間{1}を得て1秒間{2}する。Danger Zone中は{3}を得て1秒間{4}する。")
                .variable(1, Shield, 50, 30, ap(0.4))
                .variable(2, MSRatio, 10, 5)
                .variable(3, Shield, 62.5, 37.5, ap(0.5))
                .variable(4, MSRatio, 12.5, 6.25)
                .cd(6);
        Rumble.E.update()
                .active("指定方向に銛を放ち当たった敵ユニットに{1}と3秒間{2}を与える。このスキルは3秒の間、2回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2発目はHeatが増加しない。また、このスキルによるスローはスタックする。Danger Zone中では{3}と3秒間{4}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, MagicDamage, 68.75, 37.5, ap(0.625))
                .variable(4, MSSlowRatio, 18.75, 6.25)
                .cd(10)
                .range(850);
        Rumble.E.update(P307).variable(1, MagicDamage, 45, 25, ap(0.4));
        Rumble.R.update()
                .active("指定した位置から指定方向({4})にロケットを打ち出し、当たった敵ユニットに{1}と{2}を与える。また5秒間ロケットの着弾した地面に炎が残り、その上にいる敵ユニットに毎秒{3}と{2}を与える。")
                .variable(1, MagicDamage, 150, 75, ap(0.5))
                .variable(2, MSSlowRatio, 35)
                .variable(3, MagicDamage, 100, 40, ap(0.2))
                .variable(4, Distance, 1000)
                .cd(105, -15)
                .range(1750);
        Rumble.R.update(P305)
                .active("指定した位置から指定方向({4})にロケットを打ち出し、当たった地面を5秒間炎上させる。炎上した地面の上にいる敵ユニットに毎秒{3}と{2}を与える。")
                .variable(3, MagicDamage, 130, 55, ap(0.5))
                .variable(2, MSSlowRatio, 15, 5);

        /** Sejuani */
        Sejuani.P.update().passive("通常攻撃にFrostを付与する。Frost状態の敵ユニットは3秒間{1}になる。").variable(1, MSSlowRatio, 30);
        Sejuani.P.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、2秒間{1}と{2}を得る。この効果時間は最大8秒までスタックする。")
                .variable(1, AR, new Per5LevelForSejuani(10, 5))
                .variable(2, MSSlowReductionRatio, new Per5LevelForSejuani(10, 5));
        Sejuani.Q.update()
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}とFrostを与え、対象がMinionの場合は更に{2}させる。敵Championに当たるか最大距離だけ移動すると突進は止まる。")
                .variable(1, MagicDamage, 60, 30, ap(0.4))
                .variable(2, Knockback)
                .mana(70, 5)
                .cd(19, -2)
                .range(700);
        Sejuani.Q.update(P306)
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}と{2}を与える（モンスターには最大300ダメージ）。敵Championに当たると突進は止まる。")
                .variable(1, Knockup)
                .variable(2, MagicDamage, 40, 30, ap(0.4), amplify(TargetMaxHealthRatio, 4, 2))
                .mana(80, 5)
                .cd(15, -1)
                .range(650);
        Sejuani.W.update()
                .active("6秒間極寒の嵐を周囲に召還し、{1}の敵ユニットに毎秒{2}を与える。魔法DMは敵ユニットがFrostまたはPermafrostの時には50%増加する。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 12, 6, ap(0.1), amplify(Health, 0.01, 0.0025))
                .mana(40)
                .cd(10);
        Sejuani.W.update(P306)
                .active("次の通常攻撃は、対象と{1}の敵達に{2}を与える。また4秒間{1}の敵に毎秒{3}を与える。(最大で{4})")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 20, 10, ap(0.15), amplify(BounusHealth, 0.04))
                .variable(4, MagicDamage, 120, 60, ap(0.9), amplify(BounusHealth, 0.16))
                .cd(11, -1);
        Sejuani.W.update(P308).variable(4, MagicDamage, 120, 60, ap(0.9), amplify(BounusHealth, 0.1));
        Sejuani.E.update()
                .active("{0}の敵ユニットのFrostをPermafrostにし、{1}を与える。Permafrost状態の敵ユニットは3秒間{2}を受ける。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 50, ap(0.5))
                .variable(2, MSSlowRatio, 30, 10)
                .mana(55)
                .cd(11);
        Sejuani.E.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、対象を4秒間Frost状態にする。")
                .active("{0}のFrost状態の敵ユニットに{1}と{2}間{3}を与える。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 50, ap(0.5))
                .variable(2, Time, 2, 0.25)
                .variable(3, MSSlowRatio, 50, 5);
        Sejuani.E.update(P308).variable(2, Time, 1.5, 0.25);
        Sejuani.R.update()
                .active("指定方向に武器を投げ、最大距離飛ぶか敵Championに命中するとその場で氷が爆発し、{1}の敵ユニットに{2}と{3}を与え、Frostにする。武器が直撃した敵Championには{4}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1)
                .variable(4, Stun, 2)
                .mana(100)
                .cd(130, -15)
                .range(1150);
        Sejuani.R.update(P306)
                .active("指定方向に武器を投げ、敵Championに命中するとその場で爆発し、{1}の敵ユニットに{2}と{3}を与える。命中しなかった場合、最大射程で爆発し{1}の敵ユニットに{2}と{5}間{4}を与える。")
                .variable(3, Stun, 1.5, 0.25)
                .variable(4, MSSlowRatio, 90)
                .variable(5, Time, 1.5, 0.25);
        Sejuani.R.update(P308).variable(3, Stun, 1.25, 0.25).variable(5, Time, 1.25, 0.25);

        /** Shaco */
        Shaco.P.update().passive("対象の背後から攻撃した場合に{1}する。").variable(1, DamageRatio, 20);
        Shaco.Q.update()
                .active("指定地点にテレポートし、{1}になる。また、スキル使用後6秒以内に通常攻撃を行うと必ずクリティカルになる。その際のクリティカルダメージは{2}になる。")
                .variable(1, Stealth, 3.5)
                .variable(2, Percentage, 140, 20)
                .cd(11)
                .mana(90, -10)
                .range(400);
        Shaco.W.update()
                .active("指定地点に60秒持続する人形を設置する。人形は設置後2秒で{1}となり、敵ユニットがステルス状態の人形から範囲300以内に近づくと、人形のステルスが解除されると同時に近くの敵ユニットに{2}を与え、5秒間通常攻撃({3})を行った後に破壊される。")
                .variable(1, Stealth)
                .variable(2, Fear, 0.5, 0.25)
                .variable(3, MagicDamage, 35, 15, ap(0.2))
                .mana(60)
                .cd(16)
                .range(425);
        Shaco.E.update()
                .passive("通常攻撃に2秒間の{1}を付与する。対象がChampion以外の場合、更に命中率低下(値はスローと同じ)を与える。命中率低下を受けたユニットは一定確率で通常攻撃が外れる(ブラインドと同じ)。")
                .variable(1, MSSlowRatio, 10, 5)
                .active("対象の敵ユニットに{2}と3秒間{1}を与える。効果後はCDが解消されるまでPassiveの効果が無くなる。")
                .variable(2, MagicDamage, 50, 40, ap(1), bounusAD(1))
                .mana(50, 5)
                .cd(8)
                .range(625);
        Shaco.R.update()
                .active("18秒間持続する自身のイリュージョン(敵からの見た目は本体と同じ)を作成する。(RまたはALT押しながらクリックで任意の操作可能)イリュージョンは本体の75%の攻撃力を持ち、150%のダメージを受ける。また本体の一部アイテムの効果を引き継ぐ。イリュージョン死亡または効果時間終了時に爆発し、{1}の敵ユニットに{2}を与える。イリュージョンが塔に与えるダメージは半分。このスキルを使用してもステルスは解除されない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 300, 150, ap(1))
                .mana(100)
                .cd(100, -10);

        /** Shen */
        Shen.P.update()
                .passive("9秒に1度通常攻撃に追加{1}が付与され、{2}する。このスキルはShenが通常攻撃を行う度にCDが1秒解消される。CD解消は建物を攻撃した場合は発生しない。LV1/7/13で「気」回復量が増加する。")
                .variable(1, MagicDamage, 4, 0, amplify(Lv, 4), amplify(BounusHealth, 0.1))
                .variable(2, RestoreEnergy, new Per6Level(10, 10));
        Shen.Q.update()
                .active("対象の敵ユニットに{1}と5秒間持続するDebuffを与える。Debuffが付与された対象に通常攻撃またはダメージスペルで攻撃をすると、攻撃した味方Championは3秒かけて{2}する。このスキルでLHを取った場合、{3}する。")
                .variable(1, MagicDamage, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 6, 4, amplify(Health, 0.015))
                .variable(3, RestoreHealth, 2, 1.3, amplify(Health, 0.005))
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(475);
        Shen.W.update()
                .active("3秒間{1}を得る。シールドが持続している間はKi StrikeのCD解消効果が1秒から2秒になる。")
                .variable(1, Shield, 70, 45, ap(0.6))
                .cd(9, -1)
                .cost(Energy, 50, 0);
        Shen.W.update(P310A).variable(1, Shield, 60, 40, ap(0.6));
        Shen.E.update()
                .active("指定地点まで素早く移動し接触した敵Championに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける物理DMを半減する。またこのスキルが敵Championに命中する度に{3}する。")
                .variable(1, MagicDamage, 50, 35, ap(0.5))
                .variable(2, Taunt, 1.5)
                .variable(3, RestoreEnergy, 40)
                .cd(16, -2)
                .cost(Energy, 120, 0)
                .range(600);
        Shen.E.update(P312)
                .active("指定地点まで素早く移動し接触した敵Championに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける通常攻撃のDMを半減する。またこのスキルが敵Championに命中する度に{3}する。");
        Shen.R.update()
                .active("対象の味方Championに5秒間{1}を付与し、3秒詠唱後そこまでワープする。")
                .variable(1, Shield, 250, 300, ap(1.5))
                .cd(200, -20)
                .range(-1);
        Shen.R.update(P310A).active("対象の味方Championに5秒間{1}を付与し、3秒詠唱後そこまでワープする。詠唱中にスロー以外のCCを受けると中断される。");

        Shyvana();

        /** Singed */
        Singed.P.update().passive("{1}を得る。").variable(1, Health, 0, 0, amplify(Mana, 0.25));
        Singed.Q.update()
                .active("Singedの通り道に3.25秒間持続する毒を撒き、触れた敵ユニットに3秒間毎秒{1}を与える。")
                .variable(1, MagicDamage, 22, 0, ap(0.3))
                .mana(13)
                .cd(1)
                .type(SkillType.Toggle);
        Singed.W.update()
                .active("指定地点に5秒間持続する粘着剤を撒き、{1}の敵ユニットに{2}を与え続ける。この効果は範囲外に出てからも1秒間持続する。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 35, 10)
                .mana(70, 10)
                .cd(14)
                .range(1000);
        Singed.E.update()
                .active("対象の敵ユニット{1}を与え、Singedの後ろに投げ飛ばす({2})。")
                .variable(1, MagicDamage, 100, 50, ap(1))
                .variable(2, Distance, 550)
                .mana(100, 10)
                .cd(10)
                .range(125);
        Singed.E.update(P304).variable(1, MagicDamage, 80, 45, ap(0.75));
        Singed.R.update()
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
        Singed.R.update(P304).active("25秒間{1}、{2}、{3}、{4}、{5}を得て、{7}する。");

        /** Sion */
        Sion.P.update()
                .passive("40%の確率で{1}する。この軽減は防御力計算より先に行われる。")
                .variable(1, AttackDamageReduction, new Per6Level(30, 10));
        Sion.Q.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 70, 55, ap(0.9))
                .variable(2, Stun, 1.5)
                .mana(100)
                .cd(12, -1)
                .range(550);
        Sion.W.update()
                .active("{1}を得る。10秒間シールドが残っていた場合、シールドが破裂し{2}の敵ユニットに{3}を与える。使用から4秒後以降に再度使用で、即座にシールドを破裂させる。")
                .variable(1, Shield, 100, 50, ap(0.9))
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 100, 50, ap(0.9))
                .mana(70, 10)
                .cd(8);
        Sion.E.update()
                .active("{1}を得る。使用中にLHをとるとSionの最大HPが{2}増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍になる。")
                .variable(1, AD, 25, 10)
                .variable(2, Count, 1, 0.5)
                .cost(Health, 6, 2)
                .type(SkillType.Toggle);
        Sion.R.update()
                .active("20秒間{1}を得て{2}し、通常攻撃をするたびに{4}の味方ユニットは{3}する。")
                .variable(1, LS, 50, 25)
                .variable(2, ASRatio, 50)
                .variable(3, RestoreHealth, 0, 0, amplify(AttackDamageRatio, 25, 12.5))
                .variable(4, Radius, 200)
                .mana(100)
                .cd(90);

        Sivir();
        Skarner();
        Sona();
        Soraka();
        Swain();
        Syndra();
        Taric();
        Talon();
        Teemo();
        Thresh();

        /** Tristana */
        Tristana.P.update().passive("通常攻撃とExplosive Shotは追加の{1}を得る。").variable(1, Range, new Per1Level(0, 9));
        Tristana.Q.update().active("7秒間{1}する。").variable(1, ASRatio, 30, 15).mana(50).cd(20);
        Tristana.W.update()
                .active("指定地点にジャンプしジャンプ先の{1}の敵ユニットに{2}と2.5秒間{3}を与える。キルかアシストをとるとこのスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .variable(3, MSSlowRatio, 60)
                .variable(4, CDDecrease)
                .mana(80)
                .cd(22, -2)
                .range(800);
        Tristana.E.update()
                .passive("通常攻撃で敵ユニットを倒した時にそのユニットの{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 50, 25, ap(0.25))
                .active("対象の敵ユニットに5秒かけて{3}と{4}を与える。")
                .variable(3, MagicDamage, 110, 40, ap(1))
                .variable(4, Wounds)
                .mana(50, 10)
                .cd(16)
                .range(new Diff(616, 0, 1), amplify(Lv, 9));
        Tristana.R.update()
                .active("対象の敵ユニットに{1}を与え、対象と{2}の敵ユニットを{3}させる。")
                .variable(1, MagicDamage, 300, 100, ap(1.5))
                .variable(2, Radius, 200)
                .variable(3, Knockback, 600, 200)
                .mana(100)
                .cd(60)
                .range(700);

        /** Trundle */
        Trundle.P.update()
                .passive("{1}以内で敵ユニットが死んだとき、{2}する。")
                .variable(1, Radius, 1000)
                .variable(2, RestoreHealth, 0, 0, amplify(TargetMaxHealthRatio, new Per4LevelForTrundle(2, 1)));
        Trundle.Q.update()
                .active("次の通常攻撃で与えるダメージは{1}になる。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 30, 15, amplify(AD, 0.8, 0.1))
                .variable(2, AD, 20, 5)
                .variable(3, ADReduction, 10, 2.5)
                .mana(30)
                .cd(4);
        Trundle.Q.update(P306)
                .active("次の通常攻撃は{1}と0.1秒間{4}を与える。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 20, 20, amplify(AD, 1, 0.05))
                .variable(4, MSSlowRatio, 75);
        Trundle.W.update()
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}して{4}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, ASRatio, 20, 10)
                .variable(3, MSRatio, 20, 5)
                .variable(4, Tenacity, 20, 5)
                .mana(60)
                .cd(15)
                .range(900);
        Trundle.W.update(P306)
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}、{4}する。")
                .variable(2, ASRatio, 20, 15)
                .variable(4, RestoreHealthRatio, 8, 3);
        Trundle.E.update()
                .active("指定地点に{0}間持続する通行不可能なビーコンを設置し、ビーコンの{1}にいる敵ユニットに{2}を与える。また、{3}の視界を得る。")
                .variable(0, Time, 7)
                .variable(1, Radius, 375)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Radius, 1200)
                .mana(60)
                .cd(23, -3)
                .range(1000);
        Trundle.E.update(P306).variable(0, Time, 6);
        Trundle.R.update()
                .active("対象の敵ユニットに{1}を{2}、{3}を与える。その後6秒間かけて更に{1}と{2}、{3}を与える。このスキルでダメージを与えると{4}する。")
                .variable(1, MagicDamage, 100, 75, ap(0.6))
                .variable(2, ARReductionRatio, 15, 5)
                .variable(3, MRReductionRatio, 15, 5)
                .variable(4, RestoreHealth, 0, 0, amplify(DealtDamage, 1))
                .mana(75)
                .cd(80, -10)
                .range(700);
        Trundle.R.update(P306)
                .active("対象の敵ユニットに{1}を与え、4秒間かけて{2}、{3}を与えて減少させた分の値を自身のARとMRに加算する、この効果はその後4秒間持続する。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 20, 2, ap(0.02)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, MRReductionRatio, 20);

        Tryndamere();

        /** Twisted Fate */
        TwistedFate.P.update().passive("味方Championが敵を倒した時に追加で{1}を得るようになる。").variable(1, Gold, 2);
        TwistedFate.P.update(P310).passive("ユニットを倒すたびに追加の{1}(1~6でランダム、但し期待値は3.5よりも大きくなる)を得る。").variable(1, Gold);
        TwistedFate.Q.update()
                .active("指定向き3方向に貫通するカードを飛ばし、当たった敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.65))
                .mana(60, 10)
                .cd(6)
                .range(1450);
        TwistedFate.W.update()
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
        TwistedFate.W.update(P307).variable(3, RestoreMana, 50, 25);
        TwistedFate.W.update(P310)
                .active("3種類のカードが順番に出現し、8秒以内に再度使用してカードを決定する。4秒以内の次の通常攻撃が魔法DMに変換され、以下の効果が追加される。<br>Blue Card: {2}を与え{3}する。<br>Red Card: {4}の敵に{5}と2.5秒間{6}を与える。<br>Gold Card: {7}と{8}を与える。");
        TwistedFate.E.update()
                .passive("{1}を得て{2}する。通常攻撃4回毎に追加{3}を与える。")
                .variable(1, CDR, 3, 3)
                .variable(2, ASRatio, 3, 3)
                .variable(3, MagicDamage, 55, 25, ap(0.4));
        TwistedFate.E.update(P307).passive("{2}する。通常攻撃4回毎に追加{3}を与える。").variable(2, ASRatio, 10, 5);
        TwistedFate.R.update()
                .active("{1}間すべての敵Champion(ステルス中のChampion含む)の視界を得る。効果中に再度使用すると2秒間移動・攻撃が不可能になった後、指定した地点にワープする。。効果中は敵Championの頭上にアイコンが表示される。")
                .variable(1, Time, 6, 2)
                .mana(150, -25)
                .cd(150, -15)
                .range(5500);
        TwistedFate.R.update(P307).cd(180, -30);

        /** Twitch */
        Twitch.P.update()
                .passive("通常攻撃時に毒を付与し、６秒間かけて{1}を与える。毒は6回までスタックする。")
                .variable(1, TrueDamage, new Per5Level(12, 12));
        Twitch.Q.update()
                .active("使用から1.25秒後に{1}になる。ステルス状態では{2}し、ステルスを解除すると5秒間{3}する。ステルス準備中に攻撃を行うかダメージを受けると、ステルス状態になるのに再度1.25秒必要になる。ステルス準備開始から5秒経過するとダメージを受けていてもステルス状態になる。")
                .variable(1, Stealth, 4, 1)
                .variable(2, MSRatio, 20)
                .variable(3, ASRatio, 30, 10)
                .mana(60);
        Twitch.W.update()
                .active("指定地点に{1}で毒の入った瓶を投げつけ、範囲内の敵ユニットに3秒間{2}と毒を2スタック分与える。また、指定した地点の{3}。")
                .variable(1, MissileSpeed, 1400)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Visionable)
                .mana(50)
                .cd(13, -1)
                .range(950);
        Twitch.E.update()
                .active("毒をスタックされている{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 1200)
                .variable(2, PhysicalDamage, 40, 10, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)))
                .mana(50, 10)
                .cd(12, -1);
        Twitch.E.update(P310A).variable(2, PhysicalDamage, 20, 15, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)));
        Twitch.R.update()
                .active("7秒間射程が850になり{1}を得て、通常攻撃が敵ユニットを貫通するようになる。対象との直線上にいる敵ユニットにもダメージと毒スタックを与える。ダメージは敵に当たるごとに20%減少する。最小で40%。")
                .variable(1, AD, 20, 8)
                .mana(100, 25)
                .cd(120, -10);

        /** Udyr */
        Udyr.P.update()
                .passive("スキルを使用する度に{1}、{2}、{3}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。")
                .variable(-1, ASRatio, 10)
                .variable(-2, ARRatio, 4)
                .variable(-3, MRRatio, 4);
        Udyr.P.update(P305)
                .passive("スキルを使用する度に{1}、{4}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。")
                .variable(4, MS, 5);
        Udyr.Q.update()
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで{1}する。")
                .variable(-1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 30, 50, ad(1.5))
                .variable(3, ASRatio, 15, 5)
                .mana(55, -5)
                .cd(6);
        Udyr.Q.update(P305).mana(47, -3);
        Udyr.Q.update(P306)
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで通常攻撃は追加{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.15))
                .variable(2, PhysicalDamage, 30, 50, amplify(AD, 1.2, 0.1))
                .variable(3, ASRatio, 30, 10);
        Udyr.W.update()
                .active("5秒間{1}を得る。別のスキルを使うまで通常攻撃でクリティカルが発生しなくなるが、通常攻撃するごとに{2}し{3}する。")
                .variable(1, Shield, 60, 36, ap(0.5))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 10, 2))
                .variable(3, RestoreMana, 0, 0, amplify(DealtDamageRatio, 5, 1))
                .mana(55, -5)
                .cd(6);
        Udyr.W.update(P305)
                .active("5秒間{1}を得る。別のスキルを使うまで通常攻撃するごとに{2}する。")
                .variable(1, Shield, 60, 40, ap(0.5))
                .mana(47, -3);
        Udyr.E.update()
                .active("{1}間{2}する。別のスキルを使うまで通常攻撃は{3}を与える。この効果は同一の対象に6秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.5)
                .variable(2, MSRatio, 15, 3)
                .variable(3, Stun, 1)
                .mana(55, -5)
                .cd(6);
        Udyr.E.update(P305)
                .active("{1}間{2}し{4}を得る。別のスキルを使うまで通常攻撃は{3}を与える。この効果は同一の対象に6秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.25)
                .variable(2, MSRatio, 15, 5)
                .variable(4, IgnoreUnitCollision)
                .mana(47, -3);
        Udyr.R.update()
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、{2}と{3}を得る。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(1, MagicDamage, 15, 10, ap(0.25))
                .variable(2, AD, 8, 4)
                .variable(3, AP, 16, 8)
                .variable(4, MagicDamage, 40, 40, ap(0.25))
                .mana(55, -5)
                .cd(6);
        Udyr.R.update(P305)
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、次の通常攻撃に前方の敵ユニットに{4}を与える効果を付与する。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(4, MagicDamage, 40, 40, ap(0.45))
                .mana(47, -3);

        /** Urgot */
        Urgot.P.update().passive("通常攻撃またはAcid Hunterでダメージを与えた対象に、与えるダメージを15%低下するDebuffを付与する。この効果は2.5秒間持続する。");
        Urgot.Q.update()
                .active("指定方向にミサイルを飛ばし当たった敵ユニットに{1}を与える。Noxian Corrosive Chargeの効果を受けている敵ユニットの近くを指定して使用すると、その敵ユニット目掛けてミサイルが飛んでいく。")
                .variable(1, PhysicalDamage, 10, 30, ad(0.85))
                .mana(40)
                .cd(2)
                .range(1000);
        Urgot.W.update()
                .active("7秒間{1}を得る。シールドが残っている間は通常攻撃とAcid Hunterに1秒間{2}が付与される。")
                .variable(1, Shield, 80, 40, ap(0.8))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(55, 5)
                .cd(16, -1);
        Urgot.E.update()
                .active("指定地点に爆弾を飛ばし{1}の敵ユニットに5秒間かけて{2}と{3}を与える。また指定地点の{4}。")
                .variable(1, Radius, 300)
                .variable(2, PhysicalDamage, 75, 55, bounusAD(0.6))
                .variable(3, MSSlowRatio, 12, 2)
                .variable(4, Visionable)
                .mana(50, 5)
                .cd(15, -1)
                .range(900);
        Urgot.R.update()
                .active("対象の敵Championに{1}を与え、5秒間{2}と{3}を得る。1秒詠唱後に敵Championと自分の位置を入れ替え、敵Championに3秒間{4}を与える。")
                .variable(1, Suppression, 1)
                .variable(2, AR, 60, 30)
                .variable(3, MR, 60, 30)
                .variable(4, MSSlowRatio, 40)
                .mana(120)
                .cd(120)
                .range(550, 150);

        Varus();
        Vayne();

        /** Veigar */
        Veigar.P.update().passive("{1}する。").variable(1, MregRatio, 0, 0, amplify(MissingManaPercentage, 0.01));
        Veigar.Q.update()
                .passive("敵Championを倒すと{1}を得る。")
                .variable(-1, AP, 1, 1)
                .active("対象の敵ユニットに{2}を与える。このスキルでLHを取るとAPが1増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+2)になる。")
                .variable(2, MagicDamage, 80, 45, ap(0.6))
                .mana(60, 5)
                .cd(8, -1)
                .range(650);
        Veigar.W.update()
                .active("指定地点に1.2秒後に隕石を降らし、{1}の敵ユニットに{2}を与える。また隕石が落下するまでの間、指定地点の{3}。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 120, 50, ap(1))
                .variable(3, Visionable)
                .mana(70, 10)
                .cd(10)
                .range(900);
        Veigar.E.update()
                .active("指定した{1}に3秒間魔法陣を呼び出し、魔法陣の縁に触れた敵ユニットに{2}を与える。")
                .variable(1, Radius, 425)
                .variable(2, Stun, 1.5, 0.25)
                .mana(80, 10)
                .cd(20, -1)
                .range(600);
        Veigar.R.update()
                .active("対象の敵Championに{1}を与える。")
                .variable(1, MagicDamage, 250, 125, ap(1.2), amplify(TargetAP, 0.8))
                .mana(125, 50)
                .cd(130, -20)
                .range(650);

        VelKoz();

        /** Vi */
        Vi.P.update()
                .passive("敵ユニットにスキルでダメージを与えると、3秒間{1}を得る。")
                .variable(1, Shield, 0, 0, amplify(Health, 0.1))
                .cd(new Per6LevelForVi(18, -5));
        Vi.Q.update()
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.7))
                .variable(2, PhysicalDamage, 100, 60, bounusAD(1.4))
                .variable(3, Distance, 50)
                .variable(4, Distance, 600)
                .mana(50, 10)
                .cd(18, -2.5)
                .range(50);
        Vi.Q.update(P303)
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。途中で詠唱を停止させられた場合、このスキルのCDは3秒になり、消費したmanaの半分が回復する。");
        Vi.W.update()
                .passive("同一対象に3回連続して通常攻撃を行うと、{1}と4秒間{2}を与え、4秒間{3}する。(ミニオンやモンスターへは最大300DMを与える)")
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 6, 1, bounusAD(0.03)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, ASRatio, 30, 5);
        Vi.W.update(P303).variable(1, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 4, 1.5, bounusAD(0.03)));
        Vi.E.update()
                .active("チャージを1つ消費することで、次の通常攻撃に追加{1}を付与し、対象とその後方扇形{2}にいる敵ユニットにもダメージを与える範囲攻撃になる。チャージは{3}毎に増加し、最大2つまでスタックされる。")
                .variable(1, PhysicalDamage, 5, 15, ad(1.15), ap(0.7))
                .variable(2, Radius, 600)
                .variable(3, CDRAwareTime, 14, -1.5)
                .mana(60)
                .cd(1);
        Vi.R.update()
                .active("対象の敵Championに突撃し、{1}と{2}を与える。一連の動作中は{4}を得て、また対象のChampion以外でViに触れた敵ユニットには{3}を与え、左右に吹き飛ばす。")
                .variable(1, PhysicalDamage, 200, 125, bounusAD(1.4))
                .variable(2, Knockup, 1.25)
                .variable(3, PhysicalDamage, 150, 112.5, bounusAD(1.05))
                .variable(4, IgnoreCC)
                .mana(100, 25)
                .cd(130, -25)
                .range(700);

        Viktor();

        /** Vladimir */
        Vladimir.P.update()
                .passive(BounusHealth + "に比例して{1}を、" + AP + "に比例して{2}を得る。")
                .variable(1, AP, 0, 0, amplify(BounusHealth, 0.025))
                .variable(2, Health, 0, 0, ap(1.4));
        Vladimir.Q.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。")
                .variable(1, MagicDamage, 90, 35, ap(0.6))
                .variable(2, RestoreHealth, 15, 10, ap(0.25))
                .cd(10, -1.5)
                .range(600);
        Vladimir.W.update()
                .active("Vladimirが2秒間血の海に沈む。その間はターゲットされなくなり、{1}内にいる敵ユニットに0.5秒毎に{2}と{3}間の{4}を与え続ける。また、与えたダメージの12.5%Healthが回復する。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 20, 13.75, amplify(BounusHealth, 0.00375))
                .variable(3, Time, 1)
                .variable(4, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 20, 0)
                .cd(26, -3);
        Vladimir.E.update()
                .active("{1}の敵ユニットに{2}を与える。使用する度にスタックが増加し、1スタックにつきこのスキルの基礎魔法DMとHPコストが25%増加し、{4}するく(最大4スタック)。スタックは10秒増加が無いと0になる。このスキルは周囲に敵ユニットがいなくても使用可能。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 60, 25, ap(0.45))
                .variable(4, RestoreHealthRatio, 4, 1)
                .cost(Health, 30, 10)
                .cd(4.5)
                .range(620);
        Vladimir.R.update()
                .active("指定地点の{1}の敵ユニットに疫病を付与し、その敵ユニットは5秒間受けるダメージが12%増加する。効果終了時に{2}を与える。ダメージ増加効果のため実際には{3}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MagicDamage, 168, 112, ap(0.784))
                .cd(150, -15)
                .range(700);

        /** Volibear */
        Volibear.P.update()
                .passive("VolibearのHPが30%以下になったとき、6秒間かけて{1}する。{2}。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.3))
                .variable(2, CDRUnaware)
                .cd(-120);
        Volibear.Q.update()
                .active("4秒間{1}する。敵Championに向かって移動する場合は{2}する。また次の通常攻撃に追加{3}を付与し、対象をVolibearの後ろに投げ飛ばす。4秒間攻撃を行わないとCDになる。")
                .variable(1, MSRatio, 15)
                .variable(-2, MSRatio, 45)
                .variable(3, PhysicalDamage, 30, 30)
                .mana(40)
                .cd(12, -1);
        Volibear.Q.update(P3051).variable(-2, MSRatio, 30, 5);
        Volibear.W.update()
                .passive("通常攻撃でダメージを与える度にスタックが1増加し(最大3スタック)、{1}する。スタックは4秒持続する。")
                .variable(-1, ASRatio, 0, 0, amplify(Stack, 8, 3))
                .active("スタックが最大まで溜まった時のみ使用可能。対象の敵ユニットに{2}を与える。対象が失っているHP1%につきダメージが1%上昇する。")
                .variable(2, PhysicalDamage, 80, 45, amplify(BounusHealth, 0.15))
                .mana(35)
                .cd(17)
                .range(400);
        Volibear.E.update()
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。対象がMinionの場合、さらに{4}を与える。")
                .variable(1, Radius, 425)
                .variable(2, MagicDamage, 60, 45, ap(0.6))
                .variable(3, MSSlowRatio, 30, 5)
                .variable(4, Fear, 3)
                .mana(60, 5)
                .cd(11);
        Volibear.R.update()
                .active("12秒間Volibearが通常攻撃した対象に雷を放ち{1}を与える。雷は対象の{2}の敵ユニット(敵Championを優先)3体にも連鎖し同様のダメージを与える。建物を攻撃する時は効果は発生しない。")
                .variable(1, MagicDamage, 75, 40, ap(0.3))
                .variable(2, Radius, 300)
                .mana(100)
                .cd(100, -10);

        /** Warwick */
        Warwick.P.update()
                .passive("通常攻撃で対象にスタックを付与し、追加{1}を与え{2}する。スタックは4秒持続し、最大3つまでスタックされる。建物を攻撃した場合は無効。")
                .variable(1, MagicDamage, 0, 0, amplify(Stack, new Per1Level(new double[] {3, 3.5, 4, 4.5, 5, 5.5, 6,
                        6.5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16})))
                .variable(2, RestoreHealth, 0, 0, amplify(Stack, new Per1Level(new double[] {3, 3.5, 4, 4.5, 5, 5.5, 6,
                        6.5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16})));
        Warwick.Q.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。対象がChampionの場合は{3}と比較し大きいほうのDMを与える。")
                .variable(1, MagicDamage, 75, 50, ap(1))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 80))
                .variable(3, MagicDamage, 0, 0, ap(1), amplify(TargetMaxHealthRatio, 8, 2))
                .mana(70, 10)
                .cd(10, -1)
                .range(400);
        Warwick.W.update()
                .active("10秒間{2}し、{1}の味方Championは{3}する。")
                .variable(1, Radius, 1200)
                .variable(2, ASRatio, 40, 10)
                .variable(-3, ASRatio, 20, 5)
                .mana(35)
                .cd(24, -2);
        Warwick.E.update()
                .passive("{1}して、{2}内にいるHPが50%以下の敵Championの{3}。このスキルで敵のステルスを看破する事はできず、ステルス中の敵Championの視界を得ることもできない。")
                .variable(1, MSRatio, 20, 5)
                .variable(2, Radius, 1500, 800)
                .variable(3, Visionable)
                .cd(4);
        Warwick.R.update()
                .active("対象の敵Championに突撃し{2}を与えて、その間{3}を得て0.42秒毎に{1}を、計5回で{4}を与える。{5}。")
                .variable(1, MagicDamage, 50, 17, bounusAD(0.4))
                .variable(2, Suppression, 1.8)
                .variable(3, LS, 30)
                .variable(4, MagicDamage, 250, 85, bounusAD(2))
                .variable(5, OnHitEffect)
                .type(SkillType.Channel)
                .mana(100, 25)
                .cd(90, -10)
                .range(700);
        Warwick.R.update(P307).active("対象の敵Championに突撃し{2}を与えて、その間{3}を得て0.3秒毎に{1}を、計5回で{4}を与える。{5}。");

        /** MonkeyKing */
        MonkeyKing.P.update()
                .passive("Wukongの視界内{1}にいる敵Championの数に比例して、{2}と{3}を得る。")
                .variable(1, Radius, 1400)
                .variable(2, AR, 0, 0, amplify(EnemyChampion, new Per6Level(4, 2)))
                .variable(3, MR, 0, 0, amplify(EnemyChampion, new Per6Level(4, 2)));
        MonkeyKing.Q.update()
                .active("次の通常攻撃は射程が125増加して追加の{1}と3秒間の{2}を与える。")
                .variable(1, PhysicalDamage, 30, 30, ad(0.1))
                .variable(2, ARReductionRatio, 30)
                .mana(40)
                .cd(9, -1)
                .range(300);
        MonkeyKing.W.update()
                .active("{1}になり{2}を得る。同時にWukongがいた場所に分身(操作不可能)を作り出す。分身は1.5秒経過すると消滅し、その際に分身の{3}の敵に{4}を与える。")
                .variable(1, Stealth, 1.5)
                .variable(2, IgnoreUnitCollision)
                .variable(3, Radius, 350)
                .variable(4, MagicDamage, 70, 45, ap(0.6))
                .mana(50, 5)
                .cd(18, -2);
        MonkeyKing.E.update()
                .active("対象の敵ユニットまでダッシュし{1}を与える。対象の敵ユニットの{3}の敵ユニット2体にもWukongの幻影が飛び、{1}を与える。また、スキル使用後4秒間{2}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.8))
                .variable(2, ASRatio, 30, 5)
                .variable(3, Radius, 325)
                .mana(45, 5)
                .cd(8)
                .range(625);
        MonkeyKing.R.update()
                .active("4秒間Wukongが回転する。回転中は{1}の敵ユニットに0.5秒毎に{2}と{3}を与える。打ち上げ効果は同一の対象に1度までしか発生しない。また、このスキルを使用してから0.5秒毎に{5}する。最大で{4}を与え、{6}する。")
                .variable(1, Radius, 325)
                .variable(2, PhysicalDamage, 10, 45, ad(0.6))
                .variable(3, Knockup, 1.5)
                .variable(4, PhysicalDamage, 80, 360, ad(4.8))
                .variable(-5, MSRatio, 5)
                .variable(6, MSRatio, 40)
                .mana(100)
                .cd(120, -15);

        Xerath();

        /** Xin Zhao */
        XinZhao.P.update()
                .passive("通常攻撃または" + XinZhao.E + "で指定した敵ユニットに{1}を与える。この効果はスタックせず、3秒間持続し、また1体の敵ユニットにしか発動しない。")
                .variable(1, ARReductionRatio, 15);
        XinZhao.Q.update()
                .active("次の3回の通常攻撃に{1}が追加され、3回目の攻撃で{2}を与える。効果中に通常攻撃を行う度に、このスキル以外のCDが1秒解消される。")
                .variable(1, PhysicalDamage, 15, 15, ad(0.2))
                .variable(2, Knockup, 1)
                .mana(30)
                .cd(9, -1);
        XinZhao.W.update()
                .passive("通常攻撃3回ごとに{1}する。")
                .variable(1, RestoreHealth, 26, 6, ap(0.7))
                .active("5秒間{2}増加する。")
                .variable(2, ASRatio, 40, 10)
                .mana(40)
                .cd(16, -1);
        XinZhao.E.update()
                .active("対象の敵ユニットに突進し、{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MSSlowRatio, 25, 5)
                .mana(70)
                .cd(13, -1)
                .range(600);
        XinZhao.E.update(P303).variable(2, MagicDamage, 70, 35, ap(0.6)).cd(14, -1);
        XinZhao.R.update()
                .active("槍を振り回し{3}の敵ユニットに{1}と{2}を与え、このスキルを命中させた敵Championの数に比例して6秒間{4}と{5}を得る。" + XinZhao.P + "効果中の敵ユニットに対しては" + Knockback + "は発動しない。")
                .variable(1, PhysicalDamage, 125, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .variable(2, Knockback, 0)
                .variable(3, Radius, 375)
                .variable(4, AR, 15, 5)
                .variable(5, MR, 15, 5)
                .mana(100)
                .cd(100, -10);
        XinZhao.R.update(P303)
                .variable(1, PhysicalDamage, 75, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .cd(120, -10);

        Yasuo();
        Yorick();
        Zac();
        Zed();
        Ziggs();

        /** Zilean */
        Zilean.P.update().passive("すべての味方Championが取得する{1}する。").variable(1, ExperimentRatio, 8);
        Zilean.Q.update()
                .active("対象のユニットに爆弾をつけ、4秒後に対象(味方ユニットの場合ダメージ無し)とその周辺{1}の敵ユニットに{2}を与える。対象が死亡した場合は即座に爆発する。")
                .variable(1, Radius, 330)
                .variable(2, MagicDamage, 90, 55, ap(0.9))
                .mana(70, 15)
                .cd(10)
                .range(700);
        Zilean.W.update().active(Zilean.W + "以外のスキルのCDを10秒解消する。").mana(50).cd(18, -3);
        Zilean.E.update()
                .active("味方Championに使用した場合は{2}間{1}増加し、敵Championに使用した場合は{2}間{3}を与える。")
                .variable(1, MSRatio, 55)
                .variable(2, Time, 2.5, 0.75)
                .variable(3, MSSlowRatio, 55)
                .mana(80)
                .cd(20)
                .range(700);
        Zilean.R.update()
                .active("対象の味方Championが使用してから7秒以内に死亡した場合、2秒後にその場で{1}して復活する。")
                .variable(1, RestoreHealth, 600, 150, ap(2))
                .mana(125, 25)
                .cd(180)
                .range(900);

        Zyra();
    }

    private static void Aatrox() {
        Aatrox.P.update()
                .passive("スキルを使用時に消費したHealthをBlood Wellとしてスタックし(最大スタック量は{1})、5秒間戦闘状態でなくなると毎秒2%ずつ失われていく。スタックが2%貯まる毎に{2}する(最大で{3})。Healthが0になると3秒かけて{4}する(最大で{5})。{6}。")
                .variable(1, Stack, 30, 0, amplify(Lv, 45))
                .variable(-2, ASRatio, 0, 0, amplify(StackPercentage, 0.5))
                .variable(-3, ASRatio, 50)
                .variable(4, RestoreHealth, 10.5, 0, amplify(Lv, 15.75), amplify(Stack, 1))
                .variable(5, RestoreHealth, 40.5, 0, amplify(Lv, 60.75))
                .variable(6, CDRUnaware)
                .cd(-225)
                .update(P313)
                .variable(-2, ASRatio, 0, 0, amplify(StackPercentage, new Per3Level(0.6, 0.1)))
                .variable(-3, ASRatio, new Per3Level(30, 5));
        Aatrox.Q.update()
                .active("指定地点に飛びかかり、{1}の敵ユニットに{2}を与える。範囲内の中心にいる敵ユニットに対しては更に{3}を与える。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 70, 45, bounusAD(0.6))
                .variable(3, Knockup, 1)
                .cd(16, -1)
                .cost(CurrentHealthRatio, 10, 0)
                .range(650);
        Aatrox.W.update()
                .passive("通常攻撃3回ごとに{1}する。Healthが50%以下の場合、{2}する。ToggleOnの間、この効果は失われる。")
                .variable(1, RestoreHealth, 20, 5, bounusAD(0.25))
                .variable(2, RestoreHealth, 60, 15, bounusAD(0.75))
                .active("通常攻撃3回ごとに{3}を与えて{4}する。")
                .variable(3, PhysicalDamage, 60, 35, bounusAD(1))
                .variable(4, LoseHealth, 15, 8.75, bounusAD(0.25))
                .cd(0.5)
                .type(SkillType.Toggle);
        Aatrox.E.update()
                .active("指定方向に貫通するエネルギーを放ち、当たった敵ユニットに{1}と{2}間{3}を与える。")
                .variable(1, MagicDamage, 75, 45, ap(0.6), bounusAD(0.6))
                .variable(2, Time, 1.75, 0.25)
                .variable(3, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 5, 0)
                .cd(12, -1)
                .range(1000)
                .update(P313)
                .variable(1, MagicDamage, 75, 35, ap(0.6), bounusAD(0.6));
        Aatrox.R.update()
                .active("{1}の敵Championに{2}を与え、12秒間{3}し、通常攻撃の射程が325に増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 200, 100, ap(1))
                .variable(3, ASRatio, 40, 10)
                .cd(100, -15)
                .update(P506)
                .active("{1}の敵Championに{2}を与え、12秒間{3}し、通常攻撃の射程が325に増加する。当たった敵毎に20%の" + Aatrox.P + "を得る。");
    }

    private static void Ahri() {
        Ahri.P.update()
                .passive("スキルが敵ユニットに当たる度に" + Ahri.P + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルに{1}が追加される。")
                .variable(-1, SV, 35)
                .cost(Charge, 9, 0)
                .update(P313)
                .passive("スキルが敵ユニットに当たる度に" + Ahri.P + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルが敵に当たる毎に{1}する。")
                .variable(1, RestoreHealth, 2, 0, ap(0.09), amplify(Lv, 1));
        Ahri.Q.update()
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.33))
                .variable(2, TrueDamage, 40, 25, ap(0.33))
                .cd(7, 0)
                .mana(70, 5)
                .range(880)
                .update(P506)
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。オーブを射出している間{3}する。（0.5秒かけて80まで減衰）")
                .variable(1, MagicDamage, 40, 25, ap(0.35))
                .variable(2, TrueDamage, 40, 25, ap(0.35))
                .variable(3, MS, 215)
                .mana(65, 5);
        Ahri.W.update()
                .active("Ahriの周囲を回る3本の鬼火を放つ。鬼火は5秒間持続し、近くの敵ユニットに自動的に突撃して{1}を与える。鬼火が同一対象に突撃した場合、2発目以降は本来の{2}分の魔法DMを与える(同一対象に3発命中すると{3})。Ahriの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。")
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .variable(2, Percentage, 50)
                .variable(3, MagicDamage, 80, 50, ap(0.8))
                .cd(9, -1)
                .mana(60)
                .range(800)
                .update(P313)
                .variable(2, Percentage, 30)
                .variable(3, MagicDamage, 64, 40, ap(0.64))
                .mana(50)
                .update(P506)
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .variable(2, Percentage, 30)
                .variable(3, MagicDamage, 64, 40, ap(0.64))
                .range(550)
                .mana(50);
        Ahri.E.update()
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}を与える。")
                .variable(1, MagicDamage, 60, 30, ap(0.35))
                .variable(2, Status.Charm, 1, 0.25)
                .variable(3, MSSlowRatio, 50)
                .cd(12)
                .mana(50, 15)
                .range(975)
                .update(P313)
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}を与える。6秒間、対象はAhriから受けるDMが20%増加する。")
                .mana(85)
                .update(P506)
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}を与える。")
                .variable(1, MagicDamage, 60, 305, ap(0.5));
        Ahri.R.update()
                .active("指定方向にダッシュした後、{2}の敵ユニット(敵Championを優先)3体に{1}を与える。このスキルは10秒の間、3回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2～3発目はマナコスト無しで使用可能。同一対象に3発命中すると{3}。")
                .variable(1, MagicDamage, 85, 40, ap(0.35))
                .variable(2, Radius, 500)
                .variable(3, MagicDamage, 255, 120, ap(1.05))
                .cd(110, -15)
                .mana(100)
                .range(450)
                .update(P313)
                .variable(1, MagicDamage, 70, 40, ap(0.3))
                .variable(3, MagicDamage, 210, 120, ap(0.9))
                .update(P506)
                .variable(2, Radius, 600);
    }

    private static void Akali() {
        Akali.P.update()
                .passive("{1}を得る。また通常攻撃に{2}が付与される。")
                .variable(1, SV, 6, 0, bounusAD(0.167))
                .variable(2, MagicDamage, 0, 0, amplify(AD, 0.06, 0, ap(0.00167)));
        Akali.Q.update()
                .active("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃またはCrescent Slashでダメージを与えたとき、マークを消費して{2}を与え、{3}する。")
                .variable(1, MagicDamage, 45, 25, ap(0.4))
                .variable(2, MagicDamage, 45, 25, ap(0.4))
                .variable(3, RestoreEnergy, 20, 5)
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(600)
                .update(P3051)
                .variable(1, MagicDamage, 35, 20, ap(0.4))
                .variable(2, MagicDamage, 45, 25, ap(0.5))
                .update(P506)
                .active("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃でダメージを与えたとき、マークを消費して{2}を与え、{3}する。");
        Akali.W.update()
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。Akaliは{2}と{3}、{5}を得る。敵ユニットには{4}を与える。")
                .variable(1, Radius, 300)
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .variable(4, MSSlowRatio, 14, 4)
                .variable(5, Stealth)
                .cd(20)
                .cost(Energy, 80, -5)
                .range(700)
                .update(P307)
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与えて{5}。Akaliは{2}と{3}、{5}を得る。敵ユニットには{4}を与える。")
                .variable(5, Visionable)
                .update(P506)
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。自身は{2}と{3}を得て、敵ユニットには{4}を与える。ステルスはスキル使用または通常攻撃時に解除され、再度ステルス化するのに0.65秒かかる。")
                .variable(1, Radius, 400)
                .variable(2, Stealth)
                .variable(3, MSRatio, 20, 20);
        Akali.E.update()
                .active("{2}の敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 30, 25, ap(0.3), ad(0.6))
                .variable(2, Radius, 325, 0)
                .cd(7, -1)
                .cost(Energy, 60, -5);
        Akali.R.update()
                .active("対象の敵ユニットまで高速で移動し{1}を与える。使用時にチャージを消費する。チャージは{2}毎に又は敵Championキル/アシストで増加し最大で3つまでチャージされる。チャージ増加時間はCD低減の影響を受ける。")
                .variable(1, MagicDamage, 100, 75, ap(0.5))
                .variable(2, CDRAwareTime, 25, -5)
                .cd(2, -0.5)
                .cost(Charge, 1, 0)
                .range(800)
                .update(P3051)
                .variable(2, CDRAwareTime, 35, -10)
                .update(P307)
                .variable(2, CDRAwareTime, 30, -7.5)
                .update(P506)
                .range(700);
    }

    private static void Alistar() {
        Alistar.P.update()
                .passive("スキルを使用すると3秒間{1}を得て、{2}の敵ユニットと建物に毎秒{3}を与える。ミニオンに対しては与えるダメージが2倍になる。")
                .variable(3, MagicDamage, 6, 0, ap(0.1), amplify(Lv, 1))
                .variable(2, Radius, 182.5)
                .variable(1, IgnoreUnitCollision);
        Alistar.Q.update()
                .active("{4}の敵ユニットに{1}を与え、{2}後に{3}を与える。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, Knockup, 1)
                .variable(3, Stun, 0.5, 0)
                .variable(4, Radius, 365)
                .cd(17, -1)
                .mana(65, 5);
        Alistar.W.update()
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。")
                .variable(1, MagicDamage, 55, 55, ap(0.7))
                .variable(2, Knockback, 650)
                .cd(14, -1)
                .mana(65, 5)
                .range(650);
        Alistar.E.update()
                .active("{1}する。{3}の味方ユニットは{2}する。近くの敵ユニットが死ぬと{4}する。")
                .variable(1, RestoreHealth, 60, 30, ap(0.2))
                .variable(2, RestoreHealth, 30, 15, ap(0.1))
                .variable(3, Radius, 575)
                .variable(4, CDDecrease, 2)
                .cd(12, 0)
                .mana(40, 10);
        Alistar.R.update()
                .active("7秒間Alistarは{1}を得て、{2}する。Disable中でも使用可能。使用時に自身にかかっているCCを全て解除する。")
                .variable(1, AD, 60, 15)
                .variable(2, DamageReductionRatio, 70)
                .cd(120, -20)
                .mana(100, 0);
    }

    private static void Amumu() {
        Amumu.P.update().passive("通常攻撃した対象に3秒間{1}を与える。").variable(1, MRReduction, new Per6Level(15, 5));
        Amumu.Q.update()
                .active("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。")
                .variable(1, MagicDamage, 80, 60, ap(0.7))
                .variable(2, Stun, 1)
                .mana(80, 10)
                .cd(16, -2)
                .range(1100);
        Amumu.Q.update(P303).variable(1, MagicDamage, 80, 50, ap(0.7));
        Amumu.W.update()
                .active("毎秒、{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 8, 4, amplify(TargetMaxHealthRatio, 1, 0.5, ap(0.01)))
                .variable(2, Radius, 350)
                .mana(8)
                .cd(1)
                .type(SkillType.Toggle);
        Amumu.E.update()
                .passive("{1}する。")
                .variable(1, PhysicalDamageReduction, 2, 2)
                .active("{3}の敵ユニットに{2}を与える。Amumuが通常攻撃でダメージを受けるたびに{4}。")
                .variable(2, MagicDamage, 75, 25, ap(0.5))
                .variable(3, Radius, 400)
                .variable(4, CDDecrease, 0.5)
                .mana(35)
                .cd(10, -1);
        Amumu.R.update()
                .active("{2}の敵ユニットに{1}を与え、2秒間通常攻撃と移動を封じる。")
                .variable(1, MagicDamage, 150, 100, ap(0.8))
                .variable(2, Radius, 600)
                .mana(100, 50)
                .cd(150, -20)
                .update(P303)
                .variable(2, Radius, 550);
    }

    private static void Anivia() {
        Anivia.P.update()
                .passive("死亡時に卵になり6秒かけて復活する。復活中は{1}及び{2}を得る。復活中にHPが0になった場合は死亡する。{3}。")
                .variable(-1, AR, new Per4Level(-40, 15))
                .variable(-2, MR, new Per4Level(-40, 15))
                .variable(3, CDRUnaware)
                .cd(-240);
        Anivia.Q.update()
                .active("指定方向に貫通する氷を飛ばし、氷に触れた敵ユニットに{1}と3秒間{2}を与え、{4}状態にする。氷が飛んでいる最中に再度スキルを使用するか、最大距離まで飛ぶと氷が破裂し、破裂地点の{6}の敵ユニットにさらに{1}と{5}と3秒間{2}を与え、{4}状態にする。")
                .variable(1, MagicDamage, 60, 30, ap(0.5))
                .variable(2, MSSlowRatio, 20)
                .variable(4, Chill, 0)
                .variable(5, Stun, 1)
                .variable(6, Radius, 150)
                .mana(80, 20)
                .cd(12, -1)
                .range(1100)
                .update(P401)
                .mana(80, 10);
        Anivia.W.update()
                .active("指定地点に5秒間{1}の壁を作りユニットを通れなくする。また、指定地点の{2}。")
                .variable(1, Length, 400, 100)
                .variable(2, Visionable)
                .mana(70, 20)
                .cd(25)
                .range(1000)
                .update(P401)
                .mana(70);
        Anivia.E.update()
                .active("対象の敵ユニットに{1}を与える。対象が" + Chill + "の場合は{2}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MagicDamage, 110, 60, ap(1.0))
                .mana(50, 10)
                .cd(5)
                .range(650);
        Anivia.R.update()
                .active("指定地点の{6}の敵ユニットに毎秒{1}、1秒間の{2}と{3}を与え、{5}状態にする。")
                .variable(1, MagicDamage, 80, 40, ap(0.25))
                .variable(2, ASSlowRatio, 20, 0)
                .variable(3, MSSlowRatio, 20)
                .variable(5, Chill, 0)
                .variable(6, Radius, 300)
                .mana(75)
                .cd(6)
                .range(625)
                .type(SkillType.Toggle);
    }

    private static void Annie() {
        Annie.P.update()
                .passive("スキルを使用するたびにスタックが1貯まり、4スタック時に" + Annie.E + "以外のスキルを使用すると、スタックを全て消費してそのスキルに{1}が追加される。")
                .variable(1, Stun, 1.75)
                .update(P401)
                .variable(1, Stun, new Per5Level3Times(1.25, 0.25));
        Annie.Q.update()
                .active("対象の敵ユニットに{1}を与える。このスキルでLHを取ると{2}する。")
                .variable(1, MagicDamage, 85, 40, ap(0.7))
                .variable(2, RestoreMana, 60, 5)
                .mana(60, 5)
                .cd(4)
                .range(625);
        Annie.W.update()
                .active("指定方向扇形45°の{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 625)
                .variable(2, MagicDamage, 80, 50, ap(0.75))
                .mana(70, 10)
                .cd(8);
        Annie.E.update()
                .active("{1}間{2}と{3}を得て、効果時間中に通常攻撃をしてきた敵ユニットに{4}を与える。")
                .variable(1, Time, 5)
                .variable(2, AR, 20, 10)
                .variable(3, MR, 20, 10)
                .variable(4, MagicDamage, 20, 10, ap(0.2))
                .mana(20)
                .cd(10);
        Annie.R.update()
                .active("指定地点の{1}の敵ユニットに{2}を与え、操作可能なTibbersを召喚する。Tibbersは{3}間持続し、{4}の敵ユニットに毎秒{5}を与える。TibbersはALT押しながら右クリックで任意の操作が可能で以下のステータスを持つ。<br>Health : {6}<br>通常攻撃 : {7}<br>AR : {8}<br>MR : {9}<br>MS : {10}")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 200, 125, ap(0.7))
                .variable(3, Time, 45, 0)
                .variable(4, Radius, 200)
                .variable(5, MagicDamage, 35, 0, ap(0.2))
                .variable(6, Value, 1200, 400)
                .variable(7, MagicDamage, 80, 25)
                .variable(8, Value, 30, 20)
                .variable(9, Value, 25, 20)
                .variable(10, Value, 350)
                .mana(125, 50)
                .cd(120)
                .range(600)
                .update(P308)
                .variable(6, Value, 1200, 900)
                .variable(9, Value, 30, 20)
                .mana(100)
                .update(P401)
                .cd(120, -20);
    }

    private static void Ashe() {
        Ashe.P.update().passive("3秒毎に{1}する(最大100%)。通常攻撃を行うとリセットされる。").variable(-1, Critical, new Per3Level(3, 3));
        Ashe.P.update(P308)
                .passive("3秒間通常攻撃を行わないと毎秒{1}増加していく(最大100)。スタックが100の時、建物以外に通常攻撃を行うと、スタックをすべて消費して通常攻撃がクリティカルになり、スタックの値がクリティカル率と同じ値となる。")
                .variable(1, Stack, new Per5LevelForAshe(3, 1));
        Ashe.P.update(P310).variable(1, Stack, new Per5LevelForAshe(4, 1));
        Ashe.Q.update()
                .active("通常攻撃に2秒間の{1}を付与する。")
                .variable(1, MSSlowRatio, 15, 5)
                .mana(8)
                .type(SkillType.ToggleForAttack);
        Ashe.W.update()
                .active("指定方向扇形57.5°の方向に非貫通の矢7本を飛ばし当たった敵ユニットに{1}と{2}(" + Ashe.Q + "のLvに依存)を与える。" + Ashe.Q + "を覚えていない場合はスローは発生しない。")
                .variable(1, PhysicalDamage, 40, 10, ad(1))
                .variable(2, MSSlowRatio, 0)
                .mana(60)
                .cd(16, -3)
                .range(1200);
        Ashe.E.update()
                .passive("敵を倒した際に追加で{1}を得る。")
                .variable(1, Gold, 1, 1)
                .active("指定地点に偵察鷹を放つ。鷹は5秒間指定した地点の{2}。また飛行中の鷹も{2}。")
                .variable(2, Visionable)
                .cd(60)
                .range(2500, 750)
                .update(P402)
                .cd(60, -5)
                .variable(1, Gold, 3);
        Ashe.R.update()
                .active("指定方向に敵Championにのみ当たる矢を飛ばし、当たった敵Championに{1}と{2}(飛距離に比例して１～3.5秒)と3秒間の{4}を与える。また敵Champion命中時に矢が爆発し、{5}の敵ユニットに{6}と3秒間の{4}を与える。飛行中の矢は{3}。")
                .variable(1, MagicDamage, 250, 175, ap(1))
                .variable(2, Stun, 0)
                .variable(3, Visionable)
                .variable(4, MSSlowRatio, 50)
                .variable(5, Radius, 250)
                .variable(6, MagicDamage, 125, 87.5, ap(0.5))
                .mana(150)
                .cd(100, -10)
                .range(-1);
        Ashe.R.update(P313).mana(100);
    }

    private static void Blitzcrank() {
        Blitzcrank.P.update()
                .passive(" HPが20%以下になると、10秒間持続する{1}を張る。")
                .variable(1, Shield, 0, 0, amplify(CurrentManaRatio, 50))
                .cd(90);
        Blitzcrank.Q.update()
                .active("指定方向に腕を飛ばし、当たった敵ユニットに{1}と{2}を与え自分の位置まで引き寄せる。またこのスキル命中時に対象の{3}。")
                .variable(1, MagicDamage, 80, 55, ap(1))
                .variable(2, Stun, 1)
                .variable(3, Visionable)
                .mana(120)
                .cd(20, -1)
                .range(925);
        Blitzcrank.W.update()
                .active("8秒間{1}、{2}する。")
                .variable(1, MSRatio, 16, 4)
                .variable(2, ASRatio, 30, 8)
                .mana(75)
                .cd(15);
        Blitzcrank.E.update()
                .active("次の通常攻撃に追加{1}を付与し、対象に{2}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1))
                .variable(2, Knockup, 1, 0)
                .mana(25)
                .cd(9, -1);
        Blitzcrank.R.update()
                .passive("{1}の敵ユニット1体(対象はランダム)に2.5秒ごとに{2}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 100, 100, ap(0.25))
                .active("{3}の敵ユニットに{4}と{5}を与える。効果後はCDが解消されるまでPassiveの効果がなくなる。")
                .variable(3, Radius, 600)
                .variable(4, MagicDamage, 250, 125, ap(1))
                .variable(5, Silence, 0.5)
                .mana(150)
                .cd(30);
    }

    private static void Caitlyn() {
        Caitlyn.P.update()
                .passive("通常攻撃{1}回毎にダメージが増加する(Minionには250%、Championには150%)。茂みから通常攻撃を行うと2回分としてカウントされる。")
                .variable(1, Count, new Per6Level(8, -1));
        Caitlyn.P.update(P307)
                .passive("通常攻撃{1}回毎にダメージが増加する(Minionには250%、Championには150%、建物への攻撃は無効)。茂みから通常攻撃を行うと2回分としてカウントされる。");
        Caitlyn.Q.update()
                .active("1秒詠唱後、指定方向に貫通する弾を発射し当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%減少していき最小で{2}を与える。")
                .variable(1, PhysicalDamage, 20, 40, ad(1.3))
                .variable(2, PhysicalDamage, 10, 20, ad(0.65))
                .mana(50, 10)
                .cd(10, -1)
                .range(1250);
        Caitlyn.W.update()
                .active("指定地点に罠を仕掛ける。敵Championが罠の{4}に入ると発動して、対象に{1}かけて{2}と{3}を与え、9秒間対象の{5}。罠は3個まで置け、4分間持続する。")
                .variable(1, Time, 1.5)
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Snare, 1.5)
                .variable(4, Radius, 135)
                .variable(5, Visionable)
                .mana(50)
                .cd(20, -3)
                .range(800);
        Caitlyn.E.update()
                .active("指定方向にネットを飛ばし当たった敵ユニットに{1}と{3}間{2}を与え、Caitlynはネットを飛ばした方向の反対側にジャンプ({4})する。")
                .variable(1, MagicDamage, 80, 50, ap(0.8))
                .variable(2, MSSlowRatio, 50)
                .variable(3, Time, 1, 0.25)
                .variable(4, Distance, 400)
                .mana(75)
                .cd(18, -2)
                .range(850);
        Caitlyn.R.update()
                .active("0.5秒詠唱後に対象の敵Championの視界を得て、更に1秒詠唱後対象に目掛けて敵Championにのみ当たる弾を発射し、当たった敵Championに{1}を与える。ターゲットとの射線を遮ると間に入った敵Championに当たる。")
                .variable(1, PhysicalDamage, 250, 225, bounusAD(2))
                .mana(100)
                .cd(90, -15)
                .range(2000, 500);
    }

    private static void Cassiopeia() {
        Cassiopeia.P.update().passive("スキル使用後の5秒間、全てのスキルのコストが1スタックにつき10%低減する。");
        Cassiopeia.Q.update()
                .active("指定地点に0.5秒後に毒を発生させ、{1}の敵ユニットに毒を与え3秒かけて{2}を与える。このスキルがChampionにヒットした場合、3秒間{3}する。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 75, 40, ap(0.8))
                .variable(3, MSRatio, 15, 2.5)
                .mana(35, 10)
                .cd(3)
                .range(850);
        Cassiopeia.W.update()
                .active("指定地点に7秒間持続する毒霧を吹き出す。毒霧は徐々に範囲(100～175)が広がり、毒霧の上を通過した敵に2秒間持続する毒を付与し{1}と2秒間{3}を与える。また指定地点の{4}。")
                .variable(1, MagicDamage, 25, 10, ap(0.15))
                .variable(3, MSSlowRatio, 15, 5)
                .variable(4, Visionable)
                .mana(70, 10)
                .cd(9)
                .range(850);
        Cassiopeia.E.update()
                .active("対象の敵ユニットに{1}を与える。対象が毒を受けている場合、CDが0.5秒になる。")
                .variable(1, MagicDamage, 50, 35, ap(0.55))
                .mana(50, 10)
                .cd(5)
                .range(700);
        Cassiopeia.R.update()
                .active("眼からビームを放ち、指定方向扇形83°の範囲内の敵ユニットに{1}を与え、こちらを向いている敵に更に{2}を与える。後ろを向いていた場合2秒間{4}を与える。")
                .variable(1, MagicDamage, 200, 125, ap(0.6))
                .variable(2, Stun, 2)
                .variable(4, MSSlowRatio, 60)
                .mana(120, 40)
                .cd(130, -10)
                .range(750);
        Cassiopeia.R.update(P312).mana(100);
    }

    private static void ChoGath() {
        Chogath.P.update()
                .passive("敵ユニットを倒すと{1}、{2}する。")
                .variable(1, RestoreHealth, 17, 0, amplify(Lv, 3))
                .variable(2, RestoreMana, 3.25, 0, amplify(Lv, 0.25));
        Chogath.Q.update()
                .active("指定地点に0.5秒後にトゲを出現させ、{1}の敵ユニットに{2}、{3}を与えて、3秒間{5}にする。また指定地点の視界を得る。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(3, Knockup, 1)
                .variable(5, MSSlowRatio, 60)
                .mana(90)
                .cd(9)
                .range(950);
        Chogath.W.update()
                .active("前方扇形60°の領域の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 50, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 10)
                .cd(13)
                .range(700);
        Chogath.E.update()
                .active("通常攻撃時に前方にトゲを飛ばし当たった敵ユニットに{1}を与える。トゲを飛ばす範囲はUltのスタック数に比例し増加する。")
                .variable(1, MagicDamage, 20, 15, ap(0.3))
                .cd(0.5)
                .range(500)
                .type(SkillType.Toggle);
        Chogath.R.update()
                .active("対象の敵ユニットに{1}を与える。対象がChampion以外の場合は{2}を与える。このスキルで敵を倒すとスタックが1増えて{3}と{4}を得る。死亡するとスタックが半分(端数切り上げ)消失する。")
                .variable(1, TrueDamage, 300, 175, ap(0.7))
                .variable(2, TrueDamage, 1000, 0, ap(0.7))
                .variable(3, Health, 0, 0, amplify(Stack, 90, 30))
                .variable(4, Range, 0, 0, amplify(Stack, 4, 2.15))
                .mana(100)
                .cd(60)
                .range(150);
    }

    private static void Corki() {
        Corki.P.update().passive("通常攻撃に{1}が付与される。建物には無効。").variable(1, TrueDamage, 0, 0, ad(0.1));
        Corki.Q.update()
                .active("指定した{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。また、Championに当たった場合、6秒間そのChampionの{3}。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .variable(3, Visionable)
                .mana(80, 10)
                .cd(8)
                .range(600)
                .update(P314)
                .active("指定地点に爆弾を発射し、着弾時に{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。爆弾にも視界がある。また、Championに当たった場合、6秒間そのChampionの{3}。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .mana(60, 10)
                .range(825)
                .update(P403)
                .variable(2, MagicDamage, 80, 50, ap(0.5), bounusAD(0.5));

        Corki.W.update()
                .active("指定地点まで高速で移動し、通過地点を2.5秒間炎上させる。炎上地点の上にいる敵ユニットに毎秒{2}を与える。")
                .variable(2, MagicDamage, 60, 30, ap(0.4))
                .mana(100)
                .cd(26, -3)
                .range(800);
        Corki.W.update(P309).mana(50);
        Corki.E.update()
                .active("4秒間、Corkiの前方にいる敵ユニットに0.5秒毎に{1}を与える(最大8hit)。ダメージを与える度に対象ユニットに{2}を与える。この効果は2秒間持続し、8回までスタックする。")
                .variable(1, PhysicalDamage, 10, 6, bounusAD(0.02))
                .variable(2, ARReduction, 1, 1)
                .mana(60, 5)
                .cd(16)
                .range(600);
        Corki.E.update(P314).mana(50);
        Corki.R.update()
                .active("スタックを消費して、指定方向にミサイルを発射し当たった敵ユニットの{1}に{2}を与える。スタックは{3}毎に増加する（最大数7）。4発毎に大きいミサイルを発射する({4}に{5})。スタック増加時間はCD低減の影響を受ける。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 120, 70, ap(0.3), ad(0.2))
                .variable(3, CDRAwareTime, 12)
                .variable(4, Radius, 300)
                .variable(5, MagicDamage, 180, 105, ap(0.45), ad(0.3))
                .mana(30, 5)
                .cd(1.2)
                .range(1225);
        Corki.R.update(P305)
                .active("スタックを消費して、指定方向にミサイルを発射し当たった敵ユニットの{1}に{2}を与える。スタックは{3}毎に増加する（最大数7）。3発毎に大きいミサイル({4}に{5})を発射させる。スタック増加時間はCD低減の影響を受ける。")
                .variable(3, CDRAwareTime, 12, -2);
        Corki.R.update(P309).mana(20);
        Corki.R.update(P313).variable(2, MagicDamage, 100, 80, ap(0.3), ad(0.02)).cd(-2);
        Corki.R.update(P314)
                .variable(2, MagicDamage, 120, 70, ap(0.3), amplify(AD, 0.2, 0.1))
                .variable(5, MagicDamage, 180, 105, ap(0.45), amplify(AD, 0.3, 0.15));
    }

    private static void Brand() {
        Brand.P.update()
                .passive("スキルが当たった敵ユニットを炎上させ、毎秒{1}与える。この効果は4秒間続く。炎上している敵ユニットにスキルが命中すると追加効果が発生する。(Minionに対しては毎秒80DMが上限)")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2));
        Brand.Q.update()
                .active("指定方向に火球を投射し、当たった敵ユニットに{1}を与える。敵が炎上していた場合、{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.65))
                .variable(2, Stun, 2)
                .mana(50)
                .cd(8, -0.5)
                .range(1025);
        Brand.W.update()
                .active("指定地点に炎の柱を作り出し、0.5秒後に{1}の敵ユニットに{2}を与える。敵が炎上していた場合、代わりに{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 75, 45, ap(0.6))
                .variable(3, MagicDamage, 94, 56, ap(0.75))
                .mana(70, 10)
                .cd(10)
                .range(900);
        Brand.W.update(P309).mana(70, 5);
        Brand.E.update()
                .active("対象の敵ユニットに{1}を与える。敵が炎上していた場合、{2}の敵にも{1}を与える。")
                .variable(1, MagicDamage, 70, 35, ap(0.55))
                .variable(2, Radius, 200)
                .mana(60, 5)
                .cd(12, -1)
                .range(625);
        Brand.E.update(P309).mana(70, 5);
        Brand.R.update()
                .active("対象の敵ユニットに火炎弾を放つ。火炎弾は近くの敵ユニットに4回まで跳ね、その度に{1}を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。敵が炎上していた場合、敵Championに優先して跳ね返るようになる。")
                .variable(1, MagicDamage, 150, 100, ap(0.5))
                .mana(100, 50)
                .cd(105, -15)
                .range(750);
        Brand.R.update(P309).mana(100);
    }

    private static void Diana() {
        Diana.P.update()
                .passive("{1}する。通常攻撃3回毎に周囲にいる敵ユニットに{2}を与える。")
                .variable(1, ASRatio, 20)
                .variable(2, MagicDamage, new Per1Level(new double[] {20, 25, 30, 40, 50, 65, 80, 95, 110, 125, 140,
                        155, 175, 195, 215, 240, 265, 290}));
        Diana.P.update(P307).variable(2, MagicDamage, new Per1Level(new double[] {20, 25, 30, 35, 40, 50, 60, 70, 80,
                90, 105, 120, 135, 155, 175, 200, 225, 250}));
        Diana.Q.update()
                .active("指定地点に弧を描くエネルギーを放ち、当たった敵ユニットと{2}のユニットに{1}とMoonlight(3秒)を与える。またMoonlightが付与されている敵ユニットの{3}。")
                .variable(1, MagicDamage, 60, 35, ap(0.7))
                .variable(2, Radius, 50)
                .variable(3, Visionable)
                .mana(55)
                .cd(10, -1)
                .range(830);
        Diana.W.update()
                .active("5秒間{1}を張ると同時に、Dianaの周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発すると{1}が張りなおされる。")
                .variable(1, Shield, 55, 25, ap(0.45))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 20, 14, ap(0.2))
                .mana(60, 10)
                .cd(10);
        Diana.W.update(P307)
                .active("5秒間{1}を張ると同時に、Dianaの周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発すると{1}が追加される。")
                .variable(1, Shield, 40, 15, ap(0.3))
                .variable(3, MagicDamage, 22, 12, ap(0.2));
        Diana.E.update()
                .active("{1}にいるすべての敵ユニットをDianaがいる方向に引き寄せた後、2秒間{3}を与える。")
                .variable(1, Radius, 500)
                .variable(3, MSSlowRatio, 35, 5)
                .mana(70)
                .cd(26, -2);
        Diana.R.update()
                .active("対象の敵ユニットの元までテレポートし、{1}を与える。対象にMoonlightが付与されていた場合、すべての敵ユニットに付与されたMoonlightを消費してこのスキルの{2}する。")
                .variable(1, MagicDamage, 100, 60, ap(0.6))
                .variable(2, CDDecrease)
                .mana(50, 15)
                .cd(25, -5)
                .range(825);
    }

    private static void Darius() {
        Darius.P.update()
                .passive("通常攻撃またはスキルでダメージを与えた敵ユニットに出血スタックを付与する。出血スタックが付与された敵ユニットは毎秒{1}を受ける。出血スタックは最大5回までスタックし、5秒間持続する。また、出血スタックを受けている敵Champion数に応じて{2}していく。")
                .variable(1, MagicDamage, 2.4, 0, amplify(Lv, 0.3), bounusAD(0.06))
                .variable(-2, MSRatio, 5);
        Darius.Q.update()
                .active("斧を振り回し{3}の敵ユニットに{1}を与える。斧の刃に当たった敵Championに対しては{2}を与える。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.7))
                .variable(2, PhysicalDamage, 105, 52.5, bounusAD(1.05))
                .variable(3, Radius, 425)
                .mana(40)
                .cd(9, -1);
        Darius.W.update()
                .active("次の通常攻撃に{1}を追加し、2秒間{3}と{4}が付与される。対象の出血スタック数1個につき、このスキルの{5}する。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.2))
                .variable(3, ASSlowRatio, 20, 5)
                .variable(4, MSSlowRatio, 20, 5)
                .variable(5, CDDecrease, 1)
                .mana(30, 5)
                .cd(8);
        Darius.E.update()
                .passive("{1}を得る。")
                .variable(1, ARPenRatio, 5, 5)
                .active("前方範囲内の敵ユニットをDariusがいる方向に引き寄せる。")
                .mana(45)
                .cd(24, -3)
                .range(550);
        Darius.R.update()
                .active("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、{3}する。")
                .variable(1, TrueDamage, 160, 90, bounusAD(0.75))
                .variable(3, CDDecrease)
                .mana(100)
                .cd(100, -10)
                .range(475)
                .update(P303)
                .active("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、{4}間再使用することが出来る。この効果はキルを取るたびに適用される。")
                .variable(4, Time, 12)
                .cd(120, -20)
                .update(P401)
                .variable(4, Time, 20);
    }

    private static void Draven() {
        Draven.P.update()
                .passive("クリティカル時または" + Draven.Q + "使用時の通常攻撃に毎秒{1}が付与される。毎秒ダメージは4秒間持続する。")
                .variable(1, PhysicalDamage, 7.5, 0, amplify(Lv, 1));
        Draven.P.update(P309)
                .passive("Spinning Axeをキャッチするか、ミニオンかモンスターを倒すと、スタックを得る。敵Championを倒すと、スタックの半分を消費して{1}を得る。死亡時にスタックを半分失う。")
                .variable(1, Gold, 0, 0, amplify(ConsumedStack, 3));
        Draven.P.update(P311)
                .passive("Spinning Axeをキャッチするか、ミニオンかモンスターを倒すと、スタックを得る。敵Championを倒すと、スタックを消費して{1}を得る。死亡時にスタックを半分失う。")
                .variable(1, Gold, 50, 0, amplify(ConsumedStack, 2));
        Draven.Q.update()
                .active("次に行う通常攻撃に追加{1}が付与される。このスキルによる通常攻撃が敵ユニットに命中すると、斧がDravenの近くに跳ね返る。その斧をキャッチするとBlood RushのCDが解消され、更に次の通常攻撃もSpinning Axeの効果を受けるようになる。このスキルは連続で使用する事で最大2回分までチャージできる。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.45, 0.1))
                .mana(45)
                .cd(12, -1);
        Draven.W.update()
                .active("1.5秒間{1}し、3秒間{2}する。移動速度増加は1.5秒かけて元に戻る。")
                .variable(1, MSRatio, 40, 5)
                .variable(2, ASRatio, 20, 5)
                .mana(40)
                .cd(12);
        Draven.E.update()
                .active("指定方向に貫通する斧を投げ、当たった敵ユニットに{1}と{2}と2秒間{3}を与える。このノックバックは斧から弾かれる形で左右に吹き飛ぶ。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.5))
                .variable(2, Knockback, 0)
                .variable(3, MSSlowRatio, 20, 5)
                .mana(70)
                .cd(18, -1)
                .range(1050);
        Draven.R.update()
                .active("指定方向に地面を這う貫通する斧を投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに8%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定があり、斧が飛んでいる最中に再度このスキルを使用するか、敵Championに命中した時点で斧が反転してDravenの元に戻ってくる。反転した際、低下ダメージはリセットされる。また移動中の斧は{2}。")
                .variable(1, PhysicalDamage, 175, 100, bounusAD(1.1))
                .variable(2, Visionable)
                .mana(120)
                .cd(110)
                .range(-1);
    }

    private static void DrMundo() {
        DrMundo.P.update().passive("毎秒{1}する。").variable(1, RestoreHealth, 0, 0, amplify(Health, 0.003));
        DrMundo.Q.update()
                .active("指定方向に包丁を投げ（{7}）、当たった敵ユニットに{1}と2秒間の{3}を与える。最小で{4}。ミニオンやモンスターへの最大DMは{5}。命中すると{6}する。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 15, 3))
                .variable(3, MSSlowRatio, 40)
                .variable(4, MagicDamage, 80, 50)
                .variable(5, MagicDamage, 300, 100)
                .variable(6, RestoreHealth, 25, 5)
                .variable(7, MissileWidth, 80)
                .cost(Health, 50, 10)
                .cd(4)
                .range(1000)
                .update(P402)
                .variable(7, MissileWidth, 60);
        DrMundo.W.update()
                .active("{1}の敵ユニットに毎秒{2}を与える。また{3}を得る。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 35, 15, ap(0.2))
                .variable(3, Tenacity, 10, 5)
                .cost(Health, 10, 5)
                .cd(4)
                .type(SkillType.Toggle);
        DrMundo.E.update()
                .active("5秒間{1}を得る。")
                .variable(1, AD, 40, 15, amplify(MissingHealthPercentage, 0.4, 0.15))
                .cost(Health, 35, 10)
                .cd(7);
        DrMundo.R.update()
                .active("12秒かけて{1}し、{2}する。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.4, 0.15))
                .variable(2, MSRatio, 15, 10)
                .cd(75)
                .cost(CurrentHealthRatio, 20, 0);
    }

    private static void Evelynn() {
        Evelynn.P.update()
                .passive("Evelynnが{2}状態になる。スキルを使うか、ダメージを受けるか与えるかすると、6秒間ステルスが解除された状態になる。敵Championに範囲700まで近づくとステルス状態でも敵Championに視認されるようになる。また、ステルス中は毎秒{1}していく。")
                .variable(1, RestoreMana, 0, 0, amplify(Mana, 0.01))
                .variable(2, Stealth);
        Evelynn.Q.update()
                .active("視界内にいる最も近くにいる敵ユニット1体に向けて棘を放ち({2})、直線状にいる敵ユニットに{1}を与える。Evelynnが敵ユニットをターゲットしている場合は、その対象に向けて棘が放たれる。")
                .variable(1, MagicDamage, 40, 20, ap(0.45), bounusAD(0.5))
                .variable(2, MissileSpeed, 2000)
                .mana(16, 6)
                .cd(1.5)
                .range(400)
                .update(P401)
                .variable(2, MissileSpeed, 1250)
                .update(P402)
                .variable(2, MissileSpeed, 2000);
        Evelynn.W.update()
                .passive("敵Championにスキルを当てるたびに{1}する。この効果は3秒間持続し、最大4スタックする。")
                .variable(-1, MS, 4, 4)
                .active("3秒間{2}して、{3}と{4}を得る。敵Championキル/アシスト時に、このスキルの{5}する。")
                .variable(2, MSRatio, 30, 10)
                .variable(3, IgnoreSlow)
                .variable(4, IgnoreUnitCollision)
                .variable(5, CDDecrease)
                .cd(15);
        Evelynn.E.update()
                .active("対象の敵ユニットに2回連続で{1}を与え、3秒間{2}する。")
                .variable(1, MagicDamage, 35, 20, ap(0.5), bounusAD(0.5))
                .variable(2, ASRatio, 60, 15)
                .mana(50, 5)
                .cd(9)
                .range(225)
                .update(P401)
                .variable(1, PhysicalDamage, 35, 20, ap(0.5), bounusAD(0.5));
        Evelynn.R.update()
                .active("指定{1}の敵ユニットに{2}と2秒間の{3}を与え、0.5秒後にこのスキルを命中させた敵Champion毎に6秒間持続する{4}を得る。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 15, 5, ap(0.01)))
                .variable(3, MSSlowRatio, 30, 20)
                .variable(4, Shield, 150, 75)
                .mana(100)
                .cd(150, -30)
                .range(650)
                .update(P401)
                .active("指定{1}の敵ユニットに{2}と2秒間の{3}を与え、このスキルを命中させた敵Champion毎に6秒間持続する{4}を得る。");
    }

    private static void Elise() {
        Elise.P.update()
                .passive("Human Form時に使用したスキルが敵ユニットに命中するとSpiderlingのチャージを1得る。Spider Formになるとチャージ数に比例したSpiderlingを召喚する。召喚される数はSpider Formのレベルに比例し増加する。召喚されたSpiderlingは死亡するとチャージが減るが、再度Human Formに戻ると再度チャージ状態に戻る。<br>Health: {1}<br>AD: {2}<br>AS: 0.665<br>AR: {3}<br>MR: {4}<br>MS: 370<br>AoEスキルのダメージを{5}低減")
                .variable(1, Value, 100, 0, amplify(Lv, 25))
                .variable(2, Value, new Refer(Elise.R, 10, 10), ap(0.1), null)
                .variable(3, Value, 30)
                .variable(4, Value, 50)
                .variable(5, Percentage, 25);
        Elise.P.update(P310)
                .variable(1, Value, 80, 0, amplify(Lv, 10))
                .variable(3, Value, new Refer(Elise.R, 30, 20))
                .variable(4, Value, new Refer(Elise.R, 50, 20))
                .variable(5, Percentage, new Refer(Elise.R, 10, 10));
        Elise.Q.update()
                .active("対象の敵ユニットに毒を放ち{1}を与える。")
                .variable(1, MagicDamage, 40, 35, amplify(Status.TargetCurrentHealthRatio, 8, 0, ap(0.03)))
                .mana(80, 5)
                .cd(6)
                .range(625);
        Elise.W.update()
                .active("指定地点に蜘蛛を放つ。蜘蛛は敵ユニットに当たるか3秒間経過すると爆発し、範囲内の敵ユニットに{1}を与える。蜘蛛は指定地点に移動した後、最も近くにいる敵ユニットに向かって移動する。また{2}。")
                .variable(1, MagicDamage, 75, 50, ap(0.8))
                .variable(2, Visionable)
                .mana(60, 10)
                .cd(12)
                .range(950);
        Elise.E.update()
                .active("指定方向に糸を飛ばし当たった敵ユニットに{1}を与え、{2}。")
                .variable(1, Stun, 1.5)
                .variable(2, Visionable)
                .mana(50)
                .cd(14, -1)
                .range(1075);
        Elise.R.update()
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{2}と{3}を得て、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, AR, 10, 5)
                .variable(3, MR, 10, 5)
                .variable(4, MS, 10)
                .cd(4);
        Elise.R.update(P307)
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。");
        Elise.R.update(P309)
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。{5}。")
                .variable(5, NotSpellCast);
        EliseSpider.Q.update()
                .active("対象の敵ユニットに飛びつき{1}を与える。")
                .variable(1, MagicDamage, 50, 45, amplify(TargetMissingHealthRatio, 8, 0, ap(0.03)))
                .cd(6)
                .range(475);
        EliseSpider.Q.update(P304).variable(1, MagicDamage, 60, 50, amplify(TargetMissingHealthRatio, 8, 0, ap(0.03)));
        EliseSpider.W.update()
                .passive("Spiderlingの{1}する。")
                .variable(1, ASRatio, 5, 5)
                .active("3秒間EliseとSpiderlingの{2}する。また、その間Spiderlingが攻撃を行うたびにEliseの{3}する。")
                .variable(2, ASRatio, 60, 20)
                .variable(3, RestoreHealth, 4, 0, ap(0.02))
                .cd(12);
        EliseSpider.W.update(P307).variable(3, RestoreHealth, 4, 0, ap(0.04));
        EliseSpider.E.update()
                .active("EliseとSpiderlingが上空に退避し(ターゲット不可になる)指定の方法で降下する。上空にいる間は射程内の視界を得る地面をクリックした場合: 最大2秒間上空に待機し、初期位置へ降下する。この間、敵ユニットをターゲットし裏側に降下できる。敵ユニットをクリックした場合: 即座に下降し裏側に降り立つ。")
                .cd(26, -2)
                .range(1075);
        EliseSpider.R.update()
                .passive("通常攻撃に追加{1}が付与される。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .active("EliseがHuman Formに変身し射程550のRangedになる。")
                .cd(4);
        EliseSpider.R.update(P307).passive("通常攻撃に追加{1}が付与される。{2}。").variable(2, NotSpellCast);
    }

    private static void Ezreal() {
        Ezreal.P.update().passive("ユニット(敵味方問わず)にスキルを当てる度に5秒間{1}する。この効果は5回分までスタックする。").variable(-1, ASRatio, 10);
        Ezreal.Q.update()
                .active("指定方向に魔法の矢を飛ばし、当たった敵ユニットに{1}を与える。このスキルが命中すると、Ezrealのすべてのスキルの{2}。{3}")
                .variable(1, PhysicalDamage, 35, 20, ap(0.2), ad(1))
                .variable(2, CDDecrease, 1)
                .variable(3, OnHitEffect)
                .mana(28, 3)
                .cd(6, -0.5)
                .range(1150);
        Ezreal.W.update()
                .active("指定方向にChampionにのみ当たる貫通するエネルギーを飛ばし、当たった味方Championには5秒間{1}し、敵Championには{2}を与える。")
                .variable(1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .mana(50, 10)
                .cd(9)
                .range(1000);
        Ezreal.E.update()
                .active("指定地点にテレポートし、テレポート先から一番近い敵ユニット({1})1体に{2}を与える。")
                .variable(1, Radius, 750)
                .variable(2, MagicDamage, 75, 50, ap(0.75))
                .mana(90)
                .cd(19, -2)
                .range(475);
        Ezreal.R.update()
                .active("1秒詠唱後、指定方向に射程無限の貫通する魔法の矢を飛ばし当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%ずつ減り、最大で30%まで低下する。また飛行中の矢は{2}。")
                .variable(1, MagicDamage, 350, 150, ap(0.9), bounusAD(1))
                .variable(2, Visionable)
                .mana(100)
                .cd(80)
                .range(-1);
    }

    private static void Fiddlesticks() {
        FiddleSticks.P.update()
                .passive("{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 1000)
                .variable(2, Status.MRReduction, 10);

        FiddleSticks.Q.update()
                .active("対象の敵ユニットに{1}を与える。")
                .variable(1, Fear, 1, 0.5)
                .mana(65, 10)
                .cd(15, -1)
                .range(575)
                .update(P315)
                .variable(1, Fear, 1.25, 0.25)
                .mana(65);

        FiddleSticks.W.update()
                .active("対象の敵ユニットに最大5秒間毎秒{1}を与え、{2}する。敵が離れる({3})と詠唱が中断される。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 60, 5))
                .variable(3, Radius, 750)
                .mana(80, 10)
                .cd(10, -1)
                .range(475)
                .type(SkillType.Channel)
                .update(P403)
                .range(575);

        FiddleSticks.E.update()
                .active("対象の敵ユニットにカラスを飛ばし{1}と{2}を与える。カラスは{4}の敵ユニットに4回まで跳ね返りその度に効果を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。ミニオンとモンスターに対しては{3}を与える。")
                .variable(1, MagicDamage, 65, 20, ap(0.45))
                .variable(2, Silence, 1.2)
                .variable(3, MagicDamage, 97.5, 30, ap(0.675))
                .variable(4, Radius, 450)
                .mana(50, 20)
                .cd(15, -1)
                .range(750);

        FiddleSticks.R.update()
                .active("1.5秒詠唱後に指定地点にテレポートし、{1}の敵ユニットに5秒間毎秒{2}を与える。最大DMは{3}となる。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 125, 100, ap(0.45))
                .variable(3, MagicDamage, 625, 500, ap(2.25))
                .mana(150, 50)
                .cd(150, -10)
                .range(800)
                .type(SkillType.Channel)
                .update(P315)
                .mana(100);
    }

    private static void Fiora() {
        Fiora.P.update()
                .passive("通常攻撃またはLungeでダメージを与えると、6秒かけて{1}する。対象がChampionの場合、この効果は4回までスタックする。")
                .variable(1, RestoreHealth, 7, 0, amplify(Lv, 1));
        Fiora.Q.update()
                .active("対象の敵ユニットへダッシュし{1}を与える。このスキルは4秒の間、もう1度だけ使用できる。2度目は消費MN無しで使用可能。")
                .variable(1, PhysicalDamage, 40, 25, bounusAD(0.6))
                .mana(60)
                .cd(16, -2)
                .range(600);
        Fiora.W.update()
                .passive("{1}を得る。")
                .variable(1, AD, 15, 5)
                .active("1.5秒の間に受ける通常攻撃を一度だけ無効化し、その相手に{2}を与える。この効果は一部のミニオンとモンスターには発生しない。")
                .variable(2, MagicDamage, 60, 50, ap(1))
                .mana(45)
                .cd(10, -1);
        Fiora.E.update()
                .active("3秒間{1}する。効果中に通常攻撃を行うかまたはLungeを使用すると3秒間{2}する。移動速度の増加は3回までスタックする。敵Championを倒すとこのスキルの{3}する。")
                .variable(1, ASRatio, 60, 15)
                .variable(2, MSRatio, 7, 2)
                .variable(3, CDDecrease)
                .mana(55)
                .cd(15, -1);
        Fiora.R.update()
                .active("対象の敵Championにダッシュし{1}を与え、範囲内にいる敵Championをランダムに対象とし4回{1}を与える(合計5回)。最後の攻撃は最初に対象とした敵Championで固定。同一ユニットに複数回DMを与える場合、2回目以降は25%のダメージになる。単一対象への最大DMは{2}。{3}。")
                .variable(1, PhysicalDamage, 160, 170, bounusAD(1.15))
                .variable(2, PhysicalDamage, 320, 340, bounusAD(2.3))
                .variable(3, OnHitEffect)
                .mana(100)
                .cd(130, -10)
                .range(400);
    }

    private static void Fizz() {
        Fizz.P.update()
                .passive("{2}を得て、{1}する。この軽減は防御力計算より先に行われる。")
                .variable(1, AttackDamageReduction, new Per3Level(4, 2))
                .variable(2, IgnoreUnitCollision);
        Fizz.Q.update()
                .active("対象の敵ユニットに追加{1}が付与された通常攻撃を与え、その方向に駆け抜ける。移動距離は固定。{2}。")
                .variable(1, MagicDamage, 10, 30, ap(0.6))
                .variable(2, OnHitEffect)
                .mana(50, 5)
                .cd(10, -1)
                .range(550);
        Fizz.W.update()
                .passive("通常攻撃に{1}が付与される。このダメージは0.5秒毎に3秒間かけて与えられる。(Minionに対しては300DMが上限)")
                .variable(1, MagicDamage, 30, 10, ap(0.35), amplify(TargetMissingHealthRatio, 4, 1))
                .active("5秒間通常攻撃に{2}と{3}を付与する。このダメージはPassiveと重複する。")
                .variable(2, MagicDamage, 10, 5, ap(0.35))
                .variable(3, Wounds, 3)
                .mana(40)
                .cd(10);
        Fizz.W.update(P313).variable(2, MagicDamage, 10, 5, ap(0.15));
        Fizz.E.update()
                .active("指定地点にジャンプする。ジャンプ中はターゲットされない状態になる。0.75秒後にその場に降下し、{1}の敵ユニットに{2}と2秒間{3}を与える。また、ジャンプ中に再使用することで降下する場所を別の指定地点に変更しできる。その場合、{4}の敵ユニットに{5}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 50, ap(0.75))
                .variable(3, MSSlowRatio, 40, 5)
                .variable(4, Radius, 150)
                .variable(5, MagicDamage, 70, 50, ap(0.75))
                .mana(90, 10)
                .cd(16, -2)
                .range(400);
        Fizz.R.update()
                .active("指定地点に敵Championのみに命中する魚を投げ、命中した敵Championに魚がくっつき、{1}を与える。その1.5秒後に地面から鮫が現れ、魚が命中した対象を襲い、対象とその周囲({2})の敵ユニットに{3}を与え、{4}後に1.5秒間{5}を与える。魚がくっついていた敵Champion以外のユニットには{4}の代わりに{6}を与える。魚がChampionに当たらなかった場合は指定地点に魚が残り、その地点に鮫が現れる。また魚は視界を確保し、その上を敵Championが通り過ぎると、当たった場合と同様にその敵Championにくっつき、鮫が襲いかかる。")
                .variable(1, MSSlowRatio, 50, 10)
                .variable(2, Radius, 250)
                .variable(3, MagicDamage, 200, 125, ap(1))
                .variable(4, Knockup, 0)
                .variable(5, MSSlowRatio, 50, 10)
                .variable(6, Knockback, 0)
                .mana(100)
                .cd(100, -15)
                .range(1275);
    }

    private static void Gragas() {
        Gragas.P.update().passive("スキル使用後に4秒かけて{1}する。").variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02));
        Gragas.Q.update()
                .active("指定地点に樽を転がし、爆発時に{1}の敵ユニットに{2}と3秒間{3}を与える。樽は5秒経つか、スキルを再度使用すると爆発する。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 85, 50, ap(0.9))
                .variable(3, ASSlowRatio, 20, 5)
                .mana(80, 10)
                .cd(12, -1)
                .range(1100);
        Gragas.Q.update(P314).range(950);
        Gragas.W.update()
                .active("{1}する。さらに1秒詠唱後に20秒間{2}を得て、{3}するようになる。")
                .variable(1, RestoreMana, 30, 15)
                .variable(2, AD, 30, 10)
                .variable(3, DamageReductionRatio, 10, 2)
                .cd(25);
        Gragas.E.update()
                .active("指定方向に突進し、衝突した敵ユニットとその周囲にいる敵ユニットに{1}と2.5秒間{2}を与える。衝突時に突進は止まる。衝突地点に複数の敵ユニットがいた場合、{3}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.5), ad(0.66))
                .variable(2, MSSlowRatio, 35)
                .variable(3, MagicDamage, 50, 25, ap(0.5))
                .mana(75)
                .cd(7)
                .range(650)
                .update(P314)
                .active("指定方向に突進し、衝突した敵ユニットとその周囲にいる敵ユニットに{1}と2.5秒間{2}を与える。衝突時に突進は止まる。ユニットに当たった場合{3}する。")
                .variable(3, CDDecreaseRatio, 50)
                .cd(12)
                .update(P403)
                .variable(1, MagicDamage, 80, 40, ap(0.5), amplify(AD, 0.3, 0.1));

        Gragas.R.update()
                .active("指定地点に爆発する樽を投げ、{1}内の敵ユニットに{2}を与え、{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 200, 125, ap(1))
                .variable(3, Knockback, 800)
                .mana(100, 25)
                .cd(100, -10)
                .range(1050)
                .update(P403)
                .variable(2, MagicDamage, 200, 125, ap(0.9))
                .mana(100);
    }

    private static void Hecarim() {
        Hecarim.P.update()
                .passive("{2}と{1}を得る。")
                .variable(1, AD, 0, 0, amplify(BounusMS, new Per3LevelAdditional(0.1, 0.025)))
                .variable(2, IgnoreUnitCollision);
        Hecarim.Q.update()
                .active("武器を振り回し{2}の敵ユニットに{1}を与える。このスキルが敵ユニットに命中した場合、Hecarimは短時間の間1スタックを得て、1スタックにつきこのスキルの{4}する(最大2スタック)。スタックは6秒間増加がないと0になる。ミニオンやモンスターには{3}を与える。")
                .variable(1, PhysicalDamage, 50, 35, bounusAD(0.6))
                .variable(2, Radius, 200)
                .variable(3, PhysicalDamage, 18.5, 11.5, bounusAD(0.2))
                .variable(4, CDDecrease, 1)
                .mana(25)
                .cd(4)
                .update(P303)
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.6))
                .update(P309)
                .mana(24, 4);
        Hecarim.W.update()
                .active("4秒間{1}の敵ユニットに毎秒{2}を与える。この効果を受けている敵ユニットがダメージを受けた場合、そのダメージの値に応じて{3}する。")
                .variable(1, Radius, 575)
                .variable(2, MagicDamage, 20, 11.25, ap(0.2))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 10, 5))
                .mana(50, 10)
                .cd(14)
                .update(P303)
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 20, 0))
                .cd(20, -1.5)
                .update(P305)
                .cd(22, -1);
        Hecarim.E.update()
                .active("3秒間{1}して(最大75%)、その後1秒間その移動速度を維持する。また次の通常攻撃のダメージはこのスキルを使用してからHecarimが移動した距離に比例し最小で{3}、最大で{4}を与えるようになり、{2}が付与される。")
                .variable(1, MSRatio, 20, 0, amplify(Duration, 18.3))
                .variable(2, Knockback, 300)
                .variable(3, PhysicalDamage, 40, 35, bounusAD(0.5))
                .variable(4, PhysicalDamage, 80, 70, bounusAD(1))
                .mana(60)
                .cd(24, -2);
        Hecarim.R.update()
                .active("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに{1}を与える。指定した地点に到着すると衝撃波を放ち、{2}の敵ユニットに{3}と{4}を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。" + Terrified + "に陥ったユニットは強制的にHecarimから遠ざかるように移動する。この時、Hecarimとの距離に比例して移動速度が変化する。")
                .variable(1, MagicDamage, 100, 100, ap(0.8))
                .variable(2, Radius)
                .variable(3, MagicDamage, 50, 75, ap(0.4))
                .variable(4, Terrified, 1)
                .mana(100)
                .cd(140, -20)
                .range(1000)
                .update(P308)
                .active("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに{1}を与える。指定した地点に到着すると衝撃波を放ち、{2}の敵ユニットに{4}を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。" + Terrified + "に陥ったユニットは強制的にHecarimから遠ざかるように移動する。この時、Hecarimとの距離に比例して移動速度が変化する。")
                .variable(1, MagicDamage, 150, 100, ap(1));
    }

    private static void Heimerdinger() {
        Heimerdinger.P.update()
                .passive("{1}の味方ユニットとTurretは{2}を得る。")
                .variable(1, Radius, 800)
                .variable(2, Hreg, new Per5LevelForHeimer(10, 5));
        Heimerdinger.P.update(P313)
                .passive("{1}の味方ユニットとH-28G Evolution Turretは{2}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, Hreg, new Per4Level(10, 5));
        Heimerdinger.Q.update()
                .active("指定地点にTurretを設置する。使用時にスタックを消費する。設置後6秒間はTurretの攻撃速度が1.5倍になる。{1}毎にスタックが1つ増加し最大2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。Turretが塔に与えるダメージは半分になる。Debuff(CCのみ)を無効化、Heimerdingerが攻撃するor攻撃されている場合、その対象を優先で攻撃。Lv2.攻撃したユニットに{6}と{7}を与える。この効果は2秒間持続し、50回までスタックする。Lv3.Turretの最大スタック数と設置できる上限が2に増える。Lv4.Turretの最大HP+125。Lv5.50%のスプラッシュダメージが付与される。　<br>HP:{2}<br>ダメージ:{3}<br>射程:525<br>AR:{4}<br>MR:{5}<br>AS:1.25<br>視界:625")
                .variable(1, CDRAwareTime, 25)
                .variable(2, Count, 295, 0, amplify(Lv, 15))
                .variable(3, MagicDamage, 30, 8, ap(0.2))
                .variable(4, Count, 30, 0, amplify(Lv, 1))
                .variable(5, Count, 80, 0, amplify(Lv, 1))
                .variable(6, ARReduction, 1)
                .variable(7, MRReduction, 1)
                .mana(70, 10)
                .cd(1)
                .range(250);
        Heimerdinger.Q.update(P313)
                .active("スタックを消費して指定地点にTurretを最大3つまで設置する。スタックは{1}毎に増加し、最大{2}まで貯めることが出来る。スタック増加時間はCD低減の影響を受ける。塔に与えるダメージは半分。Heimerdingerが攻撃する若しくは攻撃されている場合、その対象を優先で攻撃。8秒間砲台と距離1000以上離れていた場合、砲台の動作が停止する。<br>HP:{3}<br>砲撃:{4}　{5}<br>ビーム:{6}　{7}　（12秒毎）<br>AR:10<br>MR:25<br>AS:1.75<br>視界:625")
                .variable(1, CDRAwareTime, 24, -1)
                .variable(2, Stack, new Fixed(new double[] {1, 1, 2, 2, 3}))
                .variable(3, Value, 150, 0, amplify(Lv, 25))
                .variable(4, Radius, 525)
                .variable(5, MagicDamage, 15, 7, ap(0.125))
                .variable(6, Radius, 1100)
                .variable(7, MagicDamage, 50, 25, ap(0.5))
                .mana(20)
                .cd(1)
                .range(450);
        Heimerdinger.W.update()
                .active("視界内にいる最も近い敵ユニット3体に{1}を与える。")
                .variable(1, MagicDamage, 85, 50, ap(0.55))
                .mana(65, 20)
                .cd(10)
                .range(1000);
        Heimerdinger.W.update(P313)
                .active("指定地点に目掛けて、5本のミサイルを扇状に発射する。ミサイルが指定地点を通過する後も一直線に飛行し続ける。命中すると{1}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に5発命中すると{2})。Minionに対しては60%のダメージを与える。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, MagicDamage, 108, 54, ap(0.81))
                .mana(70, 10)
                .cd(11)
                .range(1100);
        Heimerdinger.E.update()
                .active("指定地点に手榴弾を投げ、破裂した{1}にいる敵ユニットに{2}と2秒間{3}を与え、真ん中のユニットにはさらに{4}を与える。また指定地点の{5}。")
                .variable(1, Radius, 210)
                .variable(2, MagicDamage, 60, 40, ap(0.6))
                .variable(3, MSSlowRatio, 35)
                .variable(4, Stun, 1.25)
                .variable(5, Visionable)
                .mana(85)
                .cd(18, -2)
                .range(925);
        Heimerdinger.R.update()
                .active("次に使用するスキルの効果を強化する。強化されたスキルは一切のコストなしで使用でき、効果はこのスキルのLvに依存する。発動してから3秒間に何も使わない場合は再発動可能になり、もう一度使用するとCD3秒でキャンセルする。<br>H-28Q Apex Turret<br>8秒間持続する。砲撃に100%のスプラッシュダメージと{1}が付与される。<br>HP:{3}<br>砲撃:{4}　{5}<br>ビーム:{6}　{7}　（6秒毎）<br><br>Hextech Rocket Swarm<br>指定地点に目掛けて、5本のミサイルを扇状に4回発射する。命中すると{8}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に20発命中すると{9})。<br><br>CH-3X Lightning Grenade<br>2回までバウンドしつつ3回放電する手榴弾を投げる。作動した箇所にいる{10}にいる敵ユニットに{11}と2秒間{12}を与え、真ん中のユニットにはさらに{13}を与える。")
                .variable(1, MSSlowRatio, 25)
                .variable(3, Value, 600, 0, amplify(Lv, 50))
                .variable(4, Radius, 525)
                .variable(5, MagicDamage, 90, 20, ap(0.33))
                .variable(6, Radius, 1100)
                .variable(7, MagicDamage, 225, 75, ap(0.8))
                .variable(8, MagicDamage, 135, 45, ap(0.45))
                .variable(9, MagicDamage, 550, 140, ap(1.83))
                .variable(10, Radius, 420)
                .variable(11, MagicDamage, 150, 50, ap(0.6))
                .variable(12, MSSlowRatio, 80)
                .variable(13, Stack, 1.25)
                .mana(100)
                .cd(100, -20);
    }

    private static void Janna() {
        Janna.P.update().passive("全ての味方Championは{1}する。").variable(1, MSRatio, 3);
        Janna.P.update(P314).passive("{2}の全ての味方Championは{1}する。").variable(1, MSRatio, 5).variable(2, Radius, 800);
        Janna.Q.update()
                .active("指定方向に竜巻を発生させ、触れた敵ユニットに{1}と{2}を与える。竜巻は設置後に再度スキル使用ですぐに飛ばすことができるが、溜めた時間に比例して魔法DM、射程距離、打ち上げ時間が増加する。")
                .variable(1, MagicDamage, 60, 25, ap(0.75), amplify(Duration, new Fixed(new double[] {25, 30, 40, 50,
                        60})))
                .variable(2, Knockup, 0.8, 0, amplify(Duration, 0.1))
                .mana(90, 15)
                .cd(14, -1)
                .range(1100);
        Janna.Q.update(P304).variable(2, Knockup, 0.8, 0, amplify(Duration, 0.066));
        Janna.Q.update(P314).variable(1, MagicDamage, 60, 25, ap(0.35), amplify(Duration, 15, 5, ap(0.1)));
        Janna.W.update()
                .passive("{1}し{2}を得る。")
                .variable(1, MSRatio, 4, 3)
                .variable(2, IgnoreUnitCollision, 0)
                .active("対象の敵ユニットに{3}と3秒間{4}を与える。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .variable(3, MagicDamage, 60, 55, ap(0.6))
                .variable(4, MSSlowRatio, 24, 6)
                .mana(40, 10)
                .cd(12, -1)
                .range(600);
        Janna.W.update(P314)
                .active("対象の敵ユニットに{3}と3秒間{4}を与える（最大で80%）。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .variable(1, MSRatio, 4, 2, ap(0.02))
                .variable(3, MagicDamage, 60, 55, ap(0.5))
                .variable(4, MSSlowRatio, 24, 4, ap(0.06));
        Janna.E.update()
                .active("対象の味方Championか塔に5秒間{1}を付与する。シールドが持続している間は対象は{2}を得る。")
                .variable(1, Shield, 80, 40, ap(0.9))
                .variable(2, AD, 14, 9)
                .mana(70, 10)
                .cd(10)
                .range(800);
        Janna.E.update(P314).variable(1, Shield, 80, 40, ap(0.7)).variable(2, AD, 14, 9, ap(0.1));
        Janna.R.update()
                .active("0.25秒後に{1}の敵ユニットを{2}して4秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。最大で{4}する。")
                .variable(1, Radius, 725)
                .variable(2, Knockback, 875)
                .variable(3, RestoreHealth, 70, 40, ap(0.35))
                .variable(4, RestoreHealth, 280, 160, ap(1.4))
                .mana(150, 75)
                .cd(150, -15)
                .update(P303)
                .mana(100, 50)
                .update(P315)
                .mana(100)
                .update(P401)
                .active("{1}の敵ユニットを{2}して3秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。最大で{4}する。")
                .variable(3, RestoreHealth, 100, 50, ap(0.6))
                .variable(4, RestoreHealth, 300, 150, ap(1.8));
    }

    private static void Jarvan() {
        JarvanIV.P.update()
                .passive("通常攻撃に{1}(最大400DM)が付与される。同一の対象には6秒に一度しか発動しない。")
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealthRatio, new Per6Level(6, 2)));
        JarvanIV.Q.update()
                .active("槍を突き出して直線上の敵ユニットに{1}を与え、3秒間{2}を与える。また、Demacian Standardの旗にヒットした場合、旗の位置まで突進し、進路上の敵ユニット({4})に{3}を与える。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1.1))
                .variable(2, ARReductionRatio, 10, 4)
                .variable(3, Knockup, 0.75)
                .variable(4, Radius, 260)
                .mana(45, 5)
                .cd(10, -1)
                .range(770);
        JarvanIV.Q.update(P313).variable(4, Radius, 180);
        JarvanIV.W.update()
                .active("5秒間{1}を付与すると同時に、{2}の敵ユニットに２秒間{3}を与える。")
                .variable(1, Shield, 50, 40, amplify(EnemyChampion, 20, 5))
                .variable(2, Radius, 600)
                .variable(3, MSSlowRatio, 15, 5)
                .mana(65)
                .cd(20, -2);
        JarvanIV.W.update(P304).variable(1, Shield, 50, 40, amplify(EnemyChampion, 20, 10)).mana(45, 5);
        JarvanIV.E.update()
                .passive("{1}し{2}を得る。")
                .variable(1, ASRatio, 10, 3)
                .variable(2, AR, 10, 3)
                .active("指定地点に旗を投げ、{3}の敵ユニットに{4}を与える。旗は8秒間その場に残り{6}の{7}とともに、{5}の味方ChampionにPassiveの効果を与える。(Jarvan IV自身はPassiveと合わせて倍の効果を受ける)")
                .variable(3, Radius, 150)
                .variable(4, MagicDamage, 60, 45, ap(0.8))
                .variable(5, Radius, 1200)
                .variable(6, Radius, 850)
                .variable(7, Visionable)
                .mana(55)
                .cd(13)
                .range(830);
        JarvanIV.E.update(P307).variable(6, Radius, 700);
        JarvanIV.E.update(P304)
                .active("指定地点に旗を投げ、{3}の敵ユニットに{4}を与える。旗は8秒間その場に残り視界を確保するとともに、{5}の味方Championは{1}する。(Jarvan IV自身はPassiveと合わせて倍の効果を受ける)");
        JarvanIV.R.update()
                .active("対象の敵Championまで跳躍して{1}を与え、3.5秒間その周囲に通行不可能の円形の地形を作る。再度このスキルを使用すると地形を破壊できる。")
                .variable(1, PhysicalDamage, 200, 125, bounusAD(1.5))
                .mana(100, 25)
                .cd(120, -15)
                .range(650);
    }

    private static void Jinx() {
        Jinx.P.update(P312)
                .passive("攻撃した敵Championまたはタワーが3秒以内に死亡/破壊された場合、4秒間{1}する。移動速度は4秒かけて元に戻る。")
                .variable(-1, MSRatio, 175);
        Jinx.Q.update(P312)
                .passive("通常攻撃毎に{1}する。この効果は2.5秒間持続し、3回までスタックし、最大で{5}。攻撃を行わないと、スタックは2.5秒毎に1つずつ減少していく。このスキルを使用するとスタックによる攻撃速度増加は無効になる。")
                .variable(-1, ASRatio, 16.6, 6.7)
                .variable(-5, ASRatio, 50, 20)
                .active("通常攻撃は{2}し{4}が付与され、対象の{3}にいる敵にも同様のダメージを与えるようになる。")
                .variable(2, Range, 50, 20)
                .variable(3, Radius, 150)
                .variable(4, PhysicalDamage, 0, 0, ad(0.1))
                .mana(20)
                .cd(1)
                .type(SkillType.ToggleForAttack);
        Jinx.Q.update(P313).variable(-1, ASRatio, 10, 8.3).variable(-2, ASRatio, 30, 130);
        Jinx.W.update(P312)
                .active("約0.6秒詠唱後、指定方向に電撃を放ち、当たった敵ユニットに{1}と2秒間{2}を与え、2秒間そのユニットの{3}。")
                .variable(1, PhysicalDamage, 30, 45, ad(1.4))
                .variable(2, MSSlowRatio, 30, 10)
                .variable(3, Visionable)
                .mana(45, 10)
                .cd(10, -1)
                .range(1450);
        Jinx.W.update(P313).variable(1, PhysicalDamage, 10, 50, ad(1.4)).mana(50, 10);
        Jinx.E.update(P312)
                .active("指定地点に3つの罠を仕掛ける。敵Championが罠に触れると爆発し、{1}にいる敵ユニットに1.5秒かけて{2}を与え、更に罠に触れた敵Championに{3}を与える。罠は設置から{6}経過しないと反応せず、ひとつづつしか反応しない。一人のChampionが３つ全ての罠にかかった場合は{5}を与える。罠は5秒経過すると自動的に爆発する。また罠は{4}。")
                .variable(1, Radius, 50)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Snare, 1.5)
                .variable(4, Visionable)
                .variable(5, MagicDamage, 300, 150, ap(3))
                .variable(6, Time, 0.5, 0.06)
                .mana(50)
                .cd(24, -2)
                .range(950)
                .update(P401)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(5, MagicDamage, 240, 165, ap(3))
                .variable(6, Time, 0.7);
        Jinx.R.update(P312)
                .active("指定方向にロケットを放つ。ロケットが敵Championに命中すると爆発し、{1}の敵ユニットに{2}を与える。ロケットが発射から当たるまでの時間に比例してダメージが増加する(1秒で最大値になり{3}を与える、またミニオンに対しては300DMが上限)。ロケットの爆風に当たった敵ユニットには80%のダメージを与える。")
                .variable(1, Radius, 225)
                .variable(2, PhysicalDamage, 125, 50, bounusAD(0.5), amplify(TargetMissingHealthRatio, 25, 5))
                .variable(3, PhysicalDamage, 250, 100, bounusAD(1), amplify(TargetMissingHealthRatio, 25, 5))
                .mana(100)
                .cd(90, -15)
                .range(-1);
    }

    private static void Kassadin() {
        Kassadin.P.update()
                .passive("自身が受ける{1}して、4秒間軽減した分のダメージを攻撃速度(%)に加算する。")
                .variable(1, MagicDamageReductionRatio, 15);

        Kassadin.Q.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Silence, 1, 0.4)
                .mana(70, 10)
                .cd(9)
                .range(650)
                .update(P313)
                .variable(1, MagicDamage, 80, 35, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 5)
                .update(P403)
                .variable(1, MagicDamage, 80, 30, ap(0.7))
                .variable(2, Silence, 1, 0.25);

        Kassadin.W.update()
                .passive("通常攻撃ごとに{1}する。対象がChampionの場合は{2}する。")
                .variable(1, RestoreMana, 8, 3)
                .variable(2, RestoreMana, 16, 6)
                .active("5秒間、通常攻撃に追加{3}が付与される。建物には無効。")
                .variable(3, MagicDamage, 30, 15, ap(0.3))
                .mana(25)
                .cd(12);

        Kassadin.E.update()
                .active("指定方向扇形80°の{1}の敵ユニットに{2}と3秒間{3}を与える。近くのChampion(敵味方自分問わず)がスキルを使用するとスタックが増え、6スタックまで溜まると使用可能。スキル使用時にスタックは0になる。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 80, 50, ap(0.7))
                .variable(3, MSSlowRatio, 30, 5)
                .mana(80)
                .cd(6)
                .update(P403)
                .variable(2, MagicDamage, 80, 40, ap(0.7));

        Kassadin.R.update()
                .active("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに消費MNと魔法DMが増加していく。(最大10スタック)スタックは8秒間増加がないと0になる。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 60, 10, ap(0.8), amplify(Stack, 60, 10))
                .cost(Mana, new Diff(100, 0, 1), amplify(Stack, 100))
                .cd(7, -1)
                .range(700)
                .update(P313)
                .active("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに消費マナと魔法DMが増加していく。(最大10スタック)スタックは8秒間増加がないと0になる。敵Championにダメージを与えると使用時のマナの半分が回復する。")
                .variable(2, MagicDamage, 80, 20, ap(0.8), amplify(Stack, 50, 5, ap(0.1)));
    }

    private static void KhaZix() {
        Khazix.P.update()
                .passive("自身が敵チームの視界から消えた時に発動する。次の敵Championに対する通常攻撃かEvolved Void Spikeに追加{1}と2秒間{2}を付与する。この効果は敵チームの視界に現れても効果が消費されるまでは失われない。")
                .variable(1, MagicDamage, new Per1Level(new double[] {15, 20, 25, 35, 45, 55, 65, 75, 85, 95, 110, 125,
                        140, 150, 160, 170, 180, 190}), ap(0.5), null)
                .variable(2, MSSlowRatio, 25);

        Khazix.Q.update()
                .passive("敵チームの中で孤立している敵ユニットにマークを付与する。")
                .active("対象の敵ユニットに{1}を与える。マークが付与されている敵ユニットのマークの範囲内に他の敵ユニットがいない場合、{2}を与える。進化すると孤立した敵ユニットに追加{3}を与え、このスキルの射程と通常攻撃の射程が50増加する。")
                .mana(25)
                .variable(1, PhysicalDamage, 70, 30, bounusAD(1.5))
                .variable(2, PhysicalDamage, 100, 45, bounusAD(2))
                .variable(3, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 12))
                .cd(3.5)
                .range(325)
                .update(P308)
                .active("対象の敵ユニットに{1}を与える。孤立している敵には{2}を与える。進化すると敵ユニットに追加{3}を与え（孤立している敵には{4}、ミニオンやモンスターには{5}が上限）、このスキルの射程と通常攻撃の射程が50増加する。")
                .variable(2, PhysicalDamage, 101.5, 43.5, bounusAD(2.18))
                .variable(3, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 8))
                .variable(4, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 11.6))
                .variable(5, PhysicalDamage, 200)
                .update(P403)
                .variable(3, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 6))
                .variable(4, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 8.7))
                .variable(5, PhysicalDamage, 100);

        Khazix.W.update()
                .active("指定方向に敵ユニットに命中すると爆発する針を発射し、{1}の敵ユニットに{2}を与える。自身が爆発範囲内にいる場合は更に{3}する。進化すると指定方向に対して扇形になるような3方向に針を発射するようになり、また爆発にUnseen Threatの追加魔法DMとスローを付与する。")
                .mana(60, 10)
                .variable(1, Radius, 0)
                .variable(2, PhysicalDamage, 75, 40, bounusAD(0.9))
                .variable(3, RestoreHealth, 40, 30, ap(0.5))
                .cd(8)
                .range(1000)
                .update(P308)
                .active("指定方向に敵ユニットに命中すると爆発する針を発射し、{1}の敵ユニットに{2}と2秒間{4}を与える。自身が爆発範囲内にいる場合は更に{3}する。このスキルはLeap中に発動出来ない。進化すると指定方向に対して扇形になるような3方向に針を発射するようになる。")
                .variable(2, PhysicalDamage, 75, 40, bounusAD(1))
                .variable(4, MSSlowRatio, 20)
                .mana(55, 5)
                .update(P313)
                .variable(4, MSSlowRatio, 30);

        Khazix.E.update()
                .active("指定地点にジャンプし、{1}の敵ユニットに{2}を与える。進化すると射程が400増加し、またkillやassistを取った場合にこのスキルの{3}する。")
                .variable(1, Radius, 0)
                .variable(2, PhysicalDamage, 65, 35, bounusAD(0.8))
                .variable(3, CDDecrease, 0)
                .mana(50)
                .cd(22, -2)
                .range(600)
                .update(P403)
                .variable(2, PhysicalDamage, 65, 35, bounusAD(0.2));

        Khazix.R.update()
                .passive("このスキルを取得、またはランクが上がる毎に、いずれかのスキルを選んで進化させることができる。")
                .active("使用後{2}状態になり、{1}する。この際にUnseen Threatの効果が発動する。また使用後10秒以内であれば、消費マナ無しでもう一度だけこのスキルを使用することができる。進化すると10秒以内に再度使用可能な回数が2回に増加し、またステルス状態の間{3}する。")
                .variable(1, MSRatio, 40)
                .variable(2, Stealth, 1)
                .variable(3, DamageReductionRatio, 40)
                .mana(100)
                .cd(3)
                .update(P308)
                .variable(3, DamageReductionRatio, 50)
                .update(P403)
                .active("{2}状態になり、{1}し{4}を得る。この際にUnseen Threatの効果が発動する。10秒以内であればスキルを再使用できる。進化すると、{5}状態になり、{1}し、{3}して{4}を得る。また再使用回数が2回に増加する。")
                .variable(4, IgnoreUnitCollision)
                .variable(5, Stealth, 2);
    }

    private static void Kayle() {
        Kayle.P.update()
                .passive("敵Championに通常攻撃を行う度に、{1}と{2}を与える。この効果は5秒間持続し、5回までスタックする。")
                .variable(1, ARReductionRatio, 3)
                .variable(2, MRReductionRatio, 3);
        Kayle.Q.update()
                .active("{4}の光の玉を撃ち対象の敵ユニットに{1}と4秒間{2}を与える。このスキルのスローがかかった敵ユニットに対しては、Kayleが対象のユニットに与える{3}する。")
                .variable(1, MagicDamage, 60, 50, ap(1), bounusAD(1))
                .variable(2, MSSlowRatio, 35)
                .variable(3, DamageRatio, 6, 1)
                .variable(4, MissileSpeed, 1300)
                .mana(70, 5)
                .cd(8)
                .range(650)
                .update(P303)
                .active("{4}の光の玉を撃ち対象の敵ユニットに{1}と3秒間{2}、HolyFervorのスタックをひとつ与える。")
                .variable(2, MSSlowRatio, 35, 5)
                .variable(4, MissileSpeed, 1500)
                .update(P402)
                .variable(1, MagicDamage, 60, 50, ap(0.6), bounusAD(1));;
        Kayle.W.update()
                .active("対象の味方Championは{1}し、3秒間{2}する。")
                .variable(1, RestoreHealth, 60, 45, ap(0.35))
                .variable(2, MSRatio, 18, 3)
                .mana(60, 10)
                .cd(15)
                .range(1000)
                .update(P3051)
                .range(900)
                .update(P402)
                .variable(1, RestoreHealth, 60, 45, ap(0.45))
                .variable(2, MSRatio, 18, 3, ap(0.07));
        Kayle.E.update()
                .active("10秒間Kayleの通常攻撃の射程が525に伸びる(Ranged)。更に通常攻撃に追加{1}が付与され、スプラッシュ効果{2}が付く。塔を攻撃する時はスプラッシュ効果は発生しない。")
                .variable(1, MagicDamage, 20, 10, ap(0.4), amplify(AD, 0.2, 0.05))
                .variable(2, Radius, 300)
                .mana(45)
                .cd(16);
        Kayle.R.update()
                .active("対象の味方Championを{1}間無敵(ダメージ無効)にする。")
                .variable(1, Time, 2, 0.5)
                .mana(100, -25)
                .cd(90, -15)
                .range(1200)
                .update(P3051)
                .range(900)
                .update(P402)
                .mana(0);
    }

    private static void LeeSin() {
        LeeSin.P.update()
                .passive("スキルを使用すると{1}し通常攻撃の度に{2}する。この効果は3秒経つか2回通常攻撃を行うと解消される。")
                .variable(-1, ASRatio, 40)
                .variable(2, RestoreEnergy, 15);
        LeeSin.Q.update()
                .active("指定方向に気を飛ばし当たった敵ユニットに{1}を与える。このスキルが敵ユニットに当たった場合、3秒間対象の視界を得て、下記のスキルを使用できる。<br><br>{2}を消費して、Sonic Waveが当たった{3}の敵ユニットにダッシュし、{4}を与える。(追加ダメージはMinionに対して400DMが上限)")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.9))
                .variable(2, Energy, 30)
                .variable(3, Radius, 1300)
                .variable(4, PhysicalDamage, 50, 0, bounusAD(0.5), amplify(Status.TargetMissingHealthRatio, 8))
                .cd(11, -1)
                .range(1100)
                .cost(Energy, 50, 0);
        LeeSin.W.update()
                .active("対象の味方ユニットまで移動する。自身及び対象（味方Championに限る）は５秒間{1}を得る。このスキル使用後3秒間、下記のスキルが使用できる。<br><br>{2}を消費して、5秒間{3}と{4}を得る。")
                .variable(1, Shield, 40, 40, ap(0.8))
                .variable(2, Energy, 30)
                .variable(3, LS, 5, 5)
                .variable(4, SV, 5, 5)
                .cd(9)
                .cost(Energy, 50, 0)
                .range(700);
        LeeSin.E.update()
                .active("{1}の敵ユニットに{2}を与え、4秒間そのユニットの{3}。このスキルが敵ユニットに当たった場合、3秒間下記のスキルが使用できる。<br><br>{4}を消費して、Tempestが当たった{5}の敵ユニットに４秒間{6}を与える。これらの速度低下は時間と共に戻っていく。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 60, 35, bounusAD(1))
                .variable(3, Visionable)
                .variable(4, Energy, 30)
                .variable(5, Radius, 500)
                .variable(6, MSSlowRatio, 20, 10)
                .cd(10)
                .cost(Energy, 50, 0);
        LeeSin.R.update()
                .active("対象の敵Championに{1}を与え、{2}させる。ノックバックした対象に触れた敵ユニットにも{1}を与え、{3}を与える。")
                .variable(1, PhysicalDamage, 200, 200, bounusAD(2))
                .variable(2, Knockback, 1200)
                .variable(3, Knockup, 0)
                .cd(90, -15)
                .range(375);
    }

    private static void Leona() {
        Leona.P.update()
                .passive("スキルでダメージを与えた敵ユニットに、3.5秒間持続するDebuffを付与する。この敵ユニットに対してLeona以外の味方Championがダメージを与えると、付与されたDebuffを消費して追加{1}を与える。")
                .variable(1, MagicDamage, new Per2Level(20, 15));
        Leona.Q.update()
                .active("次の通常攻撃に追加{1}と{2}が付与される。")
                .variable(1, MagicDamage, 40, 30, ap(0.3))
                .variable(2, Stun, 1.25)
                .mana(45, 5)
                .cd(11, -1);
        Leona.W.update()
                .active("3秒間{1}と{2}を得て、効果終了時に{3}の敵ユニットに{4}を与える。魔法DMが敵ユニットに命中した場合、ARとMR増加の効果時間が3秒延長される。")
                .variable(1, AR, 30, 10)
                .variable(2, MR, 30, 10)
                .variable(3, Radius, 450)
                .variable(4, MagicDamage, 60, 50, ap(0.4))
                .mana(60)
                .cd(14);
        Leona.W.update(P314)
                .variable(1, AR, 25, 10, amplify(BounusAR, 0.2))
                .variable(2, MR, 25, 10, amplify(BounusMR, 0.2));
        Leona.E.update()
                .active("指定方向に貫通するエネルギーを飛ばし当たった敵ユニットに{1}を与える。このスキルが敵Championに命中した場合、その敵Championの元までLeonaが移動する。また移動中は対象の敵ChampionにSnareを与える。複数の敵Championに命中した場合は最後に命中した敵Championの元に移動する。")
                .variable(1, MagicDamage, 60, 40, ap(0.4))
                .mana(60)
                .cd(13, -1)
                .range(875);
        Leona.R.update()
                .active("わずかな間をおいて、指定地点を中心として{1}の敵ユニットに{2}を、{5}の敵ユニットに1.5秒間{3}を、{6}の敵ユニットに{4}を与える。")
                .variable(1, Radius, 125)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(5, Radius, 350)
                .variable(3, MSSlowRatio, 80)
                .variable(6, Radius, 50)
                .variable(4, Stun, 1.5)
                .mana(100, 50)
                .cd(90, -15)
                .range(1200);
        Leona.R.update(P313).mana(100);
    }

    private static void Lucian() {
        Lucian.P.update()
                .passive("スキル使用した後の通常攻撃が2回攻撃になる。この効果は通常攻撃を行うか、6秒経過すると解消される。2回目の攻撃は50%のダメージとなるが、対象がMinionの場合は100%のダメージを与える。またon-hitエフェクトは通常通り適用され、クリティカルも発生する。");
        Lucian.Q.update()
                .active("対象の敵ユニットに向けて0.35秒後に光のボルトを放ち、対象とその直線状({1})にいるすべての敵ユニットに{2}を与える(ミニオンに対しては75%)。")
                .variable(1, Length, 1100)
                .variable(2, PhysicalDamage, 80, 40, amplify(BounusAD, 0.6, 0.15))
                .variable(3, PhysicalDamage)
                .mana(60, 5)
                .cd(9, -1)
                .range(570)
                .update(P315)
                .variable(2, PhysicalDamage, 80, 30, amplify(BounusAD, 0.6, 0.15))
                .range(550);
        Lucian.W.update()
                .active("指定方向に爆発する弾を放つ。敵ユニットに当たるか最大距離まで飛ぶと十字型に爆風が広がり、範囲内の敵ユニットに{1}と6秒間マークを与える。マークを受けている敵ユニットにダメージを与えると、2秒間{2}する。また爆風が発生した地点の{3}。")
                .variable(1, MagicDamage, 60, 40, ap(0.9), bounusAD(0.8))
                .variable(2, MS, 40)
                .variable(3, Visionable)
                .mana(60)
                .cd(18, -2)
                .range(425);
        Lucian.E.update()
                .active("指定方向にダッシュし、自身にかかっているスローを解除する。" + Lucian.R + "発動中に敵Championをキルかアシストした場合このスキルの{1}する。")
                .variable(1, CDDecrease)
                .mana(60, -15)
                .cd(18, -2)
                .range(425);
        Lucian.R.update()
                .active("3秒間、指定方向に{1}発の弾を連射し一発毎に{2}を与える（最大で{3}）。銃を連射している間は移動と" + Lucian.E + "のみが可能であり、ミニオンに対しては400%のダメージを与える。また連射中にこのスキルを再使用することで連射を解除できる。")
                .variable(1, Value, 7.5, 0, amplify(AS, 7.5, 1.5))
                .variable(2, PhysicalDamage, 40, 10, ap(0.1), bounusAD(0.25))
                .variable(3, PhysicalDamage, 1040, 460, amplify(AP, 2.6, 0.4), amplify(BounusAD, 6.5, 1.0))
                .mana(100)
                .cd(100, -25)
                .range(1400);
    }

    private static void Lulu() {
        Lulu.P.update()
                .passive("Pixという妖精がお供になる。Pixが付いている味方Championが通常攻撃を行った場合、Pixは同一の敵ユニットの方向に3発の弾を放ち1発毎に{1}を与える。この弾は敵ユニットを追尾するが、弾の進行方向上にいる敵ユニットにも当たる。建物を攻撃した場合はPixは弾を撃たない。")
                .variable(1, MagicDamage, 1, 0, amplify(Lv, 2))
                .update(P314)
                .variable(1, MagicDamage, new Per2Level(3, 3), ap(0.05), null)
                .update(P315)
                .variable(1, MagicDamage, new Per2Level(3, 4), ap(0.05), null);
        Lulu.Q.update()
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間{3}を与える。この効果は時間と共に元に戻る。またPixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .variable(1, MagicDamage, 80, 45, ap(0.5))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 80)
                .mana(40, 10)
                .cd(7)
                .range(925);
        Lulu.Q.update(P306).mana(60, 5);
        Lulu.Q.update(P314)
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間{3}を与える。この効果は時間と共に{4}まで減少する。またPixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .variable(4, Percentage, 0, 0, ap(0.133));
        Lulu.W.update()
                .active("対象の味方Championに使用した場合、5秒間対象の味方Championは{1}し{2}を得る。敵Championに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、{4}する。")
                .variable(1, MSRatio, 35)
                .variable(2, AP, 20, 10)
                .variable(3, Time, 1.5, 0.25)
                .variable(4, MSReduction, 60)
                .mana(65, 5)
                .cd(18, -1.5)
                .range(650);
        Lulu.W.update(P314)
                .active("対象の味方Championに使用した場合、5秒間対象の味方Championは{1}を得る。敵Championに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、{4}する。")
                .variable(1, MSRatio, 30, 0, ap(0.1));
        Lulu.E.update()
                .active("対象の味方ユニットに使用した場合、6秒間対象の味方ユニットにPixを付けると同時に{1}を付与する。敵ユニットに使用した場合、Pixが敵ユニットに付くと同時に{2}を与え、6秒間その敵ユニットの{3}。")
                .variable(1, Shield, 60, 45, ap(0.6))
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Visionable)
                .mana(60, 10)
                .cd(10)
                .range(650)
                .update(P314)
                .variable(2, MagicDamage, 80, 50, ap(0.4))
                .update(P315)
                .variable(1, Shield, 80, 40, ap(0.6));
        Lulu.R.update()
                .active("対象の味方Championを7秒間巨大化させ、同時に対象の{3}の敵ユニットに{1}を与える。巨大化した味方Championは{2}を得て、{3}の敵ユニットに継続的に{4}を与える。スローの効果は範囲内から出ても1秒間持続する。")
                .variable(1, Knockup, 1.5)
                .variable(2, Health, 300, 150, ap(0.5))
                .variable(3, Radius, 0)
                .variable(4, MSSlowRatio, 30, 15)
                .mana(150)
                .cd(110, -15)
                .range(900)
                .update(P315)
                .mana(100);
    }

    private static void MasterYi() {
        MasterYi.P.update().passive("通常攻撃7回毎に2回分ダメージを与える。対象が建物の場合も有効。");
        MasterYi.P.update(P310).passive("連続した通常攻撃4回毎に2回攻撃をする。この追加攻撃は50%のダメージを与える。");
        MasterYi.Q.update()
                .active("対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え、対象の近くにワープする。minionの場合は50%の確率で追加{3}を与える。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, MagicDamage, 260, 60)
                .mana(60, 10)
                .cd(18, -2)
                .range(600);
        MasterYi.Q.update(P310)
                .active("対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え(クリティカル発生時は{5})、対象の近くにワープする。ミニオンには追加{3}を与える。通常攻撃をする毎に{4}する。")
                .variable(2, PhysicalDamage, 25, 35, ad(1))
                .variable(3, PhysicalDamage, 75, 25)
                .variable(4, CDDecrease, 1)
                .variable(5, PhysicalDamage, 25, 35, ad(1.6))
                .mana(70, 10)
                .cd(18, -1);
        MasterYi.Q.update(P313)
                .active("ターゲット不可状態になり対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え(クリティカル発生時は{5})、対象の近くにワープする。ミニオンには追加{3}を与える。通常攻撃をする毎に{4}する。");
        MasterYi.W.update()
                .active("5秒間詠唱を行い、毎秒{1}し、詠唱中は{2}と{3}を得る。")
                .variable(1, RestoreHealth, 40, 30, ap(0.4))
                .variable(2, AR, 100, 50)
                .variable(3, MR, 100, 50)
                .mana(50, 15)
                .cd(35)
                .type(SkillType.Channel);
        MasterYi.W.update(P310)
                .active("4秒間詠唱を行い、{1}を得る（タワーに対しては{2}）。また、毎秒{3}する。この効果は失われているHealth1%に毎に1%増加する。")
                .variable(1, DamageReductionRatio, 40, 5)
                .variable(2, DamageReduction, 20, 2.5)
                .variable(3, RestoreHealth, 30, 20, ap(0.3));
        MasterYi.W.update(P310A).variable(1, DamageReductionRatio, 50, 5);
        MasterYi.W.update(P313).mana(50);
        MasterYi.E.update()
                .passive("{1}を得る。")
                .variable(1, AD, 15, 5)
                .active("10秒間{2}を得る。CDが解消されるまでPassiveの増加ダメージがなくなる。")
                .variable(2, AD, 30, 10)
                .mana(40)
                .cd(25, -2);
        MasterYi.E.update(P310)
                .passive("{1}を得る。CD中この効果は失われる。")
                .variable(1, AD, 0, 0, amplify(AD, 0.07, 0.02))
                .active("5秒間通常攻撃に{2}が追加される。")
                .variable(2, TrueDamage, 10, 5, amplify(AD, 0.1, 0.025))
                .mana(0)
                .cd(18, -1);
        MasterYi.E.update(P310A).variable(1, AD, 0, 0, amplify(AD, 0.1));
        MasterYi.R.update()
                .active("{4}間{1}、{2}し、{3}を得る。効果中に敵Championを倒すとすべてのスキルの{5}する。")
                .variable(1, MSRatio, 40)
                .variable(2, ASRatio, 40)
                .variable(3, IgnoreSlow)
                .variable(4, Time, 8, 2)
                .variable(5, CDDecrease)
                .mana(100)
                .cd(75);
        MasterYi.R.update(P310)
                .passive("Championを倒すと" + MasterYi.R + "以外のスキルは{5}する。（アシストの場合は{6}）")
                .variable(5, CDDecrease, 18)
                .variable(6, CDDecrease, 9)
                .active("{4}間{1}、{2}し、{3}を得る。効果中にChampionを倒すと効果時間が{7}延長する。")
                .variable(1, MSRatio, 25, 10)
                .variable(2, ASRatio, 30, 25)
                .variable(4, Time, 10)
                .variable(7, Time, 4);
        MasterYi.R.update(P310A)
                .passive("Championを倒すと（アシストを含む）" + MasterYi.R + "以外のスキルは{5}する。")
                .variable(5, CDDecreaseRatio, 70);
    }

    private static void Morgana() {
        Morgana.P.update().passive("{1}を得る。").variable(1, SV, new Per6Level(10, 5));
        Morgana.Q.update()
                .active("指定方向に魔法弾を飛ばし、当たった敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 55, ap(0.9))
                .variable(2, Snare, 2, 0.25)
                .mana(60, 15)
                .cd(11)
                .range(1300);
        Morgana.Q.update(P3051).mana(50, 10);
        Morgana.W.update()
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに毎秒{1}と{2}を与える。MR低下は2秒間持続し、5回までスタックする。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MRReduction, 4, 1)
                .variable(3, Radius, 350)
                .mana(70, 15)
                .cd(10)
                .range(900);
        Morgana.W.update(P313)
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに0.5秒毎に{1}を与える（最大で{2}）。対象が失っているHP1%につき、このスキルのダメージが0.5%上昇する(最大で1.5倍)。")
                .variable(1, MagicDamage, 12, 7, ap(0.11))
                .variable(2, MagicDamage, 120, 70, ap(1.1));
        Morgana.E.update()
                .active("対象の味方Championは5秒間{1}と{2}を得る。")
                .variable(1, MagicShield, 95, 65, ap(0.7))
                .variable(2, IgnoreCC)
                .mana(50)
                .cd(23, -2)
                .range(750);
        Morgana.R.update()
                .active("周囲の敵Championに{1}と３秒間{2}を与え対象と糸で繋がれる。3秒間対象が糸の範囲内({3})に留まっていた場合、対象に{1}と{4}を与える。")
                .variable(1, MagicDamage, 175, 75, ap(0.7))
                .variable(2, MSSlowRatio, 20)
                .variable(3, Radius, 1000)
                .variable(4, Stun, 1.5)
                .mana(100, 50)
                .cd(120, -10)
                .range(600);
        Morgana.R.update(P3051).mana(100);
    }

    private static void Nami() {
        Nami.P.update().passive("スキルが味方Championに命中した際に、対象は1.5秒間{1}する。").variable(-1, MS, new Per6Level(30, 5));
        Nami.P.update(P307).variable(-1, MS, 40);
        Nami.P.update(P314).variable(-1, MS, 40, 0, ap(0.1));
        Nami.Q.update()
                .active("指定地点に泡を投げ、範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 55, ap(0.65))
                .variable(2, Stun, 1.25)
                .mana(60)
                .cd(14, -1)
                .range(875);
        Nami.Q.update(P307).variable(2, Stun, 1.5);
        Nami.Q.update(P314).variable(1, MagicDamage, 75, 55, ap(0.5));
        Nami.W.update()
                .active("対象の味方Championまたは敵Championに、Championにのみ3回まで跳ね返る({3})水流を発射する。水流が味方Championに命中した場合は{1}し、敵Championに命中した場合は{2}を与える。水流は同一のChampionには一度しか跳ね返らず、味方Championに命中した場合は一番近くの敵Championに、敵Championに命中した場合は一番近くの味方Championに跳ね返る。")
                .variable(1, RestoreHealth, 65, 30, ap(0.3))
                .variable(2, MagicDamage, 70, 40, ap(0.5))
                .variable(3, Radius, 875)
                .mana(70, 15)
                .cd(9)
                .range(725);
        Nami.W.update(P314)
                .active("対象の味方Championまたは敵Championに、Championにのみ3回まで跳ね返る({3})水流を発射する。水流が味方Championに命中した場合は{1}し、敵Championに命中した場合は{2}を与える。水流は同一のChampionには一度しか跳ね返らず、味方Championに命中した場合は一番近くの敵Championに、敵Championに命中した場合は一番近くの味方Championに跳ね返る。跳ね返るたびに効果は{4}増減する。")
                .variable(4, Percentage, -15, 0, ap(0.15));
        Nami.E.update()
                .active("対象の味方Championの通常攻撃に{1}と1秒間の{2}を付与する。この効果は5秒経つか3回通常攻撃を行うと解消される。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MSSlowRatio, 15, 5)
                .mana(55, 5)
                .cd(11)
                .range(800);
        Nami.E.update(P304).active("対象の味方Championの通常攻撃に{1}と1秒間の{2}を付与する。この効果は6秒経つか3回通常攻撃を行うと解消される。");
        Nami.E.update(P314).variable(2, MSSlowRatio, 15, 5, ap(0.05));
        Nami.R.update()
                .active("指定方向に津波を発生させ、命中した敵ユニットに{1}と{2}を与えた後2～4秒間{3}与える。スローの効果時間は当たるまでの津波の移動距離に比例して効果時間が長くなる。")
                .variable(1, Knockup, 1)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MSSlowRatio, 50, 10)
                .mana(100, 50)
                .cd(140, -20)
                .range(2500);
        Nami.R.update(P3051).range(2750).cd(120, -10).mana(100);
        Nami.R.update(P314).variable(2, MagicDamage, 150, 100, ap(0.6));
    }

    private static void Nasus() {
        Nasus.P.update().passive("{1}を得る。").variable(1, LS, new Per6Level(14, 3));
        Nasus.P.update(P314).variable(1, LS, new Per6Level(10, 5));
        Nasus.Q.update()
                .active("次に行う通常攻撃に{1}を付与する。このスキルを使用しLHをとると増加ダメージが+3されていく。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+6)になる。")
                .variable(1, PhysicalDamage, 30, 20, amplify(Stack, 3))
                .mana(20, 5)
                .cd(8, -1);
        Nasus.W.update()
                .active("対象の敵Championに5秒間{1}と{2}を与える。")
                .variable(1, ASSlowRatio, 35, 0, amplify(Duration, 3, 3))
                .variable(2, MSSlowRatio, 35, 0, amplify(Duration, 3, 3))
                .mana(80)
                .cd(15, -1)
                .range(700)
                .update(P401)
                .range(600);
        Nasus.W.update(P306).variable(1, ASSlowRatio, 17.5, 0, amplify(Duration, 1.5, 1.5));
        Nasus.E.update()
                .active("指定地点に魔法陣を呼び出し{1}の敵ユニットに{2}を与える。魔方陣は5秒間持続し、上にいる敵ユニットに{3}と毎秒{4}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 55, 40, ap(0.6))
                .variable(3, Status.ARReduction, 20, 5)
                .variable(4, MagicDamage, 11, 8, ap(0.12))
                .mana(70, 15)
                .cd(12)
                .range(650);
        Nasus.R.update()
                .active("15秒間自身の周りに砂嵐を発生させ{1}増加し、周囲の敵ユニットに毎秒{2}を与える。また効果中は通常攻撃の{3}し、スキルの{4}し、このスキルで与えたダメージの5%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。")
                .variable(1, Health, 300, 150)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 3, 1, ap(0.01)))
                .variable(3, Range, 50)
                .variable(-4, Range, 100)
                .mana(150)
                .cd(120)
                .update(P401)
                .active("15秒間自身の周りに砂嵐を発生させ{1}増加し、周囲の敵ユニットに毎秒{2}を与える。また効果中は通常攻撃の{3}し、このスキルで与えたダメージの5%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。");
    }

    private static void Nautilus() {
        Nautilus.P.update()
                .passive("通常攻撃に{1}と{2}が付与される。同一の対象には12秒に一度しか発動しない。")
                .variable(1, PhysicalDamage, 2, 0, amplify(Lv, 6))
                .variable(2, Snare, new Per6Level(0.5, 0.25));
        Nautilus.P.update(P314).variable(2, Snare, new Per5LevelWith18(0.5, 0.25));
        Nautilus.Q.update()
                .active("指定方向に錨を投げ、最初に命中した敵ユニットに{1}を与えNautilusの方向に引き寄せる。またNautilus自身も敵ユニットの方向に移動する。錨が壁に命中した場合、壁の方向にNautilusが移動しこのスキルのCDが半分になる。")
                .variable(1, MagicDamage, 60, 45, ap(0.75))
                .mana(60, 10)
                .cd(18, -2)
                .range(950);
        Nautilus.W.update()
                .active("10秒間{1}を得る。シールドが持続している間は通常攻撃時に対象とその周囲({2})にいる敵ユニットに{3}を与える。この魔法DMは2秒間かけて与えられる。")
                .variable(1, Shield, 100, 50, amplify(BounusHealth, 0.1))
                .variable(2, Radius, 350)
                .variable(3, MagicDamage, 30, 25, ap(0.4))
                .mana(80)
                .cd(26, -2);
        Nautilus.W.update(P3051).cd(22, -1);
        Nautilus.W.update(P308).variable(3, MagicDamage, 40, 15, ap(0.4));
        Nautilus.E.update()
                .active("周囲を爆発させ命中した敵ユニットに{1}と２秒間{2}を与える。スローの効果は2秒かけて元に戻る。爆発はNautilusを中心に3回まで発生し、同一対象に対して複数hitする。2発目以降は本来の50%分の魔法DMを与える(3発hitで{3})。")
                .variable(1, MagicDamage, 60, 40, ap(0.5))
                .variable(2, MSSlowRatio, 30, 5)
                .variable(3, MagicDamage, 120, 80, ap(1))
                .mana(60, 10)
                .cd(10)
                .range(400);
        Nautilus.R.update()
                .active("対象の敵Championに衝撃波を放ち、移動中の衝撃波に当たった敵ユニットに{1}と{2}を与える。衝撃波が対象の敵Championに当たると爆発し、対象とその周囲にいる敵ユニットに{3}と{2}を与える。対象の敵Championには{2}と同時に{4}を与える。")
                .variable(1, MagicDamage, 125, 50, ap(0.4))
                .variable(2, Knockup, 1)
                .variable(3, MagicDamage, 200, 125, ap(0.8))
                .variable(4, Stun, 1, 0.5)
                .mana(100)
                .cd(140, -30)
                .range(850);
    }

    private static void Nidalee() {
        Nidalee.P.update().passive("茂みに入ると{1}する。この効果は茂みから出ても2秒間持続する。").variable(-1, MSRatio, 15);
        Nidalee.Q.update()
                .active("指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍が命中した時のNidaleeとターゲットの間の距離に比例して与えるダメージが増加する。最大で{2}。")
                .variable(1, MagicDamage, 55, 40, ap(0.65))
                .variable(2, MagicDamage, 137.5, 100, ap(1.625))
                .mana(50, 10)
                .cd(5)
                .range(1500);
        Nidalee.Q.update(P314).active("指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍が投げた距離に比例して与えるダメージが増加する。最大で{2}。");
        NidaleeCougar.Q.update()
                .active("次に行う通常攻撃のダメージが{1}増加する。対象が受けているダメージに比例してダメージが増加する。最大で{2}。")
                .variable(1, PhysicalDamage, 40, 30)
                .variable(2, PhysicalDamage, 120, 90, ad(2))
                .cd(5);
        Nidalee.W.update()
                .active("指定地点に罠を仕掛ける。敵ユニットが罠を踏むと発動し、対象の敵ユニットとその周囲の敵ユニットに2秒かけて{1}を与え、{5}間{2}と{3}を与え{4}。罠は4分間持続する。罠を設置してから2秒間の間は罠は発動しない。")
                .variable(1, MagicDamage, 80, 45, ap(0.4))
                .variable(2, ARReductionRatio, 20, 5)
                .variable(3, MRReductionRatio, 20, 5)
                .variable(4, Visionable)
                .variable(5, Time, 12)
                .mana(60, 15)
                .cd(18)
                .range(900);
        Nidalee.W.update(P314).variable(5, Time, 8);
        NidaleeCougar.W.update()
                .active("前方に飛びかかり着地地点の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 125, 50, ap(0.4))
                .cd(3.5)
                .range(350);
        Nidalee.E.update()
                .active("対象の味方Championの{1}し、7秒間{2}する。")
                .variable(1, RestoreHealth, 50, 35, ap(0.7))
                .variable(2, ASRatio, 20, 10)
                .mana(60, 20)
                .cd(10)
                .range(600);
        NidaleeCougar.E.update()
                .active("前方扇形180°{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 150, 75, ap(0.4))
                .variable(2, Radius, 300)
                .cd(6);
        NidaleeCougar.E.update().variable(1, MagicDamage, 150, 75, ap(0.6));
        Nidalee.R.update()
                .active("HumanからCougarに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、{1}を得る。Cougarスキルはこのスキルのレベルに比例し威力が増加する。{2}。")
                .variable(1, MS, 20)
                .variable(2, NotSpellCast)
                .variable(3, MR, 10, 10)
                .cd(4);
        NidaleeCougar.R.update()
                .active("CougarからHumanに変身する。Human時はスキルの効果が変わり、通常攻撃の射程距離が525(Ranged)になる。{1}。")
                .variable(1, NotSpellCast)
                .cd(4);
    }

    private static void Nunu() {
        Nunu.P.update().passive("通常攻撃を行うたびにスタックが増加する(最大5スタック)。5スタックの状態でスキルを使用すると、スタックを消費して対象のスキルの消費マナが0になる。");
        Nunu.Q.update()
                .active("対象の敵MinionかPet及びモンスター1体に{1}を与え、{2}する。")
                .variable(1, TrueDamage, 500, 100)
                .variable(2, RestoreHealth, 125, 55, ap(1))
                .mana(60)
                .cd(16, -2)
                .range(125);
        Nunu.Q.update(P307)
                .active("対象の敵MinionかPet及びモンスター1体に{1}を与え、{2}する。特定のモンスターを対象とした場合{3}間、以下の追加効果を得る。<br>ゴーレム : {4}を得て{5}する。<br>リザード : 通常攻撃かスキルでダメージを与えると、{6}を与える。<br>レイス/ウルフ : 敵ユニットを倒すと3秒間{7}する。")
                .variable(1, TrueDamage, 600, 100)
                .variable(2, RestoreHealth, 90, 40, ap(0.75))
                .variable(3, Time, 120, 30)
                .variable(4, Health, 0, 0, amplify(Health, 0.1))
                .variable(5, Grow)
                .variable(6, MagicDamage, 0, 0, amplify(Health, 0.01))
                .variable(7, MSRatio, 15);
        Nunu.Q.update(P309).variable(1, TrueDamage, 500, 125);
        Nunu.Q.update(P314).variable(1, TrueDamage, 400, 150).variable(2, RestoreHealth, 70, 45, ap(0.75)).cd(13, -1);
        Nunu.W.update()
                .active("12秒間対象の味方ユニットは{1}し{2}する。自分以外に使用した場合は自身にも同様の効果が発生する。")
                .variable(1, ASRatio, 25, 5)
                .variable(2, MSRatio, 8, 1)
                .mana(50)
                .cd(15)
                .range(700);
        Nunu.E.update()
                .active("対象の敵ユニットに{1}と3秒間{2}、{3}を与える。")
                .variable(1, MagicDamage, 85, 45, ap(1))
                .variable(2, ASSlowRatio, 25)
                .variable(3, MSSlowRatio, 20, 10)
                .mana(75, 10)
                .cd(6)
                .range(550);
        Nunu.R.update()
                .active("最大3秒詠唱を行い、詠唱完了またはキャンセル時に{1}の敵ユニットに{2}を与える。ダメージは詠唱した時間に比例して最大で{3}。また詠唱中は範囲内の敵ユニットに{4}と{5}を与える。")
                .variable(1, Radius, 550)
                .variable(2, MagicDamage, 78, 31, ap(0.3))
                .variable(3, MagicDamage, 625, 250, ap(2.5))
                .variable(4, ASSlowRatio, 25)
                .variable(5, MSSlowRatio, 50)
                .mana(150)
                .cd(150, -30);
        Nunu.R.update(P3051).cd(110, -10).mana(100);
    }

    private static void Olaf() {
        Olaf.P.update().passive("{1}する。").variable(1, ASRatio, 0, 0, amplify(MissingHealthPercentage, 1));
        Olaf.Q.update()
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
        Olaf.W.update()
                .active("6秒間{1}と{2}と{3}を得る。")
                .variable(1, AD, 7, 7, amplify(Health, 0.01))
                .variable(2, LS, 9, 3)
                .variable(3, SV, 9, 3)
                .mana(40, 5)
                .cd(16)
                .update(P312)
                .active("6秒間{4}し、{2}を得る。また{5}する。")
                .variable(4, ASRatio, 20, 15)
                .variable(5, RestoreHealthRatio, 0, 0, amplify(MissingHealthPercentage, 0.4))
                .mana(30)
                .update(P313)
                .variable(4, ASRatio, 40, 10);
        Olaf.E.update()
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
        Olaf.R.update()
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

    private static void Pantheon() {
        Pantheon.P.update()
                .passive("通常攻撃を行うかスキルを使用するたびにスタックが1増加(最大4スタック)し、4スタック時に40DM以上の通常攻撃を受けるとスタックを消費して通常攻撃のダメージを無効化する。");
        Pantheon.Q.update()
                .active("対象の敵ユニットに槍を投げ{1}を与える。")
                .variable(1, PhysicalDamage, 65, 40, bounusAD(1.4))
                .mana(45)
                .cd(4)
                .range(600);
        Pantheon.W.update()
                .active("対象の敵Championに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。")
                .variable(1, MagicDamage, 50, 25, ap(1))
                .variable(2, Stun, 1)
                .mana(55)
                .cd(13, -1)
                .range(600)
                .update(P315)
                .active("対象の敵ユニットに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。");
        Pantheon.E.update()
                .passive("敵ユニットのHPが15%以下の時は通常攻撃が必ずクリティカルになり、またSpear Shotのダメージが1.5倍になる。")
                .active("指定方向に0.75秒間槍を突き出し、範囲内の敵ユニットに{1}を最大3回与える(0.25秒毎に1ヒット)。対象がChampionの場合、与えるダメージが{2}になる。")
                .variable(1, PhysicalDamage, 13, 10, bounusAD(0.6))
                .variable(2, PhysicalDamage, 26, 20, bounusAD(1.2))
                .mana(45, 5)
                .cd(10, -1)
                .range(400)
                .type(SkillType.Channel);
        Pantheon.R.update()
                .active("地点を指定して2秒後にジャンプし、その1.5秒後に指定地点の{1}に{2}と1秒間{3}を与えつつ落下する。DMは指定地点から離れるほど低減され、範囲最端では50%となる。ジャンプ前にキャンセルすると、消費した分のマナが回復し、このスキルのCDは10秒になる。")
                .variable(1, Radius, 1000)
                .variable(2, MagicDamage, 400, 300, ap(1))
                .variable(3, MSSlowRatio, 35)
                .mana(125)
                .cd(150, -15)
                .range(5500);
    }

    private static void Rammus() {
        Rammus.P.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(AR, 0.45));
        Rammus.Q.update()
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。スキルを再使用するか" + Rammus.W + "を使用するとキャンセルされる。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Knockup, 0.75)
                .variable(4, MSSlowRatio, 20, 5)
                .variable(5, MSRatio, 85)
                .mana(70, 10)
                .cd(10)
                .update(P315)
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。" + Rammus.W + "を使用するとキャンセルされる。");
        Rammus.W.update()
                .active("6秒間{1}と{2}を得て、Rammusを通常攻撃した敵ユニットに{3}を与える。効果中にPowerballを使用すると効果がキャンセルされる。また、このスキルを再使用することで効果をキャンセルできる。")
                .variable(1, AR, 40, 20)
                .variable(2, MR, 40, 20)
                .variable(3, MagicDamage, 15, 10, amplify(AR, 0.1))
                .mana(40)
                .cd(14);
        Rammus.E.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, Taunt, 1, 0.5)
                .variable(2, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(12)
                .range(325)
                .update(P315)
                .variable(1, Taunt, 1.25, 0.25)
                .mana(50);
        Rammus.R.update()
                .active("8秒間地震を発生させ{1}の敵ユニット及び建物に毎秒{2}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 65, 65, ap(0.3))
                .mana(120)
                .cd(60)
                .update(P315)
                .mana(100);
    }

    private static void Rengar() {
        Rengar.P.update()
                .passive("ステルス状態または茂みの中から相手を攻撃する際には、通常攻撃は{1}になり相手に飛びつくようになる。この効果はステルス状態が解除された、また茂みから出た後0.5秒の間でも発生し、またステルス状態や茂みの中の視界が取られていた場合でも発生する。また、Rengarがスキルで敵ユニットにダメージを与える度に1 Ferocityを得て、5 Ferocity貯まると全てを消費して強化されたスキルを使用することが出来る。")
                .variable(1, Range, 600);
        Rengar.Q.update()
                .active("{5}間次の通常攻撃に追加{1}を付与し、次の通常攻撃から4秒間{2}する。強化されると{5}間次の通常攻撃に追加{3}を付与し、次の通常攻撃から4秒間{4}する。")
                .variable(1, PhysicalDamage, 30, 30)
                .variable(2, ASRatio, 30, 5)
                .variable(3, PhysicalDamage, 30, 30, ad(1))
                .variable(-4, ASRatio, 90, 15)
                .variable(5, Time, 6)
                .cd(8, -0.5)
                .update(P401)
                .variable(5, Time, 2);
        Rengar.W.update()
                .active("{1}の敵ユニットに{2}を与える。また、このスキルが敵ユニットに命中すると、3秒間{3}と{4}を得る。強化されると{5}する。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 50, 30, ap(0.8))
                .variable(3, AR, 15, 7)
                .variable(4, MR, 15, 7)
                .variable(5, RestoreHealth, 40, 0, amplify(Lv, 20))
                .cd(15, -1)
                .update(P401)
                .active("{1}の敵ユニットに{2}を与える。また、このスキルが敵ユニットに命中すると、3秒間{3}と{4}を得る。強化されると{5}する。(失ったHealth1%毎に回復量が1%増加)")
                .variable(5, RestoreHealth, 20, 0, amplify(Lv, 10));
        Rengar.E.update()
                .active("対象の敵ユニットに投げ縄を投げ、{1}と2.5秒{2}を与える。スローは時間経過と共に元に戻る。強化されると{3}を与えるようになる。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.7))
                .variable(2, MSSlowRatio, 50, 5)
                .variable(3, Snare, 1)
                .cd(12, -1)
                .range(575);
        Rengar.R.update()
                .active("1秒後に{1}になり、{2}の敵Champion全員の{3}。ステルス準備中に攻撃を行うかダメージを受ける度に、ステルス状態になるのに必要な時間が1秒増加する。ステルス準備開始から3秒経過するとダメージを受けていてもステルス状態になる。ステルス状態の間は{4}し、0.75秒毎に1 Ferocityを得る。これらの効果はステルス状態が解除されると終了する。")
                .variable(1, Stealth, 7)
                .variable(2, Radius, 2000, 1000)
                .variable(3, Visionable)
                .variable(4, MSRatio, 20, 5)
                .cd(140, -35);
    }

    private static void Riven() {
        Riven.P.update()
                .passive("スキルを使用するごとに1チャージを得る。チャージがある状態で通常攻撃を行うと、チャージを消費して通常攻撃に{1}が付与される。チャージは最大3スタックされ、通常攻撃ごとに1チャージずつ消費される。チャージは5秒間増加または消費がないと0になる。建物には無効。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, new Per3LevelAdditional(0.2, 0.05)));
        Riven.Q.update()
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
        Riven.W.update()
                .active("{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 125)
                .variable(2, PhysicalDamage, 50, 30, bounusAD(1))
                .variable(3, Stun, 0.75)
                .cd(11, -1);
        Riven.E.update()
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
        Riven.R.update()
                .active("15秒間折れた剣の刃を再生させ、{1}増加し、射程が増加する(通常攻撃: {2} Broken Wings: {3} Ki Burst: {4})。また、このスキルを再度使用することで一度だけ0.5秒後に指定方向に巨大な衝撃波を発生させ、範囲内の敵ユニットに{5}与える。対象が受けているダメージに比例して与えるダメージが増加して、最大DMは{6}。")
                .variable(1, AD, 0, 0, ad(0.2))
                .variable(2, Range, 200)
                .variable(3, Range, 325)
                .variable(4, Range, 270)
                .variable(5, PhysicalDamage, 80, 40, bounusAD(0.6))
                .variable(6, PhysicalDamage, 240, 120, bounusAD(1.8))
                .cd(110, -30);
    }

    private static void Ryze() {
        Ryze.P.update().passive("スキルを使用すると使用した以外のスキルの{1}する。").variable(1, CDDecrease, 1);

        Ryze.Q.update()
                .active("対象の敵ユニットに{1}を与える。")
                .passive("{2}を得る。")
                .variable(1, MagicDamage, 60, 25, ap(0.4), amplify(Mana, 0.065))
                .variable(2, CDR, 2, 2)
                .mana(60)
                .cd(3.5)
                .range(650)
                .update(P310)
                .range(600)
                .update(P403)
                .range(625);

        Ryze.W.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 60, 35, ap(0.6), amplify(Mana, 0.045))
                .variable(2, Snare, 0.75, 0.25)
                .mana(80, 10)
                .cd(14)
                .range(625)
                .update(P310)
                .mana(60, 10)
                .range(600);

        Ryze.E.update()
                .active("対象の敵ユニットに魔法弾を飛ばし{1}と{2}を与える。魔法弾は{3}の敵ユニット及び自身に4回まで跳ね返る(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返り、また自身から跳ね返った弾は敵Championを優先で狙う。")
                .variable(1, MagicDamage, 50, 20, ap(0.35), amplify(Mana, 0.01))
                .variable(2, MRReduction, 12, 3)
                .variable(3, Radius, 400)
                .mana(60, 10)
                .cd(14)
                .range(675)
                .update(P310)
                .range(600);

        Ryze.R.update()
                .active("{1}間、{2}を得て{3}する。更にスキルに50%のスプラッシュダメージ({4})が付与される。")
                .variable(1, Time, 5, 1)
                .variable(2, SV, 15, 5)
                .variable(3, MS, 35, 10)
                .variable(4, Radius, 200)
                .cd(70, -10)
                .update(P310)
                .variable(3, MS, 60, 10)
                .update(P312)
                .variable(3, MS, 80);
    }

    private static void Sivir() {
        Sivir.P.update()
                .passive("敵Championに通常攻撃でダメージを与えると、2秒間{1}する。")
                .variable(-1, MSRatio, 50)
                .update(P306)
                .passive(("敵Championに通常攻撃か" + Sivir.Q + "もしくは" + Sivir.W + "でダメージを与えると、2秒間{1}する。"))
                .update(P315)
                .variable(-1, MSRatio, new Per5LevelWith18(30, 5));
        Sivir.Q.update()
                .active("指定方向にブーメランを投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに{2}ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定がある。")
                .variable(1, PhysicalDamage, 60, 45, ap(0.5), bounusAD(1.1))
                .variable(2, Percentage, 20)
                .mana(70, 10)
                .cd(9)
                .range(1200);
        Sivir.Q.update(P314).variable(1, PhysicalDamage, 25, 20, amplify(AD, 0.7, 0.1)).variable(2, Percentage, 10);
        Sivir.W.update()
                .active("次に行う通常攻撃に追加{1}が付与され、5回跳ね返る({2})ようになる。この追加ダメージはCriticalHitによって増幅される。On-Hit Effectsの効果は最初に当たったユニットにのみ発動し、跳ね返る毎にダメージが20%ずつ低下する。")
                .variable(1, PhysicalDamage, 20, 15)
                .variable(2, Radius, 450)
                .mana(40)
                .cd(7, -1);
        Sivir.W.update(P313)
                .active("次の3回の通常攻撃が{1}の全ての敵に跳ねるようになる。この跳ねは一番近くのユニットに跳ね、同一ユニットには一度しか当たらない。2匹目以降の敵には{2}を与える。On-Hit Effectsの効果は最初に当たったユニットにのみ発動する。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, 0, 0, amplify(AD, 0.5, 0.1))
                .cd(9, -1);
        Sivir.E.update()
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
        Sivir.R.update()
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

    private static void Skarner() {
        Skarner.P.update()
                .passive("通常攻撃を行うたびに、 Skarnerのすべてのスキルの{1}される(対象がChampionの場合は{2})。建物に対しては無効。")
                .variable(1, CDDecrease, 0.5)
                .variable(2, CDDecrease, 1);

        Skarner.Q.update()
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

        Skarner.W.update()
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

        Skarner.E.update()
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

        Skarner.R.update()
                .active("対象の敵Championに{1}と{2}を与える。効果中は対象の敵Championを引っ張る事が出来る。また、効果終了時に追加{3}を与える。")
                .variable(1, MagicDamage, 100, 50, ap(0.5))
                .variable(2, Suppression, 1.75)
                .variable(3, MagicDamage, 100, 50, ap(0.5))
                .mana(100, 25)
                .cd(130, -10)
                .range(350);
    }

    private static void Sona() {
        Sona.P.update()
                .passive("Auraを切り替えても、以前のAuraの効果が1秒間持続する。切替時は他のAuraスキルが0.5秒間CDになる。また、3回スキルを使用した後の通常攻撃に{1}と、そのとき展開しているAuraに応じた追加効果が発生する。<br>" + Sona.Q + " : 追加{1}を与える。<br>" + Sona.W + " : {3}間対象が与えるダメージが{4}減少するDebuffを与える。<br>" + Sona.E + " : 2秒間{2}を与える。")
                .variable(1, MagicDamage, 8, 0, amplify(Lv, 10))
                .variable(2, MSSlowRatio, 40)
                .variable(3, Time, 4)
                .variable(4, Percentage, 20);
        Sona.P.update(P308)
                .variable(1, MagicDamage, new Per1Level(new double[] {13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112,
                        122, 132, 147, 162, 177, 192}))
                .variable(3, Time, 3);
        Sona.P.update(P314)
                .variable(1, MagicDamage, new Per1Level(new double[] {13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112,
                        122, 132, 147, 162, 177, 192}), ap(0.2), null)
                .variable(4, Percentage, 20, 0, ap(0.02))
                .variable(2, MSSlowRatio, 40, 0, ap(0.04));
        Sona.Q.update()
                .active("最も近い敵ユニット2体に{4}を与える。Sonaの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。" + Sona.R + "以外の別のスキルを使うまで{1}の味方Championは{2}と{3}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, AD, 4, 4)
                .variable(3, AP, 4, 4)
                .variable(4, MagicDamage, 50, 50, ap(0.7))
                .mana(45, 5)
                .cd(7)
                .range(700);
        Sona.Q.update(P314).variable(4, MagicDamage, 50, 50, ap(0.5));
        Sona.W.update()
                .active("近くにいる最もHPが減っている味方Champion1体とSonaは{1}し、3秒間{2}と{3}を得る。" + Sona.R + "以外の別のスキルを使うまで{4}の味方Championは{5}と{6}を得る。")
                .variable(1, RestoreHealth, 40, 20, ap(0.25))
                .variable(2, AR, 8, 3)
                .variable(3, MR, 8, 3)
                .variable(4, Radius, 1000)
                .variable(5, AR, 3, 3)
                .variable(6, MR, 3, 3)
                .mana(60, 5)
                .cd(7)
                .range(1000);
        Sona.W.update(P308).variable(2, AR, 6, 1).variable(3, MR, 6, 1).variable(5, AR, 6, 1).variable(6, MR, 6, 1);
        Sona.W.update(P314).variable(1, RestoreHealth, 40, 15, ap(0.25));
        Sona.E.update()
                .active("1.5秒間{1}の味方ユニットは{2}する。" + Sona.R + "以外の別のスキルを使うまで{1}の味方Championは{3}する")
                .variable(1, Radius, 1000)
                .variable(2, MSRatio, 6, 2)
                .variable(3, MSRatio, 4, 4)
                .mana(65)
                .cd(7)
                .range(1000);
        Sona.E.update(P314).variable(2, MSRatio, 4, 2, ap(0.02));
        Sona.R.update()
                .active("前方{1}の敵Championに{2}と{3}を与える。")
                .variable(1, Radius, 1000)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1.5)
                .mana(100, 50)
                .cd(140, -20);
        Sona.R.update(P314).variable(2, MagicDamage, 150, 100, ap(0.5));
    }

    private static void Soraka() {
        Soraka.P.update().passive("{1}の味方Championは{2}を得る。").variable(1, Radius, 1000).variable(2, MR, 16);
        Soraka.P.update(P314)
                .passive("スキルによるHealth及びMana回復は、回復する対象の減少しているHealth/Mana2%につき、1%増加する(最大でHealth/Mana回復量1.5倍)。");
        Soraka.Q.update()
                .active("{1}の敵ユニットに{2}を与え、スタックを1つ増加させる。スタック1つにつき{3}を与える。スタックは5秒間持続し最大10まで増加する。")
                .variable(1, Radius, 675)
                .variable(2, MagicDamage, 60, 25, ap(0.4))
                .variable(3, MRReduction, 8, 1)
                .mana(20, 15)
                .cd(2.5);
        Soraka.Q.update(P314)
                .active("{1}の敵ユニットに{2}と{3}を与える。この減少効果は5秒間持続し最大10回まで累積する。また、このスキルが敵Championに命中すると、" + Soraka.W + "の{4}する。")
                .variable(2, MagicDamage, 60, 35, ap(0.4))
                .variable(3, MRReduction, 6, 0, ap(0.01))
                .variable(4, CDDecreaseRatio, 5, 1.25)
                .mana(30, 10);
        Soraka.W.update()
                .active("対象の味方ユニットは{1}し、{3}間{2}を得る。")
                .variable(1, RestoreHealth, 70, 70, ap(0.45))
                .variable(2, AR, 25, 20)
                .variable(3, Time, 3)
                .mana(80, 30)
                .cd(20)
                .range(750);
        Soraka.W.update(P314)
                .variable(1, RestoreHealth, 70, 50, ap(0.35))
                .variable(2, AR, 50, 15, ap(0.15))
                .variable(3, Time, 2)
                .mana(80, 20);
        Soraka.E.update()
                .active("対象の味方Championに使用すると{1}する。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .variable(1, RestoreMana, 40, 40)
                .variable(2, MagicDamage, 50, 50, ap(0.6))
                .variable(3, Silence, 1.5, 0.25)
                .cd(10)
                .range(725);
        Soraka.E.update(P314)
                .active("対象の味方Championに使用すると{1}し、Sorakaは{4}を失う。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .variable(1, RestoreMana, 20, 20, amplify(Mana, 0.05))
                .variable(2, MagicDamage, 40, 30, ap(0.4), amplify(Mana, 0.05))
                .variable(4, Mana, 0, 0, amplify(Mana, 0.05));
        Soraka.R.update()
                .active("全ての味方Championは{1}する。")
                .variable(1, RestoreHealth, 200, 120, ap(0.7))
                .mana(100, 75)
                .cd(160, -15);
        Soraka.R.update(P313).mana(100);
        Soraka.R.update(P314).variable(1, RestoreHealth, 150, 100, ap(0.55));
    }

    private static void Swain() {
        /** Swain */
        Swain.P.update().passive("敵ユニットを倒す毎に{1}する。").variable(1, RestoreMana, 9, 0, amplify(Lv, 1));
        Swain.P.update(P313)
                .passive("敵ユニットを倒す毎に{1}する。キルもしくはアシストする毎に{2}する。")
                .variable(2, RestoreMana, 0, 0, amplify(Mana, 0.09));
        Swain.Q.update()
                .active("Swainの位置にビームを吐くカラスを設置し、対象の敵ユニットに毎秒{1}と{2}を与える。3秒経つか対象のユニットがカラスの有効範囲外({3})に移動すると効果が切れる。")
                .variable(1, MagicDamage, 25, 15, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, Radius, 900)
                .mana(60, 10)
                .cd(8)
                .range(625);
        Swain.W.update()
                .active("地点を指定した0.5秒後に範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.7))
                .variable(2, Snare, 2)
                .mana(80, 10)
                .cd(18, -2)
                .range(900);
        Swain.E.update()
                .active("対象の敵ユニットに4秒かけて{1}を与える。また、効果中はSwainが対象のユニットに与える{2}する。")
                .variable(1, MagicDamage, 75, 40, ap(0.8))
                .variable(2, DamageRatio, 8, 3)
                .mana(65, 5)
                .cd(10)
                .range(625);
        Swain.R.update()
                .active("カラスに変身し、{0}の敵ユニット3体(敵Championを優先)に毎秒{1}を与える。また、{2}して敵Championの場合は{3}する。")
                .variable(0, Radius, 700)
                .variable(1, MagicDamage, 50, 25, ap(0.2))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 0.25))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamage, 0.75))
                .cd(8)
                .cost(Mana, new Diff(25, 0, 1), amplify(Duration, 5, 1))
                .type(SkillType.Toggle);
    }

    private static void Syndra() {
        Syndra.P.update().passive("各スキルを最高ランクまで上げると追加効果が発生する。");
        Syndra.Q.update()
                .active("指定地点にDark Sphereを召喚し、{1}の敵ユニットに{2}を与える。Dark Sphereはその後6秒間持続する。Lv5になるとChampionに対して{3}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MagicDamage, 264.5, 0, ap(0.69))
                .mana(40, 10)
                .cd(4)
                .range(800);
        Syndra.W.update()
                .active("指定したDark Sphereか敵minionまたは中立モンスター(DragonとBaronには無効)のいずれかを自身まで引き寄せ、最大5秒間引っ張り続ける。この際Dark Sphereを引き寄せた場合、そのDark Sphereの持続時間は引き寄せてから6秒間に更新される。その後再度地点を指定({5})することで指定地点に引き寄せたものを投げ、{1}の敵ユニットに{2}と1.5秒間{3}を与える。また指定地点の{4}。Lv5になるとスローの効果時間が2秒になる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 80, 40, ap(0.7))
                .variable(3, MSSlowRatio, 25, 5)
                .variable(4, Visionable)
                .variable(5, Radius, 900)
                .mana(60, 10)
                .cd(12, -1)
                .range(925);
        Syndra.E.update()
                .active("指定方向扇形の{1}にいる敵ユニットに{2}と{3}を与える。ノックバック距離はSyndraに近い地点にいるほど増加する。扇形の範囲内にDark Sphereがあった場合同様にノックバックさせ、それに当たった敵ユニットに{2}(このスキルのDMとは重複しない)と{4}を与える。Lv5になると範囲の横幅が50%増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, Knockback)
                .variable(4, Stun, 1.5)
                .mana(50)
                .cd(18, -1.5)
                .range(650);
        Syndra.E.update(P313).range(700);
        Syndra.R.update()
                .active("自身の周辺にDark Sphereを3つ召喚し、指定した敵Championに向けて自身の周囲に存在する全てのDark Sphereを向かわせ、{1}を与える。3個で{2}、7個で{3}になる。この際に召喚したDark Sphereは6秒間持続する。Lv3になると射程が75増加する。")
                .variable(1, MagicDamage, 90, 45, ap(0.2))
                .variable(2, MagicDamage, 270, 135, ap(0.6))
                .variable(3, MagicDamage, 630, 345, ap(1.4))
                .mana(100)
                .cd(100, -10)
                .range(675);
    }

    private static void Shyvana() {
        Shyvana.P.update()
                .passive("Shyvanaは通常攻撃時に次の効果を得る。Twin BiteのCDを0.5秒解消する。対象が建物の場合は無効。Burnoutの効果時間が1秒延長される。最大4秒延長できる。対象が建物の場合も有効。Flame BreathのAR低下を受けている敵ユニットに対し、Flame Breathのダメージの15%分の追加魔法DMが発生する。Dragon's Descent通常攻撃時に2Furyを得る。また、Human formの時には1.5秒毎に1Furyを得る。");
        Shyvana.P.update(P309)
                .passive("{1}と{2}を得る。この効果はDragon Form時には2倍になる。")
                .variable(1, AR, new Per5Level(5, 5))
                .variable(2, MR, new Per5Level(5, 5));
        Shyvana.Q.update()
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.8, 0.05))
                .variable(2, CDDecrease, 0.5)
                .cd(10, -1);
        Shyvana.Q.update(P309)
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。建物以外の対象を通常攻撃する毎に{2}する。{3}。")
                .variable(3, OnHitEffect);
        Shyvana.W.update()
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 25, 15, bounusAD(0.2))
                .variable(3, MSRatio, 30, 5)
                .cd(12)
                .update(P309)
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。通常攻撃をする毎に効果時間が1秒延長される(最大4秒増加)。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .update(P401)
                .variable(2, MagicDamage, 20, 15, bounusAD(0.2));

        Shyvana.E.update()
                .active("指定方向に火球を放ち当たった敵ユニットに{1}と４秒間{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 80, 45, ap(0.6))
                .variable(2, ARReductionRatio, 15)
                .cd(12, -1)
                .range(700)
                .update(P309)
                .active("指定方向に貫通する火球を放ち当たった敵ユニットに{1}と5秒間Debuffを与える。Debuffを受けている敵に通常攻撃をする毎に{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 80, 35, ap(0.6))
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2))
                .update(P401)
                .variable(1, MagicDamage, 60, 40, ap(0.6));
        Shyvana.R.update()
                .passive("{1}と{2}を得る。 Dragon Formの時は2倍になる。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒6Fury減少し、0になるとHuman Formに戻る。")
                .variable(3, MagicDamage, 175, 125, ap(0.7))
                .variable(4, Knockback)
                .range(1000);
        Shyvana.R.update(P309)
                .passive("Human formの時には1.5秒毎に{1}Furyを得る。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, Value, 1, 1)
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒5Fury減少し、0になるとHuman Formに戻る。");

    }

    private static void Taric() {
        Taric.P.update().passive("通常攻撃をすると{1}する。").variable(1, RestoreMana, 0, 0, amplify(DealtDamageRatio, 0.075));
        Taric.P.update(P303)
                .passive("通常攻撃に追加{1}を付与する。敵チャンピオンに対しては{2}を与える。建物には無効。")
                .variable(1, MagicDamage, 0, 0, amplify(Mana, 0.02))
                .variable(2, MagicDamage, 0, 0, amplify(Mana, 0.04));
        Taric.P.update(P314)
                .passive("スキルを使用した次の通常攻撃は追加{1}を与え、全スキルの{2}する。この効果は通常攻撃を行うか、一定時間経過すると解消される。")
                .variable(1, MagicDamage, 0, 0, amplify(AR, 0.3))
                .variable(2, CDDecrease, 2)
                .update(P315)
                .variable(1, MagicDamage, 0, 0, amplify(AR, 0.2));
        Taric.Q.update()
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。このスキルは自身が通常攻撃を行う毎にCDが1秒解消される。対象が敵Championの場合は3秒解消される。")
                .variable(1, RestoreHealth, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 84, 56, ap(0.84))
                .mana(80, 15)
                .cd(20, -1)
                .range(750);
        Taric.Q.update(P314)
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。")
                .variable(1, RestoreHealth, 60, 40, ap(0.3), amplify(BounusHealth, 0.05))
                .variable(2, RestoreHealth, 84, 56, ap(0.42), amplify(BounusHealth, 0.07))
                .mana(60, 20)
                .cd(18, -1);
        Taric.W.update()
                .passive("Taricは{1}を得て、味方Championの{1}を増加させる{2}のAuraを得る。(Taric自身はAuraと合わせて2倍の効果を得る)")
                .variable(1, AR, 10, 5)
                .variable(2, Radius, 1000)
                .active("{4}の敵ユニットに{5}を与え、4秒間{6}を与える。効果後はCDが解消されるまでPassiveのTaric自身の増加ARが無くなる。")
                .variable(4, Radius, 400)
                .variable(5, MagicDamage, 60, 45, ap(0.6))
                .variable(6, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(10);
        Taric.W.update(P303)
                .passive("Taricは{1}を得て、味方Championの{3}を増加させる{2}のAuraを得る。(Taric自身はAuraと両方の効果を得る)")
                .variable(3, AR, 0, 0, amplify(AR, 0.12))
                .variable(5, MagicDamage, 60, 45, ap(0.6), amplify(AR, 0.3))
                .mana(50);
        Taric.W.update(P304).variable(5, MagicDamage, 50, 40, ap(0.6), amplify(AR, 0.2));
        Taric.W.update(P314).variable(5, MagicDamage, 40, 40, amplify(AR, 0.3));
        Taric.W.update(P315)
                .variable(1, AR, 5, 5)
                .variable(3, AR, 0, 0, amplify(AR, 0.05))
                .variable(5, MagicDamage, 40, 40, amplify(AR, 0.2));
        Taric.E.update()
                .active("対象の敵ユニットに{1}と{2}を与える。魔法DMは対象との距離が近いほど増加し、距離が遠いほど低下する。最小DMは{3}。")
                .variable(1, MagicDamage, 80, 60, ap(0.8))
                .variable(2, Stun, 1.5)
                .variable(3, MagicDamage, 40, 30, ap(0.4))
                .mana(95)
                .cd(14, -1)
                .range(625);
        Taric.E.update(P303).mana(75);
        Taric.E.update(P304).variable(2, Stun, 1.2, 0.1);
        Taric.E.update(P314)
                .variable(1, MagicDamage, 80, 60, ap(0.4))
                .variable(3, MagicDamage, 40, 30, ap(0.2))
                .cd(18, -1);
        Taric.R.update()
                .active("{1}の敵ユニットに{2}を与える。スキル使用後の10秒間、{3}と{4}を得て、更に近くの味方Championの{5}と{6}を増加させるAura({7})を展開する。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, AD, 30, 20)
                .variable(4, AP, 30, 20)
                .variable(5, AD, 15, 10)
                .variable(6, AP, 15, 10)
                .variable(7, Radius, 1000)
                .mana(100)
                .cd(60);
        Taric.R.update(P314).variable(2, MagicDamage, 150, 100, ap(0.5)).cd(75);
    }

    private static void Talon() {
        Talon.P.update().passive("スロー、スタン、スネア、サプレッションを受けている状態の敵ユニットに対しては{1}する。").variable(1, AttackDamageRatio, 10);
        Talon.Q.update()
                .active("次の通常攻撃に{1}が付与される。対象がChampionの場合、更に6秒間対象を出血させその間毎秒{2}を与える。また出血中の対象の{3}。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.3))
                .variable(2, PhysicalDamage, 10, 10, bounusAD(1))
                .variable(3, Visionable)
                .mana(40, 5)
                .cd(8, -1);
        Talon.W.update()
                .active("前方指定範囲に飛んだ後すぐ戻る刃を投げ当たった敵ユニットに{1}と2秒間{2}を与える。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 30, 25, bounusAD(0.6))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(10)
                .range(600);
        Talon.E.update()
                .active("対象の敵ユニットに跳躍し{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。")
                .variable(1, Silence, 1)
                .variable(2, DamageRatio, 3, 3)
                .mana(35, 5)
                .cd(18, -2)
                .range(700)
                .update(P401)
                .active("対象の敵ユニットの背後に跳躍し{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。");
        Talon.R.update()
                .active("周囲に8本の刃を投げ当たった敵ユニットに{1}を与え、同時に{2}になり{3}する。ステルスが解除される、または敵ユニットを攻撃すると刃がTalonの元に戻ってくる。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 120, 50, bounusAD(0.75))
                .variable(2, Stealth, 2.5)
                .variable(3, MSRatio, 40)
                .mana(80, 10)
                .cd(75, -10)
                .range(1000);
    }

    private static void Teemo() {
        Teemo.P.update()
                .passive("2秒間動かないと{1}になる。何か行動を行うか、強制的に移動させられるとステルスが解除され、ステルス解除後3秒間{2}する。")
                .variable(1, Stealth)
                .variable(-2, ASRatio, 40);

        Teemo.Q.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 45, ap(0.8))
                .variable(2, Blind, 1.5, 0.25)
                .mana(70, 10)
                .cd(8)
                .range(680);

        Teemo.W.update()
                .passive("{1}する。敵Championかタワーからダメージを受けると5秒間効果が切れる。")
                .variable(1, MSRatio, 10, 4)
                .active("3秒間{1}し、Passiveの効果が切れることがなくなる。")
                .mana(40)
                .cd(17);

        Teemo.E.update()
                .passive("通常攻撃時に{1}と毒が付与される。毒は4秒間持続し、毎秒{2}を与える。合計で{3}。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, MagicDamage, 6, 6, ap(0.1))
                .variable(3, MagicDamage, 34, 34, ap(0.7));

        Teemo.R.update()
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒で{1}になる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と4秒間{4}を与える。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはChampionの通常攻撃でのみダメージを与えられる。")
                .variable(1, Stealth)
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 200, 125, ap(0.8))
                .variable(4, MSSlowRatio, 30, 10)
                .variable(5, CDRAwareTime, 35, -4)
                .cd(1)
                .mana(75, 25)
                .range(230)
                .update(P312)
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒で{1}になる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と4秒間{4}を与える。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはChampionの通常攻撃でのみダメージを与えられ、破壊すると{6}を得る。")
                .variable(6, Gold, 10)
                .update(P403)
                .variable(3, MagicDamage, 200, 125, ap(0.5));
    }

    private static void Thresh() {
        Thresh.P.update()
                .passive("{1}で敵ユニットが死んだ場合、一定の確率で魂を落とす。魂へ近づくか" + Thresh.W + "のランタンを魂の近くに置くとその魂を回収し、{2}と{3}を得る。落とした魂は15秒間持続し、敵チームがThreshの視界を得ていた場合、敵チームからも視認することができる。")
                .variable(1, Radius, 2000)
                .variable(2, AR, 0, 0, amplify(Stack, 1))
                .variable(3, AP, 0, 0, amplify(Stack, 1));
        Thresh.P.update(P310).variable(2, AR, 0, 0, amplify(Stack, 0.75)).variable(3, AP, 0, 0, amplify(Stack, 0.75));
        Thresh.Q.update()
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。")
                .variable(1, MagicDamage, 80, 30, ap(0.5))
                .variable(2, Stun, 1.5)
                .mana(80)
                .cd(18, -1.5)
                .range(1075);
        Thresh.Q.update(P306).variable(1, MagicDamage, 80, 40, ap(0.5));
        Thresh.Q.update(P312)
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。鎌が敵に命中した場合、このスキルの{3}する。")
                .variable(3, CDDecrease, 3)
                .cd(20, -2);
        Thresh.W.update()
                .active("指定地点に6秒間持続するランタンを設置する。味方Championがランタンを指定すると、ランタンとその味方Championが自身の方へと引き寄せられる。更にランタンの周囲にいる魂を自動的に回収し、{1}の味方Championは{2}を得る。。シールドを得られるのは1ユニットにつき1回のみ。自身がランタンから距離1500以上離れるとランタンは自動的に自身の下へと戻る。")
                .variable(1, Radius)
                .variable(2, Shield, 60, 40, ap(0.4))
                .mana(40)
                .cd(22, -1.5)
                .range(950);
        Thresh.E.update()
                .active("自身後方から前方への帯状領域内の敵ユニットに{1}を与える。また自身後方にいる敵ユニットは自身に近づく向きに、自身前方にいる敵ユニットには自身から遠ざかる向きにノックバックさせ、1.5秒間{2}を与える。")
                .variable(1, MagicDamage, 65, 40, ap(0.4))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(9)
                .range(400);
        Thresh.E.update(P306)
                .passive("通常攻撃に{3}を付与する。このDMはDamnationのスタック数と、自身が前回敵ユニットに通常攻撃をしてから経過した時間に比例して増加する。建物を攻撃した場合は追加魔法DMは発生せず、時間がリセットされる事もない。")
                .variable(2, MagicDamage, 65, 30, ap(0.4))
                .variable(3, MagicDamage, 0, 0, amplify(Stack, 1));
        Thresh.R.update()
                .active("{5}後、{4}に五角形の壁を創り出し、最初に壁に触れた敵Championに{1}と2秒間{2}を与える。2つ目以降の壁に触れた敵championには{3}と1秒間{2}を与える。敵が触れた部分の壁は破壊され消滅する。")
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

    private static void Tryndamere() {
        Tryndamere.P.update()
                .passive("{1}する。通常攻撃時に5Fury、クリティカル時に10Fury、Spinning Slashが敵ユニットに命中するたびに2Furyを得る。敵ユニットを倒すと追加で10Furyを得る。Furyの上限は100、8秒間戦闘を行わないと毎秒5Furyずつ減少していく。建物を攻撃した場合はFuryは増加しない。")
                .variable(-1, Critical, 0, 0, amplify(Stack, 0.35));
        Tryndamere.Q.update()
                .passive("{1}を得る。")
                .variable(1, AD, 5, 5, amplify(MissingHealthPercentage, 0.15, 0.05))
                .active("Furyをすべて消費し{2}する。")
                .variable(2, RestoreHealth, 30, 10, ap(1.5), amplify(Stack, 0.5, 0.45))
                .cd(12);
        Tryndamere.Q.update(P303).variable(2, RestoreHealth, 30, 10, ap(0.3), amplify(Stack, 0.5, 0.45, ap(0.012)));
        Tryndamere.W.update()
                .active("4秒間近くの敵Championに{1}を与え、後ろを向いている敵Championには更に4秒間{2}を与える。")
                .variable(1, ASSlowRatio, 20, 15)
                .variable(2, MSSlowRatio, 30, 7.5)
                .cd(14)
                .range(850);
        Tryndamere.E.update()
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。")
                .variable(1, PhysicalDamage, 70, 30, ap(1), bounusAD(1.2))
                .variable(2, CDDecrease, 2)
                .cd(13, -1)
                .range(660);
        Tryndamere.E.update(P313)
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。(ミニオンやモンスターに対して発生した場合は{3}する)")
                .variable(3, CDDecrease, 1);
        Tryndamere.R.update()
                .active("5秒間HPが1未満にならなくなる(死ななくなる)。また、このスキル使用時にFuryが{1}増加する。このスキルの使用は状態異常によって阻害されない。")
                .variable(1, Count, 50, 25)
                .cd(110, -10);
    }

    private static void Varus() {
        Varus.P.update()
                .passive("敵ユニットを倒すと3秒間{1}する。敵Championをキル/アシストすると6秒間{2}する。この効果はスタックしない。")
                .variable(-1, ASRatio, 20)
                .variable(-2, ASRatio, 40);
        Varus.Q.update()
                .active("最初にスキルを使用すると狙いを付ける。この間は通常攻撃や他のスキルを使用できなくなり、Varusの移動速度が20%低下するが、狙いを付けている間は徐々にこのスキルのダメージと射程距離が増加していく(2秒で最大)。再度このスキルを使用することで指定方向に貫通する矢を放ち、当たった敵ユニットに{1}を与える(最大で{2})。ダメージは敵に当たるごとに15%減少する。最小で33%。狙いを付けて4秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, PhysicalDamage, 10, 33, ad(1))
                .variable(2, PhysicalDamage, 15, 50, ad(1.65))
                .mana(70, 5)
                .cd(16, -2)
                .range(new Diff(850, 0, 1), amplify(Duration, 200));
        Varus.Q.update(P307).variable(1, PhysicalDamage, 10, 37, ad(1)).variable(2, PhysicalDamage, 15, 55, ad(1.65));
        Varus.W.update()
                .passive("通常攻撃に追加{1}と6秒間持続する疫病が付与される。疫病は3回までスタックする。疫病のスタックが付与されている敵ユニットにVarusの他のスキルが命中した場合、疫病のスタックを全て消費して1スタック毎に{2}を与える。")
                .variable(1, MagicDamage, 10, 4, ap(0.25))
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2, 0.75, ap(0.02)));
        Varus.E.update()
                .active("指定地点に矢の雨を放ち、範囲内の敵ユニットに{1}を与える。指定地点は4秒間呪われ、範囲内の敵ユニットに{2}と{3}を付与する。")
                .variable(1, PhysicalDamage, 65, 40, bounusAD(0.6))
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Wounds)
                .mana(80)
                .cd(18, -2)
                .range(925);
        Varus.E.update(P307).variable(1, PhysicalDamage, 65, 35, bounusAD(0.6));
        Varus.R.update()
                .active("指定方向に腐敗の蔓を投げつけ、当たった敵Championに{1}と{2}を与える。当たった敵Championからは徐々に腐敗が広がり({3})、腐敗に触れた敵Championにも同様の効果を与える。")
                .variable(1, MagicDamage, 150, 100, ap(1))
                .variable(2, Snare, 2)
                .variable(3, Radius, 550)
                .mana(120)
                .cd(120, -15)
                .range(1075);
        Varus.R.update(P313).mana(100);
    }

    private static void Vayne() {
        Vayne.P.update().passive("敵Championに向かって移動する際に{1}する。").variable(-1, MS, 30);
        Vayne.Q.update()
                .active("指定地点にローリングし、次の通常攻撃に追加{1}を付与する。6秒間攻撃を行わないとCDになる。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.3, 0.05))
                .mana(40)
                .cd(6, -1);
        Vayne.Q.update(P303).mana(30);
        Vayne.W.update()
                .passive("同じターゲットに3回連続して通常攻撃またはスキルで攻撃すると、{1}を与える。（モンスターやミニオンに対しては上限200）")
                .variable(1, TrueDamage, 20, 10, amplify(TargetMaxHealthRatio, 3, 1));
        Vayne.E.update()
                .active("対象の敵ユニットをヘビークロスボウで狙撃し{1}と{2}を与える。ノックバックした敵が壁等に当たると追加で{1}と{3}を与える。")
                .variable(1, PhysicalDamage, 45, 35, bounusAD(0.5))
                .variable(2, Knockback, 470)
                .variable(3, Stun, 1.5)
                .mana(90)
                .cd(20, -2)
                .range(650);
        Vayne.E.update(P310).range(550);
        Vayne.R.update()
                .active("{1}間{2}を得て、Tumbleを使うと{3}になり、Night Hunterの移動速度増加が3倍になる。")
                .variable(1, Time, 8, 2)
                .variable(2, AD, 25, 15)
                .variable(3, Stealth, 1)
                .mana(80)
                .cd(70);
    }

    private static void VelKoz() {
        Velkoz.P.update(P403)
                .passive("スキルで敵ユニットにダメージを与える度に対象にスタックを付与し、対象のスタックが3になるとスタックを全て消費して{1}を与える。スタックは7秒間持続する。通常攻撃を行うと、既に存在しているスタックの持続時間を7秒に戻す。")
                .variable(1, TrueDamage, 25, 0, amplify(Lv, 10));

        Velkoz.Q.update(P403)
                .active("指定方向にプラズマを放ち、当たった敵ユニットに{1}と{2}かけて減衰する{3}を与える。スキルを再使用するか、プラズマが敵ユニットに命中するとプラズマが90度の方向に分裂し、分裂したプラズマに当たった敵ユニットにも同様の効果を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.6))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 70)
                .mana(40, 5)
                .cd(7)
                .range(1050);

        Velkoz.W.update(P403)
                .active("スタックを1消費して、ビームで指定方向に裂け目を発生させ、直線状にいる敵ユニットに{1}を与える。裂け目は0.25秒後に爆発し、{2}にいる敵ユニットに{3}を与える。スタックは{4}毎に増加する（最大2）。")
                .variable(1, MagicDamage, 30, 20, ap(0.25))
                .variable(2, Radius)
                .variable(3, MagicDamage, 45, 30, ap(0.375))
                .variable(4, CDRAwareTime, 19, -1)
                .mana(50, 5)
                .cd(-1.5)
                .range(1050);

        Velkoz.E.update(P403)
                .active("指定地点を爆発させ、{1}の敵ユニットに{2}と{3}を与える。命中した敵はVel'Kozから遠ざかるように吹き飛ぶ。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 30, ap(0.5))
                .variable(3, Suspension, 0.75)
                .mana(50, 5)
                .cd(16, -1)
                .range(850);

        Velkoz.R.update(P403)
                .active("最大2.5秒間カーソルの場所目掛けて貫通するレーザーを放ち、0.25秒毎に{1}にいる敵ユニットに{2}と1秒間{3}を与える（2.5秒間当て続けた場合は{4}）。また0.5秒毎に" + Velkoz.P + "のスタックが増加する。スキルを再使用することで中断できる。ミニオン(モンスターには無効)に対しては500%のダメージを与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 50, 20, ap(0.06))
                .variable(3, MSSlowRatio, 20)
                .variable(4, MagicDamage, 500, 200, ap(0.6))
                .mana(100)
                .cd(130, -20)
                .range(1575)
                .type(SkillType.Channel);
    }

    private static void Viktor() {
        Viktor.P.update()
                .passive("Hex Coreという、自身のステータスとスキルの効果を強化するアイテムを所持している。Hex Coreは1度だけショップで1000Gを消費して以下の３通りのいずれかにアップグレードすることが出来る。Hex CoreはViktorのアイテムスロットを1つ占有し、売却することは出来ない。<br>Hex Core : {1}を得る。<br>Augment Power : {1}、{2}、{3}を得る。また、Power Transfer使用・命中時に移動速度が3秒間30%増加する。<br>Augment Gravity : {1}、{4}、{5}、{6}を得る。また、Gravity Fieldの射程が30%増加する。<br>Augment Death : {1}、{7}を得る。また、Death Rayにダメージの30%分の追加魔法DMが付与される。このダメージは4秒間かけて与える。")
                .variable(-1, AP, 0, 0, amplify(Lv, 3))
                .variable(-2, Health, 220)
                .variable(-3, Hreg, 6)
                .variable(-4, Mana, 200)
                .variable(-5, CDR, 10)
                .variable(-6, Mreg, 5)
                .variable(-7, AP, 45);
        Viktor.Q.update()
                .active("対象の敵ユニットに{1}を与え、3秒間{2}を得る。")
                .variable(1, MagicDamage, 80, 45, ap(0.65))
                .variable(2, Shield, 0, 0, amplify(DealtDamageRatio, 40))
                .mana(45, 5)
                .cd(9, -1)
                .range(600);
        Viktor.W.update()
                .active("0.25秒詠唱後、指定範囲に4秒間持続する重力束縛装置を呼び出し、範囲内の敵ユニットに{1}を与え、0.5秒毎にスタックを付与する。スタックが3溜まった敵ユニットに{2}を与える。")
                .variable(1, MSSlowRatio, 28, 4)
                .variable(2, Stun, 1.5)
                .mana(65)
                .cd(17, -1)
                .range(625);
        Viktor.E.update()
                .active("指定地点から指定方向にビームを発射し、ビームが通過する線上の敵ユニットに{1}を与える。また、ビームが通過した地点の{2}。")
                .variable(1, MagicDamage, 70, 45, ap(0.7))
                .variable(2, Visionable)
                .mana(70, 10)
                .cd(13, -1)
                .range(700);
        Viktor.R.update()
                .active("指定地点に7秒間持続する特異点を呼び出し、{1}の敵ユニットに{2}と{3}を与える。特異点は周囲の敵ユニットに毎秒{4}を与え、また近くにいる敵Championを自動的に追尾する。このスキルがActiveの間に再度地点を指定することで、特異点を指定した地点に手動で移動させる事が出来る。最大で{5}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 150, 100, ap(0.55))
                .variable(3, Silence, 0.5)
                .variable(4, MagicDamage, 40, 20, ap(0.25))
                .variable(5, MagicDamage, 430, 240, ap(2.23))
                .mana(125, 50)
                .cd(120)
                .range(700);
        Viktor.R.update(P313).mana(100);
    }

    private static void Xerath() {
        Xerath.P.update()
                .passive("{1}を得る。")
                .variable(1, AR, 0, 0, ap(0.15))
                .update(P402)
                .passive("通常攻撃を行うと{1}する。Championを攻撃した場合は回復量が2倍になる。建物に対しては無効。")
                .variable(1, RestoreMana, new Per1Level(new double[] {30, 33, 36, 42, 48, 54, 6372, 81, 90, 102, 114,
                        126, 138, 150, 165, 180.195}))
                .cd(-12);
        Xerath.Q.update()
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
        Xerath.W.update()
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
        Xerath.E.update()
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
        Xerath.R.update()
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

    private static void Yasuo() {
        Yasuo.P.update(P315)
                .passive("一定距離({1})を移動すると最大値の1%のFlowを得る。{2}するがクリティカルダメージは10%減少する。この減少効果はダメージ増減算の前に適用される。(例：本来200%のクリティカルダメージは(100 - 10) x 2 = 180%になり、" + Item.InfinityEdge.name + "を持った場合本来250%のダメージが(100 - 10) * 2.5 = 225%になる)。Flowが最大値の時、敵Championかモンスターからダメージを受けると全てのFlowを消費して{5}間{3}を得る。")
                .variable(1, Value, 40)
                .variable(2, Critical, 0, 0, amplify(Critical, 1))
                .variable(3, Shield, new Per1Level(new double[] {60, 65, 70, 75, 85, 95, 110, 125, 145, 170, 200, 240,
                        290, 350, 420, 500, 590, 690}))
                .variable(5, Time, 2)
                .update(P402)
                .variable(1, Value, 46)
                .update(P403)
                .variable(5, Time, 1.5)
                .variable(3, Shield, new Per1Level(new double[] {60, 65, 70, 75, 80, 90, 100, 110, 125, 140, 160, 185,
                        215, 250, 290, 340, 400, 470}));

        Yasuo.Q.update(P315)
                .active("指定した方向の直線上にいる全ての敵({1})に{2}を与える。" + Yasuo.E + "の使用中に起動した場合、{3}の敵にダメージを与える。このスキルは3回まで連続して使用でき、3度目の使用では{4}になり{5}を追加で与える。このスキルは通常攻撃として扱われ(クリティカル適用)、固定のCDを持つが、増加AS1.72%毎に再使用時間が1%減少する（最大で66%）。{6}。")
                .variable(1, Distance, 475)
                .variable(2, PhysicalDamage, 20, 20, ad(1))
                .variable(3, Radius, 375)
                .variable(4, Distance, 900)
                .variable(5, Knockup)
                .variable(6, OnHitEffect)
                .cd(-6, 0.5);

        Yasuo.W.update(P315)
                .passive(Yasuo.E + "か" + Yasuo.R + "を使用すると最大値の{1}のFlowを得る。")
                .variable(1, Percentage, 4, 4)
                .active("3.75秒間持続する{2}の壁を作り出す。この壁はタワー攻撃を除く全ての投射物をブロックする。")
                .variable(2, Length, 300, 50)
                .cd(26, -2)
                .range(400)
                .update(P402)
                .variable(1, Percentage, 3, 3);

        Yasuo.E.update(P315)
                .active("マークの付いていない対象の敵の方向に飛び込み一定距離({2})移動する。対象に{1}を与え{3}間マークを付与する。スキル使用時にスタックが増加し、1スタックごとに基礎ダメージが25%増加していく。(最大4スタックで{4})")
                .variable(1, MagicDamage, 70, 20, ap(0.6))
                .variable(2, Value, 475)
                .variable(3, Time, 10, -1)
                .variable(4, MagicDamage, 140, 40, ap(0.6))
                .cd(0.5, -0.1)
                .range(475);

        Yasuo.R.update(P315)
                .active("近くの空中にいる敵Championまで瞬時に移動して、対象と{1}にいる敵Championを1秒間空中に留めて{2}を与える。地面に着地すると、15秒間{3}を得る。")
                .variable(1, Radius, 400)
                .variable(2, PhysicalDamage, 200, 100, bounusAD(1.5))
                .variable(3, BounusARPenRatio, 50)
                .cd(80, -25)
                .range(1300)
                .update(P401)
                .active("Flowが最大となる。近くの空中にいる敵Championまで瞬時に移動して、対象と{1}にいる敵Championを1秒間空中に留めて{2}を与える。地面に着地すると、15秒間{3}を得る。")
                .update(P402)
                .range(1200);
    }

    private static void Yorick() {
        Yorick.P.update()
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、スロー無効化、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}")
                .variable(1, DamageReductionRatio, 0, 0, amplify(Stack, 5))
                .variable(2, AttackDamageRatio, 0, 0, amplify(Stack, 5))
                .variable(3, Value, 0, 0, amplify(Health, 0.35))
                .variable(4, Value, 0, 0, ad(0.35))
                .variable(5, Value, 10, 0, amplify(Lv, 2))
                .variable(6, Value, 20, 0, amplify(Lv, 2))
                .variable(7, Value, new Per5LevelForYoric(300, 40))
                .variable(8, Gold, 5)
                .update(P402)
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}");

        Yorick.Q.update()
                .active("次の通常攻撃は{1}を与えると同時にSpectral Ghoulを召喚する。Spectral Ghoulは{3}を得る。Spectral Ghoulが生存している間、Ghoulと自身の{q2}する。")
                .variable(1, PhysicalDamage, 30, 30, ad(1.2))
                .variable(2, MSRatio, 15, 5)
                .variable(-3, AD, 8, 8)
                .mana(40)
                .cd(9, -1);
        Yorick.W.update()
                .active("指定地点を爆発させ{1}の敵ユニットに{2}と1.5秒{3}を与え、同時にその地点にDecaying Ghoulを召喚する。Decaying Ghoulは近くの敵ユニットに継続的に{4}与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 35, ap(1))
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, MSSlowRatio, 10, 2.5)
                .mana(55, 5)
                .cd(12)
                .range(600);
        Yorick.E.update()
                .active("対象の敵ユニットに{1}を与え、{2}し対象の背後にRavenous Ghoulを召喚する。Ravenous Ghoulが通常攻撃を行うたびに{3}する。敵Championを攻撃した場合は{4}する。")
                .variable(1, MagicDamage, 55, 30, bounusAD(1))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 40))
                .variable(3, RestoreHealth, 0, 0, ad(0.175))
                .variable(4, RestoreHealth, 0, 0, ad(0.35))
                .mana(55, 5)
                .cd(10, -1)
                .range(550);
        Yorick.R.update()
                .active("対象の味方Champion一人の姿形を持ったRevenantを召喚する(ALT押しながら右クリックで任意の操作可能)。Revenantは10秒間持続し、対象の{1}の攻撃力を持つ。Revenantが生存している間に対象となった味方Championが死亡した場合、Revenantが消滅し、死亡した味方ChampionはHPとMNが最大の状態で蘇生される。蘇生した味方Championは10秒経過すると消滅する。")
                .variable(1, Percentage, 45, 15)
                .mana(100)
                .cd(120, -15)
                .range(900);
    }

    private static void Zac() {
        Zac.P.update()
                .passive("Zacのスキルが敵ユニットに命中する度に小型のスライムが出現する。スライム({5})を自身が回収すると{1}し、敵が回収すると消滅する。また、ZacのHealthが0になった時4つのスライムに分裂し一定時間かけて復活する。復活中にすべてのスライムが死亡するとZacも死亡する。復活時のHealthは生きているスライムの数に比例し増加(10-50%)する。スライムは以下のステータスを持つ。<br>Health : {2}<br>AR : {3}<br>MR : {4}")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.04))
                .variable(2, Value, 0, 0, amplify(Health, 0.12))
                .variable(3, Value, 0, 0, amplify(AR, 0.5))
                .variable(4, Value, 0, 0, amplify(MR, 0.5))
                .variable(5, Radius, 100)
                .cd(300)
                .update(P310)
                .variable(5, Radius, 25)
                .update(P403)
                .variable(5, Radius, 50);

        Zac.Q.update()
                .active("指定方向に腕を伸ばし範囲内にいる敵ユニットに{1}と2秒間{2}を与える。")
                .variable(1, MagicDamage, 70, 40, ap(0.5))
                .variable(2, MSSlowRatio, 20, 5)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(9, -0.5)
                .range(550);

        Zac.W.update()
                .active("{1}にいる敵ユニットに{2}を与える。(Minionに対しては200DMが上限)")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 15, amplify(TargetMaxHealthRatio, 4, 1, ap(0.02)))
                .cost(CurrentHealthRatio, 4, 0)
                .cd(4);

        Zac.E.update()
                .active("発動するとZacがその場で停止しチャージを行う。チャージした時間に比例して射程が前方扇形範囲で徐々に増加する。再度使用で指定した地点にジャンプし、着地時に範囲内にいる敵ユニットに{1}と{2}を与える。チャージは移動を行う事でキャンセルできる。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Knockback)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(24, -3)
                .range(1150, 100)
                .update(P310)
                .variable(1, MagicDamage, 80, 40, ap(0.7));

        Zac.R.update()
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

    private static void Zed() {
        Zed.P.update()
                .passive("HPが50%以下の敵ユニットへの通常攻撃に{1}を付与する。同一の対象には10秒に一度しか発動しない。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, new Per6LevelForZed(6, 2)));
        Zed.Q.update()
                .active("Zedと「影」から指定方向に貫通する手裏剣を飛ばし、当たった敵ユニットに{1}を与える。手裏剣は一度敵ユニットに当たるとそれ以降の敵ユニットには{3}を与える。Zedと「影」が同一の対象に手裏剣を命中させた場合、2発目以降は{2}を与える。")
                .variable(1, PhysicalDamage, 75, 35, bounusAD(1))
                .variable(2, PhysicalDamage, 37.5, 20, bounusAD(0.5))
                .variable(3, PhysicalDamage, 60, 32, bounusAD(0.8))
                .cost(Energy, 75, -5)
                .cd(6)
                .range(900);
        Zed.Q.update(P303).variable(1, PhysicalDamage, 75, 40, bounusAD(1));
        Zed.Q.update(P307).variable(3, PhysicalDamage, 45, 24, bounusAD(0.6));
        Zed.W.update()
                .passive("{1}を得る。")
                .variable(1, AD, 0, 0, amplify(BounusAD, 0.05, 0.05))
                .active("Zedの「影」が指定方向にダッシュし({5})、4秒間その場に留まり{2}の{3}。再度このスキルを使用するとZedと「影」の位置が入れ替わる。「影」はZedが通常スキルを使用すると同時に同じスキルを使用する。この時スキルがZedのスキルと同一の敵ユニットに命中した場合、{4}する。回復効果はスキル1回毎に1度のみ発動する。")
                .variable(2, Radius, 1300)
                .variable(3, Visionable)
                .variable(4, RestoreEnergy, 20, 5)
                .variable(5, MissileSpeed, 2500)
                .cost(Energy, 40, -5)
                .cd(22, -1.5)
                .range(550);
        Zed.W.update(P306).cd(18, -1);
        Zed.W.update(P307).variable(2, Radius, 700);
        Zed.W.update(P313).variable(5, MissileSpeed, 1500);
        Zed.E.update()
                .active("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵ユニットに当たる度にLiving ShadowのCDを1秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。")
                .variable(1, Radius, 290)
                .variable(2, PhysicalDamage, 60, 35, bounusAD(0.9))
                .variable(3, MSSlowRatio, 30, 7.5)
                .cost(Energy, 50, 0)
                .cd(3);
        Zed.E.update(P303).variable(2, PhysicalDamage, 60, 30, bounusAD(0.9));
        Zed.E.update(P306)
                .active("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵Championに当たる度にLiving ShadowのCDを2秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。");
        Zed.E.update(P307).cd(4);
        Zed.R.update()
                .active("対象の敵Championにダッシュしマークを付与する。ダッシュ中は0.35秒間ターゲット不可状態になる。また対象の背後に4秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1), amplify(DealtDamageRatio, 20, 15))
                .variable(2, Radius, 1100)
                .cd(120, -20)
                .range(625);
        Zed.R.update(P313)
                .active("対象の敵Championにダッシュしマークを付与する。ダッシュ中は0.75秒間ターゲット不可状態になる。また詠唱地点に6秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。")
                .variable(2, Radius, 2000);
    }

    private static void Ziggs() {
        Ziggs.P.update()
                .passive("12秒毎に通常攻撃に追加{1}が付与される。Ziggsがスキルを使う度に{2}する。建物に対しては1.5倍のDMを与える。")
                .variable(1, MagicDamage, 13, 0, ap(0.35), amplify(Lv, 7))
                .variable(2, CDDecrease, 4)
                .update(P313)
                .variable(1, MagicDamage, new Per1Level(new double[] {20, 27, 34, 41, 48, 56, 64, 72, 80, 88, 96, 105,
                        114, 123, 132, 141, 150, 160}), ap(0.35), null)
                .update(P402)
                .variable(1, MagicDamage, new Per1Level(new double[] {20, 24, 28, 32, 36, 40, 48, 56, 64, 72, 80, 88,
                        100, 112, 124, 136, 148, 160}), amplify(AP, new Per6Level(0.25, 0.05)), null);

        Ziggs.Q.update()
                .active("指定地点に跳ねながら転がる爆弾を投げ、爆発時に{1}の敵ユニットに{2}を与える。敵に当たらなかった場合には投げた方向に2回までバウンドする。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 75, 45, ap(0.65))
                .mana(50, 10)
                .cd(6, -0.5)
                .range(850);
        Ziggs.W.update()
                .active("指定地点に{6}で火薬を投げ、爆発時に{1}の敵ユニットに{2}を与え、{3}させる。Ziggsが範囲内にいた場合は自分も{3}する(Ziggsにダメージは無し)。火薬は4秒経つか、スキルを再度使用すると爆発する。また火薬は{5}。")
                .variable(1, Radius, 275)
                .variable(2, MagicDamage, 70, 35, ap(0.35))
                .variable(3, Knockback, 350)
                .variable(5, Visionable)
                .variable(6, MissileSpeed, 1600)
                .mana(65)
                .cd(26, -2)
                .range(1000);
        Ziggs.W.update(P309).variable(6, MissileSpeed, 1750).variable(3, Knockback, 400);
        Ziggs.W.update(P313).variable(1, Radius, 325);
        Ziggs.E.update()
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

        Ziggs.R.update()
                .active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 250, 125, ap(0.9))
                .variable(3, Radius, 750)
                .variable(4, MagicDamage, 200, 100, ap(0.72))
                .mana(100)
                .cd(120, -15)
                .range(5300);
        Ziggs.R.update(P313).active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。ミニオンやモンスターには2倍のダメージを与える。");
    }

    private static void Zyra() {
        Zyra.P.update()
                .passive("死亡すると2秒後にその場で植物に変形し、指定方向に一度だけ貫通する光線を放つことができる。光線に当たった敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 80, 0, amplify(Lv, 20))
                .range(1500);
        Zyra.Q.update()
                .active("地面から棘を出現させ、指定範囲内の敵ユニットに{1}を与える。種にHitした場合Thorn Spitterに成長し、{3}の敵を自動攻撃して{2}を与える。Thorn Spitterは10秒間持続する。")
                .variable(1, MagicDamage, 75, 40, ap(0.6))
                .variable(2, MagicDamage, 26, 0, amplify(Lv, 6), ap(0.2))
                .variable(3, Radius, 650)
                .mana(75, 5)
                .cd(7, -0.5)
                .range(825);
        Zyra.Q.update(P313)
                .variable(1, MagicDamage, 70, 35, ap(0.65))
                .variable(2, MagicDamage, 23, 0, amplify(Lv, 6.5), ap(0.2))
                .range(800);
        Zyra.W.update()
                .passive("{1}を得る。")
                .variable(1, CDR, 4, 4)
                .active("指定地点に30秒持続する種を植える。他のスキルを種に当てることで成長させることができる。敵Championが種を踏んだ場合、視界を2秒間得る。{2}毎にチャージが1つ増加し最大2つまでチャージされる。種が植物に成長し、同一ユニットに複数の植物がDMを与える場合、2体目以降は50%のダメージを与える。")
                .variable(2, CDRAwareTime, 17, -1)
                .range(825)
                .cost(Charge, 1, 0);
        Zyra.W.update(P313).variable(1, CDR, 2, 2);
        Zyra.E.update()
                .active("指定方向に蔓を放ち、当たった全ての敵ユニットに{1}と{2}を与える。種にHitした場合Vine Lasherに成長し、{3}の敵を自動攻撃して{4}と2秒間{5}を与える。Vine Lasherは10秒間持続する。")
                .variable(1, MagicDamage, 60, 35, ap(0.5))
                .variable(2, Snare, 0.75, 0.25)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 26, 0, amplify(Lv, 6), ap(0.2))
                .variable(5, MSSlowRatio, 30)
                .mana(70, 5)
                .cd(14, -1)
                .range(1100);
        Zyra.E.update(P313).variable(4, MagicDamage, 23, 0, amplify(Lv, 6.5), ap(0.2));
        Zyra.R.update()
                .active("指定地点に藪を召還し、{1}の全ての敵に{2}を与え、2秒後に{3}。成長した植物にHitした場合、その植物の攻撃速度が50%増加する。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 180, 85, ap(0.75))
                .variable(3, Knockup, 0)
                .mana(100, 20)
                .cd(130, -10)
                .range(700);
    }
}
