/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.api;

import teemowork.model.Describable;
import teemowork.model.Item;
import teemowork.model.ItemDefinition;
import teemowork.model.ItemDescriptor;

public abstract class RiotItemData extends Describable<ItemDescriptor> {

    /** Boots of Speed Definition */
    public static final Item BootsOfSpeed = new Item("Boots Of Speed", "ブーツ", 1001, 300, 300, 210, null, new int[] {3006, 3047, 3020, 3158, 3111, 3117, 3009}, 0, 0, 0, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.BootsOfSpeed);

    /** Faerie Charm Definition */
    public static final Item FaerieCharm = new Item("Faerie Charm", "フェアリーチャーム", 1004, 125, 125, 88, null, new int[] {3028, 3070, 3073, 3098, 3096, 3114}, 0, 48, 0, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.FaerieCharm);

    /** Rejuvenation Bead Definition */
    public static final Item RejuvenationBead = new Item("Rejuvenation Bead", "再生の珠", 1006, 150, 150, 105, null, new int[] {3077, 2053, 3097, 3801}, 0, 96, 0, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.RejuvenationBead);

    /** Giant's Belt Definition */
    public static final Item GiantsBelt = new Item("Giant's Belt", "ジャイアントベルト", 1011, 600, 1000, 700, new int[] {1028}, new int[] {3083, 3143, 3116, 3084, 3022, 3742}, 0, 144, 0, 2, 380, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.GiantsBelt);

    /** Cloak of Agility Definition */
    public static final Item CloakOfAgility = new Item("Cloak Of Agility", "アジリティクローク", 1018, 800, 800, 560, null, new int[] {3031, 3185, 3508}, 0, 192, 0, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 20, 0, ItemDefinition.CloakOfAgility);

    /** Blasting Wand Definition */
    public static final Item BlastingWand = new Item("Blasting Wand", "ブラスティングワンド", 1026, 850, 850, 595, null, new int[] {3089, 3135, 3124, 3029, 3027, 3100, 3151}, 0, 240, 0, 0, 0, 0.0F, 0, 0, 0, 40, 0, 0, 0, 0, 0, ItemDefinition.BlastingWand);

    /** Sapphire Crystal Definition */
    public static final Item SapphireCrystal = new Item("Sapphire Crystal", "サファイアクリスタル", 1027, 350, 350, 245, null, new int[] {3057, 3070, 3010, 3024, 3073, 3802}, 0, 288, 0, 0, 0, 0.0F, 250, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SapphireCrystal);

    /** Ruby Crystal Definition */
    public static final Item RubyCrystal = new Item("Ruby Crystal", "ルビークリスタル", 1028, 400, 400, 280, null, new int[] {1011, 3751, 2049, 2045, 3010, 3052, 3044, 3067, 3801, 3211, 3136, 3748}, 0, 336, 0, 0, 150, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.RubyCrystal);

    /** Cloth Armor Definition */
    public static final Item ClothArmor = new Item("Cloth Armor", "クロースアーマー", 1029, 300, 300, 210, null, new int[] {3047, 1031, 3191, 3024, 3082, 3075, 2053}, 0, 384, 0, 0, 0, 0.0F, 0, 0, 15, 0, 0, 0, 0, 0, 0, ItemDefinition.ClothArmor);

    /** Chain Vest Definition */
    public static final Item ChainVest = new Item("Chain Vest", "チェインベスト", 1031, 500, 800, 560, new int[] {1029}, new int[] {3075, 3068, 3026, 2053, 3742}, 0, 432, 0, 2, 0, 0.0F, 0, 0, 40, 0, 0, 0, 0, 0, 0, ItemDefinition.ChainVest);

    /** Null-Magic Mantle Definition */
    public static final Item NullMagicMantle = new Item("Null-Magic Mantle", "ヌルマジックマント", 1033, 450, 450, 315, null, new int[] {3111, 3211, 1057, 3028, 3140, 3155, 3105}, 0, 0, 48, 0, 0, 0.0F, 0, 0, 0, 0, 25, 0, 0, 0, 0, ItemDefinition.NullMagicMantle);

    /** Long Sword Definition */
    public static final Item LongSword = new Item("Long Sword", "ロングソード", 1036, 350, 350, 245, null, new int[] {1053, 3133, 3052, 3123, 3034, 3044, 3053, 3072, 3077, 3122, 3134, 3144, 3155}, 0, 48, 48, 0, 0, 0.0F, 0, 10, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.LongSword);

    /** Pickaxe Definition */
    public static final Item Pickaxe = new Item("Pickaxe", "ピッケル", 1037, 875, 875, 613, null, new int[] {3004, 3008, 3031, 3035, 3074, 3124, 3139, 3181, 3812}, 0, 96, 48, 0, 0, 0.0F, 0, 25, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Pickaxe);

    /** B. F. Sword Definition */
    public static final Item BFSword = new Item("B. F. Sword", "B. F. ソード", 1038, 1300, 1300, 910, null, new int[] {3031, 3072, 3147, 3508}, 0, 144, 48, 0, 0, 0.0F, 0, 40, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.BFSword);

    /** Hunter's Talisman Definition */
    public static final Item HuntersTalisman = new Item("Hunter's Talisman", "ハンタータリスマン", 1039, 350, 350, 245, null, new int[] {3706, 3711, 3715}, 0, 192, 48, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.HuntersTalisman);

    /** Hunter's Machete Definition */
    public static final Item HuntersMachete = new Item("Hunter's Machete", "ハンターマチェット", 1041, 350, 350, 245, null, new int[] {3706, 3711, 3715}, 0, 240, 48, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.HuntersMachete);

    /** Dagger Definition */
    public static final Item Dagger = new Item("Dagger", "ダガー", 1042, 300, 300, 210, null, new int[] {1043, 2015, 3006, 3046, 3086, 3101, 3091}, 0, 288, 48, 0, 0, 0.0F, 0, 0, 0, 0, 0, 12, 0, 0, 0, ItemDefinition.Dagger);

    /** Recurve Bow Definition */
    public static final Item RecurveBow = new Item("Recurve Bow", "リカーブボウ", 1043, 400, 1000, 700, new int[] {1042, 1042}, new int[] {3091, 3153, 3085, 3718, 3722, 1416, 1418, 1419, 3124, 3675}, 0, 336, 48, 2, 0, 0.0F, 0, 0, 0, 0, 0, 25, 0, 0, 0, ItemDefinition.RecurveBow);

    /** Brawler's Gloves Definition */
    public static final Item BrawlersGloves = new Item("Brawler's Gloves", "喧嘩屋のグローブ", 1051, 400, 400, 280, null, new int[] {3086, 3122}, 0, 384, 48, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 10, 0, ItemDefinition.BrawlersGloves);

    /** Amplifying Tome Definition */
    public static final Item AmplifyingTome = new Item("Amplifying Tome", "増魔の書", 1052, 435, 435, 305, null, new int[] {3108, 3191, 3136, 3135, 3145, 3113, 3090, 3116, 1402, 1410, 1414, 3001, 3050, 3089, 3165, 3802, 3673}, 0, 432, 48, 0, 0, 0.0F, 0, 0, 0, 20, 0, 0, 0, 0, 0, ItemDefinition.AmplifyingTome);

    /** Vampiric Scepter Definition */
    public static final Item VampiricScepter = new Item("Vampiric Scepter", "ヴァンパイアセプター", 1053, 550, 900, 630, new int[] {1036}, new int[] {3072, 3074, 3139, 3144, 3181, 3812}, 0, 0, 96, 2, 0, 0.0F, 0, 15, 0, 0, 0, 0, 0, 0, 10, ItemDefinition.VampiricScepter);

