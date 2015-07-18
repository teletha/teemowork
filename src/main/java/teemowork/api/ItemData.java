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

public enum ItemData {

    /** Boots of Speed Definition */
    BootsofSpeed("Boots of Speed", "ブーツ", 1001, 325, 325, 227),

    /** Faerie Charm Definition */
    FaerieCharm("Faerie Charm", "妖精の魔除け", 1004, 180, 180, 126),

    /** Rejuvenation Bead Definition */
    RejuvenationBead("Rejuvenation Bead", "再生の珠", 1006, 180, 180, 126),

    /** Giant's Belt Definition */
    GiantsBelt("Giant's Belt", "巨人のベルト", 1011, 600, 1000, 700),

    /** Cloak of Agility Definition */
    CloakofAgility("Cloak of Agility", "敏捷のマント", 1018, 730, 730, 511),

    /** Blasting Wand Definition */
    BlastingWand("Blasting Wand", "破裂の杖", 1026, 850, 850, 595),

    /** Sapphire Crystal Definition */
    SapphireCrystal("Sapphire Crystal", "サファイアクリスタル", 1027, 400, 400, 280),

    /** Ruby Crystal Definition */
    RubyCrystal("Ruby Crystal", "ルビークリスタル", 1028, 400, 400, 280),

    /** Cloth Armor Definition */
    ClothArmor("Cloth Armor", "布の鎧", 1029, 300, 300, 210),

    /** Chain Vest Definition */
    ChainVest("Chain Vest", "チェインベスト", 1031, 450, 750, 525),

    /** Null-Magic Mantle Definition */
    NullMagicMantle("Null-Magic Mantle", "抗魔のマント", 1033, 500, 500, 350),

    /** Long Sword Definition */
    LongSword("Long Sword", "ロングソード", 1036, 360, 360, 252),

    /** Pickaxe Definition */
    Pickaxe("Pickaxe", "ツルハシ", 1037, 875, 875, 613),

    /** B. F. Sword Definition */
    BFSword("B. F. Sword", "B. F. ソード", 1038, 1550, 1550, 1085),

    /** Hunter's Machete Definition */
    HuntersMachete("Hunter's Machete", "狩人の山刀", 1039, 400, 400, 280),

    /** Dagger Definition */
    Dagger("Dagger", "ダガー", 1042, 450, 450, 315),

    /** Recurve Bow Definition */
    RecurveBow("Recurve Bow", "速射の弓", 1043, 200, 1100, 770),

    /** Brawler's Gloves Definition */
    BrawlersGloves("Brawler's Gloves", "喧嘩屋の手袋", 1051, 400, 400, 280),

    /** Amplifying Tome Definition */
    AmplifyingTome("Amplifying Tome", "増魔の書", 1052, 435, 435, 305),

    /** Vampiric Scepter Definition */
    VampiricScepter("Vampiric Scepter", "吸血の権杖", 1053, 440, 800, 560),

    /** Doran's Shield Definition */
    DoransShield("Doran's Shield", "ドランの盾", 1054, 440, 440, 176),

    /** Doran's Blade Definition */
    DoransBlade("Doran's Blade", "ドランの剣", 1055, 440, 440, 176),

    /** Doran's Ring Definition */
    DoransRing("Doran's Ring", "ドランの指輪", 1056, 400, 400, 160),

    /** Negatron Cloak Definition */
    NegatronCloak("Negatron Cloak", "封魔のマント", 1057, 350, 850, 595),

    /** Needlessly Large Rod Definition */
    NeedlesslyLargeRod("Needlessly Large Rod", "ムダニデカイ・ロッド", 1058, 1250, 1250, 875),

    /** Enchantment: Furor Definition */
    BerserkersGreavesEnchantmentFuror("Berserker's Greaves Enchantment: Furor", "バーサーカーのブーツ 追加特性: 憤怒", 1300, 475, 1475, 1033),

    /** Enchantment: Alacrity Definition */
    BerserkersGreavesEnchantmentAlacrity("Berserker's Greaves Enchantment: Alacrity", "バーサーカーのブーツ 追加特性: 疾風", 1301, 475, 1475, 1033),

    /** Enchantment: Captain Definition */
    BerserkersGreavesEnchantmentCaptain("Berserker's Greaves Enchantment: Captain", "バーサーカーのブーツ 追加特性：隊長", 1302, 600, 1600, 1120),

    /** Enchantment: Distortion Definition */
    BerserkersGreavesEnchantmentDistortion("Berserker's Greaves Enchantment: Distortion", "バーサーカーのブーツ 追加特性: 時空歪曲", 1303, 475, 1475, 1033),

    /** Enchantment: Homeguard Definition */
    BerserkersGreavesEnchantmentHomeguard("Berserker's Greaves Enchantment: Homeguard", "バーサーカーのブーツ 追加特性: 防衛", 1304, 475, 1475, 1033),

