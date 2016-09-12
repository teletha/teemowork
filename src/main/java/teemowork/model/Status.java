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

import java.util.Locale;

import kiss.I;
import teemowork.UserPreference;

/**
 * @version 2013/12/02 13:28:33
 */
public enum Status {

    // ==================================================
    // Damage Type
    // ==================================================
    /** Any Damage */
    Damage("Damage", "ダメージ"), DamageRatio(Damage), CriticalDamageRatio("クリティカルダメージ", 2),

    /** Physical Daname */
    PhysicalDamage("Physical Damage", "物理ダメージ"),

    /** Magic Damage */
    MagicDamage("MagicDamage", "魔法ダメージ"),

    /** True Damage */
    TrueDamage("TrueDamage", "確定ダメージ"),

    /** ATtack Damage */
    AttackDamage("通常攻撃によるダメージ"), AttackDamageRatio(AttackDamage),

    /** Dealt Damage */
    DealtDamage("DealtDamage", "与えたダメージ"), DealtDamageRatio(DealtDamage),

    /** Dealt Damage Reduction */
    DamageDecreaseRatio("与えるダメージ"),

    /** Received Damage */
    ReceivedDamage("ReceivedDamage", "受けたダメージ"), ReceivedDamageRatio(ReceivedDamage), ReceivedDamage4SecRatio("4秒以内に" + ReceivedDamage), ReceivedOriginalDamageRatio("軽減前の受けたDM"),

    /** Received Damage */
    PreventedDamage("PreventedDamage", "軽減したダメージ"), PreventedDamageRatio(ReceivedDamage),

    // ==================================================
    // Health Related
    // ==================================================
    /** Health */
    Health("Health", "体力"), HealthPerLv, HealthRatio(Health), HealthRatioPerLv(HealthRatio), BounusHealth("増加" + Health), BounusHealthRatio(BounusHealth),

    /** Base Health */
    BaseHealth("BaseHealth", "基礎体力"),

    /** Health Regeneration */
    Hreg("HealthRegen", "体力自動回復", 2), HregPerLv(2), HregRatio("Hreg", 2),

    /** Health Cost */
    LoseHealth(Health),

    // ==================================================
    // Mana Related
    // ==================================================
    /** Mana */
    Mana("Mana", "マナ"), ManaPerLv, ManaRatio(Mana), BounusMana("増加Mana"),

    /** Mana Regeneration */
    Mreg("ManaRegen", "マナ自動回復", 2), MregPerLv(2), MregRatio("Mreg", 2),

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
    CurrentHealthRatio("CurrentHealth", "現在の体力"),

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
    AD("AD", "攻撃力"), ADPerLv, ADRatio(AD), BounusAD("BounusAD", "増加攻撃力"), BaseAD("BaseAD", "基礎攻撃力"), TargetAD("TargetAD", "対象の攻撃力"),

    /** Attack Speed */
    AS("AS", "攻撃速度", 3), ASPerLv(3), ASRatio(AS, 2), BounusASRatio("BounusAS", "増加攻撃速度"),

    /** life Steal */
    LS("Life Steal", "物理吸命"), LSPerLv(LS), LSRatio(LS),

    /** Critical Chance */
    Critical("Critical Chance", "クリティカル率"), CriticalPerLv,

    /** Other */
    AttackTowerDamageRatio("タワーに対するダメージ"),

    // ==================================================
    // Ability Power Related
    // ==================================================
    /** Ability Power */
    AP("AP", "魔力"), APPerLv, APRatio("AP", 2), TargetAP("TargetAP", "対象の魔力"), BounusAP("BounusAP", "増加魔力"),

    /** Cooldown Reduction */
    CDR("CDR", "クールダウン短縮", 2), CDRPerLv, CDRRatio, CDRUnaware("CD減少の影響を受けない"),

    /** Spell Vamp */
    SV("Spell Vamp", "魔法吸命"), SVPerLv, SVRatio,

    // ==================================================
    // AR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    ARPen("ARPen", "物理防御貫通"), ARPenPerLv,

    /** Percentage Penetration */
    ARPenRatio(ARPen), ARPenRatioPerLv, BounusARPenRatio("増加ARPen"),

    /** Flat Reduction */
    ARReduction("AR減少", "物理防御減少"),

    /** Percentage Reduction */
    ARReductionRatio(ARReduction),

    // ==================================================
    // MR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    MRPen("MRPen", "魔法防御貫通"), MRPenPerLv,

    /** Percentage Penetration */
    MRPenRatio(MRPen), MRPenRatioPerLv,

    /** Flat Reduction */
    MRReduction("MR減少", "魔法防御減少"),

    /** Percentage Reduction */
    MRReductionRatio(MRReduction),

    // ==================================================
    // Defense Related
    // ==================================================
    /** Attack Damage Resistance */
    AR("AR", "物理防御"), ARPerLv, ARRatio(AR, 3), BounusAR("BounusAR", "増加物理防御"),

    /** Magic Damage Resistance */
    MR("MR", "魔法防御"), MRPerLv, MRRatio(MR, 3), BounusMR("BounusMR", "増加魔法防御"),

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
    MSSlowReduction("Slow", "スロー"), MSSlowReductionRatio(MSSlowReduction),