    /** Doran's Shield Definition */
    public static final Item DoransShield = new Item("Doran's Shield", "ドランシールド", 1054, 450, 450, 180, null, null, 0, 48, 96, 0, 80, 1.2F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.DoransShield);

    /** Doran's Blade Definition */
    public static final Item DoransBlade = new Item("Doran's Blade", "ドランブレード", 1055, 450, 450, 180, null, null, 0, 96, 96, 0, 80, 0.0F, 0, 8, 0, 0, 0, 0, 0, 0, 3, ItemDefinition.DoransBlade);

    /** Doran's Ring Definition */
    public static final Item DoransRing = new Item("Doran's Ring", "ドランリング", 1056, 400, 400, 160, null, null, 0, 144, 96, 0, 60, 0.0F, 0, 0, 0, 15, 0, 0, 0, 0, 0, ItemDefinition.DoransRing);

    /** Negatron Cloak Definition */
    public static final Item NegatronCloak = new Item("Negatron Cloak", "ネガトロンクローク", 1057, 270, 720, 504, new int[] {1033}, new int[] {3001, 3026, 3091, 3102, 3170, 3512}, 0, 192, 96, 2, 0, 0.0F, 0, 0, 0, 0, 40, 0, 0, 0, 0, ItemDefinition.NegatronCloak);

    /** Needlessly Large Rod Definition */
    public static final Item NeedlesslyLargeRod = new Item("Needlessly Large Rod", "ムダニデカイロッド", 1058, 1250, 1250, 875, null, new int[] {3089, 3003, 3007, 3090, 3116, 3285}, 0, 240, 96, 0, 0, 0.0F, 0, 0, 0, 60, 0, 0, 0, 0, 0, ItemDefinition.NeedlesslyLargeRod);

    /** The Dark Seal Definition */
    public static final Item DarkSeal = new Item(" Dark Seal", "ダークシール", 1082, 350, 350, 245, null, new int[] {3041}, 0, 288, 96, 0, 0, 0.0F, 100, 0, 0, 15, 0, 0, 0, 0, 0, ItemDefinition.DarkSeal);

    /** Cull Definition */
    public static final Item Cull = new Item("Cull", "カル", 1083, 450, 450, 180, null, null, 0, 336, 96, 0, 0, 0.0F, 0, 7, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Cull);

    /** Enchantment: Warrior Definition */
    public static final Item StalkersBladeWarrior = new Item("Stalker's Blade [Warrior]", "エンチャント: ウォリアー", 1400, 525, 2625, 1837, new int[] {3133, 3706}, null, 0, 384, 96, 3, 0, 0.0F, 0, 60, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.StalkersBladeWarrior);

    /** Enchantment: Cinderhulk Definition */
    public static final Item StalkersBladeCinderhulk = new Item("Stalker's Blade [Cinderhulk]", "エンチャント: シンダーハルク", 1401, 525, 2625, 1837, new int[] {3751, 3706}, null, 0, 432, 96, 3, 400, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.StalkersBladeCinderhulk);

    /** Enchantment: Runic Echoes Definition */
    public static final Item StalkersBladeRunicEchoes = new Item("Stalker's Blade [Runic Echoes]", "エンチャント: ルーンエコー", 1402, 340, 2625, 1837, new int[] {3113, 1052, 3706}, null, 0, 0, 144, 3, 0, 0.0F, 0, 0, 0, 60, 0, 0, 7, 0, 0, ItemDefinition.StalkersBladeRunicEchoes);

    /** Enchantment: Warrior Definition */
    public static final Item TrackersKnifeWarrior = new Item("Tracker's Knife [Warrior]", "エンチャント: ウォリアー", 1408, 525, 2625, 1837, new int[] {3133, 3711}, null, 0, 192, 144, 3, 0, 0.0F, 0, 60, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TrackersKnifeWarrior);

    /** Enchantment: Cinderhulk Definition */
    public static final Item TrackersKnifeCinderhulk = new Item("Tracker's Knife [Cinderhulk]", "エンチャント: シンダーハルク", 1409, 525, 2625, 1837, new int[] {3751, 3711}, null, 0, 240, 144, 3, 400, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TrackersKnifeCinderhulk);

    /** Enchantment: Runic Echoes Definition */
    public static final Item TrackersKnifeRunicEchoes = new Item("Tracker's Knife [Runic Echoes]", "エンチャント: ルーンエコー", 1410, 340, 2625, 1837, new int[] {3113, 1052, 3711}, null, 0, 288, 144, 3, 0, 0.0F, 0, 0, 0, 60, 0, 0, 7, 0, 0, ItemDefinition.TrackersKnifeRunicEchoes);

    /** Enchantment: Warrior Definition */
    public static final Item SkirmishersSabreWarrior = new Item("Skirmisher's Sabre [Warrior]", "エンチャント: ウォリアー", 1412, 525, 2625, 1837, new int[] {3133, 3715}, null, 0, 336, 144, 3, 0, 0.0F, 0, 60, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SkirmishersSabreWarrior);

    /** Enchantment: Cinderhulk Definition */
    public static final Item SkirmishersSabreCinderhulk = new Item("Skirmisher's Sabre [Cinderhulk]", "エンチャント: シンダーハルク", 1413, 525, 2625, 1837, new int[] {3751, 3715}, null, 0, 384, 144, 3, 400, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SkirmishersSabreCinderhulk);

    /** Enchantment: Runic Echoes Definition */
    public static final Item SkirmishersSabreRunicEchoes = new Item("Skirmisher's Sabre [Runic Echoes]", "エンチャント: ルーンエコー", 1414, 340, 2625, 1837, new int[] {3113, 1052, 3715}, null, 0, 432, 144, 3, 0, 0.0F, 0, 0, 0, 60, 0, 0, 7, 0, 0, ItemDefinition.SkirmishersSabreRunicEchoes);

    /** Enchantment: Bloodrazor Definition */
    public static final Item StalkersBladeBloodrazor = new Item("Stalker's Blade [Bloodrazor]", "エンチャント: ブラッドレイザー", 1416, 625, 2625, 1837, new int[] {1043, 3706}, null, 0, 0, 192, 3, 0, 0.0F, 0, 0, 0, 0, 0, 50, 0, 0, 0, ItemDefinition.StalkersBladeBloodrazor);

    /** Enchantment: Bloodrazor Definition */
    public static final Item TrackersKnifeBloodrazor = new Item("Tracker's Knife [Bloodrazor]", "エンチャント: ブラッドレイザー", 1418, 625, 2625, 1837, new int[] {1043, 3711}, null, 0, 96, 192, 3, 0, 0.0F, 0, 0, 0, 0, 0, 50, 0, 0, 0, ItemDefinition.TrackersKnifeBloodrazor);

    /** Enchantment: Bloodrazor Definition */
    public static final Item SkirmishersSabreBloodrazor = new Item("Skirmisher's Sabre [Bloodrazor]", "エンチャント: ブラッドレイザー", 1419, 625, 2625, 1837, new int[] {1043, 3715}, null, 0, 144, 192, 3, 0, 0.0F, 0, 0, 0, 0, 0, 50, 0, 0, 0, ItemDefinition.SkirmishersSabreBloodrazor);

    /** Health Potion Definition */
    public static final Item HealthPotion = new Item("Health Potion", "体力ポーション", 2003, 50, 50, 20, null, null, 0, 192, 192, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.HealthPotion);

