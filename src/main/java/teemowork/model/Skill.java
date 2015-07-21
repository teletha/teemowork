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

import static teemowork.model.SkillKey.*;
import static teemowork.model.Status.*;
import static teemowork.model.Version.*;

import teemowork.api.RiotChampionData;
import teemowork.model.variable.VariableResolver.Diff;
import teemowork.model.variable.VariableResolver.Fixed;
import teemowork.model.variable.VariableResolver.Per1Level;
import teemowork.model.variable.VariableResolver.Per2Level;
import teemowork.model.variable.VariableResolver.Per3Level;
import teemowork.model.variable.VariableResolver.Per3LevelAdditional;
import teemowork.model.variable.VariableResolver.Per3LevelForKarma;
import teemowork.model.variable.VariableResolver.Per4Level;
import teemowork.model.variable.VariableResolver.Per4LevelForTrundle;
import teemowork.model.variable.VariableResolver.Per5Level;
import teemowork.model.variable.VariableResolver.Per5Level3Times;
import teemowork.model.variable.VariableResolver.Per5LevelForAshe;
import teemowork.model.variable.VariableResolver.Per5LevelForHeimer;
import teemowork.model.variable.VariableResolver.Per5LevelForSejuani;
import teemowork.model.variable.VariableResolver.Per5LevelForYoric;
import teemowork.model.variable.VariableResolver.Per5LevelWith18;
import teemowork.model.variable.VariableResolver.Per6Level;
import teemowork.model.variable.VariableResolver.Per6LevelForVi;
import teemowork.model.variable.VariableResolver.Per6LevelForZed;
import teemowork.model.variable.VariableResolver.Refer;

/**
 * @version 2013/03/29 0:48:02
 */
public class Skill extends Describable<SkillDescriptor> {

    /** Blood Well Definition */
    public static final Skill BloodWell = new Skill(RiotChampionData.Aatrox, 0);

    /** Dark Flight Definition */
    public static final Skill DarkFlight = new Skill(RiotChampionData.Aatrox, 1);

    /** Blood Thirst / Blood Price Definition */
    public static final Skill BloodThirstBloodPrice = new Skill(RiotChampionData.Aatrox, 2);

    /** Blades of Torment Definition */
    public static final Skill BladesOfTorment = new Skill(RiotChampionData.Aatrox, 3);

    /** Massacre Definition */
    public static final Skill Massacre = new Skill(RiotChampionData.Aatrox, 4);

    /** Essence Theft Definition */
    public static final Skill EssenceTheft = new Skill(RiotChampionData.Ahri, 0);

    /** Orb of Deception Definition */
    public static final Skill OrbOfDeception = new Skill(RiotChampionData.Ahri, 1);

    /** Fox-Fire Definition */
    public static final Skill FoxFire = new Skill(RiotChampionData.Ahri, 2);

    /** Charm Definition */
    public static final Skill Charm = new Skill(RiotChampionData.Ahri, 3);

    /** Spirit Rush Definition */
    public static final Skill SpiritRush = new Skill(RiotChampionData.Ahri, 4);

    /** Twin Disciplines Definition */
    public static final Skill TwinDisciplines = new Skill(RiotChampionData.Akali, 0);

    /** Mark of the Assassin Definition */
    public static final Skill MarkOfTheAssassin = new Skill(RiotChampionData.Akali, 1);

    /** Twilight Shroud Definition */
    public static final Skill TwilightShroud = new Skill(RiotChampionData.Akali, 2);

    /** Crescent Slash Definition */
    public static final Skill CrescentSlash = new Skill(RiotChampionData.Akali, 3);

    /** Shadow Dance Definition */
    public static final Skill ShadowDance = new Skill(RiotChampionData.Akali, 4);

    /** Trample Definition */
    public static final Skill Trample = new Skill(RiotChampionData.Alistar, 0);

    /** Pulverize Definition */
    public static final Skill Pulverize = new Skill(RiotChampionData.Alistar, 1);

    /** Headbutt Definition */
    public static final Skill Headbutt = new Skill(RiotChampionData.Alistar, 2);

    /** Triumphant Roar Definition */
    public static final Skill TriumphantRoar = new Skill(RiotChampionData.Alistar, 3);

    /** Unbreakable Will Definition */
    public static final Skill UnbreakableWill = new Skill(RiotChampionData.Alistar, 4);

    /** Cursed Touch Definition */
    public static final Skill CursedTouch = new Skill(RiotChampionData.Amumu, 0);

    /** Bandage Toss Definition */
    public static final Skill BandageToss = new Skill(RiotChampionData.Amumu, 1);

    /** Despair Definition */
    public static final Skill Despair = new Skill(RiotChampionData.Amumu, 2);

    /** Tantrum Definition */
    public static final Skill Tantrum = new Skill(RiotChampionData.Amumu, 3);

    /** Curse of the Sad Mummy Definition */
    public static final Skill CurseOfTheSadMummy = new Skill(RiotChampionData.Amumu, 4);

    /** Rebirth Definition */
    public static final Skill Rebirth = new Skill(RiotChampionData.Anivia, 0);

    /** Flash Frost Definition */
    public static final Skill FlashFrost = new Skill(RiotChampionData.Anivia, 1);

    /** Crystallize Definition */
    public static final Skill Crystallize = new Skill(RiotChampionData.Anivia, 2);

    /** Frostbite Definition */
    public static final Skill Frostbite = new Skill(RiotChampionData.Anivia, 3);

    /** Glacial Storm Definition */
    public static final Skill GlacialStorm = new Skill(RiotChampionData.Anivia, 4);

    /** Pyromania Definition */
    public static final Skill Pyromania = new Skill(RiotChampionData.Annie, 0);

    /** Disintegrate Definition */
    public static final Skill Disintegrate = new Skill(RiotChampionData.Annie, 1);

    /** Incinerate Definition */
    public static final Skill Incinerate = new Skill(RiotChampionData.Annie, 2);

    /** Molten Shield Definition */
    public static final Skill MoltenShield = new Skill(RiotChampionData.Annie, 3);

    /** Summon: Tibbers Definition */
    public static final Skill SummonTibbers = new Skill(RiotChampionData.Annie, 4);

    /** Frost Shot Definition */
    public static final Skill FrostShot = new Skill(RiotChampionData.Ashe, 0);

    /** Ranger's Focus Definition */
    public static final Skill RangersFocus = new Skill(RiotChampionData.Ashe, 1);

    /** Volley Definition */
    public static final Skill Volley = new Skill(RiotChampionData.Ashe, 2);

    /** Hawkshot Definition */
    public static final Skill Hawkshot = new Skill(RiotChampionData.Ashe, 3);

    /** Enchanted Crystal Arrow Definition */
    public static final Skill EnchantedCrystalArrow = new Skill(RiotChampionData.Ashe, 4);

    /** Shurima's Legacy Definition */
    public static final Skill ShurimasLegacy = new Skill(RiotChampionData.Azir, 0);

    /** Conquering Sands Definition */
    public static final Skill ConqueringSands = new Skill(RiotChampionData.Azir, 1);

    /** Arise! Definition */
    public static final Skill Arise = new Skill(RiotChampionData.Azir, 2);

    /** Shifting Sands Definition */
    public static final Skill ShiftingSands = new Skill(RiotChampionData.Azir, 3);

    /** Emperor's Divide Definition */
    public static final Skill EmperorsDivide = new Skill(RiotChampionData.Azir, 4);

    /** Traveler's Call Definition */
    public static final Skill TravelersCall = new Skill(RiotChampionData.Bard, 0);

    /** Cosmic Binding Definition */
    public static final Skill CosmicBinding = new Skill(RiotChampionData.Bard, 1);

    /** Caretaker's Shrine Definition */
    public static final Skill CaretakersShrine = new Skill(RiotChampionData.Bard, 2);

    /** Magical Journey Definition */
    public static final Skill MagicalJourney = new Skill(RiotChampionData.Bard, 3);

    /** Tempered Fate Definition */
    public static final Skill TemperedFate = new Skill(RiotChampionData.Bard, 4);

    /** Mana Barrier Definition */
    public static final Skill ManaBarrier = new Skill(RiotChampionData.Blitzcrank, 0);

    /** Rocket Grab Definition */
    public static final Skill RocketGrab = new Skill(RiotChampionData.Blitzcrank, 1);

    /** Overdrive Definition */
    public static final Skill Overdrive = new Skill(RiotChampionData.Blitzcrank, 2);

    /** Power Fist Definition */
    public static final Skill PowerFist = new Skill(RiotChampionData.Blitzcrank, 3);

    /** Static Field Definition */
    public static final Skill StaticField = new Skill(RiotChampionData.Blitzcrank, 4);

    /** Blaze Definition */
    public static final Skill Blaze = new Skill(RiotChampionData.Brand, 0);

    /** Sear Definition */
    public static final Skill Sear = new Skill(RiotChampionData.Brand, 1);

    /** Pillar of Flame Definition */
    public static final Skill PillarOfFlame = new Skill(RiotChampionData.Brand, 2);

    /** Conflagration Definition */
    public static final Skill Conflagration = new Skill(RiotChampionData.Brand, 3);

    /** Pyroclasm Definition */
    public static final Skill Pyroclasm = new Skill(RiotChampionData.Brand, 4);

    /** Concussive Blows Definition */
    public static final Skill ConcussiveBlows = new Skill(RiotChampionData.Braum, 0);

    /** Winter's Bite Definition */
    public static final Skill WintersBite = new Skill(RiotChampionData.Braum, 1);

    /** Stand Behind Me Definition */
    public static final Skill StandBehindMe = new Skill(RiotChampionData.Braum, 2);

    /** Unbreakable Definition */
    public static final Skill Unbreakable = new Skill(RiotChampionData.Braum, 3);

    /** Glacial Fissure Definition */
    public static final Skill GlacialFissure = new Skill(RiotChampionData.Braum, 4);

    /** Headshot Definition */
    public static final Skill Headshot = new Skill(RiotChampionData.Caitlyn, 0);

    /** Piltover Peacemaker Definition */
    public static final Skill PiltoverPeacemaker = new Skill(RiotChampionData.Caitlyn, 1);

    /** Yordle Snap Trap Definition */
    public static final Skill YordleSnapTrap = new Skill(RiotChampionData.Caitlyn, 2);

    /** 90 Caliber Net Definition */
    public static final Skill CaliberNet = new Skill(RiotChampionData.Caitlyn, 3);

    /** Ace in the Hole Definition */
    public static final Skill AceinTheHole = new Skill(RiotChampionData.Caitlyn, 4);

    /** Aspect of the Serpent Definition */
    public static final Skill AspectOfTheSerpent = new Skill(RiotChampionData.Cassiopeia, 0);

    /** Noxious Blast Definition */
    public static final Skill NoxiousBlast = new Skill(RiotChampionData.Cassiopeia, 1);

    /** Miasma Definition */
    public static final Skill Miasma = new Skill(RiotChampionData.Cassiopeia, 2);

    /** Twin Fang Definition */
    public static final Skill TwinFang = new Skill(RiotChampionData.Cassiopeia, 3);

    /** Petrifying Gaze Definition */
    public static final Skill PetrifyingGaze = new Skill(RiotChampionData.Cassiopeia, 4);

    /** Carnivore Definition */
    public static final Skill Carnivore = new Skill(RiotChampionData.Chogath, 0);

    /** Rupture Definition */
    public static final Skill Rupture = new Skill(RiotChampionData.Chogath, 1);

    /** Feral Scream Definition */
    public static final Skill FeralScream = new Skill(RiotChampionData.Chogath, 2);

    /** Vorpal Spikes Definition */
    public static final Skill VorpalSpikes = new Skill(RiotChampionData.Chogath, 3);

    /** Feast Definition */
    public static final Skill Feast = new Skill(RiotChampionData.Chogath, 4);

    /** Hextech Shrapnel Shells Definition */
    public static final Skill HextechShrapnelShells = new Skill(RiotChampionData.Corki, 0);

    /** Phosphorus Bomb Definition */
    public static final Skill PhosphorusBomb = new Skill(RiotChampionData.Corki, 1);

    /** Valkyrie Definition */
    public static final Skill Valkyrie = new Skill(RiotChampionData.Corki, 2);

    /** Gatling Gun Definition */
    public static final Skill GatlingGun = new Skill(RiotChampionData.Corki, 3);

    /** Missile Barrage Definition */
    public static final Skill MissileBarrage = new Skill(RiotChampionData.Corki, 4);

    /** Hemorrhage Definition */
    public static final Skill Hemorrhage = new Skill(RiotChampionData.Darius, 0);

    /** Decimate Definition */
    public static final Skill Decimate = new Skill(RiotChampionData.Darius, 1);

    /** Crippling Strike Definition */
    public static final Skill CripplingStrike = new Skill(RiotChampionData.Darius, 2);

    /** Apprehend Definition */
    public static final Skill Apprehend = new Skill(RiotChampionData.Darius, 3);

    /** Noxian Guillotine Definition */
    public static final Skill NoxianGuillotine = new Skill(RiotChampionData.Darius, 4);

    /** Moonsilver Blade Definition */
    public static final Skill MoonsilverBlade = new Skill(RiotChampionData.Diana, 0);

    /** Crescent Strike Definition */
    public static final Skill CrescentStrike = new Skill(RiotChampionData.Diana, 1);

    /** Pale Cascade Definition */
    public static final Skill PaleCascade = new Skill(RiotChampionData.Diana, 2);

    /** Moonfall Definition */
    public static final Skill Moonfall = new Skill(RiotChampionData.Diana, 3);

    /** Lunar Rush Definition */
    public static final Skill LunarRush = new Skill(RiotChampionData.Diana, 4);

    /** League of Draven Definition */
    public static final Skill LeagueOfDraven = new Skill(RiotChampionData.Draven, 0);

    /** Spinning Axe Definition */
    public static final Skill SpinningAxe = new Skill(RiotChampionData.Draven, 1);

    /** Blood Rush Definition */
    public static final Skill BloodRush = new Skill(RiotChampionData.Draven, 2);

    /** Stand Aside Definition */
    public static final Skill StandAside = new Skill(RiotChampionData.Draven, 3);

    /** Whirling Death Definition */
    public static final Skill WhirlingDeath = new Skill(RiotChampionData.Draven, 4);

    /** Adrenaline Rush Definition */
    public static final Skill AdrenalineRush = new Skill(RiotChampionData.DrMundo, 0);

    /** Infected Cleaver Definition */
    public static final Skill InfectedCleaver = new Skill(RiotChampionData.DrMundo, 1);

    /** Burning Agony Definition */
    public static final Skill BurningAgony = new Skill(RiotChampionData.DrMundo, 2);

    /** Masochism Definition */
    public static final Skill Masochism = new Skill(RiotChampionData.DrMundo, 3);

    /** Sadism Definition */
    public static final Skill Sadism = new Skill(RiotChampionData.DrMundo, 4);

    /** Z-Drive Resonance Definition */
    public static final Skill ZDriveResonance = new Skill(RiotChampionData.Ekko, 0);

    /** Timewinder Definition */
    public static final Skill Timewinder = new Skill(RiotChampionData.Ekko, 1);

    /** Parallel Convergence Definition */
    public static final Skill ParallelConvergence = new Skill(RiotChampionData.Ekko, 2);

    /** Phase Dive Definition */
    public static final Skill PhaseDive = new Skill(RiotChampionData.Ekko, 3);

    /** Chronobreak Definition */
    public static final Skill Chronobreak = new Skill(RiotChampionData.Ekko, 4);

    /** Spider Queen Definition */
    public static final Skill SpiderQueen = new Skill(RiotChampionData.Elise, 0);

    /** Neurotoxin / Venomous Bite Definition */
    public static final Skill NeurotoxinVenomousBite = new Skill(RiotChampionData.Elise, 1);

    /** Volatile Spiderling / Skittering Frenzy Definition */
    public static final Skill VolatileSpiderlingSkitteringFrenzy = new Skill(RiotChampionData.Elise, 2);

    /** Cocoon / Rappel Definition */
    public static final Skill CocoonRappel = new Skill(RiotChampionData.Elise, 3);

    /** Spider Form Definition */
    public static final Skill SpiderForm = new Skill(RiotChampionData.Elise, 4);

    /** Venomous Bite / Neurotoxin Definition */
    public static final Skill VenomousBiteNeurotoxin = new Skill(RiotChampionData.Elise, 5);

    /** Skittering Frenzy / Volatile Spiderling Definition */
    public static final Skill SkitteringFrenzyVolatileSpiderling = new Skill(RiotChampionData.Elise, 6);

    /** Rappel / Cocoon Definition */
    public static final Skill RappelCocoon = new Skill(RiotChampionData.Elise, 7);

    /** Human Form Definition */
    public static final Skill HumanForm = new Skill(RiotChampionData.Elise, 8);

    /** Shadow Walk Definition */
    public static final Skill ShadowWalk = new Skill(RiotChampionData.Evelynn, 0);

    /** Hate Spike Definition */
    public static final Skill HateSpike = new Skill(RiotChampionData.Evelynn, 1);

    /** Dark Frenzy Definition */
    public static final Skill DarkFrenzy = new Skill(RiotChampionData.Evelynn, 2);

    /** Ravage Definition */
    public static final Skill Ravage = new Skill(RiotChampionData.Evelynn, 3);

    /** Agony's Embrace Definition */
    public static final Skill AgonysEmbrace = new Skill(RiotChampionData.Evelynn, 4);

    /** Rising Spell Force Definition */
    public static final Skill RisingSpellForce = new Skill(RiotChampionData.Ezreal, 0);

    /** Mystic Shot Definition */
    public static final Skill MysticShot = new Skill(RiotChampionData.Ezreal, 1);

    /** Essence Flux Definition */
    public static final Skill EssenceFlux = new Skill(RiotChampionData.Ezreal, 2);

    /** Arcane Shift Definition */
    public static final Skill ArcaneShift = new Skill(RiotChampionData.Ezreal, 3);

    /** Trueshot Barrage Definition */
    public static final Skill TrueshotBarrage = new Skill(RiotChampionData.Ezreal, 4);

    /** Dread Definition */
    public static final Skill Dread = new Skill(RiotChampionData.FiddleSticks, 0);

    /** Terrify Definition */
    public static final Skill Terrify = new Skill(RiotChampionData.FiddleSticks, 1);

    /** Drain Definition */
    public static final Skill Drain = new Skill(RiotChampionData.FiddleSticks, 2);

    /** Dark Wind Definition */
    public static final Skill DarkWind = new Skill(RiotChampionData.FiddleSticks, 3);

    /** Crowstorm Definition */
    public static final Skill Crowstorm = new Skill(RiotChampionData.FiddleSticks, 4);

    /** Duelist Definition */
    public static final Skill Duelist = new Skill(RiotChampionData.Fiora, 0);

    /** Lunge Definition */
    public static final Skill Lunge = new Skill(RiotChampionData.Fiora, 1);

    /** Riposte Definition */
    public static final Skill Riposte = new Skill(RiotChampionData.Fiora, 2);

    /** Burst of Speed Definition */
    public static final Skill BurstOfSpeed = new Skill(RiotChampionData.Fiora, 3);

    /** Blade Waltz Definition */
    public static final Skill BladeWaltz = new Skill(RiotChampionData.Fiora, 4);

    /** Nimble Fighter Definition */
    public static final Skill NimbleFighter = new Skill(RiotChampionData.Fizz, 0);

    /** Urchin Strike Definition */
    public static final Skill UrchinStrike = new Skill(RiotChampionData.Fizz, 1);

    /** Seastone Trident Definition */
    public static final Skill SeastoneTrident = new Skill(RiotChampionData.Fizz, 2);

    /** Playful / Trickster Definition */
    public static final Skill PlayfulTrickster = new Skill(RiotChampionData.Fizz, 3);

    /** Chum the Waters Definition */
    public static final Skill ChumTheWaters = new Skill(RiotChampionData.Fizz, 4);

    /** Runic Skin Definition */
    public static final Skill RunicSkin = new Skill(RiotChampionData.Galio, 0);

    /** Resolute Smite Definition */
    public static final Skill ResoluteSmite = new Skill(RiotChampionData.Galio, 1);

    /** Bulwark Definition */
    public static final Skill Bulwark = new Skill(RiotChampionData.Galio, 2);

    /** Righteous Gust Definition */
    public static final Skill RighteousGust = new Skill(RiotChampionData.Galio, 3);

    /** Idol of Durand Definition */
    public static final Skill IdolOfDurand = new Skill(RiotChampionData.Galio, 4);

    /** Grog-Soaked Blade Definition */
    public static final Skill GrogSoakedBlade = new Skill(RiotChampionData.Gangplank, 0);

    /** Parrrley Definition */
    public static final Skill Parrrley = new Skill(RiotChampionData.Gangplank, 1);

    /** Remove Scurvy Definition */
    public static final Skill RemoveScurvy = new Skill(RiotChampionData.Gangplank, 2);

    /** Raise Morale Definition */
    public static final Skill RaiseMorale = new Skill(RiotChampionData.Gangplank, 3);

    /** Cannon Barrage Definition */
    public static final Skill CannonBarrage = new Skill(RiotChampionData.Gangplank, 4);

    /** Perseverance Definition */
    public static final Skill Perseverance = new Skill(RiotChampionData.Garen, 0);

    /** Decisive Strike Definition */
    public static final Skill DecisiveStrike = new Skill(RiotChampionData.Garen, 1);

    /** Courage Definition */
    public static final Skill Courage = new Skill(RiotChampionData.Garen, 2);

    /** Judgment Definition */
    public static final Skill Judgment = new Skill(RiotChampionData.Garen, 3);

    /** Demacian Justice Definition */
    public static final Skill DemacianJustice = new Skill(RiotChampionData.Garen, 4);

    /** Rage Gene Definition */
    public static final Skill RageGene = new Skill(RiotChampionData.Gnar, 0);

    /** Boomerang Throw / Boulder Toss Definition */
    public static final Skill BoomerangThrowBoulderToss = new Skill(RiotChampionData.Gnar, 1);

    /** Hyper / Wallop Definition */
    public static final Skill HyperWallop = new Skill(RiotChampionData.Gnar, 2);

    /** Hop / Crunch Definition */
    public static final Skill HopCrunch = new Skill(RiotChampionData.Gnar, 3);

    /** GNAR! Definition */
    public static final Skill GNAR = new Skill(RiotChampionData.Gnar, 4);

    /** Happy Hour Definition */
    public static final Skill HappyHour = new Skill(RiotChampionData.Gragas, 0);

    /** Barrel Roll Definition */
    public static final Skill BarrelRoll = new Skill(RiotChampionData.Gragas, 1);

    /** Drunken Rage Definition */
    public static final Skill DrunkenRage = new Skill(RiotChampionData.Gragas, 2);

    /** Body Slam Definition */
    public static final Skill BodySlam = new Skill(RiotChampionData.Gragas, 3);

    /** Explosive Cask Definition */
    public static final Skill ExplosiveCask = new Skill(RiotChampionData.Gragas, 4);

    /** True Grit Definition */
    public static final Skill TrueGrit = new Skill(RiotChampionData.Graves, 0);

    /** Buckshot Definition */
    public static final Skill Buckshot = new Skill(RiotChampionData.Graves, 1);

    /** Smoke Screen Definition */
    public static final Skill SmokeScreen = new Skill(RiotChampionData.Graves, 2);

    /** Quickdraw Definition */
    public static final Skill Quickdraw = new Skill(RiotChampionData.Graves, 3);

    /** Collateral Damage Definition */
    public static final Skill CollateralDamage = new Skill(RiotChampionData.Graves, 4);

    /** Warpath Definition */
    public static final Skill Warpath = new Skill(RiotChampionData.Hecarim, 0);

    /** Rampage Definition */
    public static final Skill Rampage = new Skill(RiotChampionData.Hecarim, 1);

    /** Spirit of Dread Definition */
    public static final Skill SpiritOfDread = new Skill(RiotChampionData.Hecarim, 2);

    /** Devastating Charge Definition */
    public static final Skill DevastatingCharge = new Skill(RiotChampionData.Hecarim, 3);

    /** Onslaught of Shadows Definition */
    public static final Skill OnslaughtOfShadows = new Skill(RiotChampionData.Hecarim, 4);

    /** Techmaturgical Repair Bots Definition */
    public static final Skill TechmaturgicalRepairBots = new Skill(RiotChampionData.Heimerdinger, 0);

    /** H-28G Evolution Turret Definition */
    public static final Skill H28GEvolutionTurret = new Skill(RiotChampionData.Heimerdinger, 1);

    /** Hextech Micro-Rockets Definition */
    public static final Skill HextechMicroRockets = new Skill(RiotChampionData.Heimerdinger, 2);

    /** CH-2 Electron Storm Grenade Definition */
    public static final Skill CH2ElectronStormGrenade = new Skill(RiotChampionData.Heimerdinger, 3);

    /** UPGRADE!!! Definition */
    public static final Skill UPGRADE = new Skill(RiotChampionData.Heimerdinger, 4);

    /** Ionian Fervor Definition */
    public static final Skill IonianFervor = new Skill(RiotChampionData.Irelia, 0);

    /** Bladesurge Definition */
    public static final Skill Bladesurge = new Skill(RiotChampionData.Irelia, 1);

    /** Hiten Style Definition */
    public static final Skill HitenStyle = new Skill(RiotChampionData.Irelia, 2);

    /** Equilibrium Strike Definition */
    public static final Skill EquilibriumStrike = new Skill(RiotChampionData.Irelia, 3);

    /** Transcendent Blades Definition */
    public static final Skill TranscendentBlades = new Skill(RiotChampionData.Irelia, 4);

    /** Tailwind Definition */
    public static final Skill Tailwind = new Skill(RiotChampionData.Janna, 0);

    /** Howling Gale Definition */
    public static final Skill HowlingGale = new Skill(RiotChampionData.Janna, 1);

    /** Zephyr Definition */
    public static final Skill Zephyr = new Skill(RiotChampionData.Janna, 2);

    /** Eye Of The Storm Definition */
    public static final Skill EyeOfTheStorm = new Skill(RiotChampionData.Janna, 3);

    /** Monsoon Definition */
    public static final Skill Monsoon = new Skill(RiotChampionData.Janna, 4);

    /** Martial Cadence Definition */
    public static final Skill MartialCadence = new Skill(RiotChampionData.JarvanIV, 0);

    /** Dragon Strike Definition */
    public static final Skill DragonStrike = new Skill(RiotChampionData.JarvanIV, 1);

    /** Golden Aegis Definition */
    public static final Skill GoldenAegis = new Skill(RiotChampionData.JarvanIV, 2);

    /** Demacian Standard Definition */
    public static final Skill DemacianStandard = new Skill(RiotChampionData.JarvanIV, 3);

    /** Cataclysm Definition */
    public static final Skill Cataclysm = new Skill(RiotChampionData.JarvanIV, 4);

    /** Relentless Assault Definition */
    public static final Skill RelentlessAssault = new Skill(RiotChampionData.Jax, 0);

    /** Leap Strike Definition */
    public static final Skill LeapStrike = new Skill(RiotChampionData.Jax, 1);

    /** Empower Definition */
    public static final Skill Empower = new Skill(RiotChampionData.Jax, 2);

    /** Counter Strike Definition */
    public static final Skill CounterStrike = new Skill(RiotChampionData.Jax, 3);

    /** Grandmaster's Might Definition */
    public static final Skill GrandmastersMight = new Skill(RiotChampionData.Jax, 4);

    /** Hextech Capacitor Definition */
    public static final Skill HextechCapacitor = new Skill(RiotChampionData.Jayce, 0);

    /** To the Skies! / Shock Blast Definition */
    public static final Skill ToTheSkiesShockBlast = new Skill(RiotChampionData.Jayce, 1);

    /** Lightning Field / Hyper Charge Definition */
    public static final Skill LightningFieldHyperCharge = new Skill(RiotChampionData.Jayce, 2);

    /** Thundering Blow / Acceleration Gate Definition */
    public static final Skill ThunderingBlowAccelerationGate = new Skill(RiotChampionData.Jayce, 3);

    /** Mercury Cannon / Mercury Hammer Definition */
    public static final Skill MercuryCannonMercuryHammer = new Skill(RiotChampionData.Jayce, 4);

    /** Shock Blast Definition */
    public static final Skill ShockBlast = new Skill(RiotChampionData.Jayce, 5);

    /** Hyper Charge Definition */
    public static final Skill HyperCharge = new Skill(RiotChampionData.Jayce, 6);

    /** Acceleration Gate Definition */
    public static final Skill AccelerationGate = new Skill(RiotChampionData.Jayce, 7);

    /** Mercury Hammer Definition */
    public static final Skill MercuryHammer = new Skill(RiotChampionData.Jayce, 8);

    /** Get Excited! Definition */
    public static final Skill GetExcited = new Skill(RiotChampionData.Jinx, 0);

    /** Switcheroo! Definition */
    public static final Skill Switcheroo = new Skill(RiotChampionData.Jinx, 1);

    /** Zap! Definition */
    public static final Skill Zap = new Skill(RiotChampionData.Jinx, 2);

    /** Flame Chompers! Definition */
    public static final Skill FlameChompers = new Skill(RiotChampionData.Jinx, 3);

    /** Super Mega Death Rocket! Definition */
    public static final Skill SuperMegaDeathRocket = new Skill(RiotChampionData.Jinx, 4);

    /** Martial Poise Definition */
    public static final Skill MartialPoise = new Skill(RiotChampionData.Kalista, 0);

    /** Pierce Definition */
    public static final Skill Pierce = new Skill(RiotChampionData.Kalista, 1);

    /** Sentinel Definition */
    public static final Skill Sentinel = new Skill(RiotChampionData.Kalista, 2);

    /** Rend Definition */
    public static final Skill Rend = new Skill(RiotChampionData.Kalista, 3);

    /** Fate's Call Definition */
    public static final Skill FatesCall = new Skill(RiotChampionData.Kalista, 4);

    /** Gathering Fire Definition */
    public static final Skill GatheringFire = new Skill(RiotChampionData.Karma, 0);

    /** Inner Flame Definition */
    public static final Skill InnerFlame = new Skill(RiotChampionData.Karma, 1);

    /** Focused Resolve Definition */
    public static final Skill FocusedResolve = new Skill(RiotChampionData.Karma, 2);

    /** Inspire Definition */
    public static final Skill Inspire = new Skill(RiotChampionData.Karma, 3);

    /** Mantra Definition */
    public static final Skill Mantra = new Skill(RiotChampionData.Karma, 4);

    /** Death Defied Definition */
    public static final Skill DeathDefied = new Skill(RiotChampionData.Karthus, 0);

    /** Lay Waste Definition */
    public static final Skill LayWaste = new Skill(RiotChampionData.Karthus, 1);

    /** Wall of Pain Definition */
    public static final Skill WallOfPain = new Skill(RiotChampionData.Karthus, 2);

    /** Defile Definition */
    public static final Skill Defile = new Skill(RiotChampionData.Karthus, 3);

    /** Requiem Definition */
    public static final Skill Requiem = new Skill(RiotChampionData.Karthus, 4);

    /** Void Stone Definition */
    public static final Skill VoidStone = new Skill(RiotChampionData.Kassadin, 0);

    /** Null Sphere Definition */
    public static final Skill NullSphere = new Skill(RiotChampionData.Kassadin, 1);

    /** Nether Blade Definition */
    public static final Skill NetherBlade = new Skill(RiotChampionData.Kassadin, 2);

    /** Force Pulse Definition */
    public static final Skill ForcePulse = new Skill(RiotChampionData.Kassadin, 3);

    /** Riftwalk Definition */
    public static final Skill Riftwalk = new Skill(RiotChampionData.Kassadin, 4);

    /** Voracity Definition */
    public static final Skill Voracity = new Skill(RiotChampionData.Katarina, 0);

    /** Bouncing Blades Definition */
    public static final Skill BouncingBlades = new Skill(RiotChampionData.Katarina, 1);

    /** Sinister Steel Definition */
    public static final Skill SinisterSteel = new Skill(RiotChampionData.Katarina, 2);

    /** Shunpo Definition */
    public static final Skill Shunpo = new Skill(RiotChampionData.Katarina, 3);

    /** Death Lotus Definition */
    public static final Skill DeathLotus = new Skill(RiotChampionData.Katarina, 4);

    /** Holy Fervor Definition */
    public static final Skill HolyFervor = new Skill(RiotChampionData.Kayle, 0);

    /** Reckoning Definition */
    public static final Skill Reckoning = new Skill(RiotChampionData.Kayle, 1);

    /** Divine Blessing Definition */
    public static final Skill DivineBlessing = new Skill(RiotChampionData.Kayle, 2);

    /** Righteous Fury Definition */
    public static final Skill RighteousFury = new Skill(RiotChampionData.Kayle, 3);

    /** Intervention Definition */
    public static final Skill Intervention = new Skill(RiotChampionData.Kayle, 4);

    /** Mark of the Storm Definition */
    public static final Skill MarkOfTheStorm = new Skill(RiotChampionData.Kennen, 0);

    /** Thundering Shuriken Definition */
    public static final Skill ThunderingShuriken = new Skill(RiotChampionData.Kennen, 1);

    /** Electrical Surge Definition */
    public static final Skill ElectricalSurge = new Skill(RiotChampionData.Kennen, 2);

    /** Lightning Rush Definition */
    public static final Skill LightningRush = new Skill(RiotChampionData.Kennen, 3);

    /** Slicing Maelstrom Definition */
    public static final Skill SlicingMaelstrom = new Skill(RiotChampionData.Kennen, 4);

    /** Unseen Threat Definition */
    public static final Skill UnseenThreat = new Skill(RiotChampionData.Khazix, 0);

    /** Taste Their Fear Definition */
    public static final Skill TasteTheirFear = new Skill(RiotChampionData.Khazix, 1);

    /** Void Spike Definition */
    public static final Skill VoidSpike = new Skill(RiotChampionData.Khazix, 2);

    /** Leap Definition */
    public static final Skill Leap = new Skill(RiotChampionData.Khazix, 3);

    /** Void Assault Definition */
    public static final Skill VoidAssault = new Skill(RiotChampionData.Khazix, 4);

    /** Icathian Surprise Definition */
    public static final Skill IcathianSurprise = new Skill(RiotChampionData.KogMaw, 0);

    /** Caustic Spittle Definition */
    public static final Skill CausticSpittle = new Skill(RiotChampionData.KogMaw, 1);

    /** Bio-Arcane Barrage Definition */
    public static final Skill BioArcaneBarrage = new Skill(RiotChampionData.KogMaw, 2);

    /** Void Ooze Definition */
    public static final Skill VoidOoze = new Skill(RiotChampionData.KogMaw, 3);

    /** Living Artillery Definition */
    public static final Skill LivingArtillery = new Skill(RiotChampionData.KogMaw, 4);

    /** Mirror Image Definition */
    public static final Skill MirrorImage = new Skill(RiotChampionData.Leblanc, 0);

    /** Sigil of Malice Definition */
    public static final Skill SigilOfMalice = new Skill(RiotChampionData.Leblanc, 1);

    /** Distortion Definition */
    public static final Skill Distortion = new Skill(RiotChampionData.Leblanc, 2);

    /** Ethereal Chains Definition */
    public static final Skill EtherealChains = new Skill(RiotChampionData.Leblanc, 3);

    /** Mimic Definition */
    public static final Skill Mimic = new Skill(RiotChampionData.Leblanc, 4);

    /** Flurry Definition */
    public static final Skill Flurry = new Skill(RiotChampionData.LeeSin, 0);

    /** Sonic Wave / Resonating Strike Definition */
    public static final Skill SonicWaveResonatingStrike = new Skill(RiotChampionData.LeeSin, 1);

    /** Safeguard / Iron Will Definition */
    public static final Skill SafeguardIronWill = new Skill(RiotChampionData.LeeSin, 2);

    /** Tempest / Cripple Definition */
    public static final Skill TempestCripple = new Skill(RiotChampionData.LeeSin, 3);

    /** Dragon's Rage Definition */
    public static final Skill DragonsRage = new Skill(RiotChampionData.LeeSin, 4);

    /** Sunlight Definition */
    public static final Skill Sunlight = new Skill(RiotChampionData.Leona, 0);

    /** Shield of Daybreak Definition */
    public static final Skill ShieldOfDaybreak = new Skill(RiotChampionData.Leona, 1);

    /** Eclipse Definition */
    public static final Skill Eclipse = new Skill(RiotChampionData.Leona, 2);

    /** Zenith Blade Definition */
    public static final Skill ZenithBlade = new Skill(RiotChampionData.Leona, 3);

    /** Solar Flare Definition */
    public static final Skill SolarFlare = new Skill(RiotChampionData.Leona, 4);

    /** Iceborn Definition */
    public static final Skill Iceborn = new Skill(RiotChampionData.Lissandra, 0);

    /** Ice Shard Definition */
    public static final Skill IceShard = new Skill(RiotChampionData.Lissandra, 1);

    /** Ring of Frost Definition */
    public static final Skill RingOfFrost = new Skill(RiotChampionData.Lissandra, 2);

    /** Glacial Path Definition */
    public static final Skill GlacialPath = new Skill(RiotChampionData.Lissandra, 3);

    /** Frozen Tomb Definition */
    public static final Skill FrozenTomb = new Skill(RiotChampionData.Lissandra, 4);

    /** Lightslinger Definition */
    public static final Skill Lightslinger = new Skill(RiotChampionData.Lucian, 0);

    /** Piercing Light Definition */
    public static final Skill PiercingLight = new Skill(RiotChampionData.Lucian, 1);

    /** Ardent Blaze Definition */
    public static final Skill ArdentBlaze = new Skill(RiotChampionData.Lucian, 2);

    /** Relentless Pursuit Definition */
    public static final Skill RelentlessPursuit = new Skill(RiotChampionData.Lucian, 3);

    /** The Culling Definition */
    public static final Skill TheCulling = new Skill(RiotChampionData.Lucian, 4);

    /** Pix, Faerie Companion Definition */
    public static final Skill PixFaerieCompanion = new Skill(RiotChampionData.Lulu, 0);

    /** Glitterlance Definition */
    public static final Skill Glitterlance = new Skill(RiotChampionData.Lulu, 1);

    /** Whimsy Definition */
    public static final Skill Whimsy = new Skill(RiotChampionData.Lulu, 2);

    /** Help, Pix! Definition */
    public static final Skill HelpPix = new Skill(RiotChampionData.Lulu, 3);

    /** Wild Growth Definition */
    public static final Skill WildGrowth = new Skill(RiotChampionData.Lulu, 4);

    /** Illumination Definition */
    public static final Skill Illumination = new Skill(RiotChampionData.Lux, 0);

    /** Light Binding Definition */
    public static final Skill LightBinding = new Skill(RiotChampionData.Lux, 1);

    /** Prismatic Barrier Definition */
    public static final Skill PrismaticBarrier = new Skill(RiotChampionData.Lux, 2);

    /** Lucent Singularity Definition */
    public static final Skill LucentSingularity = new Skill(RiotChampionData.Lux, 3);

    /** Final Spark Definition */
    public static final Skill FinalSpark = new Skill(RiotChampionData.Lux, 4);

    /** Granite Shield Definition */
    public static final Skill GraniteShield = new Skill(RiotChampionData.Malphite, 0);

    /** Seismic Shard Definition */
    public static final Skill SeismicShard = new Skill(RiotChampionData.Malphite, 1);

    /** Brutal Strikes Definition */
    public static final Skill BrutalStrikes = new Skill(RiotChampionData.Malphite, 2);

    /** Ground Slam Definition */
    public static final Skill GroundSlam = new Skill(RiotChampionData.Malphite, 3);

    /** Unstoppable Force Definition */
    public static final Skill UnstoppableForce = new Skill(RiotChampionData.Malphite, 4);

    /** Summon Voidling Definition */
    public static final Skill SummonVoidling = new Skill(RiotChampionData.Malzahar, 0);

    /** Call of the Void Definition */
    public static final Skill CallOfTheVoid = new Skill(RiotChampionData.Malzahar, 1);

    /** Null Zone Definition */
    public static final Skill NullZone = new Skill(RiotChampionData.Malzahar, 2);

    /** Malefic Visions Definition */
    public static final Skill MaleficVisions = new Skill(RiotChampionData.Malzahar, 3);

    /** Nether Grasp Definition */
    public static final Skill NetherGrasp = new Skill(RiotChampionData.Malzahar, 4);

    /** Sap Magic Definition */
    public static final Skill SapMagic = new Skill(RiotChampionData.Maokai, 0);

    /** Arcane Smash Definition */
    public static final Skill ArcaneSmash = new Skill(RiotChampionData.Maokai, 1);

    /** Twisted Advance Definition */
    public static final Skill TwistedAdvance = new Skill(RiotChampionData.Maokai, 2);

    /** Sapling Toss Definition */
    public static final Skill SaplingToss = new Skill(RiotChampionData.Maokai, 3);

    /** Vengeful Maelstrom Definition */
    public static final Skill VengefulMaelstrom = new Skill(RiotChampionData.Maokai, 4);

    /** Double Strike Definition */
    public static final Skill DoubleStrike = new Skill(RiotChampionData.MasterYi, 0);

    /** Alpha Strike Definition */
    public static final Skill AlphaStrike = new Skill(RiotChampionData.MasterYi, 1);

    /** Meditate Definition */
    public static final Skill Meditate = new Skill(RiotChampionData.MasterYi, 2);

    /** Wuju Style Definition */
    public static final Skill WujuStyle = new Skill(RiotChampionData.MasterYi, 3);

    /** Highlander Definition */
    public static final Skill Highlander = new Skill(RiotChampionData.MasterYi, 4);

    /** Strut Definition */
    public static final Skill Strut = new Skill(RiotChampionData.MissFortune, 0);

    /** Double Up Definition */
    public static final Skill DoubleUp = new Skill(RiotChampionData.MissFortune, 1);

    /** Impure Shots Definition */
    public static final Skill ImpureShots = new Skill(RiotChampionData.MissFortune, 2);

    /** Make It Rain Definition */
    public static final Skill MakeItRain = new Skill(RiotChampionData.MissFortune, 3);

    /** Bullet Time Definition */
    public static final Skill BulletTime = new Skill(RiotChampionData.MissFortune, 4);

    /** Stone Skin Definition */
    public static final Skill StoneSkin = new Skill(RiotChampionData.MonkeyKing, 0);

    /** Crushing Blow Definition */
    public static final Skill CrushingBlow = new Skill(RiotChampionData.MonkeyKing, 1);

    /** Decoy Definition */
    public static final Skill Decoy = new Skill(RiotChampionData.MonkeyKing, 2);

    /** Nimbus Strike Definition */
    public static final Skill NimbusStrike = new Skill(RiotChampionData.MonkeyKing, 3);

    /** Cyclone Definition */
    public static final Skill Cyclone = new Skill(RiotChampionData.MonkeyKing, 4);

    /** Iron Man Definition */
    public static final Skill IronMan = new Skill(RiotChampionData.Mordekaiser, 0);

    /** Mace of Spades Definition */
    public static final Skill MaceOfSpades = new Skill(RiotChampionData.Mordekaiser, 1);

    /** Creeping Death Definition */
    public static final Skill CreepingDeath = new Skill(RiotChampionData.Mordekaiser, 2);

    /** Siphon of Destruction Definition */
    public static final Skill SiphonOfDestruction = new Skill(RiotChampionData.Mordekaiser, 3);

    /** Children of the Grave Definition */
    public static final Skill ChildrenOfTheGrave = new Skill(RiotChampionData.Mordekaiser, 4);

    /** Soul Siphon Definition */
    public static final Skill SoulSiphon = new Skill(RiotChampionData.Morgana, 0);

    /** Dark Binding Definition */
    public static final Skill DarkBinding = new Skill(RiotChampionData.Morgana, 1);

    /** Tormented Soil Definition */
    public static final Skill TormentedSoil = new Skill(RiotChampionData.Morgana, 2);

    /** Black Shield Definition */
    public static final Skill BlackShield = new Skill(RiotChampionData.Morgana, 3);

    /** Soul Shackles Definition */
    public static final Skill SoulShackles = new Skill(RiotChampionData.Morgana, 4);

    /** Surging Tides Definition */
    public static final Skill SurgingTides = new Skill(RiotChampionData.Nami, 0);

    /** Aqua Prison Definition */
    public static final Skill AquaPrison = new Skill(RiotChampionData.Nami, 1);

    /** Ebb and Flow Definition */
    public static final Skill EbbandFlow = new Skill(RiotChampionData.Nami, 2);

    /** Tidecaller's Blessing Definition */
    public static final Skill TidecallersBlessing = new Skill(RiotChampionData.Nami, 3);

    /** Tidal Wave Definition */
    public static final Skill TidalWave = new Skill(RiotChampionData.Nami, 4);

    /** Soul Eater Definition */
    public static final Skill SoulEater = new Skill(RiotChampionData.Nasus, 0);

    /** Siphoning Strike Definition */
    public static final Skill SiphoningStrike = new Skill(RiotChampionData.Nasus, 1);

    /** Wither Definition */
    public static final Skill Wither = new Skill(RiotChampionData.Nasus, 2);

    /** Spirit Fire Definition */
    public static final Skill SpiritFire = new Skill(RiotChampionData.Nasus, 3);

    /** Fury of the Sands Definition */
    public static final Skill FuryOfTheSands = new Skill(RiotChampionData.Nasus, 4);

    /** Staggering Blow Definition */
    public static final Skill StaggeringBlow = new Skill(RiotChampionData.Nautilus, 0);

    /** Dredge Line Definition */
    public static final Skill DredgeLine = new Skill(RiotChampionData.Nautilus, 1);

    /** Titan's Wrath Definition */
    public static final Skill TitansWrath = new Skill(RiotChampionData.Nautilus, 2);

    /** Riptide Definition */
    public static final Skill Riptide = new Skill(RiotChampionData.Nautilus, 3);

    /** Depth Charge Definition */
    public static final Skill DepthCharge = new Skill(RiotChampionData.Nautilus, 4);

    /** Prowl Definition */
    public static final Skill Prowl = new Skill(RiotChampionData.Nidalee, 0);

    /** Javelin Toss / Takedown Definition */
    public static final Skill JavelinTossTakedown = new Skill(RiotChampionData.Nidalee, 1);

    /** Bushwhack / Pounce Definition */
    public static final Skill BushwhackPounce = new Skill(RiotChampionData.Nidalee, 2);

    /** Primal Surge / Swipe Definition */
    public static final Skill PrimalSurgeSwipe = new Skill(RiotChampionData.Nidalee, 3);

    /** Aspect Of The Cougar Definition */
    public static final Skill AspectOfTheCougar = new Skill(RiotChampionData.Nidalee, 4);

    /** Takedown Definition */
    public static final Skill Takedown = new Skill(RiotChampionData.Nidalee, 5);

    /** Pounce Definition */
    public static final Skill Pounce = new Skill(RiotChampionData.Nidalee, 6);

    /** Swipe Definition */
    public static final Skill Swipe = new Skill(RiotChampionData.Nidalee, 7);

    /** Aspect Of The Cougar Definition */
    public static final Skill AspectOfTheCougarInCougar = new Skill(RiotChampionData.Nidalee, 8);

    /** Umbra Blades Definition */
    public static final Skill UmbraBlades = new Skill(RiotChampionData.Nocturne, 0);

    /** Duskbringer Definition */
    public static final Skill Duskbringer = new Skill(RiotChampionData.Nocturne, 1);

    /** Shroud of Darkness Definition */
    public static final Skill ShroudOfDarkness = new Skill(RiotChampionData.Nocturne, 2);

    /** Unspeakable Horror Definition */
    public static final Skill UnspeakableHorror = new Skill(RiotChampionData.Nocturne, 3);

    /** Paranoia Definition */
    public static final Skill Paranoia = new Skill(RiotChampionData.Nocturne, 4);

    /** Visionary Definition */
    public static final Skill Visionary = new Skill(RiotChampionData.Nunu, 0);

    /** Consume Definition */
    public static final Skill Consume = new Skill(RiotChampionData.Nunu, 1);

    /** Blood Boil Definition */
    public static final Skill BloodBoil = new Skill(RiotChampionData.Nunu, 2);

    /** Ice Blast Definition */
    public static final Skill IceBlast = new Skill(RiotChampionData.Nunu, 3);

    /** Absolute Zero Definition */
    public static final Skill AbsoluteZero = new Skill(RiotChampionData.Nunu, 4);

    /** Berserker Rage Definition */
    public static final Skill BerserkerRage = new Skill(RiotChampionData.Olaf, 0);

    /** Undertow Definition */
    public static final Skill Undertow = new Skill(RiotChampionData.Olaf, 1);

    /** Vicious Strikes Definition */
    public static final Skill ViciousStrikes = new Skill(RiotChampionData.Olaf, 2);

    /** Reckless Swing Definition */
    public static final Skill RecklessSwing = new Skill(RiotChampionData.Olaf, 3);

    /** Ragnarok Definition */
    public static final Skill Ragnarok = new Skill(RiotChampionData.Olaf, 4);

    /** Clockwork Windup Definition */
    public static final Skill ClockworkWindup = new Skill(RiotChampionData.Orianna, 0);

    /** Command: Attack Definition */
    public static final Skill CommandAttack = new Skill(RiotChampionData.Orianna, 1);

    /** Command: Dissonance Definition */
    public static final Skill CommandDissonance = new Skill(RiotChampionData.Orianna, 2);

    /** Command: Protect Definition */
    public static final Skill CommandProtect = new Skill(RiotChampionData.Orianna, 3);

    /** Command: Shockwave Definition */
    public static final Skill CommandShockwave = new Skill(RiotChampionData.Orianna, 4);

    /** Aegis Protection Definition */
    public static final Skill AegisProtection = new Skill(RiotChampionData.Pantheon, 0);

    /** Spear Shot Definition */
    public static final Skill SpearShot = new Skill(RiotChampionData.Pantheon, 1);

    /** Aegis of Zeonia Definition */
    public static final Skill AegisOfZeonia = new Skill(RiotChampionData.Pantheon, 2);

    /** Heartseeker Strike Definition */
    public static final Skill HeartseekerStrike = new Skill(RiotChampionData.Pantheon, 3);

    /** Grand Skyfall Definition */
    public static final Skill GrandSkyfall = new Skill(RiotChampionData.Pantheon, 4);

    /** Valiant Fighter Definition */
    public static final Skill ValiantFighter = new Skill(RiotChampionData.Poppy, 0);

    /** Devastating Blow Definition */
    public static final Skill DevastatingBlow = new Skill(RiotChampionData.Poppy, 1);

    /** Paragon of Demacia Definition */
    public static final Skill ParagonOfDemacia = new Skill(RiotChampionData.Poppy, 2);

    /** Heroic Charge Definition */
    public static final Skill HeroicCharge = new Skill(RiotChampionData.Poppy, 3);

    /** Diplomatic Immunity Definition */
    public static final Skill DiplomaticImmunity = new Skill(RiotChampionData.Poppy, 4);

    /** Harrier Definition */
    public static final Skill Harrier = new Skill(RiotChampionData.Quinn, 0);

    /** Blinding Assault Definition */
    public static final Skill BlindingAssault = new Skill(RiotChampionData.Quinn, 1);

    /** Heightened Senses Definition */
    public static final Skill HeightenedSenses = new Skill(RiotChampionData.Quinn, 2);

    /** Vault Definition */
    public static final Skill Vault = new Skill(RiotChampionData.Quinn, 3);

    /** Tag Team Definition */
    public static final Skill TagTeam = new Skill(RiotChampionData.Quinn, 4);

    /** Spiked Shell Definition */
    public static final Skill SpikedShell = new Skill(RiotChampionData.Rammus, 0);

    /** Powerball Definition */
    public static final Skill Powerball = new Skill(RiotChampionData.Rammus, 1);

    /** Defensive Ball Curl Definition */
    public static final Skill DefensiveBallCurl = new Skill(RiotChampionData.Rammus, 2);

    /** Puncturing Taunt Definition */
    public static final Skill PuncturingTaunt = new Skill(RiotChampionData.Rammus, 3);

    /** Tremors Definition */
    public static final Skill Tremors = new Skill(RiotChampionData.Rammus, 4);

    /** Fury of the Xer'Sai Definition */
    public static final Skill FuryOfTheXerSai = new Skill(RiotChampionData.RekSai, 0);

    /** Queen's Wrath / Prey Seeker Definition */
    public static final Skill QueensWrathPreySeeker = new Skill(RiotChampionData.RekSai, 1);

    /** Burrow / Un-burrow Definition */
    public static final Skill BurrowUnburrow = new Skill(RiotChampionData.RekSai, 2);

    /** Furious Bite / Tunnel Definition */
    public static final Skill FuriousBiteTunnel = new Skill(RiotChampionData.RekSai, 3);

    /** Void Rush Definition */
    public static final Skill VoidRush = new Skill(RiotChampionData.RekSai, 4);

    /** Reign of Anger Definition */
    public static final Skill ReignOfAnger = new Skill(RiotChampionData.Renekton, 0);

    /** Cull the Meek Definition */
    public static final Skill CullTheMeek = new Skill(RiotChampionData.Renekton, 1);

    /** Ruthless Predator Definition */
    public static final Skill RuthlessPredator = new Skill(RiotChampionData.Renekton, 2);

    /** Slice and Dice Definition */
    public static final Skill SliceandDice = new Skill(RiotChampionData.Renekton, 3);

    /** Dominus Definition */
    public static final Skill Dominus = new Skill(RiotChampionData.Renekton, 4);

    /** Unseen Predator Definition */
    public static final Skill UnseenPredator = new Skill(RiotChampionData.Rengar, 0);

    /** Savagery Definition */
    public static final Skill Savagery = new Skill(RiotChampionData.Rengar, 1);

    /** Battle Roar Definition */
    public static final Skill BattleRoar = new Skill(RiotChampionData.Rengar, 2);

    /** Bola Strike Definition */
    public static final Skill BolaStrike = new Skill(RiotChampionData.Rengar, 3);

    /** Thrill of the Hunt Definition */
    public static final Skill ThrillOfTheHunt = new Skill(RiotChampionData.Rengar, 4);

    /** Runic Blade Definition */
    public static final Skill RunicBlade = new Skill(RiotChampionData.Riven, 0);

    /** Broken Wings Definition */
    public static final Skill BrokenWings = new Skill(RiotChampionData.Riven, 1);

    /** Ki Burst Definition */
    public static final Skill KiBurst = new Skill(RiotChampionData.Riven, 2);

    /** Valor Definition */
    public static final Skill Valor = new Skill(RiotChampionData.Riven, 3);

    /** Blade of the Exile Definition */
    public static final Skill BladeOfTheExile = new Skill(RiotChampionData.Riven, 4);

    /** Junkyard Titan Definition */
    public static final Skill JunkyardTitan = new Skill(RiotChampionData.Rumble, 0);

    /** Flamespitter Definition */
    public static final Skill Flamespitter = new Skill(RiotChampionData.Rumble, 1);

    /** Scrap Shield Definition */
    public static final Skill ScrapShield = new Skill(RiotChampionData.Rumble, 2);

    /** Electro Harpoon Definition */
    public static final Skill ElectroHarpoon = new Skill(RiotChampionData.Rumble, 3);

    /** The Equalizer Definition */
    public static final Skill TheEqualizer = new Skill(RiotChampionData.Rumble, 4);

    /** Arcane Mastery Definition */
    public static final Skill ArcaneMastery = new Skill(RiotChampionData.Ryze, 0);

    /** Overload Definition */
    public static final Skill Overload = new Skill(RiotChampionData.Ryze, 1);

    /** Rune Prison Definition */
    public static final Skill RunePrison = new Skill(RiotChampionData.Ryze, 2);

    /** Spell Flux Definition */
    public static final Skill SpellFlux = new Skill(RiotChampionData.Ryze, 3);

    /** Desperate Power Definition */
    public static final Skill DesperatePower = new Skill(RiotChampionData.Ryze, 4);

    /** Frost Definition */
    public static final Skill Frost = new Skill(RiotChampionData.Sejuani, 0);

    /** Arctic Assault Definition */
    public static final Skill ArcticAssault = new Skill(RiotChampionData.Sejuani, 1);

    /** Flail of the Northern Winds Definition */
    public static final Skill FlailOfTheNorthernWinds = new Skill(RiotChampionData.Sejuani, 2);

    /** Permafrost Definition */
    public static final Skill Permafrost = new Skill(RiotChampionData.Sejuani, 3);

    /** Glacial Prison Definition */
    public static final Skill GlacialPrison = new Skill(RiotChampionData.Sejuani, 4);

    /** Backstab Definition */
    public static final Skill Backstab = new Skill(RiotChampionData.Shaco, 0);

    /** Deceive Definition */
    public static final Skill Deceive = new Skill(RiotChampionData.Shaco, 1);

    /** Jack In The Box Definition */
    public static final Skill JackInTheBox = new Skill(RiotChampionData.Shaco, 2);

    /** Two-Shiv Poison Definition */
    public static final Skill TwoShivPoison = new Skill(RiotChampionData.Shaco, 3);

    /** Hallucinate Definition */
    public static final Skill Hallucinate = new Skill(RiotChampionData.Shaco, 4);

    /** Ki Strike Definition */
    public static final Skill KiStrike = new Skill(RiotChampionData.Shen, 0);

    /** Vorpal Blade Definition */
    public static final Skill VorpalBlade = new Skill(RiotChampionData.Shen, 1);

    /** Feint Definition */
    public static final Skill Feint = new Skill(RiotChampionData.Shen, 2);

    /** Shadow Dash Definition */
    public static final Skill ShadowDash = new Skill(RiotChampionData.Shen, 3);

    /** Stand United Definition */
    public static final Skill StandUnited = new Skill(RiotChampionData.Shen, 4);

    /** Dragonborn Definition */
    public static final Skill Dragonborn = new Skill(RiotChampionData.Shyvana, 0);

    /** Twin Bite Definition */
    public static final Skill TwinBite = new Skill(RiotChampionData.Shyvana, 1);

    /** Burnout Definition */
    public static final Skill Burnout = new Skill(RiotChampionData.Shyvana, 2);

    /** Flame Breath Definition */
    public static final Skill FlameBreath = new Skill(RiotChampionData.Shyvana, 3);

    /** Dragon's Descent Definition */
    public static final Skill DragonsDescent = new Skill(RiotChampionData.Shyvana, 4);

    /** Empowered Bulwark Definition */
    public static final Skill EmpoweredBulwark = new Skill(RiotChampionData.Singed, 0);

    /** Poison Trail Definition */
    public static final Skill PoisonTrail = new Skill(RiotChampionData.Singed, 1);

    /** Mega Adhesive Definition */
    public static final Skill MegaAdhesive = new Skill(RiotChampionData.Singed, 2);

    /** Fling Definition */
    public static final Skill Fling = new Skill(RiotChampionData.Singed, 3);

    /** Insanity Potion Definition */
    public static final Skill InsanityPotion = new Skill(RiotChampionData.Singed, 4);

    /** Glory in Death Definition */
    public static final Skill GloryinDeath = new Skill(RiotChampionData.Sion, 0);

    /** Decimating Smash Definition */
    public static final Skill DecimatingSmash = new Skill(RiotChampionData.Sion, 1);

    /** Soul Furnace Definition */
    public static final Skill SoulFurnace = new Skill(RiotChampionData.Sion, 2);

    /** Roar of the Slayer Definition */
    public static final Skill RoarOfTheSlayer = new Skill(RiotChampionData.Sion, 3);

    /** Unstoppable Onslaught Definition */
    public static final Skill UnstoppableOnslaught = new Skill(RiotChampionData.Sion, 4);

    /** Fleet of Foot Definition */
    public static final Skill FleetOfFoot = new Skill(RiotChampionData.Sivir, 0);

    /** Boomerang Blade Definition */
    public static final Skill BoomerangBlade = new Skill(RiotChampionData.Sivir, 1);

    /** Ricochet Definition */
    public static final Skill Ricochet = new Skill(RiotChampionData.Sivir, 2);

    /** Spell Shield Definition */
    public static final Skill SpellShield = new Skill(RiotChampionData.Sivir, 3);

    /** On The Hunt Definition */
    public static final Skill OnTheHunt = new Skill(RiotChampionData.Sivir, 4);

    /** Crystallizing Sting Definition */
    public static final Skill CrystallizingSting = new Skill(RiotChampionData.Skarner, 0);

    /** Crystal Slash Definition */
    public static final Skill CrystalSlash = new Skill(RiotChampionData.Skarner, 1);

    /** Crystalline Exoskeleton Definition */
    public static final Skill CrystallineExoskeleton = new Skill(RiotChampionData.Skarner, 2);

    /** Fracture Definition */
    public static final Skill Fracture = new Skill(RiotChampionData.Skarner, 3);

    /** Impale Definition */
    public static final Skill Impale = new Skill(RiotChampionData.Skarner, 4);

    /** Power Chord Definition */
    public static final Skill PowerChord = new Skill(RiotChampionData.Sona, 0);

    /** Hymn of Valor Definition */
    public static final Skill HymnOfValor = new Skill(RiotChampionData.Sona, 1);

    /** Aria of Perseverance Definition */
    public static final Skill AriaOfPerseverance = new Skill(RiotChampionData.Sona, 2);

    /** Song of Celerity Definition */
    public static final Skill SongOfCelerity = new Skill(RiotChampionData.Sona, 3);

    /** Crescendo Definition */
    public static final Skill Crescendo = new Skill(RiotChampionData.Sona, 4);

    /** Salvation Definition */
    public static final Skill Salvation = new Skill(RiotChampionData.Soraka, 0);

    /** Starcall Definition */
    public static final Skill Starcall = new Skill(RiotChampionData.Soraka, 1);

    /** Astral Infusion Definition */
    public static final Skill AstralInfusion = new Skill(RiotChampionData.Soraka, 2);

    /** Equinox Definition */
    public static final Skill Equinox = new Skill(RiotChampionData.Soraka, 3);

    /** Wish Definition */
    public static final Skill Wish = new Skill(RiotChampionData.Soraka, 4);

    /** Carrion Renewal Definition */
    public static final Skill CarrionRenewal = new Skill(RiotChampionData.Swain, 0);

    /** Decrepify Definition */
    public static final Skill Decrepify = new Skill(RiotChampionData.Swain, 1);

    /** Nevermove Definition */
    public static final Skill Nevermove = new Skill(RiotChampionData.Swain, 2);

    /** Torment Definition */
    public static final Skill Torment = new Skill(RiotChampionData.Swain, 3);

    /** Ravenous Flock Definition */
    public static final Skill RavenousFlock = new Skill(RiotChampionData.Swain, 4);

    /** Transcendent Definition */
    public static final Skill Transcendent = new Skill(RiotChampionData.Syndra, 0);

    /** Dark Sphere Definition */
    public static final Skill DarkSphere = new Skill(RiotChampionData.Syndra, 1);

    /** Force of Will Definition */
    public static final Skill ForceOfWill = new Skill(RiotChampionData.Syndra, 2);

    /** Scatter the Weak Definition */
    public static final Skill ScatterTheWeak = new Skill(RiotChampionData.Syndra, 3);

    /** Unleashed Power Definition */
    public static final Skill UnleashedPower = new Skill(RiotChampionData.Syndra, 4);

    /** An Acquired Taste Definition */
    public static final Skill AnAcquiredTaste = new Skill(RiotChampionData.TahmKench, 0);

    /** Tongue Lash Definition */
    public static final Skill TongueLash = new Skill(RiotChampionData.TahmKench, 1);

    /** Devour Definition */
    public static final Skill Devour = new Skill(RiotChampionData.TahmKench, 2);

    /** Thick Skin Definition */
    public static final Skill ThickSkin = new Skill(RiotChampionData.TahmKench, 3);

    /** Abyssal Voyage Definition */
    public static final Skill AbyssalVoyage = new Skill(RiotChampionData.TahmKench, 4);

    /** Mercy Definition */
    public static final Skill Mercy = new Skill(RiotChampionData.Talon, 0);

    /** Noxian Diplomacy Definition */
    public static final Skill NoxianDiplomacy = new Skill(RiotChampionData.Talon, 1);

    /** Rake Definition */
    public static final Skill Rake = new Skill(RiotChampionData.Talon, 2);

    /** Cutthroat Definition */
    public static final Skill Cutthroat = new Skill(RiotChampionData.Talon, 3);

    /** Shadow Assault Definition */
    public static final Skill ShadowAssault = new Skill(RiotChampionData.Talon, 4);

    /** Gemcraft Definition */
    public static final Skill Gemcraft = new Skill(RiotChampionData.Taric, 0);

    /** Imbue Definition */
    public static final Skill Imbue = new Skill(RiotChampionData.Taric, 1);

    /** Shatter Definition */
    public static final Skill Shatter = new Skill(RiotChampionData.Taric, 2);

    /** Dazzle Definition */
    public static final Skill Dazzle = new Skill(RiotChampionData.Taric, 3);

    /** Radiance Definition */
    public static final Skill Radiance = new Skill(RiotChampionData.Taric, 4);

    /** Camouflage Definition */
    public static final Skill Camouflage = new Skill(RiotChampionData.Teemo, 0);

    /** Blinding Dart Definition */
    public static final Skill BlindingDart = new Skill(RiotChampionData.Teemo, 1);

    /** Move Quick Definition */
    public static final Skill MoveQuick = new Skill(RiotChampionData.Teemo, 2);

    /** Toxic Shot Definition */
    public static final Skill ToxicShot = new Skill(RiotChampionData.Teemo, 3);

    /** Noxious Trap Definition */
    public static final Skill NoxiousTrap = new Skill(RiotChampionData.Teemo, 4);

    /** Damnation Definition */
    public static final Skill Damnation = new Skill(RiotChampionData.Thresh, 0);

    /** Death Sentence Definition */
    public static final Skill DeathSentence = new Skill(RiotChampionData.Thresh, 1);

    /** Dark Passage Definition */
    public static final Skill DarkPassage = new Skill(RiotChampionData.Thresh, 2);

    /** Flay Definition */
    public static final Skill Flay = new Skill(RiotChampionData.Thresh, 3);

    /** The Box Definition */
    public static final Skill TheBox = new Skill(RiotChampionData.Thresh, 4);

    /** Draw a Bead Definition */
    public static final Skill DrawaBead = new Skill(RiotChampionData.Tristana, 0);

    /** Rapid Fire Definition */
    public static final Skill RapidFire = new Skill(RiotChampionData.Tristana, 1);

    /** Rocket Jump Definition */
    public static final Skill RocketJump = new Skill(RiotChampionData.Tristana, 2);

    /** Explosive Charge Definition */
    public static final Skill ExplosiveCharge = new Skill(RiotChampionData.Tristana, 3);

    /** Buster Shot Definition */
    public static final Skill BusterShot = new Skill(RiotChampionData.Tristana, 4);

    /** King's Tribute Definition */
    public static final Skill KingsTribute = new Skill(RiotChampionData.Trundle, 0);

    /** Chomp Definition */
    public static final Skill Chomp = new Skill(RiotChampionData.Trundle, 1);

    /** Frozen Domain Definition */
    public static final Skill FrozenDomain = new Skill(RiotChampionData.Trundle, 2);

    /** Pillar of Ice Definition */
    public static final Skill PillarOfIce = new Skill(RiotChampionData.Trundle, 3);

    /** Subjugate Definition */
    public static final Skill Subjugate = new Skill(RiotChampionData.Trundle, 4);

    /** Battle Fury Definition */
    public static final Skill BattleFury = new Skill(RiotChampionData.Tryndamere, 0);

    /** Bloodlust Definition */
    public static final Skill Bloodlust = new Skill(RiotChampionData.Tryndamere, 1);

    /** Mocking Shout Definition */
    public static final Skill MockingShout = new Skill(RiotChampionData.Tryndamere, 2);

    /** Spinning Slash Definition */
    public static final Skill SpinningSlash = new Skill(RiotChampionData.Tryndamere, 3);

    /** Undying Rage Definition */
    public static final Skill UndyingRage = new Skill(RiotChampionData.Tryndamere, 4);

    /** Loaded Dice Definition */
    public static final Skill LoadedDice = new Skill(RiotChampionData.TwistedFate, 0);

    /** Wild Cards Definition */
    public static final Skill WildCards = new Skill(RiotChampionData.TwistedFate, 1);

    /** Pick A Card Definition */
    public static final Skill PickACard = new Skill(RiotChampionData.TwistedFate, 2);

    /** Stacked Deck Definition */
    public static final Skill StackedDeck = new Skill(RiotChampionData.TwistedFate, 3);

    /** Destiny Definition */
    public static final Skill Destiny = new Skill(RiotChampionData.TwistedFate, 4);

    /** Deadly Venom Definition */
    public static final Skill DeadlyVenom = new Skill(RiotChampionData.Twitch, 0);

    /** Ambush Definition */
    public static final Skill Ambush = new Skill(RiotChampionData.Twitch, 1);

    /** Venom Cask Definition */
    public static final Skill VenomCask = new Skill(RiotChampionData.Twitch, 2);

    /** Contaminate Definition */
    public static final Skill Contaminate = new Skill(RiotChampionData.Twitch, 3);

    /** Rat-Ta-Tat-Tat Definition */
    public static final Skill RatTaTatTat = new Skill(RiotChampionData.Twitch, 4);

    /** Monkey's Agility Definition */
    public static final Skill MonkeysAgility = new Skill(RiotChampionData.Udyr, 0);

    /** Tiger Stance Definition */
    public static final Skill TigerStance = new Skill(RiotChampionData.Udyr, 1);

    /** Turtle Stance Definition */
    public static final Skill TurtleStance = new Skill(RiotChampionData.Udyr, 2);

    /** Bear Stance Definition */
    public static final Skill BearStance = new Skill(RiotChampionData.Udyr, 3);

    /** Phoenix Stance Definition */
    public static final Skill PhoenixStance = new Skill(RiotChampionData.Udyr, 4);

    /** Zaun-Touched Bolt Augmenter Definition */
    public static final Skill ZaunTouchedBoltAugmenter = new Skill(RiotChampionData.Urgot, 0);

    /** Acid Hunter Definition */
    public static final Skill AcidHunter = new Skill(RiotChampionData.Urgot, 1);

    /** Terror Capacitor Definition */
    public static final Skill TerrorCapacitor = new Skill(RiotChampionData.Urgot, 2);

    /** Noxian Corrosive Charge Definition */
    public static final Skill NoxianCorrosiveCharge = new Skill(RiotChampionData.Urgot, 3);

    /** Hyper-Kinetic Position Reverser Definition */
    public static final Skill HyperKineticPositionReverser = new Skill(RiotChampionData.Urgot, 4);

    /** Living Vengeance Definition */
    public static final Skill LivingVengeance = new Skill(RiotChampionData.Varus, 0);

    /** Piercing Arrow Definition */
    public static final Skill PiercingArrow = new Skill(RiotChampionData.Varus, 1);

    /** Blighted Quiver Definition */
    public static final Skill BlightedQuiver = new Skill(RiotChampionData.Varus, 2);

    /** Hail of Arrows Definition */
    public static final Skill HailOfArrows = new Skill(RiotChampionData.Varus, 3);

    /** Chain of Corruption Definition */
    public static final Skill ChainOfCorruption = new Skill(RiotChampionData.Varus, 4);

    /** Night Hunter Definition */
    public static final Skill NightHunter = new Skill(RiotChampionData.Vayne, 0);

    /** Tumble Definition */
    public static final Skill Tumble = new Skill(RiotChampionData.Vayne, 1);

    /** Silver Bolts Definition */
    public static final Skill SilverBolts = new Skill(RiotChampionData.Vayne, 2);

    /** Condemn Definition */
    public static final Skill Condemn = new Skill(RiotChampionData.Vayne, 3);

    /** Final Hour Definition */
    public static final Skill FinalHour = new Skill(RiotChampionData.Vayne, 4);

    /** Equilibrium Definition */
    public static final Skill Equilibrium = new Skill(RiotChampionData.Veigar, 0);

    /** Baleful Strike Definition */
    public static final Skill BalefulStrike = new Skill(RiotChampionData.Veigar, 1);

    /** Dark Matter Definition */
    public static final Skill DarkMatter = new Skill(RiotChampionData.Veigar, 2);

    /** Event Horizon Definition */
    public static final Skill EventHorizon = new Skill(RiotChampionData.Veigar, 3);

    /** Primordial Burst Definition */
    public static final Skill PrimordialBurst = new Skill(RiotChampionData.Veigar, 4);

    /** Organic Deconstruction Definition */
    public static final Skill OrganicDeconstruction = new Skill(RiotChampionData.Velkoz, 0);

    /** Plasma Fission Definition */
    public static final Skill PlasmaFission = new Skill(RiotChampionData.Velkoz, 1);

    /** Void Rift Definition */
    public static final Skill VoidRift = new Skill(RiotChampionData.Velkoz, 2);

    /** Tectonic Disruption Definition */
    public static final Skill TectonicDisruption = new Skill(RiotChampionData.Velkoz, 3);

    /** Life Form Disintegration Ray Definition */
    public static final Skill LifeFormDisintegrationRay = new Skill(RiotChampionData.Velkoz, 4);

    /** Blast Shield Definition */
    public static final Skill BlastShield = new Skill(RiotChampionData.Vi, 0);

    /** Vault Breaker Definition */
    public static final Skill VaultBreaker = new Skill(RiotChampionData.Vi, 1);

    /** Denting Blows Definition */
    public static final Skill DentingBlows = new Skill(RiotChampionData.Vi, 2);

    /** Excessive Force Definition */
    public static final Skill ExcessiveForce = new Skill(RiotChampionData.Vi, 3);

    /** Assault and Battery Definition */
    public static final Skill AssaultandBattery = new Skill(RiotChampionData.Vi, 4);

    /** Glorious Evolution Definition */
    public static final Skill GloriousEvolution = new Skill(RiotChampionData.Viktor, 0);

    /** Siphon Power Definition */
    public static final Skill SiphonPower = new Skill(RiotChampionData.Viktor, 1);

    /** Gravity Field Definition */
    public static final Skill GravityField = new Skill(RiotChampionData.Viktor, 2);

    /** Death Ray Definition */
    public static final Skill DeathRay = new Skill(RiotChampionData.Viktor, 3);

    /** Chaos Storm Definition */
    public static final Skill ChaosStorm = new Skill(RiotChampionData.Viktor, 4);

    /** Crimson Pact Definition */
    public static final Skill CrimsonPact = new Skill(RiotChampionData.Vladimir, 0);

    /** Transfusion Definition */
    public static final Skill Transfusion = new Skill(RiotChampionData.Vladimir, 1);

    /** Sanguine Pool Definition */
    public static final Skill SanguinePool = new Skill(RiotChampionData.Vladimir, 2);

    /** Tides of Blood Definition */
    public static final Skill TidesOfBlood = new Skill(RiotChampionData.Vladimir, 3);

    /** Hemoplague Definition */
    public static final Skill Hemoplague = new Skill(RiotChampionData.Vladimir, 4);

    /** Chosen of the Storm Definition */
    public static final Skill ChosenOfTheStorm = new Skill(RiotChampionData.Volibear, 0);

    /** Rolling Thunder Definition */
    public static final Skill RollingThunder = new Skill(RiotChampionData.Volibear, 1);

    /** Frenzy Definition */
    public static final Skill Frenzy = new Skill(RiotChampionData.Volibear, 2);

    /** Majestic Roar Definition */
    public static final Skill MajesticRoar = new Skill(RiotChampionData.Volibear, 3);

    /** Thunder Claws Definition */
    public static final Skill ThunderClaws = new Skill(RiotChampionData.Volibear, 4);

    /** Eternal Thirst Definition */
    public static final Skill EternalThirst = new Skill(RiotChampionData.Warwick, 0);

    /** Hungering Strike Definition */
    public static final Skill HungeringStrike = new Skill(RiotChampionData.Warwick, 1);

    /** Hunters Call Definition */
    public static final Skill HuntersCall = new Skill(RiotChampionData.Warwick, 2);

    /** Blood Scent Definition */
    public static final Skill BloodScent = new Skill(RiotChampionData.Warwick, 3);

    /** Infinite Duress Definition */
    public static final Skill InfiniteDuress = new Skill(RiotChampionData.Warwick, 4);

    /** Mana Surge Definition */
    public static final Skill ManaSurge = new Skill(RiotChampionData.Xerath, 0);

    /** Arcanopulse Definition */
    public static final Skill Arcanopulse = new Skill(RiotChampionData.Xerath, 1);

    /** Eye of Destruction Definition */
    public static final Skill EyeOfDestruction = new Skill(RiotChampionData.Xerath, 2);

    /** Shocking Orb Definition */
    public static final Skill ShockingOrb = new Skill(RiotChampionData.Xerath, 3);

    /** Rite of the Arcane Definition */
    public static final Skill RiteOfTheArcane = new Skill(RiotChampionData.Xerath, 4);

    /** Challenge Definition */
    public static final Skill Challenge = new Skill(RiotChampionData.XinZhao, 0);

    /** Three Talon Strike Definition */
    public static final Skill ThreeTalonStrike = new Skill(RiotChampionData.XinZhao, 1);

    /** Battle Cry Definition */
    public static final Skill BattleCry = new Skill(RiotChampionData.XinZhao, 2);

    /** Audacious Charge Definition */
    public static final Skill AudaciousCharge = new Skill(RiotChampionData.XinZhao, 3);

    /** Crescent Sweep Definition */
    public static final Skill CrescentSweep = new Skill(RiotChampionData.XinZhao, 4);

    /** Way of the Wanderer Definition */
    public static final Skill WayOfTheWanderer = new Skill(RiotChampionData.Yasuo, 0);

    /** Steel Tempest Definition */
    public static final Skill SteelTempest = new Skill(RiotChampionData.Yasuo, 1);

    /** Wind Wall Definition */
    public static final Skill WindWall = new Skill(RiotChampionData.Yasuo, 2);

    /** Sweeping Blade Definition */
    public static final Skill SweepingBlade = new Skill(RiotChampionData.Yasuo, 3);

    /** Last Breath Definition */
    public static final Skill LastBreath = new Skill(RiotChampionData.Yasuo, 4);

    /** Unholy Covenant Definition */
    public static final Skill UnholyCovenant = new Skill(RiotChampionData.Yorick, 0);

    /** Omen of War Definition */
    public static final Skill OmenOfWar = new Skill(RiotChampionData.Yorick, 1);

    /** Omen of Pestilence Definition */
    public static final Skill OmenOfPestilence = new Skill(RiotChampionData.Yorick, 2);

    /** Omen of Famine Definition */
    public static final Skill OmenOfFamine = new Skill(RiotChampionData.Yorick, 3);

    /** Omen of Death Definition */
    public static final Skill OmenOfDeath = new Skill(RiotChampionData.Yorick, 4);

    /** Cell Division Definition */
    public static final Skill CellDivision = new Skill(RiotChampionData.Zac, 0);

    /** Stretching Strike Definition */
    public static final Skill StretchingStrike = new Skill(RiotChampionData.Zac, 1);

    /** Unstable Matter Definition */
    public static final Skill UnstableMatter = new Skill(RiotChampionData.Zac, 2);

    /** Elastic Slingshot Definition */
    public static final Skill ElasticSlingshot = new Skill(RiotChampionData.Zac, 3);

    /** Let's Bounce! Definition */
    public static final Skill LetsBounce = new Skill(RiotChampionData.Zac, 4);

    /** Contempt for the Weak Definition */
    public static final Skill ContemptforTheWeak = new Skill(RiotChampionData.Zed, 0);

    /** Razor Shuriken Definition */
    public static final Skill RazorShuriken = new Skill(RiotChampionData.Zed, 1);

    /** Living Shadow Definition */
    public static final Skill LivingShadow = new Skill(RiotChampionData.Zed, 2);

    /** Shadow Slash Definition */
    public static final Skill ShadowSlash = new Skill(RiotChampionData.Zed, 3);

    /** Death Mark Definition */
    public static final Skill DeathMark = new Skill(RiotChampionData.Zed, 4);

    /** Short Fuse Definition */
    public static final Skill ShortFuse = new Skill(RiotChampionData.Ziggs, 0);

    /** Bouncing Bomb Definition */
    public static final Skill BouncingBomb = new Skill(RiotChampionData.Ziggs, 1);

    /** Satchel Charge Definition */
    public static final Skill SatchelCharge = new Skill(RiotChampionData.Ziggs, 2);

    /** Hexplosive Minefield Definition */
    public static final Skill HexplosiveMinefield = new Skill(RiotChampionData.Ziggs, 3);

    /** Mega Inferno Bomb Definition */
    public static final Skill MegaInfernoBomb = new Skill(RiotChampionData.Ziggs, 4);

    /** Heightened Learning Definition */
    public static final Skill HeightenedLearning = new Skill(RiotChampionData.Zilean, 0);

    /** Time Bomb Definition */
    public static final Skill TimeBomb = new Skill(RiotChampionData.Zilean, 1);

    /** Rewind Definition */
    public static final Skill Rewind = new Skill(RiotChampionData.Zilean, 2);

    /** Time Warp Definition */
    public static final Skill TimeWarp = new Skill(RiotChampionData.Zilean, 3);

    /** Chronoshift Definition */
    public static final Skill Chronoshift = new Skill(RiotChampionData.Zilean, 4);

    /** Rise of the Thorns Definition */
    public static final Skill RiseOfTheThorns = new Skill(RiotChampionData.Zyra, 0);

    /** Deadly Bloom Definition */
    public static final Skill DeadlyBloom = new Skill(RiotChampionData.Zyra, 1);

    /** Rampant Growth Definition */
    public static final Skill RampantGrowth = new Skill(RiotChampionData.Zyra, 2);

    /** Grasping Roots Definition */
    public static final Skill GraspingRoots = new Skill(RiotChampionData.Zyra, 3);

    /** Stranglethorns Definition */
    public static final Skill Stranglethorns = new Skill(RiotChampionData.Zyra, 4);

    /** The skill key type. */
    public final SkillKey key;

    /** The owner data. */
    private final RiotChampionData data;

    /**
     * <p>
     * Create new Skill.
     * </p>
     * 
     * @param name
     */
    Skill(RiotChampionData data, int key) {
        this.data = data;

        switch (key) {
        case 0:
            this.key = SkillKey.Passive;
            break;

        case 1:
            this.key = SkillKey.Q;
            break;

        case 2:
            this.key = SkillKey.W;
            break;

        case 3:
            this.key = SkillKey.E;
            break;

        case 4:
        default:
            this.key = SkillKey.R;
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected SkillDescriptor createDescriptor(Version version, SkillDescriptor previous) {
        return new SkillDescriptor(this, previous, version);
    }

    /**
     * <p>
     * Retrieve the skill name.
     * </p>
     * 
     * @return A name of this skill.
     */
    public String getName() {
        return data.skills[key.ordinal()];
    }

    /**
     * <p>
     * Retrieve the localized skill name.
     * </p>
     * 
     * @return A localized name of this skill.
     */
    public String getLocalizedName() {
        return data.skillLocalized[key.ordinal()];
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/skill/" + data.name() + ".jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public float getIconPosition() {
        return key.ordinal() / (data.skills.length - 1) * 100;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * <p>
     * Returns minimum skill level.
     * </p>
     * 
     * @return
     */
    public int getMinLevel() {
        if (key == Passive || this == Mantra) {
            return 1;
        }

        if (this == SpiderForm || this == HumanForm || this == MercuryCannonMercuryHammer || this == MercuryHammer) {
            return 1;
        }
        return 0;
    }

    /**
     * <p>
     * Returns maximum skill level.
     * </p>
     * 
     * @return
     */
    @Override
    public int getMaxLevel() {
        if (key == Passive) {
            return 0;
        }

        if (this == SpiderForm || this == HumanForm || this == MercuryCannonMercuryHammer || this == MercuryHammer || this == Mantra) {
            return 4;
        }

        if (this != PhoenixStance && (key == R || this == Takedown || this == Pounce || this == Swipe)) {
            return 3;
        } else {
            return 5;
        }
    }

    static {
        Aatrox();
        Ahri();
        Akali();
        Alistar();
        Amumu();
        Anivia();
        Annie();
        Ashe();
        Blitzcrank();
        Brand();
        Caitlyn();
        Ryze();
        Cassiopeia();
        ChoGath();
        Corki();
        Darius();
        Diana();
        DrMundo();
        Draven();
        Elise();
        Evelynn();
        Ezreal();
        Fiddlesticks();
        Fiora();
        Fizz();

        /** Galio */
        RunicSkin.update().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(MR, 0.5));
        ResoluteSmite.update()
                .active("指定地点に魔法弾を飛ばし、{1}の敵ユニットに{2}と2.5秒間{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(0.6))
                .variable(3, MSSlowRatio, 24, 4)
                .mana(60, 5)
                .cd(7)
                .range(900);
        Bulwark.update()
                .active("4秒間対象のChampionは{1}と{2}を得て、効果中にその対象のChampionがダメージを受ける度にGalioの{3}する。自身に使用した場合はダメージを受けてから回復される。")
                .variable(1, AR, 30, 15)
                .variable(2, MR, 30, 15)
                .variable(3, RestoreHealth, 25, 15, ap(0.3))
                .mana(60)
                .cd(13)
                .range(800);
        RighteousGust.update()
                .active("指定方向に風を発生させ、当たった敵ユニットに{1}を与える。このスキルを使用すると指定した方向に5秒間持続する風が残り、その風の進行方向上にいる味方ユニットは{2}する。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, MSRatio, 20, 8)
                .mana(70, 5)
                .cd(12)
                .range(1000);
        IdolOfDurand.update()
                .active("{1}の敵ユニットに{2}を与え、さらに2秒間詠唱を行う。詠唱中Galioは{3}して、詠唱中にGalioがダメージを受ける度にこのスキルのダメージが5%ずつ増加していく(最大40%増加)。また詠唱中にBulwarkを使用することが出来る。詠唱完了またはキャンセル時に、周囲の敵ユニットのTauntを解除するとともに{4}を与える。最大DMは{5}。")
                .variable(1, Radius, 600)
                .variable(2, Taunt, 2)
                .variable(3, DamageReductionRatio, 50)
                .variable(4, MagicDamage, 220, 110, ap(0.6))
                .variable(5, MagicDamage, 308, 154, ap(0.84))
                .mana(100, 50)
                .cd(170, -20)
                .type(SkillType.Channel);
        IdolOfDurand.update(P311).cd(150, -15).mana(100);

        /** Gangplank */
        GrogSoakedBlade.update()
                .passive("通常攻撃時に対象にスタックを付与し、1スタックにつき毎秒{1}と{2}を与える。この効果は3秒間持続し、3回までスタックする。")
                .variable(1, MagicDamage, 3, 0, amplify(Lv, 1))
                .variable(2, MSSlowRatio, 7);
        Parrrley.update()
                .active("対象の敵ユニットに{1}(クリティカルあり)を与える。このスキルで敵ユニットを倒すと消費マナの半分のマナが回復し、追加で{2}得る。{3}。")
                .variable(1, PhysicalDamage, 20, 25, ad(1))
                .variable(2, Gold, 4, 1)
                .variable(3, OnHitEffect)
                .mana(50, 5)
                .cd(5)
                .range(625);
        RemoveScurvy.update()
                .active("自身のCC(Stun, Slow, Taunt, Fear, Snare, Silence, Suppression, Blind)を取り除き{1}する。StunなどのDisable中でも使用可能。")
                .variable(1, RestoreHealth, 80, 70, ap(1))
                .mana(65)
                .cd(22, -1);
        RaiseMorale.update()
                .passive("{1}を得て、{2}する。")
                .variable(1, AD, 8, 2)
                .variable(2, MSRatio, 3, 1)
                .active("7秒間{7}を得て、{3}する。{6}内の味方Championは{4}を得て{5}する。効果中はPassiveの効果が無効になる。")
                .variable(6, Radius, 1200)
                .variable(7, AD, 12, 7)
                .variable(3, MSRatio, 8, 3)
                .variable(4, AD, 6, 3.5)
                .variable(5, MSRatio, 4, 1.1)
                .mana(50, 5)
                .cd(25);
        CannonBarrage.update()
                .active("MAP内の指定した地点に砲撃を行い、その地点の視界({1})を得る。範囲内には7秒間砲弾が降り注ぎ(場所はランダム、計25発)、着弾した{2}にいる敵ユニットに{4}と1.25秒間{3}を与える。")
                .variable(1, Radius, 575)
                .variable(2, Radius, 275)
                .variable(3, MSSlowRatio, 25)
                .variable(4, MagicDamage, 75, 45, ap(0.2))
                .mana(100)
                .cd(120, -5)
                .range(-1);

        /** Garen */
        Perseverance.update()
                .passive("9秒間敵Minion以外からダメージを受けない状態が続くと、以降敵Minion以外からダメージを受けるまで毎秒{1}し続ける。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.005));
        Perseverance.update(P303).variable(1, RestoreHealth, 0, 0, amplify(Health, 0.004));
        DecisiveStrike.update()
                .active("{1}間{2}し、スキル使用後6秒間に行った次の通常攻撃に追加{3}と{4}が付与される。またこのスキル使用時に自身にかかっているスローを解除する。")
                .variable(1, Time, 1.5, 0.75)
                .variable(2, MSRatio, 35)
                .variable(3, PhysicalDamage, 30, 25, ad(0.4))
                .variable(4, Silence, 1.5, 0.25)
                .cd(8);
        Courage.update()
                .passive("{1}し{2}する。")
                .variable(1, AR, 0, 0, amplify(AR, 0.2))
                .variable(2, MR, 0, 0, amplify(MR, 0.2))
                .active("{3}間{4}し、{5}を得る。")
                .variable(3, Time, 2, 1)
                .variable(4, DamageReductionRatio, 30)
                .variable(5, Tenacity, 30)
                .cd(24, -1);
        Courage.update(P303)
                .variable(1, AR, 0, 0, amplify(BounusAR, 0.2))
                .variable(2, MR, 0, 0, amplify(BounusMR, 0.2));
        Judgment.update()
                .active("Garenが3秒間回転し、その間近くの敵ユニットに0.5秒毎に{1}を与える(最大6hit)。このスキルにはクリティカル判定があり、クリティカル時は追加{2}を与える。回転中は{3}を得るが、敵Minionをすり抜けている間は移動速度が20%低下する。Minionに与えるダメージは通常の75%。")
                .variable(1, PhysicalDamage, 10, 12.5, ad(0.35))
                .variable(2, PhysicalDamage, 0, 0, ad(0.175))
                .variable(3, IgnoreUnitCollision)
                .cd(13, -1);
        DemacianJustice.update()
                .active("対象の敵Championに{1}を与える。")
                .variable(1, MagicDamage, 175, 175, amplify(TargetMissingHealthRatio, new Fixed(new double[] {28.6,
                        33.3, 40})))
                .cd(160, -40)
                .range(400);

        Gragas();

        /** Graves */
        TrueGrit.update()
                .passive("戦闘状態になると1秒ごとにスタックが1増加し、スタック数に比例して{1}と{2}を得る。この効果は10回までスタックし、3秒間戦闘を行わないとスタックが0になる。")
                .variable(1, AR, new Per6Level(1, 1))
                .variable(2, MR, new Per6Level(1, 1));
        Buckshot.update()
                .active("指定方向扇形の範囲に貫通する弾を3発発射し、当たった敵ユニットに{1}を与える。同一対象に対して複数hitし、2発目以降は本来の35%分の物理DMを与える(3発hitで合計{2})。")
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.8))
                .variable(2, PhysicalDamage, 102, 59.5, bounusAD(1.36))
                .mana(60, 10)
                .cd(12, -1)
                .range(750);
        SmokeScreen.update()
                .active("指定地点にスモーク弾を発射し範囲内の敵ユニットに{1}を与え、4秒間持続する煙幕を残す。煙幕内にいる敵Championに視界低下と{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.6))
                .variable(2, MSSlowRatio, 15, 5)
                .mana(70)
                .cd(20, -1)
                .range(700);
        Quickdraw.update()
                .active("指定方向にダッシュし4秒間{1}する。このスキルは自身が通常攻撃を行う毎に{2}する。対象が建物の場合は無効。")
                .variable(1, ASRatio, 30, 10)
                .variable(2, CDDecrease, 1)
                .mana(50)
                .cd(22, -2)
                .range(425);
        CollateralDamage.update()
                .active("指定方向にMinionを貫通する爆発弾を発射し、hitした敵ユニットに{1}を与える。敵Championにhitするか最大距離飛ぶとターゲット後方に扇形に爆発が広がり、範囲内の敵ユニットに{2}を与える。")
                .variable(1, PhysicalDamage, 250, 100, bounusAD(1.4))
                .variable(2, PhysicalDamage, 140, 110, bounusAD(1.2))
                .mana(100)
                .cd(100, -10)
                .range(1000);

        Hecarim();
        Heimerdinger();

        /** Irelia */
        IonianFervor.update()
                .passive("Ireliaの視界内(範囲1200)に敵Championがいる数に応じて{1}を得る。効果の上限は最大3人まで。")
                .variable(-1, Tenacity, new Fixed(new double[] {10, 25, 40}));
        Bladesurge.update()
                .active("対象の敵ユニットに突進し、{1}を与える。このスキルで敵を倒したとき、このスキルの{2}されManaが35回復する。{3}。")
                .variable(1, PhysicalDamage, 20, 30, ad(1))
                .variable(2, CDDecrease)
                .variable(3, OnHitEffect)
                .mana(60, 5)
                .cd(14, -2)
                .range(650);
        HitenStyle.update()
                .passive("通常攻撃を行う度に{1}する。")
                .variable(1, RestoreHealth, 5, 2)
                .active("6秒間通常攻撃に{2}が付与され、PassiveのHP回復量が倍になる。")
                .variable(2, TrueDamage, 15, 15)
                .mana(40)
                .cd(15);
        EquilibriumStrike.update()
                .active("対象の敵ユニットに{1}を与える。対象の残HP%がIreliaより高かった場合{2}を与え、低かった場合は{4}間{3}を与える。")
                .variable(1, MagicDamage, 80, 50)
                .variable(2, Stun, 1, 0.25)
                .variable(3, MSSlowRatio, 60, 0)
                .variable(4, Time, 1, 0.25)
                .mana(50, 5)
                .cd(8)
                .range(425);
        TranscendentBlades.update()
                .active("指定方向に貫通する刃を飛ばし、当たった敵ユニットに{1}を与える。このスキルは15秒の間、4回まで連続して使用できる(但し、一度使用する度に0.5秒のCDが発生する)。2〜4発目はマナコスト無しで使用可能。ミニオンやモンスターにダメージを与えると{2}し、Championにダメージを与えると{3}する。")
                .variable(1, PhysicalDamage, 80, 40, ap(0.5), bounusAD(0.6))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 10))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 25))
                .mana(100)
                .cd(70, -10)
                .range(1000);

        Janna();
        Jarvan();

        /** Jax */
        RelentlessAssault.update()
                .passive("通常攻撃を行う度にスタックが1増加し、スタック数に比例して{1}する(最大6スタック)。スタックは2.5秒増加がないと0になる。")
                .variable(-1, ASRatio, new Per3Level(4, 2));
        LeapStrike.update()
                .active("対象のユニットまで飛びかかる。対象が敵ユニットの場合、{1}を与える。")
                .variable(1, PhysicalDamage, 70, 40, ap(0.6), bounusAD(1))
                .mana(65)
                .cd(10, -1)
                .range(700);
        Empower.update()
                .active("使用後に最初に行った通常攻撃かLeap Strikeに追加{1}を付与する。建物には無効。")
                .variable(1, MagicDamage, 40, 35, ap(0.6))
                .mana(30)
                .cd(7, -1);
        CounterStrike.update()
                .active("2秒間、Jaxが受けるタワー以外の通常攻撃を無効化し、AoEダメージを25%低減、さらに効果終了時に{1}の敵ユニットに{2}と{3}を与える。スキルを使用してから1秒経つと再使用できるようになり、任意に効果を終了できる。通常攻撃を回避する度にこのスキルのダメージが20%ずつ増加する(上限は100%、最大で2倍ダメージ)。")
                .variable(1, Radius, 375)
                .variable(2, PhysicalDamage, 50, 25, bounusAD(0.5))
                .variable(3, Stun, 1)
                .mana(70, 5)
                .cd(18, -2);
        GrandmastersMight.update()
                .passive("通常攻撃3回目ごとに追加で{1}を与える。建物には無効。")
                .variable(1, MagicDamage, 100, 60, ap(0.7))
                .active("8秒間{2}と{3}を得る。")
                .variable(2, AR, 25, 10, bounusAD(0.3))
                .variable(3, MR, 25, 10, ap(0.2))
                .mana(100)
                .cd(80);

        Jinx();

        /** Jayce */
        HextechCapacitor.update()
                .passive("Transformを使用すると1.25秒の間{1}し、{2}を得る。")
                .variable(-1, MS, 40)
                .variable(2, IgnoreUnitCollision);
        ToTheSkiesShockBlast.update()
                .active("対象の敵ユニットに飛びかかり、対象と周囲の敵ユニットに{1}と2秒間{2}を与える。")
                .variable(1, PhysicalDamage, 20, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 30, 5)
                .mana(40, 5)
                .cd(16, -2)
                .range(600);
        ShockBlast.update()
                .active("指定方向に{3}の雷のオーブを飛ばし、敵ユニットに命中するか一定距離で爆発し、周囲の敵ユニット{1}を与える。オーブがAcceleration Gateによって生成されたゲートを通過した場合、弾速、射程距離、爆発範囲、与えるDMが各40%増加する。{2}")
                .variable(1, PhysicalDamage, 60, 55, bounusAD(1.2))
                .variable(2, PhysicalDamage, 84, 77, bounusAD(1.68))
                .variable(3, MissileSpeed, 1350)
                .mana(55, 5)
                .cd(8)
                .range(1050);
        ShockBlast.update(P309).variable(3, MissileSpeed, 1450);
        LightningFieldHyperCharge.update()
                .passive("通常攻撃ごとに{1}する。")
                .variable(1, RestoreMana, 6, 2)
                .active("4秒間雷のオーラを身にまとい、{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 285)
                .variable(3, MagicDamage, 25, 17.5, ap(0.25))
                .mana(40)
                .cd(10);
        HyperCharge.update()
                .active("Jayceの攻撃速度が最大まで上昇する。3回通常攻撃を行うと効果が解消される。また効果中は通常攻撃で与えるダメージが{1}%になる。")
                .variable(1, Percentage, 70, 15)
                .mana(40)
                .cd(14, -2);
        ThunderingBlowAccelerationGate.update()
                .active("対象の敵ユニットに{1}と短い距離のノックバックを与える。ミニオンやモンスターに対しては{2}が上限。")
                .variable(1, MagicDamage, 0, 0, bounusAD(1), amplify(TargetMaxHealthRatio, 8, 3))
                .variable(2, MagicDamage, 200, 100)
                .mana(40)
                .cd(14, -1)
                .range(240);
        AccelerationGate.update()
                .active("4秒間持続するゲート(通りぬけ可能)を生成し、触れた味方ユニットは3秒間{1}する。移動速度は3秒かけて元に戻る。")
                .variable(1, MSRatio, 30, 5)
                .mana(50)
                .cd(14, -1)
                .range(650);
        AccelerationGate.update(P309).cd(16);
        MercuryCannonMercuryHammer.update()
                .active("射程が500(Ranged)になる。また、次の通常攻撃は５秒間{1}と{2}を与える。")
                .variable(1, ARReductionRatio, 10, 5)
                .variable(2, MRReductionRatio, 10, 5)
                .cd(6);
        MercuryCannonMercuryHammer.update(P309)
                .active("射程が500(Ranged)になる。また、次の通常攻撃は５秒間{1}と{2}を与える。{3}。")
                .variable(3, NotSpellCast);
        MercuryHammer.update()
                .active("射程が125(Melee)になり、その間は{1}と{2}を得る。また、次の通常攻撃に追加{3}を付与する。")
                .variable(1, AR, 5, 10)
                .variable(2, MR, 5, 10)
                .variable(3, MagicDamage, 20, 40)
                .cd(6);
        MercuryHammer.update(P309)
                .active("射程が125(Melee)になり、その間は{1}と{2}を得る。また、次の通常攻撃に追加{3}を付与する。{4}。")
                .variable(4, NotSpellCast);

        /** Karma */
        GatheringFire.update()
                .passive("{1}を得る。")
                .variable(1, AP, 0, 0, amplify(MissingHealthPercentage, new Per3LevelForKarma(0.3, 0.2)));
        GatheringFire.update(P305)
                .passive("敵Championにスキルでダメージを与えた場合Mantraの{1}し、通常攻撃でダメージを与えた場合は{2}する。")
                .variable(1, CDDecrease, new Per6Level(1, 0.5))
                .variable(2, CDDecrease, new Per6Level(0.5, 0.25));
        GatheringFire.update(P3051).variable(1, CDDecrease, 2).variable(2, CDDecrease, 1);
        InnerFlame.update()
                .active("指定方向扇形60°の{1}の敵ユニットに{2}を与える。Mantra Bonus:自身と効果範囲内の味方ユニットは{3}する。回復量は対象のHP残量によって変化する。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, RestoreHealth, 35, 20, amplify(MissingHealthRatio, 0.05, 0, ap(0.02)))
                .mana(70, 5)
                .cd(6);
        InnerFlame.update(P305)
                .active("指定方向に炎を飛ばし、命中した敵と{1}の敵ユニットに{2}と1.5秒間{3}を与える。Mantraを付与した場合、追加の{4}を与え、更に炎が命中した地点にフィールドを発生させ、フィールドの上にいる敵ユニットに{5}を与える。フィールドは1.5秒後に爆発し、フィールドの上にいる敵ユニットに{6}を与える。炎が敵ユニットに命中しなかった場合、最大距離まで飛んだ後にフィールドが発生する。")
                .variable(1, Radius, 230)
                .variable(2, MagicDamage, 60, 50, ap(0.6))
                .variable(3, MSSlowRatio, 25)
                .variable(4, MagicDamage, new Refer(Mantra, 25, 50), ap(0.3), null)
                .variable(5, MSSlowRatio, 50)
                .variable(6, MagicDamage, new Refer(Mantra, 50, 100), ap(0.6), null)
                .mana(50, 10)
                .cd(7, -0.5)
                .range(950);
        InnerFlame.update(P306).variable(2, MagicDamage, 80, 45, ap(0.6));
        InnerFlame.update(P308).variable(1, Radius, 250).mana(50, 5);
        FocusedResolve.update()
                .active("対象のユニットと自身を繋ぐビームを発生させる。ビームは5秒間持続し、自身及び味方ユニットは{1}し、敵ユニットには{2}を与える。ビームに触れたChampion(敵味方問わず)にも同様の効果を与え、それが敵ユニットだった場合は更に{3}を与える。ビームを繋ぐ対象がステルス状態または距離1000まで離れた場合、効果が途切れる。Mantra Bonus:MS増加/MS低下の効果が2倍になる。")
                .variable(1, MSRatio, 10, 2)
                .variable(2, MSSlowRatio, 10, 2)
                .variable(3, MagicDamage, 80, 45, ap(0.7))
                .mana(65, 10)
                .cd(15, -1)
                .range(800);
        FocusedResolve.update(P305)
                .active("対象の敵Championと自身を繋ぐビームを発生させる。0.33秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。Mantraを付与した場合、追加の{3}を与え、{4}するようになる。")
                .variable(1, MagicDamage, 10, 50 / 6, ap(0.1))
                .variable(2, Snare, 1, 0.25)
                .variable(3, MagicDamage, new Refer(Mantra, 75 / 6, 75 / 6), ap(0.1), null)
                .variable(4, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 25, 0, ap(0.01)))
                .mana(70, 10)
                .cd(16, -0.5);
        FocusedResolve.update(P3051)
                .active("対象の敵Championと自身を繋ぐビームを発生させる。0.66秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。Mantraを付与した場合、追加の{3}を与え、{4}するようになる。ダメージを与えるたびにGathering Fireの効果が発生する。")
                .variable(1, MagicDamage, 20, 50 / 3, ap(0.2))
                .variable(2, Snare, 1, 0.25)
                .variable(3, MagicDamage, new Refer(Mantra, 75 / 3, 75 / 3), ap(0.2), null)
                .variable(4, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 25, 0, ap(0.01)))
                .mana(70, 5);
        FocusedResolve.update(P306).cd(16, -1);
        FocusedResolve.update(P308)
                .active("対象の敵Championと自身を繋ぐビームを発生させる。0.66秒毎に{1}を与え、2秒間ビームが持続していた場合{2}を与える。Mantraを付与した場合、追加の{3}を与え、{4}するようになる。2秒間ビームが持続していた場合、追加で{4}する。ダメージを与えるたびにGathering Fireの効果が発生する。")
                .variable(4, RestoreHealth, 0, 0, amplify(MissingHealthRatio, 20, 0, ap(0.01)));
        Inspire.update()
                .active("対象の味方ユニットに5秒間持続する{1}を付与する。Mantra Bonus:味方ユニットにシールドを付与した際、その味方ユニットの{2}にいる敵ユニットに{3}を与える。")
                .variable(1, Shield, 80, 40, ap(0.8))
                .variable(2, Radius, 600)
                .variable(3, MagicDamage, 80, 40, ap(0.8))
                .mana(80, 10)
                .cd(10)
                .range(650);
        Inspire.update(P305)
                .active("対象の味方は4秒間{1}を得て{6}間{2}する。Mantraを付与した場合、味方ユニットにシールドを付与した際に{3}の味方ユニットは{4}を得て{7}し、敵ユニットには{5}を与える。対象とした味方ユニットは通常のシールドとMantraによるシールド両方の効果を得られる。")
                .variable(1, Shield, 80, 40, ap(0.5))
                .variable(2, MSRatio, 20, 10)
                .variable(3, Radius, 600)
                .variable(4, Shield, new Refer(Mantra, 30, 40), ap(0.3), null)
                .variable(5, MagicDamage, new Refer(Mantra, 60, 80), ap(0.6), null)
                .variable(6, Time, 1.25)
                .variable(7, MSRatio, 20, 10)
                .mana(60, 10)
                .cd(12)
                .range(800);
        Inspire.update(P3051).variable(3, Radius, 700).variable(6, Time, 1.5).variable(7, MSRatio, 60);
        Inspire.update(P306).variable(2, MSRatio, 40, 5).cd(10);
        Mantra.update()
                .active("次に使用するスキルにMantra Bonusを付与する。Lv1から使用でき、スキルポイントを割り振ることはできない。{1}毎にスタック数が1つ増加し最大で2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。")
                .variable(1, CDRAwareTime, new Per6Level(30, -5))
                .cd(0.25);
        Mantra.update(P305).active("8秒以内に使用する次のスキルにMantraを付与する。追加効果はMnatraのスキルレベルを参照する。").cd(45);
        Mantra.update(P306).cd(45, -3);

        /** Karthus */
        DeathDefied.update().passive("死亡後7秒間スキルが使用可能。この状態ではスキルコストがなくなる。");
        LayWaste.update()
                .active("指定地点を0.5秒後に爆発させ{1}の敵ユニットに{2}を与える。対象が1体の場合は{3}を与える。また、指定地点の{4}。")
                .variable(1, Radius, 100)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 80, 40, ap(0.6))
                .variable(4, Visionable)
                .mana(20, 6)
                .cd(1)
                .range(875);
        WallOfPain.update()
                .active("指定地点に{3}の通りぬけ可能な壁を5秒間生成し、触れた敵ユニットに５秒間{1}と{2}を与える。スローの効果は5秒かけて元に戻る。また、指定地点の{4}。")
                .variable(1, MRReductionRatio, 15)
                .variable(2, MSSlowRatio, 40, 10)
                .variable(3, Length, 800, 100)
                .variable(4, Visionable)
                .mana(100)
                .cd(18)
                .range(1000);
        Defile.update()
                .passive("敵ユニットを倒すと{1}する。")
                .variable(1, RestoreMana, 20, 7)
                .active("{2}の敵ユニットに毎秒{3}を与える。")
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 30, 20, ap(0.25))
                .mana(30, 12)
                .cd(0.5)
                .type(SkillType.Toggle);
        Defile.update(P310).variable(3, MagicDamage, 30, 20, ap(0.2));
        Requiem.update()
                .active("3秒詠唱後にすべての敵Championに{1}を与える。")
                .variable(1, MagicDamage, 250, 150, ap(0.6))
                .mana(150, 25)
                .cd(200, -20)
                .range(-1);

        Kassadin();

        /** Katarina */
        Voracity.update().passive("敵Championキル/アシスト時に、すべてのスキルの{1}する。").variable(1, CDDecrease, 15);
        BouncingBlades.update()
                .active("対象の敵ユニットにナイフを飛ばし{1}と４秒間Debuffを与える。ナイフは近くの敵ユニット({2})に4回まで跳ね返り、その度にダメージとDebuffを与える。ナイフが与えるダメージは跳ね返る度に10%低下する。Debuffが付与された敵ユニットにKatarinaが通常攻撃またはスキルでダメージを与えると、付与されたDebuffを消費して{3}を与える。")
                .variable(1, MagicDamage, 60, 25, ap(0.15))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 15, 15, ap(0.15))
                .cd(10, -0.5)
                .range(675);
        SinisterSteel.update()
                .active("{1}にいる敵ユニットに{2}を与える。このスキルが敵Championに命中した場合、1秒間{3}する。")
                .variable(2, MagicDamage, 40, 35, ap(0.25))
                .variable(1, Radius, 375)
                .variable(3, MSRatio, 15, 5)
                .cd(4);
        Shunpo.update()
                .active("対象のユニットの後方までワープし、それが敵ユニットの場合は{1}を与える。またこのスキル使用後、Katarinaが受ける{2}する。この効果は1.5秒間持続する。")
                .variable(1, MagicDamage, 60, 25, ap(0.5))
                .variable(2, DamageReductionRatio, 15)
                .cd(12, -1.5)
                .range(700);
        DeathLotus.update()
                .active("最大2秒間回転する。その間は0.2秒毎に{2}にいる最も近い敵Champion3体にナイフを連続で飛ばし、都度{1}と3秒間HP回復量-50%を与える。敵一体に与える最大DMは{3}。")
                .variable(1, MagicDamage, 40, 10, ap(0.2), bounusAD(0.3))
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 400, 100, ap(2), bounusAD(3))
                .cd(60, -5)
                .type(SkillType.Channel);
        DeathLotus.update(P312)
                .active("最大2.5秒間回転する。その間は0.25秒毎に{2}にいる最も近い敵Champion3体にナイフを連続で飛ばし、都度{1}と3秒間HP回復量-50%を与える。敵一体に与える最大DMは{3}。")
                .variable(1, MagicDamage, 40, 17.5, ap(0.25), bounusAD(0.375))
                .variable(3, MagicDamage, 400, 175, ap(2.5), bounusAD(3.75))
                .cd(60, -7.5);

        Kayle();

        /** Kennen */
        MarkOfTheStorm.update()
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは8秒間増加がないと0になる。同一の敵Championを7秒以内に2度スタンさせると、{3}を与える。")
                .variable(1, Stun, 1)
                .variable(2, RestoreEnergy, 25)
                .variable(3, Stun, 0.5);
        MarkOfTheStorm.update(P309)
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象を{1}させ、{2}する。スタックは6秒間増加がないと0になる。同一の敵Championを7秒以内に2度スタンさせると、{3}を与える。");
        ThunderingShuriken.update()
                .active("指定方向に手裏剣を飛ばし、当たった敵ユニットに{1}と雷スタックを与える。")
                .variable(1, MagicDamage, 75, 40, ap(0.75))
                .cd(8, -1)
                .range(900)
                .cost(Energy, 65, -5);
        ElectricalSurge.update()
                .passive("5回毎の通常攻撃時に追加{1}と雷スタックを与える効果を追加する。")
                .variable(1, MagicDamage, 0, 0, ad(0.4))
                .active("{3}の雷スタックの付与されている敵ユニットに{2}と雷スタックを与える。")
                .variable(3, Radius, 800)
                .variable(2, MagicDamage, 65, 30, ap(0.55))
                .cd(14, -2)
                .cost(Energy, 45, 0);
        LightningRush.update()
                .active("2.5秒間{1}し、{6}を得る。この間は通常攻撃が不可能になり、Kennenに触れた敵ユニットに{2}と雷スタックを与え、一度だけ{3}する。また、このスキルを使用すると4秒間{4}と{5}を得る。Minionに与えるダメージは半分。")
                .variable(1, MS, 230)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .variable(3, RestoreEnergy, 40)
                .variable(4, AR, 10, 10)
                .variable(5, MR, 10, 10)
                .variable(6, IgnoreUnitCollision)
                .cd(10, -1)
                .cost(Energy, 100, -5);
        SlicingMaelstrom.update()
                .active("{1}に嵐を発生させ、{4}間{2}毎に範囲内にいる敵Champion一人をランダムに雷を落とし{3}と雷スタックを与える。同一の対象には3回までヒットし、最大DMは{5}。また、範囲内に複数の対象がいる場合、同一の対象に連続してはヒットしない。雷スタックはヒットする毎に蓄積する。")
                .variable(1, Radius, 550)
                .variable(2, Time, new Fixed(new double[] {0.5, 0.4, 0.33}))
                .variable(3, MagicDamage, 80, 65, ap(0.4))
                .variable(4, Time, 3, 1)
                .variable(5, MagicDamage, 240, 195, ap(1.2))
                .cd(120);

        KhaZix();

        /** Kog'Maw */
        IcathianSurprise.update()
                .passive("死亡すると4秒後に自爆して周囲の敵ユニットに{1}を与える。自爆するまでの間は徐々に移動速度が増加する(最大時40%増加)。")
                .variable(1, TrueDamage, 100, 0, amplify(Lv, 25));
        CausticSpittle.update()
                .passive("{1}する。")
                .variable(1, ASRatio, 10, 5)
                .active("対象の敵ユニットに{2}を与え、4秒間{3}と{4}を与える。")
                .variable(2, MagicDamage, 60, 50, ap(0.7))
                .variable(3, ARReduction, 5, 5)
                .variable(4, MRReduction, 5, 5)
                .mana(60)
                .cd(8)
                .range(625);
        BioArcaneBarrage.update()
                .active("8秒間通常攻撃の{1}し、通常攻撃時に{2}を追加で与える。")
                .variable(1, Range, 130, 20)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2, 1, ap(0.01)))
                .mana(50)
                .cd(17)
                .range(130, 20);
        VoidOoze.update()
                .active("指定方向に貫通する弾を発射し、当たった敵ユニットに{1}を与える。弾の通過点に4秒間持続する液体が残り、その上にいる敵ユニットに{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, MSSlowRatio, 20, 8)
                .mana(80, 10)
                .cd(12)
                .range(1400);
        LivingArtillery.update()
                .active("指定地点を砲撃し、{1}の敵ユニットに{2}を敵Championには{3}を与え、4秒間そのユニットの視界を得る。このスキルを使うたびにスタックが増加し、1スタックにつきこのスキルの消費マナが40ずつ増加していく。スタックは6秒間持続する。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 80, 40, ap(0.3), bounusAD(0.5))
                .variable(3, MagicDamage, 180, 90, ap(0.3), bounusAD(0.5))
                .cost(Mana, new Diff(40, 0, 1), amplify(Stack, 40))
                .cd(2, -0.5)
                .range(1400, 300);

        /** LeBlanc */
        MirrorImage.update()
                .passive("HPが40%以下になったとき0.5秒間ステルス状態になり、自分の分身を作り出す。分身は8秒間持続し、分身が敵にダメージを与えることはできない。{1}。")
                .variable(1, CDRUnaware)
                .cd(-60);
        SigilOfMalice.update()
                .active("対象の敵ユニットに{1}と3.5秒間持続するマークを付与する。マークが付いている間に再度スキルでダメージを与えると、マークを消費して追加{2}と{3}を付与する。")
                .variable(1, MagicDamage, 70, 40, ap(0.6))
                .variable(2, MagicDamage, 20, 20, ap(0.2))
                .variable(3, Silence, 2)
                .mana(70, 5)
                .cd(6)
                .range(700)
                .update(P309)
                .variable(1, MagicDamage, 55, 25, ap(0.4))
                .variable(2, MagicDamage, 55, 25, ap(0.4))
                .variable(3, Silence, 1.5)
                .mana(50, 10);
        Distortion.update()
                .active("指定地点まで高速で移動し、移動先の{1}にいる敵ユニットに{2}を与える。3秒間以内にもう一度このスキルを使用すると元居た地点に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 85, 40, ap(0.6))
                .mana(80)
                .cd(18, -2)
                .range(600);
        Distortion.update(P309).mana(80, 10);
        EtherealChains.update()
                .active("指定方向に鎖を放ち、当たった敵ユニットに{1}と{5}間{2}を与え対象と鎖で繋がれる。{5}間対象が鎖の範囲内(範囲1000)に留まっていた場合、対象に追加{3}と{4}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.5))
                .variable(2, MSSlowRatio, 25)
                .variable(3, MagicDamage, 40, 25, ap(0.5))
                .variable(4, Snare, 1, 0.3)
                .variable(5, Time, 2)
                .mana(80)
                .cd(10)
                .range(950);
        EtherealChains.update(P309).variable(5, Time, 1.5).variable(4, Snare, 1.5).cd(14, -1);
        Mimic.update()
                .active("直前に使ったスキルを、威力を{1}増した状態で再使用する。Distortionとして使用した場合、それぞれDistortionとDistortion:Mimicを使用した地点に戻る事ができる。")
                .variable(1, Percentage, 10, 15)
                .mana(100, -50)
                .cd(40, -8);
        Mimic.update(P309)
                .active("直前に使ったスキルをコピーする。(ダメージ値が下記のように変化する)<br>Sigil of Silence: {1}<br>Distortion: {2}<br>Ethereal Chains: {3}")
                .variable(1, MagicDamage, 100, 100, ap(0.65))
                .variable(2, MagicDamage, 150, 150, ap(0.975))
                .variable(3, MagicDamage, 100, 100, ap(0.65))
                .mana(0);

        LeeSin();
        Leona();

        /** Lissandra */
        Iceborn.update().passive("18秒毎に次に使うスキルのコストが0になる。Glacial Path以外のスキルを敵ユニットに命中させるたびに、このスキルのCDが1秒解消される。");
        IceShard.update()
                .active("指定方向に貫通する氷の槍を飛ばし、当たった敵ユニットに{1}を与える。このスキルが最初に命中した敵ユニットには更に1.5秒間{2}を与える。")
                .variable(1, MagicDamage, 75, 35, ap(0.65))
                .variable(2, MSSlowRatio, 16, 3)
                .mana(85)
                .cd(6, -0.5)
                .range(725);
        RingOfFrost.update()
                .active("{1}にいるすべての敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, Snare, 1.1, 0.1)
                .mana(70)
                .cd(18, -2);
        RingOfFrost.update(P308).cd(14, -1).mana(50);
        GlacialPath.update()
                .active("指定方向に貫通する氷の爪を飛ばし、当たった敵ユニットに{1}を与える。氷の爪が出ている間にこのスキルを再度使用すると、氷の爪の位置までワープし氷の爪が消滅する。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .mana(80, 5)
                .cd(24, -3)
                .range(1050);
        FrozenTomb.update()
                .active("対象の敵Championに{1}と{2}を与え、同時に対象の敵Championの周囲に3秒間持続するDark Iceを呼び出し、Dark Iceに触れた敵ユニットに{1}と{3}を与える。このスキルは自身を対象とする事が可能で、自身を対象とした場合は{4}間行動出来なくなる代わりに、ダメージを無効化かつターゲット不可状態になり、自身の周囲からDark Iceが出現する。")
                .variable(1, MagicDamage, 150, 150, ap(0.7))
                .variable(2, Stun, 1.5)
                .variable(3, MSSlowRatio, 20)
                .variable(4, Time, 1.5)
                .mana(100)
                .cd(130, -25);
        FrozenTomb.update(P308)
                .variable(1, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MSSlowRatio, 20, 10)
                .variable(4, Time, 2.5);

        Lucian();
        Lulu();

        /** Lux */
        Illumination.update()
                .passive("スキルでダメージを与えた敵ユニットに6秒間持続するDebuffを付与する。この敵ユニットに対して通常攻撃かFinal Sparkでダメージを与えると、付与されたDebuffを消費して追加{1}を与える。")
                .variable(1, MagicDamage, 10, 0, amplify(Lv, 10));
        LightBinding.update()
                .active("指定方向に光の玉を飛ばし、当たった敵ユニットに{1}と{2}を与える。光の玉は一度だけ敵ユニットを貫通し、2体目のユニットには{3}と{4}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, Snare, 2)
                .variable(3, MagicDamage, 50, 25, ap(0.35))
                .variable(4, Snare, 1)
                .mana(50, 10)
                .cd(15, -1)
                .range(1175);
        PrismaticBarrier.update()
                .active("指定方向に杖を投げ、自身と当たった味方Championに{1}を付与する。行きと帰りそれぞれに判定があり、シールドは3秒間持続する。")
                .variable(1, Shield, 80, 25, ap(0.35))
                .mana(60)
                .cd(14, -1)
                .range(1000);
        LucentSingularity.update()
                .active("指定地点に光の玉を設置し、{1}の敵ユニットに{2}を与える。光の玉は5秒経つか再度スキルを使用する事で爆発し、{1}の敵ユニットに{3}を与える。光の玉は{4}。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 20, 4)
                .variable(3, MagicDamage, 60, 45, ap(0.6))
                .variable(4, Visionable)
                .mana(70, 15)
                .cd(10)
                .range(1100);
        FinalSpark.update()
                .active("1秒詠唱後、指定方向の直線状にいるすべての敵ユニットに{1}を与える。また効果範囲内の視界を確保する。Hitした敵がIlluminationのデバフを受けていた場合はその分の追加ダメージを与えたうえ、新たにIlluminationのデバフを与える。")
                .variable(1, MagicDamage, 300, 100, ap(0.75))
                .mana(100)
                .cd(80, -20)
                .range(3000);
        FinalSpark.update(P3051).cd(80, -15);

        /** Malphite */
        GraniteShield.update().passive("10秒間ダメージを受けないと{1}を得る。").variable(1, Shield, 0, 0, amplify(Health, 0.1));
        SeismicShard.update()
                .active("対象の敵ユニットに{1}と4秒間{2}を与える。また、このスキルで減少させた移動速度を自身の移動速度に加算する。移動速度増加は4秒間持続する。")
                .variable(1, MagicDamage, 70, 50, ap(0.6))
                .variable(2, MSSlowRatio, 14, 3)
                .mana(70, 5)
                .cd(8)
                .range(625);
        BrutalStrikes.update()
                .passive("通常攻撃時に対象の{1}にいる敵ユニットに{2}を与える。建物を攻撃する際にはスプラッシュ効果は発生しない。")
                .variable(1, Radius, 200)
                .variable(2, PhysicalDamage, 0, 0, amplify(AD, 0.3, 0.08))
                .active("6秒間{3}、{4}する。")
                .variable(3, ADRatio, 20, 5)
                .variable(4, ARRatio, 20, 5)
                .mana(50, 5)
                .cd(14);
        GroundSlam.update()
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 60, 40, ap(0.2), amplify(AR, 0.3))
                .variable(3, ASSlowRatio, 30, 5)
                .mana(50, 5)
                .cd(7);
        UnstoppableForce.update()
                .active("指定地点に突撃し{1}の敵ユニットに{2}を与えると共に{3}後、{4}を与える。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 200, 100, ap(1))
                .variable(3, Knockup, 1)
                .variable(4, Stun, 0.5)
                .mana(100)
                .cd(130, -15)
                .range(1000);

        /** Malzahar */
        SummonVoidling.update()
                .passive("スキルを4回使う度にVoidlingを召喚する。Voidlingは21秒間持続し、7秒後にADとARが1.5倍、14秒後にASが2倍に増加する。任意の操作不可。攻撃対象は、Ultを掛けた相手、" + MaleficVisions + "を掛けた相手、Malzaharがターゲットしている相手の順。<br>Health: {1}<br>AD: {2}<br>AR: 30<br>MR: 50<br>AS: 0.831<br>MS: 451")
                .variable(1, Value, 200, 0, amplify(Lv, 40))
                .variable(2, Value, 20, 0, amplify(Lv, 5), bounusAD(1));
        CallOfTheVoid.update()
                .active("指定した地点の左右から挟み込む様に2本の波動が出現し、当たった敵ユニットに{1}と{2}を与える。また、指定した場所の視界を得る。")
                .variable(1, MagicDamage, 80, 55, ap(0.8))
                .variable(2, Silence, 1.4, 0.4)
                .mana(80, 10)
                .cd(9)
                .range(900);
        CallOfTheVoid.update(P306).mana(80, 5);
        NullZone.update()
                .active("指定地点に5秒間持続する{1}のダメージゾーンを発生させ、上にいる敵ユニットに毎秒{2}を与える。(Minionに対しては毎秒120DMが上限)")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 4, 1, ap(0.01)))
                .mana(90, 10)
                .cd(14)
                .range(800);
        NullZone.update(P306).mana(90, 5);
        MaleficVisions.update()
                .active("対象の敵ユニットに4秒かけて{1}を与える。効果中に敵ユニットが死亡した場合、{2}し、近くの敵ユニットに効果が移り変わる。移る度に4秒のタイマーはリセットされる。")
                .variable(1, MagicDamage, 80, 60, ap(0.8))
                .variable(2, RestoreMana, 10, 4)
                .mana(60, 15)
                .cd(15, -2)
                .range(650);
        NetherGrasp.update()
                .active("対象の敵Championに2.5秒かけて{1}と{2}を与える。ダメージは0.5秒毎に計5回の判定がある。")
                .variable(1, MagicDamage, 250, 150, ap(1.3))
                .variable(2, Suppression, 2.5)
                .mana(150)
                .cd(120, -20)
                .range(700)
                .type(SkillType.Channel);

        /** Maokai */
        SapMagic.update()
                .passive("近くのChampion(敵味方自分問わず)がスキルを使用するとスタックが増え、5スタックまで溜まった状態で通常攻撃を行うと{1}する。このスキル発動時にスタックは0になる。建物を攻撃した場合は発動しない。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.07));
        ArcaneSmash.update()
                .active("{1}の敵ユニットと指定方向の敵ユニットに{2}と2秒間{3}を与える。{4}の敵ユニットには更に{5}を与える。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, MSSlowRatio, 20, 7)
                .variable(4, Radius, 200)
                .variable(5, Knockback, 0)
                .mana(55)
                .cd(6)
                .range(700);
        TwistedAdvance.update()
                .active("対象の敵ユニットまで高速移動し{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 35, ap(0.8))
                .variable(2, Snare, 1, 0.25)
                .mana(75, 5)
                .cd(13)
                .range(650);
        SaplingToss.update()
                .active("指定地点に苗木を投げ、{1}の敵ユニットに{2}を与える。苗木は最大35秒間その場で待機し、敵ユニットが近付く({4})と相手に向かって移動を開始する、敵に接触するか数秒経つと爆発して{1}に{3}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 35, ap(0.4))
                .variable(3, MagicDamage, 80, 50, ap(0.6))
                .variable(4, Radius, 500)
                .mana(70, 10)
                .cd(12)
                .range(1100);
        VengefulMaelstrom.update()
                .passive("指定地点の{1}にシールドを展開し、範囲内の味方Championが受けるダメージを20%低減させる(タワーからの攻撃以外)。解除すると範囲内の敵ユニットに{2}を与える。低減したダメージ量に比例して与えるダメージが増加する。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 100, 50, ap(0.5))
                .mana(75)
                .cd(40, -10)
                .range(575);

        MasterYi();

        /** Miss Fortune */
        Strut.update()
                .passive("5秒間ダメージを受けないと{1}する。以後、毎秒移動速度が9ずつ上昇し、5秒後に移動速度上昇値は上限の70に到達する。ダメージを受けると解除される。")
                .variable(-1, MS, 25);
        DoubleUp.update()
                .active("対象の敵ユニットに弾丸を飛ばし{1}を与える。弾は一度だけ跳ね返り、背後にいる敵ユニット一体(範囲500)を対象とし{2}を与える。{3}。")
                .variable(1, PhysicalDamage, 25, 35, ad(0.75))
                .variable(2, PhysicalDamage, 30, 42, ad(0.9))
                .variable(3, OnHitEffect)
                .mana(70, 5)
                .cd(9, -1)
                .range(625);
        ImpureShots.update()
                .passive("通常攻撃に{1}を与え、対象にスタックを付与する。1スタックにつき追加魔法DMが倍増していく。最大{4}(最大4倍ダメージ)で5秒間持続する。")
                .variable(1, MagicDamage, 6, 2, ap(0.05))
                .active("6秒間{2}し、通常攻撃に{3}を付加する。")
                .variable(2, ASRatio, 30, 5)
                .variable(3, Wounds, 3)
                .variable(4, Stack, 4)
                .mana(50)
                .cd(16);
        ImpureShots.update(P307).variable(1, MagicDamage, 4, 2, ap(0.05)).variable(4, Stack, 5);
        MakeItRain.update()
                .active("地点を指定した0.5秒後に2秒間銃弾の雨を降らし、{1}の敵ユニットに{2}と1秒間{3}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 90, 55, ap(0.8))
                .variable(3, MSSlowRatio, 20, 8)
                .mana(80)
                .cd(15)
                .range(800);
        BulletTime.update()
                .active("指定方向扇形の範囲に2秒間、弾幕砲火を浴びせて範囲内の敵ユニットに{1}を与える。弾は0.25秒毎に一発発射され、同一の対象に8回までヒットする。最大で{2}。")
                .variable(1, PhysicalDamage, 65, 30, ap(0.2), bounusAD(0.35))
                .variable(2, PhysicalDamage, 520, 240, ap(1.6), bounusAD(2.8))
                .mana(100)
                .cd(120, -10)
                .range(1400)
                .type(SkillType.Channel);

        /** Mordekaiser */
        IronMan.update()
                .passive("スキルで与えたダメージの17.5%(Championに対しては35%)をシールドに変換して(最大で{1})受けたダメージはHPより先にシールドがくらってくれる。1秒毎に3%ずつ低下していく。")
                .variable(1, Shield, 90, 0, amplify(Lv, 30));
        MaceOfSpades.update()
                .active("次に行う通常攻撃が{1}になり、更に近くの敵ユニット3体({2})にもダメージを与える。対象が1体だけの場合は{3}与える。")
                .variable(1, MagicDamage, 80, 30, ap(0.4), bounusAD(1))
                .variable(2, Radius, 600)
                .variable(3, MagicDamage, 132, 49.5, ap(0.66), bounusAD(1.65))
                .cd(8, -1)
                .cost(Health, 20, 5);
        CreepingDeath.update()
                .active("対象の味方ユニットに6秒間持続するシールドを付与する。付与されたユニットは{1}と{2}を得て、{3}の敵ユニットに毎秒{4}を与える。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 24, 12, ap(0.2))
                .cd(20, -2)
                .range(750)
                .cost(Health, 26, 6);
        SiphonOfDestruction.update()
                .active("指定方向扇形の範囲内の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 70, 45, ap(0.6))
                .cd(6)
                .range(700)
                .cost(Health, 24, 12);
        ChildrenOfTheGrave.update()
                .active("対象の敵Championに{1}を与え、その後10秒間、毎秒{2}を与える。10秒間で総計{4}を与え、{3}する。効果中に対象が死ぬとThe Spiritを生成し30秒間従わせる。(RまたはALT押しながらクリックで任意の操作可能)　The Spirit AD: 元になったChampのAD + MordekaiserのADの75%AP: 元になったChampのAP + MordekaiserのAPの75%HP: 元になったChampのHP + MordekaiserのHPの15%行動範囲: 1125 また、The Spiritを従えている間、Mordekaiserは元になったChampのADとAPの20％を得る。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 12, 2.5, ap(0.02)))
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 1.2, 0.25, ap(0.002)))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 100))
                .variable(4, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 24, 5, ap(0.04)))
                .cd(120, -15)
                .range(850);

        Morgana();
        Nami();
        Nasus();
        Nautilus();
        Nidalee();

        /** Nocturne */
        UmbraBlades.update()
                .passive("10秒に1度、通常攻撃のダメージが120%に増加し、{1}の敵ユニットにダメージを与える範囲攻撃になる。この効果がヒットした敵の数に応じて{2}する。また、通常攻撃を行うごとに、このスキルの{3}する。建物を攻撃する時はこの効果は発生しない。")
                .variable(1, Radius, 200)
                .variable(2, RestoreHealth, new Per6Level(10, 8))
                .variable(3, CDDecrease, 1)
                .cd(10);
        Duskbringer.update()
                .active("指定方向に影の刃を投げて当たった敵ユニットに{1}を与える。刃の軌跡には5秒間持続するDusk Trailが残り、刃がヒットした敵Championの動いた軌道上にもDusk Trailが残るようになる。Dusk Trailの上ではNocturneは{2}と{3}を得て、{4}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.75))
                .variable(2, AD, 15, 10)
                .variable(3, IgnoreUnitCollision)
                .variable(4, ASRatio, 15, 5)
                .mana(60, 5)
                .cd(10)
                .range(1200);
        ShroudOfDarkness.update()
                .passive("{1}する。")
                .variable(1, ASRatio, 20, 5)
                .active("Nocturneに1.5秒間持続する{2}を付与し、その間一度だけ敵のスキルを無効化する。無効化した場合、5秒間Passiveの増加攻撃速度が2倍になる。")
                .variable(2, Status.SpellShield)
                .mana(50)
                .cd(20, -2);
        UnspeakableHorror.update()
                .active("対象の敵ユニットに2秒間0.5秒毎に{1}、合計で{3}を与え、2秒間対象が一定範囲内(範囲465)に留まり続けていれば、更に{2}を与える。")
                .variable(1, MagicDamage, 12.5, 12.5, ap(0.25))
                .variable(2, Fear, 1, 0.25)
                .variable(3, MagicDamage, 50, 50, ap(1))
                .mana(60, 5)
                .cd(15, -1)
                .range(425);
        Paranoia.update()
                .active("4秒間すべての敵Championに{1}を与え、また自分以外の視界を得られなくする。効果中に範囲内にいる敵Championを指定すると対象の位置まで移動し、到着時に対象に{2}を与える。")
                .variable(1, Foggy, 300)
                .variable(2, PhysicalDamage, 150, 100, bounusAD(1.2))
                .mana(100)
                .cd(180, -40)
                .range(2000, 750);

        Nunu();
        Olaf();

        /** Orianna */
        ClockworkWindup.update()
                .passive("通常攻撃に追加{1}が付与される。4秒以内に同一の対象を連続して攻撃すると、追加魔法DMが20%上昇していく(最大+40%)。建物には無効。")
                .variable(1, MagicDamage, new Per3Level(10, 8), ap(0.15), null);
        CommandAttack.update()
                .active("指定した地点にBallを移動させ、移動中のBallに触れた敵ユニットと指定{1}にいる敵ユニットに{2}を与える。ダメージは敵に当たるごとに10%づつ減少する(最大60%減少)。BallはOriannaから一定距離離れなければその場に待機して{3}。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 60, 30, ap(0.5))
                .variable(3, Visionable)
                .mana(50)
                .cd(6, -0.75)
                .range(825);
        CommandDissonance.update()
                .active("Ballの存在する地点にフィールドを展開しBallの{1}にいる敵ユニットに{2}を与える。フィールドは3秒間持続し、フィールドの上の味方ユニットは{3}し、敵ユニットには{4}を与える。フィールドから出た場合、この効果は2秒かけて元に戻る。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 45, ap(0.7))
                .variable(3, MSRatio, 20, 5)
                .variable(4, MSSlowRatio, 20, 5)
                .mana(70, 10)
                .cd(9);
        CommandProtect.update()
                .passive("Ballが付いている味方Championは{1}と{2}を得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("対象の味方ChampionまでBallを移動させ、4秒間持続する{3}を付与する。また、移動中のBallに触れた敵ユニットに{4}を与える。Ballは対象がOriannaから一定距離離れなければ貼り付き続ける。")
                .variable(3, Shield, 80, 40, ap(0.4))
                .variable(4, MagicDamage, 60, 30, ap(0.3))
                .mana(60)
                .cd(9)
                .range(1120);
        CommandShockwave.update()
                .active("約0.5秒詠唱後にBallから衝撃波を発生させ、Ballの{1}にいる敵ユニットに{2}を与えると共に、Ballの方向に{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 75, ap(0.7))
                .variable(3, Knockback, 350)
                .mana(100, 25)
                .cd(120, -15);

        Pantheon();

        /** Poppy */
        ValiantFighter.update().passive("現在HPの10%を超えるダメージを受けた際、その超過分のダメージを50%低減する。塔の攻撃には無効。");
        DevastatingBlow.update()
                .active("次に行う通常攻撃が魔法DMになり、追加{1}が付与される。")
                .variable(1, MagicDamage, 20, 20, ap(0.6), amplify(TargetMaxHealthRatio, 8))
                .mana(55)
                .cd(8, -1);
        ParagonOfDemacia.update()
                .passive("通常攻撃を行うか、ダメージを受ける度にスタックが1増加する(最大10)。スタック数に比例して{1}と{2}を得る。スタックは5秒間増加がないと0になる。")
                .variable(-1, AD, 1.5, 0, amplify(Stack, 0.5))
                .variable(-2, AR, 1.5, 0, amplify(Stack, 0.5))
                .active("スタックを最大(10)まで増加させ、5秒間{3}する。")
                .variable(3, MSRatio, 17, 2)
                .mana(70, 5)
                .cd(12);
        HeroicCharge.update()
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。ノックバック時に壁にぶつかった場合、追加{3}と{4}を与える。")
                .variable(1, Knockback)
                .variable(2, MagicDamage, 50, 25, ap(0.4))
                .variable(3, MagicDamage, 75, 50, ap(0.4))
                .variable(4, Stun, 1.5)
                .mana(60, 5)
                .cd(12, -1)
                .range(525);
        DiplomaticImmunity.update()
                .active("対象の敵Championを{2}秒間ターゲットし、その対象に与える{1}する。効果中は対象以外からのすべての攻撃を無効化する(対象のPetからはダメージを受ける)。")
                .variable(1, DamageRatio, 20, 10)
                .variable(2, Time, 6, 1)
                .mana(100)
                .cd(140, -20)
                .range(900);

        /** Quinn */
        Harrier.update()
                .passive("ValorがQuinnの周辺に存在する敵ユニット一体(Champion優先)に自動的に4.5秒間持続するマークを付与する。マークが付与された敵ユニットにQuinnが通常攻撃を行うと、付与されたマークを消費して{1}を与える。またマークが付与された敵ユニットの{2}。Valorと交代している間はこのスキルは無効になる。")
                .variable(1, PhysicalDamage, new Per1Level(new double[] {25, 35, 45, 55, 65, 75, 85, 95, 105, 115, 125,
                        135, 145, 155, 170, 185, 190, 215}), bounusAD(0.5), null)
                .variable(2, Visionable)
                .cd(10);
        BlindingAssault.update()
                .active("指定方向にValorを突撃させ、最初に当たった敵ユニットと{1}の敵ユニットに{2}と{3}を与える。Tag Team時は自身の{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 200)
                .variable(2, PhysicalDamage, 70, 40, bounusAD(0.65))
                .variable(3, Blind, 1.5)
                .mana(60, 5)
                .cd(11, -1)
                .range(1025);
        BlindingAssault.update(P306).variable(2, PhysicalDamage, 70, 40, bounusAD(0.65), ap(0.5));
        HeightenedSenses.update()
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}する。Tag Team時は{2}する。")
                .variable(1, ASRatio, 20, 5)
                .variable(-2, ASRatio, 40, 10)
                .active("2秒間{3}の視界を得る。")
                .variable(3, Radius, 2100)
                .cd(50, -5);
        HeightenedSenses.update(P306)
                .passive("Harrierによってマークが付与された敵ユニットに通常攻撃を行うと、3秒間{1}、{3}する。Tag Team時は{2}する。")
                .variable(3, MS, 20, 10);
        Vault.update()
                .active("対象の敵ユニットまでダッシュし{1}と2秒間{2}を与える。スローの効果は2秒かけて元に戻る。ダッシュ後、Quinnは自身の通常攻撃の最大射程(距離525)までジャンプして対象と距離を離す。また、同時に対象にはHarrierのマークが付与される。Tag Team時はダッシュ後に距離を離さなくなる。")
                .variable(1, PhysicalDamage, 40, 30, bounusAD(0.2))
                .variable(2, MSSlowRatio, 50)
                .range(750)
                .mana(50)
                .cd(12, -1);
        TagTeam.update()
                .active("20秒間ValorがQuinnと入れ替わり戦闘に参加する。Valorは射程125のMeleeであり、専用のスキルが与えられるがスキルのCDはQuinnと共有する。Valorは{1}を得て{2}する。戦闘状態に入ると{3}する。このスキルを再度使用するか、20秒経過するとValorがQuinnと入れ替わり、{4}に敵ユニットに{5}を与える。対象が受けているダメージに比例して与えるダメージが増加し、最大で{6}を与える。")
                .variable(1, IgnoreUnitCollision)
                .variable(-2, MSRatio, 80)
                .variable(3, MSRatio, 20)
                .variable(4, Radius, 700)
                .variable(5, PhysicalDamage, 100, 50, bounusAD(0.5))
                .variable(6, PhysicalDamage, 200, 100, bounusAD(1))
                .cd(140, -20)
                .mana(100);
        TagTeam.update(P306).variable(-2, MSRatio, 80, 10).variable(3, MSRatio, 20, 10).cd(140, -30);

        Rammus();

        /** Renekton */
        ReignOfAnger.update()
                .passive("通常攻撃ごとにFuryが5増加する。12秒間戦闘を行わないとFuryは毎秒2.5減少する。Furyの最大値は100、Furyが50以上ある場合にスキルを使用すると、Furyを50消費してスキルが強化される。また、RenektonのHPが50%以下になるとFuryの増加量が50%増加する。建物を攻撃した場合はFuryは増加しない。");
        CullTheMeek.update()
                .active("武器を振り回し{1}の敵ユニットに{2}を与え、{3}する(上限あり)。対象がChampionの場合、{4}する。当たったユニット1体につきFuryが5増加する(最大25)。Fury消費すると与えるダメージが50%増加し、HP回復量が2倍、回復上限が3倍に増加する。但し、Fury増加効果は無くなる。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, 60, 30, bounusAD(0.8))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 5))
                .variable(4, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 20))
                .cd(8);
        RuthlessPredator.update()
                .active("次に行う通常攻撃が2回攻撃になり、{1}が付与される。Fury消費すると攻撃回数が3回に増加し、{2}を付与する。但し、Fury増加効果は無くなる。{3}。")
                .variable(1, Stun, 0.75)
                .variable(2, Stun, 1.5)
                .variable(3, OnHitEffect)
                .cd(13, -1);
        SliceandDice.update()
                .active("指定方向にダッシュし触れた敵ユニットに{1}を与える(Slice)。このスキルが敵にヒットした場合、4秒間の間だけ再度使用できる(Dice)。Fury消費時:Diceで与えるダメージが50%増加し、4秒間{2}を与える。SliceではFuryを消費しない。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.9))
                .variable(2, ARReductionRatio, 15, 5)
                .cd(18, -1)
                .range(450);
        Dominus.update()
                .active("15秒間サイズが大きくなり、スキルの射程が増加する。更に{1}を得て{2}の敵ユニットに毎秒{3}を与える。また、毎秒5Furyを得る。")
                .variable(1, Health, 300, 150)
                .variable(2, Radius, 350)
                .variable(3, MagicDamage, 40, 30, ap(0.1))
                .cd(120);

        Rengar();
        Riven();

        /** Rumble */
        JunkyardTitan.update()
                .passive("Ult以外のスキルを使うとHeatが20増加し、それが50以上になると「Danger Zone」状態に入り全てのスキルに追加効果がつくようになる。Heatが100になると6秒間スキルが使用不可能になり、通常攻撃に追加{1}が付与される。Heatは時間によって減少していく。追加魔法DMは建物には無効。")
                .variable(1, MagicDamage, 20, 0, ap(0.3), amplify(Lv, 5));
        Flamespitter.update()
                .active("3秒間前方の範囲を火炎放射器で焼き払い、範囲内の敵ユニットに毎秒{1}を与える。minionに与えるダメージは半分。Danger Zone中は{2}を与える。")
                .variable(1, MagicDamage, 30, 23.3, ap(0.45))
                .variable(2, MagicDamage, 37.5, 29.1, ap(0.56))
                .cd(6)
                .range(600);
        Flamespitter.update(P307)
                .variable(1, MagicDamage, 25, 20, ap(0.33))
                .variable(2, MagicDamage, 37.5, 30, ap(0.5));
        ScrapShield.update()
                .active("2秒間{1}を得て1秒間{2}する。Danger Zone中は{3}を得て1秒間{4}する。")
                .variable(1, Shield, 50, 30, ap(0.4))
                .variable(2, MSRatio, 10, 5)
                .variable(3, Shield, 62.5, 37.5, ap(0.5))
                .variable(4, MSRatio, 12.5, 6.25)
                .cd(6);
        ElectroHarpoon.update()
                .active("指定方向に銛を放ち当たった敵ユニットに{1}と3秒間{2}を与える。このスキルは3秒の間、2回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2発目はHeatが増加しない。また、このスキルによるスローはスタックする。Danger Zone中では{3}と3秒間{4}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MSSlowRatio, 15, 5)
                .variable(3, MagicDamage, 68.75, 37.5, ap(0.625))
                .variable(4, MSSlowRatio, 18.75, 6.25)
                .cd(10)
                .range(850);
        ElectroHarpoon.update(P307).variable(1, MagicDamage, 45, 25, ap(0.4));
        TheEqualizer.update()
                .active("指定した位置から指定方向({4})にロケットを打ち出し、当たった敵ユニットに{1}と{2}を与える。また5秒間ロケットの着弾した地面に炎が残り、その上にいる敵ユニットに毎秒{3}と{2}を与える。")
                .variable(1, MagicDamage, 150, 75, ap(0.5))
                .variable(2, MSSlowRatio, 35)
                .variable(3, MagicDamage, 100, 40, ap(0.2))
                .variable(4, Distance, 1000)
                .cd(105, -15)
                .range(1750);
        TheEqualizer.update(P305)
                .active("指定した位置から指定方向({4})にロケットを打ち出し、当たった地面を5秒間炎上させる。炎上した地面の上にいる敵ユニットに毎秒{3}と{2}を与える。")
                .variable(3, MagicDamage, 130, 55, ap(0.5))
                .variable(2, MSSlowRatio, 15, 5);

        /** Sejuani */
        Frost.update().passive("通常攻撃にFrostを付与する。Frost状態の敵ユニットは3秒間{1}になる。").variable(1, MSSlowRatio, 30);
        Frost.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、2秒間{1}と{2}を得る。この効果時間は最大8秒までスタックする。")
                .variable(1, AR, new Per5LevelForSejuani(10, 5))
                .variable(2, MSSlowReductionRatio, new Per5LevelForSejuani(10, 5));
        ArcticAssault.update()
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}とFrostを与え、対象がMinionの場合は更に{2}させる。敵Championに当たるか最大距離だけ移動すると突進は止まる。")
                .variable(1, MagicDamage, 60, 30, ap(0.4))
                .variable(2, Knockback)
                .mana(70, 5)
                .cd(19, -2)
                .range(700);
        ArcticAssault.update(P306)
                .active("指定方向に突進し、接触した全ての敵ユニットに{1}と{2}を与える（モンスターには最大300ダメージ）。敵Championに当たると突進は止まる。")
                .variable(1, Knockup)
                .variable(2, MagicDamage, 40, 30, ap(0.4), amplify(TargetMaxHealthRatio, 4, 2))
                .mana(80, 5)
                .cd(15, -1)
                .range(650);
        FlailOfTheNorthernWinds.update()
                .active("6秒間極寒の嵐を周囲に召還し、{1}の敵ユニットに毎秒{2}を与える。魔法DMは敵ユニットがFrostまたはPermafrostの時には50%増加する。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 12, 6, ap(0.1), amplify(Health, 0.01, 0.0025))
                .mana(40)
                .cd(10);
        FlailOfTheNorthernWinds.update(P306)
                .active("次の通常攻撃は、対象と{1}の敵達に{2}を与える。また4秒間{1}の敵に毎秒{3}を与える。(最大で{4})")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 20, ap(0.3))
                .variable(3, MagicDamage, 20, 10, ap(0.15), amplify(BounusHealth, 0.04))
                .variable(4, MagicDamage, 120, 60, ap(0.9), amplify(BounusHealth, 0.16))
                .cd(11, -1);
        FlailOfTheNorthernWinds.update(P308).variable(4, MagicDamage, 120, 60, ap(0.9), amplify(BounusHealth, 0.1));
        Permafrost.update()
                .active("{0}の敵ユニットのFrostをPermafrostにし、{1}を与える。Permafrost状態の敵ユニットは3秒間{2}を受ける。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 50, ap(0.5))
                .variable(2, MSSlowRatio, 30, 10)
                .mana(55)
                .cd(11);
        Permafrost.update(P306)
                .passive("通常攻撃かスキルによりダメージを与えると、対象を4秒間Frost状態にする。")
                .active("{0}のFrost状態の敵ユニットに{1}と{2}間{3}を与える。")
                .variable(0, Radius, 1000)
                .variable(1, MagicDamage, 60, 50, ap(0.5))
                .variable(2, Time, 2, 0.25)
                .variable(3, MSSlowRatio, 50, 5);
        Permafrost.update(P308).variable(2, Time, 1.5, 0.25);
        GlacialPrison.update()
                .active("指定方向に武器を投げ、最大距離飛ぶか敵Championに命中するとその場で氷が爆発し、{1}の敵ユニットに{2}と{3}を与え、Frostにする。武器が直撃した敵Championには{4}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1)
                .variable(4, Stun, 2)
                .mana(100)
                .cd(130, -15)
                .range(1150);
        GlacialPrison.update(P306)
                .active("指定方向に武器を投げ、敵Championに命中するとその場で爆発し、{1}の敵ユニットに{2}と{3}を与える。命中しなかった場合、最大射程で爆発し{1}の敵ユニットに{2}と{5}間{4}を与える。")
                .variable(3, Stun, 1.5, 0.25)
                .variable(4, MSSlowRatio, 90)
                .variable(5, Time, 1.5, 0.25);
        GlacialPrison.update(P308).variable(3, Stun, 1.25, 0.25).variable(5, Time, 1.25, 0.25);

        /** Shaco */
        Backstab.update().passive("対象の背後から攻撃した場合に{1}する。").variable(1, DamageRatio, 20);
        Deceive.update()
                .active("指定地点にテレポートし、{1}になる。また、スキル使用後6秒以内に通常攻撃を行うと必ずクリティカルになる。その際のクリティカルダメージは{2}になる。")
                .variable(1, Stealth, 3.5)
                .variable(2, Percentage, 140, 20)
                .cd(11)
                .mana(90, -10)
                .range(400);
        JackInTheBox.update()
                .active("指定地点に60秒持続する人形を設置する。人形は設置後2秒で{1}となり、敵ユニットがステルス状態の人形から範囲300以内に近づくと、人形のステルスが解除されると同時に近くの敵ユニットに{2}を与え、5秒間通常攻撃({3})を行った後に破壊される。")
                .variable(1, Stealth)
                .variable(2, Fear, 0.5, 0.25)
                .variable(3, MagicDamage, 35, 15, ap(0.2))
                .mana(60)
                .cd(16)
                .range(425);
        TwoShivPoison.update()
                .passive("通常攻撃に2秒間の{1}を付与する。対象がChampion以外の場合、更に命中率低下(値はスローと同じ)を与える。命中率低下を受けたユニットは一定確率で通常攻撃が外れる(ブラインドと同じ)。")
                .variable(1, MSSlowRatio, 10, 5)
                .active("対象の敵ユニットに{2}と3秒間{1}を与える。効果後はCDが解消されるまでPassiveの効果が無くなる。")
                .variable(2, MagicDamage, 50, 40, ap(1), bounusAD(1))
                .mana(50, 5)
                .cd(8)
                .range(625);
        Hallucinate.update()
                .active("18秒間持続する自身のイリュージョン(敵からの見た目は本体と同じ)を作成する。(RまたはALT押しながらクリックで任意の操作可能)イリュージョンは本体の75%の攻撃力を持ち、150%のダメージを受ける。また本体の一部アイテムの効果を引き継ぐ。イリュージョン死亡または効果時間終了時に爆発し、{1}の敵ユニットに{2}を与える。イリュージョンが塔に与えるダメージは半分。このスキルを使用してもステルスは解除されない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 300, 150, ap(1))
                .mana(100)
                .cd(100, -10);

        /** Shen */
        KiStrike.update()
                .passive("9秒に1度通常攻撃に追加{1}が付与され、{2}する。このスキルはShenが通常攻撃を行う度にCDが1秒解消される。CD解消は建物を攻撃した場合は発生しない。LV1/7/13で「気」回復量が増加する。")
                .variable(1, MagicDamage, 4, 0, amplify(Lv, 4), amplify(BounusHealth, 0.1))
                .variable(2, RestoreEnergy, new Per6Level(10, 10));
        VorpalBlade.update()
                .active("対象の敵ユニットに{1}と5秒間持続するDebuffを与える。Debuffが付与された対象に通常攻撃またはダメージスペルで攻撃をすると、攻撃した味方Championは3秒かけて{2}する。このスキルでLHを取った場合、{3}する。")
                .variable(1, MagicDamage, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 6, 4, amplify(Health, 0.015))
                .variable(3, RestoreHealth, 2, 1.3, amplify(Health, 0.005))
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(475);
        Feint.update()
                .active("3秒間{1}を得る。シールドが持続している間はKi StrikeのCD解消効果が1秒から2秒になる。")
                .variable(1, Shield, 70, 45, ap(0.6))
                .cd(9, -1)
                .cost(Energy, 50, 0);
        Feint.update(P310A).variable(1, Shield, 60, 40, ap(0.6));
        ShadowDash.update()
                .active("指定地点まで素早く移動し接触した敵Championに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける物理DMを半減する。またこのスキルが敵Championに命中する度に{3}する。")
                .variable(1, MagicDamage, 50, 35, ap(0.5))
                .variable(2, Taunt, 1.5)
                .variable(3, RestoreEnergy, 40)
                .cd(16, -2)
                .cost(Energy, 120, 0)
                .range(600);
        ShadowDash.update(P312)
                .active("指定地点まで素早く移動し接触した敵Championに{1}と{2}を与える。ShenはTaunt効果中の対象から受ける通常攻撃のDMを半減する。またこのスキルが敵Championに命中する度に{3}する。");
        StandUnited.update()
                .active("対象の味方Championに5秒間{1}を付与し、3秒詠唱後そこまでワープする。")
                .variable(1, Shield, 250, 300, ap(1.5))
                .cd(200, -20)
                .range(-1);
        StandUnited.update(P310A).active("対象の味方Championに5秒間{1}を付与し、3秒詠唱後そこまでワープする。詠唱中にスロー以外のCCを受けると中断される。");

        Shyvana();

        /** Singed */
        EmpoweredBulwark.update().passive("{1}を得る。").variable(1, Health, 0, 0, amplify(Mana, 0.25));
        PoisonTrail.update()
                .active("Singedの通り道に3.25秒間持続する毒を撒き、触れた敵ユニットに3秒間毎秒{1}を与える。")
                .variable(1, MagicDamage, 22, 0, ap(0.3))
                .mana(13)
                .cd(1)
                .type(SkillType.Toggle);
        MegaAdhesive.update()
                .active("指定地点に5秒間持続する粘着剤を撒き、{1}の敵ユニットに{2}を与え続ける。この効果は範囲外に出てからも1秒間持続する。")
                .variable(1, Radius, 350)
                .variable(2, MSSlowRatio, 35, 10)
                .mana(70, 10)
                .cd(14)
                .range(1000);
        Fling.update()
                .active("対象の敵ユニット{1}を与え、Singedの後ろに投げ飛ばす({2})。")
                .variable(1, MagicDamage, 100, 50, ap(1))
                .variable(2, Distance, 550)
                .mana(100, 10)
                .cd(10)
                .range(125);
        Fling.update(P304).variable(1, MagicDamage, 80, 45, ap(0.75));
        InsanityPotion.update()
                .active("25秒間{1}、{2}、{3}、{4}、{5}、{6}を得て、{7}する。")
                .variable(1, AP, 35, 15)
                .variable(2, AR, 35, 15)
                .variable(3, MR, 35, 15)
                .variable(4, Hreg, 35, 15)
                .variable(5, Mreg, 35, 15)
                .variable(6, Tenacity, 10, 5)
                .variable(7, MSRatio, 35, 15)
                .mana(150)
                .cd(100);
        InsanityPotion.update(P304).active("25秒間{1}、{2}、{3}、{4}、{5}を得て、{7}する。");

        /** Sion */
        GloryinDeath.update()
                .passive("40%の確率で{1}する。この軽減は防御力計算より先に行われる。")
                .variable(1, AttackDamageReduction, new Per6Level(30, 10));
        DecimatingSmash.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 70, 55, ap(0.9))
                .variable(2, Stun, 1.5)
                .mana(100)
                .cd(12, -1)
                .range(550);
        SoulFurnace.update()
                .active("{1}を得る。10秒間シールドが残っていた場合、シールドが破裂し{2}の敵ユニットに{3}を与える。使用から4秒後以降に再度使用で、即座にシールドを破裂させる。")
                .variable(1, Shield, 100, 50, ap(0.9))
                .variable(2, Radius, 550)
                .variable(3, MagicDamage, 100, 50, ap(0.9))
                .mana(70, 10)
                .cd(8);
        RoarOfTheSlayer.update()
                .active("{1}を得る。使用中にLHをとるとSionの最大HPが{2}増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍になる。")
                .variable(1, AD, 25, 10)
                .variable(2, Count, 1, 0.5)
                .cost(Health, 6, 2)
                .type(SkillType.Toggle);
        UnstoppableOnslaught.update()
                .active("20秒間{1}を得て{2}し、通常攻撃をするたびに{4}の味方ユニットは{3}する。")
                .variable(1, LS, 50, 25)
                .variable(2, ASRatio, 50)
                .variable(3, RestoreHealth, 0, 0, amplify(AttackDamageRatio, 25, 12.5))
                .variable(4, Radius, 200)
                .mana(100)
                .cd(90);

        Sivir();
        Skarner();
        Sona();
        Soraka();
        Swain();
        Syndra();
        Taric();
        Talon();
        Teemo();
        Thresh();

        /** Tristana */
        DrawaBead.update().passive("通常攻撃とExplosive Shotは追加の{1}を得る。").variable(1, Range, new Per1Level(0, 9));
        RapidFire.update().active("7秒間{1}する。").variable(1, ASRatio, 30, 15).mana(50).cd(20);
        RocketJump.update()
                .active("指定地点にジャンプしジャンプ先の{1}の敵ユニットに{2}と2.5秒間{3}を与える。キルかアシストをとるとこのスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .variable(3, MSSlowRatio, 60)
                .variable(4, CDDecrease)
                .mana(80)
                .cd(22, -2)
                .range(800);
        ExplosiveCharge.update()
                .passive("通常攻撃で敵ユニットを倒した時にそのユニットの{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 50, 25, ap(0.25))
                .active("対象の敵ユニットに5秒かけて{3}と{4}を与える。")
                .variable(3, MagicDamage, 110, 40, ap(1))
                .variable(4, Wounds)
                .mana(50, 10)
                .cd(16)
                .range(new Diff(616, 0, 1), amplify(Lv, 9));
        BusterShot.update()
                .active("対象の敵ユニットに{1}を与え、対象と{2}の敵ユニットを{3}させる。")
                .variable(1, MagicDamage, 300, 100, ap(1.5))
                .variable(2, Radius, 200)
                .variable(3, Knockback, 600, 200)
                .mana(100)
                .cd(60)
                .range(700);

        /** Trundle */
        KingsTribute.update()
                .passive("{1}以内で敵ユニットが死んだとき、{2}する。")
                .variable(1, Radius, 1000)
                .variable(2, RestoreHealth, 0, 0, amplify(TargetMaxHealthRatio, new Per4LevelForTrundle(2, 1)));
        Chomp.update()
                .active("次の通常攻撃で与えるダメージは{1}になる。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 30, 15, amplify(AD, 0.8, 0.1))
                .variable(2, AD, 20, 5)
                .variable(3, ADReduction, 10, 2.5)
                .mana(30)
                .cd(4);
        Chomp.update(P306)
                .active("次の通常攻撃は{1}と0.1秒間{4}を与える。8秒間{2}を得て、攻撃を受けたユニットは{3}する。建物には無効。")
                .variable(1, PhysicalDamage, 20, 20, amplify(AD, 1, 0.05))
                .variable(4, MSSlowRatio, 75);
        FrozenDomain.update()
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}して{4}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, ASRatio, 20, 10)
                .variable(3, MSRatio, 20, 5)
                .variable(4, Tenacity, 20, 5)
                .mana(60)
                .cd(15)
                .range(900);
        FrozenDomain.update(P306)
                .active("指定した地点の{1}に8秒間持続する呪いを振りまく。範囲内に入っている間、{2}、{3}、{4}する。")
                .variable(2, ASRatio, 20, 15)
                .variable(4, RestoreHealthRatio, 8, 3);
        PillarOfIce.update()
                .active("指定地点に{0}間持続する通行不可能なビーコンを設置し、ビーコンの{1}にいる敵ユニットに{2}を与える。また、{3}の視界を得る。")
                .variable(0, Time, 7)
                .variable(1, Radius, 375)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Radius, 1200)
                .mana(60)
                .cd(23, -3)
                .range(1000);
        PillarOfIce.update(P306).variable(0, Time, 6);
        Subjugate.update()
                .active("対象の敵ユニットに{1}を{2}、{3}を与える。その後6秒間かけて更に{1}と{2}、{3}を与える。このスキルでダメージを与えると{4}する。")
                .variable(1, MagicDamage, 100, 75, ap(0.6))
                .variable(2, ARReductionRatio, 15, 5)
                .variable(3, MRReductionRatio, 15, 5)
                .variable(4, RestoreHealth, 0, 0, amplify(DealtDamage, 1))
                .mana(75)
                .cd(80, -10)
                .range(700);
        Subjugate.update(P306)
                .active("対象の敵ユニットに{1}を与え、4秒間かけて{2}、{3}を与えて減少させた分の値を自身のARとMRに加算する、この効果はその後4秒間持続する。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 20, 2, ap(0.02)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, MRReductionRatio, 20);

        Tryndamere();

        /** Twisted Fate */
        LoadedDice.update().passive("味方Championが敵を倒した時に追加で{1}を得るようになる。").variable(1, Gold, 2);
        LoadedDice.update(P310).passive("ユニットを倒すたびに追加の{1}(1~6でランダム、但し期待値は3.5よりも大きくなる)を得る。").variable(1, Gold);
        WildCards.update()
                .active("指定向き3方向に貫通するカードを飛ばし、当たった敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.65))
                .mana(60, 10)
                .cd(6)
                .range(1450);
        PickACard.update()
                .active("使用するとBlue、Red、Goldの3種のカードを選択し始め、再度使用でカードが決定する。決定したカードにより次の通常攻撃が魔法DMに変換され、以下の効果が追加される。<br>Blue Card: {2}を与え{3}する。<br>Red Card: {4}の敵に{5}と2.5秒間{6}を与える。<br>Gold Card: {7}と{8}を与える。")
                .variable(2, MagicDamage, 40, 20, ap(0.4), ad(1))
                .variable(3, RestoreMana, 26, 13, ad(0.65))
                .variable(4, Radius, 100)
                .variable(5, MagicDamage, 30, 15, ap(0.4), ad(1))
                .variable(6, MSSlowRatio, 30, 5)
                .variable(7, MagicDamage, 15, 7.5, ap(0.4), ad(1))
                .variable(8, Stun, 1.2, 0.2)
                .mana(40, 15)
                .cd(6);
        PickACard.update(P307).variable(3, RestoreMana, 50, 25);
        PickACard.update(P310)
                .active("3種類のカードが順番に出現し、8秒以内に再度使用してカードを決定する。4秒以内の次の通常攻撃が魔法DMに変換され、以下の効果が追加される。<br>Blue Card: {2}を与え{3}する。<br>Red Card: {4}の敵に{5}と2.5秒間{6}を与える。<br>Gold Card: {7}と{8}を与える。");
        StackedDeck.update()
                .passive("{1}を得て{2}する。通常攻撃4回毎に追加{3}を与える。")
                .variable(1, CDR, 3, 3)
                .variable(2, ASRatio, 3, 3)
                .variable(3, MagicDamage, 55, 25, ap(0.4));
        StackedDeck.update(P307).passive("{2}する。通常攻撃4回毎に追加{3}を与える。").variable(2, ASRatio, 10, 5);
        Destiny.update()
                .active("{1}間すべての敵Champion(ステルス中のChampion含む)の視界を得る。効果中に再度使用すると2秒間移動・攻撃が不可能になった後、指定した地点にワープする。。効果中は敵Championの頭上にアイコンが表示される。")
                .variable(1, Time, 6, 2)
                .mana(150, -25)
                .cd(150, -15)
                .range(5500);
        Destiny.update(P307).cd(180, -30);

        /** Twitch */
        DeadlyVenom.update()
                .passive("通常攻撃時に毒を付与し、６秒間かけて{1}を与える。毒は6回までスタックする。")
                .variable(1, TrueDamage, new Per5Level(12, 12));
        Ambush.update()
                .active("使用から1.25秒後に{1}になる。ステルス状態では{2}し、ステルスを解除すると5秒間{3}する。ステルス準備中に攻撃を行うかダメージを受けると、ステルス状態になるのに再度1.25秒必要になる。ステルス準備開始から5秒経過するとダメージを受けていてもステルス状態になる。")
                .variable(1, Stealth, 4, 1)
                .variable(2, MSRatio, 20)
                .variable(3, ASRatio, 30, 10)
                .mana(60);
        VenomCask.update()
                .active("指定地点に{1}で毒の入った瓶を投げつけ、範囲内の敵ユニットに3秒間{2}と毒を2スタック分与える。また、指定した地点の{3}。")
                .variable(1, MissileSpeed, 1400)
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Visionable)
                .mana(50)
                .cd(13, -1)
                .range(950);
        Contaminate.update()
                .active("毒をスタックされている{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 1200)
                .variable(2, PhysicalDamage, 40, 10, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)))
                .mana(50, 10)
                .cd(12, -1);
        Contaminate.update(P310A).variable(2, PhysicalDamage, 20, 15, amplify(Stack, 15, 5, ap(0.2), bounusAD(0.25)));
        RatTaTatTat.update()
                .active("7秒間射程が850になり{1}を得て、通常攻撃が敵ユニットを貫通するようになる。対象との直線上にいる敵ユニットにもダメージと毒スタックを与える。ダメージは敵に当たるごとに20%減少する。最小で40%。")
                .variable(1, AD, 20, 8)
                .mana(100, 25)
                .cd(120, -10);

        /** Udyr */
        MonkeysAgility.update()
                .passive("スキルを使用する度に{1}、{2}、{3}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。")
                .variable(-1, ASRatio, 10)
                .variable(-2, ARRatio, 4)
                .variable(-3, MRRatio, 4);
        MonkeysAgility.update(P305)
                .passive("スキルを使用する度に{1}、{4}する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。")
                .variable(4, MS, 5);
        TigerStance.update()
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで{1}する。")
                .variable(-1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 30, 50, ad(1.5))
                .variable(3, ASRatio, 15, 5)
                .mana(55, -5)
                .cd(6);
        TigerStance.update(P305).mana(47, -3);
        TigerStance.update(P306)
                .active("次の通常攻撃は2秒間かけて追加の{2}を与えるようになり（建物には無効）、5秒間{3}する。別のスキルを使うまで通常攻撃は追加{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.15))
                .variable(2, PhysicalDamage, 30, 50, amplify(AD, 1.2, 0.1))
                .variable(3, ASRatio, 30, 10);
        TurtleStance.update()
                .active("5秒間{1}を得る。別のスキルを使うまで通常攻撃でクリティカルが発生しなくなるが、通常攻撃するごとに{2}し{3}する。")
                .variable(1, Shield, 60, 36, ap(0.5))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 10, 2))
                .variable(3, RestoreMana, 0, 0, amplify(DealtDamageRatio, 5, 1))
                .mana(55, -5)
                .cd(6);
        TurtleStance.update(P305)
                .active("5秒間{1}を得る。別のスキルを使うまで通常攻撃するごとに{2}する。")
                .variable(1, Shield, 60, 40, ap(0.5))
                .mana(47, -3);
        BearStance.update()
                .active("{1}間{2}する。別のスキルを使うまで通常攻撃は{3}を与える。この効果は同一の対象に6秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.5)
                .variable(2, MSRatio, 15, 3)
                .variable(3, Stun, 1)
                .mana(55, -5)
                .cd(6);
        BearStance.update(P305)
                .active("{1}間{2}し{4}を得る。別のスキルを使うまで通常攻撃は{3}を与える。この効果は同一の対象に6秒に1度しか発動しない。")
                .variable(1, Time, 2, 0.25)
                .variable(2, MSRatio, 15, 5)
                .variable(4, IgnoreUnitCollision)
                .mana(47, -3);
        PhoenixStance.update()
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、{2}と{3}を得る。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(1, MagicDamage, 15, 10, ap(0.25))
                .variable(2, AD, 8, 4)
                .variable(3, AP, 16, 8)
                .variable(4, MagicDamage, 40, 40, ap(0.25))
                .mana(55, -5)
                .cd(6);
        PhoenixStance.update(P305)
                .active("5秒間周囲の敵ユニットに毎秒{1}を与え、次の通常攻撃に前方の敵ユニットに{4}を与える効果を付与する。別のスキル使うまで通常攻撃を3回行うごとに火を吹き前方の敵ユニットに{4}を与える。")
                .variable(4, MagicDamage, 40, 40, ap(0.45))
                .mana(47, -3);

        /** Urgot */
        ZaunTouchedBoltAugmenter.update()
                .passive("通常攻撃またはAcid Hunterでダメージを与えた対象に、与えるダメージを15%低下するDebuffを付与する。この効果は2.5秒間持続する。");
        AcidHunter.update()
                .active("指定方向にミサイルを飛ばし当たった敵ユニットに{1}を与える。Noxian Corrosive Chargeの効果を受けている敵ユニットの近くを指定して使用すると、その敵ユニット目掛けてミサイルが飛んでいく。")
                .variable(1, PhysicalDamage, 10, 30, ad(0.85))
                .mana(40)
                .cd(2)
                .range(1000);
        TerrorCapacitor.update()
                .active("7秒間{1}を得る。シールドが残っている間は通常攻撃とAcid Hunterに1秒間{2}が付与される。")
                .variable(1, Shield, 80, 40, ap(0.8))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(55, 5)
                .cd(16, -1);
        NoxianCorrosiveCharge.update()
                .active("指定地点に爆弾を飛ばし{1}の敵ユニットに5秒間かけて{2}と{3}を与える。また指定地点の{4}。")
                .variable(1, Radius, 300)
                .variable(2, PhysicalDamage, 75, 55, bounusAD(0.6))
                .variable(3, MSSlowRatio, 12, 2)
                .variable(4, Visionable)
                .mana(50, 5)
                .cd(15, -1)
                .range(900);
        HyperKineticPositionReverser.update()
                .active("対象の敵Championに{1}を与え、5秒間{2}と{3}を得る。1秒詠唱後に敵Championと自分の位置を入れ替え、敵Championに3秒間{4}を与える。")
                .variable(1, Suppression, 1)
                .variable(2, AR, 60, 30)
                .variable(3, MR, 60, 30)
                .variable(4, MSSlowRatio, 40)
                .mana(120)
                .cd(120)
                .range(550, 150);

        Varus();
        Vayne();

        /** Veigar */
        Equilibrium.update().passive("{1}する。").variable(1, MregRatio, 0, 0, amplify(MissingManaPercentage, 0.01));
        BalefulStrike.update()
                .passive("敵Championを倒すと{1}を得る。")
                .variable(-1, AP, 1, 1)
                .active("対象の敵ユニットに{2}を与える。このスキルでLHを取るとAPが1増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+2)になる。")
                .variable(2, MagicDamage, 80, 45, ap(0.6))
                .mana(60, 5)
                .cd(8, -1)
                .range(650);
        DarkMatter.update()
                .active("指定地点に1.2秒後に隕石を降らし、{1}の敵ユニットに{2}を与える。また隕石が落下するまでの間、指定地点の{3}。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 120, 50, ap(1))
                .variable(3, Visionable)
                .mana(70, 10)
                .cd(10)
                .range(900);
        EventHorizon.update()
                .active("指定した{1}に3秒間魔法陣を呼び出し、魔法陣の縁に触れた敵ユニットに{2}を与える。")
                .variable(1, Radius, 425)
                .variable(2, Stun, 1.5, 0.25)
                .mana(80, 10)
                .cd(20, -1)
                .range(600);
        PrimordialBurst.update()
                .active("対象の敵Championに{1}を与える。")
                .variable(1, MagicDamage, 250, 125, ap(1.2), amplify(TargetAP, 0.8))
                .mana(125, 50)
                .cd(130, -20)
                .range(650);

        VelKoz();

        /** Vi */
        BlastShield.update()
                .passive("敵ユニットにスキルでダメージを与えると、3秒間{1}を得る。")
                .variable(1, Shield, 0, 0, amplify(Health, 0.1))
                .cd(new Per6LevelForVi(18, -5));
        VaultBreaker.update()
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.7))
                .variable(2, PhysicalDamage, 100, 60, bounusAD(1.4))
                .variable(3, Distance, 50)
                .variable(4, Distance, 600)
                .mana(50, 10)
                .cd(18, -2.5)
                .range(50);
        VaultBreaker.update(P303)
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25秒で最大)。再度使用で指定した方向へとダッシュし(最小{3}、最大{4})、命中した全ての敵ユニットに{1}を与える(最大で{2})。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。途中で詠唱を停止させられた場合、このスキルのCDは3秒になり、消費したmanaの半分が回復する。");
        DentingBlows.update()
                .passive("同一対象に3回連続して通常攻撃を行うと、{1}と4秒間{2}を与え、4秒間{3}する。(ミニオンやモンスターへは最大300DMを与える)")
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 6, 1, bounusAD(0.03)))
                .variable(2, ARReductionRatio, 20)
                .variable(3, ASRatio, 30, 5);
        DentingBlows.update(P303)
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 4, 1.5, bounusAD(0.03)));
        ExcessiveForce.update()
                .active("チャージを1つ消費することで、次の通常攻撃に追加{1}を付与し、対象とその後方扇形{2}にいる敵ユニットにもダメージを与える範囲攻撃になる。チャージは{3}毎に増加し、最大2つまでスタックされる。")
                .variable(1, PhysicalDamage, 5, 15, ad(1.15), ap(0.7))
                .variable(2, Radius, 600)
                .variable(3, CDRAwareTime, 14, -1.5)
                .mana(60)
                .cd(1);
        AssaultandBattery.update()
                .active("対象の敵Championに突撃し、{1}と{2}を与える。一連の動作中は{4}を得て、また対象のChampion以外でViに触れた敵ユニットには{3}を与え、左右に吹き飛ばす。")
                .variable(1, PhysicalDamage, 200, 125, bounusAD(1.4))
                .variable(2, Knockup, 1.25)
                .variable(3, PhysicalDamage, 150, 112.5, bounusAD(1.05))
                .variable(4, IgnoreCC)
                .mana(100, 25)
                .cd(130, -25)
                .range(700);

        Viktor();

        /** Vladimir */
        CrimsonPact.update()
                .passive(BounusHealth + "に比例して{1}を、" + AP + "に比例して{2}を得る。")
                .variable(1, AP, 0, 0, amplify(BounusHealth, 0.025))
                .variable(2, Health, 0, 0, ap(1.4));
        Transfusion.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。")
                .variable(1, MagicDamage, 90, 35, ap(0.6))
                .variable(2, RestoreHealth, 15, 10, ap(0.25))
                .cd(10, -1.5)
                .range(600);
        SanguinePool.update()
                .active("Vladimirが2秒間血の海に沈む。その間はターゲットされなくなり、{1}内にいる敵ユニットに0.5秒毎に{2}と{3}間の{4}を与え続ける。また、与えたダメージの12.5%Healthが回復する。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 20, 13.75, amplify(BounusHealth, 0.00375))
                .variable(3, Time, 1)
                .variable(4, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 20, 0)
                .cd(26, -3);
        TidesOfBlood.update()
                .active("{1}の敵ユニットに{2}を与える。使用する度にスタックが増加し、1スタックにつきこのスキルの基礎魔法DMとHPコストが25%増加し、{4}するく(最大4スタック)。スタックは10秒増加が無いと0になる。このスキルは周囲に敵ユニットがいなくても使用可能。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 60, 25, ap(0.45))
                .variable(4, RestoreHealthRatio, 4, 1)
                .cost(Health, 30, 10)
                .cd(4.5)
                .range(620);
        Hemoplague.update()
                .active("指定地点の{1}の敵ユニットに疫病を付与し、その敵ユニットは5秒間受けるダメージが12%増加する。効果終了時に{2}を与える。ダメージ増加効果のため実際には{3}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MagicDamage, 168, 112, ap(0.784))
                .cd(150, -15)
                .range(700);

        /** Volibear */
        ChosenOfTheStorm.update()
                .passive("VolibearのHPが30%以下になったとき、6秒間かけて{1}する。{2}。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.3))
                .variable(2, CDRUnaware)
                .cd(-120);
        RollingThunder.update()
                .active("4秒間{1}する。敵Championに向かって移動する場合は{2}する。また次の通常攻撃に追加{3}を付与し、対象をVolibearの後ろに投げ飛ばす。4秒間攻撃を行わないとCDになる。")
                .variable(1, MSRatio, 15)
                .variable(-2, MSRatio, 45)
                .variable(3, PhysicalDamage, 30, 30)
                .mana(40)
                .cd(12, -1);
        RollingThunder.update(P3051).variable(-2, MSRatio, 30, 5);
        Frenzy.update()
                .passive("通常攻撃でダメージを与える度にスタックが1増加し(最大3スタック)、{1}する。スタックは4秒持続する。")
                .variable(-1, ASRatio, 0, 0, amplify(Stack, 8, 3))
                .active("スタックが最大まで溜まった時のみ使用可能。対象の敵ユニットに{2}を与える。対象が失っているHP1%につきダメージが1%上昇する。")
                .variable(2, PhysicalDamage, 80, 45, amplify(BounusHealth, 0.15))
                .mana(35)
                .cd(17)
                .range(400);
        MajesticRoar.update()
                .active("{1}の敵ユニットに{2}と3秒間{3}を与える。対象がMinionの場合、さらに{4}を与える。")
                .variable(1, Radius, 425)
                .variable(2, MagicDamage, 60, 45, ap(0.6))
                .variable(3, MSSlowRatio, 30, 5)
                .variable(4, Fear, 3)
                .mana(60, 5)
                .cd(11);
        ThunderClaws.update()
                .active("12秒間Volibearが通常攻撃した対象に雷を放ち{1}を与える。雷は対象の{2}の敵ユニット(敵Championを優先)3体にも連鎖し同様のダメージを与える。建物を攻撃する時は効果は発生しない。")
                .variable(1, MagicDamage, 75, 40, ap(0.3))
                .variable(2, Radius, 300)
                .mana(100)
                .cd(100, -10);

        /** Warwick */
        EternalThirst.update()
                .passive("通常攻撃で対象にスタックを付与し、追加{1}を与え{2}する。スタックは4秒持続し、最大3つまでスタックされる。建物を攻撃した場合は無効。")
                .variable(1, MagicDamage, 0, 0, amplify(Stack, new Per1Level(new double[] {3, 3.5, 4, 4.5, 5, 5.5, 6,
                        6.5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16})))
                .variable(2, RestoreHealth, 0, 0, amplify(Stack, new Per1Level(new double[] {3, 3.5, 4, 4.5, 5, 5.5, 6,
                        6.5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16})));
        HungeringStrike.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。対象がChampionの場合は{3}と比較し大きいほうのDMを与える。")
                .variable(1, MagicDamage, 75, 50, ap(1))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 80))
                .variable(3, MagicDamage, 0, 0, ap(1), amplify(TargetMaxHealthRatio, 8, 2))
                .mana(70, 10)
                .cd(10, -1)
                .range(400);
        HuntersCall.update()
                .active("10秒間{2}し、{1}の味方Championは{3}する。")
                .variable(1, Radius, 1200)
                .variable(2, ASRatio, 40, 10)
                .variable(-3, ASRatio, 20, 5)
                .mana(35)
                .cd(24, -2);
        BloodScent.update()
                .passive("{1}して、{2}内にいるHPが50%以下の敵Championの{3}。このスキルで敵のステルスを看破する事はできず、ステルス中の敵Championの視界を得ることもできない。")
                .variable(1, MSRatio, 20, 5)
                .variable(2, Radius, 1500, 800)
                .variable(3, Visionable)
                .cd(4);
        InfiniteDuress.update()
                .active("対象の敵Championに突撃し{2}を与えて、その間{3}を得て0.42秒毎に{1}を、計5回で{4}を与える。{5}。")
                .variable(1, MagicDamage, 50, 17, bounusAD(0.4))
                .variable(2, Suppression, 1.8)
                .variable(3, LS, 30)
                .variable(4, MagicDamage, 250, 85, bounusAD(2))
                .variable(5, OnHitEffect)
                .type(SkillType.Channel)
                .mana(100, 25)
                .cd(90, -10)
                .range(700);
        InfiniteDuress.update(P307).active("対象の敵Championに突撃し{2}を与えて、その間{3}を得て0.3秒毎に{1}を、計5回で{4}を与える。{5}。");

        /** Wukong */
        StoneSkin.update()
                .passive("Wukongの視界内{1}にいる敵Championの数に比例して、{2}と{3}を得る。")
                .variable(1, Radius, 1400)
                .variable(2, AR, 0, 0, amplify(EnemyChampion, new Per6Level(4, 2)))
                .variable(3, MR, 0, 0, amplify(EnemyChampion, new Per6Level(4, 2)));
        CrushingBlow.update()
                .active("次の通常攻撃は射程が125増加して追加の{1}と3秒間の{2}を与える。")
                .variable(1, PhysicalDamage, 30, 30, ad(0.1))
                .variable(2, ARReductionRatio, 30)
                .mana(40)
                .cd(9, -1)
                .range(300);
        Decoy.update()
                .active("{1}になり{2}を得る。同時にWukongがいた場所に分身(操作不可能)を作り出す。分身は1.5秒経過すると消滅し、その際に分身の{3}の敵に{4}を与える。")
                .variable(1, Stealth, 1.5)
                .variable(2, IgnoreUnitCollision)
                .variable(3, Radius, 350)
                .variable(4, MagicDamage, 70, 45, ap(0.6))
                .mana(50, 5)
                .cd(18, -2);
        NimbusStrike.update()
                .active("対象の敵ユニットまでダッシュし{1}を与える。対象の敵ユニットの{3}の敵ユニット2体にもWukongの幻影が飛び、{1}を与える。また、スキル使用後4秒間{2}する。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.8))
                .variable(2, ASRatio, 30, 5)
                .variable(3, Radius, 325)
                .mana(45, 5)
                .cd(8)
                .range(625);
        Cyclone.update()
                .active("4秒間Wukongが回転する。回転中は{1}の敵ユニットに0.5秒毎に{2}と{3}を与える。打ち上げ効果は同一の対象に1度までしか発生しない。また、このスキルを使用してから0.5秒毎に{5}する。最大で{4}を与え、{6}する。")
                .variable(1, Radius, 325)
                .variable(2, PhysicalDamage, 10, 45, ad(0.6))
                .variable(3, Knockup, 1.5)
                .variable(4, PhysicalDamage, 80, 360, ad(4.8))
                .variable(-5, MSRatio, 5)
                .variable(6, MSRatio, 40)
                .mana(100)
                .cd(120, -15);

        Xerath();

        /** Xin Zhao */
        Challenge.update()
                .passive("通常攻撃または" + AudaciousCharge + "で指定した敵ユニットに{1}を与える。この効果はスタックせず、3秒間持続し、また1体の敵ユニットにしか発動しない。")
                .variable(1, ARReductionRatio, 15);
        ThreeTalonStrike.update()
                .active("次の3回の通常攻撃に{1}が追加され、3回目の攻撃で{2}を与える。効果中に通常攻撃を行う度に、このスキル以外のCDが1秒解消される。")
                .variable(1, PhysicalDamage, 15, 15, ad(0.2))
                .variable(2, Knockup, 1)
                .mana(30)
                .cd(9, -1);
        BattleCry.update()
                .passive("通常攻撃3回ごとに{1}する。")
                .variable(1, RestoreHealth, 26, 6, ap(0.7))
                .active("5秒間{2}増加する。")
                .variable(2, ASRatio, 40, 10)
                .mana(40)
                .cd(16, -1);
        AudaciousCharge.update()
                .active("対象の敵ユニットに突進し、{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MSSlowRatio, 25, 5)
                .mana(70)
                .cd(13, -1)
                .range(600);
        AudaciousCharge.update(P303).variable(2, MagicDamage, 70, 35, ap(0.6)).cd(14, -1);
        CrescentSweep.update()
                .active("槍を振り回し{3}の敵ユニットに{1}と{2}を与え、このスキルを命中させた敵Championの数に比例して6秒間{4}と{5}を得る。" + Challenge + "効果中の敵ユニットに対しては" + Knockback + "は発動しない。")
                .variable(1, PhysicalDamage, 125, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .variable(2, Knockback, 0)
                .variable(3, Radius, 375)
                .variable(4, AR, 15, 5)
                .variable(5, MR, 15, 5)
                .mana(100)
                .cd(100, -10);
        CrescentSweep.update(P303)
                .variable(1, PhysicalDamage, 75, 100, bounusAD(1), amplify(TargetCurrentHealthRatio, 0.15))
                .cd(120, -10);

        Yasuo();
        Yorick();
        Zac();
        Zed();
        Ziggs();

        /** Zilean */
        HeightenedLearning.update().passive("すべての味方Championが取得する{1}する。").variable(1, ExperimentRatio, 8);
        TimeBomb.update()
                .active("対象のユニットに爆弾をつけ、4秒後に対象(味方ユニットの場合ダメージ無し)とその周辺{1}の敵ユニットに{2}を与える。対象が死亡した場合は即座に爆発する。")
                .variable(1, Radius, 330)
                .variable(2, MagicDamage, 90, 55, ap(0.9))
                .mana(70, 15)
                .cd(10)
                .range(700);
        Rewind.update().active(Rewind + "以外のスキルのCDを10秒解消する。").mana(50).cd(18, -3);
        TimeWarp.update()
                .active("味方Championに使用した場合は{2}間{1}増加し、敵Championに使用した場合は{2}間{3}を与える。")
                .variable(1, MSRatio, 55)
                .variable(2, Time, 2.5, 0.75)
                .variable(3, MSSlowRatio, 55)
                .mana(80)
                .cd(20)
                .range(700);
        Chronoshift.update()
                .active("対象の味方Championが使用してから7秒以内に死亡した場合、2秒後にその場で{1}して復活する。")
                .variable(1, RestoreHealth, 600, 150, ap(2))
                .mana(125, 25)
                .cd(180)
                .range(900);

        Zyra();
    }

    private static void Aatrox() {
        BloodWell.update()
                .passive("スキルを使用時に消費したHealthをBlood Wellとしてスタックし(最大スタック量は{1})、5秒間戦闘状態でなくなると毎秒2%ずつ失われていく。スタックが2%貯まる毎に{2}する(最大で{3})。Healthが0になると3秒かけて{4}する(最大で{5})。{6}。")
                .variable(1, Stack, 30, 0, amplify(Lv, 45))
                .variable(-2, ASRatio, 0, 0, amplify(StackPercentage, 0.5))
                .variable(-3, ASRatio, 50)
                .variable(4, RestoreHealth, 10.5, 0, amplify(Lv, 15.75), amplify(Stack, 1))
                .variable(5, RestoreHealth, 40.5, 0, amplify(Lv, 60.75))
                .variable(6, CDRUnaware)
                .cd(-225);
        BloodWell.update(P313)
                .variable(-2, ASRatio, 0, 0, amplify(StackPercentage, new Per3Level(0.6, 0.1)))
                .variable(-3, ASRatio, new Per3Level(30, 5));
        DarkFlight.update()
                .active("指定地点に飛びかかり、{1}の敵ユニットに{2}を与える。範囲内の中心にいる敵ユニットに対しては更に{3}を与える。")
                .variable(1, Radius)
                .variable(2, PhysicalDamage, 70, 45, bounusAD(0.6))
                .variable(3, Knockup, 1)
                .cd(16, -1)
                .cost(CurrentHealthRatio, 10, 0)
                .range(650);
        BloodThirstBloodPrice.update()
                .passive("通常攻撃3回ごとに{1}する。Healthが50%以下の場合、{2}する。ToggleOnの間、この効果は失われる。")
                .variable(1, RestoreHealth, 20, 5, bounusAD(0.25))
                .variable(2, RestoreHealth, 60, 15, bounusAD(0.75))
                .active("通常攻撃3回ごとに{3}を与えて{4}する。")
                .variable(3, PhysicalDamage, 60, 35, bounusAD(1))
                .variable(4, LoseHealth, 15, 8.75, bounusAD(0.25))
                .cd(0.5)
                .type(SkillType.Toggle);
        BladesOfTorment.update()
                .active("指定方向に貫通するエネルギーを放ち、当たった敵ユニットに{1}と{2}間{3}を与える。")
                .variable(1, MagicDamage, 75, 45, ap(0.6), bounusAD(0.6))
                .variable(2, Time, 1.75, 0.25)
                .variable(3, MSSlowRatio, 40)
                .cost(CurrentHealthRatio, 5, 0)
                .cd(12, -1)
                .range(1000);
        BladesOfTorment.update(P313).variable(1, MagicDamage, 75, 35, ap(0.6), bounusAD(0.6));
        Massacre.update()
                .active("{1}の敵Championに{2}を与え、12秒間{3}し、通常攻撃の射程が325に増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 200, 100, ap(1))
                .variable(3, ASRatio, 40, 10)
                .cd(100, -15)
                .update(P506)
                .active("{1}の敵Championに{2}を与え、12秒間{3}し、通常攻撃の射程が325に増加する。当たった敵毎に20%の" + BloodWell + "を得る。");
    }

    private static void Ahri() {
        EssenceTheft.update()
                .passive("スキルが敵ユニットに当たる度に" + EssenceTheft + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルに{1}が追加される。")
                .variable(-1, SV, 35)
                .cost(Charge, 9, 0)
                .update(P313)
                .passive("スキルが敵ユニットに当たる度に" + EssenceTheft + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルが敵に当たる毎に{1}する。")
                .variable(1, RestoreHealth, 2, 0, ap(0.09), amplify(Lv, 1));
        OrbOfDeception.update()
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.33))
                .variable(2, TrueDamage, 40, 25, ap(0.33))
                .cd(7, 0)
                .mana(70, 5)
                .range(880)
                .update(P506)
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。オーブを射出している間{3}する。（0.5秒かけて80まで減衰）")
                .variable(1, MagicDamage, 40, 25, ap(0.35))
                .variable(2, TrueDamage, 40, 25, ap(0.35))
                .variable(3, MS, 215)
                .mana(65, 5);
        FoxFire.update()
                .active("Ahriの周囲を回る3本の鬼火を放つ。鬼火は5秒間持続し、近くの敵ユニットに自動的に突撃して{1}を与える。鬼火が同一対象に突撃した場合、2発目以降は本来の{2}分の魔法DMを与える(同一対象に3発命中すると{3})。Ahriの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。")
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .variable(2, Percentage, 50)
                .variable(3, MagicDamage, 80, 50, ap(0.8))
                .cd(9, -1)
                .mana(60)
                .range(800)
                .update(P313)
                .variable(2, Percentage, 30)
                .variable(3, MagicDamage, 64, 40, ap(0.64))
                .mana(50)
                .update(P506)
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .variable(2, Percentage, 30)
                .variable(3, MagicDamage, 64, 40, ap(0.64))
                .range(550)
                .mana(50);
        Charm.update()
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}を与える。")
                .variable(1, MagicDamage, 60, 30, ap(0.35))
                .variable(2, Status.Charm, 1, 0.25)
                .variable(3, MSSlowRatio, 50)
                .cd(12)
                .mana(50, 15)
                .range(975)
                .update(P313)
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}を与える。6秒間、対象はAhriから受けるDMが20%増加する。")
                .mana(85)
                .update(P506)
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}を与える。")
                .variable(1, MagicDamage, 60, 305, ap(0.5));
        SpiritRush.update()
                .active("指定方向にダッシュした後、{2}の敵ユニット(敵Championを優先)3体に{1}を与える。このスキルは10秒の間、3回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2～3発目はマナコスト無しで使用可能。同一対象に3発命中すると{3}。")
                .variable(1, MagicDamage, 85, 40, ap(0.35))
                .variable(2, Radius, 500)
                .variable(3, MagicDamage, 255, 120, ap(1.05))
                .cd(110, -15)
                .mana(100)
                .range(450)
                .update(P313)
                .variable(1, MagicDamage, 70, 40, ap(0.3))
                .variable(3, MagicDamage, 210, 120, ap(0.9))
                .update(P506)
                .variable(2, Radius, 600);
    }

    private static void Akali() {
        TwinDisciplines.update()
                .passive("{1}を得る。また通常攻撃に{2}が付与される。")
                .variable(1, SV, 6, 0, bounusAD(0.167))
                .variable(2, MagicDamage, 0, 0, amplify(AD, 0.06, 0, ap(0.00167)));
        MarkOfTheAssassin.update()
                .active("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃またはCrescent Slashでダメージを与えたとき、マークを消費して{2}を与え、{3}する。")
                .variable(1, MagicDamage, 45, 25, ap(0.4))
                .variable(2, MagicDamage, 45, 25, ap(0.4))
                .variable(3, RestoreEnergy, 20, 5)
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(600)
                .update(P3051)
                .variable(1, MagicDamage, 35, 20, ap(0.4))
                .variable(2, MagicDamage, 45, 25, ap(0.5))
                .update(P506)
                .active("対象の敵ユニットにカマを投げつけ{1}と6秒間マークを与える。マークが付いた対象に通常攻撃でダメージを与えたとき、マークを消費して{2}を与え、{3}する。");
        TwilightShroud.update()
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。Akaliは{2}と{3}、{5}を得る。敵ユニットには{4}を与える。")
                .variable(1, Radius, 300)
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .variable(4, MSSlowRatio, 14, 4)
                .variable(5, Stealth)
                .cd(20)
                .cost(Energy, 80, -5)
                .range(700)
                .update(P307)
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与えて{5}。Akaliは{2}と{3}、{5}を得る。敵ユニットには{4}を与える。")
                .variable(5, Visionable)
                .update(P506)
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。自身は{2}と{3}を得て、敵ユニットには{4}を与える。ステルスはスキル使用または通常攻撃時に解除され、再度ステルス化するのに0.65秒かかる。")
                .variable(1, Radius, 400)
                .variable(2, Stealth)
                .variable(3, MSRatio, 20, 20);
        CrescentSlash.update()
                .active("{2}の敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 30, 25, ap(0.3), ad(0.6))
                .variable(2, Radius, 325, 0)
                .cd(7, -1)
                .cost(Energy, 60, -5);
        ShadowDance.update()
                .active("対象の敵ユニットまで高速で移動し{1}を与える。使用時にチャージを消費する。チャージは{2}毎に又は敵Championキル/アシストで増加し最大で3つまでチャージされる。チャージ増加時間はCD低減の影響を受ける。")
                .variable(1, MagicDamage, 100, 75, ap(0.5))
                .variable(2, CDRAwareTime, 25, -5)
                .cd(2, -0.5)
                .cost(Charge, 1, 0)
                .range(800)
                .update(P3051)
                .variable(2, CDRAwareTime, 35, -10)
                .update(P307)
                .variable(2, CDRAwareTime, 30, -7.5)
                .update(P506)
                .range(700);
    }

    private static void Alistar() {
        Trample.update()
                .passive("スキルを使用すると3秒間{1}を得て、{2}の敵ユニットと建物に毎秒{3}を与える。ミニオンに対しては与えるダメージが2倍になる。")
                .variable(3, MagicDamage, 6, 0, ap(0.1), amplify(Lv, 1))
                .variable(2, Radius, 182.5)
                .variable(1, IgnoreUnitCollision);
        Pulverize.update()
                .active("{4}の敵ユニットに{1}を与え、{2}後に{3}を与える。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, Knockup, 1)
                .variable(3, Stun, 0.5, 0)
                .variable(4, Radius, 365)
                .cd(17, -1)
                .mana(65, 5);
        Headbutt.update()
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。")
                .variable(1, MagicDamage, 55, 55, ap(0.7))
                .variable(2, Knockback, 650)
                .cd(14, -1)
                .mana(65, 5)
                .range(650);
        TriumphantRoar.update()
                .active("{1}する。{3}の味方ユニットは{2}する。近くの敵ユニットが死ぬと{4}する。")
                .variable(1, RestoreHealth, 60, 30, ap(0.2))
                .variable(2, RestoreHealth, 30, 15, ap(0.1))
                .variable(3, Radius, 575)
                .variable(4, CDDecrease, 2)
                .cd(12, 0)
                .mana(40, 10);
        UnbreakableWill.update()
                .active("7秒間Alistarは{1}を得て、{2}する。Disable中でも使用可能。使用時に自身にかかっているCCを全て解除する。")
                .variable(1, AD, 60, 15)
                .variable(2, DamageReductionRatio, 70)
                .cd(120, -20)
                .mana(100, 0);
    }

    private static void Amumu() {
        CursedTouch.update().passive("通常攻撃した対象に3秒間{1}を与える。").variable(1, MRReduction, new Per6Level(15, 5));
        BandageToss.update()
                .active("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。")
                .variable(1, MagicDamage, 80, 60, ap(0.7))
                .variable(2, Stun, 1)
                .mana(80, 10)
                .cd(16, -2)
                .range(1100);
        BandageToss.update(P303).variable(1, MagicDamage, 80, 50, ap(0.7));
        Despair.update()
                .active("毎秒、{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 8, 4, amplify(TargetMaxHealthRatio, 1, 0.5, ap(0.01)))
                .variable(2, Radius, 350)
                .mana(8)
                .cd(1)
                .type(SkillType.Toggle);
        Tantrum.update()
                .passive("{1}する。")
                .variable(1, PhysicalDamageReduction, 2, 2)
                .active("{3}の敵ユニットに{2}を与える。Amumuが通常攻撃でダメージを受けるたびに{4}。")
                .variable(2, MagicDamage, 75, 25, ap(0.5))
                .variable(3, Radius, 400)
                .variable(4, CDDecrease, 0.5)
                .mana(35)
                .cd(10, -1);
        CurseOfTheSadMummy.update()
                .active("{2}の敵ユニットに{1}を与え、2秒間通常攻撃と移動を封じる。")
                .variable(1, MagicDamage, 150, 100, ap(0.8))
                .variable(2, Radius, 600)
                .mana(100, 50)
                .cd(150, -20)
                .update(P303)
                .variable(2, Radius, 550);
    }

    private static void Anivia() {
        Rebirth.update()
                .passive("死亡時に卵になり6秒かけて復活する。復活中は{1}及び{2}を得る。復活中にHPが0になった場合は死亡する。{3}。")
                .variable(-1, AR, new Per4Level(-40, 15))
                .variable(-2, MR, new Per4Level(-40, 15))
                .variable(3, CDRUnaware)
                .cd(-240);
        FlashFrost.update()
                .active("指定方向に貫通する氷を飛ばし、氷に触れた敵ユニットに{1}と3秒間{2}を与え、{4}状態にする。氷が飛んでいる最中に再度スキルを使用するか、最大距離まで飛ぶと氷が破裂し、破裂地点の{6}の敵ユニットにさらに{1}と{5}と3秒間{2}を与え、{4}状態にする。")
                .variable(1, MagicDamage, 60, 30, ap(0.5))
                .variable(2, MSSlowRatio, 20)
                .variable(4, Chill, 0)
                .variable(5, Stun, 1)
                .variable(6, Radius, 150)
                .mana(80, 20)
                .cd(12, -1)
                .range(1100)
                .update(P401)
                .mana(80, 10);
        Crystallize.update()
                .active("指定地点に5秒間{1}の壁を作りユニットを通れなくする。また、指定地点の{2}。")
                .variable(1, Length, 400, 100)
                .variable(2, Visionable)
                .mana(70, 20)
                .cd(25)
                .range(1000)
                .update(P401)
                .mana(70);
        Frostbite.update()
                .active("対象の敵ユニットに{1}を与える。対象が" + Chill + "の場合は{2}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MagicDamage, 110, 60, ap(1.0))
                .mana(50, 10)
                .cd(5)
                .range(650);
        GlacialStorm.update()
                .active("指定地点の{6}の敵ユニットに毎秒{1}、1秒間の{2}と{3}を与え、{5}状態にする。")
                .variable(1, MagicDamage, 80, 40, ap(0.25))
                .variable(2, ASSlowRatio, 20, 0)
                .variable(3, MSSlowRatio, 20)
                .variable(5, Chill, 0)
                .variable(6, Radius, 300)
                .mana(75)
                .cd(6)
                .range(625)
                .type(SkillType.Toggle);
    }

    private static void Annie() {
        Pyromania.update()
                .passive("スキルを使用するたびにスタックが1貯まり、4スタック時に" + MoltenShield + "以外のスキルを使用すると、スタックを全て消費してそのスキルに{1}が追加される。")
                .variable(1, Stun, 1.75)
                .update(P401)
                .variable(1, Stun, new Per5Level3Times(1.25, 0.25));
        Disintegrate.update()
                .active("対象の敵ユニットに{1}を与える。このスキルでLHを取ると{2}する。")
                .variable(1, MagicDamage, 85, 40, ap(0.7))
                .variable(2, RestoreMana, 60, 5)
                .mana(60, 5)
                .cd(4)
                .range(625);
        Incinerate.update()
                .active("指定方向扇形45°の{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 625)
                .variable(2, MagicDamage, 80, 50, ap(0.75))
                .mana(70, 10)
                .cd(8);
        MoltenShield.update()
                .active("{1}間{2}と{3}を得て、効果時間中に通常攻撃をしてきた敵ユニットに{4}を与える。")
                .variable(1, Time, 5)
                .variable(2, AR, 20, 10)
                .variable(3, MR, 20, 10)
                .variable(4, MagicDamage, 20, 10, ap(0.2))
                .mana(20)
                .cd(10);
        SummonTibbers.update()
                .active("指定地点の{1}の敵ユニットに{2}を与え、操作可能なTibbersを召喚する。Tibbersは{3}間持続し、{4}の敵ユニットに毎秒{5}を与える。TibbersはALT押しながら右クリックで任意の操作が可能で以下のステータスを持つ。<br>Health : {6}<br>通常攻撃 : {7}<br>AR : {8}<br>MR : {9}<br>MS : {10}")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 200, 125, ap(0.7))
                .variable(3, Time, 45, 0)
                .variable(4, Radius, 200)
                .variable(5, MagicDamage, 35, 0, ap(0.2))
                .variable(6, Value, 1200, 400)
                .variable(7, MagicDamage, 80, 25)
                .variable(8, Value, 30, 20)
                .variable(9, Value, 25, 20)
                .variable(10, Value, 350)
                .mana(125, 50)
                .cd(120)
                .range(600)
                .update(P308)
                .variable(6, Value, 1200, 900)
                .variable(9, Value, 30, 20)
                .mana(100)
                .update(P401)
                .cd(120, -20);
    }

    private static void Ashe() {
        FrostShot.update().passive("3秒毎に{1}する(最大100%)。通常攻撃を行うとリセットされる。").variable(-1, Critical, new Per3Level(3, 3));
        FrostShot.update(P308)
                .passive("3秒間通常攻撃を行わないと毎秒{1}増加していく(最大100)。スタックが100の時、建物以外に通常攻撃を行うと、スタックをすべて消費して通常攻撃がクリティカルになり、スタックの値がクリティカル率と同じ値となる。")
                .variable(1, Stack, new Per5LevelForAshe(3, 1));
        FrostShot.update(P310).variable(1, Stack, new Per5LevelForAshe(4, 1));
        RangersFocus.update()
                .active("通常攻撃に2秒間の{1}を付与する。")
                .variable(1, MSSlowRatio, 15, 5)
                .mana(8)
                .type(SkillType.ToggleForAttack);
        Volley.update()
                .active("指定方向扇形57.5°の方向に非貫通の矢7本を飛ばし当たった敵ユニットに{1}と{2}(" + FrostShot + "のLvに依存)を与える。" + FrostShot + "を覚えていない場合はスローは発生しない。")
                .variable(1, PhysicalDamage, 40, 10, ad(1))
                .variable(2, MSSlowRatio, 0)
                .mana(60)
                .cd(16, -3)
                .range(1200);
        Hawkshot.update()
                .passive("敵を倒した際に追加で{1}を得る。")
                .variable(1, Gold, 1, 1)
                .active("指定地点に偵察鷹を放つ。鷹は5秒間指定した地点の{2}。また飛行中の鷹も{2}。")
                .variable(2, Visionable)
                .cd(60)
                .range(2500, 750)
                .update(P402)
                .cd(60, -5)
                .variable(1, Gold, 3);
        EnchantedCrystalArrow.update()
                .active("指定方向に敵Championにのみ当たる矢を飛ばし、当たった敵Championに{1}と{2}(飛距離に比例して１～3.5秒)と3秒間の{4}を与える。また敵Champion命中時に矢が爆発し、{5}の敵ユニットに{6}と3秒間の{4}を与える。飛行中の矢は{3}。")
                .variable(1, MagicDamage, 250, 175, ap(1))
                .variable(2, Stun, 0)
                .variable(3, Visionable)
                .variable(4, MSSlowRatio, 50)
                .variable(5, Radius, 250)
                .variable(6, MagicDamage, 125, 87.5, ap(0.5))
                .mana(150)
                .cd(100, -10)
                .range(-1);
        EnchantedCrystalArrow.update(P313).mana(100);
    }

    private static void Blitzcrank() {
        ManaBarrier.update()
                .passive(" HPが20%以下になると、10秒間持続する{1}を張る。")
                .variable(1, Shield, 0, 0, amplify(CurrentManaRatio, 50))
                .cd(90);
        RocketGrab.update()
                .active("指定方向に腕を飛ばし、当たった敵ユニットに{1}と{2}を与え自分の位置まで引き寄せる。またこのスキル命中時に対象の{3}。")
                .variable(1, MagicDamage, 80, 55, ap(1))
                .variable(2, Stun, 1)
                .variable(3, Visionable)
                .mana(120)
                .cd(20, -1)
                .range(925);
        Overdrive.update()
                .active("8秒間{1}、{2}する。")
                .variable(1, MSRatio, 16, 4)
                .variable(2, ASRatio, 30, 8)
                .mana(75)
                .cd(15);
        PowerFist.update()
                .active("次の通常攻撃に追加{1}を付与し、対象に{2}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1))
                .variable(2, Knockup, 1, 0)
                .mana(25)
                .cd(9, -1);
        StaticField.update()
                .passive("{1}の敵ユニット1体(対象はランダム)に2.5秒ごとに{2}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 100, 100, ap(0.25))
                .active("{3}の敵ユニットに{4}と{5}を与える。効果後はCDが解消されるまでPassiveの効果がなくなる。")
                .variable(3, Radius, 600)
                .variable(4, MagicDamage, 250, 125, ap(1))
                .variable(5, Silence, 0.5)
                .mana(150)
                .cd(30);
    }

    private static void Caitlyn() {
        Headshot.update()
                .passive("通常攻撃{1}回毎にダメージが増加する(Minionには250%、Championには150%)。茂みから通常攻撃を行うと2回分としてカウントされる。")
                .variable(1, Count, new Per6Level(8, -1));
        Headshot.update(P307)
                .passive("通常攻撃{1}回毎にダメージが増加する(Minionには250%、Championには150%、建物への攻撃は無効)。茂みから通常攻撃を行うと2回分としてカウントされる。");
        PiltoverPeacemaker.update()
                .active("1秒詠唱後、指定方向に貫通する弾を発射し当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%減少していき最小で{2}を与える。")
                .variable(1, PhysicalDamage, 20, 40, ad(1.3))
                .variable(2, PhysicalDamage, 10, 20, ad(0.65))
                .mana(50, 10)
                .cd(10, -1)
                .range(1250);
        YordleSnapTrap.update()
                .active("指定地点に罠を仕掛ける。敵Championが罠の{4}に入ると発動して、対象に{1}かけて{2}と{3}を与え、9秒間対象の{5}。罠は3個まで置け、4分間持続する。")
                .variable(1, Time, 1.5)
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Snare, 1.5)
                .variable(4, Radius, 135)
                .variable(5, Visionable)
                .mana(50)
                .cd(20, -3)
                .range(800);
        CaliberNet.update()
                .active("指定方向にネットを飛ばし当たった敵ユニットに{1}と{3}間{2}を与え、Caitlynはネットを飛ばした方向の反対側にジャンプ({4})する。")
                .variable(1, MagicDamage, 80, 50, ap(0.8))
                .variable(2, MSSlowRatio, 50)
                .variable(3, Time, 1, 0.25)
                .variable(4, Distance, 400)
                .mana(75)
                .cd(18, -2)
                .range(850);
        AceinTheHole.update()
                .active("0.5秒詠唱後に対象の敵Championの視界を得て、更に1秒詠唱後対象に目掛けて敵Championにのみ当たる弾を発射し、当たった敵Championに{1}を与える。ターゲットとの射線を遮ると間に入った敵Championに当たる。")
                .variable(1, PhysicalDamage, 250, 225, bounusAD(2))
                .mana(100)
                .cd(90, -15)
                .range(2000, 500);
    }

    private static void Cassiopeia() {
        AspectOfTheSerpent.update().passive("スキル使用後の5秒間、全てのスキルのコストが1スタックにつき10%低減する。");
        NoxiousBlast.update()
                .active("指定地点に0.5秒後に毒を発生させ、{1}の敵ユニットに毒を与え3秒かけて{2}を与える。このスキルがChampionにヒットした場合、3秒間{3}する。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 75, 40, ap(0.8))
                .variable(3, MSRatio, 15, 2.5)
                .mana(35, 10)
                .cd(3)
                .range(850);
        Miasma.update()
                .active("指定地点に7秒間持続する毒霧を吹き出す。毒霧は徐々に範囲(100～175)が広がり、毒霧の上を通過した敵に2秒間持続する毒を付与し{1}と2秒間{3}を与える。また指定地点の{4}。")
                .variable(1, MagicDamage, 25, 10, ap(0.15))
                .variable(3, MSSlowRatio, 15, 5)
                .variable(4, Visionable)
                .mana(70, 10)
                .cd(9)
                .range(850);
        TwinFang.update()
                .active("対象の敵ユニットに{1}を与える。対象が毒を受けている場合、CDが0.5秒になる。")
                .variable(1, MagicDamage, 50, 35, ap(0.55))
                .mana(50, 10)
                .cd(5)
                .range(700);
        PetrifyingGaze.update()
                .active("眼からビームを放ち、指定方向扇形83°の範囲内の敵ユニットに{1}を与え、こちらを向いている敵に更に{2}を与える。後ろを向いていた場合2秒間{4}を与える。")
                .variable(1, MagicDamage, 200, 125, ap(0.6))
                .variable(2, Stun, 2)
                .variable(4, MSSlowRatio, 60)
                .mana(120, 40)
                .cd(130, -10)
                .range(750);
        PetrifyingGaze.update(P312).mana(100);
    }

    private static void ChoGath() {
        Carnivore.update()
                .passive("敵ユニットを倒すと{1}、{2}する。")
                .variable(1, RestoreHealth, 17, 0, amplify(Lv, 3))
                .variable(2, RestoreMana, 3.25, 0, amplify(Lv, 0.25));
        Rupture.update()
                .active("指定地点に0.5秒後にトゲを出現させ、{1}の敵ユニットに{2}、{3}を与えて、3秒間{5}にする。また指定地点の視界を得る。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(3, Knockup, 1)
                .variable(5, MSSlowRatio, 60)
                .mana(90)
                .cd(9)
                .range(950);
        FeralScream.update()
                .active("前方扇形60°の領域の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 50, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 10)
                .cd(13)
                .range(700);
        VorpalSpikes.update()
                .active("通常攻撃時に前方にトゲを飛ばし当たった敵ユニットに{1}を与える。トゲを飛ばす範囲はUltのスタック数に比例し増加する。")
                .variable(1, MagicDamage, 20, 15, ap(0.3))
                .cd(0.5)
                .range(500)
                .type(SkillType.Toggle);
        Feast.update()
                .active("対象の敵ユニットに{1}を与える。対象がChampion以外の場合は{2}を与える。このスキルで敵を倒すとスタックが1増えて{3}と{4}を得る。死亡するとスタックが半分(端数切り上げ)消失する。")
                .variable(1, TrueDamage, 300, 175, ap(0.7))
                .variable(2, TrueDamage, 1000, 0, ap(0.7))
                .variable(3, Health, 0, 0, amplify(Stack, 90, 30))
                .variable(4, Range, 0, 0, amplify(Stack, 4, 2.15))
                .mana(100)
                .cd(60)
                .range(150);
    }

    private static void Corki() {
        HextechShrapnelShells.update().passive("通常攻撃に{1}が付与される。建物には無効。").variable(1, TrueDamage, 0, 0, ad(0.1));
        PhosphorusBomb.update()
                .active("指定した{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。また、Championに当たった場合、6秒間そのChampionの{3}。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .variable(3, Visionable)
                .mana(80, 10)
                .cd(8)
                .range(600)
                .update(P314)
                .active("指定地点に爆弾を発射し、着弾時に{1}の敵ユニットに{2}を与え、6秒間指定地点の{3}。爆弾にも視界がある。また、Championに当たった場合、6秒間そのChampionの{3}。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .mana(60, 10)
                .range(825)
                .update(P403)
                .variable(2, MagicDamage, 80, 50, ap(0.5), bounusAD(0.5));

        Valkyrie.update()
                .active("指定地点まで高速で移動し、通過地点を2.5秒間炎上させる。炎上地点の上にいる敵ユニットに毎秒{2}を与える。")
                .variable(2, MagicDamage, 60, 30, ap(0.4))
                .mana(100)
                .cd(26, -3)
                .range(800);
        Valkyrie.update(P309).mana(50);
        GatlingGun.update()
                .active("4秒間、Corkiの前方にいる敵ユニットに0.5秒毎に{1}を与える(最大8hit)。ダメージを与える度に対象ユニットに{2}を与える。この効果は2秒間持続し、8回までスタックする。")
                .variable(1, PhysicalDamage, 10, 6, bounusAD(0.02))
                .variable(2, ARReduction, 1, 1)
                .mana(60, 5)
                .cd(16)
                .range(600);
        GatlingGun.update(P314).mana(50);
        MissileBarrage.update()
                .active("スタックを消費して、指定方向にミサイルを発射し当たった敵ユニットの{1}に{2}を与える。スタックは{3}毎に増加する（最大数7）。4発毎に大きいミサイルを発射する({4}に{5})。スタック増加時間はCD低減の影響を受ける。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 120, 70, ap(0.3), ad(0.2))
                .variable(3, CDRAwareTime, 12)
                .variable(4, Radius, 300)
                .variable(5, MagicDamage, 180, 105, ap(0.45), ad(0.3))
                .mana(30, 5)
                .cd(1.2)
                .range(1225);
        MissileBarrage.update(P305)
                .active("スタックを消費して、指定方向にミサイルを発射し当たった敵ユニットの{1}に{2}を与える。スタックは{3}毎に増加する（最大数7）。3発毎に大きいミサイル({4}に{5})を発射させる。スタック増加時間はCD低減の影響を受ける。")
                .variable(3, CDRAwareTime, 12, -2);
        MissileBarrage.update(P309).mana(20);
        MissileBarrage.update(P313).variable(2, MagicDamage, 100, 80, ap(0.3), ad(0.02)).cd(-2);
        MissileBarrage.update(P314)
                .variable(2, MagicDamage, 120, 70, ap(0.3), amplify(AD, 0.2, 0.1))
                .variable(5, MagicDamage, 180, 105, ap(0.45), amplify(AD, 0.3, 0.15));
    }

    private static void Brand() {
        Blaze.update()
                .passive("スキルが当たった敵ユニットを炎上させ、毎秒{1}与える。この効果は4秒間続く。炎上している敵ユニットにスキルが命中すると追加効果が発生する。(Minionに対しては毎秒80DMが上限)")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2));
        Sear.update()
                .active("指定方向に火球を投射し、当たった敵ユニットに{1}を与える。敵が炎上していた場合、{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.65))
                .variable(2, Stun, 2)
                .mana(50)
                .cd(8, -0.5)
                .range(1025);
        PillarOfFlame.update()
                .active("指定地点に炎の柱を作り出し、0.5秒後に{1}の敵ユニットに{2}を与える。敵が炎上していた場合、代わりに{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 75, 45, ap(0.6))
                .variable(3, MagicDamage, 94, 56, ap(0.75))
                .mana(70, 10)
                .cd(10)
                .range(900);
        PillarOfFlame.update(P309).mana(70, 5);
        Conflagration.update()
                .active("対象の敵ユニットに{1}を与える。敵が炎上していた場合、{2}の敵にも{1}を与える。")
                .variable(1, MagicDamage, 70, 35, ap(0.55))
                .variable(2, Radius, 200)
                .mana(60, 5)
                .cd(12, -1)
                .range(625);
        Conflagration.update(P309).mana(70, 5);
        Pyroclasm.update()
                .active("対象の敵ユニットに火炎弾を放つ。火炎弾は近くの敵ユニットに4回まで跳ね、その度に{1}を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。敵が炎上していた場合、敵Championに優先して跳ね返るようになる。")
                .variable(1, MagicDamage, 150, 100, ap(0.5))
                .mana(100, 50)
                .cd(105, -15)
                .range(750);
        Pyroclasm.update(P309).mana(100);
    }

    private static void Diana() {
        MoonsilverBlade.update()
                .passive("{1}する。通常攻撃3回毎に周囲にいる敵ユニットに{2}を与える。")
                .variable(1, ASRatio, 20)
                .variable(2, MagicDamage, new Per1Level(new double[] {20, 25, 30, 40, 50, 65, 80, 95, 110, 125, 140,
                        155, 175, 195, 215, 240, 265, 290}));
        MoonsilverBlade.update(P307).variable(2, MagicDamage, new Per1Level(new double[] {20, 25, 30, 35, 40, 50, 60,
                70, 80, 90, 105, 120, 135, 155, 175, 200, 225, 250}));
        CrescentStrike.update()
                .active("指定地点に弧を描くエネルギーを放ち、当たった敵ユニットと{2}のユニットに{1}とMoonlight(3秒)を与える。またMoonlightが付与されている敵ユニットの{3}。")
                .variable(1, MagicDamage, 60, 35, ap(0.7))
                .variable(2, Radius, 50)
                .variable(3, Visionable)
                .mana(55)
                .cd(10, -1)
                .range(830);
        PaleCascade.update()
                .active("5秒間{1}を張ると同時に、Dianaの周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発すると{1}が張りなおされる。")
                .variable(1, Shield, 55, 25, ap(0.45))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 20, 14, ap(0.2))
                .mana(60, 10)
                .cd(10);
        PaleCascade.update(P307)
                .active("5秒間{1}を張ると同時に、Dianaの周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発すると{1}が追加される。")
                .variable(1, Shield, 40, 15, ap(0.3))
                .variable(3, MagicDamage, 22, 12, ap(0.2));
        Moonfall.update()
                .active("{1}にいるすべての敵ユニットをDianaがいる方向に引き寄せた後、2秒間{3}を与える。")
                .variable(1, Radius, 500)
                .variable(3, MSSlowRatio, 35, 5)
                .mana(70)
                .cd(26, -2);
        LunarRush.update()
                .active("対象の敵ユニットの元までテレポートし、{1}を与える。対象にMoonlightが付与されていた場合、すべての敵ユニットに付与されたMoonlightを消費してこのスキルの{2}する。")
                .variable(1, MagicDamage, 100, 60, ap(0.6))
                .variable(2, CDDecrease)
                .mana(50, 15)
                .cd(25, -5)
                .range(825);
    }

    private static void Darius() {
        Hemorrhage.update()
                .passive("通常攻撃またはスキルでダメージを与えた敵ユニットに出血スタックを付与する。出血スタックが付与された敵ユニットは毎秒{1}を受ける。出血スタックは最大5回までスタックし、5秒間持続する。また、出血スタックを受けている敵Champion数に応じて{2}していく。")
                .variable(1, MagicDamage, 2.4, 0, amplify(Lv, 0.3), bounusAD(0.06))
                .variable(-2, MSRatio, 5);
        Decimate.update()
                .active("斧を振り回し{3}の敵ユニットに{1}を与える。斧の刃に当たった敵Championに対しては{2}を与える。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.7))
                .variable(2, PhysicalDamage, 105, 52.5, bounusAD(1.05))
                .variable(3, Radius, 425)
                .mana(40)
                .cd(9, -1);
        CripplingStrike.update()
                .active("次の通常攻撃に{1}を追加し、2秒間{3}と{4}が付与される。対象の出血スタック数1個につき、このスキルの{5}する。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.2))
                .variable(3, ASSlowRatio, 20, 5)
                .variable(4, MSSlowRatio, 20, 5)
                .variable(5, CDDecrease, 1)
                .mana(30, 5)
                .cd(8);
        Apprehend.update()
                .passive("{1}を得る。")
                .variable(1, ARPenRatio, 5, 5)
                .active("前方範囲内の敵ユニットをDariusがいる方向に引き寄せる。")
                .mana(45)
                .cd(24, -3)
                .range(550);
        NoxianGuillotine.update()
                .active("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、{3}する。")
                .variable(1, TrueDamage, 160, 90, bounusAD(0.75))
                .variable(3, CDDecrease)
                .mana(100)
                .cd(100, -10)
                .range(475)
                .update(P303)
                .active("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、{4}間再使用することが出来る。この効果はキルを取るたびに適用される。")
                .variable(4, Time, 12)
                .cd(120, -20)
                .update(P401)
                .variable(4, Time, 20);
    }

    private static void Draven() {
        LeagueOfDraven.update()
                .passive("クリティカル時または" + SpinningAxe + "使用時の通常攻撃に毎秒{1}が付与される。毎秒ダメージは4秒間持続する。")
                .variable(1, PhysicalDamage, 7.5, 0, amplify(Lv, 1));
        LeagueOfDraven.update(P309)
                .passive("Spinning Axeをキャッチするか、ミニオンかモンスターを倒すと、スタックを得る。敵Championを倒すと、スタックの半分を消費して{1}を得る。死亡時にスタックを半分失う。")
                .variable(1, Gold, 0, 0, amplify(ConsumedStack, 3));
        LeagueOfDraven.update(P311)
                .passive("Spinning Axeをキャッチするか、ミニオンかモンスターを倒すと、スタックを得る。敵Championを倒すと、スタックを消費して{1}を得る。死亡時にスタックを半分失う。")
                .variable(1, Gold, 50, 0, amplify(ConsumedStack, 2));
        SpinningAxe.update()
                .active("次に行う通常攻撃に追加{1}が付与される。このスキルによる通常攻撃が敵ユニットに命中すると、斧がDravenの近くに跳ね返る。その斧をキャッチするとBlood RushのCDが解消され、更に次の通常攻撃もSpinning Axeの効果を受けるようになる。このスキルは連続で使用する事で最大2回分までチャージできる。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.45, 0.1))
                .mana(45)
                .cd(12, -1);
        BloodRush.update()
                .active("1.5秒間{1}し、3秒間{2}する。移動速度増加は1.5秒かけて元に戻る。")
                .variable(1, MSRatio, 40, 5)
                .variable(2, ASRatio, 20, 5)
                .mana(40)
                .cd(12);
        StandAside.update()
                .active("指定方向に貫通する斧を投げ、当たった敵ユニットに{1}と{2}と2秒間{3}を与える。このノックバックは斧から弾かれる形で左右に吹き飛ぶ。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.5))
                .variable(2, Knockback, 0)
                .variable(3, MSSlowRatio, 20, 5)
                .mana(70)
                .cd(18, -1)
                .range(1050);
        WhirlingDeath.update()
                .active("指定方向に地面を這う貫通する斧を投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに8%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定があり、斧が飛んでいる最中に再度このスキルを使用するか、敵Championに命中した時点で斧が反転してDravenの元に戻ってくる。反転した際、低下ダメージはリセットされる。また移動中の斧は{2}。")
                .variable(1, PhysicalDamage, 175, 100, bounusAD(1.1))
                .variable(2, Visionable)
                .mana(120)
                .cd(110)
                .range(-1);
    }

    private static void DrMundo() {
        AdrenalineRush.update().passive("毎秒{1}する。").variable(1, RestoreHealth, 0, 0, amplify(Health, 0.003));
        InfectedCleaver.update()
                .active("指定方向に包丁を投げ（{7}）、当たった敵ユニットに{1}と2秒間の{3}を与える。最小で{4}。ミニオンやモンスターへの最大DMは{5}。命中すると{6}する。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 15, 3))
                .variable(3, MSSlowRatio, 40)
                .variable(4, MagicDamage, 80, 50)
                .variable(5, MagicDamage, 300, 100)
                .variable(6, RestoreHealth, 25, 5)
                .variable(7, MissileWidth, 80)
                .cost(Health, 50, 10)
                .cd(4)
                .range(1000)
                .update(P402)
                .variable(7, MissileWidth, 60);
        BurningAgony.update()
                .active("{1}の敵ユニットに毎秒{2}を与える。また{3}を得る。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 35, 15, ap(0.2))
                .variable(3, Tenacity, 10, 5)
                .cost(Health, 10, 5)
                .cd(4)
                .type(SkillType.Toggle);
        Masochism.update()
                .active("5秒間{1}を得る。")
                .variable(1, AD, 40, 15, amplify(MissingHealthPercentage, 0.4, 0.15))
                .cost(Health, 35, 10)
                .cd(7);
        Sadism.update()
                .active("12秒かけて{1}し、{2}する。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.4, 0.15))
                .variable(2, MSRatio, 15, 10)
                .cd(75)
                .cost(CurrentHealthRatio, 20, 0);
    }

    private static void Evelynn() {
        ShadowWalk.update()
                .passive("Evelynnが{2}状態になる。スキルを使うか、ダメージを受けるか与えるかすると、6秒間ステルスが解除された状態になる。敵Championに範囲700まで近づくとステルス状態でも敵Championに視認されるようになる。また、ステルス中は毎秒{1}していく。")
                .variable(1, RestoreMana, 0, 0, amplify(Mana, 0.01))
                .variable(2, Stealth);
        HateSpike.update()
                .active("視界内にいる最も近くにいる敵ユニット1体に向けて棘を放ち({2})、直線状にいる敵ユニットに{1}を与える。Evelynnが敵ユニットをターゲットしている場合は、その対象に向けて棘が放たれる。")
                .variable(1, MagicDamage, 40, 20, ap(0.45), bounusAD(0.5))
                .variable(2, MissileSpeed, 2000)
                .mana(16, 6)
                .cd(1.5)
                .range(400)
                .update(P401)
                .variable(2, MissileSpeed, 1250)
                .update(P402)
                .variable(2, MissileSpeed, 2000);
        DarkFrenzy.update()
                .passive("敵Championにスキルを当てるたびに{1}する。この効果は3秒間持続し、最大4スタックする。")
                .variable(-1, MS, 4, 4)
                .active("3秒間{2}して、{3}と{4}を得る。敵Championキル/アシスト時に、このスキルの{5}する。")
                .variable(2, MSRatio, 30, 10)
                .variable(3, IgnoreSlow)
                .variable(4, IgnoreUnitCollision)
                .variable(5, CDDecrease)
                .cd(15);
        Ravage.update()
                .active("対象の敵ユニットに2回連続で{1}を与え、3秒間{2}する。")
                .variable(1, MagicDamage, 35, 20, ap(0.5), bounusAD(0.5))
                .variable(2, ASRatio, 60, 15)
                .mana(50, 5)
                .cd(9)
                .range(225)
                .update(P401)
                .variable(1, PhysicalDamage, 35, 20, ap(0.5), bounusAD(0.5));
        AgonysEmbrace.update()
                .active("指定{1}の敵ユニットに{2}と2秒間の{3}を与え、0.5秒後にこのスキルを命中させた敵Champion毎に6秒間持続する{4}を得る。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 15, 5, ap(0.01)))
                .variable(3, MSSlowRatio, 30, 20)
                .variable(4, Shield, 150, 75)
                .mana(100)
                .cd(150, -30)
                .range(650)
                .update(P401)
                .active("指定{1}の敵ユニットに{2}と2秒間の{3}を与え、このスキルを命中させた敵Champion毎に6秒間持続する{4}を得る。");
    }

    private static void Elise() {
        SpiderQueen.update()
                .passive("Human Form時に使用したスキルが敵ユニットに命中するとSpiderlingのチャージを1得る。Spider Formになるとチャージ数に比例したSpiderlingを召喚する。召喚される数はSpider Formのレベルに比例し増加する。召喚されたSpiderlingは死亡するとチャージが減るが、再度Human Formに戻ると再度チャージ状態に戻る。<br>Health: {1}<br>AD: {2}<br>AS: 0.665<br>AR: {3}<br>MR: {4}<br>MS: 370<br>AoEスキルのダメージを{5}低減")
                .variable(1, Value, 100, 0, amplify(Lv, 25))
                .variable(2, Value, new Refer(SpiderForm, 10, 10), ap(0.1), null)
                .variable(3, Value, 30)
                .variable(4, Value, 50)
                .variable(5, Percentage, 25);
        SpiderQueen.update(P310)
                .variable(1, Value, 80, 0, amplify(Lv, 10))
                .variable(3, Value, new Refer(SpiderForm, 30, 20))
                .variable(4, Value, new Refer(SpiderForm, 50, 20))
                .variable(5, Percentage, new Refer(SpiderForm, 10, 10));
        NeurotoxinVenomousBite.update()
                .active("対象の敵ユニットに毒を放ち{1}を与える。")
                .variable(1, MagicDamage, 50, 45, amplify(TargetCurrentHealthRatio, 8, 0, ap(0.03)))
                .mana(80, 5)
                .cd(6)
                .range(650);
        NeurotoxinVenomousBite.update(P304)
                .variable(1, MagicDamage, 40, 40, amplify(Status.TargetCurrentHealthRatio, 8, 0, ap(0.03)))
                .range(625);
        VolatileSpiderlingSkitteringFrenzy.update()
                .active("指定地点に蜘蛛を放つ。蜘蛛は敵ユニットに当たるか3秒間経過すると爆発し、範囲内の敵ユニットに{1}を与える。蜘蛛は指定地点に移動した後、最も近くにいる敵ユニットに向かって移動する。また{2}。")
                .variable(1, MagicDamage, 75, 50, ap(0.8))
                .variable(2, Visionable)
                .mana(60, 10)
                .cd(12)
                .range(950);
        CocoonRappel.update()
                .active("指定方向に糸を飛ばし当たった敵ユニットに{1}を与え、{2}。")
                .variable(1, Stun, 1.5)
                .variable(2, Visionable)
                .mana(50)
                .cd(14, -1)
                .range(1075);
        SpiderForm.update()
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{2}と{3}を得て、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, AR, 10, 5)
                .variable(3, MR, 10, 5)
                .variable(4, MS, 10)
                .cd(4);
        SpiderForm.update(P307)
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。");
        SpiderForm.update(P309)
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{4}する。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。{5}。")
                .variable(5, NotSpellCast);
        VenomousBiteNeurotoxin.update()
                .active("対象の敵ユニットに飛びつき{1}を与える。")
                .variable(1, MagicDamage, 50, 45, amplify(TargetMissingHealthRatio, 8, 0, ap(0.03)))
                .cd(6)
                .range(475);
        VenomousBiteNeurotoxin.update(P304)
                .variable(1, MagicDamage, 60, 50, amplify(TargetMissingHealthRatio, 8, 0, ap(0.03)));
        SkitteringFrenzyVolatileSpiderling.update()
                .passive("Spiderlingの{1}する。")
                .variable(1, ASRatio, 5, 5)
                .active("3秒間EliseとSpiderlingの{2}する。また、その間Spiderlingが攻撃を行うたびにEliseの{3}する。")
                .variable(2, ASRatio, 60, 20)
                .variable(3, RestoreHealth, 4, 0, ap(0.02))
                .cd(12);
        SkitteringFrenzyVolatileSpiderling.update(P307).variable(3, RestoreHealth, 4, 0, ap(0.04));
        RappelCocoon.update()
                .active("EliseとSpiderlingが上空に退避し(ターゲット不可になる)指定の方法で降下する。上空にいる間は射程内の視界を得る地面をクリックした場合: 最大2秒間上空に待機し、初期位置へ降下する。この間、敵ユニットをターゲットし裏側に降下できる。敵ユニットをクリックした場合: 即座に下降し裏側に降り立つ。")
                .cd(26, -2)
                .range(1075);
        HumanForm.update()
                .passive("通常攻撃に追加{1}が付与される。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .active("EliseがHuman Formに変身し射程550のRangedになる。")
                .cd(4);
        HumanForm.update(P307).passive("通常攻撃に追加{1}が付与される。{2}。").variable(2, NotSpellCast);
    }

    private static void Ezreal() {
        RisingSpellForce.update().passive("ユニット(敵味方問わず)にスキルを当てる度に5秒間{1}する。この効果は5回分までスタックする。").variable(-1, ASRatio, 10);
        MysticShot.update()
                .active("指定方向に魔法の矢を飛ばし、当たった敵ユニットに{1}を与える。このスキルが命中すると、Ezrealのすべてのスキルの{2}。{3}")
                .variable(1, PhysicalDamage, 35, 20, ap(0.2), ad(1))
                .variable(2, CDDecrease, 1)
                .variable(3, OnHitEffect)
                .mana(28, 3)
                .cd(6, -0.5)
                .range(1150);
        EssenceFlux.update()
                .active("指定方向にChampionにのみ当たる貫通するエネルギーを飛ばし、当たった味方Championには5秒間{1}し、敵Championには{2}を与える。")
                .variable(1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .mana(50, 10)
                .cd(9)
                .range(1000);
        ArcaneShift.update()
                .active("指定地点にテレポートし、テレポート先から一番近い敵ユニット({1})1体に{2}を与える。")
                .variable(1, Radius, 750)
                .variable(2, MagicDamage, 75, 50, ap(0.75))
                .mana(90)
                .cd(19, -2)
                .range(475);
        TrueshotBarrage.update()
                .active("1秒詠唱後、指定方向に射程無限の貫通する魔法の矢を飛ばし当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%ずつ減り、最大で30%まで低下する。また飛行中の矢は{2}。")
                .variable(1, MagicDamage, 350, 150, ap(0.9), bounusAD(1))
                .variable(2, Visionable)
                .mana(100)
                .cd(80)
                .range(-1);
    }

    private static void Fiddlesticks() {
        Dread.update().passive("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 1000).variable(2, Status.MRReduction, 10);

        Terrify.update()
                .active("対象の敵ユニットに{1}を与える。")
                .variable(1, Fear, 1, 0.5)
                .mana(65, 10)
                .cd(15, -1)
                .range(575)
                .update(P315)
                .variable(1, Fear, 1.25, 0.25)
                .mana(65);

        Drain.update()
                .active("対象の敵ユニットに最大5秒間毎秒{1}を与え、{2}する。敵が離れる({3})と詠唱が中断される。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 60, 5))
                .variable(3, Radius, 750)
                .mana(80, 10)
                .cd(10, -1)
                .range(475)
                .type(SkillType.Channel)
                .update(P403)
                .range(575);

        DarkWind.update()
                .active("対象の敵ユニットにカラスを飛ばし{1}と{2}を与える。カラスは{4}の敵ユニットに4回まで跳ね返りその度に効果を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。ミニオンとモンスターに対しては{3}を与える。")
                .variable(1, MagicDamage, 65, 20, ap(0.45))
                .variable(2, Silence, 1.2)
                .variable(3, MagicDamage, 97.5, 30, ap(0.675))
                .variable(4, Radius, 450)
                .mana(50, 20)
                .cd(15, -1)
                .range(750);

        Crowstorm.update()
                .active("1.5秒詠唱後に指定地点にテレポートし、{1}の敵ユニットに5秒間毎秒{2}を与える。最大DMは{3}となる。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 125, 100, ap(0.45))
                .variable(3, MagicDamage, 625, 500, ap(2.25))
                .mana(150, 50)
                .cd(150, -10)
                .range(800)
                .type(SkillType.Channel)
                .update(P315)
                .mana(100);
    }

    private static void Fiora() {
        Duelist.update()
                .passive("通常攻撃またはLungeでダメージを与えると、6秒かけて{1}する。対象がChampionの場合、この効果は4回までスタックする。")
                .variable(1, RestoreHealth, 7, 0, amplify(Lv, 1));
        Lunge.update()
                .active("対象の敵ユニットへダッシュし{1}を与える。このスキルは4秒の間、もう1度だけ使用できる。2度目は消費MN無しで使用可能。")
                .variable(1, PhysicalDamage, 40, 25, bounusAD(0.6))
                .mana(60)
                .cd(16, -2)
                .range(600);
        Riposte.update()
                .passive("{1}を得る。")
                .variable(1, AD, 15, 5)
                .active("1.5秒の間に受ける通常攻撃を一度だけ無効化し、その相手に{2}を与える。この効果は一部のミニオンとモンスターには発生しない。")
                .variable(2, MagicDamage, 60, 50, ap(1))
                .mana(45)
                .cd(10, -1);
        BurstOfSpeed.update()
                .active("3秒間{1}する。効果中に通常攻撃を行うかまたはLungeを使用すると3秒間{2}する。移動速度の増加は3回までスタックする。敵Championを倒すとこのスキルの{3}する。")
                .variable(1, ASRatio, 60, 15)
                .variable(2, MSRatio, 7, 2)
                .variable(3, CDDecrease)
                .mana(55)
                .cd(15, -1);
        BladeWaltz.update()
                .active("対象の敵Championにダッシュし{1}を与え、範囲内にいる敵Championをランダムに対象とし4回{1}を与える(合計5回)。最後の攻撃は最初に対象とした敵Championで固定。同一ユニットに複数回DMを与える場合、2回目以降は25%のダメージになる。単一対象への最大DMは{2}。{3}。")
                .variable(1, PhysicalDamage, 160, 170, bounusAD(1.15))
                .variable(2, PhysicalDamage, 320, 340, bounusAD(2.3))
                .variable(3, OnHitEffect)
                .mana(100)
                .cd(130, -10)
                .range(400);
    }

    private static void Fizz() {
        NimbleFighter.update()
                .passive("{2}を得て、{1}する。この軽減は防御力計算より先に行われる。")
                .variable(1, AttackDamageReduction, new Per3Level(4, 2))
                .variable(2, IgnoreUnitCollision);
        UrchinStrike.update()
                .active("対象の敵ユニットに追加{1}が付与された通常攻撃を与え、その方向に駆け抜ける。移動距離は固定。{2}。")
                .variable(1, MagicDamage, 10, 30, ap(0.6))
                .variable(2, OnHitEffect)
                .mana(50, 5)
                .cd(10, -1)
                .range(550);
        SeastoneTrident.update()
                .passive("通常攻撃に{1}が付与される。このダメージは0.5秒毎に3秒間かけて与えられる。(Minionに対しては300DMが上限)")
                .variable(1, MagicDamage, 30, 10, ap(0.35), amplify(TargetMissingHealthRatio, 4, 1))
                .active("5秒間通常攻撃に{2}と{3}を付与する。このダメージはPassiveと重複する。")
                .variable(2, MagicDamage, 10, 5, ap(0.35))
                .variable(3, Wounds, 3)
                .mana(40)
                .cd(10);
        SeastoneTrident.update(P313).variable(2, MagicDamage, 10, 5, ap(0.15));
        PlayfulTrickster.update()
                .active("指定地点にジャンプする。ジャンプ中はターゲットされない状態になる。0.75秒後にその場に降下し、{1}の敵ユニットに{2}と2秒間{3}を与える。また、ジャンプ中に再使用することで降下する場所を別の指定地点に変更しできる。その場合、{4}の敵ユニットに{5}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 50, ap(0.75))
                .variable(3, MSSlowRatio, 40, 5)
                .variable(4, Radius, 150)
                .variable(5, MagicDamage, 70, 50, ap(0.75))
                .mana(90, 10)
                .cd(16, -2)
                .range(400);
        ChumTheWaters.update()
                .active("指定地点に敵Championのみに命中する魚を投げ、命中した敵Championに魚がくっつき、{1}を与える。その1.5秒後に地面から鮫が現れ、魚が命中した対象を襲い、対象とその周囲({2})の敵ユニットに{3}を与え、{4}後に1.5秒間{5}を与える。魚がくっついていた敵Champion以外のユニットには{4}の代わりに{6}を与える。魚がChampionに当たらなかった場合は指定地点に魚が残り、その地点に鮫が現れる。また魚は視界を確保し、その上を敵Championが通り過ぎると、当たった場合と同様にその敵Championにくっつき、鮫が襲いかかる。")
                .variable(1, MSSlowRatio, 50, 10)
                .variable(2, Radius, 250)
                .variable(3, MagicDamage, 200, 125, ap(1))
                .variable(4, Knockup, 0)
                .variable(5, MSSlowRatio, 50, 10)
                .variable(6, Knockback, 0)
                .mana(100)
                .cd(100, -15)
                .range(1275);
    }

    private static void Gragas() {
        HappyHour.update().passive("スキル使用後に4秒かけて{1}する。").variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02));
        BarrelRoll.update()
                .active("指定地点に樽を転がし、爆発時に{1}の敵ユニットに{2}と3秒間{3}を与える。樽は5秒経つか、スキルを再度使用すると爆発する。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 85, 50, ap(0.9))
                .variable(3, ASSlowRatio, 20, 5)
                .mana(80, 10)
                .cd(12, -1)
                .range(1100);
        BarrelRoll.update(P314).range(950);
        DrunkenRage.update()
                .active("{1}する。さらに1秒詠唱後に20秒間{2}を得て、{3}するようになる。")
                .variable(1, RestoreMana, 30, 15)
                .variable(2, AD, 30, 10)
                .variable(3, DamageReductionRatio, 10, 2)
                .cd(25);
        BodySlam.update()
                .active("指定方向に突進し、衝突した敵ユニットとその周囲にいる敵ユニットに{1}と2.5秒間{2}を与える。衝突時に突進は止まる。衝突地点に複数の敵ユニットがいた場合、{3}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.5), ad(0.66))
                .variable(2, MSSlowRatio, 35)
                .variable(3, MagicDamage, 50, 25, ap(0.5))
                .mana(75)
                .cd(7)
                .range(650)
                .update(P314)
                .active("指定方向に突進し、衝突した敵ユニットとその周囲にいる敵ユニットに{1}と2.5秒間{2}を与える。衝突時に突進は止まる。ユニットに当たった場合{3}する。")
                .variable(3, CDDecreaseRatio, 50)
                .cd(12)
                .update(P403)
                .variable(1, MagicDamage, 80, 40, ap(0.5), amplify(AD, 0.3, 0.1));

        ExplosiveCask.update()
                .active("指定地点に爆発する樽を投げ、{1}内の敵ユニットに{2}を与え、{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 200, 125, ap(1))
                .variable(3, Knockback, 800)
                .mana(100, 25)
                .cd(100, -10)
                .range(1050)
                .update(P403)
                .variable(2, MagicDamage, 200, 125, ap(0.9))
                .mana(100);
    }

    private static void Hecarim() {
        Warpath.update()
                .passive("{2}と{1}を得る。")
                .variable(1, AD, 0, 0, amplify(BounusMS, new Per3LevelAdditional(0.1, 0.025)))
                .variable(2, IgnoreUnitCollision);
        Rampage.update()
                .active("武器を振り回し{2}の敵ユニットに{1}を与える。このスキルが敵ユニットに命中した場合、Hecarimは短時間の間1スタックを得て、1スタックにつきこのスキルの{4}する(最大2スタック)。スタックは6秒間増加がないと0になる。ミニオンやモンスターには{3}を与える。")
                .variable(1, PhysicalDamage, 50, 35, bounusAD(0.6))
                .variable(2, Radius, 200)
                .variable(3, PhysicalDamage, 18.5, 11.5, bounusAD(0.2))
                .variable(4, CDDecrease, 1)
                .mana(25)
                .cd(4)
                .update(P303)
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.6))
                .update(P309)
                .mana(24, 4);
        SpiritOfDread.update()
                .active("4秒間{1}の敵ユニットに毎秒{2}を与える。この効果を受けている敵ユニットがダメージを受けた場合、そのダメージの値に応じて{3}する。")
                .variable(1, Radius, 575)
                .variable(2, MagicDamage, 20, 11.25, ap(0.2))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 10, 5))
                .mana(50, 10)
                .cd(14)
                .update(P303)
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 20, 0))
                .cd(20, -1.5)
                .update(P305)
                .cd(22, -1);
        DevastatingCharge.update()
                .active("3秒間{1}して(最大75%)、その後1秒間その移動速度を維持する。また次の通常攻撃のダメージはこのスキルを使用してからHecarimが移動した距離に比例し最小で{3}、最大で{4}を与えるようになり、{2}が付与される。")
                .variable(1, MSRatio, 20, 0, amplify(Duration, 18.3))
                .variable(2, Knockback, 300)
                .variable(3, PhysicalDamage, 40, 35, bounusAD(0.5))
                .variable(4, PhysicalDamage, 80, 70, bounusAD(1))
                .mana(60)
                .cd(24, -2);
        OnslaughtOfShadows.update()
                .active("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに{1}を与える。指定した地点に到着すると衝撃波を放ち、{2}の敵ユニットに{3}と{4}を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。" + Terrified + "に陥ったユニットは強制的にHecarimから遠ざかるように移動する。この時、Hecarimとの距離に比例して移動速度が変化する。")
                .variable(1, MagicDamage, 100, 100, ap(0.8))
                .variable(2, Radius)
                .variable(3, MagicDamage, 50, 75, ap(0.4))
                .variable(4, Terrified, 1)
                .mana(100)
                .cd(140, -20)
                .range(1000)
                .update(P308)
                .active("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに{1}を与える。指定した地点に到着すると衝撃波を放ち、{2}の敵ユニットに{4}を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。" + Terrified + "に陥ったユニットは強制的にHecarimから遠ざかるように移動する。この時、Hecarimとの距離に比例して移動速度が変化する。")
                .variable(1, MagicDamage, 150, 100, ap(1));
    }

    private static void Heimerdinger() {
        TechmaturgicalRepairBots.update()
                .passive("{1}の味方ユニットとTurretは{2}を得る。")
                .variable(1, Radius, 800)
                .variable(2, Hreg, new Per5LevelForHeimer(10, 5));
        TechmaturgicalRepairBots.update(P313)
                .passive("{1}の味方ユニットとH-28G Evolution Turretは{2}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, Hreg, new Per4Level(10, 5));
        H28GEvolutionTurret.update()
                .active("指定地点にTurretを設置する。使用時にスタックを消費する。設置後6秒間はTurretの攻撃速度が1.5倍になる。{1}毎にスタックが1つ増加し最大2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。Turretが塔に与えるダメージは半分になる。Debuff(CCのみ)を無効化、Heimerdingerが攻撃するor攻撃されている場合、その対象を優先で攻撃。Lv2.攻撃したユニットに{6}と{7}を与える。この効果は2秒間持続し、50回までスタックする。Lv3.Turretの最大スタック数と設置できる上限が2に増える。Lv4.Turretの最大HP+125。Lv5.50%のスプラッシュダメージが付与される。　<br>HP:{2}<br>ダメージ:{3}<br>射程:525<br>AR:{4}<br>MR:{5}<br>AS:1.25<br>視界:625")
                .variable(1, CDRAwareTime, 25)
                .variable(2, Count, 295, 0, amplify(Lv, 15))
                .variable(3, MagicDamage, 30, 8, ap(0.2))
                .variable(4, Count, 30, 0, amplify(Lv, 1))
                .variable(5, Count, 80, 0, amplify(Lv, 1))
                .variable(6, ARReduction, 1)
                .variable(7, MRReduction, 1)
                .mana(70, 10)
                .cd(1)
                .range(250);
        H28GEvolutionTurret.update(P313)
                .active("スタックを消費して指定地点にTurretを最大3つまで設置する。スタックは{1}毎に増加し、最大{2}まで貯めることが出来る。スタック増加時間はCD低減の影響を受ける。塔に与えるダメージは半分。Heimerdingerが攻撃する若しくは攻撃されている場合、その対象を優先で攻撃。8秒間砲台と距離1000以上離れていた場合、砲台の動作が停止する。<br>HP:{3}<br>砲撃:{4}　{5}<br>ビーム:{6}　{7}　（12秒毎）<br>AR:10<br>MR:25<br>AS:1.75<br>視界:625")
                .variable(1, CDRAwareTime, 24, -1)
                .variable(2, Stack, new Fixed(new double[] {1, 1, 2, 2, 3}))
                .variable(3, Value, 150, 0, amplify(Lv, 25))
                .variable(4, Radius, 525)
                .variable(5, MagicDamage, 15, 7, ap(0.125))
                .variable(6, Radius, 1100)
                .variable(7, MagicDamage, 50, 25, ap(0.5))
                .mana(20)
                .cd(1)
                .range(450);
        HextechMicroRockets.update()
                .active("視界内にいる最も近い敵ユニット3体に{1}を与える。")
                .variable(1, MagicDamage, 85, 50, ap(0.55))
                .mana(65, 20)
                .cd(10)
                .range(1000);
        HextechMicroRockets.update(P313)
                .active("指定地点に目掛けて、5本のミサイルを扇状に発射する。ミサイルが指定地点を通過する後も一直線に飛行し続ける。命中すると{1}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に5発命中すると{2})。Minionに対しては60%のダメージを与える。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, MagicDamage, 108, 54, ap(0.81))
                .mana(70, 10)
                .cd(11)
                .range(1100);
        CH2ElectronStormGrenade.update()
                .active("指定地点に手榴弾を投げ、破裂した{1}にいる敵ユニットに{2}と2秒間{3}を与え、真ん中のユニットにはさらに{4}を与える。また指定地点の{5}。")
                .variable(1, Radius, 210)
                .variable(2, MagicDamage, 60, 40, ap(0.6))
                .variable(3, MSSlowRatio, 35)
                .variable(4, Stun, 1.25)
                .variable(5, Visionable)
                .mana(85)
                .cd(18, -2)
                .range(925);
        UPGRADE.update()
                .active("次に使用するスキルの効果を強化する。強化されたスキルは一切のコストなしで使用でき、効果はこのスキルのLvに依存する。発動してから3秒間に何も使わない場合は再発動可能になり、もう一度使用するとCD3秒でキャンセルする。<br>H-28Q Apex Turret<br>8秒間持続する。砲撃に100%のスプラッシュダメージと{1}が付与される。<br>HP:{3}<br>砲撃:{4}　{5}<br>ビーム:{6}　{7}　（6秒毎）<br><br>Hextech Rocket Swarm<br>指定地点に目掛けて、5本のミサイルを扇状に4回発射する。命中すると{8}を与える。同一対象に対して複数命中し、2発目以降は本来の20%分のDMを与える(同一対象に20発命中すると{9})。<br><br>CH-3X Lightning Grenade<br>2回までバウンドしつつ3回放電する手榴弾を投げる。作動した箇所にいる{10}にいる敵ユニットに{11}と2秒間{12}を与え、真ん中のユニットにはさらに{13}を与える。")
                .variable(1, MSSlowRatio, 25)
                .variable(3, Value, 600, 0, amplify(Lv, 50))
                .variable(4, Radius, 525)
                .variable(5, MagicDamage, 90, 20, ap(0.33))
                .variable(6, Radius, 1100)
                .variable(7, MagicDamage, 225, 75, ap(0.8))
                .variable(8, MagicDamage, 135, 45, ap(0.45))
                .variable(9, MagicDamage, 550, 140, ap(1.83))
                .variable(10, Radius, 420)
                .variable(11, MagicDamage, 150, 50, ap(0.6))
                .variable(12, MSSlowRatio, 80)
                .variable(13, Stack, 1.25)
                .mana(100)
                .cd(100, -20);
    }

    private static void Janna() {
        Tailwind.update().passive("全ての味方Championは{1}する。").variable(1, MSRatio, 3);
        Tailwind.update(P314).passive("{2}の全ての味方Championは{1}する。").variable(1, MSRatio, 5).variable(2, Radius, 800);
        HowlingGale.update()
                .active("指定方向に竜巻を発生させ、触れた敵ユニットに{1}と{2}を与える。竜巻は設置後に再度スキル使用ですぐに飛ばすことができるが、溜めた時間に比例して魔法DM、射程距離、打ち上げ時間が増加する。")
                .variable(1, MagicDamage, 60, 25, ap(0.75), amplify(Duration, new Fixed(new double[] {25, 30, 40, 50,
                        60})))
                .variable(2, Knockup, 0.8, 0, amplify(Duration, 0.1))
                .mana(90, 15)
                .cd(14, -1)
                .range(1100);
        HowlingGale.update(P304).variable(2, Knockup, 0.8, 0, amplify(Duration, 0.066));
        HowlingGale.update(P314).variable(1, MagicDamage, 60, 25, ap(0.35), amplify(Duration, 15, 5, ap(0.1)));
        Zephyr.update()
                .passive("{1}し{2}を得る。")
                .variable(1, MSRatio, 4, 3)
                .variable(2, IgnoreUnitCollision, 0)
                .active("対象の敵ユニットに{3}と3秒間{4}を与える。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .variable(3, MagicDamage, 60, 55, ap(0.6))
                .variable(4, MSSlowRatio, 24, 6)
                .mana(40, 10)
                .cd(12, -1)
                .range(600);
        Zephyr.update(P314)
                .active("対象の敵ユニットに{3}と3秒間{4}を与える（最大で80%）。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .variable(1, MSRatio, 4, 2, ap(0.02))
                .variable(3, MagicDamage, 60, 55, ap(0.5))
                .variable(4, MSSlowRatio, 24, 4, ap(0.06));
        EyeOfTheStorm.update()
                .active("対象の味方Championか塔に5秒間{1}を付与する。シールドが持続している間は対象は{2}を得る。")
                .variable(1, Shield, 80, 40, ap(0.9))
                .variable(2, AD, 14, 9)
                .mana(70, 10)
                .cd(10)
                .range(800);
        EyeOfTheStorm.update(P314).variable(1, Shield, 80, 40, ap(0.7)).variable(2, AD, 14, 9, ap(0.1));
        Monsoon.update()
                .active("0.25秒後に{1}の敵ユニットを{2}して4秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。最大で{4}する。")
                .variable(1, Radius, 725)
                .variable(2, Knockback, 875)
                .variable(3, RestoreHealth, 70, 40, ap(0.35))
                .variable(4, RestoreHealth, 280, 160, ap(1.4))
                .mana(150, 75)
                .cd(150, -15)
                .update(P303)
                .mana(100, 50)
                .update(P315)
                .mana(100)
                .update(P401)
                .active("{1}の敵ユニットを{2}して3秒間詠唱する。詠唱中は{1}の味方ユニットは毎秒{3}する。最大で{4}する。")
                .variable(3, RestoreHealth, 100, 50, ap(0.6))
                .variable(4, RestoreHealth, 300, 150, ap(1.8));
    }

    private static void Jarvan() {
        MartialCadence.update()
                .passive("通常攻撃に{1}(最大400DM)が付与される。同一の対象には6秒に一度しか発動しない。")
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealthRatio, new Per6Level(6, 2)));
        DragonStrike.update()
                .active("槍を突き出して直線上の敵ユニットに{1}を与え、3秒間{2}を与える。また、Demacian Standardの旗にヒットした場合、旗の位置まで突進し、進路上の敵ユニット({4})に{3}を与える。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1.1))
                .variable(2, ARReductionRatio, 10, 4)
                .variable(3, Knockup, 0.75)
                .variable(4, Radius, 260)
                .mana(45, 5)
                .cd(10, -1)
                .range(770);
        DragonStrike.update(P313).variable(4, Radius, 180);
        GoldenAegis.update()
                .active("5秒間{1}を付与すると同時に、{2}の敵ユニットに２秒間{3}を与える。")
                .variable(1, Shield, 50, 40, amplify(EnemyChampion, 20, 5))
                .variable(2, Radius, 600)
                .variable(3, MSSlowRatio, 15, 5)
                .mana(65)
                .cd(20, -2);
        GoldenAegis.update(P304).variable(1, Shield, 50, 40, amplify(EnemyChampion, 20, 10)).mana(45, 5);
        DemacianStandard.update()
                .passive("{1}し{2}を得る。")
                .variable(1, ASRatio, 10, 3)
                .variable(2, AR, 10, 3)
                .active("指定地点に旗を投げ、{3}の敵ユニットに{4}を与える。旗は8秒間その場に残り{6}の{7}とともに、{5}の味方ChampionにPassiveの効果を与える。(Jarvan IV自身はPassiveと合わせて倍の効果を受ける)")
                .variable(3, Radius, 150)
                .variable(4, MagicDamage, 60, 45, ap(0.8))
                .variable(5, Radius, 1200)
                .variable(6, Radius, 850)
                .variable(7, Visionable)
                .mana(55)
                .cd(13)
                .range(830);
        DemacianStandard.update(P307).variable(6, Radius, 700);
        DemacianStandard.update(P304)
                .active("指定地点に旗を投げ、{3}の敵ユニットに{4}を与える。旗は8秒間その場に残り視界を確保するとともに、{5}の味方Championは{1}する。(Jarvan IV自身はPassiveと合わせて倍の効果を受ける)");
        Cataclysm.update()
                .active("対象の敵Championまで跳躍して{1}を与え、3.5秒間その周囲に通行不可能の円形の地形を作る。再度このスキルを使用すると地形を破壊できる。")
                .variable(1, PhysicalDamage, 200, 125, bounusAD(1.5))
                .mana(100, 25)
                .cd(120, -15)
                .range(650);
    }

    private static void Jinx() {
        GetExcited.update(P312)
                .passive("攻撃した敵Championまたはタワーが3秒以内に死亡/破壊された場合、4秒間{1}する。移動速度は4秒かけて元に戻る。")
                .variable(-1, MSRatio, 175);
        Switcheroo.update(P312)
                .passive("通常攻撃毎に{1}する。この効果は2.5秒間持続し、3回までスタックし、最大で{5}。攻撃を行わないと、スタックは2.5秒毎に1つずつ減少していく。このスキルを使用するとスタックによる攻撃速度増加は無効になる。")
                .variable(-1, ASRatio, 16.6, 6.7)
                .variable(-5, ASRatio, 50, 20)
                .active("通常攻撃は{2}し{4}が付与され、対象の{3}にいる敵にも同様のダメージを与えるようになる。")
                .variable(2, Range, 50, 20)
                .variable(3, Radius, 150)
                .variable(4, PhysicalDamage, 0, 0, ad(0.1))
                .mana(20)
                .cd(1)
                .type(SkillType.ToggleForAttack);
        Switcheroo.update(P313).variable(-1, ASRatio, 10, 8.3).variable(-2, ASRatio, 30, 130);
        Zap.update(P312)
                .active("約0.6秒詠唱後、指定方向に電撃を放ち、当たった敵ユニットに{1}と2秒間{2}を与え、2秒間そのユニットの{3}。")
                .variable(1, PhysicalDamage, 30, 45, ad(1.4))
                .variable(2, MSSlowRatio, 30, 10)
                .variable(3, Visionable)
                .mana(45, 10)
                .cd(10, -1)
                .range(1450);
        Zap.update(P313).variable(1, PhysicalDamage, 10, 50, ad(1.4)).mana(50, 10);
        FlameChompers.update(P312)
                .active("指定地点に3つの罠を仕掛ける。敵Championが罠に触れると爆発し、{1}にいる敵ユニットに1.5秒かけて{2}を与え、更に罠に触れた敵Championに{3}を与える。罠は設置から{6}経過しないと反応せず、ひとつづつしか反応しない。一人のChampionが３つ全ての罠にかかった場合は{5}を与える。罠は5秒経過すると自動的に爆発する。また罠は{4}。")
                .variable(1, Radius, 50)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Snare, 1.5)
                .variable(4, Visionable)
                .variable(5, MagicDamage, 300, 150, ap(3))
                .variable(6, Time, 0.5, 0.06)
                .mana(50)
                .cd(24, -2)
                .range(950)
                .update(P401)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(5, MagicDamage, 240, 165, ap(3))
                .variable(6, Time, 0.7);
        SuperMegaDeathRocket.update(P312)
                .active("指定方向にロケットを放つ。ロケットが敵Championに命中すると爆発し、{1}の敵ユニットに{2}を与える。ロケットが発射から当たるまでの時間に比例してダメージが増加する(1秒で最大値になり{3}を与える、またミニオンに対しては300DMが上限)。ロケットの爆風に当たった敵ユニットには80%のダメージを与える。")
                .variable(1, Radius, 225)
                .variable(2, PhysicalDamage, 125, 50, bounusAD(0.5), amplify(TargetMissingHealthRatio, 25, 5))
                .variable(3, PhysicalDamage, 250, 100, bounusAD(1), amplify(TargetMissingHealthRatio, 25, 5))
                .mana(100)
                .cd(90, -15)
                .range(-1);
    }

    private static void Kassadin() {
        VoidStone.update()
                .passive("自身が受ける{1}して、4秒間軽減した分のダメージを攻撃速度(%)に加算する。")
                .variable(1, MagicDamageReductionRatio, 15);

        NullSphere.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Silence, 1, 0.4)
                .mana(70, 10)
                .cd(9)
                .range(650)
                .update(P313)
                .variable(1, MagicDamage, 80, 35, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 5)
                .update(P403)
                .variable(1, MagicDamage, 80, 30, ap(0.7))
                .variable(2, Silence, 1, 0.25);

        NetherBlade.update()
                .passive("通常攻撃ごとに{1}する。対象がChampionの場合は{2}する。")
                .variable(1, RestoreMana, 8, 3)
                .variable(2, RestoreMana, 16, 6)
                .active("5秒間、通常攻撃に追加{3}が付与される。建物には無効。")
                .variable(3, MagicDamage, 30, 15, ap(0.3))
                .mana(25)
                .cd(12);

        ForcePulse.update()
                .active("指定方向扇形80°の{1}の敵ユニットに{2}と3秒間{3}を与える。近くのChampion(敵味方自分問わず)がスキルを使用するとスタックが増え、6スタックまで溜まると使用可能。スキル使用時にスタックは0になる。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 80, 50, ap(0.7))
                .variable(3, MSSlowRatio, 30, 5)
                .mana(80)
                .cd(6)
                .update(P403)
                .variable(2, MagicDamage, 80, 40, ap(0.7));

        Riftwalk.update()
                .active("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに消費MNと魔法DMが増加していく。(最大10スタック)スタックは8秒間増加がないと0になる。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 60, 10, ap(0.8), amplify(Stack, 60, 10))
                .cost(Mana, new Diff(100, 0, 1), amplify(Stack, 100))
                .cd(7, -1)
                .range(700)
                .update(P313)
                .active("指定地点にテレポートし、テレポート先の{1}の敵ユニットに{2}を与える。スキル使用時にスタックが増加し、1スタックごとに消費マナと魔法DMが増加していく。(最大10スタック)スタックは8秒間増加がないと0になる。敵Championにダメージを与えると使用時のマナの半分が回復する。")
                .variable(2, MagicDamage, 80, 20, ap(0.8), amplify(Stack, 50, 5, ap(0.1)));
    }

    private static void KhaZix() {
        UnseenThreat.update()
                .passive("自身が敵チームの視界から消えた時に発動する。次の敵Championに対する通常攻撃かEvolved Void Spikeに追加{1}と2秒間{2}を付与する。この効果は敵チームの視界に現れても効果が消費されるまでは失われない。")
                .variable(1, MagicDamage, new Per1Level(new double[] {15, 20, 25, 35, 45, 55, 65, 75, 85, 95, 110, 125,
                        140, 150, 160, 170, 180, 190}), ap(0.5), null)
                .variable(2, MSSlowRatio, 25);

        TasteTheirFear.update()
                .passive("敵チームの中で孤立している敵ユニットにマークを付与する。")
                .active("対象の敵ユニットに{1}を与える。マークが付与されている敵ユニットのマークの範囲内に他の敵ユニットがいない場合、{2}を与える。進化すると孤立した敵ユニットに追加{3}を与え、このスキルの射程と通常攻撃の射程が50増加する。")
                .mana(25)
                .variable(1, PhysicalDamage, 70, 30, bounusAD(1.5))
                .variable(2, PhysicalDamage, 100, 45, bounusAD(2))
                .variable(3, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 12))
                .cd(3.5)
                .range(325)
                .update(P308)
                .active("対象の敵ユニットに{1}を与える。孤立している敵には{2}を与える。進化すると敵ユニットに追加{3}を与え（孤立している敵には{4}、ミニオンやモンスターには{5}が上限）、このスキルの射程と通常攻撃の射程が50増加する。")
                .variable(2, PhysicalDamage, 101.5, 43.5, bounusAD(2.18))
                .variable(3, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 8))
                .variable(4, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 11.6))
                .variable(5, PhysicalDamage, 200)
                .update(P403)
                .variable(3, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 6))
                .variable(4, PhysicalDamage, 0, 0, amplify(TargetMissingHealthRatio, 8.7))
                .variable(5, PhysicalDamage, 100);

        VoidSpike.update()
                .active("指定方向に敵ユニットに命中すると爆発する針を発射し、{1}の敵ユニットに{2}を与える。自身が爆発範囲内にいる場合は更に{3}する。進化すると指定方向に対して扇形になるような3方向に針を発射するようになり、また爆発にUnseen Threatの追加魔法DMとスローを付与する。")
                .mana(60, 10)
                .variable(1, Radius, 0)
                .variable(2, PhysicalDamage, 75, 40, bounusAD(0.9))
                .variable(3, RestoreHealth, 40, 30, ap(0.5))
                .cd(8)
                .range(1000)
                .update(P308)
                .active("指定方向に敵ユニットに命中すると爆発する針を発射し、{1}の敵ユニットに{2}と2秒間{4}を与える。自身が爆発範囲内にいる場合は更に{3}する。このスキルはLeap中に発動出来ない。進化すると指定方向に対して扇形になるような3方向に針を発射するようになる。")
                .variable(2, PhysicalDamage, 75, 40, bounusAD(1))
                .variable(4, MSSlowRatio, 20)
                .mana(55, 5)
                .update(P313)
                .variable(4, MSSlowRatio, 30);

        Leap.update()
                .active("指定地点にジャンプし、{1}の敵ユニットに{2}を与える。進化すると射程が400増加し、またkillやassistを取った場合にこのスキルの{3}する。")
                .variable(1, Radius, 0)
                .variable(2, PhysicalDamage, 65, 35, bounusAD(0.8))
                .variable(3, CDDecrease, 0)
                .mana(50)
                .cd(22, -2)
                .range(600)
                .update(P403)
                .variable(2, PhysicalDamage, 65, 35, bounusAD(0.2));

        VoidAssault.update()
                .passive("このスキルを取得、またはランクが上がる毎に、いずれかのスキルを選んで進化させることができる。")
                .active("使用後{2}状態になり、{1}する。この際にUnseen Threatの効果が発動する。また使用後10秒以内であれば、消費マナ無しでもう一度だけこのスキルを使用することができる。進化すると10秒以内に再度使用可能な回数が2回に増加し、またステルス状態の間{3}する。")
                .variable(1, MSRatio, 40)
                .variable(2, Stealth, 1)
                .variable(3, DamageReductionRatio, 40)
                .mana(100)
                .cd(3)
                .update(P308)
                .variable(3, DamageReductionRatio, 50)
                .update(P403)
                .active("{2}状態になり、{1}し{4}を得る。この際にUnseen Threatの効果が発動する。10秒以内であればスキルを再使用できる。進化すると、{5}状態になり、{1}し、{3}して{4}を得る。また再使用回数が2回に増加する。")
                .variable(4, IgnoreUnitCollision)
                .variable(5, Stealth, 2);
    }

    private static void Kayle() {
        HolyFervor.update()
                .passive("敵Championに通常攻撃を行う度に、{1}と{2}を与える。この効果は5秒間持続し、5回までスタックする。")
                .variable(1, ARReductionRatio, 3)
                .variable(2, MRReductionRatio, 3);
        Reckoning.update()
                .active("{4}の光の玉を撃ち対象の敵ユニットに{1}と4秒間{2}を与える。このスキルのスローがかかった敵ユニットに対しては、Kayleが対象のユニットに与える{3}する。")
                .variable(1, MagicDamage, 60, 50, ap(1), bounusAD(1))
                .variable(2, MSSlowRatio, 35)
                .variable(3, DamageRatio, 6, 1)
                .variable(4, MissileSpeed, 1300)
                .mana(70, 5)
                .cd(8)
                .range(650)
                .update(P303)
                .active("{4}の光の玉を撃ち対象の敵ユニットに{1}と3秒間{2}、HolyFervorのスタックをひとつ与える。")
                .variable(2, MSSlowRatio, 35, 5)
                .variable(4, MissileSpeed, 1500)
                .update(P402)
                .variable(1, MagicDamage, 60, 50, ap(0.6), bounusAD(1));;
        DivineBlessing.update()
                .active("対象の味方Championは{1}し、3秒間{2}する。")
                .variable(1, RestoreHealth, 60, 45, ap(0.35))
                .variable(2, MSRatio, 18, 3)
                .mana(60, 10)
                .cd(15)
                .range(1000)
                .update(P3051)
                .range(900)
                .update(P402)
                .variable(1, RestoreHealth, 60, 45, ap(0.45))
                .variable(2, MSRatio, 18, 3, ap(0.07));
        RighteousFury.update()
                .active("10秒間Kayleの通常攻撃の射程が525に伸びる(Ranged)。更に通常攻撃に追加{1}が付与され、スプラッシュ効果{2}が付く。塔を攻撃する時はスプラッシュ効果は発生しない。")
                .variable(1, MagicDamage, 20, 10, ap(0.4), amplify(AD, 0.2, 0.05))
                .variable(2, Radius, 300)
                .mana(45)
                .cd(16);
        Intervention.update()
                .active("対象の味方Championを{1}間無敵(ダメージ無効)にする。")
                .variable(1, Time, 2, 0.5)
                .mana(100, -25)
                .cd(90, -15)
                .range(1200)
                .update(P3051)
                .range(900)
                .update(P402)
                .mana(0);
    }

    private static void LeeSin() {
        Flurry.update()
                .passive("スキルを使用すると{1}し通常攻撃の度に{2}する。この効果は3秒経つか2回通常攻撃を行うと解消される。")
                .variable(-1, ASRatio, 40)
                .variable(2, RestoreEnergy, 15);
        SonicWaveResonatingStrike.update()
                .active("指定方向に気を飛ばし当たった敵ユニットに{1}を与える。このスキルが敵ユニットに当たった場合、3秒間対象の視界を得て、下記のスキルを使用できる。<br><br>{2}を消費して、Sonic Waveが当たった{3}の敵ユニットにダッシュし、{4}を与える。(追加ダメージはMinionに対して400DMが上限)")
                .variable(1, PhysicalDamage, 50, 30, bounusAD(0.9))
                .variable(2, Energy, 30)
                .variable(3, Radius, 1300)
                .variable(4, PhysicalDamage, 50, 0, bounusAD(0.5), amplify(Status.TargetMissingHealthRatio, 8))
                .cd(11, -1)
                .range(1100)
                .cost(Energy, 50, 0);
        SafeguardIronWill.update()
                .active("対象の味方ユニットまで移動する。自身及び対象（味方Championに限る）は５秒間{1}を得る。このスキル使用後3秒間、下記のスキルが使用できる。<br><br>{2}を消費して、5秒間{3}と{4}を得る。")
                .variable(1, Shield, 40, 40, ap(0.8))
                .variable(2, Energy, 30)
                .variable(3, LS, 5, 5)
                .variable(4, SV, 5, 5)
                .cd(9)
                .cost(Energy, 50, 0)
                .range(700);
        TempestCripple.update()
                .active("{1}の敵ユニットに{2}を与え、4秒間そのユニットの{3}。このスキルが敵ユニットに当たった場合、3秒間下記のスキルが使用できる。<br><br>{4}を消費して、Tempestが当たった{5}の敵ユニットに４秒間{6}を与える。これらの速度低下は時間と共に戻っていく。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 60, 35, bounusAD(1))
                .variable(3, Visionable)
                .variable(4, Energy, 30)
                .variable(5, Radius, 500)
                .variable(6, MSSlowRatio, 20, 10)
                .cd(10)
                .cost(Energy, 50, 0);
        DragonsRage.update()
                .active("対象の敵Championに{1}を与え、{2}させる。ノックバックした対象に触れた敵ユニットにも{1}を与え、{3}を与える。")
                .variable(1, PhysicalDamage, 200, 200, bounusAD(2))
                .variable(2, Knockback, 1200)
                .variable(3, Knockup, 0)
                .cd(90, -15)
                .range(375);
    }

    private static void Leona() {
        Sunlight.update()
                .passive("スキルでダメージを与えた敵ユニットに、3.5秒間持続するDebuffを付与する。この敵ユニットに対してLeona以外の味方Championがダメージを与えると、付与されたDebuffを消費して追加{1}を与える。")
                .variable(1, MagicDamage, new Per2Level(20, 15));
        ShieldOfDaybreak.update()
                .active("次の通常攻撃に追加{1}と{2}が付与される。")
                .variable(1, MagicDamage, 40, 30, ap(0.3))
                .variable(2, Stun, 1.25)
                .mana(45, 5)
                .cd(11, -1);
        Eclipse.update()
                .active("3秒間{1}と{2}を得て、効果終了時に{3}の敵ユニットに{4}を与える。魔法DMが敵ユニットに命中した場合、ARとMR増加の効果時間が3秒延長される。")
                .variable(1, AR, 30, 10)
                .variable(2, MR, 30, 10)
                .variable(3, Radius, 450)
                .variable(4, MagicDamage, 60, 50, ap(0.4))
                .mana(60)
                .cd(14);
        Eclipse.update(P314)
                .variable(1, AR, 25, 10, amplify(BounusAR, 0.2))
                .variable(2, MR, 25, 10, amplify(BounusMR, 0.2));
        ZenithBlade.update()
                .active("指定方向に貫通するエネルギーを飛ばし当たった敵ユニットに{1}を与える。このスキルが敵Championに命中した場合、その敵Championの元までLeonaが移動する。また移動中は対象の敵ChampionにSnareを与える。複数の敵Championに命中した場合は最後に命中した敵Championの元に移動する。")
                .variable(1, MagicDamage, 60, 40, ap(0.4))
                .mana(60)
                .cd(13, -1)
                .range(875);
        SolarFlare.update()
                .active("わずかな間をおいて、指定地点を中心として{1}の敵ユニットに{2}を、{5}の敵ユニットに1.5秒間{3}を、{6}の敵ユニットに{4}を与える。")
                .variable(1, Radius, 125)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(5, Radius, 350)
                .variable(3, MSSlowRatio, 80)
                .variable(6, Radius, 50)
                .variable(4, Stun, 1.5)
                .mana(100, 50)
                .cd(90, -15)
                .range(1200);
        SolarFlare.update(P313).mana(100);
    }

    private static void Lucian() {
        Lightslinger.update()
                .passive("スキル使用した後の通常攻撃が2回攻撃になる。この効果は通常攻撃を行うか、6秒経過すると解消される。2回目の攻撃は50%のダメージとなるが、対象がMinionの場合は100%のダメージを与える。またon-hitエフェクトは通常通り適用され、クリティカルも発生する。");
        PiercingLight.update()
                .active("対象の敵ユニットに向けて0.35秒後に光のボルトを放ち、対象とその直線状({1})にいるすべての敵ユニットに{2}を与える(ミニオンに対しては75%)。")
                .variable(1, Length, 1100)
                .variable(2, PhysicalDamage, 80, 40, amplify(BounusAD, 0.6, 0.15))
                .variable(3, PhysicalDamage)
                .mana(60, 5)
                .cd(9, -1)
                .range(570)
                .update(P315)
                .variable(2, PhysicalDamage, 80, 30, amplify(BounusAD, 0.6, 0.15))
                .range(550);
        ArdentBlaze.update()
                .active("指定方向に爆発する弾を放つ。敵ユニットに当たるか最大距離まで飛ぶと十字型に爆風が広がり、範囲内の敵ユニットに{1}と6秒間マークを与える。マークを受けている敵ユニットにダメージを与えると、2秒間{2}する。また爆風が発生した地点の{3}。")
                .variable(1, MagicDamage, 60, 40, ap(0.9), bounusAD(0.8))
                .variable(2, MS, 40)
                .variable(3, Visionable)
                .mana(60)
                .cd(18, -2)
                .range(425);
        RelentlessPursuit.update()
                .active("指定方向にダッシュし、自身にかかっているスローを解除する。" + TheCulling + "発動中に敵Championをキルかアシストした場合このスキルの{1}する。")
                .variable(1, CDDecrease)
                .mana(60, -15)
                .cd(18, -2)
                .range(425);
        TheCulling.update()
                .active("3秒間、指定方向に{1}発の弾を連射し一発毎に{2}を与える（最大で{3}）。銃を連射している間は移動と" + RelentlessPursuit + "のみが可能であり、ミニオンに対しては400%のダメージを与える。また連射中にこのスキルを再使用することで連射を解除できる。")
                .variable(1, Value, 7.5, 0, amplify(AS, 7.5, 1.5))
                .variable(2, PhysicalDamage, 40, 10, ap(0.1), bounusAD(0.25))
                .variable(3, PhysicalDamage, 1040, 460, amplify(AP, 2.6, 0.4), amplify(BounusAD, 6.5, 1.0))
                .mana(100)
                .cd(100, -25)
                .range(1400);
    }

    private static void Lulu() {
        PixFaerieCompanion.update()
                .passive("Pixという妖精がお供になる。Pixが付いている味方Championが通常攻撃を行った場合、Pixは同一の敵ユニットの方向に3発の弾を放ち1発毎に{1}を与える。この弾は敵ユニットを追尾するが、弾の進行方向上にいる敵ユニットにも当たる。建物を攻撃した場合はPixは弾を撃たない。")
                .variable(1, MagicDamage, 1, 0, amplify(Lv, 2))
                .update(P314)
                .variable(1, MagicDamage, new Per2Level(3, 3), ap(0.05), null)
                .update(P315)
                .variable(1, MagicDamage, new Per2Level(3, 4), ap(0.05), null);
        Glitterlance.update()
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間{3}を与える。この効果は時間と共に元に戻る。またPixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .variable(1, MagicDamage, 80, 45, ap(0.5))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 80)
                .mana(40, 10)
                .cd(7)
                .range(925);
        Glitterlance.update(P306).mana(60, 5);
        Glitterlance.update(P314)
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに{1}と{2}間{3}を与える。この効果は時間と共に{4}まで減少する。またPixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .variable(4, Percentage, 0, 0, ap(0.133));
        Whimsy.update()
                .active("対象の味方Championに使用した場合、5秒間対象の味方Championは{1}し{2}を得る。敵Championに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、{4}する。")
                .variable(1, MSRatio, 35)
                .variable(2, AP, 20, 10)
                .variable(3, Time, 1.5, 0.25)
                .variable(4, MSReduction, 60)
                .mana(65, 5)
                .cd(18, -1.5)
                .range(650);
        Whimsy.update(P314)
                .active("対象の味方Championに使用した場合、5秒間対象の味方Championは{1}を得る。敵Championに使用した場合、{3}間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、{4}する。")
                .variable(1, MSRatio, 30, 0, ap(0.1));
        HelpPix.update()
                .active("対象の味方ユニットに使用した場合、6秒間対象の味方ユニットにPixを付けると同時に{1}を付与する。敵ユニットに使用した場合、Pixが敵ユニットに付くと同時に{2}を与え、6秒間その敵ユニットの{3}。")
                .variable(1, Shield, 60, 45, ap(0.6))
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Visionable)
                .mana(60, 10)
                .cd(10)
                .range(650)
                .update(P314)
                .variable(2, MagicDamage, 80, 50, ap(0.4))
                .update(P315)
                .variable(1, Shield, 80, 40, ap(0.6));
        WildGrowth.update()
                .active("対象の味方Championを7秒間巨大化させ、同時に対象の{3}の敵ユニットに{1}を与える。巨大化した味方Championは{2}を得て、{3}の敵ユニットに継続的に{4}を与える。スローの効果は範囲内から出ても1秒間持続する。")
                .variable(1, Knockup, 1.5)
                .variable(2, Health, 300, 150, ap(0.5))
                .variable(3, Radius, 0)
                .variable(4, MSSlowRatio, 30, 15)
                .mana(150)
                .cd(110, -15)
                .range(900)
                .update(P315)
                .mana(100);
    }

    private static void MasterYi() {
        DoubleStrike.update().passive("通常攻撃7回毎に2回分ダメージを与える。対象が建物の場合も有効。");
        DoubleStrike.update(P310).passive("連続した通常攻撃4回毎に2回攻撃をする。この追加攻撃は50%のダメージを与える。");
        AlphaStrike.update()
                .active("対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え、対象の近くにワープする。minionの場合は50%の確率で追加{3}を与える。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, MagicDamage, 260, 60)
                .mana(60, 10)
                .cd(18, -2)
                .range(600);
        AlphaStrike.update(P310)
                .active("対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え(クリティカル発生時は{5})、対象の近くにワープする。ミニオンには追加{3}を与える。通常攻撃をする毎に{4}する。")
                .variable(2, PhysicalDamage, 25, 35, ad(1))
                .variable(3, PhysicalDamage, 75, 25)
                .variable(4, CDDecrease, 1)
                .variable(5, PhysicalDamage, 25, 35, ad(1.6))
                .mana(70, 10)
                .cd(18, -1);
        AlphaStrike.update(P313)
                .active("ターゲット不可状態になり対象の敵ユニットと近くの敵ユニット3体({1})をランダムに対象とし{2}を与え(クリティカル発生時は{5})、対象の近くにワープする。ミニオンには追加{3}を与える。通常攻撃をする毎に{4}する。");
        Meditate.update()
                .active("5秒間詠唱を行い、毎秒{1}し、詠唱中は{2}と{3}を得る。")
                .variable(1, RestoreHealth, 40, 30, ap(0.4))
                .variable(2, AR, 100, 50)
                .variable(3, MR, 100, 50)
                .mana(50, 15)
                .cd(35)
                .type(SkillType.Channel);
        Meditate.update(P310)
                .active("4秒間詠唱を行い、{1}を得る（タワーに対しては{2}）。また、毎秒{3}する。この効果は失われているHealth1%に毎に1%増加する。")
                .variable(1, DamageReductionRatio, 40, 5)
                .variable(2, DamageReduction, 20, 2.5)
                .variable(3, RestoreHealth, 30, 20, ap(0.3));
        Meditate.update(P310A).variable(1, DamageReductionRatio, 50, 5);
        Meditate.update(P313).mana(50);
        WujuStyle.update()
                .passive("{1}を得る。")
                .variable(1, AD, 15, 5)
                .active("10秒間{2}を得る。CDが解消されるまでPassiveの増加ダメージがなくなる。")
                .variable(2, AD, 30, 10)
                .mana(40)
                .cd(25, -2);
        WujuStyle.update(P310)
                .passive("{1}を得る。CD中この効果は失われる。")
                .variable(1, AD, 0, 0, amplify(AD, 0.07, 0.02))
                .active("5秒間通常攻撃に{2}が追加される。")
                .variable(2, TrueDamage, 10, 5, amplify(AD, 0.1, 0.025))
                .mana(0)
                .cd(18, -1);
        WujuStyle.update(P310A).variable(1, AD, 0, 0, amplify(AD, 0.1));
        Highlander.update()
                .active("{4}間{1}、{2}し、{3}を得る。効果中に敵Championを倒すとすべてのスキルの{5}する。")
                .variable(1, MSRatio, 40)
                .variable(2, ASRatio, 40)
                .variable(3, IgnoreSlow)
                .variable(4, Time, 8, 2)
                .variable(5, CDDecrease)
                .mana(100)
                .cd(75);
        Highlander.update(P310)
                .passive("Championを倒すと" + Highlander + "以外のスキルは{5}する。（アシストの場合は{6}）")
                .variable(5, CDDecrease, 18)
                .variable(6, CDDecrease, 9)
                .active("{4}間{1}、{2}し、{3}を得る。効果中にChampionを倒すと効果時間が{7}延長する。")
                .variable(1, MSRatio, 25, 10)
                .variable(2, ASRatio, 30, 25)
                .variable(4, Time, 10)
                .variable(7, Time, 4);
        Highlander.update(P310A)
                .passive("Championを倒すと（アシストを含む）" + Highlander + "以外のスキルは{5}する。")
                .variable(5, CDDecreaseRatio, 70);
    }

    private static void Morgana() {
        SoulSiphon.update().passive("{1}を得る。").variable(1, SV, new Per6Level(10, 5));
        DarkBinding.update()
                .active("指定方向に魔法弾を飛ばし、当たった敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 55, ap(0.9))
                .variable(2, Snare, 2, 0.25)
                .mana(60, 15)
                .cd(11)
                .range(1300);
        DarkBinding.update(P3051).mana(50, 10);
        TormentedSoil.update()
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに毎秒{1}と{2}を与える。MR低下は2秒間持続し、5回までスタックする。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MRReduction, 4, 1)
                .variable(3, Radius, 350)
                .mana(70, 15)
                .cd(10)
                .range(900);
        TormentedSoil.update(P313)
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに0.5秒毎に{1}を与える（最大で{2}）。対象が失っているHP1%につき、このスキルのダメージが0.5%上昇する(最大で1.5倍)。")
                .variable(1, MagicDamage, 12, 7, ap(0.11))
                .variable(2, MagicDamage, 120, 70, ap(1.1));
        BlackShield.update()
                .active("対象の味方Championは5秒間{1}と{2}を得る。")
                .variable(1, MagicShield, 95, 65, ap(0.7))
                .variable(2, IgnoreCC)
                .mana(50)
                .cd(23, -2)
                .range(750);
        SoulShackles.update()
                .active("周囲の敵Championに{1}と３秒間{2}を与え対象と糸で繋がれる。3秒間対象が糸の範囲内({3})に留まっていた場合、対象に{1}と{4}を与える。")
                .variable(1, MagicDamage, 175, 75, ap(0.7))
                .variable(2, MSSlowRatio, 20)
                .variable(3, Radius, 1000)
                .variable(4, Stun, 1.5)
                .mana(100, 50)
                .cd(120, -10)
                .range(600);
        SoulShackles.update(P3051).mana(100);
    }

    private static void Nami() {
        SurgingTides.update().passive("スキルが味方Championに命中した際に、対象は1.5秒間{1}する。").variable(-1, MS, new Per6Level(30, 5));
        SurgingTides.update(P307).variable(-1, MS, 40);
        SurgingTides.update(P314).variable(-1, MS, 40, 0, ap(0.1));
        AquaPrison.update()
                .active("指定地点に泡を投げ、範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 55, ap(0.65))
                .variable(2, Stun, 1.25)
                .mana(60)
                .cd(14, -1)
                .range(875);
        AquaPrison.update(P307).variable(2, Stun, 1.5);
        AquaPrison.update(P314).variable(1, MagicDamage, 75, 55, ap(0.5));
        EbbandFlow.update()
                .active("対象の味方Championまたは敵Championに、Championにのみ3回まで跳ね返る({3})水流を発射する。水流が味方Championに命中した場合は{1}し、敵Championに命中した場合は{2}を与える。水流は同一のChampionには一度しか跳ね返らず、味方Championに命中した場合は一番近くの敵Championに、敵Championに命中した場合は一番近くの味方Championに跳ね返る。")
                .variable(1, RestoreHealth, 65, 30, ap(0.3))
                .variable(2, MagicDamage, 70, 40, ap(0.5))
                .variable(3, Radius, 875)
                .mana(70, 15)
                .cd(9)
                .range(725);
        EbbandFlow.update(P314)
                .active("対象の味方Championまたは敵Championに、Championにのみ3回まで跳ね返る({3})水流を発射する。水流が味方Championに命中した場合は{1}し、敵Championに命中した場合は{2}を与える。水流は同一のChampionには一度しか跳ね返らず、味方Championに命中した場合は一番近くの敵Championに、敵Championに命中した場合は一番近くの味方Championに跳ね返る。跳ね返るたびに効果は{4}増減する。")
                .variable(4, Percentage, -15, 0, ap(0.15));
        TidecallersBlessing.update()
                .active("対象の味方Championの通常攻撃に{1}と1秒間の{2}を付与する。この効果は5秒経つか3回通常攻撃を行うと解消される。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MSSlowRatio, 15, 5)
                .mana(55, 5)
                .cd(11)
                .range(800);
        TidecallersBlessing.update(P304).active("対象の味方Championの通常攻撃に{1}と1秒間の{2}を付与する。この効果は6秒経つか3回通常攻撃を行うと解消される。");
        TidecallersBlessing.update(P314).variable(2, MSSlowRatio, 15, 5, ap(0.05));
        TidalWave.update()
                .active("指定方向に津波を発生させ、命中した敵ユニットに{1}と{2}を与えた後2～4秒間{3}与える。スローの効果時間は当たるまでの津波の移動距離に比例して効果時間が長くなる。")
                .variable(1, Knockup, 1)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MSSlowRatio, 50, 10)
                .mana(100, 50)
                .cd(140, -20)
                .range(2500);
        TidalWave.update(P3051).range(2750).cd(120, -10).mana(100);
        TidalWave.update(P314).variable(2, MagicDamage, 150, 100, ap(0.6));
    }

    private static void Nasus() {
        SoulEater.update().passive("{1}を得る。").variable(1, LS, new Per6Level(14, 3));
        SoulEater.update(P314).variable(1, LS, new Per6Level(10, 5));
        SiphoningStrike.update()
                .active("次に行う通常攻撃に{1}を付与する。このスキルを使用しLHをとると増加ダメージが+3されていく。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+6)になる。")
                .variable(1, PhysicalDamage, 30, 20, amplify(Stack, 3))
                .mana(20, 5)
                .cd(8, -1);
        Wither.update()
                .active("対象の敵Championに5秒間{1}と{2}を与える。")
                .variable(1, ASSlowRatio, 35, 0, amplify(Duration, 3, 3))
                .variable(2, MSSlowRatio, 35, 0, amplify(Duration, 3, 3))
                .mana(80)
                .cd(15, -1)
                .range(700)
                .update(P401)
                .range(600);
        Wither.update(P306).variable(1, ASSlowRatio, 17.5, 0, amplify(Duration, 1.5, 1.5));
        SpiritFire.update()
                .active("指定地点に魔法陣を呼び出し{1}の敵ユニットに{2}を与える。魔方陣は5秒間持続し、上にいる敵ユニットに{3}と毎秒{4}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 55, 40, ap(0.6))
                .variable(3, Status.ARReduction, 20, 5)
                .variable(4, MagicDamage, 11, 8, ap(0.12))
                .mana(70, 15)
                .cd(12)
                .range(650);
        FuryOfTheSands.update()
                .active("15秒間自身の周りに砂嵐を発生させ{1}増加し、周囲の敵ユニットに毎秒{2}を与える。また効果中は通常攻撃の{3}し、スキルの{4}し、このスキルで与えたダメージの5%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。")
                .variable(1, Health, 300, 150)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 3, 1, ap(0.01)))
                .variable(3, Range, 50)
                .variable(-4, Range, 100)
                .mana(150)
                .cd(120)
                .update(P401)
                .active("15秒間自身の周りに砂嵐を発生させ{1}増加し、周囲の敵ユニットに毎秒{2}を与える。また効果中は通常攻撃の{3}し、このスキルで与えたダメージの5%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。");
    }

    private static void Nautilus() {
        StaggeringBlow.update()
                .passive("通常攻撃に{1}と{2}が付与される。同一の対象には12秒に一度しか発動しない。")
                .variable(1, PhysicalDamage, 2, 0, amplify(Lv, 6))
                .variable(2, Snare, new Per6Level(0.5, 0.25));
        StaggeringBlow.update(P314).variable(2, Snare, new Per5LevelWith18(0.5, 0.25));
        DredgeLine.update()
                .active("指定方向に錨を投げ、最初に命中した敵ユニットに{1}を与えNautilusの方向に引き寄せる。またNautilus自身も敵ユニットの方向に移動する。錨が壁に命中した場合、壁の方向にNautilusが移動しこのスキルのCDが半分になる。")
                .variable(1, MagicDamage, 60, 45, ap(0.75))
                .mana(60, 10)
                .cd(18, -2)
                .range(950);
        TitansWrath.update()
                .active("10秒間{1}を得る。シールドが持続している間は通常攻撃時に対象とその周囲({2})にいる敵ユニットに{3}を与える。この魔法DMは2秒間かけて与えられる。")
                .variable(1, Shield, 100, 50, amplify(BounusHealth, 0.1))
                .variable(2, Radius, 350)
                .variable(3, MagicDamage, 30, 25, ap(0.4))
                .mana(80)
                .cd(26, -2);
        TitansWrath.update(P3051).cd(22, -1);
        TitansWrath.update(P308).variable(3, MagicDamage, 40, 15, ap(0.4));
        Riptide.update()
                .active("周囲を爆発させ命中した敵ユニットに{1}と２秒間{2}を与える。スローの効果は2秒かけて元に戻る。爆発はNautilusを中心に3回まで発生し、同一対象に対して複数hitする。2発目以降は本来の50%分の魔法DMを与える(3発hitで{3})。")
                .variable(1, MagicDamage, 60, 40, ap(0.5))
                .variable(2, MSSlowRatio, 30, 5)
                .variable(3, MagicDamage, 120, 80, ap(1))
                .mana(60, 10)
                .cd(10)
                .range(400);
        DepthCharge.update()
                .active("対象の敵Championに衝撃波を放ち、移動中の衝撃波に当たった敵ユニットに{1}と{2}を与える。衝撃波が対象の敵Championに当たると爆発し、対象とその周囲にいる敵ユニットに{3}と{2}を与える。対象の敵Championには{2}と同時に{4}を与える。")
                .variable(1, MagicDamage, 125, 50, ap(0.4))
                .variable(2, Knockup, 1)
                .variable(3, MagicDamage, 200, 125, ap(0.8))
                .variable(4, Stun, 1, 0.5)
                .mana(100)
                .cd(140, -30)
                .range(850);
    }

    private static void Nidalee() {
        Prowl.update().passive("茂みに入ると{1}する。この効果は茂みから出ても2秒間持続する。").variable(-1, MSRatio, 15);
        JavelinTossTakedown.update()
                .active("指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍が命中した時のNidaleeとターゲットの間の距離に比例して与えるダメージが増加する。最大で{2}。")
                .variable(1, MagicDamage, 55, 40, ap(0.65))
                .variable(2, MagicDamage, 137.5, 100, ap(1.625))
                .mana(50, 10)
                .cd(5)
                .range(1500);
        JavelinTossTakedown.update(P314).active("指定方向に槍を投げて当たった敵ユニットに{1}を与える。槍が投げた距離に比例して与えるダメージが増加する。最大で{2}。");
        Takedown.update()
                .active("次に行う通常攻撃のダメージが{1}増加する。対象が受けているダメージに比例してダメージが増加する。最大で{2}。")
                .variable(1, PhysicalDamage, 40, 30)
                .variable(2, PhysicalDamage, 120, 90, ad(2))
                .cd(5);
        BushwhackPounce.update()
                .active("指定地点に罠を仕掛ける。敵ユニットが罠を踏むと発動し、対象の敵ユニットとその周囲の敵ユニットに2秒かけて{1}を与え、{5}間{2}と{3}を与え{4}。罠は4分間持続する。罠を設置してから2秒間の間は罠は発動しない。")
                .variable(1, MagicDamage, 80, 45, ap(0.4))
                .variable(2, ARReductionRatio, 20, 5)
                .variable(3, MRReductionRatio, 20, 5)
                .variable(4, Visionable)
                .variable(5, Time, 12)
                .mana(60, 15)
                .cd(18)
                .range(900);
        BushwhackPounce.update(P314).variable(5, Time, 8);
        Pounce.update()
                .active("前方に飛びかかり着地地点の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 125, 50, ap(0.4))
                .cd(3.5)
                .range(350);
        PrimalSurgeSwipe.update()
                .active("対象の味方Championの{1}し、7秒間{2}する。")
                .variable(1, RestoreHealth, 50, 35, ap(0.7))
                .variable(2, ASRatio, 20, 10)
                .mana(60, 20)
                .cd(10)
                .range(600);
        Swipe.update()
                .active("前方扇形180°{2}の敵ユニットに{1}を与える。")
                .variable(1, MagicDamage, 150, 75, ap(0.4))
                .variable(2, Radius, 300)
                .cd(6);
        Swipe.update().variable(1, MagicDamage, 150, 75, ap(0.6));
        AspectOfTheCougar.update()
                .active("HumanからCougarに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、{1}、{2}、{3}を得る。Cougarスキルはこのスキルのレベルに比例し威力が増加する。")
                .variable(1, MS, 20)
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .cd(4);
        AspectOfTheCougar.update(P303)
                .active("HumanからCougarに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、{1}を得る。Cougarスキルはこのスキルのレベルに比例し威力が増加する。");
        AspectOfTheCougar.update(P309)
                .active("HumanからCougarに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、{1}を得る。Cougarスキルはこのスキルのレベルに比例し威力が増加する。{2}。")
                .variable(2, NotSpellCast);
        AspectOfTheCougarInCougar.update()
                .active("CougarからHumanに変身する。Human時はスキルの効果が変わり、通常攻撃の射程距離が525(Ranged)になる。")
                .cd(4);
        AspectOfTheCougarInCougar.update(P309)
                .active("CougarからHumanに変身する。Human時はスキルの効果が変わり、通常攻撃の射程距離が525(Ranged)になる。{1}。")
                .variable(1, NotSpellCast);
    }

    private static void Nunu() {
        Visionary.update().passive("通常攻撃を行うたびにスタックが増加する(最大5スタック)。5スタックの状態でスキルを使用すると、スタックを消費して対象のスキルの消費マナが0になる。");
        Consume.update()
                .active("対象の敵MinionかPet及びモンスター1体に{1}を与え、{2}する。")
                .variable(1, TrueDamage, 500, 100)
                .variable(2, RestoreHealth, 125, 55, ap(1))
                .mana(60)
                .cd(16, -2)
                .range(125);
        Consume.update(P307)
                .active("対象の敵MinionかPet及びモンスター1体に{1}を与え、{2}する。特定のモンスターを対象とした場合{3}間、以下の追加効果を得る。<br>ゴーレム : {4}を得て{5}する。<br>リザード : 通常攻撃かスキルでダメージを与えると、{6}を与える。<br>レイス/ウルフ : 敵ユニットを倒すと3秒間{7}する。")
                .variable(1, TrueDamage, 600, 100)
                .variable(2, RestoreHealth, 90, 40, ap(0.75))
                .variable(3, Time, 120, 30)
                .variable(4, Health, 0, 0, amplify(Health, 0.1))
                .variable(5, Grow)
                .variable(6, MagicDamage, 0, 0, amplify(Health, 0.01))
                .variable(7, MSRatio, 15);
        Consume.update(P309).variable(1, TrueDamage, 500, 125);
        Consume.update(P314).variable(1, TrueDamage, 400, 150).variable(2, RestoreHealth, 70, 45, ap(0.75)).cd(13, -1);
        BloodBoil.update()
                .active("12秒間対象の味方ユニットは{1}し{2}する。自分以外に使用した場合は自身にも同様の効果が発生する。")
                .variable(1, ASRatio, 25, 5)
                .variable(2, MSRatio, 8, 1)
                .mana(50)
                .cd(15)
                .range(700);
        IceBlast.update()
                .active("対象の敵ユニットに{1}と3秒間{2}、{3}を与える。")
                .variable(1, MagicDamage, 85, 45, ap(1))
                .variable(2, ASSlowRatio, 25)
                .variable(3, MSSlowRatio, 20, 10)
                .mana(75, 10)
                .cd(6)
                .range(550);
        AbsoluteZero.update()
                .active("最大3秒詠唱を行い、詠唱完了またはキャンセル時に{1}の敵ユニットに{2}を与える。ダメージは詠唱した時間に比例して最大で{3}。また詠唱中は範囲内の敵ユニットに{4}と{5}を与える。")
                .variable(1, Radius, 550)
                .variable(2, MagicDamage, 78, 31, ap(0.3))
                .variable(3, MagicDamage, 625, 250, ap(2.5))
                .variable(4, ASSlowRatio, 25)
                .variable(5, MSSlowRatio, 50)
                .mana(150)
                .cd(150, -30);
        AbsoluteZero.update(P3051).cd(110, -10).mana(100);
    }

    private static void Olaf() {
        BerserkerRage.update().passive("{1}する。").variable(1, ASRatio, 0, 0, amplify(MissingHealthPercentage, 1));
        Undertow.update()
                .active("指定地点に貫通する斧を投げ、当たった敵ユニットに{1}と{4}間{2}を与える。このスローは2.5秒かけて元に戻る。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルの{3}する。")
                .variable(1, PhysicalDamage, 80, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 24, 4)
                .variable(3, CDDecrease, 4.5)
                .variable(4, Time, 2.5)
                .mana(55, 5)
                .cd(8)
                .range(1000)
                .update(P312)
                .active("指定地点に貫通する斧を投げ(最短飛距離400)、当たった敵ユニットに{1}と{4}間{2}を与える。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルの{3}する。")
                .variable(1, PhysicalDamage, 70, 45, bounusAD(1))
                .variable(2, MSSlowRatio, 35, 5)
                .variable(4, Time, 1, 0, amplify(Distance, 1))
                .update(P313)
                .variable(4, Time, 1.5, 0, amplify(Distance, 1))
                .mana(60)
                .update(P401)
                .variable(2, MSSlowRatio, 29, 4);
        ViciousStrikes.update()
                .active("6秒間{1}と{2}と{3}を得る。")
                .variable(1, AD, 7, 7, amplify(Health, 0.01))
                .variable(2, LS, 9, 3)
                .variable(3, SV, 9, 3)
                .mana(40, 5)
                .cd(16)
                .update(P312)
                .active("6秒間{4}し、{2}を得る。また{5}する。")
                .variable(4, ASRatio, 20, 15)
                .variable(5, RestoreHealthRatio, 0, 0, amplify(MissingHealthPercentage, 0.4))
                .mana(30)
                .update(P313)
                .variable(4, ASRatio, 40, 10);
        RecklessSwing.update()
                .active("対象の敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 100, 60)
                .cost(Health, 40, 24)
                .cd(9, -1)
                .range(325)
                .update(P312)
                .active("対象の敵ユニットに{1}を与える。このスキルで対象を倒した場合、使用コストとして消費したHealthは返還される。通常攻撃をする度にこのスキルの{2}する。")
                .variable(1, TrueDamage, 70, 45, ad(0.4))
                .variable(2, CDDecrease, 1)
                .cd(12, -1)
                .cost(Health, new Diff(28, 18, 5), ad(0.16))
                .update(P313)
                .cost(Health, new Diff(21, 13.5, 5), ad(0.12));
        Ragnarok.update()
                .active("6秒間{1}、{2}、{3}と{4}を得る。既にCCを受けていた場合はそれらを解除する。StunなどのDisable中でも使用可能。")
                .variable(1, ARPen, 10, 10)
                .variable(2, AR, 30, 15)
                .variable(3, MR, 30, 15)
                .variable(4, IgnoreCC)
                .mana(100, -25)
                .cd(100)
                .update(P312)
                .passive("{2}と{3}を得る。")
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .active("6秒間パッシブの効果が消失して、{1}と{4}を得る。既にCCを受けていた場合はそれらを解除する。StunなどのDisable中でも使用可能。")
                .variable(1, AD, 40, 20)
                .cd(120, -20)
                .mana(0);
    }

    private static void Pantheon() {
        AegisProtection.update()
                .passive("通常攻撃を行うかスキルを使用するたびにスタックが1増加(最大4スタック)し、4スタック時に40DM以上の通常攻撃を受けるとスタックを消費して通常攻撃のダメージを無効化する。");
        SpearShot.update()
                .active("対象の敵ユニットに槍を投げ{1}を与える。")
                .variable(1, PhysicalDamage, 65, 40, bounusAD(1.4))
                .mana(45)
                .cd(4)
                .range(600);
        AegisOfZeonia.update()
                .active("対象の敵Championに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。")
                .variable(1, MagicDamage, 50, 25, ap(1))
                .variable(2, Stun, 1)
                .mana(55)
                .cd(13, -1)
                .range(600)
                .update(P315)
                .active("対象の敵ユニットに飛びかかり{1}と{2}を与え、Aegis Protectionを発動する。");
        HeartseekerStrike.update()
                .passive("敵ユニットのHPが15%以下の時は通常攻撃が必ずクリティカルになり、またSpear Shotのダメージが1.5倍になる。")
                .active("指定方向に0.75秒間槍を突き出し、範囲内の敵ユニットに{1}を最大3回与える(0.25秒毎に1ヒット)。対象がChampionの場合、与えるダメージが{2}になる。")
                .variable(1, PhysicalDamage, 13, 10, bounusAD(0.6))
                .variable(2, PhysicalDamage, 26, 20, bounusAD(1.2))
                .mana(45, 5)
                .cd(10, -1)
                .range(400)
                .type(SkillType.Channel);
        GrandSkyfall.update()
                .active("地点を指定して2秒後にジャンプし、その1.5秒後に指定地点の{1}に{2}と1秒間{3}を与えつつ落下する。DMは指定地点から離れるほど低減され、範囲最端では50%となる。ジャンプ前にキャンセルすると、消費した分のマナが回復し、このスキルのCDは10秒になる。")
                .variable(1, Radius, 1000)
                .variable(2, MagicDamage, 400, 300, ap(1))
                .variable(3, MSSlowRatio, 35)
                .mana(125)
                .cd(150, -15)
                .range(5500);
    }

    private static void Rammus() {
        SpikedShell.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(AR, 0.45));
        Powerball.update()
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。スキルを再使用するか" + DefensiveBallCurl + "を使用するとキャンセルされる。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Knockup, 0.75)
                .variable(4, MSSlowRatio, 20, 5)
                .variable(5, MSRatio, 85)
                .mana(70, 10)
                .cd(10)
                .update(P315)
                .active("7秒間徐々に移動速度が増加し、最大で{5}する。最初に当たった敵ユニットと自身の周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。" + DefensiveBallCurl + "を使用するとキャンセルされる。");
        DefensiveBallCurl.update()
                .active("6秒間{1}と{2}を得て、Rammusを通常攻撃した敵ユニットに{3}を与える。効果中にPowerballを使用すると効果がキャンセルされる。また、このスキルを再使用することで効果をキャンセルできる。")
                .variable(1, AR, 40, 20)
                .variable(2, MR, 40, 20)
                .variable(3, MagicDamage, 15, 10, amplify(AR, 0.1))
                .mana(40)
                .cd(14);
        PuncturingTaunt.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, Taunt, 1, 0.5)
                .variable(2, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(12)
                .range(325)
                .update(P315)
                .variable(1, Taunt, 1.25, 0.25)
                .mana(50);
        Tremors.update()
                .active("8秒間地震を発生させ{1}の敵ユニット及び建物に毎秒{2}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 65, 65, ap(0.3))
                .mana(120)
                .cd(60)
                .update(P315)
                .mana(100);
    }

    private static void Rengar() {
        UnseenPredator.update()
                .passive("ステルス状態または茂みの中から相手を攻撃する際には、通常攻撃は{1}になり相手に飛びつくようになる。この効果はステルス状態が解除された、また茂みから出た後0.5秒の間でも発生し、またステルス状態や茂みの中の視界が取られていた場合でも発生する。また、Rengarがスキルで敵ユニットにダメージを与える度に1 Ferocityを得て、5 Ferocity貯まると全てを消費して強化されたスキルを使用することが出来る。")
                .variable(1, Range, 600);
        Savagery.update()
                .active("{5}間次の通常攻撃に追加{1}を付与し、次の通常攻撃から4秒間{2}する。強化されると{5}間次の通常攻撃に追加{3}を付与し、次の通常攻撃から4秒間{4}する。")
                .variable(1, PhysicalDamage, 30, 30)
                .variable(2, ASRatio, 30, 5)
                .variable(3, PhysicalDamage, 30, 30, ad(1))
                .variable(-4, ASRatio, 90, 15)
                .variable(5, Time, 6)
                .cd(8, -0.5)
                .update(P401)
                .variable(5, Time, 2);
        BattleRoar.update()
                .active("{1}の敵ユニットに{2}を与える。また、このスキルが敵ユニットに命中すると、3秒間{3}と{4}を得る。強化されると{5}する。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 50, 30, ap(0.8))
                .variable(3, AR, 15, 7)
                .variable(4, MR, 15, 7)
                .variable(5, RestoreHealth, 40, 0, amplify(Lv, 20))
                .cd(15, -1)
                .update(P401)
                .active("{1}の敵ユニットに{2}を与える。また、このスキルが敵ユニットに命中すると、3秒間{3}と{4}を得る。強化されると{5}する。(失ったHealth1%毎に回復量が1%増加)")
                .variable(5, RestoreHealth, 20, 0, amplify(Lv, 10));
        BolaStrike.update()
                .active("対象の敵ユニットに投げ縄を投げ、{1}と2.5秒{2}を与える。スローは時間経過と共に元に戻る。強化されると{3}を与えるようになる。")
                .variable(1, PhysicalDamage, 60, 45, bounusAD(0.7))
                .variable(2, MSSlowRatio, 50, 5)
                .variable(3, Snare, 1)
                .cd(12, -1)
                .range(575);
        ThrillOfTheHunt.update()
                .active("1秒後に{1}になり、{2}の敵Champion全員の{3}。ステルス準備中に攻撃を行うかダメージを受ける度に、ステルス状態になるのに必要な時間が1秒増加する。ステルス準備開始から3秒経過するとダメージを受けていてもステルス状態になる。ステルス状態の間は{4}し、0.75秒毎に1 Ferocityを得る。これらの効果はステルス状態が解除されると終了する。")
                .variable(1, Stealth, 7)
                .variable(2, Radius, 2000, 1000)
                .variable(3, Visionable)
                .variable(4, MSRatio, 20, 5)
                .cd(140, -35);
    }

    private static void Riven() {
        RunicBlade.update()
                .passive("スキルを使用するごとに1チャージを得る。チャージがある状態で通常攻撃を行うと、チャージを消費して通常攻撃に{1}が付与される。チャージは最大3スタックされ、通常攻撃ごとに1チャージずつ消費される。チャージは5秒間増加または消費がないと0になる。建物には無効。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, new Per3LevelAdditional(0.2, 0.05)));
        BrokenWings.update()
                .active("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。")
                .variable(1, Radius, 112.5)
                .variable(2, PhysicalDamage, 30, 25, bounusAD(0.7))
                .variable(3, Radius, 150)
                .variable(4, Knockback, 225)
                .variable(5, PhysicalDamage, 90, 75, bounusAD(2.1))
                .cd(1)
                .range(260)
                .update(P310A)
                .active("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。3度目のジャンプのみ壁を飛び越えられる。")
                .variable(4, Knockup)
                .update(P401)
                .variable(2, PhysicalDamage, 10, 20, amplify(AD, 0.4, 0.05))
                .variable(5, PhysicalDamage, 30, 60, amplify(AD, 1.2, 0.15));
        KiBurst.update()
                .active("{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 125)
                .variable(2, PhysicalDamage, 50, 30, bounusAD(1))
                .variable(3, Stun, 0.75)
                .cd(11, -1);
        Valor.update()
                .active("指定方向にダッシュ({1})し、{3}間{2}が付与される。")
                .variable(1, Distance, 325)
                .variable(2, Shield, 70, 30, bounusAD(1))
                .variable(3, Time, 2.5)
                .cd(10, -1)
                .range(325)
                .update(P401)
                .variable(3, Time, 1.5)
                .update(P402)
                .variable(2, Shield, 90, 30, bounusAD(1));
        BladeOfTheExile.update()
                .active("15秒間折れた剣の刃を再生させ、{1}増加し、射程が増加する(通常攻撃: {2} Broken Wings: {3} Ki Burst: {4})。また、このスキルを再度使用することで一度だけ0.5秒後に指定方向に巨大な衝撃波を発生させ、範囲内の敵ユニットに{5}与える。対象が受けているダメージに比例して与えるダメージが増加して、最大DMは{6}。")
                .variable(1, AD, 0, 0, ad(0.2))
                .variable(2, Range, 200)
                .variable(3, Range, 325)
                .variable(4, Range, 270)
                .variable(5, PhysicalDamage, 80, 40, bounusAD(0.6))
                .variable(6, PhysicalDamage, 240, 120, bounusAD(1.8))
                .cd(110, -30);
    }

    private static void Ryze() {
        ArcaneMastery.update().passive("スキルを使用すると使用した以外のスキルの{1}する。").variable(1, CDDecrease, 1);

        Overload.update()
                .active("対象の敵ユニットに{1}を与える。")
                .passive("{2}を得る。")
                .variable(1, MagicDamage, 60, 25, ap(0.4), amplify(Mana, 0.065))
                .variable(2, CDR, 2, 2)
                .mana(60)
                .cd(3.5)
                .range(650)
                .update(P310)
                .range(600)
                .update(P403)
                .range(625);

        RunePrison.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 60, 35, ap(0.6), amplify(Mana, 0.045))
                .variable(2, Snare, 0.75, 0.25)
                .mana(80, 10)
                .cd(14)
                .range(625)
                .update(P310)
                .mana(60, 10)
                .range(600);

        SpellFlux.update()
                .active("対象の敵ユニットに魔法弾を飛ばし{1}と{2}を与える。魔法弾は{3}の敵ユニット及び自身に4回まで跳ね返る(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返り、また自身から跳ね返った弾は敵Championを優先で狙う。")
                .variable(1, MagicDamage, 50, 20, ap(0.35), amplify(Mana, 0.01))
                .variable(2, MRReduction, 12, 3)
                .variable(3, Radius, 400)
                .mana(60, 10)
                .cd(14)
                .range(675)
                .update(P310)
                .range(600);

        DesperatePower.update()
                .active("{1}間、{2}を得て{3}する。更にスキルに50%のスプラッシュダメージ({4})が付与される。")
                .variable(1, Time, 5, 1)
                .variable(2, SV, 15, 5)
                .variable(3, MS, 35, 10)
                .variable(4, Radius, 200)
                .cd(70, -10)
                .update(P310)
                .variable(3, MS, 60, 10)
                .update(P312)
                .variable(3, MS, 80);
    }

    private static void Sivir() {
        FleetOfFoot.update()
                .passive("敵Championに通常攻撃でダメージを与えると、2秒間{1}する。")
                .variable(-1, MSRatio, 50)
                .update(P306)
                .passive(("敵Championに通常攻撃か" + BoomerangBlade + "もしくは" + Ricochet + "でダメージを与えると、2秒間{1}する。"))
                .update(P315)
                .variable(-1, MSRatio, new Per5LevelWith18(30, 5));
        BoomerangBlade.update()
                .active("指定方向にブーメランを投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに{2}ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定がある。")
                .variable(1, PhysicalDamage, 60, 45, ap(0.5), bounusAD(1.1))
                .variable(2, Percentage, 20)
                .mana(70, 10)
                .cd(9)
                .range(1200);
        BoomerangBlade.update(P314)
                .variable(1, PhysicalDamage, 25, 20, amplify(AD, 0.7, 0.1))
                .variable(2, Percentage, 10);
        Ricochet.update()
                .active("次に行う通常攻撃に追加{1}が付与され、5回跳ね返る({2})ようになる。この追加ダメージはCriticalHitによって増幅される。On-Hit Effectsの効果は最初に当たったユニットにのみ発動し、跳ね返る毎にダメージが20%ずつ低下する。")
                .variable(1, PhysicalDamage, 20, 15)
                .variable(2, Radius, 450)
                .mana(40)
                .cd(7, -1);
        Ricochet.update(P313)
                .active("次の3回の通常攻撃が{1}の全ての敵に跳ねるようになる。この跳ねは一番近くのユニットに跳ね、同一ユニットには一度しか当たらない。2匹目以降の敵には{2}を与える。On-Hit Effectsの効果は最初に当たったユニットにのみ発動する。")
                .variable(1, Radius, 450)
                .variable(2, PhysicalDamage, 0, 0, amplify(AD, 0.5, 0.1))
                .cd(9, -1);
        SpellShield.update()
                .active("{3}間、一度だけ敵のスキルを無効化する{1}を得る。無効化した場合{2}する。")
                .variable(1, Status.SpellShield)
                .variable(2, RestoreMana, 150)
                .variable(3, Time, 3)
                .mana(75)
                .cd(22, -3)
                .update(P313)
                .mana(0)
                .variable(2, RestoreMana, 60, 15)
                .update(P315)
                .variable(3, Time, 1.5);
        OnTheHunt.update()
                .active("{5}間以下の能力をもつ{1}のオーラを発生させる。{2}し、自身は{3}、近くの味方ユニットは{4}する。一度範囲内に入れば、Sivirから離れても効果が持続する。")
                .variable(1, Radius, 1200)
                .variable(2, MSRatio, 20)
                .variable(3, ASRatio, 30, 15)
                .variable(4, ASRatio, 15, 7.5)
                .variable(5, Time, 10)
                .mana(100)
                .cd(100, -10)
                .range(1200)
                .update(P313)
                .passive("Ricochetの起動中は{1}する。")
                .variable(-1, ASRatio, 40, 20)
                .active("{5}間{2}の味方は{3}する。一度範囲内に入れば、Sivirから離れても効果が持続する。増加移動速度は{6}かけて20%まで減少する。")
                .variable(2, Radius, 1000)
                .variable(3, MSRatio, 60)
                .variable(6, Time, 4)
                .range(0)
                .cd(120, -30)
                .update(P315)
                .variable(5, Time, 8)
                .variable(6, Time, 2, 1)
                .cd(120, -20);
    }

    private static void Skarner() {
        CrystallizingSting.update()
                .passive("通常攻撃を行うたびに、 Skarnerのすべてのスキルの{1}される(対象がChampionの場合は{2})。建物に対しては無効。")
                .variable(1, CDDecrease, 0.5)
                .variable(2, CDDecrease, 1);

        CrystalSlash.update()
                .active("{4}の敵ユニットに{1}を与える。このスキルが命中した場合、5秒間Crystal Energyのスタックを得る。スタックがある状態で再度このスキルを使用すると、追加{2}と2秒間{3}が付与される。")
                .variable(1, PhysicalDamage, 25, 15, bounusAD(0.8))
                .variable(2, MagicDamage, 24, 12, ap(0.4))
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, Radius, 350)
                .mana(20, 2)
                .cd(3.5)
                .update(P402)
                .active("{4}の敵ユニットに{1}を与える。このスキルが命中した場合、5秒間{3}得る。この効果は3回までスタックする。スタックがある状態で再度このスキルを使用すると、{2}を与える。")
                .variable(3, ASRatio, 8, 2)
                .update(P403)
                .mana(16, 2);

        CrystallineExoskeleton.update()
                .active("6秒間{1}を張る。シールドが残っている間{2}し、{3}する。")
                .variable(1, Shield, 70, 45, ap(0.6))
                .variable(2, MSRatio, 15, 2)
                .variable(3, ASRatio, 30, 5)
                .mana(60)
                .cd(18)
                .update(P402)
                .active("6秒間{1}を張る。シールドが残っている間3秒かけて{2}する。")
                .variable(1, Shield, 80, 55, ap(0.8))
                .variable(2, MSRatio, 16, 4)
                .cd(16);

        Fracture.update()
                .active("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに{1}と6秒間持続するマークを付与する。自身がマークが付いた敵ユニットを攻撃するか、このスキルで敵ユニットを倒した場合、マークを消費して{2}する。HP回復量はマークを消費する度に50%ずつ低下していく。")
                .variable(1, MagicDamage, 80, 40, ap(0.7))
                .variable(2, RestoreHealth, 30, 15, ap(0.3))
                .mana(50, 5)
                .cd(10)
                .range(600)
                .update(P402)
                .active("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに{1}と2.5秒間{2}を付与する。")
                .variable(2, MSSlowRatio, 30, 5)
                .cd(14)
                .range(1000)
                .update(P403)
                .variable(2, MSSlowRatio, 45, 5);

        Impale.update()
                .active("対象の敵Championに{1}と{2}を与える。効果中は対象の敵Championを引っ張る事が出来る。また、効果終了時に追加{3}を与える。")
                .variable(1, MagicDamage, 100, 50, ap(0.5))
                .variable(2, Suppression, 1.75)
                .variable(3, MagicDamage, 100, 50, ap(0.5))
                .mana(100, 25)
                .cd(130, -10)
                .range(350);
    }

    private static void Sona() {
        PowerChord.update()
                .passive("Auraを切り替えても、以前のAuraの効果が1秒間持続する。切替時は他のAuraスキルが0.5秒間CDになる。また、3回スキルを使用した後の通常攻撃に{1}と、そのとき展開しているAuraに応じた追加効果が発生する。<br>" + HymnOfValor + " : 追加{1}を与える。<br>" + AriaOfPerseverance + " : {3}間対象が与えるダメージが{4}減少するDebuffを与える。<br>" + SongOfCelerity + " : 2秒間{2}を与える。")
                .variable(1, MagicDamage, 8, 0, amplify(Lv, 10))
                .variable(2, MSSlowRatio, 40)
                .variable(3, Time, 4)
                .variable(4, Percentage, 20);
        PowerChord.update(P308)
                .variable(1, MagicDamage, new Per1Level(new double[] {13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112,
                        122, 132, 147, 162, 177, 192}))
                .variable(3, Time, 3);
        PowerChord.update(P314)
                .variable(1, MagicDamage, new Per1Level(new double[] {13, 20, 27, 35, 43, 52, 62, 72, 82, 92, 102, 112,
                        122, 132, 147, 162, 177, 192}), ap(0.2), null)
                .variable(4, Percentage, 20, 0, ap(0.02))
                .variable(2, MSSlowRatio, 40, 0, ap(0.04));
        HymnOfValor.update()
                .active("最も近い敵ユニット2体に{4}を与える。Sonaの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。" + Crescendo + "以外の別のスキルを使うまで{1}の味方Championは{2}と{3}を得る。")
                .variable(1, Radius, 1000)
                .variable(2, AD, 4, 4)
                .variable(3, AP, 4, 4)
                .variable(4, MagicDamage, 50, 50, ap(0.7))
                .mana(45, 5)
                .cd(7)
                .range(700);
        HymnOfValor.update(P314).variable(4, MagicDamage, 50, 50, ap(0.5));
        AriaOfPerseverance.update()
                .active("近くにいる最もHPが減っている味方Champion1体とSonaは{1}し、3秒間{2}と{3}を得る。" + Crescendo + "以外の別のスキルを使うまで{4}の味方Championは{5}と{6}を得る。")
                .variable(1, RestoreHealth, 40, 20, ap(0.25))
                .variable(2, AR, 8, 3)
                .variable(3, MR, 8, 3)
                .variable(4, Radius, 1000)
                .variable(5, AR, 3, 3)
                .variable(6, MR, 3, 3)
                .mana(60, 5)
                .cd(7)
                .range(1000);
        AriaOfPerseverance.update(P308)
                .variable(2, AR, 6, 1)
                .variable(3, MR, 6, 1)
                .variable(5, AR, 6, 1)
                .variable(6, MR, 6, 1);
        AriaOfPerseverance.update(P314).variable(1, RestoreHealth, 40, 15, ap(0.25));
        SongOfCelerity.update()
                .active("1.5秒間{1}の味方ユニットは{2}する。" + Crescendo + "以外の別のスキルを使うまで{1}の味方Championは{3}する")
                .variable(1, Radius, 1000)
                .variable(2, MSRatio, 6, 2)
                .variable(3, MSRatio, 4, 4)
                .mana(65)
                .cd(7)
                .range(1000);
        SongOfCelerity.update(P314).variable(2, MSRatio, 4, 2, ap(0.02));
        Crescendo.update()
                .active("前方{1}の敵Championに{2}と{3}を与える。")
                .variable(1, Radius, 1000)
                .variable(2, MagicDamage, 150, 100, ap(0.8))
                .variable(3, Stun, 1.5)
                .mana(100, 50)
                .cd(140, -20);
        Crescendo.update(P314).variable(2, MagicDamage, 150, 100, ap(0.5));
    }

    private static void Soraka() {
        Salvation.update().passive("{1}の味方Championは{2}を得る。").variable(1, Radius, 1000).variable(2, MR, 16);
        Salvation.update(P314)
                .passive("スキルによるHealth及びMana回復は、回復する対象の減少しているHealth/Mana2%につき、1%増加する(最大でHealth/Mana回復量1.5倍)。");
        Starcall.update()
                .active("{1}の敵ユニットに{2}を与え、スタックを1つ増加させる。スタック1つにつき{3}を与える。スタックは5秒間持続し最大10まで増加する。")
                .variable(1, Radius, 675)
                .variable(2, MagicDamage, 60, 25, ap(0.4))
                .variable(3, MRReduction, 8, 1)
                .mana(20, 15)
                .cd(2.5);
        Starcall.update(P314)
                .active("{1}の敵ユニットに{2}と{3}を与える。この減少効果は5秒間持続し最大10回まで累積する。また、このスキルが敵Championに命中すると、" + AstralInfusion + "の{4}する。")
                .variable(2, MagicDamage, 60, 35, ap(0.4))
                .variable(3, MRReduction, 6, 0, ap(0.01))
                .variable(4, CDDecreaseRatio, 5, 1.25)
                .mana(30, 10);
        AstralInfusion.update()
                .active("対象の味方ユニットは{1}し、{3}間{2}を得る。")
                .variable(1, RestoreHealth, 70, 70, ap(0.45))
                .variable(2, AR, 25, 20)
                .variable(3, Time, 3)
                .mana(80, 30)
                .cd(20)
                .range(750);
        AstralInfusion.update(P314)
                .variable(1, RestoreHealth, 70, 50, ap(0.35))
                .variable(2, AR, 50, 15, ap(0.15))
                .variable(3, Time, 2)
                .mana(80, 20);
        Equinox.update()
                .active("対象の味方Championに使用すると{1}する。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .variable(1, RestoreMana, 40, 40)
                .variable(2, MagicDamage, 50, 50, ap(0.6))
                .variable(3, Silence, 1.5, 0.25)
                .cd(10)
                .range(725);
        Equinox.update(P314)
                .active("対象の味方Championに使用すると{1}し、Sorakaは{4}を失う。敵ユニットに使用すると{2}と{3}を与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .variable(1, RestoreMana, 20, 20, amplify(Mana, 0.05))
                .variable(2, MagicDamage, 40, 30, ap(0.4), amplify(Mana, 0.05))
                .variable(4, Mana, 0, 0, amplify(Mana, 0.05));
        Wish.update()
                .active("全ての味方Championは{1}する。")
                .variable(1, RestoreHealth, 200, 120, ap(0.7))
                .mana(100, 75)
                .cd(160, -15);
        Wish.update(P313).mana(100);
        Wish.update(P314).variable(1, RestoreHealth, 150, 100, ap(0.55));
    }

    private static void Swain() {
        /** Swain */
        CarrionRenewal.update().passive("敵ユニットを倒す毎に{1}する。").variable(1, RestoreMana, 9, 0, amplify(Lv, 1));
        CarrionRenewal.update(P313)
                .passive("敵ユニットを倒す毎に{1}する。キルもしくはアシストする毎に{2}する。")
                .variable(2, RestoreMana, 0, 0, amplify(Mana, 0.09));
        Decrepify.update()
                .active("Swainの位置にビームを吐くカラスを設置し、対象の敵ユニットに毎秒{1}と{2}を与える。3秒経つか対象のユニットがカラスの有効範囲外({3})に移動すると効果が切れる。")
                .variable(1, MagicDamage, 25, 15, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, Radius, 900)
                .mana(60, 10)
                .cd(8)
                .range(625);
        Nevermove.update()
                .active("地点を指定した0.5秒後に範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.7))
                .variable(2, Snare, 2)
                .mana(80, 10)
                .cd(18, -2)
                .range(900);
        Torment.update()
                .active("対象の敵ユニットに4秒かけて{1}を与える。また、効果中はSwainが対象のユニットに与える{2}する。")
                .variable(1, MagicDamage, 75, 40, ap(0.8))
                .variable(2, DamageRatio, 8, 3)
                .mana(65, 5)
                .cd(10)
                .range(625);
        RavenousFlock.update()
                .active("カラスに変身し、{0}の敵ユニット3体(敵Championを優先)に毎秒{1}を与える。また、{2}して敵Championの場合は{3}する。")
                .variable(0, Radius, 700)
                .variable(1, MagicDamage, 50, 25, ap(0.2))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 0.25))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamage, 0.75))
                .cd(8)
                .cost(Mana, new Diff(25, 0, 1), amplify(Duration, 5, 1))
                .type(SkillType.Toggle);
    }

    private static void Syndra() {
        Transcendent.update().passive("各スキルを最高ランクまで上げると追加効果が発生する。");
        DarkSphere.update()
                .active("指定地点にDark Sphereを召喚し、{1}の敵ユニットに{2}を与える。Dark Sphereはその後6秒間持続する。Lv5になるとChampionに対して{3}を与える。")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, MagicDamage, 264.5, 0, ap(0.69))
                .mana(40, 10)
                .cd(4)
                .range(800);
        ForceOfWill.update()
                .active("指定したDark Sphereか敵minionまたは中立モンスター(DragonとBaronには無効)のいずれかを自身まで引き寄せ、最大5秒間引っ張り続ける。この際Dark Sphereを引き寄せた場合、そのDark Sphereの持続時間は引き寄せてから6秒間に更新される。その後再度地点を指定({5})することで指定地点に引き寄せたものを投げ、{1}の敵ユニットに{2}と1.5秒間{3}を与える。また指定地点の{4}。Lv5になるとスローの効果時間が2秒になる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 80, 40, ap(0.7))
                .variable(3, MSSlowRatio, 25, 5)
                .variable(4, Visionable)
                .variable(5, Radius, 900)
                .mana(60, 10)
                .cd(12, -1)
                .range(925);
        ScatterTheWeak.update()
                .active("指定方向扇形の{1}にいる敵ユニットに{2}と{3}を与える。ノックバック距離はSyndraに近い地点にいるほど増加する。扇形の範囲内にDark Sphereがあった場合同様にノックバックさせ、それに当たった敵ユニットに{2}(このスキルのDMとは重複しない)と{4}を与える。Lv5になると範囲の横幅が50%増加する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 45, ap(0.4))
                .variable(3, Knockback)
                .variable(4, Stun, 1.5)
                .mana(50)
                .cd(18, -1.5)
                .range(650);
        ScatterTheWeak.update(P313).range(700);
        UnleashedPower.update()
                .active("自身の周辺にDark Sphereを3つ召喚し、指定した敵Championに向けて自身の周囲に存在する全てのDark Sphereを向かわせ、{1}を与える。3個で{2}、7個で{3}になる。この際に召喚したDark Sphereは6秒間持続する。Lv3になると射程が75増加する。")
                .variable(1, MagicDamage, 90, 45, ap(0.2))
                .variable(2, MagicDamage, 270, 135, ap(0.6))
                .variable(3, MagicDamage, 630, 345, ap(1.4))
                .mana(100)
                .cd(100, -10)
                .range(675);
    }

    private static void Shyvana() {
        Dragonborn.update()
                .passive("Shyvanaは通常攻撃時に次の効果を得る。Twin BiteのCDを0.5秒解消する。対象が建物の場合は無効。Burnoutの効果時間が1秒延長される。最大4秒延長できる。対象が建物の場合も有効。Flame BreathのAR低下を受けている敵ユニットに対し、Flame Breathのダメージの15%分の追加魔法DMが発生する。Dragon's Descent通常攻撃時に2Furyを得る。また、Human formの時には1.5秒毎に1Furyを得る。");
        Dragonborn.update(P309)
                .passive("{1}と{2}を得る。この効果はDragon Form時には2倍になる。")
                .variable(1, AR, new Per5Level(5, 5))
                .variable(2, MR, new Per5Level(5, 5));
        TwinBite.update()
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.8, 0.05))
                .variable(2, CDDecrease, 0.5)
                .cd(10, -1);
        TwinBite.update(P309)
                .active("次に行う通常攻撃が二回攻撃になり、ニ回目の攻撃は{1}を与える。Dragon Form時は対象の周囲にいる敵ユニットにも同様の効果を与える。建物以外の対象を通常攻撃する毎に{2}する。{3}。")
                .variable(3, OnHitEffect);
        Burnout.update()
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 25, 15, bounusAD(0.2))
                .variable(3, MSRatio, 30, 5)
                .cd(12)
                .update(P309)
                .active("3秒間{1}の敵ユニットに毎秒{2}を与え、{3}する。通常攻撃をする毎に効果時間が1秒延長される(最大4秒増加)。移動速度上昇は時間経過と共に減少する。Dragon Form時Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒{2}を与える。")
                .update(P401)
                .variable(2, MagicDamage, 20, 15, bounusAD(0.2));

        FlameBreath.update()
                .active("指定方向に火球を放ち当たった敵ユニットに{1}と４秒間{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 80, 45, ap(0.6))
                .variable(2, ARReductionRatio, 15)
                .cd(12, -1)
                .range(700)
                .update(P309)
                .active("指定方向に貫通する火球を放ち当たった敵ユニットに{1}と5秒間Debuffを与える。Debuffを受けている敵に通常攻撃をする毎に{2}を与える。Dragon Form時Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .variable(1, MagicDamage, 80, 35, ap(0.6))
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2))
                .update(P401)
                .variable(1, MagicDamage, 60, 40, ap(0.6));
        DragonsDescent.update()
                .passive("{1}と{2}を得る。 Dragon Formの時は2倍になる。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, AR, 10, 5)
                .variable(2, MR, 10, 5)
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒6Fury減少し、0になるとHuman Formに戻る。")
                .variable(3, MagicDamage, 175, 125, ap(0.7))
                .variable(4, Knockback)
                .range(1000);
        DragonsDescent.update(P309)
                .passive("Human formの時には1.5秒毎に{1}Furyを得る。また、このスキルのLv1取得時に100Furyを得る。")
                .variable(1, Value, 1, 1)
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに{3}を与え、移動地点の方向に{4}を与える。Dragon Formでは毎秒5Fury減少し、0になるとHuman Formに戻る。");

    }

    private static void Taric() {
        Gemcraft.update().passive("通常攻撃をすると{1}する。").variable(1, RestoreMana, 0, 0, amplify(DealtDamageRatio, 0.075));
        Gemcraft.update(P303)
                .passive("通常攻撃に追加{1}を付与する。敵チャンピオンに対しては{2}を与える。建物には無効。")
                .variable(1, MagicDamage, 0, 0, amplify(Mana, 0.02))
                .variable(2, MagicDamage, 0, 0, amplify(Mana, 0.04));
        Gemcraft.update(P314)
                .passive("スキルを使用した次の通常攻撃は追加{1}を与え、全スキルの{2}する。この効果は通常攻撃を行うか、一定時間経過すると解消される。")
                .variable(1, MagicDamage, 0, 0, amplify(AR, 0.3))
                .variable(2, CDDecrease, 2)
                .update(P315)
                .variable(1, MagicDamage, 0, 0, amplify(AR, 0.2));
        Imbue.update()
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。このスキルは自身が通常攻撃を行う毎にCDが1秒解消される。対象が敵Championの場合は3秒解消される。")
                .variable(1, RestoreHealth, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 84, 56, ap(0.84))
                .mana(80, 15)
                .cd(20, -1)
                .range(750);
        Imbue.update(P314)
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。")
                .variable(1, RestoreHealth, 60, 40, ap(0.3), amplify(BounusHealth, 0.05))
                .variable(2, RestoreHealth, 84, 56, ap(0.42), amplify(BounusHealth, 0.07))
                .mana(60, 20)
                .cd(18, -1);
        Shatter.update()
                .passive("Taricは{1}を得て、味方Championの{1}を増加させる{2}のAuraを得る。(Taric自身はAuraと合わせて2倍の効果を得る)")
                .variable(1, AR, 10, 5)
                .variable(2, Radius, 1000)
                .active("{4}の敵ユニットに{5}を与え、4秒間{6}を与える。効果後はCDが解消されるまでPassiveのTaric自身の増加ARが無くなる。")
                .variable(4, Radius, 400)
                .variable(5, MagicDamage, 60, 45, ap(0.6))
                .variable(6, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(10);
        Shatter.update(P303)
                .passive("Taricは{1}を得て、味方Championの{3}を増加させる{2}のAuraを得る。(Taric自身はAuraと両方の効果を得る)")
                .variable(3, AR, 0, 0, amplify(AR, 0.12))
                .variable(5, MagicDamage, 60, 45, ap(0.6), amplify(AR, 0.3))
                .mana(50);
        Shatter.update(P304).variable(5, MagicDamage, 50, 40, ap(0.6), amplify(AR, 0.2));
        Shatter.update(P314).variable(5, MagicDamage, 40, 40, amplify(AR, 0.3));
        Shatter.update(P315)
                .variable(1, AR, 5, 5)
                .variable(3, AR, 0, 0, amplify(AR, 0.05))
                .variable(5, MagicDamage, 40, 40, amplify(AR, 0.2));
        Dazzle.update()
                .active("対象の敵ユニットに{1}と{2}を与える。魔法DMは対象との距離が近いほど増加し、距離が遠いほど低下する。最小DMは{3}。")
                .variable(1, MagicDamage, 80, 60, ap(0.8))
                .variable(2, Stun, 1.5)
                .variable(3, MagicDamage, 40, 30, ap(0.4))
                .mana(95)
                .cd(14, -1)
                .range(625);
        Dazzle.update(P303).mana(75);
        Dazzle.update(P304).variable(2, Stun, 1.2, 0.1);
        Dazzle.update(P314)
                .variable(1, MagicDamage, 80, 60, ap(0.4))
                .variable(3, MagicDamage, 40, 30, ap(0.2))
                .cd(18, -1);
        Radiance.update()
                .active("{1}の敵ユニットに{2}を与える。スキル使用後の10秒間、{3}と{4}を得て、更に近くの味方Championの{5}と{6}を増加させるAura({7})を展開する。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, AD, 30, 20)
                .variable(4, AP, 30, 20)
                .variable(5, AD, 15, 10)
                .variable(6, AP, 15, 10)
                .variable(7, Radius, 1000)
                .mana(100)
                .cd(60);
        Radiance.update(P314).variable(2, MagicDamage, 150, 100, ap(0.5)).cd(75);
    }

    private static void Talon() {
        Mercy.update().passive("スロー、スタン、スネア、サプレッションを受けている状態の敵ユニットに対しては{1}する。").variable(1, AttackDamageRatio, 10);
        NoxianDiplomacy.update()
                .active("次の通常攻撃に{1}が付与される。対象がChampionの場合、更に6秒間対象を出血させその間毎秒{2}を与える。また出血中の対象の{3}。")
                .variable(1, PhysicalDamage, 30, 30, bounusAD(0.3))
                .variable(2, PhysicalDamage, 10, 10, bounusAD(1))
                .variable(3, Visionable)
                .mana(40, 5)
                .cd(8, -1);
        Rake.update()
                .active("前方指定範囲に飛んだ後すぐ戻る刃を投げ当たった敵ユニットに{1}と2秒間{2}を与える。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 30, 25, bounusAD(0.6))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(10)
                .range(600);
        Cutthroat.update()
                .active("対象の敵ユニットに跳躍し{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。")
                .variable(1, Silence, 1)
                .variable(2, DamageRatio, 3, 3)
                .mana(35, 5)
                .cd(18, -2)
                .range(700)
                .update(P401)
                .active("対象の敵ユニットの背後に跳躍し{1}と3秒間マークを与える。マークがついた敵ユニットに対しては{2}する。");
        ShadowAssault.update()
                .active("周囲に8本の刃を投げ当たった敵ユニットに{1}を与え、同時に{2}になり{3}する。ステルスが解除される、または敵ユニットを攻撃すると刃がTalonの元に戻ってくる。刃は戻り際にも判定がある。")
                .variable(1, PhysicalDamage, 120, 50, bounusAD(0.75))
                .variable(2, Stealth, 2.5)
                .variable(3, MSRatio, 40)
                .mana(80, 10)
                .cd(75, -10)
                .range(1000);
    }

    private static void Teemo() {
        Camouflage.update()
                .passive("2秒間動かないと{1}になる。何か行動を行うか、強制的に移動させられるとステルスが解除され、ステルス解除後3秒間{2}する。")
                .variable(1, Stealth)
                .variable(-2, ASRatio, 40);

        BlindingDart.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 45, ap(0.8))
                .variable(2, Blind, 1.5, 0.25)
                .mana(70, 10)
                .cd(8)
                .range(680);

        MoveQuick.update()
                .passive("{1}する。敵Championかタワーからダメージを受けると5秒間効果が切れる。")
                .variable(1, MSRatio, 10, 4)
                .active("3秒間{1}し、Passiveの効果が切れることがなくなる。")
                .mana(40)
                .cd(17);

        ToxicShot.update()
                .passive("通常攻撃時に{1}と毒が付与される。毒は4秒間持続し、毎秒{2}を与える。合計で{3}。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, MagicDamage, 6, 6, ap(0.1))
                .variable(3, MagicDamage, 34, 34, ap(0.7));

        NoxiousTrap.update()
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒で{1}になる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と4秒間{4}を与える。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはChampionの通常攻撃でのみダメージを与えられる。")
                .variable(1, Stealth)
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 200, 125, ap(0.8))
                .variable(4, MSSlowRatio, 30, 10)
                .variable(5, CDRAwareTime, 35, -4)
                .cd(1)
                .mana(75, 25)
                .range(230)
                .update(P312)
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒で{1}になる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、{2}のユニットに4秒かけて{3}と4秒間{4}を与える。{5}毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはChampionの通常攻撃でのみダメージを与えられ、破壊すると{6}を得る。")
                .variable(6, Gold, 10)
                .update(P403)
                .variable(3, MagicDamage, 200, 125, ap(0.5));
    }

    private static void Thresh() {
        Damnation.update()
                .passive("{1}で敵ユニットが死んだ場合、一定の確率で魂を落とす。魂へ近づくか" + DarkPassage + "のランタンを魂の近くに置くとその魂を回収し、{2}と{3}を得る。落とした魂は15秒間持続し、敵チームがThreshの視界を得ていた場合、敵チームからも視認することができる。")
                .variable(1, Radius, 2000)
                .variable(2, AR, 0, 0, amplify(Stack, 1))
                .variable(3, AP, 0, 0, amplify(Stack, 1));
        Damnation.update(P310).variable(2, AR, 0, 0, amplify(Stack, 0.75)).variable(3, AP, 0, 0, amplify(Stack, 0.75));
        DeathSentence.update()
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。")
                .variable(1, MagicDamage, 80, 30, ap(0.5))
                .variable(2, Stun, 1.5)
                .mana(80)
                .cd(18, -1.5)
                .range(1075);
        DeathSentence.update(P306).variable(1, MagicDamage, 80, 40, ap(0.5));
        DeathSentence.update(P312)
                .active("指定方向に鎌を投げ、命中した敵ユニットに{1}と{2}を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。鎌が敵に命中した場合、このスキルの{3}する。")
                .variable(3, CDDecrease, 3)
                .cd(20, -2);
        DarkPassage.update()
                .active("指定地点に6秒間持続するランタンを設置する。味方Championがランタンを指定すると、ランタンとその味方Championが自身の方へと引き寄せられる。更にランタンの周囲にいる魂を自動的に回収し、{1}の味方Championは{2}を得る。。シールドを得られるのは1ユニットにつき1回のみ。自身がランタンから距離1500以上離れるとランタンは自動的に自身の下へと戻る。")
                .variable(1, Radius)
                .variable(2, Shield, 60, 40, ap(0.4))
                .mana(40)
                .cd(22, -1.5)
                .range(950);
        Flay.update()
                .active("自身後方から前方への帯状領域内の敵ユニットに{1}を与える。また自身後方にいる敵ユニットは自身に近づく向きに、自身前方にいる敵ユニットには自身から遠ざかる向きにノックバックさせ、1.5秒間{2}を与える。")
                .variable(1, MagicDamage, 65, 40, ap(0.4))
                .variable(2, MSSlowRatio, 20, 5)
                .mana(60, 5)
                .cd(9)
                .range(400);
        Flay.update(P306)
                .passive("通常攻撃に{3}を付与する。このDMはDamnationのスタック数と、自身が前回敵ユニットに通常攻撃をしてから経過した時間に比例して増加する。建物を攻撃した場合は追加魔法DMは発生せず、時間がリセットされる事もない。")
                .variable(2, MagicDamage, 65, 30, ap(0.4))
                .variable(3, MagicDamage, 0, 0, amplify(Stack, 1));
        TheBox.update()
                .active("{5}後、{4}に五角形の壁を創り出し、最初に壁に触れた敵Championに{1}と2秒間{2}を与える。2つ目以降の壁に触れた敵championには{3}と1秒間{2}を与える。敵が触れた部分の壁は破壊され消滅する。")
                .variable(1, MagicDamage, 250, 150, ap(1))
                .variable(2, MSSlowRatio, 99)
                .variable(3, MagicDamage, 125, 75, ap(0.5))
                .variable(4, Radius, 450)
                .variable(5, Time, 0.5)
                .mana(100)
                .cd(150, -10)
                .update(P401)
                .variable(5, Time, 0.75);
    }

    private static void Tryndamere() {
        BattleFury.update()
                .passive("{1}する。通常攻撃時に5Fury、クリティカル時に10Fury、Spinning Slashが敵ユニットに命中するたびに2Furyを得る。敵ユニットを倒すと追加で10Furyを得る。Furyの上限は100、8秒間戦闘を行わないと毎秒5Furyずつ減少していく。建物を攻撃した場合はFuryは増加しない。")
                .variable(-1, Critical, 0, 0, amplify(Stack, 0.35));
        Bloodlust.update()
                .passive("{1}を得る。")
                .variable(1, AD, 5, 5, amplify(MissingHealthPercentage, 0.15, 0.05))
                .active("Furyをすべて消費し{2}する。")
                .variable(2, RestoreHealth, 30, 10, ap(1.5), amplify(Stack, 0.5, 0.45))
                .cd(12);
        Bloodlust.update(P303).variable(2, RestoreHealth, 30, 10, ap(0.3), amplify(Stack, 0.5, 0.45, ap(0.012)));
        MockingShout.update()
                .active("4秒間近くの敵Championに{1}を与え、後ろを向いている敵Championには更に4秒間{2}を与える。")
                .variable(1, ASSlowRatio, 20, 15)
                .variable(2, MSSlowRatio, 30, 7.5)
                .cd(14)
                .range(850);
        SpinningSlash.update()
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。")
                .variable(1, PhysicalDamage, 70, 30, ap(1), bounusAD(1.2))
                .variable(2, CDDecrease, 2)
                .cd(13, -1)
                .range(660);
        SpinningSlash.update(P313)
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに{1}を与える。このスキルはクリティカルが発生するたびに{2}する。(ミニオンやモンスターに対して発生した場合は{3}する)")
                .variable(3, CDDecrease, 1);
        UndyingRage.update()
                .active("5秒間HPが1未満にならなくなる(死ななくなる)。また、このスキル使用時にFuryが{1}増加する。このスキルの使用は状態異常によって阻害されない。")
                .variable(1, Count, 50, 25)
                .cd(110, -10);
    }

    private static void Varus() {
        LivingVengeance.update()
                .passive("敵ユニットを倒すと3秒間{1}する。敵Championをキル/アシストすると6秒間{2}する。この効果はスタックしない。")
                .variable(-1, ASRatio, 20)
                .variable(-2, ASRatio, 40);
        PiercingArrow.update()
                .active("最初にスキルを使用すると狙いを付ける。この間は通常攻撃や他のスキルを使用できなくなり、Varusの移動速度が20%低下するが、狙いを付けている間は徐々にこのスキルのダメージと射程距離が増加していく(2秒で最大)。再度このスキルを使用することで指定方向に貫通する矢を放ち、当たった敵ユニットに{1}を与える(最大で{2})。ダメージは敵に当たるごとに15%減少する。最小で33%。狙いを付けて4秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, PhysicalDamage, 10, 33, ad(1))
                .variable(2, PhysicalDamage, 15, 50, ad(1.65))
                .mana(70, 5)
                .cd(16, -2)
                .range(new Diff(850, 0, 1), amplify(Duration, 200));
        PiercingArrow.update(P307)
                .variable(1, PhysicalDamage, 10, 37, ad(1))
                .variable(2, PhysicalDamage, 15, 55, ad(1.65));
        BlightedQuiver.update()
                .passive("通常攻撃に追加{1}と6秒間持続する疫病が付与される。疫病は3回までスタックする。疫病のスタックが付与されている敵ユニットにVarusの他のスキルが命中した場合、疫病のスタックを全て消費して1スタック毎に{2}を与える。")
                .variable(1, MagicDamage, 10, 4, ap(0.25))
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 2, 0.75, ap(0.02)));
        HailOfArrows.update()
                .active("指定地点に矢の雨を放ち、範囲内の敵ユニットに{1}を与える。指定地点は4秒間呪われ、範囲内の敵ユニットに{2}と{3}を付与する。")
                .variable(1, PhysicalDamage, 65, 40, bounusAD(0.6))
                .variable(2, MSSlowRatio, 25, 5)
                .variable(3, Wounds)
                .mana(80)
                .cd(18, -2)
                .range(925);
        HailOfArrows.update(P307).variable(1, PhysicalDamage, 65, 35, bounusAD(0.6));
        ChainOfCorruption.update()
                .active("指定方向に腐敗の蔓を投げつけ、当たった敵Championに{1}と{2}を与える。当たった敵Championからは徐々に腐敗が広がり({3})、腐敗に触れた敵Championにも同様の効果を与える。")
                .variable(1, MagicDamage, 150, 100, ap(1))
                .variable(2, Snare, 2)
                .variable(3, Radius, 550)
                .mana(120)
                .cd(120, -15)
                .range(1075);
        ChainOfCorruption.update(P313).mana(100);
    }

    private static void Vayne() {
        NightHunter.update().passive("敵Championに向かって移動する際に{1}する。").variable(-1, MS, 30);
        Tumble.update()
                .active("指定地点にローリングし、次の通常攻撃に追加{1}を付与する。6秒間攻撃を行わないとCDになる。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.3, 0.05))
                .mana(40)
                .cd(6, -1);
        Tumble.update(P303).mana(30);
        SilverBolts.update()
                .passive("同じターゲットに3回連続して通常攻撃またはスキルで攻撃すると、{1}を与える。（モンスターやミニオンに対しては上限200）")
                .variable(1, TrueDamage, 20, 10, amplify(TargetMaxHealthRatio, 3, 1));
        Condemn.update()
                .active("対象の敵ユニットをヘビークロスボウで狙撃し{1}と{2}を与える。ノックバックした敵が壁等に当たると追加で{1}と{3}を与える。")
                .variable(1, PhysicalDamage, 45, 35, bounusAD(0.5))
                .variable(2, Knockback, 470)
                .variable(3, Stun, 1.5)
                .mana(90)
                .cd(20, -2)
                .range(650);
        Condemn.update(P310).range(550);
        FinalHour.update()
                .active("{1}間{2}を得て、Tumbleを使うと{3}になり、Night Hunterの移動速度増加が3倍になる。")
                .variable(1, Time, 8, 2)
                .variable(2, AD, 25, 15)
                .variable(3, Stealth, 1)
                .mana(80)
                .cd(70);
    }

    private static void VelKoz() {
        OrganicDeconstruction.update(P403)
                .passive("スキルで敵ユニットにダメージを与える度に対象にスタックを付与し、対象のスタックが3になるとスタックを全て消費して{1}を与える。スタックは7秒間持続する。通常攻撃を行うと、既に存在しているスタックの持続時間を7秒に戻す。")
                .variable(1, TrueDamage, 25, 0, amplify(Lv, 10));

        PlasmaFission.update(P403)
                .active("指定方向にプラズマを放ち、当たった敵ユニットに{1}と{2}かけて減衰する{3}を与える。スキルを再使用するか、プラズマが敵ユニットに命中するとプラズマが90度の方向に分裂し、分裂したプラズマに当たった敵ユニットにも同様の効果を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.6))
                .variable(2, Time, 1, 0.25)
                .variable(3, MSSlowRatio, 70)
                .mana(40, 5)
                .cd(7)
                .range(1050);

        VoidRift.update(P403)
                .active("スタックを1消費して、ビームで指定方向に裂け目を発生させ、直線状にいる敵ユニットに{1}を与える。裂け目は0.25秒後に爆発し、{2}にいる敵ユニットに{3}を与える。スタックは{4}毎に増加する（最大2）。")
                .variable(1, MagicDamage, 30, 20, ap(0.25))
                .variable(2, Radius)
                .variable(3, MagicDamage, 45, 30, ap(0.375))
                .variable(4, CDRAwareTime, 19, -1)
                .mana(50, 5)
                .cd(-1.5)
                .range(1050);

        TectonicDisruption.update(P403)
                .active("指定地点を爆発させ、{1}の敵ユニットに{2}と{3}を与える。命中した敵はVel'Kozから遠ざかるように吹き飛ぶ。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 70, 30, ap(0.5))
                .variable(3, Suspension, 0.75)
                .mana(50, 5)
                .cd(16, -1)
                .range(850);

        LifeFormDisintegrationRay.update(P403)
                .active("最大2.5秒間カーソルの場所目掛けて貫通するレーザーを放ち、0.25秒毎に{1}にいる敵ユニットに{2}と1秒間{3}を与える（2.5秒間当て続けた場合は{4}）。また0.5秒毎に" + OrganicDeconstruction + "のスタックが増加する。スキルを再使用することで中断できる。ミニオン(モンスターには無効)に対しては500%のダメージを与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 50, 20, ap(0.06))
                .variable(3, MSSlowRatio, 20)
                .variable(4, MagicDamage, 500, 200, ap(0.6))
                .mana(100)
                .cd(130, -20)
                .range(1575)
                .type(SkillType.Channel);
    }

    private static void Viktor() {
        GloriousEvolution.update()
                .passive("Hex Coreという、自身のステータスとスキルの効果を強化するアイテムを所持している。Hex Coreは1度だけショップで1000Gを消費して以下の３通りのいずれかにアップグレードすることが出来る。Hex CoreはViktorのアイテムスロットを1つ占有し、売却することは出来ない。<br>Hex Core : {1}を得る。<br>Augment Power : {1}、{2}、{3}を得る。また、Power Transfer使用・命中時に移動速度が3秒間30%増加する。<br>Augment Gravity : {1}、{4}、{5}、{6}を得る。また、Gravity Fieldの射程が30%増加する。<br>Augment Death : {1}、{7}を得る。また、Death Rayにダメージの30%分の追加魔法DMが付与される。このダメージは4秒間かけて与える。")
                .variable(-1, AP, 0, 0, amplify(Lv, 3))
                .variable(-2, Health, 220)
                .variable(-3, Hreg, 6)
                .variable(-4, Mana, 200)
                .variable(-5, CDR, 10)
                .variable(-6, Mreg, 5)
                .variable(-7, AP, 45);
        SiphonPower.update()
                .active("対象の敵ユニットに{1}を与え、3秒間{2}を得る。")
                .variable(1, MagicDamage, 80, 45, ap(0.65))
                .variable(2, Shield, 0, 0, amplify(DealtDamageRatio, 40))
                .mana(45, 5)
                .cd(9, -1)
                .range(600);
        GravityField.update()
                .active("0.25秒詠唱後、指定範囲に4秒間持続する重力束縛装置を呼び出し、範囲内の敵ユニットに{1}を与え、0.5秒毎にスタックを付与する。スタックが3溜まった敵ユニットに{2}を与える。")
                .variable(1, MSSlowRatio, 28, 4)
                .variable(2, Stun, 1.5)
                .mana(65)
                .cd(17, -1)
                .range(625);
        DeathRay.update()
                .active("指定地点から指定方向にビームを発射し、ビームが通過する線上の敵ユニットに{1}を与える。また、ビームが通過した地点の{2}。")
                .variable(1, MagicDamage, 70, 45, ap(0.7))
                .variable(2, Visionable)
                .mana(70, 10)
                .cd(13, -1)
                .range(700);
        ChaosStorm.update()
                .active("指定地点に7秒間持続する特異点を呼び出し、{1}の敵ユニットに{2}と{3}を与える。特異点は周囲の敵ユニットに毎秒{4}を与え、また近くにいる敵Championを自動的に追尾する。このスキルがActiveの間に再度地点を指定することで、特異点を指定した地点に手動で移動させる事が出来る。最大で{5}を与える。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 150, 100, ap(0.55))
                .variable(3, Silence, 0.5)
                .variable(4, MagicDamage, 40, 20, ap(0.25))
                .variable(5, MagicDamage, 430, 240, ap(2.23))
                .mana(125, 50)
                .cd(120)
                .range(700);
        ChaosStorm.update(P313).mana(100);
    }

    private static void Xerath() {
        ManaSurge.update()
                .passive("{1}を得る。")
                .variable(1, AR, 0, 0, ap(0.15))
                .update(P402)
                .passive("通常攻撃を行うと{1}する。Championを攻撃した場合は回復量が2倍になる。建物に対しては無効。")
                .variable(1, RestoreMana, new Per1Level(new double[] {30, 33, 36, 42, 48, 54, 6372, 81, 90, 102, 114,
                        126, 138, 150, 165, 180.195}))
                .cd(-12);
        Arcanopulse.update()
                .active("0.75秒詠唱後指定方向にビームを放ち、直線状の敵ユニットすべてに{1}を与える。")
                .variable(1, MagicDamage, 75, 40, ap(0.6))
                .mana(65, 5)
                .cd(7, -0.5)
                .range(900)
                .update(P402)
                .active("最初にスキルを使用するとチャージを行う。この間は通常攻撃や他のスキルを使用できなくなり、移動速度が徐々に低下(最大で-50%)するが、チャージしている間は徐々にこのスキルの射程距離が増加していき、1.5秒後に最大射程1400に到達。再度このスキルを使用することで指定方向に電撃を放ち、直線状にいる敵ユニットに{1}を与える。チャージを行って3秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .variable(1, MagicDamage, 80, 40, ap(0.75))
                .cd(9, -1)
                .mana(80, 10)
                .range(750);
        EyeOfDestruction.update()
                .active("0.5秒詠唱後に移動が不可能になる代わりに、全てのスキルの射程が400増加し、{1}を得る。この効果は8秒経過するか、再度このスキルを使用する事で解除される。このスキルが解除された時に2秒間{2}する。")
                .variable(1, MRPenRatio, 16, 6)
                .variable(2, MSRatio, 35)
                .cd(20, -4)
                .update(P402)
                .active("0.5秒後に指定地点の{1}の敵ユニットに{2}と2.5秒間{3}を与える。中心点にいる敵ユニットに対しては{4}と2.5秒間{5}を与える（2.5秒かけて10%まで減衰）。また、指定地点の{6}。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 30, ap(0.6))
                .variable(3, MSSlowRatio, 10)
                .variable(4, MagicDamage, 90, 45, ap(0.9))
                .variable(5, MSSlowRatio, 60, 5)
                .variable(6, Visionable)
                .cd(14, -1)
                .mana(70, 10)
                .range(1100);
        ShockingOrb.update()
                .active("対象の敵ユニットに{1}と3秒間マークを与える。マークがついている敵ユニットにXerathのスキルが命中した場合、マークを消費して対象に{2}を与える。")
                .variable(1, MagicDamage, 70, 50, ap(0.8))
                .variable(2, Stun, 1.5)
                .mana(70, 5)
                .cd(12, -1)
                .range(600)
                .update(P402)
                .active("指定方向に雷のオーブを放ち、当たった敵ユニットに{1}と{2}を与える。飛距離に比例してスタンの効果時間が延長する（0.75秒から2秒）。")
                .variable(1, MagicDamage, 80, 30, ap(0.45))
                .variable(2, Stun)
                .cd(13, -0.5)
                .mana(60, 5)
                .range(1050);
        RiteOfTheArcane.update()
                .active("0.5秒後に指定地点の{1}の敵ユニットに{2}を与える。このスキルは12秒の間、3回まで連続して使用できる(但し、一度使用する度に0.35秒のCDが発生する)。2〜3発目はマナコスト無しで使用可能。また、指定地点の視界{3}を得る。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 125, 75, ap(0.6))
                .variable(3, Radius, 300)
                .mana(150, 30)
                .cd(80, -10)
                .range(900)
                .update(P402)
                .active("最大10秒間通常攻撃、移動、スキル使用が不可能になる。最大3回、指定地点に砲撃を行い、0.5秒後に{1}の敵ユニットに{2}を与える。一度使用する度に0.35秒のCDが発生する。また、指定地点の{3}。砲撃を行う前に行動不可状態を解除した場合、このスキルの{4}する。")
                .variable(1, Radius)
                .variable(2, MagicDamage, 190, 55, ap(0.43))
                .variable(3, Visionable)
                .variable(4, CDDecreaseRatio, 50)
                .cd(130, -15)
                .mana(100)
                .range(3200, 1200);
    }

    private static void Yasuo() {
        WayOfTheWanderer.update(P315)
                .passive("一定距離({1})を移動すると最大値の1%のFlowを得る。{2}するがクリティカルダメージは10%減少する。この減少効果はダメージ増減算の前に適用される。(例：本来200%のクリティカルダメージは(100 - 10) x 2 = 180%になり、" + Item.InfinityEdge.name + "を持った場合本来250%のダメージが(100 - 10) * 2.5 = 225%になる)。Flowが最大値の時、敵Championかモンスターからダメージを受けると全てのFlowを消費して{5}間{3}を得る。")
                .variable(1, Value, 40)
                .variable(2, Critical, 0, 0, amplify(Critical, 1))
                .variable(3, Shield, new Per1Level(new double[] {60, 65, 70, 75, 85, 95, 110, 125, 145, 170, 200, 240,
                        290, 350, 420, 500, 590, 690}))
                .variable(5, Time, 2)
                .update(P402)
                .variable(1, Value, 46)
                .update(P403)
                .variable(5, Time, 1.5)
                .variable(3, Shield, new Per1Level(new double[] {60, 65, 70, 75, 80, 90, 100, 110, 125, 140, 160, 185,
                        215, 250, 290, 340, 400, 470}));

        SteelTempest.update(P315)
                .active("指定した方向の直線上にいる全ての敵({1})に{2}を与える。" + WhirlingDeath + "の使用中に起動した場合、{3}の敵にダメージを与える。このスキルは3回まで連続して使用でき、3度目の使用では{4}になり{5}を追加で与える。このスキルは通常攻撃として扱われ(クリティカル適用)、固定のCDを持つが、増加AS1.72%毎に再使用時間が1%減少する（最大で66%）。{6}。")
                .variable(1, Distance, 475)
                .variable(2, PhysicalDamage, 20, 20, ad(1))
                .variable(3, Radius, 375)
                .variable(4, Distance, 900)
                .variable(5, Knockup)
                .variable(6, OnHitEffect)
                .cd(-6, 0.5);

        WindWall.update(P315)
                .passive(SweepingBlade + "か" + LastBreath + "を使用すると最大値の{1}のFlowを得る。")
                .variable(1, Percentage, 4, 4)
                .active("3.75秒間持続する{2}の壁を作り出す。この壁はタワー攻撃を除く全ての投射物をブロックする。")
                .variable(2, Length, 300, 50)
                .cd(26, -2)
                .range(400)
                .update(P402)
                .variable(1, Percentage, 3, 3);

        SweepingBlade.update(P315)
                .active("マークの付いていない対象の敵の方向に飛び込み一定距離({2})移動する。対象に{1}を与え{3}間マークを付与する。スキル使用時にスタックが増加し、1スタックごとに基礎ダメージが25%増加していく。(最大4スタックで{4})")
                .variable(1, MagicDamage, 70, 20, ap(0.6))
                .variable(2, Value, 475)
                .variable(3, Time, 10, -1)
                .variable(4, MagicDamage, 140, 40, ap(0.6))
                .cd(0.5, -0.1)
                .range(475);

        LastBreath.update(P315)
                .active("近くの空中にいる敵Championまで瞬時に移動して、対象と{1}にいる敵Championを1秒間空中に留めて{2}を与える。地面に着地すると、15秒間{3}を得る。")
                .variable(1, Radius, 400)
                .variable(2, PhysicalDamage, 200, 100, bounusAD(1.5))
                .variable(3, BounusARPenRatio, 50)
                .cd(80, -25)
                .range(1300)
                .update(P401)
                .active("Flowが最大となる。近くの空中にいる敵Championまで瞬時に移動して、対象と{1}にいる敵Championを1秒間空中に留めて{2}を与える。地面に着地すると、15秒間{3}を得る。")
                .update(P402)
                .range(1200);
    }

    private static void Yorick() {
        UnholyCovenant.update()
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、スロー無効化、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}")
                .variable(1, DamageReductionRatio, 0, 0, amplify(Stack, 5))
                .variable(2, AttackDamageRatio, 0, 0, amplify(Stack, 5))
                .variable(3, Value, 0, 0, amplify(Health, 0.35))
                .variable(4, Value, 0, 0, ad(0.35))
                .variable(5, Value, 10, 0, amplify(Lv, 2))
                .variable(6, Value, 20, 0, amplify(Lv, 2))
                .variable(7, Value, new Per5LevelForYoric(300, 40))
                .variable(8, Gold, 5)
                .update(P402)
                .passive("召喚中のGhoulの数に比例して{1}し{2}する。召喚したGhoulは5秒間持続し、毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。任意の操作不可、AoEスキルのダメージを50%低減し敵ユニットの通行を妨げない。<br>Health : {3}<br>AD : {4}<br>AR : {5}<br>MR : {6}<br>AS : 0.670<br>MS : {7}<br>Kill : {8}");

        OmenOfWar.update()
                .active("次の通常攻撃は{1}を与えると同時にSpectral Ghoulを召喚する。Spectral Ghoulは{3}を得る。Spectral Ghoulが生存している間、Ghoulと自身の{q2}する。")
                .variable(1, PhysicalDamage, 30, 30, ad(1.2))
                .variable(2, MSRatio, 15, 5)
                .variable(-3, AD, 8, 8)
                .mana(40)
                .cd(9, -1);
        OmenOfPestilence.update()
                .active("指定地点を爆発させ{1}の敵ユニットに{2}と1.5秒{3}を与え、同時にその地点にDecaying Ghoulを召喚する。Decaying Ghoulは近くの敵ユニットに継続的に{4}与える。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 60, 35, ap(1))
                .variable(3, MSSlowRatio, 20, 5)
                .variable(4, MSSlowRatio, 10, 2.5)
                .mana(55, 5)
                .cd(12)
                .range(600);
        OmenOfFamine.update()
                .active("対象の敵ユニットに{1}を与え、{2}し対象の背後にRavenous Ghoulを召喚する。Ravenous Ghoulが通常攻撃を行うたびに{3}する。敵Championを攻撃した場合は{4}する。")
                .variable(1, MagicDamage, 55, 30, bounusAD(1))
                .variable(2, RestoreHealth, 0, 0, amplify(DealtDamageRatio, 40))
                .variable(3, RestoreHealth, 0, 0, ad(0.175))
                .variable(4, RestoreHealth, 0, 0, ad(0.35))
                .mana(55, 5)
                .cd(10, -1)
                .range(550);
        OmenOfDeath.update()
                .active("対象の味方Champion一人の姿形を持ったRevenantを召喚する(ALT押しながら右クリックで任意の操作可能)。Revenantは10秒間持続し、対象の{1}の攻撃力を持つ。Revenantが生存している間に対象となった味方Championが死亡した場合、Revenantが消滅し、死亡した味方ChampionはHPとMNが最大の状態で蘇生される。蘇生した味方Championは10秒経過すると消滅する。")
                .variable(1, Percentage, 45, 15)
                .mana(100)
                .cd(120, -15)
                .range(900);
    }

    private static void Zac() {
        CellDivision.update()
                .passive("Zacのスキルが敵ユニットに命中する度に小型のスライムが出現する。スライム({5})を自身が回収すると{1}し、敵が回収すると消滅する。また、ZacのHealthが0になった時4つのスライムに分裂し一定時間かけて復活する。復活中にすべてのスライムが死亡するとZacも死亡する。復活時のHealthは生きているスライムの数に比例し増加(10-50%)する。スライムは以下のステータスを持つ。<br>Health : {2}<br>AR : {3}<br>MR : {4}")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.04))
                .variable(2, Value, 0, 0, amplify(Health, 0.12))
                .variable(3, Value, 0, 0, amplify(AR, 0.5))
                .variable(4, Value, 0, 0, amplify(MR, 0.5))
                .variable(5, Radius, 100)
                .cd(300)
                .update(P310)
                .variable(5, Radius, 25)
                .update(P403)
                .variable(5, Radius, 50);

        StretchingStrike.update()
                .active("指定方向に腕を伸ばし範囲内にいる敵ユニットに{1}と2秒間{2}を与える。")
                .variable(1, MagicDamage, 70, 40, ap(0.5))
                .variable(2, MSSlowRatio, 20, 5)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(9, -0.5)
                .range(550);

        UnstableMatter.update()
                .active("{1}にいる敵ユニットに{2}を与える。(Minionに対しては200DMが上限)")
                .variable(1, Radius, 350)
                .variable(2, MagicDamage, 40, 15, amplify(TargetMaxHealthRatio, 4, 1, ap(0.02)))
                .cost(CurrentHealthRatio, 4, 0)
                .cd(4);

        ElasticSlingshot.update()
                .active("発動するとZacがその場で停止しチャージを行う。チャージした時間に比例して射程が前方扇形範囲で徐々に増加する。再度使用で指定した地点にジャンプし、着地時に範囲内にいる敵ユニットに{1}と{2}を与える。チャージは移動を行う事でキャンセルできる。")
                .variable(1, MagicDamage, 80, 50, ap(0.7))
                .variable(2, Knockback)
                .cost(CurrentHealthRatio, 4, 0)
                .cd(24, -3)
                .range(1150, 100)
                .update(P310)
                .variable(1, MagicDamage, 80, 40, ap(0.7));

        LetsBounce.update()
                .active("Zacが4回飛び跳ね、その度に周囲にいる敵ユニットに{1}と{2}と1秒間{3}を与える。ノックバックは同一の対象に1度までしか発生せず、同一ユニットに複数回DMを与える場合、2回目以降は50%のダメージになる。このスキルが発動している間はUnstable Matterと移動のみが可能であり、また徐々に移動速度が増加する(20-50%増加)。使用中は{4}を得る。またこのスキル使用時に自身にかかっているスローを解除する。")
                .variable(1, MagicDamage, 160, 80, ap(0.25))
                .variable(2, Knockback)
                .variable(3, MSSlowRatio, 20)
                .variable(4, Tenacity, 75)
                .cd(130, -15)
                .range(300)
                .update(P307)
                .variable(1, MagicDamage, 140, 70, ap(0.4))
                .update(P310A)
                .active("Zacが4回飛び跳ね、その度に周囲にいる敵ユニットに{1}と{2}と1秒間{3}を与える。ノックバックは同一の対象に1度までしか発生せず、同一ユニットに複数回DMを与える場合、2回目以降は50%のダメージになる。このスキルが発動している間はUnstable Matterと移動のみが可能であり、また徐々に移動速度が増加する(20-50%増加)。またこのスキル使用時に自身にかかっているスローを解除する。");
    }

    private static void Zed() {
        ContemptforTheWeak.update()
                .passive("HPが50%以下の敵ユニットへの通常攻撃に{1}を付与する。同一の対象には10秒に一度しか発動しない。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, new Per6LevelForZed(6, 2)));
        RazorShuriken.update()
                .active("Zedと「影」から指定方向に貫通する手裏剣を飛ばし、当たった敵ユニットに{1}を与える。手裏剣は一度敵ユニットに当たるとそれ以降の敵ユニットには{3}を与える。Zedと「影」が同一の対象に手裏剣を命中させた場合、2発目以降は{2}を与える。")
                .variable(1, PhysicalDamage, 75, 35, bounusAD(1))
                .variable(2, PhysicalDamage, 37.5, 20, bounusAD(0.5))
                .variable(3, PhysicalDamage, 60, 32, bounusAD(0.8))
                .cost(Energy, 75, -5)
                .cd(6)
                .range(900);
        RazorShuriken.update(P303).variable(1, PhysicalDamage, 75, 40, bounusAD(1));
        RazorShuriken.update(P307).variable(3, PhysicalDamage, 45, 24, bounusAD(0.6));
        LivingShadow.update()
                .passive("{1}を得る。")
                .variable(1, AD, 0, 0, amplify(BounusAD, 0.05, 0.05))
                .active("Zedの「影」が指定方向にダッシュし({5})、4秒間その場に留まり{2}の{3}。再度このスキルを使用するとZedと「影」の位置が入れ替わる。「影」はZedが通常スキルを使用すると同時に同じスキルを使用する。この時スキルがZedのスキルと同一の敵ユニットに命中した場合、{4}する。回復効果はスキル1回毎に1度のみ発動する。")
                .variable(2, Radius, 1300)
                .variable(3, Visionable)
                .variable(4, RestoreEnergy, 20, 5)
                .variable(5, MissileSpeed, 2500)
                .cost(Energy, 40, -5)
                .cd(22, -1.5)
                .range(550);
        LivingShadow.update(P306).cd(18, -1);
        LivingShadow.update(P307).variable(2, Radius, 700);
        LivingShadow.update(P313).variable(5, MissileSpeed, 1500);
        ShadowSlash.update()
                .active("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵ユニットに当たる度にLiving ShadowのCDを1秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。")
                .variable(1, Radius, 290)
                .variable(2, PhysicalDamage, 60, 35, bounusAD(0.9))
                .variable(3, MSSlowRatio, 30, 7.5)
                .cost(Energy, 50, 0)
                .cd(3);
        ShadowSlash.update(P303).variable(2, PhysicalDamage, 60, 30, bounusAD(0.9));
        ShadowSlash.update(P306)
                .active("Zedと「影」から衝撃波を発生させ、{1}の敵ユニットに{2}を与える。ZedのShadow Slashは敵Championに当たる度にLiving ShadowのCDを2秒解消させる。「影」のShadow Slashはダメージと共に敵ユニットに1.5秒間{3}を与える。Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇する。");
        ShadowSlash.update(P307).cd(4);
        DeathMark.update()
                .active("対象の敵Championにダッシュしマークを付与する。ダッシュ中は0.35秒間ターゲット不可状態になる。また対象の背後に4秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1), amplify(DealtDamageRatio, 20, 15))
                .variable(2, Radius, 1100)
                .cd(120, -20)
                .range(625);
        DeathMark.update(P313)
                .active("対象の敵Championにダッシュしマークを付与する。ダッシュ中は0.75秒間ターゲット不可状態になる。また詠唱地点に6秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる({2})。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例し{1}を与える。")
                .variable(2, Radius, 2000);
    }

    private static void Ziggs() {
        ShortFuse.update()
                .passive("12秒毎に通常攻撃に追加{1}が付与される。Ziggsがスキルを使う度に{2}する。建物に対しては1.5倍のDMを与える。")
                .variable(1, MagicDamage, 13, 0, ap(0.35), amplify(Lv, 7))
                .variable(2, CDDecrease, 4)
                .update(P313)
                .variable(1, MagicDamage, new Per1Level(new double[] {20, 27, 34, 41, 48, 56, 64, 72, 80, 88, 96, 105,
                        114, 123, 132, 141, 150, 160}), ap(0.35), null)
                .update(P402)
                .variable(1, MagicDamage, new Per1Level(new double[] {20, 24, 28, 32, 36, 40, 48, 56, 64, 72, 80, 88,
                        100, 112, 124, 136, 148, 160}), amplify(AP, new Per6Level(0.25, 0.05)), null);

        BouncingBomb.update()
                .active("指定地点に跳ねながら転がる爆弾を投げ、爆発時に{1}の敵ユニットに{2}を与える。敵に当たらなかった場合には投げた方向に2回までバウンドする。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 75, 45, ap(0.65))
                .mana(50, 10)
                .cd(6, -0.5)
                .range(850);
        SatchelCharge.update()
                .active("指定地点に{6}で火薬を投げ、爆発時に{1}の敵ユニットに{2}を与え、{3}させる。Ziggsが範囲内にいた場合は自分も{3}する(Ziggsにダメージは無し)。火薬は4秒経つか、スキルを再度使用すると爆発する。また火薬は{5}。")
                .variable(1, Radius, 275)
                .variable(2, MagicDamage, 70, 35, ap(0.35))
                .variable(3, Knockback, 350)
                .variable(5, Visionable)
                .variable(6, MissileSpeed, 1600)
                .mana(65)
                .cd(26, -2)
                .range(1000);
        SatchelCharge.update(P309).variable(6, MissileSpeed, 1750).variable(3, Knockback, 400);
        SatchelCharge.update(P313).variable(1, Radius, 325);
        HexplosiveMinefield.update()
                .active("指定地点の{4}に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れる({5})と{1}と1.5秒間{2}を与える。ミニオン以外の同ユニットが2個目以降に踏むと{3}を与える。地雷は爆発するか10秒経つと消滅する。")
                .variable(1, MagicDamage, 40, 25, ap(0.3))
                .variable(2, MSSlowRatio, 20, 5)
                .variable(3, MagicDamage, 16, 10, ap(0.12))
                .variable(4, Radius, 400)
                .variable(5, Radius, 135)
                .mana(70, 10)
                .cd(16)
                .range(900)
                .update(P313)
                .variable(5, Radius, 150)
                .update(P402)
                .active("指定地点の{4}に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れる({5})と{1}と1.5秒間{2}を与える。同ユニットが2個目以降に踏むと{3}を与える。地雷は爆発するか10秒経つと消滅する。");

        MegaInfernoBomb.update()
                .active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 250, 125, ap(0.9))
                .variable(3, Radius, 750)
                .variable(4, MagicDamage, 200, 100, ap(0.72))
                .mana(100)
                .cd(120, -15)
                .range(5300);
        MegaInfernoBomb.update(P313)
                .active("指定地点に巨大な爆弾を投下し、{1}の敵ユニットに{2}を与え、{3}の敵ユニットに{4}を与える。ミニオンやモンスターには2倍のダメージを与える。");
    }

    private static void Zyra() {
        RiseOfTheThorns.update()
                .passive("死亡すると2秒後にその場で植物に変形し、指定方向に一度だけ貫通する光線を放つことができる。光線に当たった敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 80, 0, amplify(Lv, 20))
                .range(1500);
        DeadlyBloom.update()
                .active("地面から棘を出現させ、指定範囲内の敵ユニットに{1}を与える。種にHitした場合Thorn Spitterに成長し、{3}の敵を自動攻撃して{2}を与える。Thorn Spitterは10秒間持続する。")
                .variable(1, MagicDamage, 75, 40, ap(0.6))
                .variable(2, MagicDamage, 26, 0, amplify(Lv, 6), ap(0.2))
                .variable(3, Radius, 650)
                .mana(75, 5)
                .cd(7, -0.5)
                .range(825);
        DeadlyBloom.update(P313)
                .variable(1, MagicDamage, 70, 35, ap(0.65))
                .variable(2, MagicDamage, 23, 0, amplify(Lv, 6.5), ap(0.2))
                .range(800);
        RampantGrowth.update()
                .passive("{1}を得る。")
                .variable(1, CDR, 4, 4)
                .active("指定地点に30秒持続する種を植える。他のスキルを種に当てることで成長させることができる。敵Championが種を踏んだ場合、視界を2秒間得る。{2}毎にチャージが1つ増加し最大2つまでチャージされる。種が植物に成長し、同一ユニットに複数の植物がDMを与える場合、2体目以降は50%のダメージを与える。")
                .variable(2, CDRAwareTime, 17, -1)
                .range(825)
                .cost(Charge, 1, 0);
        RampantGrowth.update(P313).variable(1, CDR, 2, 2);
        GraspingRoots.update()
                .active("指定方向に蔓を放ち、当たった全ての敵ユニットに{1}と{2}を与える。種にHitした場合Vine Lasherに成長し、{3}の敵を自動攻撃して{4}と2秒間{5}を与える。Vine Lasherは10秒間持続する。")
                .variable(1, MagicDamage, 60, 35, ap(0.5))
                .variable(2, Snare, 0.75, 0.25)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 26, 0, amplify(Lv, 6), ap(0.2))
                .variable(5, MSSlowRatio, 30)
                .mana(70, 5)
                .cd(14, -1)
                .range(1100);
        GraspingRoots.update(P313).variable(4, MagicDamage, 23, 0, amplify(Lv, 6.5), ap(0.2));
        Stranglethorns.update()
                .active("指定地点に藪を召還し、{1}の全ての敵に{2}を与え、2秒後に{3}。成長した植物にHitした場合、その植物の攻撃速度が50%増加する。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 180, 85, ap(0.75))
                .variable(3, Knockup, 0)
                .mana(100, 20)
                .cd(130, -10)
                .range(700);
    }
}
