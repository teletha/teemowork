/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;
import static teemowork.model.Version.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;

/**
 * @version 2013/12/01 12:39:34
 */
public class Ability extends Describable<AbilityDescriptor> {

    /** The ability. */
    public static final Ability AegisValor = new Ability("Valor", ability -> {
        ability.aura("{1}の味方ユニットは{2}を得る。味方ミニオンは与えるダメージが15%増加する。")
                .variable(1, Radius)
                .variable(2, Hreg, 10)

                .update(P314)
                .passive("{1}の味方ミニオンは与えるダメージが15%増加する。");
    });

    /** The ability. */
    public static final Ability Aid = new Ability("Aid", ability -> {
        ability.passive("サモナースペルのHeal, Clairvoyance, ClarityのCDを30%減少させる。");
    });

    /** The ability. */
    public static final Ability ArcticEmbrace = new Ability("Arctic Embrace", ability -> {
        ability.active("対象（{1}）とその{2}の敵に{3}と2秒かけて減衰する{4}を与える。{5}")
                .variable(1, Radius, 850)
                .variable(2, Radius, 225)
                .variable(3, MagicDamage, 50, 0, amplify(Lv, 5))
                .variable(4, MSSlowRatio, 80)
                .variable(5, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability ArchangelInsight = new Ability("洞察", ability -> {
        ability.passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Mana, 0.03));
    });

    /** The ability. */
    public static final Ability ARPen10 = new Ability(ability -> {
        ability.passive("{1}を得る。").variable(1, ARPen, 10);
    });

    /** The ability. */
    public static final Ability ARPen20 = new Ability(ability -> {
        ability.passive("{1}を得る。").variable(1, ARPen, 20);
    });

    /** The ability. */
    public static final Ability Avarice = new Ability("強欲", ability -> {
        ability.passive("{1}を得る。").variable(1, GoldPer10Sec, 3);
    });

    /** The ability. */
    public static final Ability Awe = new Ability("畏怖", ability -> {
        ability.passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Mana, 0.02));
    });

    /** The ability. */
    public static final Ability BlastingSmite = new Ability("破裂のスマイト", ability -> {
        ability.passive("ターゲットの周囲にいるモンスターとミニオンに半分のダメージを与え、全てのユニットに{1}を与える。「スマイト」をモンスターに使用すると、{2}し{3}する。")
                .variable(1, Stun, 1.5)
                .variable(2, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 15))
                .variable(3, RestoreMana, 0, 0, amplify(MissingManaRatio, 15));
    });

    /** The ability. */
    public static final Ability BlockDamage = new Ability(ability -> {
        ability.passive("{1}する。").variable(1, AttackDamageReductionRatio, 10);
    });

    /** The ability. */
    public static final Ability BountyHunter = new Ability("Bounty Hunter", ability -> {
        ability.passive("キル、アシストもしくは伝説のモンスターを倒すと{1}を、巨大モンスターを倒すと{2}を得る。").variable(1, Gold, 40).variable(2, Gold, 10);
    });

    /** The ability. */
    public static final Ability BowDamage = new Ability(ability -> {
        ability.passive("通常攻撃命中時に追加で{1}を与える。").variable(1, PhysicalDamage, 10);
    });

    /** The ability. */
    public static final Ability BulwarkLegion = new Ability("Legion", ability -> {
        ability.aura("{1}の味方ユニットは{2}、{3}、{4}を得る。味方ミニオンに対しては効果が1.5倍になる。")
                .variable(1, Radius, 1100)
                .variable(2, AR, 10)
                .variable(3, MR, 25)
                .variable(4, Hreg, 10);
    });

    /** The ability. */
    public static final Ability Butcher = new Ability("Butcher", ability -> {
        ability.passive("中立モンスターに対するダメージが{1}上昇する。")
                .variable(1, Percentage, 25)

                .update(P308)
                .variable(1, Percentage, 30);
    });

    /** The ability. */
    public static final Ability CDR10 = new Ability(ability -> {
        ability.passive("{1}を得る。").variable(1, CDR, 10);
    });

    /** The ability. */
    public static final Ability ChallengingSmite = new Ability("覚悟のスマイト", ability -> {
        ability.passive("「スマイト」で敵のチャンピオンを攻撃できるようになる。対象のチャンピオンは4秒間マークされ{3}。対象への通常攻撃の命中時に3秒間かけて{1}を与え、対象から受ける{2}する。")
                .variable(1, TrueDamage, 54, 0, amplify(Lv, 6))
                .variable(2, DamageReductionRatio, 20)
                .variable(3, Visionable);
    });

    /** The ability. */
    public static final Ability ChillingSmite = new Ability("冷気のスマイト", ability -> {
        ability.passive("「スマイト」で敵のチャンピオンを攻撃できるようになる。対象のチャンピオンに{1}と2秒間{2}を与え、その移動速度を自身に加算する。")
                .variable(1, TrueDamage, 20, 0, amplify(Lv, 8))
                .variable(2, MSSlowRatio, 20);
    });

    /** The ability. */
    public static final Ability Cleave = new Ability("なぎ払い", ability -> {
        ability.passive("通常攻撃は{1}のユニットに{2}を与える。ダメージは攻撃対象から離れるにつれて減少し、最小で{3}になる。")
                .variable(1, Radius, 385)
                .variable(2, PhysicalDamage, 0, 0, ad(0.6))
                .variable(3, PhysicalDamage, 0, 0, ad(0.2));
    });

    /** The ability. */
    public static final Ability ColdSteel = new Ability("冷たい鋼", ability -> {
        ability.passive("通常攻撃を受けた際に対象に{2}間{1}を与える。").variable(1, ASSlowRatio, 15).variable(2, Time, 1);
    });

    /** The ability. */
    public static final Ability Crescent = new Ability("三日月斬", ability -> {
        ability.active("{1}のユニットに{2}を与える。ダメージは自身から離れるにつれて減少し、最小で{3}になる。{4}。")
                .variable(1, Radius, 400)
                .variable(2, PhysicalDamage, 0, 0, ad(1))
                .variable(3, PhysicalDamage, 0, 0, amplify(AD, 0.6))
                .variable(4, ItemCD, 10);
    });

    /** The ability. */
    public static final Ability DeadlyPhalanx = new Ability("Deadly Phalanx", ability -> {
        ability.active("対象の味方は4秒間{1}を得る。また、4秒後にその味方の周囲の敵に{2}を与える。{3}")
                .variable(1, Shield, 0, 0, amplify(Health, 0.1))
                .variable(2, MagicDamage, 0, 0, amplify(TargetAD, 1), amplify(TargetAP, 0.3))
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability Devouring = new Ability("むさぼり食らう", ability -> {
        ability.active("通常攻撃ごとに{1}を与える。スタックは大型モンスターかチャンピオンを{2}と1、RiftScuttlerを{2}と2、DragonかBaronを{2}と5、増加する。スタックが30貯まると進化する。")
                .variable(1, MagicDamage, 30, 0, amplify(Stack, 1))
                .variable(2, Takedown);
    });

    /** The ability. */
    public static final Ability EleisasBlessing = new Ability("Eleisa's Blessing", ability -> {
        ability.passive("このアイテムを所持した状態でレベルを3上げるとこのアイテムは消費されるが、アイテムの効果はその後もそのまま得られるようになる。");
    });

    /** The ability. */
    public static final Ability EnhancedMovement1 = new Ability("移動速度強化", ability -> {
        ability.passive("{1}する。").variable(1, MS, 25);
    });

    /** The ability. */
    public static final Ability EnhancedMovement2 = new Ability("移動速度強化", ability -> {
        ability.passive("{1}する。").variable(1, MS, 45);
    });

    /** The ability. */
    public static final Ability EnhancedMovement3 = new Ability("移動速度強化", ability -> {
        ability.passive("{1}する。").variable(1, MS, 60);
    });

    /** The ability. */
    public static final Ability EnhancedMovement5 = new Ability("移動速度強化", ability -> {
        ability.passive("{1}する。5秒間戦闘をしなければ、{2}する。").variable(1, MS, 25).variable(2, MS, 105);
    });

    /** The ability. */
    public static final Ability EyesOfPain = new Ability("Eyes of Pain", ability -> {
        ability.passive("{1}を得る。").variable(1, MRPen, 15);
    });

    /** The ability. */
    public static final Ability FavorLevel1 = new Ability("恩寵", ability -> {
        ability.passive("{1}であなたが殺すことなくミニオンが死んだ場合に{2}獲得し、{3}する。")
                .variable(1, Radius, 1400)
                .variable(2, Gold, 3)
                .variable(3, RestoreHealth, 5);
    });

    /** The ability. */
    public static final Ability FavorLevel2 = new Ability("恩寵", ability -> {
        ability.passive("{1}であなたが殺すことなくミニオンが死んだ場合に{2}獲得し、{3}する。")
                .variable(1, Radius, 1400)
                .variable(2, Gold, 4)
                .variable(3, RestoreHealth, 10);
    });

    /** The ability. */
    public static final Ability GhostWard = new Ability("ゴーストワード", ability -> {
        ability.active("チャージを1つ消費して" + Item.StealthWard.name + "と同様の効果があるオブジェクトを指定地点に設置する。");
    });

    /** The ability. */
    public static final Ability GoldIncome = new Ability("Gold Income", ability -> {
        ability.passive("収入増加アイテムはひとつしか保有できない。");
    });

    /** The ability. */
    public static final Ability Greed = new Ability("金銭欲", ability -> {
        ability.passive("ユニットを倒すたびに{1}を得る。").variable(1, Gold, 2);
    });

    /** The ability. */
    public static final Ability HexCoreDeath = new Ability(ability -> {
        ability.ununique().passive("Death Rayにダメージ30%分の魔法ダメージが追加される。このダメージは4秒間かけて与えられる。");
    });

    /** The ability. */
    public static final Ability HexCoreGravity = new Ability(ability -> {
        ability.ununique().passive("Gravity Fieldの射程が30%増加する。");
    });

    /** The ability. */
    public static final Ability HexCorePower = new Ability(ability -> {
        ability.ununique().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 3));
    });

    /** The ability. */
    public static final Ability HexCoreTransfer = new Ability(ability -> {
        ability.ununique().passive("Power Transfe使用・命中時に3秒間{1}する。").variable(1, MSRatio, 30);
    });

    /** The ability. */
    public static final Ability Hunt = new Ability("Hunt", ability -> {
        ability.active("6秒間持続する無敵のゴーストを2体召喚する。ゴーストは最も近くにいる最大2人の敵Championの元まで移動していき(移動速度は450)、ゴーストが敵Championに触れた場合ゴーストが消滅し、その敵Championに2.5秒{1}を与え、2.5秒間対象の視界を得る。{2}。")
                .variable(1, MSSlowRatio, 40)
                .variable(2, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability Icy = new Ability("Icy", ability -> {
        ability.passive("通常攻撃に1.5秒間{1}(遠距離攻撃型は{2})を付与する。").variable(1, MSSlowRatio, 40).variable(2, MSSlowRatio, 30);
    });

    /** The ability. */
    public static final Ability ImmolateLevel1 = new Ability("猛火", ability -> {
        ability.passive("周囲{1}の敵に毎秒{2}を与える。モンスターに対しては{3}を与える。 ")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 5, 0, amplify(Lv, 1))
                .variable(3, MagicDamage, 7.5, 0, amplify(Lv, 1.5));
    });

    /** The ability. */
    public static final Ability ImmolateLevel2 = new Ability("猛火", ability -> {
        ability.passive("周囲{1}の敵に毎秒{2}を与える。モンスターに対しては{3}を与える。 ")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 15, 0, amplify(Lv, 0.6))
                .variable(3, MagicDamage, 30, 0, amplify(Lv, 1.2));
    });

    /** The ability. */
    public static final Ability Insight = new Ability("Insight", ability -> {
        ability.passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Mana, 0.03));
    });

    /** The ability. */
    public static final Ability Ionian = new Ability(ability -> {
        ability.passive("{1}を得る。").variable(1, CDR, 15);
    });

    /** The ability. */
    public static final Ability Jungler = new Ability("ジャングラー", ability -> {
        ability.passive("モンスターに対する攻撃命中時に2秒間かけて{1}を与える。また、モンスターとの戦闘中、毎秒{2}し、{3}する（非好戦的なモンスターの場合、自動回復効果はなし）。")
                .variable(1, MagicDamage, 45)
                .variable(2, RestoreHealth, 10)
                .variable(3, RestoreMana, 5);
    });

    /** The ability. */
    public static final Ability KindlegemPassive = new Ability(ability -> {
        ability.passive("{1}を得る。").variable(1, CDR, 15);
    });

    /** The ability. */
    public static final Ability Legion = new Ability("Legion", ability -> {
        ability.aura("{1}の味方ユニットは{2}得て、{3}する。")
                .variable(1, Radius, 1100)
                .variable(2, MR, 20)
                .variable(3, HregRatio, 75);
    });

    /** The ability. */
    public static final Ability LifelineLevel1 = new Ability("ライフライン", ability -> {
        ability.passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 250)
                .variable(2, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability LifelineLevel2 = new Ability("ライフライン", ability -> {
        ability.passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 400)
                .variable(2, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability LuckyShadow = new Ability("Lucky Shadow", ability -> {
        ability.passive("{1}を得る。").variable(1, Status.GoldPer10Sec, 4);
    });

    /** The ability. */
    public static final Ability LargeMonsterKill = new Ability(ability -> {
        ability.passive("大型モンスターを倒すたびに{1}を得る。").variable(1, Gold, 30);
    });

    /** The ability. */
    public static final Ability MaimForMadredsRazors = new Ability("Maim", ability -> {
        ability.passive("ミニオンやモンスターに対して通常攻撃をした際、25%の確率で{1}を与える。")
                .variable(1, MagicDamage, 500)

                .update(P308)
                .passive("モンスターへ通常攻撃をする度に{1}を与える。")
                .variable(1, MagicDamage, 60)

                .update(P314)
                .passive("モンスターへ通常攻撃をする度に{1}を与え、{2}する。")
                .variable(2, RestoreHealth, 5);
    });

    /** The ability. */
    public static final Ability MaladyPassive = new Ability(ability -> {
        ability.passive("通常攻撃に{1}と{2}を与える。MR減少は7回までスタックし、8秒間持続する。")
                .variable(1, MagicDamage, 15, 0, ap(0.1))
                .variable(2, MRReduction, 4);
    });

    /** The ability. */
    public static final Ability ManaChargeLevel1 = new Ability("マナチャージ", ability -> {
        ability.passive("スキル使用時またはマナ消費時に最大マナが4増加し（{1}）、8秒毎に最大マナが1増加する。最大増加量は750。").variable(1, ItemCD, 4);
    });

    /** The ability. */
    public static final Ability ManaChargeLevel2 = new Ability("マナチャージ", ability -> {
        ability.passive("スキル使用時またはマナ消費時に最大マナが4増加する（{1}）。750まで貯まると進化する。").variable(1, ItemCD, 4);
    });

    /** The ability. */
    public static final Ability ManaChargeManamune = new Ability("マナチャージ", ability -> {
        ability.passive("通常攻撃時、スキル使用時及びマナ消費時に最大Manaが4増加する（{1}）。750まで貯まると進化する。").variable(1, ItemCD, 4);
    });

    /** The ability. */
    public static final Ability ManaFont = new Ability("Mana Font", ability -> {
        ability.passive("５秒ごとに{1}する。").variable(1, RestoreMana, 0, 0, amplify(MissingManaRatio, 2));
    });

    /** The ability. */
    public static final Ability ManaPotion = new Ability(ability -> {
        ability.ununique().active("15秒かけてManaを100回復する");
    });

    /** The ability. */
    public static final Ability ManaShield = new Ability("マナシールド", ability -> {
        ability.active("現在のManaの20%を消費し、3秒間{1}を得る。{2}。")
                .variable(1, Shield, 150, 0, amplify(Status.CurrentManaRatio, 0.2))
                .variable(2, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability ManaWarp = new Ability("Mana Warp", ability -> {
        ability.aura("{1}の味方Championは{2}を得る。")
                .variable(1, Radius, 1100)
                .variable(2, Hreg, 6)

                .update(P307)
                .variable(2, Hreg, 5);
    });

    /** The ability. */
    public static final Ability MikaelsCrucibleActive = new Ability(ability -> {
        ability.active("対象の味方Champion({1})のStun, Snare, Taunt, Fear, Silence, Slowを全て解除し、{2}する。{3}")
                .variable(1, Radius, 800)
                .variable(2, RestoreHealth, 150, 0, amplify(TargetMissingHealthRatio, 15))
                .variable(3, ItemCD, 180)

                .update(P307)
                .variable(2, RestoreHealth, 150, 0, amplify(TargetMaxHealthRatio, 10));
    });

    /** The ability. */
    public static final Ability MorellonomiconPassive = new Ability(ability -> {
        ability.passive("HPが40%以下の敵Championに魔法DMを与えると{1}を与える。").variable(1, Wounds, 4);
    });

    /** The ability. */
    public static final Ability OhmwreckerActive = new Ability(ability -> {
        ability.active("一番近くのTowerからの攻撃を2.5秒間防ぐ。この効果は同一のTowerに対して7.5秒に一度しか使えない。{1}。").variable(1, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability OraclesElixirActive = new Ability(ability -> {
        ability.ununique()
                .active("このアイテムを消費して{1}のStealth状態の敵が味方に見えるようになる。5分経つか、死亡すると効果が切れる。")
                .variable(1, Radius, 750)

                .update(P309)
                .active("このアイテムを消費して{1}のStealth状態の敵が味方に見えるようになる。4分経つと効果が切れる。")
                .variable(1, Radius, 600);
    });

    /** The ability. */
    public static final Ability PhantomHit = new Ability("Phantom Hit", ability -> {
        ability.passive("通常攻撃毎に追加で{1}を与える。また通常攻撃2回毎に、ダメージを持たない通常攻撃を追加で発生させる。").variable(1, MagicDamage, 60);
    });

    /** The ability. */
    public static final Ability PointRunner = new Ability("ポイントランナー", ability -> {
        ability.passive("タワー（破壊されたものを含む）の{1}では、2秒間{2}する。").variable(1, Radius, 1300).variable(2, MSRatio, 30);
    });

    /** The ability. */
    public static final Ability Promote = new Ability("昇格", ability -> {
        ability.active("レーン上のミニオンを大幅に強化して被魔法ダメージを無効化する。{1}。").variable(1, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability Rage = new Ability("疾風怒濤", ability -> {
        ability.passive("通常攻撃をする毎に2秒間{1}する。敵ユニットを倒すと2秒間{2}する。遠隔攻撃型のチャンピオンの場合、この移動速度ボーナスは半分になる。")
                .variable(1, MS, 20)
                .variable(2, MS, 60);
    });

    /** The ability. */
    public static final Ability Rend = new Ability("Rend", ability -> {
        ability.passive("中立モンスターに対する通常攻撃に{1}を付与する。").variable(1, TrueDamage, 10);
    });

    /** The ability. */
    public static final Ability ScavengingSmite = new Ability("乱食のスマイト", ability -> {
        ability.passive("スマイト」を使って敵陣側のジャングルで大型モンスターを攻撃すると、「スマイト」の{1}する。そのモンスターを倒すと、{2}を得て{3}する。この効果は2秒間にかけて減衰する。")
                .variable(1, CDDecreaseRatio, 50)
                .variable(2, Gold, 20)
                .variable(3, MSRatio, 175);
    });

    /** The ability. */
    public static final Ability ShardOfTrueIceActive = new Ability(ability -> {
        ability.active("対象の味方ユニット({0})の周辺に4秒間持続する吹雪を発生させ、{1}にいる敵ユニットに{2}を与える。{3}。")
                .variable(0, Radius, 800)
                .variable(1, Radius, 200)
                .variable(2, MSSlowRatio, 30)
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SpellbladeIceborn = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、周囲の敵ユニットに{1}を与える効果を付与し、範囲内の敵ユニットに{2}を与える円形のフィールド({3})を2秒間形成する。{5}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1.25))
                .variable(2, MSSlowRatio, 30)
                .variable(3, Radius, 285)
                .variable(5, ItemCD, 1.5);
    });

    /** The ability. */
    public static final Ability SpellbladeLich = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。")
                .variable(1, MagicDamage, 50, 0, amplify(BaseAD, 0.75), ap(0.5))
                .variable(2, ItemCD, 1.5);
    });

    /** The ability. */
    public static final Ability SpellbladeRuneglaive = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃は魔法ダメージに変換され、対象の{1}の敵に追加{2}を与える({3})。またモンスターに対して攻撃した際には{4}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 0, 0, amplify(BaseAD, 1), amplify(AP, 0.3))
                .variable(3, CD, 1.5)
                .variable(4, RestoreMana, 0, 0, amplify(MissingManaRatio, 8));
    });

    /** The ability. */
    public static final Ability SpellbladeSheen = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1))
                .variable(2, ItemCD, 1.5);
    });

    /** The ability. */
    public static final Ability SpellbladeTrinityForce = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 2))
                .variable(2, ItemCD, 1.5)

                .update(P310A)
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 2));
    });

    /** The ability. */
    public static final Ability ShurelyasReverieAvtive = new Ability(ability -> {
        ability.active("{1}の味方Championは3秒間{2}する。{3}。")
                .variable(1, Radius, 600)
                .variable(2, MSRatio, 40)
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SlowResist = new Ability("スロウ耐性", ability -> {
        ability.passive("{1}する。").variable(1, Status.MSSlowReductionRatio, 25);
    });

    /** The ability. */
    public static final Ability SolariActive = new Ability(ability -> {
        ability.active("自身と{1}の味方Championは5秒間{2}を得る。{3}。")
                .variable(1, Radius, 600)
                .variable(2, Shield, 50, 0, amplify(Lv, 10))
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SpoilsofWarLevel1 = new Ability("戦場の略奪", ability -> {
        ability.passive("60秒毎に最大2つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、体力が{2}以下のミニオンに近接攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                .variable(1, RestoreHealth, 40)
                .variable(2, Value, 200, 0, amplify(AD, 1));
    });

    /** The ability. */
    public static final Ability SpoilsofWarLevel2 = new Ability("戦場の略奪", ability -> {
        ability.passive("30秒毎に最大3つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、体力が{2}以下のミニオンに近接攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                .variable(1, RestoreHealth, 50)
                .variable(2, Value, 240, 0, amplify(AD, 1));
    });

    /** The ability. */
    public static final Ability SpoilsofWarLevel3 = new Ability("戦場の略奪", ability -> {
        ability.passive("30秒毎に最大4つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、体力が{2}以下のミニオンに近接攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                .variable(1, RestoreHealth, 50, 0, amplify(HealthRatio, 1))
                .variable(2, Value, 400, 0, amplify(AD, 1));
    });

    /** The ability. */
    public static final Ability TenacityEffect = new Ability("根性", ability -> {
        ability.passive("{1} を得る。").variable(1, Status.Tenacity, 35);
    });

    /** The ability. */
    public static final Ability TheHexCorePassive = new Ability(ability -> {
        ability.ununique().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 3));
    });

    /** The ability. */
    public static final Ability Transmute = new Ability("Transmute", ability -> {
        ability.passive("{1}を得る。").variable(1, GoldPer10Sec, 5);
    });

    /** The ability. */
    public static final Ability TributeLevel1 = new Ability("徴収", ability -> {
        ability.passive("チャンピオンまたは建造物に対してスキル攻撃ないし通常攻撃を行うと、{1}を与え、{2}を得る。この効果は最大で30秒間に3回まで発生する。ミニオンを倒すと、これらの効果は12秒間無効となる。")
                .variable(1, TrueDamage, 10)
                .variable(2, Gold, 5);
    });

    /** The ability. */
    public static final Ability TributeLevel2 = new Ability("徴収", ability -> {
        ability.passive("チャンピオンまたは建造物に対してスキル攻撃ないし通常攻撃を行うと、{1}を与え、{2}を得る。この効果は最大で30秒間に3回まで発生する。ミニオンを倒すと、これらの効果は12秒間無効となる。")
                .variable(1, TrueDamage, 15)
                .variable(2, Gold, 10);
    });

    /** The ability. */
    public static final Ability Valor = new Ability("Valor", ability -> {
        ability.aura("{1}の味方ユニットは{2}を得る。").variable(1, Radius).variable(2, Hreg, 7);
    });

    /** The ability. */
    public static final Ability ValorsReward = new Ability("勇者の報酬", ability -> {
        ability.passive("レベルアップ時に8秒かけて{1}し、{2}する。").variable(1, RestoreHealth, 150).variable(2, RestoreMana, 200);
    });

    /** The ability. */
    public static final Ability WardRefresh1 = new Ability("Ward Refresh", ability -> {
        ability.passive("購入時及びショップを訪れる度に4つのチャージを得る。");
    });

    /** The ability. */
    public static final Ability WardRefresh2 = new Ability("Ward Refresh", ability -> {
        ability.passive("購入時及びショップを訪れる度に5つのチャージを得る。");
    });

    /** The ability. */
    public static final Ability ZekesHeraldAura = new Ability(ability -> {
        ability.aura("{1}の味方Championは{2}と{3}を得る。").variable(1, Radius, 1200).variable(2, AD, 20).variable(3, LS, 10);
    });

    /** The ability. */
    public static final Ability Spirit = new Ability(ability -> {
        ability.passive("モンスターにダメージを与えると{1}し{2}する。(範囲攻撃の場合は効果が半減する)")
                .variable(1, RestoreHealth, 0, 0, amplify(DealtDamage, 0.08))
                .variable(2, RestoreMana, 0, 0, amplify(DealtDamage, 0.04))

                .update(P403)
                .passive("モンスターにダメージを与えると{1}し{2}する。")
                .variable(1, RestoreHealth, 0, 0, amplify(DealtDamage, 0.06))
                .variable(2, RestoreMana, 0, 0, amplify(DealtDamage, 0.03));
    });

    // lazy initialization
    static {
        try {
            for (Field field : Ability.class.getFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Ability ability = (Ability) field.get(null);
                    ability.descriptor.accept(ability.update());
                }
            }
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /** The ability name. */
    public final String name;

    /** The ability descriptor. */
    private final Consumer<AbilityDescriptor> descriptor;

    /**
     * Create new ability with invisible name.
     */
    Ability(Consumer<AbilityDescriptor> descriptor) {
        this(null, descriptor);
    }

    /**
     * Create new ability with visible name.
     */
    Ability(String name, Consumer<AbilityDescriptor> descriptor) {
        this.name = name == null ? "#" + descriptor.hashCode() : name;
        this.descriptor = descriptor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbilityDescriptor createDescriptor(Version version, AbilityDescriptor previous) {
        return new AbilityDescriptor(this, previous, version);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }
}