    /** Total Biscuit of Rejuvenation Definition */
    public static final Item TotalBiscuitOfRejuvenation = new Item("Total Biscuit Of Rejuvenation", "栄養満点ビスケット", 2010, 50, 50, 20, null, null, 0, 288, 192, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TotalBiscuitOfRejuvenation);

    /** Kircheis Shard Definition */
    public static final Item KircheisShard = new Item("Kircheis Shard", "キルヒアイスシャード", 2015, 450, 750, 525, new int[] {1042}, new int[] {3087, 3094}, 0, 336, 192, 2, 0, 0.0F, 0, 0, 0, 0, 0, 15, 0, 0, 0, ItemDefinition.KircheisShard);

    /** Refillable Potion Definition */
    public static final Item RefillablePotion = new Item("Refillable Potion", "詰め替えポーション", 2031, 150, 150, 60, null, new int[] {2032, 2033}, 0, 384, 192, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.RefillablePotion);

    /** Hunter's Potion Definition */
    public static final Item HuntersPotion = new Item("Hunter's Potion", "ハンターポーション", 2032, 250, 400, 160, new int[] {2031}, null, 0, 432, 192, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.HuntersPotion);

    /** Corrupting Potion Definition */
    public static final Item CorruptingPotion = new Item("Corrupting Potion", "コラプトポーション", 2033, 350, 500, 200, new int[] {2031}, null, 0, 0, 240, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.CorruptingPotion);

    /** Vision Ward Definition */
    public static final Item VisionWard = new Item("Vision Ward", "ビジョンワード", 2043, 75, 75, 30, null, null, 0, 48, 240, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.VisionWard);

    /** Ruby Sightstone Definition */
    public static final Item RubySightstone = new Item("Ruby Sightstone", "ルビーサイトストーン", 2045, 400, 1600, 640, new int[] {2049, 1028}, null, 0, 96, 240, 3, 500, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.RubySightstone);

    /** Sightstone Definition */
    public static final Item Sightstone = new Item("Sightstone", "サイトストーン", 2049, 400, 800, 320, new int[] {1028}, new int[] {2045, 2301, 2302, 2303}, 0, 192, 240, 2, 150, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Sightstone);

    /** Raptor Cloak Definition */
    public static final Item RaptorCloak = new Item("Raptor Cloak", "ラプタークローク", 2053, 250, 1200, 840, new int[] {1006, 1031}, new int[] {3056, 3069, 3512}, 0, 384, 240, 3, 0, 0.0F, 0, 0, 40, 0, 0, 0, 0, 0, 0, ItemDefinition.RaptorCloak);

    /** Elixir of Iron Definition */
    public static final Item ElixirOfIron = new Item("Elixir Of Iron", "アイアンエリクサー", 2138, 500, 500, 200, null, null, 0, 0, 288, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.ElixirOfIron);

    /** Elixir of Sorcery Definition */
    public static final Item ElixirOfSorcery = new Item("Elixir Of Sorcery", "ソーサリーエリクサー", 2139, 500, 500, 200, null, null, 0, 48, 288, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.ElixirOfSorcery);

    /** Elixir of Wrath Definition */
    public static final Item ElixirOfWrath = new Item("Elixir Of Wrath", "ラースエリクサー", 2140, 500, 500, 200, null, null, 0, 96, 288, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.ElixirOfWrath);

    /** Eye of the Watchers Definition */
    public static final Item EyeOftheWatchers = new Item("Eye Of the Watchers", "ウォッチャーの瞳", 2301, 550, 2200, 880, new int[] {2049, 3098}, null, 0, 144, 288, 3, 200, 0.0F, 0, 0, 0, 25, 0, 0, 0, 0, 0, ItemDefinition.EyeOftheWatchers);

    /** Eye of the Oasis Definition */
    public static final Item EyeOftheOasis = new Item("Eye Of the Oasis", "オアシスの瞳", 2302, 550, 2200, 880, new int[] {2049, 3096}, null, 0, 192, 288, 3, 200, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.EyeOftheOasis);

    /** Eye of the Equinox Definition */
    public static final Item EyeOftheEquinox = new Item("Eye Of the Equinox", "イクイノックスの瞳", 2303, 550, 2200, 880, new int[] {2049, 3097}, null, 0, 240, 288, 3, 500, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.EyeOftheEquinox);

    /** Abyssal Scepter Definition */
    public static final Item AbyssalScepter = new Item("Abyssal Scepter", "アビサルセプター", 3001, 695, 2750, 1925, new int[] {3108, 1057, 1052}, null, 0, 288, 288, 3, 0, 0.0F, 0, 0, 0, 60, 60, 0, 0, 0, 0, ItemDefinition.AbyssalScepter);

    /** Archangel's Staff Definition */
    public static final Item ArchangelsStaff = new Item("Archangel's Staff", "アークエンジェルスタッフ", 3003, 1100, 3100, 2170, new int[] {3070, 1058}, new int[] {3040}, 0, 336, 288, 3, 0, 0.0F, 250, 0, 0, 80, 0, 0, 0, 0, 0, ItemDefinition.ArchangelsStaff);

    /** Manamune Definition */
    public static final Item Manamune = new Item("Manamune", "マナムネ", 3004, 775, 2400, 1680, new int[] {3070, 1037}, new int[] {3042}, 0, 384, 288, 3, 0, 0.0F, 250, 25, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Manamune);

    /** Berserker's Greaves Definition */
    public static final Item BerserkersGreaves = new Item("Berserker's Greaves", "バーサーカーブーツ", 3006, 500, 1100, 770, new int[] {1001, 1042}, new int[] {1303, 1302}, 0, 432, 288, 2, 0, 0.0F, 0, 0, 0, 0, 0, 35, 0, 0, 0, ItemDefinition.BerserkersGreaves);

    /** Boots of Swiftness Definition */
    public static final Item BootsOfSwiftness = new Item("Boots Of Swiftness", "スイフトネスブーツ", 3009, 600, 900, 630, new int[] {1001}, new int[] {1308, 1307}, 0, 96, 336, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.BootsOfSwiftness);

    /** Catalyst of Aeons Definition */
    public static final Item CatalystOfAeons = new Item("Catalyst Of Aeons", "久遠のカタリスト", 3010, 350, 1100, 770, new int[] {1028, 1027}, new int[] {3027, 3029, 3030, 3800}, 0, 144, 336, 2, 225, 0.0F, 300, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.CatalystOfAeons);

    /** Sorcerer's Shoes Definition */
    public static final Item SorcerersShoes = new Item("Sorcerer's Shoes", "ソーサラーシューズ", 3020, 800, 1100, 770, new int[] {1001}, new int[] {1313, 1312}, 0, 192, 336, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SorcerersShoes);

    /** Frozen Mallet Definition */
    public static final Item FrozenMallet = new Item("Frozen Mallet", "フローズンマレット", 3022, 900, 3100, 2170, new int[] {3052, 1011}, null, 0, 240, 336, 3, 700, 0.0F, 0, 30, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.FrozenMallet);

    /** Glacial Shroud Definition */
    public static final Item GlacialShroud = new Item("Glacial Shroud", "グレイシャルシュラウド", 3024, 350, 1000, 700, new int[] {1027, 1029}, new int[] {3110, 3025, 3050, 3187}, 0, 288, 336, 2, 0, 0.0F, 250, 0, 25, 0, 0, 0, 0, 0, 0, ItemDefinition.GlacialShroud);

