/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License"),
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;

import java.util.ArrayList;
import java.util.List;

import js.dom.Element;

/**
 * @version 2015/07/22 2:20:21
 */
public class Champion {

    /** The counter for id. */
    private static int counter = 0;

    /** The champion manager. */
    private static final List<Champion> champions = new ArrayList();

    /** Aatrox Definition */
    public static final Champion Aatrox = new Champion("Aatrox", "エイトロックス", "Aatrox", 537.8F, 85.0F, 6.59F, 0.5F, 105.6F, 45.0F, 0.0F, 0.0F, 60.376F, 3.2F, -0.04F, 3.0F, 0.0F, 0.0F, 24.384F, 3.8F, 32.1F, 0.0F, 345.0F, 150.0F, new String[] {
            "Blood Well", "Dark Flight", "Blood Thirst / Blood Price", "Blades of Torment",
            "Massacre"}, new String[] {"血の泉", "闇の翼", "血の渇望/血の代償", "嘆きの刃", "大虐殺"}, false);

    /** Ahri Definition */
    public static final Champion Ahri = new Champion("Ahri", "アーリ", "Ahri", 514.4F, 80.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.04F, 3.0F, -0.065F, 2.0F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Essence Theft", "Orb of Deception", "Fox-Fire", "Charm",
            "Spirit Rush"}, new String[] {"精気吸引", "幻惑の宝珠", "狐火", "魅了", "妖狐演舞"}, false);

    /** Akali Definition */
    public static final Champion Akali = new Champion("Akali", "アカリ", "Akali", 587.8F, 85.0F, 8.34F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 58.376F, 3.2F, -0.1F, 3.1F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Twin Disciplines", "Mark of the Assassin", "Twilight Shroud", "Crescent Slash",
            "Shadow Dance"}, new String[] {"双の行", "刺客の刻印", "薄闇の帳", "三日月斬り", "影の舞"}, false);

    /** Alistar Definition */
    public static final Champion Alistar = new Champion("Alistar", "アリスター", "Alistar", 613.36F, 102.0F, 8.675F, 0.85F, 278.84F, 38.0F, 6.0F, 0.8F, 61.1116F, 3.62F, 0.0F, 2.125F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 0.0F, 330.0F, 125.0F, new String[] {
            "Trample", "Pulverize", "Headbutt", "Triumphant Roar",
            "Unbreakable Will"}, new String[] {"踏破", "圧砕", "頭突き", "戦士の咆哮", "不屈の意志"}, false);

    /** Amumu Definition */
    public static final Champion Amumu = new Champion("Amumu", "アムム", "Amumu", 613.12F, 84.0F, 8.875F, 0.85F, 287.2F, 40.0F, 7.38F, 0.525F, 53.384F, 3.8F, -0.02F, 2.18F, 0.0F, 0.0F, 23.544F, 3.3F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Cursed Touch", "Bandage Toss", "Despair", "Tantrum",
            "Curse of the Sad Mummy"}, new String[] {"呪いの手", "絡みつく包帯", "涙の池", "あばれる", "泣き虫ミイラの呪い"}, false);

    /** Anivia Definition */
    public static final Champion Anivia = new Champion("Anivia", "アニヴィア", "Anivia", 467.6F, 70.0F, 5.57F, 0.55F, 346.04F, 53.0F, 6.0F, 0.8F, 51.376F, 3.2F, 0.0F, 1.68F, 0.0F, 0.0F, 21.22F, 4.0F, 30.0F, 0.0F, 325.0F, 600.0F, new String[] {
            "Rebirth", "Flash Frost", "Crystallize", "Frostbite",
            "Glacial Storm"}, new String[] {"再誕", "結氷の煌めき", "氷塊の壁", "一振りの氷柱", "凍てつく吹雪"}, false);

    /** Annie Definition */
    public static final Champion Annie = new Champion("Annie", "アニー", "Annie", 511.68F, 76.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 50.41F, 2.625F, 0.08F, 1.36F, 0.0F, 0.0F, 19.22F, 4.0F, 30.0F, 0.0F, 335.0F, 575.0F, new String[] {
            "Pyromania", "Disintegrate", "Incinerate", "Molten Shield",
            "Summon: Tibbers"}, new String[] {"火遊びだいすき", "ファイアボール", "バーニングファイア", "モルテンシールド", "でておいで！ティバーズ！"}, false);

    /** Ashe Definition */
    public static final Champion Ashe = new Champion("Ashe", "アッシュ", "Ashe", 527.72F, 79.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 51.088F, 2.85F, -0.05F, 3.33F, 0.0F, 0.0F, 21.212F, 3.4F, 30.0F, 0.0F, 325.0F, 600.0F, new String[] {
            "Frost Shot", "Ranger's Focus", "Volley", "Hawkshot",
            "Enchanted Crystal Arrow"}, new String[] {"フロストショット", "レンジャーのフォーカス", "ボレー", "ホークショット", "クリスタルアロー"}, false);

    /** Azir Definition */
    public static final Champion Azir = new Champion("Azir", "アジール", "Azir", 524.4F, 80.0F, 6.92F, 0.55F, 350.56F, 42.0F, 6.0F, 0.8F, 52.0F, 2.8F, -0.02F, 1.5F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Shurima's Legacy", "Conquering Sands", "Arise!", "Shifting Sands",
            "Emperor's Divide"}, new String[] {"シュリーマの遺産", "征服の勅命", "目覚めよ！", "流砂の衝撃", "皇帝の断絶"}, false);

    /** Bard Definition */
    public static final Champion Bard = new Champion("Bard", "バード", "Bard", 535.0F, 85.0F, 5.4F, 0.55F, 350.0F, 50.0F, 6.0F, 0.45F, 52.0F, 3.0F, 0.0F, 2.0F, 0.0F, 0.0F, 25.0F, 4.0F, 30.0F, 0.0F, 330.0F, 500.0F, new String[] {
            "Traveler's Call", "Cosmic Binding", "Caretaker's Shrine", "Magical Journey",
            "Tempered Fate"}, new String[] {"旅人の呼び声", "宇宙の法則", "回復の遺物", "精霊の旅路", "運命の調律"}, false);

    /** Blitzcrank Definition */
    public static final Champion Blitzcrank = new Champion("Blitzcrank", "ブリッツ", "Blitzcrank", 582.6F, 95.0F, 8.51F, 0.75F, 267.2F, 40.0F, 6.0F, 0.8F, 61.54F, 3.5F, 0.0F, 1.13F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 0.0F, 325.0F, 125.0F, new String[] {
            "Mana Barrier", "Rocket Grab", "Overdrive", "Power Fist",
            "Static Field"}, new String[] {"マナバリア", "ロケットグラブ", "オーバードライブ", "パワーフィスト", "イナズマフィールド"}, false);

    /** Brand Definition */
    public static final Champion Brand = new Champion("Brand", "ブランド", "Brand", 507.68F, 76.0F, 5.42F, 0.55F, 325.6F, 45.0F, 8.005F, 0.6F, 57.04F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {
            "Blaze", "Sear", "Pillar of Flame", "Conflagration",
            "Pyroclasm"}, new String[] {"炎上", "焦炎", "烈火の柱", "焼灼", "業火"}, false);

    /** Braum Definition */
    public static final Champion Braum = new Champion("Braum", "ブラーム", "Braum", 576.16F, 87.0F, 8.18F, 1.0F, 310.6F, 45.0F, 6.0F, 0.8F, 55.376F, 3.2F, -0.03F, 3.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Concussive Blows", "Winter's Bite", "Stand Behind Me", "Unbreakable",
            "Glacial Fissure"}, new String[] {"漢の拳", "冬の凍瘡", "儂に任せとけ！", "不破の盾", "氷河の裂溝"}, false);

    /** Caitlyn Definition */
    public static final Champion Caitlyn = new Champion("Caitlyn", "ケイトリン", "Caitlyn", 524.4F, 80.0F, 5.67F, 0.55F, 313.8F, 35.0F, 7.42F, 0.55F, 50.04F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 650.0F, new String[] {
            "Headshot", "Piltover Peacemaker", "Yordle Snap Trap", "90 Caliber Net",
            "Ace in the Hole"}, new String[] {"ヘッドショット", "ピースメーカー", "ヨードルトラップ", "L-90 カリバーネット", "ブルズアイ"}, false);

    /** Cassiopeia Definition */
    public static final Champion Cassiopeia = new Champion("Cassiopeia", "カシオペア", "Cassiopeia", 506.0F, 75.0F, 5.69F, 0.5F, 370.8F, 60.0F, 8.36F, 0.75F, 52.376F, 3.2F, -0.034F, 1.68F, 0.0F, 0.0F, 22.22F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {
            "Aspect of the Serpent", "Noxious Blast", "Miasma", "Twin Fang",
            "Petrifying Gaze"}, new String[] {"蛇の容貌", "ノクサスの害毒", "瘴毒", "双毒牙", "石化の視線"}, false);

    /** Cho'Gath Definition */
    public static final Champion Chogath = new Champion("Cho'Gath", "チョ＝ガス", "Chogath", 574.4F, 80.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.0F, 1.44F, 0.0F, 0.0F, 28.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Carnivore", "Rupture", "Feral Scream", "Vorpal Spikes",
            "Feast"}, new String[] {"暴食", "地裂の棘", "死の叫び声", "絶命の棘", "捕食"}, false);

    /** Corki Definition */
    public static final Champion Corki = new Champion("Corki", "コーキー", "Corki", 512.76F, 82.0F, 5.42F, 0.55F, 305.16F, 37.0F, 7.42F, 0.55F, 51.24F, 3.0F, 0.0F, 2.3F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Hextech Shrapnel Shells", "Phosphorus Bomb", "Valkyrie", "Gatling Gun",
            "Missile Barrage"}, new String[] {"ヘクステック榴散弾", "閃光弾", "ワルキューレの騎行", "ガトリング砲", "連発ミサイル"}, false);

    /** Darius Definition */
    public static final Champion Darius = new Champion("Darius", "ダリウス", "Darius", 582.24F, 93.0F, 9.845F, 0.95F, 263.0F, 37.5F, 6.585F, 0.35F, 55.88F, 3.5F, -0.08F, 2.65F, 0.0F, 0.0F, 29.88F, 3.5F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {
            "Hemorrhage", "Decimate", "Crippling Strike", "Apprehend",
            "Noxian Guillotine"}, new String[] {"大出血", "皆殺しの斧", "薙ぎ払い", "捕縛", "ノクサス斬首斧"}, false);

    /** Diana Definition */
    public static final Champion Diana = new Champion("Diana", "ダイアナ", "Diana", 589.2F, 90.0F, 7.425F, 0.85F, 297.2F, 40.0F, 6.0F, 0.8F, 53.04F, 3.0F, 0.0F, 2.25F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 0.0F, 345.0F, 150.0F, new String[] {
            "Moonsilver Blade", "Crescent Strike", "Pale Cascade", "Moonfall",
            "Lunar Rush"}, new String[] {"銀月の刃", "月影", "朧月の羽衣", "瞬月", "月下美刃"}, false);

    /** Draven Definition */
    public static final Champion Draven = new Champion("Draven", "ドレイヴン", "Draven", 557.76F, 82.0F, 6.175F, 0.7F, 310.56F, 42.0F, 8.04F, 0.65F, 50.38F, 3.5F, -0.08F, 2.7F, 0.0F, 0.0F, 25.544F, 3.3F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "League of Draven", "Spinning Axe", "Blood Rush", "Stand Aside",
            "Whirling Death"}, new String[] {"リーグ・オブ・ドレイヴン", "回転斬斧", "血の疼き", "薙ぎ払い", "死の車輪"}, false);

    /** Dr. Mundo Definition */
    public static final Champion DrMundo = new Champion("Dr. Mundo", "ドクター・ムンド", "DrMundo", 582.52F, 89.0F, 7.76F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 61.27F, 3.0F, 0.0F, 2.8F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Adrenaline Rush", "Infected Cleaver", "Burning Agony", "Masochism",
            "Sadism"}, new String[] {"アドレナリンラッシュ", "ホウチョウ", "バーニングペイン", "マゾヒズム", "サディズム"}, false);

    /** Ekko Definition */
    public static final Champion Ekko = new Champion("Ekko", "エコー", "Ekko", 580.0F, 80.0F, 9.0F, 0.9F, 280.0F, 50.0F, 6.0F, 0.8F, 59.0F, 3.0F, 0.0F, 3.3F, 0.0F, 0.0F, 27.0F, 3.0F, 32.0F, 0.0F, 340.0F, 125.0F, new String[] {
            "Z-Drive Resonance", "Timewinder", "Parallel Convergence", "Phase Dive",
            "Chronobreak"}, new String[] {"ゼロ・ドライブ共振", "時空ワインダー", "パラレルタイムトラップ", "亜空間ダイブ", "クロノブレイク"}, false);

    /** Elise Definition */
    public static final Champion Elise = new Champion("Elise", "エリス", "Elise", 529.4F, 80.0F, 5.705F, 0.6F, 324.0F, 50.0F, 6.0F, 0.8F, 50.54F, 3.0F, 0.0F, 1.75F, 0.0F, 0.0F, 22.128F, 3.35F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Spider Queen", "Neurotoxin / Venomous Bite", "Volatile Spiderling / Skittering Frenzy", "Cocoon / Rappel",
            "Spider Form", "Venomous Bite / Neurotoxin", "Skittering Frenzy / Volatile Spiderling", "Rappel / Cocoon",
            "Human Form"}, new String[] {"孵化", "神経毒/毒牙", "子蜘蛛爆弾/猛食", "繭化/蜘蛛の糸", "蜘蛛形態", "毒牙/神経毒", "猛食/子蜘蛛爆弾", "蜘蛛の糸/繭化",
                    "ヒト形態"}, false);

    /** Elise Definition */
    public static final Champion EliseTransformed = new Champion("Elise", "エリス", "Elise", 529.4F, 80.0F, 5.705F, 0.6F, 324.0F, 50.0F, 6.0F, 0.8F, 50.54F, 3.0F, 0.0F, 1.75F, 0.0F, 0.0F, 22.128F, 3.35F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Spider Queen", "Neurotoxin / Venomous Bite", "Volatile Spiderling / Skittering Frenzy", "Cocoon / Rappel",
            "Spider Form", "Venomous Bite / Neurotoxin", "Skittering Frenzy / Volatile Spiderling", "Rappel / Cocoon",
            "Human Form"}, new String[] {"孵化", "神経毒/毒牙", "子蜘蛛爆弾/猛食", "繭化/蜘蛛の糸", "蜘蛛形態", "毒牙/神経毒", "猛食/子蜘蛛爆弾", "蜘蛛の糸/繭化",
                    "ヒト形態"}, true);

    /** Evelynn Definition */
    public static final Champion Evelynn = new Champion("Evelynn", "エヴェリン", "Evelynn", 531.2F, 90.0F, 9.82F, 0.55F, 265.6F, 45.0F, 8.105F, 0.6F, 53.88F, 3.5F, 0.0F, 3.6F, 0.0F, 0.0F, 26.5F, 3.8F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {
            "Shadow Walk", "Hate Spike", "Dark Frenzy", "Ravage",
            "Agony's Embrace"}, new String[] {"影踏み", "憎悪の棘", "闇の舞", "猛撃", "苦悶の抱擁"}, false);

    /** Ezreal Definition */
    public static final Champion Ezreal = new Champion("Ezreal", "エズリアル", "Ezreal", 484.4F, 80.0F, 6.42F, 0.55F, 310.6F, 45.0F, 8.09F, 0.65F, 50.24F, 3.0F, 0.0F, 2.8F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Rising Spell Force", "Mystic Shot", "Essence Flux", "Arcane Shift",
            "Trueshot Barrage"}, new String[] {"ライジングフォース", "ミスティックショット", "エッセンスフロー", "ミスティカルシフト", "トゥルーショット"}, false);

    /** Fiddlesticks Definition */
    public static final Champion FiddleSticks = new Champion("Fiddlesticks", "フィドル", "FiddleSticks", 524.4F, 80.0F, 5.605F, 0.6F, 350.12F, 59.0F, 6.0F, 0.8F, 48.36F, 2.625F, 0.0F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 480.0F, new String[] {
            "Dread", "Terrify", "Drain", "Dark Wind",
            "Crowstorm"}, new String[] {"ドレッド", "テラー", "ドレイン", "ダークウィンド", "クロウストーム"}, false);

    /** Fiora Definition */
    public static final Champion Fiora = new Champion("Fiora", "フィオラ", "Fiora", 592.8F, 85.0F, 6.84F, 0.8F, 287.2F, 40.0F, 7.59F, 0.5F, 59.876F, 3.2F, -0.07F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Duelist", "Lunge", "Riposte", "Burst of Speed",
            "Blade Waltz"}, new String[] {"デュエリスト", "ファント", "リポスト", "スピードバースト", "ブレードワルツ"}, false);

    /** Fizz Definition */
    public static final Champion Fizz = new Champion("Fizz", "フィズ", "Fizz", 558.48F, 86.0F, 8.175F, 0.7F, 267.2F, 40.0F, 6.0F, 0.8F, 58.04F, 3.0F, -0.05F, 3.1F, 0.0F, 0.0F, 22.412F, 3.4F, 32.1F, 0.0F, 335.0F, 175.0F, new String[] {
            "Nimble Fighter", "Urchin Strike", "Seastone Trident", "Playful / Trickster",
            "Chum the Waters"}, new String[] {"シーファイター", "ウニトゲ・ストライク", "シートライデント", "プレイ/トリックスター", "フィッシング"}, false);

    /** Galio Definition */
    public static final Champion Galio = new Champion("Galio", "ガリオ", "Galio", 577.8F, 85.0F, 8.71F, 0.75F, 319.0F, 50.0F, 6.0F, 0.8F, 61.97F, 3.375F, -0.02F, 1.2F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Runic Skin", "Resolute Smite", "Bulwark", "Righteous Gust",
            "Idol of Durand"}, new String[] {"ルーンの加護", "懲罰の視線", "忠義の防壁", "正義の追い風", "デュランドの偶像"}, false);

    /** Gangplank Definition */
    public static final Champion Gangplank = new Champion("Gangplank", "ガングプランク", "Gangplank", 631.08F, 81.0F, 5.51F, 0.75F, 282.2F, 40.0F, 7.675F, 0.7F, 59.04F, 3.0F, -0.04F, 2.75F, 0.0F, 0.0F, 26.044F, 3.3F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Grog-Soaked Blade", "Parrrley", "Remove Scurvy", "Raise Morale",
            "Cannon Barrage"}, new String[] {"酒浸りの剣", "偽りの発砲", "壊血病治癒", "士気上昇", "一斉砲撃"}, false);

    /** Garen Definition */
    public static final Champion Garen = new Champion("Garen", "ガレン", "Garen", 616.28F, 96.0F, 7.84F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 57.88F, 3.5F, 0.0F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Perseverance", "Decisive Strike", "Courage", "Judgment",
            "Demacian Justice"}, new String[] {"忍耐", "断固たる一撃", "勇気の護り", "断罪剣", "デマーシアの正義"}, false);

    /** Gnar Definition */
    public static final Champion Gnar = new Champion("Gnar", "ナー", "Gnar", 540.0F, 65.0F, 2.5F, 0.5F, 100.0F, 0.0F, 0.0F, 0.0F, 48.0F, 3.0F, 0.0F, 6.0F, 0.0F, 0.0F, 23.0F, 2.5F, 30.0F, 0.0F, 325.0F, 150.0F, new String[] {
            "Rage Gene", "Boomerang Throw / Boulder Toss", "Hyper / Wallop", "Hop / Crunch",
            "GNAR!"}, new String[] {"ぷんすこ", "ブーメラン/ぽいっ", "ごきげん/こてんぱん", "ぴょんぴょん/ドガン！", "ナー！"}, false);

    /** Gragas Definition */
    public static final Champion Gragas = new Champion("Gragas", "グラガス", "Gragas", 583.52F, 89.0F, 5.5F, 0.5F, 400.0F, 47.0F, 6.0F, 0.8F, 61.38F, 3.5F, -0.04F, 2.05F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 0.0F, 330.0F, 125.0F, new String[] {
            "Happy Hour", "Barrel Roll", "Drunken Rage", "Body Slam",
            "Explosive Cask"}, new String[] {"ほろ酔い", "タル転がし", "飲みすぎ注意", "腹の肉", "タル爆弾"}, false);

    /** Graves Definition */
    public static final Champion Graves = new Champion("Graves", "グレイヴズ", "Graves", 551.12F, 84.0F, 6.675F, 0.7F, 322.2F, 40.0F, 7.925F, 0.7F, 54.208F, 3.1F, 0.0F, 2.9F, 0.0F, 0.0F, 24.376F, 3.2F, 30.0F, 0.0F, 330.0F, 525.0F, new String[] {
            "True Grit", "Buckshot", "Smoke Screen", "Quickdraw",
            "Collateral Damage"}, new String[] {"確固たる信念", "散弾", "煙幕", "早撃ち", "炸裂砲弾"}, false);

    /** Hecarim Definition */
    public static final Champion Hecarim = new Champion("Hecarim", "ヘカリム", "Hecarim", 599.6F, 95.0F, 7.0F, 0.75F, 277.2F, 40.0F, 6.5F, 0.6F, 61.376F, 3.2F, -0.0672F, 2.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 0.0F, 345.0F, 175.0F, new String[] {
            "Warpath", "Rampage", "Spirit of Dread", "Devastating Charge",
            "Onslaught of Shadows"}, new String[] {"出陣", "縦横無尽", "怨霊の恐怖", "猛突進", "幻影の襲撃"}, false);

    /** Heimerdinger Definition */
    public static final Champion Heimerdinger = new Champion("Heimerdinger", "ハイマー", "Heimerdinger", 476.0F, 75.0F, 11.005F, 1.75F, 307.2F, 40.0F, 6.0F, 0.8F, 55.536F, 2.7F, 0.0F, 1.36F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {
            "Techmaturgical Repair Bots", "H-28G Evolution Turret", "Hextech Micro-Rockets",
            "CH-2 Electron Storm Grenade", "UPGRADE!!!"}, new String[] {"テクマタージカル修理ボット", "H-28G革新砲", "ヘクステック小型ロケット",
                    "CH-2超電磁グレネード", "アップグレード！！！"}, false);

    /** Irelia Definition */
    public static final Champion Irelia = new Champion("Irelia", "イレリア", "Irelia", 607.2F, 90.0F, 8.59F, 0.65F, 288.8F, 35.0F, 8.09F, 0.65F, 61.544F, 3.3F, -0.06F, 3.2F, 0.0F, 0.0F, 25.3F, 3.75F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Ionian Fervor", "Bladesurge", "Hiten Style", "Equilibrium Strike",
            "Transcendent Blades"}, new String[] {"アイオニアの熱情", "瞬剣", "飛天流", "平衡の一撃", "飛剣の舞"}, false);

    /** Janna Definition */
    public static final Champion Janna = new Champion("Janna", "ジャンナ", "Janna", 487.04F, 78.0F, 5.42F, 0.55F, 409.52F, 64.0F, 9.0F, 0.4F, 51.956F, 2.95F, 0.0F, 2.61F, 0.0F, 0.0F, 19.384F, 3.8F, 30.0F, 0.0F, 335.0F, 475.0F, new String[] {
            "Tailwind", "Howling Gale", "Zephyr", "Eye Of The Storm",
            "Monsoon"}, new String[] {"追い風", "颶風のすさび", "西風の神", "嵐の祝福", "青嵐"}, false);

    /** Jarvan IV Definition */
    public static final Champion JarvanIV = new Champion("Jarvan IV", "ジャーヴァンⅣ", "JarvanIV", 571.2F, 90.0F, 8.175F, 0.7F, 302.2F, 40.0F, 6.755F, 0.45F, 55.712F, 3.4F, -0.05F, 2.5F, 0.0F, 0.0F, 27.0F, 3.6F, 32.1F, 0.0F, 340.0F, 175.0F, new String[] {
            "Martial Cadence", "Dragon Strike", "Golden Aegis", "Demacian Standard",
            "Cataclysm"}, new String[] {"武魂の律動", "龍撃", "黄金の護輪", "デマーシアの旗印", "決戦場"}, false);

    /** Jax Definition */
    public static final Champion Jax = new Champion("Jax", "ジャックス", "Jax", 592.8F, 85.0F, 8.37F, 0.55F, 288.8F, 35.0F, 7.575F, 0.7F, 61.97F, 3.375F, -0.02F, 3.4F, 0.0F, 0.0F, 27.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Relentless Assault", "Leap Strike", "Empower", "Counter Strike",
            "Grandmaster's Might"}, new String[] {"連撃の鬼", "跳躍撃", "入魂", "後の先", "達人の剛力"}, false);

    /** Jayce Definition */
    public static final Champion Jayce = new Champion("Jayce", "ジェイス", "Jayce", 571.2F, 90.0F, 7.34F, 0.8F, 307.2F, 40.0F, 6.0F, 0.8F, 50.38F, 3.5F, -0.05F, 3.0F, 0.0F, 0.0F, 22.38F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {
            "Hextech Capacitor", "To the Skies! / Shock Blast", "Lightning Field / Hyper Charge",
            "Thundering Blow / Acceleration Gate", "Mercury Cannon / Mercury Hammer", "Shock Blast", "Hyper Charge",
            "Acceleration Gate", "Mercury Hammer"}, new String[] {"ヘクステック・コンデンサー", "スカイバスター/ショックブラスト",
                    "ライトニング/ハイパーチャージ", "サンダーブロー/アクセルゲート", "マーキュリーキャノン/マーキュリーハンマー", "ショックブラスト", "ハイパーチャージ", "アクセルゲート",
                    "マーキュリーハンマー"}, false);

    /** Jayce Definition */
    public static final Champion JayceTransformed = new Champion("Jayce", "ジェイス", "Jayce", 571.2F, 90.0F, 7.34F, 0.8F, 307.2F, 40.0F, 6.0F, 0.8F, 50.38F, 3.5F, -0.05F, 3.0F, 0.0F, 0.0F, 22.38F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {
            "Hextech Capacitor", "To the Skies! / Shock Blast", "Lightning Field / Hyper Charge",
            "Thundering Blow / Acceleration Gate", "Mercury Cannon / Mercury Hammer", "Shock Blast", "Hyper Charge",
            "Acceleration Gate", "Mercury Hammer"}, new String[] {"ヘクステック・コンデンサー", "スカイバスター/ショックブラスト",
                    "ライトニング/ハイパーチャージ", "サンダーブロー/アクセルゲート", "マーキュリーキャノン/マーキュリーハンマー", "ショックブラスト", "ハイパーチャージ", "アクセルゲート",
                    "マーキュリーハンマー"}, true);

    /** Jinx Definition */
    public static final Champion Jinx = new Champion("Jinx", "ジンクス", "Jinx", 517.76F, 82.0F, 5.84F, 0.5F, 245.6F, 45.0F, 6.68F, 1.0F, 53.04F, 3.0F, 0.0F, 1.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {
            "Get Excited!", "Switcheroo!", "Zap!", "Flame Chompers!", "Super Mega Death Rocket!"}, new String[] {
                    "キャッホー！", "スイッチング！", "シビレーザー！", "パックンチョッパー！", "スーパーメガデスロケット！"}, false);

    /** Kalista Definition */
    public static final Champion Kalista = new Champion("Kalista", "カリスタ", "Kalista", 517.76F, 83.0F, 6.0F, 0.55F, 231.8F, 35.0F, 6.3F, 0.4F, 57.5F, 3.5F, -0.05F, 3.3F, 0.0F, 0.0F, 19.012F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Martial Poise", "Pierce", "Sentinel", "Rend",
            "Fate's Call"}, new String[] {"戦いの所作", "貫魂の一投", "執念の霊魂", "引き裂く遺恨", "宿命の呼び声"}, false);

    /** Karma Definition */
    public static final Champion Karma = new Champion("Karma", "カルマ", "Karma", 522.44F, 83.0F, 5.62F, 0.55F, 374.0F, 50.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.0F, 2.3F, 0.0F, 0.0F, 20.384F, 3.8F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Gathering Fire", "Inner Flame", "Focused Resolve", "Inspire",
            "Mantra"}, new String[] {"寄せ火", "内なる炎", "不退転の決意", "激励", "マントラ"}, false);

    /** Karthus Definition */
    public static final Champion Karthus = new Champion("Karthus", "カーサス", "Karthus", 516.0F, 75.0F, 6.42F, 0.55F, 372.48F, 61.0F, 6.0F, 0.8F, 45.66F, 3.25F, 0.0F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {
            "Death Defied", "Lay Waste", "Wall of Pain", "Defile",
            "Requiem"}, new String[] {"死の拒絶", "根絶やし", "苦痛の壁", "冒涜", "鎮魂歌"}, false);

    /** Kassadin Definition */
    public static final Champion Kassadin = new Champion("Kassadin", "カサディン", "Kassadin", 564.04F, 78.0F, 7.79F, 0.5F, 347.6F, 70.0F, 6.0F, 0.8F, 58.852F, 3.9F, -0.023F, 3.7F, 0.0F, 0.0F, 23.376F, 3.2F, 30.0F, 0.0F, 340.0F, 150.0F, new String[] {
            "Void Stone", "Null Sphere", "Nether Blade", "Force Pulse",
            "Riftwalk"}, new String[] {"ヴォイドの石", "零の魔珠", "冥界の刃", "闇の波動", "無限回廊"}, false);

    /** Katarina Definition */
    public static final Champion Katarina = new Champion("Katarina", "カタリナ", "Katarina", 510.0F, 83.0F, 4.5F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 58.0F, 3.2F, -0.05F, 2.74F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Voracity", "Bouncing Blades", "Sinister Steel", "Shunpo",
            "Death Lotus"}, new String[] {"貪欲", "跳刃乱舞", "凶刃の渦", "瞬歩", "死刃蓮華"}, false);

    /** Kayle Definition */
    public static final Champion Kayle = new Champion("Kayle", "ケイル", "Kayle", 574.24F, 93.0F, 8.26F, 0.75F, 322.2F, 40.0F, 6.0F, 0.8F, 56.004F, 2.8F, -0.02F, 2.2F, 0.0F, 0.0F, 26.88F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {
            "Holy Fervor", "Reckoning", "Divine Blessing", "Righteous Fury",
            "Intervention"}, new String[] {"聖なる闘志", "天罰", "神々の祝福", "義憤", "神権代行"}, false);

    /** Kennen Definition */
    public static final Champion Kennen = new Champion("Kennen", "ケネン", "Kennen", 535.72F, 79.0F, 5.59F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 50.544F, 3.3F, -0.0947F, 3.4F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {
            "Mark of the Storm", "Thundering Shuriken", "Electrical Surge", "Lightning Rush",
            "Slicing Maelstrom"}, new String[] {"嵐の刻印", "雷手裏剣", "稲妻の奔流", "疾風迅雷", "雷撃の大嵐"}, false);

    /** Kha'Zix Definition */
    public static final Champion Khazix = new Champion("Kha'Zix", "カ＝ジックス", "Khazix", 572.8F, 85.0F, 7.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Unseen Threat", "Taste Their Fear", "Void Spike", "Leap",
            "Void Assault"}, new String[] {"見えざる脅威", "甘美なる恐怖", "破裂の棘", "跳躍", "捕食の本能"}, false);

    /** Kog'Maw Definition */
    public static final Champion KogMaw = new Champion("Kog'Maw", "コグ＝マウ", "KogMaw", 546.16F, 87.0F, 5.92F, 0.55F, 322.2F, 40.0F, 8.675F, 0.7F, 49.04F, 3.0F, -0.06F, 2.65F, 0.0F, 0.0F, 19.88F, 3.5F, 30.0F, 0.0F, 325.0F, 500.0F, new String[] {
            "Icathian Surprise", "Caustic Spittle", "Bio-Arcane Barrage", "Void Ooze",
            "Living Artillery"}, new String[] {"イカシアの自爆", "腐食粘液", "有機性魔力砲", "ヴォイド分泌液", "生体空撃砲"}, false);

    /** LeBlanc Definition */
    public static final Champion Leblanc = new Champion("LeBlanc", "ルブラン", "Leblanc", 516.0F, 75.0F, 7.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 54.88F, 3.5F, 0.0F, 1.4F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Mirror Image", "Sigil of Malice", "Distortion", "Ethereal Chains",
            "Mimic"}, new String[] {"鏡像", "悪意の印", "空間歪曲", "霊妙な鎖", "再演"}, false);

    /** Lee Sin Definition */
    public static final Champion LeeSin = new Champion("Lee Sin", "リー・シン", "LeeSin", 570.8F, 85.0F, 7.425F, 0.7F, 200.0F, 0.0F, 50.0F, 0.0F, 61.176F, 3.2F, -0.04F, 3.0F, 0.0F, 0.0F, 24.216F, 3.7F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Flurry", "Sonic Wave / Resonating Strike", "Safeguard / Iron Will", "Tempest / Cripple",
            "Dragon's Rage"}, new String[] {"乱舞", "音の波動/共鳴拳", "守りの型/鉄の意志", "破風/縛脚", "龍の怒り"}, false);

    /** Leona Definition */
    public static final Champion Leona = new Champion("Leona", "レオナ", "Leona", 576.16F, 87.0F, 8.425F, 0.85F, 302.2F, 40.0F, 6.0F, 0.8F, 60.04F, 3.0F, 0.0F, 2.9F, 0.0F, 0.0F, 27.208F, 3.1F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Sunlight", "Shield of Daybreak", "Eclipse", "Zenith Blade",
            "Solar Flare"}, new String[] {"太陽の輝き", "暁の盾", "煌光破", "天陽の剣", "太陽の一閃"}, false);

    /** Lissandra Definition */
    public static final Champion Lissandra = new Champion("Lissandra", "リサンドラ", "Lissandra", 506.12F, 84.0F, 6.92F, 0.55F, 304.0F, 50.0F, 5.67F, 0.4F, 50.536F, 2.7F, 0.0F, 1.36F, 0.0F, 0.0F, 20.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Iceborn", "Ice Shard", "Ring of Frost", "Glacial Path",
            "Frozen Tomb"}, new String[] {"アイスボーン", "アイスシャード", "リング・オブ・フロスト", "グラシアルパス", "フローズングレイブ"}, false);

    /** Lucian Definition */
    public static final Champion Lucian = new Champion("Lucian", "ルシアン", "Lucian", 554.4F, 80.0F, 6.19F, 0.65F, 298.88F, 41.0F, 8.175F, 0.7F, 52.04F, 3.0F, -0.02F, 3.3F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {
            "Lightslinger", "Piercing Light", "Ardent Blaze", "Relentless Pursuit",
            "The Culling"}, new String[] {"二丁掃射", "閃光", "浄化の星印", "瞬脚", "殲滅"}, false);

    /** Lulu Definition */
    public static final Champion Lulu = new Champion("Lulu", "ルル", "Lulu", 552.76F, 82.0F, 6.005F, 0.6F, 292.4F, 55.0F, 8.5F, 0.6F, 46.368F, 2.6F, 0.0F, 2.25F, 0.0F, 0.0F, 19.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Pix, Faerie Companion", "Glitterlance", "Whimsy", "Help, Pix!",
            "Wild Growth"}, new String[] {"仲良し妖精ピックス", "ぴかぴかランス", "イタズラ", "ピックス、おねがい！", "おおきくなぁれ！"}, false);

    /** Lux Definition */
    public static final Champion Lux = new Champion("Lux", "ラックス", "Lux", 477.72F, 79.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.0F, 1.36F, 0.0F, 0.0F, 18.72F, 4.0F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Illumination", "Light Binding", "Prismatic Barrier", "Lucent Singularity",
            "Final Spark"}, new String[] {"イルミネーション", "ライトバインド", "プリズムバリア", "シンギュラリティ", "ファイナルスパーク"}, false);

    /** Malphite Definition */
    public static final Champion Malphite = new Champion("Malphite", "マルファイト", "Malphite", 574.2F, 90.0F, 8.37F, 0.55F, 282.2F, 40.0F, 7.32F, 0.55F, 61.97F, 3.375F, -0.02F, 3.4F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Granite Shield", "Seismic Shard", "Brutal Strikes", "Ground Slam",
            "Unstoppable Force"}, new String[] {"岩盤の盾", "大地の破片", "大地の怒り", "岩強の拳", "不可止の衝撃"}, false);

    /** Malzahar Definition */
    public static final Champion Malzahar = new Champion("Malzahar", "マルザハール", "Malzahar", 514.4F, 80.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {
            "Summon Voidling", "Call of the Void", "Null Zone", "Malefic Visions",
            "Nether Grasp"}, new String[] {"ヴォイドリング使い", "ヴォイドの呼び声", "零の領域", "視の浸食", "冥界の緊縛"}, false);

    /** Maokai Definition */
    public static final Champion Maokai = new Champion("Maokai", "マオカイ", "Maokai", 572.2F, 90.0F, 8.675F, 0.85F, 327.28F, 46.0F, 7.205F, 0.45F, 63.544F, 3.3F, -0.1F, 2.125F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 335.0F, 125.0F, new String[] {
            "Sap Magic", "Arcane Smash", "Twisted Advance", "Sapling Toss",
            "Vengeful Maelstrom"}, new String[] {"魔樹液", "魔紋打ち", "進撃の樹人", "苗木投げ", "報復の旋風"}, false);

    /** Master Yi Definition */
    public static final Champion MasterYi = new Champion("Master Yi", "マスター・イー", "MasterYi", 598.56F, 92.0F, 7.59F, 0.65F, 250.56F, 42.0F, 7.255F, 0.45F, 60.04F, 3.0F, -0.08F, 2.0F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 0.0F, 355.0F, 125.0F, new String[] {
            "Double Strike", "Alpha Strike", "Meditate", "Wuju Style",
            "Highlander"}, new String[] {"双連斬", "疾風斬・極", "明鏡止水", "無極流", "無極流奥義"}, false);

    /** Miss Fortune Definition */
    public static final Champion MissFortune = new Champion("Miss Fortune", "フォーチュン", "MissFortune", 577.8F, 85.0F, 6.19F, 0.65F, 275.84F, 38.0F, 8.04F, 0.65F, 49.54F, 3.0F, -0.04734F, 3.01F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Strut", "Double Up", "Impure Shots", "Make It Rain",
            "Bullet Time"}, new String[] {"ステップアップ", "ダブルアップ", "ダーティショット", "レイニングバレット", "バレットタイム"}, false);

    /** Wukong Definition */
    public static final Champion MonkeyKing = new Champion("Wukong", "ウーコン", "MonkeyKing", 577.8F, 85.0F, 6.19F, 0.65F, 265.84F, 38.0F, 8.04F, 0.65F, 59.876F, 3.2F, -0.05F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 345.0F, 175.0F, new String[] {
            "Stone Skin", "Crushing Blow", "Decoy", "Nimbus Strike",
            "Cyclone"}, new String[] {"岩の皮膚", "強棒打", "隠れ蓑の術", "残像撃", "輪舞旋風"}, false);

    /** Mordekaiser Definition */
    public static final Champion Mordekaiser = new Champion("Mordekaiser", "モルデカイザー", "Mordekaiser", 555.4F, 80.0F, 3.37F, 0.55F, 120.0F, 0.0F, 0.0F, 0.0F, 57.58F, 3.5F, -0.1F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {
            "Iron Man", "Mace of Spades", "Creeping Death", "Siphon of Destruction",
            "Children of the Grave"}, new String[] {"アイアンマン", "メイス・オブ・スペーズ", "クリーピング・デス", "サイフォン・オブ・デストラクション",
                    "チルドレン・オブ・ザ・グレイヴ"}, false);

    /** Morgana Definition */
    public static final Champion Morgana = new Champion("Morgana", "モルガナ", "Morgana", 547.48F, 86.0F, 5.705F, 0.6F, 340.8F, 60.0F, 6.0F, 0.8F, 55.46F, 3.5F, 0.0F, 1.53F, 0.0F, 0.0F, 25.384F, 3.8F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {
            "Soul Siphon", "Dark Binding", "Tormented Soil", "Black Shield",
            "Soul Shackles"}, new String[] {"魂吸引", "闇の束縛", "苦悶の沼", "漆黒の盾", "魂の足枷"}, false);

    /** Nami Definition */
    public static final Champion Nami = new Champion("Nami", "ナミ", "Nami", 489.32F, 74.0F, 5.42F, 0.55F, 377.24F, 43.0F, 9.0F, 0.4F, 51.208F, 3.1F, -0.03F, 2.61F, 0.0F, 0.0F, 19.72F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {
            "Surging Tides", "Aqua Prison", "Ebb and Flow", "Tidecaller's Blessing",
            "Tidal Wave"}, new String[] {"激流", "水の監獄", "潮流", "潮使いの祝福", "大海嘯"}, false);

    /** Nasus Definition */
    public static final Champion Nasus = new Champion("Nasus", "ナサス", "Nasus", 561.2F, 90.0F, 9.01F, 0.9F, 275.6F, 45.0F, 7.44F, 0.5F, 59.18F, 3.5F, -0.02F, 3.48F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Soul Eater", "Siphoning Strike", "Wither", "Spirit Fire",
            "Fury of the Sands"}, new String[] {"魂の統括", "吸魂撃", "風化", "輪廻の炎", "憤怒の熱砂"}, false);

    /** Nautilus Definition */
    public static final Champion Nautilus = new Champion("Nautilus", "ノーチラス", "Nautilus", 576.48F, 86.0F, 8.37F, 0.55F, 284.0F, 50.0F, 8.625F, 0.7F, 57.544F, 3.3F, 0.02F, 1.0F, 0.0F, 0.0F, 26.46F, 3.25F, 32.1F, 0.0F, 325.0F, 175.0F, new String[] {
            "Staggering Blow", "Dredge Line", "Titan's Wrath", "Riptide",
            "Depth Charge"}, new String[] {"鉄の錨", "錨投げ", "大海の激憤", "粉砕水", "爆雷発射"}, false);

    /** Nidalee Definition */
    public static final Champion Nidalee = new Champion("Nidalee", "ニダリー", "Nidalee", 511.2F, 80.0F, 6.005F, 0.6F, 295.6F, 45.0F, 6.0F, 0.8F, 47.88F, 3.5F, -0.02F, 3.22F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Prowl", "Javelin Toss / Takedown", "Bushwhack / Pounce", "Primal Surge / Swipe", "Aspect Of The Cougar",
            "Takedown", "Pounce", "Swipe"}, new String[] {"獲物探し", "槍投げ/テイクダウン", "虎挟み/ジャンプ", "高揚/クーガークロウ", "クーガーの心",
                    "テイクダウン", "ジャンプ", "クーガークロウ"}, false);

    /** Nidalee Definition */
    public static final Champion NidaleeTransformed = new Champion("Nidalee", "ニダリー", "Nidalee", 511.2F, 80.0F, 6.005F, 0.6F, 295.6F, 45.0F, 6.0F, 0.8F, 47.88F, 3.5F, -0.02F, 3.22F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Prowl", "Javelin Toss / Takedown", "Bushwhack / Pounce", "Primal Surge / Swipe", "Aspect Of The Cougar",
            "Takedown", "Pounce", "Swipe"}, new String[] {"獲物探し", "槍投げ/テイクダウン", "虎挟み/ジャンプ", "高揚/クーガークロウ", "クーガーの心",
                    "テイクダウン", "ジャンプ", "クーガークロウ"}, true);

    /** Nocturne Definition */
    public static final Champion Nocturne = new Champion("Nocturne", "ノクターン", "Nocturne", 582.8F, 85.0F, 8.26F, 0.75F, 273.8F, 35.0F, 6.755F, 0.45F, 59.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Umbra Blades", "Duskbringer", "Shroud of Darkness", "Unspeakable Horror",
            "Paranoia"}, new String[] {"夢幻斬", "闇の手", "漆黒の帳", "底知れぬ恐怖", "悪夢"}, false);

    /** Nunu Definition */
    public static final Champion Nunu = new Champion("Nunu", "ヌヌ", "Nunu", 598.28F, 90.0F, 8.39F, 0.8F, 283.56F, 42.0F, 7.44F, 0.5F, 56.856F, 3.45F, 0.0F, 2.25F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Visionary", "Consume", "Blood Boil", "Ice Blast",
            "Absolute Zero"}, new String[] {"幻想", "丸飲み", "熱血", "氷弾", "アブソリュート・ゼロ"}, false);

    /** Olaf Definition */
    public static final Champion Olaf = new Champion("Olaf", "オラフ", "Olaf", 597.24F, 93.0F, 8.51F, 0.9F, 265.6F, 45.0F, 7.465F, 0.575F, 59.98F, 3.5F, -0.1F, 2.7F, 0.0F, 0.0F, 26.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Berserker Rage", "Undertow", "Vicious Strikes", "Reckless Swing",
            "Ragnarok"}, new String[] {"狂戦士の怒り", "斧投げ", "残忍な斧", "捨て身切り", "滅我"}, false);

    /** Orianna Definition */
    public static final Champion Orianna = new Champion("Orianna", "オリアナ", "Orianna", 517.72F, 79.0F, 6.87F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 40.368F, 2.6F, -0.05F, 3.5F, 0.0F, 0.0F, 17.04F, 3.0F, 30.0F, 0.0F, 325.0F, 525.0F, new String[] {
            "Clockwork Windup", "Command: Attack", "Command: Dissonance", "Command: Protect",
            "Command: Shockwave"}, new String[] {"ぜんまい仕掛け", "命令: 攻撃", "命令: 乱磁場", "命令: 防御", "命令: 衝撃波"}, false);

    /** Pantheon Definition */
    public static final Champion Pantheon = new Champion("Pantheon", "パンテオン", "Pantheon", 579.16F, 87.0F, 7.84F, 0.65F, 267.12F, 34.0F, 7.355F, 0.45F, 55.572F, 2.9F, 0.0F, 2.95F, 0.0F, 0.0F, 27.652F, 3.9F, 32.1F, 0.0F, 355.0F, 150.0F, new String[] {
            "Aegis Protection", "Spear Shot", "Aegis of Zeonia", "Heartseeker Strike",
            "Grand Skyfall"}, new String[] {"イージスの守護", "痛恨の槍", "ゼオニアの加護", "急所乱撃", "天上天下唯我独槍"}, false);

    /** Poppy Definition */
    public static final Champion Poppy = new Champion("Poppy", "ポッピー", "Poppy", 559.08F, 81.0F, 8.37F, 0.55F, 235.4F, 30.0F, 7.155F, 0.45F, 61.97F, 3.375F, -0.02F, 3.35F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 345.0F, 125.0F, new String[] {
            "Valiant Fighter", "Devastating Blow", "Paragon of Demacia", "Heroic Charge",
            "Diplomatic Immunity"}, new String[] {"勇敢な戦士", "渾身の一撃", "デマーシアの規範", "勇猛な突進", "絶対的特権"}, false);

    /** Quinn Definition */
    public static final Champion Quinn = new Champion("Quinn", "クイン", "Quinn", 532.8F, 85.0F, 5.42F, 0.55F, 268.8F, 35.0F, 6.97F, 0.4F, 51.04F, 3.0F, -0.065F, 3.1F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Harrier", "Blinding Assault", "Heightened Senses", "Vault",
            "Tag Team"}, new String[] {"鷲匠", "暗闇の強襲", "鷹の眼", "飛翔撃", "相棒"}, false);

    /** Rammus Definition */
    public static final Champion Rammus = new Champion("Rammus", "ラムス", "Rammus", 564.48F, 86.0F, 7.92F, 0.55F, 310.44F, 33.0F, 7.84F, 0.5F, 55.88F, 3.5F, 0.0F, 2.215F, 0.0F, 0.0F, 31.384F, 3.8F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Spiked Shell", "Powerball", "Defensive Ball Curl", "Puncturing Taunt",
            "Tremors"}, new String[] {"トゲトゲ", "ころころ", "大防御", "ちくちく", "ドスンドスン"}, false);

    /** Rek'Sai Definition */
    public static final Champion RekSai = new Champion("Rek'Sai", "レク＝サイ", "RekSai", 570.0F, 90.0F, 7.34F, 0.65F, 100.0F, 0.0F, 0.0F, 0.0F, 55.628F, 3.35F, 0.0F, 2.0F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 0.0F, 335.0F, 175.0F, new String[] {
            "Fury of the Xer'Sai", "Queen's Wrath / Prey Seeker", "Burrow / Un-burrow", "Furious Bite / Tunnel",
            "Void Rush"}, new String[] {"ゼル＝サイの怒り", "女王の怒り/獲物定め", "潜伏/襲撃", "激情の牙/掘削", "ヴォイドの猛攻"}, false);

    /** Renekton Definition */
    public static final Champion Renekton = new Champion("Renekton", "レネクトン", "Renekton", 572.16F, 87.0F, 7.96F, 0.75F, 100.0F, 0.0F, 0.0F, 0.0F, 58.328F, 3.1F, -0.06F, 2.65F, 0.0F, 0.0F, 25.584F, 3.8F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Reign of Anger", "Cull the Meek", "Ruthless Predator", "Slice and Dice",
            "Dominus"}, new String[] {"怒りの支配", "肉削ぎ", "無慈悲な連撃", "斬り切り舞", "凶暴化"}, false);

    /** Rengar Definition */
    public static final Champion Rengar = new Champion("Rengar", "レンガー", "Rengar", 586.2F, 90.0F, 4.27F, 0.4F, 5.0F, 0.0F, 0.0F, 0.0F, 60.04F, 3.0F, -0.08F, 2.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Unseen Predator", "Savagery", "Battle Roar", "Bola Strike",
            "Thrill of the Hunt"}, new String[] {"見えざる襲撃者", "逆上", "狩りの雄叫び", "鉄球の投げ縄", "狩猟本能"}, false);

    /** Riven Definition */
    public static final Champion Riven = new Champion("Riven", "リヴェン", "Riven", 558.48F, 86.0F, 3.34F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 56.04F, 3.0F, 0.0F, 3.5F, 0.0F, 0.0F, 24.376F, 3.2F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {
            "Runic Blade", "Broken Wings", "Ki Burst", "Valor",
            "Blade of the Exile"}, new String[] {"ルーンの剣", "折れた翼", "気功破", "勇躍", "追放者の剣"}, false);

    /** Rumble Definition */
    public static final Champion Rumble = new Champion("Rumble", "ランブル", "Rumble", 584.4F, 80.0F, 8.005F, 0.6F, 100.0F, 0.0F, 0.0F, 0.0F, 61.036F, 3.2F, -0.03F, 1.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Junkyard Titan", "Flamespitter", "Scrap Shield", "Electro Harpoon",
            "The Equalizer"}, new String[] {"ポンコツタイタン", "スピットファイア", "ジャンクシールド", "エレクトロハープーン", "イコライザー"}, false);

    /** Ryze Definition */
    public static final Champion Ryze = new Champion("Ryze", "ライズ", "Ryze", 558.48F, 86.0F, 5.27F, 0.55F, 342.4F, 55.0F, 5.0F, 1.0F, 55.04F, 3.0F, 0.0F, 2.112F, 0.0F, 0.0F, 21.552F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F, new String[] {
            "Arcane Mastery", "Overload", "Rune Prison", "Spell Flux",
            "Desperate Power"}, new String[] {"古代の呪術", "破呪", "ルーンの牢獄", "呪文跳弾", "禁断の呪力"}, false);

    /** Sejuani Definition */
    public static final Champion Sejuani = new Champion("Sejuani", "セジュアニ", "Sejuani", 600.0F, 95.0F, 8.675F, 0.85F, 400.0F, 40.0F, 7.205F, 0.45F, 57.544F, 3.3F, -0.0672F, 1.44F, 0.0F, 0.0F, 29.54F, 3.0F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {
            "Frost", "Arctic Assault", "Flail of the Northern Winds", "Permafrost",
            "Glacial Prison"}, new String[] {"凍傷", "猪突凍進", "北風のフレイル", "永久凍土", "氷河の牢獄"}, false);

    /** Shaco Definition */
    public static final Champion Shaco = new Champion("Shaco", "シャコ", "Shaco", 582.12F, 84.0F, 8.37F, 0.55F, 297.2F, 40.0F, 7.155F, 0.45F, 57.58F, 3.5F, -0.1F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Backstab", "Deceive", "Jack In The Box", "Two-Shiv Poison",
            "Hallucinate"}, new String[] {"背後からの一撃", "幻惑", "びっくり箱", "両刃の毒短剣", "幻覚"}, false);

    /** Shen Definition */
    public static final Champion Shen = new Champion("Shen", "シェン", "Shen", 570.8F, 85.0F, 8.37F, 0.55F, 200.0F, 0.0F, 50.0F, 0.0F, 60.17F, 3.375F, -0.04F, 3.4F, 0.0F, 0.0F, 25.72F, 4.0F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Ki Strike", "Vorpal Blade", "Feint", "Shadow Dash",
            "Stand United"}, new String[] {"気功斬", "吸命刀", "護遁の術", "殺気駆け", "刹那護法"}, false);

    /** Shyvana Definition */
    public static final Champion Shyvana = new Champion("Shyvana", "シヴァーナ", "Shyvana", 594.6F, 95.0F, 8.59F, 0.8F, 100.0F, 0.0F, 0.0F, 0.0F, 60.712F, 3.4F, -0.05F, 2.5F, 0.0F, 0.0F, 27.628F, 3.35F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Dragonborn", "Twin Bite", "Burnout", "Flame Breath",
            "Dragon's Descent"}, new String[] {"龍族の血脈", "双咬撃", "烈風炎", "火炎の息吹", "龍族の血統"}, false);

    /** Singed Definition */
    public static final Champion Singed = new Champion("Singed", "シンジド", "Singed", 542.76F, 82.0F, 8.02F, 0.55F, 290.6F, 45.0F, 7.52F, 0.55F, 62.32F, 3.375F, 0.02F, 1.81F, 0.0F, 0.0F, 27.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Empowered Bulwark", "Poison Trail", "Mega Adhesive", "Fling",
            "Insanity Potion"}, new String[] {"肉体強化", "猛毒の跡", "強力粘着剤", "ぶん投げ", "狂人のポーション"}, false);

    /** Sion Definition */
    public static final Champion Sion = new Champion("Sion", "サイオン", "Sion", 542.64F, 73.0F, 10.18F, 0.8F, 275.6F, 45.0F, 8.005F, 0.6F, 59.72F, 4.0F, -0.08F, 1.3F, 0.0F, 0.0F, 23.04F, 3.0F, 32.1F, 0.0F, 345.0F, 150.0F, new String[] {
            "Glory in Death", "Decimating Smash", "Soul Furnace", "Roar of the Slayer",
            "Unstoppable Onslaught"}, new String[] {"名誉ある死", "破滅の斧", "魂の炉心", "殺意の雄叫び", "猪突猛進"}, false);

    /** Sivir Definition */
    public static final Champion Sivir = new Champion("Sivir", "シヴィア", "Sivir", 515.76F, 82.0F, 5.17F, 0.55F, 284.0F, 50.0F, 8.01F, 0.9F, 52.04F, 3.0F, -0.05F, 1.6F, 0.0F, 0.0F, 22.21F, 3.25F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {
            "Fleet of Foot", "Boomerang Blade", "Ricochet", "Spell Shield",
            "On The Hunt"}, new String[] {"戦駆け", "ぶっ放し", "跳刃", "破魔の護り", "狩猟の幕開け"}, false);

    /** Skarner Definition */
    public static final Champion Skarner = new Champion("Skarner", "スカーナー", "Skarner", 601.28F, 96.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.0F, 2.1F, 0.0F, 0.0F, 29.384F, 3.8F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Crystallizing Sting", "Crystal Slash", "Crystalline Exoskeleton", "Fracture",
            "Impale"}, new String[] {"水晶の針", "水晶波斬", "外殻水晶化", "破砕弾", "狙い刺し"}, false);

    /** Sona Definition */
    public static final Champion Sona = new Champion("Sona", "ソナ", "Sona", 482.36F, 77.0F, 5.42F, 0.55F, 340.6F, 45.0F, 9.0F, 0.4F, 50.04F, 3.0F, -0.03F, 2.3F, 0.0F, 0.0F, 20.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Power Chord", "Hymn of Valor", "Aria of Perseverance", "Song of Celerity",
            "Crescendo"}, new String[] {"パワーコード", "義勇の賛歌", "堅忍のアリア", "疾風の歌", "クレッシェンド"}, false);

    /** Soraka Definition */
    public static final Champion Soraka = new Champion("Soraka", "ソラカ", "Soraka", 529.04F, 78.0F, 2.5F, 0.5F, 350.8F, 60.0F, 9.0F, 0.4F, 50.04F, 3.0F, 0.0F, 2.14F, 0.0F, 0.0F, 23.384F, 3.8F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Salvation", "Starcall", "Astral Infusion", "Equinox",
            "Wish"}, new String[] {"救済", "星のささやき", "星霊の癒し", "星の静寂", "願い"}, false);

    /** Swain Definition */
    public static final Champion Swain = new Champion("Swain", "スウェイン", "Swain", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, 0.0F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 500.0F, new String[] {
            "Carrion Renewal", "Decrepify", "Nevermove", "Torment",
            "Ravenous Flock"}, new String[] {"屍食再生", "戦慄の怪鳥", "漆黒の束縛", "苦悶", "黒烏の恐襲"}, false);

    /** Syndra Definition */
    public static final Champion Syndra = new Champion("Syndra", "シンドラ", "Syndra", 511.04F, 78.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.872F, 2.9F, 0.0F, 2.0F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Transcendent", "Dark Sphere", "Force of Will", "Scatter the Weak",
            "Unleashed Power"}, new String[] {"絶大なる魔力", "闇の魔珠", "魔力の制御", "魔力四散", "魔力解放"}, false);

    /** Tahm Kench Definition */
    public static final Champion TahmKench = new Champion("Tahm Kench", "Tahm Kench", "TahmKench", 610.0F, 95.0F, 6.5F, 0.55F, 325.0F, 40.0F, 5.5F, 1.0F, 56.0F, 3.2F, 0.0F, 2.5F, 0.0F, 0.0F, 27.0F, 3.0F, 32.1F, 0.0F, 335.0F, 200.0F, new String[] {
            "An Acquired Taste", "Tongue Lash", "Devour", "Thick Skin", "Abyssal Voyage"}, new String[] {
                    "An Acquired Taste", "Tongue Lash", "Devour", "Thick Skin", "Abyssal Voyage"}, false);

    /** Talon Definition */
    public static final Champion Talon = new Champion("Talon", "タロン", "Talon", 582.8F, 85.0F, 8.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "Mercy", "Noxian Diplomacy", "Rake", "Cutthroat",
            "Shadow Assault"}, new String[] {"刃の慈悲", "ノクサスの刃", "飛燕手裏剣", "瞬刃", "影刃円舞"}, false);

    /** Taric Definition */
    public static final Champion Taric = new Champion("Taric", "タリック", "Taric", 619.2F, 90.0F, 7.94F, 0.5F, 349.08F, 56.0F, 6.0F, 0.8F, 57.88F, 3.5F, 0.0F, 2.02F, 0.0F, 0.0F, 25.876F, 3.2F, 32.1F, 0.0F, 340.0F, 125.0F, new String[] {
            "Gemcraft", "Imbue", "Shatter", "Dazzle",
            "Radiance"}, new String[] {"ジェムクラフト", "パワーストーン", "ジェムクラッシュ", "プリズムチャーム", "シャイニング"}, false);

    /** Teemo Definition */
    public static final Champion Teemo = new Champion("Teemo", "ティーモ", "Teemo", 515.76F, 82.0F, 5.74F, 0.65F, 267.2F, 40.0F, 7.205F, 0.45F, 47.54F, 3.0F, -0.0947F, 3.38F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 330.0F, 500.0F, new String[] {
            "Camouflage", "Blinding Dart", "Move Quick", "Toxic Shot",
            "Noxious Trap"}, new String[] {"身隠し", "目つぶしダーツ", "駆け足！", "毒たっぷり吹き矢", "毒キノコ"}, false);

    /** Thresh Definition */
    public static final Champion Thresh = new Champion("Thresh", "スレッシュ", "Thresh", 560.52F, 89.0F, 6.92F, 0.55F, 273.92F, 44.0F, 6.0F, 0.8F, 47.696F, 2.2F, 0.0F, 3.5F, 0.0F, 0.0F, 16.0F, 0.0F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {
            "Damnation", "Death Sentence", "Dark Passage", "Flay",
            "The Box"}, new String[] {"魂の束縛", "死の宣告", "嘆きの魂灯", "絶望の鎖", "魂の牢獄"}, false);

    /** Tristana Definition */
    public static final Champion Tristana = new Champion("Tristana", "トリスターナ", "Tristana", 542.76F, 82.0F, 6.19F, 0.65F, 246.76F, 32.0F, 7.205F, 0.45F, 51.54F, 3.0F, -0.04734F, 1.5F, 0.0F, 0.0F, 22.0F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Draw a Bead", "Rapid Fire", "Rocket Jump", "Explosive Charge",
            "Buster Shot"}, new String[] {"ドロー＆グロー", "ラピッドファイア", "ロケットジャンプ", "ヨードルグレネード", "バスターショット"}, false);

    /** Trundle Definition */
    public static final Champion Trundle = new Champion("Trundle", "トランドル", "Trundle", 616.28F, 96.0F, 9.425F, 0.85F, 281.6F, 45.0F, 7.505F, 0.6F, 60.04F, 3.0F, -0.0672F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 0.0F, 350.0F, 125.0F, new String[] {
            "King's Tribute", "Chomp", "Frozen Domain", "Pillar of Ice",
            "Subjugate"}, new String[] {"王への貢物", "噛み付き", "凍てつく大地", "氷冷の柱", "暴虐なる搾取"}, false);

    /** Tryndamere Definition */
    public static final Champion Tryndamere = new Champion("Tryndamere", "トリンダミア", "Tryndamere", 625.64F, 98.0F, 8.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 61.376F, 3.2F, -0.0672F, 2.9F, 0.0F, 0.0F, 24.108F, 3.1F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Battle Fury", "Bloodlust", "Mocking Shout", "Spinning Slash",
            "Undying Rage"}, new String[] {"戦場の咆哮", "血の欲望", "嘲りの叫び", "旋回斬り", "不死の憤激"}, false);

    /** Twisted Fate Definition */
    public static final Champion TwistedFate = new Champion("Twisted Fate", "フェイト", "TwistedFate", 521.76F, 82.0F, 5.505F, 0.6F, 265.84F, 38.0F, 6.0F, 0.8F, 49.954F, 3.3F, -0.04F, 3.22F, 0.0F, 0.0F, 20.542F, 3.15F, 30.0F, 0.0F, 330.0F, 525.0F, new String[] {
            "Loaded Dice", "Wild Cards", "Pick A Card", "Stacked Deck",
            "Destiny"}, new String[] {"イカサマダイス", "ワイルドカード", "ドロー", "フォーカード", "デスティニー"}, false);

    /** Twitch Definition */
    public static final Champion Twitch = new Champion("Twitch", "トゥイッチ", "Twitch", 525.08F, 81.0F, 6.005F, 0.6F, 287.2F, 40.0F, 7.255F, 0.45F, 49.04F, 3.0F, -0.08F, 3.38F, 0.0F, 0.0F, 23.04F, 3.0F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Deadly Venom", "Ambush", "Venom Cask", "Contaminate",
            "Rat-Ta-Tat-Tat"}, new String[] {"致死毒", "奇襲", "毒瓶投げ", "致死毒活発化", "ラッタッタッタッタ"}, false);

    /** Udyr Definition */
    public static final Champion Udyr = new Champion("Udyr", "ウディア", "Udyr", 593.32F, 99.0F, 8.71F, 0.75F, 270.4F, 30.0F, 7.505F, 0.45F, 58.286F, 3.2F, -0.05F, 2.67F, 0.0F, 0.0F, 25.47F, 4.0F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Monkey's Agility", "Tiger Stance", "Turtle Stance", "Bear Stance",
            "Phoenix Stance"}, new String[] {"乱撃高揚", "虎形態", "亀形態", "熊形態", "不死鳥形態"}, false);

    /** Urgot Definition */
    public static final Champion Urgot = new Champion("Urgot", "アーゴット", "Urgot", 586.52F, 89.0F, 6.505F, 0.6F, 312.4F, 55.0F, 8.59F, 0.65F, 52.048F, 3.6F, -0.03F, 2.9F, 0.0F, 0.0F, 24.544F, 3.3F, 30.0F, 0.0F, 335.0F, 425.0F, new String[] {
            "Zaun-Touched Bolt Augmenter", "Acid Hunter", "Terror Capacitor", "Noxian Corrosive Charge",
            "Hyper-Kinetic Position Reverser"}, new String[] {"ゾウン・デストラクション", "アシッドハンター", "テラーコンデンサー", "ノクサス・コラプトシェル",
                    "ハイパーキネティック・ポジションリバーサー"}, false);

    /** Varus Definition */
    public static final Champion Varus = new Champion("Varus", "ヴァルス", "Varus", 537.76F, 82.0F, 5.42F, 0.55F, 310.48F, 36.0F, 7.34F, 0.8F, 49.04F, 3.0F, -0.05F, 3.0F, 0.0F, 0.0F, 23.212F, 3.4F, 30.0F, 0.0F, 330.0F, 575.0F, new String[] {
            "Living Vengeance", "Piercing Arrow", "Blighted Quiver", "Hail of Arrows",
            "Chain of Corruption"}, new String[] {"復讐の化身", "渾身の一矢", "枯死の矢筒", "滅びの矢雨", "穢れの連鎖"}, false);

    /** Vayne Definition */
    public static final Champion Vayne = new Champion("Vayne", "ヴェイン", "Vayne", 498.44F, 83.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 53.46F, 3.25F, -0.05F, 4.0F, 0.0F, 0.0F, 19.012F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F, new String[] {
            "Night Hunter", "Tumble", "Silver Bolts", "Condemn",
            "Final Hour"}, new String[] {"闇夜の狩人　", "転撃", "銀の矢", "制裁", "決戦"}, false);

    /** Veigar Definition */
    public static final Champion Veigar = new Champion("Veigar", "ヴェイガー", "Veigar", 492.76F, 82.0F, 5.42F, 0.55F, 342.4F, 55.0F, 6.0F, 0.8F, 50.71F, 2.625F, 0.0F, 2.24F, 0.0F, 0.0F, 22.55F, 3.75F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {
            "Equilibrium", "Baleful Strike", "Dark Matter", "Event Horizon",
            "Primordial Burst"}, new String[] {"ワールドバランス", "イーヴィルストライク", "ダークマター", "イベントホライズン", "メテオバースト"}, false);

    /** Vel'Koz Definition */
    public static final Champion Velkoz = new Champion("Vel'Koz", "ヴェル＝コズ", "Velkoz", 507.68F, 76.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.937874F, 3.1415927F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {
            "Organic Deconstruction", "Plasma Fission", "Void Rift", "Tectonic Disruption",
            "Life Form Disintegration Ray"}, new String[] {"有機分解", "電離炸裂弾", "ヴォイドの裂谷", "地殻砕裂", "生体破壊光線"}, false);

    /** Vi Definition */
    public static final Champion Vi = new Champion("Vi", "ヴァイ", "Vi", 582.8F, 85.0F, 9.01F, 0.9F, 295.6F, 45.0F, 8.09F, 0.65F, 55.88F, 3.5F, -0.03F, 2.5F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Blast Shield", "Vault Breaker", "Denting Blows", "Excessive Force",
            "Assault and Battery"}, new String[] {"爆風の護り", "一拳必殺", "タコ殴り", "爆拳衝", "無慈悲な強襲"}, false);

    /** Viktor Definition */
    public static final Champion Viktor = new Champion("Viktor", "ヴィクター", "Viktor", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, -0.05F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 525.0F, new String[] {
            "Glorious Evolution", "Siphon Power", "Gravity Field", "Death Ray",
            "Chaos Storm"}, new String[] {"グロリアス・エヴォリューション", "パワーブラスト", "グラビティフィールド", "デス・レイ", "カオスストーム"}, false);

    /** Vladimir Definition */
    public static final Champion Vladimir = new Champion("Vladimir", "ヴラッドミア", "Vladimir", 542.8F, 85.0F, 7.005F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 48.04F, 3.0F, -0.05F, 2.0F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F, new String[] {
            "Crimson Pact", "Transfusion", "Sanguine Pool", "Tides of Blood",
            "Hemoplague"}, new String[] {"真紅の盟約", "吸血", "紅血の沼", "血液奔流", "呪血の渦"}, false);

    /** Volibear Definition */
    public static final Champion Volibear = new Champion("Volibear", "ヴォリベア", "Volibear", 584.48F, 86.0F, 8.09F, 0.65F, 270.4F, 30.0F, 8.09F, 0.65F, 59.544F, 3.3F, -0.05F, 2.67F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Chosen of the Storm", "Rolling Thunder", "Frenzy", "Majestic Roar",
            "Thunder Claws"}, new String[] {"嵐に選ばれし者", "鳴雷", "獰猛", "雄大な咆哮", "稲妻の爪"}, false);

    /** Warwick Definition */
    public static final Champion Warwick = new Champion("Warwick", "ワーウィック", "Warwick", 592.64F, 98.0F, 8.39F, 0.8F, 240.4F, 30.0F, 8.105F, 0.6F, 62.43F, 3.375F, -0.08F, 2.88F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Eternal Thirst", "Hungering Strike", "Hunters Call", "Blood Scent",
            "Infinite Duress"}, new String[] {"永遠の渇き", "餓狼", "狩りの遠吠え", "血の香", "無慈悲な狼撃"}, false);

    /** Xerath Definition */
    public static final Champion Xerath = new Champion("Xerath", "ゼラス", "Xerath", 514.4F, 80.0F, 5.42F, 0.55F, 316.96F, 47.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F, new String[] {
            "Mana Surge", "Arcanopulse", "Eye of Destruction", "Shocking Orb",
            "Rite of the Arcane"}, new String[] {"マナ吸引", "魔力の波動", "破滅の瞳", "衝撃の宝珠", "深淵の儀式"}, false);

    /** Xin Zhao Definition */
    public static final Champion XinZhao = new Champion("Xin Zhao", "シン・ジャオ", "XinZhao", 591.16F, 87.0F, 8.175F, 0.7F, 273.8F, 35.0F, 7.255F, 0.45F, 57.544F, 3.3F, -0.07F, 2.6F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 175.0F, new String[] {
            "Challenge", "Three Talon Strike", "Battle Cry", "Audacious Charge",
            "Crescent Sweep"}, new String[] {"一意専心", "三槍撃", "気焔万丈", "勇将の猛進", "三日月槍舞"}, false);

    /** Yasuo Definition */
    public static final Champion Yasuo = new Champion("Yasuo", "ヤスオ", "Yasuo", 517.76F, 82.0F, 6.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 55.376F, 3.2F, -0.05F, 3.2F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 345.0F, 175.0F, new String[] {
            "Way of the Wanderer", "Steel Tempest", "Wind Wall", "Sweeping Blade",
            "Last Breath"}, new String[] {"浪人道", "百錬一刀", "風殺の壁", "居合斬り", "鬼哭啾々"}, false);

    /** Yorick Definition */
    public static final Champion Yorick = new Champion("Yorick", "ヨーリック", "Yorick", 563.8F, 85.0F, 8.175F, 0.7F, 293.8F, 35.0F, 6.755F, 0.45F, 57.58F, 3.5F, 0.0F, 3.0F, 0.0F, 0.0F, 25.048F, 3.6F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Unholy Covenant", "Omen of War", "Omen of Pestilence", "Omen of Famine",
            "Omen of Death"}, new String[] {"不浄な誓約", "戦の凶兆", "疫の凶兆", "飢の凶兆", "死の凶兆"}, false);

    /** Zac Definition */
    public static final Champion Zac = new Champion("Zac", "ザック", "Zac", 614.6F, 95.0F, 7.92F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 59.67F, 3.375F, -0.02F, 1.6F, 0.0F, 0.0F, 23.88F, 3.5F, 32.1F, 0.0F, 335.0F, 125.0F, new String[] {
            "Cell Division", "Stretching Strike", "Unstable Matter", "Elastic Slingshot",
            "Let's Bounce!"}, new String[] {"細胞分裂", "ノビノビパンチ", "ボインボイン", "スライミーショット", "ボムボムスラム"}, false);

    /** Zed Definition */
    public static final Champion Zed = new Champion("Zed", "ゼド", "Zed", 579.4F, 80.0F, 7.09F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 54.712F, 3.4F, -0.03F, 2.1F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F, new String[] {
            "Contempt for the Weak", "Razor Shuriken", "Living Shadow", "Shadow Slash",
            "Death Mark"}, new String[] {"弱者必衰", "風車手裏剣", "影分身", "闇討ち", "死の刻印"}, false);

    /** Ziggs Definition */
    public static final Champion Ziggs = new Champion("Ziggs", "ジグス", "Ziggs", 524.4F, 80.0F, 6.255F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 54.208F, 3.1F, -0.04734F, 2.0F, 0.0F, 0.0F, 21.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F, new String[] {
            "Short Fuse", "Bouncing Bomb", "Satchel Charge", "Hexplosive Minefield",
            "Mega Inferno Bomb"}, new String[] {"ショートヒューズ", "バウンドボム", "エンジニアボム", "ヘクステックマイン", "メガインフェルノボム"}, false);

    /** Zilean Definition */
    public static final Champion Zilean = new Champion("Zilean", "ジリアン", "Zilean", 499.28F, 77.0F, 5.44F, 0.5F, 360.8F, 60.0F, 6.0F, 0.8F, 51.64F, 3.0F, 0.0F, 2.13F, 0.0F, 0.0F, 19.134F, 3.8F, 30.0F, 0.0F, 335.0F, 550.0F, new String[] {
            "Heightened Learning", "Time Bomb", "Rewind", "Time Warp",
            "Chronoshift"}, new String[] {"ハイスピードラーニング", "タイムボム", "リ・ウィンド", "タイムワープ", "クロノシフト"}, false);

    /** Zyra Definition */
    public static final Champion Zyra = new Champion("Zyra", "ザイラ", "Zyra", 479.32F, 74.0F, 5.69F, 0.5F, 334.0F, 50.0F, 6.0F, 0.8F, 53.376F, 3.2F, 0.0F, 2.11F, 0.0F, 0.0F, 20.04F, 3.0F, 30.0F, 0.0F, 325.0F, 575.0F, new String[] {
            "Rise of the Thorns", "Deadly Bloom", "Rampant Growth", "Grasping Roots",
            "Stranglethorns"}, new String[] {"最後の一咲き", "死華の誘い", "狂い咲き", "捕縛の根", "茨のゆりかご"}, false);

    /** The champion id. */
    public final int id;

    /** The name. */
    public final String name;

    /** The localized name. */
    public final String localized;

    /** The normalized skillSystem name. */
    public final String systemName;

    /** The skill set. */
    public final Skill[] skills = new Skill[5];

    /** The skill. */
    public final Skill P;

    /** The skill. */
    public final Skill Q;

    /** The skill. */
    public final Skill W;

    /** The skill. */
    public final Skill E;

    /** The skill. */
    public final Skill R;

    /** The descriptor. */
    private final ChampionStatus[] versions = new ChampionStatus[Version.values().length];

    /**
     * <p>
     * Create new champion.
     * </p>
     * 
     * @param name
     */
    Champion(String name, String localized, String system, float hp, float hpPer, float hreg, float hregPer, float mp, float mpPer, float mreg, float mregPer, float ad, float adPer, float as, float asPer, float crit, float critPer, float ar, float arPer, float mr, float mrPer, float ms, float range, String[] skillNames, String[] skillLocalized, boolean transformed) {
        this.id = transformed ? counter : counter++;

        for (int i = 0; i < skills.length; i++) {
            this.skills[i] = new Skill(skillNames[i], skillLocalized[i], system, i, skillNames.length);
        }

        this.P = this.skills[0];
        this.Q = this.skills[1];
        this.W = this.skills[2];
        this.E = this.skills[3];
        this.R = this.skills[4];

        if (!transformed) {
            champions.add(this);
        }

        this.name = name;
        this.localized = localized;
        this.systemName = system;

        this.update(Version.P0000)
                .set(Health, hp, hpPer)
                .set(Hreg, hreg, hregPer)
                .set(Mana, mp, mpPer)
                .set(Mreg, mreg, mregPer)
                .set(AD, ad, adPer)
                .set(AS, as, asPer)
                .set(Critical, crit, critPer)
                .set(AR, ar, arPer)
                .set(MR, mr, mrPer)
                .set(MS, ms)
                .set(Range, range);
    }

    /**
     * <p>
     * Returns skillSystem name.
     * </p>
     * 
     * @return
     */
    public String getSystemName() {
        return name.replace("\\.", "").replace("\\s", "").replace("\\'", "");
    }

    /**
     * <p>
     * Pattern natch against this champion name.
     * </p>
     * 
     * @param name A name pattern.
     * @return A result.
     */
    public boolean match(String name) {
        return name != null && systemName.contains(name.toLowerCase());
    }

    /**
     * <p>
     * Returns splash art path.
     * </p>
     * 
     * @return
     */
    public String getSplashArt() {
        return "src/main/resources/teemowork/splash/" + getSystemName() + ".jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/icon/" + getSystemName() + ".png";
    }

    /**
     * <p>
     * Apply icon image.
     * </p>
     */
    public void applyIcon(Element element) {
        element.css("background-image", "url(src/main/resources/teemowork/champions.jpg)")
                .css("background-position", id / (counter - 1) * 100 + "% 0%")
                .css("background-size", "cover")
                .css("background-origin", "border-box");
    }

    /**
     * <p>
     * Retrieve a descriptor at the specified version.
     * </p>
     */
    public ChampionStatus getStatus(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ChampionStatus status = versions[i];

            if (status != null) {
                return status;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @param version A update version.
     * @return A champion descriptor.
     */
    ChampionStatus update(Version version) {
        ChampionStatus status = new ChampionStatus(getStatus(version));
        versions[version.ordinal()] = status;

        return status;
    }

    /**
     * <p>
     * List up all champions.
     * </p>
     * 
     * @return
     */
    public static List<Champion> getAll() {
        return champions;
    }

    /**
     * <p>
     * Find champion by name.
     * </p>
     * 
     * @param name A champion name.
     * @return A matched champion.
     */
    public static Champion getByName(String name) {
        for (Champion champion : champions) {
            if (champion.systemName.equals(name)) {
                return champion;
            }
        }
        return null;
    }

    public static int size() {
        return counter;
    }

    // /** The initialization state. */
    // private static boolean initialized;

    // /**
    // * Initialize {@link Skill}.
    // */
    // private static void initilaize() {
    // initialized = true;
    //
    // Aatrox.update(P0000)
    // .set(Health, 395, 85)
    // .set(Hreg, 5.75, 0.5)
    // .set(Mana, 0, 0)
    // .set(Mreg, 0, 0)
    // .set(AD, 55, 3.2)
    // .set(AS, 0.651, 3)
    // .set(AR, 18, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 150)
    // .set(MS, 345);
    // Ahri.update(P506)
    // .set(Health, 380, 80)
    // .set(Hreg, 5.5, 0.6)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 50, 3)
    // .set(AS, 0.668, 2)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Akali.update(P506)
    // .set(Health, 445, 85)
    // .set(Hreg, 7.25, 0.65)
    // .set(Energy, 200)
    // .set(Ereg, 50)
    // .set(AD, 53, 3.2)
    // .set(AS, 0.694, 3.1)
    // .set(AR, 20.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Alistar.update(P0000)
    // .set(Health, 442, 102)
    // .set(Hreg, 7.25, 0.85)
    // .set(Mana, 215, 38)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 55.03, 3.62)
    // .set(AS, 0.625, 3.62)
    // .set(AR, 18.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 325);
    // Amumu.update(P0000)
    // .set(Health, 472, 84)
    // .set(Hreg, 7.45, 0.85)
    // .set(Mana, 220, 40)
    // .set(Mreg, 6.5, 0.525)
    // .set(AD, 47, 3.8)
    // .set(AS, 0.638, 2.18)
    // .set(AR, 23.544, 3.3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Anivia.update(P0000)
    // .set(Health, 350, 70)
    // .set(Hreg, 4.65, 0.55)
    // .set(Mana, 257, 53)
    // .set(Mreg, 7.0, 0.6)
    // .set(AD, 48, 3.2)
    // .set(AS, 0.625, 1.68)
    // .set(AR, 17.22, 4)
    // .set(MR, 30, 0)
    // .set(Range, 600)
    // .set(MissileSpeed, 1400)
    // .set(MS, 325);
    // Annie.update(P0000)
    // .set(Health, 384, 76)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 49, 2.625)
    // .set(AS, 0.579, 1.36)
    // .set(AR, 12.5, 4)
    // .set(MR, 30, 0)
    // .set(Range, 625)
    // .set(MS, 335);
    // Ashe.update(P0000)
    // .set(Health, 395, 79)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 173, 35)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 46.3, 2.85)
    // .set(AS, 0.658, 3.34)
    // .set(AR, 11.5, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 600)
    // .set(MS, 325);
    // Ashe.update(P303).set(AS, 0.658, 4);
    // Blitzcrank.update(P0000)
    // .set(Health, 423, 95)
    // .set(Hreg, 7.25, 0.75)
    // .set(Mana, 200, 40)
    // .set(Mreg, 6.6, 0.5)
    // .set(AD, 55.66, 3.5)
    // .set(AS, 0.625, 1.13)
    // .set(AR, 14.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 325);
    // Brand.update(P0000)
    // .set(Health, 380, 76)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 51.66, 3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Caitlyn.update(P0000)
    // .set(Health, 390, 80)
    // .set(Hreg, 4.75, 0.55)
    // .set(Mana, 255, 35)
    // .set(Mreg, 6.5, 0.55)
    // .set(AD, 47, 3)
    // .set(AS, 0.668, 3)
    // .set(AR, 13, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 650)
    // .set(MS, 325);
    // Caitlyn.update(P307).set(AS, 0.625, 4);
    // Cassiopeia.update(P0000)
    // .set(Health, 380, 75)
    // .set(Hreg, 4.85, 0.5)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7.1, 0.75)
    // .set(AD, 47, 3.2)
    // .set(AS, 0.644, 1.68)
    // .set(AR, 11.5, 4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Chogath.update(P0000)
    // .set(Health, 440, 80)
    // .set(Hreg, 7.5, 0.85)
    // .set(Mana, 205, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 54.1, 4.2)
    // .set(AS, 0.625, 1.44)
    // .set(AR, 19, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Corki.update(P0000)
    // .set(Health, 375, 82)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 243, 37)
    // .set(Mreg, 6.5, 0.55)
    // .set(AD, 48.2, 3)
    // .set(AS, 0.658, 2.3)
    // .set(AR, 13.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Corki.update(P313).set(AS, 0.625, 2.3);
    // Darius.update(P0000)
    // .set(Health, 426, 93)
    // .set(Hreg, 8.25, 0.95)
    // .set(Mana, 200, 37.5)
    // .set(Mreg, 6, 0.35)
    // .set(AD, 50, 3.5)
    // .set(AS, 0.679, 2.6)
    // .set(AR, 20, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Diana.update(P0000)
    // .set(Health, 438, 90)
    // .set(Hreg, 7, 0.85)
    // .set(Mana, 230, 40)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 48, 3)
    // .set(AS, 0.625, 2.25)
    // .set(AR, 16, 3.6)
    // .set(MR, 30, 1.25)
    // .set(Range, 150)
    // .set(MS, 345);
    // DrMundo.update(P0000)
    // .set(Health, 433, 89)
    // .set(Hreg, 6.5, 0.75)
    // .set(AD, 56.23, 3)
    // .set(AS, 0.625, 2.8)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Draven.update(P0000)
    // .set(Health, 420, 82)
    // .set(Hreg, 5, 0.7)
    // .set(Mana, 240, 42)
    // .set(Mreg, 6.95, 0.65)
    // .set(AD, 46.5, 3.5)
    // .set(AS, 0.679, 2.6)
    // .set(AR, 16, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Elise.update(P0000)
    // .set(Health, 395, 80)
    // .set(Hreg, 4.7, 0.6)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 47.5, 3)
    // .set(AS, 0.625, 1.75)
    // .set(AR, 12.65, 3.35)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // EliseTransformed.update(P0000)
    // .set(Health, 395, 80)
    // .set(Hreg, 4.7, 0.6)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 47.5, 3)
    // .set(AS, 0.625, 1.75)
    // .set(AR, 12.65, 3.35)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // Evelynn.update(P0000)
    // .set(Health, 414, 86)
    // .set(Hreg, 6.95, 0.55)
    // .set(Mana, 180, 42)
    // .set(Mreg, 7.1, 0.6)
    // .set(AD, 48, 3.3)
    // .set(AS, 0.658, 3.84)
    // .set(AR, 12.5, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Ezreal.update(P0000)
    // .set(Health, 350, 80)
    // .set(Hreg, 5.5, 0.55)
    // .set(Mana, 235, 45)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 47.2, 3)
    // .set(AS, 0.625, 2.8)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // FiddleSticks.update(P0000)
    // .set(Health, 390, 80)
    // .set(Hreg, 4.6, 0.6)
    // .set(Mana, 251, 59)
    // .set(Mreg, 6.9, 0.65)
    // .set(AD, 45.95, 2.625)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 480)
    // .set(MS, 335);
    // Fiora.update(P0000)
    // .set(Health, 450, 85)
    // .set(Hreg, 6.3, 0.8)
    // .set(Mana, 220, 40)
    // .set(Mreg, 7.25, 0.5)
    // .set(AD, 54.5, 3.2)
    // .set(AS, 0.672, 3)
    // .set(AR, 15.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Fizz.update(P0000)
    // .set(Health, 414, 86)
    // .set(Hreg, 7.0, 0.7)
    // .set(Mana, 200, 40)
    // .set(Mreg, 6.15, 0.45)
    // .set(AD, 53, 3)
    // .set(AS, 0.658, 3.1)
    // .set(AR, 13, 3.4)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 335);
    // Galio.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 7.45, 0.75)
    // .set(Mana, 235, 50)
    // .set(Mreg, 7, 0.7)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 1.2)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // Gangplank.update(P0000)
    // .set(Health, 495, 81)
    // .set(Hreg, 4.25, 0.75)
    // .set(Mana, 215, 40)
    // .set(Mreg, 6.5, 0.7)
    // .set(AD, 54, 3)
    // .set(AS, 0.651, 2.75)
    // .set(AR, 16.5, 3.3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Garen.update(P0000)
    // .set(Health, 455, 96)
    // .set(Hreg, 7.5, 0.75)
    // .set(AD, 52.5, 3.5)
    // .set(AS, 0.625, 2.9)
    // .set(AR, 19, 2.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Gragas.update(P0000)
    // .set(Health, 434, 89)
    // .set(Hreg, 7.25, 0.85)
    // .set(Mana, 221, 47)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 55.78, 3.375)
    // .set(AS, 0.651, 2.05)
    // .set(AR, 16, 3.6)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 340);
    // Graves.update(P0000)
    // .set(Health, 410, 84)
    // .set(Hreg, 5.5, 0.7)
    // .set(Mana, 255, 40)
    // .set(Mreg, 6.75, 0.7)
    // .set(AD, 51, 3.1)
    // .set(AS, 0.625, 2.9)
    // .set(AR, 15, 3.2)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 330);
    // Hecarim.update(P0000)
    // .set(Health, 440, 95)
    // .set(Hreg, 8, 0.75)
    // .set(Mana, 210, 40)
    // .set(Mreg, 6.5, 0.6)
    // .set(AD, 56, 3.2)
    // .set(AS, 0.67, 2.5)
    // .set(AR, 16, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 345);
    // Heimerdinger.update(P0000)
    // .set(Health, 350, 75)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 240, 65)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 49.24, 3)
    // .set(AS, 0.625, 1.21)
    // .set(AR, 7, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Irelia.update(P0000)
    // .set(Health, 456, 90)
    // .set(Hreg, 7.5, 0.65)
    // .set(Mana, 230, 35)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 56, 3.3)
    // .set(AS, 0.665, 3.2)
    // .set(AR, 15, 3.75)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Janna.update(P0000)
    // .set(Health, 356, 78)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 302, 64)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 49, 2.95)
    // .set(AS, 0.625, 2.61)
    // .set(AR, 9, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 475)
    // .set(MS, 335);
    // JarvanIV.update(P0000)
    // .set(Health, 420, 90)
    // .set(Hreg, 7, 0.7)
    // .set(Mana, 235, 40)
    // .set(Mreg, 6, 0.45)
    // .set(AD, 50, 3.4)
    // .set(AS, 0.658, 2.5)
    // .set(AR, 14, 3)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 340);
    // Jax.update(P0000)
    // .set(Health, 463, 98)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 230, 35)
    // .set(Mreg, 6.4, 0.7)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 3.4)
    // .set(AR, 18, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Jayce.update(P0000)
    // .set(Health, 420, 90)
    // .set(Hreg, 6, 0.8)
    // .set(Mana, 240, 40)
    // .set(Mreg, 7, 0.7)
    // .set(AD, 46.5, 3.5)
    // .set(AS, 0.658, 3)
    // .set(AR, 12.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // JayceTransformed.update(P0000)
    // .set(Health, 420, 90)
    // .set(Hreg, 6, 0.8)
    // .set(Mana, 240, 40)
    // .set(Mreg, 7, 0.7)
    // .set(AD, 46.5, 3.5)
    // .set(AS, 0.658, 3)
    // .set(AR, 12.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 335);
    // Jinx.update(Version.P312)
    // .set(Health, 420, 80)
    // .set(Hreg, 5, 0.5)
    // .set(Mana, 170, 45)
    // .set(Mreg, 5, 1)
    // .set(AD, 50, 3)
    // .set(AS, 0.625, 1)
    // .set(AR, 13, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 325);
    // Jinx.update(P401).set(Health, 388, 82);
    // Karma.update(P0000)
    // .set(Health, 410, 86)
    // .set(Hreg, 4.7, 0.55)
    // .set(Mana, 240, 60)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 50, 3.3)
    // .set(AS, 0.625, 2.3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 425)
    // .set(MS, 335);
    // Karthus.update(P0000)
    // .set(Health, 390, 75)
    // .set(Hreg, 5.5, 0.55)
    // .set(Mana, 270, 61)
    // .set(Mreg, 6.5, 0.6)
    // .set(AD, 42.2, 3.25)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 450)
    // .set(MS, 335);
    // Kassadin.update(P0000)
    // .set(Health, 433, 78)
    // .set(Hreg, 6.95, 0.5)
    // .set(Mana, 230, 45)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 52.3, 3.9)
    // .set(AS, 0.638, 3.7)
    // .set(AR, 14, 3.2)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Kassadin.update(P313).set(MR, 30, 0);
    // Katarina.update(P0000)
    // .set(Health, 395, 83)
    // .set(Hreg, 6.95, 0.55)
    // .set(AD, 53, 3.2)
    // .set(AS, 0.658, 2.74)
    // .set(AR, 14.75, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Kayle.update(P0000)
    // .set(Health, 418, 93)
    // .set(Hreg, 7, 0.75)
    // .set(Mana, 255, 40)
    // .set(Mreg, 6.9, 0.525)
    // .set(AD, 53.3, 2.8)
    // .set(AS, 0.638, 2.5)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 0.75)
    // .set(Range, 125)
    // .set(MS, 335);
    // Kayle.update(P303).set(MR, 30, 0);
    // Kennen.update(P0000)
    // .set(Health, 403, 79)
    // .set(Hreg, 4.65, 0.65)
    // .set(Energy, 200)
    // .set(Ereg, 50)
    // .set(AD, 51.3, 3.3)
    // .set(AS, 0.69, 3.4)
    // .set(AR, 14, 3.75)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Kennen.update(P309).set(AD, 47.2, 3.3);
    // Khazix.update(P0000)
    // .set(Health, 430, 85)
    // .set(Hreg, 6.25, 0.75)
    // .set(Mana, 260, 40)
    // .set(Mreg, 6.75, 0.5)
    // .set(AD, 50, 3.1)
    // .set(AS, 0.665, 2.7)
    // .set(AR, 15, 3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // KogMaw.update(P0000)
    // .set(Health, 440, 84)
    // .set(Hreg, 5, 0.55)
    // .set(Mana, 295, 40)
    // .set(Mreg, 7.5, 0.7)
    // .set(AD, 46, 3)
    // .set(AS, 0.665, 2.65)
    // .set(AR, 13, 3.53)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 340);
    // Leblanc.update(P0000)
    // .set(Health, 390, 75)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 51, 3.1)
    // .set(AS, 0.625, 1.4)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 335);
    // Leblanc.update(Version.P310A).set(Hreg, 6.5, 0.55).set(AD, 51, 3.5);
    // LeeSin.update(P0000)
    // .set(Health, 428, 85)
    // .set(Hreg, 6.25, 0.7)
    // .set(Ereg, 200)
    // .set(Ereg, 50)
    // .set(AD, 55.8, 3.2)
    // .set(AS, 0.651, 3)
    // .set(AR, 16, 3.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Leona.update(P0000)
    // .set(Health, 430, 87)
    // .set(Hreg, 9, 0.85)
    // .set(Mana, 235, 40)
    // .set(Mreg, 8, 0.7)
    // .set(AD, 55, 3)
    // .set(AS, 0.625, 2.9)
    // .set(AR, 18, 3.1)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Lissandra.update(P0000)
    // .set(Health, 365, 84)
    // .set(Hreg, 6, 0.55)
    // .set(Mana, 220, 50)
    // .set(Mreg, 5, 0.4)
    // .set(AD, 48, 2.7)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 10, 3.7)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Lucian.update(P310A)
    // .set(Health, 390, 80)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 230, 41)
    // .set(Mreg, 6, 0.65)
    // .set(AD, 46, 3)
    // .set(AS, 0.638, 3.3)
    // .set(AR, 15, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Lucian.update(P312).set(Mreg, 7, 0.7);
    // Lulu.update(P0000)
    // .set(Health, 415, 82)
    // .set(Hreg, 6, 0.72)
    // .set(Mana, 200, 50)
    // .set(Mreg, 6, 0.6)
    // .set(AD, 44.4, 2.6)
    // .set(AS, 0.625, 2.2)
    // .set(AR, 9, 3.7)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Lulu.update(P306).set(Mana, 200, 55);
    // Lux.update(P0000)
    // .set(Health, 345, 79)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6, 0.6)
    // .set(AD, 50, 3.3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 8, 4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Lux.update(P3051).set(MS, 330);
    // Malphite.update(P0000)
    // .set(Health, 423, 90)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 215, 40)
    // .set(Mreg, 6.4, 0.55)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 3.4)
    // .set(AR, 18, 3.75)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Malzahar.update(P0000)
    // .set(Health, 380, 80)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 51.66, 3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Maokai.update(P0000)
    // .set(Health, 421, 90)
    // .set(Hreg, 7.25, 0.85)
    // .set(Mana, 250, 46)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 58, 3.3)
    // .set(AS, 0.694, 2.13)
    // .set(AR, 18, 4)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // MasterYi.update(P0000)
    // .set(Health, 444, 86)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 199, 36)
    // .set(Mreg, 6.5, 0.45)
    // .set(AD, 55.12, 3.1)
    // .set(AS, 0.679, 2.98)
    // .set(AR, 16.3, 3.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 355);
    // MasterYi.update(P310).set(Health, 444, 92).set(Mana, 180, 42).set(AR, 15, 3).set(AS, 0.679,
    // 2.75);
    // MasterYi.update(P310A).set(AS, 0.679, 2);
    // MissFortune.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 212, 38)
    // .set(Mreg, 6.95, 0.65)
    // .set(AD, 46.5, 3)
    // .set(AS, 0.658, 3.01)
    // .set(AR, 15, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Mordekaiser.update(P0000)
    // .set(Health, 421, 80)
    // .set(Hreg, 7.45, 0.55)
    // .set(AD, 51.7, 3.5)
    // .set(AS, 0.694, 3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Morgana.update(P0000)
    // .set(Health, 403, 86)
    // .set(Hreg, 4.7, 0.6)
    // .set(Mana, 240, 60)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 51.58, 3.5)
    // .set(AS, 0.579, 1.53)
    // .set(AR, 15, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 425)
    // .set(MS, 335);
    // Morgana.update(P313).set(Range, 450).set(AS, 0.625, 1.53);
    // Nami.update(P0000)
    // .set(Health, 365, 74)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 305, 43)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 48, 3.1)
    // .set(AS, 0.644, 2.6)
    // .set(AR, 9, 4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340)
    // .set(MissileSpeed, 1350);
    // Nami.update(P307).set(MissileSpeed, 1500);
    // Nasus.update(P0000)
    // .set(Health, 410, 90)
    // .set(Hreg, 7.5, 0.9)
    // .set(Mana, 200, 45)
    // .set(Mreg, 6.6, 0.5)
    // .set(AD, 53.3, 3.5)
    // .set(AS, 0.638, 3.48)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Nautilus.update(P0000)
    // .set(Health, 432, 86)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 200, 50)
    // .set(Mreg, 7.45, 0.7)
    // .set(AD, 52, 3.3)
    // .set(AS, 0.613, 0.98)
    // .set(AR, 12, 3.25)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 325);
    // Nautilus.update(P3051).set(AR, 19, 3.25);
    // Nidalee.update(P0000)
    // .set(Health, 370, 90)
    // .set(Hreg, 5.0, 0.6)
    // .set(Mana, 220, 45)
    // .set(Mreg, 7, 0.5)
    // .set(AD, 49, 3.5)
    // .set(AS, 0.672, 3.22)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0.75)
    // .set(Range, 525)
    // .set(MS, 335);
    // Nidalee.update(P303).set(MR, 30, 0);
    // NidaleeTransformed.update(P0000)
    // .set(Health, 370, 90)
    // .set(Hreg, 5.0, 0.6)
    // .set(Mana, 220, 45)
    // .set(Mreg, 7, 0.5)
    // .set(AD, 49, 3.5)
    // .set(AS, 0.672, 3.22)
    // .set(AR, 11, 3.5)
    // .set(MR, 30, 0.75)
    // .set(Range, 125)
    // .set(MS, 335);
    // NidaleeTransformed.update(P303).set(MR, 30, 0);
    // Nocturne.update(P0000)
    // .set(Health, 430, 85)
    // .set(Hreg, 7, 0.75)
    // .set(Mana, 215, 35)
    // .set(Mreg, 6, 0.45)
    // .set(AD, 54, 3.1)
    // .set(AS, 0.668, 2.7)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Nunu.update(P0000)
    // .set(Health, 437, 108)
    // .set(Hreg, 7.05, 0.8)
    // .set(Mana, 213, 42)
    // .set(Mreg, 6.6, 0.5)
    // .set(AD, 51.6, 3.4)
    // .set(AS, 0.625, 2.25)
    // .set(AR, 16.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Nunu.update(P309).set(Health, 437, 96);
    // Olaf.update(P0000)
    // .set(Health, 441, 93)
    // .set(Hreg, 7, 0.9)
    // .set(Mana, 225, 45)
    // .set(Mreg, 6.5, 0.575)
    // .set(AD, 54.1, 3.5)
    // .set(AS, 0.694, 2.7)
    // .set(AR, 17, 3)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Olaf.update(P312).set(Mana, 190, 45);
    // Orianna.update(P0000)
    // .set(Health, 385, 79)
    // .set(Hreg, 5.95, 0.55)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7, 0.5)
    // .set(AD, 44, 2.6)
    // .set(AS, 0.658, 3.5)
    // .set(AR, 8, 3)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 325);
    // Pantheon.update(P0000)
    // .set(Health, 433, 87)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 210, 34)
    // .set(Mreg, 6.6, 0.45)
    // .set(AD, 50.7, 2.9)
    // .set(AS, 0.679, 2.95)
    // .set(AR, 17.1, 3.9)
    // .set(MR, 30, 1.25)
    // .set(Range, 155)
    // .set(MS, 355);
    // Poppy.update(P0000)
    // .set(Health, 423, 81)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 185, 30)
    // .set(Mreg, 6.4, 0.45)
    // .set(AD, 56.3, 3.375)
    // .set(AS, 0.638, 3.35)
    // .set(AR, 18, 4)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 345);
    // Quinn.update(P0000)
    // .set(Health, 390, 85)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 210, 35)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 48, 3)
    // .set(AS, 0.668, 3.11)
    // .set(AR, 13.5, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 335);
    // Rammus.update(P0000)
    // .set(Health, 420, 86)
    // .set(Hreg, 8, 0.55)
    // .set(Mana, 255, 33)
    // .set(Mreg, 4.5, 0.3)
    // .set(AD, 50, 3.5)
    // .set(AS, 0.625, 2.22)
    // .set(AR, 21, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Renekton.update(P0000)
    // .set(Health, 426, 87)
    // .set(Hreg, 6.7, 0.75)
    // .set(AD, 53.12, 3.1)
    // .set(AS, 0.665, 2.65)
    // .set(AR, 15.2, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Rengar.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 4, 0.4)
    // .set(AD, 55, 3)
    // .set(AS, 0.679, 2.85)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Riven.update(P0000)
    // .set(Health, 414, 86)
    // .set(Hreg, 5.5, 0.5)
    // .set(AD, 54, 2.7)
    // .set(AS, 0.625, 3.5)
    // .set(AR, 15, 3.1)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Riven.update(P401).set(AD, 51, 3);
    // Riven.update(P402).set(Hreg, 2.5, 0.5);
    // Rumble.update(P0000)
    // .set(Health, 450, 80)
    // .set(Hreg, 7, 0.7)
    // .set(AD, 55.32, 3.2)
    // .set(AS, 0.644, 1.85)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Ryze.update(P0000)
    // .set(Health, 360, 86)
    // .set(Hreg, 4.35, 0.55)
    // .set(Mana, 250, 55)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 52, 3)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 11, 3.9)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Ryze.update(P312).set(MS, 340);
    // Ryze.update(P403).set(Health, 414, 86);
    // Sejuani.update(P0000)
    // .set(Health, 450, 85)
    // .set(Hreg, 7.35, 0.85)
    // .set(Mana, 220, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 54, 3.4)
    // .set(AS, 0.67, 1.45)
    // .set(AR, 20.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Sejuani.update(P306).set(Health, 440, 95).set(Hreg, 7.25, 0.85).set(AD, 52, 3.3).set(AR,
    // 20.5, 3);
    // Shaco.update(P0000)
    // .set(Health, 441, 84)
    // .set(Hreg, 7.45, 0.55)
    // .set(Mana, 270, 40)
    // .set(Mreg, 6.4, 0.45)
    // .set(AD, 51.7, 3.5)
    // .set(AS, 0.694, 3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Shen.update(P0000)
    // .set(Health, 428, 85)
    // .set(Hreg, 7.45, 0.55)
    // .set(Energy, 200)
    // .set(Ereg, 50)
    // .set(AD, 54.5, 3.375)
    // .set(AS, 0.651, 3.4)
    // .set(AR, 15, 4)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 335);
    // Shyvana.update(P0000)
    // .set(Health, 435, 95)
    // .set(Hreg, 7.2, 0.8)
    // .set(AD, 54.5, 3.4)
    // .set(AS, 0.658, 3.4)
    // .set(AR, 17.6, 3.4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Singed.update(P0000)
    // .set(Health, 405, 82)
    // .set(Hreg, 7.1, 0.55)
    // .set(Mana, 215, 45)
    // .set(Mreg, 6.6, 0.55)
    // .set(AD, 56.65, 3.375)
    // .set(AS, 0.613, 1.81)
    // .set(AR, 18, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 125)
    // .set(MS, 345);
    // Sion.update(P0000)
    // .set(Health, 403, 104)
    // .set(Hreg, 7.9, 0.95)
    // .set(Mana, 240, 40)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 55.52, 3.1875)
    // .set(AS, 0.625, 1.63)
    // .set(AR, 17.75, 3.25)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Sivir.update(P0000)
    // .set(Health, 378, 82)
    // .set(Hreg, 4.25, 0.55)
    // .set(Mana, 203, 43)
    // .set(Mreg, 6.5, 0.5)
    // .set(AD, 49, 2.9)
    // .set(AS, 0.658, 3.28)
    // .set(AR, 12.75, 3.25)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 335);
    // Sivir.update(P313).set(AS, 0.658, 1.6);
    // Skarner.update(P0000)
    // .set(Health, 440, 96)
    // .set(Hreg, 7.5, 0.85)
    // .set(Mana, 205, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 54.1, 4.2)
    // .set(AS, 0.625, 2.1)
    // .set(AR, 19, 3.8)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Skarner.update(P402).set(AS, 0.619, 2.1);
    // Sona.update(P0000)
    // .set(Health, 340, 70)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 265, 45)
    // .set(Mreg, 7.0, 0.65)
    // .set(AD, 47, 3)
    // .set(AS, 0.644, 2.3)
    // .set(AR, 6, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Sona.update(P308).set(Health, 380, 70).set(AR, 8, 3.3);
    // Soraka.update(P0000)
    // .set(Health, 375, 71)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 240, 60)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 48.8, 3)
    // .set(AS, 0.625, 2.14)
    // .set(AR, 7.4, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 335);
    // Soraka.update(P314).set(Health, 405, 76).set(AR, 9.4, 3.8);
    // Soraka.update(P315).set(AR, 13, 3.8).set(MS, 340);
    // Swain.update(P0000)
    // .set(Health, 385, 78)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.8, 0.65)
    // .set(AD, 49, 3)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 12, 4)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 335);
    // Syndra.update(P0000)
    // .set(Health, 380, 78)
    // .set(Hreg, 5.5, 0.6)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 51, 2.9)
    // .set(AS, 0.625, 2)
    // .set(AR, 15, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Talon.update(P0000)
    // .set(Health, 440, 85)
    // .set(Hreg, 7.25, 0.75)
    // .set(Mana, 260, 40)
    // .set(Mreg, 6.75, 0.5)
    // .set(AD, 50, 3.1)
    // .set(AS, 0.668, 2.7)
    // .set(AR, 17, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Taric.update(P0000)
    // .set(Health, 468, 90)
    // .set(Hreg, 7.1, 0.5)
    // .set(Mana, 255, 56)
    // .set(Mreg, 4.1, 0.4)
    // .set(AD, 58, 3.5)
    // .set(AS, 0.625, 2.02)
    // .set(AR, 16.5, 3.2)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 340);
    // Taric.update(P303).set(AD, 53, 3.5);
    // Teemo.update(P0000)
    // .set(Health, 383, 82)
    // .set(Hreg, 4.65, 0.65)
    // .set(Mana, 200, 40)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 44.5, 3)
    // .set(AS, 0.690, 3.38)
    // .set(AR, 14, 3.75)
    // .set(MR, 30, 0)
    // .set(Range, 500)
    // .set(MS, 330);
    // Thresh.update(P0000)
    // .set(Health, 452, 89)
    // .set(Hreg, 6, 0.55)
    // .set(Mana, 200, 44)
    // .set(Mreg, 5, 0.7)
    // .set(AD, 46, 2.2)
    // .set(AS, 0.625, 2.1)
    // .set(AR, 18, 0)
    // .set(MR, 30, 0)
    // .set(Range, 475)
    // .set(MS, 335);
    // Thresh.update(P310).set(Health, 411, 89).set(AR, 12, 0);
    // Thresh.update(P313).set(AS, 0.625, 3);
    // Thresh.update(P402).set(Range, 450);
    // Tristana.update(P0000)
    // .set(Health, 415, 82)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 193, 32)
    // .set(Mreg, 6.45, 0.45)
    // .set(AD, 46.5, 3)
    // .set(AS, 0.658, 3.01)
    // .set(AR, 15, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 325);
    // Tristana.update(P303).set(AS, 0.658, 4);
    // Trundle.update(P0000)
    // .set(Health, 455, 96)
    // .set(Hreg, 8, 0.85)
    // .set(Mana, 206, 45)
    // .set(Mreg, 6.5, 0.6)
    // .set(AD, 54.66, 3)
    // .set(AS, 0.672, 2.9)
    // .set(AR, 19, 2.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Tryndamere.update(P0000)
    // .set(Health, 461, 98)
    // .set(Hreg, 7.9, 0.9)
    // .set(AD, 56, 3.2)
    // .set(AS, 0.67, 2.9)
    // .set(AR, 14.9, 3.1)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // TwistedFate.update(P0000)
    // .set(Health, 384, 82)
    // .set(Hreg, 4.5, 0.6)
    // .set(Mana, 202, 38)
    // .set(Mreg, 6.5, 0.5)
    // .set(AD, 46.61, 3.3)
    // .set(AS, 0.651, 3.22)
    // .set(AR, 11.25, 3.15)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 330);
    // Twitch.update(P0000)
    // .set(Health, 389, 81)
    // .set(Hreg, 5, 0.6)
    // .set(Mana, 220, 40)
    // .set(Mreg, 6.5, 0.45)
    // .set(AD, 49, 3)
    // .set(AS, 0.679, 3.38)
    // .set(AR, 14, 3)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Udyr.update(P0000)
    // .set(Health, 427, 99)
    // .set(Hreg, 7.45, 0.75)
    // .set(Mana, 220, 30)
    // .set(Mreg, 6.4, 0.45)
    // .set(AD, 52.91, 3.2)
    // .set(AS, 0.658, 2.67)
    // .set(AR, 14.75, 4)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Urgot.update(P0000)
    // .set(Health, 437, 89)
    // .set(Hreg, 5.5, 0.6)
    // .set(Mana, 220, 55)
    // .set(Mreg, 7.5, 0.65)
    // .set(AD, 48, 3.6)
    // .set(AS, 0.644, 2.9)
    // .set(AR, 15, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 425)
    // .set(MS, 335);
    // Varus.update(P0000)
    // .set(Health, 400, 82)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 36)
    // .set(Mreg, 6.5, 0.5)
    // .set(AD, 46, 3)
    // .set(AS, 0.658, 2.65)
    // .set(AR, 13.5, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 575)
    // .set(MS, 335);
    // Varus.update(P307).set(MS, 330);
    // Vayne.update(P0000)
    // .set(Health, 359, 83)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 173, 27)
    // .set(Mreg, 6.3, 0.4)
    // .set(AD, 50, 3.25)
    // .set(AS, 0.658, 3.1)
    // .set(AR, 9.3, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 330);
    // Vayne.update(P303).set(Mana, 173, 35).set(AS, 0.658, 4);
    // Veigar.update(P0000)
    // .set(Health, 355, 82)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 55)
    // .set(Mreg, 6.9, 0.6)
    // .set(AD, 48.3, 2.625)
    // .set(AS, 0.625, 2.24)
    // .set(AR, 12.25, 3.75)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 340);
    // Velkoz.update(P403)
    // .set(Health, 380, 76)
    // .set(Hreg, 4.5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 51.7, 3.14)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 340);
    // Vi.update(P0000)
    // .set(Health, 440, 85)
    // .set(Hreg, 7.5, 0.9)
    // .set(Mana, 220, 45)
    // .set(Mreg, 7.0, 0.65)
    // .set(AD, 55, 3.5)
    // .set(AS, 0.643, 2.5)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 350);
    // Vi.update(P303).set(AD, 51, 3.5);
    // Viktor.update(P0000)
    // .set(Health, 385, 78)
    // .set(Hreg, 6.75, 0.65)
    // .set(Mana, 240, 50)
    // .set(Mreg, 6.9, 0.45)
    // .set(AD, 49, 3)
    // .set(AS, 0.625, 2.11)
    // .set(AR, 12, 4)
    // .set(MR, 30, 0)
    // .set(Range, 525)
    // .set(MS, 335);
    // Vladimir.update(P0000)
    // .set(Health, 400, 85)
    // .set(Hreg, 6, 0.6)
    // .set(AD, 45, 3)
    // .set(AS, 0.6258, 2)
    // .set(AR, 12, 3.5)
    // .set(MR, 30, 0)
    // .set(Range, 450)
    // .set(MS, 335);
    // Volibear.update(P0000)
    // .set(Health, 440, 86)
    // .set(Hreg, 7.0, 0.65)
    // .set(Mana, 220, 30)
    // .set(Mreg, 7, 0.65)
    // .set(AD, 54, 3.3)
    // .set(AS, 0.658, 2.9)
    // .set(AR, 16.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Warwick.update(P0000)
    // .set(Health, 428, 98)
    // .set(Hreg, 7.05, 0.8)
    // .set(Mana, 190, 30)
    // .set(Mreg, 7.1, 0.6)
    // .set(AD, 56.76, 3.375)
    // .set(AS, 0.679, 2.88)
    // .set(AR, 16, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // MonkeyKing.update(P0000)
    // .set(Health, 435, 85)
    // .set(Hreg, 5.1, 0.65)
    // .set(Mana, 202, 38)
    // .set(Mreg, 6.9, 0.65)
    // .set(AD, 54, 3.2)
    // .set(AS, 0.658, 3)
    // .set(AR, 15, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 345);
    // Xerath.update(P0000)
    // .set(Health, 380, 80)
    // .set(Hreg, 5, 0.55)
    // .set(Mana, 250, 45)
    // .set(Mreg, 7, 0.6)
    // .set(AD, 52, 3)
    // .set(AS, 0.625, 1.36)
    // .set(AR, 12.6, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 550)
    // .set(MS, 340);
    // Xerath.update(P402).set(Mana, 238, 47).set(Mreg, 6, 0.65).set(Range, 525);
    // XinZhao.update(P0000)
    // .set(Health, 445, 87)
    // .set(Hreg, 7, 0.7)
    // .set(Mana, 213, 31)
    // .set(Mreg, 6.6, 0.45)
    // .set(AD, 52, 3.3)
    // .set(AS, 0.672, 2.7)
    // .set(AR, 16.2, 3.7)
    // .set(MR, 30, 1.25)
    // .set(Range, 175)
    // .set(MS, 345);
    // Yasuo.update(P315)
    // .set(Health, 430, 82)
    // .set(Hreg, 5, 0.9)
    // .set(AD, 50, 3.2)
    // .set(AS, 0.658, 4)
    // .set(AR, 16, 3.4)
    // .set(MR, 30, 0)
    // .set(Range, 175)
    // .set(MS, 350);
    // Yorick.update(P0000)
    // .set(Health, 421, 85)
    // .set(Hreg, 8.5, 0.7)
    // .set(Mana, 235, 35)
    // .set(Mreg, 6.5, 0.45)
    // .set(AD, 51.5, 3.5)
    // .set(AS, 0.625, 3)
    // .set(AR, 18, 3.6)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Zac.update(P0000)
    // .set(Health, 455, 95)
    // .set(Hreg, 12.5, 0.55)
    // .set(AD, 54, 3.375)
    // .set(AS, 0.638, 1.6)
    // .set(AR, 14, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 335);
    // Zac.update(P307).set(Hreg, 7, 0.55);
    // Zed.update(P0000)
    // .set(Health, 445, 85)
    // .set(Hreg, 6, 0.65)
    // .set(Energy, 20)
    // .set(Ereg, 50)
    // .set(AD, 48.6, 3.4)
    // .set(AS, 0.658, 3.1)
    // .set(AR, 17.5, 3.5)
    // .set(MR, 30, 1.25)
    // .set(Range, 125)
    // .set(MS, 345);
    // Ziggs.update(P0000)
    // .set(Health, 390, 80)
    // .set(Hreg, 5.25, 0.6)
    // .set(Mana, 250, 50)
    // .set(Mreg, 6.75, 0.6)
    // .set(AD, 54, 3.1)
    // .set(AS, 0.656, 1.7)
    // .set(AR, 12, 3.3)
    // .set(MR, 30, 0)
    // .set(Range, 575)
    // .set(MS, 330);
    // Zilean.update(P0000)
    // .set(Health, 380, 71)
    // .set(Hreg, 4.6, 0.5)
    // .set(Mana, 260, 60)
    // .set(Mreg, 6.95, 0.65)
    // .set(AD, 48.6, 3)
    // .set(AS, 0.625, 2.13)
    // .set(AR, 6.75, 3.8)
    // .set(MR, 30, 0)
    // .set(Range, 600)
    // .set(MS, 335);
    // Zyra.update(P0000)
    // .set(Health, 355, 74)
    // .set(Hreg, 4.85, 0.5)
    // .set(Mana, 250, 50)
    // .set(Mreg, 7.1, 0.75)
    // .set(AD, 50, 3.2)
    // .set(AS, 0.625, 1.8)
    // .set(AR, 11, 3)
    // .set(MR, 30, 0)
    // .set(Range, 575)
    // .set(MS, 325);
    // }
}
