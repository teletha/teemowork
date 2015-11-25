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

import java.util.List;
import java.util.ArrayList;
import teemowork.model.SkillDefinition;
import teemowork.model.Champion;

public class RiotChampionData {

    /** Champion Manager */
    protected static final List<Champion> champions = new ArrayList();

    /** Aatrox Definition */
    public static final Champion Aatrox = new Champion(266, "Aatrox", "エイトロックス", "Aatrox", 537.8F, 85.0F, 6.59F, 0.5F, 105.6F, 45.0F, 0.0F, 0.0F, 60.376F, 3.2F, 0.651F, 3.0F, 0.0F, 0.0F, 24.384F, 3.8F, 32.1F, 1.25F, 345.0F, 150.0F, new String[] {"Blood Well", "Dark Flight", "Blood Thirst / Blood Price", "Blades of Torment", "Massacre"}, new String[] {"血の泉", "闇の翼", "血の渇望/血の代償", "嘆きの刃", "大虐殺"}, SkillDefinition::Aatrox, false);

    /** Ahri Definition */
    public static final Champion Ahri = new Champion(103, "Ahri", "アーリ", "Ahri", 514.4F, 80.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.04F, 3.0F, 0.668F, 2.0F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Essence Theft", "Orb of Deception", "Fox-Fire", "Charm", "Spirit Rush"}, new String[] {"精気吸引", "幻惑の宝珠", "狐火", "魅了", "妖狐演舞"}, SkillDefinition::Ahri, false);

    /** Akali Definition */
    public static final Champion Akali = new Champion(84, "Akali", "アカリ", "Akali", 587.8F, 85.0F, 8.34F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 58.376F, 3.2F, 0.694F, 3.1F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Twin Disciplines", "Mark of the Assassin", "Twilight Shroud", "Crescent Slash", "Shadow Dance"}, new String[] {"双の行", "刺客の刻印", "薄闇の帳", "三日月斬り", "影の舞"}, SkillDefinition::Akali, false);

    /** Alistar Definition */
    public static final Champion Alistar = new Champion(12, "Alistar", "アリスター", "Alistar", 613.36F, 106.0F, 8.675F, 0.85F, 278.84F, 38.0F, 8.5F, 0.8F, 61.1116F, 3.62F, 0.625F, 2.125F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 1.25F, 330.0F, 125.0F, new String[] {"Trample", "Pulverize", "Headbutt", "Triumphant Roar", "Unbreakable Will"}, new String[] {"踏破", "圧砕", "頭突き", "戦士の咆哮", "不屈の意志"}, SkillDefinition::Alistar, false);

    /** Amumu Definition */
    public static final Champion Amumu = new Champion(32, "Amumu", "アムム", "Amumu", 613.12F, 84.0F, 8.875F, 0.85F, 287.2F, 40.0F, 7.38F, 0.525F, 53.384F, 3.8F, 0.638F, 2.18F, 0.0F, 0.0F, 23.544F, 3.8F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Cursed Touch", "Bandage Toss", "Despair", "Tantrum", "Curse of the Sad Mummy"}, new String[] {"呪いの手", "絡みつく包帯", "涙の池", "あばれる", "泣き虫ミイラの呪い"}, SkillDefinition::Amumu, false);

    /** Anivia Definition */
    public static final Champion Anivia = new Champion(34, "Anivia", "アニヴィア", "Anivia", 467.6F, 70.0F, 5.57F, 0.55F, 396.04F, 50.0F, 6.0F, 0.8F, 51.376F, 3.2F, 0.625F, 1.68F, 0.0F, 0.0F, 21.22F, 4.0F, 30.0F, 0.0F, 325.0F, 600.0F, new String[] {"Rebirth", "Flash Frost", "Crystallize", "Frostbite", "Glacial Storm"}, new String[] {"再誕", "結氷の煌めき", "氷塊の壁", "一振りの氷柱", "凍てつく吹雪"}, SkillDefinition::Anivia, false);

    /** Annie Definition */
    public static final Champion Annie = new Champion(1, "Annie", "アニー", "Annie", 511.68F, 76.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 50.41F, 2.625F, 0.579F, 1.36F, 0.0F, 0.0F, 19.22F, 4.0F, 30.0F, 0.0F, 335.0F, 575.0F, new String[] {"Pyromania", "Disintegrate", "Incinerate", "Molten Shield", "Summon: Tibbers"}, new String[] {"火遊びだいすき", "ファイアボール", "バーニングファイア", "モルテンシールド", "でておいで！ティバーズ！"}, SkillDefinition::Annie, false);

    /** Ashe Definition */
    public static final Champion Ashe = new Champion(22, "Ashe", "アッシュ", "Ashe", 527.72F, 79.0F, 5.42F, 0.55F, 280.0F, 32.0F, 6.97F, 0.4F, 56.508F, 2.26F, 0.658F, 3.33F, 0.0F, 0.0F, 21.212F, 3.4F, 30.0F, 0.0F, 325.0F, 600.0F, new String[] {"Frost Shot", "Ranger's Focus", "Volley", "Hawkshot", "Enchanted Crystal Arrow"}, new String[] {"フロストショット", "レンジャーのフォーカス", "ボレー", "ホークショット", "クリスタルアロー"}, SkillDefinition::Ashe, false);

    /** Azir Definition */
    public static final Champion Azir = new Champion(268, "Azir", "アジール", "Azir", 524.4F, 80.0F, 6.92F, 0.55F, 350.56F, 42.0F, 6.0F, 0.8F, 52.0F, 2.8F, 0.638F, 1.5F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {"Shurima's Legacy", "Conquering Sands", "Arise!", "Shifting Sands", "Emperor's Divide"}, new String[] {"シュリーマの遺産", "征服の勅命", "目覚めよ！", "流砂の衝撃", "皇帝の断絶"}, SkillDefinition::Azir, false);

    /** Bard Definition */
    public static final Champion Bard = new Champion(432, "Bard", "バード", "Bard", 535.0F, 89.0F, 5.4F, 0.55F, 350.0F, 50.0F, 6.0F, 0.45F, 52.0F, 3.0F, 0.625F, 2.0F, 0.0F, 0.0F, 25.0F, 4.0F, 30.0F, 0.0F, 330.0F, 500.0F, new String[] {"Traveler's Call", "Cosmic Binding", "Caretaker's Shrine", "Magical Journey", "Tempered Fate"}, new String[] {"旅人の呼び声", "宇宙の法則", "回復の遺物", "精霊の旅路", "運命の調律"}, SkillDefinition::Bard, false);

    /** Blitzcrank Definition */
    public static final Champion Blitzcrank = new Champion(53, "Blitzcrank", "ブリッツ", "Blitzcrank", 582.6F, 95.0F, 8.51F, 0.75F, 267.2F, 40.0F, 8.5F, 0.8F, 61.54F, 3.5F, 0.625F, 1.13F, 0.0F, 0.0F, 24.38F, 4.0F, 32.1F, 1.25F, 325.0F, 125.0F, new String[] {"Mana Barrier", "Rocket Grab", "Overdrive", "Power Fist", "Static Field"}, new String[] {"マナバリア", "ロケットグラブ", "オーバードライブ", "パワーフィスト", "イナズマフィールド"}, SkillDefinition::Blitzcrank, false);

    /** Brand Definition */
    public static final Champion Brand = new Champion(63, "Brand", "ブランド", "Brand", 507.68F, 76.0F, 5.42F, 0.55F, 375.6F, 42.0F, 8.005F, 0.6F, 57.04F, 3.0F, 0.625F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Blaze", "Sear", "Pillar of Flame", "Conflagration", "Pyroclasm"}, new String[] {"炎上", "焦炎", "烈火の柱", "焼灼", "業火"}, SkillDefinition::Brand, false);

    /** Braum Definition */
    public static final Champion Braum = new Champion(201, "Braum", "ブラーム", "Braum", 576.16F, 87.0F, 8.18F, 1.0F, 310.6F, 45.0F, 6.0F, 0.8F, 55.376F, 3.2F, 0.644F, 3.5F, 0.0F, 0.0F, 26.72F, 4.5F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Concussive Blows", "Winter's Bite", "Stand Behind Me", "Unbreakable", "Glacial Fissure"}, new String[] {"漢の拳", "冬の凍瘡", "儂に任せとけ！", "不破の盾", "氷河の裂溝"}, SkillDefinition::Braum, false);

    /** Caitlyn Definition */
    public static final Champion Caitlyn = new Champion(51, "Caitlyn", "ケイトリン", "Caitlyn", 524.4F, 80.0F, 5.67F, 0.55F, 313.8F, 35.0F, 7.42F, 0.55F, 53.66F, 2.18F, 0.568F, 4.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 650.0F, new String[] {"Headshot", "Piltover Peacemaker", "Yordle Snap Trap", "90 Caliber Net", "Ace in the Hole"}, new String[] {"ヘッドショット", "ピースメーカー", "ヨードルトラップ", "L-90 カリバーネット", "ブルズアイ"}, SkillDefinition::Caitlyn, false);

    /** Cassiopeia Definition */
    public static final Champion Cassiopeia = new Champion(69, "Cassiopeia", "カシオペア", "Cassiopeia", 506.0F, 75.0F, 5.69F, 0.5F, 370.8F, 60.0F, 8.36F, 0.75F, 52.376F, 3.2F, 0.647F, 1.68F, 0.0F, 0.0F, 22.22F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Aspect of the Serpent", "Noxious Blast", "Miasma", "Twin Fang", "Petrifying Gaze"}, new String[] {"蛇の容貌", "ノクサスの害毒", "瘴毒", "双毒牙", "石化の視線"}, SkillDefinition::Cassiopeia, false);

    /** Cho'Gath Definition */
    public static final Champion Chogath = new Champion(31, "Cho'Gath", "チョ＝ガス", "Chogath", 574.4F, 80.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.625F, 1.44F, 0.0F, 0.0F, 28.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Carnivore", "Rupture", "Feral Scream", "Vorpal Spikes", "Feast"}, new String[] {"暴食", "地裂の棘", "死の叫び声", "絶命の棘", "捕食"}, SkillDefinition::Chogath, false);

    /** Corki Definition */
    public static final Champion Corki = new Champion(42, "Corki", "コーキー", "Corki", 512.76F, 82.0F, 5.42F, 0.55F, 350.16F, 34.0F, 7.42F, 0.55F, 56.0F, 2.5F, 0.625F, 2.3F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Hextech Munitions", "Phosphorus Bomb", "Valkyrie", "Gatling Gun", "Missile Barrage"}, new String[] {"ヘクステック榴散弾", "閃光弾", "ワルキューレの騎行", "ガトリング砲", "連発ミサイル"}, SkillDefinition::Corki, false);

    /** Darius Definition */
    public static final Champion Darius = new Champion(122, "Darius", "ダリウス", "Darius", 582.24F, 100.0F, 9.845F, 0.95F, 263.0F, 37.5F, 6.585F, 0.35F, 56.0F, 5.0F, 0.625F, 1.0F, 0.0F, 0.0F, 30.0F, 4.0F, 32.1F, 1.25F, 340.0F, 175.0F, new String[] {"Hemorrhage", "Decimate", "Crippling Strike", "Apprehend", "Noxian Guillotine"}, new String[] {"大出血", "皆殺しの斧", "薙ぎ払い", "捕縛", "ノクサス斬首斧"}, SkillDefinition::Darius, false);

    /** Diana Definition */
    public static final Champion Diana = new Champion(131, "Diana", "ダイアナ", "Diana", 589.2F, 90.0F, 7.425F, 0.85F, 297.2F, 40.0F, 6.0F, 0.8F, 53.04F, 3.0F, 0.625F, 2.25F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 1.25F, 345.0F, 150.0F, new String[] {"Moonsilver Blade", "Crescent Strike", "Pale Cascade", "Moonfall", "Lunar Rush"}, new String[] {"銀月の刃", "月影", "朧月の羽衣", "瞬月", "月下美刃"}, SkillDefinition::Diana, false);

    /** Dr. Mundo Definition */
    public static final Champion DrMundo = new Champion(36, "Dr. Mundo", "ドクター・ムンド", "DrMundo", 582.52F, 89.0F, 7.76F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 61.27F, 3.0F, 0.625F, 2.8F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Adrenaline Rush", "Infected Cleaver", "Burning Agony", "Masochism", "Sadism"}, new String[] {"アドレナリンラッシュ", "ホウチョウ", "バーニングペイン", "マゾヒズム", "サディズム"}, SkillDefinition::DrMundo, false);

    /** Draven Definition */
    public static final Champion Draven = new Champion(119, "Draven", "ドレイヴン", "Draven", 557.76F, 82.0F, 6.175F, 0.7F, 360.56F, 39.0F, 8.04F, 0.65F, 55.8F, 2.91F, 0.679F, 2.7F, 0.0F, 0.0F, 25.544F, 3.3F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"League of Draven", "Spinning Axe", "Blood Rush", "Stand Aside", "Whirling Death"}, new String[] {"リーグ・オブ・ドレイヴン", "回転斬斧", "血の疼き", "薙ぎ払い", "死の車輪"}, SkillDefinition::Draven, false);

    /** Ekko Definition */
    public static final Champion Ekko = new Champion(245, "Ekko", "エコー", "Ekko", 580.0F, 80.0F, 9.0F, 0.9F, 280.0F, 50.0F, 6.0F, 0.8F, 59.0F, 3.0F, 0.625F, 3.3F, 0.0F, 0.0F, 27.0F, 3.0F, 32.0F, 1.25F, 340.0F, 125.0F, new String[] {"Z-Drive Resonance", "Timewinder", "Parallel Convergence", "Phase Dive", "Chronobreak"}, new String[] {"ゼロ・ドライブ", "タイムワインダー", "パラレルトラップ", "フェイズダイブ", "クロノブレイク"}, SkillDefinition::Ekko, false);

    /** Elise Definition */
    public static final Champion Elise = new Champion(60, "Elise", "エリス", "Elise", 529.4F, 80.0F, 5.705F, 0.6F, 324.0F, 50.0F, 6.0F, 0.8F, 50.54F, 3.0F, 0.625F, 1.75F, 0.0F, 0.0F, 22.128F, 3.35F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Spider Queen", "Neurotoxin", "Volatile Spiderling", "Cocoon", "Spider Form"}, new String[] {"蜘蛛の女王", "神経毒", "子蜘蛛爆弾", "繭化", "蜘蛛形態"}, SkillDefinition::Elise, false);

    /** Elise Definition */
    public static final Champion EliseTransformed = new Champion(-60, "Elise", "エリス", "EliseTransformed", 529.4F, 80.0F, 5.705F, 0.6F, 324.0F, 50.0F, 6.0F, 0.8F, 50.54F, 3.0F, 0.625F, 1.75F, 0.0F, 0.0F, 22.128F, 3.35F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Spider Queen", "Venomous Bite", "Skittering Frenzy", "Rappel", "Human Form"}, new String[] {"蜘蛛の女王", "毒牙", "猛食", "蜘蛛の糸", "ヒト形態"}, SkillDefinition::EliseTransformed, true);

    /** Evelynn Definition */
    public static final Champion Evelynn = new Champion(28, "Evelynn", "エヴェリン", "Evelynn", 531.2F, 90.0F, 9.82F, 0.55F, 315.6F, 42.0F, 8.105F, 0.6F, 53.88F, 3.5F, 0.625F, 3.6F, 0.0F, 0.0F, 26.5F, 3.8F, 32.1F, 1.25F, 340.0F, 125.0F, new String[] {"Shadow Walk", "Hate Spike", "Dark Frenzy", "Ravage", "Agony's Embrace"}, new String[] {"影踏み", "憎悪の棘", "闇の舞", "猛撃", "苦悶の抱擁"}, SkillDefinition::Evelynn, false);

    /** Ezreal Definition */
    public static final Champion Ezreal = new Champion(81, "Ezreal", "エズリアル", "Ezreal", 484.4F, 80.0F, 6.42F, 0.55F, 360.6F, 42.0F, 8.09F, 0.65F, 55.66F, 2.41F, 0.625F, 2.8F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Rising Spell Force", "Mystic Shot", "Essence Flux", "Arcane Shift", "Trueshot Barrage"}, new String[] {"ライジングフォース", "ミスティックショット", "エッセンスフロー", "ミスティカルシフト", "トゥルーショット"}, SkillDefinition::Ezreal, false);

    /** Fiddlesticks Definition */
    public static final Champion FiddleSticks = new Champion(9, "Fiddlesticks", "フィドル", "FiddleSticks", 524.4F, 80.0F, 5.605F, 0.6F, 400.12F, 56.0F, 6.0F, 0.8F, 48.36F, 2.625F, 0.625F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 480.0F, new String[] {"Dread", "Terrify", "Drain", "Dark Wind", "Crowstorm"}, new String[] {"ドレッド", "テラー", "ドレイン", "ダークウィンド", "クロウストーム"}, SkillDefinition::FiddleSticks, false);

    /** Fiora Definition */
    public static final Champion Fiora = new Champion(114, "Fiora", "フィオラ", "Fiora", 550.0F, 85.0F, 8.25F, 0.55F, 300.0F, 40.0F, 8.0F, 0.7F, 60.0F, 3.3F, 0.625F, 3.2F, 0.0F, 0.0F, 24.0F, 3.5F, 32.1F, 1.25F, 345.0F, 150.0F, new String[] {"Duelist's Dance", "Lunge", "Riposte", "Bladework", "Grand Challenge"}, new String[] {"デュエリストの舞", "ファント", "リポスト", "ブレードワーク", "グランドチャレンジ"}, SkillDefinition::Fiora, false);

    /** Fizz Definition */
    public static final Champion Fizz = new Champion(105, "Fizz", "フィズ", "Fizz", 558.48F, 86.0F, 8.175F, 0.7F, 317.2F, 37.0F, 6.0F, 0.8F, 58.04F, 3.0F, 0.658F, 3.1F, 0.0F, 0.0F, 22.412F, 3.4F, 32.1F, 1.25F, 335.0F, 175.0F, new String[] {"Nimble Fighter", "Urchin Strike", "Seastone Trident", "Playful / Trickster", "Chum the Waters"}, new String[] {"シーファイター", "ウニトゲ・ストライク", "シートライデント", "プレイ/トリックスター", "フィッシング"}, SkillDefinition::Fizz, false);

    /** Galio Definition */
    public static final Champion Galio = new Champion(3, "Galio", "ガリオ", "Galio", 577.8F, 85.0F, 8.71F, 0.75F, 369.0F, 47.0F, 6.0F, 0.8F, 61.97F, 3.375F, 0.638F, 1.2F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Runic Skin", "Resolute Smite", "Bulwark", "Righteous Gust", "Idol of Durand"}, new String[] {"ルーンの加護", "懲罰の視線", "忠義の防壁", "正義の追い風", "デュランドの偶像"}, SkillDefinition::Galio, false);

    /** Gangplank Definition */
    public static final Champion Gangplank = new Champion(41, "Gangplank", "ガングプランク", "Gangplank", 580.0F, 82.0F, 6.0F, 0.6F, 282.0F, 40.0F, 7.5F, 0.7F, 56.0F, 3.0F, 0.625F, 3.2F, 0.0F, 0.0F, 26.0F, 3.0F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Trial by Fire", "Parrrley", "Remove Scurvy", "Powder Keg", "Cannon Barrage"}, new String[] {"背水の銃剣", "偽りの発砲", "壊血病治癒", "火薬樽", "一斉砲撃"}, SkillDefinition::Gangplank, false);

    /** Garen Definition */
    public static final Champion Garen = new Champion(86, "Garen", "ガレン", "Garen", 616.28F, 84.25F, 7.84F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 57.88F, 4.5F, 0.625F, 2.9F, 0.0F, 0.0F, 27.536F, 3.0F, 32.1F, 1.25F, 340.0F, 175.0F, new String[] {"Perseverance", "Decisive Strike", "Courage", "Judgment", "Demacian Justice"}, new String[] {"忍耐", "断固たる一撃", "勇気の護り", "断罪剣", "デマーシアの正義"}, SkillDefinition::Garen, false);

    /** Gnar Definition */
    public static final Champion Gnar = new Champion(150, "Gnar", "ナー", "Gnar", 540.0F, 65.0F, 2.5F, 0.5F, 100.0F, 0.0F, 0.0F, 0.0F, 48.0F, 3.0F, 0.625F, 6.0F, 0.0F, 0.0F, 23.0F, 2.5F, 30.0F, 0.0F, 325.0F, 150.0F, new String[] {"Rage Gene", "Boomerang Throw / Boulder Toss", "Hyper / Wallop", "Hop / Crunch", "GNAR!"}, new String[] {"ぷんすこ", "ブーメラン/ぽいっ", "ごきげん/こてんぱん", "ぴょんぴょん/ドガン！", "ナー！"}, SkillDefinition::Gnar, false);

    /** Gragas Definition */
    public static final Champion Gragas = new Champion(79, "Gragas", "グラガス", "Gragas", 583.52F, 89.0F, 5.5F, 0.5F, 400.0F, 47.0F, 6.0F, 0.8F, 61.38F, 3.5F, 0.651F, 2.05F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 1.25F, 330.0F, 125.0F, new String[] {"Happy Hour", "Barrel Roll", "Drunken Rage", "Body Slam", "Explosive Cask"}, new String[] {"ふわふわタイム", "タル転がし", "飲みすぎ注意", "腹の肉", "タル爆弾"}, SkillDefinition::Gragas, false);

    /** Graves Definition */
    public static final Champion Graves = new Champion(104, "Graves", "グレイヴズ", "Graves", 551.12F, 84.0F, 6.675F, 0.7F, 322.2F, 40.0F, 7.925F, 0.7F, 60.83F, 2.41F, 0.481F, 2.6F, 0.0F, 0.0F, 24.376F, 3.4F, 30.0F, 0.0F, 340.0F, 425.0F, new String[] {"New Destiny", "End of the Line", "Smoke Screen", "Quickdraw", "Collateral Damage"}, new String[] {"確固たる信念", "End of the Line", "煙幕", "早撃ち", "炸裂砲弾"}, SkillDefinition::Graves, false);

    /** Hecarim Definition */
    public static final Champion Hecarim = new Champion(120, "Hecarim", "ヘカリム", "Hecarim", 599.6F, 95.0F, 7.0F, 0.75F, 277.2F, 40.0F, 6.5F, 0.6F, 61.376F, 3.2F, 0.67F, 2.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 1.25F, 345.0F, 175.0F, new String[] {"Warpath", "Rampage", "Spirit of Dread", "Devastating Charge", "Onslaught of Shadows"}, new String[] {"出陣", "縦横無尽", "怨霊の恐怖", "猛突進", "幻影の襲撃"}, SkillDefinition::Hecarim, false);

    /** Heimerdinger Definition */
    public static final Champion Heimerdinger = new Champion(74, "Heimerdinger", "ハイマー", "Heimerdinger", 476.0F, 75.0F, 11.005F, 1.75F, 307.2F, 40.0F, 6.0F, 0.8F, 55.536F, 2.7F, 0.625F, 1.36F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Techmaturgical Repair Bots", "H-28G Evolution Turret", "Hextech Micro-Rockets", "CH-2 Electron Storm Grenade", "UPGRADE!!!"}, new String[] {"テクマタジカル修理ボット", "H-28G革新砲", "ヘクステック小型ロケット", "CH-2超電磁グレネード", "アップグレード！！！"}, SkillDefinition::Heimerdinger, false);

    /** Illaoi Definition */
    public static final Champion Illaoi = new Champion(420, "Illaoi", "Illaoi", "Illaoi", 585.6F, 95.0F, 9.5F, 0.8F, 300.0F, 40.0F, 7.5F, 0.75F, 60.0F, 5.0F, 0.625F, 2.5F, 0.0F, 0.0F, 26.0F, 3.8F, 32.1F, 1.25F, 340.0F, 125.0F, new String[] {"Prophet of an Elder God", "Tentacle Smash", "Harsh Lesson", "Test of Spirit", "Leap of Faith"}, new String[] {"Prophet of an Elder God", "Tentacle Smash", "Harsh Lesson", "Test of Spirit", "Leap of Faith"}, SkillDefinition::Illaoi, false);

    /** Irelia Definition */
    public static final Champion Irelia = new Champion(39, "Irelia", "イレリア", "Irelia", 607.2F, 90.0F, 8.59F, 0.65F, 338.8F, 32.0F, 8.09F, 0.65F, 61.544F, 3.3F, 0.665F, 3.2F, 0.0F, 0.0F, 25.3F, 3.75F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Ionian Fervor", "Bladesurge", "Hiten Style", "Equilibrium Strike", "Transcendent Blades"}, new String[] {"アイオニアの熱情", "瞬剣", "飛天流", "平衡の一撃", "飛剣の舞"}, SkillDefinition::Irelia, false);

    /** Janna Definition */
    public static final Champion Janna = new Champion(40, "Janna", "ジャンナ", "Janna", 487.04F, 78.0F, 5.42F, 0.55F, 409.52F, 64.0F, 11.5F, 0.4F, 51.956F, 2.95F, 0.625F, 2.61F, 0.0F, 0.0F, 19.384F, 3.8F, 30.0F, 0.0F, 335.0F, 475.0F, new String[] {"Tailwind", "Howling Gale", "Zephyr", "Eye Of The Storm", "Monsoon"}, new String[] {"追い風", "大竜巻", "西風の神", "嵐の祝福", "青嵐"}, SkillDefinition::Janna, false);

    /** Jarvan IV Definition */
    public static final Champion JarvanIV = new Champion(59, "Jarvan IV", "ジャーヴァンⅣ", "JarvanIV", 571.2F, 90.0F, 8.175F, 0.7F, 302.2F, 40.0F, 6.755F, 0.45F, 55.712F, 3.4F, 0.658F, 2.5F, 0.0F, 0.0F, 29.0F, 3.6F, 32.1F, 1.25F, 340.0F, 175.0F, new String[] {"Martial Cadence", "Dragon Strike", "Golden Aegis", "Demacian Standard", "Cataclysm"}, new String[] {"武魂の律動", "龍撃", "黄金の護輪", "デマーシアの旗印", "決戦場"}, SkillDefinition::JarvanIV, false);

    /** Jax Definition */
    public static final Champion Jax = new Champion(24, "Jax", "ジャックス", "Jax", 592.8F, 85.0F, 8.37F, 0.55F, 338.8F, 32.0F, 7.575F, 0.7F, 61.97F, 3.375F, 0.638F, 3.4F, 0.0F, 0.0F, 27.04F, 3.0F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Relentless Assault", "Leap Strike", "Empower", "Counter Strike", "Grandmaster's Might"}, new String[] {"連撃の鬼", "跳躍撃", "入魂", "後の先", "達人の剛力"}, SkillDefinition::Jax, false);

    /** Jayce Definition */
    public static final Champion Jayce = new Champion(126, "Jayce", "ジェイス", "Jayce", 571.2F, 90.0F, 7.34F, 0.8F, 357.2F, 37.0F, 6.0F, 0.8F, 50.38F, 3.5F, 0.658F, 3.0F, 0.0F, 0.0F, 22.38F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Hextech Capacitor", "To the Skies!", "Lightning Field", "Thundering Blow", "Mercury Cannon"}, new String[] {"ヘクステック・コンデンサー", "スカイバスター", "ライトニング", "サンダーブロー", "マーキュリーキャノン"}, SkillDefinition::Jayce, false);

    /** Jayce Definition */
    public static final Champion JayceTransformed = new Champion(-126, "Jayce", "ジェイス", "JayceTransformed", 571.2F, 90.0F, 7.34F, 0.8F, 357.2F, 37.0F, 6.0F, 0.8F, 50.38F, 3.5F, 0.658F, 3.0F, 0.0F, 0.0F, 22.38F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Hextech Capacitor", "Shock Blast", "Hyper Charge", "Acceleration Gate", "Mercury Hammer"}, new String[] {"ヘクステック・コンデンサー", "ショックブラスト", "ハイパーチャージ", "アクセルゲート", "マーキュリーハンマー"}, SkillDefinition::JayceTransformed, true);

    /** Jinx Definition */
    public static final Champion Jinx = new Champion(222, "Jinx", "ジンクス", "Jinx", 517.76F, 82.0F, 5.84F, 0.5F, 245.6F, 45.0F, 6.68F, 1.0F, 58.46F, 2.41F, 0.625F, 1.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {"Get Excited!", "Switcheroo!", "Zap!", "Flame Chompers!", "Super Mega Death Rocket!"}, new String[] {"キャッホー！", "スイッチング！", "シビレーザー！", "パックンチョッパー！", "スーパーメガデスロケット！"}, SkillDefinition::Jinx, false);

    /** Kalista Definition */
    public static final Champion Kalista = new Champion(429, "Kalista", "カリスタ", "Kalista", 517.76F, 83.0F, 6.0F, 0.55F, 231.8F, 35.0F, 6.3F, 0.4F, 62.92F, 2.91F, 0.694F, 2.8F, 0.0F, 0.0F, 19.012F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Martial Poise", "Pierce", "Sentinel", "Rend", "Fate's Call"}, new String[] {"戦いの所作", "貫魂の一投", "執念の霊魂", "引き裂く遺恨", "宿命の呼び声"}, SkillDefinition::Kalista, false);

    /** Karma Definition */
    public static final Champion Karma = new Champion(43, "Karma", "カルマ", "Karma", 522.44F, 83.0F, 5.62F, 0.55F, 374.0F, 50.0F, 8.5F, 0.8F, 53.544F, 3.3F, 0.625F, 2.3F, 0.0F, 0.0F, 20.384F, 3.8F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Gathering Fire", "Inner Flame", "Focused Resolve", "Inspire", "Mantra"}, new String[] {"寄せ火", "内なる炎", "不退転の決意", "激励", "マントラ"}, SkillDefinition::Karma, false);

    /** Karthus Definition */
    public static final Champion Karthus = new Champion(30, "Karthus", "カーサス", "Karthus", 516.0F, 75.0F, 6.42F, 0.55F, 372.48F, 61.0F, 6.0F, 0.8F, 45.66F, 3.25F, 0.625F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Death Defied", "Lay Waste", "Wall of Pain", "Defile", "Requiem"}, new String[] {"死の拒絶", "根絶やし", "苦痛の壁", "冒涜", "鎮魂歌"}, SkillDefinition::Karthus, false);

    /** Kassadin Definition */
    public static final Champion Kassadin = new Champion(38, "Kassadin", "カサディン", "Kassadin", 564.04F, 78.0F, 7.79F, 0.5F, 397.6F, 67.0F, 6.0F, 0.8F, 58.852F, 3.9F, 0.64F, 3.7F, 0.0F, 0.0F, 23.376F, 3.2F, 30.0F, 0.0F, 340.0F, 150.0F, new String[] {"Void Stone", "Null Sphere", "Nether Blade", "Force Pulse", "Riftwalk"}, new String[] {"ヴォイドの石", "零の魔珠", "冥界の刃", "闇の波動", "無限回廊"}, SkillDefinition::Kassadin, false);

    /** Katarina Definition */
    public static final Champion Katarina = new Champion(55, "Katarina", "カタリナ", "Katarina", 510.0F, 83.0F, 4.5F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 58.0F, 3.2F, 0.658F, 2.74F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Voracity", "Bouncing Blades", "Sinister Steel", "Shunpo", "Death Lotus"}, new String[] {"貪欲", "跳刃乱舞", "凶刃の渦", "瞬歩", "死刃蓮華"}, SkillDefinition::Katarina, false);

    /** Kayle Definition */
    public static final Champion Kayle = new Champion(10, "Kayle", "ケイル", "Kayle", 574.24F, 93.0F, 8.26F, 0.75F, 322.2F, 40.0F, 6.0F, 0.8F, 51.0F, 2.8F, 0.638F, 2.2F, 0.0F, 0.0F, 26.88F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Holy Fervor", "Reckoning", "Divine Blessing", "Righteous Fury", "Intervention"}, new String[] {"聖なる闘志", "天罰", "神々の祝福", "義憤", "神権代行"}, SkillDefinition::Kayle, false);

    /** Kennen Definition */
    public static final Champion Kennen = new Champion(85, "Kennen", "ケネン", "Kennen", 535.72F, 79.0F, 5.59F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 50.544F, 3.3F, 0.69F, 3.4F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Mark of the Storm", "Thundering Shuriken", "Electrical Surge", "Lightning Rush", "Slicing Maelstrom"}, new String[] {"嵐の刻印", "雷手裏剣", "稲妻の奔流", "疾風迅雷", "雷撃の大嵐"}, SkillDefinition::Kennen, false);

    /** Kha'Zix Definition */
    public static final Champion Khazix = new Champion(121, "Kha'Zix", "カ＝ジックス", "Khazix", 572.8F, 85.0F, 7.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, 0.668F, 2.7F, 0.0F, 0.0F, 27.0F, 3.0F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Unseen Threat", "Taste Their Fear", "Void Spike", "Leap", "Void Assault"}, new String[] {"見えざる脅威", "甘美なる恐怖", "破裂の棘", "跳躍", "捕食の本能"}, SkillDefinition::Khazix, false);

    /** Kindred Definition */
    public static final Champion Kindred = new Champion(203, "Kindred", "Kindred", "Kindred", 540.0F, 85.0F, 7.0F, 0.55F, 300.0F, 35.0F, 6.97F, 0.4F, 54.0F, 1.7F, 0.625F, 2.5F, 0.0F, 0.0F, 27.0F, 3.25F, 30.0F, 0.0F, 325.0F, 500.0F, new String[] {"Mark of the Kindred", "Dance of Arrows", "Wolf's Frenzy", "Mounting Dread", "Lamb's Respite"}, new String[] {"Mark of the Kindred", "Dance of Arrows", "Wolf's Frenzy", "Mounting Dread", "Lamb's Respite"}, SkillDefinition::Kindred, false);

    /** Kog'Maw Definition */
    public static final Champion KogMaw = new Champion(96, "Kog'Maw", "コグ＝マウ", "KogMaw", 517.76F, 82.0F, 5.92F, 0.55F, 322.2F, 40.0F, 8.675F, 0.7F, 57.46F, 2.41F, 0.665F, 1.5F, 0.0F, 0.0F, 19.88F, 3.5F, 30.0F, 0.0F, 325.0F, 500.0F, new String[] {"Icathian Surprise", "Caustic Spittle", "Bio-Arcane Barrage", "Void Ooze", "Living Artillery"}, new String[] {"イカシアの自爆", "腐食粘液", "有機性魔力砲", "ヴォイド分泌液", "生体空撃砲"}, SkillDefinition::KogMaw, false);

    /** LeBlanc Definition */
    public static final Champion Leblanc = new Champion(7, "LeBlanc", "ルブラン", "Leblanc", 516.0F, 75.0F, 7.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 54.88F, 3.5F, 0.625F, 1.4F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Mirror Image", "Sigil of Malice", "Distortion", "Ethereal Chains", "Mimic"}, new String[] {"鏡像", "悪意の印", "空間歪曲", "霊妙な鎖", "再演"}, SkillDefinition::Leblanc, false);

    /** Lee Sin Definition */
    public static final Champion LeeSin = new Champion(64, "Lee Sin", "リー・シン", "LeeSin", 570.8F, 85.0F, 7.425F, 0.7F, 200.0F, 0.0F, 50.0F, 0.0F, 61.176F, 3.2F, 0.651F, 3.0F, 0.0F, 0.0F, 24.216F, 3.7F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Flurry", "Sonic Wave / Resonating Strike", "Safeguard / Iron Will", "Tempest / Cripple", "Dragon's Rage"}, new String[] {"練気", "音撃破/共鳴拳", "守りの型/鉄の意志", "破風/縛脚", "龍の怒り"}, SkillDefinition::LeeSin, false);

    /** Leona Definition */
    public static final Champion Leona = new Champion(89, "Leona", "レオナ", "Leona", 576.16F, 87.0F, 8.425F, 0.85F, 302.2F, 40.0F, 6.0F, 0.8F, 60.04F, 3.0F, 0.625F, 2.9F, 0.0F, 0.0F, 27.208F, 3.6F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Sunlight", "Shield of Daybreak", "Eclipse", "Zenith Blade", "Solar Flare"}, new String[] {"太陽の輝き", "暁の盾", "煌光破", "天陽の剣", "太陽の一閃"}, SkillDefinition::Leona, false);

    /** Lissandra Definition */
    public static final Champion Lissandra = new Champion(127, "Lissandra", "リサンドラ", "Lissandra", 506.12F, 84.0F, 6.92F, 0.55F, 304.0F, 50.0F, 5.67F, 0.4F, 50.536F, 2.7F, 0.625F, 1.36F, 0.0F, 0.0F, 20.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Iceborn", "Ice Shard", "Ring of Frost", "Glacial Path", "Frozen Tomb"}, new String[] {"アイスボーン", "アイスシャード", "リング・オブ・フロスト", "グラシアルパス", "フローズングレイブ"}, SkillDefinition::Lissandra, false);

    /** Lucian Definition */
    public static final Champion Lucian = new Champion(236, "Lucian", "ルシアン", "Lucian", 554.4F, 80.0F, 6.19F, 0.65F, 348.88F, 38.0F, 8.175F, 0.7F, 57.46F, 2.41F, 0.638F, 3.3F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {"Lightslinger", "Piercing Light", "Ardent Blaze", "Relentless Pursuit", "The Culling"}, new String[] {"二丁掃射", "閃光", "浄化の星印", "瞬脚", "殲滅"}, SkillDefinition::Lucian, false);

    /** Lulu Definition */
    public static final Champion Lulu = new Champion(117, "Lulu", "ルル", "Lulu", 552.76F, 74.0F, 6.005F, 0.6F, 292.4F, 55.0F, 11.0F, 0.6F, 46.368F, 2.6F, 0.625F, 2.25F, 0.0F, 0.0F, 19.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Pix, Faerie Companion", "Glitterlance", "Whimsy", "Help, Pix!", "Wild Growth"}, new String[] {"仲良し妖精ピックス", "ぴかぴかランス", "イタズラ", "ピックス、おねがい！", "おおきくなぁれ！"}, SkillDefinition::Lulu, false);

    /** Lux Definition */
    public static final Champion Lux = new Champion(99, "Lux", "ラックス", "Lux", 477.72F, 79.0F, 5.42F, 0.55F, 384.0F, 47.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.625F, 1.36F, 0.0F, 0.0F, 18.72F, 4.0F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Illumination", "Light Binding", "Prismatic Barrier", "Lucent Singularity", "Final Spark"}, new String[] {"イルミネーション", "ライトバインド", "プリズムバリア", "シンギュラリティ", "ファイナルスパーク"}, SkillDefinition::Lux, false);

    /** Malphite Definition */
    public static final Champion Malphite = new Champion(54, "Malphite", "マルファイト", "Malphite", 574.2F, 90.0F, 8.37F, 0.55F, 282.2F, 40.0F, 7.32F, 0.55F, 61.97F, 3.375F, 0.638F, 3.4F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Granite Shield", "Seismic Shard", "Brutal Strikes", "Ground Slam", "Unstoppable Force"}, new String[] {"岩盤の盾", "大地の破片", "大地の怒り", "岩強の拳", "不可止の衝撃"}, SkillDefinition::Malphite, false);

    /** Malzahar Definition */
    public static final Champion Malzahar = new Champion(90, "Malzahar", "マルザハール", "Malzahar", 514.4F, 80.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.625F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Summon Voidling", "Call of the Void", "Null Zone", "Malefic Visions", "Nether Grasp"}, new String[] {"ヴォイドリング使い", "ヴォイドの呼び声", "零の領域", "視の浸食", "冥界の緊縛"}, SkillDefinition::Malzahar, false);

    /** Maokai Definition */
    public static final Champion Maokai = new Champion(57, "Maokai", "マオカイ", "Maokai", 572.2F, 90.0F, 8.675F, 0.85F, 377.28F, 43.0F, 7.205F, 0.45F, 63.544F, 3.3F, 0.694F, 2.125F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {"Sap Magic", "Arcane Smash", "Twisted Advance", "Sapling Toss", "Vengeful Maelstrom"}, new String[] {"魔樹液", "魔紋打ち", "進撃の樹人", "苗木投げ", "報復の旋風"}, SkillDefinition::Maokai, false);

    /** Master Yi Definition */
    public static final Champion MasterYi = new Champion(11, "Master Yi", "マスター・イー", "MasterYi", 598.56F, 92.0F, 7.59F, 0.65F, 250.56F, 42.0F, 7.255F, 0.45F, 60.04F, 3.0F, 0.679F, 2.0F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 1.25F, 355.0F, 125.0F, new String[] {"Double Strike", "Alpha Strike", "Meditate", "Wuju Style", "Highlander"}, new String[] {"双連斬", "疾風斬・極", "明鏡止水", "無極流", "無極流奥義"}, SkillDefinition::MasterYi, false);

    /** Miss Fortune Definition */
    public static final Champion MissFortune = new Champion(21, "Miss Fortune", "フォーチュン", "MissFortune", 530.0F, 85.0F, 6.19F, 0.65F, 325.84F, 35.0F, 8.04F, 0.65F, 46.0F, 1.0F, 0.656F, 3.0F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Love Tap", "Double Up", "Strut", "Make It Rain", "Bullet Time"}, new String[] {"ステップアップ", "ダブルアップ", "ダーティショット", "レイニングバレット", "バレットタイム"}, SkillDefinition::MissFortune, false);

    /** Mordekaiser Definition */
    public static final Champion Mordekaiser = new Champion(82, "Mordekaiser", "モルデカイザー", "Mordekaiser", 525.0F, 73.0F, 4.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 61.0F, 5.0F, 0.601F, 2.2F, 0.0F, 0.0F, 20.0F, 3.75F, 32.1F, 1.25F, 325.0F, 175.0F, new String[] {"Iron Man", "Mace of Spades", "Harvesters of Sorrow", "Siphon of Destruction", "Children of the Grave"}, new String[] {"アイアンマン", "メイス・オブ・スペーズ", "悲しみを刈り取る者", "ハンド・オブ・ルーイン", "グレイブ・チルドレン"}, SkillDefinition::Mordekaiser, false);

    /** Morgana Definition */
    public static final Champion Morgana = new Champion(25, "Morgana", "モルガナ", "Morgana", 547.48F, 86.0F, 5.705F, 0.6F, 340.8F, 60.0F, 8.5F, 0.8F, 55.46F, 3.5F, 0.625F, 1.53F, 0.0F, 0.0F, 25.384F, 3.8F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Soul Siphon", "Dark Binding", "Tormented Soil", "Black Shield", "Soul Shackles"}, new String[] {"魂吸引", "闇の束縛", "苦悶の沼", "漆黒の盾", "魂の足枷"}, SkillDefinition::Morgana, false);

    /** Nami Definition */
    public static final Champion Nami = new Champion(267, "Nami", "ナミ", "Nami", 489.32F, 74.0F, 5.42F, 0.55F, 377.24F, 43.0F, 11.5F, 0.4F, 51.208F, 3.1F, 0.644F, 2.61F, 0.0F, 0.0F, 19.72F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Surging Tides", "Aqua Prison", "Ebb and Flow", "Tidecaller's Blessing", "Tidal Wave"}, new String[] {"激流", "水の監獄", "潮流", "潮使いの祝福", "海神の舞"}, SkillDefinition::Nami, false);

    /** Nasus Definition */
    public static final Champion Nasus = new Champion(75, "Nasus", "ナサス", "Nasus", 561.2F, 90.0F, 9.01F, 0.9F, 325.6F, 42.0F, 7.44F, 0.5F, 59.18F, 3.5F, 0.638F, 3.48F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Soul Eater", "Siphoning Strike", "Wither", "Spirit Fire", "Fury of the Sands"}, new String[] {"魂の統括", "吸魂撃", "風化", "輪廻の炎", "憤怒の熱砂"}, SkillDefinition::Nasus, false);

    /** Nautilus Definition */
    public static final Champion Nautilus = new Champion(111, "Nautilus", "ノーチラス", "Nautilus", 576.48F, 86.0F, 8.37F, 0.55F, 334.0F, 47.0F, 8.625F, 0.7F, 57.544F, 3.3F, 0.613F, 1.0F, 0.0F, 0.0F, 26.46F, 3.75F, 32.1F, 1.25F, 325.0F, 175.0F, new String[] {"Staggering Blow", "Dredge Line", "Titan's Wrath", "Riptide", "Depth Charge"}, new String[] {"鉄の錨", "錨投げ", "大海の激憤", "粉砕水", "爆雷発射"}, SkillDefinition::Nautilus, false);

    /** Nidalee Definition */
    public static final Champion Nidalee = new Champion(76, "Nidalee", "ニダリー", "Nidalee", 511.2F, 80.0F, 6.005F, 0.6F, 295.6F, 45.0F, 6.0F, 0.8F, 47.88F, 3.5F, 0.638F, 3.22F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Prowl", "Javelin Toss", "Bushwhack", "Primal Surge", "Aspect Of The Cougar"}, new String[] {"獲物探し", "槍投げ", "虎挟み", "高揚", "クーガーの心"}, SkillDefinition::Nidalee, false);

    /** Nidalee Definition */
    public static final Champion NidaleeTransformed = new Champion(-76, "Nidalee", "ニダリー", "NidaleeTransformed", 511.2F, 80.0F, 6.005F, 0.6F, 295.6F, 45.0F, 6.0F, 0.8F, 47.88F, 3.5F, 0.638F, 3.22F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Prowl", "Takedown", "Pounce", "Swipe", "Aspect Of The Cougar"}, new String[] {"獲物探し", "テイクダウン", "ジャンプ", "クーガークロウ", "クーガーの心"}, SkillDefinition::NidaleeTransformed, true);

    /** Nocturne Definition */
    public static final Champion Nocturne = new Champion(56, "Nocturne", "ノクターン", "Nocturne", 582.8F, 85.0F, 8.26F, 0.75F, 273.8F, 35.0F, 6.755F, 0.45F, 59.208F, 3.1F, 0.668F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Umbra Blades", "Duskbringer", "Shroud of Darkness", "Unspeakable Horror", "Paranoia"}, new String[] {"夢幻斬", "闇の手", "漆黒の帳", "底知れぬ恐怖", "悪夢"}, SkillDefinition::Nocturne, false);

    /** Nunu Definition */
    public static final Champion Nunu = new Champion(20, "Nunu", "ヌヌ", "Nunu", 598.28F, 90.0F, 8.39F, 0.8F, 283.56F, 42.0F, 7.44F, 0.5F, 56.856F, 3.45F, 0.625F, 2.25F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Visionary", "Consume", "Blood Boil", "Ice Blast", "Absolute Zero"}, new String[] {"幻想", "丸かじり", "熱血", "氷弾", "アブソリュート・ゼロ"}, SkillDefinition::Nunu, false);

    /** Olaf Definition */
    public static final Champion Olaf = new Champion(2, "Olaf", "オラフ", "Olaf", 597.24F, 93.0F, 8.51F, 0.9F, 315.6F, 42.0F, 7.465F, 0.575F, 59.98F, 3.5F, 0.694F, 2.7F, 0.0F, 0.0F, 26.04F, 3.0F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Berserker Rage", "Undertow", "Vicious Strikes", "Reckless Swing", "Ragnarok"}, new String[] {"狂戦士の怒り", "斧投げ", "残忍な斧", "捨て身切り", "滅我"}, SkillDefinition::Olaf, false);

    /** Orianna Definition */
    public static final Champion Orianna = new Champion(61, "Orianna", "オリアナ", "Orianna", 517.72F, 79.0F, 6.87F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 40.368F, 2.6F, 0.658F, 3.5F, 0.0F, 0.0F, 17.04F, 3.0F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {"Clockwork Windup", "Command: Attack", "Command: Dissonance", "Command: Protect", "Command: Shockwave"}, new String[] {"ぜんまい仕掛け", "命令: 攻撃", "命令: 乱磁場", "命令: 防御", "命令: 衝撃波"}, SkillDefinition::Orianna, false);

    /** Pantheon Definition */
    public static final Champion Pantheon = new Champion(80, "Pantheon", "パンテオン", "Pantheon", 579.16F, 87.0F, 7.84F, 0.65F, 317.12F, 31.0F, 7.355F, 0.45F, 55.572F, 2.9F, 0.644F, 2.95F, 0.0F, 0.0F, 27.652F, 3.9F, 32.1F, 1.25F, 355.0F, 150.0F, new String[] {"Aegis Protection", "Spear Shot", "Aegis of Zeonia", "Heartseeker Strike", "Grand Skyfall"}, new String[] {"イージスの守護", "痛恨の槍", "ゼオニアの加護", "急所乱撃", "天上天下唯我独槍"}, SkillDefinition::Pantheon, false);

    /** Poppy Definition */
    public static final Champion Poppy = new Champion(78, "Poppy", "ポッピー", "Poppy", 559.08F, 81.0F, 8.37F, 0.55F, 235.4F, 30.0F, 7.155F, 0.45F, 61.97F, 3.375F, 0.638F, 3.35F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 345.0F, 125.0F, new String[] {"Valiant Fighter", "Devastating Blow", "Paragon of Demacia", "Heroic Charge", "Diplomatic Immunity"}, new String[] {"勇敢な戦士", "渾身の一撃", "デマーシアの規範", "勇猛な突進", "絶対的特権"}, SkillDefinition::Poppy, false);

    /** Quinn Definition */
    public static final Champion Quinn = new Champion(133, "Quinn", "クイン", "Quinn", 532.8F, 85.0F, 5.42F, 0.55F, 268.8F, 35.0F, 6.97F, 0.4F, 56.46F, 2.41F, 0.668F, 3.1F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Harrier", "Blinding Assault", "Heightened Senses", "Vault", "Behind Enemy Lines"}, new String[] {"鷲匠", "暗闇の強襲", "鷹の眼", "飛翔撃", "相棒"}, SkillDefinition::Quinn, false);

    /** Rammus Definition */
    public static final Champion Rammus = new Champion(33, "Rammus", "ラムス", "Rammus", 564.48F, 86.0F, 7.92F, 0.55F, 310.44F, 33.0F, 7.84F, 0.5F, 55.88F, 3.5F, 0.625F, 2.215F, 0.0F, 0.0F, 31.384F, 4.3F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Spiked Shell", "Powerball", "Defensive Ball Curl", "Puncturing Taunt", "Tremors"}, new String[] {"トゲトゲ", "ころころ", "かたくなる", "ちくちく", "ドスンドスン"}, SkillDefinition::Rammus, false);

    /** Rek'Sai Definition */
    public static final Champion RekSai = new Champion(421, "Rek'Sai", "レク＝サイ", "RekSai", 570.0F, 90.0F, 7.34F, 0.65F, 100.0F, 0.0F, 0.0F, 0.0F, 55.628F, 3.35F, 0.625F, 2.0F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 1.25F, 335.0F, 175.0F, new String[] {"Fury of the Xer'Sai", "Queen's Wrath", "Burrow", "Furious Bite", "Void Rush"}, new String[] {"ゼル＝サイの怒り", "女王の怒り", "潜伏", "激情の牙", "ヴォイドの猛攻"}, SkillDefinition::RekSai, false);

    /** Rek'Sai Definition */
    public static final Champion RekSaiTransformed = new Champion(-421, "Rek'Sai", "レク＝サイ", "RekSaiTransformed", 570.0F, 90.0F, 7.34F, 0.65F, 100.0F, 0.0F, 0.0F, 0.0F, 55.628F, 3.35F, 0.625F, 2.0F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 1.25F, 335.0F, 175.0F, new String[] {"Fury of the Xer'Sai", "Prey Seeker", "Un-burrow", "Tunnel", "Void Rush"}, new String[] {"ゼル＝サイの怒り", "獲物定め", "襲撃", "掘削", "ヴォイドの猛攻"}, SkillDefinition::RekSaiTransformed, true);

    /** Renekton Definition */
    public static final Champion Renekton = new Champion(58, "Renekton", "レネクトン", "Renekton", 572.16F, 87.0F, 7.96F, 0.75F, 100.0F, 0.0F, 0.0F, 0.0F, 58.328F, 3.1F, 0.665F, 2.65F, 0.0F, 0.0F, 25.584F, 3.8F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Reign of Anger", "Cull the Meek", "Ruthless Predator", "Slice and Dice", "Dominus"}, new String[] {"怒りの支配", "肉削ぎ", "無慈悲な連撃", "斬り切り舞", "凶暴化"}, SkillDefinition::Renekton, false);

    /** Rengar Definition */
    public static final Champion Rengar = new Champion(107, "Rengar", "レンガー", "Rengar", 586.2F, 90.0F, 4.27F, 0.4F, 5.0F, 0.0F, 0.0F, 0.0F, 60.04F, 3.0F, 0.679F, 2.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Unseen Predator", "Savagery", "Battle Roar", "Bola Strike", "Thrill of the Hunt"}, new String[] {"見えざる襲撃者", "逆上", "狩りの雄叫び", "鉄球の投げ縄", "狩猟本能"}, SkillDefinition::Rengar, false);

    /** Riven Definition */
    public static final Champion Riven = new Champion(92, "Riven", "リヴェン", "Riven", 558.48F, 86.0F, 3.34F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 56.04F, 3.0F, 0.625F, 3.5F, 0.0F, 0.0F, 24.376F, 3.2F, 32.1F, 1.25F, 340.0F, 125.0F, new String[] {"Runic Blade", "Broken Wings", "Ki Burst", "Valor", "Blade of the Exile"}, new String[] {"ルーンの剣", "折れた翼", "気功破", "勇躍", "追放者の剣"}, SkillDefinition::Riven, false);

    /** Rumble Definition */
    public static final Champion Rumble = new Champion(68, "Rumble", "ランブル", "Rumble", 584.4F, 80.0F, 8.005F, 0.6F, 100.0F, 0.0F, 0.0F, 0.0F, 61.036F, 3.2F, 0.644F, 1.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Junkyard Titan", "Flamespitter", "Scrap Shield", "Electro Harpoon", "The Equalizer"}, new String[] {"ポンコツタイタン", "スピットファイア", "ジャンクシールド", "エレクトロハープーン", "イコライザー"}, SkillDefinition::Rumble, false);

    /** Ryze Definition */
    public static final Champion Ryze = new Champion(13, "Ryze", "ライズ", "Ryze", 558.48F, 86.0F, 5.27F, 0.55F, 392.4F, 52.0F, 5.0F, 1.0F, 55.04F, 3.0F, 0.625F, 2.112F, 0.0F, 0.0F, 21.552F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {"Arcane Mastery", "Overload", "Rune Prison", "Spell Flux", "Desperate Power"}, new String[] {"古代の呪術", "破呪", "ルーンの牢獄", "呪文跳弾", "禁断の呪力"}, SkillDefinition::Ryze, false);

    /** Sejuani Definition */
    public static final Champion Sejuani = new Champion(113, "Sejuani", "セジュアニ", "Sejuani", 600.0F, 95.0F, 8.675F, 0.85F, 400.0F, 40.0F, 7.205F, 0.45F, 57.544F, 3.3F, 0.67F, 1.44F, 0.0F, 0.0F, 29.54F, 3.0F, 32.1F, 1.25F, 340.0F, 125.0F, new String[] {"Frost", "Arctic Assault", "Flail of the Northern Winds", "Permafrost", "Glacial Prison"}, new String[] {"凍傷", "猪突凍進", "北風のフレイル", "永久凍土", "氷河の牢獄"}, SkillDefinition::Sejuani, false);

    /** Shaco Definition */
    public static final Champion Shaco = new Champion(35, "Shaco", "シャコ", "Shaco", 582.12F, 84.0F, 8.37F, 0.55F, 297.2F, 40.0F, 7.155F, 0.45F, 57.58F, 3.5F, 0.694F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Backstab", "Deceive", "Jack In The Box", "Two-Shiv Poison", "Hallucinate"}, new String[] {"背後からの一撃", "幻惑", "びっくり箱", "両刃の毒短剣", "幻覚"}, SkillDefinition::Shaco, false);

    /** Shen Definition */
    public static final Champion Shen = new Champion(98, "Shen", "シェン", "Shen", 570.8F, 85.0F, 8.37F, 0.55F, 200.0F, 0.0F, 50.0F, 0.0F, 60.17F, 3.375F, 0.651F, 3.4F, 0.0F, 0.0F, 25.72F, 4.0F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Ki Strike", "Vorpal Blade", "Feint", "Shadow Dash", "Stand United"}, new String[] {"気功斬", "吸命刀", "護遁の術", "殺気駆け", "刹那護法"}, SkillDefinition::Shen, false);

    /** Shyvana Definition */
    public static final Champion Shyvana = new Champion(102, "Shyvana", "シヴァーナ", "Shyvana", 594.6F, 95.0F, 8.59F, 0.8F, 100.0F, 0.0F, 0.0F, 0.0F, 60.712F, 3.4F, 0.658F, 2.5F, 0.0F, 0.0F, 27.628F, 3.35F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Dragonborn", "Twin Bite", "Burnout", "Flame Breath", "Dragon's Descent"}, new String[] {"龍族の血脈", "双咬撃", "烈風炎", "火炎の息吹", "龍族の血統"}, SkillDefinition::Shyvana, false);

    /** Singed Definition */
    public static final Champion Singed = new Champion(27, "Singed", "シンジド", "Singed", 542.76F, 82.0F, 8.02F, 0.55F, 290.6F, 45.0F, 7.52F, 0.55F, 62.32F, 3.375F, 0.613F, 1.81F, 0.0F, 0.0F, 27.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Empowered Bulwark", "Poison Trail", "Mega Adhesive", "Fling", "Insanity Potion"}, new String[] {"肉体強化", "猛毒の跡", "強力粘着剤", "ぶん投げ", "狂人のポーション"}, SkillDefinition::Singed, false);

    /** Sion Definition */
    public static final Champion Sion = new Champion(14, "Sion", "サイオン", "Sion", 542.64F, 73.0F, 10.18F, 0.8F, 325.6F, 42.0F, 8.005F, 0.6F, 59.72F, 4.0F, 0.679F, 1.3F, 0.0F, 0.0F, 23.04F, 3.0F, 32.1F, 1.25F, 345.0F, 175.0F, new String[] {"Glory in Death", "Decimating Smash", "Soul Furnace", "Roar of the Slayer", "Unstoppable Onslaught"}, new String[] {"名誉ある死", "破滅の斧", "魂の炉心", "殺意の雄叫び", "猪突猛進"}, SkillDefinition::Sion, false);

    /** Sivir Definition */
    public static final Champion Sivir = new Champion(15, "Sivir", "シヴィア", "Sivir", 515.76F, 82.0F, 5.17F, 0.55F, 284.0F, 50.0F, 8.01F, 0.9F, 57.46F, 2.41F, 0.625F, 1.6F, 0.0F, 0.0F, 22.21F, 3.25F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {"Fleet of Foot", "Boomerang Blade", "Ricochet", "Spell Shield", "On The Hunt"}, new String[] {"戦駆け", "ぶっ放し", "跳刃", "破魔の護り", "狩猟の幕開け"}, SkillDefinition::Sivir, false);

    /** Skarner Definition */
    public static final Champion Skarner = new Champion(72, "Skarner", "スカーナー", "Skarner", 601.28F, 90.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 57.156F, 4.5F, 0.625F, 2.1F, 0.0F, 0.0F, 29.384F, 3.8F, 32.1F, 1.25F, 335.0F, 125.0F, new String[] {"Crystal Spires", "Crystal Slash", "Crystalline Exoskeleton", "Fracture", "Impale"}, new String[] {"水晶の針", "水晶波斬", "外殻水晶化", "破砕弾", "狙い刺し"}, SkillDefinition::Skarner, false);

    /** Sona Definition */
    public static final Champion Sona = new Champion(37, "Sona", "ソナ", "Sona", 482.36F, 77.0F, 5.42F, 0.55F, 340.6F, 45.0F, 11.5F, 0.4F, 50.04F, 3.0F, 0.644F, 2.3F, 0.0F, 0.0F, 20.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Power Chord", "Hymn of Valor", "Aria of Perseverance", "Song of Celerity", "Crescendo"}, new String[] {"パワーコード", "ヒム・オブ・ヴァロー", "パーセヴァランス", "セレニティ", "クレッシェンド"}, SkillDefinition::Sona, false);

    /** Soraka Definition */
    public static final Champion Soraka = new Champion(16, "Soraka", "ソラカ", "Soraka", 529.04F, 78.0F, 2.5F, 0.5F, 350.8F, 60.0F, 11.5F, 0.4F, 50.04F, 3.0F, 0.625F, 2.14F, 0.0F, 0.0F, 23.384F, 3.8F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Salvation", "Starcall", "Astral Infusion", "Equinox", "Wish"}, new String[] {"救済", "星のささやき", "星霊の癒し", "星の静寂", "願い"}, SkillDefinition::Soraka, false);

    /** Swain Definition */
    public static final Champion Swain = new Champion(50, "Swain", "スウェイン", "Swain", 516.04F, 78.0F, 7.84F, 0.65F, 374.0F, 47.0F, 6.0F, 0.8F, 52.04F, 3.0F, 0.625F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {"Carrion Renewal", "Decrepify", "Nevermove", "Torment", "Ravenous Flock"}, new String[] {"屍食再生", "戦慄の怪鳥", "漆黒の束縛", "苦悶", "黒烏の恐襲"}, SkillDefinition::Swain, false);

    /** Syndra Definition */
    public static final Champion Syndra = new Champion(134, "Syndra", "シンドラ", "Syndra", 511.04F, 78.0F, 6.505F, 0.6F, 384.0F, 60.0F, 6.0F, 0.8F, 53.872F, 2.9F, 0.625F, 2.0F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Transcendent", "Dark Sphere", "Force of Will", "Scatter the Weak", "Unleashed Power"}, new String[] {"絶大なる魔力", "闇の魔珠", "魔力の制御", "魔力四散", "魔力解放"}, SkillDefinition::Syndra, false);

    /** Tahm Kench Definition */
    public static final Champion TahmKench = new Champion(223, "Tahm Kench", "タム・ケンチ", "TahmKench", 610.0F, 95.0F, 6.5F, 0.55F, 325.0F, 40.0F, 8.0F, 1.0F, 56.0F, 3.2F, 0.625F, 2.5F, 0.0F, 0.0F, 27.0F, 3.5F, 32.1F, 1.25F, 335.0F, 175.0F, new String[] {"An Acquired Taste", "Tongue Lash", "Devour", "Thick Skin", "Abyssal Voyage"}, new String[] {"味見", "舌のムチ", "丸呑み", "硬質化", "船旅"}, SkillDefinition::TahmKench, false);

    /** Talon Definition */
    public static final Champion Talon = new Champion(91, "Talon", "タロン", "Talon", 582.8F, 85.0F, 8.51F, 0.75F, 377.2F, 37.0F, 7.59F, 0.5F, 55.208F, 3.1F, 0.668F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 1.25F, 350.0F, 125.0F, new String[] {"Mercy", "Noxian Diplomacy", "Rake", "Cutthroat", "Shadow Assault"}, new String[] {"刃の慈悲", "ノクサスの刃", "飛燕手裏剣", "瞬刃", "影刃円舞"}, SkillDefinition::Talon, false);

    /** Taric Definition */
    public static final Champion Taric = new Champion(44, "Taric", "タリック", "Taric", 619.2F, 90.0F, 7.94F, 0.5F, 349.08F, 56.0F, 8.5F, 0.8F, 57.88F, 3.5F, 0.625F, 2.02F, 0.0F, 0.0F, 25.876F, 3.7F, 32.1F, 1.25F, 340.0F, 125.0F, new String[] {"Gemcraft", "Imbue", "Shatter", "Dazzle", "Radiance"}, new String[] {"ジェムクラフト", "パワーストーン", "ジェムクラッシュ", "プリズムチャーム", "シャイニング"}, SkillDefinition::Taric, false);

    /** Teemo Definition */
    public static final Champion Teemo = new Champion(17, "Teemo", "ティーモ", "Teemo", 515.76F, 82.0F, 5.74F, 0.65F, 267.2F, 40.0F, 7.205F, 0.45F, 47.54F, 3.0F, 0.69F, 3.38F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 330.0F, 500.0F, new String[] {"Camouflage", "Blinding Dart", "Move Quick", "Toxic Shot", "Noxious Trap"}, new String[] {"身隠し", "目つぶしダーツ", "駆け足！", "毒たっぷり吹き矢", "毒キノコ"}, SkillDefinition::Teemo, false);

    /** Thresh Definition */
    public static final Champion Thresh = new Champion(412, "Thresh", "スレッシュ", "Thresh", 560.52F, 93.0F, 6.92F, 0.55F, 273.92F, 44.0F, 6.0F, 0.8F, 47.696F, 2.2F, 0.625F, 3.5F, 0.0F, 0.0F, 16.0F, 0.0F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Damnation", "Death Sentence", "Dark Passage", "Flay", "The Box"}, new String[] {"魂の束縛", "死の宣告", "嘆きの魂灯", "絶望の鎖", "魂の牢獄"}, SkillDefinition::Thresh, false);

    /** Tristana Definition */
    public static final Champion Tristana = new Champion(18, "Tristana", "トリスターナ", "Tristana", 542.76F, 82.0F, 6.19F, 0.65F, 246.76F, 32.0F, 7.205F, 0.45F, 56.96F, 2.41F, 0.656F, 1.5F, 0.0F, 0.0F, 22.0F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Draw a Bead", "Rapid Fire", "Rocket Jump", "Explosive Charge", "Buster Shot"}, new String[] {"ドロー＆グロー", "ラピッドファイア", "ロケットジャンプ", "ヨードルグレネード", "バスターショット"}, SkillDefinition::Tristana, false);

    /** Trundle Definition */
    public static final Champion Trundle = new Champion(48, "Trundle", "トランドル", "Trundle", 616.28F, 96.0F, 9.425F, 0.85F, 281.6F, 45.0F, 7.505F, 0.6F, 60.04F, 3.0F, 0.67F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 1.25F, 350.0F, 175.0F, new String[] {"King's Tribute", "Chomp", "Frozen Domain", "Pillar of Ice", "Subjugate"}, new String[] {"王への貢物", "噛み付き", "凍てつく大地", "氷冷の柱", "暴虐なる搾取"}, SkillDefinition::Trundle, false);

    /** Tryndamere Definition */
    public static final Champion Tryndamere = new Champion(23, "Tryndamere", "トリンダメア", "Tryndamere", 625.64F, 98.0F, 8.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 61.376F, 3.2F, 0.67F, 2.9F, 0.0F, 0.0F, 24.108F, 3.1F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Battle Fury", "Bloodlust", "Mocking Shout", "Spinning Slash", "Undying Rage"}, new String[] {"戦場の咆哮", "血の欲望", "嘲りの叫び", "旋回斬り", "不死の憤激"}, SkillDefinition::Tryndamere, false);

    /** Twisted Fate Definition */
    public static final Champion TwistedFate = new Champion(4, "Twisted Fate", "フェイト", "TwistedFate", 521.76F, 82.0F, 5.505F, 0.6F, 265.84F, 38.0F, 6.0F, 0.8F, 49.954F, 3.3F, 0.651F, 3.22F, 0.0F, 0.0F, 20.542F, 3.15F, 30.0F, 0.0F, 330.0F, 525.0F, new String[] {"Loaded Dice", "Wild Cards", "Pick A Card", "Stacked Deck", "Destiny"}, new String[] {"イカサマダイス", "ワイルドカード", "ドロー", "フォーカード", "デスティニー"}, SkillDefinition::TwistedFate, false);

    /** Twitch Definition */
    public static final Champion Twitch = new Champion(29, "Twitch", "トゥイッチ", "Twitch", 525.08F, 81.0F, 6.005F, 0.6F, 287.2F, 40.0F, 7.255F, 0.45F, 55.46F, 2.41F, 0.679F, 3.38F, 0.0F, 0.0F, 23.04F, 3.0F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Deadly Venom", "Ambush", "Venom Cask", "Contaminate", "Rat-Ta-Tat-Tat"}, new String[] {"致死毒", "奇襲", "毒瓶投げ", "致死毒活発化", "ラッタッタッタッタ"}, SkillDefinition::Twitch, false);

    /** Udyr Definition */
    public static final Champion Udyr = new Champion(77, "Udyr", "ウディア", "Udyr", 593.32F, 99.0F, 8.71F, 0.75F, 270.4F, 30.0F, 7.505F, 0.45F, 58.286F, 3.2F, 0.658F, 2.67F, 0.0F, 0.0F, 25.47F, 4.0F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Monkey's Agility", "Tiger Stance", "Turtle Stance", "Bear Stance", "Phoenix Stance"}, new String[] {"乱撃高揚", "虎形態", "亀形態", "熊形態", "不死鳥形態"}, SkillDefinition::Udyr, false);

    /** Urgot Definition */
    public static final Champion Urgot = new Champion(6, "Urgot", "アーゴット", "Urgot", 586.52F, 89.0F, 6.505F, 0.6F, 312.4F, 55.0F, 8.59F, 0.65F, 52.048F, 3.6F, 0.644F, 2.9F, 0.0F, 0.0F, 24.544F, 3.3F, 30.0F, 0.0F, 335.0F, 425.0F, new String[] {"Zaun-Touched Bolt Augmenter", "Acid Hunter", "Terror Capacitor", "Noxian Corrosive Charge", "Hyper-Kinetic Position Reverser"}, new String[] {"ゾウン・デストラクション", "アシッドハンター", "テラーコンデンサー", "ノクサス・コラプトシェル", "ハイパーキネティック・ポジションリバーサー"}, SkillDefinition::Urgot, false);

    /** Varus Definition */
    public static final Champion Varus = new Champion(110, "Varus", "ヴァルス", "Varus", 537.76F, 82.0F, 5.42F, 0.55F, 360.48F, 33.0F, 7.34F, 0.8F, 54.66F, 2.41F, 0.658F, 3.0F, 0.0F, 0.0F, 23.212F, 3.4F, 30.0F, 0.0F, 330.0F, 575.0F, new String[] {"Living Vengeance", "Piercing Arrow", "Blighted Quiver", "Hail of Arrows", "Chain of Corruption"}, new String[] {"復讐の化身", "渾身の一矢", "枯死の矢筒", "滅びの矢雨", "穢れの連鎖"}, SkillDefinition::Varus, false);

    /** Vayne Definition */
    public static final Champion Vayne = new Champion(67, "Vayne", "ヴェイン", "Vayne", 498.44F, 83.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 55.88F, 1.66F, 0.658F, 4.0F, 0.0F, 0.0F, 19.012F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {"Night Hunter", "Tumble", "Silver Bolts", "Condemn", "Final Hour"}, new String[] {"闇夜の狩人　", "転撃", "銀の矢", "制裁", "決戦"}, SkillDefinition::Vayne, false);

    /** Veigar Definition */
    public static final Champion Veigar = new Champion(45, "Veigar", "ヴェイガー", "Veigar", 492.76F, 82.0F, 5.42F, 0.55F, 392.4F, 52.0F, 6.0F, 0.8F, 50.71F, 2.625F, 0.625F, 2.24F, 0.0F, 0.0F, 22.55F, 3.75F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {"Equilibrium", "Baleful Strike", "Dark Matter", "Event Horizon", "Primordial Burst"}, new String[] {"ワールドバランス", "イーヴィルストライク", "ダークマター", "イベントホライズン", "メテオバースト"}, SkillDefinition::Veigar, false);

    /** Vel'Koz Definition */
    public static final Champion Velkoz = new Champion(161, "Vel'Koz", "ヴェル＝コズ", "Velkoz", 507.68F, 76.0F, 5.42F, 0.55F, 375.6F, 42.0F, 6.0F, 0.8F, 54.937874F, 3.1415927F, 0.625F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {"Organic Deconstruction", "Plasma Fission", "Void Rift", "Tectonic Disruption", "Life Form Disintegration Ray"}, new String[] {"有機分解", "電離炸裂弾", "ヴォイドの裂谷", "地殻砕裂", "生体破壊光線"}, SkillDefinition::Velkoz, false);

    /** Vi Definition */
    public static final Champion Vi = new Champion(254, "Vi", "ヴァイ", "Vi", 582.8F, 85.0F, 9.01F, 0.9F, 295.6F, 45.0F, 8.09F, 0.65F, 55.88F, 3.5F, 0.644F, 2.5F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Blast Shield", "Vault Breaker", "Denting Blows", "Excessive Force", "Assault and Battery"}, new String[] {"爆風の護り", "跳破拳", "滅多打ち", "爆拳衝", "一拳必殺"}, SkillDefinition::Vi, false);

    /** Viktor Definition */
    public static final Champion Viktor = new Champion(112, "Viktor", "ヴィクター", "Viktor", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, 0.658F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {"Glorious Evolution", "Siphon Power", "Gravity Field", "Death Ray", "Chaos Storm"}, new String[] {"グロリアス・エヴォリューション", "パワーブラスト", "グラビティフィールド", "デス・レイ", "カオスストーム"}, SkillDefinition::Viktor, false);

    /** Vladimir Definition */
    public static final Champion Vladimir = new Champion(8, "Vladimir", "ヴラッドミア", "Vladimir", 542.8F, 85.0F, 7.005F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 48.04F, 3.0F, 0.658F, 2.0F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {"Crimson Pact", "Transfusion", "Sanguine Pool", "Tides of Blood", "Hemoplague"}, new String[] {"真紅の盟約", "吸血", "紅血の沼", "血液奔流", "呪血の渦"}, SkillDefinition::Vladimir, false);

    /** Volibear Definition */
    public static final Champion Volibear = new Champion(106, "Volibear", "ヴォリベア", "Volibear", 584.48F, 86.0F, 8.09F, 0.65F, 270.4F, 30.0F, 8.09F, 0.65F, 59.544F, 3.3F, 0.658F, 2.67F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Chosen of the Storm", "Rolling Thunder", "Frenzy", "Majestic Roar", "Thunder Claws"}, new String[] {"嵐に選ばれし者", "鳴雷", "獰猛", "雄大な咆哮", "稲妻の爪"}, SkillDefinition::Volibear, false);

    /** Warwick Definition */
    public static final Champion Warwick = new Champion(19, "Warwick", "ワーウィック", "Warwick", 592.64F, 98.0F, 8.39F, 0.8F, 240.4F, 30.0F, 8.105F, 0.6F, 62.43F, 3.375F, 0.679F, 2.88F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Eternal Thirst", "Hungering Strike", "Hunters Call", "Blood Scent", "Infinite Duress"}, new String[] {"永遠の渇き", "餓狼", "狩りの遠吠え", "血の香", "無慈悲な狼撃"}, SkillDefinition::Warwick, false);

    /** Wukong Definition */
    public static final Champion MonkeyKing = new Champion(62, "Wukong", "ウーコン", "MonkeyKing", 577.8F, 85.0F, 6.19F, 0.65F, 265.84F, 38.0F, 8.04F, 0.65F, 59.876F, 3.2F, 0.658F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 1.25F, 345.0F, 175.0F, new String[] {"Stone Skin", "Crushing Blow", "Decoy", "Nimbus Strike", "Cyclone"}, new String[] {"岩の皮膚", "強棒打", "隠れ蓑の術", "残像撃", "輪舞旋風"}, SkillDefinition::MonkeyKing, false);

    /** Xerath Definition */
    public static final Champion Xerath = new Champion(101, "Xerath", "ゼラス", "Xerath", 514.4F, 80.0F, 5.42F, 0.55F, 366.96F, 44.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.625F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {"Mana Surge", "Arcanopulse", "Eye of Destruction", "Shocking Orb", "Rite of the Arcane"}, new String[] {"マナ吸引", "魔力の波動", "破滅の瞳", "衝撃の宝珠", "深淵の儀式"}, SkillDefinition::Xerath, false);

    /** Xin Zhao Definition */
    public static final Champion XinZhao = new Champion(5, "Xin Zhao", "シン・ジャオ", "XinZhao", 591.16F, 87.0F, 8.175F, 0.7F, 273.8F, 35.0F, 7.255F, 0.45F, 57.544F, 3.3F, 0.672F, 2.6F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 1.25F, 345.0F, 175.0F, new String[] {"Challenge", "Three Talon Strike", "Battle Cry", "Audacious Charge", "Crescent Sweep"}, new String[] {"一意専心", "三槍撃", "気焔万丈", "兵貴神速", "三日月槍舞"}, SkillDefinition::XinZhao, false);

    /** Yasuo Definition */
    public static final Champion Yasuo = new Champion(157, "Yasuo", "ヤスオ", "Yasuo", 517.76F, 82.0F, 6.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 55.376F, 3.2F, 0.658F, 3.2F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 345.0F, 175.0F, new String[] {"Way of the Wanderer", "Steel Tempest", "Wind Wall", "Sweeping Blade", "Last Breath"}, new String[] {"浪人道", "百錬一刀", "風殺の壁", "居合斬り", "鬼哭啾々"}, SkillDefinition::Yasuo, false);

    /** Yorick Definition */
    public static final Champion Yorick = new Champion(83, "Yorick", "ヨーリック", "Yorick", 563.8F, 85.0F, 8.175F, 0.7F, 293.8F, 35.0F, 6.755F, 0.45F, 57.58F, 3.5F, 0.625F, 3.0F, 0.0F, 0.0F, 25.048F, 3.6F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Unholy Covenant", "Omen of War", "Omen of Pestilence", "Omen of Famine", "Omen of Death"}, new String[] {"不浄な誓約", "戦の凶兆", "疫の凶兆", "飢の凶兆", "死の凶兆"}, SkillDefinition::Yorick, false);

    /** Zac Definition */
    public static final Champion Zac = new Champion(154, "Zac", "ザック", "Zac", 614.6F, 95.0F, 7.92F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 59.67F, 3.375F, 0.638F, 1.6F, 0.0F, 0.0F, 23.88F, 3.5F, 32.1F, 1.25F, 335.0F, 175.0F, new String[] {"Cell Division", "Stretching Strike", "Unstable Matter", "Elastic Slingshot", "Let's Bounce!"}, new String[] {"スライムドロップ", "ノビノビパンチ", "ボインボイン", "スライミーショット", "ボムボムスラム"}, SkillDefinition::Zac, false);

    /** Zed Definition */
    public static final Champion Zed = new Champion(238, "Zed", "ゼド", "Zed", 579.4F, 80.0F, 7.09F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 54.712F, 3.4F, 0.644F, 2.1F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 1.25F, 345.0F, 125.0F, new String[] {"Contempt for the Weak", "Razor Shuriken", "Living Shadow", "Shadow Slash", "Death Mark"}, new String[] {"弱者必衰", "風車手裏剣", "影分身", "闇討ち", "死の刻印"}, SkillDefinition::Zed, false);

    /** Ziggs Definition */
    public static final Champion Ziggs = new Champion(115, "Ziggs", "ジグス", "Ziggs", 524.4F, 80.0F, 6.255F, 0.6F, 384.0F, 47.0F, 6.0F, 0.8F, 54.208F, 3.1F, 0.656F, 2.0F, 0.0F, 0.0F, 21.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {"Short Fuse", "Bouncing Bomb", "Satchel Charge", "Hexplosive Minefield", "Mega Inferno Bomb"}, new String[] {"ショートヒューズ", "バウンドボム", "エンジニアボム", "ヘクステックマイン", "メガインフェルノボム"}, SkillDefinition::Ziggs, false);

    /** Zilean Definition */
    public static final Champion Zilean = new Champion(26, "Zilean", "ジリアン", "Zilean", 499.28F, 77.0F, 5.44F, 0.5F, 360.8F, 60.0F, 8.5F, 0.8F, 51.64F, 3.0F, 0.625F, 2.13F, 0.0F, 0.0F, 19.134F, 3.8F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {"Time in a Bottle", "Time Bomb", "Rewind", "Time Warp", "Chronoshift"}, new String[] {"ハイスピードラーニング", "タイムボム", "リ・ウィンド", "タイムワープ", "クロノシフト"}, SkillDefinition::Zilean, false);

    /** Zyra Definition */
    public static final Champion Zyra = new Champion(143, "Zyra", "ザイラ", "Zyra", 479.32F, 74.0F, 5.69F, 0.5F, 334.0F, 50.0F, 8.5F, 0.8F, 53.376F, 3.2F, 0.625F, 2.11F, 0.0F, 0.0F, 20.04F, 3.0F, 30.0F, 0.0F, 325.0F, 575.0F, new String[] {"Rise of the Thorns", "Deadly Bloom", "Rampant Growth", "Grasping Roots", "Stranglethorns"}, new String[] {"最後の一咲き", "死華の誘い", "狂い咲き", "捕縛の根", "茨のゆりかご"}, SkillDefinition::Zyra, false);
}