    /** Enchantment: Furor Definition */
    BootsofSwiftnessEnchantmentFuror("Boots of Swiftness Enchantment: Furor", "迅速のブーツ 追加特性: 憤怒", 1305, 475, 1475, 1033),

    /** Enchantment: Alacrity Definition */
    BootsofSwiftnessEnchantmentAlacrity("Boots of Swiftness Enchantment: Alacrity", "迅速のブーツ 追加特性: 疾風", 1306, 475, 1475, 1033),

    /** Enchantment: Captain Definition */
    BootsofSwiftnessEnchantmentCaptain("Boots of Swiftness Enchantment: Captain", "迅速のブーツ 追加特性：隊長", 1307, 600, 1600, 1120),

    /** Enchantment: Distortion Definition */
    BootsofSwiftnessEnchantmentDistortion("Boots of Swiftness Enchantment: Distortion", "迅速のブーツ 追加特性: 時空歪曲", 1308, 475, 1475, 1033),

    /** Enchantment: Homeguard Definition */
    BootsofSwiftnessEnchantmentHomeguard("Boots of Swiftness Enchantment: Homeguard", "迅速のブーツ 追加特性: 防衛", 1309, 475, 1475, 1033),

    /** Enchantment: Furor Definition */
    SorcerersShoesEnchantmentFuror("Sorcerer's Shoes Enchantment: Furor", "魔道士の靴 追加特性: 憤怒", 1310, 475, 1575, 1103),

    /** Enchantment: Alacrity Definition */
    SorcerersShoesEnchantmentAlacrity("Sorcerer's Shoes Enchantment: Alacrity", "魔道士の靴 追加特性: 疾風", 1311, 475, 1575, 1103),

    /** Enchantment: Captain Definition */
    SorcerersShoesEnchantmentCaptain("Sorcerer's Shoes Enchantment: Captain", "魔道士の靴 追加特性：隊長", 1312, 600, 1700, 1190),

    /** Enchantment: Distortion Definition */
    SorcerersShoesEnchantmentDistortion("Sorcerer's Shoes Enchantment: Distortion", "魔道士の靴 追加特性: 時空歪曲", 1313, 475, 1575, 1103),

    /** Enchantment: Homeguard Definition */
    SorcerersShoesEnchantmentHomeguard("Sorcerer's Shoes Enchantment: Homeguard", "魔道士の靴 追加特性: 防衛", 1314, 475, 1575, 1103),

    /** Enchantment: Furor Definition */
    NinjaTabiEnchantmentFuror("Ninja Tabi Enchantment: Furor", "忍者足袋 追加特性: 憤怒", 1315, 475, 1475, 1033),

    /** Enchantment: Alacrity Definition */
    NinjaTabiEnchantmentAlacrity("Ninja Tabi Enchantment: Alacrity", "忍者足袋 追加特性: 疾風", 1316, 475, 1475, 1033),

    /** Enchantment: Captain Definition */
    NinjaTabiEnchantmentCaptain("Ninja Tabi Enchantment: Captain", "忍者足袋 追加特性：隊長", 1317, 600, 1600, 1120),

    /** Enchantment: Distortion Definition */
    NinjaTabiEnchantmentDistortion("Ninja Tabi Enchantment: Distortion", "忍者足袋 追加特性: 時空歪曲", 1318, 475, 1475, 1033),

    /** Enchantment: Homeguard Definition */
    NinjaTabiEnchantmentHomeguard("Ninja Tabi Enchantment: Homeguard", "忍者足袋 追加特性: 防衛", 1319, 475, 1475, 1033),

    /** Enchantment: Furor Definition */
    MercurysTreadsEnchantmentFuror("Mercury's Treads Enchantment: Furor", "マーキュリーの靴 追加特性: 憤怒", 1320, 475, 1675, 1173),

    /** Enchantment: Alacrity Definition */
    MercurysTreadsEnchantmentAlacrity("Mercury's Treads Enchantment: Alacrity", "マーキュリーの靴 追加特性: 疾風", 1321, 475, 1675, 1173),

    /** Enchantment: Captain Definition */
    MercurysTreadsEnchantmentCaptain("Mercury's Treads Enchantment: Captain", "マーキュリーの靴 追加特性：隊長", 1322, 600, 1800, 1260),

    /** Enchantment: Distortion Definition */
    MercurysTreadsEnchantmentDistortion("Mercury's Treads Enchantment: Distortion", "マーキュリーの靴 追加特性: 時空歪曲", 1323, 475, 1675, 1173),

    /** Enchantment: Homeguard Definition */
    MercurysTreadsEnchantmentHomeguard("Mercury's Treads Enchantment: Homeguard", "マーキュリーの靴 追加特性: 防衛", 1324, 475, 1675, 1173),

    /** Enchantment: Furor Definition */
    BootsofMobilityEnchantmentFuror("Boots of Mobility Enchantment: Furor", "踏破のブーツ 追加特性: 憤怒", 1325, 475, 1275, 893),

