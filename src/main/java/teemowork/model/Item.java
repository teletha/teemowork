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
        item.cost(980).abilityPower(70).magicRegist(45).add(ability -> {
            ability.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, MRReduction, 20);
        });
    });

    /** Aegis of the Legion */
    public static final Item AegisOftheLegion = new Item(RiotItemData.AegisoftheLegion, item -> {

    });

    /** Aether Wisp */
    public static final Item AetherWisp = new Item(RiotItemData.AetherWisp, item -> {
        item.abilityPower(30).add(ability -> {
            ability.passive("{1}する。").variable(1, MSRatio, 5);
        });
    });

    /** Amplifying Tome */
    public static final Item AmplifyingTome = new Item(RiotItemData.AmplifyingTome, item -> {
        item.cost(435).abilityPower(20);
    });

    /** Ancient Coin */
    public static final Item AncientCoin = new Item(RiotItemData.AncientCoin, item -> {
        item.manaRegenRatio(25).add(Ability.GoldIncome).add("Favor", ability -> {
            ability.passive("{3}であなたが殺すことなくミニオンが死んだ場合に{1}獲得し、{2}する。")
                    .variable(1, Gold, 3)
                    .variable(2, RestoreHealth, 5)
                    .variable(3, Radius, 1400);
        });
    });

    /** Archangel's Staff */
    public static final Item ArchangelsStaff = new Item(RiotItemData.ArchangelsStaff, item -> {
        item.cost(1140).abilityPower(60).manaRegen(10).mana(250).add(Ability.ArchangelInsight).add(Ability.ManaCharge);
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
        item.cost(900)
                .abilityPower(60)
                .manaRegen(15)
                .magicRegist(40)
                .cooldownReduction(20)
                .add(Ability.AtheneRestore)
                .add(Ability.ManaFont);
    });

    /** Avarice Blade */
    public static final Item AvariceBlade = new Item(RiotItemData.AvariceBlade, item -> {
        item.cost(400).critical(10).add(Ability.Avarice).add(Ability.Greed);
    });

    /** B. F. Sword */
    public static final Item BFSword = new Item(RiotItemData.BFSword, item -> {
        item.cost(1550).attackDamage(45);
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

    });

    /** Banshee's Veil */
    public static final Item BansheesVeil = new Item(RiotItemData.BansheesVeil, item -> {
        item.cost(600)
                .health(400)
                .mana(300)
                .magicRegist(45)
                .add(ability -> {
            ability.passive("敵Championからのスキルを無効化するシールドを張る。シールドはスキルを無効化すると消費され、25秒間敵Championからダメージを受けないと再生する。");
        })

                .update(P310)

                .cost(875)
                .health(450)
                .magicRegist(55)
                .mana(0)
                .add(ability -> {
            ability.passive("Championからダメージを受けると10秒間{1}を得る。").variable(-1, Hreg, 45);
        })

                .update(P403)
                .price(950, 1925);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreaves = new Item(RiotItemData.BerserkersGreaves, item -> {
        item.cost(150)
                .attackSpeed(20)
                .add(Ability.EnhancedMovement2)

                .update(P308)
                .cost(175);
    });

    /** Bilgewater Cutlass */
    public static final Item BilgewaterCutlass = new Item(RiotItemData.BilgewaterCutlass, item -> {
        item.cost(200)
                .lifeSteal(12)
                .attackDamage(25)
                .add(ability -> {
            ability.active("対象の敵Champion({0})に{1}と2秒間{2}与える。{3}。")
                    .variable(0, Radius, 550)
                    .variable(1, MagicDamage, 100)
                    .variable(2, MSSlowRatio, 25)
                    .variable(3, ItemCD, 90)

                    .update(P310A)
                    .variable(0, Radius, 450);
        })

                .update(P314)
                .price(240, 980);
    });

    /** The Black Cleaver */
    public static final Item BlackCleaver = new Item(RiotItemData.TheBlackCleaver, item -> {
        item.cost(1188)
                .attackDamage(50)
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

                .update(P403)
                .price(1263, 2100);
    });

    /** Blade of the Ruined King */
    public static final Item BladeOftheRuinedKing = new Item(RiotItemData.BladeoftheRuinedKing, item -> {
        item.cost(1000).lifeSteal(15).attackDamage(25).attackSpeed(40).add(ability -> {
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
        item.cost(860).abilityPower(40);
    });

    /** The Bloodthirster */
    public static final Item Bloodthirster = new Item(RiotItemData.TheBloodthirster, item -> {
        item.cost(850).lifeSteal(12).attackDamage(70).add(ability -> {
            ability.ununique()
                    .passive("敵ユニットを倒す度に{1}と{2}を得る。この効果は30回分までスタックし、死亡すると半分のスタックが失われる。")
                    .variable(1, AD, 0, 0, amplify(Stack, 1))
                    .variable(2, LS, 0, 0, amplify(Stack, 0.2));
        });
    });

    /** Boots of Mobility */
    public static final Item BootsOfMobility = new Item(RiotItemData.BootsofMobility, item -> {
        item.cost(650)
                .add(Ability.EnhancedMovement5)

                .update(P308)
                .cost(675)

                .update(P403)
                .cost(475);
    });

    /** Boots of Speed */
    public static final Item BootsOfSpeed = new Item(RiotItemData.BootsofSpeed, item -> {
        item.cost(350)
                .add(Ability.EnhancedMovement1)

                .update(P308)
                .cost(325);
    });

    /** Boots of Swiftness */
    public static final Item BootsOfSwiftness = new Item(RiotItemData.BootsofSwiftness, item -> {
        item.cost(650)
                .add(Ability.EnhancedMovement3)
                .add(Ability.SlowResist)

                .update(P308)
                .cost(675);
    });

    /** Brawler's Gloves */
    public static final Item BrawlersGloves = new Item(RiotItemData.BrawlersGloves, item -> {
        item.cost(400).critical(8);
    });

    /** The Brutalizer */
    public static final Item Brutalizer = new Item(RiotItemData.TheBrutalizer, item -> {
        item.cost(547)
                .attackDamage(25)
                .add(ability -> {
            ability.passive("{1}と{2}を得る。").variable(1, CDR, 10).variable(2, ARPen, 10);
        })

                .update(P314)
                .price(617, 936);
    });

    /** Catalyst the Protector */
    public static final Item CatalystTheProtector = new Item(RiotItemData.CatalysttheProtector, item -> {
        item.cost(325)
                .health(200)
                .mana(300)
                .add(Ability.ValorsReward)

                .update(P403)
                .price(400, 840);
    });

    /** Chain Vest */
    public static final Item ChainVest = new Item(RiotItemData.ChainVest, item -> {
        item.cost(720).armor(40);
    });

    /** Chalice of Harmony */
    public static final Item ChaliceOfHarmony = new Item(RiotItemData.ChaliceofHarmony, item -> {
        item.cost(120).manaRegen(7).magicRegist(25).add(Ability.ManaFont);
    });

    /** Cloak of Agility */
    public static final Item CloakOfAgility = new Item(RiotItemData.CloakofAgility, item -> {
        item.cost(730).critical(15);
    });

    /** Cloth Armor */
    public static final Item ClothArmor = new Item(RiotItemData.ClothArmor, item -> {
        item.cost(300).armor(15);
    });

    /** Item definition */
    public static final Item CrystallineBracer = new Item(RiotItemData.CrystallineBracer, item -> {
        item.health(200).healthRegen(50);
    });

    /** Crystalline Flask */
    public static final Item CrystallineFlask = new Item(RiotItemData.CrystallineFlask, item -> {
        item.cost(345).add(ability -> {
            ability.active("チャージを1つ消費して12秒かけて{1}し、{2}する。")
                    .variable(1, Status.RestoreHealth, 120)
                    .variable(2, RestoreMana, 60);
        }).add(ability -> {
            ability.passive("ショップを訪れる度に3つのチャージを得る。");
        });
    });

    /** Dagger */
    public static final Item Dagger = new Item(RiotItemData.Dagger, item -> {
        item.cost(400).attackSpeed(12);
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

    /** Faerie Charm */
    public static final Item FaerieCharm = new Item(RiotItemData.FaerieCharm, item -> {
        item.cost(180).manaRegen(3);
    });

    /** Fiendish Codex */
    public static final Item FiendishCodex = new Item(RiotItemData.FiendishCodex, item -> {
        item.cost(385).abilityPower(30).add(ability -> {
            ability.passive("{1}を得る。").variable(1, CDR, 10);
        });
    });

    /** Forbidden Idol */
    public static final Item ForbiddenIdol = new Item(RiotItemData.ForbiddenIdol, item -> {
        item.manaRegen(50).add(ability -> {
            ability.passive("{1}を得る。").variable(1, CDR, 10);
        });
    });

    /** Frozen Heart */
    public static final Item FrozenHeart = new Item(RiotItemData.FrozenHeart, item -> {
        item.cost(550).cooldownReduction(20).armor(95).mana(400).add(Ability.FrozenHeartPassive);
    });

    /** Frozen Mallet */
    public static final Item FrozenMallet = new Item(RiotItemData.FrozenMallet, item -> {
        item.cost(835)
                .attackDamage(30)
                .health(700)
                .add(Ability.Icy2)

                .update(P310A)

                .cost(950)

                .update(P403)
                .price(1025, 2310);
    });

    /** Giant's Belt */
    public static final Item GiantsBelt = new Item(RiotItemData.GiantsBelt, item -> {
        item.cost(1000).health(380);
    });

    /** Glacial Shroud */
    public static final Item GlacialShroud = new Item(RiotItemData.GlacialShroud, item -> {
        item.cost(230).armor(45).mana(300).add(ability -> {
            ability.passive("{1}を得る。").variable(1, CDR, 10);
        });
    });

    /** Guardian Angel */
    public static final Item GuardianAngel = new Item(RiotItemData.GuardianAngel, item -> {
        item.cost(1480)
                .armor(50)
                .magicRegist(30)
                .add(ability -> {
            ability.passive("Healthが0になった際、4秒後に{1}と{2}を得て復活する。{3}。")
                    .variable(-1, Health, 0, 0, amplify(Health, 0.3))
                    .variable(-2, Mana, 0, 0, amplify(Mana, 0.3))
                    .variable(3, ItemCD, 300);
        })

                .update(P310)

                .cost(1310)
                .magicRegist(40);
    });

    /** Guinsoo's Rageblade */
    public static final Item GuinsoosRageblade = new Item(RiotItemData.GuinsoosRageblade, item -> {
        item.cost(865).attackDamage(30).abilityPower(40).add(ability -> {
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
        item.cost(575)
                .abilityPower(25)
                .health(200)
                .add(Ability.EyesOfPain)

                .update(P403)
                .price(650, 1040);
    });

    /** Health Potion */
    public static final Item HealthPotion = new Item(RiotItemData.HealthPotion, item -> {
        item.cost(35).add(ability -> {
            ability.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreHealth, 150);
        });
    });

    /** Hexdrinker */
    public static final Item Hexdrinker = new Item(RiotItemData.Hexdrinker, item -> {
        item.cost(550)
                .attackDamage(25)
                .magicRegist(25)
                .add(Ability.Lifeline1)

                .update(P314)
                .price(590, 945);
    });

    /** Hextech Gunblade */
    public static final Item HextechGunblade = new Item(RiotItemData.HextechGunblade, item -> {
        item.cost(800).lifeSteal(12).attackDamage(45).abilityPower(65).add(ability -> {
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
        item.cost(330).abilityPower(40).add(Ability.HextechRevolverPassive);
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
        item.cost(700).abilityPower(30).cooldownReduction(10).armor(70).mana(500).add(Ability.Spellblade);
    });

    /** Infinity Edge */
    public static final Item InfinityEdge = new Item(RiotItemData.InfinityEdge, item -> {
        item.cost(645).attackDamage(70).critical(25).add(Ability.InfinityEdgePassive);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsOfLucidity = new Item(RiotItemData.IonianBootsofLucidity, item -> {
        item.cost(700)
                .add(Ability.IonianCDR)
                .add(Ability.EnhancedMovement2)

                .update(P306)
                .cost(650)

                .update(P308)
                .cost(675);
    });

    /** Kindlegem */
    public static final Item Kindlegem = new Item(RiotItemData.Kindlegem, item -> {
        item.cost(375)
                .health(200)
                .add(Ability.KindlegemPassive)

                .update(P403)
                .price(450, 595);
    });

    /** Last Whisper */
    public static final Item LastWhisper = new Item(RiotItemData.LastWhisper, item -> {
        item.cost(1025)
                .attackDamage(40)
                .add(Ability.LastWhisperPassive)

                .update(P314)
                .price(1065, 1610);
    });

    /** Liandry's Torment */
    public static final Item LiandrysTorment = new Item(RiotItemData.LiandrysTorment, item -> {
        item.cost(980).abilityPower(50).health(300).add(Ability.EyesOfPain).add(Ability.LiandrysTormentPassive);
    });

    /** Lich Bane */
    public static final Item LichBane = new Item(RiotItemData.LichBane, item -> {
        item.cost(940).abilityPower(80).mana(250).movementSpeed(5).add(Ability.LichSpellblade);
    });

    /** Locket of the Iron Solari */
    public static final Item LocketOftheIronSolari = new Item(RiotItemData.LocketoftheIronSolari, item -> {
        item.cost(520)
                .health(300)
                .cooldownReduction(10)
                .armor(35)
                .healthRegen(5)
                .add(Ability.SolariActive)

                .update(P310)

                .cost(600)
                .health(300)
                .armor(20)
                .cooldownReduction(10)
                .healthRegen(0)
                .add(Ability.Legion);
    });

    /** Long Sword */
    public static final Item LongSword = new Item(RiotItemData.LongSword, item -> {
        item.cost(400)
                .attackDamage(10)

                .update(P314)
                .cost(360)

                .update(P513)
                .set(RiotItemData.LongSword);
    });

    /** Mana Potion */
    public static final Item ManaPotion = new Item(RiotItemData.ManaPotion, item -> {
        item.cost(35).add(ability -> {
            ability.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreMana, 100);
        });
    });

    /** Manamune */
    public static final Item Manamune = new Item(RiotItemData.Manamune, item -> {
        item.cost(1000)
                .attackDamage(20)
                .manaRegen(7)
                .mana(250)
                .add(Ability.Awe)
                .add(Ability.ManamuneManaCharge)

                .update(P314)
                .price(1040, 1470);
    });

    /** Maw of Malmortius */
    public static final Item MawOfMalmortius = new Item(RiotItemData.MawofMalmortius, item -> {
        item.cost(975)
                .attackDamage(55)
                .magicRegist(36)
                .add(Ability.MawOfMalmortiusPassive)
                .add(Ability.Lifeline2)

                .update(P309)
                .attackDamage(60)
                .magicRegist(40);
    });

    /** Mejai's Soulstealer */
    public static final Item MejaisSoulstealer = new Item(RiotItemData.MejaisSoulstealer, item -> {
        item.cost(800).abilityPower(20).add(Ability.MejaisSoulstealerPassive);
    });

    /** Mercurial Scimitar */
    public static final Item MercurialScimitar = new Item(RiotItemData.MercurialScimitar, item -> {
        item.cost(600).attackDamage(60).magicRegist(45).add(Ability.Quicksilver2);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreads = new Item(RiotItemData.MercurysTreads, item -> {
        item.cost(450)
                .magicRegist(25)
                .add(Ability.EnhancedMovement2)
                .add(Ability.TenacityPassive)

                .update(P308)
                .cost(475);
    });

    /** Mikael's Crucible */
    public static final Item MikaelsCrucible = new Item(RiotItemData.MikaelsCrucible, item -> {

    });

    /** Morellonomicon */
    public static final Item Morellonomicon = new Item(RiotItemData.Morellonomicon, item -> {
    });

    /** Muramana */
    public static final Item Muramana = new Item(RiotItemData.Muramana, item -> {
        item.cost(0).attackDamage(20).manaRegen(7).mana(1000).add(Ability.Awe).add(Ability.MuramanaToggle);
    });

    /** Nashor's Tooth */
    public static final Item NashorsTooth = new Item(RiotItemData.NashorsTooth, item -> {
        item.cost(430)
                .abilityPower(65)
                .attackSpeed(50)
                .add(Ability.NashorsToothPassive)

                .update(P308)
                .cost(920)
                .abilityPower(60);
    });

    /** Needlessly Large Rod */
    public static final Item NeedlesslyLargeRod = new Item(RiotItemData.NeedlesslyLargeRod, item -> {
        item.cost(1600).abilityPower(80);
    });

    /** Negatron Cloak */
    public static final Item NegatronCloak = new Item(RiotItemData.NegatronCloak, item -> {
        item.cost(720).magicRegist(40);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabi = new Item(RiotItemData.NinjaTabi, item -> {
        item.cost(350)
                .armor(25)
                .add(Ability.NinjaTabiPassive)
                .add(Ability.EnhancedMovement2)

                .update(P308)
                .cost(375);
    });

    /** Null-Magic Mantle */
    public static final Item NullMagicMantle = new Item(RiotItemData.NullMagicMantle, item -> {
        item.cost(400).magicRegist(20);
    });

    /** Ohmwrecker */
    public static final Item Ohmwrecker = new Item(RiotItemData.Ohmwrecker, item -> {

    });

    /** Phage */
    public static final Item Phage = new Item(RiotItemData.Phage, item -> {
        item.cost(590)
                .attackDamage(20)
                .health(200)
                .add(Ability.Icy1)

                .update(P310A)
                .cost(375)
                .clear()
                .add(Ability.Rage)

                .update(P312)
                .cost(475)

                .update(P314)
                .price(490, 928)

                .update(P403)
                .price(565);
    });

    /** Phantom Dancer */
    public static final Item PhantomDancer = new Item(RiotItemData.PhantomDancer, item -> {
        item.cost(495).attackSpeed(50).movementSpeed(5).critical(30).add(Ability.PhantomDancerPassive);
    });

    /** Pickaxe */
    public static final Item Pickaxe = new Item(RiotItemData.Pickaxe, item -> {
        item.cost(875).attackDamage(25);
    });

    /** PoachersKnife */
    public static final Item PoachersKnife = new Item(RiotItemData.PoachersKnife, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.ScavengingSmite).add(Ability.Jungler);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeEnchantmentCinderhulk = new Item(RiotItemData.PoachersKnifeEnchantmentCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeEnchantmentDevourer = new Item(RiotItemData.PoachersKnifeEnchantmentDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeEnchantmentRuneglaive = new Item(RiotItemData.PoachersKnifeEnchantmentRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.RuneglaiveSpellblade);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeEnchantmentWarrior = new Item(RiotItemData.PoachersKnifeEnchantmentWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ScavengingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** PoachersKnife */
    public static final Item PoachersKnifeEnchantmentSatedDevourer = new Item(RiotItemData.PoachersKnifeEnchantmentSatedDevourer, item -> {
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
        item.cost(830).magicRegist(45).add(Ability.Quicksilver1);
    });

    /** Rabadon's Deathcap */
    public static final Item RabadonsDeathcap = new Item(RiotItemData.RabadonsDeathcap, item -> {
        item.cost(840).abilityPower(120).add(Ability.RabadonsDeathcapPassive);
    });

    /** Randuin's Omen */
    public static final Item RanduinsOmen = new Item(RiotItemData.RanduinsOmen, item -> {
        item.cost(1000).health(500).armor(70).add(Ability.ColdSteel2).add(Ability.RanduinsOmenAvtive);
    });

    /** Raptor Cloak */
    public static final Item RaptorCloak = new Item(RiotItemData.RaptorCloak, item -> {
        item.armor(40).healthRegen(100).add("ポイントランナー", ability -> {
            ability.passive("タワー（破壊されたものを含む）の周囲{1}では,2秒間{2}する。").variable(1, Radius, 1300).variable(2, MSRatio, 30);
        });
    });

    /** Ravenous Hydra */
    public static final Item RavenousHydra = new Item(RiotItemData.RavenousHydraMeleeOnly, item -> {
        item.cost(200)
                .lifeSteal(12)
                .attackDamage(75)
                .healthRegen(15)
                .add(Ability.RavenousHydraPassive)
                .add(Ability.Cleave)
                .add(Ability.Crescent)

                .update(P306)
                .cost(600);
    });

    /** Recurve Bow */
    public static final Item RecurveBow = new Item(RiotItemData.RecurveBow, item -> {
        item.cost(950)
                .attackSpeed(30)

                .update(P308)
                .cost(900);
    });

    /** Rejuvenation Bead */
    public static final Item RejuvenationBead = new Item(RiotItemData.RejuvenationBead, item -> {
        item.cost(180).healthRegen(5);
    });

    /** Relic Shield */
    public static final Item RelicShield = new Item(RiotItemData.RelicShield, item -> {
        item.health(75).add(Ability.GoldIncome).add("戦場の略奪", ability -> {
            ability.passive("60秒毎に最大2つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、体力が{2}以下のミニオンに近接攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                    .variable(1, RestoreHealth, 40)
                    .variable(2, Value, 200, 0, amplify(AD, 1));
        });
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazer = new Item(RiotItemData.RangersTrailblazer, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.BlastingSmite).add(Ability.Jungler);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerEnchantmentCinderhulk = new Item(RiotItemData.RangersTrailblazerEnchantmentCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerEnchantmentDevourer = new Item(RiotItemData.RangersTrailblazerEnchantmentDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerEnchantmentRuneglaive = new Item(RiotItemData.RangersTrailblazerEnchantmentRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.RuneglaiveSpellblade);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerEnchantmentWarrior = new Item(RiotItemData.RangersTrailblazerEnchantmentWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** RangersTrailblazer */
    public static final Item RangersTrailblazerEnchantmentSatedDevourer = new Item(RiotItemData.RangersTrailblazerEnchantmentSatedDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.BlastingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.PhantomHit);
    });

    /** Rod of Ages */
    public static final Item RodOfAges = new Item(RiotItemData.RodofAges, item -> {
        item.cost(740).abilityPower(60).health(450).mana(450).add(Ability.ValorsReward).add(ability -> {
            ability.ununique()
                    .passive("1分毎に{1}と{2}と{3}を得る。この効果は10回まで発生する。")
                    .variable(1, Health, 0, 0, amplify(Stack, 20))
                    .variable(2, Mana, 0, 0, amplify(Stack, 20))
                    .variable(3, AP, 0, 0, amplify(Stack, 2));
        });
    });

    /** Ruby Crystal */
    public static final Item RubyCrystal = new Item(RiotItemData.RubyCrystal, item -> {
        item.cost(475)
                .health(180)

                .update(P403)
                .price(400, 280)
                .health(150);
    });

    /** Ruby Sightstone */
    public static final Item RubySightstone = new Item(RiotItemData.RubySightstone, item -> {
        item.cost(125)
                .health(360)
                .add(Ability.WardRefresh2)
                .add(Ability.GhostWard2)

                .update(P314)
                .remove(Ability.GhostWard2)
                .add(Ability.GhostWard1)

                .update(P403)
                .cost(325)
                .health(400);
    });

    /** Runaan's Hurricane */
    public static final Item RunaansHurricane = new Item(RiotItemData.RunaansHurricaneRangedOnly, item -> {
        item.cost(700).attackSpeed(70).add(Ability.RunaansHurricanePassive);
    });

    /** Rylai's Crystal Scepter */
    public static final Item RylaisCrystalScepter = new Item(RiotItemData.RylaisCrystalScepter, item -> {
        item.cost(605).abilityPower(80).health(500).add(Ability.RylaisCrystalScepterPassive);
    });

    /** Sapphire Crystal */
    public static final Item SapphireCrystal = new Item(RiotItemData.SapphireCrystal, item -> {
        item.cost(400).mana(200);
    });

    /** Seraph's Embrace */
    public static final Item SeraphsEmbrace = new Item(RiotItemData.SeraphsEmbrace, item -> {
        item.cost(0).abilityPower(60).manaRegen(10).mana(1000).add(Ability.Insight).add(Ability.ManaShield);
    });

    /** Seeker's Armguard */
    public static final Item SeekersArmguard = new Item(RiotItemData.SeekersArmguard, item -> {
        item.cost(125).abilityPower(20).armor(30).add(Ability.SeekersArmguardPassive);
    });

    /** Sheen */
    public static final Item Sheen = new Item(RiotItemData.Sheen, item -> {
        item.cost(365).abilityPower(25).mana(200).add(Ability.SheenSpellblade);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabre = new Item(RiotItemData.SkirmishersSabre, item -> {
        item.add(Ability.GoldIncome).add(Ability.LargeMonsterKill).add(Ability.ChallengingSmite).add(Ability.Jungler);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreEnchantmentCinderhulk = new Item(RiotItemData.SkirmishersSabreEnchantmentCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreEnchantmentDevourer = new Item(RiotItemData.SkirmishersSabreEnchantmentDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreEnchantmentRuneglaive = new Item(RiotItemData.SkirmishersSabreEnchantmentRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.RuneglaiveSpellblade);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreEnchantmentWarrior = new Item(RiotItemData.SkirmishersSabreEnchantmentWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChallengingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** SkirmishersSabre */
    public static final Item SkirmishersSabreEnchantmentSatedDevourer = new Item(RiotItemData.SkirmishersSabreEnchantmentSatedDevourer, item -> {
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
    public static final Item StalkersBladeEnchantmentCinderhulk = new Item(RiotItemData.StalkersBladeEnchantmentCinderhulk, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .health(300)
                .set(BounusHealth, 25)
                .add(Ability.Immolate);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeEnchantmentDevourer = new Item(RiotItemData.StalkersBladeEnchantmentDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.Devouring);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeEnchantmentRuneglaive = new Item(RiotItemData.StalkersBladeEnchantmentRuneglaive, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .abilityPower(50)
                .mana(200)
                .cooldownReduction(10)
                .add(Ability.RuneglaiveSpellblade);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeEnchantmentWarrior = new Item(RiotItemData.StalkersBladeEnchantmentWarrior, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .attackDamage(40)
                .cooldownReduction(10)
                .set(ARPen, 10);
    });

    /** StalkersBlade */
    public static final Item StalkersBladeEnchantmentSatedDevourer = new Item(RiotItemData.StalkersBladeEnchantmentSatedDevourer, item -> {
        item.add(Ability.GoldIncome)
                .add(Ability.LargeMonsterKill)
                .add(Ability.ChillingSmite)
                .add(Ability.Jungler)
                .attackSpeed(50)
                .add(Ability.PhantomHit);
    });

    /** Sight Ward */
    public static final Item StealthWard = new Item(RiotItemData.StealthWard, item -> {
        item.cost(75).add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して、視界{1}を持つオブジェクトを指定地点に設置する。オブジェクトは設置から約3秒後にステルス状態になり、3分間持続する。各プレイヤーは3つまでしか設置出来ず、3つしか携帯出来ない。{2}")
                    .variable(1, Radius, 1100)
                    .variable(2, Visionable);
        });
    });

    /** Sightstone */
    public static final Item Sightstone = new Item(RiotItemData.Sightstone, item -> {
        item.cost(475)
                .health(180)
                .add(Ability.WardRefresh1)
                .add(Ability.GhostWard1)

                .update(P403)
                .health(150)
                .cost(400);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoes = new Item(RiotItemData.SorcerersShoes, item -> {
        item.cost(750)
                .set(MRPen, 15)
                .add(Ability.EnhancedMovement2)

                .update(P308)
                .cost(775);
    });

    /** Spectre's Cowl */
    public static final Item SpectresCowl = new Item(RiotItemData.SpectresCowl, item -> {
        item.cost(205)
                .health(200)
                .magicRegist(45)
                .add(Ability.SpectresCowlPassive)

                .update(P403)
                .price(280, 945);
    });

    /** Spellthief's Edge */
    public static final Item SpellthiefsEdge = new Item(RiotItemData.SpellthiefsEdge, item -> {
        item.abilityPower(5).manaRegenRatio(25).goldGeneration(2).add(Ability.GoldIncome).add("徴収", ability -> {
            ability.passive("敵Championか建物に通常攻撃かスキルを使用すると{2}を与え{1}獲得する。この効果は30秒に3度まで発生し、ミニオンを倒すと12秒間無効になる。")
                    .variable(1, Gold, 5)
                    .variable(2, TrueDamage, 10);
        });
    });

    /** Spirit Visage */
    public static final Item SpiritVisage = new Item(RiotItemData.SpiritVisage, item -> {
        item.cost(630)
                .health(200)
                .cooldownReduction(20)
                .magicRegist(50)
                .add(Ability.SpiritVisagePassive)

                .update(P310)

                .cost(375)
                .health(400)
                .magicRegist(55)
                .healthRegen(20)

                .update(P310A)
                .cost(500)

                .update(P401)
                .cooldownReduction(10);
    });

    /** Statikk Shiv */
    public static final Item StatikkShiv = new Item(RiotItemData.StatikkShiv, item -> {
        item.cost(525).attackSpeed(40).movementSpeed(6).critical(20).add(Ability.StatikkShivPassive);
    });

    /** Stinger */
    public static final Item Stinger = new Item(RiotItemData.Stinger, item -> {
        item.cost(450).attackSpeed(40).add(Ability.StingerPassive);
    });

    /** Sunfire Cape */
    public static final Item SunfireCape = new Item(RiotItemData.SunfireCape, item -> {
        item.cost(930).health(450).armor(45).add(Ability.SunfireCapePassive);
    });

    /** Sword of the Occult */
    public static final Item SwordOftheOccult = new Item(RiotItemData.SwordoftheOccult, item -> {
        item.cost(800)
                .attackDamage(10)
                .add(Ability.SwordOftheOccultPassive)

                .update(P314)
                .price(840, 840);
    });

    /** Tear of the Goddess */
    public static final Item TearOftheGoddess = new Item(RiotItemData.TearoftheGoddess, item -> {
        item.cost(120)
                .manaRegen(7)
                .mana(250)
                .add(Ability.TearManaCharge)

                .update(P403)
                .manaRegen(6);
    });

    /** Augment: Power */
    public static final Item TheHexCoremk1 = new Item(RiotItemData.TheHexCoremk1, item -> {
    });

    /** Augment: Gravity */
    public static final Item TheHexCoremk2 = new Item(RiotItemData.TheHexCoremk2, item -> {
    });

    /** Thornmail */
    public static final Item Thornmail = new Item(RiotItemData.Thornmail, item -> {
        item.cost(1180).armor(100).add(ability -> {
            ability.passive("敵の通常攻撃受けるとその攻撃者に{1}を与える。")
                    .variable(1, MagicDamage, 0, 0, amplify(ReceivedOriginalDamageRatio, 30));
        });
    });

    /** Tiamat */
    public static final Item Tiamat = new Item(RiotItemData.TiamatMeleeOnly, item -> {
        item.cost(665)
                .attackDamage(50)
                .healthRegen(15)
                .add(Ability.Cleave)
                .add(Ability.Crescent)

                .update(P306)
                .cost(265)
                .attackDamage(40)

                .update(P314)
                .price(305, 1330);
    });

    /** Trinity Force */
    public static final Item TrinityForce = new Item(RiotItemData.TrinityForce, item -> {
        item.cost(3)
                .attackDamage(30)
                .abilityPower(30)
                .health(250)
                .attackSpeed(30)
                .mana(200)
                .movementSpeed(8)
                .critical(10)
                .add(Ability.Icy1)
                .add(Ability.TrinitySpellblade)

                .update(P310A)
                .remove(Ability.Icy1)
                .add(Ability.Rage);
    });

    /** Twin Shadows */
    public static final Item TwinShadows = new Item(RiotItemData.TwinShadows, item -> {

    });

    /** Vampiric Scepter */
    public static final Item VampiricScepter = new Item(RiotItemData.VampiricScepter, item -> {
        item.cost(400)
                .lifeSteal(10)
                .attackDamage(10)

                .update(P314)
                .price(440, 560);
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
        item.cost(1000).abilityPower(70).add(ability -> {
            ability.passive("{1}を得る。").variable(1, MRPenRatio, 35);
        });
    });

    /** Warden's Mail */
    public static final Item WardensMail = new Item(RiotItemData.WardensMail, item -> {
        item.cost(500)
                .armor(50)
                .add(Ability.ColdSteel1)

                .update(P310)
                .cost(400);
    });

    /** Warmog's Armor */
    public static final Item WarmogsArmor = new Item(RiotItemData.WarmogsArmor, item -> {
        item.cost(995)
                .health(1000)
                .add(ability -> {
            ability.passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(Health, 0.01));
        })

                .update(P403)
                .price(1070, 1981);
    });

    /** Will of the Ancients */
    public static final Item WillOftheAncients = new Item(RiotItemData.WilloftheAncients, item -> {

    });

    /** Wit's End */
    public static final Item WitsEnd = new Item(RiotItemData.WitsEnd, item -> {
        item.cost(850)
                .attackSpeed(40)
                .magicRegist(25)
                .add(Ability.WitsEndPassive)

                .update(P308)

                .cost(700)
                .attackSpeed(42);
    });

    /** Youmuu's Ghostblade */
    public static final Item YoumuusGhostblade = new Item(RiotItemData.YoumuusGhostblade, item -> {
        item.cost(563)
                .attackDamage(30)
                .cooldownReduction(10)
                .critical(15)
                .add(Ability.YoumuusGhostbladePassive)
                .add(Ability.YoumuusGhostbladeActive);
    });

    /** Zeal */
    public static final Item Zeal = new Item(RiotItemData.Zeal, item -> {
        item.cost(375).attackSpeed(18).movementSpeed(5).critical(10);
    });

    /** Zeke's Herald */
    public static final Item ZekesHerald = new Item(RiotItemData.ZekesHerald, item -> {
        item.cost(900).health(250).cooldownReduction(20).add(Ability.ZekesHeraldAura);
    });

    /** Zephyr */
    public static final Item Zephyr = new Item(RiotItemData.Zephyr, item -> {
        item.cost(725)
                .attackDamage(25)
                .cooldownReduction(10)
                .attackSpeed(50)
                .movementSpeed(10)
                .add(Ability.TenacityPassive);
    });

    /** Zhonya's Hourglass */
    public static final Item ZhonyasHourglass = new Item(RiotItemData.ZhonyasHourglass, item -> {
        item.cost(500).abilityPower(120).armor(50).add(Ability.Stasis);
    });

    /** Frostfang */
    public static final Item Frostfang = new Item(RiotItemData.Frostfang, item -> {
        item.price(485, 340)
                .abilityPower(20)
                .manaRegen(7)
                .goldGeneration(4)
                .add(Ability.GoldIncome)
                .add("Tribute", ability -> {
            ability.passive("Championに通常攻撃を行うと{1}獲得する（CD{2}）。ミニオンを倒すとこの効果は10秒間無効になる。")
                    .variable(1, Gold, 8)
                    .variable(2, Time, 10)

                    .update(P403)
                    .passive("敵Championか建物に通常攻撃かスキルを使用すると{2}を与え{1}獲得する。この効果は30秒に3度まで発生し、ミニオンを倒すと12秒間無効になる。")
                    .variable(1, Gold, 10)
                    .variable(2, TrueDamage, 15);
        })

                .update(P403)
                .price(500, 346)
                .abilityPower(10)
                .manaRegen(5);
    });

    /** Frost Queen's Claim */
    public static final Item FrostQueensClaim = new Item(RiotItemData.FrostQueensClaim, item -> {
        item.price(715, 800)
                .abilityPower(50)
                .manaRegen(10)
                .goldGeneration(4)
                .add(Ability.GoldIncome)
                .add("Tribute", ability -> {
            ability.passive("Championに通常攻撃を行うと{1}獲得する（{2}）。ミニオンを倒すとこの効果は10秒間無効になる。")
                    .variable(1, Gold, 8)
                    .variable(2, ItemCD, 10)

                    .update(P403)
                    .passive("敵Championか建物に通常攻撃かスキルを使用すると{2}を与え{1}獲得する。この効果は30秒に3度まで発生する。")
                    .variable(1, Gold, 10)
                    .variable(2, TrueDamage, 15);
        })

                .update(P403)
                .price(315, 800)

                .abilityPower(40)
                .cooldownReduction(10)
                .add(ability -> {
            ability.active("対象とその{1}の敵に{2}と2秒かけて減衰する{3}を与える。{4}")
                    .variable(1, Radius)
                    .variable(2, MagicDamage, 50, 0, amplify(Lv, 5, 5))
                    .variable(3, MSSlowRatio, 80)
                    .variable(4, ItemCD, 60);
        });;
    });

    /** Nomad's Medallion */
    public static final Item NomadsMedallion = new Item(RiotItemData.NomadsMedallion, item -> {
        item.price(485, 340)
                .healthRegen(8)
                .manaRegen(11)
                .goldGeneration(2)
                .add(Ability.GoldIncome)
                .add("Favor", ability -> {
            ability.passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得する。")
                    .variable(1, Gold, 4)

                    .update(P403)
                    .passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得し、{2}する。")
                    .variable(1, Gold, 3)
                    .variable(2, RestoreHealth, 5);
        })

                .update(P403)
                .price(500, 340)
                .healthRegen(5)
                .manaRegen(7);
    });

    /** Talisman of Ascension */
    public static final Item TalismanOfAscension = new Item(RiotItemData.TalismanofAscension, item -> {
        item.price(970, 800)
                .healthRegen(10)
                .manaRegen(15)
                .cooldownReduction(20)
                .goldGeneration(2)
                .add(Ability.GoldIncome)
                .add("Favor", ability -> {
            ability.passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得する。")
                    .variable(1, Gold, 4)

                    .update(P403)
                    .passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得し、{2}する。")
                    .variable(1, Gold, 3)
                    .variable(2, RestoreHealth, 10);
        })
                .add(ability -> {
            ability.active("{1}の味方は3秒間{2}する。{3}")
                    .variable(1, Radius, 600)
                    .variable(2, MSRatio, 40)
                    .variable(3, ItemCD, 60);
        })

                .update(P403)
                .price(955, 800)
                .manaRegen(15);
    });

    /** Targon's Brace */
    public static final Item TargonsBrace = new Item(RiotItemData.TargonsBrace, item -> {
        item.price(485, 340)
                .health(175)
                .healthRegen(12)
                .add(Ability.GoldIncome)
                .add("Spoils of War", ability -> {
            ability.passive("30秒毎に最大3つまでスタックが貯まる。スタックがある状態でミニオンを倒すと最寄りの味方Championはあなたが獲得した金額+10Goｌdを獲得し、{1}する。また、Healthが{2}以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                    .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02))
                    .variable(2, Value, 200, 0, ad(1))

                    .update(P403)
                    .passive("30秒毎に最大3つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、Healthが200以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                    .variable(1, RestoreHealth, 50);
        })

                .update(P403)
                .price(500, 346)
                .health(175)
                .healthRegen(8);
    });

    /** Face of the Mountain */
    public static final Item FaceOfTheMountain = new Item(RiotItemData.FaceoftheMountain, item -> {
        item.price(675, 800)
                .health(375)
                .healthRegen(25)
                .cooldownReduction(10)
                .add(Ability.GoldIncome)
                .add("Spoils of War", ability -> {
            ability.passive("30秒毎に最大4つまでスタックが貯まる。スタックがある状態でミニオンを倒すと最寄りの味方Championはあなたが獲得した金額+10Goｌdを獲得し、{1}する。また、Healthが{2}以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                    .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02))
                    .variable(2, Value, 200, 0, ad(1))

                    .update(P403)
                    .passive("30秒毎に最大4つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、Healthが200以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                    .variable(1, RestoreHealth, 50, 0, amplify(HealthRatio, 0.01));
        })
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

                .price(285, 800);
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