    /** Iceborn Gauntlet Definition */
    public static final Item IcebornGauntlet = new Item("Iceborn Gauntlet", "アイスボーンガントレット", 3025, 650, 2700, 1890, new int[] {3057, 3024}, null, 0, 336, 336, 3, 0, 0.0F, 500, 0, 65, 0, 0, 0, 0, 0, 0, ItemDefinition.IcebornGauntlet);

    /** Guardian Angel Definition */
    public static final Item GuardianAngel = new Item("Guardian Angel", "ガーディアンエンジェル", 3026, 880, 2400, 960, new int[] {1057, 1031}, null, 0, 384, 336, 3, 0, 0.0F, 0, 0, 60, 0, 45, 0, 0, 0, 0, ItemDefinition.GuardianAngel);

    /** Rod of Ages Definition */
    public static final Item RodOfAges = new Item("Rod Of Ages", "ロッド・オブ・エイジス", 3027, 750, 2700, 1890, new int[] {3010, 1026}, null, 0, 432, 336, 3, 300, 0.0F, 300, 0, 0, 60, 0, 0, 0, 0, 0, ItemDefinition.RodOfAges);

    /** Chalice of Harmony Definition */
    public static final Item ChaliceOfHarmony = new Item("Chalice Of Harmony", "調和の聖杯", 3028, 200, 900, 630, new int[] {1004, 1033, 1004}, new int[] {3174, 3222}, 0, 0, 384, 2, 0, 0.0F, 0, 0, 0, 0, 25, 0, 0, 0, 0, ItemDefinition.ChaliceOfHarmony);

    /** Hextech GLP-800 Definition */
    public static final Item HextechGLP800 = new Item("Hextech GLP-800", "ヘクステック・GLP-800", 3030, 850, 3000, 2100, new int[] {3010, 3145}, null, 0, 96, 384, 3, 300, 0.0F, 400, 0, 0, 80, 0, 0, 0, 0, 0, ItemDefinition.HextechGLP800);

    /** Infinity Edge Definition */
    public static final Item InfinityEdge = new Item("Infinity Edge", "インフィニティ・エッジ", 3031, 625, 3600, 2520, new int[] {1038, 1037, 1018}, null, 0, 144, 384, 2, 0, 0.0F, 0, 70, 0, 0, 0, 0, 0, 20, 0, ItemDefinition.InfinityEdge);

    /** Mortal Reminder Definition */
    public static final Item MortalReminder = new Item("Mortal Reminder", "モータルリマインダー", 3033, 600, 2700, 1890, new int[] {3035, 3123}, null, 0, 192, 384, 3, 0, 0.0F, 0, 50, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.MortalReminder);

    /** Giant Slayer Definition */
    public static final Item GiantSlayer = new Item("Giant Slayer", "ジャイアントスレイヤー", 3034, 650, 1000, 700, new int[] {1036}, new int[] {3036}, 0, 240, 384, 2, 0, 0.0F, 0, 10, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.GiantSlayer);

    /** Last Whisper Definition */
    public static final Item LastWhisper = new Item("Last Whisper", "ラストウィスパー", 3035, 425, 1300, 910, new int[] {1037}, new int[] {3033, 3036}, 0, 288, 384, 2, 0, 0.0F, 0, 25, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.LastWhisper);

    /** Lord Dominik's Regards Definition */
    public static final Item LordDominiksRegards = new Item("Lord Dominik's Regards", "ドミニクリガード", 3036, 400, 2700, 1890, new int[] {3035, 3034}, null, 0, 336, 384, 3, 0, 0.0F, 0, 50, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.LordDominiksRegards);

    /** Seraph's Embrace Definition */
    public static final Item SeraphsEmbrace = new Item("Seraph's Embrace", "セラフ・エンブレイス", 3040, 3100, 3100, 4340, new int[] {3003}, null, 0, 384, 384, 4, 0, 0.0F, 1000, 0, 0, 80, 0, 0, 0, 0, 0, ItemDefinition.SeraphsEmbrace);

    /** Mejai's Soulstealer Definition */
    public static final Item MejaisSoulstealer = new Item("Mejai's Soulstealer", "メジャイ・ソウルスティーラー", 3041, 1050, 1400, 980, new int[] {1082}, null, 0, 432, 384, 2, 0, 0.0F, 200, 0, 0, 20, 0, 0, 0, 0, 0, ItemDefinition.MejaisSoulstealer);

    /** Muramana Definition */
    public static final Item Muramana = new Item("Muramana", "ムラマナ", 3042, 2400, 2400, 3360, new int[] {3004}, null, 0, 0, 432, 4, 0, 0.0F, 1000, 25, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Muramana);

    /** Phage Definition */
    public static final Item Phage = new Item("Phage", "ファージ", 3044, 500, 1250, 875, new int[] {1028, 1036}, new int[] {3078, 3071}, 0, 96, 432, 2, 200, 0.0F, 0, 15, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Phage);

    /** Phantom Dancer Definition */
    public static final Item PhantomDancer = new Item("Phantom Dancer", "ファントムダンサー", 3046, 650, 2550, 1785, new int[] {1042, 3086, 1042}, null, 0, 144, 432, 3, 0, 0.0F, 0, 0, 0, 0, 0, 45, 5, 30, 0, ItemDefinition.PhantomDancer);

    /** Ninja Tabi Definition */
    public static final Item NinjaTabi = new Item("Ninja Tabi", "忍者足袋", 3047, 500, 1100, 770, new int[] {1001, 1029}, new int[] {1318, 1317}, 0, 192, 432, 2, 0, 0.0F, 0, 0, 30, 0, 0, 0, 0, 0, 0, ItemDefinition.NinjaTabi);

    /** Zeke's Harbinger Definition */
    public static final Item ZekesHarbinger = new Item("Zeke's Harbinger", "ジークハービンジャー", 3050, 480, 2350, 1645, new int[] {1052, 3024, 1052}, null, 0, 288, 432, 3, 0, 0.0F, 250, 0, 30, 50, 0, 0, 0, 0, 0, ItemDefinition.ZekesHarbinger);

    /** Jaurim's Fist Definition */
    public static final Item JaurimsFist = new Item("Jaurim's Fist", "ジャウリムフィスト", 3052, 450, 1200, 840, new int[] {1036, 1028}, new int[] {3022, 3053, 3104, 3748}, 0, 336, 432, 2, 150, 0.0F, 0, 15, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.JaurimsFist);

    /** Sterak's Gage Definition */
    public static final Item SteraksGage = new Item("Sterak's Gage", "ステラックの篭手", 3053, 1150, 2700, 1890, new int[] {3052, 1036}, null, 0, 384, 432, 3, 400, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SteraksGage);

    /** Ohmwrecker Definition */
    public static final Item Ohmwrecker = new Item("Ohmwrecker", "オームレッカー", 3056, 650, 2650, 1855, new int[] {2053, 3067}, null, 0, 432, 432, 4, 300, 0.0F, 0, 0, 50, 0, 0, 0, 0, 0, 0, ItemDefinition.Ohmwrecker);

    /** Sheen Definition */
    public static final Item Sheen = new Item("Sheen", "シーン", 3057, 700, 1050, 735, new int[] {1027}, new int[] {3078, 3100, 3025}, 1, 0, 0, 2, 0, 0.0F, 250, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Sheen);

    /** Banner of Command Definition */
    public static final Item BannerOfCommand = new Item("Banner Of Command", "統率の旗", 3060, 600, 3000, 2100, new int[] {3105, 3108}, null, 1, 48, 0, 4, 200, 0.0F, 0, 0, 0, 60, 20, 0, 0, 0, 0, ItemDefinition.BannerOfCommand);