    /** Enchantment: Alacrity Definition */
    BootsofMobilityEnchantmentAlacrity("Boots of Mobility Enchantment: Alacrity", "踏破のブーツ 追加特性: 疾風", 1326, 475, 1275, 893),

    /** Enchantment: Captain Definition */
    BootsofMobilityEnchantmentCaptain("Boots of Mobility Enchantment: Captain", "踏破のブーツ 追加特性：隊長", 1327, 600, 1400, 980),

    /** Enchantment: Distortion Definition */
    BootsofMobilityEnchantmentDistortion("Boots of Mobility Enchantment: Distortion", "踏破のブーツ 追加特性: 時空歪曲", 1328, 475, 1275, 893),

    /** Enchantment: Homeguard Definition */
    BootsofMobilityEnchantmentHomeguard("Boots of Mobility Enchantment: Homeguard", "踏破のブーツ 追加特性: 防衛", 1329, 475, 1275, 893),

    /** Enchantment: Furor Definition */
    IonianBootsofLucidityEnchantmentFuror("Ionian Boots of Lucidity Enchantment: Furor", "アイオニアブーツ 追加特性: 憤怒", 1330, 475, 1475, 1033),

    /** Enchantment: Alacrity Definition */
    IonianBootsofLucidityEnchantmentAlacrity("Ionian Boots of Lucidity Enchantment: Alacrity", "アイオニアブーツ 追加特性: 疾風", 1331, 475, 1475, 1033),

    /** Enchantment: Captain Definition */
    IonianBootsofLucidityEnchantmentCaptain("Ionian Boots of Lucidity Enchantment: Captain", "アイオニアブーツ 追加特性：隊長", 1332, 600, 1600, 1120),

    /** Enchantment: Distortion Definition */
    IonianBootsofLucidityEnchantmentDistortion("Ionian Boots of Lucidity Enchantment: Distortion", "アイオニアブーツ 追加特性: 時空歪曲", 1333, 475, 1475, 1033),

    /** Enchantment: Homeguard Definition */
    IonianBootsofLucidityEnchantmentHomeguard("Ionian Boots of Lucidity Enchantment: Homeguard", "アイオニアブーツ 追加特性: 防衛", 1334, 475, 1475, 1033),

    /** Health Potion Definition */
    HealthPotion("Health Potion", "ライフポーション", 2003, 35, 35, 14),

    /** Mana Potion Definition */
    ManaPotion("Mana Potion", "マナポーション", 2004, 35, 35, 14),

    /** Total Biscuit of Rejuvenation Definition */
    TotalBiscuitofRejuvenation("Total Biscuit of Rejuvenation", "栄養満点ビスケット", 2010, 35, 35, 14),

    /** Crystalline Flask Definition */
    CrystallineFlask("Crystalline Flask", "クリスタル・フラスコ", 2041, 345, 345, 138),

    /** Vision Ward Definition */
    VisionWard("Vision Ward", "ビジョンワード", 2043, 100, 100, 40),

    /** Stealth Ward Definition */
    StealthWard("Stealth Ward", "ステルスワード", 2044, 75, 75, 30),

    /** Ruby Sightstone Definition */
    RubySightstone("Ruby Sightstone", "ルビー・サイトストーン", 2045, 400, 1600, 640),

    /** Sightstone Definition */
    Sightstone("Sightstone", "サイトストーン", 2049, 400, 800, 320),

    /** Explorer's Ward Definition */
    ExplorersWard("Explorer's Ward", "探検家のワード", 2050, 0, 0, 0),

    /** Poro-Snax Definition */
    PoroSnax("Poro-Snax", "ポロのおやつ", 2052, 0, 0, 0),

    /** Raptor Cloak Definition */
    RaptorCloak("Raptor Cloak", "ラプターのマント", 2053, 520, 1000, 700),

    /** Diet Poro-Snax Definition */
    DietPoroSnax("Diet Poro-Snax", "ポロのヘルシーおやつ", 2054, 0, 0, 0),

    /** Elixir of Ruin Definition */
    ElixirofRuin("Elixir of Ruin", "破滅のエリクサー", 2137, 400, 400, 160),

    /** Elixir of Iron Definition */
    ElixirofIron("Elixir of Iron", "巨躯のエリクサー", 2138, 400, 400, 160),

    /** Elixir of Sorcery Definition */
    ElixirofSorcery("Elixir of Sorcery", "聡明のエリクサー", 2139, 400, 400, 160),

    /** Elixir of Wrath Definition */
    ElixirofWrath("Elixir of Wrath", "憤怒のエリクサー", 2140, 400, 400, 160),

    /** Abyssal Scepter Definition */
    AbyssalScepter("Abyssal Scepter", "深淵の権杖", 3001, 730, 2430, 1701),

