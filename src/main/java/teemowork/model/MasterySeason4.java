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

import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2013/03/13 14:34:14
 */
public class MasterySeason4 extends Mastery {

    static final Mastery[] Masteries = new Mastery[57];

    /** Mastery */
    public static final MasterySeason4 DoubleEdgedSword = new MasterySeason4("Double-Edged Sword", 1, Offense, 0);

    /** Mastery */
    public static final MasterySeason4 Fury = new MasterySeason4("Fury", 4, Offense, 0);

    /** Mastery */
    public static final MasterySeason4 Sorcery = new MasterySeason4("Sorcery", 4, Offense, 0);

    /** Mastery */
    public static final MasterySeason4 Butcher = new MasterySeason4("Butcher", 1, Offense, 0);

    /** Mastery */
    public static final MasterySeason4 ExposeWeakness = new MasterySeason4("Expose Weakness", 1, Offense, 1);

    /** Mastery */
    public static final MasterySeason4 BruteForce = new MasterySeason4("Brute Force", 3, Offense, 1);

    /** Mastery */
    public static final MasterySeason4 MentalForce = new MasterySeason4("Mental Force", 3, Offense, 1);

    /** Mastery */
    public static final MasterySeason4 Feast = new MasterySeason4("Feast", 1, Offense, 1, Butcher);

    /** Mastery */
    public static final MasterySeason4 SpellWeaving = new MasterySeason4("Spell Weaving", 1, Offense, 2);

    /** Mastery */
    public static final MasterySeason4 MartialMastery = new MasterySeason4("Martial Mastery", 1, Offense, 2, BruteForce);

    /** Mastery */
    public static final MasterySeason4 ArcaneMastery = new MasterySeason4("Arcane Mastery", 1, Offense, 2, MentalForce);

    /** Mastery */
    public static final MasterySeason4 Executioner = new MasterySeason4("Executioner", 3, Offense, 2);

    /** Mastery */
    public static final MasterySeason4 BladeWeaving = new MasterySeason4("Blade Weaving", 1, Offense, 3, SpellWeaving);

    /** Mastery */
    public static final MasterySeason4 Warlord = new MasterySeason4("Warlord", 3, Offense, 3);

    /** Mastery */
    public static final MasterySeason4 Archmage = new MasterySeason4("Archmage", 3, Offense, 3);

    /** Mastery */
    public static final MasterySeason4 DangerousGame = new MasterySeason4("Dangerous Game", 1, Offense, 3, Executioner);

    /** Mastery */
    public static final MasterySeason4 Frenzy = new MasterySeason4("Frenzy", 1, Offense, 4);

    /** Mastery */
    public static final MasterySeason4 DevastatingStrikes = new MasterySeason4("Devastating Strikes", 3, Offense, 4);

    /** Mastery */
    public static final MasterySeason4 ArcaneBlade = new MasterySeason4("Arcane Blade", 1, Offense, 4);

    /** Mastery */
    public static final MasterySeason4 Havoc = new MasterySeason4("Havoc", 1, Offense, 5);

