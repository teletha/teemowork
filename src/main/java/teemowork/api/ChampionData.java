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


public enum ChampionData {

    /** Aatrox Definition */
    Aatrox("Aatrox", "エイトロックス", 537.8F, 85.0F, 6.59F, 0.5F, 105.6F, 45.0F, 0.0F, 0.0F, 60.376F, 3.2F, -0.04F, 3.0F, 0.0F, 0.0F, 24.384F, 3.8F, 32.1F, 0.0F, 345.0F, 150.0F),

    /** Ahri Definition */
    Ahri("Ahri", "アーリ", 514.4F, 80.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.04F, 3.0F, -0.065F, 2.0F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Akali Definition */
    Akali("Akali", "アカリ", 587.8F, 85.0F, 8.34F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 58.376F, 3.2F, -0.1F, 3.1F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Alistar Definition */
    Alistar("Alistar", "アリスター", 613.36F, 102.0F, 8.675F, 0.85F, 278.84F, 38.0F, 6.0F, 0.8F, 61.1116F, 3.62F, 0.0F, 2.125F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 0.0F, 330.0F, 125.0F),

    /** Amumu Definition */
    Amumu("Amumu", "アムム", 613.12F, 84.0F, 8.875F, 0.85F, 287.2F, 40.0F, 7.38F, 0.525F, 53.384F, 3.8F, -0.02F, 2.18F, 0.0F, 0.0F, 23.544F, 3.3F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Anivia Definition */
    Anivia("Anivia", "アニヴィア", 467.6F, 70.0F, 5.57F, 0.55F, 346.04F, 53.0F, 6.0F, 0.8F, 51.376F, 3.2F, 0.0F, 1.68F, 0.0F, 0.0F, 21.22F, 4.0F, 30.0F, 0.0F, 325.0F, 600.0F),

    /** Annie Definition */
    Annie("Annie", "アニー", 511.68F, 76.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 50.41F, 2.625F, 0.08F, 1.36F, 0.0F, 0.0F, 19.22F, 4.0F, 30.0F, 0.0F, 335.0F, 575.0F),

    /** Ashe Definition */
    Ashe("Ashe", "アッシュ", 527.72F, 79.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 51.088F, 2.85F, -0.05F, 3.33F, 0.0F, 0.0F, 21.212F, 3.4F, 30.0F, 0.0F, 325.0F, 600.0F),

    /** Azir Definition */
    Azir("Azir", "アジール", 524.4F, 80.0F, 6.92F, 0.55F, 350.56F, 42.0F, 6.0F, 0.8F, 52.0F, 2.8F, -0.02F, 1.5F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 335.0F, 525.0F),

    /** Bard Definition */
    Bard("Bard", "バード", 535.0F, 85.0F, 5.4F, 0.55F, 350.0F, 50.0F, 6.0F, 0.45F, 52.0F, 3.0F, 0.0F, 2.0F, 0.0F, 0.0F, 25.0F, 4.0F, 30.0F, 0.0F, 330.0F, 500.0F),

    /** Blitzcrank Definition */
    Blitzcrank("Blitzcrank", "ブリッツ", 582.6F, 95.0F, 8.51F, 0.75F, 267.2F, 40.0F, 6.0F, 0.8F, 61.54F, 3.5F, 0.0F, 1.13F, 0.0F, 0.0F, 24.38F, 3.5F, 32.1F, 0.0F, 325.0F, 125.0F),

    /** Brand Definition */
    Brand("Brand", "ブランド", 507.68F, 76.0F, 5.42F, 0.55F, 325.6F, 45.0F, 8.005F, 0.6F, 57.04F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F),

    /** Braum Definition */
    Braum("Braum", "ブラーム", 576.16F, 87.0F, 8.18F, 1.0F, 310.6F, 45.0F, 6.0F, 0.8F, 55.376F, 3.2F, -0.03F, 3.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Caitlyn Definition */
    Caitlyn("Caitlyn", "ケイトリン", 524.4F, 80.0F, 5.67F, 0.55F, 313.8F, 35.0F, 7.42F, 0.55F, 50.04F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 650.0F),

    /** Cassiopeia Definition */
    Cassiopeia("Cassiopeia", "カシオペア", 506.0F, 75.0F, 5.69F, 0.5F, 370.8F, 60.0F, 8.36F, 0.75F, 52.376F, 3.2F, -0.034F, 1.68F, 0.0F, 0.0F, 22.22F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F),

    /** Cho'Gath Definition */
    Chogath("Cho'Gath", "チョ＝ガス", 574.4F, 80.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.0F, 1.44F, 0.0F, 0.0F, 28.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Corki Definition */
    Corki("Corki", "コーキー", 512.76F, 82.0F, 5.42F, 0.55F, 305.16F, 37.0F, 7.42F, 0.55F, 51.24F, 3.0F, 0.0F, 2.3F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Darius Definition */
    Darius("Darius", "ダリウス", 582.24F, 93.0F, 9.845F, 0.95F, 263.0F, 37.5F, 6.585F, 0.35F, 55.88F, 3.5F, -0.08F, 2.65F, 0.0F, 0.0F, 29.88F, 3.5F, 32.1F, 0.0F, 340.0F, 125.0F),

    /** Diana Definition */
    Diana("Diana", "ダイアナ", 589.2F, 90.0F, 7.425F, 0.85F, 297.2F, 40.0F, 6.0F, 0.8F, 53.04F, 3.0F, 0.0F, 2.25F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 0.0F, 345.0F, 150.0F),

    /** Draven Definition */
    Draven("Draven", "ドレイヴン", 557.76F, 82.0F, 6.175F, 0.7F, 310.56F, 42.0F, 8.04F, 0.65F, 50.38F, 3.5F, -0.08F, 2.7F, 0.0F, 0.0F, 25.544F, 3.3F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Dr. Mundo Definition */
    DrMundo("Dr. Mundo", "ドクター・ムンド", 582.52F, 89.0F, 7.76F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 61.27F, 3.0F, 0.0F, 2.8F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Ekko Definition */
    Ekko("Ekko", "エコー", 580.0F, 80.0F, 9.0F, 0.9F, 280.0F, 50.0F, 6.0F, 0.8F, 59.0F, 3.0F, 0.0F, 3.3F, 0.0F, 0.0F, 27.0F, 3.0F, 32.0F, 0.0F, 340.0F, 125.0F),

    /** Elise Definition */
    Elise("Elise", "エリス", 529.4F, 80.0F, 5.705F, 0.6F, 324.0F, 50.0F, 6.0F, 0.8F, 50.54F, 3.0F, 0.0F, 1.75F, 0.0F, 0.0F, 22.128F, 3.35F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Evelynn Definition */
    Evelynn("Evelynn", "エヴェリン", 531.2F, 90.0F, 9.82F, 0.55F, 265.6F, 45.0F, 8.105F, 0.6F, 53.88F, 3.5F, 0.0F, 3.6F, 0.0F, 0.0F, 26.5F, 3.8F, 32.1F, 0.0F, 340.0F, 125.0F),

    /** Ezreal Definition */
    Ezreal("Ezreal", "エズリアル", 484.4F, 80.0F, 6.42F, 0.55F, 310.6F, 45.0F, 8.09F, 0.65F, 50.24F, 3.0F, 0.0F, 2.8F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Fiddlesticks Definition */
    FiddleSticks("Fiddlesticks", "フィドル", 524.4F, 80.0F, 5.605F, 0.6F, 350.12F, 59.0F, 6.0F, 0.8F, 48.36F, 2.625F, 0.0F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 480.0F),

    /** Fiora Definition */
    Fiora("Fiora", "フィオラ", 592.8F, 85.0F, 6.84F, 0.8F, 287.2F, 40.0F, 7.59F, 0.5F, 59.876F, 3.2F, -0.07F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Fizz Definition */
    Fizz("Fizz", "フィズ", 558.48F, 86.0F, 8.175F, 0.7F, 267.2F, 40.0F, 6.0F, 0.8F, 58.04F, 3.0F, -0.05F, 3.1F, 0.0F, 0.0F, 22.412F, 3.4F, 32.1F, 0.0F, 335.0F, 175.0F),

    /** Galio Definition */
    Galio("Galio", "ガリオ", 577.8F, 85.0F, 8.71F, 0.75F, 319.0F, 50.0F, 6.0F, 0.8F, 61.97F, 3.375F, -0.02F, 1.2F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Gangplank Definition */
    Gangplank("Gangplank", "ガングプランク", 631.08F, 81.0F, 5.51F, 0.75F, 282.2F, 40.0F, 7.675F, 0.7F, 59.04F, 3.0F, -0.04F, 2.75F, 0.0F, 0.0F, 26.044F, 3.3F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Garen Definition */
    Garen("Garen", "ガレン", 616.28F, 96.0F, 7.84F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 57.88F, 3.5F, 0.0F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Gnar Definition */
    Gnar("Gnar", "ナー", 540.0F, 65.0F, 2.5F, 0.5F, 100.0F, 0.0F, 0.0F, 0.0F, 48.0F, 3.0F, 0.0F, 6.0F, 0.0F, 0.0F, 23.0F, 2.5F, 30.0F, 0.0F, 325.0F, 150.0F),

    /** Gragas Definition */
    Gragas("Gragas", "グラガス", 583.52F, 89.0F, 5.5F, 0.5F, 400.0F, 47.0F, 6.0F, 0.8F, 61.38F, 3.5F, -0.04F, 2.05F, 0.0F, 0.0F, 26.048F, 3.6F, 32.1F, 0.0F, 330.0F, 125.0F),

    /** Graves Definition */
    Graves("Graves", "グレイヴズ", 551.12F, 84.0F, 6.675F, 0.7F, 322.2F, 40.0F, 7.925F, 0.7F, 54.208F, 3.1F, 0.0F, 2.9F, 0.0F, 0.0F, 24.376F, 3.2F, 30.0F, 0.0F, 330.0F, 525.0F),

    /** Hecarim Definition */
    Hecarim("Hecarim", "ヘカリム", 599.6F, 95.0F, 7.0F, 0.75F, 277.2F, 40.0F, 6.5F, 0.6F, 61.376F, 3.2F, -0.0672F, 2.5F, 0.0F, 0.0F, 26.72F, 4.0F, 32.1F, 0.0F, 345.0F, 175.0F),

    /** Heimerdinger Definition */
    Heimerdinger("Heimerdinger", "ハイマー", 476.0F, 75.0F, 11.005F, 1.75F, 307.2F, 40.0F, 6.0F, 0.8F, 55.536F, 2.7F, 0.0F, 1.36F, 0.0F, 0.0F, 19.04F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F),

    /** Irelia Definition */
    Irelia("Irelia", "イレリア", 607.2F, 90.0F, 8.59F, 0.65F, 288.8F, 35.0F, 8.09F, 0.65F, 61.544F, 3.3F, -0.06F, 3.2F, 0.0F, 0.0F, 25.3F, 3.75F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Janna Definition */
    Janna("Janna", "ジャンナ", 487.04F, 78.0F, 5.42F, 0.55F, 409.52F, 64.0F, 9.0F, 0.4F, 51.956F, 2.95F, 0.0F, 2.61F, 0.0F, 0.0F, 19.384F, 3.8F, 30.0F, 0.0F, 335.0F, 475.0F),

    /** Jarvan IV Definition */
    JarvanIV("Jarvan IV", "ジャーヴァンⅣ", 571.2F, 90.0F, 8.175F, 0.7F, 302.2F, 40.0F, 6.755F, 0.45F, 55.712F, 3.4F, -0.05F, 2.5F, 0.0F, 0.0F, 27.0F, 3.6F, 32.1F, 0.0F, 340.0F, 175.0F),

    /** Jax Definition */
    Jax("Jax", "ジャックス", 592.8F, 85.0F, 8.37F, 0.55F, 288.8F, 35.0F, 7.575F, 0.7F, 61.97F, 3.375F, -0.02F, 3.4F, 0.0F, 0.0F, 27.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Jayce Definition */
    Jayce("Jayce", "ジェイス", 571.2F, 90.0F, 7.34F, 0.8F, 307.2F, 40.0F, 6.0F, 0.8F, 50.38F, 3.5F, -0.05F, 3.0F, 0.0F, 0.0F, 22.38F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F),

    /** Jinx Definition */
    Jinx("Jinx", "ジンクス", 517.76F, 82.0F, 5.84F, 0.5F, 245.6F, 45.0F, 6.68F, 1.0F, 53.04F, 3.0F, 0.0F, 1.0F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 325.0F, 525.0F),

    /** Kalista Definition */
    Kalista("Kalista", "カリスタ", 517.76F, 83.0F, 6.0F, 0.55F, 231.8F, 35.0F, 6.3F, 0.4F, 57.5F, 3.5F, -0.05F, 3.3F, 0.0F, 0.0F, 19.012F, 3.5F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Karma Definition */
    Karma("Karma", "カルマ", 522.44F, 83.0F, 5.62F, 0.55F, 374.0F, 50.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.0F, 2.3F, 0.0F, 0.0F, 20.384F, 3.8F, 30.0F, 0.0F, 335.0F, 525.0F),

    /** Karthus Definition */
    Karthus("Karthus", "カーサス", 516.0F, 75.0F, 6.42F, 0.55F, 372.48F, 61.0F, 6.0F, 0.8F, 45.66F, 3.25F, 0.0F, 2.11F, 0.0F, 0.0F, 20.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F),

    /** Kassadin Definition */
    Kassadin("Kassadin", "カサディン", 564.04F, 78.0F, 7.79F, 0.5F, 347.6F, 70.0F, 6.0F, 0.8F, 58.852F, 3.9F, -0.023F, 3.7F, 0.0F, 0.0F, 23.376F, 3.2F, 30.0F, 0.0F, 340.0F, 150.0F),

    /** Katarina Definition */
    Katarina("Katarina", "カタリナ", 510.0F, 83.0F, 4.5F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 58.0F, 3.2F, -0.05F, 2.74F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Kayle Definition */
    Kayle("Kayle", "ケイル", 574.24F, 93.0F, 8.26F, 0.75F, 322.2F, 40.0F, 6.0F, 0.8F, 56.004F, 2.8F, -0.02F, 2.2F, 0.0F, 0.0F, 26.88F, 3.5F, 30.0F, 0.0F, 335.0F, 125.0F),

    /** Kennen Definition */
    Kennen("Kennen", "ケネン", 535.72F, 79.0F, 5.59F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 50.544F, 3.3F, -0.0947F, 3.4F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 335.0F, 550.0F),

    /** Kha'Zix Definition */
    Khazix("Kha'Zix", "カ＝ジックス", 572.8F, 85.0F, 7.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Kog'Maw Definition */
    KogMaw("Kog'Maw", "コグ＝マウ", 546.16F, 87.0F, 5.92F, 0.55F, 322.2F, 40.0F, 8.675F, 0.7F, 49.04F, 3.0F, -0.06F, 2.65F, 0.0F, 0.0F, 19.88F, 3.5F, 30.0F, 0.0F, 325.0F, 500.0F),

    /** LeBlanc Definition */
    Leblanc("LeBlanc", "ルブラン", 516.0F, 75.0F, 7.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 54.88F, 3.5F, 0.0F, 1.4F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F),

    /** Lee Sin Definition */
    LeeSin("Lee Sin", "リー・シン", 570.8F, 85.0F, 7.425F, 0.7F, 200.0F, 0.0F, 50.0F, 0.0F, 61.176F, 3.2F, -0.04F, 3.0F, 0.0F, 0.0F, 24.216F, 3.7F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Leona Definition */
    Leona("Leona", "レオナ", 576.16F, 87.0F, 8.425F, 0.85F, 302.2F, 40.0F, 6.0F, 0.8F, 60.04F, 3.0F, 0.0F, 2.9F, 0.0F, 0.0F, 27.208F, 3.1F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Lissandra Definition */
    Lissandra("Lissandra", "リサンドラ", 506.12F, 84.0F, 6.92F, 0.55F, 304.0F, 50.0F, 5.67F, 0.4F, 50.536F, 2.7F, 0.0F, 1.36F, 0.0F, 0.0F, 20.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Lucian Definition */
    Lucian("Lucian", "ルシアン", 554.4F, 80.0F, 6.19F, 0.65F, 298.88F, 41.0F, 8.175F, 0.7F, 52.04F, 3.0F, -0.02F, 3.3F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 335.0F, 500.0F),

    /** Lulu Definition */
    Lulu("Lulu", "ルル", 552.76F, 82.0F, 6.005F, 0.6F, 292.4F, 55.0F, 8.5F, 0.6F, 46.368F, 2.6F, 0.0F, 2.25F, 0.0F, 0.0F, 19.216F, 3.7F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Lux Definition */
    Lux("Lux", "ラックス", 477.72F, 79.0F, 5.42F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 53.544F, 3.3F, 0.0F, 1.36F, 0.0F, 0.0F, 18.72F, 4.0F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Malphite Definition */
    Malphite("Malphite", "マルファイト", 574.2F, 90.0F, 8.37F, 0.55F, 282.2F, 40.0F, 7.32F, 0.55F, 61.97F, 3.375F, -0.02F, 3.4F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Malzahar Definition */
    Malzahar("Malzahar", "マルザハール", 514.4F, 80.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 550.0F),

    /** Maokai Definition */
    Maokai("Maokai", "マオカイ", 572.2F, 90.0F, 8.675F, 0.85F, 327.28F, 46.0F, 7.205F, 0.45F, 63.544F, 3.3F, -0.1F, 2.125F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 335.0F, 125.0F),

    /** Master Yi Definition */
    MasterYi("Master Yi", "マスター・イー", 598.56F, 92.0F, 7.59F, 0.65F, 250.56F, 42.0F, 7.255F, 0.45F, 60.04F, 3.0F, -0.08F, 2.0F, 0.0F, 0.0F, 24.04F, 3.0F, 32.1F, 0.0F, 355.0F, 125.0F),

    /** Miss Fortune Definition */
    MissFortune("Miss Fortune", "フォーチュン", 577.8F, 85.0F, 6.19F, 0.65F, 275.84F, 38.0F, 8.04F, 0.65F, 49.54F, 3.0F, -0.04734F, 3.01F, 0.0F, 0.0F, 24.04F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Wukong Definition */
    MonkeyKing("Wukong", "ウーコン", 577.8F, 85.0F, 6.19F, 0.65F, 265.84F, 38.0F, 8.04F, 0.65F, 59.876F, 3.2F, -0.05F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 345.0F, 175.0F),

    /** Mordekaiser Definition */
    Mordekaiser("Mordekaiser", "モルデカイザー", 555.4F, 80.0F, 3.37F, 0.55F, 120.0F, 0.0F, 0.0F, 0.0F, 57.58F, 3.5F, -0.1F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 340.0F, 125.0F),

    /** Morgana Definition */
    Morgana("Morgana", "モルガナ", 547.48F, 86.0F, 5.705F, 0.6F, 340.8F, 60.0F, 6.0F, 0.8F, 55.46F, 3.5F, 0.0F, 1.53F, 0.0F, 0.0F, 25.384F, 3.8F, 30.0F, 0.0F, 335.0F, 450.0F),

    /** Nami Definition */
    Nami("Nami", "ナミ", 489.32F, 74.0F, 5.42F, 0.55F, 377.24F, 43.0F, 9.0F, 0.4F, 51.208F, 3.1F, -0.03F, 2.61F, 0.0F, 0.0F, 19.72F, 4.0F, 30.0F, 0.0F, 335.0F, 550.0F),

    /** Nasus Definition */
    Nasus("Nasus", "ナサス", 561.2F, 90.0F, 9.01F, 0.9F, 275.6F, 45.0F, 7.44F, 0.5F, 59.18F, 3.5F, -0.02F, 3.48F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Nautilus Definition */
    Nautilus("Nautilus", "ノーチラス", 576.48F, 86.0F, 8.37F, 0.55F, 284.0F, 50.0F, 8.625F, 0.7F, 57.544F, 3.3F, 0.02F, 1.0F, 0.0F, 0.0F, 26.46F, 3.25F, 32.1F, 0.0F, 325.0F, 175.0F),

    /** Nidalee Definition */
    Nidalee("Nidalee", "ニダリー", 511.2F, 80.0F, 6.005F, 0.6F, 295.6F, 45.0F, 6.0F, 0.8F, 47.88F, 3.5F, -0.02F, 3.22F, 0.0F, 0.0F, 22.88F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F),

    /** Nocturne Definition */
    Nocturne("Nocturne", "ノクターン", 582.8F, 85.0F, 8.26F, 0.75F, 273.8F, 35.0F, 6.755F, 0.45F, 59.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Nunu Definition */
    Nunu("Nunu", "ヌヌ", 598.28F, 90.0F, 8.39F, 0.8F, 283.56F, 42.0F, 7.44F, 0.5F, 56.856F, 3.45F, 0.0F, 2.25F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Olaf Definition */
    Olaf("Olaf", "オラフ", 597.24F, 93.0F, 8.51F, 0.9F, 265.6F, 45.0F, 7.465F, 0.575F, 59.98F, 3.5F, -0.1F, 2.7F, 0.0F, 0.0F, 26.04F, 3.0F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Orianna Definition */
    Orianna("Orianna", "オリアナ", 517.72F, 79.0F, 6.87F, 0.55F, 334.0F, 50.0F, 6.0F, 0.8F, 40.368F, 2.6F, -0.05F, 3.5F, 0.0F, 0.0F, 17.04F, 3.0F, 30.0F, 0.0F, 325.0F, 525.0F),

    /** Pantheon Definition */
    Pantheon("Pantheon", "パンテオン", 579.16F, 87.0F, 7.84F, 0.65F, 267.12F, 34.0F, 7.355F, 0.45F, 55.572F, 2.9F, 0.0F, 2.95F, 0.0F, 0.0F, 27.652F, 3.9F, 32.1F, 0.0F, 355.0F, 150.0F),

    /** Poppy Definition */
    Poppy("Poppy", "ポッピー", 559.08F, 81.0F, 8.37F, 0.55F, 235.4F, 30.0F, 7.155F, 0.45F, 61.97F, 3.375F, -0.02F, 3.35F, 0.0F, 0.0F, 28.72F, 4.0F, 30.0F, 0.0F, 345.0F, 125.0F),

    /** Quinn Definition */
    Quinn("Quinn", "クイン", 532.8F, 85.0F, 5.42F, 0.55F, 268.8F, 35.0F, 6.97F, 0.4F, 51.04F, 3.0F, -0.065F, 3.1F, 0.0F, 0.0F, 23.38F, 3.5F, 30.0F, 0.0F, 335.0F, 525.0F),

    /** Rammus Definition */
    Rammus("Rammus", "ラムス", 564.48F, 86.0F, 7.92F, 0.55F, 310.44F, 33.0F, 7.84F, 0.5F, 55.88F, 3.5F, 0.0F, 2.215F, 0.0F, 0.0F, 31.384F, 3.8F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Rek'Sai Definition */
    RekSai("Rek'Sai", "レク＝サイ", 570.0F, 90.0F, 7.34F, 0.65F, 100.0F, 0.0F, 0.0F, 0.0F, 55.628F, 3.35F, 0.0F, 2.0F, 0.0F, 0.0F, 28.3F, 3.75F, 32.1F, 0.0F, 335.0F, 175.0F),

    /** Renekton Definition */
    Renekton("Renekton", "レネクトン", 572.16F, 87.0F, 7.96F, 0.75F, 100.0F, 0.0F, 0.0F, 0.0F, 58.328F, 3.1F, -0.06F, 2.65F, 0.0F, 0.0F, 25.584F, 3.8F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Rengar Definition */
    Rengar("Rengar", "レンガー", 586.2F, 90.0F, 4.27F, 0.4F, 5.0F, 0.0F, 0.0F, 0.0F, 60.04F, 3.0F, -0.08F, 2.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Riven Definition */
    Riven("Riven", "リヴェン", 558.48F, 86.0F, 3.34F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 56.04F, 3.0F, 0.0F, 3.5F, 0.0F, 0.0F, 24.376F, 3.2F, 32.1F, 0.0F, 340.0F, 125.0F),

    /** Rumble Definition */
    Rumble("Rumble", "ランブル", 584.4F, 80.0F, 8.005F, 0.6F, 100.0F, 0.0F, 0.0F, 0.0F, 61.036F, 3.2F, -0.03F, 1.85F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Ryze Definition */
    Ryze("Ryze", "ライズ", 558.48F, 86.0F, 5.27F, 0.55F, 342.4F, 55.0F, 5.0F, 1.0F, 55.04F, 3.0F, 0.0F, 2.112F, 0.0F, 0.0F, 21.552F, 3.0F, 30.0F, 0.0F, 340.0F, 550.0F),

    /** Sejuani Definition */
    Sejuani("Sejuani", "セジュアニ", 600.0F, 95.0F, 8.675F, 0.85F, 400.0F, 40.0F, 7.205F, 0.45F, 57.544F, 3.3F, -0.0672F, 1.44F, 0.0F, 0.0F, 29.54F, 3.0F, 32.1F, 0.0F, 340.0F, 125.0F),

    /** Shaco Definition */
    Shaco("Shaco", "シャコ", 582.12F, 84.0F, 8.37F, 0.55F, 297.2F, 40.0F, 7.155F, 0.45F, 57.58F, 3.5F, -0.1F, 3.0F, 0.0F, 0.0F, 24.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Shen Definition */
    Shen("Shen", "シェン", 570.8F, 85.0F, 8.37F, 0.55F, 200.0F, 0.0F, 50.0F, 0.0F, 60.17F, 3.375F, -0.04F, 3.4F, 0.0F, 0.0F, 25.72F, 4.0F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Shyvana Definition */
    Shyvana("Shyvana", "シヴァーナ", 594.6F, 95.0F, 8.59F, 0.8F, 100.0F, 0.0F, 0.0F, 0.0F, 60.712F, 3.4F, -0.05F, 2.5F, 0.0F, 0.0F, 27.628F, 3.35F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Singed Definition */
    Singed("Singed", "シンジド", 542.76F, 82.0F, 8.02F, 0.55F, 290.6F, 45.0F, 7.52F, 0.55F, 62.32F, 3.375F, 0.02F, 1.81F, 0.0F, 0.0F, 27.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Sion Definition */
    Sion("Sion", "サイオン", 542.64F, 73.0F, 10.18F, 0.8F, 275.6F, 45.0F, 8.005F, 0.6F, 59.72F, 4.0F, -0.08F, 1.3F, 0.0F, 0.0F, 23.04F, 3.0F, 32.1F, 0.0F, 345.0F, 150.0F),

    /** Sivir Definition */
    Sivir("Sivir", "シヴィア", 515.76F, 82.0F, 5.17F, 0.55F, 284.0F, 50.0F, 8.01F, 0.9F, 52.04F, 3.0F, -0.05F, 1.6F, 0.0F, 0.0F, 22.21F, 3.25F, 30.0F, 0.0F, 335.0F, 500.0F),

    /** Skarner Definition */
    Skarner("Skarner", "スカーナー", 601.28F, 96.0F, 8.925F, 0.85F, 272.2F, 40.0F, 7.205F, 0.45F, 61.156F, 4.2F, 0.0F, 2.1F, 0.0F, 0.0F, 29.384F, 3.8F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Sona Definition */
    Sona("Sona", "ソナ", 482.36F, 77.0F, 5.42F, 0.55F, 340.6F, 45.0F, 9.0F, 0.4F, 50.04F, 3.0F, -0.03F, 2.3F, 0.0F, 0.0F, 20.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Soraka Definition */
    Soraka("Soraka", "ソラカ", 529.04F, 78.0F, 2.5F, 0.5F, 350.8F, 60.0F, 9.0F, 0.4F, 50.04F, 3.0F, 0.0F, 2.14F, 0.0F, 0.0F, 23.384F, 3.8F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Swain Definition */
    Swain("Swain", "スウェイン", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, 0.0F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 500.0F),

    /** Syndra Definition */
    Syndra("Syndra", "シンドラ", 511.04F, 78.0F, 6.505F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 53.872F, 2.9F, 0.0F, 2.0F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Tahm Kench Definition */
    TahmKench("Tahm Kench", "Tahm Kench", 610.0F, 95.0F, 6.5F, 0.55F, 325.0F, 40.0F, 5.5F, 1.0F, 56.0F, 3.2F, 0.0F, 2.5F, 0.0F, 0.0F, 27.0F, 3.0F, 32.1F, 0.0F, 335.0F, 200.0F),

    /** Talon Definition */
    Talon("Talon", "タロン", 582.8F, 85.0F, 8.51F, 0.75F, 327.2F, 40.0F, 7.59F, 0.5F, 55.208F, 3.1F, -0.065F, 2.7F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Taric Definition */
    Taric("Taric", "タリック", 619.2F, 90.0F, 7.94F, 0.5F, 349.08F, 56.0F, 6.0F, 0.8F, 57.88F, 3.5F, 0.0F, 2.02F, 0.0F, 0.0F, 25.876F, 3.2F, 32.1F, 0.0F, 340.0F, 125.0F),

    /** Teemo Definition */
    Teemo("Teemo", "ティーモ", 515.76F, 82.0F, 5.74F, 0.65F, 267.2F, 40.0F, 7.205F, 0.45F, 47.54F, 3.0F, -0.0947F, 3.38F, 0.0F, 0.0F, 24.3F, 3.75F, 30.0F, 0.0F, 330.0F, 500.0F),

    /** Thresh Definition */
    Thresh("Thresh", "スレッシュ", 560.52F, 89.0F, 6.92F, 0.55F, 273.92F, 44.0F, 6.0F, 0.8F, 47.696F, 2.2F, 0.0F, 3.5F, 0.0F, 0.0F, 16.0F, 0.0F, 30.0F, 0.0F, 335.0F, 450.0F),

    /** Tristana Definition */
    Tristana("Tristana", "トリスターナ", 542.76F, 82.0F, 6.19F, 0.65F, 246.76F, 32.0F, 7.205F, 0.45F, 51.54F, 3.0F, -0.04734F, 1.5F, 0.0F, 0.0F, 22.0F, 3.0F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Trundle Definition */
    Trundle("Trundle", "トランドル", 616.28F, 96.0F, 9.425F, 0.85F, 281.6F, 45.0F, 7.505F, 0.6F, 60.04F, 3.0F, -0.0672F, 2.9F, 0.0F, 0.0F, 27.536F, 2.7F, 32.1F, 0.0F, 350.0F, 125.0F),

    /** Tryndamere Definition */
    Tryndamere("Tryndamere", "トリンダミア", 625.64F, 98.0F, 8.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 61.376F, 3.2F, -0.0672F, 2.9F, 0.0F, 0.0F, 24.108F, 3.1F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Twisted Fate Definition */
    TwistedFate("Twisted Fate", "フェイト", 521.76F, 82.0F, 5.505F, 0.6F, 265.84F, 38.0F, 6.0F, 0.8F, 49.954F, 3.3F, -0.04F, 3.22F, 0.0F, 0.0F, 20.542F, 3.15F, 30.0F, 0.0F, 330.0F, 525.0F),

    /** Twitch Definition */
    Twitch("Twitch", "トゥイッチ", 525.08F, 81.0F, 6.005F, 0.6F, 287.2F, 40.0F, 7.255F, 0.45F, 49.04F, 3.0F, -0.08F, 3.38F, 0.0F, 0.0F, 23.04F, 3.0F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Udyr Definition */
    Udyr("Udyr", "ウディア", 593.32F, 99.0F, 8.71F, 0.75F, 270.4F, 30.0F, 7.505F, 0.45F, 58.286F, 3.2F, -0.05F, 2.67F, 0.0F, 0.0F, 25.47F, 4.0F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Urgot Definition */
    Urgot("Urgot", "アーゴット", 586.52F, 89.0F, 6.505F, 0.6F, 312.4F, 55.0F, 8.59F, 0.65F, 52.048F, 3.6F, -0.03F, 2.9F, 0.0F, 0.0F, 24.544F, 3.3F, 30.0F, 0.0F, 335.0F, 425.0F),

    /** Varus Definition */
    Varus("Varus", "ヴァルス", 537.76F, 82.0F, 5.42F, 0.55F, 310.48F, 36.0F, 7.34F, 0.8F, 49.04F, 3.0F, -0.05F, 3.0F, 0.0F, 0.0F, 23.212F, 3.4F, 30.0F, 0.0F, 330.0F, 575.0F),

    /** Vayne Definition */
    Vayne("Vayne", "ヴェイン", 498.44F, 83.0F, 5.42F, 0.55F, 231.8F, 35.0F, 6.97F, 0.4F, 53.46F, 3.25F, -0.05F, 4.0F, 0.0F, 0.0F, 19.012F, 3.4F, 30.0F, 0.0F, 330.0F, 550.0F),

    /** Veigar Definition */
    Veigar("Veigar", "ヴェイガー", 492.76F, 82.0F, 5.42F, 0.55F, 342.4F, 55.0F, 6.0F, 0.8F, 50.71F, 2.625F, 0.0F, 2.24F, 0.0F, 0.0F, 22.55F, 3.75F, 30.0F, 0.0F, 340.0F, 525.0F),

    /** Vel'Koz Definition */
    Velkoz("Vel'Koz", "ヴェル＝コズ", 507.68F, 76.0F, 5.42F, 0.55F, 325.6F, 45.0F, 6.0F, 0.8F, 54.937874F, 3.1415927F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F),

    /** Vi Definition */
    Vi("Vi", "ヴァイ", 582.8F, 85.0F, 9.01F, 0.9F, 295.6F, 45.0F, 8.09F, 0.65F, 55.88F, 3.5F, -0.03F, 2.5F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Viktor Definition */
    Viktor("Viktor", "ヴィクター", 516.04F, 78.0F, 7.84F, 0.65F, 324.0F, 50.0F, 6.0F, 0.8F, 52.04F, 3.0F, -0.05F, 2.11F, 0.0F, 0.0F, 22.72F, 4.0F, 30.0F, 0.0F, 335.0F, 525.0F),

    /** Vladimir Definition */
    Vladimir("Vladimir", "ヴラッドミア", 542.8F, 85.0F, 7.005F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 48.04F, 3.0F, -0.05F, 2.0F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 335.0F, 450.0F),

    /** Volibear Definition */
    Volibear("Volibear", "ヴォリベア", 584.48F, 86.0F, 8.09F, 0.65F, 270.4F, 30.0F, 8.09F, 0.65F, 59.544F, 3.3F, -0.05F, 2.67F, 0.0F, 0.0F, 26.38F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Warwick Definition */
    Warwick("Warwick", "ワーウィック", 592.64F, 98.0F, 8.39F, 0.8F, 240.4F, 30.0F, 8.105F, 0.6F, 62.43F, 3.375F, -0.08F, 2.88F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Xerath Definition */
    Xerath("Xerath", "ゼラス", 514.4F, 80.0F, 5.42F, 0.55F, 316.96F, 47.0F, 6.0F, 0.8F, 54.7F, 3.0F, 0.0F, 1.36F, 0.0F, 0.0F, 21.88F, 3.5F, 30.0F, 0.0F, 340.0F, 525.0F),

    /** Xin Zhao Definition */
    XinZhao("Xin Zhao", "シン・ジャオ", 591.16F, 87.0F, 8.175F, 0.7F, 273.8F, 35.0F, 7.255F, 0.45F, 57.544F, 3.3F, -0.07F, 2.6F, 0.0F, 0.0F, 25.88F, 3.5F, 32.1F, 0.0F, 345.0F, 175.0F),

    /** Yasuo Definition */
    Yasuo("Yasuo", "ヤスオ", 517.76F, 82.0F, 6.51F, 0.9F, 100.0F, 0.0F, 0.0F, 0.0F, 55.376F, 3.2F, -0.05F, 3.2F, 0.0F, 0.0F, 24.712F, 3.4F, 30.0F, 0.0F, 345.0F, 175.0F),

    /** Yorick Definition */
    Yorick("Yorick", "ヨーリック", 563.8F, 85.0F, 8.175F, 0.7F, 293.8F, 35.0F, 6.755F, 0.45F, 57.58F, 3.5F, 0.0F, 3.0F, 0.0F, 0.0F, 25.048F, 3.6F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Zac Definition */
    Zac("Zac", "ザック", 614.6F, 95.0F, 7.92F, 0.55F, 0.0F, 0.0F, 0.0F, 0.0F, 59.67F, 3.375F, -0.02F, 1.6F, 0.0F, 0.0F, 23.88F, 3.5F, 32.1F, 0.0F, 335.0F, 125.0F),

    /** Zed Definition */
    Zed("Zed", "ゼド", 579.4F, 80.0F, 7.09F, 0.65F, 200.0F, 0.0F, 50.0F, 0.0F, 54.712F, 3.4F, -0.03F, 2.1F, 0.0F, 0.0F, 26.88F, 3.5F, 32.1F, 0.0F, 345.0F, 125.0F),

    /** Ziggs Definition */
    Ziggs("Ziggs", "ジグス", 524.4F, 80.0F, 6.255F, 0.6F, 334.0F, 50.0F, 6.0F, 0.8F, 54.208F, 3.1F, -0.04734F, 2.0F, 0.0F, 0.0F, 21.544F, 3.3F, 30.0F, 0.0F, 325.0F, 550.0F),

    /** Zilean Definition */
    Zilean("Zilean", "ジリアン", 499.28F, 77.0F, 5.44F, 0.5F, 360.8F, 60.0F, 6.0F, 0.8F, 51.64F, 3.0F, 0.0F, 2.13F, 0.0F, 0.0F, 19.134F, 3.8F, 30.0F, 0.0F, 335.0F, 550.0F),

    /** Zyra Definition */
    Zyra("Zyra", "ザイラ", 479.32F, 74.0F, 5.69F, 0.5F, 334.0F, 50.0F, 6.0F, 0.8F, 53.376F, 3.2F, 0.0F, 2.11F, 0.0F, 0.0F, 20.04F, 3.0F, 30.0F, 0.0F, 325.0F, 575.0F);

    /** Champion status. */
    public final String name;

    /** Champion status. */
    public final String jp;

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

    /**
     * The champion definition.
     */
    private ChampionData(String name, String jp, float hp, float hpPer, float hreg, float hregPer, float mp, float mpPer, float mreg, float mregPer, float ad, float adPer, float as, float asPer, float crit, float critPer, float ar, float arPer, float mr, float mrPer, float ms, float range) {
        this.name = name;
        this.jp = jp;
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
    }
}