    /** Archangel's Staff Definition */
    ArchangelsStaff("Archangel's Staff", "大天使の杖", 3003, 1030, 3000, 2100),

    /** Manamune Definition */
    Manamune("Manamune", "マナ・ムネ", 3004, 605, 2200, 1540),

    /** Berserker's Greaves Definition */
    BerserkersGreaves("Berserker's Greaves", "バーサーカーのブーツ", 3006, 225, 1000, 700),

    /** Boots of Swiftness Definition */
    BootsofSwiftness("Boots of Swiftness", "迅速のブーツ", 3009, 675, 1000, 700),

    /** Catalyst the Protector Definition */
    CatalysttheProtector("Catalyst the Protector", "守護の触媒", 3010, 400, 1200, 840),

    /** Sorcerer's Shoes Definition */
    SorcerersShoes("Sorcerer's Shoes", "魔道士の靴", 3020, 775, 1100, 770),

    /** Frozen Mallet Definition */
    FrozenMallet("Frozen Mallet", "氷結の大槌", 3022, 1025, 3300, 2310),

    /** Twin Shadows Definition */
    TwinShadows("Twin Shadows", "双子の亡霊", 3023, 730, 2400, 1680),

    /** Glacial Shroud Definition */
    GlacialShroud("Glacial Shroud", "氷河の盾", 3024, 250, 950, 665),

    /** Iceborn Gauntlet Definition */
    IcebornGauntlet("Iceborn Gauntlet", "アイスボーンの籠手", 3025, 750, 2900, 2030),

    /** Guardian Angel Definition */
    GuardianAngel("Guardian Angel", "守護天使の鎧", 3026, 1200, 2800, 1120),

    /** Rod of Ages Definition */
    RodofAges("Rod of Ages", "歳月の杖", 3027, 650, 2700, 1890),

    /** Chalice of Harmony Definition */
    ChaliceofHarmony("Chalice of Harmony", "調和の聖杯", 3028, 40, 900, 630),

    /** Infinity Edge Definition */
    InfinityEdge("Infinity Edge", "無限の神剣", 3031, 645, 3800, 2660),

    /** Last Whisper Definition */
    LastWhisper("Last Whisper", "終焉の弓", 3035, 1065, 2300, 1610),

    /** Seraph's Embrace Definition */
    SeraphsEmbrace("Seraph's Embrace", "熾天使の抱擁", 3040, 3000, 3000, 4200),

    /** Mejai's Soulstealer Definition */
    MejaisSoulstealer("Mejai's Soulstealer", "メジャイの魔本", 3041, 965, 1400, 980),

    /** Muramana Definition */
    Muramana("Muramana", "ムラ・マナ", 3042, 2200, 2200, 3080),

    /** Phage Definition */
    Phage("Phage", "ファージ", 3044, 565, 1325, 927),

    /** Phantom Dancer Definition */
    PhantomDancer("Phantom Dancer", "幻影の踊り手", 3046, 520, 2800, 1960),

    /** Ninja Tabi Definition */
    NinjaTabi("Ninja Tabi", "忍者足袋", 3047, 375, 1000, 700),

    /** Zeke's Herald Definition */
    ZekesHerald("Zeke's Herald", "ジークの使者", 3050, 800, 2450, 1715),

    /** Ohmwrecker Definition */
    Ohmwrecker("Ohmwrecker", "撹乱石", 3056, 750, 2600, 1820),

    /** Sheen Definition */
    Sheen("Sheen", "シーン", 3057, 365, 1200, 840),

    /** Banner of Command Definition */
    BannerofCommand("Banner of Command", "統率の旗", 3060, 280, 3000, 2100),

    /** Spirit Visage Definition */
    SpiritVisage("Spirit Visage", "精霊の鎧", 3065, 700, 2750, 1925),

    /** Kindlegem Definition */
    Kindlegem("Kindlegem", "点火石", 3067, 450, 850, 595),

    /** Sunfire Cape Definition */
    SunfireCape("Sunfire Cape", "灼熱の鎧", 3068, 850, 2600, 1820),

    /** Talisman of Ascension Definition */
    TalismanofAscension("Talisman of Ascension", "超越の護符", 3069, 635, 2100, 840),

    /** Tear of the Goddess Definition */
    TearoftheGoddess("Tear of the Goddess", "女神の涙", 3070, 140, 720, 504),

    /** The Black Cleaver Definition */
    TheBlackCleaver("The Black Cleaver", "撃滅の黒斧", 3071, 825, 3000, 2100),

    /** The Bloodthirster Definition */
    TheBloodthirster("The Bloodthirster", "渇望の血剣", 3072, 1150, 3500, 2450),

    /** Ravenous Hydra (Melee Only) Definition */
    RavenousHydraMeleeOnly("Ravenous Hydra (Melee Only)", "餓えしハイドラ(近接専用)", 3074, 600, 3300, 2310),

