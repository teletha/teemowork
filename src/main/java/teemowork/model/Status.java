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

/**
 * @version 2013/12/02 13:28:33
 */
public enum Status {

    // ==================================================
    // Damage Type
    // ==================================================
    /** Any Damage */
    Damage("ダメージ"), DamageRatio(Damage), CriticalDamageRatio("クリティカルダメージ", 2),

    /** Physical Daname */
    PhysicalDamage("物理DM"),

    /** Magic Damage */
    MagicDamage("魔法DM"),

    /** True Damage */
    TrueDamage("TrueDM"),

    /** ATtack Damage */
    AttackDamage("通常攻撃によるダメージ"), AttackDamageRatio(AttackDamage),

    /** Dealt Damage */
    DealtDamage("与えたDM"), DealtDamageRatio(DealtDamage),

    /** Dealt Damage Reduction */
    DamageDecreaseRatio("与えるダメージ"),

    /** Received Damage */
    ReceivedDamage("受けたDM"), ReceivedDamageRatio(ReceivedDamage), ReceivedDamage4SecRatio(
            "4秒以内に" + ReceivedDamage), ReceivedOriginalDamageRatio("軽減前の受けたDM"),

    /** Received Damage */
    PreventedDamage("軽減したDM"), PreventedDamageRatio(ReceivedDamage),

    // ==================================================
    // Health Related
    // ==================================================
    /** Health */
    Health("Health"), HealthPerLv, HealthRatio(Health), HealthRatioPerLv(HealthRatio), BounusHealth("増加" + Health),

    /** Base Health */
    BaseHealth("基礎" + Health),

    /** Health Regeneration */
    Hreg(2), HregPerLv(2), HregRatio("Hreg", 2),

    /** Health Cost */
    LoseHealth("Health"),

    // ==================================================
    // Mana Related
    // ==================================================
    /** Mana */
    Mana("Mana"), ManaPerLv, ManaRatio(Mana), BounusMana("増加Mana"),

    /** Mana Regeneration */
    Mreg(2), MregPerLv(2), MregRatio("Mreg", 2),

    // ==================================================
    // Energy Related
    // ==================================================
    /** Energy */
    Energy, EnergyPerLv, EnergyRatio("Energy"),

    /** Energy Regeneration */
    Ereg, EregPerLv, EregRatio("Energy"),

    // ==================================================
    // My Health Reference
    // ==================================================
    CurrentHealthRatio("現在のHealth"),

    MissingHealthRatio("失ったHealth"),

    MissingHealthPercentage("Health損耗率"),

    // ==================================================
    // Target Health Reference
    // ==================================================
    TargetMaxHealthRatio("対象の最大Health"),

    TargetCurrentHealthRatio("対象の現在のHealth"),

    TargetMissingHealthRatio("対象の失ったHealth"),

    TargetBounusHealthRatio("対象の増加Health"),

    // ==================================================
    // My Mana Reference
    // ==================================================
    CurrentManaRatio("現在のMana"),

    MissingManaRatio("失ったMana"),

    MissingManaPercentage("Mana損耗率"),

    // ==================================================
    // Target Mana Related Reference
    // ==================================================
    TargetCurrentManaRatio("対象の現在のMana"),

    // ==================================================
    // Attack Related
    // ==================================================
    /** Attack Damage */
    AD, ADPerLv, ADRatio("AD"), BounusAD("増加AD"), BaseAD("基礎AD"), TargetAD("対象のAD"),

    /** Attack Speed */
    AS(3), ASPerLv(3), ASRatio("攻撃速度", 2),

    /** life Steal */
    LS("Life Steal"), LSPerLv(LS), LSRatio(LS),

    /** Critical Chance */
    Critical("Critical Chance"), CriticalPerLv, CriticalRatio,

    /** Other */
    AttackTowerDamageRatio("タワーに対するダメージ"),

    // ==================================================
    // Ability Power Related
    // ==================================================
    /** Ability Power */
    AP, APPerLv, APRatio("AP", 2), TargetAP("対象のAP"),

    /** Cooldown Reduction */
    CDR("CD減少", 2), CDRPerLv, CDRRatio, CDRUnaware("CD減少の影響を受けない"),

    /** Spell Vamp */
    SV("Spell Vamp"), SVPerLv, SVRatio,

    // ==================================================
    // AR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    ARPen, ARPenPerLv,

    /** Percentage Penetration */
    ARPenRatio("ARPen"), ARPenRatioPerLv, BounusARPenRatio("増加ARPen"),

    /** Flat Reduction */
    ARReduction("AR減少"),

    /** Percentage Reduction */
    ARReductionRatio("AR減少"),

    // ==================================================
    // MR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    MRPen, MRPenPerLv,

    /** Percentage Penetration */
    MRPenRatio("MRPen"), MRPenRatioPerLv,

    /** Flat Reduction */
    MRReduction("MR減少"),

    /** Percentage Reduction */
    MRReductionRatio("MR減少"),

    // ==================================================
    // Defense Related
    // ==================================================
    /** Attack Damage Resistance */
    AR, ARPerLv, ARRatio("AR", 3), BounusAR("増加AR"),

