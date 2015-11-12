/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.api;


public class RiotItemData {

    /** Boots of Speed Definition */
    public static final RiotItemData BootsofSpeed = new RiotItemData("Boots of Speed", "ブーツ", 1001, 300, 300, 210, null, new int[] {3006, 3047, 3020, 3158, 3111, 3117, 3009}, 0, 0, 0, 0);

    /** Faerie Charm Definition */
    public static final RiotItemData FaerieCharm = new RiotItemData("Faerie Charm", "妖精の魔除け", 1004, 125, 125, 88, null, new int[] {3028, 3070, 3073, 3098, 3096, 3114}, 0, 48, 0, 0);

    /** Rejuvenation Bead Definition */
    public static final RiotItemData RejuvenationBead = new RiotItemData("Rejuvenation Bead", "再生の珠", 1006, 150, 150, 105, null, new int[] {3077, 3112, 2051, 2053, 3096, 3097, 3801}, 0, 96, 0, 0);

    /** Giant's Belt Definition */
    public static final RiotItemData GiantsBelt = new RiotItemData("Giant's Belt", "巨人のベルト", 1011, 600, 1000, 700, new int[] {1028}, new int[] {3083, 3143, 3116, 3084, 3742}, 0, 144, 0, 2);

    /** Cloak of Agility Definition */
    public static final RiotItemData CloakofAgility = new RiotItemData("Cloak of Agility", "敏捷のマント", 1018, 800, 800, 560, null, new int[] {3031, 3104, 3185, 3508}, 0, 192, 0, 0);

    /** Blasting Wand Definition */
    public static final RiotItemData BlastingWand = new RiotItemData("Blasting Wand", "破裂の杖", 1026, 850, 850, 595, null, new int[] {3001, 3135, 3027, 3029, 3089, 3124, 3100, 3151}, 0, 240, 0, 0);

    /** Sapphire Crystal Definition */
    public static final RiotItemData SapphireCrystal = new RiotItemData("Sapphire Crystal", "サファイアクリスタル", 1027, 350, 350, 245, null, new int[] {3057, 3070, 3073, 3010, 3024}, 0, 288, 0, 0);

    /** Ruby Crystal Definition */
    public static final RiotItemData RubyCrystal = new RiotItemData("Ruby Crystal", "ルビークリスタル", 1028, 400, 400, 280, null, new int[] {1011, 3751, 2049, 2045, 2051, 3010, 3052, 3022, 3044, 3053, 3067, 3801, 3211, 3136, 3748}, 0, 336, 0, 0);

    /** Cloth Armor Definition */
    public static final RiotItemData ClothArmor = new RiotItemData("Cloth Armor", "布の鎧", 1029, 300, 300, 210, null, new int[] {3047, 1031, 3191, 3024, 3082, 3075, 2053}, 0, 384, 0, 0);

    /** Chain Vest Definition */
    public static final RiotItemData ChainVest = new RiotItemData("Chain Vest", "チェインベスト", 1031, 500, 800, 560, new int[] {1029}, new int[] {3075, 3068, 3026, 2053, 3742}, 0, 432, 0, 2);

    /** Null-Magic Mantle Definition */
    public static final RiotItemData NullMagicMantle = new RiotItemData("Null-Magic Mantle", "抗魔のマント", 1033, 450, 450, 315, null, new int[] {3111, 3211, 1057, 3028, 3140, 3155, 3105, 3091}, 0, 0, 48, 0);

    /** Long Sword Definition */
    public static final RiotItemData LongSword = new RiotItemData("Long Sword", "ロングソード", 1036, 350, 350, 245, null, new int[] {1053, 3133, 3052, 3123, 3034, 3044, 3072, 3074, 3122, 3134, 3144, 3154, 3155, 3159}, 0, 48, 48, 0);

    /** Pickaxe Definition */
    public static final RiotItemData Pickaxe = new RiotItemData("Pickaxe", "ツルハシ", 1037, 875, 875, 613, null, new int[] {3004, 3008, 3022, 3031, 3035, 3077, 3104, 3124, 3139, 3181, 3184, 3812}, 0, 96, 48, 0);

    /** B. F. Sword Definition */
    public static final RiotItemData BFSword = new RiotItemData("B. F. Sword", "B. F. ソード", 1038, 1300, 1300, 910, null, new int[] {3031, 3072, 3508}, 0, 144, 48, 0);

    /** Hunter's Talisman Definition */
    public static final RiotItemData HuntersTalisman = new RiotItemData("Hunter's Talisman", "狩人の山刀", 1039, 350, 350, 245, null, new int[] {3706, 3711, 3715}, 0, 192, 48, 0);

    /** Hunter's Machete Definition */
    public static final RiotItemData HuntersMachete = new RiotItemData("Hunter's Machete", "Hunter's Machete", 1041, 350, 350, 245, null, new int[] {3706, 3711, 3715}, 3, 240, 240, 0);

    /** Dagger Definition */
    public static final RiotItemData Dagger = new RiotItemData("Dagger", "ダガー", 1042, 300, 300, 210, null, new int[] {1043, 3006, 2015, 3046, 3086, 3091, 3101, 3106, 3154, 3159}, 0, 240, 48, 0);

    /** Recurve Bow Definition */
    public static final RiotItemData RecurveBow = new RiotItemData("Recurve Bow", "速射の弓", 1043, 400, 1000, 700, new int[] {1042, 1042}, new int[] {3091, 3153, 3085, 3718, 3722, 1403, 1411, 1415, 3674}, 0, 288, 48, 2);

    /** Brawler's Gloves Definition */
    public static final RiotItemData BrawlersGloves = new RiotItemData("Brawler's Gloves", "喧嘩屋の手袋", 1051, 400, 400, 280, null, new int[] {3086, 3122}, 0, 336, 48, 0);

    /** Amplifying Tome Definition */
    public static final RiotItemData AmplifyingTome = new RiotItemData("Amplifying Tome", "増魔の書", 1052, 435, 435, 305, null, new int[] {3108, 3191, 3136, 3135, 3145, 3113, 3090, 3116, 1402, 1410, 1414, 3050, 3089, 3165, 3174, 3673, 3744}, 0, 384, 48, 0);

    /** Vampiric Scepter Definition */
    public static final RiotItemData VampiricScepter = new RiotItemData("Vampiric Scepter", "吸血の権杖", 1053, 550, 900, 630, new int[] {1036}, new int[] {3072, 3074, 3139, 3144, 3181, 3812}, 0, 432, 48, 2);

    /** Doran's Shield Definition */
    public static final RiotItemData DoransShield = new RiotItemData("Doran's Shield", "ドランの盾", 1054, 450, 450, 180, null, null, 0, 0, 96, 0);

    /** Doran's Blade Definition */
    public static final RiotItemData DoransBlade = new RiotItemData("Doran's Blade", "ドランの剣", 1055, 450, 450, 180, null, null, 0, 48, 96, 0);

    /** Doran's Ring Definition */
    public static final RiotItemData DoransRing = new RiotItemData("Doran's Ring", "ドランの指輪", 1056, 400, 400, 160, null, null, 0, 96, 96, 0);

    /** Negatron Cloak Definition */
    public static final RiotItemData NegatronCloak = new RiotItemData("Negatron Cloak", "封魔のマント", 1057, 270, 720, 504, new int[] {1033}, new int[] {3001, 3026, 3112, 3170, 3180, 3512}, 0, 144, 96, 2);

    /** Needlessly Large Rod Definition */
    public static final RiotItemData NeedlesslyLargeRod = new RiotItemData("Needlessly Large Rod", "ムダニデカイ・ロッド", 1058, 1250, 1250, 875, null, new int[] {3089, 3157, 3003, 3007, 3090, 3116, 3285}, 0, 192, 96, 0);

    /** Prospector's Blade Definition */
    public static final RiotItemData ProspectorsBlade = new RiotItemData("Prospector's Blade", "プロスペクターの剣", 1062, 950, 950, 380, null, null, 0, 240, 96, 0);

    /** Prospector's Ring Definition */
    public static final RiotItemData ProspectorsRing = new RiotItemData("Prospector's Ring", "プロスペクターの指輪", 1063, 950, 950, 380, null, null, 0, 288, 96, 0);

    /** Doran's Shield (Showdown) Definition */
    public static final RiotItemData DoransShieldShowdown = new RiotItemData("Doran's Shield (Showdown)", "ドランの盾(ショーダウン)", 1074, 440, 440, 176, null, null, 0, 336, 96, 0);

    /** Doran's Blade (Showdown) Definition */
    public static final RiotItemData DoransBladeShowdown = new RiotItemData("Doran's Blade (Showdown)", "ドランの剣(ショーダウン)", 1075, 440, 440, 176, null, null, 0, 384, 96, 0);

