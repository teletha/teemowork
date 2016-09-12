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

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;

/**
 * @version 2016/09/12 21:46:07
 */
public class Ability extends Describable<AbilityDescriptor> {

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
    public static final Ability Awe = new Ability("畏怖", ability -> {
        ability.passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Mana, 0.02));
    });

    /** The ability. */
    public static final Ability BlockDamage = new Ability(ability -> {
        ability.passive("{1}する。").variable(1, AttackDamageReductionRatio, 10);
    });

    /** The ability. */
    public static final Ability BowDamage = new Ability(ability -> {
        ability.passive("通常攻撃命中時に追加で{1}を与える。").variable(1, PhysicalDamage, 15);
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
    public static final Ability CleaveHealth = new Ability("なぎ払い", ability -> {
        ability.passive("通常攻撃は追加で{2}を与える。更に{1}の敵に{3}を与える。")
                .variable(1, Radius, 385)
                .variable(2, PhysicalDamage, 5, 0, amplify(HealthRatio, 1))
                .variable(3, PhysicalDamage, 40, 0, amplify(HealthRatio, 2.5));
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
    public static final Ability CrescentHealth = new Ability("三日月斬", ability -> {
        ability.active("次の通常攻撃の" + CleaveHealth + "の効果は{1}のユニットに{2}を与える。{3}。{4}。")
                .variable(1, Radius, 400)
                .variable(2, PhysicalDamage, 40, 0, amplify(HealthRatio, 10))
                .variable(3, ResetAATimer)
                .variable(4, ItemCD, 20);
    });

    /** The ability. */
    public static final Ability Bloodrazor = new Ability(ability -> {
        ability.active("通常攻撃ごとに{1}を与える。（ミニオンやモンスターに対しては75が上限）").variable(1, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 4));
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
        ability.passive("{1}する。5秒間戦闘をしなければ、{2}する。").variable(1, MS, 25).variable(2, MS, 115);
    });

    /** The ability. */
    public static final Ability Energize = new Ability("Energize", ability -> {
        ability.passive("移動または通常攻撃を行うとその度にチャージが貯まっていく。 チャージが100に達した時、次の通常攻撃時に全てのチャージを消費して追加効果が発生する。");
    });

    /** The ability. */
    public static final Ability EyesOfPain = new Ability("Eyes of Pain", ability -> {
        ability.passive("{1}を得る。").variable(1, MRPen, 15);
    });

    /** The ability. */
    public static final Ability FavorLevel1 = new Ability("恩寵", ability -> {
        ability.passive("{1}であなたが殺すことなくミニオンが死んだ場合に{2}獲得し、{3}する。")
                .variable(1, Radius, 1400)
                .variable(2, Gold, 4)
                .variable(3, RestoreHealth, 5);
    });

    /** The ability. */
    public static final Ability FavorLevel2 = new Ability("恩寵", ability -> {
        ability.passive("{1}であなたが殺すことなくミニオンが死んだ場合に{2}獲得し、{3}する。")
                .variable(1, Radius, 1400)
                .variable(2, Gold, 6)
                .variable(3, RestoreHealth, 10);
    });

    /** The ability. */
    public static final Ability GhostWard = new Ability("ゴーストワード", ability -> {
        ability.active("チャージを1つ消費して150秒間持続する視界確保の効果があるオブジェクトを指定地点に設置する。");
    });

    /** The ability. */
    public static final Ability GiantSlayer = new Ability("Giant Slayer", ability -> {
        ability.active("敵チャンピオンの最大" + Status.Health + "が自身より50大きくなるごとに対象への" + Status.PhysicalDamage + "が1%増加する（最大で10%増加）。");
    });

    /** The ability. */
    public static final Ability GiantSlayer2 = new Ability("Giant Slayer", ability -> {
        ability.active("敵チャンピオンの最大" + Status.Health + "が自身より50大きくなるごとに対象への" + Status.PhysicalDamage + "が1.5%増加する（最大で15%増加）。");
    });

    /** The ability. */
    public static final Ability GoldIncome = new Ability("Gold Income", ability -> {
        ability.passive("収入増加アイテムはひとつしか保有できない。");
    });

    /** The ability. */
    public static final Ability Icy = new Ability("Icy", ability -> {
        ability.passive("通常攻撃に1.5秒間{1}(遠距離攻撃型は{2})を付与する。").variable(1, MSSlowRatio, 40).variable(2, MSSlowRatio, 30);
    });

    /** The ability. */
    public static final Ability ImmolateLevel1 = new Ability("猛火", ability -> {
        ability.passive("{1}の敵に毎秒{2}を与える。モンスターに対しては{3}を与える。 ")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 5, 0, amplify(Lv, 1))
                .variable(3, MagicDamage, 7.5, 0, amplify(Lv, 1.5));
    });

    /** The ability. */
    public static final Ability ImmolateLevel2 = new Ability("猛火", ability -> {
        ability.passive("{1}の敵に毎秒{2}を与える。モンスターに対しては{3}を与える。 ")
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
        ability.passive("{1}を得る。サモナースペルの" + CD + "が10%減少する。").variable(1, CDR, 10);
    });

    /** The ability. */
    public static final Ability Legion0 = new Ability("Legion", ability -> {
        ability.aura("{1}の味方ユニットは{2}を得る。").variable(1, Radius, 1100).variable(2, MR, 10);
    });

    /** The ability. */
    public static final Ability Legion = new Ability("Legion", ability -> {
        ability.aura("{1}の味方ユニットは{2}を得る。").variable(1, Radius, 1100).variable(2, MR, 15);
    });

    /** The ability. */
    public static final Ability LastWhisper = new Ability("Last Whipser", ability -> {
        ability.passive("{1}を得る。").variable(1, BounusARPenRatio, 45);
    });

    /** The ability. */
    public static final Ability LifelineLevel1 = new Ability("ライフライン", ability -> {
        ability.passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 100, 0, level(10))
                .variable(2, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability LifelineLevel2 = new Ability("ライフライン", ability -> {
        ability.passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。また戦闘終了時まで{2}し、{3}、{4}を得る。{5}。")
                .variable(1, MagicShield, 300, 0, amplify(BounusMR, 1))
                .variable(2, ASRatio, 25)
                .variable(3, LS, 10)
                .variable(4, SV, 10)
                .variable(5, ItemCD, 90);
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
    public static final Ability ManaShield = new Ability("マナシールド", ability -> {
        ability.active("現在のManaの20%を消費し、3秒間{1}を得る。{2}。")
                .variable(1, Shield, 150, 0, amplify(Status.CurrentManaRatio, 0.2))
                .variable(2, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability Nail = new Ability("Nail", ability -> {
        ability.passive("モンスターへの通常攻撃は追加{1}を与える。大型モンスターを倒すと{2}を得る。モンスターを相手にした時{3}を得る。")
                .variable(1, TrueDamage, 20)
                .variable(2, Experiment, 15)
                .variable(1, LS, 8);
    });

    /** The ability. */
    public static final Ability Tooth = new Ability("Tooth", ability -> {
        ability.passive("モンスターへのダメージを与えると5秒間かけて{1}与え、{2}する。大型モンスターを倒すと{3}を得る。ジャングル内にいる時{4}する。")
                .variable(1, TrueDamage, 25)
                .variable(2, RestoreHealth, 25)
                .variable(3, Experiment, 15)
                .variable(4, MregRatio, 150);
    });

    /** The ability. */
    public static final Ability NailAndTooth = new Ability("Nail / Tooth", ability -> {
        ability.passive("モンスターへの通常攻撃は追加{1}を与える。モンスターへのダメージを与えると5秒間かけて{2}与え、{3}する。大型モンスターを倒すと{4}を得る。モンスターを相手にした時{5}を得る。ジャングル内にいる時{6}する。")
                .variable(1, TrueDamage, 20)
                .variable(2, TrueDamage, 30)
                .variable(3, RestoreHealth, 30)
                .variable(4, Experiment, 30)
                .variable(5, LS, 10)
                .variable(6, MregRatio, 180);
    });

    /** The ability. */
    public static final Ability PhantomHit = new Ability("Phantom Hit", ability -> {
        ability.passive("通常攻撃毎に追加で{1}を与える。また近接攻撃は通常攻撃2回毎に遠距離攻撃は通常攻撃4回毎に、ダメージを持たない通常攻撃を追加で発生させる。").variable(1, MagicDamage, 60);
    });

    /** The ability. */
    public static final Ability PointRunner = new Ability("ポイントランナー", ability -> {
        ability.passive("タワー（破壊されたものを含む）の{1}では、2秒かけて{2}する。この効果は範囲外に出ると2秒かけて減衰する。").variable(1, Radius, 1300).variable(2, MSRatio, 20);
    });

    /** The ability. */
    public static final Ability Promote = new Ability("昇格", ability -> {
        ability.active("レーン上のミニオンを大幅に強化して被魔法ダメージを無効化する。{1}。").variable(1, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability Rage = new Ability("疾風怒濤", ability -> {
        ability.passive("通常攻撃をする毎に2秒間{1}する。敵ユニットを倒すと2秒間{2}する。遠隔攻撃型のチャンピオンの場合、この移動速度ボーナスは半分になる。").variable(1, MS, 20).variable(2, MS, 60);
    });

    /** The ability. */
    public static final Ability RunicEchoes = new Ability("追撃", ability -> {
        ability.passive("スキルの使用、移動によってチャージが溜まる。100チャージ溜まると、次のスキルはチャージを全て消費して対象と{1}の敵(最大4体まで)に{2}を与える。巨大モンスターに対してはダメージが2.5倍になり{3}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 80, 0, ap(0.1))
                .variable(3, RestoreMana, amplify(MissingManaRatio, 18));
    });

    /** The ability. */
    public static final Ability SpellbladeIceborn = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、周囲の敵ユニットに{1}を与える効果を付与し、範囲内（ボーナスARにより拡大）の敵ユニットに{2}を与える円形のフィールド({3})を2秒間形成する。{5}。")
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
    public static final Ability SpellbladeSheen = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。").variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1)).variable(2, ItemCD, 1.5);
    });

    /** The ability. */
    public static final Ability SpellbladeTrinityForce = new Ability("追撃", ability -> {
        ability.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。").variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 2)).variable(2, ItemCD, 1.5);
    });

    /** The ability. */
    public static final Ability SlowResist = new Ability("スロウ耐性", ability -> {
        ability.passive("{1}する。").variable(1, Status.MSSlowReductionRatio, 25);
    });

    /** The ability. */
    public static final Ability SpoilsofWarLevel1 = new Ability("戦場の略奪", ability -> {
        ability.passive("60秒毎に最大2つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、体力が{2}以下のミニオンに近接攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                .variable(1, RestoreHealth, 15)
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
                .variable(1, RestoreHealth, 50)
                .variable(2, Value, 400, 0, amplify(AD, 1));
    });

    /** The ability. */
    public static final Ability TenacityEffect = new Ability("根性", ability -> {
        ability.passive("{1} を得る。").variable(1, Status.Tenacity, 30);
    });

    /** The ability. */
    public static final Ability TributeLevel1 = new Ability("徴収", ability -> {
        ability.passive("チャンピオンまたは建造物に対してスキル攻撃ないし通常攻撃を行うと、{1}を与え、{2}を得る。この効果は最大で30秒間に3回まで発生する。ミニオンを倒すと、これらの効果は12秒間無効となる。")
                .variable(1, TrueDamage, 10)
                .variable(2, Gold, 8);
    });

    /** The ability. */
    public static final Ability TributeLevel2 = new Ability("徴収", ability -> {
        ability.passive("チャンピオンまたは建造物に対してスキル攻撃ないし通常攻撃を行うと、{1}を与え、{2}を得る。この効果は最大で30秒間に3回まで発生する。ミニオンを倒すと、これらの効果は12秒間無効となる。")
                .variable(1, TrueDamage, 15)
                .variable(2, Gold, 15);
    });

    /** The ability. */
    public static final Ability Eternity = new Ability("久遠", ability -> {
        ability.passive("敵チャンピオンから受けたダメージの15%分マナを回復し、自身が消費したマナの20%分HPを回復する。HP回復はマナ消費毎に最大で15。");
    });

    /** The ability. */
    public static final Ability WardRefresh0 = new Ability("Warding", ability -> {
        ability.passive("お店を訪れる度に2つのチャージを得る。");
    });

    /** The ability. */
    public static final Ability WardRefresh1 = new Ability("Ward Refresh", ability -> {
        ability.passive("お店を訪れる度に3つのチャージを得る。");
    });

    /** The ability. */
    public static final Ability WardRefresh2 = new Ability("Ward Refresh", ability -> {
        ability.passive("お店を訪れる度に4つのチャージを得る。");
    });

    // lazy initialization
    static {
        try {
            for (Field field : Ability.class.getFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Ability ability = (Ability) field.get(null);
                    ability.definition.accept(ability.update(Version.P301));
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
    private final Consumer<AbilityDescriptor> definition;

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
        this.definition = descriptor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbilityDescriptor createDescriptor(Version version) {
        return new AbilityDescriptor(this, version);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