    /** Magic Damage Resistance */
    MR, MRPerLv, MRRatio("MR", 3), BounusMR("増加MR"),

    /** General Damage Reduction */
    DamageReduction(Damage), DamageReductionRatio(Damage),

    /** Physical Damage Reduction */
    PhysicalDamageReduction(PhysicalDamage), PhysicalDamageReductionRatio(PhysicalDamage),

    /** Critical Damage Reduction */
    CriticalDamageReductionRatio("クリティカルダメージ"),

    /** Magic Damage Reduction */
    MagicDamageReduction(MagicDamage), MagicDamageReductionRatio(MagicDamage),

    /** Attack Damage Reduction */
    AttackDamageReduction(AttackDamage), AttackDamageReductionRatio(AttackDamage),

    /** Other Status Reduction */
    ADReduction(AD),

    /** Movement Slow Reduction */
    MSSlowReduction("スロー"), MSSlowReductionRatio("スロー"),

    /** Shield */
    Shield("シールド"), PhysicalShield("物理DM用シールド"), MagicShield("魔法DM用シールド"), SpellShield("スペルシールド"),

    // ==================================================
    // Other Status Related
    // ==================================================
    /** Range */
    Range("射程"), RangePerLv, RangeRatio(Range),

    /** Grow Body Size */
    Grow("サイズ"),

    /** Level */
    Lv,

    /** Tenacity */
    Tenacity("Tenacity"), TenacityPerLv,

    /** Experiment */
    Experiment("経験値"), ExperimentRatio("経験値"),

    /** Cooldown */
    CD(2), CDPerLv, CDDecrease(2), CDDecreaseRatio(1), ItemCD("CD", 1),

    // ==================================================
    // Heal Related
    // ==================================================
    RestoreHealth(Health),

    RestoreHealthRatio("Health回復量", 3),

    RestoreMana(Mana),

    RestoreEnergy(Energy),

    // ==================================================
    // Crowd Control and Debuff
    // ==================================================
    Charm("魅了", 3),

    Stun("スタン", 3),

    Suspension("サスペンション", 3),

    Snare("スネア", 3),

    Fear("Fear", 3),

    Terrified("Terrified", 3),

    Silence("サイレンス", 3),

    Blind("ブラインド", 3),

    Taunt("タウント", 3),

    Suppression("サプレッション", 3),

    Knockup("打ち上げ", 3),

    Knockback("ノックバック"),

    Slow("移動及び攻撃速度低下"), SlowRatio(Slow),

    MSSlow("移動速度低下"), MSSlowRatio("スロー"),

    ASSlow("攻撃速度低下"), ASSlowRatio(ASSlow),

    Wounds("重傷"),

    Foggy("視界低下"),

    // ==================================================
    // Movement Related
    // ==================================================
    /** Movement Speed */
    MS("移動速度"), MSPerLv, MSRatio("移動速度"), BounusMS("増加移動速度"),

    /** Reduction. */
    MSReduction(MS),

    /** Ignore Slow */
    IgnoreSlow(MSSlow.name + "無効"),

    /** Ignore Unit Collision */
    IgnoreUnitCollision("ユニット衝突無効"),

    /** Ignore Crowd Control */
    IgnoreCC("CC無効"),

    /** Remove Crowd Control */
    RemoveCC("全てのCCを解除"),

    // ==================================================
    // State
    // ==================================================
    Stealth("ステルス"),

    Visionable("視界を得る"),

    NotSpellCast("このスキルはSpellcastとして扱われない"),

    Chill,

    OnHitEffect("このスキルはOn-Hit Effectの影響を受ける"),

    // ==================================================
    // Cost Related
    // ==================================================
    /** Cost */
    Cost, CostPerLv,

    Sell,

    Gold, GoldPer10Sec("Gold Generation"),

    // ==================================================
    // Time Related
    // ==================================================
    Time("", 3), CDRAwareTime(""), RespawnTimeReductionRatio("死亡時間"),

    Duration("経過秒数"),

    Count("", 3), Radius("範囲"),

    Length("長さ"),

    Distance("距離"),

    MissileSpeed("弾速"),

    MissileWidth("射幅"),

    EnemyChampion("敵Championの数"),

    DamagedChampion("ダメージを与えた敵チャンピオンの数"),

    Takedown("キルするかアシストする"),

    ResetAATimer("通常攻撃タイマーを解消する"),

    Value("", 0),

    Percentage(""),

    Charge,

    Fury("Fury"),

    Stack("スタック"), ConsumedStack("消費したスタック"), StackPercentage("");

    /** The status name. */
    public final String name;

    /** The unit. */
    // public final String unit;

    /** The precision for value. */
    public final int precision;

    /**
     * @param precision
     */
    private Status() {
        this(1);
    }

    /**
     * @param name
     */
    private Status(String name) {
        this(name, 1);
    }

    /**
     * @param status
     */
    private Status(Status status) {
        this(status.name, 1);
    }

