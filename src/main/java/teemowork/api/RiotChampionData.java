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


public enum RiotChampionData {

    /** Aatrox Definition */
    Aatrox("Aatrox", "エイトロックス", 537.8F, 85.0F, 6.59F, 0.5F, 105.6F, 45.0F, 0.0F, 0.0F, 60.376F, 3.2F, -0.04F, 3.0F, 0.0F, 0.0F, 24.384F, 3.8F, 32.1F, 0.0F, 345.0F, 150.0F, new String[] {"Blood Well", "Dark Flight", "Blood Thirst / Blood Price", "Blades of Torment", "Massacre"}, new String[] {"血の泉", "闇の翼", "血の渇望/血の代償", "嘆きの刃", "大虐殺"}, new String[] {"Aatrox_Passive", "AatroxQ", "AatroxW", "AatroxE", "AatroxR"}),

    /** Ahri Definition */
    Ahri("Ahri", "アーリ", 514.4F, 80.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.04F, 3.0F, -0.065F, 2.0F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Essence Theft", "Orb of Deception", "Fox-Fire", "Charm", "Spirit Rush"}, new String[] {"精気吸引", "幻惑の宝珠", "狐火", "魅了", "妖狐演舞"}, new String[] {"Ahri_SoulEater", "AhriOrbofDeception", "AhriFoxFire", "AhriSeduce", "AhriTumble"}),

    /** Akali Definition */
    Akali("Akali", "アカリ", 587.8F, 85.0F, 8.34F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 58.376F, 3.2F, -0.1F, 3.1F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Twin Disciplines", "Mark of the Assassin", "Twilight Shroud", "Crescent Slash", "Shadow Dance"}, new String[] {"双の行", "刺客の刻印", "薄闇の帳", "三日月斬り", "影の舞"}, new String[] {"AkaliTwinDisciplines", "AkaliMota", "AkaliSmokeBomb", "AkaliShadowSwipe", "AkaliShadowDance"}),

    /** Alistar Definition */
    Alistar("Alistar", "アリスター", 613.36F, 102.0F, 8.675F, 0.85F, 278.84F, 38.0F, 6.0F, 0.8F, 61.1116F, 3.62F, 0.0F, 2.125F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 0.0F, 330.0F, 125.0F, new String[] {"Trample", "Pulverize", "Headbutt", "Triumphant Roar", "Unbreakable Will"}, new String[] {"踏破", "圧砕", "頭突き", "戦士の咆哮", "不屈の意志"}, new String[] {"Alistar_Passive", "Pulverize", "Headbutt", "TriumphantRoar", "FerociousHowl"}),

    /** Amumu Definition */
    Amumu("Amumu", "アムム", 613.12F, 84.0F, 8.875F, 0.85F, 287.2F, 40.0F, 7.38F, 0.525F, 53.384F, 3.8F, -0.02F, 2.18F, 0.0F, 0.0F, 23.544F, 3.3F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Cursed Touch", "Bandage Toss", "Despair", "Tantrum", "Curse of the Sad Mummy"}, new String[] {"呪いの手", "絡みつく包帯", "涙の池", "あばれる", "泣き虫ミイラの呪い"}, new String[] {"SadMummy_CorpseExplosion", "BandageToss", "AuraofDespair", "Tantrum", "CurseoftheSadMummy"}),

    /** Anivia Definition */
    Anivia("Anivia", "アニヴィア", 467.6F, 70.0F, 5.57F, 0.55F, 346.04F, 53.0F, 6.0F, 0.8F, 51.376F, 3.2F, 0.0F, 1.68F, 0.0F, 0.0F, 21.22F, 4.0F, 30.0F, 0.0F, 325.0F, 600.0F, new String[] {"Rebirth", "Flash Frost", "Crystallize", "Frostbite", "Glacial Storm"}, new String[] {"再誕", "結氷の煌めき", "氷塊の壁", "一振りの氷柱", "凍てつく吹雪"}, new String[] {"Cryophoenix_Rebirth", "FlashFrost", "Crystallize", "Frostbite", "GlacialStorm"}),

    /** Annie Definition */
    Annie("Annie", "アニー", 511.68F, 76.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 50.41F, 2.625F, 0.08F, 1.36F, 0.0F, 0.0F, 19.22F, 4.0F, 30.0F, 0.0F, 335.0F, 575.0F, new String[] {"Pyromania", "Disintegrate", "Incinerate", "Molten Shield", "Summon: Tibbers"}, new String[] {"火遊びだいすき", "ファイアボール", "バーニングファイア", "モルテンシールド", "でておいで！ティバーズ！"}, new String[] {"Annie_Passive", "Disintegrate", "Incinerate", "MoltenShield", "InfernalGuardian"}),

    /** Ashe Definition */
    Ashe("Ashe", "アッシュ", 527.72F, 79.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 51.088F, 2.85F, -0.05F, 3.33F, 0.0F, 0.0F, 21.212F, 3.4F, 30.0F, 0.0F, 325.0F, 600.0F, new String[] {"Frost Shot", "Ranger's Focus", "Volley", "Hawkshot", "Enchanted Crystal Arrow"}, new String[] {"フロストショット", "レンジャーのフォーカス", "ボレー", "ホークショット", "クリスタルアロー"}, new String[] {"Ashe_P", "AsheQ", "Volley", "AsheSpiritOfTheHawk", "EnchantedCrystalArrow"}),

    /** Azir Definition */
    Azir("Azir", "アジール", 524.4F, 80.0F, 6.92F, 0.55F, 350.56F, 42.0F, 6.0F, 0.8F, 52.0F, 2.8F, -0.02F, 1.5F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Shurima's Legacy", "Conquering Sands", "Arise!", "Shifting Sands", "Emperor's Divide"}, new String[] {"シュリーマの遺産", "征服の勅命", "目覚めよ！", "流砂の衝撃", "皇帝の断絶"}, new String[] {"Azir_Passive", "AzirQ", "AzirW", "AzirE", "AzirR"}),

    /** Bard Definition */
    Bard("Bard", "バード", 535.0F, 85.0F, 5.4F, 0.55F, 350.0F, 50.0F, 6.0F, 0.45F, 52.0F, 3.0F, 0.0F, 2.0F, 0.0F, 0.0F, 25.0F, 4.0F, 30.0F, 0.0F, 330.0F, 500.0F, new String[] {"Traveler's Call", "Cosmic Binding", "Caretaker's Shrine", "Magical Journey", "Tempered Fate"}, new String[] {"旅人の呼び声", "宇宙の法則", "回復の遺物", "精霊の旅路", "運命の調律"}, new String[] {"Bard_Passive", "BardQ", "BardW", "BardE", "BardR"}),

    /** Blitzcrank Definition */
    Blitzcrank("Blitzcrank", "ブリッツ", 582.6F, 95.0F, 8.51F, 0.75F, 267.2F, 40.0F, 6.0F, 0.8F, 61.54F, 3.5F, 0.0F, 1.13F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 0.0F, 325.0F, 125.0F, new String[] {"Mana Barrier", "Rocket Grab", "Overdrive", "Power Fist", "Static Field"}, new String[] {"マナバリア", "ロケットグラブ", "オーバードライブ", "パワーフィスト", "イナズマフィールド"}, new String[] {"Blitzcrank_ManaBarrier", "RocketGrab", "Overdrive", "PowerFist", "StaticField"}),

    /** Brand Definition */
    Brand("Brand", "ブランド", 507.68F, 76.0F, 5.42F, 0.55F, 325.6F, 45.0F, 8.005F, 0.6F, 57.04F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Blaze", "Sear", "Pillar of Flame", "Conflagration", "Pyroclasm"}, new String[] {"炎上", "焦炎", "烈火の柱", "焼灼", "業火"}, new String[] {"BrandBlaze", "BrandBlaze", "BrandFissure", "BrandConflagration", "BrandWildfire"}),

    /** Braum Definition */
    Braum("Braum", "ブラーム", 576.16F, 87.0F, 8.18F, 1.0F, 310.6F, 45.0F, 6.0F, 0.8F, 55.376F, 3.2F, -0.03F, 3.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Concussive Blows", "Winter's Bite", "Stand Behind Me", "Unbreakable", "Glacial Fissure"}, new String[] {"漢の拳", "冬の凍瘡", "儂に任せとけ！", "不破の盾", "氷河の裂溝"}, new String[] {"Braum_Passive", "BraumQ", "BraumW", "BraumE", "BraumRWrapper"}),

    /** Caitlyn Definition */
    Caitlyn("Caitlyn", "ケイトリン", 524.4F, 80.0F, 5.67F, 0.55F, 313.8F, 35.0F, 7.42F, 0.55F, 50.04F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 650.0F, new String[] {"Headshot", "Piltover Peacemaker", "Yordle Snap Trap", "90 Caliber Net", "Ace in the Hole"}, new String[] {"ヘッドショット", "ピースメーカー", "ヨードルトラップ", "L-90 カリバーネット", "ブルズアイ"}, new String[] {"Caitlyn_Headshot", "CaitlynPiltoverPeacemaker", "CaitlynYordleTrap", "CaitlynEntrapment", "CaitlynAceintheHole"}),

    /** Cassiopeia Definition */
    Cassiopeia("Cassiopeia", "カシオペア", 506.0F, 75.0F, 5.69F, 0.5F, 370.8F, 60.0F, 8.36F, 0.75F, 52.376F, 3.2F, -0.034F, 1.68F, 0.0F, 0.0F, 22.22F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Aspect of the Serpent", "Noxious Blast", "Miasma", "Twin Fang", "Petrifying Gaze"}, new String[] {"蛇の容貌", "ノクサスの害毒", "瘴毒", "双毒牙", "石化の視線"}, new String[] {"Cassiopeia_DeadlyCadence", "CassiopeiaNoxiousBlast", "CassiopeiaMiasma", "CassiopeiaTwinFang", "CassiopeiaPetrifyingGaze"}),

    /** Cho'Gath Definition */
    Chogath("Cho'Gath", "チョ＝ガス", 574.4F, 80.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.0F, 1.44F, 0.0F, 0.0F, 28.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Carnivore", "Rupture", "Feral Scream", "Vorpal Spikes", "Feast"}, new String[] {"暴食", "地裂の棘", "死の叫び声", "絶命の棘", "捕食"}, new String[] {"GreenTerror_TailSpike", "Rupture", "FeralScream", "VorpalSpikes", "Feast"}),

    /** Corki Definition */
    Corki("Corki", "コーキー", 512.76F, 82.0F, 5.42F, 0.55F, 305.16F, 37.0F, 7.42F, 0.55F, 51.24F, 3.0F, 0.0F, 2.3F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Hextech Shrapnel Shells", "Phosphorus Bomb", "Valkyrie", "Gatling Gun", "Missile Barrage"}, new String[] {"ヘクステック榴散弾", "閃光弾", "ワルキューレの騎行", "ガトリング砲", "連発ミサイル"}, new String[] {"Corki_RapidReload", "PhosphorusBomb", "CarpetBomb", "GGun", "MissileBarrage"}),

    /** Darius Definition */
    Darius("Darius", "ダリウス", 582.24F, 93.0F, 9.845F, 0.95F, 263.0F, 37.5F, 6.585F, 0.35F, 55.88F, 3.5F, -0.08F, 2.65F, 0.0F, 0.0F, 29.88F, 3.5F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {"Hemorrhage", "Decimate", "Crippling Strike", "Apprehend", "Noxian Guillotine"}, new String[] {"大出血", "皆殺しの斧", "薙ぎ払い", "捕縛", "ノクサス斬首斧"}, new String[] {"Darius_Icon_Hemorrhage", "DariusCleave", "DariusNoxianTacticsONH", "DariusAxeGrabCone", "DariusExecute"}),

    /** Diana Definition */
    Diana("Diana", "ダイアナ", 589.2F, 90.0F, 7.425F, 0.85F, 297.2F, 40.0F, 6.0F, 0.8F, 53.04F, 3.0F, 0.0F, 2.25F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 0.0F, 345.0F, 150.0F, new String[] {"Moonsilver Blade", "Crescent Strike", "Pale Cascade", "Moonfall", "Lunar Rush"}, new String[] {"銀月の刃", "月影", "朧月の羽衣", "瞬月", "月下美刃"}, new String[] {"Diana_Passive_LunarBlade", "DianaArc", "DianaOrbs", "DianaVortex", "DianaTeleport"}),

    /** Draven Definition */
    Draven("Draven", "ドレイヴン", 557.76F, 82.0F, 6.175F, 0.7F, 310.56F, 42.0F, 8.04F, 0.65F, 50.38F, 3.5F, -0.08F, 2.7F, 0.0F, 0.0F, 25.544F, 3.3F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"League of Draven", "Spinning Axe", "Blood Rush", "Stand Aside", "Whirling Death"}, new String[] {"リーグ・オブ・ドレイヴン", "回転斬斧", "血の疼き", "薙ぎ払い", "死の車輪"}, new String[] {"Draven_passive", "DravenSpinning", "DravenFury", "DravenDoubleShot", "DravenRCast"}),

    /** Dr. Mundo Definition */
    DrMundo("Dr. Mundo", "ドクター・ムンド", 582.52F, 89.0F, 7.76F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 61.27F, 3.0F, 0.0F, 2.8F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Adrenaline Rush", "Infected Cleaver", "Burning Agony", "Masochism", "Sadism"}, new String[] {"アドレナリンラッシュ", "ホウチョウ", "バーニングペイン", "マゾヒズム", "サディズム"}, new String[] {"DrMundo_AdrenalineRush2", "InfectedCleaverMissileCast", "BurningAgony", "Masochism", "Sadism"}),

    /** Ekko Definition */
    Ekko("Ekko", "エコー", 580.0F, 80.0F, 9.0F, 0.9F, 280.0F, 50.0F, 6.0F, 0.8F, 59.0F, 3.0F, 0.0F, 3.3F, 0.0F, 0.0F, 27.0F, 3.0F, 32.0F, 0.0F, 340.0F, 125.0F, new String[] {"Z-Drive Resonance", "Timewinder", "Parallel Convergence", "Phase Dive", "Chronobreak"}, new String[] {"ゼロ・ドライブ共振", "時空ワインダー", "パラレルタイムトラップ", "亜空間ダイブ", "クロノブレイク"}, new String[] {"Ekko_P", "EkkoQ", "EkkoW", "EkkoE", "EkkoR"}),

    /** Elise Definition */
    Elise("Elise", "エリス", 529.4F, 80.0F, 5.705F, 0.6F, 324.0F, 50.0F, 6.0F, 0.8F, 50.54F, 3.0F, 0.0F, 1.75F, 0.0F, 0.0F, 22.128F, 3.35F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Spider Queen", "Neurotoxin / Venomous Bite", "Volatile Spiderling / Skittering Frenzy", "Cocoon / Rappel", "Spider Form", "Venomous Bite / Neurotoxin", "Skittering Frenzy / Volatile Spiderling", "Rappel / Cocoon", "Human Form"}, new String[] {"孵化", "神経毒/毒牙", "子蜘蛛爆弾/猛食", "繭化/蜘蛛の糸", "蜘蛛形態", "毒牙/神経毒", "猛食/子蜘蛛爆弾", "蜘蛛の糸/繭化", "ヒト形態"}, new String[] {"ElisePassive", "EliseHumanQ", "EliseHumanW", "EliseHumanE", "EliseR", "EliseSpiderQCast", "EliseSpiderW", "EliseSpiderEInitial", "EliseRSpider"}),

    /** Evelynn Definition */
    Evelynn("Evelynn", "エヴェリン", 531.2F, 90.0F, 9.82F, 0.55F, 265.6F, 45.0F, 8.105F, 0.6F, 53.88F, 3.5F, 0.0F, 3.6F, 0.0F, 0.0F, 26.5F, 3.8F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {"Shadow Walk", "Hate Spike", "Dark Frenzy", "Ravage", "Agony's Embrace"}, new String[] {"影踏み", "憎悪の棘", "闇の舞", "猛撃", "苦悶の抱擁"}, new String[] {"Evelynn_ShadowWalk", "EvelynnQ", "EvelynnW", "EvelynnE", "EvelynnR"}),

    /** Ezreal Definition */
    Ezreal("Ezreal", "エズリアル", 484.4F, 80.0F, 6.42F, 0.55F, 310.6F, 45.0F, 8.09F, 0.65F, 50.24F, 3.0F, 0.0F, 2.8F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Rising Spell Force", "Mystic Shot", "Essence Flux", "Arcane Shift", "Trueshot Barrage"}, new String[] {"ライジングフォース", "ミスティックショット", "エッセンスフロー", "ミスティカルシフト", "トゥルーショット"}, new String[] {"Ezreal_RisingSpellForce", "EzrealMysticShot", "EzrealEssenceFlux", "EzrealArcaneShift", "EzrealTrueshotBarrage"}),

    /** Fiddlesticks Definition */
    FiddleSticks("Fiddlesticks", "フィドル", 524.4F, 80.0F, 5.605F, 0.6F, 350.12F, 59.0F, 6.0F, 0.8F, 48.36F, 2.625F, 0.0F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 480.0F, new String[] {"Dread", "Terrify", "Drain", "Dark Wind", "Crowstorm"}, new String[] {"ドレッド", "テラー", "ドレイン", "ダークウィンド", "クロウストーム"}, new String[] {"Fiddlesticks_Paranoia", "Terrify", "Drain", "FiddlesticksDarkWind", "Crowstorm"}),

    /** Fiora Definition */
    Fiora("Fiora", "フィオラ", 592.8F, 85.0F, 6.84F, 0.8F, 287.2F, 40.0F, 7.59F, 0.5F, 59.876F, 3.2F, -0.07F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Duelist", "Lunge", "Riposte", "Burst of Speed", "Blade Waltz"}, new String[] {"デュエリスト", "ファント", "リポスト", "スピードバースト", "ブレードワルツ"}, new String[] {"Fiora_Duelist", "FioraQ", "FioraRiposte", "FioraFlurry", "FioraDance"}),

    /** Fizz Definition */
    Fizz("Fizz", "フィズ", 558.48F, 86.0F, 8.175F, 0.7F, 267.2F, 40.0F, 6.0F, 0.8F, 58.04F, 3.0F, -0.05F, 3.1F, 0.0F, 0.0F, 22.412F, 3.4F, 32.1F, 0.0F, 335.0F, 175.0F, new String[] {"Nimble Fighter", "Urchin Strike", "Seastone Trident", "Playful / Trickster", "Chum the Waters"}, new String[] {"シーファイター", "ウニトゲ・ストライク", "シートライデント", "プレイ/トリックスター", "フィッシング"}, new String[] {"FizzPassive", "FizzPiercingStrike", "FizzSeastonePassive", "FizzJump", "FizzMarinerDoom"}),

    /** Galio Definition */
    Galio("Galio", "ガリオ", 577.8F, 85.0F, 8.71F, 0.75F, 319.0F, 50.0F, 6.0F, 0.8F, 61.97F, 3.375F, -0.02F, 1.2F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Runic Skin", "Resolute Smite", "Bulwark", "Righteous Gust", "Idol of Durand"}, new String[] {"ルーンの加護", "懲罰の視線", "忠義の防壁", "正義の追い風", "デュランドの偶像"}, new String[] {"Galio_RunicSkin", "GalioResoluteSmite", "GalioBulwark", "GalioRighteousGust", "GalioIdolOfDurand"}),

    /** Gangplank Definition */
    Gangplank("Gangplank", "ガングプランク", 631.08F, 81.0F, 5.51F, 0.75F, 282.2F, 40.0F, 7.675F, 0.7F, 59.04F, 3.0F, -0.04F, 2.75F, 0.0F, 0.0F, 26.044F, 3.3F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Grog-Soaked Blade", "Parrrley", "Remove Scurvy", "Raise Morale", "Cannon Barrage"}, new String[] {"酒浸りの剣", "偽りの発砲", "壊血病治癒", "士気上昇", "一斉砲撃"}, new String[] {"Pirate_GrogSoakedBlade", "Parley", "RemoveScurvy", "RaiseMorale", "CannonBarrage"}),

    /** Garen Definition */
    Garen("Garen", "ガレン", 616.28F, 96.0F, 7.84F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 57.88F, 3.5F, 0.0F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Perseverance", "Decisive Strike", "Courage", "Judgment", "Demacian Justice"}, new String[] {"忍耐", "断固たる一撃", "勇気の護り", "断罪剣", "デマーシアの正義"}, new String[] {"Garen_Passive", "GarenQ", "GarenW", "GarenE", "GarenR"}),

    /** Gnar Definition */
    Gnar("Gnar", "ナー", 540.0F, 65.0F, 2.5F, 0.5F, 100.0F, 0.0F, 0.0F, 0.0F, 48.0F, 3.0F, 0.0F, 6.0F, 0.0F, 0.0F, 23.0F, 2.5F, 30.0F, 0.0F, 325.0F, 150.0F, new String[] {"Rage Gene", "Boomerang Throw / Boulder Toss", "Hyper / Wallop", "Hop / Crunch", "GNAR!"}, new String[] {"ぷんすこ", "ブーメラン/ぽいっ", "ごきげん/こてんぱん", "ぴょんぴょん/ドガン！", "ナー！"}, new String[] {"Gnar_Passive", "GnarQ", "GnarW", "GnarE", "GnarR"}),

    /** Gragas Definition */
    Gragas("Gragas", "グラガス", 583.52F, 89.0F, 5.5F, 0.5F, 400.0F, 47.0F, 6.0F, 0.8F, 61.38F, 3.5F, -0.04F, 2.05F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 0.0F, 330.0F, 125.0F, new String[] {"Happy Hour", "Barrel Roll", "Drunken Rage", "Body Slam", "Explosive Cask"}, new String[] {"ほろ酔い", "タル転がし", "飲みすぎ注意", "腹の肉", "タル爆弾"}, new String[] {"GragasPassiveHeal", "GragasQ", "GragasW", "GragasE", "GragasR"}),

    /** Graves Definition */
    Graves("Graves", "グレイヴズ", 551.12F, 84.0F, 6.675F, 0.7F, 322.2F, 40.0F, 7.925F, 0.7F, 54.208F, 3.1F, 0.0F, 2.9F, 0.0F, 0.0F, 24.376F, 3.2F, 30.0F, 0.0F, 330.0F, 525.0F, new String[] {"True Grit", "Buckshot", "Smoke Screen", "Quickdraw", "Collateral Damage"}, new String[] {"確固たる信念", "散弾", "煙幕", "早撃ち", "炸裂砲弾"}, new String[] {"GravesTrueGrit", "GravesClusterShot", "GravesSmokeGrenade", "GravesMove", "GravesChargeShot"}),

    /** Hecarim Definition */
    Hecarim("Hecarim", "ヘカリム", 599.6F, 95.0F, 7.0F, 0.75F, 277.2F, 40.0F, 6.5F, 0.6F, 61.376F, 3.2F, -0.0672F, 2.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 0.0F, 345.0F, 175.0F, new String[] {"Warpath", "Rampage", "Spirit of Dread", "Devastating Charge", "Onslaught of Shadows"}, new String[] {"出陣", "縦横無尽", "怨霊の恐怖", "猛突進", "幻影の襲撃"}, new String[] {"Hecarim_Passive", "HecarimRapidSlash", "HecarimW", "HecarimRamp", "HecarimUlt"}),

    /** Heimerdinger Definition */
    Heimerdinger("Heimerdinger", "ハイマー", 476.0F, 75.0F, 11.005F, 1.75F, 307.2F, 40.0F, 6.0F, 0.8F, 55.536F, 2.7F, 0.0F, 1.36F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Techmaturgical Repair Bots", "H-28G Evolution Turret", "Hextech Micro-Rockets", "CH-2 Electron Storm Grenade", "UPGRADE!!!"}, new String[] {"テクマタージカル修理ボット", "H-28G革新砲", "ヘクステック小型ロケット", "CH-2超電磁グレネード", "アップグレード！！！"}, new String[] {"Heimerdinger_Passive", "HeimerdingerQ", "HeimerdingerW", "HeimerdingerE", "HeimerdingerR"}),

    /** Irelia Definition */
    Irelia("Irelia", "イレリア", 607.2F, 90.0F, 8.59F, 0.65F, 288.8F, 35.0F, 8.09F, 0.65F, 61.544F, 3.3F, -0.06F, 3.2F, 0.0F, 0.0F, 25.3F, 3.75F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Ionian Fervor", "Bladesurge", "Hiten Style", "Equilibrium Strike", "Transcendent Blades"}, new String[] {"アイオニアの熱情", "瞬剣", "飛天流", "平衡の一撃", "飛剣の舞"}, new String[] {"Irelia_IonianFervor", "IreliaGatotsu", "IreliaHitenStyle", "IreliaEquilibriumStrike", "IreliaTranscendentBlades"}),

    /** Janna Definition */
    Janna("Janna", "ジャンナ", 487.04F, 78.0F, 5.42F, 0.55F, 409.52F, 64.0F, 9.0F, 0.4F, 51.956F, 2.95F, 0.0F, 2.61F, 0.0F, 0.0F, 19.384F, 3.8F, 30.0F, 0.0F, 335.0F, 475.0F, new String[] {"Tailwind", "Howling Gale", "Zephyr", "Eye Of The Storm", "Monsoon"}, new String[] {"追い風", "颶風のすさび", "西風の神", "嵐の祝福", "青嵐"}, new String[] {"Janna_Tailwind", "HowlingGale", "SowTheWind", "EyeOfTheStorm", "ReapTheWhirlwind"}),

    /** Jarvan IV Definition */
    JarvanIV("Jarvan IV", "ジャーヴァンⅣ", 571.2F, 90.0F, 8.175F, 0.7F, 302.2F, 40.0F, 6.755F, 0.45F, 55.712F, 3.4F, -0.05F, 2.5F, 0.0F, 0.0F, 27.0F, 3.6F, 32.1F, 0.0F, 340.0F, 175.0F, new String[] {"Martial Cadence", "Dragon Strike", "Golden Aegis", "Demacian Standard", "Cataclysm"}, new String[] {"武魂の律動", "龍撃", "黄金の護輪", "デマーシアの旗印", "決戦場"}, new String[] {"JarvanIV_MartialCadence", "JarvanIVDragonStrike", "JarvanIVGoldenAegis", "JarvanIVDemacianStandard", "JarvanIVCataclysm"}),

    /** Jax Definition */
    Jax("Jax", "ジャックス", 592.8F, 85.0F, 8.37F, 0.55F, 288.8F, 35.0F, 7.575F, 0.7F, 61.97F, 3.375F, -0.02F, 3.4F, 0.0F, 0.0F, 27.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Relentless Assault", "Leap Strike", "Empower", "Counter Strike", "Grandmaster's Might"}, new String[] {"連撃の鬼", "跳躍撃", "入魂", "後の先", "達人の剛力"}, new String[] {"Armsmaster_MasterOfArms", "JaxLeapStrike", "JaxEmpowerTwo", "JaxCounterStrike", "JaxRelentlessAssault"}),

    /** Jayce Definition */
    Jayce("Jayce", "ジェイス", 571.2F, 90.0F, 7.34F, 0.8F, 307.2F, 40.0F, 6.0F, 0.8F, 50.38F, 3.5F, -0.05F, 3.0F, 0.0F, 0.0F, 22.38F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Hextech Capacitor", "To the Skies! / Shock Blast", "Lightning Field / Hyper Charge", "Thundering Blow / Acceleration Gate", "Mercury Cannon / Mercury Hammer", "Shock Blast", "Hyper Charge", "Acceleration Gate", "Mercury Hammer"}, new String[] {"ヘクステック・コンデンサー", "スカイバスター/ショックブラスト", "ライトニング/ハイパーチャージ", "サンダーブロー/アクセルゲート", "マーキュリーキャノン/マーキュリーハンマー", "ショックブラスト", "ハイパーチャージ", "アクセルゲート", "マーキュリーハンマー"}, new String[] {"Jayce_Passive", "JayceToTheSkies", "JayceStaticField", "JayceThunderingBlow", "JayceStanceHtG", "JayceShockBlast", "JayceHyperCharge", "JayceAccelerationGate", "JayceStanceGtH"}),

    /** Jinx Definition */
    Jinx("Jinx", "ジンクス", 517.76F, 82.0F, 5.84F, 0.5F, 245.6F, 45.0F, 6.68F, 1.0F, 53.04F, 3.0F, 0.0F, 1.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {"Get Excited!", "Switcheroo!", "Zap!", "Flame Chompers!", "Super Mega Death Rocket!"}, new String[] {"キャッホー！", "スイッチング！", "シビレーザー！", "パックンチョッパー！", "スーパーメガデスロケット！"}, new String[] {"Jinx_Passive", "JinxQ", "JinxW", "JinxE", "JinxR"}),

    /** Kalista Definition */
    Kalista("Kalista", "カリスタ", 517.76F, 83.0F, 6.0F, 0.55F, 231.8F, 35.0F, 6.3F, 0.4F, 57.5F, 3.5F, -0.05F, 3.3F, 0.0F, 0.0F, 19.012F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Martial Poise", "Pierce", "Sentinel", "Rend", "Fate's Call"}, new String[] {"戦いの所作", "貫魂の一投", "執念の霊魂", "引き裂く遺恨", "宿命の呼び声"}, new String[] {"Kalista_Passive", "KalistaMysticShot", "KalistaW", "KalistaExpungeWrapper", "KalistaRx"}),

    /** Karma Definition */
    Karma("Karma", "カルマ", 522.44F, 83.0F, 5.62F, 0.55F, 374.0F, 50.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.0F, 2.3F, 0.0F, 0.0F, 20.384F, 3.8F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Gathering Fire", "Inner Flame", "Focused Resolve", "Inspire", "Mantra"}, new String[] {"寄せ火", "内なる炎", "不退転の決意", "激励", "マントラ"}, new String[] {"Karma_Passive", "KarmaQ", "KarmaSpiritBind", "KarmaSolKimShield", "KarmaMantra"}),

    /** Karthus Definition */
    Karthus("Karthus", "カーサス", 516.0F, 75.0F, 6.42F, 0.55F, 372.48F, 61.0F, 6.0F, 0.8F, 45.66F, 3.25F, 0.0F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Death Defied", "Lay Waste", "Wall of Pain", "Defile", "Requiem"}, new String[] {"死の拒絶", "根絶やし", "苦痛の壁", "冒涜", "鎮魂歌"}, new String[] {"Karthus_Passive", "KarthusLayWasteA1", "KarthusWallOfPain", "KarthusDefile", "KarthusFallenOne"}),

    /** Kassadin Definition */
    Kassadin("Kassadin", "カサディン", 564.04F, 78.0F, 7.79F, 0.5F, 347.6F, 70.0F, 6.0F, 0.8F, 58.852F, 3.9F, -0.023F, 3.7F, 0.0F, 0.0F, 23.376F, 3.2F, 30.0F, 0.0F, 340.0F, 150.0F, new String[] {"Void Stone", "Null Sphere", "Nether Blade", "Force Pulse", "Riftwalk"}, new String[] {"ヴォイドの石", "零の魔珠", "冥界の刃", "闇の波動", "無限回廊"}, new String[] {"Kassadin_Passive", "NullLance", "NetherBlade", "ForcePulse", "RiftWalk"}),

    /** Katarina Definition */
    Katarina("Katarina", "カタリナ", 510.0F, 83.0F, 4.5F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 58.0F, 3.2F, -0.05F, 2.74F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Voracity", "Bouncing Blades", "Sinister Steel", "Shunpo", "Death Lotus"}, new String[] {"貪欲", "跳刃乱舞", "凶刃の渦", "瞬歩", "死刃蓮華"}, new String[] {"Katarina_Passive", "KatarinaQ", "KatarinaW", "KatarinaE", "KatarinaR"}),

    /** Kayle Definition */
    Kayle("Kayle", "ケイル", 574.24F, 93.0F, 8.26F, 0.75F, 322.2F, 40.0F, 6.0F, 0.8F, 56.004F, 2.8F, -0.02F, 2.2F, 0.0F, 0.0F, 26.88F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Holy Fervor", "Reckoning", "Divine Blessing", "Righteous Fury", "Intervention"}, new String[] {"聖なる闘志", "天罰", "神々の祝福", "義憤", "神権代行"}, new String[] {"Kayle_Passive", "JudicatorReckoning", "JudicatorDivineBlessing", "JudicatorRighteousFury", "JudicatorIntervention"}),

    /** Kennen Definition */
    Kennen("Kennen", "ケネン", 535.72F, 79.0F, 5.59F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 50.544F, 3.3F, -0.0947F, 3.4F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Mark of the Storm", "Thundering Shuriken", "Electrical Surge", "Lightning Rush", "Slicing Maelstrom"}, new String[] {"嵐の刻印", "雷手裏剣", "稲妻の奔流", "疾風迅雷", "雷撃の大嵐"}, new String[] {"Kennen_MarkOfStorm", "KennenShurikenHurlMissile1", "KennenBringTheLight", "KennenLightningRush", "KennenShurikenStorm"}),

    /** Kha'Zix Definition */
    Khazix("Kha'Zix", "カ＝ジックス", 572.8F, 85.0F, 7.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Unseen Threat", "Taste Their Fear", "Void Spike", "Leap", "Void Assault"}, new String[] {"見えざる脅威", "甘美なる恐怖", "破裂の棘", "跳躍", "捕食の本能"}, new String[] {"Khazix_P", "KhazixQ", "KhazixW", "KhazixE", "KhazixR"}),

    /** Kog'Maw Definition */
    KogMaw("Kog'Maw", "コグ＝マウ", 546.16F, 87.0F, 5.92F, 0.55F, 322.2F, 40.0F, 8.675F, 0.7F, 49.04F, 3.0F, -0.06F, 2.65F, 0.0F, 0.0F, 19.88F, 3.5F, 30.0F, 0.0F, 325.0F, 500.0F, new String[] {"Icathian Surprise", "Caustic Spittle", "Bio-Arcane Barrage", "Void Ooze", "Living Artillery"}, new String[] {"イカシアの自爆", "腐食粘液", "有機性魔力砲", "ヴォイド分泌液", "生体空撃砲"}, new String[] {"KogMaw_IcathianSurprise", "KogMawQ", "KogMawBioArcaneBarrage", "KogMawVoidOoze", "KogMawLivingArtillery"}),

    /** LeBlanc Definition */
    Leblanc("LeBlanc", "ルブラン", 516.0F, 75.0F, 7.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 54.88F, 3.5F, 0.0F, 1.4F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Mirror Image", "Sigil of Malice", "Distortion", "Ethereal Chains", "Mimic"}, new String[] {"鏡像", "悪意の印", "空間歪曲", "霊妙な鎖", "再演"}, new String[] {"LeblancMirrorImage", "LeblancChaosOrb", "LeblancSlide", "LeblancSoulShackle", "LeblancMimic"}),

    /** Lee Sin Definition */
    LeeSin("Lee Sin", "リー・シン", 570.8F, 85.0F, 7.425F, 0.7F, 200.0F, 0.0F, 50.0F, 0.0F, 61.176F, 3.2F, -0.04F, 3.0F, 0.0F, 0.0F, 24.216F, 3.7F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Flurry", "Sonic Wave / Resonating Strike", "Safeguard / Iron Will", "Tempest / Cripple", "Dragon's Rage"}, new String[] {"乱舞", "音の波動/共鳴拳", "守りの型/鉄の意志", "破風/縛脚", "龍の怒り"}, new String[] {"LeeSinPassive", "BlindMonkQOne", "BlindMonkWOne", "BlindMonkEOne", "BlindMonkRKick"}),

    /** Leona Definition */
    Leona("Leona", "レオナ", 576.16F, 87.0F, 8.425F, 0.85F, 302.2F, 40.0F, 6.0F, 0.8F, 60.04F, 3.0F, 0.0F, 2.9F, 0.0F, 0.0F, 27.208F, 3.1F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Sunlight", "Shield of Daybreak", "Eclipse", "Zenith Blade", "Solar Flare"}, new String[] {"太陽の輝き", "暁の盾", "煌光破", "天陽の剣", "太陽の一閃"}, new String[] {"LeonaSunlight", "LeonaShieldOfDaybreak", "LeonaSolarBarrier", "LeonaZenithBlade", "LeonaSolarFlare"}),

    /** Lissandra Definition */
    Lissandra("Lissandra", "リサンドラ", 506.12F, 84.0F, 6.92F, 0.55F, 304.0F, 50.0F, 5.67F, 0.4F, 50.536F, 2.7F, 0.0F, 1.36F, 0.0F, 0.0F, 20.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Iceborn", "Ice Shard", "Ring of Frost", "Glacial Path", "Frozen Tomb"}, new String[] {"アイスボーン", "アイスシャード", "リング・オブ・フロスト", "グラシアルパス", "フローズングレイブ"}, new String[] {"Lissandra_Passive", "LissandraQ", "LissandraW", "LissandraE", "LissandraR"}),

    /** Lucian Definition */
    Lucian("Lucian", "ルシアン", 554.4F, 80.0F, 6.19F, 0.65F, 298.88F, 41.0F, 8.175F, 0.7F, 52.04F, 3.0F, -0.02F, 3.3F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {"Lightslinger", "Piercing Light", "Ardent Blaze", "Relentless Pursuit", "The Culling"}, new String[] {"二丁掃射", "閃光", "浄化の星印", "瞬脚", "殲滅"}, new String[] {"Lucian_Passive", "LucianQ", "LucianW", "LucianE", "LucianR"}),

    /** Lulu Definition */
    Lulu("Lulu", "ルル", 552.76F, 82.0F, 6.005F, 0.6F, 292.4F, 55.0F, 8.5F, 0.6F, 46.368F, 2.6F, 0.0F, 2.25F, 0.0F, 0.0F, 19.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Pix, Faerie Companion", "Glitterlance", "Whimsy", "Help, Pix!", "Wild Growth"}, new String[] {"仲良し妖精ピックス", "ぴかぴかランス", "イタズラ", "ピックス、おねがい！", "おおきくなぁれ！"}, new String[] {"Lulu_PixFaerieCompanion", "LuluQ", "LuluW", "LuluE", "LuluR"}),

    /** Lux Definition */
    Lux("Lux", "ラックス", 477.72F, 79.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.0F, 1.36F, 0.0F, 0.0F, 18.72F, 4.0F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Illumination", "Light Binding", "Prismatic Barrier", "Lucent Singularity", "Final Spark"}, new String[] {"イルミネーション", "ライトバインド", "プリズムバリア", "シンギュラリティ", "ファイナルスパーク"}, new String[] {"LuxIlluminatingFraulein", "LuxLightBinding", "LuxPrismaticWave", "LuxLightStrikeKugel", "LuxMaliceCannon"}),

    /** Malphite Definition */
    Malphite("Malphite", "マルファイト", 574.2F, 90.0F, 8.37F, 0.55F, 282.2F, 40.0F, 7.32F, 0.55F, 61.97F, 3.375F, -0.02F, 3.4F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Granite Shield", "Seismic Shard", "Brutal Strikes", "Ground Slam", "Unstoppable Force"}, new String[] {"岩盤の盾", "大地の破片", "大地の怒り", "岩強の拳", "不可止の衝撃"}, new String[] {"Malphite_GraniteShield", "SeismicShard", "Obduracy", "Landslide", "UFSlash"}),

    /** Malzahar Definition */
    Malzahar("Malzahar", "マルザハール", 514.4F, 80.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Summon Voidling", "Call of the Void", "Null Zone", "Malefic Visions", "Nether Grasp"}, new String[] {"ヴォイドリング使い", "ヴォイドの呼び声", "零の領域", "視の浸食", "冥界の緊縛"}, new String[] {"AlZahar_SummonVoidling", "AlZaharCalloftheVoid", "AlZaharNullZone", "AlZaharMaleficVisions", "AlZaharNetherGrasp"}),

    /** Maokai Definition */
    Maokai("Maokai", "マオカイ", 572.2F, 90.0F, 8.675F, 0.85F, 327.28F, 46.0F, 7.205F, 0.45F, 63.544F, 3.3F, -0.1F, 2.125F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Sap Magic", "Arcane Smash", "Twisted Advance", "Sapling Toss", "Vengeful Maelstrom"}, new String[] {"魔樹液", "魔紋打ち", "進撃の樹人", "苗木投げ", "報復の旋風"}, new String[] {"Maokai_Passive", "MaokaiTrunkLine", "MaokaiUnstableGrowth", "MaokaiSapling2", "MaokaiDrain3"}),

    /** Master Yi Definition */
    MasterYi("Master Yi", "マスター・イー", 598.56F, 92.0F, 7.59F, 0.65F, 250.56F, 42.0F, 7.255F, 0.45F, 60.04F, 3.0F, -0.08F, 2.0F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 0.0F, 355.0F, 125.0F, new String[] {"Double Strike", "Alpha Strike", "Meditate", "Wuju Style", "Highlander"}, new String[] {"双連斬", "疾風斬・極", "明鏡止水", "無極流", "無極流奥義"}, new String[] {"MasterYi_Passive1", "AlphaStrike", "Meditate", "WujuStyle", "Highlander"}),

    /** Miss Fortune Definition */
    MissFortune("Miss Fortune", "フォーチュン", 577.8F, 85.0F, 6.19F, 0.65F, 275.84F, 38.0F, 8.04F, 0.65F, 49.54F, 3.0F, -0.04734F, 3.01F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Strut", "Double Up", "Impure Shots", "Make It Rain", "Bullet Time"}, new String[] {"ステップアップ", "ダブルアップ", "ダーティショット", "レイニングバレット", "バレットタイム"}, new String[] {"MissFortune_Strut", "MissFortuneRicochetShot", "MissFortuneViciousStrikes", "MissFortuneScattershot", "MissFortuneBulletTime"}),

    /** Wukong Definition */
    MonkeyKing("Wukong", "ウーコン", 577.8F, 85.0F, 6.19F, 0.65F, 265.84F, 38.0F, 8.04F, 0.65F, 59.876F, 3.2F, -0.05F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 345.0F, 175.0F, new String[] {"Stone Skin", "Crushing Blow", "Decoy", "Nimbus Strike", "Cyclone"}, new String[] {"岩の皮膚", "強棒打", "隠れ蓑の術", "残像撃", "輪舞旋風"}, new String[] {"MonkeyKingStoneSkin", "MonkeyKingDoubleAttack", "MonkeyKingDecoy", "MonkeyKingNimbus", "MonkeyKingSpinToWin"}),

    /** Mordekaiser Definition */
    Mordekaiser("Mordekaiser", "モルデカイザー", 555.4F, 80.0F, 3.37F, 0.55F, 120.0F, 0.0F, 0.0F, 0.0F, 57.58F, 3.5F, -0.1F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {"Iron Man", "Mace of Spades", "Creeping Death", "Siphon of Destruction", "Children of the Grave"}, new String[] {"アイアンマン", "メイス・オブ・スペーズ", "クリーピング・デス", "サイフォン・オブ・デストラクション", "チルドレン・オブ・ザ・グレイヴ"}, new String[] {"Mordekaiser_IronMan", "MordekaiserMaceOfSpades", "MordekaiserCreepingDeathCast", "MordekaiserSyphonOfDestruction", "MordekaiserChildrenOfTheGrave"}),

    /** Morgana Definition */
    Morgana("Morgana", "モルガナ", 547.48F, 86.0F, 5.705F, 0.6F, 340.8F, 60.0F, 6.0F, 0.8F, 55.46F, 3.5F, 0.0F, 1.53F, 0.0F, 0.0F, 25.384F, 3.8F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Soul Siphon", "Dark Binding", "Tormented Soil", "Black Shield", "Soul Shackles"}, new String[] {"魂吸引", "闇の束縛", "苦悶の沼", "漆黒の盾", "魂の足枷"}, new String[] {"FallenAngel_Empathize", "DarkBindingMissile", "TormentedSoil", "BlackShield", "SoulShackles"}),

    /** Nami Definition */
    Nami("Nami", "ナミ", 489.32F, 74.0F, 5.42F, 0.55F, 377.24F, 43.0F, 9.0F, 0.4F, 51.208F, 3.1F, -0.03F, 2.61F, 0.0F, 0.0F, 19.72F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Surging Tides", "Aqua Prison", "Ebb and Flow", "Tidecaller's Blessing", "Tidal Wave"}, new String[] {"激流", "水の監獄", "潮流", "潮使いの祝福", "大海嘯"}, new String[] {"NamiPassive", "NamiQ", "NamiW", "NamiE", "NamiR"}),

    /** Nasus Definition */
    Nasus("Nasus", "ナサス", 561.2F, 90.0F, 9.01F, 0.9F, 275.6F, 45.0F, 7.44F, 0.5F, 59.18F, 3.5F, -0.02F, 3.48F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Soul Eater", "Siphoning Strike", "Wither", "Spirit Fire", "Fury of the Sands"}, new String[] {"魂の統括", "吸魂撃", "風化", "輪廻の炎", "憤怒の熱砂"}, new String[] {"Nasus_Passive", "NasusQ", "NasusW", "NasusE", "NasusR"}),

    /** Nautilus Definition */
    Nautilus("Nautilus", "ノーチラス", 576.48F, 86.0F, 8.37F, 0.55F, 284.0F, 50.0F, 8.625F, 0.7F, 57.544F, 3.3F, 0.02F, 1.0F, 0.0F, 0.0F, 26.46F, 3.25F, 32.1F, 0.0F, 325.0F, 175.0F, new String[] {"Staggering Blow", "Dredge Line", "Titan's Wrath", "Riptide", "Depth Charge"}, new String[] {"鉄の錨", "錨投げ", "大海の激憤", "粉砕水", "爆雷発射"}, new String[] {"Nautilus_StaggeringBlow", "NautilusAnchorDrag", "NautilusPiercingGaze", "NautilusSplashZone", "NautilusGrandLine"}),

    /** Nidalee Definition */
    Nidalee("Nidalee", "ニダリー", 511.2F, 80.0F, 6.005F, 0.6F, 295.6F, 45.0F, 6.0F, 0.8F, 47.88F, 3.5F, -0.02F, 3.22F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Prowl", "Javelin Toss / Takedown", "Bushwhack / Pounce", "Primal Surge / Swipe", "Aspect Of The Cougar", "Takedown", "Pounce", "Swipe"}, new String[] {"獲物探し", "槍投げ/テイクダウン", "虎挟み/ジャンプ", "高揚/クーガークロウ", "クーガーの心", "テイクダウン", "ジャンプ", "クーガークロウ"}, new String[] {"Nidalee_Passive", "JavelinToss", "Bushwhack", "PrimalSurge", "AspectOfTheCougar", "Takedown", "Pounce", "Swipe"}),

    /** Nocturne Definition */
    Nocturne("Nocturne", "ノクターン", 582.8F, 85.0F, 8.26F, 0.75F, 273.8F, 35.0F, 6.755F, 0.45F, 59.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Umbra Blades", "Duskbringer", "Shroud of Darkness", "Unspeakable Horror", "Paranoia"}, new String[] {"夢幻斬", "闇の手", "漆黒の帳", "底知れぬ恐怖", "悪夢"}, new String[] {"Nocturne_UmbraBlades", "NocturneDuskbringer", "NocturneShroudofDarkness", "NocturneUnspeakableHorror", "NocturneParanoia"}),

    /** Nunu Definition */
    Nunu("Nunu", "ヌヌ", 598.28F, 90.0F, 8.39F, 0.8F, 283.56F, 42.0F, 7.44F, 0.5F, 56.856F, 3.45F, 0.0F, 2.25F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Visionary", "Consume", "Blood Boil", "Ice Blast", "Absolute Zero"}, new String[] {"幻想", "丸飲み", "熱血", "氷弾", "アブソリュート・ゼロ"}, new String[] {"Yeti_FrostNova", "Consume", "BloodBoil", "IceBlast", "AbsoluteZero"}),

    /** Olaf Definition */
    Olaf("Olaf", "オラフ", 597.24F, 93.0F, 8.51F, 0.9F, 265.6F, 45.0F, 7.465F, 0.575F, 59.98F, 3.5F, -0.1F, 2.7F, 0.0F, 0.0F, 26.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Berserker Rage", "Undertow", "Vicious Strikes", "Reckless Swing", "Ragnarok"}, new String[] {"狂戦士の怒り", "斧投げ", "残忍な斧", "捨て身切り", "滅我"}, new String[] {"Olaf_Passive", "OlafAxeThrowCast", "OlafFrenziedStrikes", "OlafRecklessStrike", "OlafRagnarok"}),

    /** Orianna Definition */
    Orianna("Orianna", "オリアナ", 517.72F, 79.0F, 6.87F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 40.368F, 2.6F, -0.05F, 3.5F, 0.0F, 0.0F, 17.04F, 3.0F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {"Clockwork Windup", "Command: Attack", "Command: Dissonance", "Command: Protect", "Command: Shockwave"}, new String[] {"ぜんまい仕掛け", "命令: 攻撃", "命令: 乱磁場", "命令: 防御", "命令: 衝撃波"}, new String[] {"OriannaPassive", "OrianaIzunaCommand", "OrianaDissonanceCommand", "OrianaRedactCommand", "OrianaDetonateCommand"}),

    /** Pantheon Definition */
    Pantheon("Pantheon", "パンテオン", 579.16F, 87.0F, 7.84F, 0.65F, 267.12F, 34.0F, 7.355F, 0.45F, 55.572F, 2.9F, 0.0F, 2.95F, 0.0F, 0.0F, 27.652F, 3.9F, 32.1F, 0.0F, 355.0F, 150.0F, new String[] {"Aegis Protection", "Spear Shot", "Aegis of Zeonia", "Heartseeker Strike", "Grand Skyfall"}, new String[] {"イージスの守護", "痛恨の槍", "ゼオニアの加護", "急所乱撃", "天上天下唯我独槍"}, new String[] {"Pantheon_AOZ", "PantheonQ", "PantheonW", "PantheonE", "PantheonRJump"}),

    /** Poppy Definition */
    Poppy("Poppy", "ポッピー", 559.08F, 81.0F, 8.37F, 0.55F, 235.4F, 30.0F, 7.155F, 0.45F, 61.97F, 3.375F, -0.02F, 3.35F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 345.0F, 125.0F, new String[] {"Valiant Fighter", "Devastating Blow", "Paragon of Demacia", "Heroic Charge", "Diplomatic Immunity"}, new String[] {"勇敢な戦士", "渾身の一撃", "デマーシアの規範", "勇猛な突進", "絶対的特権"}, new String[] {"Poppy_ValiantFighter", "PoppyDevastatingBlow", "PoppyParagonOfDemacia", "PoppyHeroicCharge", "PoppyDiplomaticImmunity"}),

    /** Quinn Definition */
    Quinn("Quinn", "クイン", 532.8F, 85.0F, 5.42F, 0.55F, 268.8F, 35.0F, 6.97F, 0.4F, 51.04F, 3.0F, -0.065F, 3.1F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Harrier", "Blinding Assault", "Heightened Senses", "Vault", "Tag Team"}, new String[] {"鷲匠", "暗闇の強襲", "鷹の眼", "飛翔撃", "相棒"}, new String[] {"Quinn_Passive", "QuinnQ", "QuinnW", "QuinnE", "QuinnR"}),

    /** Rammus Definition */
    Rammus("Rammus", "ラムス", 564.48F, 86.0F, 7.92F, 0.55F, 310.44F, 33.0F, 7.84F, 0.5F, 55.88F, 3.5F, 0.0F, 2.215F, 0.0F, 0.0F, 31.384F, 3.8F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Spiked Shell", "Powerball", "Defensive Ball Curl", "Puncturing Taunt", "Tremors"}, new String[] {"トゲトゲ", "ころころ", "大防御", "ちくちく", "ドスンドスン"}, new String[] {"Armordillo_ScavengeArmor", "PowerBall", "DefensiveBallCurl", "PuncturingTaunt", "Tremors2"}),

    /** Rek'Sai Definition */
    RekSai("Rek'Sai", "レク＝サイ", 570.0F, 90.0F, 7.34F, 0.65F, 100.0F, 0.0F, 0.0F, 0.0F, 55.628F, 3.35F, 0.0F, 2.0F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 0.0F, 335.0F, 175.0F, new String[] {"Fury of the Xer'Sai", "Queen's Wrath / Prey Seeker", "Burrow / Un-burrow", "Furious Bite / Tunnel", "Void Rush"}, new String[] {"ゼル＝サイの怒り", "女王の怒り/獲物定め", "潜伏/襲撃", "激情の牙/掘削", "ヴォイドの猛攻"}, new String[] {"RekSai_Passive", "RekSaiQ", "RekSaiW", "RekSaiE", "RekSaiR"}),

    /** Renekton Definition */
    Renekton("Renekton", "レネクトン", 572.16F, 87.0F, 7.96F, 0.75F, 100.0F, 0.0F, 0.0F, 0.0F, 58.328F, 3.1F, -0.06F, 2.65F, 0.0F, 0.0F, 25.584F, 3.8F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Reign of Anger", "Cull the Meek", "Ruthless Predator", "Slice and Dice", "Dominus"}, new String[] {"怒りの支配", "肉削ぎ", "無慈悲な連撃", "斬り切り舞", "凶暴化"}, new String[] {"Renekton_Predator", "RenektonCleave", "RenektonPreExecute", "RenektonSliceAndDice", "RenektonReignOfTheTyrant"}),

    /** Rengar Definition */
    Rengar("Rengar", "レンガー", 586.2F, 90.0F, 4.27F, 0.4F, 5.0F, 0.0F, 0.0F, 0.0F, 60.04F, 3.0F, -0.08F, 2.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Unseen Predator", "Savagery", "Battle Roar", "Bola Strike", "Thrill of the Hunt"}, new String[] {"見えざる襲撃者", "逆上", "狩りの雄叫び", "鉄球の投げ縄", "狩猟本能"}, new String[] {"Rengar_Passive", "RengarQ", "RengarW", "RengarE", "RengarR"}),

    /** Riven Definition */
    Riven("Riven", "リヴェン", 558.48F, 86.0F, 3.34F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 56.04F, 3.0F, 0.0F, 3.5F, 0.0F, 0.0F, 24.376F, 3.2F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {"Runic Blade", "Broken Wings", "Ki Burst", "Valor", "Blade of the Exile"}, new String[] {"ルーンの剣", "折れた翼", "気功破", "勇躍", "追放者の剣"}, new String[] {"RivenRunicBlades", "RivenTriCleave", "RivenMartyr", "RivenFeint", "RivenFengShuiEngine"}),

    /** Rumble Definition */
    Rumble("Rumble", "ランブル", 584.4F, 80.0F, 8.005F, 0.6F, 100.0F, 0.0F, 0.0F, 0.0F, 61.036F, 3.2F, -0.03F, 1.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Junkyard Titan", "Flamespitter", "Scrap Shield", "Electro Harpoon", "The Equalizer"}, new String[] {"ポンコツタイタン", "スピットファイア", "ジャンクシールド", "エレクトロハープーン", "イコライザー"}, new String[] {"Rumble_Junkyard Titan1", "RumbleFlameThrower", "RumbleShield", "RumbleGrenade", "RumbleCarpetBomb"}),

    /** Ryze Definition */
    Ryze("Ryze", "ライズ", 558.48F, 86.0F, 5.27F, 0.55F, 342.4F, 55.0F, 5.0F, 1.0F, 55.04F, 3.0F, 0.0F, 2.112F, 0.0F, 0.0F, 21.552F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Arcane Mastery", "Overload", "Rune Prison", "Spell Flux", "Desperate Power"}, new String[] {"古代の呪術", "破呪", "ルーンの牢獄", "呪文跳弾", "禁断の呪力"}, new String[] {"Ryze_P", "RyzeQ", "RyzeW", "RyzeE", "RyzeR"}),

    /** Sejuani Definition */
    Sejuani("Sejuani", "セジュアニ", 600.0F, 95.0F, 8.675F, 0.85F, 400.0F, 40.0F, 7.205F, 0.45F, 57.544F, 3.3F, -0.0672F, 1.44F, 0.0F, 0.0F, 29.54F, 3.0F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {"Frost", "Arctic Assault", "Flail of the Northern Winds", "Permafrost", "Glacial Prison"}, new String[] {"凍傷", "猪突凍進", "北風のフレイル", "永久凍土", "氷河の牢獄"}, new String[] {"Sejuani_Passive", "SejuaniArcticAssault", "SejuaniNorthernWinds", "SejuaniWintersClaw", "SejuaniGlacialPrisonStart"}),

    /** Shaco Definition */
    Shaco("Shaco", "シャコ", 582.12F, 84.0F, 8.37F, 0.55F, 297.2F, 40.0F, 7.155F, 0.45F, 57.58F, 3.5F, -0.1F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Backstab", "Deceive", "Jack In The Box", "Two-Shiv Poison", "Hallucinate"}, new String[] {"背後からの一撃", "幻惑", "びっくり箱", "両刃の毒短剣", "幻覚"}, new String[] {"Jester_CarefulStrikes", "Deceive", "JackInTheBox", "TwoShivPoison", "HallucinateFull"}),

    /** Shen Definition */
    Shen("Shen", "シェン", 570.8F, 85.0F, 8.37F, 0.55F, 200.0F, 0.0F, 50.0F, 0.0F, 60.17F, 3.375F, -0.04F, 3.4F, 0.0F, 0.0F, 25.72F, 4.0F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Ki Strike", "Vorpal Blade", "Feint", "Shadow Dash", "Stand United"}, new String[] {"気功斬", "吸命刀", "護遁の術", "殺気駆け", "刹那護法"}, new String[] {"Shen_KiStrike", "ShenVorpalStar", "ShenFeint", "ShenShadowDash", "ShenStandUnited"}),

    /** Shyvana Definition */
    Shyvana("Shyvana", "シヴァーナ", 594.6F, 95.0F, 8.59F, 0.8F, 100.0F, 0.0F, 0.0F, 0.0F, 60.712F, 3.4F, -0.05F, 2.5F, 0.0F, 0.0F, 27.628F, 3.35F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Dragonborn", "Twin Bite", "Burnout", "Flame Breath", "Dragon's Descent"}, new String[] {"龍族の血脈", "双咬撃", "烈風炎", "火炎の息吹", "龍族の血統"}, new String[] {"ShyvanaReinforcedScales", "ShyvanaDoubleAttack", "ShyvanaImmolationAura", "ShyvanaFireball", "ShyvanaTransformCast"}),

    /** Singed Definition */
    Singed("Singed", "シンジド", 542.76F, 82.0F, 8.02F, 0.55F, 290.6F, 45.0F, 7.52F, 0.55F, 62.32F, 3.375F, 0.02F, 1.81F, 0.0F, 0.0F, 27.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Empowered Bulwark", "Poison Trail", "Mega Adhesive", "Fling", "Insanity Potion"}, new String[] {"肉体強化", "猛毒の跡", "強力粘着剤", "ぶん投げ", "狂人のポーション"}, new String[] {"Singed_Passive", "PoisonTrail", "MegaAdhesive", "Fling", "InsanityPotion"}),

    /** Sion Definition */
    Sion("Sion", "サイオン", 542.64F, 73.0F, 10.18F, 0.8F, 275.6F, 45.0F, 8.005F, 0.6F, 59.72F, 4.0F, -0.08F, 1.3F, 0.0F, 0.0F, 23.04F, 3.0F, 32.1F, 0.0F, 345.0F, 150.0F, new String[] {"Glory in Death", "Decimating Smash", "Soul Furnace", "Roar of the Slayer", "Unstoppable Onslaught"}, new String[] {"名誉ある死", "破滅の斧", "魂の炉心", "殺意の雄叫び", "猪突猛進"}, new String[] {"Sion_Passive1", "SionQ", "SionW", "SionE", "SionR"}),

    /** Sivir Definition */
    Sivir("Sivir", "シヴィア", 515.76F, 82.0F, 5.17F, 0.55F, 284.0F, 50.0F, 8.01F, 0.9F, 52.04F, 3.0F, -0.05F, 1.6F, 0.0F, 0.0F, 22.21F, 3.25F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {"Fleet of Foot", "Boomerang Blade", "Ricochet", "Spell Shield", "On The Hunt"}, new String[] {"戦駆け", "ぶっ放し", "跳刃", "破魔の護り", "狩猟の幕開け"}, new String[] {"Sivir_Passive", "SivirQ", "SivirW", "SivirE", "SivirR"}),

    /** Skarner Definition */
    Skarner("Skarner", "スカーナー", 601.28F, 96.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.0F, 2.1F, 0.0F, 0.0F, 29.384F, 3.8F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Crystallizing Sting", "Crystal Slash", "Crystalline Exoskeleton", "Fracture", "Impale"}, new String[] {"水晶の針", "水晶波斬", "外殻水晶化", "破砕弾", "狙い刺し"}, new String[] {"Skarner_Passive", "SkarnerVirulentSlash", "SkarnerExoskeleton", "SkarnerFracture", "SkarnerImpale"}),

    /** Sona Definition */
    Sona("Sona", "ソナ", 482.36F, 77.0F, 5.42F, 0.55F, 340.6F, 45.0F, 9.0F, 0.4F, 50.04F, 3.0F, -0.03F, 2.3F, 0.0F, 0.0F, 20.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Power Chord", "Hymn of Valor", "Aria of Perseverance", "Song of Celerity", "Crescendo"}, new String[] {"パワーコード", "義勇の賛歌", "堅忍のアリア", "疾風の歌", "クレッシェンド"}, new String[] {"Sona_Passive_Charged", "SonaQ", "SonaW", "SonaE", "SonaR"}),

    /** Soraka Definition */
    Soraka("Soraka", "ソラカ", 529.04F, 78.0F, 2.5F, 0.5F, 350.8F, 60.0F, 9.0F, 0.4F, 50.04F, 3.0F, 0.0F, 2.14F, 0.0F, 0.0F, 23.384F, 3.8F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Salvation", "Starcall", "Astral Infusion", "Equinox", "Wish"}, new String[] {"救済", "星のささやき", "星霊の癒し", "星の静寂", "願い"}, new String[] {"Soraka_Passive", "SorakaQ", "SorakaW", "SorakaE", "SorakaR"}),

    /** Swain Definition */
    Swain("Swain", "スウェイン", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, 0.0F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {"Carrion Renewal", "Decrepify", "Nevermove", "Torment", "Ravenous Flock"}, new String[] {"屍食再生", "戦慄の怪鳥", "漆黒の束縛", "苦悶", "黒烏の恐襲"}, new String[] {"SwainCarrionRenewal", "SwainDecrepify", "SwainShadowGrasp", "SwainTorment", "SwainMetamorphism"}),

    /** Syndra Definition */
    Syndra("Syndra", "シンドラ", 511.04F, 78.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.872F, 2.9F, 0.0F, 2.0F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Transcendent", "Dark Sphere", "Force of Will", "Scatter the Weak", "Unleashed Power"}, new String[] {"絶大なる魔力", "闇の魔珠", "魔力の制御", "魔力四散", "魔力解放"}, new String[] {"SyndraPassive", "SyndraQ", "SyndraW", "SyndraE", "SyndraR"}),

    /** Tahm Kench Definition */
    TahmKench("Tahm Kench", "Tahm Kench", 610.0F, 95.0F, 6.5F, 0.55F, 325.0F, 40.0F, 5.5F, 1.0F, 56.0F, 3.2F, 0.0F, 2.5F, 0.0F, 0.0F, 27.0F, 3.0F, 32.1F, 0.0F, 335.0F, 200.0F, new String[] {"An Acquired Taste", "Tongue Lash", "Devour", "Thick Skin", "Abyssal Voyage"}, new String[] {"An Acquired Taste", "Tongue Lash", "Devour", "Thick Skin", "Abyssal Voyage"}, new String[] {"TahmKench_P", "TahmKenchQ", "TahmKenchW", "TahmKenchE", "TahmKenchNewR"}),

    /** Talon Definition */
    Talon("Talon", "タロン", 582.8F, 85.0F, 8.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"Mercy", "Noxian Diplomacy", "Rake", "Cutthroat", "Shadow Assault"}, new String[] {"刃の慈悲", "ノクサスの刃", "飛燕手裏剣", "瞬刃", "影刃円舞"}, new String[] {"TalonMercy", "TalonNoxianDiplomacy", "TalonRake", "TalonCutthroat", "TalonShadowAssault"}),

    /** Taric Definition */
    Taric("Taric", "タリック", 619.2F, 90.0F, 7.94F, 0.5F, 349.08F, 56.0F, 6.0F, 0.8F, 57.88F, 3.5F, 0.0F, 2.02F, 0.0F, 0.0F, 25.876F, 3.2F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {"Gemcraft", "Imbue", "Shatter", "Dazzle", "Radiance"}, new String[] {"ジェムクラフト", "パワーストーン", "ジェムクラッシュ", "プリズムチャーム", "シャイニング"}, new String[] {"GemKnight_Gemcraft", "Imbue", "Shatter", "Dazzle", "TaricHammerSmash"}),

    /** Teemo Definition */
    Teemo("Teemo", "ティーモ", 515.76F, 82.0F, 5.74F, 0.65F, 267.2F, 40.0F, 7.205F, 0.45F, 47.54F, 3.0F, -0.0947F, 3.38F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 330.0F, 500.0F, new String[] {"Camouflage", "Blinding Dart", "Move Quick", "Toxic Shot", "Noxious Trap"}, new String[] {"身隠し", "目つぶしダーツ", "駆け足！", "毒たっぷり吹き矢", "毒キノコ"}, new String[] {"Teemo_Camouflage", "BlindingDart", "MoveQuick", "ToxicShot", "BantamTrap"}),

    /** Thresh Definition */
    Thresh("Thresh", "スレッシュ", 560.52F, 89.0F, 6.92F, 0.55F, 273.92F, 44.0F, 6.0F, 0.8F, 47.696F, 2.2F, 0.0F, 3.5F, 0.0F, 0.0F, 16.0F, 0.0F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Damnation", "Death Sentence", "Dark Passage", "Flay", "The Box"}, new String[] {"魂の束縛", "死の宣告", "嘆きの魂灯", "絶望の鎖", "魂の牢獄"}, new String[] {"Thresh_Passive", "ThreshQ", "ThreshW", "ThreshE", "ThreshRPenta"}),

    /** Tristana Definition */
    Tristana("Tristana", "トリスターナ", 542.76F, 82.0F, 6.19F, 0.65F, 246.76F, 32.0F, 7.205F, 0.45F, 51.54F, 3.0F, -0.04734F, 1.5F, 0.0F, 0.0F, 22.0F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Draw a Bead", "Rapid Fire", "Rocket Jump", "Explosive Charge", "Buster Shot"}, new String[] {"ドロー＆グロー", "ラピッドファイア", "ロケットジャンプ", "ヨードルグレネード", "バスターショット"}, new String[] {"Tristana_Passive", "TristanaQ", "TristanaW", "TristanaE", "TristanaR"}),

    /** Trundle Definition */
    Trundle("Trundle", "トランドル", 616.28F, 96.0F, 9.425F, 0.85F, 281.6F, 45.0F, 7.505F, 0.6F, 60.04F, 3.0F, -0.0672F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {"King's Tribute", "Chomp", "Frozen Domain", "Pillar of Ice", "Subjugate"}, new String[] {"王への貢物", "噛み付き", "凍てつく大地", "氷冷の柱", "暴虐なる搾取"}, new String[] {"Trundle_Passive", "TrundleTrollSmash", "trundledesecrate", "TrundleCircle", "TrundlePain"}),

    /** Tryndamere Definition */
    Tryndamere("Tryndamere", "トリンダミア", 625.64F, 98.0F, 8.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 61.376F, 3.2F, -0.0672F, 2.9F, 0.0F, 0.0F, 24.108F, 3.1F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Battle Fury", "Bloodlust", "Mocking Shout", "Spinning Slash", "Undying Rage"}, new String[] {"戦場の咆哮", "血の欲望", "嘲りの叫び", "旋回斬り", "不死の憤激"}, new String[] {"Tryndamere_Passive", "Bloodlust", "MockingShout", "slashCast", "UndyingRage"}),

    /** Twisted Fate Definition */
    TwistedFate("Twisted Fate", "フェイト", 521.76F, 82.0F, 5.505F, 0.6F, 265.84F, 38.0F, 6.0F, 0.8F, 49.954F, 3.3F, -0.04F, 3.22F, 0.0F, 0.0F, 20.542F, 3.15F, 30.0F, 0.0F, 330.0F, 525.0F, new String[] {"Loaded Dice", "Wild Cards", "Pick A Card", "Stacked Deck", "Destiny"}, new String[] {"イカサマダイス", "ワイルドカード", "ドロー", "フォーカード", "デスティニー"}, new String[] {"Cardmaster_SealFate", "WildCards", "PickACard", "CardmasterStack", "Destiny"}),

    /** Twitch Definition */
    Twitch("Twitch", "トゥイッチ", 525.08F, 81.0F, 6.005F, 0.6F, 287.2F, 40.0F, 7.255F, 0.45F, 49.04F, 3.0F, -0.08F, 3.38F, 0.0F, 0.0F, 23.04F, 3.0F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Deadly Venom", "Ambush", "Venom Cask", "Contaminate", "Rat-Ta-Tat-Tat"}, new String[] {"致死毒", "奇襲", "毒瓶投げ", "致死毒活発化", "ラッタッタッタッタ"}, new String[] {"Twitch_Passive", "TwitchHideInShadows", "TwitchVenomCask", "TwitchExpunge", "TwitchFullAutomatic"}),

    /** Udyr Definition */
    Udyr("Udyr", "ウディア", 593.32F, 99.0F, 8.71F, 0.75F, 270.4F, 30.0F, 7.505F, 0.45F, 58.286F, 3.2F, -0.05F, 2.67F, 0.0F, 0.0F, 25.47F, 4.0F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Monkey's Agility", "Tiger Stance", "Turtle Stance", "Bear Stance", "Phoenix Stance"}, new String[] {"乱撃高揚", "虎形態", "亀形態", "熊形態", "不死鳥形態"}, new String[] {"Udyr_MonkeysAgility", "UdyrTigerStance", "UdyrTurtleStance", "UdyrBearStance", "UdyrPhoenixStance"}),

    /** Urgot Definition */
    Urgot("Urgot", "アーゴット", 586.52F, 89.0F, 6.505F, 0.6F, 312.4F, 55.0F, 8.59F, 0.65F, 52.048F, 3.6F, -0.03F, 2.9F, 0.0F, 0.0F, 24.544F, 3.3F, 30.0F, 0.0F, 335.0F, 425.0F, new String[] {"Zaun-Touched Bolt Augmenter", "Acid Hunter", "Terror Capacitor", "Noxian Corrosive Charge", "Hyper-Kinetic Position Reverser"}, new String[] {"ゾウン・デストラクション", "アシッドハンター", "テラーコンデンサー", "ノクサス・コラプトシェル", "ハイパーキネティック・ポジションリバーサー"}, new String[] {"Urgot_Passive", "UrgotHeatseekingMissile", "UrgotTerrorCapacitorActive2", "UrgotPlasmaGrenade", "UrgotSwap2"}),

    /** Varus Definition */
    Varus("Varus", "ヴァルス", 537.76F, 82.0F, 5.42F, 0.55F, 310.48F, 36.0F, 7.34F, 0.8F, 49.04F, 3.0F, -0.05F, 3.0F, 0.0F, 0.0F, 23.212F, 3.4F, 30.0F, 0.0F, 330.0F, 575.0F, new String[] {"Living Vengeance", "Piercing Arrow", "Blighted Quiver", "Hail of Arrows", "Chain of Corruption"}, new String[] {"復讐の化身", "渾身の一矢", "枯死の矢筒", "滅びの矢雨", "穢れの連鎖"}, new String[] {"VarusPassive", "VarusQ", "VarusW", "VarusE", "VarusR"}),

    /** Vayne Definition */
    Vayne("Vayne", "ヴェイン", 498.44F, 83.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 53.46F, 3.25F, -0.05F, 4.0F, 0.0F, 0.0F, 19.012F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Night Hunter", "Tumble", "Silver Bolts", "Condemn", "Final Hour"}, new String[] {"闇夜の狩人　", "転撃", "銀の矢", "制裁", "決戦"}, new String[] {"Vayne_NightHunter", "VayneTumble", "VayneSilveredBolts", "VayneCondemn", "VayneInquisition"}),

    /** Veigar Definition */
    Veigar("Veigar", "ヴェイガー", 492.76F, 82.0F, 5.42F, 0.55F, 342.4F, 55.0F, 6.0F, 0.8F, 50.71F, 2.625F, 0.0F, 2.24F, 0.0F, 0.0F, 22.55F, 3.75F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {"Equilibrium", "Baleful Strike", "Dark Matter", "Event Horizon", "Primordial Burst"}, new String[] {"ワールドバランス", "イーヴィルストライク", "ダークマター", "イベントホライズン", "メテオバースト"}, new String[] {"Veigar_Entropy", "VeigarBalefulStrike", "VeigarDarkMatter", "VeigarEventHorizon", "VeigarPrimordialBurst"}),

    /** Vel'Koz Definition */
    Velkoz("Vel'Koz", "ヴェル＝コズ", 507.68F, 76.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.937874F, 3.1415927F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {"Organic Deconstruction", "Plasma Fission", "Void Rift", "Tectonic Disruption", "Life Form Disintegration Ray"}, new String[] {"有機分解", "電離炸裂弾", "ヴォイドの裂谷", "地殻砕裂", "生体破壊光線"}, new String[] {"Velkoz_Passive", "VelkozQ", "VelkozW", "VelkozE", "VelkozR"}),

    /** Vi Definition */
    Vi("Vi", "ヴァイ", 582.8F, 85.0F, 9.01F, 0.9F, 295.6F, 45.0F, 8.09F, 0.65F, 55.88F, 3.5F, -0.03F, 2.5F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Blast Shield", "Vault Breaker", "Denting Blows", "Excessive Force", "Assault and Battery"}, new String[] {"爆風の護り", "一拳必殺", "タコ殴り", "爆拳衝", "無慈悲な強襲"}, new String[] {"ViPassive", "ViQ", "ViW", "ViE", "ViR"}),

    /** Viktor Definition */
    Viktor("Viktor", "ヴィクター", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, -0.05F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Glorious Evolution", "Siphon Power", "Gravity Field", "Death Ray", "Chaos Storm"}, new String[] {"グロリアス・エヴォリューション", "パワーブラスト", "グラビティフィールド", "デス・レイ", "カオスストーム"}, new String[] {"Viktor_Passive", "ViktorPowerTransfer", "ViktorGravitonField", "ViktorDeathRay", "ViktorChaosStorm"}),

    /** Vladimir Definition */
    Vladimir("Vladimir", "ヴラッドミア", 542.8F, 85.0F, 7.005F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 48.04F, 3.0F, -0.05F, 2.0F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Crimson Pact", "Transfusion", "Sanguine Pool", "Tides of Blood", "Hemoplague"}, new String[] {"真紅の盟約", "吸血", "紅血の沼", "血液奔流", "呪血の渦"}, new String[] {"Vladimir_BloodGorged", "VladimirTransfusion", "VladimirSanguinePool", "VladimirTidesofBlood", "VladimirHemoplague"}),

    /** Volibear Definition */
    Volibear("Volibear", "ヴォリベア", 584.48F, 86.0F, 8.09F, 0.65F, 270.4F, 30.0F, 8.09F, 0.65F, 59.544F, 3.3F, -0.05F, 2.67F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Chosen of the Storm", "Rolling Thunder", "Frenzy", "Majestic Roar", "Thunder Claws"}, new String[] {"嵐に選ばれし者", "鳴雷", "獰猛", "雄大な咆哮", "稲妻の爪"}, new String[] {"VolibearPassive", "VolibearQ", "VolibearW", "VolibearE", "VolibearR"}),

    /** Warwick Definition */
    Warwick("Warwick", "ワーウィック", 592.64F, 98.0F, 8.39F, 0.8F, 240.4F, 30.0F, 8.105F, 0.6F, 62.43F, 3.375F, -0.08F, 2.88F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Eternal Thirst", "Hungering Strike", "Hunters Call", "Blood Scent", "Infinite Duress"}, new String[] {"永遠の渇き", "餓狼", "狩りの遠吠え", "血の香", "無慈悲な狼撃"}, new String[] {"Warwick_InnerHunger", "HungeringStrike", "HuntersCall", "BloodScent", "InfiniteDuress"}),

    /** Xerath Definition */
    Xerath("Xerath", "ゼラス", 514.4F, 80.0F, 5.42F, 0.55F, 316.96F, 47.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {"Mana Surge", "Arcanopulse", "Eye of Destruction", "Shocking Orb", "Rite of the Arcane"}, new String[] {"マナ吸引", "魔力の波動", "破滅の瞳", "衝撃の宝珠", "深淵の儀式"}, new String[] {"Xerath_Passive1", "XerathArcanopulseChargeUp", "XerathArcaneBarrage2", "XerathMageSpear", "XerathLocusOfPower2"}),

    /** Xin Zhao Definition */
    XinZhao("Xin Zhao", "シン・ジャオ", 591.16F, 87.0F, 8.175F, 0.7F, 273.8F, 35.0F, 7.255F, 0.45F, 57.544F, 3.3F, -0.07F, 2.6F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 175.0F, new String[] {"Challenge", "Three Talon Strike", "Battle Cry", "Audacious Charge", "Crescent Sweep"}, new String[] {"一意専心", "三槍撃", "気焔万丈", "勇将の猛進", "三日月槍舞"}, new String[] {"XinZhao_TirelessWarrior", "XenZhaoComboTarget", "XenZhaoBattleCry", "XenZhaoSweep", "XenZhaoParry"}),

    /** Yasuo Definition */
    Yasuo("Yasuo", "ヤスオ", 517.76F, 82.0F, 6.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 55.376F, 3.2F, -0.05F, 3.2F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 345.0F, 175.0F, new String[] {"Way of the Wanderer", "Steel Tempest", "Wind Wall", "Sweeping Blade", "Last Breath"}, new String[] {"浪人道", "百錬一刀", "風殺の壁", "居合斬り", "鬼哭啾々"}, new String[] {"Yasuo_Passive", "YasuoQW", "YasuoWMovingWall", "YasuoDashWrapper", "YasuoRKnockUpComboW"}),

    /** Yorick Definition */
    Yorick("Yorick", "ヨーリック", 563.8F, 85.0F, 8.175F, 0.7F, 293.8F, 35.0F, 6.755F, 0.45F, 57.58F, 3.5F, 0.0F, 3.0F, 0.0F, 0.0F, 25.048F, 3.6F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Unholy Covenant", "Omen of War", "Omen of Pestilence", "Omen of Famine", "Omen of Death"}, new String[] {"不浄な誓約", "戦の凶兆", "疫の凶兆", "飢の凶兆", "死の凶兆"}, new String[] {"YorickUnholyCovenant", "YorickSpectral", "YorickDecayed", "YorickRavenous", "YorickReviveAlly"}),

    /** Zac Definition */
    Zac("Zac", "ザック", 614.6F, 95.0F, 7.92F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 59.67F, 3.375F, -0.02F, 1.6F, 0.0F, 0.0F, 23.88F, 3.5F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {"Cell Division", "Stretching Strike", "Unstable Matter", "Elastic Slingshot", "Let's Bounce!"}, new String[] {"細胞分裂", "ノビノビパンチ", "ボインボイン", "スライミーショット", "ボムボムスラム"}, new String[] {"ZacPassive", "ZacQ", "ZacW", "ZacE", "ZacR"}),

    /** Zed Definition */
    Zed("Zed", "ゼド", 579.4F, 80.0F, 7.09F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 54.712F, 3.4F, -0.03F, 2.1F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {"Contempt for the Weak", "Razor Shuriken", "Living Shadow", "Shadow Slash", "Death Mark"}, new String[] {"弱者必衰", "風車手裏剣", "影分身", "闇討ち", "死の刻印"}, new String[] {"shadowninja_P", "ZedShuriken", "ZedShadowDash", "ZedPBAOEDummy", "ZedUlt"}),

    /** Ziggs Definition */
    Ziggs("Ziggs", "ジグス", 524.4F, 80.0F, 6.255F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 54.208F, 3.1F, -0.04734F, 2.0F, 0.0F, 0.0F, 21.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Short Fuse", "Bouncing Bomb", "Satchel Charge", "Hexplosive Minefield", "Mega Inferno Bomb"}, new String[] {"ショートヒューズ", "バウンドボム", "エンジニアボム", "ヘクステックマイン", "メガインフェルノボム"}, new String[] {"ZiggsPassiveReady", "ZiggsQ", "ZiggsW", "ZiggsE", "ZiggsR"}),

    /** Zilean Definition */
    Zilean("Zilean", "ジリアン", 499.28F, 77.0F, 5.44F, 0.5F, 360.8F, 60.0F, 6.0F, 0.8F, 51.64F, 3.0F, 0.0F, 2.13F, 0.0F, 0.0F, 19.134F, 3.8F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Heightened Learning", "Time Bomb", "Rewind", "Time Warp", "Chronoshift"}, new String[] {"ハイスピードラーニング", "タイムボム", "リ・ウィンド", "タイムワープ", "クロノシフト"}, new String[] {"Zilean_Passive", "ZileanQ", "ZileanW", "TimeWarp", "ChronoShift"}),

    /** Zyra Definition */
    Zyra("Zyra", "ザイラ", 479.32F, 74.0F, 5.69F, 0.5F, 334.0F, 50.0F, 6.0F, 0.8F, 53.376F, 3.2F, 0.0F, 2.11F, 0.0F, 0.0F, 20.04F, 3.0F, 30.0F, 0.0F, 325.0F, 575.0F, new String[] {"Rise of the Thorns", "Deadly Bloom", "Rampant Growth", "Grasping Roots", "Stranglethorns"}, new String[] {"最後の一咲き", "死華の誘い", "狂い咲き", "捕縛の根", "茨のゆりかご"}, new String[] {"ZyraP", "ZyraQFissure", "ZyraSeed", "ZyraGraspingRoots", "ZyraBrambleZone"});

    /** Champion status. */
    public final String name;

    /** Champion status. */
    public final String localizedName;

    /** Champion status. */
    public final float hp;

    /** Champion status. */
    public final float hpPer;

    /** Champion status. */
    public final float hreg;

    /** Champion status. */
    public final float hregPer;

    /** Champion status. */
    public final float mp;

    /** Champion status. */
    public final float mpPer;

    /** Champion status. */
    public final float mreg;

    /** Champion status. */
    public final float mregPer;

    /** Champion status. */
    public final float ad;

    /** Champion status. */
    public final float adPer;

    /** Champion status. */
    public final float as;

    /** Champion status. */
    public final float asPer;

    /** Champion status. */
    public final float crit;

    /** Champion status. */
    public final float critPer;

    /** Champion status. */
    public final float ar;

    /** Champion status. */
    public final float arPer;

    /** Champion status. */
    public final float mr;

    /** Champion status. */
    public final float mrPer;

    /** Champion status. */
    public final float ms;

    /** Champion status. */
    public final float range;

    /** Champion status. */
    public final String[] skills;

    /** Champion status. */
    public final String[] skillLocalized;

    /** Champion status. */
    public final String[] skillSystem;

    /**
     * The champion definition.
     */
    private RiotChampionData(String name, String localizedName, float hp, float hpPer, float hreg, float hregPer, float mp, float mpPer, float mreg, float mregPer, float ad, float adPer, float as, float asPer, float crit, float critPer, float ar, float arPer, float mr, float mrPer, float ms, float range, String[] skills, String[] skillLocalized, String[] skillSystem) {
        this.name = name;
        this.localizedName = localizedName;
        this.hp = hp;
        this.hpPer = hpPer;
        this.hreg = hreg;
        this.hregPer = hregPer;
        this.mp = mp;
        this.mpPer = mpPer;
        this.mreg = mreg;
        this.mregPer = mregPer;
        this.ad = ad;
        this.adPer = adPer;
        this.as = as;
        this.asPer = asPer;
        this.crit = crit;
        this.critPer = critPer;
        this.ar = ar;
        this.arPer = arPer;
        this.mr = mr;
        this.mrPer = mrPer;
        this.ms = ms;
        this.range = range;
        this.skills = skills;
        this.skillLocalized = skillLocalized;
        this.skillSystem = skillSystem;
    }
}
