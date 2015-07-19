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

import static teemowork.model.ItemData.*;
import static teemowork.model.Status.*;

/**
 * @version 2015/07/19 13:06:38
 */
public class ItemDataDefinition {

    static {
        BootsofSpeed.describe(item -> {
            item.add("移動速度強化", ability -> {
                ability.passive("{1}する。").variable(1, MS, 25);
            });
        });

        FaerieCharm.describe(item -> {
            item.manaRegen(25);
        });

        RejuvenationBead.describe(item -> {
            item.healthRegen(50);
        });

        GiantsBelt.describe(item -> {
            item.health(380);
        });

        CloakofAgility.describe(item -> {
            item.critical(15);
        });

        BlastingWand.describe(item -> {
            item.abilityPower(40);
        });

        SapphireCrystal.describe(item -> {
            item.mana(200);
        });

        RubyCrystal.describe(item -> {
            item.health(150);
        });

        ClothArmor.describe(item -> {
            item.armor(15);
        });

        ChainVest.describe(item -> {
            item.armor(40);
        });

        NullMagicMantle.describe(item -> {
            item.magicRegist(25);
        });

        LongSword.describe(item -> {
            item.attackDamage(10);
        });

        Pickaxe.describe(item -> {
            item.attackDamage(25);
        });

        BFSword.describe(item -> {
            item.attackDamage(50);
        });

        HuntersMachete.describe(item -> {
            item.add(ability -> {
                ability.passive("大型モンスターを倒すごとに{1}を得る。").variable(1, Gold, 15);
            }).add("ジャングラー", ability -> {
                ability.passive("モンスターに対する攻撃命中時に2秒間かけて{1}を与える。また、モンスターとの戦闘中、毎秒{2}及び{3}する（非好戦的なモンスターの場合、自動回復効果はなし）。")
                        .variable(1, MagicDamage, 30)
                        .variable(2, RestoreHealth, 7)
                        .variable(3, RestoreMana, 3);
            });
        });
    }
}