    /** Thornmail Definition */
    Thornmail("Thornmail", "茨の鎧", 3075, 1050, 2100, 1470),

    /** Tiamat (Melee Only) Definition */
    TiamatMeleeOnly("Tiamat (Melee Only)", "ティアマット（近接専用）", 3077, 305, 1900, 1330),

    /** Trinity Force Definition */
    TrinityForce("Trinity Force", "トリニティ・フォース", 3078, 78, 3703, 2592),

    /** Warden's Mail Definition */
    WardensMail("Warden's Mail", "番人の鎧", 3082, 450, 1050, 735),

    /** Warmog's Armor Definition */
    WarmogsArmor("Warmog's Armor", "ワーモグの鎧", 3083, 300, 2500, 1750),

    /** Runaan's Hurricane (Ranged Only) Definition */
    RunaansHurricaneRangedOnly("Runaan's Hurricane (Ranged Only)", "ルナーンのハリケーン(遠隔専用)", 3085, 500, 2500, 1750),

    /** Zeal Definition */
    Zeal("Zeal", "ジール", 3086, 250, 1100, 770),

    /** Statikk Shiv Definition */
    StatikkShiv("Statikk Shiv", "雷剣", 3087, 600, 2500, 1750),

    /** Rabadon's Deathcap Definition */
    RabadonsDeathcap("Rabadon's Deathcap", "ラバドンの死の帽子", 3089, 965, 3500, 2450),

    /** Wit's End Definition */
    WitsEnd("Wit's End", "究極の答え", 3091, 550, 2600, 1820),

    /** Frost Queen's Claim Definition */
    FrostQueensClaim("Frost Queen's Claim", "女王の凍った指先", 3092, 515, 2200, 880),

    /** Avarice Blade Definition */
    AvariceBlade("Avarice Blade", "貪欲の刃", 3093, 400, 800, 320),

    /** Nomad's Medallion Definition */
    NomadsMedallion("Nomad's Medallion", "放浪民のメダル", 3096, 500, 865, 346),

    /** Targon's Brace Definition */
    TargonsBrace("Targon's Brace", "ターゴンの腕輪", 3097, 500, 865, 346),

    /** Frostfang Definition */
    Frostfang("Frostfang", "白霜の牙", 3098, 500, 865, 346),

    /** Lich Bane Definition */
    LichBane("Lich Bane", "死神殺しの双剣", 3100, 950, 3000, 2100),

    /** Stinger Definition */
    Stinger("Stinger", "刺剣", 3101, 350, 1250, 875),

    /** Banshee's Veil Definition */
    BansheesVeil("Banshee's Veil", "バンシーのヴェール", 3102, 1150, 2750, 1925),

    /** Aegis of the Legion Definition */
    AegisoftheLegion("Aegis of the Legion", "イージスの盾", 3105, 820, 1900, 1330),

    /** Madred's Razors Definition */
    MadredsRazors("Madred's Razors", "マッドレッドの鉤爪", 3106, 300, 750, 525),

    /** Fiendish Codex Definition */
    FiendishCodex("Fiendish Codex", "悪魔の古書", 3108, 385, 820, 574),

    /** Frozen Heart Definition */
    FrozenHeart("Frozen Heart", "凍れる心臓", 3110, 450, 2450, 1715),

    /** Mercury's Treads Definition */
    MercurysTreads("Mercury's Treads", "マーキュリーの靴", 3111, 375, 1200, 840),

    /** Aether Wisp Definition */
    AetherWisp("Aether Wisp", "鬼火", 3113, 415, 850, 595),

    /** Forbidden Idol Definition */
    ForbiddenIdol("Forbidden Idol", "禁じられた偶像", 3114, 240, 600, 420),

    /** Nashor's Tooth Definition */
    NashorsTooth("Nashor's Tooth", "ナッシャーの歯牙", 3115, 930, 3000, 2100),

    /** Rylai's Crystal Scepter Definition */
    RylaisCrystalScepter("Rylai's Crystal Scepter", "リーライのクリスタル権杖", 3116, 315, 3000, 2100),

    /** Boots of Mobility Definition */
    BootsofMobility("Boots of Mobility", "踏破のブーツ", 3117, 475, 800, 560),

    /** Guinsoo's Rageblade Definition */
    GuinsoosRageblade("Guinsoo's Rageblade", "グインソーの荒ぶる刃", 3124, 865, 2590, 1813),

    /** The Brutalizer Definition */
    TheBrutalizer("The Brutalizer", "ブルータライザー", 3134, 617, 1337, 936),

    /** Void Staff Definition */
    VoidStaff("Void Staff", "ヴォイドの杖", 3135, 1215, 2500, 1750),

    /** Haunting Guise Definition */
    HauntingGuise("Haunting Guise", "悲愴な仮面", 3136, 665, 1500, 1050),

    /** Mercurial Scimitar Definition */
    MercurialScimitar("Mercurial Scimitar", "水銀の三日月刀", 3139, 900, 3700, 2590),