    /**
     * @param precision
     */
    private Status(int precision) {
        this(null, precision);
    }

    /**
     * @param name
     */
    private Status(String name, int precision) {
        this.name = name == null ? name() : name;
        this.precision = precision;
    }

    /**
     * <p>
     * Find base status type.
     * </p>
     * 
     * @return
     */
    public Status base() {
        if (name().startsWith("Base")) {
            return valueOf(name().substring(4));
        }
        return null;
    }

    /**
     * <p>
     * Test status type.
     * </p>
     * 
     * @return
     */
    public boolean isPerLv() {
        return name().endsWith("PerLv");
    }

    /**
     * <p>
     * Find per level status.
     * </p>
     * 
     * @return
     */
    public Status per() {
        if (name().endsWith("PerLv")) {
            return null;
        }
        return Status.valueOf(name() + "PerLv");
    }

    /**
     * <p>
     * Find ratio status.
     * </p>
     * 
     * @return
     */
    public Status ratio() {
        if (name().endsWith("Ratio")) {
            return null;
        }
        return Status.valueOf(name() + "Ratio");
    }

    /**
     * <p>
     * Round up the specified value decimal for this state.
     * </p>
     * 
     * @param value
     * @return
     */
    public double round(double value) {
        double factor = Math.pow(10, precision);
        return Math.round(value * factor) / factor;
    }

    /**
     * <p>
     * Compute values.
     * </p>
     * 
     * @param one
     * @param other
     * @return
     */
    public double compute(double one, double other) {
        switch (this) {
        case ARPenRatio:
        case ARReductionRatio:
        case MRPenRatio:
        case MRReductionRatio:
        case Tenacity:
            return (1 - (1 - one / 100) * (1 - other / 100)) * 100;

        default:
            return one + other;
        }
    }

    public String getUnit() {
        if (name().endsWith("Ratio")) {
            return "%";
        }

        switch (this) {
        case Time:
        case Snare:
        case Silence:
        case Charm:
        case Stun:
        case Blind:
        case Taunt:
        case Fear:
        case Terrified:
        case Wounds:
        case Knockup:
        case Suppression:
        case CD:
        case CDRAwareTime:
        case CDDecrease:
            return "秒";

        case Stealth:
            return "秒間";

        case CDR:
        case Critical:
        case SV:
        case LS:
        case Tenacity:
        case Percentage:
        case Grow:
            return "%";

        default:
            return "";
        }
    }

    /**
     * <p>
     * Format human-readable status with the specified value.
     * </p>
     * 
     * @param computed A value to display.
     * @return A formatted text.
     */
    public String format(double computed) {
        switch (this) {
        case Critical:
        case MS:
        case DamageRatio:
        case CriticalDamageRatio:
        case AttackDamage:
        case AttackDamageRatio:
        case MSRatio:
        case ASRatio:
        case ADRatio:
        case APRatio:
        case ARRatio:
        case MRRatio:
        case HealthRatio:
        case ManaRatio:
        case HregRatio:
        case MregRatio:
        case LSRatio:
        case ExperimentRatio:
        case RestoreHealthRatio:
        case Grow:
        case AttackTowerDamageRatio:
            return name + "が" + formatValue(Math.abs(computed)) + (0 <= computed ? "増加" : "減少");

        case DamageReduction:
        case DamageReductionRatio:
        case PhysicalDamageReduction:
        case PhysicalDamageReductionRatio:
        case MagicDamageReduction:
        case MagicDamageReductionRatio:
        case AttackDamageReduction:
        case AttackDamageReductionRatio:
        case MSSlowReduction:
        case MSSlowReductionRatio:
        case RespawnTimeReductionRatio:
        case CriticalDamageReductionRatio:
            return name + "を" + formatValue(computed) + "軽減";

        case ADReduction:
        case MSReduction:
        case DamageDecreaseRatio:
            return name + "が" + formatValue(computed) + "減少";

        case LoseHealth:
            return name + "を" + formatValue(computed) + "消費";

        case RestoreEnergy:
        case RestoreHealth:
        case RestoreMana:
            return name + "が" + formatValue(computed) + "回復";

        case CDDecrease:
        case CDDecreaseRatio:
            return "CDが" + formatValue(computed) + "解消";

        case Stealth:
            return formatValue(computed) + "ステルス";

        case Gold:
            return formatValue(computed) + "Gold";

        case GoldPer10Sec:
            return "10秒毎に" + formatValue(computed) + "Gold";

        case Range:
            return "射程が" + formatValue(Math.abs(computed)) + (0 <= computed ? "増加" : "減少");

        case Knockback:
            String length = formatValue(computed);

            if (length.length() == 0) {
                return name;
            } else {
                return name + "(距離" + formatValue(computed) + ")";
            }

        case Stack:
        case ConsumedStack:
            return formatValue(computed) + "スタック";
        }
        return name + formatValue(computed);
    }

    /**
     * <p>
     * Helper method to format value.
     * </p>
     * 
     * @param value
     * @return
     */
    private String formatValue(double value) {
        return value == 0 ? "" : round(value) + getUnit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
