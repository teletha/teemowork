/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;

public class ItemData extends Describable<ItemDescriptor> {
    /** The item manager. */
    private static final List<ItemData> items = new ArrayList();

    /** Boots of Speed Definition */
    public static final ItemData BootsofSpeed = new ItemData("Boots of Speed", "ブーツ", 1001, 325, 325, 227, null, new int[] {3006, 3047, 3020, 3158, 3111, 3117, 3009}, 0, 0, 0, 0, "<groupLimit>1個しか持てない。</groupLimit><br><br><unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +25<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("移動速度強化", ability -> {
        });
    });

    /** Faerie Charm Definition */
    public static final ItemData FaerieCharm = new ItemData("Faerie Charm", "妖精の魔除け", 1004, 180, 180, 126, null, new int[] {3028, 3070, 3073, 3114}, 0, 48, 0, 0, "<stats><mana>基本マナ自動回復 +25％ (マナ自動回復</mana></stats>", item -> {
    });

    /** Rejuvenation Bead Definition */
    public static final ItemData RejuvenationBead = new ItemData("Rejuvenation Bead", "再生の珠", 1006, 180, 180, 126, null, new int[] {3077, 3112, 2051, 2053, 3105, 3801}, 0, 96, 0, 0, "<stats>基本ライフ自動回復 +50％ (ライフ回復</stats>", item -> {
    });

    /** Giant's Belt Definition */
    public static final ItemData GiantsBelt = new ItemData("Giant's Belt", "巨人のベルト", 1011, 600, 1000, 700, new int[] {1028}, new int[] {3083, 3143, 3116, 3022, 3084}, 0, 144, 0, 2, "<stats>ライフ +380</stats>", item -> {
        item.health(380);
    });

    /** Cloak of Agility Definition */
    public static final ItemData CloakofAgility = new ItemData("Cloak of Agility", "敏捷のマント", 1018, 730, 730, 511, null, new int[] {3046, 3031, 3104, 3185}, 0, 192, 0, 0, "<stats>クリティカル率 +15%</stats>", item -> {
        item.critical(15);
    });

    /** Blasting Wand Definition */
    public static final ItemData BlastingWand = new ItemData("Blasting Wand", "破裂の杖", 1026, 850, 850, 595, null, new int[] {3001, 3135, 3027, 3029, 3089, 3124, 3151, 3286}, 0, 240, 0, 0, "<stats>魔力 +40</stats>", item -> {
        item.abilityPower(40);
    });

    /** Sapphire Crystal Definition */
    public static final ItemData SapphireCrystal = new ItemData("Sapphire Crystal", "サファイアクリスタル", 1027, 400, 400, 280, null, new int[] {3057, 3070, 3073, 3010, 3024}, 0, 288, 0, 0, "<stats><mana>マナ +200</mana></stats>", item -> {
        item.mana(200);
    });

    /** Ruby Crystal Definition */
    public static final ItemData RubyCrystal = new ItemData("Ruby Crystal", "ルビークリスタル", 1028, 400, 400, 280, null, new int[] {1011, 2049, 2045, 2051, 3010, 3022, 3044, 3067, 3105, 3211, 3751, 3801, 3102, 3136}, 0, 336, 0, 0, "<stats>ライフ +150</stats>", item -> {
        item.health(150);
    });

    /** Cloth Armor Definition */
    public static final ItemData ClothArmor = new ItemData("Cloth Armor", "布の鎧", 1029, 300, 300, 210, null, new int[] {3047, 1031, 3191, 3024, 3082, 3075, 2053}, 0, 384, 0, 0, "<stats>物理防御 +15</stats>", item -> {
        item.armor(15);
    });

    /** Chain Vest Definition */
    public static final ItemData ChainVest = new ItemData("Chain Vest", "チェインベスト", 1031, 450, 750, 525, new int[] {1029}, new int[] {3075, 3068, 3026}, 0, 432, 0, 2, "<stats>物理防御 +40</stats>", item -> {
        item.armor(40);
    });

    /** Null-Magic Mantle Definition */
    public static final ItemData NullMagicMantle = new ItemData("Null-Magic Mantle", "抗魔のマント", 1033, 500, 500, 350, null, new int[] {3111, 3211, 1057, 3028, 3140, 3155, 3105, 3091}, 0, 0, 48, 0, "<stats>魔法防御 +25</stats>", item -> {
        item.magicRegist(25);
    });

    /** Long Sword Definition */
    public static final ItemData LongSword = new ItemData("Long Sword", "ロングソード", 1036, 360, 360, 252, null, new int[] {1053, 3044, 3134, 3155, 3077, 3035, 3154, 3141, 3144, 3122, 3159}, 0, 48, 48, 0, "<stats>攻撃力 +10</stats>", item -> {
        item.attackDamage(10);
    });

    /** Pickaxe Definition */
    public static final ItemData Pickaxe = new ItemData("Pickaxe", "ツルハシ", 1037, 875, 875, 613, null, new int[] {3035, 3124, 3031, 3156, 3077, 3104, 3184, 3004, 3008, 3022, 3172, 3181}, 0, 96, 48, 0, "<stats>攻撃力 +25</stats>", item -> {
        item.attackDamage(25);
    });

    /** B. F. Sword Definition */
    public static final ItemData BFSword = new ItemData("B. F. Sword", "B. F. ソード", 1038, 1550, 1550, 1085, null, new int[] {3031, 3072, 3139, 3508}, 0, 144, 48, 0, "<stats>攻撃力 +50</stats>", item -> {
        item.attackDamage(50);
    });

    /** Hunter's Machete Definition */
    public static final ItemData HuntersMachete = new ItemData("Hunter's Machete", "狩人の山刀", 1039, 400, 400, 280, null, new int[] {3706, 3711, 3715, 3713}, 0, 192, 48, 0, "<stats>大型モンスター・キルごとのゴールドボーナス +15</stats><br><passive>自動効果 - ジャングラー:</passive> モンスターに対する攻撃命中時に2秒にわたり30の魔法ダメージを与える。また、モンスターとの戦闘中、毎秒7ライフおよび3マナが自動回復する（非好戦的なモンスターの場合、自動回復効果はなし）。<br><br><groupLimit>所持できるジャングラー専用アイテムは1 つのみ</groupLimit>", item -> {
    });

    /** Dagger Definition */
    public static final ItemData Dagger = new ItemData("Dagger", "ダガー", 1042, 450, 450, 315, null, new int[] {3006, 3106, 3086, 3101, 1043, 3085, 3046, 3154, 3091, 3159}, 0, 240, 48, 0, "<stats>攻撃速度 +15％</stats>", item -> {
        item.attackSpeed(15);
    });

    /** Recurve Bow Definition */
    public static final ItemData RecurveBow = new ItemData("Recurve Bow", "速射の弓", 1043, 200, 1100, 770, new int[] {1042, 1042}, new int[] {3091, 3153, 3085, 3710, 3718, 3726, 3722}, 0, 288, 48, 2, "<stats>攻撃速度 +30％</stats><br><br><unique>自動効果(累積不可):</unique> 通常攻撃に命中時10の物理ダメージボーナス。", item -> {
        item.attackSpeed(30);
        item.add("通常攻撃に命中時10の物理ダメージボーナス。", ability -> {
        });
    });

    /** Brawler's Gloves Definition */
    public static final ItemData BrawlersGloves = new ItemData("Brawler's Gloves", "喧嘩屋の手袋", 1051, 400, 400, 280, null, new int[] {3086, 3093, 3122}, 0, 336, 48, 0, "<stats>クリティカル率 +8％</stats>", item -> {
        item.critical(8);
    });

    /** Amplifying Tome Definition */
    public static final ItemData AmplifyingTome = new ItemData("Amplifying Tome", "増魔の書", 1052, 435, 435, 305, null, new int[] {3108, 3191, 3057, 3136, 3135, 3145, 3113, 3090, 3116, 3151, 3041, 3089, 3165, 3174}, 0, 384, 48, 0, "<stats>魔力 +20</stats>", item -> {
        item.abilityPower(20);
    });

    /** Vampiric Scepter Definition */
    public static final ItemData VampiricScepter = new ItemData("Vampiric Scepter", "吸血の権杖", 1053, 440, 800, 560, new int[] {1036}, new int[] {3144, 3181, 3072, 3074, 3508, 3050}, 0, 432, 48, 2, "<stats>攻撃力 +10<br>物理吸命 +8%</stats>", item -> {
        item.attackDamage(10);
        item.lifeSteal(8);
    });

    /** Doran's Shield Definition */
    public static final ItemData DoransShield = new ItemData("Doran's Shield", "ドランの盾", 1054, 440, 440, 176, null, null, 0, 0, 96, 0, "<stats>ライフ +80</stats><br><br><unique>自動効果: </unique>5秒毎に6ライフ回復。<br><unique>ユニーク自動効果:</unique> 敵のチャンピオンが発動する単体攻撃とスキルから8ダメージをガード。", item -> {
        item.health(80);
        item.healthRegen(6);
        item.add("5秒毎に6ライフ回復。", ability -> {
        });
        item.add("敵のチャンピオンが発動する単体攻撃とスキルから8ダメージをガード。", ability -> {
        });
    });

    /** Doran's Blade Definition */
    public static final ItemData DoransBlade = new ItemData("Doran's Blade", "ドランの剣", 1055, 440, 440, 176, null, null, 0, 48, 96, 0, "<stats>ライフ +70<br>攻撃力 +7<br>物理吸命 +3%</stats>", item -> {
        item.attackDamage(7);
        item.lifeSteal(3);
        item.health(70);
    });

    /** Doran's Ring Definition */
    public static final ItemData DoransRing = new ItemData("Doran's Ring", "ドランの指輪", 1056, 400, 400, 160, null, null, 0, 96, 96, 0, "<stats>ライフ +60<br>魔力 +15</stats><br><br><passive>自動効果:</passive> <mana>マナ自動回復(毎5秒) +3<br><passive>自動効果:</passive> ユニット1体を倒すたびにマナを4回復。", item -> {
        item.abilityPower(15);
        item.health(60);
        item.manaRegen(3);
    });

    /** Negatron Cloak Definition */
    public static final ItemData NegatronCloak = new ItemData("Negatron Cloak", "封魔のマント", 1057, 350, 850, 595, new int[] {1033}, new int[] {3001, 3026, 3112, 3170, 3180, 3512}, 0, 144, 96, 2, "<stats>魔法防御 +45</stats>", item -> {
        item.magicRegist(45);
    });

    /** Needlessly Large Rod Definition */
    public static final ItemData NeedlesslyLargeRod = new ItemData("Needlessly Large Rod", "ムダニデカイ・ロッド", 1058, 1250, 1250, 875, null, new int[] {3089, 3157, 3003, 3007, 3090, 3116, 3285}, 0, 192, 96, 0, "<stats>魔力 +60</stats>", item -> {
        item.abilityPower(60);
    });

    /** Enchantment: Furor Definition */
    public static final ItemData BerserkersGreavesEnchantmentFuror = new ItemData("Berserker's Greaves Enchantment: Furor", "バーサーカーのブーツ 追加特性: 憤怒", 1300, 475, 1475, 1033, new int[] {3006}, null, 2, 0, 336, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackSpeed(25);
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData BerserkersGreavesEnchantmentAlacrity = new ItemData("Berserker's Greaves Enchantment: Alacrity", "バーサーカーのブーツ 追加特性: 疾風", 1301, 475, 1475, 1033, new int[] {3006}, null, 2, 48, 336, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.attackSpeed(25);
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData BerserkersGreavesEnchantmentCaptain = new ItemData("Berserker's Greaves Enchantment: Captain", "バーサーカーのブーツ 追加特性：隊長", 1302, 600, 1600, 1120, new int[] {3006}, null, 2, 96, 336, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackSpeed(25);
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData BerserkersGreavesEnchantmentDistortion = new ItemData("Berserker's Greaves Enchantment: Distortion", "バーサーカーのブーツ 追加特性: 時空歪曲", 1303, 475, 1475, 1033, new int[] {3006}, null, 2, 144, 336, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackSpeed(25);
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData BerserkersGreavesEnchantmentHomeguard = new ItemData("Berserker's Greaves Enchantment: Homeguard", "バーサーカーのブーツ 追加特性: 防衛", 1304, 475, 1475, 1033, new int[] {3006}, null, 2, 192, 336, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackSpeed(25);
        item.add("防衛", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData BootsofSwiftnessEnchantmentFuror = new ItemData("Boots of Swiftness Enchantment: Furor", "迅速のブーツ 追加特性: 憤怒", 1305, 475, 1475, 1033, new int[] {3009}, null, 2, 240, 336, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData BootsofSwiftnessEnchantmentAlacrity = new ItemData("Boots of Swiftness Enchantment: Alacrity", "迅速のブーツ 追加特性: 疾風", 1306, 475, 1475, 1033, new int[] {3009}, null, 2, 288, 336, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData BootsofSwiftnessEnchantmentCaptain = new ItemData("Boots of Swiftness Enchantment: Captain", "迅速のブーツ 追加特性：隊長", 1307, 600, 1600, 1120, new int[] {3009}, null, 2, 336, 336, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData BootsofSwiftnessEnchantmentDistortion = new ItemData("Boots of Swiftness Enchantment: Distortion", "迅速のブーツ 追加特性: 時空歪曲", 1308, 475, 1475, 1033, new int[] {3009}, null, 2, 384, 336, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData BootsofSwiftnessEnchantmentHomeguard = new ItemData("Boots of Swiftness Enchantment: Homeguard", "迅速のブーツ 追加特性: 防衛", 1309, 475, 1475, 1033, new int[] {3009}, null, 2, 432, 336, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("防衛", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData SorcerersShoesEnchantmentFuror = new ItemData("Sorcerer's Shoes Enchantment: Furor", "魔道士の靴 追加特性: 憤怒", 1310, 475, 1575, 1103, new int[] {3020}, null, 2, 0, 384, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData SorcerersShoesEnchantmentAlacrity = new ItemData("Sorcerer's Shoes Enchantment: Alacrity", "魔道士の靴 追加特性: 疾風", 1311, 475, 1575, 1103, new int[] {3020}, null, 2, 48, 384, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData SorcerersShoesEnchantmentCaptain = new ItemData("Sorcerer's Shoes Enchantment: Captain", "魔道士の靴 追加特性：隊長", 1312, 600, 1700, 1190, new int[] {3020}, null, 2, 96, 384, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData SorcerersShoesEnchantmentDistortion = new ItemData("Sorcerer's Shoes Enchantment: Distortion", "魔道士の靴 追加特性: 時空歪曲", 1313, 475, 1575, 1103, new int[] {3020}, null, 2, 144, 384, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData SorcerersShoesEnchantmentHomeguard = new ItemData("Sorcerer's Shoes Enchantment: Homeguard", "魔道士の靴 追加特性: 防衛", 1314, 475, 1575, 1103, new int[] {3020}, null, 2, 192, 384, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("防衛", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData NinjaTabiEnchantmentFuror = new ItemData("Ninja Tabi Enchantment: Furor", "忍者足袋 追加特性: 憤怒", 1315, 475, 1475, 1033, new int[] {3047}, null, 2, 240, 384, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.armor(25);
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData NinjaTabiEnchantmentAlacrity = new ItemData("Ninja Tabi Enchantment: Alacrity", "忍者足袋 追加特性: 疾風", 1316, 475, 1475, 1033, new int[] {3047}, null, 2, 288, 384, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.armor(25);
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData NinjaTabiEnchantmentCaptain = new ItemData("Ninja Tabi Enchantment: Captain", "忍者足袋 追加特性：隊長", 1317, 600, 1600, 1120, new int[] {3047}, null, 2, 336, 384, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.armor(25);
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData NinjaTabiEnchantmentDistortion = new ItemData("Ninja Tabi Enchantment: Distortion", "忍者足袋 追加特性: 時空歪曲", 1318, 475, 1475, 1033, new int[] {3047}, null, 2, 384, 384, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.armor(25);
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData NinjaTabiEnchantmentHomeguard = new ItemData("Ninja Tabi Enchantment: Homeguard", "忍者足袋 追加特性: 防衛", 1319, 475, 1475, 1033, new int[] {3047}, null, 2, 432, 384, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.armor(25);
        item.add("防衛", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData MercurysTreadsEnchantmentFuror = new ItemData("Mercury's Treads Enchantment: Furor", "マーキュリーの靴 追加特性: 憤怒", 1320, 475, 1675, 1173, new int[] {3111}, null, 2, 0, 432, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.magicRegist(25);
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData MercurysTreadsEnchantmentAlacrity = new ItemData("Mercury's Treads Enchantment: Alacrity", "マーキュリーの靴 追加特性: 疾風", 1321, 475, 1675, 1173, new int[] {3111}, null, 2, 48, 432, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.magicRegist(25);
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData MercurysTreadsEnchantmentCaptain = new ItemData("Mercury's Treads Enchantment: Captain", "マーキュリーの靴 追加特性：隊長", 1322, 600, 1800, 1260, new int[] {3111}, null, 2, 96, 432, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.magicRegist(25);
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData MercurysTreadsEnchantmentDistortion = new ItemData("Mercury's Treads Enchantment: Distortion", "マーキュリーの靴 追加特性: 時空歪曲", 1323, 475, 1675, 1173, new int[] {3111}, null, 2, 144, 432, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.magicRegist(25);
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData MercurysTreadsEnchantmentHomeguard = new ItemData("Mercury's Treads Enchantment: Homeguard", "マーキュリーの靴 追加特性: 防衛", 1324, 475, 1675, 1173, new int[] {3111}, null, 2, 192, 432, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.magicRegist(25);
        item.add("防衛", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData BootsofMobilityEnchantmentFuror = new ItemData("Boots of Mobility Enchantment: Furor", "踏破のブーツ 追加特性: 憤怒", 1325, 475, 1275, 893, new int[] {3117}, null, 2, 240, 432, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData BootsofMobilityEnchantmentAlacrity = new ItemData("Boots of Mobility Enchantment: Alacrity", "踏破のブーツ 追加特性: 疾風", 1326, 475, 1275, 893, new int[] {3117}, null, 2, 288, 432, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData BootsofMobilityEnchantmentCaptain = new ItemData("Boots of Mobility Enchantment: Captain", "踏破のブーツ 追加特性：隊長", 1327, 600, 1400, 980, new int[] {3117}, null, 2, 336, 432, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData BootsofMobilityEnchantmentDistortion = new ItemData("Boots of Mobility Enchantment: Distortion", "踏破のブーツ 追加特性: 時空歪曲", 1328, 475, 1275, 893, new int[] {3117}, null, 2, 384, 432, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData BootsofMobilityEnchantmentHomeguard = new ItemData("Boots of Mobility Enchantment: Homeguard", "踏破のブーツ 追加特性: 防衛", 1329, 475, 1275, 893, new int[] {3117}, null, 2, 432, 432, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("防衛", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData IonianBootsofLucidityEnchantmentFuror = new ItemData("Ionian Boots of Lucidity Enchantment: Furor", "アイオニアブーツ 追加特性: 憤怒", 1330, 475, 1475, 1033, new int[] {3158}, null, 3, 0, 0, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData IonianBootsofLucidityEnchantmentAlacrity = new ItemData("Ionian Boots of Lucidity Enchantment: Alacrity", "アイオニアブーツ 追加特性: 疾風", 1331, 475, 1475, 1033, new int[] {3158}, null, 3, 48, 0, 3, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData IonianBootsofLucidityEnchantmentCaptain = new ItemData("Ionian Boots of Lucidity Enchantment: Captain", "アイオニアブーツ 追加特性：隊長", 1332, 600, 1600, 1120, new int[] {3158}, null, 3, 96, 0, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData IonianBootsofLucidityEnchantmentDistortion = new ItemData("Ionian Boots of Lucidity Enchantment: Distortion", "アイオニアブーツ 追加特性: 時空歪曲", 1333, 475, 1475, 1033, new int[] {3158}, null, 3, 144, 0, 3, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData IonianBootsofLucidityEnchantmentHomeguard = new ItemData("Ionian Boots of Lucidity Enchantment: Homeguard", "アイオニアブーツ 追加特性: 防衛", 1334, 475, 1475, 1033, new int[] {3158}, null, 3, 192, 0, 3, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("防衛", ability -> {
        });
    });

    /** Health Potion Definition */
    public static final ItemData HealthPotion = new ItemData("Health Potion", "ライフポーション", 2003, 35, 35, 14, null, null, 0, 0, 144, 0, "<groupLimit>同時に持てるのは5個まで。</groupLimit><br><br><consumable>クリックで使用:</consumable> ライフ150を15秒間かけて回復する。", item -> {
    });

    /** Mana Potion Definition */
    public static final ItemData ManaPotion = new ItemData("Mana Potion", "マナポーション", 2004, 35, 35, 14, null, null, 0, 48, 144, 0, "<groupLimit>同時に持てるのは5個まで。</groupLimit><br><br><consumable>クリックで使用:</consumable> <mana>100のマナを15秒かけて回復。</mana>", item -> {
    });

    /** Total Biscuit of Rejuvenation Definition */
    public static final ItemData TotalBiscuitofRejuvenation = new ItemData("Total Biscuit of Rejuvenation", "栄養満点ビスケット", 2010, 35, 35, 14, null, null, 0, 144, 144, 0, "<consumable>クリックで使用:</consumable> ライフ20とマナ10をただちに回復した後、ライフ150を15秒間かけて回復する。", item -> {
    });

    /** Crystalline Flask Definition */
    public static final ItemData CrystallineFlask = new ItemData("Crystalline Flask", "クリスタル・フラスコ", 2041, 345, 345, 138, null, null, 0, 192, 144, 0, "<unique>ユニーク自動効果:</unique> ショップを訪れることで3チャージ分を補充できる。<br><active>ユニーク発動効果:</active> 1チャージ消費して120ライフと60マナを12秒間かけて回復する。", item -> {
        item.add("ショップを訪れることで3チャージ分を補充できる。<br>", ability -> {
        });
    });

    /** Vision Ward Definition */
    public static final ItemData VisionWard = new ItemData("Vision Ward", "ビジョンワード", 2043, 100, 100, 40, null, null, 0, 240, 144, 0, "<groupLimit>ビジョンワードは同時に2個までしか持てない。</groupLimit><br><br><consumable>クリックで使用:</consumable> ビジョンワード1個を設置する。ワードは周囲の視界を与え、視界内で不可視状態になっている敵の姿をあばく。効果は破壊されるまで続く。マップへ同時に置ける<font color='#BBFFFF'>ビジョンワード</font>の個数は、1プレイヤーにつき1個まで。<br><br><i>(この効果でワードを発見した者は、そのワードを壊した時にゴールド報酬の分配対象となる)</i>", item -> {
    });

    /** Stealth Ward Definition */
    public static final ItemData StealthWard = new ItemData("Stealth Ward", "ステルスワード", 2044, 75, 75, 30, null, null, 0, 288, 144, 0, "<groupLimit>ステルスワードは同時に3個までしか持てない。</groupLimit><br><br><consumable>クリックで使用:</consumable> ステルスワード1個を設置する。ワードは周囲の視界を得る。効果は3分間持続する。マップへ同時に置ける<font color='#BBFFFF'>ステルスワード</font>の個数は、1プレイヤーにつき3個まで。", item -> {
    });

    /** Ruby Sightstone Definition */
    public static final ItemData RubySightstone = new ItemData("Ruby Sightstone", "ルビー・サイトストーン", 2045, 400, 1600, 640, new int[] {2049, 1028}, null, 0, 336, 144, 3, "<stats>ライフ +400</stats><br><br><unique>ユニーク自動効果 - ワード更新:</unique> ショップを訪れることで5チャージを補充できる。<br><active>ユニーク発動効果 - ゴーストワード:</active> 1チャージ消費して<font color='#FFFFFF'>ステルスワード</font>1個を設置する。ワードは周囲の視界を3分間得る。マップへ同時に置ける<font color='#BBFFFF'>ステルスワード</font>の個数は、1プレイヤーにつき3個まで。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.health(400);
        item.add("ワード更新", ability -> {
        });
    });

    /** Sightstone Definition */
    public static final ItemData Sightstone = new ItemData("Sightstone", "サイトストーン", 2049, 400, 800, 320, new int[] {1028}, new int[] {2045}, 0, 432, 144, 2, "<stats>+150ライフ</stats><br><br><unique>ユニーク自動効果 - ワード更新:</unique> ショップを訪れることで4チャージを補充できる。<br><active>ユニーク発動効果 - ゴーストワード:</active> 1チャージ消費して<font color='#FFFFFF'>ステルスワード</font>1個を設置する。ワードは周囲の視界を3分間得る。マップへ同時に置ける<font color='#BBFFFF'>ステルスワード</font>の個数は、1プレイヤーにつき3個まで。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.health(150);
        item.add("ワード更新", ability -> {
        });
    });

    /** Explorer's Ward Definition */
    public static final ItemData ExplorersWard = new ItemData("Explorer's Ward", "探検家のワード", 2050, 0, 0, 0, null, null, 0, 0, 192, 0, "<consumable>クリックで使用:</consumable> ステルスワード1個を設置する。ワードは周囲の視界を得る。効果は60秒間持続する。", item -> {
    });

    /** Poro-Snax Definition */
    public static final ItemData PoroSnax = new ItemData("Poro-Snax", "ポロのおやつ", 2052, 0, 0, 0, null, null, 0, 96, 192, 0, "放し飼いで伸び伸びと草を食べて育ったアヴァローサン地鶏と、ZMO不使用の有機フレヨルド産ハーブをブレンドし、風味豊かに仕上げました。かわいいポロのご機嫌な生活に必要な栄養素を、バランス良く含有しています。<br><br><i>すべての収益はノクサスの動物虐待防止運動に寄付されます。</i>", item -> {
    });

    /** Raptor Cloak Definition */
    public static final ItemData RaptorCloak = new ItemData("Raptor Cloak", "ラプターのマント", 2053, 520, 1000, 700, new int[] {1006, 1029}, new int[] {3056, 3512}, 0, 144, 192, 2, "<stats>物理防御 +40<br>基本ライフ自動回復 +100％ (ライフ回復</stats><br><br><unique>ユニーク自動効果 - ポイントランナー:</unique> タワー(破壊されたものを含む)付近では、2秒にわたり移動速度が最大30％上昇。", item -> {
        item.armor(40);
        item.add("ポイントランナー", ability -> {
        });
    });

    /** Diet Poro-Snax Definition */
    public static final ItemData DietPoroSnax = new ItemData("Diet Poro-Snax", "ポロのヘルシーおやつ", 2054, 0, 0, 0, null, null, 0, 192, 192, 0, "通常のポロスナックのフレーバーはそのままに、カロリーゼロを実現！あなたのポロもハッピー&ヘルシー！<br><br><consumable>クリックで消費:</consumable> かわいいポロにおいしくて健康的なおやつを。", item -> {
    });

    /** Elixir of Ruin Definition */
    public static final ItemData ElixirofRuin = new ItemData("Elixir of Ruin", "破滅のエリクサー", 2137, 400, 400, 160, null, null, 0, 240, 192, 0, "<stats><levelLimit>購入するにはレベル9以上必要。</levelLimit></stats><br><br><consumable>クリックで消費:</consumable> 3分間、ライフ +250、タワーへのダメージボーナス15％、<font color='#FF8811'><u>攻城戦の達士</u></font>の効果を得る。<br><br><font color='#FF8811'><u>攻城戦の達士:</u></font> 周囲のミニオンにタワーへのダメージボーナス15％と移動速度ボーナスを付与(チャンピオンの移動速度により上昇する値が変動)。<br><br><i>(同時に2個以上のフラスコは使用できない)</i>", item -> {
    });

    /** Elixir of Iron Definition */
    public static final ItemData ElixirofIron = new ItemData("Elixir of Iron", "巨躯のエリクサー", 2138, 400, 400, 160, null, null, 0, 288, 192, 0, "<stats><levelLimit>購入するにはレベル9以上必要。</levelLimit></stats><br><br><consumable>クリックで消費:</consumable> 3分間、サイズ、スロウ耐性、根性が25％上昇し、<font color='#FF8811'><u>鋼の導べ</u></font>の効果を得る。<br><br><font color='#FF8811'><u>鋼の導べ:</u></font> 通過した場所は「鋼の導べ」となり、続く味方のチャンピオンの移動速度を15％上昇させる。<br><br><i>(同時に2個以上のフラスコは使用できない)</i>", item -> {
    });

    /** Elixir of Sorcery Definition */
    public static final ItemData ElixirofSorcery = new ItemData("Elixir of Sorcery", "聡明のエリクサー", 2139, 400, 400, 160, null, null, 0, 336, 192, 0, "<stats><levelLimit>購入するにはレベル9以上必要。</levelLimit></stats><br><br><consumable>クリックで消費:</consumable> 3分間、魔力 +40、マナ自動回復(毎5秒) +15、そして<font color='#FF8811'><u>聡明</u></font>の効果を得る。<br><br><font color='#FF8811'><u>聡明:</u></font> チャンピオンとタワーに25の確定ダメージボーナスを与える。チャンピオンをターゲットとする場合、この効果には5秒のクールダウンがあるが、タワーをターゲットとする場合のクールダウンはない。<br><br><i>(同時に2個以上のフラスコは使用できない)</i><br>", item -> {
    });

    /** Elixir of Wrath Definition */
    public static final ItemData ElixirofWrath = new ItemData("Elixir of Wrath", "憤怒のエリクサー", 2140, 400, 400, 160, null, null, 0, 384, 192, 0, "<stats><levelLimit>購入するにはレベル9以上必要。</levelLimit></stats><br><br><consumable>クリックで消費: </consumable>3分間、攻撃力 +25と<font color='#FF8811'><u>血に飢えし者</u></font>の効果を得る。<br><br><font color='#FF8811'><u>血に飢えし者:</u></font>チャンピオンに物理ダメージを与えると、与ダメージの10％に相当するライフを回復する。キルおよびアシス獲得で、このフラスコの効果時間が30秒延長される。<br><br><i>(同時に2個以上のフラスコは使用できない)</i>", item -> {
    });

    /** Abyssal Scepter Definition */
    public static final ItemData AbyssalScepter = new ItemData("Abyssal Scepter", "深淵の権杖", 3001, 730, 2430, 1701, new int[] {1026, 1057}, null, 0, 432, 192, 3, "<stats>魔力 +70<br>魔法防御 +50</stats><br><br><aura>ユニークオーラ:</aura> 周囲の敵の魔法防御を20下げる。", item -> {
        item.abilityPower(70);
        item.magicRegist(50);
    });

    /** Archangel's Staff Definition */
    public static final ItemData ArchangelsStaff = new ItemData("Archangel's Staff", "大天使の杖", 3003, 1030, 3000, 2100, new int[] {3070, 1058}, new int[] {3040}, 0, 0, 240, 3, "<stats>魔力 +80<br><mana>マナ +250<br>基本マナ自動回復 +50％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果 - 洞察:</unique> マナ最大値の3％に等しい魔力を得る。<br><unique>ユニーク自動効果 - マナチャージ:</unique> スキル使用およびマナ消費ごとに、マナ最大値が8上昇(最大で750マナ上昇)。この効果は最大2回(毎8秒)まで発生する。ボーナス分のマナが750に達した時点で「熾天使の抱擁」に変化する。</mana><br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.abilityPower(80);
        item.mana(250);
        item.add("洞察", ability -> {
        });
        item.add("マナチャージ", ability -> {
        });
    });

    /** Manamune Definition */
    public static final ItemData Manamune = new ItemData("Manamune", "マナ・ムネ", 3004, 605, 2200, 1540, new int[] {3070, 1037}, new int[] {3042}, 0, 48, 240, 3, "<stats>攻撃力 +25<br><mana>マナ +250<br>基本マナ自動回復 +25％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果 - 畏怖:</unique> マナ最大値の2％に等しい物理ダメージボーナスを得る。<br><unique>ユニーク自動効果 - マナチャージ:</unique> 通常攻撃/スキル使用/マナ消費ごとに、マナ最大値が4上昇(最大で750マナ上昇)。この効果は最大2回(毎8秒)まで発生する。<br><br>ボーナス分のマナが750に達した時点で「ムラ･マナ」に変化する。</mana><br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.attackDamage(25);
        item.mana(250);
        item.add("畏怖", ability -> {
        });
        item.add("マナチャージ", ability -> {
        });
    });

    /** Berserker's Greaves Definition */
    public static final ItemData BerserkersGreaves = new ItemData("Berserker's Greaves", "バーサーカーのブーツ", 3006, 225, 1000, 700, new int[] {1001, 1042}, new int[] {1301, 1303, 1300, 1302, 1304}, 0, 96, 240, 2, "<stats> +25%攻撃速度</stats><br><br><unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +45<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackSpeed(25);
        item.add("移動速度強化", ability -> {
        });
    });

    /** Boots of Swiftness Definition */
    public static final ItemData BootsofSwiftness = new ItemData("Boots of Swiftness", "迅速のブーツ", 3009, 675, 1000, 700, new int[] {1001}, new int[] {1306, 1308, 1305, 1307, 1309}, 0, 240, 240, 2, "<unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +60<br><unique>ユニーク自動効果 - スロウ耐性:</unique> 移動が遅くなる効果の影響を25%軽減する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("移動速度強化", ability -> {
        });
        item.add("スロウ耐性", ability -> {
        });
    });

    /** Catalyst the Protector Definition */
    public static final ItemData CatalysttheProtector = new ItemData("Catalyst the Protector", "守護の触媒", 3010, 400, 1200, 840, new int[] {1028, 1027}, new int[] {3027, 3029, 3180, 3800}, 0, 288, 240, 2, "<stats>ライフ +200<br><mana>マナ +300</mana></stats><br><br><unique>ユニーク自動効果 - 勇者の報酬:</unique> レベルアップ時に、ライフ150とマナ200を8秒かけて回復する。<br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.health(200);
        item.mana(300);
        item.add("勇者の報酬", ability -> {
        });
    });

    /** Sorcerer's Shoes Definition */
    public static final ItemData SorcerersShoes = new ItemData("Sorcerer's Shoes", "魔道士の靴", 3020, 775, 1100, 770, new int[] {1001}, new int[] {1311, 1313, 1310, 1312, 1314}, 0, 336, 240, 2, "<stats>魔法防御貫通 +15</stats><br><br><unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +45<br><br><i>(魔法防御貫通: 対象の魔法防御を魔法防御貫通の値だけ無視することによって、魔法ダメージが多く与えられる)</i><br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("移動速度強化", ability -> {
        });
    });

    /** Frozen Mallet Definition */
    public static final ItemData FrozenMallet = new ItemData("Frozen Mallet", "氷結の大槌", 3022, 1025, 3300, 2310, new int[] {1028, 1011, 1037}, null, 0, 384, 240, 3, "<stats>ライフ +700<br>攻撃力 +30</stats><br><br><unique>ユニーク自動効果 - 氷結:</unique> 通常攻撃が命中すると対象の移動速度を1.5秒間遅くする(移動速度低下率は近接攻撃で40%、遠隔攻撃で30%)。</i>", item -> {
        item.attackDamage(30);
        item.health(700);
        item.add("氷結", ability -> {
        });
    });

    /** Twin Shadows Definition */
    public static final ItemData TwinShadows = new ItemData("Twin Shadows", "双子の亡霊", 3023, 730, 2400, 1680, new int[] {3108, 3113}, null, 0, 432, 240, 3, "<stats>魔力 +80<br>クールダウン +10％<br>移動速度 +6％</stats><br><br><active>ユニーク発動効果 - 狩り:</active> 攻撃が無効な亡霊を2体召喚し、最も近くにいる敵のチャンピオン2人を6秒間偵察する。亡霊は標的に追いつくと、標的を可視状態にして移動速度を40％遅くする。効果は2.5秒間。<br><br>標的を見つけられなかった場合、亡霊は召喚者のもとへ戻ろうとする。亡霊が帰還に成功した場合、このアイテムのクールダウンは40秒短縮される(120秒クールダウン)。", item -> {
        item.abilityPower(80);
        item.movementSpeed(6);
    });

    /** Glacial Shroud Definition */
    public static final ItemData GlacialShroud = new ItemData("Glacial Shroud", "氷河の盾", 3024, 250, 950, 665, new int[] {1027, 1029}, new int[] {3110, 3025, 3187}, 0, 0, 288, 2, "<stats>物理防御 +20<br><mana>マナ +250</mana></stats><br><br><unique>ユニーク自動効果:</unique> クールダウン +10％", item -> {
        item.mana(250);
        item.armor(20);
        item.add("クールダウン +10％", ability -> {
        });
    });

    /** Iceborn Gauntlet Definition */
    public static final ItemData IcebornGauntlet = new ItemData("Iceborn Gauntlet", "アイスボーンの籠手", 3025, 750, 2900, 2030, new int[] {3057, 3024}, null, 0, 48, 288, 3, "<stats>物理防御 +60<br>魔力 +30<br>クールダウン +10％<br><mana>マナ +500</mana></stats><br><br><unique>ユニーク自動効果 - 追撃:</unique> スキル使用後、次の通常攻撃が命中すると、基本攻撃力の125％に等しい物理ダメージボーナスをターゲットの周囲の敵に与え、ターゲットの周囲に2秒にわたって移動速度を30％低下させるフィールドを形成する(クールダウン1.5秒、遠隔攻撃の場合はフィールドサイズが半分となる)。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.abilityPower(30);
        item.mana(500);
        item.armor(60);
        item.add("追撃", ability -> {
        });
    });

    /** Guardian Angel Definition */
    public static final ItemData GuardianAngel = new ItemData("Guardian Angel", "守護天使の鎧", 3026, 1200, 2800, 1120, new int[] {1057, 1031}, null, 0, 96, 288, 3, "<stats>物理防御 +50<br>魔法防御 +50</stats><br><br><unique>ユニーク自動効果:</unique> ライフがゼロになった際、4秒間静止した後に、ライフとマナが最大値の30%分回復して復活する(クールダウン300秒)。", item -> {
        item.armor(50);
        item.magicRegist(50);
        item.add("ライフがゼロになった際、4秒間静止した後に、ライフとマナが最大値の30%分回復して復活する(クールダウン300秒)。", ability -> {
        });
    });

    /** Rod of Ages Definition */
    public static final ItemData RodofAges = new ItemData("Rod of Ages", "歳月の杖", 3027, 650, 2700, 1890, new int[] {3010, 1026}, null, 0, 144, 288, 3, "<stats>ライフ +300<br><mana>マナ +400</mana><br>魔力 +60</stats><br><br><passive>自動効果:</passive> 1累積につきライフ +20、マナ +40、魔力 +4を得る(最大でライフ +200、マナ +400、魔力 +40)。1分ごとに1累積獲得(最大10累積)。<br><unique>ユニーク自動効果 - 勇者の報酬:</unique> レベルアップ時に、150ライフと200マナを8秒かけて回復する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.abilityPower(60);
        item.health(300);
        item.mana(400);
        item.add("勇者の報酬", ability -> {
        });
    });

    /** Chalice of Harmony Definition */
    public static final ItemData ChaliceofHarmony = new ItemData("Chalice of Harmony", "調和の聖杯", 3028, 40, 900, 630, new int[] {1004, 1033, 1004}, new int[] {3174, 3222}, 0, 192, 288, 2, "<stats>魔法防御 +25<br><mana>基本マナ自動回復 +50％ (マナ自動回復</stats><br><br><unique>ユニーク自動効果 - マナの泉:</unique> 5秒ごとに失ったマナの2％を回復する。</mana><br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.magicRegist(25);
        item.add("マナの泉", ability -> {
        });
    });

    /** Infinity Edge Definition */
    public static final ItemData InfinityEdge = new ItemData("Infinity Edge", "無限の神剣", 3031, 645, 3800, 2660, new int[] {1038, 1037, 1018}, null, 0, 288, 288, 2, "<stats>攻撃力 +80<br>クリティカル率 +20％</stats><br><br><unique>ユニーク自動効果:</unique> クリティカル時に与えるダメージが200％から250％に変化する。", item -> {
        item.attackDamage(80);
        item.critical(20);
        item.add("クリティカル時に与えるダメージが200％から250％に変化する。", ability -> {
        });
    });

    /** Last Whisper Definition */
    public static final ItemData LastWhisper = new ItemData("Last Whisper", "終焉の弓", 3035, 1065, 2300, 1610, new int[] {1037, 1036}, null, 0, 336, 288, 2, "<stats>攻撃力 +40</stats><br><br><unique>ユニーク自動効果:</unique> 物理ダメージが対象の物理防御の35%を無視する(物理防御貫通の前に適用される)。", item -> {
        item.attackDamage(40);
        item.add("物理ダメージが対象の物理防御の35%を無視する(物理防御貫通の前に適用される)。", ability -> {
        });
    });

    /** Seraph's Embrace Definition */
    public static final ItemData SeraphsEmbrace = new ItemData("Seraph's Embrace", "熾天使の抱擁", 3040, 3000, 3000, 4200, new int[] {3003}, null, 0, 384, 288, 4, "<stats>魔力 +80<br><mana>マナ +1000<br>基本マナ自動回復 +50％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果 - 洞察:</unique> マナ最大値の3％に等しい魔力を得る。</mana><br><active>ユニーク発動効果 - マナシールド:</active> マナ現在量の20％を消費して、3秒にわたってシールドを張る。このシールドは150 + 消費したマナ量に等しいダメージを吸収する(クールダウン120秒)。<br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.abilityPower(80);
        item.mana(1000);
        item.add("洞察", ability -> {
        });
    });

    /** Mejai's Soulstealer Definition */
    public static final ItemData MejaisSoulstealer = new ItemData("Mejai's Soulstealer", "メジャイの魔本", 3041, 965, 1400, 980, new int[] {1052}, null, 0, 432, 288, 2, "<stats>魔力 +20</stats><br><br><unique>ユニーク自動効果:</unique> 1累積につき魔力が8上昇。初回購入時には5累積を得る。1キルごとに2累積、1アシストごとに1累積を獲得(最大20累積)。死亡すると累積数の半分を失う。20累積した状態では15％のクールダウンが発生する。", item -> {
        item.abilityPower(20);
        item.add("1累積につき魔力が8上昇。初回購入時には5累積を得る。1キルごとに2累積、1アシストごとに1累積を獲得(最大20累積)。死亡すると累積数の半分を失う。20累積した状態では15％のクールダウンが発生する。", ability -> {
        });
    });

    /** Muramana Definition */
    public static final ItemData Muramana = new ItemData("Muramana", "ムラ・マナ", 3042, 2200, 2200, 3080, new int[] {3004}, null, 0, 0, 336, 4, "<stats>攻撃力 +25<br><mana>マナ +1000<br>基本マナ自動回復 +25％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果 - 畏怖:</unique> マナ最大値の2％に等しい物理ダメージボーナスを得る。<br><unique>ユニーク切替効果:</unique> 単体対象のスキル/攻撃の命中時にマナ現在値の3％を消費して、その消費マナ量の2倍に等しい物理ダメージボーナスを与える。</mana><br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.attackDamage(25);
        item.mana(1000);
        item.add("畏怖", ability -> {
        });
        item.add("単体対象のスキル/攻撃の命中時にマナ現在値の3％を消費して、その消費マナ量の2倍に等しい物理ダメージボーナスを与える。", ability -> {
        });
    });

    /** Phage Definition */
    public static final ItemData Phage = new ItemData("Phage", "ファージ", 3044, 565, 1325, 927, new int[] {1028, 1036}, new int[] {3078, 3071, 3184}, 0, 96, 336, 2, "<stats>ライフ +200<br>攻撃力 +20</stats><br><br><unique>ユニーク自動効果 - 疾風怒濤:</unique> 通常攻撃をすると2秒間移動速度が20上昇する。敵を倒した場合、移動速度は60上昇する。遠隔攻撃型のチャンピオンの場合、この移動速度ボーナスは半分になる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackDamage(20);
        item.health(200);
        item.add("疾風怒濤", ability -> {
        });
    });

    /** Phantom Dancer Definition */
    public static final ItemData PhantomDancer = new ItemData("Phantom Dancer", "幻影の踊り手", 3046, 520, 2800, 1960, new int[] {1018, 3086, 1042}, null, 0, 144, 336, 3, "<stats>攻撃速度 +50%<br>クリティカル率 +35%<br>移動速度 +5%</stats><br><br><unique>ユニーク自動効果:</unique> チャンピオンはユニットがいる場所を通り抜けられる。", item -> {
        item.attackSpeed(50);
        item.critical(35);
        item.movementSpeed(5);
        item.add("チャンピオンはユニットがいる場所を通り抜けられる。", ability -> {
        });
    });

    /** Ninja Tabi Definition */
    public static final ItemData NinjaTabi = new ItemData("Ninja Tabi", "忍者足袋", 3047, 375, 1000, 700, new int[] {1001, 1029}, new int[] {1316, 1318, 1315, 1317, 1319}, 0, 192, 336, 2, "<stats>物理防御 +25</stats><br><br><unique>ユニーク自動効果:</unique> 通常攻撃のダメージを10%ブロックする。<br><unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度+45<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.armor(25);
        item.add("通常攻撃のダメージを10%ブロックする。", ability -> {
        });
        item.add("移動速度強化", ability -> {
        });
    });

    /** Zeke's Herald Definition */
    public static final ItemData ZekesHerald = new ItemData("Zeke's Herald", "ジークの使者", 3050, 800, 2450, 1715, new int[] {3067, 1053}, null, 0, 288, 336, 3, "<stats>ライフ +250<br>クールダウン +20％</stats><br><br><aura>オーラ(累積不可):</aura> 味方のチャンピオンに10％の物理吸命と攻撃力20を与える。", item -> {
        item.health(250);
    });

    /** Ohmwrecker Definition */
    public static final ItemData Ohmwrecker = new ItemData("Ohmwrecker", "撹乱石", 3056, 750, 2600, 1820, new int[] {2053, 3067}, null, 0, 336, 336, 3, "<stats>ライフ +300<br>物理防御 +50<br>基本ライフ自動回復 +100％ (ライフ自動回復<br>クールダウン +10％</stats><br><br><active>ユニーク発動効果:</active> 周囲の敵タワーは3秒間攻撃できなくなる(クールダウン120秒)。同じタワーに対しては8秒に1回しか効果がない。<br><br><unique>ユニーク自動効果 - ポイントランナー:</unique> タワー(破壊されたものを含む)付近では、2秒にわたり移動速度が最大30％上昇。<br>", item -> {
        item.health(300);
        item.armor(50);
        item.add("ポイントランナー", ability -> {
        });
    });

    /** Sheen Definition */
    public static final ItemData Sheen = new ItemData("Sheen", "シーン", 3057, 365, 1200, 840, new int[] {1027, 1052}, new int[] {3078, 3100, 3025, 3708, 3716, 3720, 3724}, 0, 384, 336, 2, "<stats>魔力 +25<br><mana>マナ +200</mana></stats><br><br><unique>ユニーク自動効果 - 追撃:</unique> スキル使用後、次の通常攻撃は命中時に基本攻撃力の100％に等しい物理ダメージボーナスを与える(クールダウン1.5秒)。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.abilityPower(25);
        item.mana(200);
        item.add("追撃", ability -> {
        });
    });

    /** Banner of Command Definition */
    public static final ItemData BannerofCommand = new ItemData("Banner of Command", "統率の旗", 3060, 280, 3000, 2100, new int[] {3105, 3108}, null, 0, 432, 336, 3, "<stats>ライフ +200<br>魔力 +60<br>魔法防御 +20<br>クールダウン +10％</stats><br><br><aura>ユニークオーラ - 精兵:</aura> 周囲の味方に対し魔法防御20と基本ライフ自動回復75％を与える。<br><active>ユニーク発動効果 - 昇格:</active> レーン上のミニオンを大幅に強化して被魔法ダメージを無効化する(クールダウン120秒)。<br><br><i>(同名のユニークオーラは累積しない)</i>", item -> {
        item.abilityPower(60);
        item.health(200);
        item.magicRegist(20);
    });

    /** Spirit Visage Definition */
    public static final ItemData SpiritVisage = new ItemData("Spirit Visage", "精霊の鎧", 3065, 700, 2750, 1925, new int[] {3211, 3067}, null, 0, 0, 384, 3, "<stats>ライフ +400<br>魔法防御 +55<br>基本ライフ自動回復 +100％ (ライフ自動回復<br>クールダウン +10％</stats><br><br><unique>ユニーク自動効果:</unique> 自己ヒール、ライフ自動回復、物理吸命、魔法吸命の効果が20％上昇。", item -> {
        item.health(400);
        item.magicRegist(55);
        item.add("自己ヒール、ライフ自動回復、物理吸命、魔法吸命の効果が20％上昇。", ability -> {
        });
    });

    /** Kindlegem Definition */
    public static final ItemData Kindlegem = new ItemData("Kindlegem", "点火石", 3067, 450, 850, 595, new int[] {1028}, new int[] {3187, 3190, 3401, 3065, 3050, 3056, 3071}, 0, 48, 384, 2, "<stats>ライフ +200 </stats><br><br><unique>ユニーク自動効果:</unique> クールダウン +10%", item -> {
        item.health(200);
        item.add("クールダウン +10%", ability -> {
        });
    });

    /** Sunfire Cape Definition */
    public static final ItemData SunfireCape = new ItemData("Sunfire Cape", "灼熱の鎧", 3068, 850, 2600, 1820, new int[] {1031, 3751}, null, 0, 96, 384, 3, "<stats>ライフ +450<br>物理防御 +45</stats><br><br><unique>ユニーク自動効果 - 猛火:</unique> 周囲の敵に毎秒25 + (1 x チャンピオンのレベル) の魔法ダメージを与える。", item -> {
        item.health(450);
        item.armor(45);
        item.add("猛火", ability -> {
        });
    });

    /** Talisman of Ascension Definition */
    public static final ItemData TalismanofAscension = new ItemData("Talisman of Ascension", "超越の護符", 3069, 635, 2100, 840, new int[] {3096, 3114}, null, 0, 144, 384, 3, "<stats>基本ライフ自動回復 +100％ (ライフ自動回復<br><mana>基本マナ自動回復 +100％ (マナ自動回復<br></mana>移動速度 +20<br>クールダウン +10％<br>獲得ゴールド(10秒毎) +2</stats><br><br><unique>ユニーク自動効果 - 恩寵:</unique> 自らとどめを刺すことなく周囲でミニオンが死んだ場合、4ゴールドを得て10ライフを回復する。<br><active>ユニーク発動効果:</active> 周囲の味方の移動速度を40％上昇させる。効果は3秒間(クールダウン40秒)。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit><br><br><i><font color='#447777'>「太陽を讃えよ」－歴史家シュレリア、CLE25年9月22日</font></i><br><br>", item -> {
        item.add("恩寵", ability -> {
        });
    });

    /** Tear of the Goddess Definition */
    public static final ItemData TearoftheGoddess = new ItemData("Tear of the Goddess", "女神の涙", 3070, 140, 720, 504, new int[] {1027, 1004}, new int[] {3003, 3004}, 0, 192, 384, 2, "<stats><mana>マナ +250<br>基本マナ自動回復 +25％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果 - マナチャージ:</unique> スキル使用/マナ消費ごとに、マナ最大値が4上昇(この効果は最大2回(毎8秒)まで発生する)。マナ最大値が1(毎8秒)上昇。<br><br>最大で750マナ上昇。</mana><br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.mana(250);
        item.add("マナチャージ", ability -> {
        });
    });

    /** The Black Cleaver Definition */
    public static final ItemData TheBlackCleaver = new ItemData("The Black Cleaver", "撃滅の黒斧", 3071, 825, 3000, 2100, new int[] {3044, 3067}, null, 0, 240, 384, 3, "<stats>ライフ +400<br>攻撃力 +40<br>クールダウン +20％</stats><br><br><passive>ユニーク自動効果:</passive> 敵のチャンピオンに物理ダメージを与えると相手にクリーブをつけ、物理防御を5％下げる。効果は6秒間継続。最大で6回、30％までスタックする。<br><unique>ユニーク自動効果 - 怒り:</unique>物理ダメージを与えると、2秒にわたり移動速度が20上昇する。クリーブを受けた敵のチャンピオンからアシストを獲得するか、他のユニットからキルを獲得すると、上昇する移動速度は60になる(2秒間)。遠隔チャンピオンの場合は、上昇する移動速度が半分になる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackDamage(40);
        item.health(400);
        item.add("怒り", ability -> {
        });
    });

    /** The Bloodthirster Definition */
    public static final ItemData TheBloodthirster = new ItemData("The Bloodthirster", "渇望の血剣", 3072, 1150, 3500, 2450, new int[] {1053, 1038}, null, 0, 288, 384, 3, "<stats>攻撃力 +80</stats><br><br><passive>ユニーク自動効果:</passive> 物理吸命 +20%<br><passive>ユニーク自動効果:</passive> 通常攻撃で最大ライフ値を超えてライフを吸収できる。余ったライフはシールドとして自身に付与され、50～350ダメージ(チャンピオンのレベルに比例)をブロックする。<br><br>このシールドは25秒にわたって戦闘を行わなければ、徐々に減少する。", item -> {
        item.attackDamage(80);
    });

    /** Ravenous Hydra (Melee Only) Definition */
    public static final ItemData RavenousHydraMeleeOnly = new ItemData("Ravenous Hydra (Melee Only)", "餓えしハイドラ(近接専用)", 3074, 600, 3300, 2310, new int[] {3077, 1053}, null, 0, 384, 384, 3, "<stats>攻撃力 +75<br>基本ライフ自動回復 +100％ <br>物理吸命 +12％</stats><br><br><passive>自動効果:</passive> このアイテムが与えたダメージには物理吸命が適用される。<br><unique>ユニーク自動効果 - なぎ払い:</unique> 合計攻撃力の20％～60％を物理ダメージボーナスとして通常攻撃に上乗せし、ターゲットの周囲の敵にダメージを与える(ターゲットの近くにいる敵ほど受けるダメージが大きくなる)。<br><active>ユニーク発動効果 - 三日月斬:</active> 合計攻撃力の60％～100％を物理ダメージとして周囲の敵ユニットに与える(近くにいる敵ほど受けるダメージが大きくなる)(クールダウン10秒)。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackDamage(75);
        item.lifeSteal(12);
        item.add("なぎ払い", ability -> {
        });
    });

    /** Thornmail Definition */
    public static final ItemData Thornmail = new ItemData("Thornmail", "茨の鎧", 3075, 1050, 2100, 1470, new int[] {1029, 1031}, null, 0, 432, 384, 3, "<stats>物理防御 +100</stats><br><br><unique>ユニーク自動効果:</unique> 通常攻撃を受けた時、与えられたダメージ(各種防御で軽減される前)の30%を攻撃者に魔法ダメージとして与える。", item -> {
        item.armor(100);
        item.add("通常攻撃を受けた時、与えられたダメージ(各種防御で軽減される前)の30%を攻撃者に魔法ダメージとして与える。", ability -> {
        });
    });

    /** Tiamat (Melee Only) Definition */
    public static final ItemData TiamatMeleeOnly = new ItemData("Tiamat (Melee Only)", "ティアマット（近接専用）", 3077, 305, 1900, 1330, new int[] {1037, 1036, 1006, 1006}, new int[] {3074}, 0, 0, 432, 2, "<stats>攻撃力 +40<br>基本ライフ自動回復 +100％ (ライフ自動回復</stats><br><br><unique>ユニーク自動効果 - なぎ払い:</unique> 合計攻撃力の20％～60％を物理ダメージボーナスとして通常攻撃に上乗せし、ターゲットの周囲の敵にダメージを与える(ターゲットの近くにいる敵ほど受けるダメージが大きくなる)。<br><active>ユニーク発動効果 - 三日月:</active> 合計攻撃力の60％～100％を物理ダメージとして周囲の敵ユニットに与える(近くにいる敵ほど受けるダメージが大きくなる)(クールダウン10秒)。<br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.attackDamage(40);
        item.add("なぎ払い", ability -> {
        });
    });

    /** Trinity Force Definition */
    public static final ItemData TrinityForce = new ItemData("Trinity Force", "トリニティ・フォース", 3078, 78, 3703, 2592, new int[] {3086, 3057, 3044}, null, 0, 48, 432, 3, "<stats>攻撃力 +30<br>魔力 +30<br>攻撃速度 +30％<br>クリティカル率 +10％<br>移動速度 +8％<br>ライフ +250<br><mana>マナ +200</mana></stats><br><br><unique>ユニーク自動効果 - 疾風怒濤:</unique> 通常攻撃をすると移動速度が20上昇する。効果は2秒間。敵を倒した場合、移動速度は60上昇する。遠隔攻撃を行うチャンピオンの場合、この移動速度ボーナスは半分になる。<br><unique>ユニーク自動効果 - 追撃:</unique> スキル使用後、次の通常攻撃が命中すると基本攻撃力の200％に等しい物理ダメージボーナスを与える(クールダウン1.5秒)。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackDamage(30);
        item.attackSpeed(30);
        item.critical(10);
        item.abilityPower(30);
        item.health(250);
        item.mana(200);
        item.movementSpeed(8);
        item.add("疾風怒濤", ability -> {
        });
        item.add("追撃", ability -> {
        });
    });

    /** Warden's Mail Definition */
    public static final ItemData WardensMail = new ItemData("Warden's Mail", "番人の鎧", 3082, 450, 1050, 735, new int[] {1029, 1029}, new int[] {3110, 3143}, 0, 96, 432, 2, "<stats>物理防御 +45</stats><br><br><unique>ユニーク自動効果 - 冷たい鋼:</unique> 通常攻撃を受けた際、攻撃者の攻撃速度を15%低下させる。効果は1秒間持続する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.armor(45);
        item.add("冷たい鋼", ability -> {
        });
    });

    /** Warmog's Armor Definition */
    public static final ItemData WarmogsArmor = new ItemData("Warmog's Armor", "ワーモグの鎧", 3083, 300, 2500, 1750, new int[] {3801, 1011, 3801}, null, 0, 144, 432, 3, "<stats>ライフ +800</stats><br><br><unique>ユニーク自動効果:</unique> 8秒間ダメージを受けずにいると、最大ライフ値の1％を5秒ごとに回復する。", item -> {
        item.health(800);
        item.add("8秒間ダメージを受けずにいると、最大ライフ値の1％を5秒ごとに回復する。", ability -> {
        });
    });

    /** Runaan's Hurricane (Ranged Only) Definition */
    public static final ItemData RunaansHurricaneRangedOnly = new ItemData("Runaan's Hurricane (Ranged Only)", "ルナーンのハリケーン(遠隔専用)", 3085, 500, 2500, 1750, new int[] {1042, 1043, 1042}, null, 0, 240, 432, 3, "<stats>攻撃速度 +70％</stats><br><br><unique>自動効果(累積不可):</unique> 通常攻撃時、ターゲットの周囲にいる敵(最大2体)にも矢を放つ。この矢はそれぞれ攻撃力の50％に相当する物理ダメージを与える。それぞれの矢には命中時効果が適用される。<br><unique>自動効果(累積不可):</unique> 通常攻撃に命中時10の物理ダメージボーナス。<br>  ", item -> {
        item.attackSpeed(70);
        item.add("通常攻撃時、ターゲットの周囲にいる敵(最大2体)にも矢を放つ。この矢はそれぞれ攻撃力の50％に相当する物理ダメージを与える。それぞれの矢には命中時効果が適用される。", ability -> {
        });
        item.add("通常攻撃に命中時10の物理ダメージボーナス。<br>  ", ability -> {
        });
    });

    /** Zeal Definition */
    public static final ItemData Zeal = new ItemData("Zeal", "ジール", 3086, 250, 1100, 770, new int[] {1051, 1042}, new int[] {3046, 3078, 3087}, 0, 288, 432, 2, "<stats>攻撃速度 +20％<br>クリティカル率 +10％<br>移動速度 +5％</stats>", item -> {
        item.attackSpeed(20);
        item.critical(10);
        item.movementSpeed(5);
    });

    /** Statikk Shiv Definition */
    public static final ItemData StatikkShiv = new ItemData("Statikk Shiv", "雷剣", 3087, 600, 2500, 1750, new int[] {3086, 3093}, null, 0, 336, 432, 3, "<stats>攻撃速度 +40%<br>クリティカル率 +20%<br>移動速度 +6%</stats><br><br><unique>ユニーク自動効果:</unique> 移動時および攻撃時に帯電が累積する。100チャージが貯まった状態で通常攻撃を命中させると、全チャージを消費して100の魔法ダメージボーナスを最大4体までの標的に与える(クリティカルダメージが発生する可能性あり)。", item -> {
        item.attackSpeed(40);
        item.critical(20);
        item.movementSpeed(6);
        item.add("移動時および攻撃時に帯電が累積する。100チャージが貯まった状態で通常攻撃を命中させると、全チャージを消費して100の魔法ダメージボーナスを最大4体までの標的に与える(クリティカルダメージが発生する可能性あり)。", ability -> {
        });
    });

    /** Rabadon's Deathcap Definition */
    public static final ItemData RabadonsDeathcap = new ItemData("Rabadon's Deathcap", "ラバドンの死の帽子", 3089, 965, 3500, 2450, new int[] {1026, 1058, 1052}, null, 0, 384, 432, 2, "<stats>魔力+120 </stats><br><br><unique>ユニーク自動効果:</unique> 魔力を35%上昇させる。", item -> {
        item.abilityPower(120);
        item.add("魔力を35%上昇させる。", ability -> {
        });
    });

    /** Wit's End Definition */
    public static final ItemData WitsEnd = new ItemData("Wit's End", "究極の答え", 3091, 550, 2600, 1820, new int[] {1043, 1033, 1042}, null, 1, 0, 0, 3, "<stats>攻撃速度 +50%<br>魔法防御 +30</stats><br><br><unique>通常攻撃が命中した際に、42の魔法ダメージボーナスを与える。<br><unique>ユニーク自動効果:</unique> 通常攻撃が命中した際に、対象の魔法防御を5奪う(この効果は5回まで累積する)。", item -> {
        item.attackSpeed(50);
        item.magicRegist(30);
        item.add("通常攻撃が命中した際に、対象の魔法防御を5奪う(この効果は5回まで累積する)。", ability -> {
        });
    });

    /** Frost Queen's Claim Definition */
    public static final ItemData FrostQueensClaim = new ItemData("Frost Queen's Claim", "女王の凍った指先", 3092, 515, 2200, 880, new int[] {3098, 3108}, null, 1, 48, 0, 3, "<stats>魔力 +50<br>クールダウン +10％<br>獲得ゴールド(10秒毎) +2<br><mana>基本マナ自動回復 +50％ (マナ自動回復</mana></stats><br><br><unique>ユニーク自動効果 - 徴収:</unique> チャンピオンまたは建造物に対してスキル攻撃ないし通常攻撃を行うと、15の追加ダメージを与え、10ゴールドを獲得する。この効果は最大で30秒間に3回まで発生する。<br><active>ユニーク発動効果:</active> 氷の槍を発射する。槍は炸裂して周囲の敵に50 + (5 x チャンピオンのレベル) の魔法ダメージを与え、さらに移動速度を80％低下させる。このスロウ効果は2秒間かけて減衰する(クールダウン60秒)。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit>", item -> {
        item.abilityPower(50);
        item.add("徴収", ability -> {
        });
    });

    /** Avarice Blade Definition */
    public static final ItemData AvariceBlade = new ItemData("Avarice Blade", "貪欲の刃", 3093, 400, 800, 320, new int[] {1051}, new int[] {3087, 3142}, 1, 96, 0, 2, "<stats>クリティカル率 +10%</stats><br><br><unique>ユニーク自動効果 - 強欲:</unique> ゴールド(毎10秒) +3<br><unique>ユニーク自動効果 - 金銭欲:</unique> ユニットを1体倒すたびに2ゴールドを獲得する。<br><br><groupLimit>他の金策アイテムに加えて購入可能</groupLimit>", item -> {
        item.critical(10);
        item.add("強欲", ability -> {
        });
        item.add("金銭欲", ability -> {
        });
    });

    /** Nomad's Medallion Definition */
    public static final ItemData NomadsMedallion = new ItemData("Nomad's Medallion", "放浪民のメダル", 3096, 500, 865, 346, new int[] {3301}, new int[] {3069}, 1, 144, 0, 2, "<stats>基本ライフ自動回復 +25％ (ライフ自動回復<br><mana>基本マナ自動回復 +50％ (マナ自動回復<br></mana>移動速度 +10<br>獲得ゴールド(10秒毎) +2</stats><br><br><unique>ユニーク自動効果 - 恩寵:</unique> 自らとどめを刺すことなく周囲でミニオンが倒れると、4ゴールドを獲得し、ライフも10回復する。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit><br><br><i><font color='#447777'>「そのメダルは陽光を浴びると、誰もが讃える輝きを放つという」－歴史家シュレリア、CLE24年6月22日</font></i><br><br>", item -> {
        item.add("恩寵", ability -> {
        });
    });

    /** Targon's Brace Definition */
    public static final ItemData TargonsBrace = new ItemData("Targon's Brace", "ターゴンの腕輪", 3097, 500, 865, 346, new int[] {3302}, new int[] {3401}, 1, 192, 0, 2, "<stats>ライフ +175<br>基本ライフ自動回復 +50％ (ライフ自動回復</stats><br><br><unique>ユニーク自動効果 - 戦場の略奪:</unique> 近接の通常攻撃で、ライフが240未満のミニオンに対しとどめを刺す。ミニオンを倒すと、自分ともっとも自分の近くにいる味方のチャンピオンのライフが50回復し、ミニオンを倒した際の獲得ゴールドと同じ額が味方のチャンピオンにも与えられる。<br><br>これらの効果は周囲に最低1人の味方のチャンピオンがいなければ発生しない。チャージは30秒ごとに発生し、最大3チャージまで蓄積する。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit>", item -> {
        item.health(175);
        item.add("戦場の略奪", ability -> {
        });
    });

    /** Frostfang Definition */
    public static final ItemData Frostfang = new ItemData("Frostfang", "白霜の牙", 3098, 500, 865, 346, new int[] {3303}, new int[] {3092}, 1, 240, 0, 2, "<stats>魔力 +10<br>獲得ゴールド(10秒毎) +2<br><mana>基本マナ自動回復 +50％ (マナ自動回復</mana></stats><br><br><unique>ユニーク自動効果 - 徴収:</unique> チャンピオンまたは建造物に対してスキル攻撃ないし通常攻撃を行うと、15の追加ダメージを与え、10ゴールドを獲得する。この効果は最大で30秒間に3回まで発生する。ミニオンを倒すと、この自動効果は12秒にわたって発生しなくなる。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit></i>", item -> {
        item.abilityPower(10);
        item.add("徴収", ability -> {
        });
    });

    /** Lich Bane Definition */
    public static final ItemData LichBane = new ItemData("Lich Bane", "死神殺しの双剣", 3100, 950, 3000, 2100, new int[] {3057, 3113}, null, 1, 288, 0, 3, "<stats>魔力 +80<br>移動速度 +5％<br><mana>マナ +250</mana></stats><br><br><unique>ユニーク自動効果 - 追撃:</unique> スキル使用後、次の通常攻撃が命中すると、基本攻撃力の75％に魔力の50％を加えた値に等しい魔法ダメージボーナスを与える(クールダウン1.5秒)。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.abilityPower(80);
        item.mana(250);
        item.movementSpeed(5);
        item.add("追撃", ability -> {
        });
    });

    /** Stinger Definition */
    public static final ItemData Stinger = new ItemData("Stinger", "刺剣", 3101, 350, 1250, 875, new int[] {1042, 1042}, new int[] {3115, 3172, 3137}, 1, 336, 0, 2, "<stats>攻撃速度 +40%</stats><br><br><unique>ユニーク自動効果:</unique> クールダウン +10%", item -> {
        item.attackSpeed(40);
        item.add("クールダウン +10%", ability -> {
        });
    });

    /** Banshee's Veil Definition */
    public static final ItemData BansheesVeil = new ItemData("Banshee's Veil", "バンシーのヴェール", 3102, 1150, 2750, 1925, new int[] {3211, 1028}, null, 1, 384, 0, 3, "<stats>ライフ +450<br>魔法防御 +55<br>基本ライフ自動回復 +100％ (ライフ自動回復</stats><br><br><unique>ユニーク自動効果:</unique> 次の敵スキルをガードするスキル無効化の護りを展開する。このシールドは敵のチャンピオンからダメージを受けないまま40秒経つと、再展開する。", item -> {
        item.health(450);
        item.magicRegist(55);
        item.add("次の敵スキルをガードするスキル無効化の護りを展開する。このシールドは敵のチャンピオンからダメージを受けないまま40秒経つと、再展開する。", ability -> {
        });
    });

    /** Aegis of the Legion Definition */
    public static final ItemData AegisoftheLegion = new ItemData("Aegis of the Legion", "イージスの盾", 3105, 820, 1900, 1330, new int[] {1028, 1033, 1006}, new int[] {3190, 3060}, 1, 0, 48, 2, "<stats>ライフ +200<br>魔法防御 +20</stats><br><br><aura>オーラ(累積不可) - 精兵:</aura> 周囲の味方は、魔法防御 +20、基本ライフ自動回復 +75％を得る。<br><br><i>(同名のオーラは累積不可。)</i>", item -> {
        item.health(200);
        item.magicRegist(20);
    });

    /** Madred's Razors Definition */
    public static final ItemData MadredsRazors = new ItemData("Madred's Razors", "マッドレッドの鉤爪", 3106, 300, 750, 525, new int[] {1042}, new int[] {3154, 3159}, 1, 48, 48, 2, "<stats>攻撃速度 +15％</stats><br><br><unique>ユニーク自動効果 - たたみ掛け:</unique>中立モンスターに対する通常攻撃に50の魔法ダメージボーナスがつき、命中時にライフを8回復する。<br><br><i>(同名のユニーク自動効果はスタックしない。)</i>", item -> {
        item.attackSpeed(15);
        item.add("たたみ掛け", ability -> {
        });
    });

    /** Fiendish Codex Definition */
    public static final ItemData FiendishCodex = new ItemData("Fiendish Codex", "悪魔の古書", 3108, 385, 820, 574, new int[] {1052}, new int[] {3174, 3092, 3115, 3023, 3165, 3152, 3060, 3290}, 1, 96, 48, 2, "<stats>魔力 +30</stats><br><br><unique>ユニーク自動効果:</unique> クールダウン +10％", item -> {
        item.abilityPower(30);
        item.add("クールダウン +10％", ability -> {
        });
    });

    /** Frozen Heart Definition */
    public static final ItemData FrozenHeart = new ItemData("Frozen Heart", "凍れる心臓", 3110, 450, 2450, 1715, new int[] {3082, 3024}, null, 1, 144, 48, 3, "<stats>物理防御 +100<br>クールダウン +20％<br><mana>マナ +400</mana></stats><br><br><aura>ユニークオーラ:</aura> 周囲の敵の攻撃速度を15％低下させる。", item -> {
        item.mana(400);
        item.armor(100);
    });

    /** Mercury's Treads Definition */
    public static final ItemData MercurysTreads = new ItemData("Mercury's Treads", "マーキュリーの靴", 3111, 375, 1200, 840, new int[] {1001, 1033}, new int[] {1321, 1323, 1320, 1322, 1324}, 1, 192, 48, 2, "<stats>魔法防御 +25</stats><br><br><unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +45<br><unique>ユニーク自動効果 - 根性:</unique> スタン、スロウ、挑発、恐怖、沈黙、目つぶし、変身、移動不能の持続時間を35%短縮する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.magicRegist(25);
        item.add("移動速度強化", ability -> {
        });
        item.add("根性", ability -> {
        });
    });

    /** Aether Wisp Definition */
    public static final ItemData AetherWisp = new ItemData("Aether Wisp", "鬼火", 3113, 415, 850, 595, new int[] {1052}, new int[] {3023, 3290, 3100, 3285, 3286, 3504}, 1, 288, 48, 2, "<stats>魔力 +30</stats><br><br><unique>ユニーク自動効果:</unique> 移動速度 +5%", item -> {
        item.abilityPower(30);
        item.add("移動速度 +5%", ability -> {
        });
    });

    /** Forbidden Idol Definition */
    public static final ItemData ForbiddenIdol = new ItemData("Forbidden Idol", "禁じられた偶像", 3114, 240, 600, 420, new int[] {1004, 1004}, new int[] {3069, 3165, 3222, 3504}, 1, 336, 48, 2, "<stats><mana>基本マナ自動回復 +50％ (マナ自動回復</mana></stats><br><br><unique>ユニーク自動効果:</unique> クールダウン +10％", item -> {
        item.add("クールダウン +10％", ability -> {
        });
    });

    /** Nashor's Tooth Definition */
    public static final ItemData NashorsTooth = new ItemData("Nashor's Tooth", "ナッシャーの歯牙", 3115, 930, 3000, 2100, new int[] {3101, 3108}, null, 1, 384, 48, 3, "<stats>攻撃速度 +40%<br>魔力 +80</stats><br><br><unique>ユニーク自動効果:</unique> クールダウン +20%<br><unique>ユニーク自動効果:</unique> 通常攻撃は命中時に15 (+魔力の15%)の魔法ダメージボーナスを与える。<br>", item -> {
        item.attackSpeed(40);
        item.abilityPower(80);
        item.add("クールダウン +20%", ability -> {
        });
        item.add("通常攻撃は命中時に15 (+魔力の15%)の魔法ダメージボーナスを与える。<br>", ability -> {
        });
    });

    /** Rylai's Crystal Scepter Definition */
    public static final ItemData RylaisCrystalScepter = new ItemData("Rylai's Crystal Scepter", "リーライのクリスタル権杖", 3116, 315, 3000, 2100, new int[] {1058, 1052, 1011}, null, 1, 432, 48, 3, "<stats>ライフ +400<br>魔力 +100</stats><br><br><unique>ユニーク自動効果:</unique> スキルダメージを与えると標的の移動速度が1.5秒にわたって40%低下する(複数対象および継続ダメージのスキルであれば20%)", item -> {
        item.abilityPower(100);
        item.health(400);
        item.add("スキルダメージを与えると標的の移動速度が1.5秒にわたって40%低下する(複数対象および継続ダメージのスキルであれば20%)", ability -> {
        });
    });

    /** Boots of Mobility Definition */
    public static final ItemData BootsofMobility = new ItemData("Boots of Mobility", "踏破のブーツ", 3117, 475, 800, 560, new int[] {1001}, new int[] {1326, 1328, 1325, 1327, 1329}, 1, 0, 96, 2, "<unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +25。5秒にわたって戦闘を行わなければ、移動速度ボーナスは+105になる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("移動速度強化", ability -> {
        });
    });

    /** Guinsoo's Rageblade Definition */
    public static final ItemData GuinsoosRageblade = new ItemData("Guinsoo's Rageblade", "グインソーの荒ぶる刃", 3124, 865, 2590, 1813, new int[] {1026, 1037}, null, 1, 96, 96, 2, "<stats>攻撃力 +30<br>魔力 +40</stats><br><br><passive>自動効果:</passive> 通常攻撃(攻撃時)と呪文使用時に、攻撃速度 +4%と魔力 +4の効果が8秒にわたって発生する(最大8回まで累積)<br><unique>ユニーク自動効果:</unique> ライフが残り50%を切ると、攻撃速度 +20%、物理吸命 +10%、魔法吸命 +10%を獲得する。この効果は戦闘状態から離脱するまで続く(クールダウン30秒)。", item -> {
        item.attackDamage(30);
        item.abilityPower(40);
        item.add("ライフが残り50%を切ると、攻撃速度 +20%、物理吸命 +10%、魔法吸命 +10%を獲得する。この効果は戦闘状態から離脱するまで続く(クールダウン30秒)。", ability -> {
        });
    });

    /** The Brutalizer Definition */
    public static final ItemData TheBrutalizer = new ItemData("The Brutalizer", "ブルータライザー", 3134, 617, 1337, 936, new int[] {1036, 1036}, new int[] {3142, 3707, 3714, 3719, 3723}, 1, 144, 96, 2, "<stats>攻撃力+25</stats><br><br><unique>ユニーク自動効果:</unique> クールダウン+10%<br><unique>ユニーク自動効果:</unique>物理防御貫通 +10<br><br><i>(物理防御貫通: 対象の物理防御を物理防御貫通の値だけ無視することによって、物理ダメージが多く与えられる)</i>", item -> {
        item.attackDamage(25);
        item.add("クールダウン+10%", ability -> {
        });
        item.add("物理防御貫通 +10<br><br>(物理防御貫通: 対象の物理防御を物理防御貫通の値だけ無視することによって、物理ダメージが多く与えられる)", ability -> {
        });
    });

    /** Void Staff Definition */
    public static final ItemData VoidStaff = new ItemData("Void Staff", "ヴォイドの杖", 3135, 1215, 2500, 1750, new int[] {1026, 1052}, null, 1, 192, 96, 2, "<stats>魔力 +80</stats><br><br><unique>ユニーク自動効果:</unique> 魔法ダメージが標的の魔法防御の35%を無視する(魔法防御貫通の前に適用される)", item -> {
        item.abilityPower(80);
        item.add("魔法ダメージが標的の魔法防御の35%を無視する(魔法防御貫通の前に適用される)", ability -> {
        });
    });

    /** Haunting Guise Definition */
    public static final ItemData HauntingGuise = new ItemData("Haunting Guise", "悲愴な仮面", 3136, 665, 1500, 1050, new int[] {1028, 1052}, new int[] {3151}, 1, 240, 96, 2, "<stats>魔力 +25<br>ライフ +200</stats><br><br><unique>ユニーク自動効果 - 苦痛の邪眼:</unique> 魔法防御貫通 +15<br><br><i>(魔法防御貫通: 対象の魔法防御を魔法防御貫通の値だけ無視することによって、魔法ダメージが多く与えられる)</i><br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.abilityPower(25);
        item.health(200);
        item.add("苦痛の邪眼", ability -> {
        });
    });

    /** Mercurial Scimitar Definition */
    public static final ItemData MercurialScimitar = new ItemData("Mercurial Scimitar", "水銀の三日月刀", 3139, 900, 3700, 2590, new int[] {1038, 3140}, null, 1, 336, 96, 3, "<stats>攻撃力+80<br>魔法防御 +35</stats><br><br><active>ユニーク発動効果 - 水銀:</active> 弱体化をすべて解除し、移動速度ボーナス+50%の効果が1秒にわたって発生する(クールダウン90秒)。", item -> {
        item.attackDamage(80);
        item.magicRegist(35);
    });

    /** Quicksilver Sash Definition */
    public static final ItemData QuicksilverSash = new ItemData("Quicksilver Sash", "水銀の腰帯", 3140, 750, 1250, 875, new int[] {1033}, new int[] {3139, 3137}, 1, 384, 96, 2, "<stats>魔法防御 +30</stats><br><br><active>ユニーク発動効果 - 水銀:</active> 行動妨害をすべて解除する(クールダウン90秒)。", item -> {
        item.magicRegist(30);
    });

    /** Sword of the Occult Definition */
    public static final ItemData SwordoftheOccult = new ItemData("Sword of the Occult", "秘境の魔剣", 3141, 1040, 1400, 980, new int[] {1036}, null, 1, 432, 96, 2, "<stats>攻撃力 +10</stats><br><br><unique>ユニーク自動効果:</unique> 1累積につき攻撃力5上昇。初回購入時には5累積を得る。1キルごとに2累積、1アシストごとに1累積を獲得(最大20累積)。死亡すると累積数の半分を失う。20累積した状態では移動速度が20％上昇する。", item -> {
        item.attackDamage(10);
        item.add("1累積につき攻撃力5上昇。初回購入時には5累積を得る。1キルごとに2累積、1アシストごとに1累積を獲得(最大20累積)。死亡すると累積数の半分を失う。20累積した状態では移動速度が20％上昇する。", ability -> {
        });
    });

    /** Youmuu's Ghostblade Definition */
    public static final ItemData YoumuusGhostblade = new ItemData("Youmuu's Ghostblade", "妖夢の霊剣", 3142, 563, 2700, 1890, new int[] {3093, 3134}, null, 1, 0, 144, 3, "<stats>攻撃力 +30<br>クリティカル率 +15%<br>クールダウン +10%</stats><br><br><passive>ユニーク自動効果:</passive> 物理防御貫通 +20</passive><br><active>ユニーク発動効果:</active> 移動速度 +20%と攻撃速度 +40%の効果が6秒にわたって発生する(クールダウン45秒)。<br><br><i>(物理防御貫通: 対象の物理防御を物理防御貫通の値だけ無視することによって、物理ダメージが多く与えられる)</i>", item -> {
        item.attackDamage(30);
        item.critical(15);
    });

    /** Randuin's Omen Definition */
    public static final ItemData RanduinsOmen = new ItemData("Randuin's Omen", "ランデュインの白盾", 3143, 800, 2850, 1995, new int[] {3082, 1011}, null, 1, 48, 144, 3, "<stats>ライフ +500<br>物理防御 +70</stats><br><br><unique>自動効果(累積不可) - 冷たい鋼:</unique> 通常攻撃を受けた時、攻撃者の攻撃速度を15％低下させる。<br><active>発動効果(累積不可):</active> 周囲の敵ユニットの移動速度を35％低下させる。効果は2秒間(物理防御200ごとに+1秒、魔法防御200ごとに+1秒)(クールダウン60秒)。<br><br><i>(同名の自動効果は累積不可。)</i>", item -> {
        item.health(500);
        item.armor(70);
        item.add("冷たい鋼", ability -> {
        });
    });

    /** Bilgewater Cutlass Definition */
    public static final ItemData BilgewaterCutlass = new ItemData("Bilgewater Cutlass", "ビルジウォーターの海賊刀", 3144, 240, 1400, 980, new int[] {1036, 1053}, new int[] {3146, 3153}, 1, 96, 144, 3, "<stats>攻撃力 +25<br>物理吸命 +8%</stats><br><br><active>ユニーク発動効果:</active> 100の魔法ダメージを与え、対象チャンピオンの移動速度を25%低下させる。効果は2秒間(クールダウン90秒)。", item -> {
        item.attackDamage(25);
        item.lifeSteal(8);
    });

    /** Hextech Revolver Definition */
    public static final ItemData HextechRevolver = new ItemData("Hextech Revolver", "ヘクステック・リボルバー", 3145, 330, 1200, 840, new int[] {1052, 1052}, new int[] {3146, 3152}, 1, 144, 144, 2, "<stats>魔力 +40</stats><br><br><unique>ユニーク自動効果:</unique> 魔法吸命 +12%<br><br><i>(魔法吸命: スキルで与えたダメージの一定割合をライフとして回復する。範囲効果呪文は魔法吸命の効果が3分の1になる)</i>", item -> {
        item.abilityPower(40);
        item.add("魔法吸命 +12%<br><br>(魔法吸命: スキルで与えたダメージの一定割合をライフとして回復する。範囲効果呪文は魔法吸命の効果が3分の1になる)", ability -> {
        });
    });

    /** Hextech Gunblade Definition */
    public static final ItemData HextechGunblade = new ItemData("Hextech Gunblade", "ヘクステック・ガンブレード", 3146, 800, 3400, 2380, new int[] {3144, 3145}, null, 1, 192, 144, 4, "<stats>攻撃力 +40<br>魔力 +80<br>物理吸命 +10%</stats><br><br><unique>ユニーク自動効果:</unique> 魔法吸命 +20%<br><unique>ユニーク自動効果:</unique> 敵のチャンピオンに通常攻撃を命中させるか単体攻撃スキルを使用すると、このアイテムのクールダウンが3秒短縮される。<br><active>ユニーク発動効果:</active> 150 (+魔力の40%)の魔法ダメージを与え、対象チャンピオンの移動速度を40%低下させる。効果は2秒間(クールダウン60秒)。<br><br><i>(魔法吸命: スキルで与えたダメージの一定割合をライフとして回復する。範囲効果スキルは魔法吸命の効果が3分の1になる)</i>", item -> {
        item.attackDamage(40);
        item.lifeSteal(10);
        item.abilityPower(80);
        item.add("魔法吸命 +20%", ability -> {
        });
        item.add("敵のチャンピオンに通常攻撃を命中させるか単体攻撃スキルを使用すると、このアイテムのクールダウンが3秒短縮される。<br>", ability -> {
        });
    });

    /** Liandry's Torment Definition */
    public static final ItemData LiandrysTorment = new ItemData("Liandry's Torment", "ライアンドリーの苦悶", 3151, 650, 3000, 2100, new int[] {3136, 1026}, null, 1, 240, 144, 3, "<stats>魔力 +80<br>ライフ +300</stats><br><br><unique>ユニーク自動効果 - 苦痛の邪眼:</unique> +15魔法防御貫通<br><unique>ユニーク自動効果:</unique> スキルダメージを与えると同時に3秒間の継続ダメージ効果も付与する。この効果は対象のライフ現在値の2%に等しい魔法ダメージを毎秒与える。この継続ダメージは、移動制限を受けているユニットに対しては2倍に増加するが、モンスターに対しては毎秒100までしかダメージを与えられない。<br><br><i>(移動制限とは、スロウ、スタン、挑発、恐怖、または移動不能の状態を指す)</i><br><br><i>(魔法防御貫通: 対象の魔法防御を魔法防御貫通の値だけ無視し、与える魔法ダメージが増加する)</i><br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.abilityPower(80);
        item.health(300);
        item.add("苦痛の邪眼", ability -> {
        });
        item.add("スキルダメージを与えると同時に3秒間の継続ダメージ効果も付与する。この効果は対象のライフ現在値の2%に等しい魔法ダメージを毎秒与える。この継続ダメージは、移動制限を受けているユニットに対しては2倍に増加するが、モンスターに対しては毎秒100までしかダメージを与えられない。<br><br>(移動制限とは、スロウ、スタン、挑発、恐怖、または移動不能の状態を指す)<br><br>(魔法防御貫通: 対象の魔法防御を魔法防御貫通の値だけ無視し、与える魔法ダメージが増加する)<br><br>(同名のユニーク自動効果は累積しない)", ability -> {
        });
    });

    /** Will of the Ancients Definition */
    public static final ItemData WilloftheAncients = new ItemData("Will of the Ancients", "古代人の遺志", 3152, 480, 2500, 1750, new int[] {3145, 3108}, null, 1, 288, 144, 3, "<stats>魔力 +80<br>クールダウン +10％</stats><br><br><unique>ユニーク自動効果:</unique> 魔法吸命 +20％<br><br><i>(魔法吸命: スキルで与えたダメージの一定割合を、自分のライフとして回復する。範囲効果スキルの場合は、魔法吸命の効果は3分の1となる。)</i>", item -> {
        item.abilityPower(80);
        item.add("魔法吸命 +20％<br><br>(魔法吸命: スキルで与えたダメージの一定割合を、自分のライフとして回復する。範囲効果スキルの場合は、魔法吸命の効果は3分の1となる。)", ability -> {
        });
    });

    /** Blade of the Ruined King Definition */
    public static final ItemData BladeoftheRuinedKing = new ItemData("Blade of the Ruined King", "失墜の王剣", 3153, 700, 3200, 2240, new int[] {3144, 1043}, null, 1, 336, 144, 4, "<stats>攻撃力 +25<br>攻撃速度 +40％<br>物理吸命 +10％</stats><br><br><unique>ユニーク自動効果:</unique> 通常攻撃が命中すると、対象の現在ライフ値の8％を物理ダメージボーナスとして与える(モンスター/ミニオンに対しては最大60まで)。<br><active>ユニーク発動効果:</active> 対象チャンピオンの最大ライフ値の10％(最小100)を物理ダメージとして与え、同量を自分のライフとして回復し、標的の移動速度を3秒にわたって25％低下させる(クールダウン90秒)。", item -> {
        item.attackDamage(25);
        item.attackSpeed(40);
        item.lifeSteal(10);
        item.add("通常攻撃が命中すると、対象の現在ライフ値の8％を物理ダメージボーナスとして与える(モンスター/ミニオンに対しては最大60まで)。<br>", ability -> {
        });
    });

    /** Wriggle's Lantern Definition */
    public static final ItemData WrigglesLantern = new ItemData("Wriggle's Lantern", "リグルのランタン", 3154, 215, 1775, 710, new int[] {3106, 1036, 1042}, null, 1, 384, 144, 3, "<stats>攻撃力 +12<br>攻撃速度 +30%</stats><br><br><unique>ユニーク自動効果 - えぐり取る:</unique> モンスターに対する通常攻撃が命中すると、75の魔法ダメージボーナスを与え、10ライフを回復する。<br><unique>ユニーク自動効果:</unique> モンスターから獲得できるゴールドが30%増加する。<br><active>ユニーク発動効果:</active> <font color='#BBFFFF'>ステルスワード</font>1個を設置する。これは周囲エリアの視界を180秒にわたって確保する(クールダウン180秒)。<br><br>キル、アシスト、大型モンスターキルが合計30キルに達すると、野獣の灯火に変化する。<br><i>(ハンターのマチェットまたはマッドレッドの鉤爪で殺したチャンピオンおよびモンスターは、必要なキル数にカウントされる)</i><br><br><groupLimit>金策アイテムは1個しか持てない</groupLimit>", item -> {
        item.attackDamage(12);
        item.attackSpeed(30);
        item.add("えぐり取る", ability -> {
        });
        item.add("モンスターから獲得できるゴールドが30%増加する。<br>", ability -> {
        });
    });

    /** Hexdrinker Definition */
    public static final ItemData Hexdrinker = new ItemData("Hexdrinker", "呪飲の剣", 3155, 590, 1450, 1015, new int[] {1036, 1033}, new int[] {3156}, 1, 432, 144, 2, "<stats>攻撃力 +25<br>魔法防御 +30</stats><br><br><unique>ユニーク自動効果 - ライフライン:</unique> ライフが残り30%未満になるような魔法ダメージを受けた時、自身にシールドを付与する。このシールドは250魔法ダメージを5秒にわたって吸収する(クールダウン90秒)。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.attackDamage(25);
        item.magicRegist(30);
        item.add("ライフライン", ability -> {
        });
    });

    /** Maw of Malmortius Definition */
    public static final ItemData MawofMalmortius = new ItemData("Maw of Malmortius", "マルモルティウスの胃袋", 3156, 875, 3200, 2240, new int[] {3155, 1037}, null, 1, 0, 192, 3, "<stats>攻撃力 +60<br>魔法防御 +40</stats><br><br><unique>ユニーク自動効果:</unique> 失ったライフの量に応じて攻撃力が上昇(ライフ最大値の2％ごとに攻撃力 +1 )。増加する攻撃力は最大で35。<br><unique>ユニーク自動効果 - ライフライン: </unique>魔法ダメージを受け、そのダメージによりライフが最大値の30％未満になる場合、5秒間魔法ダメージを90吸収するシールドを得る(クールダウン90秒)。<br><br><i>(同名のユニーク自動効果はスタックしない。)</i>", item -> {
        item.attackDamage(60);
        item.magicRegist(40);
        item.add("失ったライフの量に応じて攻撃力が上昇(ライフ最大値の2％ごとに攻撃力 +1 )。増加する攻撃力は最大で35。", ability -> {
        });
        item.add("ライフライン", ability -> {
        });
    });

    /** Zhonya's Hourglass Definition */
    public static final ItemData ZhonyasHourglass = new ItemData("Zhonya's Hourglass", "ゾーニャの砂時計", 3157, 550, 3000, 2100, new int[] {3191, 1058}, null, 1, 48, 192, 3, "<stats>魔力 +100<br>物理防御 +50</stats><br><br><active>ユニーク発動効果 - 停滞:</active> 自身が無敵状態になり、敵からターゲット不能になる。効果は2.5秒間。この間、自分は移動、攻撃、呪文使用、アイテム使用ができなくなる(クールダウン90秒)。", item -> {
        item.abilityPower(100);
        item.armor(50);
    });

    /** Ionian Boots of Lucidity Definition */
    public static final ItemData IonianBootsofLucidity = new ItemData("Ionian Boots of Lucidity", "アイオニアブーツ", 3158, 675, 1000, 700, new int[] {1001}, new int[] {1331, 1333, 1330, 1332, 1334}, 1, 96, 192, 2, "<unique>ユニーク自動効果:</unique> クールダウン +@Effect8Amount*-100@％<br><unique>ユニーク自動効果 - 移動速度強化:</unique> 移動速度 +45<br><br><i>(同名のユニーク自動効果は累積しない)</i><br><br><i><font color='#FDD017'>「このアイテムはCLE20年12月10日、南方諸州の領有権をめぐる再戦において、アイオニアがノクサスに対して収めた勝利を称えるものである」</font></i>", item -> {
        item.add("クールダウン +@Effect8Amount*-100@％", ability -> {
        });
        item.add("移動速度強化", ability -> {
        });
    });

    /** Morellonomicon Definition */
    public static final ItemData Morellonomicon = new ItemData("Morellonomicon", "モレロの死書", 3165, 445, 2300, 1610, new int[] {3108, 3114, 1052}, null, 1, 192, 192, 3, "<stats>魔力 +80<br>クールダウン +20％<br><mana>基本マナ自動回復 +100％ (マナ自動回復</mana></stats><br><br><unique>ユニーク自動効果:</unique> ライフが残り40％未満の敵のチャンピオンに魔法ダメージを与えると、4秒にわたって「重傷」を付与する。<br><br><i>(重傷は自分が受ける回復効果と再生効果を半減させる。)</i>", item -> {
        item.abilityPower(80);
        item.add("ライフが残り40％未満の敵のチャンピオンに魔法ダメージを与えると、4秒にわたって「重傷」を付与する。<br><br>(重傷は自分が受ける回復効果と再生効果を半減させる。)", ability -> {
        });
    });

    /** Zephyr Definition */
    public static final ItemData Zephyr = new ItemData("Zephyr", "ゼピュロス", 3172, 725, 2850, 1995, new int[] {3101, 1037}, null, 1, 48, 240, 3, "<stats>攻撃力 +25<br>攻撃速度 +50％<br>移動速度 +10％<br>クールダウン +10％</stats><br><br><unique>ユニーク自動効果 - 根性:</unique> スタン、スロウ、挑発、恐怖、沈黙、目つぶし、変身、移動不能の持続時間を35％短縮する。<br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.attackDamage(25);
        item.attackSpeed(50);
        item.movementSpeed(10);
        item.add("根性", ability -> {
        });
    });

    /** Athene's Unholy Grail Definition */
    public static final ItemData AthenesUnholyGrail = new ItemData("Athene's Unholy Grail", "アテネの血杯", 3174, 545, 2700, 1890, new int[] {3108, 3028, 1052}, null, 1, 96, 240, 3, "<stats>魔力 +60<br>魔法防御 +25<br>クールダウン +20％<br><mana>基本マナ自動回復 +100％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果:</unique> キル/アシスト時にマナが最大値の30％回復する。<br><unique>ユニーク自動効果 - マナの泉:</unique> 5秒ごとに失ったマナの2％を回復する。<br></mana><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.abilityPower(60);
        item.magicRegist(25);
        item.add("キル/アシスト時にマナが最大値の30％回復する。", ability -> {
        });
        item.add("マナの泉", ability -> {
        });
    });

    /** Locket of the Iron Solari Definition */
    public static final ItemData LocketoftheIronSolari = new ItemData("Locket of the Iron Solari", "ソラリのペンダント", 3190, 50, 2800, 1960, new int[] {3105, 3067}, null, 1, 432, 240, 3, "<stats>ライフ +400<br>魔法防御 +20<br>クールダウン +10％</stats><br><br><active>ユニーク発動効果:</active> 周囲の味方にシールドを付与する。シールドは5秒間、最大50 + (10 x チャンピオンのレベル) までのダメージを吸収する(クールダウン60秒)。<br><aura>ユニークオーラ - 精兵:</aura> 周囲の味方に魔法防御20と75％の基本ライフ自動回復を付与する。<br><br><i>(同名のユニークオーラは累積しない)", item -> {
        item.health(400);
        item.magicRegist(20);
    });

    /** Seeker's Armguard Definition */
    public static final ItemData SeekersArmguard = new ItemData("Seeker's Armguard", "探究者の腕甲", 3191, 465, 1200, 840, new int[] {1029, 1052}, new int[] {3090, 3157, 3170}, 1, 0, 288, 2, "<stats>物理防御 +30<br>魔力 +25</stats><br><br><passive>ユニーク自動効果:</passive> ユニット1体をキルするごとに物理防御と魔力がそれぞれ0.5上昇する。このボーナスは最大30回まで累積する。", item -> {
        item.abilityPower(25);
        item.armor(30);
    });

    /** The Hex Core mk-1 Definition */
    public static final ItemData TheHexCoremk1 = new ItemData("The Hex Core mk-1", "ヘクスコアMK-1", 3196, 1000, 1000, 700, new int[] {3200}, new int[] {3197}, 1, 48, 288, 2, "<stats>魔力 +(4 x チャンピオンのレベル)<br>魔力 +20<br>マナ +150</stats><br><br><unique>ユニーク自動効果 - スキル増強:</unique> ヴィクターは基本スキルのうち1つをアップグレードできる。", item -> {
        item.abilityPower(20);
        item.mana(150);
        item.add("スキル増強", ability -> {
        });
    });

    /** The Hex Core mk-2 Definition */
    public static final ItemData TheHexCoremk2 = new ItemData("The Hex Core mk-2", "ヘクスコアMK-2", 3197, 1000, 2000, 1400, new int[] {3196}, new int[] {3198}, 1, 96, 288, 3, "<stats>魔力 +(5 x チャンピオンのレベル)<br>魔力 +40<br>マナ +300</stats><br><br><unique>ユニーク自動効果 - スキル増強:</unique> ヴィクターは基本スキルのうち1つをアップグレードできる。", item -> {
        item.abilityPower(40);
        item.mana(300);
        item.add("スキル増強", ability -> {
        });
    });

    /** Perfect Hex Core Definition */
    public static final ItemData PerfectHexCore = new ItemData("Perfect Hex Core", "究極のヘクスコア", 3198, 1000, 3000, 2100, new int[] {3197}, null, 1, 144, 288, 4, "<stats>魔力 +(6 x チャンピオンのレベル)<br>魔力 +60<br>マナ +500</stats><br><br><passive>ユニーク自動効果 - グロリアス・エヴォリューション:</unique> ヴィクターの力が最高潮にまで達し、通常のスキルに加え「カオスストーム」もアップグレードできる。", item -> {
        item.abilityPower(60);
        item.mana(500);
    });

    /** Prototype Hex Core Definition */
    public static final ItemData PrototypeHexCore = new ItemData("Prototype Hex Core", "プロトタイプ・ヘクスコア", 3200, 0, 0, 0, null, new int[] {3196}, 1, 192, 288, 0, "<stats>魔力 +(3 x チャンピオンのレベル)</stats><br><br><passive>ユニーク自動効果 - スキル増強:</passive> このアイテムは3回までアップグレードが可能。アップグレードをすることでヴィクターの基本スキルを強化できる。", item -> {
    });

    /** Spectre's Cowl Definition */
    public static final ItemData SpectresCowl = new ItemData("Spectre's Cowl", "死霊の頭巾", 3211, 300, 1200, 840, new int[] {1028, 1033}, new int[] {3065, 3102}, 1, 240, 288, 2, "<stats>ライフ +200<br>魔法防御 +35</stats><br><br><unique>ユニーク自動効果:</unique> 敵のチャンピオンからダメージを受けると基本ライフ自動回復150％を10秒間得る。<br><br>", item -> {
        item.health(200);
        item.magicRegist(35);
        item.add("敵のチャンピオンからダメージを受けると基本ライフ自動回復150％を10秒間得る。<br><br>", ability -> {
        });
    });

    /** Mikael's Crucible Definition */
    public static final ItemData MikaelsCrucible = new ItemData("Mikael's Crucible", "ミカエルのるつぼ", 3222, 950, 2450, 1715, new int[] {3028, 3114}, null, 1, 288, 288, 3, "<stats>魔法防御 +40<br>クールダウン +10％<br><mana>基本マナ自動回復 +100％ (マナ自動回復</mana></stats><br><br><mana><unique>ユニーク自動効果 - マナの泉:</unique> 5秒ごとに失ったマナの2％を回復する。</mana><br><active>ユニーク発動効果:</active> 味方のチャンピオン1体からスタン、移動不能、挑発、恐怖、沈黙、スロウの効果をすべて取り除き、そのチャンピオンのライフを150 (+ライフ最大値の10％) 回復する(クールダウン180秒)。<br><br><i>(同名のユニーク自動効果は累積しない。)</i>", item -> {
        item.magicRegist(40);
        item.add("マナの泉", ability -> {
        });
    });

    /** Enchantment: Furor Definition */
    public static final ItemData EnchantmentFuror = new ItemData("Enchantment: Furor", "追加特性: 憤怒", 3240, 475, 475, 333, null, null, 3, 240, 0, 0, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「憤怒」の効果を付ける。<br><br><unique>ユニーク自動効果 - 憤怒:</unique> 単体対象のスキル/攻撃が(命中して)ダメージを与えると、移動速度が12％上昇する。この効果は2秒間かけて減衰する。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("憤怒", ability -> {
        });
    });

    /** Enchantment: Alacrity Definition */
    public static final ItemData EnchantmentAlacrity = new ItemData("Enchantment: Alacrity", "追加特性: 疾風", 3241, 475, 475, 333, null, null, 3, 288, 0, 0, "<groupLimit>Limited to 1 of each enchantment type.</groupLimit><br>Enchants boots to have Alacrity bonus. <br><br><unique>UNIQUE Passive - Alacrity:</unique> +20 Movement Speed<br><br><i>(Unique Passives with the same name don't stack.)</i>", item -> {
        item.add("Alacrity", ability -> {
        });
    });

    /** Enchantment: Captain Definition */
    public static final ItemData EnchantmentCaptain = new ItemData("Enchantment: Captain", "追加特性：隊長", 3242, 600, 600, 420, null, null, 3, 336, 0, 0, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「隊長」の効果をつける。<br><br><unique>ユニーク自動効果 - 隊長:</unique> 自分に近づいてくる味方のチャンピオンの移動速度を10％上昇させる。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("隊長", ability -> {
        });
    });

    /** Enchantment: Distortion Definition */
    public static final ItemData EnchantmentDistortion = new ItemData("Enchantment: Distortion", "追加特性: 時空歪曲", 3243, 475, 475, 333, null, null, 3, 384, 0, 0, "<groupLimit>追加特性はいずれか1種類しか付与できない。</groupLimit><br>ブーツに「時空歪曲」の効果を付ける。<br><br><unique>ユニーク自動効果 - 時空歪曲:</unique> サモナースペルのうち、テレポート、フラッシュ、ゴーストのクールダウンが20%短縮し、以下の移動速度ボーナスを得る。<br><br><font color='#FFDD00'>ゴースト:</font> 移動速度ボーナスが27%から40%に上昇。<br><font color='#FFDD00'>フラッシュ:</font> 使用後1秒間、移動速度に20%ボーナス。<br><font color='#FFDD00'>テレポート:</font> 使用後3秒間、移動速度に30%ボーナス。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("時空歪曲", ability -> {
        });
    });

    /** Enchantment: Homeguard Definition */
    public static final ItemData EnchantmentHomeguard = new ItemData("Enchantment: Homeguard", "追加特性: 防衛", 3244, 475, 475, 333, null, null, 3, 432, 0, 0, "<groupLimit>適用可能な追加特性は1種類のみ。</groupLimit><br>ブーツに「防衛」の効果をつける。<br><br><unique>ユニーク自動効果 - 防衛:</unique> ショップを訪れるとライフ自動回復速度とマナ自動回復速度が大きく上昇する。また移動速度に+200％のボーナスを得る(この効果は8秒間かけて減衰する)。移動速度ボーナスおよび自動回復速度ボーナスは、戦闘状態を離脱後6秒間は発動しない。<br><br><i>(同名のユニーク自動効果は累積しない)</i>", item -> {
        item.add("防衛", ability -> {
        });
    });

    /** Luden's Echo Definition */
    public static final ItemData LudensEcho = new ItemData("Luden's Echo", "ルーデンの共鳴", 3285, 900, 3000, 2100, new int[] {1058, 3113}, null, 2, 288, 288, 3, "<stats>魔力 +100<br>移動速度 +10％</stats><br><br><unique>ユニーク自動効果: </unique>移動およびスキル使用によりチャージを溜めることができる。チャージが100溜まると、次に発動するスキルに100 (+魔力の10％) の魔法ダメージが追加される。最大4体のターゲットに命中する。", item -> {
        item.abilityPower(100);
        item.movementSpeed(10);
        item.add("移動およびスキル使用によりチャージを溜めることができる。チャージが100溜まると、次に発動するスキルに100 (+魔力の10％) の魔法ダメージが追加される。最大4体のターゲットに命中する。", ability -> {
        });
    });

    /** Ancient Coin Definition */
    public static final ItemData AncientCoin = new ItemData("Ancient Coin", "いにしえのコイン", 3301, 365, 365, 146, null, new int[] {3096}, 2, 144, 0, 0, "<stats><mana>基本マナ自動回復 +25％ (マナ自動回復</mana></stats><br><br><unique>ユニーク自動効果 - 恩寵:</unique> 自らとどめを刺すことなく周囲で敵ミニオンが倒された場合、3ゴールドを得てライフを5回復する。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit><br><br><i><font color='#447777'>「砂金は砂漠より出でて、いにしえのコインにまつわる」－歴史家シュレリア、CLE23年11月11日</font></i><br><br>", item -> {
        item.add("恩寵", ability -> {
        });
    });

    /** Relic Shield Definition */
    public static final ItemData RelicShield = new ItemData("Relic Shield", "遺宝の盾", 3302, 365, 365, 146, null, new int[] {3097}, 2, 192, 0, 0, "<stats>ライフ +75</stats><br><br><unique>ユニーク自動効果 - 戦場の略奪:</unique> 近接の通常攻撃でライフが200未満のミニオンにとどめを刺すことができる。この方法でミニオンを倒した場合、自分と周囲にいる味方のチャンピオンはライフが40回復し、それぞれキル相当のゴールドを得る。<br><br>これらの効果は周囲に最低1人の味方のチャンピオンがいないと発生しない。チャージは60秒毎に発生する。最大2チャージ。<br><br><groupLimit>所持可能な金策アイテムは1個のみ</groupLimit>", item -> {
        item.health(75);
        item.add("戦場の略奪", ability -> {
        });
    });

    /** Spellthief's Edge Definition */
    public static final ItemData SpellthiefsEdge = new ItemData("Spellthief's Edge", "スペルシーフ・エッジ", 3303, 365, 365, 146, null, new int[] {3098}, 2, 240, 0, 0, "<stats>魔力 +5<br>獲得ゴールド(10秒毎) +2<br><mana>基本マナ自動回復 +25％ (マナ自動回復</mana></stats><br><br><unique>ユニーク自動効果 - 徴収:</unique> チャンピオンまたは建造物にスキル攻撃/通常攻撃をすると、追加ダメージ10を与え、5ゴールドを獲得する。この効果は最大で30秒間に3回まで発生する。ミニオンを倒すと、この自動効果は12秒間発生しなくなる。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit>", item -> {
        item.abilityPower(5);
        item.add("徴収", ability -> {
        });
    });

    /** Warding Totem (Trinket) Definition */
    public static final ItemData WardingTotemTrinket = new ItemData("Warding Totem (Trinket)", "守護のトーテム", 3340, 0, 0, 0, null, new int[] {3361, 3362}, 2, 288, 0, 0, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><br><br><unique>発動効果:</unique> 60秒間持続する「<font color='#BBFFFF'>ステルスワード</font>」を1個設置する(クールダウン120秒)。<br><br>レベル9で、このワードの効果時間が120秒に延びる。<br><br>マップへ同時に置ける「<font color='#BBFFFF'>ステルスワード</font>」はプレイヤー1人につき3個まで。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("60秒間持続する「ステルスワード」を1個設置する(クールダウン120秒)。<br><br>レベル9で、このワードの効果時間が120秒に延びる。<br><br>マップへ同時に置ける「ステルスワード」はプレイヤー1人につき3個まで。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Sweeping Lens (Trinket) Definition */
    public static final ItemData SweepingLensTrinket = new ItemData("Sweeping Lens (Trinket)", "検視のレンズ", 3341, 0, 0, 0, null, new int[] {3364}, 2, 336, 0, 0, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><br><br><unique>発動効果:</unique> 小さな有効範囲内にあるステルスのトラップとワードを、6秒のあいだ見破り、かつ無効にする(クールダウン120秒)。<br><br>レベル9で、投射距離と走査半径がそれぞれ50％拡大し、クールダウンは75秒に短縮される。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("小さな有効範囲内にあるステルスのトラップとワードを、6秒のあいだ見破り、かつ無効にする(クールダウン120秒)。<br><br>レベル9で、投射距離と走査半径がそれぞれ50％拡大し、クールダウンは75秒に短縮される。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Scrying Orb (Trinket) Definition */
    public static final ItemData ScryingOrbTrinket = new ItemData("Scrying Orb (Trinket)", "透視のオーブ", 3342, 0, 0, 0, null, new int[] {3363}, 2, 384, 0, 0, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><br><br><unique>発動効果:</unique> 2500距離以内の場所から一定範囲の視界を2秒間確保する。範囲内にいる敵のチャンピオンは5秒間可視状態になる(クールダウン120秒)。<br><br>レベル9で、投射距離は3500まで延びる。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("2500距離以内の場所から一定範囲の視界を2秒間確保する。範囲内にいる敵のチャンピオンは5秒間可視状態になる(クールダウン120秒)。<br><br>レベル9で、投射距離は3500まで延びる。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Hextech Sweeper Definition */
    public static final ItemData HextechSweeper = new ItemData("Hextech Sweeper", "ヘクステック・スイーパー", 3348, 0, 0, 0, null, null, 2, 432, 288, 0, "<active>発動効果(累積不可) - 狩人の目:</active> 指定範囲に隠密状態を見破る霧を5秒間展開する。範囲内のトラップおよび敵のチャンピオンの隠密状態を3秒間見破る(クールダウン90秒)。", item -> {
    });

    /** Greater Stealth Totem (Trinket) Definition */
    public static final ItemData GreaterStealthTotemTrinket = new ItemData("Greater Stealth Totem (Trinket)", "隠密のトーテム", 3361, 250, 250, 175, new int[] {3340}, null, 2, 0, 48, 2, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><levelLimit> *アップグレードにはレベル9以上が必要。</levelLimit><stats></stats><br><br><unique>ユニーク発動効果:</unique> 周囲の視界を確保する、ステルスのワードを1個設置する。効果は180秒間持続する。60秒ごとに1個、合計2個チャージ。マップ上に同時に置ける「<font color='#BBFFFF'>ステルスワード</font>」はプレイヤー1人につき3個まで。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("周囲の視界を確保する、ステルスのワードを1個設置する。効果は180秒間持続する。60秒ごとに1個、合計2個チャージ。マップ上に同時に置ける「ステルスワード」はプレイヤー1人につき3個まで。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Greater Vision Totem (Trinket) Definition */
    public static final ItemData GreaterVisionTotemTrinket = new ItemData("Greater Vision Totem (Trinket)", "発見のトーテム", 3362, 250, 250, 175, new int[] {3340}, null, 2, 48, 48, 2, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><levelLimit> *アップグレードにはレベル9以上が必要。</levelLimit><stats></stats><br><br><unique>ユニーク発動効果:</unique> ビジョンワード1個を設置する。ワードは周囲の視界を与え、視界内にいる不可視状態の敵を可視状態にする。効果は破壊されるまで続く(クールダウン120秒)。マップへ同時に置ける<font color='#BBFFFF'>「ビジョンワード」</font>はプレイヤー1人につき1個まで。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("ビジョンワード1個を設置する。ワードは周囲の視界を与え、視界内にいる不可視状態の敵を可視状態にする。効果は破壊されるまで続く(クールダウン120秒)。マップへ同時に置ける「ビジョンワード」はプレイヤー1人につき1個まで。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Farsight Orb (Trinket) Definition */
    public static final ItemData FarsightOrbTrinket = new ItemData("Farsight Orb (Trinket)", "天眼のオーブ", 3363, 250, 250, 175, new int[] {3342}, null, 2, 96, 48, 2, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><levelLimit> <stats>*アップグレードにはレベル9以上が必要。</stats></levelLimit><br><br><unique>ユニーク発動効果:</unique> 4000距離以内の場所から一定範囲の視界を2秒間確保する。範囲内にいる敵のチャンピオンは5秒のあいだ可視状態になる(クールダウン90秒)。<br><br>また、60秒間持続する可視状態のワードを1個設置する。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("4000距離以内の場所から一定範囲の視界を2秒間確保する。範囲内にいる敵のチャンピオンは5秒のあいだ可視状態になる(クールダウン90秒)。<br><br>また、60秒間持続する可視状態のワードを1個設置する。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Oracle's Lens (Trinket) Definition */
    public static final ItemData OraclesLensTrinket = new ItemData("Oracle's Lens (Trinket)", "看破のレンズ", 3364, 250, 250, 175, new int[] {3341}, null, 2, 144, 48, 2, "<groupLimit>所持可能なアクセサリーは1個のみ。</groupLimit><levelLimit> *アップグレードにはレベル9以上が必要。</levelLimit><stats></stats><br><br><unique>ユニーク発動効果:</unique> 有効範囲中程度の内にあるステルスのトラップとワードを6秒にわたって見破り、かつ無効にする。さらに、周囲にいるステルスのユニットを10秒のあいだ見破る(クールダウン75秒)。<br><br><i>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)</i>", item -> {
        item.add("有効範囲中程度の内にあるステルスのトラップとワードを6秒にわたって見破り、かつ無効にする。さらに、周囲にいるステルスのユニットを10秒のあいだ見破る(クールダウン75秒)。<br><br>(アクセサリーはゲーム開始後30秒間は使用できない。アクセサリーを売ると120秒間はアクセサリーが使えなくなる。)", ability -> {
        });
    });

    /** Face of the Mountain Definition */
    public static final ItemData FaceoftheMountain = new ItemData("Face of the Mountain", "山の相貌", 3401, 485, 2200, 880, new int[] {3097, 3067}, null, 2, 192, 48, 3, "<stats>ライフ +500<br>基本ライフ自動回復 +100％ (ライフ自動回復<br>クールダウン +10％</stats><br><br><unique>ユニーク自動効果 - 戦場の略奪:</unique> 近接の通常攻撃で、ライフが400未満のミニオンに対しとどめを刺す。ミニオンを倒すと、自分ともっとも自分の近くにいる味方のチャンピオンのライフが50 (+自身のライフ最大値の1％) 回復し、ミニオンを倒した際の獲得ゴールドと同じ額が味方のチャンピオンにも与えられる。<br><br>この効果は周囲に最低1人の味方のチャンピオンがいないと発生しない。チャージは30秒ごとに発生し、最大4チャージまで累積する。<br><unique>ユニーク発動効果:</unique> 味方1体にシールドを張る。このシールドは使用者のライフ最大値の10％にあたるダメージを吸収し、4秒間持続する。4秒後、シールドは炸裂して、シールド対象の攻撃力合計の100％ + 魔力の30％を魔法ダメージとして範囲内の敵に与える(クールダウン60秒)。<br><br><groupLimit>所持可能なゴールド増加アイテムは1個のみ</groupLimit>", item -> {
        item.health(500);
        item.add("戦場の略奪", ability -> {
        });
        item.add("味方1体にシールドを張る。このシールドは使用者のライフ最大値の10％にあたるダメージを吸収し、4秒間持続する。4秒後、シールドは炸裂して、シールド対象の攻撃力合計の100％ + 魔力の30％を魔法ダメージとして範囲内の敵に与える(クールダウン60秒)。<br><br>", ability -> {
        });
    });

    /** Ardent Censer Definition */
    public static final ItemData ArdentCenser = new ItemData("Ardent Censer", "情愛の香炉", 3504, 650, 2100, 1470, new int[] {3114, 3113}, null, 2, 0, 192, 3, "<stats>魔力 +40<br>クールダウン +10％<br><mana>基本マナ自動回復 +100％ (マナ回復</mana></stats><br><br><unique>自動効果(累積不可):</unique> 移動速度 +8％<br><unique>自動効果(累積不可):</unique> 他ユニットにヒールやシールドを与えると、対象ユニットは6秒のあいだ攻撃速度が15％上昇し、攻撃命中時に30の魔法ダメージを与える。<br><br><i>(この効果は自動回復効果や自分自身への効果では発生しない。)", item -> {
        item.abilityPower(40);
        item.add("移動速度 +8％", ability -> {
        });
        item.add("他ユニットにヒールやシールドを与えると、対象ユニットは6秒のあいだ攻撃速度が15％上昇し、攻撃命中時に30の魔法ダメージを与える。<br><br>(この効果は自動回復効果や自分自身への効果では発生しない。)", ability -> {
        });
    });

    /** Essence Reaver Definition */
    public static final ItemData EssenceReaver = new ItemData("Essence Reaver", "霊奪刃", 3508, 850, 3200, 2240, new int[] {1053, 1038}, null, 2, 48, 192, 3, "<stats>攻撃力 +80<br>物理吸命 +10％<br>クールダウン +10％</stats><br><br><mana><passive>ユニーク自動効果:</passive> 通常攻撃で与えたダメージの2％～8％をマナとして回復する。この効果は失ったマナ量に比例して増える。</mana>", item -> {
        item.attackDamage(80);
        item.lifeSteal(10);
    });

    /** Zz'Rot Portal Definition */
    public static final ItemData ZzRotPortal = new ItemData("Zz'Rot Portal", "ジ＝ロット・ポータル", 3512, 950, 2800, 1960, new int[] {2053, 1057}, null, 2, 96, 192, 3, "<stats>物理防御 +60<br>魔法防御 +60<br>基本ライフ自動回復 +100％ (ライフ回復<br></stats><br><unique>自動効果(累積不可) - ポイントランナー:</unique> タワーおよび「ヴォイドの扉」(破壊されたものを含む)付近では、2秒間かけて移動速度が最大30％上昇。<br><br><active>発動効果(累積不可): </active>指定した場所に、150秒間持続する「ヴォイドの扉」を召喚する。この扉は4秒ごとにヴォイドスポーンを産む。ヴォイドスポーンは最も近いレーンに進攻し、時間と共に消滅する。ヴォイドスポーンは、建造物を攻撃すると爆発する。ヴォイドスポーンは、チャンピオンおよびヴォイドの生物を攻撃することはない(クールダウン150秒)。<br><br>最初の1匹と4匹ごとに出現するヴォイドスポーンは、物理防御と魔法防御の100％に相当するダメージボーナスを得る。", item -> {
        item.armor(60);
        item.magicRegist(60);
        item.add("ポイントランナー", ability -> {
        });
    });

    /** The Black Spear Definition */
    public static final ItemData TheBlackSpear = new ItemData("The Black Spear", "復讐の槍", 3599, 0, 0, 0, null, null, 2, 144, 192, 0, "<stats></stats><br><passive>発動効果: </passive> 味方1体と現在のゲーム終了まで続く誓いを結び、「誓いの友」となる。誓いの友同士が近くにいると、両者とも能力が強化される。", item -> {
    });

    /** Stalker's Blade Definition */
    public static final ItemData StalkersBlade = new ItemData("Stalker's Blade", "追跡の鋭刃", 3706, 450, 850, 595, new int[] {1039}, new int[] {3707, 3708, 3709, 3710}, 2, 192, 192, 2, "<stats>大型モンスター・キルごとの獲得ゴールドボーナス +30</stats><br><passive>自動効果 - 冷気のスマイト:</passive> 「スマイト」で敵のチャンピオンを攻撃できるようになる。与える確定ダメージが通常より減るかわり、そのチャンピオンの移動速度を2秒間20％奪う。<br><br><passive>自動効果 - ジャングラー:</passive> モンスターに45追加魔法ダメージを2秒にわたって与える。またモンスターと戦闘中はライフ自動回復10 (毎秒) とマナ自動回復5 (毎秒) を得る。<br><br><groupLimit>所持できるジャングラー専用アイテムは1つのみ</groupLimit>", item -> {
    });

    /** Enchantment: Warrior Definition */
    public static final ItemData StalkersBladeEnchantmentWarrior = new ItemData("Stalker's Blade Enchantment: Warrior", "追跡の鋭刃 追加特性: 戦士", 3707, 63, 2250, 1575, new int[] {3706, 3134}, null, 2, 240, 192, 3, "<stats>攻撃力 +40<br>クールダウン +10％<br>物理防御貫通 +10</stats>", item -> {
    });

    /** Enchantment: Runeglaive Definition */
    public static final ItemData StalkersBladeEnchantmentRuneglaive = new ItemData("Stalker's Blade Enchantment: Runeglaive", "追跡の鋭刃 追加特性: 魔術師", 3708, 200, 2250, 1575, new int[] {3706, 3057}, null, 2, 288, 192, 3, "<stats>魔力 +80<br>クールダウン +20％</stats>", item -> {
        item.mana(200);
    });

    /** Enchantment: Cinderhulk Definition */
    public static final ItemData StalkersBladeEnchantmentCinderhulk = new ItemData("Stalker's Blade Enchantment: Cinderhulk", "追跡の鋭刃 追加特性: 護炎石", 3709, 400, 2250, 1575, new int[] {3706, 3751}, null, 2, 336, 192, 3, "<stats>ライフ +300<br>ライフボーナス +25％</stats><br><br><unique>自動効果(累積不可) - 猛火:</unique> 周囲の敵に毎秒15 (+0.6 x チャンピオンのレベル) の魔法ダメージを与える。モンスターに対しては100％のダメージボーナスを与える。  ", item -> {
        item.add("猛火", ability -> {
        });
    });

    /** Enchantment: Devourer Definition */
    public static final ItemData StalkersBladeEnchantmentDevourer = new ItemData("Stalker's Blade Enchantment: Devourer", "追跡の鋭刃 追加特性：貪食者", 3710, 300, 2250, 1575, new int[] {3706, 1043}, new int[] {3930}, 2, 384, 192, 3, "<stats>攻撃速度 +50％<br>命中時の魔法ダメージ +25</stats><br><br><passive>自動効果 - むさぼり食らう: </passive>大型モンスターを倒すと、このアイテムによる与魔法ダメージが1増加。チャンピオンに対するキルまたはアシスト獲得でこのアイテムによる与魔法ダメージが2増加。", item -> {
    });

    /** Poacher's Knife Definition */
    public static final ItemData PoachersKnife = new ItemData("Poacher's Knife", "略奪の短剣", 3711, 450, 850, 595, new int[] {1039}, new int[] {3719, 3720, 3721, 3722}, 2, 432, 192, 2, "<stats>大型モンスター・キルごとの獲得ゴールドボーナス +30</stats><br><passive>自動効果 - 乱食のスマイト:</passive> 「スマイト」を使って敵陣側のジャングルで大型モンスターを攻撃すると、「スマイト」のクールダウンが半分に短縮する。そのモンスターを倒すと、追加ゴールド+20を得て、移動速度が175％上がる。上がった移動速度は2秒間に減衰する。<br><br><passive>自動効果 - ジャングラー:</passive> モンスターに45追加魔法ダメージを2秒にわたって与える。またモンスターと戦闘中はライフ自動回復10 (毎秒) とマナ自動回復5 (毎秒) を得る。<br><br><groupLimit>所持できるジャングラー専用アイテムは1つのみ</groupLimit>", item -> {
    });

    /** Ranger's Trailblazer Definition */
    public static final ItemData RangersTrailblazer = new ItemData("Ranger's Trailblazer", "狩猟の手斧", 3713, 450, 850, 595, new int[] {1039}, new int[] {3723, 3724, 3725, 3726}, 2, 0, 240, 2, "<stats>大型モンスター・キルごとの獲得ゴールドボーナス +30</stats><br><passive>自動効果 - 破裂のスマイト:</passive> 「スマイト」に範囲ダメージがつく。ターゲットの周囲にいるモンスターと敵ミニオンすべてに半分のダメージを与えて1.5秒スタンさせる。「スマイト」をモンスターに使用すると、失ったライフおよびマナの15％を回復する。<br><br><passive>自動効果 - ジャングラー: </passive>モンスターに45追加魔法ダメージを2秒にわたって与える。またモンスターと戦闘中はライフ自動回復10 (毎秒) とマナ自動回復5 (毎秒) を得る。<br><br><groupLimit>所持できるジャングラー専用アイテムは1つのみ</groupLimit>", item -> {
    });

    /** Enchantment: Warrior Definition */
    public static final ItemData SkirmishersSabreEnchantmentWarrior = new ItemData("Skirmisher's Sabre Enchantment: Warrior", "一騎のサーベル 追加特性: 戦士", 3714, 63, 2250, 1575, new int[] {3715, 3134}, null, 2, 48, 240, 3, "<stats>攻撃力 +40<br>クールダウン +10％<br>物理防御貫通 +10</stats>", item -> {
    });

    /** Skirmisher's Sabre Definition */
    public static final ItemData SkirmishersSabre = new ItemData("Skirmisher's Sabre", "一騎のサーベル", 3715, 450, 850, 595, new int[] {1039}, new int[] {3714, 3716, 3717, 3718}, 2, 96, 240, 2, "<stats>大型モンスター・キルごとの獲得ゴールドボーナス +30</stats><br><passive>自動効果 - 覚悟のスマイト:</passive> 「スマイト」で敵のチャンピオンを攻撃できるようになる。これを受けたチャンピオンは4秒間マークされる。マークされたターゲットに対しては、マークした者は通常攻撃の命中時に3秒間追加確定ダメージを与え、常に姿を見ることができ、受けるダメージを20％軽減できる。<br><br><passive>自動効果 - ジャングラー:</passive> モンスターに45追加魔法ダメージを2秒にわたって与える。またモンスターと戦闘中はライフ自動回復10 (毎秒) とマナ自動回復5 (毎秒) を得る。<br><br><groupLimit>所持できるジャングラー専用アイテムは1つのみ</groupLimit>", item -> {
    });

    /** Enchantment: Runeglaive Definition */
    public static final ItemData SkirmishersSabreEnchantmentRuneglaive = new ItemData("Skirmisher's Sabre Enchantment: Runeglaive", "一騎のサーベル 追加特性: 魔術師", 3716, 200, 2250, 1575, new int[] {3715, 3057}, null, 2, 144, 240, 3, "<stats>魔力 +80<br>クールダウン +20％</stats>", item -> {
        item.mana(200);
    });

    /** Enchantment: Cinderhulk Definition */
    public static final ItemData SkirmishersSabreEnchantmentCinderhulk = new ItemData("Skirmisher's Sabre Enchantment: Cinderhulk", "一騎のサーベル 追加特性: 護炎石", 3717, 400, 2250, 1575, new int[] {3715, 3751}, null, 2, 192, 240, 3, "<stats>ライフ +300<br>ライフボーナス +25％</stats><br><br><unique>自動効果(累積不可) - 猛火:</unique> 周囲の敵に毎秒15 (+0.6 x チャンピオンのレベル) の魔法ダメージを与える。モンスターに対しては100％のダメージボーナスを与える。  ", item -> {
        item.add("猛火", ability -> {
        });
    });

    /** Enchantment: Devourer Definition */
    public static final ItemData SkirmishersSabreEnchantmentDevourer = new ItemData("Skirmisher's Sabre Enchantment: Devourer", "一騎のサーベル 追加特性：貪食者", 3718, 300, 2250, 1575, new int[] {3715, 1043}, new int[] {3931}, 2, 240, 240, 3, "<stats>攻撃速度 +50％<br>命中時の魔法ダメージ +25</stats><br><br><passive>自動効果 - むさぼり食らう: </passive>大型モンスターを倒すと、このアイテムによる与魔法ダメージが1増加。チャンピオンに対するキルまたはアシスト獲得でこのアイテムによる与魔法ダメージが2増加。", item -> {
    });

    /** Enchantment: Warrior Definition */
    public static final ItemData PoachersKnifeEnchantmentWarrior = new ItemData("Poacher's Knife Enchantment: Warrior", "略奪の短剣 追加特性: 戦士", 3719, 63, 2250, 1575, new int[] {3711, 3134}, null, 2, 288, 240, 3, "<stats>攻撃力 +40<br>クールダウン +10％<br>物理防御貫通 +10</stats>", item -> {
    });

    /** Enchantment: Runeglaive Definition */
    public static final ItemData PoachersKnifeEnchantmentRuneglaive = new ItemData("Poacher's Knife Enchantment: Runeglaive", "略奪の短剣 追加特性: 魔術師", 3720, 200, 2250, 1575, new int[] {3711, 3057}, null, 2, 336, 240, 3, "<stats>魔力 +80<br>クールダウン +20％</stats>", item -> {
        item.mana(200);
    });

    /** Enchantment: Cinderhulk Definition */
    public static final ItemData PoachersKnifeEnchantmentCinderhulk = new ItemData("Poacher's Knife Enchantment: Cinderhulk", "略奪の短剣 追加特性: 護炎石", 3721, 400, 2250, 1575, new int[] {3711, 3751}, null, 2, 384, 240, 3, "<stats>ライフ +300<br>ライフボーナス +25％</stats><br><br><unique>自動効果(累積不可) - 猛火:</unique> 周囲の敵に毎秒15 (+0.6 x チャンピオンのレベル) の魔法ダメージを与える。モンスターに対しては100％のダメージボーナスを与える。  ", item -> {
        item.add("猛火", ability -> {
        });
    });

    /** Enchantment: Devourer Definition */
    public static final ItemData PoachersKnifeEnchantmentDevourer = new ItemData("Poacher's Knife Enchantment: Devourer", "略奪の短剣 追加特性：貪食者", 3722, 300, 2250, 1575, new int[] {3711, 1043}, new int[] {3932}, 2, 432, 240, 3, "<stats>攻撃速度 +50％<br>命中時の魔法ダメージ +25</stats><br><br><passive>自動効果 - むさぼり食らう: </passive>大型モンスターを倒すと、このアイテムによる与魔法ダメージが1増加。チャンピオンに対するキルまたはアシスト獲得でこのアイテムによる与魔法ダメージが2増加。", item -> {
    });

    /** Enchantment: Warrior Definition */
    public static final ItemData RangersTrailblazerEnchantmentWarrior = new ItemData("Ranger's Trailblazer Enchantment: Warrior", "狩猟の手斧 追加特性: 戦士", 3723, 63, 2250, 1575, new int[] {3713, 3134}, null, 2, 0, 288, 3, "<stats>攻撃力 +40<br>クールダウン +10％<br>物理防御貫通 +10</stats>", item -> {
    });

    /** Enchantment: Runeglaive Definition */
    public static final ItemData RangersTrailblazerEnchantmentRuneglaive = new ItemData("Ranger's Trailblazer Enchantment: Runeglaive", "狩猟の手斧 追加特性: 魔術師", 3724, 200, 2250, 1575, new int[] {3713, 3057}, null, 2, 48, 288, 3, "<stats>魔力 +80<br>クールダウン +20％</stats>", item -> {
        item.mana(200);
    });

    /** Enchantment: Cinderhulk Definition */
    public static final ItemData RangersTrailblazerEnchantmentCinderhulk = new ItemData("Ranger's Trailblazer Enchantment: Cinderhulk", "狩猟の手斧 追加特性: 護炎石", 3725, 400, 2250, 1575, new int[] {3713, 3751}, null, 2, 96, 288, 3, "<stats>ライフ +300<br>ライフボーナス +25％</stats><br><br><unique>自動効果(累積不可) - 猛火:</unique> 周囲の敵に毎秒15 (+0.6 x チャンピオンのレベル) の魔法ダメージを与える。モンスターに対しては100％のダメージボーナスを与える。  ", item -> {
        item.add("猛火", ability -> {
        });
    });

    /** Enchantment: Devourer Definition */
    public static final ItemData RangersTrailblazerEnchantmentDevourer = new ItemData("Ranger's Trailblazer Enchantment: Devourer", "狩猟の手斧 追加特性：貪食者", 3726, 300, 2250, 1575, new int[] {3713, 1043}, new int[] {3933}, 2, 144, 288, 3, "<stats>攻撃速度 +50％<br>命中時の魔法ダメージ +25</stats><br><br><passive>自動効果 - むさぼり食らう: </passive>大型モンスターを倒すと、このアイテムによる与魔法ダメージが1増加。チャンピオンに対するキルまたはアシスト獲得でこのアイテムによる与魔法ダメージが2増加。", item -> {
    });

    /** Bami's Cinder Definition */
    public static final ItemData BamisCinder = new ItemData("Bami's Cinder", "バミの残り火", 3751, 600, 1000, 700, new int[] {1028}, new int[] {3068, 3709, 3717, 3721, 3725}, 2, 336, 288, 2, "<stats>ライフ +300</stats><br><br><unique>ユニーク自動効果 - 猛火:</unique>周囲の敵に毎秒5 (+1 x チャンピオンのレベル) の魔法ダメージを与える。ミニオンおよび中立モンスターには50％のダメージボーナスを与える。", item -> {
        item.health(300);
        item.add("猛火", ability -> {
        });
    });

    /** Righteous Glory Definition */
    public static final ItemData RighteousGlory = new ItemData("Righteous Glory", "正義の栄光", 3800, 700, 2500, 1750, new int[] {3010, 3801}, null, 2, 192, 288, 3, "<stats>ライフ +500<br><mana>マナ +300</mana><br>基本ライフ自動回復 +100％ (ライフ自動回復</stats><br><br><unique>ユニーク自動効果 - 勇者の報酬:</unique> レベルアップ時にライフ150とマナ200を8秒かけて回復する。<br><unique>ユニーク発動効果:</unique> 周囲の味方が敵または敵タワーに向かって移動する時、その味方の移動速度を3秒のあいだ+60％上昇させる。3秒後、衝撃波を放ち、周囲にいる敵のチャンピオンの移動速度を1秒のあいだ80％低下させる(クールダウン90秒)。<br><br>効果時間終了前にこの効果を再発動すれば、その時点で即座に衝撃波を放つことができる。", item -> {
        item.health(500);
        item.mana(300);
        item.add("勇者の報酬", ability -> {
        });
        item.add("周囲の味方が敵または敵タワーに向かって移動する時、その味方の移動速度を3秒のあいだ+60％上昇させる。3秒後、衝撃波を放ち、周囲にいる敵のチャンピオンの移動速度を1秒のあいだ80％低下させる(クールダウン90秒)。<br><br>効果時間終了前にこの効果を再発動すれば、その時点で即座に衝撃波を放つことができる。", ability -> {
        });
    });

    /** Crystalline Bracer Definition */
    public static final ItemData CrystallineBracer = new ItemData("Crystalline Bracer", "クリスタルの籠手", 3801, 20, 600, 420, new int[] {1028, 1006}, new int[] {3083, 3084, 3800}, 2, 240, 288, 2, "<stats>ライフ +200<br>基本ライフ自動回復 +50% )</stats>", item -> {
        item.health(200);
    });

    /** Enchantment: Sated Devourer Definition */
    public static final ItemData StalkersBladeEnchantmentSatedDevourer = new ItemData("Stalker's Blade Enchantment: Sated Devourer", "追跡の鋭刃 Enchantment: Sated Devourer", 3930, 2250, 2250, 3150, new int[] {3710}, null, 3, 0, 48, 4, "<stats>+50% Attack Speed<br>+60 Magic Damage on Hit</stats><br><br><passive>Passive - Phantom Hit:</passive> Every other basic attack will trigger on Hit effects an additional time.", item -> {
    });

    /** Enchantment: Sated Devourer Definition */
    public static final ItemData SkirmishersSabreEnchantmentSatedDevourer = new ItemData("Skirmisher's Sabre Enchantment: Sated Devourer", "一騎のサーベル Enchantment: Sated Devourer", 3931, 2250, 2250, 3150, new int[] {3718}, null, 3, 48, 48, 4, "<stats>+50% Attack Speed<br>+60 Magic Damage on Hit</stats><br><br><passive>Passive - Phantom Hit:</passive> Every other basic attack will trigger on Hit effects an additional time.", item -> {
    });

    /** Enchantment: Sated Devourer Definition */
    public static final ItemData PoachersKnifeEnchantmentSatedDevourer = new ItemData("Poacher's Knife Enchantment: Sated Devourer", "略奪の短剣 Enchantment: Sated Devourer", 3932, 2250, 2250, 3150, new int[] {3722}, null, 3, 96, 48, 4, "<stats>+50% Attack Speed<br>+60 Magic Damage on Hit</stats><br><br><passive>Passive - Phantom Hit:</passive> Every other basic attack will trigger on Hit effects an additional time.", item -> {
    });

    /** Enchantment: Sated Devourer Definition */
    public static final ItemData RangersTrailblazerEnchantmentSatedDevourer = new ItemData("Ranger's Trailblazer Enchantment: Sated Devourer", "狩猟の手斧 Enchantment: Sated Devourer", 3933, 2250, 2250, 3150, new int[] {3726}, null, 3, 144, 48, 4, "<stats>+50% Attack Speed<br>+60 Magic Damage on Hit</stats><br><br><passive>Passive - Phantom Hit:</passive> Every other basic attack will trigger on Hit effects an additional time.", item -> {
    });

    /** Item status. */
    public final String name;

    /** Item status. */
    public final String localizedName;

    /** Item status. */
    public final int identicalName;

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

    /** Item status. */
    public final String description;

    /** Item status. */
    public final Consumer<ItemDescriptor> descriptor;

    /**
     * The item definition.
     */
    private ItemData(String name, String localizedName, int identicalName, int buyBase, int buyTotal, int sell, int[] from, int[] to, int imageNo, int imageX, int imageY, int depth, String description, Consumer<ItemDescriptor> descriptor) {
        this.name = name;
        this.localizedName = localizedName;
        this.identicalName = identicalName;
        this.buyBase = buyBase;
        this.buyTotal = buyTotal;
        this.sell = sell;
        this.from = from;
        this.to = to;
        this.imageNo = imageNo;
        this.imageX = imageX;
        this.imageY = imageY;
        this.depth = depth;
        this.description = description;
        this.descriptor = descriptor;

        items.add(this);
    }

    /**
     * Descrive item status.
     */
    void describe(Consumer<ItemDescriptor> description) {
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
        return null;
    }

    /**
     * List up all Items.
     */
    public static List<ItemData> getAll() {
        return items;
    }
}