    /** Spirit Visage Definition */
    public static final Item SpiritVisage = new Item("Spirit Visage", "スピリットビサージュ", 3065, 800, 2800, 1960, new int[] {3211, 3067}, null, 1, 96, 0, 3, 500, 0.0F, 0, 0, 0, 0, 55, 0, 0, 0, 0, ItemDefinition.SpiritVisage);

    /** Kindlegem Definition */
    public static final Item Kindlegem = new Item("Kindlegem", "キンドルジェム", 3067, 400, 800, 560, new int[] {1028}, new int[] {3187, 3190, 3401, 3065, 3056, 3083, 3152}, 1, 144, 0, 2, 200, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Kindlegem);

    /** Sunfire Cape Definition */
    public static final Item SunfireCape = new Item("Sunfire Cape", "サンファイア・ケープ", 3068, 1000, 2900, 2030, new int[] {1031, 3751}, null, 1, 192, 0, 3, 500, 0.0F, 0, 0, 50, 0, 0, 0, 0, 0, 0, ItemDefinition.SunfireCape);

    /** Talisman of Ascension Definition */
    public static final Item TalismanOfAscension = new Item("Talisman Of Ascension", "超越のタリスマン", 3069, 450, 2500, 1000, new int[] {3096, 2053}, null, 1, 240, 0, 4, 0, 0.0F, 0, 0, 45, 0, 0, 0, 0, 0, 0, ItemDefinition.TalismanOfAscension);

    /** Tear of the Goddess Definition */
    public static final Item TearOftheGoddess = new Item("Tear Of the Goddess", "女神の涙", 3070, 275, 750, 525, new int[] {1027, 1004}, new int[] {3003, 3004}, 1, 288, 0, 2, 0, 0.0F, 250, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TearOftheGoddess);

    /** The Black Cleaver Definition */
    public static final Item BlackCleaver = new Item(" Black Cleaver", "ブラック・クリーバー", 3071, 750, 3100, 2170, new int[] {3044, 3133}, null, 1, 336, 0, 3, 300, 0.0F, 0, 50, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.BlackCleaver);

    /** The Bloodthirster Definition */
    public static final Item Bloodthirster = new Item(" Bloodthirster", "ブラッドサースター", 3072, 1150, 3700, 2590, new int[] {1038, 1036, 1053}, null, 1, 384, 0, 3, 0, 0.0F, 0, 75, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Bloodthirster);

    /** Ravenous Hydra Definition */
    public static final Item RavenousHydra = new Item("Ravenous Hydra", "ラヴァナス・ハイドラ", 3074, 525, 3500, 2450, new int[] {3077, 1053, 1037}, null, 1, 0, 48, 3, 0, 0.0F, 0, 75, 0, 0, 0, 0, 0, 0, 12, ItemDefinition.RavenousHydra);

    /** Thornmail Definition */
    public static final Item Thornmail = new Item("Thornmail", "ソーンメイル", 3075, 1250, 2350, 1645, new int[] {1029, 1031}, null, 1, 48, 48, 3, 0, 0.0F, 0, 0, 100, 0, 0, 0, 0, 0, 0, ItemDefinition.Thornmail);

    /** Tiamat Definition */
    public static final Item Tiamat = new Item("Tiamat", "ティアマット", 3077, 350, 1200, 840, new int[] {1036, 1006, 1036}, new int[] {3074, 3748}, 1, 96, 48, 2, 0, 0.0F, 0, 20, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.Tiamat);

    /** Trinity Force Definition */
    public static final Item TrinityForce = new Item("Trinity Force", "トリニティ・フォース", 3078, 333, 3733, 2613, new int[] {3101, 3057, 3044}, null, 1, 144, 48, 3, 250, 0.0F, 250, 25, 0, 0, 0, 40, 5, 0, 0, ItemDefinition.TrinityForce);

    /** Warden's Mail Definition */
    public static final Item WardensMail = new Item("Warden's Mail", "ワーデンメイル", 3082, 400, 1000, 700, new int[] {1029, 1029}, new int[] {3110, 3143}, 1, 192, 48, 2, 0, 0.0F, 0, 0, 40, 0, 0, 0, 0, 0, 0, ItemDefinition.WardensMail);

    /** Warmog's Armor Definition */
    public static final Item WarmogsArmor = new Item("Warmog's Armor", "ワーモグアーマー", 3083, 400, 2850, 1995, new int[] {1011, 3067, 3801}, null, 1, 240, 48, 3, 800, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.WarmogsArmor);

    /** Runaan's Hurricane Definition */
    public static final Item RunaansHurricane = new Item("Runaan's Hurricane", "ルナーン・ハリケーン", 3085, 300, 2600, 1820, new int[] {1043, 3086}, null, 1, 336, 48, 3, 0, 0.0F, 0, 0, 0, 0, 0, 40, 7, 30, 0, ItemDefinition.RunaansHurricane);

    /** Zeal Definition */
    public static final Item Zeal = new Item("Zeal", "ジール", 3086, 600, 1300, 910, new int[] {1051, 1042}, new int[] {3046, 3085, 3087, 3094}, 1, 384, 48, 2, 0, 0.0F, 0, 0, 0, 0, 0, 15, 0, 20, 0, ItemDefinition.Zeal);

    /** Statikk Shiv Definition */
    public static final Item StatikkShiv = new Item("Statikk Shiv", "スタティック・シヴ", 3087, 550, 2600, 1820, new int[] {3086, 2015}, null, 1, 432, 48, 3, 0, 0.0F, 0, 0, 0, 0, 0, 35, 5, 30, 0, ItemDefinition.StatikkShiv);

    /** Rabadon's Deathcap Definition */
    public static final Item RabadonsDeathcap = new Item("Rabadon's Deathcap", "ラバドン・デスキャップ", 3089, 1265, 3800, 2660, new int[] {1026, 1058, 1052}, null, 1, 0, 96, 2, 0, 0.0F, 0, 0, 0, 120, 0, 0, 0, 0, 0, ItemDefinition.RabadonsDeathcap);

    /** Wit's End Definition */
    public static final Item WitsEnd = new Item("Wit's End", "ウィッツエンド", 3091, 480, 2500, 1750, new int[] {1043, 1057, 1042}, null, 1, 96, 96, 3, 0, 0.0F, 0, 0, 0, 0, 40, 40, 0, 0, 0, ItemDefinition.WitsEnd);

    /** Frost Queen's Claim Definition */
    public static final Item FrostQueensClaim = new Item("Frost Queen's Claim", "フロストクイーンクレイム", 3092, 450, 2200, 880, new int[] {3098, 3108}, null, 1, 144, 96, 3, 0, 0.0F, 0, 0, 0, 50, 0, 0, 0, 0, 0, ItemDefinition.FrostQueensClaim);

    /** Rapid Firecannon Definition */
    public static final Item RapidFirecannon = new Item("Rapid Firecannon", "ラピッドファイアキャノン", 3094, 550, 2600, 1820, new int[] {3086, 2015}, null, 1, 192, 96, 3, 0, 0.0F, 0, 0, 0, 0, 0, 30, 5, 30, 0, ItemDefinition.RapidFirecannon);

    /** Nomad's Medallion Definition */
    public static final Item NomadsMedallion = new Item("Nomad's Medallion", "ノマドのメダル", 3096, 375, 850, 340, new int[] {1004, 3301}, new int[] {2302, 3069}, 1, 240, 96, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.NomadsMedallion);

    /** Targon's Brace Definition */
    public static final Item TargonsBrace = new Item("Targon's Brace", "ターゴンの腕輪", 3097, 350, 850, 340, new int[] {3302, 1006}, new int[] {2303, 3401}, 1, 288, 96, 2, 175, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TargonsBrace);

