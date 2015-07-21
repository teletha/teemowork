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

import teemowork.model.Skill;
import teemowork.model.Describable;
import teemowork.model.SkillDescriptor;

public abstract class RiotSkillData extends Describable<SkillDescriptor> {

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
    public static final Skill AceInTheHole = new Skill(RiotChampionData.Caitlyn, 4);

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
    public static final Skill GloryInDeath = new Skill(RiotChampionData.Sion, 0);

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
}