    /** Quicksilver Sash Definition */
    QuicksilverSash("Quicksilver Sash", "水銀の腰帯", 3140, 750, 1250, 875),

    /** Sword of the Occult Definition */
    SwordoftheOccult("Sword of the Occult", "秘境の魔剣", 3141, 1040, 1400, 980),

    /** Youmuu's Ghostblade Definition */
    YoumuusGhostblade("Youmuu's Ghostblade", "妖夢の霊剣", 3142, 563, 2700, 1890),

    /** Randuin's Omen Definition */
    RanduinsOmen("Randuin's Omen", "ランデュインの白盾", 3143, 800, 2850, 1995),

    /** Bilgewater Cutlass Definition */
    BilgewaterCutlass("Bilgewater Cutlass", "ビルジウォーターの海賊刀", 3144, 240, 1400, 980),

    /** Hextech Revolver Definition */
    HextechRevolver("Hextech Revolver", "ヘクステック・リボルバー", 3145, 330, 1200, 840),

    /** Hextech Gunblade Definition */
    HextechGunblade("Hextech Gunblade", "ヘクステック・ガンブレード", 3146, 800, 3400, 2380),

    /** Liandry's Torment Definition */
    LiandrysTorment("Liandry's Torment", "ライアンドリーの苦悶", 3151, 650, 3000, 2100),

    /** Will of the Ancients Definition */
    WilloftheAncients("Will of the Ancients", "古代人の遺志", 3152, 480, 2500, 1750),

    /** Blade of the Ruined King Definition */
    BladeoftheRuinedKing("Blade of the Ruined King", "失墜の王剣", 3153, 700, 3200, 2240),

    /** Wriggle's Lantern Definition */
    WrigglesLantern("Wriggle's Lantern", "リグルのランタン", 3154, 215, 1775, 710),

    /** Hexdrinker Definition */
    Hexdrinker("Hexdrinker", "呪飲の剣", 3155, 590, 1450, 1015),

    /** Maw of Malmortius Definition */
    MawofMalmortius("Maw of Malmortius", "マルモルティウスの胃袋", 3156, 875, 3200, 2240),

    /** Zhonya's Hourglass Definition */
    ZhonyasHourglass("Zhonya's Hourglass", "ゾーニャの砂時計", 3157, 550, 3000, 2100),

    /** Ionian Boots of Lucidity Definition */
    IonianBootsofLucidity("Ionian Boots of Lucidity", "アイオニアブーツ", 3158, 675, 1000, 700),

    /** Morellonomicon Definition */
    Morellonomicon("Morellonomicon", "モレロの死書", 3165, 445, 2300, 1610),

    /** Zephyr Definition */
    Zephyr("Zephyr", "ゼピュロス", 3172, 725, 2850, 1995),

    /** Athene's Unholy Grail Definition */
    AthenesUnholyGrail("Athene's Unholy Grail", "アテネの血杯", 3174, 545, 2700, 1890),

    /** Locket of the Iron Solari Definition */
    LocketoftheIronSolari("Locket of the Iron Solari", "ソラリのペンダント", 3190, 50, 2800, 1960),

    /** Seeker's Armguard Definition */
    SeekersArmguard("Seeker's Armguard", "探究者の腕甲", 3191, 465, 1200, 840),

    /** The Hex Core mk-1 Definition */
    TheHexCoremk1("The Hex Core mk-1", "ヘクスコアMK-1", 3196, 1000, 1000, 700),

    /** The Hex Core mk-2 Definition */
    TheHexCoremk2("The Hex Core mk-2", "ヘクスコアMK-2", 3197, 1000, 2000, 1400),

    /** Perfect Hex Core Definition */
    PerfectHexCore("Perfect Hex Core", "究極のヘクスコア", 3198, 1000, 3000, 2100),

    /** Prototype Hex Core Definition */
    PrototypeHexCore("Prototype Hex Core", "プロトタイプ・ヘクスコア", 3200, 0, 0, 0),

    /** Spectre's Cowl Definition */
    SpectresCowl("Spectre's Cowl", "死霊の頭巾", 3211, 300, 1200, 840),

    /** Mikael's Crucible Definition */
    MikaelsCrucible("Mikael's Crucible", "ミカエルのるつぼ", 3222, 950, 2450, 1715),

    /** Enchantment: Furor Definition */
    EnchantmentFuror("Enchantment: Furor", "追加特性: 憤怒", 3240, 475, 475, 333),

    /** Enchantment: Alacrity Definition */
    EnchantmentAlacrity("Enchantment: Alacrity", "追加特性: 疾風", 3241, 475, 475, 333),

    /** Enchantment: Captain Definition */
    EnchantmentCaptain("Enchantment: Captain", "追加特性：隊長", 3242, 600, 600, 420),