    /** Shield */
    Shield("Shield", "シールド"), PhysicalShield("物理DM用シールド"), MagicShield("魔法DM用シールド"), SpellShield("スペルシールド"),

    // ==================================================
    // Other Status Related
    // ==================================================
    /** Range */
    Range("Range", "射程"), RangePerLv, RangeRatio(Range),

    /** Grow Body Size */
    Grow("サイズ"),

    /** Level */
    Lv,

    /** Tenacity */
    Tenacity("Tenacity", "耐性"), TenacityPerLv,

    /** Experiment */
    Experiment("経験値"), ExperimentRatio("経験値"),

    /** Cooldown */
    CD("CD", "クールダウン", 2), CDPerLv, CDDecrease(CD, 2), CDDecreaseRatio(CD, 1), ItemCD(CD, 1),

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

    NearSight("視界減少", 3),

    Taunt("タウント", 3),

    Suppression("サプレッション", 3),

    Knockup("打ち上げ", 3),

    Knockback("ノックバック"),

    Slow("移動及び攻撃速度低下"), SlowRatio(Slow),

    MSSlow("移動速度低下"), MSSlowRatio("Slow", "スロー"),

    ASSlow("攻撃速度低下"), ASSlowRatio(ASSlow),

    Wounds("重傷"),

    Foggy("視界低下"),

    // ==================================================
    // Movement Related
    // ==================================================
    /** Movement Speed */
    MS("MS", "移動速度"), MSPerLv, MSRatio("移動速度"), BounusMS("増加移動速度"),

    /** Reduction. */
    MSReduction(MS),

    /** Ignore Slow */
    IgnoreSlow(MSSlow.name + "無効"),

    /** Ignore Unit Collision */
    IgnoreUnitCollision("ユニット衝突無効"),

    /** Ignore Unit Collision */
    IgnoreDamage("ダメージ無効"),

    /** Ignore Crowd Control */
    IgnoreCC("CC無効"),

    /** Remove Crowd Control */
    RemoveCC("全てのCCを解除"),

    Untargetable("対象不可"),

    Stasis("対象及び操作不可"),

    Dash("移動"),

    DashTarget("突撃"),

    Blink("テレポート"),

    BlinkTarget("テレポート"),

    BlinkExchange("入れ替わる"),

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

    Takedown("キルかアシストを取る"),

    ResetAATimer("通常攻撃タイマーを解消する"),

    Value("", 0),

    Percentage(""),

    Charge,

    Fury("Fury"),

    Stack("スタック"), ConsumedStack("消費したスタック"), StackPercentage("");

    /** The status name. */
    private final String name;

    /** The status name. */
    private final String localized;

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
     * @param name
     */
    private Status(String name, String localized) {
        this(name, localized, 1);
    }

    /**
     * @param status
     */
    private Status(Status status) {
        this(status.name, status.localized, 1);
    }

    /**
     * @param precision
     */
    private Status(int precision) {
        this((String) null, precision);
    }

    /**
     * @param name
     */
    private Status(String name, int precision) {
        this(name, name, precision);
    }

    /**
     * @param name
     */
    private Status(Status status, int precision) {
        this(status.name, status.localized, precision);
    }

    /**
     * @param name
     */
    private Status(String name, String localized, int precision) {
        this.name = name == null ? name() : name;
        this.localized = name == null ? name() : localized;
        this.precision = precision;
    }

    /**
     * <p>
     * Returns the name of this status.
     * </p>
     * 
     * @return A status name.
     */
    public String getName() {
        return I.make(UserPreference.class).localeStatus.getValue() == Locale.ENGLISH ? name : localized;
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
        case NearSight:
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
        case DamageRatio:
        case CriticalDamageRatio:
        case AttackDamage:
        case AttackDamageRatio:
        case MS:
        case MSRatio:
        case AS:
        case BounusASRatio:
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
            return getName() + "が" + formatValue(Math.abs(computed)) + (0 <= computed ? "増加" : "減少");

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
            return getName() + "を" + formatValue(computed) + "軽減";

        case ADReduction:
        case MSReduction:
        case DamageDecreaseRatio:
            return getName() + "が" + formatValue(computed) + "減少";

        case LoseHealth:
            return getName() + "を" + formatValue(computed) + "消費";

        case RestoreEnergy:
        case RestoreHealth:
        case RestoreMana:
            return getName() + "が" + formatValue(computed) + "回復";

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

        case Blink:
        case BlinkExchange:
        case BlinkTarget:
        case Knockback:
            String length = formatValue(computed);

            if (length.length() == 0) {
                return getName();
            } else {
                return getName() + "(距離" + formatValue(computed) + ")";
            }

        case Dash:
        case DashTarget:
            String speed = formatValue(computed);

            if (speed.length() == 0) {
                return getName();
            } else {
                return getName() + "(速度" + formatValue(computed) + ")";
            }

        case Stack:
        case ConsumedStack:
            return formatValue(computed) + "スタック";
        }
        return getName() + formatValue(computed);
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
        return getName();
    }
}