    /** Frostfang Definition */
    public static final Item Frostfang = new Item("Frostfang", "フロストファング", 3098, 375, 850, 340, new int[] {3303, 1004}, new int[] {2301, 3092}, 1, 336, 96, 2, 0, 0.0F, 0, 0, 0, 15, 0, 0, 0, 0, 0, ItemDefinition.Frostfang);

    /** Lich Bane Definition */
    public static final Item LichBane = new Item("Lich Bane", "リッチベイン", 3100, 450, 3200, 2240, new int[] {3057, 3113, 1026}, null, 1, 384, 96, 3, 0, 0.0F, 250, 0, 0, 80, 0, 0, 7, 0, 0, ItemDefinition.LichBane);

    /** Stinger Definition */
    public static final Item Stinger = new Item("Stinger", "スティンガー", 3101, 500, 1100, 770, new int[] {1042, 1042}, new int[] {3115, 3137, 3078}, 1, 432, 96, 2, 0, 0.0F, 0, 0, 0, 0, 0, 35, 0, 0, 0, ItemDefinition.Stinger);

    /** Banshee's Veil Definition */
    public static final Item BansheesVeil = new Item("Banshee's Veil", "バンシーヴェール", 3102, 530, 2450, 1715, new int[] {3211, 1057}, null, 1, 0, 144, 3, 300, 0.0F, 0, 0, 0, 0, 70, 0, 0, 0, 0, ItemDefinition.BansheesVeil);

    /** Aegis of the Legion Definition */
    public static final Item AegisOftheLegion = new Item("Aegis Of the Legion", "イージスの盾", 3105, 400, 1500, 1050, new int[] {1033, 3801}, new int[] {3190, 3060}, 1, 96, 144, 3, 200, 0.0F, 0, 0, 0, 0, 20, 0, 0, 0, 0, ItemDefinition.AegisOftheLegion);

    /** Fiendish Codex Definition */
    public static final Item FiendishCodex = new Item("Fiendish Codex", "フィンディッシュの古書", 3108, 465, 900, 630, new int[] {1052}, new int[] {3174, 3092, 3115, 3165, 3060, 3001, 3157}, 1, 144, 144, 2, 0, 0.0F, 0, 0, 0, 30, 0, 0, 0, 0, 0, ItemDefinition.FiendishCodex);

    /** Frozen Heart Definition */
    public static final Item FrozenHeart = new Item("Frozen Heart", "フローズンハート", 3110, 800, 2800, 1960, new int[] {3082, 3024}, null, 1, 192, 144, 3, 0, 0.0F, 400, 0, 90, 0, 0, 0, 0, 0, 0, ItemDefinition.FrozenHeart);

    /** Mercury's Treads Definition */
    public static final Item MercurysTreads = new Item("Mercury's Treads", "マーキュリーブーツ", 3111, 350, 1100, 770, new int[] {1001, 1033}, new int[] {1323, 1322}, 1, 240, 144, 2, 0, 0.0F, 0, 0, 0, 0, 25, 0, 0, 0, 0, ItemDefinition.MercurysTreads);

    /** Aether Wisp Definition */
    public static final Item AetherWisp = new Item("Aether Wisp", "エーテルウィスプ", 3113, 415, 850, 595, new int[] {1052}, new int[] {3290, 1402, 1410, 1414, 3100, 3285, 3504, 3673}, 1, 336, 144, 2, 0, 0.0F, 0, 0, 0, 30, 0, 0, 0, 0, 0, ItemDefinition.AetherWisp);

    /** Forbidden Idol Definition */
    public static final Item ForbiddenIdol = new Item("Forbidden Idol", "フォビドゥンアイドル", 3114, 600, 850, 595, new int[] {1004, 1004}, new int[] {3222, 3504}, 1, 384, 144, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.ForbiddenIdol);

    /** Nashor's Tooth Definition */
    public static final Item NashorsTooth = new Item("Nashor's Tooth", "ナッシャー・トゥース", 3115, 1000, 3000, 2100, new int[] {3101, 3108}, null, 1, 432, 144, 3, 0, 0.0F, 0, 0, 0, 80, 0, 50, 0, 0, 0, ItemDefinition.NashorsTooth);

    /** Rylai's Crystal Scepter Definition */
    public static final Item RylaisCrystalScepter = new Item("Rylai's Crystal Scepter", "リーライ・クリスタルセプター", 3116, 515, 3200, 2240, new int[] {1058, 1052, 1011}, null, 1, 0, 192, 3, 400, 0.0F, 0, 0, 0, 100, 0, 0, 0, 0, 0, ItemDefinition.RylaisCrystalScepter);

    /** Boots of Mobility Definition */
    public static final Item BootsOfMobility = new Item("Boots Of Mobility", "モビリティブーツ", 3117, 600, 900, 630, new int[] {1001}, new int[] {1328, 1327}, 1, 48, 192, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.BootsOfMobility);

    /** Executioner's Calling Definition */
    public static final Item ExecutionersCalling = new Item("Executioner's Calling", "エクスキューショナー・コーリング", 3123, 450, 800, 560, new int[] {1036}, new int[] {3033}, 1, 144, 192, 2, 0, 0.0F, 0, 15, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.ExecutionersCalling);

    /** Guinsoo's Rageblade Definition */
    public static final Item GuinsoosRageblade = new Item("Guinsoo's Rageblade", "グインソー・レイジブレード", 3124, 875, 3600, 2520, new int[] {1026, 1043, 1037}, null, 1, 192, 192, 3, 0, 0.0F, 0, 35, 0, 50, 0, 0, 0, 0, 0, ItemDefinition.GuinsoosRageblade);

    /** Caulfield's Warhammer Definition */
    public static final Item CaulfieldsWarhammer = new Item("Caulfield's Warhammer", "コールフィールド・ウォーハンマー", 3133, 400, 1100, 770, new int[] {1036, 1036}, new int[] {3142, 1400, 1408, 1412, 3071, 3104, 3508, 3671, 3812}, 1, 240, 192, 2, 0, 0.0F, 0, 25, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.CaulfieldsWarhammer);

    /** Serrated Dirk Definition */
    public static final Item SerratedDirk = new Item("Serrated Dirk", "セレイテッドダーク", 3134, 400, 1100, 770, new int[] {1036, 1036}, new int[] {3142, 3147, 3156}, 1, 288, 192, 2, 0, 0.0F, 0, 20, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SerratedDirk);

    /** Void Staff Definition */
    public static final Item VoidStaff = new Item("Void Staff", "ヴォイドスタッフ", 3135, 1365, 2650, 1855, new int[] {1026, 1052}, null, 1, 336, 192, 2, 0, 0.0F, 0, 0, 0, 80, 0, 0, 0, 0, 0, ItemDefinition.VoidStaff);

    /** Haunting Guise Definition */
    public static final Item HauntingGuise = new Item("Haunting Guise", "悲愴な仮面", 3136, 765, 1600, 1120, new int[] {1028, 1052}, new int[] {3151}, 1, 384, 192, 2, 200, 0.0F, 0, 0, 0, 25, 0, 0, 0, 0, 0, ItemDefinition.HauntingGuise);

    /** Mercurial Scimitar Definition */
    public static final Item MercurialScimitar = new Item("Mercurial Scimitar", "マーキュリアル・シミター", 3139, 525, 3600, 2520, new int[] {3140, 1037, 1053}, null, 1, 0, 240, 3, 0, 0.0F, 0, 65, 0, 0, 35, 0, 0, 0, 10, ItemDefinition.MercurialScimitar);