    /** Enchantment: Distortion Definition */
    EnchantmentDistortion("Enchantment: Distortion", "追加特性: 時空歪曲", 3243, 475, 475, 333),

    /** Enchantment: Homeguard Definition */
    EnchantmentHomeguard("Enchantment: Homeguard", "追加特性: 防衛", 3244, 475, 475, 333),

    /** Luden's Echo Definition */
    LudensEcho("Luden's Echo", "ルーデンの共鳴", 3285, 900, 3000, 2100),

    /** Ancient Coin Definition */
    AncientCoin("Ancient Coin", "いにしえのコイン", 3301, 365, 365, 146),

    /** Relic Shield Definition */
    RelicShield("Relic Shield", "遺宝の盾", 3302, 365, 365, 146),

    /** Spellthief's Edge Definition */
    SpellthiefsEdge("Spellthief's Edge", "スペルシーフ・エッジ", 3303, 365, 365, 146),

    /** Warding Totem (Trinket) Definition */
    WardingTotemTrinket("Warding Totem (Trinket)", "守護のトーテム", 3340, 0, 0, 0),

    /** Sweeping Lens (Trinket) Definition */
    SweepingLensTrinket("Sweeping Lens (Trinket)", "検視のレンズ", 3341, 0, 0, 0),

    /** Scrying Orb (Trinket) Definition */
    ScryingOrbTrinket("Scrying Orb (Trinket)", "透視のオーブ", 3342, 0, 0, 0),

    /** Hextech Sweeper Definition */
    HextechSweeper("Hextech Sweeper", "ヘクステック・スイーパー", 3348, 0, 0, 0),

    /** Greater Stealth Totem (Trinket) Definition */
    GreaterStealthTotemTrinket("Greater Stealth Totem (Trinket)", "隠密のトーテム", 3361, 250, 250, 175),

    /** Greater Vision Totem (Trinket) Definition */
    GreaterVisionTotemTrinket("Greater Vision Totem (Trinket)", "発見のトーテム", 3362, 250, 250, 175),

    /** Farsight Orb (Trinket) Definition */
    FarsightOrbTrinket("Farsight Orb (Trinket)", "天眼のオーブ", 3363, 250, 250, 175),

    /** Oracle's Lens (Trinket) Definition */
    OraclesLensTrinket("Oracle's Lens (Trinket)", "看破のレンズ", 3364, 250, 250, 175),

    /** Face of the Mountain Definition */
    FaceoftheMountain("Face of the Mountain", "山の相貌", 3401, 485, 2200, 880),

    /** Ardent Censer Definition */
    ArdentCenser("Ardent Censer", "情愛の香炉", 3504, 650, 2100, 1470),

    /** Essence Reaver Definition */
    EssenceReaver("Essence Reaver", "霊奪刃", 3508, 850, 3200, 2240),

    /** Zz'Rot Portal Definition */
    ZzRotPortal("Zz'Rot Portal", "ジ＝ロット・ポータル", 3512, 950, 2800, 1960),

    /** The Black Spear Definition */
    TheBlackSpear("The Black Spear", "復讐の槍", 3599, 0, 0, 0),

    /** Stalker's Blade Definition */
    StalkersBlade("Stalker's Blade", "追跡の鋭刃", 3706, 450, 850, 595),

    /** Enchantment: Warrior Definition */
    StalkersBladeEnchantmentWarrior("Stalker's Blade Enchantment: Warrior", "追跡の鋭刃 追加特性: 戦士", 3707, 63, 2250, 1575),

    /** Enchantment: Runeglaive Definition */
    StalkersBladeEnchantmentRuneglaive("Stalker's Blade Enchantment: Runeglaive", "追跡の鋭刃 追加特性: 魔術師", 3708, 200, 2250, 1575),

    /** Enchantment: Cinderhulk Definition */
    StalkersBladeEnchantmentCinderhulk("Stalker's Blade Enchantment: Cinderhulk", "追跡の鋭刃 追加特性: 護炎石", 3709, 400, 2250, 1575),

    /** Enchantment: Devourer Definition */
    StalkersBladeEnchantmentDevourer("Stalker's Blade Enchantment: Devourer", "追跡の鋭刃 追加特性：貪食者", 3710, 300, 2250, 1575),

    /** Poacher's Knife Definition */
    PoachersKnife("Poacher's Knife", "略奪の短剣", 3711, 450, 850, 595),

    /** Ranger's Trailblazer Definition */
    RangersTrailblazer("Ranger's Trailblazer", "狩猟の手斧", 3713, 450, 850, 595),

    /** Enchantment: Warrior Definition */
    SkirmishersSabreEnchantmentWarrior("Skirmisher's Sabre Enchantment: Warrior", "一騎のサーベル 追加特性: 戦士", 3714, 63, 2250, 1575),

    /** Skirmisher's Sabre Definition */
    SkirmishersSabre("Skirmisher's Sabre", "一騎のサーベル", 3715, 450, 850, 595),

