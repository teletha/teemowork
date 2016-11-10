/*
 * Copyright (C) 2016 Teemowork Development Team
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

import java.util.function.Consumer;

import teemowork.model.variable.VariableResolver.PerLevel;

/**
 * @version 2016/09/12 0:59:43
 */
public interface ItemDefinition {

    /** Abyssal Scepter */
    public static Consumer<ItemDescriptor> AbyssalScepter = item -> {
        item.add(ability -> {
            ability.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, MRReduction, 20);
        });
    };

    /** Aegis of the Legion */
    public static Consumer<ItemDescriptor> AegisOftheLegion = item -> {
        item.healthRegenRatio(100).add(Ability.Legion0);
    };

    /** Aether Wisp */
    public static Consumer<ItemDescriptor> AetherWisp = item -> {
        item.add(ability -> {
            ability.passive("{1}する。").variable(1, MSRatio, 5);
        });
    };

    /** Amplifying Tome */
    public static Consumer<ItemDescriptor> AmplifyingTome = item -> {
    };

    /** Ancient Coin */
    public static Consumer<ItemDescriptor> AncientCoin = item -> {
        item.manaRegenRatio(25).add(Ability.GoldIncome).add(Ability.FavorLevel1);
    };

    /** Archangel's Staff */
    public static Consumer<ItemDescriptor> ArchangelsStaff = item -> {
        item.manaRegenRatio(50).add(Ability.ArchangelInsight).add(Ability.ManaChargeLevel2);
    };

    /** Archangel's Staff */
    public static Consumer<ItemDescriptor> ArdentCenser = item -> {
        item.cdr(10).manaRegenRatio(100).add(ability -> {
            ability.passive("{1}する。").variable(1, MSRatio, 8);
        }).add(ability -> {
            ability.passive("他ユニットを回復したりシールドを付与すると、対象ユニットは6秒間{1}し、攻撃命中時に{2}を与える。").variable(-1, ASRatio, 15).variable(2, MagicDamage, 30);
        });
    };

    /** Athene's Unholy Grail */
    public static Consumer<ItemDescriptor> AthenesUnholyGrail = item -> {
        item.manaRegenRatio(100).cdr(20).add(Ability.ManaFont).add(ability -> {
            ability.passive("{2}と{1}する。").variable(1, RestoreMana, 0, 0, amplify(Mana, 0.3)).variable(2, Takedown);
        });
    };

    /** B. F. Sword */
    public static Consumer<ItemDescriptor> BFSword = item -> {
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> BamisCinder = item -> {
        item.add(Ability.ImmolateLevel1);
    };

    /** Banner of Command */
    public static Consumer<ItemDescriptor> BannerOfCommand = item -> {
        item.cdr(10).healthRegenRatio(100).add(Ability.Legion).add(Ability.Promote);
    };

    /** Banshee's Veil */
    public static Consumer<ItemDescriptor> BansheesVeil = item -> {
        item.manaRegenRatio(100).add(ability -> {
            ability.passive("敵Championのスキルを無効化するシールドを張る。シールドはスキルを無効化すると消費され、40秒間敵Championからダメージを受けないと再生する。");
        });
    };

    /** Berserker's Greaves */
    public static Consumer<ItemDescriptor> BerserkersGreaves = item -> {
        item.add(Ability.EnhancedMovement2);
    };

    /** Bilgewater Cutlass */
    public static Consumer<ItemDescriptor> BilgewaterCutlass = item -> {
        item.add(ability -> {
            ability.active("対象の敵Champion({0})に{1}と2秒間{2}与える。{3}。")
                    .variable(0, Radius, 550)
                    .variable(1, MagicDamage, 100)
                    .variable(2, MSSlowRatio, 25)
                    .variable(3, ItemCD, 90);
        });
    };

    /** The Black Cleaver */
    public static Consumer<ItemDescriptor> BlackCleaver = item -> {
        item.cdr(20).add(Ability.Rage).add(ability -> {
            ability.ununique().passive("敵Championに物理DMを与えた際、6秒間{1}を与える（最大6回までスタック）。").variable(1, ARReductionRatio, 5);
        });
    };

    /** Blade of the Ruined King */
    public static Consumer<ItemDescriptor> BladeOftheRuinedKing = item -> {
        item.add(ability -> {
            ability.passive("通常攻撃に{1}を付与する（下限10ダメージ、ミニオンまたはモンスターに対しては上限60ダメージ）。")
                    .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealthRatio, 6));
        }).add(ability -> {
            ability.active("対象の敵Champion({1})に{2}(下限100ダメージ)を与え、{3}する。また{4}間{5}を与え、自身の移動速度がその分だけ増加する。{6}。")
                    .variable(1, Radius, 550)
                    .variable(2, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 15))
                    .variable(3, RestoreHealth, 0, 0, amplify(DealtDamage, 1))
                    .variable(4, Time, 3)
                    .variable(5, MSSlowRatio, 30)
                    .variable(6, ItemCD, 90);
        });
    };

    /** Blasting Wand */
    public static Consumer<ItemDescriptor> BlastingWand = item -> {
    };

    /** The Bloodthirster */
    public static Consumer<ItemDescriptor> Bloodthirster = item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。").variable(1, LS, 20);
        }).add(ability -> {
            ability.passive("通常攻撃で最大ライフ値を超えてライフを吸収できる。余ったライフはシールドとして自身に付与され、50～350ダメージ(チャンピオンのレベルに比例)をブロックする。");
        });
    };

    /** Boots of Mobility */
    public static Consumer<ItemDescriptor> BootsOfMobility = item -> {
        item.add(Ability.EnhancedMovement5);
    };

    /** Boots of Speed */
    public static Consumer<ItemDescriptor> BootsOfSpeed = item -> {
        item.add(Ability.EnhancedMovement1);
    };

    /** Boots of Swiftness */
    public static Consumer<ItemDescriptor> BootsOfSwiftness = item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    };

    /** Brawler's Gloves */
    public static Consumer<ItemDescriptor> BrawlersGloves = item -> {
    };

    /** Catalyst the Protector */
    public static Consumer<ItemDescriptor> CatalystOfAeons = item -> {
        item.add(Ability.Eternity);
    };

    /** Caulfield's Warhammer */
    public static Consumer<ItemDescriptor> CaulfieldsWarhammer = item -> {
        item.cdr(10);
    };

    /** Chain Vest */
    public static Consumer<ItemDescriptor> ChainVest = item -> {
    };

    /** Chalice of Harmony */
    public static Consumer<ItemDescriptor> ChaliceOfHarmony = item -> {
        item.manaRegenRatio(50).add(Ability.ManaFont);
    };

    /** Cloak of Agility */
    public static Consumer<ItemDescriptor> CloakOfAgility = item -> {
    };

    /** Cloth Armor */
    public static Consumer<ItemDescriptor> ClothArmor = item -> {
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> ControlWard = item -> {
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> CorruptingPotion = item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("チャージを消費して12秒かけて{1}し、{2}する。またその間、単体攻撃をした敵チャンピオンに3秒かけて{3}を与える。お店に寄るごとに3チャージを得る。")
                    .variable(1, RestoreHealth, 150)
                    .variable(2, RestoreMana, 50)
                    .variable(3, MagicDamage, 12, 0, level(1));
        });
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> CrystallineBracer = item -> {
        item.healthRegenRatio(50);
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> Cull = item -> {
        item.add(ability -> {
            ability.passive("通常攻撃時に{1}する。").variable(1, RestoreHealth, 3);
        }).add(ability -> {
            ability.passive("ミニオンを倒すと{1}を得る。100体のミニオンを倒すと{2}を得てこの効果が消滅する。").variable(1, Gold, 1).variable(2, Gold, 350);
        });
    };

    /** Dagger */
    public static Consumer<ItemDescriptor> Dagger = item -> {
    };

    /** The Dark Seal */
    public static Consumer<ItemDescriptor> DarkSeal = item -> {
        item.add(ability -> {
            ability.passive("ポーションの回復量が25%増加する。");
        }).add(ability -> {
            ability.passive("Kill毎に2、Assist毎に1スタックを得る（最大で10）。死ぬと4スタックを失う。スタック毎に{1}を得る。").variable(1, AP, 3);
        });
    };

    /** DeadMansPlate */
    public static Consumer<ItemDescriptor> DeadMansPlate = item -> {
        item.add("Dreadnought", ability -> {
            ability.passive("移動するとチャージが貯まっていき、比例して移動速度が増加していく。チャージは最大で100まで貯まり、{1}する。チャージは移動阻害効果を受けると急激に減少し、" + MSSlow + "を受けると緩やかに減少する。")
                    .variable(1, MS, 60);
        }).add("Crushing Blow", ability -> {
            ability.passive("通常攻撃を行うと全てのチャージを消費して{1}を与える。100チャージを消費した場合は、与えるダメージが2倍になる。近接攻撃をした場合はさらに1秒かけて減衰する{2}を与える。")
                    .variable(1, PhysicalDamage, 0, 0, amplify(Charge, 0.5))
                    .variable(2, MSSlowRatio, 50);
        });
    };

    /** Death's Dance */
    public static Consumer<ItemDescriptor> DeathsDance = item -> {
        item.cdr(10).add(ability -> {
            ability.passive(PhysicalDamage + "を与えると{1}する。（複数対象の場合は33%）").variable(1, RestoreHealth, amplify(DealtDamageRatio, 15));
        }).add(ability -> {
            ability.passive("受けたダメージの15%に等しいダメージを5秒間かけて対象に跳ね返す。");
        });
    };

    /** Doran's Blade */
    public static Consumer<ItemDescriptor> DoransBlade = item -> {
    };

    /** Doran's Ring */
    public static Consumer<ItemDescriptor> DoransRing = item -> {
        item.manaRegenRatio(50).add(ability -> {
            ability.ununique().passive("敵ユニットを倒すと{1}する。").variable(1, RestoreMana, 4);
        });
    };

    /** Doran's Shield */
    public static Consumer<ItemDescriptor> DoransShield = item -> {
        item.add(ability -> {
            ability.passive("敵Championからの{1}する。").variable(1, DamageReduction, 6);
        });
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> DuskbladeOfDraktharr = item -> {
        item.add(Ability.ARPen10).add(ability -> {
            ability.passive("敵チャンピオンへ通常攻撃を与えると、2秒後に{1}を与える({2})。この効果が発動する前に敵を倒した場合、{3}する。")
                    .variable(1, PhysicalDamage, 90, 0, amplify(TargetMissingHealthRatio, 25))
                    .variable(2, ItemCD, 120)
                    .variable(3, CDDecrease);
        });
    };

    /** EdgeOfNight */
    public static Consumer<ItemDescriptor> EdgeOfNight = item -> {

    };

    /** Item definition */
    public static Consumer<ItemDescriptor> ElixirOfSorcery = item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}と{2}を得る。また、チャンピオンかタワーにダメージを与えるたびに、{3}を追加で与える。この効果はチャンピオンに対しては5秒毎にしか発生しない。")
                    .variable(1, AP, 50)
                    .variable(2, Mreg, 15)
                    .variable(3, TrueDamage, 25);
        });
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> ElixirOfIron = item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}、{2}、{3}を得る。また、通過した場所は「鋼の導べ」となり、後続の味方チャンピオンは{4}する。")
                    .variable(1, Grow, 20)
                    .variable(2, Health, 300)
                    .variable(3, Tenacity, 25)
                    .variable(4, MSRatio, 15);
        });
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> ElixirOfWrath = item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}を得る。また、チャンピオンに対して物理ダメージを与えると、自身の体力がダメージの15％分回復する。")
                    .variable(1, AD, 30)
                    .variable(2, Takedown);
        });
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> EyeOftheEquinox = item -> {
        item.goldGeneration(2).healthRegenRatio(100).add(Ability.SpoilsofWarLevel3).add(Ability.WardRefresh2).add(Ability.GhostWard);
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> EyeOftheOasis = item -> {
        item.healthRegenRatio(150).manaRegenRatio(100).cdr(10).add(Ability.FavorLevel2).add(Ability.WardRefresh2).add(Ability.GhostWard);
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> EyeOftheWatchers = item -> {
        item.goldGeneration(2).manaRegenRatio(100).cdr(10).add(Ability.TributeLevel2).add(Ability.WardRefresh2).add(Ability.GhostWard);
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> EssenceReaver = item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。（20%を上限にこのアイテム以外からの" + Critical + "に等しい" + CDR + "を得る）").variable(1, CDR, 10, 0, amplify(Critical, 1));
        }).add(ability -> {
            ability.passive("クリティカル発生時に{1}する。").variable(1, RestoreMana, amplify(Mana, 0.03));
        });
    };

    /** Item definition */
    public static Consumer<ItemDescriptor> ExecutionersCalling = item -> {
        item.add(ability -> {
            ability.passive("物理ダメージを与えた対象に3秒間{1}を与える。").variable(1, Wounds);
        });
    };

    /** Face of the Mountain */
    public static Consumer<ItemDescriptor> FaceOftheMountain = item -> {
        item.healthRegenRatio(100)
                .goldGeneration(2)
                .cdr(10)
                .add(Ability.GoldIncome)
                .add(Ability.SpoilsofWarLevel3)
                .add("Deadly Phalanx", ability -> {
                    ability.active("対象の味方チャンピオンに4秒間{1}を与える。また4秒後に爆発して{2}の敵に{3}を与える。")
                            .variable(1, Shield, amplify(Health, 0.1))
                            .variable(2, Radius, 200)
                            .variable(3, MagicDamage, 0, 0, ad(1), ap(0.3));
                });
    };

    /** Faerie Charm */
    public static Consumer<ItemDescriptor> FaerieCharm = item -> {
        item.manaRegenRatio(25);
    };

    /** Fiendish Codex */
    public static Consumer<ItemDescriptor> FiendishCodex = item -> {
        item.add(Ability.CDR10);
    };

    /** Forbidden Idol */
    public static Consumer<ItemDescriptor> ForbiddenIdol = item -> {
        item.manaRegenRatio(50).add(Ability.CDR10);
    };

    /** Frostfang */
    public static Consumer<ItemDescriptor> Frostfang = item -> {
        item.manaRegenRatio(100).goldGeneration(2).add(Ability.GoldIncome).add(Ability.TributeLevel2);
    };

    /** Frost Queen's Claim */
    public static Consumer<ItemDescriptor> FrostQueensClaim = item -> {
        item.manaRegenRatio(100).goldGeneration(2).cdr(10).add(Ability.GoldIncome).add(Ability.TributeLevel2).add(ability -> {
            ability.active("攻撃無効な亡霊を2体召喚し、最も近くにいる敵チャンピオン2人を6秒間探索する。亡霊はターゲットに追いつくと、2秒から5秒間（亡霊の移動距離に依る）{1}と{2}を与える。ターゲットを見つけられなかった場合、亡霊は召喚者のもとへ戻ろうとする。亡霊が帰還に成功した場合、このアイテムのクールダウンは20秒短縮される({3})。")
                    .variable(1, Visionable)
                    .variable(2, MSSlowRatio, 40)
                    .variable(3, ItemCD, 90);
        });
    };

    /** Frozen Heart */
    public static Consumer<ItemDescriptor> FrozenHeart = item -> {
        item.cdr(20).add(ability -> {
            ability.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, ASSlowRatio, 15);
        });
    };

    /** Frozen Mallet */
    public static Consumer<ItemDescriptor> FrozenMallet = item -> {
        item.add(Ability.Icy);
    };

    /** Giant's Belt */
    public static Consumer<ItemDescriptor> GiantsBelt = item -> {
    };

    /** Giant Slayer */
    public static Consumer<ItemDescriptor> GiantSlayer = item -> {
        item.add(Ability.GiantSlayer);
    };

    /** Glacial Shroud */
    public static Consumer<ItemDescriptor> GlacialShroud = item -> {
        item.add(Ability.CDR10);
    };

    /** Guardian Angel */
    public static Consumer<ItemDescriptor> GuardianAngel = item -> {
        item.add(ability -> {
            ability.passive(Health + "が0になると、4秒後に{2}と{3}を得て復活する。{4}。")
                    .variable(-2, Health, 0, 0, amplify(Health, 0.3))
                    .variable(-3, Mana, 0, 0, amplify(Mana, 0.3))
                    .variable(4, ItemCD, 300);
        });
    };

    /** Guinsoo's Rageblade */
    public static Consumer<ItemDescriptor> GuinsoosRageblade = item -> {
        item.add(ability -> {
            ability.ununique()
                    .passive("通常攻撃時にスタックが1増加する（近接チャンピオンは2増加）。1スタックにつき{1}し{2}と{3}を得る。スタックは5秒持続し、最大8スタックまで増加する。8スタック時は通常攻撃に{4}の敵ユニットに{5}を与える。")
                    .variable(-1, ASRatio, 8)
                    .variable(-2, AP, 4)
                    .variable(-3, AD, 3)
                    .variable(4, Radius, 350)
                    .variable(5, MagicDamage, 20, 0, bounusAD(0.15), ap(0.075));
        });
    };

    /** Haunting Guise */
    public static Consumer<ItemDescriptor> HauntingGuise = item -> {
        item.add(Ability.EyesOfPain);
    };

    /** Augment: Power */
    public static Consumer<ItemDescriptor> HexCoremk1 = item -> {
        item.add(ability -> {
            ability.passive("{1}と{2}を得る。").variable(1, AP, level(3)).variable(2, Mana, level(15));
        });
    };

    /** Augment: Gravity */
    public static Consumer<ItemDescriptor> HexCoremk2 = item -> {
        item.add(ability -> {
            ability.passive("{1}と{2}を得る。").variable(1, AP, level(6)).variable(2, Mana, level(20));
        });
    };

    /** Health Potion */
    public static Consumer<ItemDescriptor> HealthPotion = item -> {
        item.add(ability -> {
            ability.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreHealth, 150);
        });
    };

    /** Hexdrinker */
    public static Consumer<ItemDescriptor> Hexdrinker = item -> {
        item.add(Ability.LifelineLevel1);
    };

    /** Hextech Gunblade */
    public static Consumer<ItemDescriptor> HextechGunblade = item -> {
        item.add(ability -> {
            ability.passive("{1}する。（範囲攻撃は33%）").variable(1, RestoreHealth, amplify(DealtDamage, 0.15));
        }).add(ability -> {
            ability.active("対象の敵Champion({1})に{2}と2秒間{3}を与える。{4}。")
                    .variable(1, Radius, 700)
                    .variable(2, MagicDamage, 150, 0, ap(0.4))
                    .variable(3, MSSlowRatio, 40)
                    .variable(4, ItemCD, 30);
        });
    };

    /** HextechGLP800 */
    public static Consumer<ItemDescriptor> HextechGLP800 = item -> {
        item.add("Frost Bolt", ability -> {
            ability.active("指定方向の敵ユニットに{1}を与え、0.5秒かけて減衰する{2}を付与する。")
                    .variable(1, MagicDamage, new PerLevel(100, 106, 112, 118, 124, 130, 136, 141, 147, 153, 159, 165, 171, 176, 182, 188, 194, 200), ap(0.35))
                    .variable(2, MSSlowRatio, 65);
        });
    };

    /** Item */
    public static Consumer<ItemDescriptor> HextechProtobelt01 = item -> {
        item.cdr(10).add("Fire Bolt", ability -> {
            ability.active("指定方向にダッシュして前方扇状に矢を放ち、当たった敵ユニットに{1}を与える。同一ユニットに複数の矢が当たった場合、2本目以降の矢は20%のダメージになる。このダッシュで地形を通り抜けることはできない。")
                    .variable(1, MagicDamage, new PerLevel(75, 79, 83, 88, 92, 97, 101, 106, 110, 115, 119, 124, 128, 132, 137, 141, 146, 150), ap(0.35));
        });
    };

    /** Hextech Revolver */
    public static Consumer<ItemDescriptor> HextechRevolver = item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。").variable(1, SV, 12);
        });
    };

    /** Hunter's Machete */
    public static Consumer<ItemDescriptor> HuntersMachete = item -> {
        item.add(Ability.Nail);
    };

    /** Hunter's Potion */
    public static Consumer<ItemDescriptor> HuntersPotion = item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("チャージを消費して8秒かけて{1}し、{2}する。お店に寄るごとに5チャージを得る。大型モンスターを倒すと1チャージを得る。")
                    .variable(1, RestoreHealth, 60)
                    .variable(2, RestoreMana, 35);
        });
    };

    /** Hunter's Talisman */
    public static Consumer<ItemDescriptor> HuntersTalisman = item -> {
        item.add(Ability.Tooth);
    };

    /** Iceborn Gauntlet */
    public static Consumer<ItemDescriptor> IcebornGauntlet = item -> {
        item.cdr(20).add(Ability.SpellbladeIceborn);
    };

    /** Infinity Edge */
    public static Consumer<ItemDescriptor> InfinityEdge = item -> {
        item.add(ability -> {
            ability.passive("{1}する。").variable(1, CriticalDamageRatio, 50);
        });
    };

    /** Ionian Boots of Lucidity */
    public static Consumer<ItemDescriptor> IonianBootsOfLucidity = item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    };

    /** Jaurim's Fist */
    public static Consumer<ItemDescriptor> JaurimsFist = item -> {
        item.add(ability -> {
            ability.passive("敵ユニットを倒すたびに{1}を得る。この効果は30回まで蓄積する。").variable(1, Health, 5);
        });
    };

    /** Kindlegem */
    public static Consumer<ItemDescriptor> Kindlegem = item -> {
        item.add(Ability.CDR10);
    };

    /** Kircheis Shard */
    public static Consumer<ItemDescriptor> KircheisShard = item -> {
        item.add(Ability.Energize).add(ability -> {
            ability.passive("チャージされた通常攻撃は追加{1}を与える。").variable(1, MagicDamage, 40);
        });
    };

    /** KnightsVow */
    public static Consumer<ItemDescriptor> KnightsVow = item -> {

    };

    /** Last Whisper */
    public static Consumer<ItemDescriptor> LastWhisper = item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。").variable(1, BounusARPenRatio, 30);
        });
    };

    /** Liandry's Torment */
    public static Consumer<ItemDescriptor> LiandrysTorment = item -> {
        item.add(Ability.EyesOfPain).add(ability -> {
            ability.passive("敵ユニットにスキルでダメージを与えた際に3秒間、毎秒{1}を与える(ミニオンやモンスターに対しては上限100)。対象が移動阻害効果を受けている場合、ダメージは2倍になる。")
                    .variable(1, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 2));
        });
    };

    /** Lich Bane */
    public static Consumer<ItemDescriptor> LichBane = item -> {
        item.cdr(10).add(Ability.SpellbladeLich);
    };

    /** Lord Dominik's Regards */
    public static Consumer<ItemDescriptor> LordDominiksRegards = item -> {
        item.add(Ability.GiantSlayer2).add(Ability.LastWhisper);
    };

    /** Locket of the Iron Solari */
    public static Consumer<ItemDescriptor> LocketOftheIronSolari = item -> {
        item.cdr(10).healthRegenRatio(100).add(Ability.Legion).add(ability -> {
            ability.active("{1}の味方に2秒間{2}を付与する。{3}。")
                    .variable(1, Radius, 600)
                    .variable(2, Shield, 75, 0, amplify(Lv, 15))
                    .variable(3, ItemCD, 60);
        });
    };

    /** Long Sword */
    public static Consumer<ItemDescriptor> LongSword = item -> {
    };

    /** Item */
    public static Consumer<ItemDescriptor> LostChapter = item -> {
        item.add(ability -> {
            ability.passive("レベルアップ時に3秒かけて{1}する。").variable(1, RestoreMana, amplify(Status.Mana, 0.2));
        });
    };

    /** Long Sword */
    public static Consumer<ItemDescriptor> LudensEcho = item -> {
        item.add(ability -> {
            ability.passive("移動およびスキル使用によりチャージを溜めることができる。チャージが100溜まると、次に発動するスキルに{1}が追加される。最大4体のターゲットに命中する。")
                    .variable(1, MagicDamage, 100, 0, ap(0.1));
        });
    };

    /** Manamune */
    public static Consumer<ItemDescriptor> Manamune = item -> {
        item.manaRegenRatio(25).add(Ability.Awe).add(Ability.ManaChargeManamune);
    };

    /** Maw of Malmortius */
    public static Consumer<ItemDescriptor> MawOfMalmortius = item -> {
        item.set(ARPen, 10).add(Ability.LifelineLevel2);
    };

    /** Mejai's Soulstealer */
    public static Consumer<ItemDescriptor> MejaisSoulstealer = item -> {
        item.add(ability -> {
            ability.passive("Kill毎に4、Assist毎に2スタックを得る（最大で25）。死ぬと10スタックを失う。スタック毎に{1}を得る。15スタック以上の時{2}を得る。")
                    .variable(1, AP, 5)
                    .variable(1, MSRatio, 10);
        });
    };

    /** Mercurial Scimitar */
    public static Consumer<ItemDescriptor> MercurialScimitar = item -> {
        item.add("水銀", ability -> {
            ability.active("自身のDebuffをすべて除去し、1秒間{1}する。{2}。").variable(1, MSRatio, 50).variable(2, ItemCD, 90);
        });
    };

    /** Mercury's Treads */
    public static Consumer<ItemDescriptor> MercurysTreads = item -> {
        item.add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    };

    /** Mikael's Crucible */
    public static Consumer<ItemDescriptor> MikaelsCrucible = item -> {
        item.cdr(10).manaRegenRatio(100).add(Ability.ManaFont).add(ability -> {
            ability.active(" 対象({1})の味方のチャンピオンからDebuffを全て取り除き、{2}する。{3}。")
                    .variable(1, Radius, 750)
                    .variable(2, RestoreHealth, 150, 0, amplify(TargetMaxHealthRatio, 0.1))
                    .variable(3, ItemCD, 180);
        });
    };

    /** Morellonomicon */
    public static Consumer<ItemDescriptor> Morellonomicon = item -> {
        item.cdr(20).manaRegenRatio(100).add(ability -> {
            ability.passive("ライフが残り40％未満の敵のチャンピオンに魔法ダメージを与えると、{1} を与える。").variable(1, Wounds, 4);
        });
    };

    /** Mortal Reminder */
    public static Consumer<ItemDescriptor> MortalReminder = item -> {
        item.add(Ability.LastWhisper).add(ability -> {
            ability.passive("物理ダメージを与えた対象に5秒間{1}を与える。").variable(1, Wounds);
        });
    };

    /** Muramana */
    public static Consumer<ItemDescriptor> Muramana = item -> {
        item.manaRegenRatio(25).add(Ability.Awe).add(ability -> {
            ability.passive("敵チャンピオンに対して単体スキルや通常攻撃がヒットすると、現在マナの3%を消費して{1}を与える。この効果は自身のマナが最大値の20%以上あるときにしか発動しない。")
                    .variable(1, PhysicalDamage, 0, 0, amplify(Status.CurrentManaRatio, 6));
        });
    };

    /** Nashor's Tooth */
    public static Consumer<ItemDescriptor> NashorsTooth = item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。通常攻撃に{2}を付与する。").variable(1, CDR, 20).variable(2, MagicDamage, 15, 0, ap(0.15));
        });
    };

    /** Needlessly Large Rod */
    public static Consumer<ItemDescriptor> NeedlesslyLargeRod = item -> {
    };

    /** Negatron Cloak */
    public static Consumer<ItemDescriptor> NegatronCloak = item -> {
    };

    /** Ninja Tabi */
    public static Consumer<ItemDescriptor> NinjaTabi = item -> {
        item.add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    };

    /** Nomad's Medallion */
    public static Consumer<ItemDescriptor> NomadsMedallion = item -> {
        item.healthRegenRatio(50).manaRegenRatio(50).add(Ability.GoldIncome).add(Ability.FavorLevel2);
    };

    /** Null-Magic Mantle */
    public static Consumer<ItemDescriptor> NullMagicMantle = item -> {
    };

    /** Ohmwrecker */
    public static Consumer<ItemDescriptor> Ohmwrecker = item -> {
        item.cdr(10).healthRegenRatio(150).add(Ability.PointRunner).add(ability -> {
            ability.active("周囲の敵タワーは3秒間攻撃できなくなる。同じタワーに対しては8秒に1回しか効果がない。{1}。").variable(1, ItemCD, 120);
        });
    };

    /** Phage */
    public static Consumer<ItemDescriptor> Phage = item -> {
        item.add(Ability.Rage);
    };

    /** Phantom Dancer */
    public static Consumer<ItemDescriptor> PhantomDancer = item -> {
        item.add("Spectral Waltz", ability -> {
            ability.passive("{3}の視界内に敵チャンピオンがいる場合、{1}と{2}を得る。")
                    .variable(1, IgnoreUnitCollision)
                    .variable(2, MSRatio, 7)
                    .variable(3, Radius, 500);
        }).add("Lament", ability -> {
            ability.passive("通常攻撃を与えた敵チャンピオンから受けるダメージが10秒間12%減少する。この効果は同時に一体のチャンピオンにしか発生しない。");
        });
    };

    /** Pickaxe */
    public static Consumer<ItemDescriptor> Pickaxe = item -> {
    };

    /** PoachersDirk */
    public static Consumer<ItemDescriptor> PoachersDirk = item -> {

    };

    /** The Hex Core */
    public static Consumer<ItemDescriptor> PrototypeHexCore = item -> {
        item.add(ability -> {
            ability.passive("{1}と{2}を得る。").variable(1, AP, level(1)).variable(2, Mana, level(10));
        });
    };

    /** The Hex Core */
    public static Consumer<ItemDescriptor> PerfectHexCore = item -> {
        item.add(ability -> {
            ability.passive("{1}と{2}を得る。").variable(1, AP, level(10)).variable(2, Mana, level(25));
        });
    };

    /** Quicksilver Sash */
    public static Consumer<ItemDescriptor> QuicksilverSash = item -> {
        item.add("水銀", ability -> {
            ability.active("自身のDebuffをすべて除去する。{1}。").variable(1, ItemCD, 90);
        });
    };

    /** Rabadon's Deathcap */
    public static Consumer<ItemDescriptor> RabadonsDeathcap = item -> {
        item.add(ability -> {
            ability.passive("{1}する。").variable(1, APRatio, 35);
        });
    };

    /** Randuin's Omen */
    public static Consumer<ItemDescriptor> RanduinsOmen = item -> {
        item.add(ability -> {
            ability.ununique().passive("{1}する。").variable(1, CriticalDamageReductionRatio, 10);
        }).add(Ability.ColdSteel).add(ability -> {
            ability.active("{1}の敵ユニットに4秒間{2}を与える。この効果時間は、自身のArmor+Magic Resistの値100につき1秒増加する。{3}。")
                    .variable(1, Radius, 500)
                    .variable(2, MSSlowRatio, 35)
                    .variable(3, ItemCD, 60);
        });
    };

    /** Rapid Firecannon */
    public static Consumer<ItemDescriptor> RapidFirecannon = item -> {
        item.add(Ability.Energize).add(ability -> {
            ability.passive("チャージされた通常攻撃は射程が35%延び、追加{1}を与える。建物に対しても有効。").variable(1, MagicDamage, 44, 0, level(6));
        });
    };

    /** Raptor Cloak */
    public static Consumer<ItemDescriptor> RaptorCloak = item -> {
        item.healthRegenRatio(150).add(Ability.PointRunner);
    };

    /** Ravenous Hydra */
    public static Consumer<ItemDescriptor> RavenousHydra = item -> {
        item.healthRegenRatio(100).add(Ability.Cleave).add(Ability.Crescent).add(ability -> {
            ability.ununique().passive("このアイテムによって与えられたダメージはLife Stealの効果を受ける。");
        });
    };

    /** Recurve Bow */
    public static Consumer<ItemDescriptor> RecurveBow = item -> {
        item.add(Ability.BowDamage);
    };

    /** Redemption */
    public static Consumer<ItemDescriptor> Redemption = item -> {

    };

    /** Refillable Potion */
    public static Consumer<ItemDescriptor> RefillablePotion = item -> {
        item.add(ability -> {
            ability.ununique().active("チャージを消費して12秒かけて{1}する。お店に寄るごとに2チャージを得る。").variable(1, RestoreHealth, 125);
        });
    };

    /** Rejuvenation Bead */
    public static Consumer<ItemDescriptor> RejuvenationBead = item -> {
        item.healthRegenRatio(50);
    };

    /** Relic Shield */
    public static Consumer<ItemDescriptor> RelicShield = item -> {
        item.goldGeneration(2).add(Ability.GoldIncome).add(Ability.SpoilsofWarLevel1);
    };

    /** Relic Shield */
    public static Consumer<ItemDescriptor> RighteousGlory = item -> {
        item.healthRegenRatio(100).add(ability -> {
            ability.active("周囲の味方が敵または敵タワーに向かって移動する時、移動速度を3秒間{1}する。3秒後、周囲にいる敵のチャンピオンに1秒間{2}を与える。{3}。")
                    .variable(1, MSRatio, 60)
                    .variable(2, MSSlowRatio, 80)
                    .variable(3, ItemCD, 90);
        });
    };

    /** Rod of Ages */
    public static Consumer<ItemDescriptor> RodOfAges = item -> {
        item.add(Ability.Eternity).add(ability -> {
            ability.ununique()
                    .passive("1分毎に{1}と{2}と{3}を得る。この効果は10回まで発生する。")
                    .variable(1, Health, 0, 0, amplify(Stack, 20))
                    .variable(2, Mana, 0, 0, amplify(Stack, 40))
                    .variable(3, AP, 0, 0, amplify(Stack, 4));
        });
    };

    /** Ruby Crystal */
    public static Consumer<ItemDescriptor> RubyCrystal = item -> {
    };

    /** Ruby Sightstone */
    public static Consumer<ItemDescriptor> RubySightstone = item -> {
        item.add(Ability.WardRefresh2).add(Ability.GhostWard).add(ability -> {
            ability.passive("アイテムの" + CD + "が10%減少する。");
        });
    };

    /** Runaan's Hurricane */
    public static Consumer<ItemDescriptor> RunaansHurricane = item -> {
        item.add(Ability.BowDamage).add(ability -> {
            ability.passive("通常攻撃をした際に、{1}の2体の敵ユニットに{2}を与える（クリティカルあり）。{3}。")
                    .variable(1, Radius, 375)
                    .variable(2, PhysicalDamage, 0, 0, ad(0.25))
                    .variable(3, OnHitEffect);
        });
    };

    /** Rylai's Crystal Scepter */
    public static Consumer<ItemDescriptor> RylaisCrystalScepter = item -> {
        item.add(ability -> {
            ability.passive("スキルでダメージを与えた際に1.5秒間{1}を与える。対象が範囲スキルの場合は1秒間{2}を、持続ダメージスキルもしくはペット攻撃の場合は1秒間{3} を与える。")
                    .variable(1, MSSlowRatio, 40)
                    .variable(2, MSSlowRatio, 40)
                    .variable(3, MSSlowRatio, 20);
        });
    };

    /** Sapphire Crystal */
    public static Consumer<ItemDescriptor> SapphireCrystal = item -> {
    };

    /** Seraph's Embrace */
    public static Consumer<ItemDescriptor> SeraphsEmbrace = item -> {
        item.manaRegenRatio(100).add(Ability.Insight).add(Ability.ManaShield);
    };

    /** Serrated Dirk */
    public static Consumer<ItemDescriptor> SerratedDirk = item -> {
        item.set(ARPen, 10).add(ability -> {
            ability.passive("ユニットを倒した後の通常攻撃か単体スキル使用時に追加{1}を与える。").variable(1, TrueDamage, 15);
        });
    };

    /** Seeker's Armguard */
    public static Consumer<ItemDescriptor> SeekersArmguard = item -> {
        item.add(ability -> {
            ability.passive("敵ユニットを倒す度に{1}と{2}を得る。この効果は30回分までスタックする。")
                    .variable(1, AP, 0, 0, amplify(Stack, 0.5))
                    .variable(2, AR, 0, 0, amplify(Stack, 0.5));
        });
    };

    /** Sheen */
    public static Consumer<ItemDescriptor> Sheen = item -> {
        item.cdr(10).add(Ability.SpellbladeSheen);
    };

    /** Sightstone */
    public static Consumer<ItemDescriptor> Sightstone = item -> {
        item.add(Ability.WardRefresh1).add(Ability.GhostWard);
    };

    /** SkirmishersSabre */
    public static Consumer<ItemDescriptor> SkirmishersSabre = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChallengingSmite);
    };

    /** SkirmishersSabre */
    public static Consumer<ItemDescriptor> SkirmishersSabreCinderhulk = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChallengingSmite).set(BounusHealthRatio, 15).add(Ability.ImmolateLevel2);
    };

    /** SkirmishersSabre */
    public static Consumer<ItemDescriptor> SkirmishersSabreBloodrazor = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChallengingSmite).add(Ability.Bloodrazor);
    };

    /** SkirmishersSabre */
    public static Consumer<ItemDescriptor> SkirmishersSabreRunicEchoes = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChallengingSmite).add(Ability.RunicEchoes);
    };

    /** SkirmishersSabre */
    public static Consumer<ItemDescriptor> SkirmishersSabreWarrior = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChallengingSmite).cdr(10);
    };

    /** Sorcerer's Shoes */
    public static Consumer<ItemDescriptor> SorcerersShoes = item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    };

    /** Spectre's Cowl */
    public static Consumer<ItemDescriptor> SpectresCowl = item -> {
        item.add(ability -> {
            ability.passive("チャンピオンからダメージを受けると10秒間{1}を得る。").variable(-1, HregRatio, 150);
        });
    };

    /** Spellthief's Edge */
    public static Consumer<ItemDescriptor> SpellthiefsEdge = item -> {
        item.manaRegenRatio(25).goldGeneration(2).add(Ability.GoldIncome).add(Ability.TributeLevel1);
    };

    /** Spirit Visage */
    public static Consumer<ItemDescriptor> SpiritVisage = item -> {
        item.cdr(10).healthRegenRatio(150).add(ability -> {
            ability.passive("{1}する。").variable(1, RestoreHealthRatio, 20);
        });
    };

    /** StalkersBlade */
    public static Consumer<ItemDescriptor> StalkersBlade = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChillingSmite);
    };

    /** StalkersBlade */
    public static Consumer<ItemDescriptor> StalkersBladeCinderhulk = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChillingSmite).set(BounusHealthRatio, 15).add(Ability.ImmolateLevel2);
    };

    /** StalkersBlade */
    public static Consumer<ItemDescriptor> StalkersBladeBloodrazor = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChillingSmite).add(Ability.Bloodrazor);
    };

    /** StalkersBlade */
    public static Consumer<ItemDescriptor> StalkersBladeRunicEchoes = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChillingSmite).add(Ability.RunicEchoes);
    };

    /** StalkersBlade */
    public static Consumer<ItemDescriptor> StalkersBladeWarrior = item -> {
        item.add(Ability.NailAndTooth).add(Ability.ChillingSmite).cdr(10);
    };

    /** Statikk Shiv */
    public static Consumer<ItemDescriptor> StatikkShiv = item -> {
        item.add(Ability.Energize).add(ability -> {
            ability.passive("チャージされた通常攻撃は対象に雷を放ち{1}を与える。雷は対象の付近の敵ユニット({2})4体にも連鎖し同様のダメージを与える。雷によるダメージはクリティカルの影響を受ける。建物には無効。ミニオンに対してはダメージが120%増加。")
                    .variable(1, MagicDamage, 46, 0, level(4.11))
                    .variable(2, Radius, 300);
        });
    };

    /** SteraksGage */
    public static Consumer<ItemDescriptor> SteraksGage = item -> {
        item.add(ability -> {
            ability.ununique().passive("{1}を得る。").variable(1, AD, amplify(BaseAD, 0.25));
        }).add(ability -> {
            ability.passive("5秒以内に{1}のダメージを受けると8秒間Primal Rageの効果を得る。{2}。").variable(1, Value, 400, 0, level(82.35)).variable(2, ItemCD, 45);
        }).add("Primal Rage", ability -> {
            ability.passive("{1}が増加し、{2}を得て、急速に減衰する{3}を得る。")
                    .variable(1, Grow)
                    .variable(-2, AD, amplify(BaseAD, 0.25))
                    .variable(3, Shield, amplify(HealthRatio, 30));
        });
    };

    /** Stinger */
    public static Consumer<ItemDescriptor> Stinger = item -> {
        item.add(Ability.CDR10);
    };

    /** Sunfire Cape */
    public static Consumer<ItemDescriptor> SunfireCape = item -> {
        item.add("猛火", ability -> {
            ability.passive("{1}の敵に毎秒{2}を与える。ミニオンやモンスターへのダメージは50%増加する。")
                    .variable(1, Radius, 400)
                    .variable(2, MagicDamage, 25, 0, amplify(Lv, 1));
        });
    };

    /** Targon's Brace */
    public static Consumer<ItemDescriptor> TargonsBrace = item -> {
        item.healthRegenRatio(50).goldGeneration(2).add(Ability.GoldIncome).add(Ability.SpoilsofWarLevel2);
    };

    /** Talisman of Ascension */
    public static Consumer<ItemDescriptor> TalismanOfAscension = item -> {
        item.healthRegenRatio(100).manaRegenRatio(100).cdr(10).add(Ability.GoldIncome).add(Ability.FavorLevel2).add(ability -> {
            ability.active("{1}の味方は3秒間{2}する。{3}。").variable(1, Radius, 600).variable(2, MSRatio, 40).variable(3, ItemCD, 60);
        });
    };

    /** Tear of the Goddess */
    public static Consumer<ItemDescriptor> TearOftheGoddess = item -> {
        item.manaRegenRatio(25).add(Ability.ManaChargeLevel1);
    };

    /** Thornmail */
    public static Consumer<ItemDescriptor> Thornmail = item -> {
        item.add(ability -> {
            ability.passive("敵の通常攻撃受けるとその攻撃者に{1}を与える。")
                    .variable(1, MagicDamage, 0, 0, amplify(ReceivedOriginalDamageRatio, 15), amplify(BounusAR, 0.25));
        });
    };

    /** Tiamat */
    public static Consumer<ItemDescriptor> Tiamat = item -> {
        item.healthRegenRatio(50).add(Ability.Crescent);
    };

    /** TitanicHydra */
    public static Consumer<ItemDescriptor> TitanicHydra = item -> {
        item.healthRegenRatio(100).add(Ability.CleaveHealth).add(Ability.CrescentHealth);
    };

    /** Item */
    public static Consumer<ItemDescriptor> TotalBiscuitOfRejuvenation = item -> {
    };

    /** Tracker's Knife */
    public static Consumer<ItemDescriptor> TrackersKnife = item -> {
        item.add(Ability.NailAndTooth).add(Ability.WardRefresh0).add(Ability.GhostWard);
    };

    /** Tracker's Knife */
    public static Consumer<ItemDescriptor> TrackersKnifeCinderhulk = item -> {
        item.add(Ability.NailAndTooth)
                .add(Ability.WardRefresh0)
                .add(Ability.GhostWard)

                .set(BounusHealthRatio, 15)
                .add(Ability.ImmolateLevel2);
    };

    /** Tracker's Knife */
    public static Consumer<ItemDescriptor> TrackersKnifeBloodrazor = item -> {
        item.add(Ability.NailAndTooth).add(Ability.WardRefresh0).add(Ability.GhostWard).add(Ability.Bloodrazor);
    };

    /** Tracker's Knife */
    public static Consumer<ItemDescriptor> TrackersKnifeRunicEchoes = item -> {
        item.add(Ability.NailAndTooth).add(Ability.WardRefresh0).add(Ability.GhostWard).add(Ability.RunicEchoes);
    };

    /** Tracker's Knife */
    public static Consumer<ItemDescriptor> TrackersKnifeWarrior = item -> {
        item.add(Ability.NailAndTooth).add(Ability.WardRefresh0).add(Ability.GhostWard).cdr(10);
    };

    /** Trinity Force */
    public static Consumer<ItemDescriptor> TrinityForce = item -> {
        item.cdr(10).add(Ability.SpellbladeTrinityForce).add(Ability.Rage);
    };

    /** Vampiric Scepter */
    public static Consumer<ItemDescriptor> VampiricScepter = item -> {
    };

    /** Void Staff */
    public static Consumer<ItemDescriptor> VoidStaff = item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。").variable(1, MRPenRatio, 35);
        });
    };

    /** Warden's Mail */
    public static Consumer<ItemDescriptor> WardensMail = item -> {
        item.add(Ability.ColdSteel);
    };

    /** Warmog's Armor */
    public static Consumer<ItemDescriptor> WarmogsArmor = item -> {
        item.healthRegenRatio(200).add("Warmog's Heart", ability -> {
            ability.passive("8秒間ダメージを受けていなければ毎秒{1}する。この効果は最大" + Health + "が3000以上でないと発動しない。")
                    .variable(1, RestoreHealth, amplify(HealthRatio, 3));
        });
    };

    /** Wit's End */
    public static Consumer<ItemDescriptor> WitsEnd = item -> {
        item.add(ability -> {
            ability.passive("通常攻撃は追加{1}を与え、{2}を得る。また対象の敵に{3}を与える。MRの増減は5回までスタックし、5秒間持続する。")
                    .variable(1, MagicDamage, 40)
                    .variable(2, MR, 0, 0, amplify(Stack, 5))
                    .variable(3, MRReduction, 0, 0, amplify(Stack, 5));
        });
    };

    /** Youmuu's Ghostblade */
    public static Consumer<ItemDescriptor> YoumuusGhostblade = item -> {
        item.cdr(10).add(Ability.ARPen20).add(ability -> {
            ability.active("6秒間{1}と{2}を得る。{3}。").variable(1, MSRatio, 20).variable(2, ASRatio, 40).variable(3, ItemCD, 45);
        });
    };

    /** Zeal */
    public static Consumer<ItemDescriptor> Zeal = item -> {
    };

    /** Zeke's Herald */
    public static Consumer<ItemDescriptor> ZekesHarbinger = item -> {
        item.cdr(10).add(ability -> {
            ability.passive("{1}にConduitを使用した味方がいる場合、チャージを生成する。攻撃もしくはスキルを使用することで追加のチャージを生成する。最大100チャージまで貯まり、5秒間持続する。最大チャージ時にダメージを与えると、全てのチャージを消費して8秒間あなたと対象の味方は{2}し{3}する。")
                    .variable(1, Radius, 1000)
                    .variable(2, APRatio, 20)
                    .variable(3, Critical, 50);
        }).add(ability -> {
            ability.active("味方チャンピオンを指定する。以前の対象との関係は破棄される。{1}。").variable(1, ItemCD, 60);
        });
    };

    /** Zhonya's Hourglass */
    public static Consumer<ItemDescriptor> ZhonyasHourglass = item -> {
        item.cdr(10).add("停滞", ability -> {
            ability.active("2.5秒間{1}になる。{1}。").variable(1, Stasis).variable(2, ItemCD, 120);
        });
    };

    /** Item Definition */
    public static Consumer<ItemDescriptor> ZzRotPortal = item -> {
        item.healthRegenRatio(125).add(Ability.PointRunner).add(ability -> {
            ability.active("指定した場所に、150秒間持続する「ヴォイドの扉」を召喚する。この扉は4秒ごとにヴォイドスポーンを産む。ヴォイドスポーンは最も近いレーンに進攻し、時間と共に消滅する。ヴォイドスポーンは、建造物を攻撃すると爆発する。ヴォイドスポーンは、チャンピオンおよびヴォイドの生物を攻撃することはない。最初の1匹と4匹ごとに出現するヴォイドスポーンは、追加{2}を与える。{1}。")
                    .variable(1, ItemCD, 150)
                    .variable(2, Damage, 0, 0, amplify(AR, 1), amplify(MR, 1));
        });
    };
}