    /** Quicksilver Sash Definition */
    public static final Item QuicksilverSash = new Item("Quicksilver Sash", "シルバーサッシュ", 3140, 850, 1300, 910, new int[] {1033}, new int[] {3139, 3137}, 1, 48, 240, 2, 0, 0.0F, 0, 0, 0, 0, 30, 0, 0, 0, 0, ItemDefinition.QuicksilverSash);

    /** Youmuu's Ghostblade Definition */
    public static final Item YoumuusGhostblade = new Item("Youmuu's Ghostblade", "妖夢の霊剣", 3142, 1000, 3200, 2240, new int[] {3133, 3134}, null, 1, 96, 240, 3, 0, 0.0F, 0, 60, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.YoumuusGhostblade);

    /** Randuin's Omen Definition */
    public static final Item RanduinsOmen = new Item("Randuin's Omen", "ランデュイン・オーメン", 3143, 900, 2900, 2030, new int[] {3082, 1011}, null, 1, 144, 240, 3, 500, 0.0F, 0, 0, 60, 0, 0, 0, 0, 0, 0, ItemDefinition.RanduinsOmen);

    /** Bilgewater Cutlass Definition */
    public static final Item BilgewaterCutlass = new Item("Bilgewater Cutlass", "ビルジウォーター・カトラス", 3144, 250, 1500, 1050, new int[] {1053, 1036}, new int[] {3146, 3153}, 1, 192, 240, 3, 0, 0.0F, 0, 25, 0, 0, 0, 0, 0, 0, 10, ItemDefinition.BilgewaterCutlass);

    /** Hextech Revolver Definition */
    public static final Item HextechRevolver = new Item("Hextech Revolver", "ヘクステック・リボルバー", 3145, 180, 1050, 735, new int[] {1052, 1052}, new int[] {3146, 3152, 3030}, 1, 240, 240, 2, 0, 0.0F, 0, 0, 0, 40, 0, 0, 0, 0, 0, ItemDefinition.HextechRevolver);

    /** Hextech Gunblade Definition */
    public static final Item HextechGunblade = new Item("Hextech Gunblade", "ヘクステック・ガンブレード", 3146, 850, 3400, 2380, new int[] {3144, 3145}, null, 1, 288, 240, 4, 0, 0.0F, 0, 40, 0, 80, 0, 0, 0, 0, 0, ItemDefinition.HextechGunblade);

    /** Duskblade of Draktharr Definition */
    public static final Item DuskbladeOfDraktharr = new Item("Duskblade Of Draktharr", "ドラクサー・ダスクブレード", 3147, 850, 3250, 2275, new int[] {3134, 1038}, null, 1, 336, 240, 3, 0, 0.0F, 0, 75, 0, 0, 0, 0, 5, 0, 0, ItemDefinition.DuskbladeOfDraktharr);

    /** Liandry's Torment Definition */
    public static final Item LiandrysTorment = new Item("Liandry's Torment", "ライアンドリーの仮面", 3151, 750, 3200, 2240, new int[] {3136, 1026}, null, 1, 384, 240, 3, 300, 0.0F, 0, 0, 0, 80, 0, 0, 0, 0, 0, ItemDefinition.LiandrysTorment);

    /** Hextech Protobelt-01 Definition */
    public static final Item HextechProtobelt01 = new Item("Hextech Protobelt-01", "ヘクステック・プロトベルト01", 3152, 650, 2500, 1750, new int[] {3145, 3067}, null, 1, 432, 240, 3, 300, 0.0F, 0, 0, 0, 60, 0, 0, 0, 0, 0, ItemDefinition.HextechProtobelt01);

    /** Blade of the Ruined King Definition */
    public static final Item BladeOftheRuinedKing = new Item("Blade Of the Ruined King", "ルインドキング･ブレード", 3153, 900, 3400, 2380, new int[] {3144, 1043}, null, 1, 0, 288, 4, 0, 0.0F, 0, 25, 0, 0, 0, 40, 0, 0, 10, ItemDefinition.BladeOftheRuinedKing);

    /** Hexdrinker Definition */
    public static final Item Hexdrinker = new Item("Hexdrinker", "ヘクスドリンカー", 3155, 500, 1300, 910, new int[] {1036, 1033}, new int[] {3156}, 1, 96, 288, 2, 0, 0.0F, 0, 20, 0, 0, 35, 0, 0, 0, 0, ItemDefinition.Hexdrinker);

    /** Maw of Malmortius Definition */
    public static final Item MawOfMalmortius = new Item("Maw Of Malmortius", "マルモティウスの胃袋", 3156, 850, 3250, 2275, new int[] {3155, 3134}, null, 1, 144, 288, 3, 0, 0.0F, 0, 55, 0, 0, 40, 0, 0, 0, 0, ItemDefinition.MawOfMalmortius);

    /** Zhonya's Hourglass Definition */
    public static final Item ZhonyasHourglass = new Item("Zhonya's Hourglass", "ゾーニャの砂時計", 3157, 800, 2900, 2030, new int[] {3191, 3108}, null, 1, 192, 288, 3, 0, 0.0F, 0, 0, 45, 70, 0, 0, 0, 0, 0, ItemDefinition.ZhonyasHourglass);

    /** Ionian Boots of Lucidity Definition */
    public static final Item IonianBootsOfLucidity = new Item("Ionian Boots Of Lucidity", "アイオニアブーツ", 3158, 600, 900, 630, new int[] {1001}, new int[] {1333, 1332}, 1, 240, 288, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.IonianBootsOfLucidity);

    /** Morellonomicon Definition */
    public static final Item Morellonomicon = new Item("Morellonomicon", "モレロノミコン", 3165, 665, 2900, 2030, new int[] {3108, 1052, 3802}, null, 1, 288, 288, 3, 0, 0.0F, 400, 0, 0, 100, 0, 0, 0, 0, 0, ItemDefinition.Morellonomicon);

    /** Athene's Unholy Grail Definition */
    public static final Item AthenesUnholyGrail = new Item("Athene's Unholy Grail", "アテネの血杯", 3174, 450, 2250, 1575, new int[] {3108, 3028}, null, 1, 384, 288, 3, 0, 0.0F, 0, 0, 0, 40, 25, 0, 0, 0, 0, ItemDefinition.AthenesUnholyGrail);

    /** Locket of the Iron Solari Definition */
    public static final Item LocketOftheIronSolari = new Item("Locket Of the Iron Solari", "ソラリのロケット", 3190, 200, 2500, 1750, new int[] {3105, 3067}, null, 1, 192, 336, 4, 400, 0.0F, 0, 0, 0, 0, 20, 0, 0, 0, 0, ItemDefinition.LocketOftheIronSolari);

    /** Seeker's Armguard Definition */
    public static final Item SeekersArmguard = new Item("Seeker's Armguard", "シーカー・アームガード", 3191, 165, 1200, 840, new int[] {1029, 1052, 1029}, new int[] {3090, 3157, 3170}, 1, 240, 336, 2, 0, 0.0F, 0, 0, 30, 20, 0, 0, 0, 0, 0, ItemDefinition.SeekersArmguard);

    /** The Hex Core mk-1 Definition */
    public static final Item HexCoremk1 = new Item(" Hex Core mk-1", "ヘクスコアMK-1", 3196, 1250, 1250, 875, new int[] {3200}, new int[] {3197}, 1, 288, 336, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.HexCoremk1);