    /** Enchantment: Runeglaive Definition */
    SkirmishersSabreEnchantmentRuneglaive("Skirmisher's Sabre Enchantment: Runeglaive", "一騎のサーベル 追加特性: 魔術師", 3716, 200, 2250, 1575),

    /** Enchantment: Cinderhulk Definition */
    SkirmishersSabreEnchantmentCinderhulk("Skirmisher's Sabre Enchantment: Cinderhulk", "一騎のサーベル 追加特性: 護炎石", 3717, 400, 2250, 1575),

    /** Enchantment: Devourer Definition */
    SkirmishersSabreEnchantmentDevourer("Skirmisher's Sabre Enchantment: Devourer", "一騎のサーベル 追加特性：貪食者", 3718, 300, 2250, 1575),

    /** Enchantment: Warrior Definition */
    PoachersKnifeEnchantmentWarrior("Poacher's Knife Enchantment: Warrior", "略奪の短剣 追加特性: 戦士", 3719, 63, 2250, 1575),

    /** Enchantment: Runeglaive Definition */
    PoachersKnifeEnchantmentRuneglaive("Poacher's Knife Enchantment: Runeglaive", "略奪の短剣 追加特性: 魔術師", 3720, 200, 2250, 1575),

    /** Enchantment: Cinderhulk Definition */
    PoachersKnifeEnchantmentCinderhulk("Poacher's Knife Enchantment: Cinderhulk", "略奪の短剣 追加特性: 護炎石", 3721, 400, 2250, 1575),

    /** Enchantment: Devourer Definition */
    PoachersKnifeEnchantmentDevourer("Poacher's Knife Enchantment: Devourer", "略奪の短剣 追加特性：貪食者", 3722, 300, 2250, 1575),

    /** Enchantment: Warrior Definition */
    RangersTrailblazerEnchantmentWarrior("Ranger's Trailblazer Enchantment: Warrior", "狩猟の手斧 追加特性: 戦士", 3723, 63, 2250, 1575),

    /** Enchantment: Runeglaive Definition */
    RangersTrailblazerEnchantmentRuneglaive("Ranger's Trailblazer Enchantment: Runeglaive", "狩猟の手斧 追加特性: 魔術師", 3724, 200, 2250, 1575),

    /** Enchantment: Cinderhulk Definition */
    RangersTrailblazerEnchantmentCinderhulk("Ranger's Trailblazer Enchantment: Cinderhulk", "狩猟の手斧 追加特性: 護炎石", 3725, 400, 2250, 1575),

    /** Enchantment: Devourer Definition */
    RangersTrailblazerEnchantmentDevourer("Ranger's Trailblazer Enchantment: Devourer", "狩猟の手斧 追加特性：貪食者", 3726, 300, 2250, 1575),

    /** Bami's Cinder Definition */
    BamisCinder("Bami's Cinder", "バミの残り火", 3751, 600, 1000, 700),

    /** Righteous Glory Definition */
    RighteousGlory("Righteous Glory", "正義の栄光", 3800, 700, 2500, 1750),

    /** Crystalline Bracer Definition */
    CrystallineBracer("Crystalline Bracer", "クリスタルの籠手", 3801, 20, 600, 420),

    /** Enchantment: Sated Devourer Definition */
    StalkersBladeEnchantmentSatedDevourer("Stalker's Blade Enchantment: Sated Devourer", "追跡の鋭刃 Enchantment: Sated Devourer", 3930, 2250, 2250, 3150),

    /** Enchantment: Sated Devourer Definition */
    SkirmishersSabreEnchantmentSatedDevourer("Skirmisher's Sabre Enchantment: Sated Devourer", "一騎のサーベル Enchantment: Sated Devourer", 3931, 2250, 2250, 3150),

    /** Enchantment: Sated Devourer Definition */
    PoachersKnifeEnchantmentSatedDevourer("Poacher's Knife Enchantment: Sated Devourer", "略奪の短剣 Enchantment: Sated Devourer", 3932, 2250, 2250, 3150),

    /** Enchantment: Sated Devourer Definition */
    RangersTrailblazerEnchantmentSatedDevourer("Ranger's Trailblazer Enchantment: Sated Devourer", "狩猟の手斧 Enchantment: Sated Devourer", 3933, 2250, 2250, 3150);

    /** Champion status. */
    public final String name;

    /** Champion status. */
    public final String localizedName;

    /** Champion status. */
    public final int id;

    /** Champion status. */
    public final int buyBase;

    /** Champion status. */
    public final int buyTotal;

    /** Champion status. */
    public final int sell;

    /**
     * The item definition.
     */
    private ItemData(String name, String localizedName, int id, int buyBase, int buyTotal, int sell) {
        this.name = name;
        this.localizedName = localizedName;
        this.id = id;
        this.buyBase = buyBase;
        this.buyTotal = buyTotal;
        this.sell = sell;
    }
}