    static {
        DoubleEdgedSword.update(P401)
                .passive("Melee : {1}し、被ダメージが1%増加する。<br>Ranged : {2}し、被ダメージが1.5%増加する。")
                .variable(1, DamageRatio, 2)
                .variable(2, DamageRatio, 1.5);
        Fury.update(P401).passive("{1}する。").variable(1, ASRatio, 1.25, 1.25);
        Sorcery.update(P401).passive("{1}を得る。").variable(1, CDR, 1.25, 1.25);
        Butcher.update(P401).passive("ミニオンやモンスターへの通常攻撃や単一対象スキルのダメージが2増加する。(AoE及びDoTスキルは対象外)");
        ExposeWeakness.update(P401).passive("スキルでダメージを与えた対象は、3秒間味方から受けるダメージが1%増加するようになる。");
        BruteForce.update(P401).passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Lv, 0.22, 0.22));
        MentalForce.update(P401).passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 0.33, 0.28));
        Feast.update(P401).passive("敵を倒す毎に{1}し{2}する。").variable(1, RestoreHealth, 2).variable(2, RestoreMana, 1);
        SpellWeaving.update(P401).passive("通常攻撃でChampionにダメージを与えると、5秒間自身のスキルの与ダメージが1%増加する。この効果は3回までスタックする。");
        MartialMastery.update(P401).passive("{1}を得る。").variable(1, AD, 4);
        ArcaneMastery.update(P401).passive("{1}を得る。").variable(1, AP, 6);
        Executioner.update(P401).passive("対象のHealthが{1}以下の時、{2}する。").variable(1, Percentage, 20, 15).variable(2, DamageRatio, 5);
        BladeWeaving.update(P401).passive("スキルでChampionにダメージを与えると、5秒間自身の通常攻撃の与ダメージが1%増加する。この効果は3回までスタックする。");
        Warlord.update(P401).passive("{1}を得る。").variable(1, AD, 0, 0, amplify(BounusAD, 0.02, 0.015));
        Archmage.update(P401).passive("{1}する。").variable(1, APRatio, 2, 1.5);
        DangerousGame.update(P401)
                .passive("Championを倒すと{1}し、{2}する。")
                .variable(1, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 5))
                .variable(2, RestoreMana, 0, 0, amplify(Status.MissingManaRatio, 5));
        Frenzy.update(P401).passive("クリティカルが発生すると3秒間{1}する。この効果は3回までスタックする。").variable(-1, ASRatio, 5);
        DevastatingStrikes.update(P401).passive("{1}と{2}を得る。").variable(1, ARPenRatio, 2, 2).variable(2, MRPenRatio, 2, 2);
        ArcaneBlade.update(P401).passive("通常攻撃に{1}を付与する。").variable(1, MagicDamage, 0, 0, ap(0.05));
        Havoc.update(P401).passive("{1}する。").variable(1, DamageRatio, 3);
    }

    /** Mastery */
    public static final MasterySeason4 Block = new MasterySeason4("Block", 2, Defense, 0);

    /** Mastery */
    public static final MasterySeason4 Recovery = new MasterySeason4("Recovery", 2, Defense, 0);

    /** Mastery */
    public static final MasterySeason4 EnchantedArmor = new MasterySeason4("Enchanted Armor", 2, Defense, 0);

    /** Mastery */
    public static final MasterySeason4 ToughSkin = new MasterySeason4("Tough Skin", 2, Defense, 0);

    /** Mastery */
    public static final MasterySeason4 Unyielding = new MasterySeason4("Unyielding", 1, Defense, 1, Block);

    /** Mastery */
    public static final MasterySeason4 VeteranScars = new MasterySeason4("Veteran Scars", 3, Defense, 1);

    /** Mastery */
    public static final MasterySeason4 BladedArmor = new MasterySeason4("Bladed Armor", 1, Defense, 1, ToughSkin);

    /** Mastery */
    public static final MasterySeason4 Oppression = new MasterySeason4("Oppression", 1, Defense, 2);

    /** Mastery */
    public static final MasterySeason4 Juggernaut = new MasterySeason4("Juggernaut", 1, Defense, 2, VeteranScars);

    /** Mastery */
    public static final MasterySeason4 Hardiness = new MasterySeason4("Hardiness", 3, Defense, 2);

    /** Mastery */
    public static final MasterySeason4 Resistance = new MasterySeason4("Resistance", 3, Defense, 2);

    /** Mastery */
    public static final MasterySeason4 Perseverance = new MasterySeason4("Perseverance", 3, Defense, 3);

    /** Mastery */
    public static final MasterySeason4 Swiftness = new MasterySeason4("Swiftness", 1, Defense, 3);

    /** Mastery */
    public static final MasterySeason4 ReinforcedArmor = new MasterySeason4("Reinforced Armor ", 1, Defense, 3, Hardiness);

    /** Mastery */
    public static final MasterySeason4 Evasive = new MasterySeason4("Evasive", 3, Defense, 3, Resistance);

    /** Mastery */
    public static final MasterySeason4 SecondWind = new MasterySeason4("Second Wind", 1, Defense, 4, Perseverance);

    /** Mastery */
    public static final MasterySeason4 LegendaryGuardian = new MasterySeason4("Legendary Guardian", 4, Defense, 4);

    /** Mastery */
    public static final MasterySeason4 RunicShield = new MasterySeason4("Runic Shield   ", 1, Defense, 4);

    /** Mastery */
    public static final MasterySeason4 Tenacious = new MasterySeason4("Tenacious", 1, Defense, 5);

    static {
        Block.update(P401).passive("敵Championから受ける{1}する。").variable(1, AttackDamageReduction, 1, 1);
        Recovery.update(P401).passive("{1}を得る。").variable(1, Hreg, 1, 1);
        EnchantedArmor.update(P401)
                .passive("{1}と{2}を得る。")
                .variable(1, AR, 0, 0, amplify(BounusAR, 0.025, 0.025))
                .variable(2, MR, 0, 0, amplify(BounusMR, 0.025, 0.025));
        ToughSkin.update(P401).passive("モンスターから受ける{1}する。").variable(1, DamageReduction, 1, 1);
        Unyielding.update(P401)
                .passive("Melee : Championから受ける{1}する。<br>Ranged : Championから受ける{2}する。")
                .variable(1, DamageReduction, 2)
                .variable(2, DamageReduction, 1);
        VeteranScars.update(P401).passive("{1}を得る。").variable(1, Health, 12, 12);
        BladedArmor.update(P401)
                .passive("攻撃してきたモンスターを出血状態にし、毎秒{1}を与える。")
                .variable(1, TrueDamage, 0, 0, amplify(TargetCurrentHealthRatio, 1));
        Oppression.update(P401).passive("スタン,スロー, タウント, フィアー, スネア, 打ち上げ, ノックバック,もしくはサプレッションを受けている敵ユニットから受ける被ダメージが3%減少する。");
        Juggernaut.update(P401).passive("{1}する。").variable(1, HealthRatio, 3);
        Hardiness.update(P401).passive("{1}を得る。").variable(1, AR, 2, 1.5);
        Resistance.update(P401).passive("{1}を得る。").variable(1, MR, 2, 1.5);
        Perseverance.update(P401).passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(MissingHealthPercentage, 0.35, 0.325));
        Swiftness.update(P401).passive("{1}する。").variable(1, MSSlowReductionRatio, 10);
        ReinforcedArmor.update(P401).passive("クリティカルヒットから受ける{1}する。").variable(1, DamageReductionRatio, 10);
        Evasive.update(P401).passive("AoEスキルから受ける{1}する。").variable(1, DamageReductionRatio, 10);
        SecondWind.update(P401).passive("Healthが25%以下の時、{1}する。").variable(1, RestoreHealthRatio, 10);
        LegendaryGuardian.update(P401)
                .passive("{1}に敵Championがいる場合、{2}と{3}を得る。")
                .variable(1, Radius, 700)
                .variable(2, AR, 0, 0, amplify(EnemyChampion, 1, 1))
                .variable(3, MR, 0, 0, amplify(EnemyChampion, 0.5, 0.5));
        RunicShield.update(P401).passive("ゲーム開始時とRespawnする時、{1}を得る。").variable(1, Shield, 50);
        Tenacious.update(P401).passive("{1}を得る。").variable(1, Tenacity, 15);
    }

    /** Mastery */
    public static final MasterySeason4 Phasewalker = new MasterySeason4("Phasewalker", 1, Utility, 0);

    /** Mastery */
    public static final MasterySeason4 FleetOfFoot = new MasterySeason4("Fleet of Foot", 3, Utility, 0);

    /** Mastery */
    public static final MasterySeason4 Meditation = new MasterySeason4("Meditation", 3, Utility, 0);

    /** Mastery */
    public static final MasterySeason4 Scout = new MasterySeason4("Scout", 1, Utility, 0);

    /** Mastery */
    public static final MasterySeason4 SummonersInsight = new MasterySeason4("Summoner's Insight", 3, Utility, 1);

    /** Mastery */
    public static final MasterySeason4 StrengthOfSpirit = new MasterySeason4("Strength of Spirit", 1, Utility, 1, Meditation);

    /** Mastery */
    public static final MasterySeason4 Alchemist = new MasterySeason4("Alchemist", 1, Utility, 1);

    /** Mastery */
    public static final MasterySeason4 Greed = new MasterySeason4("Greed", 3, Utility, 2);

    /** Mastery */
    public static final MasterySeason4 RunicAffinity = new MasterySeason4("Runic Affinity", 1, Utility, 2);

    /** Mastery */
    public static final MasterySeason4 Vampirism = new MasterySeason4("Vampirism", 3, Utility, 2);

    /** Mastery */
    public static final MasterySeason4 CulinaryMaster = new MasterySeason4("Culinary Master", 1, Utility, 2, Alchemist);

    /** Mastery */
    public static final MasterySeason4 Wealth = new MasterySeason4("Wealth", 1, Utility, 3);

    /** Mastery */
    public static final MasterySeason4 Scavenger = new MasterySeason4("Scavenger", 1, Utility, 3, Greed);

    /** Mastery */
    public static final MasterySeason4 ExpandedMind = new MasterySeason4("Expanded Mind", 3, Utility, 3);

    /** Mastery */
    public static final MasterySeason4 Inspiration = new MasterySeason4("Inspiration", 2, Utility, 3);

    /** Mastery */
    public static final MasterySeason4 Bandit = new MasterySeason4("Bandit", 1, Utility, 4, Wealth);

    /** Mastery */
    public static final MasterySeason4 Intelligence = new MasterySeason4("Intelligence", 3, Utility, 4);

    /** Mastery */
    public static final MasterySeason4 Wanderer = new MasterySeason4("Wanderer", 1, Utility, 5);

    static {
        Phasewalker.update(P401).passive("Recallの詠唱時間が1秒短くなる。");
        FleetOfFoot.update(P401).passive("{1}する。").variable(1, MSRatio, 0.5, 0.5);
        Meditation.update(P401).passive("{1}を得る。").variable(1, Mreg, 1, 1);
        Scout.update(P401).passive("Trinket系アイテムの射程が25%増加する。");
        SummonersInsight.update(P401).passive("{Summoner SpellのCDが{1}減少する。").variable(1, Percentage, 4, 3);
        StrengthOfSpirit.update(P401).passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(Mana, 0.0033));
        Alchemist.update(P401).passive("PotionとElixir系のアイテムの持続時間が10%増加する。");
        Greed.update(P401).passive("{1}を得る。").variable(1, GoldPer10Sec, 0.5, 0.5);
        RunicAffinity.update(P401).passive("BaronBuff以外のBuffの効果時間が20%延長される。");
        Vampirism.update(P401).passive("{1}と{2}を得る。").variable(1, LS, 1, 1).variable(2, SV, 1, 1);
        CulinaryMaster.update(P401).passive("Health PotionがTotal Biscuit of Rejuvenationになり、使用時は即座にHealthを20、Manaを10回復する。");
        Scavenger.update(P401).passive("自分以外の味方が近くのミニオンを倒すと{1}を得る。").variable(1, Gold, 1);
        Wealth.update(P401).passive("ゲーム開始時に{1}を得る。").variable(1, Gold, 40);
        ExpandedMind.update(P401).passive("{1}を得る。").variable(1, Mana, 0, 0, amplify(Mana, 0.02, 0.015));
        Inspiration.update(P401).passive("レベルが自分よりも高い味方の側にいると、1秒毎に{1}を得る。").variable(1, Experiment, 0.5, 0.5);
        Bandit.update(P401)
                .passive("Melee : キルもしくはアシストを取ると{1}を得る。<br>Ranged : 敵Championに通常攻撃でダメージを与える毎に{2}を得る。CDは5秒。")
                .variable(1, Gold, 15)
                .variable(2, Gold, 3);
        Intelligence.update(P401).passive("{1}を得る。また、アイテムのActiveのCDが{2}減少する。").variable(1, CDR, 2, 1.5).variable(2, Percentage, 4, 3);
        Wanderer.update(P401).passive("非戦闘時、{1}する。").variable(1, MSRatio, 5);
    }

    /**
     * A mastery tree definition.
     */
    static final Mastery[][][] Trees = {
            // ============ Offense ============ //
            {{DoubleEdgedSword, Fury, Sorcery, Butcher}, {ExposeWeakness, BruteForce, MentalForce, Feast},
                    {SpellWeaving, MartialMastery, ArcaneMastery, Executioner}, {BladeWeaving, Warlord, Archmage, DangerousGame},
                    {Frenzy, DevastatingStrikes, null, ArcaneBlade}, {null, Havoc, null, null}},

            // ============ Defense ============ //
            {{Block, Recovery, EnchantedArmor, ToughSkin}, {Unyielding, VeteranScars, null, BladedArmor},
                    {Oppression, Juggernaut, Hardiness, Resistance}, {Perseverance, Swiftness, ReinforcedArmor, Evasive},
                    {SecondWind, LegendaryGuardian, RunicShield, null}, {null, Tenacious, null, null}},

            // ============ Utility ============ //
            {{Phasewalker, FleetOfFoot, Meditation, Scout}, {null, SummonersInsight, StrengthOfSpirit, Alchemist},
                    {Greed, RunicAffinity, Vampirism, CulinaryMaster}, {Scavenger, Wealth, ExpandedMind, Inspiration},
                    {null, Bandit, Intelligence, null}, {null, Wanderer, null, null}}};

    /** The id counter. */
    private static int counter = 0;

    /**
     * <p>
     * Define mastery.
     * </p>
     * 
     * @param name A mastery name.
     * @param level A max level.
     */
    MasterySeason4(String name, int level, int type, int rank) {
        this(name, level, type, rank, null);
    }

    /**
     * <p>
     * Define mastery.
     * </p>
     * 
     * @param name A mastery name.
     * @param level A max level.
     */
    MasterySeason4(String name, int level, int type, int rank, Mastery dependency) {
        super(name, level, type, rank, counter++, dependency);

        Masteries[id] = this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getIcon() {
        return "src/main/resources/teemowork/mastery/s4/" + system + ".png";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Numeric getIconPosition() {
        return new Numeric(id / (counter - 1) * 100, Unit.percent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected MasteryDescriptor createDescriptor(Version version) {
        return new MasteryDescriptor(this, version);
    }
}