    /** The Hex Core mk-2 Definition */
    public static final Item HexCoremk2 = new Item(" Hex Core mk-2", "ヘクスコアMK-2", 3197, 1000, 2250, 1575, new int[] {3196}, new int[] {3198}, 1, 336, 336, 3, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.HexCoremk2);

    /** Perfect Hex Core Definition */
    public static final Item PerfectHexCore = new Item("Perfect Hex Core", "パーフェクト・ヘクスコア", 3198, 750, 3000, 2100, new int[] {3197}, null, 1, 384, 336, 4, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.PerfectHexCore);

    /** Prototype Hex Core Definition */
    public static final Item PrototypeHexCore = new Item("Prototype Hex Core", "プロトタイプ・ヘクスコア", 3200, 0, 0, 0, null, new int[] {3196}, 1, 432, 336, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.PrototypeHexCore);

    /** Spectre's Cowl Definition */
    public static final Item SpectresCowl = new Item("Spectre's Cowl", "スペクターカウル", 3211, 350, 1200, 840, new int[] {1028, 1033}, new int[] {3065, 3102}, 1, 0, 384, 2, 250, 0.0F, 0, 0, 0, 0, 30, 0, 0, 0, 0, ItemDefinition.SpectresCowl);

    /** Mikael's Crucible Definition */
    public static final Item MikaelsCrucible = new Item("Mikael's Crucible", "ミカエルのるつぼ", 3222, 650, 2400, 1680, new int[] {3028, 3114}, null, 1, 48, 384, 3, 0, 0.0F, 0, 0, 0, 0, 35, 0, 0, 0, 0, ItemDefinition.MikaelsCrucible);

    /** Luden's Echo Definition */
    public static final Item LudensEcho = new Item("Luden's Echo", "ルーデンエコー", 3285, 1100, 3200, 2240, new int[] {1058, 3113}, null, 1, 96, 384, 3, 0, 0.0F, 0, 0, 0, 100, 0, 0, 10, 0, 0, ItemDefinition.LudensEcho);

    /** Ancient Coin Definition */
    public static final Item AncientCoin = new Item("Ancient Coin", "エンシェントコイン", 3301, 350, 350, 140, null, new int[] {3096}, 1, 144, 384, 0, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.AncientCoin);

    /** Relic Shield Definition */
    public static final Item RelicShield = new Item("Relic Shield", "レリックシールド", 3302, 350, 350, 140, null, new int[] {3097}, 1, 192, 384, 0, 75, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.RelicShield);

    /** Spellthief's Edge Definition */
    public static final Item SpellthiefsEdge = new Item("Spellthief's Edge", "スペルシーフエッジ", 3303, 350, 350, 140, null, new int[] {3098}, 1, 240, 384, 0, 0, 0.0F, 0, 0, 0, 5, 0, 0, 0, 0, 0, ItemDefinition.SpellthiefsEdge);

    /** Face of the Mountain Definition */
    public static final Item FaceOftheMountain = new Item("Face Of the Mountain", "フェイス・オブ・マウンテン", 3401, 550, 2200, 880, new int[] {3097, 3067}, null, 1, 192, 432, 3, 450, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.FaceOftheMountain);

    /** Ardent Censer Definition */
    public static final Item ArdentCenser = new Item("Ardent Censer", "アーデントセンサー", 3504, 700, 2400, 1680, new int[] {3114, 3113}, null, 2, 96, 0, 3, 0, 0.0F, 0, 0, 0, 60, 0, 0, 0, 0, 0, ItemDefinition.ArdentCenser);

    /** Essence Reaver Definition */
    public static final Item EssenceReaver = new Item("Essence Reaver", "エッセンスリーバー", 3508, 400, 3600, 2520, new int[] {1038, 3133, 1018}, null, 2, 144, 0, 3, 0, 0.0F, 0, 70, 0, 0, 0, 0, 0, 20, 0, ItemDefinition.EssenceReaver);

    /** Zz'Rot Portal Definition */
    public static final Item ZzRotPortal = new Item("Zz'Rot Portal", "ジ＝ロット・ポータル", 3512, 780, 2700, 1890, new int[] {2053, 1057}, null, 2, 192, 0, 4, 0, 0.0F, 0, 0, 55, 0, 55, 0, 0, 0, 0, ItemDefinition.ZzRotPortal);

    /** Stalker's Blade Definition */
    public static final Item StalkersBlade = new Item("Stalker's Blade", "ストーカーブレード", 3706, 300, 1000, 700, new int[] {1039, 1041}, new int[] {1400, 1401, 1402, 1416}, 2, 0, 48, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.StalkersBlade);

    /** Tracker's Knife Definition */
    public static final Item TrackersKnife = new Item("Tracker's Knife", "トラッカーナイフ", 3711, 300, 1000, 700, new int[] {1039, 1041}, new int[] {1408, 1409, 1410, 1418}, 2, 48, 48, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TrackersKnife);

    /** Skirmisher's Sabre Definition */
    public static final Item SkirmishersSabre = new Item("Skirmisher's Sabre", "スカーミッシュセイバー", 3715, 300, 1000, 700, new int[] {1039, 1041}, new int[] {1412, 1413, 1414, 1419}, 2, 96, 48, 2, 0, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.SkirmishersSabre);

    /** Dead Man's Plate Definition */
    public static final Item DeadMansPlate = new Item("Dead Man's Plate", "デッドマンプレート", 3742, 1100, 2900, 2030, new int[] {1031, 1011}, null, 2, 144, 48, 3, 500, 0.0F, 0, 0, 50, 0, 0, 0, 0, 0, 0, ItemDefinition.DeadMansPlate);

    /** Titanic Hydra Definition */
    public static final Item TitanicHydra = new Item("Titanic Hydra", "タイタン・ハイドラ", 3748, 700, 3500, 2450, new int[] {3077, 1028, 3052}, null, 2, 192, 48, 3, 450, 0.0F, 0, 35, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.TitanicHydra);

    /** Bami's Cinder Definition */
    public static final Item BamisCinder = new Item("Bami's Cinder", "バミ・シンダー", 3751, 700, 1100, 770, new int[] {1028}, new int[] {3068, 3717, 3725, 1401, 1409, 1413, 3672}, 2, 240, 48, 2, 280, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.BamisCinder);

    /** Righteous Glory Definition */
    public static final Item RighteousGlory = new Item("Righteous Glory", "ライチャスグローリー", 3800, 750, 2500, 1750, new int[] {3010, 3801}, null, 2, 288, 48, 3, 500, 0.0F, 300, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.RighteousGlory);

    /** Crystalline Bracer Definition */
    public static final Item CrystallineBracer = new Item("Crystalline Bracer", "クリスタルブレーサー", 3801, 100, 650, 455, new int[] {1028, 1006}, new int[] {3105, 3083, 3084, 3800}, 2, 336, 48, 2, 200, 0.0F, 0, 0, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.CrystallineBracer);

    /** Lost Chapter Definition */
    public static final Item LostChapter = new Item("Lost Chapter", "ロストチャプター", 3802, 115, 900, 630, new int[] {1052, 1027}, new int[] {3165}, 2, 384, 48, 2, 0, 0.0F, 300, 0, 0, 25, 0, 0, 0, 0, 0, ItemDefinition.LostChapter);

    /** Death's Dance Definition */
    public static final Item DeathsDance = new Item("Death's Dance", "デスダンス", 3812, 625, 3500, 2450, new int[] {1053, 1037, 3133}, null, 2, 432, 48, 3, 0, 0.0F, 0, 75, 0, 0, 0, 0, 0, 0, 0, ItemDefinition.DeathsDance);
}