    /** Doran's Ring (Showdown) Definition */
    public static final RiotItemData DoransRingShowdown = new RiotItemData("Doran's Ring (Showdown)", "ドランの指輪(ショーダウン)", 1076, 400, 400, 160, null, null, 0, 432, 96, 0);

    /** The Dark Seal Definition */
    public static final RiotItemData TheDarkSeal = new RiotItemData("The Dark Seal", "The Dark Seal", 1082, 400, 400, 280, null, new int[] {3041}, 3, 288, 240, 0);

    /** Cull Definition */
    public static final RiotItemData Cull = new RiotItemData("Cull", "Cull", 1083, 450, 450, 180, null, null, 3, 336, 240, 0);

    /** Enchantment: Furor Definition */
    public static final RiotItemData BerserkersGreavesFuror = new RiotItemData("Berserker's Greaves [Furor]", "バーサーカーのブーツ [憤怒]", 1300, 450, 1550, 1085, new int[] {3006}, null, 2, 0, 336, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData BerserkersGreavesAlacrity = new RiotItemData("Berserker's Greaves [Alacrity]", "バーサーカーのブーツ [疾風]", 1301, 450, 1550, 1085, new int[] {3006}, null, 2, 48, 336, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData BerserkersGreavesCaptain = new RiotItemData("Berserker's Greaves [Captain]", "バーサーカーのブーツ [隊長]", 1302, 450, 1550, 1085, new int[] {3006}, null, 2, 96, 336, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData BerserkersGreavesDistortion = new RiotItemData("Berserker's Greaves [Distortion]", "バーサーカーのブーツ [時空歪曲]", 1303, 450, 1550, 1085, new int[] {3006}, null, 2, 144, 336, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData BerserkersGreavesHomeguard = new RiotItemData("Berserker's Greaves [Homeguard]", "バーサーカーのブーツ [防衛]", 1304, 450, 1550, 1085, new int[] {3006}, null, 2, 192, 336, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData BootsofSwiftnessFuror = new RiotItemData("Boots of Swiftness [Furor]", "迅速のブーツ [憤怒]", 1305, 450, 1250, 875, new int[] {3009}, null, 2, 240, 336, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData BootsofSwiftnessAlacrity = new RiotItemData("Boots of Swiftness [Alacrity]", "迅速のブーツ [疾風]", 1306, 450, 1250, 875, new int[] {3009}, null, 2, 288, 336, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData BootsofSwiftnessCaptain = new RiotItemData("Boots of Swiftness [Captain]", "迅速のブーツ [隊長]", 1307, 450, 1250, 875, new int[] {3009}, null, 2, 336, 336, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData BootsofSwiftnessDistortion = new RiotItemData("Boots of Swiftness [Distortion]", "迅速のブーツ [時空歪曲]", 1308, 450, 1250, 875, new int[] {3009}, null, 2, 384, 336, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData BootsofSwiftnessHomeguard = new RiotItemData("Boots of Swiftness [Homeguard]", "迅速のブーツ [防衛]", 1309, 450, 1250, 875, new int[] {3009}, null, 2, 432, 336, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData SorcerersShoesFuror = new RiotItemData("Sorcerer's Shoes [Furor]", "魔道士の靴 [憤怒]", 1310, 450, 1550, 1085, new int[] {3020}, null, 2, 0, 384, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData SorcerersShoesAlacrity = new RiotItemData("Sorcerer's Shoes [Alacrity]", "魔道士の靴 [疾風]", 1311, 450, 1550, 1085, new int[] {3020}, null, 2, 48, 384, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData SorcerersShoesCaptain = new RiotItemData("Sorcerer's Shoes [Captain]", "魔道士の靴 [隊長]", 1312, 450, 1550, 1085, new int[] {3020}, null, 2, 96, 384, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData SorcerersShoesDistortion = new RiotItemData("Sorcerer's Shoes [Distortion]", "魔道士の靴 [時空歪曲]", 1313, 450, 1550, 1085, new int[] {3020}, null, 2, 144, 384, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData SorcerersShoesHomeguard = new RiotItemData("Sorcerer's Shoes [Homeguard]", "魔道士の靴 [防衛]", 1314, 450, 1550, 1085, new int[] {3020}, null, 2, 192, 384, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData NinjaTabiFuror = new RiotItemData("Ninja Tabi [Furor]", "忍者足袋 [憤怒]", 1315, 450, 1550, 1085, new int[] {3047}, null, 2, 240, 384, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData NinjaTabiAlacrity = new RiotItemData("Ninja Tabi [Alacrity]", "忍者足袋 [疾風]", 1316, 450, 1550, 1085, new int[] {3047}, null, 2, 288, 384, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData NinjaTabiCaptain = new RiotItemData("Ninja Tabi [Captain]", "忍者足袋 [隊長]", 1317, 450, 1550, 1085, new int[] {3047}, null, 2, 336, 384, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData NinjaTabiDistortion = new RiotItemData("Ninja Tabi [Distortion]", "忍者足袋 [時空歪曲]", 1318, 450, 1550, 1085, new int[] {3047}, null, 2, 384, 384, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData NinjaTabiHomeguard = new RiotItemData("Ninja Tabi [Homeguard]", "忍者足袋 [防衛]", 1319, 450, 1550, 1085, new int[] {3047}, null, 2, 432, 384, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData MercurysTreadsFuror = new RiotItemData("Mercury's Treads [Furor]", "マーキュリーの靴 [憤怒]", 1320, 450, 1550, 1085, new int[] {3111}, null, 2, 0, 432, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData MercurysTreadsAlacrity = new RiotItemData("Mercury's Treads [Alacrity]", "マーキュリーの靴 [疾風]", 1321, 450, 1550, 1085, new int[] {3111}, null, 2, 48, 432, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData MercurysTreadsCaptain = new RiotItemData("Mercury's Treads [Captain]", "マーキュリーの靴 [隊長]", 1322, 450, 1550, 1085, new int[] {3111}, null, 2, 96, 432, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData MercurysTreadsDistortion = new RiotItemData("Mercury's Treads [Distortion]", "マーキュリーの靴 [時空歪曲]", 1323, 450, 1550, 1085, new int[] {3111}, null, 2, 144, 432, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData MercurysTreadsHomeguard = new RiotItemData("Mercury's Treads [Homeguard]", "マーキュリーの靴 [防衛]", 1324, 450, 1550, 1085, new int[] {3111}, null, 2, 192, 432, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData BootsofMobilityFuror = new RiotItemData("Boots of Mobility [Furor]", "踏破のブーツ [憤怒]", 1325, 450, 1250, 875, new int[] {3117}, null, 2, 240, 432, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData BootsofMobilityAlacrity = new RiotItemData("Boots of Mobility [Alacrity]", "踏破のブーツ [疾風]", 1326, 450, 1250, 875, new int[] {3117}, null, 2, 288, 432, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData BootsofMobilityCaptain = new RiotItemData("Boots of Mobility [Captain]", "踏破のブーツ [隊長]", 1327, 450, 1250, 875, new int[] {3117}, null, 2, 336, 432, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData BootsofMobilityDistortion = new RiotItemData("Boots of Mobility [Distortion]", "踏破のブーツ [時空歪曲]", 1328, 450, 1250, 875, new int[] {3117}, null, 2, 384, 432, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData BootsofMobilityHomeguard = new RiotItemData("Boots of Mobility [Homeguard]", "踏破のブーツ [防衛]", 1329, 450, 1250, 875, new int[] {3117}, null, 2, 432, 432, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData IonianBootsofLucidityFuror = new RiotItemData("Ionian Boots of Lucidity [Furor]", "アイオニアブーツ [憤怒]", 1330, 450, 1250, 875, new int[] {3158}, null, 3, 0, 0, 3);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData IonianBootsofLucidityAlacrity = new RiotItemData("Ionian Boots of Lucidity [Alacrity]", "アイオニアブーツ [疾風]", 1331, 450, 1250, 875, new int[] {3158}, null, 3, 48, 0, 3);

    /** Enchantment: Captain Definition */
    public static final RiotItemData IonianBootsofLucidityCaptain = new RiotItemData("Ionian Boots of Lucidity [Captain]", "アイオニアブーツ [隊長]", 1332, 450, 1250, 875, new int[] {3158}, null, 3, 96, 0, 3);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData IonianBootsofLucidityDistortion = new RiotItemData("Ionian Boots of Lucidity [Distortion]", "アイオニアブーツ [時空歪曲]", 1333, 450, 1250, 875, new int[] {3158}, null, 3, 144, 0, 3);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData IonianBootsofLucidityHomeguard = new RiotItemData("Ionian Boots of Lucidity [Homeguard]", "アイオニアブーツ [防衛]", 1334, 450, 1250, 875, new int[] {3158}, null, 3, 192, 0, 3);

    /** Enchantment: Warrior Definition */
    public static final RiotItemData StalkersBladeWarrior = new RiotItemData("Stalker's Blade [Warrior]", "追跡の鋭刃 [Warrior]", 1400, 475, 2625, 1837, new int[] {3133, 3706}, null, 3, 384, 240, 3);

    /** Enchantment: Cinderhulk Definition */
    public static final RiotItemData StalkersBladeCinderhulk = new RiotItemData("Stalker's Blade [Cinderhulk]", "追跡の鋭刃 [Cinderhulk]", 1401, 475, 2625, 1837, new int[] {3751, 3706}, null, 3, 432, 240, 3);

    /** Enchantment: Runeglaive Definition */
    public static final RiotItemData StalkersBladeRuneglaive = new RiotItemData("Stalker's Blade [Runeglaive]", "追跡の鋭刃 [Runeglaive]", 1402, 140, 2675, 1872, new int[] {3057, 1052, 3706}, null, 3, 0, 288, 3);

    /** Enchantment: Devourer Definition */
    public static final RiotItemData StalkersBladeDevourer = new RiotItemData("Stalker's Blade [Devourer]", "追跡の鋭刃 [Devourer]", 1403, 400, 2450, 1715, new int[] {1043, 3706}, new int[] {3930}, 3, 48, 288, 3);

    /** Enchantment: Warrior Definition */
    public static final RiotItemData TrackersKnifeWarrior = new RiotItemData("Tracker's Knife [Warrior]", "略奪の短剣 [Warrior]", 1408, 475, 2625, 1837, new int[] {3133, 3711}, null, 3, 288, 288, 3);

    /** Enchantment: Cinderhulk Definition */
    public static final RiotItemData TrackersKnifeCinderhulk = new RiotItemData("Tracker's Knife [Cinderhulk]", "略奪の短剣 [Cinderhulk]", 1409, 475, 2625, 1837, new int[] {3751, 3711}, null, 3, 336, 288, 3);

    /** Enchantment: Runeglaive Definition */
    public static final RiotItemData TrackersKnifeRuneglaive = new RiotItemData("Tracker's Knife [Runeglaive]", "略奪の短剣 [Runeglaive]", 1410, 140, 2675, 1872, new int[] {3057, 1052, 3711}, null, 3, 384, 288, 3);

    /** Enchantment: Devourer Definition */
    public static final RiotItemData TrackersKnifeDevourer = new RiotItemData("Tracker's Knife [Devourer]", "略奪の短剣 [Devourer]", 1411, 400, 2450, 1715, new int[] {1043, 3711}, new int[] {3932}, 3, 432, 288, 3);

    /** Enchantment: Warrior Definition */
    public static final RiotItemData SkirmishersSabreWarrior = new RiotItemData("Skirmisher's Sabre [Warrior]", "一騎のサーベル [Warrior]", 1412, 475, 2625, 1837, new int[] {3133, 3715}, null, 3, 0, 336, 3);

    /** Enchantment: Cinderhulk Definition */
    public static final RiotItemData SkirmishersSabreCinderhulk = new RiotItemData("Skirmisher's Sabre [Cinderhulk]", "一騎のサーベル [Cinderhulk]", 1413, 475, 2625, 1837, new int[] {3751, 3715}, null, 3, 48, 336, 3);

    /** Enchantment: Runeglaive Definition */
    public static final RiotItemData SkirmishersSabreRuneglaive = new RiotItemData("Skirmisher's Sabre [Runeglaive]", "一騎のサーベル [Runeglaive]", 1414, 140, 2675, 1872, new int[] {3057, 1052, 3715}, null, 3, 96, 336, 3);

    /** Enchantment: Devourer Definition */
    public static final RiotItemData SkirmishersSabreDevourer = new RiotItemData("Skirmisher's Sabre [Devourer]", "一騎のサーベル [Devourer]", 1415, 400, 2450, 1715, new int[] {1043, 3715}, new int[] {3931}, 3, 144, 336, 3);

    /** Health Potion Definition */
    public static final RiotItemData HealthPotion = new RiotItemData("Health Potion", "体力ポーション", 2003, 50, 50, 20, null, null, 0, 0, 144, 0);

    /** Total Biscuit of Rejuvenation Definition */
    public static final RiotItemData TotalBiscuitofRejuvenation = new RiotItemData("Total Biscuit of Rejuvenation", "栄養満点ビスケット", 2010, 50, 50, 20, null, null, 0, 144, 144, 0);

    /** Kircheis Shard Definition */
    public static final RiotItemData KircheisShard = new RiotItemData("Kircheis Shard", "Kircheis Shard", 2015, 450, 750, 525, new int[] {1042}, new int[] {3087, 3094}, 3, 192, 336, 2);

    /** Refillable Potion Definition */
    public static final RiotItemData RefillablePotion = new RiotItemData("Refillable Potion", "Refillable Potion", 2031, 150, 150, 60, null, new int[] {2032, 2033}, 3, 240, 336, 0);

    /** Hunter's Potion Definition */
    public static final RiotItemData HuntersPotion = new RiotItemData("Hunter's Potion", "Hunter's Potion", 2032, 250, 400, 160, new int[] {2031}, null, 3, 288, 336, 2);

    /** Corrupting Potion Definition */
    public static final RiotItemData CorruptingPotion = new RiotItemData("Corrupting Potion", "Corrupting Potion", 2033, 350, 500, 200, new int[] {2031}, null, 3, 336, 336, 2);

    /** Vision Ward Definition */
    public static final RiotItemData VisionWard = new RiotItemData("Vision Ward", "ビジョンワード", 2043, 75, 75, 30, null, null, 0, 240, 144, 0);

    /** Ruby Sightstone Definition */
    public static final RiotItemData RubySightstone = new RiotItemData("Ruby Sightstone", "ルビー・サイトストーン", 2045, 600, 1800, 720, new int[] {2049, 1028}, null, 0, 336, 144, 3);

    /** Oracle's Extract Definition */
    public static final RiotItemData OraclesExtract = new RiotItemData("Oracle's Extract", "オラクルのエキス", 2047, 250, 250, 100, null, null, 0, 384, 144, 0);

    /** Sightstone Definition */
    public static final RiotItemData Sightstone = new RiotItemData("Sightstone", "サイトストーン", 2049, 400, 800, 320, new int[] {1028}, new int[] {2045, 2301, 2302, 2303}, 0, 432, 144, 2);

    /** Explorer's Ward Definition */
    public static final RiotItemData ExplorersWard = new RiotItemData("Explorer's Ward", "探検家のワード", 2050, 0, 0, 0, null, null, 0, 0, 192, 0);

    /** Guardian's Horn Definition */
    public static final RiotItemData GuardiansHorn = new RiotItemData("Guardian's Horn", "守護者の角笛", 2051, 450, 1000, 700, new int[] {1006, 1028}, null, 0, 48, 192, 2);

    /** Poro-Snax Definition */
    public static final RiotItemData PoroSnax = new RiotItemData("Poro-Snax", "ポロのおやつ", 2052, 0, 0, 0, null, null, 0, 96, 192, 0);

    /** Raptor Cloak Definition */
    public static final RiotItemData RaptorCloak = new RiotItemData("Raptor Cloak", "ラプターのマント", 2053, 250, 1200, 840, new int[] {1006, 1031}, new int[] {3056, 3512}, 0, 144, 192, 3);

    /** Diet Poro-Snax Definition */
    public static final RiotItemData DietPoroSnax = new RiotItemData("Diet Poro-Snax", "ポロのヘルシーおやつ", 2054, 0, 0, 0, null, null, 0, 192, 192, 0);

    /** Elixir of Iron Definition */
    public static final RiotItemData ElixirofIron = new RiotItemData("Elixir of Iron", "巨躯のエリクサー", 2138, 500, 500, 200, null, null, 0, 288, 192, 0);

    /** Elixir of Sorcery Definition */
    public static final RiotItemData ElixirofSorcery = new RiotItemData("Elixir of Sorcery", "聡明のエリクサー", 2139, 500, 500, 200, null, null, 0, 336, 192, 0);

    /** Elixir of Wrath Definition */
    public static final RiotItemData ElixirofWrath = new RiotItemData("Elixir of Wrath", "憤怒のエリクサー", 2140, 500, 500, 200, null, null, 0, 384, 192, 0);

    /** Eye of the Watchers Definition */
    public static final RiotItemData EyeoftheWatchers = new RiotItemData("Eye of the Watchers", "Eye of the Watchers", 2301, 550, 2200, 880, new int[] {2049, 3098}, null, 3, 384, 336, 3);

    /** Eye of the Oasis Definition */
    public static final RiotItemData EyeoftheOasis = new RiotItemData("Eye of the Oasis", "Eye of the Oasis", 2302, 550, 2200, 880, new int[] {2049, 3096}, null, 3, 432, 336, 3);

    /** Eye of the Equinox Definition */
    public static final RiotItemData EyeoftheEquinox = new RiotItemData("Eye of the Equinox", "Eye of the Equinox", 2303, 550, 2200, 880, new int[] {2049, 3097}, null, 3, 0, 384, 3);

    /** Abyssal Scepter Definition */
    public static final RiotItemData AbyssalScepter = new RiotItemData("Abyssal Scepter", "深淵の権杖", 3001, 780, 2350, 1645, new int[] {1026, 1057}, null, 0, 432, 192, 3);

    /** Archangel's Staff Definition */
    public static final RiotItemData ArchangelsStaff = new RiotItemData("Archangel's Staff", "大天使の杖", 3003, 1100, 3100, 2170, new int[] {3070, 1058}, new int[] {3040}, 0, 0, 240, 3);

    /** Manamune Definition */
    public static final RiotItemData Manamune = new RiotItemData("Manamune", "マナ・ムネ", 3004, 775, 2400, 1680, new int[] {3070, 1037}, new int[] {3042}, 0, 48, 240, 3);

    /** Berserker's Greaves Definition */
    public static final RiotItemData BerserkersGreaves = new RiotItemData("Berserker's Greaves", "バーサーカーのブーツ", 3006, 500, 1100, 770, new int[] {1001, 1042}, new int[] {1301, 1303, 1300, 1302, 1304}, 0, 96, 240, 2);

    /** Boots of Swiftness Definition */
    public static final RiotItemData BootsofSwiftness = new RiotItemData("Boots of Swiftness", "迅速のブーツ", 3009, 500, 800, 560, new int[] {1001}, new int[] {1306, 1308, 1305, 1307, 1309}, 0, 240, 240, 2);

    /** Catalyst the Protector Definition */
    public static final RiotItemData CatalysttheProtector = new RiotItemData("Catalyst the Protector", "守護の触媒", 3010, 450, 1200, 840, new int[] {1028, 1027}, new int[] {3027, 3029, 3180, 3800}, 0, 288, 240, 2);

    /** Sorcerer's Shoes Definition */
    public static final RiotItemData SorcerersShoes = new RiotItemData("Sorcerer's Shoes", "魔道士の靴", 3020, 800, 1100, 770, new int[] {1001}, new int[] {1311, 1313, 1310, 1312, 1314}, 0, 336, 240, 2);

    /** Frozen Mallet Definition */
    public static final RiotItemData FrozenMallet = new RiotItemData("Frozen Mallet", "氷結の大槌", 3022, 625, 3100, 2170, new int[] {3052, 1037, 1028}, null, 0, 384, 240, 3);

    /** Glacial Shroud Definition */
    public static final RiotItemData GlacialShroud = new RiotItemData("Glacial Shroud", "氷河の盾", 3024, 350, 1000, 700, new int[] {1027, 1029}, new int[] {3110, 3025, 3050, 3187}, 0, 0, 288, 2);

    /** Iceborn Gauntlet Definition */
    public static final RiotItemData IcebornGauntlet = new RiotItemData("Iceborn Gauntlet", "アイスボーンの籠手", 3025, 650, 2700, 1890, new int[] {3057, 3024}, null, 0, 48, 288, 3);

    /** Guardian Angel Definition */
    public static final RiotItemData GuardianAngel = new RiotItemData("Guardian Angel", "守護天使の鎧", 3026, 1380, 2900, 1160, new int[] {1057, 1031}, null, 0, 96, 288, 3);

    /** Rod of Ages Definition */
    public static final RiotItemData RodofAges = new RiotItemData("Rod of Ages", "歳月の杖", 3027, 950, 3000, 2100, new int[] {3010, 1026}, null, 0, 144, 288, 3);

    /** Chalice of Harmony Definition */
    public static final RiotItemData ChaliceofHarmony = new RiotItemData("Chalice of Harmony", "調和の聖杯", 3028, 300, 1000, 700, new int[] {1004, 1033, 1004}, new int[] {3174, 3222, 3744}, 0, 192, 288, 2);

    /** Infinity Edge Definition */
    public static final RiotItemData InfinityEdge = new RiotItemData("Infinity Edge", "無限の神剣", 3031, 625, 3600, 2520, new int[] {1038, 1037, 1018}, null, 0, 288, 288, 2);

    /** Mortal Reminder Definition */
    public static final RiotItemData MortalReminder = new RiotItemData("Mortal Reminder", "Mortal Reminder", 3033, 600, 2700, 1890, new int[] {3035, 3123}, null, 3, 48, 384, 3);

    /** Giant Slayer Definition */
    public static final RiotItemData GiantSlayer = new RiotItemData("Giant Slayer", "Giant Slayer", 3034, 650, 1000, 700, new int[] {1036}, new int[] {3036}, 3, 96, 384, 2);

    /** Last Whisper Definition */
    public static final RiotItemData LastWhisper = new RiotItemData("Last Whisper", "終焉の弓", 3035, 425, 1300, 910, new int[] {1037}, new int[] {3033, 3036}, 0, 336, 288, 2);

    /** Lord Dominik's Regards Definition */
    public static final RiotItemData LordDominiksRegards = new RiotItemData("Lord Dominik's Regards", "Lord Dominik's Regards", 3036, 400, 2700, 1890, new int[] {3035, 3034}, null, 3, 144, 384, 3);

    /** Seraph's Embrace Definition */
    public static final RiotItemData SeraphsEmbrace = new RiotItemData("Seraph's Embrace", "熾天使の抱擁", 3040, 3000, 3000, 4270, new int[] {3003}, null, 0, 384, 288, 4);

    /** Mejai's Soulstealer Definition */
    public static final RiotItemData MejaisSoulstealer = new RiotItemData("Mejai's Soulstealer", "メジャイの魔本", 3041, 1000, 1400, 980, new int[] {1082}, null, 0, 432, 288, 2);

    /** Muramana Definition */
    public static final RiotItemData Muramana = new RiotItemData("Muramana", "ムラ・マナ", 3042, 2200, 2200, 3220, new int[] {3004}, null, 0, 0, 336, 4);

    /** Phage Definition */
    public static final RiotItemData Phage = new RiotItemData("Phage", "ファージ", 3044, 500, 1250, 875, new int[] {1028, 1036}, new int[] {3078, 3071, 3184}, 0, 96, 336, 2);

    /** Phantom Dancer Definition */
    public static final RiotItemData PhantomDancer = new RiotItemData("Phantom Dancer", "幻影の踊り手", 3046, 900, 2700, 1890, new int[] {1042, 3086, 1042}, null, 0, 144, 336, 3);

    /** Ninja Tabi Definition */
    public static final RiotItemData NinjaTabi = new RiotItemData("Ninja Tabi", "忍者足袋", 3047, 500, 1100, 770, new int[] {1001, 1029}, new int[] {1316, 1318, 1315, 1317, 1319}, 0, 192, 336, 2);

    /** Zeke's Harbinger Definition */
    public static final RiotItemData ZekesHarbinger = new RiotItemData("Zeke's Harbinger", "ジークの先駆者", 3050, 480, 2350, 1645, new int[] {1052, 3024, 1052}, null, 0, 288, 336, 3);

    /** Jaurim's Fist Definition */
    public static final RiotItemData JaurimsFist = new RiotItemData("Jaurim's Fist", "Jaurim's Fist", 3052, 450, 1200, 840, new int[] {1036, 1028}, new int[] {3022, 3053, 3748}, 3, 192, 384, 2);

    /** Sterak's Gage Definition */
    public static final RiotItemData SteraksGage = new RiotItemData("Sterak's Gage", "ステラックの篭手", 3053, 1100, 2700, 1890, new int[] {3052, 1028}, null, 3, 144, 240, 3);

    /** Ohmwrecker Definition */
    public static final RiotItemData Ohmwrecker = new RiotItemData("Ohmwrecker", "撹乱石", 3056, 650, 2650, 1855, new int[] {2053, 3067}, null, 0, 336, 336, 4);

    /** Sheen Definition */
    public static final RiotItemData Sheen = new RiotItemData("Sheen", "シーン", 3057, 700, 1050, 735, new int[] {1027}, new int[] {3078, 3100, 3025, 1402, 1410, 1414, 3673}, 0, 384, 336, 2);

    /** Banner of Command Definition */
    public static final RiotItemData BannerofCommand = new RiotItemData("Banner of Command", "統率の旗", 3060, 600, 2900, 2030, new int[] {3105, 3108}, null, 0, 432, 336, 4);

    /** Spirit Visage Definition */
    public static final RiotItemData SpiritVisage = new RiotItemData("Spirit Visage", "精霊の鎧", 3065, 900, 2800, 1960, new int[] {3211, 3067}, null, 0, 0, 384, 3);

    /** Kindlegem Definition */
    public static final RiotItemData Kindlegem = new RiotItemData("Kindlegem", "点火石", 3067, 400, 800, 560, new int[] {1028}, new int[] {3187, 3190, 3401, 3065, 3056}, 0, 48, 384, 2);

    /** Sunfire Cape Definition */
    public static final RiotItemData SunfireCape = new RiotItemData("Sunfire Cape", "灼熱の鎧", 3068, 800, 2700, 1890, new int[] {1031, 3751}, null, 0, 96, 384, 3);

    /** Talisman of Ascension Definition */
    public static final RiotItemData TalismanofAscension = new RiotItemData("Talisman of Ascension", "超越の護符", 3069, 800, 2200, 880, new int[] {3096, 3114}, null, 0, 144, 384, 3);

    /** Tear of the Goddess Definition */
    public static final RiotItemData TearoftheGoddess = new RiotItemData("Tear of the Goddess", "女神の涙", 3070, 275, 750, 525, new int[] {1027, 1004}, new int[] {3003, 3004}, 0, 192, 384, 2);

    /** The Black Cleaver Definition */
    public static final RiotItemData TheBlackCleaver = new RiotItemData("The Black Cleaver", "撃滅の黒斧", 3071, 1150, 3500, 2450, new int[] {3044, 3133}, null, 0, 240, 384, 3);

    /** The Bloodthirster Definition */
    public static final RiotItemData TheBloodthirster = new RiotItemData("The Bloodthirster", "渇望の血剣", 3072, 1150, 3700, 2590, new int[] {1038, 1036, 1053}, null, 0, 288, 384, 3);

    /** Ravenous Hydra Definition */
    public static final RiotItemData RavenousHydra = new RiotItemData("Ravenous Hydra", "餓えしハイドラ(近接専用)", 3074, 1100, 3600, 2520, new int[] {3077, 1053, 1036}, null, 0, 384, 384, 3);

    /** Thornmail Definition */
    public static final RiotItemData Thornmail = new RiotItemData("Thornmail", "刃の鎧", 3075, 1250, 2350, 1645, new int[] {1029, 1031}, null, 0, 432, 384, 3);

    /** Tiamat Definition */
    public static final RiotItemData Tiamat = new RiotItemData("Tiamat", "ティアマット（近接専用）", 3077, 225, 1250, 875, new int[] {1037, 1006}, new int[] {3074, 3748}, 0, 0, 432, 2);

    /** Trinity Force Definition */
    public static final RiotItemData TrinityForce = new RiotItemData("Trinity Force", "トリニティ・フォース", 3078, 300, 3800, 2660, new int[] {3086, 3057, 3044}, null, 0, 48, 432, 3);

    /** Warden's Mail Definition */
    public static final RiotItemData WardensMail = new RiotItemData("Warden's Mail", "番人の鎧", 3082, 500, 1100, 770, new int[] {1029, 1029}, new int[] {3110, 3143}, 0, 96, 432, 2);

    /** Warmog's Armor Definition */
    public static final RiotItemData WarmogsArmor = new RiotItemData("Warmog's Armor", "ワーモグの鎧", 3083, 550, 2850, 1995, new int[] {3801, 1011, 3801}, null, 0, 144, 432, 3);

    /** Overlord's Bloodmail Definition */
    public static final RiotItemData OverlordsBloodmail = new RiotItemData("Overlord's Bloodmail", "覇王の血染鎧", 3084, 900, 2550, 1785, new int[] {1011, 3801}, null, 0, 192, 432, 3);

    /** Runaan's Hurricane Definition */
    public static final RiotItemData RunaansHurricane = new RiotItemData("Runaan's Hurricane", "ルナーンのハリケーン(遠隔専用)", 3085, 300, 2500, 1750, new int[] {1043, 3086}, null, 0, 240, 432, 3);

    /** Zeal Definition */
    public static final RiotItemData Zeal = new RiotItemData("Zeal", "ジール", 3086, 500, 1200, 840, new int[] {1051, 1042}, new int[] {3046, 3078, 3085, 3087, 3094}, 0, 288, 432, 2);

    /** Statikk Shiv Definition */
    public static final RiotItemData StatikkShiv = new RiotItemData("Statikk Shiv", "雷剣", 3087, 550, 2500, 1750, new int[] {3086, 2015}, null, 0, 336, 432, 3);

    /** Rabadon's Deathcap Definition */
    public static final RiotItemData RabadonsDeathcap = new RiotItemData("Rabadon's Deathcap", "ラバドンの死の帽子", 3089, 1265, 3800, 2660, new int[] {1026, 1058, 1052}, null, 0, 384, 432, 2);

    /** Wooglet's Witchcap Definition */
    public static final RiotItemData WoogletsWitchcap = new RiotItemData("Wooglet's Witchcap", "ウーグレットの魔の帽子", 3090, 1050, 3500, 2450, new int[] {3191, 1058}, null, 0, 432, 432, 3);

    /** Wit's End Definition */
    public static final RiotItemData WitsEnd = new RiotItemData("Wit's End", "究極の答え", 3091, 1050, 2800, 1960, new int[] {1043, 1033, 1042}, null, 1, 0, 0, 3);

    /** Frost Queen's Claim Definition */
    public static final RiotItemData FrostQueensClaim = new RiotItemData("Frost Queen's Claim", "女王の凍った指先", 3092, 550, 2200, 880, new int[] {3098, 3108}, null, 1, 48, 0, 3);

    /** Rapid Firecannon Definition */
    public static final RiotItemData RapidFirecannon = new RiotItemData("Rapid Firecannon", "Rapid Firecannon", 3094, 550, 2500, 1750, new int[] {3086, 2015}, null, 3, 240, 384, 3);

    /** Nomad's Medallion Definition */
    public static final RiotItemData NomadsMedallion = new RiotItemData("Nomad's Medallion", "放浪民のメダル", 3096, 225, 850, 340, new int[] {1004, 3301, 1006}, new int[] {2302, 3069}, 1, 144, 0, 2);

    /** Targon's Brace Definition */
    public static final RiotItemData TargonsBrace = new RiotItemData("Targon's Brace", "ターゴンの腕輪", 3097, 350, 850, 340, new int[] {3302, 1006}, new int[] {2303, 3401}, 1, 192, 0, 2);

    /** Frostfang Definition */
    public static final RiotItemData Frostfang = new RiotItemData("Frostfang", "白霜の牙", 3098, 375, 850, 340, new int[] {3303, 1004}, new int[] {2301, 3092}, 1, 240, 0, 2);

    /** Lich Bane Definition */
    public static final RiotItemData LichBane = new RiotItemData("Lich Bane", "死神殺しの双剣", 3100, 450, 3200, 2240, new int[] {3057, 3113, 1026}, null, 1, 288, 0, 3);

    /** Stinger Definition */
    public static final RiotItemData Stinger = new RiotItemData("Stinger", "刺剣", 3101, 600, 1200, 840, new int[] {1042, 1042}, new int[] {3115, 3137}, 1, 336, 0, 2);

    /** Banshee's Veil Definition */
    public static final RiotItemData BansheesVeil = new RiotItemData("Banshee's Veil", "バンシーのヴェール", 3102, 1150, 2900, 2030, new int[] {3211, 3801}, null, 1, 384, 0, 3);

    /** Lord Van Damm's Pillager Definition */
    public static final RiotItemData LordVanDammsPillager = new RiotItemData("Lord Van Damm's Pillager", "ヴァンダム卿の星球武器", 3104, 725, 3600, 2520, new int[] {3122, 1037, 1018}, null, 1, 432, 0, 3);

    /** Aegis of the Legion Definition */
    public static final RiotItemData AegisoftheLegion = new RiotItemData("Aegis of the Legion", "イージスの盾", 3105, 400, 1500, 1050, new int[] {1033, 3801}, new int[] {3190, 3060}, 1, 0, 48, 3);

    /** Fiendish Codex Definition */
    public static final RiotItemData FiendishCodex = new RiotItemData("Fiendish Codex", "悪魔の古書", 3108, 365, 800, 560, new int[] {1052}, new int[] {3174, 3092, 3115, 3165, 3152, 3060}, 1, 96, 48, 2);

    /** Frozen Heart Definition */
    public static final RiotItemData FrozenHeart = new RiotItemData("Frozen Heart", "凍れる心臓", 3110, 700, 2800, 1960, new int[] {3082, 3024}, null, 1, 144, 48, 3);

    /** Mercury's Treads Definition */
    public static final RiotItemData MercurysTreads = new RiotItemData("Mercury's Treads", "マーキュリーの靴", 3111, 350, 1100, 770, new int[] {1001, 1033}, new int[] {1321, 1323, 1320, 1322, 1324}, 1, 192, 48, 2);

    /** Orb of Winter Definition */
    public static final RiotItemData OrbofWinter = new RiotItemData("Orb of Winter", "冬の宝珠", 3112, 990, 2010, 1407, new int[] {1006, 1006, 1057}, null, 1, 240, 48, 3);

    /** Aether Wisp Definition */
    public static final RiotItemData AetherWisp = new RiotItemData("Aether Wisp", "鬼火", 3113, 415, 850, 595, new int[] {1052}, new int[] {3290, 3100, 3285, 3504}, 1, 288, 48, 2);

    /** Forbidden Idol Definition */
    public static final RiotItemData ForbiddenIdol = new RiotItemData("Forbidden Idol", "禁じられた偶像", 3114, 300, 550, 385, new int[] {1004, 1004}, new int[] {3069, 3165, 3222, 3504}, 1, 336, 48, 2);

    /** Nashor's Tooth Definition */
    public static final RiotItemData NashorsTooth = new RiotItemData("Nashor's Tooth", "ナッシャーの歯牙", 3115, 1000, 3000, 2100, new int[] {3101, 3108}, null, 1, 384, 48, 3);

    /** Rylai's Crystal Scepter Definition */
    public static final RiotItemData RylaisCrystalScepter = new RiotItemData("Rylai's Crystal Scepter", "リーライのクリスタル権杖", 3116, 515, 3200, 2240, new int[] {1058, 1052, 1011}, null, 1, 432, 48, 3);

    /** Boots of Mobility Definition */
    public static final RiotItemData BootsofMobility = new RiotItemData("Boots of Mobility", "踏破のブーツ", 3117, 500, 800, 560, new int[] {1001}, new int[] {1326, 1328, 1325, 1327, 1329}, 1, 0, 96, 2);

    /** Wicked Hatchet Definition */
    public static final RiotItemData WickedHatchet = new RiotItemData("Wicked Hatchet", "邪悪な手斧", 3122, 450, 1200, 840, new int[] {1051, 1036}, new int[] {3104, 3185}, 1, 48, 96, 2);

    /** Executioner's Calling Definition */
    public static final RiotItemData ExecutionersCalling = new RiotItemData("Executioner's Calling", "処刑人の使命", 3123, 450, 800, 560, new int[] {1036}, new int[] {3033}, 3, 288, 384, 2);

    /** Guinsoo's Rageblade Definition */
    public static final RiotItemData GuinsoosRageblade = new RiotItemData("Guinsoo's Rageblade", "グインソーの荒ぶる刃", 3124, 775, 2500, 1750, new int[] {1026, 1037}, null, 1, 96, 96, 2);

    /** Caulfield's Warhammer Definition */
    public static final RiotItemData CaulfieldsWarhammer = new RiotItemData("Caulfield's Warhammer", "Caulfield's Warhammer", 3133, 400, 1100, 770, new int[] {1036, 1036}, new int[] {3142, 1400, 1408, 1412, 3071, 3508, 3671, 3812}, 3, 336, 384, 2);

    /** Serrated Dirk Definition */
    public static final RiotItemData SerratedDirk = new RiotItemData("Serrated Dirk", "ブルータライザー", 3134, 400, 1100, 770, new int[] {1036, 1036}, new int[] {3142, 3156}, 1, 144, 96, 2);

    /** Void Staff Definition */
    public static final RiotItemData VoidStaff = new RiotItemData("Void Staff", "ヴォイドの杖", 3135, 1365, 2650, 1855, new int[] {1026, 1052}, null, 1, 192, 96, 2);

    /** Haunting Guise Definition */
    public static final RiotItemData HauntingGuise = new RiotItemData("Haunting Guise", "悲愴な仮面", 3136, 765, 1600, 1120, new int[] {1028, 1052}, new int[] {3151}, 1, 240, 96, 2);

    /** Dervish Blade Definition */
    public static final RiotItemData DervishBlade = new RiotItemData("Dervish Blade", "修道僧の刀", 3137, 200, 2700, 1890, new int[] {3140, 3101}, null, 1, 288, 96, 3);

    /** Mercurial Scimitar Definition */
    public static final RiotItemData MercurialScimitar = new RiotItemData("Mercurial Scimitar", "水銀の三日月刀", 3139, 625, 3700, 2590, new int[] {3140, 1037, 1053}, null, 1, 336, 96, 3);

    /** Quicksilver Sash Definition */
    public static final RiotItemData QuicksilverSash = new RiotItemData("Quicksilver Sash", "水銀の腰帯", 3140, 850, 1300, 910, new int[] {1033}, new int[] {3139, 3137}, 1, 384, 96, 2);

    /** Youmuu's Ghostblade Definition */
    public static final RiotItemData YoumuusGhostblade = new RiotItemData("Youmuu's Ghostblade", "妖夢の霊剣", 3142, 1000, 3200, 2240, new int[] {3133, 3134}, null, 1, 0, 144, 3);

    /** Randuin's Omen Definition */
    public static final RiotItemData RanduinsOmen = new RiotItemData("Randuin's Omen", "ランデュインの白盾", 3143, 900, 3000, 2100, new int[] {3082, 1011}, null, 1, 48, 144, 3);

    /** Bilgewater Cutlass Definition */
    public static final RiotItemData BilgewaterCutlass = new RiotItemData("Bilgewater Cutlass", "ビルジウォーターの海賊刀", 3144, 400, 1650, 1155, new int[] {1053, 1036}, new int[] {3146, 3153}, 1, 96, 144, 3);

    /** Hextech Revolver Definition */
    public static final RiotItemData HextechRevolver = new RiotItemData("Hextech Revolver", "ヘクステック・リボルバー", 3145, 330, 1200, 840, new int[] {1052, 1052}, new int[] {3146, 3152}, 1, 144, 144, 2);

    /** Hextech Gunblade Definition */
    public static final RiotItemData HextechGunblade = new RiotItemData("Hextech Gunblade", "ヘクステック・ガンブレード", 3146, 550, 3400, 2380, new int[] {3144, 3145}, null, 1, 192, 144, 4);

    /** Liandry's Torment Definition */
    public static final RiotItemData LiandrysTorment = new RiotItemData("Liandry's Torment", "ライアンドリーの苦悶", 3151, 750, 3200, 2240, new int[] {3136, 1026}, null, 1, 240, 144, 3);

    /** Will of the Ancients Definition */
    public static final RiotItemData WilloftheAncients = new RiotItemData("Will of the Ancients", "古代人の遺志", 3152, 300, 2300, 1610, new int[] {3145, 3108}, null, 1, 288, 144, 3);

    /** Blade of the Ruined King Definition */
    public static final RiotItemData BladeoftheRuinedKing = new RiotItemData("Blade of the Ruined King", "失墜の王剣", 3153, 750, 3400, 2380, new int[] {3144, 1043}, null, 1, 336, 144, 4);

    /** Hexdrinker Definition */
    public static final RiotItemData Hexdrinker = new RiotItemData("Hexdrinker", "呪飲の剣", 3155, 500, 1300, 910, new int[] {1036, 1033}, new int[] {3156}, 1, 432, 144, 2);

    /** Maw of Malmortius Definition */
    public static final RiotItemData MawofMalmortius = new RiotItemData("Maw of Malmortius", "マルモルティウスの胃袋", 3156, 850, 3250, 2275, new int[] {3155, 3134}, null, 1, 0, 192, 3);

    /** Zhonya's Hourglass Definition */
    public static final RiotItemData ZhonyasHourglass = new RiotItemData("Zhonya's Hourglass", "ゾーニャの砂時計", 3157, 1050, 3500, 2450, new int[] {3191, 1058}, null, 1, 48, 192, 3);

    /** Ionian Boots of Lucidity Definition */
    public static final RiotItemData IonianBootsofLucidity = new RiotItemData("Ionian Boots of Lucidity", "アイオニアブーツ", 3158, 500, 800, 560, new int[] {1001}, new int[] {1331, 1333, 1330, 1332, 1334}, 1, 96, 192, 2);

    /** Grez's Spectral Lantern Definition */
    public static final RiotItemData GrezsSpectralLantern = new RiotItemData("Grez's Spectral Lantern", "グレズの亡霊ランタン", 3159, 180, 1430, 572, new int[] {3106, 1036, 1042}, null, 1, 144, 192, 3);

    /** Morellonomicon Definition */
    public static final RiotItemData Morellonomicon = new RiotItemData("Morellonomicon", "モレロの死書", 3165, 765, 2550, 1785, new int[] {3108, 3114, 1052}, null, 1, 192, 192, 3);

    /** Moonflair Spellblade Definition */
    public static final RiotItemData MoonflairSpellblade = new RiotItemData("Moonflair Spellblade", "月啓の呪剣", 3170, 580, 2500, 1750, new int[] {3191, 1057}, null, 1, 432, 192, 3);

    /** Athene's Unholy Grail Definition */
    public static final RiotItemData AthenesUnholyGrail = new RiotItemData("Athene's Unholy Grail", "アテネの血杯", 3174, 565, 2800, 1960, new int[] {3108, 3028, 1052}, null, 1, 96, 240, 3);

    /** Odyn's Veil Definition */
    public static final RiotItemData OdynsVeil = new RiotItemData("Odyn's Veil", "オーディンのヴェール", 3180, 480, 2400, 1680, new int[] {1057, 3010}, null, 1, 192, 240, 3);

    /** Sanguine Blade Definition */
    public static final RiotItemData SanguineBlade = new RiotItemData("Sanguine Blade", "紅血の刃", 3181, 625, 2400, 1680, new int[] {1037, 1053}, null, 1, 240, 240, 3);

    /** Entropy Definition */
    public static final RiotItemData Entropy = new RiotItemData("Entropy", "エントロピー", 3184, 475, 2600, 1820, new int[] {3044, 1037}, null, 1, 288, 240, 3);

    /** The Lightbringer Definition */
    public static final RiotItemData TheLightbringer = new RiotItemData("The Lightbringer", "会心の弓", 3185, 350, 2350, 1645, new int[] {3122, 1018}, null, 1, 336, 240, 3);

    /** Hextech Sweeper Definition */
    public static final RiotItemData HextechSweeper = new RiotItemData("Hextech Sweeper", "ヘクステック・スイーパー", 3187, 350, 2150, 1505, new int[] {3024, 3067}, null, 1, 384, 240, 3);

    /** Locket of the Iron Solari Definition */
    public static final RiotItemData LocketoftheIronSolari = new RiotItemData("Locket of the Iron Solari", "ソラリのペンダント", 3190, 200, 2500, 1750, new int[] {3105, 3067}, null, 1, 432, 240, 4);

    /** Seeker's Armguard Definition */
    public static final RiotItemData SeekersArmguard = new RiotItemData("Seeker's Armguard", "探究者の腕甲", 3191, 465, 1200, 840, new int[] {1029, 1052}, new int[] {3090, 3157, 3170}, 1, 0, 288, 2);

    /** The Hex Core mk-1 Definition */
    public static final RiotItemData TheHexCoremk1 = new RiotItemData("The Hex Core mk-1", "ヘクスコアMK-1", 3196, 1000, 1000, 700, new int[] {3200}, new int[] {3197}, 1, 48, 288, 2);

    /** The Hex Core mk-2 Definition */
    public static final RiotItemData TheHexCoremk2 = new RiotItemData("The Hex Core mk-2", "ヘクスコアMK-2", 3197, 1000, 2000, 1400, new int[] {3196}, new int[] {3198}, 1, 96, 288, 3);

    /** Perfect Hex Core Definition */
    public static final RiotItemData PerfectHexCore = new RiotItemData("Perfect Hex Core", "究極のヘクスコア", 3198, 1000, 3000, 2100, new int[] {3197}, null, 1, 144, 288, 4);

    /** Prototype Hex Core Definition */
    public static final RiotItemData PrototypeHexCore = new RiotItemData("Prototype Hex Core", "プロトタイプ・ヘクスコア", 3200, 0, 0, 0, null, new int[] {3196}, 1, 192, 288, 0);

    /** Spectre's Cowl Definition */
    public static final RiotItemData SpectresCowl = new RiotItemData("Spectre's Cowl", "死霊の頭巾", 3211, 250, 1100, 770, new int[] {1028, 1033}, new int[] {3065, 3102}, 1, 240, 288, 2);

    /** Mikael's Crucible Definition */
    public static final RiotItemData MikaelsCrucible = new RiotItemData("Mikael's Crucible", "ミカエルのるつぼ", 3222, 750, 2300, 1610, new int[] {3028, 3114}, null, 1, 288, 288, 3);

    /** Enchantment: Furor Definition */
    public static final RiotItemData EnchantmentFuror = new RiotItemData("Enchantment: Furor", "追加特性: 憤怒", 3240, 450, 450, 315, null, null, 3, 240, 0, 0);

    /** Enchantment: Alacrity Definition */
    public static final RiotItemData EnchantmentAlacrity = new RiotItemData("Enchantment: Alacrity", "追加特性: 疾風", 3241, 450, 450, 315, null, null, 3, 288, 0, 0);

    /** Enchantment: Captain Definition */
    public static final RiotItemData EnchantmentCaptain = new RiotItemData("Enchantment: Captain", "追加特性: 隊長", 3242, 450, 450, 315, null, null, 3, 336, 0, 0);

    /** Enchantment: Distortion Definition */
    public static final RiotItemData EnchantmentDistortion = new RiotItemData("Enchantment: Distortion", "追加特性: 時空歪曲", 3243, 450, 450, 315, null, null, 3, 384, 0, 0);

    /** Enchantment: Homeguard Definition */
    public static final RiotItemData EnchantmentHomeguard = new RiotItemData("Enchantment: Homeguard", "追加特性: 防衛", 3244, 450, 450, 315, null, null, 3, 432, 0, 0);

    /** Luden's Echo Definition */
    public static final RiotItemData LudensEcho = new RiotItemData("Luden's Echo", "ルーデンの共鳴", 3285, 1100, 3200, 2240, new int[] {1058, 3113}, null, 2, 288, 288, 3);

    /** Ancient Coin Definition */
    public static final RiotItemData AncientCoin = new RiotItemData("Ancient Coin", "いにしえのコイン", 3301, 350, 350, 140, null, new int[] {3096}, 2, 144, 0, 0);

    /** Relic Shield Definition */
    public static final RiotItemData RelicShield = new RiotItemData("Relic Shield", "遺宝の盾", 3302, 350, 350, 140, null, new int[] {3097}, 2, 192, 0, 0);

    /** Spellthief's Edge Definition */
    public static final RiotItemData SpellthiefsEdge = new RiotItemData("Spellthief's Edge", "スペルシーフ・エッジ", 3303, 350, 350, 140, null, new int[] {3098}, 2, 240, 0, 0);

    /** Warding Totem (Trinket) Definition */
    public static final RiotItemData WardingTotemTrinket = new RiotItemData("Warding Totem (Trinket)", "守護のトーテム", 3340, 0, 0, 0, null, null, 2, 288, 0, 0);

    /** Sweeping Lens (Trinket) Definition */
    public static final RiotItemData SweepingLensTrinket = new RiotItemData("Sweeping Lens (Trinket)", "検視のレンズ", 3341, 0, 0, 0, null, null, 2, 336, 0, 0);

    /** Soul Anchor (Trinket) Definition */
    public static final RiotItemData SoulAnchorTrinket = new RiotItemData("Soul Anchor (Trinket)", "魂の綱(アクセサリー)", 3345, 0, 0, 0, null, null, 2, 432, 0, 0);

    /** Greater Stealth Totem (Trinket) Definition */
    public static final RiotItemData GreaterStealthTotemTrinket = new RiotItemData("Greater Stealth Totem (Trinket)", "隠密のトーテム", 3361, 250, 250, 175, null, null, 2, 0, 48, 0);

    /** Greater Vision Totem (Trinket) Definition */
    public static final RiotItemData GreaterVisionTotemTrinket = new RiotItemData("Greater Vision Totem (Trinket)", "発見のトーテム", 3362, 250, 250, 175, null, null, 2, 48, 48, 0);

    /** Farsight Alteration Definition */
    public static final RiotItemData FarsightAlteration = new RiotItemData("Farsight Alteration", "天眼のオーブ", 3363, 0, 0, 0, null, null, 2, 96, 48, 0);

    /** Oracle Alteration Definition */
    public static final RiotItemData OracleAlteration = new RiotItemData("Oracle Alteration", "看破のレンズ", 3364, 0, 0, 0, null, null, 2, 144, 48, 0);

    /** Face of the Mountain Definition */
    public static final RiotItemData FaceoftheMountain = new RiotItemData("Face of the Mountain", "山の相貌", 3401, 550, 2200, 880, new int[] {3097, 3067}, null, 2, 192, 48, 3);

    /** Golden Transcendence Definition */
    public static final RiotItemData GoldenTranscendence = new RiotItemData("Golden Transcendence", "黄金の超越", 3460, 0, 0, 0, null, null, 2, 432, 144, 0);

    /** Ardent Censer Definition */
    public static final RiotItemData ArdentCenser = new RiotItemData("Ardent Censer", "情愛の香炉", 3504, 800, 2200, 1540, new int[] {3114, 3113}, null, 2, 0, 192, 3);

    /** Essence Reaver Definition */
    public static final RiotItemData EssenceReaver = new RiotItemData("Essence Reaver", "霊奪刃", 3508, 400, 3600, 2520, new int[] {1038, 3133, 1018}, null, 2, 48, 192, 3);

    /** Zz'Rot Portal Definition */
    public static final RiotItemData ZzRotPortal = new RiotItemData("Zz'Rot Portal", "ジ＝ロット・ポータル", 3512, 780, 2700, 1890, new int[] {2053, 1057}, null, 2, 96, 192, 4);

    /** The Black Spear Definition */
    public static final RiotItemData TheBlackSpear = new RiotItemData("The Black Spear", "復讐の槍", 3599, 0, 0, 0, null, null, 2, 144, 192, 0);

    /** Enchantment: Warrior Definition */
    public static final RiotItemData CaulfieldsWarhammerWarrior = new RiotItemData("Caulfield's Warhammer [Warrior]", "Caulfield's Warhammer [Warrior]", 3671, 475, 1575, 1103, new int[] {3133}, null, 3, 384, 384, 3);

    /** Enchantment: Cinderhulk Definition */
    public static final RiotItemData BamisCinderCinderhulk = new RiotItemData("Bami's Cinder [Cinderhulk]", "バミの残り火 [Cinderhulk]", 3672, 475, 1575, 1103, new int[] {3751}, null, 3, 432, 384, 3);

    /** Enchantment: Runeglaive Definition */
    public static final RiotItemData AmplifyingTomeRuneglaive = new RiotItemData("Amplifying Tome [Runeglaive]", "増魔の書 [Runeglaive]", 3673, 140, 1625, 1138, new int[] {3057, 1052}, null, 3, 0, 432, 3);

    /** Enchantment: Devourer Definition */
    public static final RiotItemData RecurveBowDevourer = new RiotItemData("Recurve Bow [Devourer]", "速射の弓 [Devourer]", 3674, 400, 1400, 980, new int[] {1043}, null, 3, 48, 432, 3);

    /** Stalker's Blade Definition */
    public static final RiotItemData StalkersBlade = new RiotItemData("Stalker's Blade", "追跡の鋭刃", 3706, 350, 1050, 735, new int[] {1039, 1041}, new int[] {1400, 1401, 1402, 1403}, 2, 192, 192, 2);

    /** Tracker's Knife Definition */
    public static final RiotItemData TrackersKnife = new RiotItemData("Tracker's Knife", "略奪の短剣", 3711, 350, 1050, 735, new int[] {1039, 1041}, new int[] {1408, 1409, 1410, 1411}, 2, 432, 192, 2);

    /** Skirmisher's Sabre Definition */
    public static final RiotItemData SkirmishersSabre = new RiotItemData("Skirmisher's Sabre", "一騎のサーベル", 3715, 350, 1050, 735, new int[] {1039, 1041}, new int[] {1412, 1413, 1414, 1415}, 2, 96, 240, 2);

    /** Dead Man's Plate Definition */
    public static final RiotItemData DeadMansPlate = new RiotItemData("Dead Man's Plate", "死人の皿", 3742, 1000, 2800, 1960, new int[] {1031, 1011}, null, 3, 48, 192, 3);

    /** Staff of Flowing Water Definition */
    public static final RiotItemData StaffofFlowingWater = new RiotItemData("Staff of Flowing Water", "流水の杖", 3744, 300, 1735, 1215, new int[] {3028, 1052}, null, 3, 96, 192, 3);

    /** Titanic Hydra Definition */
    public static final RiotItemData TitanicHydra = new RiotItemData("Titanic Hydra", "タイタンのハイドラ(近接専用)", 3748, 750, 3600, 2520, new int[] {3077, 1028, 3052}, null, 3, 192, 240, 3);

    /** Bami's Cinder Definition */
    public static final RiotItemData BamisCinder = new RiotItemData("Bami's Cinder", "バミの残り火", 3751, 700, 1100, 770, new int[] {1028}, new int[] {3068, 3717, 3725, 1401, 1409, 1413, 3672}, 2, 336, 288, 2);

    /** Righteous Glory Definition */
    public static final RiotItemData RighteousGlory = new RiotItemData("Righteous Glory", "正義の栄光", 3800, 750, 2600, 1820, new int[] {3010, 3801}, null, 2, 192, 288, 3);

    /** Crystalline Bracer Definition */
    public static final RiotItemData CrystallineBracer = new RiotItemData("Crystalline Bracer", "クリスタルの籠手", 3801, 100, 650, 455, new int[] {1028, 1006}, new int[] {3105, 3083, 3084, 3102, 3800}, 2, 240, 288, 2);

    /** Death's Dance Definition */
    public static final RiotItemData DeathsDance = new RiotItemData("Death's Dance", "Death's Dance", 3812, 525, 3400, 2380, new int[] {1053, 1037, 3133}, null, 3, 96, 432, 3);

    /** Fire at Will Definition */
    public static final RiotItemData FireatWill = new RiotItemData("Fire at Will", "乱れ撃ち", 3901, 0, 0, 0, null, null, 3, 384, 192, 0);

    /** Death's Daughter Definition */
    public static final RiotItemData DeathsDaughter = new RiotItemData("Death's Daughter", "死の女神", 3902, 0, 0, 0, null, null, 3, 432, 192, 0);

    /** Raise Morale Definition */
    public static final RiotItemData RaiseMorale = new RiotItemData("Raise Morale", "士気上昇", 3903, 0, 0, 0, null, null, 3, 0, 240, 0);

    /** Enchantment: Sated Devourer Definition */
    public static final RiotItemData StalkersBladeSatedDevourer = new RiotItemData("Stalker's Blade [Sated Devourer]", "追跡の鋭刃 [Devourer] [満たされた食欲]", 3930, 2250, 2250, 3290, new int[] {1403}, null, 3, 0, 48, 4);

    /** Enchantment: Sated Devourer Definition */
    public static final RiotItemData SkirmishersSabreSatedDevourer = new RiotItemData("Skirmisher's Sabre [Sated Devourer]", "一騎のサーベル [Devourer] [満たされた食欲]", 3931, 2250, 2250, 3290, new int[] {1415}, null, 3, 48, 48, 4);

    /** Enchantment: Sated Devourer Definition */
    public static final RiotItemData TrackersKnifeSatedDevourer = new RiotItemData("Tracker's Knife [Sated Devourer]", "略奪の短剣 [Devourer] [満たされた食欲]", 3932, 2250, 2250, 3290, new int[] {1411}, null, 3, 96, 48, 4);

    /** Item status. */
    public final String name;

    /** Item status. */
    public final String localizedName;

    /** Item status. */
    public final int id;

    /** Item status. */
    public final int buyBase;

    /** Item status. */
    public final int buyTotal;

    /** Item status. */
    public final int sell;

    /** Item status. */
    public final int[] from;

    /** Item status. */
    public final int[] to;

    /** Item status. */
    public final int imageNo;

    /** Item status. */
    public final int imageX;

    /** Item status. */
    public final int imageY;

    /** Item status. */
    public final int depth;

    /**
     * The item definition.
     */
    private RiotItemData(String name, String localizedName, int id, int buyBase, int buyTotal, int sell, int[] from, int[] to, int imageNo, int imageX, int imageY, int depth) {
        this.name = name;
        this.localizedName = localizedName;
        this.id = id;
        this.buyBase = buyBase;
        this.buyTotal = buyTotal;
        this.sell = sell;
        this.from = from;
        this.to = to;
        this.imageNo = imageNo;
        this.imageX = imageX;
        this.imageY = imageY;
        this.depth = depth;
    }
}
