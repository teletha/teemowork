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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import js.dom.Element;

/**
 * @version 2015/07/19 23:24:51
 */
public class Item extends Describable<ItemDescriptor> {

    /** The counter for id. */
    private static int counter = 0;

    /** The item manager. */
    private static final List<Item> items = new ArrayList();

    /** Abyssal Scepter */
    public static final Item AbyssalScepter = new Item(RiotItemData.AbyssalScepter, item -> {
        item.abilityPower(70).magicRegist(45).add(ability -> {
            ability.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, MRReduction, 20);
        });
    });

    /** Aegis of the Legion */
    public static final Item AegisOftheLegion = new Item(RiotItemData.AegisoftheLegion, item -> {
        item.health(200).magicRegist(20).add(Ability.Legion);
    });

    /** Aether Wisp */
    public static final Item AetherWisp = new Item(RiotItemData.AetherWisp, item -> {
        item.abilityPower(30).add(ability -> {
            ability.passive("{1}する。").variable(1, MSRatio, 5);
        });
    });

    /** Amplifying Tome */
    public static final Item AmplifyingTome = new Item(RiotItemData.AmplifyingTome, item -> {
        item.abilityPower(20);
    });

    /** Ancient Coin */
    public static final Item AncientCoin = new Item(RiotItemData.AncientCoin, item -> {
        item.manaRegenRatio(25).add(Ability.GoldIncome).add(Ability.FavorLevel1);
    });

    /** Archangel's Staff */
    public static final Item ArchangelsStaff = new Item(RiotItemData.ArchangelsStaff, item -> {
        item.abilityPower(60).manaRegen(10).mana(250).add(Ability.ArchangelInsight).add(Ability.ManaCharge);
    });

    /** Archangel's Staff */
    public static final Item ArdentCenser = new Item(RiotItemData.ArdentCenser, item -> {
        item.cooldownReduction(10).abilityPower(40).manaRegenRatio(100).add(ability -> {
            ability.passive("{1}する。").variable(1, MSRatio, 8);
        }).add(ability -> {
            ability.passive("他ユニットを回復したりシールドを付与すると、対象ユニットは6秒間{1}し、攻撃命中時に{2}を与える。")
                    .variable(-1, ASRatio, 15)
                    .variable(2, MagicDamage, 30);
        });
    });

    /** Athene's Unholy Grail */
    public static final Item AthenesUnholyGrail = new Item(RiotItemData.AthenesUnholyGrail, item -> {
        item.abilityPower(60)
                .manaRegen(15)
                .magicRegist(40)
                .cooldownReduction(20)
                .add(Ability.AtheneRestore)
                .add(Ability.ManaFont);
    });

    /** Avarice Blade */
    public static final Item AvariceBlade = new Item(RiotItemData.AvariceBlade, item -> {
        item.critical(10).add(Ability.Avarice).add(Ability.Greed);
    });

    /** B. F. Sword */
    public static final Item BFSword = new Item(RiotItemData.BFSword, item -> {
        item.attackDamage(50);
    });

    /** Item definition */
    public static final Item BamisCinder = new Item(RiotItemData.BamisCinder, item -> {
        item.health(300).add("猛火", ability -> {
            ability.passive("周囲{1}の敵に毎秒{2}を与える。ミニオンおよび中立モンスターには{3}を与える。")
                    .variable(1, Radius, 400)
                    .variable(2, MagicDamage, 5, 0, amplify(Lv, 1))
                    .variable(3, MagicDamage, 7.5, 0, amplify(Lv, 1.5));
        });
    });

    /** Banner of Command */
    public static final Item BannerOfCommand = new Item(RiotItemData.BannerofCommand, item -> {
        item.abilityPower(60)
                .cooldownReduction(10)
                .health(200)
                .magicRegist(20)
                .add(Ability.Legion)
                .add(Ability.Promote);
    });

    /** Banshee's Veil */
    public static final Item BansheesVeil = new Item(RiotItemData.BansheesVeil, item -> {
        item.health(400)
                .mana(300)
                .magicRegist(45)
                .add(ability -> {
            ability.passive("敵Championからのスキルを無効化するシールドを張る。シールドはスキルを無効化すると消費され、25秒間敵Championからダメージを受けないと再生する。");
        })

                .update(P310)

                .health(450)
                .magicRegist(55)
                .mana(0)
                .add(ability -> {
            ability.passive("Championからダメージを受けると10秒間{1}を得る。").variable(-1, Hreg, 45);
        })

                .update(P403);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreaves = new Item(RiotItemData.BerserkersGreaves, item -> {
        item.attackSpeed(25).add(Ability.EnhancedMovement2);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreavesAlacrity = new Item(RiotItemData.BerserkersGreavesAlacrity, item -> {
        item.attackSpeed(25).add(Ability.EnhancedMovement2);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreavesCaptain = new Item(RiotItemData.BerserkersGreavesCaptain, item -> {
        item.attackSpeed(25).add(Ability.EnhancedMovement2);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreavesDistortion = new Item(RiotItemData.BerserkersGreavesDistortion, item -> {
        item.attackSpeed(25).add(Ability.EnhancedMovement2);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreavesFuror = new Item(RiotItemData.BerserkersGreavesFuror, item -> {
        item.attackSpeed(25).add(Ability.EnhancedMovement2);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreavesHomeguard = new Item(RiotItemData.BerserkersGreavesHomeguard, item -> {
        item.attackSpeed(25).add(Ability.EnhancedMovement2);
    });

    /** Bilgewater Cutlass */
    public static final Item BilgewaterCutlass = new Item(RiotItemData.BilgewaterCutlass, item -> {
        item.lifeSteal(8).attackDamage(25).add(ability -> {
            ability.active("対象の敵Champion({0})に{1}と2秒間{2}与える。{3}。")
                    .variable(0, Radius, 550)
                    .variable(1, MagicDamage, 100)
                    .variable(2, MSSlowRatio, 25)
                    .variable(3, ItemCD, 90);
        });
    });

    /** The Black Cleaver */
    public static final Item BlackCleaver = new Item(RiotItemData.TheBlackCleaver, item -> {
        item.attackDamage(50)
                .health(200)
                .cooldownReduction(10)
                .add(ability -> {
            ability.ununique()
                    .passive("敵Championに物理DMを与えた際、{1}を与える。5回（計25％）までスタックし、4秒間持続する。")
                    .variable(1, ARReductionRatio, 5);
        })
                .add(ability -> {
            ability.passive("{1}を得る。").variable(1, ARPen, 10);
        })

                .update(P403);
    });

    /** Blade of the Ruined King */
    public static final Item BladeOftheRuinedKing = new Item(RiotItemData.BladeoftheRuinedKing, item -> {
        item.lifeSteal(15).attackDamage(25).attackSpeed(40).add(ability -> {
            ability.passive("通常攻撃に{1}(Minionに対しては60が上限)を付与する。")
                    .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealthRatio, 5));
        }).add(ability -> {
            ability.active("対象の敵Champion({1})に{2}(下限100)を与え、{3}する。また{5}間{4}を与え、自身の移動速度がその分だけ増加する。{6}。")
                    .variable(1, Radius, 550)
                    .variable(2, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 15))
                    .variable(3, RestoreHealth, 0, 0, amplify(DealtDamage, 1))
                    .variable(4, MSSlowRatio, 30)
                    .variable(5, Time, 4)
                    .variable(6, ItemCD, 60)

                    .update(P310)
                    .variable(5, Time, 3)

                    .update(P310A)
                    .variable(1, Radius, 450)
                    .variable(6, ItemCD, 90);
        });
    });

    /** Blasting Wand */
    public static final Item BlastingWand = new Item(RiotItemData.BlastingWand, item -> {
        item.abilityPower(40);
    });

    /** The Bloodthirster */
    public static final Item Bloodthirster = new Item(RiotItemData.TheBloodthirster, item -> {
        item.lifeSteal(12).attackDamage(70).add(ability -> {
            ability.ununique()
                    .passive("敵ユニットを倒す度に{1}と{2}を得る。この効果は30回分までスタックし、死亡すると半分のスタックが失われる。")
                    .variable(1, AD, 0, 0, amplify(Stack, 1))
                    .variable(2, LS, 0, 0, amplify(Stack, 0.2));
        });
    });

    /** Boots of Mobility */
    public static final Item BootsOfMobility = new Item(RiotItemData.BootsofMobility, item -> {
        item.add(Ability.EnhancedMovement5);
    });

    /** Boots of Mobility */
    public static final Item BootsofMobilityAlacrity = new Item(RiotItemData.BootsofMobilityAlacrity, item -> {
        item.add(Ability.EnhancedMovement5);
    });

    /** Boots of Mobility */
    public static final Item BootsofMobilityCaptain = new Item(RiotItemData.BootsofMobilityCaptain, item -> {
        item.add(Ability.EnhancedMovement5);
    });

    /** Boots of Mobility */
    public static final Item BootsofMobilityDistortion = new Item(RiotItemData.BootsofMobilityDistortion, item -> {
        item.add(Ability.EnhancedMovement5);
    });

    /** Boots of Mobility */
    public static final Item BootsofMobilityFuror = new Item(RiotItemData.BootsofMobilityFuror, item -> {
        item.add(Ability.EnhancedMovement5);
    });

    /** Boots of Mobility */
    public static final Item BootsofMobilityHomeguard = new Item(RiotItemData.BootsofMobilityHomeguard, item -> {
        item.add(Ability.EnhancedMovement5);
    });

    /** Boots of Speed */
    public static final Item BootsOfSpeed = new Item(RiotItemData.BootsofSpeed, item -> {
        item.add(Ability.EnhancedMovement1);
    });

    /** Boots of Swiftness */
    public static final Item BootsOfSwiftness = new Item(RiotItemData.BootsofSwiftness, item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    });

    /** Boots of Swiftness */
    public static final Item BootsofSwiftnessAlacrity = new Item(RiotItemData.BootsofSwiftnessAlacrity, item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    });

    /** Boots of Swiftness */
    public static final Item BootsofSwiftnessCaptain = new Item(RiotItemData.BootsofSwiftnessCaptain, item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    });

    /** Boots of Swiftness */
    public static final Item BootsofSwiftnessDistortion = new Item(RiotItemData.BootsofSwiftnessDistortion, item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    });

    /** Boots of Swiftness */
    public static final Item BootsofSwiftnessFuror = new Item(RiotItemData.BootsofSwiftnessFuror, item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    });

    /** Boots of Swiftness */
    public static final Item BootsofSwiftnessHomeguard = new Item(RiotItemData.BootsofSwiftnessHomeguard, item -> {
        item.add(Ability.EnhancedMovement3).add(Ability.SlowResist);
    });

    /** Brawler's Gloves */
    public static final Item BrawlersGloves = new Item(RiotItemData.BrawlersGloves, item -> {
        item.critical(8);
    });

    /** The Brutalizer */
    public static final Item Brutalizer = new Item(RiotItemData.TheBrutalizer, item -> {
        item.attackDamage(25).add(Ability.ARPen10).add(Ability.CDR10);
    });

    /** Catalyst the Protector */
    public static final Item CatalystTheProtector = new Item(RiotItemData.CatalysttheProtector, item -> {
        item.health(200).mana(300).add(Ability.ValorsReward);
    });

    /** Chain Vest */
    public static final Item ChainVest = new Item(RiotItemData.ChainVest, item -> {
        item.armor(40);
    });

    /** Chalice of Harmony */
    public static final Item ChaliceOfHarmony = new Item(RiotItemData.ChaliceofHarmony, item -> {
        item.manaRegenRatio(50).magicRegist(25).add(Ability.ManaFont);
    });

    /** Cloak of Agility */
    public static final Item CloakOfAgility = new Item(RiotItemData.CloakofAgility, item -> {
        item.critical(15);
    });

    /** Cloth Armor */
    public static final Item ClothArmor = new Item(RiotItemData.ClothArmor, item -> {
        item.armor(15);
    });

    /** Item definition */
    public static final Item CrystallineBracer = new Item(RiotItemData.CrystallineBracer, item -> {
        item.health(200).healthRegenRatio(50);
    });

    /** Crystalline Flask */
    public static final Item CrystallineFlask = new Item(RiotItemData.CrystallineFlask, item -> {
        item.add(ability -> {
            ability.active("チャージを1つ消費して12秒かけて{1}し、{2}する。")
                    .variable(1, Status.RestoreHealth, 120)
                    .variable(2, RestoreMana, 60);
        }).add(ability -> {
            ability.passive("ショップを訪れる度に3つのチャージを得る。");
        });
    });

    /** Dagger */
    public static final Item Dagger = new Item(RiotItemData.Dagger, item -> {
        item.attackSpeed(15);
    });

    /** Doran's Blade */
    public static final Item DoransBlade = new Item(RiotItemData.DoransBlade, item -> {
        item.attackDamage(7).health(70).lifeSteal(3);
    });

    /** Doran's Ring */
    public static final Item DoransRing = new Item(RiotItemData.DoransRing, item -> {
        item.abilityPower(15).health(60).manaRegen(3).add(ability -> {
            ability.ununique().passive("敵ユニットを倒すと{1}する。").variable(1, RestoreMana, 4);
        });
    });

    /** Doran's Shield */
    public static final Item DoransShield = new Item(RiotItemData.DoransShield, item -> {
        item.health(80).healthRegen(6).add(ability -> {
            ability.passive("敵Championからの{1}する。").variable(1, DamageReduction, 6);
        });
    });

    /** Item definition */
    public static final Item ElixirofSorcery = new Item(RiotItemData.ElixirofSorcery, item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}と{2}を得る。また、チャンピオンかタワーにダメージを与えるたびに、{3}を追加で与える。この効果はチャンピオンに対しては5秒毎にしか発生しない。")
                    .variable(1, AP, 40)
                    .variable(2, Mreg, 15)
                    .variable(3, TrueDamage, 25);
        });
    });

    /** Item definition */
    public static final Item ElixirofRuin = new Item(RiotItemData.ElixirofRuin, item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}を得て、{2}する。また、周囲のミニオンは{2}し、自身と同じ移動速度になる。")
                    .variable(1, Health, 250)
                    .variable(2, AttackTowerDamageRatio, 15)
                    .variable(3, Tenacity, 25)
                    .variable(4, MSRatio, 15);
        });
    });

    /** Item definition */
    public static final Item ElixirofIron = new Item(RiotItemData.ElixirofIron, item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}、{2}、{3}を得る。また、通過した場所は「鋼の導べ」となり、後続の味方チャンピオンは{4}する。")
                    .variable(1, Grow, 25)
                    .variable(2, MSSlowReductionRatio, 25)
                    .variable(3, Tenacity, 25)
                    .variable(4, MSRatio, 15);
        });
    });

    /** Item definition */
    public static final Item ElixirofWrath = new Item(RiotItemData.ElixirofWrath, item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して3分間、{1}を得る。また、チャンピオンに対して物理ダメージを与えると、自身の体力がダメージの10％分回復する。これらの効果は{2}たびに30秒間延長する。")
                    .variable(1, AD, 25)
                    .variable(2, Takedown);
        });
    });

    /** Face of the Mountain */
    public static final Item FaceOfTheMountain = new Item(RiotItemData.FaceoftheMountain, item -> {
        item.health(500)
                .healthRegenRatio(100)
                .cooldownReduction(10)
                .add(Ability.GoldIncome)
                .add(Ability.SpoilsofWarLevel3)
                .add("Deadly Phalanx", ability -> {
            ability.active("あなたは{1}を失う。対象の味方は4秒間{2}を得る。また、4秒後にその味方の周囲の敵に{3}を与える。{4}")
                    .variable(1, CurrentHealthRatio, 20)
                    .variable(2, Shield, 0, 0, amplify(Health, 0.1))
                    .variable(3, MagicDamage, 0, 0, amplify(Health, 0.1))
                    .variable(4, ItemCD, 60)

                    .update(P403)
                    .active("対象の味方は4秒間{2}を得る。また、4秒後にその味方の周囲の敵に{3}を与える。{4}")
                    .variable(1, HealthRatio, 10)
                    .variable(2, Shield, 0, 0, amplify(Health, 0.1))
                    .variable(3, MagicDamage, 0, 0, amplify(TargetAD, 1), amplify(TargetAP, 0.3))
                    .variable(4, ItemCD, 60);
        })

                .update(P403)

        ;
    });

    /** Faerie Charm */
    public static final Item FaerieCharm = new Item(RiotItemData.FaerieCharm, item -> {
        item.manaRegenRatio(25);
    });

    /** Fiendish Codex */
    public static final Item FiendishCodex = new Item(RiotItemData.FiendishCodex, item -> {
        item.abilityPower(30).add(Ability.CDR10);
    });

    /** Forbidden Idol */
    public static final Item ForbiddenIdol = new Item(RiotItemData.ForbiddenIdol, item -> {
        item.manaRegenRatio(50).add(Ability.CDR10);
    });

    /** Frostfang */
    public static final Item Frostfang = new Item(RiotItemData.Frostfang, item -> {
        item.abilityPower(10).manaRegenRatio(50).goldGeneration(2).add(Ability.GoldIncome).add(Ability.TributeLevel2);
    });

    /** Frost Queen's Claim */
    public static final Item FrostQueensClaim = new Item(RiotItemData.FrostQueensClaim, item -> {
        item.abilityPower(50)
                .manaRegen(10)
                .goldGeneration(2)
                .cooldownReduction(10)
                .add(Ability.GoldIncome)
                .add(Ability.TributeLevel2)
                .add(Ability.ArcticEmbrace);
    });

    /** Frozen Heart */
    public static final Item FrozenHeart = new Item(RiotItemData.FrozenHeart, item -> {
        item.cooldownReduction(20).armor(100).mana(400).add(ability -> {
            ability.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, ASSlowRatio, 15);
        });
    });

    /** Frozen Mallet */
    public static final Item FrozenMallet = new Item(RiotItemData.FrozenMallet, item -> {
        item.attackDamage(30).health(700).add(Ability.Icy2);
    });

    /** Giant's Belt */
    public static final Item GiantsBelt = new Item(RiotItemData.GiantsBelt, item -> {
        item.health(380);
    });

    /** Glacial Shroud */
    public static final Item GlacialShroud = new Item(RiotItemData.GlacialShroud, item -> {
        item.armor(20).mana(250).add(Ability.CDR10);
    });

    /** Guardian Angel */
    public static final Item GuardianAngel = new Item(RiotItemData.GuardianAngel, item -> {
        item.armor(50)
                .magicRegist(30)
                .add(ability -> {
            ability.passive("Healthが0になった際、4秒後に{1}と{2}を得て復活する。{3}。")
                    .variable(-1, Health, 0, 0, amplify(Health, 0.3))
                    .variable(-2, Mana, 0, 0, amplify(Mana, 0.3))
                    .variable(3, ItemCD, 300);
        })

                .update(P310)

                .magicRegist(40);
    });

    /** Guinsoo's Rageblade */
    public static final Item GuinsoosRageblade = new Item(RiotItemData.GuinsoosRageblade, item -> {
        item.attackDamage(30).abilityPower(40).add(ability -> {
            ability.ununique()
                    .passive("通常攻撃またはスキル使用時にスタックが1増加する。1スタックにつき{1}し{2}を得る。スタックは8秒持続し、最大8スタックまで増加する。")
                    .variable(-1, ASRatio, 4)
                    .variable(-2, AP, 4);
        }).add(ability -> {
            ability.passive("自身のHealthが50%以下になった際に、戦闘状態が終わるまでの間{1}し{2}と{3}を得る。8秒間戦闘を行わないと解除される。{4}。")
                    .variable(-1, ASRatio, 20)
                    .variable(-2, LS, 10)
                    .variable(-3, SV, 10)
                    .variable(4, ItemCD, 30);
        });
    });

    /** Haunting Guise */
    public static final Item HauntingGuise = new Item(RiotItemData.HauntingGuise, item -> {
        item.abilityPower(25).health(200).add(Ability.EyesOfPain);
    });

    /** Health Potion */
    public static final Item HealthPotion = new Item(RiotItemData.HealthPotion, item -> {
        item.add(ability -> {
            ability.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreHealth, 150);
        });
    });

    /** Hexdrinker */
    public static final Item Hexdrinker = new Item(RiotItemData.Hexdrinker, item -> {
        item.attackDamage(25).magicRegist(30).add(Ability.LifelineLevel1);
    });

    /** Hextech Gunblade */
    public static final Item HextechGunblade = new Item(RiotItemData.HextechGunblade, item -> {
        item.lifeSteal(12).attackDamage(45).abilityPower(65).add(ability -> {
            ability.passive("{1}を得る。敵Championに通常攻撃でダメージを与えるか、単体対象かつDoTではないダメージスキルを使用するたびに、このアイテムのUNIQUE ActiveのCDが3秒解消する。")
                    .variable(1, SV, 20);
        }).add(ability -> {
            ability.active("対象の敵Champion({1})に{2}と2秒間{3}を与える。{4}。")
                    .variable(1, Radius, 700)
                    .variable(2, MagicDamage, 150, 0, ap(0.4))
                    .variable(3, MSSlowRatio, 40)
                    .variable(4, ItemCD, 60);
        });
    });

    /** Hextech Revolver */
    public static final Item HextechRevolver = new Item(RiotItemData.HextechRevolver, item -> {
        item.abilityPower(40).add(ability -> {
            ability.passive("{1}を得る。").variable(1, SV, 12);
        });
    });

    /** Hunter's Machete */
    public static final Item HuntersMachete = new Item(RiotItemData.HuntersMachete, item -> {
        item.add(Ability.GoldIncome).add(ability -> {
            ability.passive("大型モンスターを倒すたびに{1}を得る。").variable(1, Gold, 15);
        }).add("ジャングラー", ability -> {
            ability.passive("モンスターに対する攻撃命中時に2秒間かけて{1}を与える。また、モンスターとの戦闘中、毎秒{2}、{3}する（非好戦的なモンスターの場合、自動回復効果はなし）。")
                    .variable(1, MagicDamage, 30)
                    .variable(2, RestoreHealth, 7)
                    .variable(3, RestoreMana, 3);
        });
    });

    /** Iceborn Gauntlet */
    public static final Item IcebornGauntlet = new Item(RiotItemData.IcebornGauntlet, item -> {
        item.abilityPower(30).cooldownReduction(10).armor(70).mana(500).add(Ability.SpellbladeIceborn);
    });

    /** Infinity Edge */
    public static final Item InfinityEdge = new Item(RiotItemData.InfinityEdge, item -> {
        item.attackDamage(70).critical(25).add(Ability.InfinityEdgePassive);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsOfLucidity = new Item(RiotItemData.IonianBootsofLucidity, item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsofLucidityAlacrity = new Item(RiotItemData.IonianBootsofLucidityAlacrity, item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsofLucidityCaptain = new Item(RiotItemData.IonianBootsofLucidityCaptain, item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsofLucidityDistortion = new Item(RiotItemData.IonianBootsofLucidityDistortion, item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsofLucidityFuror = new Item(RiotItemData.IonianBootsofLucidityFuror, item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsofLucidityHomeguard = new Item(RiotItemData.IonianBootsofLucidityHomeguard, item -> {
        item.add(Ability.Ionian).add(Ability.EnhancedMovement2);
    });

    /** Kindlegem */
    public static final Item Kindlegem = new Item(RiotItemData.Kindlegem, item -> {
        item.health(200).add(Ability.CDR10);
    });

    /** Last Whisper */
    public static final Item LastWhisper = new Item(RiotItemData.LastWhisper, item -> {
        item.attackDamage(40)
                .add(Ability.LastWhisperPassive)

                .update(P314);
    });

    /** Liandry's Torment */
    public static final Item LiandrysTorment = new Item(RiotItemData.LiandrysTorment, item -> {
        item.abilityPower(50).health(300).add(Ability.EyesOfPain).add(Ability.LiandrysTormentPassive);
    });

    /** Lich Bane */
    public static final Item LichBane = new Item(RiotItemData.LichBane, item -> {
        item.abilityPower(80).mana(250).movementSpeed(5).add(Ability.SpellbladeLich);
    });

    /** Locket of the Iron Solari */
    public static final Item LocketOftheIronSolari = new Item(RiotItemData.LocketoftheIronSolari, item -> {
        item.cooldownReduction(10).health(400).magicRegist(20).add(Ability.Legion).add(ability -> {
            ability.active("{1}の味方に５秒間{2}を付与する。{3}。")
                    .variable(1, Radius, 600)
                    .variable(2, Shield, 50, 0, amplify(Lv, 10))
                    .variable(3, ItemCD, 60);
        });
    });

    /** Long Sword */
    public static final Item LongSword = new Item(RiotItemData.LongSword, item -> {
        item.attackDamage(10);
    });

    /** Mana Potion */
    public static final Item ManaPotion = new Item(RiotItemData.ManaPotion, item -> {
        item.add(ability -> {
            ability.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreMana, 100);
        });
    });

    /** Manamune */
    public static final Item Manamune = new Item(RiotItemData.Manamune, item -> {
        item.attackDamage(20)
                .manaRegen(7)
                .mana(250)
                .add(Ability.Awe)
                .add(Ability.ManamuneManaCharge)

                .update(P314);
    });

    /** Maw of Malmortius */
    public static final Item MawOfMalmortius = new Item(RiotItemData.MawofMalmortius, item -> {
        item.attackDamage(55)
                .magicRegist(36)
                .add(Ability.MawOfMalmortiusPassive)
                .add(Ability.LifelineLevel2)

                .update(P309)
                .attackDamage(60)
                .magicRegist(40);
    });

    /** Mejai's Soulstealer */
    public static final Item MejaisSoulstealer = new Item(RiotItemData.MejaisSoulstealer, item -> {
        item.abilityPower(20).add(Ability.MejaisSoulstealerPassive);
    });

    /** Mercurial Scimitar */
    public static final Item MercurialScimitar = new Item(RiotItemData.MercurialScimitar, item -> {
        item.attackDamage(60).magicRegist(45).add(Ability.Quicksilver2);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreads = new Item(RiotItemData.MercurysTreads, item -> {
        item.magicRegist(25).add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreadsAlacrity = new Item(RiotItemData.MercurysTreadsAlacrity, item -> {
        item.magicRegist(25).add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreadsCaptain = new Item(RiotItemData.MercurysTreadsCaptain, item -> {
        item.magicRegist(25).add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreadsDistortion = new Item(RiotItemData.MercurysTreadsDistortion, item -> {
        item.magicRegist(25).add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreadsFuror = new Item(RiotItemData.MercurysTreadsFuror, item -> {
        item.magicRegist(25).add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreadsHomeguard = new Item(RiotItemData.MercurysTreadsHomeguard, item -> {
        item.magicRegist(25).add(Ability.EnhancedMovement2).add(Ability.TenacityEffect);
    });

    /** Mikael's Crucible */
    public static final Item MikaelsCrucible = new Item(RiotItemData.MikaelsCrucible, item -> {

    });

    /** Morellonomicon */
    public static final Item Morellonomicon = new Item(RiotItemData.Morellonomicon, item -> {
    });

    /** Muramana */
    public static final Item Muramana = new Item(RiotItemData.Muramana, item -> {
        item.attackDamage(20).manaRegen(7).mana(1000).add(Ability.Awe).add(Ability.MuramanaToggle);
    });

    /** Nashor's Tooth */
    public static final Item NashorsTooth = new Item(RiotItemData.NashorsTooth, item -> {
        item.abilityPower(65)
                .attackSpeed(50)
                .add(Ability.NashorsToothPassive)

                .update(P308)

                .abilityPower(60);
    });

    /** Needlessly Large Rod */
    public static final Item NeedlesslyLargeRod = new Item(RiotItemData.NeedlesslyLargeRod, item -> {
        item.abilityPower(60);
    });

    /** Negatron Cloak */
    public static final Item NegatronCloak = new Item(RiotItemData.NegatronCloak, item -> {
        item.magicRegist(45);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabi = new Item(RiotItemData.NinjaTabi, item -> {
        item.armor(25).add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabiAlacrity = new Item(RiotItemData.NinjaTabiAlacrity, item -> {
        item.armor(25).add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabiCaptain = new Item(RiotItemData.NinjaTabiCaptain, item -> {
        item.armor(25).add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabiDistortion = new Item(RiotItemData.NinjaTabiDistortion, item -> {
        item.armor(25).add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabiFuror = new Item(RiotItemData.NinjaTabiFuror, item -> {
        item.armor(25).add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabiHomeguard = new Item(RiotItemData.NinjaTabiHomeguard, item -> {
        item.armor(25).add(Ability.BlockDamage).add(Ability.EnhancedMovement2);
    });

    /** Nomad's Medallion */
    public static final Item NomadsMedallion = new Item(RiotItemData.NomadsMedallion, item -> {
        item.healthRegenRatio(25)
                .manaRegenRatio(50)
                .goldGeneration(2)
                .set(MS, 10)
                .add(Ability.GoldIncome)
                .add(Ability.FavorLevel2);
    });

    /** Null-Magic Mantle */
    public static final Item NullMagicMantle = new Item(RiotItemData.NullMagicMantle, item -> {
        item.magicRegist(25);
    });

    /** Ohmwrecker */
    public static final Item Ohmwrecker = new Item(RiotItemData.Ohmwrecker, item -> {

    });

    /** Phage */
    public static final Item Phage = new Item(RiotItemData.Phage, item -> {
        item.attackDamage(20).health(200).add(Ability.Rage);
    });

    /** Phantom Dancer */
    public static final Item PhantomDancer = new Item(RiotItemData.PhantomDancer, item -> {
        item.attackSpeed(50).movementSpeed(5).critical(30).add(Ability.PhantomDancerPassive);
    });

    /** Pickaxe */
    public static final Item Pickaxe = new Item(RiotItemData.Pickaxe, item -> {
        item.attackDamage(25);
    });

    /** PoachersKnife */
    public static final Item PoachersKnife = new Item(RiotItemData.PoachersKnife, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.ScavengingSmite).add(Ability.Jungler);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeCinderhulk = new Item(RiotItemData.PoachersKnifeCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeDevourer = new Item(RiotItemData.PoachersKnifeDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeRuneglaive = new Item(RiotItemData.PoachersKnifeRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.SpellbladeRuneglaive);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeWarrior = new Item(RiotItemData.PoachersKnifeWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeSatedDevourer = new Item(RiotItemData.PoachersKnifeSatedDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.PhantomHit);
    });

    /** The Hex Core */
    public static final Item PrototypeHexCore = new Item(RiotItemData.PrototypeHexCore, item -> {
        item.add(ability -> {
            ability.passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 3));
        });
    });

    /** The Hex Core */
    public static final Item PerfectHexCore = new Item(RiotItemData.PerfectHexCore, item -> {
        item.abilityPower(60).mana(500).add(ability -> {
            ability.passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 6));
        });
    });

    /** Quicksilver Sash */
    public static final Item QuicksilverSash = new Item(RiotItemData.QuicksilverSash, item -> {
        item.magicRegist(30).add(ability -> {
            ability.active("自身のDebuffをすべて除去する。{1}。").variable(1, ItemCD, 90);
        });
    });

    /** Rabadon's Deathcap */
    public static final Item RabadonsDeathcap = new Item(RiotItemData.RabadonsDeathcap, item -> {
        item.abilityPower(120).add(Ability.RabadonsDeathcapPassive);
    });

    /** Randuin's Omen */
    public static final Item RanduinsOmen = new Item(RiotItemData.RanduinsOmen, item -> {
        item.health(500).armor(70).add(Ability.ColdSteel).add(ability -> {
            ability.active("{1}の敵ユニットに{4}間{2}を与える。この効果時間は、自身のArmor+Magic Resistの値100につき1秒増加する。{3}。")
                    .variable(1, Radius, 500)
                    .variable(2, MSSlowRatio, 35)
                    .variable(3, ItemCD, 60)
                    .variable(4, Time, 2, 0, amplify(AR, 0.005), amplify(MR, 0.005));
        });
    });

    /** Raptor Cloak */
    public static final Item RaptorCloak = new Item(RiotItemData.RaptorCloak, item -> {
        item.armor(40).healthRegenRatio(100).add(Ability.PointRunner);
    });

    /** Ravenous Hydra */
    public static final Item RavenousHydra = new Item(RiotItemData.RavenousHydraMeleeOnly, item -> {
        item.lifeSteal(12)
                .attackDamage(75)
                .healthRegen(15)
                .add(Ability.RavenousHydraPassive)
                .add(Ability.Cleave)
                .add(Ability.Crescent)

                .update(P306);
    });

    /** Recurve Bow */
    public static final Item RecurveBow = new Item(RiotItemData.RecurveBow, item -> {
        item.attackSpeed(30).add(Ability.BowDamage);
    });

    /** Rejuvenation Bead */
    public static final Item RejuvenationBead = new Item(RiotItemData.RejuvenationBead, item -> {
        item.healthRegenRatio(50);
    });

    /** Relic Shield */
    public static final Item RelicShield = new Item(RiotItemData.RelicShield, item -> {
        item.health(75).add(Ability.GoldIncome).add(Ability.SpoilsofWarLevel1);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazer = new Item(RiotItemData.RangersTrailblazer, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.BlastingSmite).add(Ability.Jungler);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerCinderhulk = new Item(RiotItemData.RangersTrailblazerCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerDevourer = new Item(RiotItemData.RangersTrailblazerDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerRuneglaive = new Item(RiotItemData.RangersTrailblazerRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.SpellbladeRuneglaive);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerWarrior = new Item(RiotItemData.RangersTrailblazerWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerSatedDevourer = new Item(RiotItemData.RangersTrailblazerSatedDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.PhantomHit);
    });

    /** Rod of Ages */
    public static final Item RodOfAges = new Item(RiotItemData.RodofAges, item -> {
        item.abilityPower(60).health(450).mana(450).add(Ability.ValorsReward).add(ability -> {
            ability.ununique()
                    .passive("1分毎に{1}と{2}と{3}を得る。この効果は10回まで発生する。")
                    .variable(1, Health, 0, 0, amplify(Stack, 20))
                    .variable(2, Mana, 0, 0, amplify(Stack, 20))
                    .variable(3, AP, 0, 0, amplify(Stack, 2));
        });
    });

    /** Ruby Crystal */
    public static final Item RubyCrystal = new Item(RiotItemData.RubyCrystal, item -> {
        item.health(150);
    });

    /** Ruby Sightstone */
    public static final Item RubySightstone = new Item(RiotItemData.RubySightstone, item -> {
        item.health(400).add(Ability.WardRefresh2).add(Ability.GhostWard);
    });

    /** Runaan's Hurricane */
    public static final Item RunaansHurricane = new Item(RiotItemData.RunaansHurricaneRangedOnly, item -> {
        item.attackSpeed(70).add(Ability.RunaansHurricanePassive);
    });

    /** Rylai's Crystal Scepter */
    public static final Item RylaisCrystalScepter = new Item(RiotItemData.RylaisCrystalScepter, item -> {
        item.abilityPower(80).health(500).add(Ability.RylaisCrystalScepterPassive);
    });

    /** Sapphire Crystal */
    public static final Item SapphireCrystal = new Item(RiotItemData.SapphireCrystal, item -> {
        item.mana(200);
    });

    /** Seraph's Embrace */
    public static final Item SeraphsEmbrace = new Item(RiotItemData.SeraphsEmbrace, item -> {
        item.abilityPower(60).manaRegen(10).mana(1000).add(Ability.Insight).add(Ability.ManaShield);
    });

    /** Seeker's Armguard */
    public static final Item SeekersArmguard = new Item(RiotItemData.SeekersArmguard, item -> {
        item.abilityPower(25).armor(30).add(ability -> {
            ability.passive("敵ユニットを倒す度に{1}と{2}を得る。この効果は30回分までスタックする。")
                    .variable(1, AP, 0, 0, amplify(Stack, 0.5))
                    .variable(2, AR, 0, 0, amplify(Stack, 0.5));
        });
    });

    /** Sheen */
    public static final Item Sheen = new Item(RiotItemData.Sheen, item -> {
        item.abilityPower(25).mana(200).add(Ability.SpellbladeSheen);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabre = new Item(RiotItemData.SkirmishersSabre, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.ChallengingSmite).add(Ability.Jungler);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreCinderhulk = new Item(RiotItemData.SkirmishersSabreCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreDevourer = new Item(RiotItemData.SkirmishersSabreDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreRuneglaive = new Item(RiotItemData.SkirmishersSabreRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.SpellbladeRuneglaive);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreWarrior = new Item(RiotItemData.SkirmishersSabreWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreSatedDevourer = new Item(RiotItemData.SkirmishersSabreSatedDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.PhantomHit);
    });

    /** StalkersBlade */
    public static final Item StalkersBlade = new Item(RiotItemData.StalkersBlade, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.ChillingSmite).add(Ability.Jungler);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeCinderhulk = new Item(RiotItemData.StalkersBladeCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeDevourer = new Item(RiotItemData.StalkersBladeDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeRuneglaive = new Item(RiotItemData.StalkersBladeRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.SpellbladeRuneglaive);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeWarrior = new Item(RiotItemData.StalkersBladeWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeSatedDevourer = new Item(RiotItemData.StalkersBladeSatedDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.PhantomHit);
    });

    /** Sight Ward */
    public static final Item StealthWard = new Item(RiotItemData.StealthWard, item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して、視界{1}を持つオブジェクトを指定地点に設置する。オブジェクトは設置から約3秒後にステルス状態になり、3分間持続する。各プレイヤーは3つまでしか設置出来ず、3つしか携帯出来ない。{2}")
                    .variable(1, Radius, 1100)
                    .variable(2, Visionable);
        });
    });

    /** Sightstone */
    public static final Item Sightstone = new Item(RiotItemData.Sightstone, item -> {
        item.health(150).add(Ability.WardRefresh1).add(Ability.GhostWard);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoes = new Item(RiotItemData.SorcerersShoes, item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoesAlacrity = new Item(RiotItemData.SorcerersShoesAlacrity, item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoesCaptain = new Item(RiotItemData.SorcerersShoesCaptain, item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoesDistortion = new Item(RiotItemData.SorcerersShoesDistortion, item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoesFuror = new Item(RiotItemData.SorcerersShoesFuror, item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoesHomeguard = new Item(RiotItemData.SorcerersShoesHomeguard, item -> {
        item.set(MRPen, 15).add(Ability.EnhancedMovement2);
    });

    /** Spectre's Cowl */
    public static final Item SpectresCowl = new Item(RiotItemData.SpectresCowl, item -> {
        item.health(200).magicRegist(35).add(ability -> {
            ability.passive("チャンピオンからダメージを受けると10秒間{1}を得る。").variable(-1, HregRatio, 150);
        });
    });

    /** Spellthief's Edge */
    public static final Item SpellthiefsEdge = new Item(RiotItemData.SpellthiefsEdge, item -> {
        item.abilityPower(5).manaRegenRatio(25).goldGeneration(2).add(Ability.GoldIncome).add(Ability.TributeLevel1);
    });

    /** Spirit Visage */
    public static final Item SpiritVisage = new Item(RiotItemData.SpiritVisage, item -> {
        item.health(200)
                .cooldownReduction(20)
                .magicRegist(50)
                .add(Ability.SpiritVisagePassive)

                .update(P310)

                .health(400)
                .magicRegist(55)
                .healthRegen(20)

                .update(P310A)

                .update(P401)
                .cooldownReduction(10);
    });

    /** Statikk Shiv */
    public static final Item StatikkShiv = new Item(RiotItemData.StatikkShiv, item -> {
        item.attackSpeed(40).movementSpeed(6).critical(20).add(Ability.StatikkShivPassive);
    });

    /** Stinger */
    public static final Item Stinger = new Item(RiotItemData.Stinger, item -> {
        item.attackSpeed(40).add(Ability.CDR10);
    });

    /** Sunfire Cape */
    public static final Item SunfireCape = new Item(RiotItemData.SunfireCape, item -> {
        item.health(450).armor(45).add(Ability.SunfireCapePassive);
    });

    /** Sword of the Occult */
    public static final Item SwordOftheOccult = new Item(RiotItemData.SwordoftheOccult, item -> {
        item.attackDamage(10)
                .add(Ability.SwordOftheOccultPassive)

                .update(P314);
    });

    /** Targon's Brace */
    public static final Item TargonsBrace = new Item(RiotItemData.TargonsBrace, item -> {
        item.health(175).healthRegenRatio(50).add(Ability.GoldIncome).add(Ability.SpoilsofWarLevel2);
    });

    /** Talisman of Ascension */
    public static final Item TalismanOfAscension = new Item(RiotItemData.TalismanofAscension, item -> {
        item.healthRegenRatio(100)
                .manaRegenRatio(100)
                .cooldownReduction(10)
                .set(MS, 20)
                .goldGeneration(2)
                .add(Ability.GoldIncome)
                .add(Ability.FavorLevel2)
                .add(ability -> {
            ability.active("{1}の味方は3秒間{2}する。{3}。")
                    .variable(1, Radius, 600)
                    .variable(2, MSRatio, 40)
                    .variable(3, ItemCD, 40);
        });
    });

    /** Tear of the Goddess */
    public static final Item TearOftheGoddess = new Item(RiotItemData.TearoftheGoddess, item -> {
        item.manaRegenRatio(25).mana(250).add(Ability.ManaChargeLevel1);
    });

    /** Augment: Power */
    public static final Item TheHexCoremk1 = new Item(RiotItemData.TheHexCoremk1, item -> {
    });

    /** Augment: Gravity */
    public static final Item TheHexCoremk2 = new Item(RiotItemData.TheHexCoremk2, item -> {
    });

    /** Thornmail */
    public static final Item Thornmail = new Item(RiotItemData.Thornmail, item -> {
        item.armor(100).add(ability -> {
            ability.passive("敵の通常攻撃受けるとその攻撃者に{1}を与える。")
                    .variable(1, MagicDamage, 0, 0, amplify(ReceivedOriginalDamageRatio, 30));
        });
    });

    /** Tiamat */
    public static final Item Tiamat = new Item(RiotItemData.TiamatMeleeOnly, item -> {
        item.attackDamage(40).healthRegenRatio(100).add(Ability.Cleave).add(Ability.Crescent);
    });

    /** Trinity Force */
    public static final Item TrinityForce = new Item(RiotItemData.TrinityForce, item -> {
        item.attackDamage(30)
                .abilityPower(30)
                .health(250)
                .attackSpeed(30)
                .mana(200)
                .movementSpeed(8)
                .critical(10)
                .add(Ability.SpellbladeTrinityForce)

                .update(P310A)
                .add(Ability.Rage);
    });

    /** Twin Shadows */
    public static final Item TwinShadows = new Item(RiotItemData.TwinShadows, item -> {

    });

    /** Vampiric Scepter */
    public static final Item VampiricScepter = new Item(RiotItemData.VampiricScepter, item -> {
        item.lifeSteal(8).attackDamage(10);
    });

    /** Vision Ward */
    public static final Item VisionWard = new Item(RiotItemData.VisionWard, item -> {
        item.add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して、ステルスを看破できる視界{1}を持ち耐久値5のオブジェクトを指定地点に設置する。これは永久に持続する。各プレイヤーは1個しか設置出来ず、2個しか携帯出来ない。{2}")
                    .variable(1, Radius, 1100)
                    .variable(2, Visionable);
        });
    });

    /** Void Staff */
    public static final Item VoidStaff = new Item(RiotItemData.VoidStaff, item -> {
        item.abilityPower(70).add(ability -> {
            ability.passive("{1}を得る。").variable(1, MRPenRatio, 35);
        });
    });

    /** Warden's Mail */
    public static final Item WardensMail = new Item(RiotItemData.WardensMail, item -> {
        item.armor(45).add(Ability.ColdSteel);
    });

    /** Warmog's Armor */
    public static final Item WarmogsArmor = new Item(RiotItemData.WarmogsArmor, item -> {
        item.health(1000)
                .add(ability -> {
            ability.passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(Health, 0.01));
        })

                .update(P403);
    });

    /** Will of the Ancients */
    public static final Item WillOftheAncients = new Item(RiotItemData.WilloftheAncients, item -> {

    });

    /** Wit's End */
    public static final Item WitsEnd = new Item(RiotItemData.WitsEnd, item -> {
        item.attackSpeed(40)
                .magicRegist(25)
                .add(Ability.WitsEndPassive)

                .update(P308)

                .attackSpeed(42);
    });

    /** Youmuu's Ghostblade */
    public static final Item YoumuusGhostblade = new Item(RiotItemData.YoumuusGhostblade, item -> {
        item.attackDamage(30)
                .cooldownReduction(10)
                .critical(15)
                .add(Ability.YoumuusGhostbladePassive)
                .add(Ability.YoumuusGhostbladeActive);
    });

    /** Zeal */
    public static final Item Zeal = new Item(RiotItemData.Zeal, item -> {
        item.attackSpeed(20).movementSpeed(5).critical(10);
    });

    /** Zeke's Herald */
    public static final Item ZekesHerald = new Item(RiotItemData.ZekesHerald, item -> {
        item.health(250).cooldownReduction(20).add(Ability.ZekesHeraldAura);
    });

    /** Zephyr */
    public static final Item Zephyr = new Item(RiotItemData.Zephyr, item -> {
        item.attackDamage(25).cooldownReduction(10).attackSpeed(50).movementSpeed(10).add(Ability.TenacityEffect);
    });

    /** Zhonya's Hourglass */
    public static final Item ZhonyasHourglass = new Item(RiotItemData.ZhonyasHourglass, item -> {
        item.abilityPower(120).armor(50).add(Ability.Stasis);
    });

    // lazy initialization
    static {
        try {
            for (Field field : Item.class.getFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Item item = (Item) field.get(null);
                    ItemDescriptor descriptor = item.update();

                    if (item.data.from != null) {
                        descriptor.build(item.data.from);
                    }
                    item.descriptor.accept(descriptor);
                }
            }
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /** The sequencial id. */
    public final int position;

    /** The item id. */
    public final int id;

    /** The item name. */
    public final String name;

    /** The item description. */
    private final Consumer<ItemDescriptor> descriptor;

    /** The riot provided item data. */
    private final RiotItemData data;

    /**
     * <p>
     * Create Item.
     * </p>
     * 
     * @param id
     * @param name
     */
    Item(RiotItemData data, Consumer<ItemDescriptor> descriptor) {
        this.data = data;
        this.position = counter++;
        this.id = data.id;
        this.name = data.name;
        this.descriptor = descriptor;

        items.add(this);
    }

    /**
     * <p>
     * Apply icon image.
     * </p>
     */
    public void applyIcon(Element element) {
        element.css("background-image", "url(src/main/resources/teemowork/items.jpg)")
                .css("background-position", position / (counter - 1) * 100 + "% 0%")
                .css("background-size", "cover")
                .css("background-origin", "border-box");
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
    protected ItemDescriptor createDescriptor(Version version, ItemDescriptor previous) {
        return new ItemDescriptor(this, previous, version);
    }

    /**
     * <p>
     * Calcurate item total cost.
     * </p>
     * 
     * @param version
     * @return
     */
    public double getTotalCost() {
        return data.buyTotal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * <p>
     * List up all Items.
     * </p>
     * 
     * @return
     */
    public static List<Item> getAll() {
        return items;
    }

    /**
     * <p>
     * Find Item by name.
     * </p>
     * 
     * @param name A Item name.
     * @return A matched Item.
     */
    public static Item getByName(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * <p>
     * Find Item by id.
     * </p>
     * 
     * @param id A Item id.
     * @return A matched Item.
     */
    public static Item getById(int id) {
        for (Item item : items) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    public static int size() {
        return counter;
    }
}
