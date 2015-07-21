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


public class RiotSkillData {

    /** Blood Well Definition */
    public static final RiotSkillData BloodWell = new RiotSkillData(RiotChampionData.Aatrox, 0);

    /** Dark Flight Definition */
    public static final RiotSkillData DarkFlight = new RiotSkillData(RiotChampionData.Aatrox, 1);

    /** Blood Thirst / Blood Price Definition */
    public static final RiotSkillData BloodThirstBloodPrice = new RiotSkillData(RiotChampionData.Aatrox, 2);

    /** Blades of Torment Definition */
    public static final RiotSkillData BladesOfTorment = new RiotSkillData(RiotChampionData.Aatrox, 3);

    /** Massacre Definition */
    public static final RiotSkillData Massacre = new RiotSkillData(RiotChampionData.Aatrox, 4);

    /** Essence Theft Definition */
    public static final RiotSkillData EssenceTheft = new RiotSkillData(RiotChampionData.Ahri, 0);

    /** Orb of Deception Definition */
    public static final RiotSkillData OrbOfDeception = new RiotSkillData(RiotChampionData.Ahri, 1);

    /** Fox-Fire Definition */
    public static final RiotSkillData FoxFire = new RiotSkillData(RiotChampionData.Ahri, 2);

    /** Charm Definition */
    public static final RiotSkillData Charm = new RiotSkillData(RiotChampionData.Ahri, 3);

    /** Spirit Rush Definition */
    public static final RiotSkillData SpiritRush = new RiotSkillData(RiotChampionData.Ahri, 4);

    /** Twin Disciplines Definition */
    public static final RiotSkillData TwinDisciplines = new RiotSkillData(RiotChampionData.Akali, 0);

    /** Mark of the Assassin Definition */
    public static final RiotSkillData MarkOfTheAssassin = new RiotSkillData(RiotChampionData.Akali, 1);

    /** Twilight Shroud Definition */
    public static final RiotSkillData TwilightShroud = new RiotSkillData(RiotChampionData.Akali, 2);

    /** Crescent Slash Definition */
    public static final RiotSkillData CrescentSlash = new RiotSkillData(RiotChampionData.Akali, 3);

    /** Shadow Dance Definition */
    public static final RiotSkillData ShadowDance = new RiotSkillData(RiotChampionData.Akali, 4);

    /** Trample Definition */
    public static final RiotSkillData Trample = new RiotSkillData(RiotChampionData.Alistar, 0);

    /** Pulverize Definition */
    public static final RiotSkillData Pulverize = new RiotSkillData(RiotChampionData.Alistar, 1);

    /** Headbutt Definition */
    public static final RiotSkillData Headbutt = new RiotSkillData(RiotChampionData.Alistar, 2);

    /** Triumphant Roar Definition */
    public static final RiotSkillData TriumphantRoar = new RiotSkillData(RiotChampionData.Alistar, 3);

    /** Unbreakable Will Definition */
    public static final RiotSkillData UnbreakableWill = new RiotSkillData(RiotChampionData.Alistar, 4);

    /** Cursed Touch Definition */
    public static final RiotSkillData CursedTouch = new RiotSkillData(RiotChampionData.Amumu, 0);

    /** Bandage Toss Definition */
    public static final RiotSkillData BandageToss = new RiotSkillData(RiotChampionData.Amumu, 1);

    /** Despair Definition */
    public static final RiotSkillData Despair = new RiotSkillData(RiotChampionData.Amumu, 2);

    /** Tantrum Definition */
    public static final RiotSkillData Tantrum = new RiotSkillData(RiotChampionData.Amumu, 3);

    /** Curse of the Sad Mummy Definition */
    public static final RiotSkillData CurseOfTheSadMummy = new RiotSkillData(RiotChampionData.Amumu, 4);

    /** Rebirth Definition */
    public static final RiotSkillData Rebirth = new RiotSkillData(RiotChampionData.Anivia, 0);

    /** Flash Frost Definition */
    public static final RiotSkillData FlashFrost = new RiotSkillData(RiotChampionData.Anivia, 1);

    /** Crystallize Definition */
    public static final RiotSkillData Crystallize = new RiotSkillData(RiotChampionData.Anivia, 2);

    /** Frostbite Definition */
    public static final RiotSkillData Frostbite = new RiotSkillData(RiotChampionData.Anivia, 3);

    /** Glacial Storm Definition */
    public static final RiotSkillData GlacialStorm = new RiotSkillData(RiotChampionData.Anivia, 4);

    /** Pyromania Definition */
    public static final RiotSkillData Pyromania = new RiotSkillData(RiotChampionData.Annie, 0);

    /** Disintegrate Definition */
    public static final RiotSkillData Disintegrate = new RiotSkillData(RiotChampionData.Annie, 1);

    /** Incinerate Definition */
    public static final RiotSkillData Incinerate = new RiotSkillData(RiotChampionData.Annie, 2);

    /** Molten Shield Definition */
    public static final RiotSkillData MoltenShield = new RiotSkillData(RiotChampionData.Annie, 3);

    /** Summon: Tibbers Definition */
    public static final RiotSkillData SummonTibbers = new RiotSkillData(RiotChampionData.Annie, 4);

    /** Frost Shot Definition */
    public static final RiotSkillData FrostShot = new RiotSkillData(RiotChampionData.Ashe, 0);

    /** Ranger's Focus Definition */
    public static final RiotSkillData RangersFocus = new RiotSkillData(RiotChampionData.Ashe, 1);

    /** Volley Definition */
    public static final RiotSkillData Volley = new RiotSkillData(RiotChampionData.Ashe, 2);

    /** Hawkshot Definition */
    public static final RiotSkillData Hawkshot = new RiotSkillData(RiotChampionData.Ashe, 3);

    /** Enchanted Crystal Arrow Definition */
    public static final RiotSkillData EnchantedCrystalArrow = new RiotSkillData(RiotChampionData.Ashe, 4);

    /** Shurima's Legacy Definition */
    public static final RiotSkillData ShurimasLegacy = new RiotSkillData(RiotChampionData.Azir, 0);

    /** Conquering Sands Definition */
    public static final RiotSkillData ConqueringSands = new RiotSkillData(RiotChampionData.Azir, 1);

    /** Arise! Definition */
    public static final RiotSkillData Arise = new RiotSkillData(RiotChampionData.Azir, 2);

    /** Shifting Sands Definition */
    public static final RiotSkillData ShiftingSands = new RiotSkillData(RiotChampionData.Azir, 3);

    /** Emperor's Divide Definition */
    public static final RiotSkillData EmperorsDivide = new RiotSkillData(RiotChampionData.Azir, 4);

    /** Traveler's Call Definition */
    public static final RiotSkillData TravelersCall = new RiotSkillData(RiotChampionData.Bard, 0);

    /** Cosmic Binding Definition */
    public static final RiotSkillData CosmicBinding = new RiotSkillData(RiotChampionData.Bard, 1);

    /** Caretaker's Shrine Definition */
    public static final RiotSkillData CaretakersShrine = new RiotSkillData(RiotChampionData.Bard, 2);

    /** Magical Journey Definition */
    public static final RiotSkillData MagicalJourney = new RiotSkillData(RiotChampionData.Bard, 3);

    /** Tempered Fate Definition */
    public static final RiotSkillData TemperedFate = new RiotSkillData(RiotChampionData.Bard, 4);

    /** Mana Barrier Definition */
    public static final RiotSkillData ManaBarrier = new RiotSkillData(RiotChampionData.Blitzcrank, 0);

    /** Rocket Grab Definition */
    public static final RiotSkillData RocketGrab = new RiotSkillData(RiotChampionData.Blitzcrank, 1);

    /** Overdrive Definition */
    public static final RiotSkillData Overdrive = new RiotSkillData(RiotChampionData.Blitzcrank, 2);

    /** Power Fist Definition */
    public static final RiotSkillData PowerFist = new RiotSkillData(RiotChampionData.Blitzcrank, 3);

    /** Static Field Definition */
    public static final RiotSkillData StaticField = new RiotSkillData(RiotChampionData.Blitzcrank, 4);

    /** Blaze Definition */
    public static final RiotSkillData Blaze = new RiotSkillData(RiotChampionData.Brand, 0);

    /** Sear Definition */
    public static final RiotSkillData Sear = new RiotSkillData(RiotChampionData.Brand, 1);

    /** Pillar of Flame Definition */
    public static final RiotSkillData PillarOfFlame = new RiotSkillData(RiotChampionData.Brand, 2);

    /** Conflagration Definition */
    public static final RiotSkillData Conflagration = new RiotSkillData(RiotChampionData.Brand, 3);

    /** Pyroclasm Definition */
    public static final RiotSkillData Pyroclasm = new RiotSkillData(RiotChampionData.Brand, 4);

    /** Concussive Blows Definition */
    public static final RiotSkillData ConcussiveBlows = new RiotSkillData(RiotChampionData.Braum, 0);

    /** Winter's Bite Definition */
    public static final RiotSkillData WintersBite = new RiotSkillData(RiotChampionData.Braum, 1);

    /** Stand Behind Me Definition */
    public static final RiotSkillData StandBehindMe = new RiotSkillData(RiotChampionData.Braum, 2);

    /** Unbreakable Definition */
    public static final RiotSkillData Unbreakable = new RiotSkillData(RiotChampionData.Braum, 3);

    /** Glacial Fissure Definition */
    public static final RiotSkillData GlacialFissure = new RiotSkillData(RiotChampionData.Braum, 4);

    /** Headshot Definition */
    public static final RiotSkillData Headshot = new RiotSkillData(RiotChampionData.Caitlyn, 0);

    /** Piltover Peacemaker Definition */
    public static final RiotSkillData PiltoverPeacemaker = new RiotSkillData(RiotChampionData.Caitlyn, 1);

    /** Yordle Snap Trap Definition */
    public static final RiotSkillData YordleSnapTrap = new RiotSkillData(RiotChampionData.Caitlyn, 2);

    /** 90 Caliber Net Definition */
    public static final RiotSkillData CaliberNet = new RiotSkillData(RiotChampionData.Caitlyn, 3);

    /** Ace in the Hole Definition */
    public static final RiotSkillData AceinTheHole = new RiotSkillData(RiotChampionData.Caitlyn, 4);

    /** Aspect of the Serpent Definition */
    public static final RiotSkillData AspectOfTheSerpent = new RiotSkillData(RiotChampionData.Cassiopeia, 0);

    /** Noxious Blast Definition */
    public static final RiotSkillData NoxiousBlast = new RiotSkillData(RiotChampionData.Cassiopeia, 1);

    /** Miasma Definition */
    public static final RiotSkillData Miasma = new RiotSkillData(RiotChampionData.Cassiopeia, 2);

    /** Twin Fang Definition */
    public static final RiotSkillData TwinFang = new RiotSkillData(RiotChampionData.Cassiopeia, 3);

    /** Petrifying Gaze Definition */
    public static final RiotSkillData PetrifyingGaze = new RiotSkillData(RiotChampionData.Cassiopeia, 4);

    /** Carnivore Definition */
    public static final RiotSkillData Carnivore = new RiotSkillData(RiotChampionData.Chogath, 0);

    /** Rupture Definition */
    public static final RiotSkillData Rupture = new RiotSkillData(RiotChampionData.Chogath, 1);

    /** Feral Scream Definition */
    public static final RiotSkillData FeralScream = new RiotSkillData(RiotChampionData.Chogath, 2);

    /** Vorpal Spikes Definition */
    public static final RiotSkillData VorpalSpikes = new RiotSkillData(RiotChampionData.Chogath, 3);

    /** Feast Definition */
    public static final RiotSkillData Feast = new RiotSkillData(RiotChampionData.Chogath, 4);

    /** Hextech Shrapnel Shells Definition */
    public static final RiotSkillData HextechShrapnelShells = new RiotSkillData(RiotChampionData.Corki, 0);

    /** Phosphorus Bomb Definition */
    public static final RiotSkillData PhosphorusBomb = new RiotSkillData(RiotChampionData.Corki, 1);

    /** Valkyrie Definition */
    public static final RiotSkillData Valkyrie = new RiotSkillData(RiotChampionData.Corki, 2);

    /** Gatling Gun Definition */
    public static final RiotSkillData GatlingGun = new RiotSkillData(RiotChampionData.Corki, 3);

    /** Missile Barrage Definition */
    public static final RiotSkillData MissileBarrage = new RiotSkillData(RiotChampionData.Corki, 4);

    /** Hemorrhage Definition */
    public static final RiotSkillData Hemorrhage = new RiotSkillData(RiotChampionData.Darius, 0);

    /** Decimate Definition */
    public static final RiotSkillData Decimate = new RiotSkillData(RiotChampionData.Darius, 1);

    /** Crippling Strike Definition */
    public static final RiotSkillData CripplingStrike = new RiotSkillData(RiotChampionData.Darius, 2);

    /** Apprehend Definition */
    public static final RiotSkillData Apprehend = new RiotSkillData(RiotChampionData.Darius, 3);

    /** Noxian Guillotine Definition */
    public static final RiotSkillData NoxianGuillotine = new RiotSkillData(RiotChampionData.Darius, 4);

    /** Moonsilver Blade Definition */
    public static final RiotSkillData MoonsilverBlade = new RiotSkillData(RiotChampionData.Diana, 0);

    /** Crescent Strike Definition */
    public static final RiotSkillData CrescentStrike = new RiotSkillData(RiotChampionData.Diana, 1);

    /** Pale Cascade Definition */
    public static final RiotSkillData PaleCascade = new RiotSkillData(RiotChampionData.Diana, 2);

    /** Moonfall Definition */
    public static final RiotSkillData Moonfall = new RiotSkillData(RiotChampionData.Diana, 3);

    /** Lunar Rush Definition */
    public static final RiotSkillData LunarRush = new RiotSkillData(RiotChampionData.Diana, 4);

    /** League of Draven Definition */
    public static final RiotSkillData LeagueOfDraven = new RiotSkillData(RiotChampionData.Draven, 0);

    /** Spinning Axe Definition */
    public static final RiotSkillData SpinningAxe = new RiotSkillData(RiotChampionData.Draven, 1);

    /** Blood Rush Definition */
    public static final RiotSkillData BloodRush = new RiotSkillData(RiotChampionData.Draven, 2);

    /** Stand Aside Definition */
    public static final RiotSkillData StandAside = new RiotSkillData(RiotChampionData.Draven, 3);

    /** Whirling Death Definition */
    public static final RiotSkillData WhirlingDeath = new RiotSkillData(RiotChampionData.Draven, 4);

    /** Adrenaline Rush Definition */
    public static final RiotSkillData AdrenalineRush = new RiotSkillData(RiotChampionData.DrMundo, 0);

    /** Infected Cleaver Definition */
    public static final RiotSkillData InfectedCleaver = new RiotSkillData(RiotChampionData.DrMundo, 1);

    /** Burning Agony Definition */
    public static final RiotSkillData BurningAgony = new RiotSkillData(RiotChampionData.DrMundo, 2);

    /** Masochism Definition */
    public static final RiotSkillData Masochism = new RiotSkillData(RiotChampionData.DrMundo, 3);

    /** Sadism Definition */
    public static final RiotSkillData Sadism = new RiotSkillData(RiotChampionData.DrMundo, 4);

    /** Z-Drive Resonance Definition */
    public static final RiotSkillData ZDriveResonance = new RiotSkillData(RiotChampionData.Ekko, 0);

    /** Timewinder Definition */
    public static final RiotSkillData Timewinder = new RiotSkillData(RiotChampionData.Ekko, 1);

    /** Parallel Convergence Definition */
    public static final RiotSkillData ParallelConvergence = new RiotSkillData(RiotChampionData.Ekko, 2);

    /** Phase Dive Definition */
    public static final RiotSkillData PhaseDive = new RiotSkillData(RiotChampionData.Ekko, 3);

    /** Chronobreak Definition */
    public static final RiotSkillData Chronobreak = new RiotSkillData(RiotChampionData.Ekko, 4);

    /** Spider Queen Definition */
    public static final RiotSkillData SpiderQueen = new RiotSkillData(RiotChampionData.Elise, 0);

    /** Neurotoxin / Venomous Bite Definition */
    public static final RiotSkillData NeurotoxinVenomousBite = new RiotSkillData(RiotChampionData.Elise, 1);

    /** Volatile Spiderling / Skittering Frenzy Definition */
    public static final RiotSkillData VolatileSpiderlingSkitteringFrenzy = new RiotSkillData(RiotChampionData.Elise, 2);

    /** Cocoon / Rappel Definition */
    public static final RiotSkillData CocoonRappel = new RiotSkillData(RiotChampionData.Elise, 3);

    /** Spider Form Definition */
    public static final RiotSkillData SpiderForm = new RiotSkillData(RiotChampionData.Elise, 4);

    /** Venomous Bite / Neurotoxin Definition */
    public static final RiotSkillData VenomousBiteNeurotoxin = new RiotSkillData(RiotChampionData.Elise, 5);

    /** Skittering Frenzy / Volatile Spiderling Definition */
    public static final RiotSkillData SkitteringFrenzyVolatileSpiderling = new RiotSkillData(RiotChampionData.Elise, 6);

    /** Rappel / Cocoon Definition */
    public static final RiotSkillData RappelCocoon = new RiotSkillData(RiotChampionData.Elise, 7);

    /** Human Form Definition */
    public static final RiotSkillData HumanForm = new RiotSkillData(RiotChampionData.Elise, 8);

    /** Shadow Walk Definition */
    public static final RiotSkillData ShadowWalk = new RiotSkillData(RiotChampionData.Evelynn, 0);

    /** Hate Spike Definition */
    public static final RiotSkillData HateSpike = new RiotSkillData(RiotChampionData.Evelynn, 1);

    /** Dark Frenzy Definition */
    public static final RiotSkillData DarkFrenzy = new RiotSkillData(RiotChampionData.Evelynn, 2);

    /** Ravage Definition */
    public static final RiotSkillData Ravage = new RiotSkillData(RiotChampionData.Evelynn, 3);

    /** Agony's Embrace Definition */
    public static final RiotSkillData AgonysEmbrace = new RiotSkillData(RiotChampionData.Evelynn, 4);

    /** Rising Spell Force Definition */
    public static final RiotSkillData RisingSpellForce = new RiotSkillData(RiotChampionData.Ezreal, 0);

    /** Mystic Shot Definition */
    public static final RiotSkillData MysticShot = new RiotSkillData(RiotChampionData.Ezreal, 1);

    /** Essence Flux Definition */
    public static final RiotSkillData EssenceFlux = new RiotSkillData(RiotChampionData.Ezreal, 2);

    /** Arcane Shift Definition */
    public static final RiotSkillData ArcaneShift = new RiotSkillData(RiotChampionData.Ezreal, 3);

    /** Trueshot Barrage Definition */
    public static final RiotSkillData TrueshotBarrage = new RiotSkillData(RiotChampionData.Ezreal, 4);

    /** Dread Definition */
    public static final RiotSkillData Dread = new RiotSkillData(RiotChampionData.FiddleSticks, 0);

    /** Terrify Definition */
    public static final RiotSkillData Terrify = new RiotSkillData(RiotChampionData.FiddleSticks, 1);

    /** Drain Definition */
    public static final RiotSkillData Drain = new RiotSkillData(RiotChampionData.FiddleSticks, 2);

    /** Dark Wind Definition */
    public static final RiotSkillData DarkWind = new RiotSkillData(RiotChampionData.FiddleSticks, 3);

    /** Crowstorm Definition */
    public static final RiotSkillData Crowstorm = new RiotSkillData(RiotChampionData.FiddleSticks, 4);

    /** Duelist Definition */
    public static final RiotSkillData Duelist = new RiotSkillData(RiotChampionData.Fiora, 0);

    /** Lunge Definition */
    public static final RiotSkillData Lunge = new RiotSkillData(RiotChampionData.Fiora, 1);

    /** Riposte Definition */
    public static final RiotSkillData Riposte = new RiotSkillData(RiotChampionData.Fiora, 2);

    /** Burst of Speed Definition */
    public static final RiotSkillData BurstOfSpeed = new RiotSkillData(RiotChampionData.Fiora, 3);

    /** Blade Waltz Definition */
    public static final RiotSkillData BladeWaltz = new RiotSkillData(RiotChampionData.Fiora, 4);

    /** Nimble Fighter Definition */
    public static final RiotSkillData NimbleFighter = new RiotSkillData(RiotChampionData.Fizz, 0);

    /** Urchin Strike Definition */
    public static final RiotSkillData UrchinStrike = new RiotSkillData(RiotChampionData.Fizz, 1);

    /** Seastone Trident Definition */
    public static final RiotSkillData SeastoneTrident = new RiotSkillData(RiotChampionData.Fizz, 2);

    /** Playful / Trickster Definition */
    public static final RiotSkillData PlayfulTrickster = new RiotSkillData(RiotChampionData.Fizz, 3);

    /** Chum the Waters Definition */
    public static final RiotSkillData ChumTheWaters = new RiotSkillData(RiotChampionData.Fizz, 4);

    /** Runic Skin Definition */
    public static final RiotSkillData RunicSkin = new RiotSkillData(RiotChampionData.Galio, 0);

    /** Resolute Smite Definition */
    public static final RiotSkillData ResoluteSmite = new RiotSkillData(RiotChampionData.Galio, 1);

    /** Bulwark Definition */
    public static final RiotSkillData Bulwark = new RiotSkillData(RiotChampionData.Galio, 2);

    /** Righteous Gust Definition */
    public static final RiotSkillData RighteousGust = new RiotSkillData(RiotChampionData.Galio, 3);

    /** Idol of Durand Definition */
    public static final RiotSkillData IdolOfDurand = new RiotSkillData(RiotChampionData.Galio, 4);

    /** Grog-Soaked Blade Definition */
    public static final RiotSkillData GrogSoakedBlade = new RiotSkillData(RiotChampionData.Gangplank, 0);

    /** Parrrley Definition */
    public static final RiotSkillData Parrrley = new RiotSkillData(RiotChampionData.Gangplank, 1);

    /** Remove Scurvy Definition */
    public static final RiotSkillData RemoveScurvy = new RiotSkillData(RiotChampionData.Gangplank, 2);

    /** Raise Morale Definition */
    public static final RiotSkillData RaiseMorale = new RiotSkillData(RiotChampionData.Gangplank, 3);

    /** Cannon Barrage Definition */
    public static final RiotSkillData CannonBarrage = new RiotSkillData(RiotChampionData.Gangplank, 4);

    /** Perseverance Definition */
    public static final RiotSkillData Perseverance = new RiotSkillData(RiotChampionData.Garen, 0);

    /** Decisive Strike Definition */
    public static final RiotSkillData DecisiveStrike = new RiotSkillData(RiotChampionData.Garen, 1);

    /** Courage Definition */
    public static final RiotSkillData Courage = new RiotSkillData(RiotChampionData.Garen, 2);

    /** Judgment Definition */
    public static final RiotSkillData Judgment = new RiotSkillData(RiotChampionData.Garen, 3);

    /** Demacian Justice Definition */
    public static final RiotSkillData DemacianJustice = new RiotSkillData(RiotChampionData.Garen, 4);

    /** Rage Gene Definition */
    public static final RiotSkillData RageGene = new RiotSkillData(RiotChampionData.Gnar, 0);

    /** Boomerang Throw / Boulder Toss Definition */
    public static final RiotSkillData BoomerangThrowBoulderToss = new RiotSkillData(RiotChampionData.Gnar, 1);

    /** Hyper / Wallop Definition */
    public static final RiotSkillData HyperWallop = new RiotSkillData(RiotChampionData.Gnar, 2);

    /** Hop / Crunch Definition */
    public static final RiotSkillData HopCrunch = new RiotSkillData(RiotChampionData.Gnar, 3);

    /** GNAR! Definition */
    public static final RiotSkillData GNAR = new RiotSkillData(RiotChampionData.Gnar, 4);

    /** Happy Hour Definition */
    public static final RiotSkillData HappyHour = new RiotSkillData(RiotChampionData.Gragas, 0);

    /** Barrel Roll Definition */
    public static final RiotSkillData BarrelRoll = new RiotSkillData(RiotChampionData.Gragas, 1);

    /** Drunken Rage Definition */
    public static final RiotSkillData DrunkenRage = new RiotSkillData(RiotChampionData.Gragas, 2);

    /** Body Slam Definition */
    public static final RiotSkillData BodySlam = new RiotSkillData(RiotChampionData.Gragas, 3);

    /** Explosive Cask Definition */
    public static final RiotSkillData ExplosiveCask = new RiotSkillData(RiotChampionData.Gragas, 4);

    /** True Grit Definition */
    public static final RiotSkillData TrueGrit = new RiotSkillData(RiotChampionData.Graves, 0);

    /** Buckshot Definition */
    public static final RiotSkillData Buckshot = new RiotSkillData(RiotChampionData.Graves, 1);

    /** Smoke Screen Definition */
    public static final RiotSkillData SmokeScreen = new RiotSkillData(RiotChampionData.Graves, 2);

    /** Quickdraw Definition */
    public static final RiotSkillData Quickdraw = new RiotSkillData(RiotChampionData.Graves, 3);

    /** Collateral Damage Definition */
    public static final RiotSkillData CollateralDamage = new RiotSkillData(RiotChampionData.Graves, 4);

    /** Warpath Definition */
    public static final RiotSkillData Warpath = new RiotSkillData(RiotChampionData.Hecarim, 0);

    /** Rampage Definition */
    public static final RiotSkillData Rampage = new RiotSkillData(RiotChampionData.Hecarim, 1);

    /** Spirit of Dread Definition */
    public static final RiotSkillData SpiritOfDread = new RiotSkillData(RiotChampionData.Hecarim, 2);

    /** Devastating Charge Definition */
    public static final RiotSkillData DevastatingCharge = new RiotSkillData(RiotChampionData.Hecarim, 3);

    /** Onslaught of Shadows Definition */
    public static final RiotSkillData OnslaughtOfShadows = new RiotSkillData(RiotChampionData.Hecarim, 4);

    /** Techmaturgical Repair Bots Definition */
    public static final RiotSkillData TechmaturgicalRepairBots = new RiotSkillData(RiotChampionData.Heimerdinger, 0);

    /** H-28G Evolution Turret Definition */
    public static final RiotSkillData H28GEvolutionTurret = new RiotSkillData(RiotChampionData.Heimerdinger, 1);

    /** Hextech Micro-Rockets Definition */
    public static final RiotSkillData HextechMicroRockets = new RiotSkillData(RiotChampionData.Heimerdinger, 2);

    /** CH-2 Electron Storm Grenade Definition */
    public static final RiotSkillData CH2ElectronStormGrenade = new RiotSkillData(RiotChampionData.Heimerdinger, 3);

    /** UPGRADE!!! Definition */
    public static final RiotSkillData UPGRADE = new RiotSkillData(RiotChampionData.Heimerdinger, 4);

    /** Ionian Fervor Definition */
    public static final RiotSkillData IonianFervor = new RiotSkillData(RiotChampionData.Irelia, 0);

    /** Bladesurge Definition */
    public static final RiotSkillData Bladesurge = new RiotSkillData(RiotChampionData.Irelia, 1);

    /** Hiten Style Definition */
    public static final RiotSkillData HitenStyle = new RiotSkillData(RiotChampionData.Irelia, 2);

    /** Equilibrium Strike Definition */
    public static final RiotSkillData EquilibriumStrike = new RiotSkillData(RiotChampionData.Irelia, 3);

    /** Transcendent Blades Definition */
    public static final RiotSkillData TranscendentBlades = new RiotSkillData(RiotChampionData.Irelia, 4);

    /** Tailwind Definition */
    public static final RiotSkillData Tailwind = new RiotSkillData(RiotChampionData.Janna, 0);

    /** Howling Gale Definition */
    public static final RiotSkillData HowlingGale = new RiotSkillData(RiotChampionData.Janna, 1);

    /** Zephyr Definition */
    public static final RiotSkillData Zephyr = new RiotSkillData(RiotChampionData.Janna, 2);

    /** Eye Of The Storm Definition */
    public static final RiotSkillData EyeOfTheStorm = new RiotSkillData(RiotChampionData.Janna, 3);

    /** Monsoon Definition */
    public static final RiotSkillData Monsoon = new RiotSkillData(RiotChampionData.Janna, 4);

    /** Martial Cadence Definition */
    public static final RiotSkillData MartialCadence = new RiotSkillData(RiotChampionData.JarvanIV, 0);

    /** Dragon Strike Definition */
    public static final RiotSkillData DragonStrike = new RiotSkillData(RiotChampionData.JarvanIV, 1);

    /** Golden Aegis Definition */
    public static final RiotSkillData GoldenAegis = new RiotSkillData(RiotChampionData.JarvanIV, 2);

    /** Demacian Standard Definition */
    public static final RiotSkillData DemacianStandard = new RiotSkillData(RiotChampionData.JarvanIV, 3);

    /** Cataclysm Definition */
    public static final RiotSkillData Cataclysm = new RiotSkillData(RiotChampionData.JarvanIV, 4);

    /** Relentless Assault Definition */
    public static final RiotSkillData RelentlessAssault = new RiotSkillData(RiotChampionData.Jax, 0);

    /** Leap Strike Definition */
    public static final RiotSkillData LeapStrike = new RiotSkillData(RiotChampionData.Jax, 1);

    /** Empower Definition */
    public static final RiotSkillData Empower = new RiotSkillData(RiotChampionData.Jax, 2);

    /** Counter Strike Definition */
    public static final RiotSkillData CounterStrike = new RiotSkillData(RiotChampionData.Jax, 3);

    /** Grandmaster's Might Definition */
    public static final RiotSkillData GrandmastersMight = new RiotSkillData(RiotChampionData.Jax, 4);

    /** Hextech Capacitor Definition */
    public static final RiotSkillData HextechCapacitor = new RiotSkillData(RiotChampionData.Jayce, 0);

    /** To the Skies! / Shock Blast Definition */
    public static final RiotSkillData ToTheSkiesShockBlast = new RiotSkillData(RiotChampionData.Jayce, 1);

    /** Lightning Field / Hyper Charge Definition */
    public static final RiotSkillData LightningFieldHyperCharge = new RiotSkillData(RiotChampionData.Jayce, 2);

    /** Thundering Blow / Acceleration Gate Definition */
    public static final RiotSkillData ThunderingBlowAccelerationGate = new RiotSkillData(RiotChampionData.Jayce, 3);

    /** Mercury Cannon / Mercury Hammer Definition */
    public static final RiotSkillData MercuryCannonMercuryHammer = new RiotSkillData(RiotChampionData.Jayce, 4);

    /** Shock Blast Definition */
    public static final RiotSkillData ShockBlast = new RiotSkillData(RiotChampionData.Jayce, 5);

    /** Hyper Charge Definition */
    public static final RiotSkillData HyperCharge = new RiotSkillData(RiotChampionData.Jayce, 6);

    /** Acceleration Gate Definition */
    public static final RiotSkillData AccelerationGate = new RiotSkillData(RiotChampionData.Jayce, 7);

    /** Mercury Hammer Definition */
    public static final RiotSkillData MercuryHammer = new RiotSkillData(RiotChampionData.Jayce, 8);

    /** Get Excited! Definition */
    public static final RiotSkillData GetExcited = new RiotSkillData(RiotChampionData.Jinx, 0);

    /** Switcheroo! Definition */
    public static final RiotSkillData Switcheroo = new RiotSkillData(RiotChampionData.Jinx, 1);

    /** Zap! Definition */
    public static final RiotSkillData Zap = new RiotSkillData(RiotChampionData.Jinx, 2);

    /** Flame Chompers! Definition */
    public static final RiotSkillData FlameChompers = new RiotSkillData(RiotChampionData.Jinx, 3);

    /** Super Mega Death Rocket! Definition */
    public static final RiotSkillData SuperMegaDeathRocket = new RiotSkillData(RiotChampionData.Jinx, 4);

    /** Martial Poise Definition */
    public static final RiotSkillData MartialPoise = new RiotSkillData(RiotChampionData.Kalista, 0);

    /** Pierce Definition */
    public static final RiotSkillData Pierce = new RiotSkillData(RiotChampionData.Kalista, 1);

    /** Sentinel Definition */
    public static final RiotSkillData Sentinel = new RiotSkillData(RiotChampionData.Kalista, 2);

    /** Rend Definition */
    public static final RiotSkillData Rend = new RiotSkillData(RiotChampionData.Kalista, 3);

    /** Fate's Call Definition */
    public static final RiotSkillData FatesCall = new RiotSkillData(RiotChampionData.Kalista, 4);

    /** Gathering Fire Definition */
    public static final RiotSkillData GatheringFire = new RiotSkillData(RiotChampionData.Karma, 0);

    /** Inner Flame Definition */
    public static final RiotSkillData InnerFlame = new RiotSkillData(RiotChampionData.Karma, 1);

    /** Focused Resolve Definition */
    public static final RiotSkillData FocusedResolve = new RiotSkillData(RiotChampionData.Karma, 2);

    /** Inspire Definition */
    public static final RiotSkillData Inspire = new RiotSkillData(RiotChampionData.Karma, 3);

    /** Mantra Definition */
    public static final RiotSkillData Mantra = new RiotSkillData(RiotChampionData.Karma, 4);

    /** Death Defied Definition */
    public static final RiotSkillData DeathDefied = new RiotSkillData(RiotChampionData.Karthus, 0);

    /** Lay Waste Definition */
    public static final RiotSkillData LayWaste = new RiotSkillData(RiotChampionData.Karthus, 1);

    /** Wall of Pain Definition */
    public static final RiotSkillData WallOfPain = new RiotSkillData(RiotChampionData.Karthus, 2);

    /** Defile Definition */
    public static final RiotSkillData Defile = new RiotSkillData(RiotChampionData.Karthus, 3);

    /** Requiem Definition */
    public static final RiotSkillData Requiem = new RiotSkillData(RiotChampionData.Karthus, 4);

    /** Void Stone Definition */
    public static final RiotSkillData VoidStone = new RiotSkillData(RiotChampionData.Kassadin, 0);

    /** Null Sphere Definition */
    public static final RiotSkillData NullSphere = new RiotSkillData(RiotChampionData.Kassadin, 1);

    /** Nether Blade Definition */
    public static final RiotSkillData NetherBlade = new RiotSkillData(RiotChampionData.Kassadin, 2);

    /** Force Pulse Definition */
    public static final RiotSkillData ForcePulse = new RiotSkillData(RiotChampionData.Kassadin, 3);

    /** Riftwalk Definition */
    public static final RiotSkillData Riftwalk = new RiotSkillData(RiotChampionData.Kassadin, 4);

    /** Voracity Definition */
    public static final RiotSkillData Voracity = new RiotSkillData(RiotChampionData.Katarina, 0);

    /** Bouncing Blades Definition */
    public static final RiotSkillData BouncingBlades = new RiotSkillData(RiotChampionData.Katarina, 1);

    /** Sinister Steel Definition */
    public static final RiotSkillData SinisterSteel = new RiotSkillData(RiotChampionData.Katarina, 2);

    /** Shunpo Definition */
    public static final RiotSkillData Shunpo = new RiotSkillData(RiotChampionData.Katarina, 3);

    /** Death Lotus Definition */
    public static final RiotSkillData DeathLotus = new RiotSkillData(RiotChampionData.Katarina, 4);

    /** Holy Fervor Definition */
    public static final RiotSkillData HolyFervor = new RiotSkillData(RiotChampionData.Kayle, 0);

    /** Reckoning Definition */
    public static final RiotSkillData Reckoning = new RiotSkillData(RiotChampionData.Kayle, 1);

    /** Divine Blessing Definition */
    public static final RiotSkillData DivineBlessing = new RiotSkillData(RiotChampionData.Kayle, 2);

    /** Righteous Fury Definition */
    public static final RiotSkillData RighteousFury = new RiotSkillData(RiotChampionData.Kayle, 3);

    /** Intervention Definition */
    public static final RiotSkillData Intervention = new RiotSkillData(RiotChampionData.Kayle, 4);

    /** Mark of the Storm Definition */
    public static final RiotSkillData MarkOfTheStorm = new RiotSkillData(RiotChampionData.Kennen, 0);

    /** Thundering Shuriken Definition */
    public static final RiotSkillData ThunderingShuriken = new RiotSkillData(RiotChampionData.Kennen, 1);

    /** Electrical Surge Definition */
    public static final RiotSkillData ElectricalSurge = new RiotSkillData(RiotChampionData.Kennen, 2);

    /** Lightning Rush Definition */
    public static final RiotSkillData LightningRush = new RiotSkillData(RiotChampionData.Kennen, 3);

    /** Slicing Maelstrom Definition */
    public static final RiotSkillData SlicingMaelstrom = new RiotSkillData(RiotChampionData.Kennen, 4);

    /** Unseen Threat Definition */
    public static final RiotSkillData UnseenThreat = new RiotSkillData(RiotChampionData.Khazix, 0);

    /** Taste Their Fear Definition */
    public static final RiotSkillData TasteTheirFear = new RiotSkillData(RiotChampionData.Khazix, 1);

    /** Void Spike Definition */
    public static final RiotSkillData VoidSpike = new RiotSkillData(RiotChampionData.Khazix, 2);

    /** Leap Definition */
    public static final RiotSkillData Leap = new RiotSkillData(RiotChampionData.Khazix, 3);

    /** Void Assault Definition */
    public static final RiotSkillData VoidAssault = new RiotSkillData(RiotChampionData.Khazix, 4);

    /** Icathian Surprise Definition */
    public static final RiotSkillData IcathianSurprise = new RiotSkillData(RiotChampionData.KogMaw, 0);

    /** Caustic Spittle Definition */
    public static final RiotSkillData CausticSpittle = new RiotSkillData(RiotChampionData.KogMaw, 1);

    /** Bio-Arcane Barrage Definition */
    public static final RiotSkillData BioArcaneBarrage = new RiotSkillData(RiotChampionData.KogMaw, 2);

    /** Void Ooze Definition */
    public static final RiotSkillData VoidOoze = new RiotSkillData(RiotChampionData.KogMaw, 3);

    /** Living Artillery Definition */
    public static final RiotSkillData LivingArtillery = new RiotSkillData(RiotChampionData.KogMaw, 4);

    /** Mirror Image Definition */
    public static final RiotSkillData MirrorImage = new RiotSkillData(RiotChampionData.Leblanc, 0);

    /** Sigil of Malice Definition */
    public static final RiotSkillData SigilOfMalice = new RiotSkillData(RiotChampionData.Leblanc, 1);

    /** Distortion Definition */
    public static final RiotSkillData Distortion = new RiotSkillData(RiotChampionData.Leblanc, 2);

    /** Ethereal Chains Definition */
    public static final RiotSkillData EtherealChains = new RiotSkillData(RiotChampionData.Leblanc, 3);

    /** Mimic Definition */
    public static final RiotSkillData Mimic = new RiotSkillData(RiotChampionData.Leblanc, 4);

    /** Flurry Definition */
    public static final RiotSkillData Flurry = new RiotSkillData(RiotChampionData.LeeSin, 0);

    /** Sonic Wave / Resonating Strike Definition */
    public static final RiotSkillData SonicWaveResonatingStrike = new RiotSkillData(RiotChampionData.LeeSin, 1);

    /** Safeguard / Iron Will Definition */
    public static final RiotSkillData SafeguardIronWill = new RiotSkillData(RiotChampionData.LeeSin, 2);

    /** Tempest / Cripple Definition */
    public static final RiotSkillData TempestCripple = new RiotSkillData(RiotChampionData.LeeSin, 3);

    /** Dragon's Rage Definition */
    public static final RiotSkillData DragonsRage = new RiotSkillData(RiotChampionData.LeeSin, 4);

    /** Sunlight Definition */
    public static final RiotSkillData Sunlight = new RiotSkillData(RiotChampionData.Leona, 0);

    /** Shield of Daybreak Definition */
    public static final RiotSkillData ShieldOfDaybreak = new RiotSkillData(RiotChampionData.Leona, 1);

    /** Eclipse Definition */
    public static final RiotSkillData Eclipse = new RiotSkillData(RiotChampionData.Leona, 2);

    /** Zenith Blade Definition */
    public static final RiotSkillData ZenithBlade = new RiotSkillData(RiotChampionData.Leona, 3);

    /** Solar Flare Definition */
    public static final RiotSkillData SolarFlare = new RiotSkillData(RiotChampionData.Leona, 4);

    /** Iceborn Definition */
    public static final RiotSkillData Iceborn = new RiotSkillData(RiotChampionData.Lissandra, 0);

    /** Ice Shard Definition */
    public static final RiotSkillData IceShard = new RiotSkillData(RiotChampionData.Lissandra, 1);

    /** Ring of Frost Definition */
    public static final RiotSkillData RingOfFrost = new RiotSkillData(RiotChampionData.Lissandra, 2);

    /** Glacial Path Definition */
    public static final RiotSkillData GlacialPath = new RiotSkillData(RiotChampionData.Lissandra, 3);

    /** Frozen Tomb Definition */
    public static final RiotSkillData FrozenTomb = new RiotSkillData(RiotChampionData.Lissandra, 4);

    /** Lightslinger Definition */
    public static final RiotSkillData Lightslinger = new RiotSkillData(RiotChampionData.Lucian, 0);

    /** Piercing Light Definition */
    public static final RiotSkillData PiercingLight = new RiotSkillData(RiotChampionData.Lucian, 1);

    /** Ardent Blaze Definition */
    public static final RiotSkillData ArdentBlaze = new RiotSkillData(RiotChampionData.Lucian, 2);

    /** Relentless Pursuit Definition */
    public static final RiotSkillData RelentlessPursuit = new RiotSkillData(RiotChampionData.Lucian, 3);

    /** The Culling Definition */
    public static final RiotSkillData TheCulling = new RiotSkillData(RiotChampionData.Lucian, 4);

    /** Pix, Faerie Companion Definition */
    public static final RiotSkillData PixFaerieCompanion = new RiotSkillData(RiotChampionData.Lulu, 0);

    /** Glitterlance Definition */
    public static final RiotSkillData Glitterlance = new RiotSkillData(RiotChampionData.Lulu, 1);

    /** Whimsy Definition */
    public static final RiotSkillData Whimsy = new RiotSkillData(RiotChampionData.Lulu, 2);

    /** Help, Pix! Definition */
    public static final RiotSkillData HelpPix = new RiotSkillData(RiotChampionData.Lulu, 3);

    /** Wild Growth Definition */
    public static final RiotSkillData WildGrowth = new RiotSkillData(RiotChampionData.Lulu, 4);

    /** Illumination Definition */
    public static final RiotSkillData Illumination = new RiotSkillData(RiotChampionData.Lux, 0);

    /** Light Binding Definition */
    public static final RiotSkillData LightBinding = new RiotSkillData(RiotChampionData.Lux, 1);

    /** Prismatic Barrier Definition */
    public static final RiotSkillData PrismaticBarrier = new RiotSkillData(RiotChampionData.Lux, 2);

    /** Lucent Singularity Definition */
    public static final RiotSkillData LucentSingularity = new RiotSkillData(RiotChampionData.Lux, 3);

    /** Final Spark Definition */
    public static final RiotSkillData FinalSpark = new RiotSkillData(RiotChampionData.Lux, 4);

    /** Granite Shield Definition */
    public static final RiotSkillData GraniteShield = new RiotSkillData(RiotChampionData.Malphite, 0);

    /** Seismic Shard Definition */
    public static final RiotSkillData SeismicShard = new RiotSkillData(RiotChampionData.Malphite, 1);

    /** Brutal Strikes Definition */
    public static final RiotSkillData BrutalStrikes = new RiotSkillData(RiotChampionData.Malphite, 2);

    /** Ground Slam Definition */
    public static final RiotSkillData GroundSlam = new RiotSkillData(RiotChampionData.Malphite, 3);

    /** Unstoppable Force Definition */
    public static final RiotSkillData UnstoppableForce = new RiotSkillData(RiotChampionData.Malphite, 4);

    /** Summon Voidling Definition */
    public static final RiotSkillData SummonVoidling = new RiotSkillData(RiotChampionData.Malzahar, 0);

    /** Call of the Void Definition */
    public static final RiotSkillData CallOfTheVoid = new RiotSkillData(RiotChampionData.Malzahar, 1);

    /** Null Zone Definition */
    public static final RiotSkillData NullZone = new RiotSkillData(RiotChampionData.Malzahar, 2);

    /** Malefic Visions Definition */
    public static final RiotSkillData MaleficVisions = new RiotSkillData(RiotChampionData.Malzahar, 3);

    /** Nether Grasp Definition */
    public static final RiotSkillData NetherGrasp = new RiotSkillData(RiotChampionData.Malzahar, 4);

    /** Sap Magic Definition */
    public static final RiotSkillData SapMagic = new RiotSkillData(RiotChampionData.Maokai, 0);

    /** Arcane Smash Definition */
    public static final RiotSkillData ArcaneSmash = new RiotSkillData(RiotChampionData.Maokai, 1);

    /** Twisted Advance Definition */
    public static final RiotSkillData TwistedAdvance = new RiotSkillData(RiotChampionData.Maokai, 2);

    /** Sapling Toss Definition */
    public static final RiotSkillData SaplingToss = new RiotSkillData(RiotChampionData.Maokai, 3);

    /** Vengeful Maelstrom Definition */
    public static final RiotSkillData VengefulMaelstrom = new RiotSkillData(RiotChampionData.Maokai, 4);

    /** Double Strike Definition */
    public static final RiotSkillData DoubleStrike = new RiotSkillData(RiotChampionData.MasterYi, 0);

    /** Alpha Strike Definition */
    public static final RiotSkillData AlphaStrike = new RiotSkillData(RiotChampionData.MasterYi, 1);

    /** Meditate Definition */
    public static final RiotSkillData Meditate = new RiotSkillData(RiotChampionData.MasterYi, 2);

    /** Wuju Style Definition */
    public static final RiotSkillData WujuStyle = new RiotSkillData(RiotChampionData.MasterYi, 3);

    /** Highlander Definition */
    public static final RiotSkillData Highlander = new RiotSkillData(RiotChampionData.MasterYi, 4);

    /** Strut Definition */
    public static final RiotSkillData Strut = new RiotSkillData(RiotChampionData.MissFortune, 0);

    /** Double Up Definition */
    public static final RiotSkillData DoubleUp = new RiotSkillData(RiotChampionData.MissFortune, 1);

    /** Impure Shots Definition */
    public static final RiotSkillData ImpureShots = new RiotSkillData(RiotChampionData.MissFortune, 2);

    /** Make It Rain Definition */
    public static final RiotSkillData MakeItRain = new RiotSkillData(RiotChampionData.MissFortune, 3);

    /** Bullet Time Definition */
    public static final RiotSkillData BulletTime = new RiotSkillData(RiotChampionData.MissFortune, 4);

    /** Stone Skin Definition */
    public static final RiotSkillData StoneSkin = new RiotSkillData(RiotChampionData.MonkeyKing, 0);

    /** Crushing Blow Definition */
    public static final RiotSkillData CrushingBlow = new RiotSkillData(RiotChampionData.MonkeyKing, 1);

    /** Decoy Definition */
    public static final RiotSkillData Decoy = new RiotSkillData(RiotChampionData.MonkeyKing, 2);

    /** Nimbus Strike Definition */
    public static final RiotSkillData NimbusStrike = new RiotSkillData(RiotChampionData.MonkeyKing, 3);

    /** Cyclone Definition */
    public static final RiotSkillData Cyclone = new RiotSkillData(RiotChampionData.MonkeyKing, 4);

    /** Iron Man Definition */
    public static final RiotSkillData IronMan = new RiotSkillData(RiotChampionData.Mordekaiser, 0);

    /** Mace of Spades Definition */
    public static final RiotSkillData MaceOfSpades = new RiotSkillData(RiotChampionData.Mordekaiser, 1);

    /** Creeping Death Definition */
    public static final RiotSkillData CreepingDeath = new RiotSkillData(RiotChampionData.Mordekaiser, 2);

    /** Siphon of Destruction Definition */
    public static final RiotSkillData SiphonOfDestruction = new RiotSkillData(RiotChampionData.Mordekaiser, 3);

    /** Children of the Grave Definition */
    public static final RiotSkillData ChildrenOfTheGrave = new RiotSkillData(RiotChampionData.Mordekaiser, 4);

    /** Soul Siphon Definition */
    public static final RiotSkillData SoulSiphon = new RiotSkillData(RiotChampionData.Morgana, 0);

    /** Dark Binding Definition */
    public static final RiotSkillData DarkBinding = new RiotSkillData(RiotChampionData.Morgana, 1);

    /** Tormented Soil Definition */
    public static final RiotSkillData TormentedSoil = new RiotSkillData(RiotChampionData.Morgana, 2);

    /** Black Shield Definition */
    public static final RiotSkillData BlackShield = new RiotSkillData(RiotChampionData.Morgana, 3);

    /** Soul Shackles Definition */
    public static final RiotSkillData SoulShackles = new RiotSkillData(RiotChampionData.Morgana, 4);

    /** Surging Tides Definition */
    public static final RiotSkillData SurgingTides = new RiotSkillData(RiotChampionData.Nami, 0);

    /** Aqua Prison Definition */
    public static final RiotSkillData AquaPrison = new RiotSkillData(RiotChampionData.Nami, 1);

    /** Ebb and Flow Definition */
    public static final RiotSkillData EbbandFlow = new RiotSkillData(RiotChampionData.Nami, 2);

    /** Tidecaller's Blessing Definition */
    public static final RiotSkillData TidecallersBlessing = new RiotSkillData(RiotChampionData.Nami, 3);

    /** Tidal Wave Definition */
    public static final RiotSkillData TidalWave = new RiotSkillData(RiotChampionData.Nami, 4);

    /** Soul Eater Definition */
    public static final RiotSkillData SoulEater = new RiotSkillData(RiotChampionData.Nasus, 0);

    /** Siphoning Strike Definition */
    public static final RiotSkillData SiphoningStrike = new RiotSkillData(RiotChampionData.Nasus, 1);

    /** Wither Definition */
    public static final RiotSkillData Wither = new RiotSkillData(RiotChampionData.Nasus, 2);

    /** Spirit Fire Definition */
    public static final RiotSkillData SpiritFire = new RiotSkillData(RiotChampionData.Nasus, 3);

    /** Fury of the Sands Definition */
    public static final RiotSkillData FuryOfTheSands = new RiotSkillData(RiotChampionData.Nasus, 4);

    /** Staggering Blow Definition */
    public static final RiotSkillData StaggeringBlow = new RiotSkillData(RiotChampionData.Nautilus, 0);

    /** Dredge Line Definition */
    public static final RiotSkillData DredgeLine = new RiotSkillData(RiotChampionData.Nautilus, 1);

    /** Titan's Wrath Definition */
    public static final RiotSkillData TitansWrath = new RiotSkillData(RiotChampionData.Nautilus, 2);

    /** Riptide Definition */
    public static final RiotSkillData Riptide = new RiotSkillData(RiotChampionData.Nautilus, 3);

    /** Depth Charge Definition */
    public static final RiotSkillData DepthCharge = new RiotSkillData(RiotChampionData.Nautilus, 4);

    /** Prowl Definition */
    public static final RiotSkillData Prowl = new RiotSkillData(RiotChampionData.Nidalee, 0);

    /** Javelin Toss / Takedown Definition */
    public static final RiotSkillData JavelinTossTakedown = new RiotSkillData(RiotChampionData.Nidalee, 1);

    /** Bushwhack / Pounce Definition */
    public static final RiotSkillData BushwhackPounce = new RiotSkillData(RiotChampionData.Nidalee, 2);

    /** Primal Surge / Swipe Definition */
    public static final RiotSkillData PrimalSurgeSwipe = new RiotSkillData(RiotChampionData.Nidalee, 3);

    /** Aspect Of The Cougar Definition */
    public static final RiotSkillData AspectOfTheCougar = new RiotSkillData(RiotChampionData.Nidalee, 4);

    /** Takedown Definition */
    public static final RiotSkillData Takedown = new RiotSkillData(RiotChampionData.Nidalee, 5);

    /** Pounce Definition */
    public static final RiotSkillData Pounce = new RiotSkillData(RiotChampionData.Nidalee, 6);

    /** Swipe Definition */
    public static final RiotSkillData Swipe = new RiotSkillData(RiotChampionData.Nidalee, 7);

    /** Umbra Blades Definition */
    public static final RiotSkillData UmbraBlades = new RiotSkillData(RiotChampionData.Nocturne, 0);

    /** Duskbringer Definition */
    public static final RiotSkillData Duskbringer = new RiotSkillData(RiotChampionData.Nocturne, 1);

    /** Shroud of Darkness Definition */
    public static final RiotSkillData ShroudOfDarkness = new RiotSkillData(RiotChampionData.Nocturne, 2);

    /** Unspeakable Horror Definition */
    public static final RiotSkillData UnspeakableHorror = new RiotSkillData(RiotChampionData.Nocturne, 3);

    /** Paranoia Definition */
    public static final RiotSkillData Paranoia = new RiotSkillData(RiotChampionData.Nocturne, 4);

    /** Visionary Definition */
    public static final RiotSkillData Visionary = new RiotSkillData(RiotChampionData.Nunu, 0);

    /** Consume Definition */
    public static final RiotSkillData Consume = new RiotSkillData(RiotChampionData.Nunu, 1);

    /** Blood Boil Definition */
    public static final RiotSkillData BloodBoil = new RiotSkillData(RiotChampionData.Nunu, 2);

    /** Ice Blast Definition */
    public static final RiotSkillData IceBlast = new RiotSkillData(RiotChampionData.Nunu, 3);

    /** Absolute Zero Definition */
    public static final RiotSkillData AbsoluteZero = new RiotSkillData(RiotChampionData.Nunu, 4);

    /** Berserker Rage Definition */
    public static final RiotSkillData BerserkerRage = new RiotSkillData(RiotChampionData.Olaf, 0);

    /** Undertow Definition */
    public static final RiotSkillData Undertow = new RiotSkillData(RiotChampionData.Olaf, 1);

    /** Vicious Strikes Definition */
    public static final RiotSkillData ViciousStrikes = new RiotSkillData(RiotChampionData.Olaf, 2);

    /** Reckless Swing Definition */
    public static final RiotSkillData RecklessSwing = new RiotSkillData(RiotChampionData.Olaf, 3);

    /** Ragnarok Definition */
    public static final RiotSkillData Ragnarok = new RiotSkillData(RiotChampionData.Olaf, 4);

    /** Clockwork Windup Definition */
    public static final RiotSkillData ClockworkWindup = new RiotSkillData(RiotChampionData.Orianna, 0);

    /** Command: Attack Definition */
    public static final RiotSkillData CommandAttack = new RiotSkillData(RiotChampionData.Orianna, 1);

    /** Command: Dissonance Definition */
    public static final RiotSkillData CommandDissonance = new RiotSkillData(RiotChampionData.Orianna, 2);

    /** Command: Protect Definition */
    public static final RiotSkillData CommandProtect = new RiotSkillData(RiotChampionData.Orianna, 3);

    /** Command: Shockwave Definition */
    public static final RiotSkillData CommandShockwave = new RiotSkillData(RiotChampionData.Orianna, 4);

    /** Aegis Protection Definition */
    public static final RiotSkillData AegisProtection = new RiotSkillData(RiotChampionData.Pantheon, 0);

    /** Spear Shot Definition */
    public static final RiotSkillData SpearShot = new RiotSkillData(RiotChampionData.Pantheon, 1);

    /** Aegis of Zeonia Definition */
    public static final RiotSkillData AegisOfZeonia = new RiotSkillData(RiotChampionData.Pantheon, 2);

    /** Heartseeker Strike Definition */
    public static final RiotSkillData HeartseekerStrike = new RiotSkillData(RiotChampionData.Pantheon, 3);

    /** Grand Skyfall Definition */
    public static final RiotSkillData GrandSkyfall = new RiotSkillData(RiotChampionData.Pantheon, 4);

    /** Valiant Fighter Definition */
    public static final RiotSkillData ValiantFighter = new RiotSkillData(RiotChampionData.Poppy, 0);

    /** Devastating Blow Definition */
    public static final RiotSkillData DevastatingBlow = new RiotSkillData(RiotChampionData.Poppy, 1);

    /** Paragon of Demacia Definition */
    public static final RiotSkillData ParagonOfDemacia = new RiotSkillData(RiotChampionData.Poppy, 2);

    /** Heroic Charge Definition */
    public static final RiotSkillData HeroicCharge = new RiotSkillData(RiotChampionData.Poppy, 3);

    /** Diplomatic Immunity Definition */
    public static final RiotSkillData DiplomaticImmunity = new RiotSkillData(RiotChampionData.Poppy, 4);

    /** Harrier Definition */
    public static final RiotSkillData Harrier = new RiotSkillData(RiotChampionData.Quinn, 0);

    /** Blinding Assault Definition */
    public static final RiotSkillData BlindingAssault = new RiotSkillData(RiotChampionData.Quinn, 1);

    /** Heightened Senses Definition */
    public static final RiotSkillData HeightenedSenses = new RiotSkillData(RiotChampionData.Quinn, 2);

    /** Vault Definition */
    public static final RiotSkillData Vault = new RiotSkillData(RiotChampionData.Quinn, 3);

    /** Tag Team Definition */
    public static final RiotSkillData TagTeam = new RiotSkillData(RiotChampionData.Quinn, 4);

    /** Spiked Shell Definition */
    public static final RiotSkillData SpikedShell = new RiotSkillData(RiotChampionData.Rammus, 0);

    /** Powerball Definition */
    public static final RiotSkillData Powerball = new RiotSkillData(RiotChampionData.Rammus, 1);

    /** Defensive Ball Curl Definition */
    public static final RiotSkillData DefensiveBallCurl = new RiotSkillData(RiotChampionData.Rammus, 2);

    /** Puncturing Taunt Definition */
    public static final RiotSkillData PuncturingTaunt = new RiotSkillData(RiotChampionData.Rammus, 3);

    /** Tremors Definition */
    public static final RiotSkillData Tremors = new RiotSkillData(RiotChampionData.Rammus, 4);

    /** Fury of the Xer'Sai Definition */
    public static final RiotSkillData FuryOfTheXerSai = new RiotSkillData(RiotChampionData.RekSai, 0);

    /** Queen's Wrath / Prey Seeker Definition */
    public static final RiotSkillData QueensWrathPreySeeker = new RiotSkillData(RiotChampionData.RekSai, 1);

    /** Burrow / Un-burrow Definition */
    public static final RiotSkillData BurrowUnburrow = new RiotSkillData(RiotChampionData.RekSai, 2);

    /** Furious Bite / Tunnel Definition */
    public static final RiotSkillData FuriousBiteTunnel = new RiotSkillData(RiotChampionData.RekSai, 3);

    /** Void Rush Definition */
    public static final RiotSkillData VoidRush = new RiotSkillData(RiotChampionData.RekSai, 4);

    /** Reign of Anger Definition */
    public static final RiotSkillData ReignOfAnger = new RiotSkillData(RiotChampionData.Renekton, 0);

    /** Cull the Meek Definition */
    public static final RiotSkillData CullTheMeek = new RiotSkillData(RiotChampionData.Renekton, 1);

    /** Ruthless Predator Definition */
    public static final RiotSkillData RuthlessPredator = new RiotSkillData(RiotChampionData.Renekton, 2);

    /** Slice and Dice Definition */
    public static final RiotSkillData SliceandDice = new RiotSkillData(RiotChampionData.Renekton, 3);

    /** Dominus Definition */
    public static final RiotSkillData Dominus = new RiotSkillData(RiotChampionData.Renekton, 4);

    /** Unseen Predator Definition */
    public static final RiotSkillData UnseenPredator = new RiotSkillData(RiotChampionData.Rengar, 0);

    /** Savagery Definition */
    public static final RiotSkillData Savagery = new RiotSkillData(RiotChampionData.Rengar, 1);

    /** Battle Roar Definition */
    public static final RiotSkillData BattleRoar = new RiotSkillData(RiotChampionData.Rengar, 2);

    /** Bola Strike Definition */
    public static final RiotSkillData BolaStrike = new RiotSkillData(RiotChampionData.Rengar, 3);

    /** Thrill of the Hunt Definition */
    public static final RiotSkillData ThrillOfTheHunt = new RiotSkillData(RiotChampionData.Rengar, 4);

    /** Runic Blade Definition */
    public static final RiotSkillData RunicBlade = new RiotSkillData(RiotChampionData.Riven, 0);

    /** Broken Wings Definition */
    public static final RiotSkillData BrokenWings = new RiotSkillData(RiotChampionData.Riven, 1);

    /** Ki Burst Definition */
    public static final RiotSkillData KiBurst = new RiotSkillData(RiotChampionData.Riven, 2);

    /** Valor Definition */
    public static final RiotSkillData Valor = new RiotSkillData(RiotChampionData.Riven, 3);

    /** Blade of the Exile Definition */
    public static final RiotSkillData BladeOfTheExile = new RiotSkillData(RiotChampionData.Riven, 4);

    /** Junkyard Titan Definition */
    public static final RiotSkillData JunkyardTitan = new RiotSkillData(RiotChampionData.Rumble, 0);

    /** Flamespitter Definition */
    public static final RiotSkillData Flamespitter = new RiotSkillData(RiotChampionData.Rumble, 1);

    /** Scrap Shield Definition */
    public static final RiotSkillData ScrapShield = new RiotSkillData(RiotChampionData.Rumble, 2);

    /** Electro Harpoon Definition */
    public static final RiotSkillData ElectroHarpoon = new RiotSkillData(RiotChampionData.Rumble, 3);

    /** The Equalizer Definition */
    public static final RiotSkillData TheEqualizer = new RiotSkillData(RiotChampionData.Rumble, 4);

    /** Arcane Mastery Definition */
    public static final RiotSkillData ArcaneMastery = new RiotSkillData(RiotChampionData.Ryze, 0);

    /** Overload Definition */
    public static final RiotSkillData Overload = new RiotSkillData(RiotChampionData.Ryze, 1);

    /** Rune Prison Definition */
    public static final RiotSkillData RunePrison = new RiotSkillData(RiotChampionData.Ryze, 2);

    /** Spell Flux Definition */
    public static final RiotSkillData SpellFlux = new RiotSkillData(RiotChampionData.Ryze, 3);

    /** Desperate Power Definition */
    public static final RiotSkillData DesperatePower = new RiotSkillData(RiotChampionData.Ryze, 4);

    /** Frost Definition */
    public static final RiotSkillData Frost = new RiotSkillData(RiotChampionData.Sejuani, 0);

    /** Arctic Assault Definition */
    public static final RiotSkillData ArcticAssault = new RiotSkillData(RiotChampionData.Sejuani, 1);

    /** Flail of the Northern Winds Definition */
    public static final RiotSkillData FlailOfTheNorthernWinds = new RiotSkillData(RiotChampionData.Sejuani, 2);

    /** Permafrost Definition */
    public static final RiotSkillData Permafrost = new RiotSkillData(RiotChampionData.Sejuani, 3);

    /** Glacial Prison Definition */
    public static final RiotSkillData GlacialPrison = new RiotSkillData(RiotChampionData.Sejuani, 4);

    /** Backstab Definition */
    public static final RiotSkillData Backstab = new RiotSkillData(RiotChampionData.Shaco, 0);

    /** Deceive Definition */
    public static final RiotSkillData Deceive = new RiotSkillData(RiotChampionData.Shaco, 1);

    /** Jack In The Box Definition */
    public static final RiotSkillData JackInTheBox = new RiotSkillData(RiotChampionData.Shaco, 2);

    /** Two-Shiv Poison Definition */
    public static final RiotSkillData TwoShivPoison = new RiotSkillData(RiotChampionData.Shaco, 3);

    /** Hallucinate Definition */
    public static final RiotSkillData Hallucinate = new RiotSkillData(RiotChampionData.Shaco, 4);

    /** Ki Strike Definition */
    public static final RiotSkillData KiStrike = new RiotSkillData(RiotChampionData.Shen, 0);

    /** Vorpal Blade Definition */
    public static final RiotSkillData VorpalBlade = new RiotSkillData(RiotChampionData.Shen, 1);

    /** Feint Definition */
    public static final RiotSkillData Feint = new RiotSkillData(RiotChampionData.Shen, 2);

    /** Shadow Dash Definition */
    public static final RiotSkillData ShadowDash = new RiotSkillData(RiotChampionData.Shen, 3);

    /** Stand United Definition */
    public static final RiotSkillData StandUnited = new RiotSkillData(RiotChampionData.Shen, 4);

    /** Dragonborn Definition */
    public static final RiotSkillData Dragonborn = new RiotSkillData(RiotChampionData.Shyvana, 0);

    /** Twin Bite Definition */
    public static final RiotSkillData TwinBite = new RiotSkillData(RiotChampionData.Shyvana, 1);

    /** Burnout Definition */
    public static final RiotSkillData Burnout = new RiotSkillData(RiotChampionData.Shyvana, 2);

    /** Flame Breath Definition */
    public static final RiotSkillData FlameBreath = new RiotSkillData(RiotChampionData.Shyvana, 3);

    /** Dragon's Descent Definition */
    public static final RiotSkillData DragonsDescent = new RiotSkillData(RiotChampionData.Shyvana, 4);

    /** Empowered Bulwark Definition */
    public static final RiotSkillData EmpoweredBulwark = new RiotSkillData(RiotChampionData.Singed, 0);

    /** Poison Trail Definition */
    public static final RiotSkillData PoisonTrail = new RiotSkillData(RiotChampionData.Singed, 1);

    /** Mega Adhesive Definition */
    public static final RiotSkillData MegaAdhesive = new RiotSkillData(RiotChampionData.Singed, 2);

    /** Fling Definition */
    public static final RiotSkillData Fling = new RiotSkillData(RiotChampionData.Singed, 3);

    /** Insanity Potion Definition */
    public static final RiotSkillData InsanityPotion = new RiotSkillData(RiotChampionData.Singed, 4);

    /** Glory in Death Definition */
    public static final RiotSkillData GloryinDeath = new RiotSkillData(RiotChampionData.Sion, 0);

    /** Decimating Smash Definition */
    public static final RiotSkillData DecimatingSmash = new RiotSkillData(RiotChampionData.Sion, 1);

    /** Soul Furnace Definition */
    public static final RiotSkillData SoulFurnace = new RiotSkillData(RiotChampionData.Sion, 2);

    /** Roar of the Slayer Definition */
    public static final RiotSkillData RoarOfTheSlayer = new RiotSkillData(RiotChampionData.Sion, 3);

    /** Unstoppable Onslaught Definition */
    public static final RiotSkillData UnstoppableOnslaught = new RiotSkillData(RiotChampionData.Sion, 4);

    /** Fleet of Foot Definition */
    public static final RiotSkillData FleetOfFoot = new RiotSkillData(RiotChampionData.Sivir, 0);

    /** Boomerang Blade Definition */
    public static final RiotSkillData BoomerangBlade = new RiotSkillData(RiotChampionData.Sivir, 1);

    /** Ricochet Definition */
    public static final RiotSkillData Ricochet = new RiotSkillData(RiotChampionData.Sivir, 2);

    /** Spell Shield Definition */
    public static final RiotSkillData SpellShield = new RiotSkillData(RiotChampionData.Sivir, 3);

    /** On The Hunt Definition */
    public static final RiotSkillData OnTheHunt = new RiotSkillData(RiotChampionData.Sivir, 4);

    /** Crystallizing Sting Definition */
    public static final RiotSkillData CrystallizingSting = new RiotSkillData(RiotChampionData.Skarner, 0);

    /** Crystal Slash Definition */
    public static final RiotSkillData CrystalSlash = new RiotSkillData(RiotChampionData.Skarner, 1);

    /** Crystalline Exoskeleton Definition */
    public static final RiotSkillData CrystallineExoskeleton = new RiotSkillData(RiotChampionData.Skarner, 2);

    /** Fracture Definition */
    public static final RiotSkillData Fracture = new RiotSkillData(RiotChampionData.Skarner, 3);

    /** Impale Definition */
    public static final RiotSkillData Impale = new RiotSkillData(RiotChampionData.Skarner, 4);

    /** Power Chord Definition */
    public static final RiotSkillData PowerChord = new RiotSkillData(RiotChampionData.Sona, 0);

    /** Hymn of Valor Definition */
    public static final RiotSkillData HymnOfValor = new RiotSkillData(RiotChampionData.Sona, 1);

    /** Aria of Perseverance Definition */
    public static final RiotSkillData AriaOfPerseverance = new RiotSkillData(RiotChampionData.Sona, 2);

    /** Song of Celerity Definition */
    public static final RiotSkillData SongOfCelerity = new RiotSkillData(RiotChampionData.Sona, 3);

    /** Crescendo Definition */
    public static final RiotSkillData Crescendo = new RiotSkillData(RiotChampionData.Sona, 4);

    /** Salvation Definition */
    public static final RiotSkillData Salvation = new RiotSkillData(RiotChampionData.Soraka, 0);

    /** Starcall Definition */
    public static final RiotSkillData Starcall = new RiotSkillData(RiotChampionData.Soraka, 1);

    /** Astral Infusion Definition */
    public static final RiotSkillData AstralInfusion = new RiotSkillData(RiotChampionData.Soraka, 2);

    /** Equinox Definition */
    public static final RiotSkillData Equinox = new RiotSkillData(RiotChampionData.Soraka, 3);

    /** Wish Definition */
    public static final RiotSkillData Wish = new RiotSkillData(RiotChampionData.Soraka, 4);

    /** Carrion Renewal Definition */
    public static final RiotSkillData CarrionRenewal = new RiotSkillData(RiotChampionData.Swain, 0);

    /** Decrepify Definition */
    public static final RiotSkillData Decrepify = new RiotSkillData(RiotChampionData.Swain, 1);

    /** Nevermove Definition */
    public static final RiotSkillData Nevermove = new RiotSkillData(RiotChampionData.Swain, 2);

    /** Torment Definition */
    public static final RiotSkillData Torment = new RiotSkillData(RiotChampionData.Swain, 3);

    /** Ravenous Flock Definition */
    public static final RiotSkillData RavenousFlock = new RiotSkillData(RiotChampionData.Swain, 4);

    /** Transcendent Definition */
    public static final RiotSkillData Transcendent = new RiotSkillData(RiotChampionData.Syndra, 0);

    /** Dark Sphere Definition */
    public static final RiotSkillData DarkSphere = new RiotSkillData(RiotChampionData.Syndra, 1);

    /** Force of Will Definition */
    public static final RiotSkillData ForceOfWill = new RiotSkillData(RiotChampionData.Syndra, 2);

    /** Scatter the Weak Definition */
    public static final RiotSkillData ScatterTheWeak = new RiotSkillData(RiotChampionData.Syndra, 3);

    /** Unleashed Power Definition */
    public static final RiotSkillData UnleashedPower = new RiotSkillData(RiotChampionData.Syndra, 4);

    /** An Acquired Taste Definition */
    public static final RiotSkillData AnAcquiredTaste = new RiotSkillData(RiotChampionData.TahmKench, 0);

    /** Tongue Lash Definition */
    public static final RiotSkillData TongueLash = new RiotSkillData(RiotChampionData.TahmKench, 1);

    /** Devour Definition */
    public static final RiotSkillData Devour = new RiotSkillData(RiotChampionData.TahmKench, 2);

    /** Thick Skin Definition */
    public static final RiotSkillData ThickSkin = new RiotSkillData(RiotChampionData.TahmKench, 3);

    /** Abyssal Voyage Definition */
    public static final RiotSkillData AbyssalVoyage = new RiotSkillData(RiotChampionData.TahmKench, 4);

    /** Mercy Definition */
    public static final RiotSkillData Mercy = new RiotSkillData(RiotChampionData.Talon, 0);

    /** Noxian Diplomacy Definition */
    public static final RiotSkillData NoxianDiplomacy = new RiotSkillData(RiotChampionData.Talon, 1);

    /** Rake Definition */
    public static final RiotSkillData Rake = new RiotSkillData(RiotChampionData.Talon, 2);

    /** Cutthroat Definition */
    public static final RiotSkillData Cutthroat = new RiotSkillData(RiotChampionData.Talon, 3);

    /** Shadow Assault Definition */
    public static final RiotSkillData ShadowAssault = new RiotSkillData(RiotChampionData.Talon, 4);

    /** Gemcraft Definition */
    public static final RiotSkillData Gemcraft = new RiotSkillData(RiotChampionData.Taric, 0);

    /** Imbue Definition */
    public static final RiotSkillData Imbue = new RiotSkillData(RiotChampionData.Taric, 1);

    /** Shatter Definition */
    public static final RiotSkillData Shatter = new RiotSkillData(RiotChampionData.Taric, 2);

    /** Dazzle Definition */
    public static final RiotSkillData Dazzle = new RiotSkillData(RiotChampionData.Taric, 3);

    /** Radiance Definition */
    public static final RiotSkillData Radiance = new RiotSkillData(RiotChampionData.Taric, 4);

    /** Camouflage Definition */
    public static final RiotSkillData Camouflage = new RiotSkillData(RiotChampionData.Teemo, 0);

    /** Blinding Dart Definition */
    public static final RiotSkillData BlindingDart = new RiotSkillData(RiotChampionData.Teemo, 1);

    /** Move Quick Definition */
    public static final RiotSkillData MoveQuick = new RiotSkillData(RiotChampionData.Teemo, 2);

    /** Toxic Shot Definition */
    public static final RiotSkillData ToxicShot = new RiotSkillData(RiotChampionData.Teemo, 3);

    /** Noxious Trap Definition */
    public static final RiotSkillData NoxiousTrap = new RiotSkillData(RiotChampionData.Teemo, 4);

    /** Damnation Definition */
    public static final RiotSkillData Damnation = new RiotSkillData(RiotChampionData.Thresh, 0);

    /** Death Sentence Definition */
    public static final RiotSkillData DeathSentence = new RiotSkillData(RiotChampionData.Thresh, 1);

    /** Dark Passage Definition */
    public static final RiotSkillData DarkPassage = new RiotSkillData(RiotChampionData.Thresh, 2);

    /** Flay Definition */
    public static final RiotSkillData Flay = new RiotSkillData(RiotChampionData.Thresh, 3);

    /** The Box Definition */
    public static final RiotSkillData TheBox = new RiotSkillData(RiotChampionData.Thresh, 4);

    /** Draw a Bead Definition */
    public static final RiotSkillData DrawaBead = new RiotSkillData(RiotChampionData.Tristana, 0);

    /** Rapid Fire Definition */
    public static final RiotSkillData RapidFire = new RiotSkillData(RiotChampionData.Tristana, 1);

    /** Rocket Jump Definition */
    public static final RiotSkillData RocketJump = new RiotSkillData(RiotChampionData.Tristana, 2);

    /** Explosive Charge Definition */
    public static final RiotSkillData ExplosiveCharge = new RiotSkillData(RiotChampionData.Tristana, 3);

    /** Buster Shot Definition */
    public static final RiotSkillData BusterShot = new RiotSkillData(RiotChampionData.Tristana, 4);

    /** King's Tribute Definition */
    public static final RiotSkillData KingsTribute = new RiotSkillData(RiotChampionData.Trundle, 0);

    /** Chomp Definition */
    public static final RiotSkillData Chomp = new RiotSkillData(RiotChampionData.Trundle, 1);

    /** Frozen Domain Definition */
    public static final RiotSkillData FrozenDomain = new RiotSkillData(RiotChampionData.Trundle, 2);

    /** Pillar of Ice Definition */
    public static final RiotSkillData PillarOfIce = new RiotSkillData(RiotChampionData.Trundle, 3);

    /** Subjugate Definition */
    public static final RiotSkillData Subjugate = new RiotSkillData(RiotChampionData.Trundle, 4);

    /** Battle Fury Definition */
    public static final RiotSkillData BattleFury = new RiotSkillData(RiotChampionData.Tryndamere, 0);

    /** Bloodlust Definition */
    public static final RiotSkillData Bloodlust = new RiotSkillData(RiotChampionData.Tryndamere, 1);

    /** Mocking Shout Definition */
    public static final RiotSkillData MockingShout = new RiotSkillData(RiotChampionData.Tryndamere, 2);

    /** Spinning Slash Definition */
    public static final RiotSkillData SpinningSlash = new RiotSkillData(RiotChampionData.Tryndamere, 3);

    /** Undying Rage Definition */
    public static final RiotSkillData UndyingRage = new RiotSkillData(RiotChampionData.Tryndamere, 4);

    /** Loaded Dice Definition */
    public static final RiotSkillData LoadedDice = new RiotSkillData(RiotChampionData.TwistedFate, 0);

    /** Wild Cards Definition */
    public static final RiotSkillData WildCards = new RiotSkillData(RiotChampionData.TwistedFate, 1);

    /** Pick A Card Definition */
    public static final RiotSkillData PickACard = new RiotSkillData(RiotChampionData.TwistedFate, 2);

    /** Stacked Deck Definition */
    public static final RiotSkillData StackedDeck = new RiotSkillData(RiotChampionData.TwistedFate, 3);

    /** Destiny Definition */
    public static final RiotSkillData Destiny = new RiotSkillData(RiotChampionData.TwistedFate, 4);

    /** Deadly Venom Definition */
    public static final RiotSkillData DeadlyVenom = new RiotSkillData(RiotChampionData.Twitch, 0);

    /** Ambush Definition */
    public static final RiotSkillData Ambush = new RiotSkillData(RiotChampionData.Twitch, 1);

    /** Venom Cask Definition */
    public static final RiotSkillData VenomCask = new RiotSkillData(RiotChampionData.Twitch, 2);

    /** Contaminate Definition */
    public static final RiotSkillData Contaminate = new RiotSkillData(RiotChampionData.Twitch, 3);

    /** Rat-Ta-Tat-Tat Definition */
    public static final RiotSkillData RatTaTatTat = new RiotSkillData(RiotChampionData.Twitch, 4);

    /** Monkey's Agility Definition */
    public static final RiotSkillData MonkeysAgility = new RiotSkillData(RiotChampionData.Udyr, 0);

    /** Tiger Stance Definition */
    public static final RiotSkillData TigerStance = new RiotSkillData(RiotChampionData.Udyr, 1);

    /** Turtle Stance Definition */
    public static final RiotSkillData TurtleStance = new RiotSkillData(RiotChampionData.Udyr, 2);

    /** Bear Stance Definition */
    public static final RiotSkillData BearStance = new RiotSkillData(RiotChampionData.Udyr, 3);

    /** Phoenix Stance Definition */
    public static final RiotSkillData PhoenixStance = new RiotSkillData(RiotChampionData.Udyr, 4);

    /** Zaun-Touched Bolt Augmenter Definition */
    public static final RiotSkillData ZaunTouchedBoltAugmenter = new RiotSkillData(RiotChampionData.Urgot, 0);

    /** Acid Hunter Definition */
    public static final RiotSkillData AcidHunter = new RiotSkillData(RiotChampionData.Urgot, 1);

    /** Terror Capacitor Definition */
    public static final RiotSkillData TerrorCapacitor = new RiotSkillData(RiotChampionData.Urgot, 2);

    /** Noxian Corrosive Charge Definition */
    public static final RiotSkillData NoxianCorrosiveCharge = new RiotSkillData(RiotChampionData.Urgot, 3);

    /** Hyper-Kinetic Position Reverser Definition */
    public static final RiotSkillData HyperKineticPositionReverser = new RiotSkillData(RiotChampionData.Urgot, 4);

    /** Living Vengeance Definition */
    public static final RiotSkillData LivingVengeance = new RiotSkillData(RiotChampionData.Varus, 0);

    /** Piercing Arrow Definition */
    public static final RiotSkillData PiercingArrow = new RiotSkillData(RiotChampionData.Varus, 1);

    /** Blighted Quiver Definition */
    public static final RiotSkillData BlightedQuiver = new RiotSkillData(RiotChampionData.Varus, 2);

    /** Hail of Arrows Definition */
    public static final RiotSkillData HailOfArrows = new RiotSkillData(RiotChampionData.Varus, 3);

    /** Chain of Corruption Definition */
    public static final RiotSkillData ChainOfCorruption = new RiotSkillData(RiotChampionData.Varus, 4);

    /** Night Hunter Definition */
    public static final RiotSkillData NightHunter = new RiotSkillData(RiotChampionData.Vayne, 0);

    /** Tumble Definition */
    public static final RiotSkillData Tumble = new RiotSkillData(RiotChampionData.Vayne, 1);

    /** Silver Bolts Definition */
    public static final RiotSkillData SilverBolts = new RiotSkillData(RiotChampionData.Vayne, 2);

    /** Condemn Definition */
    public static final RiotSkillData Condemn = new RiotSkillData(RiotChampionData.Vayne, 3);

    /** Final Hour Definition */
    public static final RiotSkillData FinalHour = new RiotSkillData(RiotChampionData.Vayne, 4);

    /** Equilibrium Definition */
    public static final RiotSkillData Equilibrium = new RiotSkillData(RiotChampionData.Veigar, 0);

    /** Baleful Strike Definition */
    public static final RiotSkillData BalefulStrike = new RiotSkillData(RiotChampionData.Veigar, 1);

    /** Dark Matter Definition */
    public static final RiotSkillData DarkMatter = new RiotSkillData(RiotChampionData.Veigar, 2);

    /** Event Horizon Definition */
    public static final RiotSkillData EventHorizon = new RiotSkillData(RiotChampionData.Veigar, 3);

    /** Primordial Burst Definition */
    public static final RiotSkillData PrimordialBurst = new RiotSkillData(RiotChampionData.Veigar, 4);

    /** Organic Deconstruction Definition */
    public static final RiotSkillData OrganicDeconstruction = new RiotSkillData(RiotChampionData.Velkoz, 0);

    /** Plasma Fission Definition */
    public static final RiotSkillData PlasmaFission = new RiotSkillData(RiotChampionData.Velkoz, 1);

    /** Void Rift Definition */
    public static final RiotSkillData VoidRift = new RiotSkillData(RiotChampionData.Velkoz, 2);

    /** Tectonic Disruption Definition */
    public static final RiotSkillData TectonicDisruption = new RiotSkillData(RiotChampionData.Velkoz, 3);

    /** Life Form Disintegration Ray Definition */
    public static final RiotSkillData LifeFormDisintegrationRay = new RiotSkillData(RiotChampionData.Velkoz, 4);

    /** Blast Shield Definition */
    public static final RiotSkillData BlastShield = new RiotSkillData(RiotChampionData.Vi, 0);

    /** Vault Breaker Definition */
    public static final RiotSkillData VaultBreaker = new RiotSkillData(RiotChampionData.Vi, 1);

    /** Denting Blows Definition */
    public static final RiotSkillData DentingBlows = new RiotSkillData(RiotChampionData.Vi, 2);

    /** Excessive Force Definition */
    public static final RiotSkillData ExcessiveForce = new RiotSkillData(RiotChampionData.Vi, 3);

    /** Assault and Battery Definition */
    public static final RiotSkillData AssaultandBattery = new RiotSkillData(RiotChampionData.Vi, 4);

    /** Glorious Evolution Definition */
    public static final RiotSkillData GloriousEvolution = new RiotSkillData(RiotChampionData.Viktor, 0);

    /** Siphon Power Definition */
    public static final RiotSkillData SiphonPower = new RiotSkillData(RiotChampionData.Viktor, 1);

    /** Gravity Field Definition */
    public static final RiotSkillData GravityField = new RiotSkillData(RiotChampionData.Viktor, 2);

    /** Death Ray Definition */
    public static final RiotSkillData DeathRay = new RiotSkillData(RiotChampionData.Viktor, 3);

    /** Chaos Storm Definition */
    public static final RiotSkillData ChaosStorm = new RiotSkillData(RiotChampionData.Viktor, 4);

    /** Crimson Pact Definition */
    public static final RiotSkillData CrimsonPact = new RiotSkillData(RiotChampionData.Vladimir, 0);

    /** Transfusion Definition */
    public static final RiotSkillData Transfusion = new RiotSkillData(RiotChampionData.Vladimir, 1);

    /** Sanguine Pool Definition */
    public static final RiotSkillData SanguinePool = new RiotSkillData(RiotChampionData.Vladimir, 2);

    /** Tides of Blood Definition */
    public static final RiotSkillData TidesOfBlood = new RiotSkillData(RiotChampionData.Vladimir, 3);

    /** Hemoplague Definition */
    public static final RiotSkillData Hemoplague = new RiotSkillData(RiotChampionData.Vladimir, 4);

    /** Chosen of the Storm Definition */
    public static final RiotSkillData ChosenOfTheStorm = new RiotSkillData(RiotChampionData.Volibear, 0);

    /** Rolling Thunder Definition */
    public static final RiotSkillData RollingThunder = new RiotSkillData(RiotChampionData.Volibear, 1);

    /** Frenzy Definition */
    public static final RiotSkillData Frenzy = new RiotSkillData(RiotChampionData.Volibear, 2);

    /** Majestic Roar Definition */
    public static final RiotSkillData MajesticRoar = new RiotSkillData(RiotChampionData.Volibear, 3);

    /** Thunder Claws Definition */
    public static final RiotSkillData ThunderClaws = new RiotSkillData(RiotChampionData.Volibear, 4);

    /** Eternal Thirst Definition */
    public static final RiotSkillData EternalThirst = new RiotSkillData(RiotChampionData.Warwick, 0);

    /** Hungering Strike Definition */
    public static final RiotSkillData HungeringStrike = new RiotSkillData(RiotChampionData.Warwick, 1);

    /** Hunters Call Definition */
    public static final RiotSkillData HuntersCall = new RiotSkillData(RiotChampionData.Warwick, 2);

    /** Blood Scent Definition */
    public static final RiotSkillData BloodScent = new RiotSkillData(RiotChampionData.Warwick, 3);

    /** Infinite Duress Definition */
    public static final RiotSkillData InfiniteDuress = new RiotSkillData(RiotChampionData.Warwick, 4);

    /** Mana Surge Definition */
    public static final RiotSkillData ManaSurge = new RiotSkillData(RiotChampionData.Xerath, 0);

    /** Arcanopulse Definition */
    public static final RiotSkillData Arcanopulse = new RiotSkillData(RiotChampionData.Xerath, 1);

    /** Eye of Destruction Definition */
    public static final RiotSkillData EyeOfDestruction = new RiotSkillData(RiotChampionData.Xerath, 2);

    /** Shocking Orb Definition */
    public static final RiotSkillData ShockingOrb = new RiotSkillData(RiotChampionData.Xerath, 3);

    /** Rite of the Arcane Definition */
    public static final RiotSkillData RiteOfTheArcane = new RiotSkillData(RiotChampionData.Xerath, 4);

    /** Challenge Definition */
    public static final RiotSkillData Challenge = new RiotSkillData(RiotChampionData.XinZhao, 0);

    /** Three Talon Strike Definition */
    public static final RiotSkillData ThreeTalonStrike = new RiotSkillData(RiotChampionData.XinZhao, 1);

    /** Battle Cry Definition */
    public static final RiotSkillData BattleCry = new RiotSkillData(RiotChampionData.XinZhao, 2);

    /** Audacious Charge Definition */
    public static final RiotSkillData AudaciousCharge = new RiotSkillData(RiotChampionData.XinZhao, 3);

    /** Crescent Sweep Definition */
    public static final RiotSkillData CrescentSweep = new RiotSkillData(RiotChampionData.XinZhao, 4);

    /** Way of the Wanderer Definition */
    public static final RiotSkillData WayOfTheWanderer = new RiotSkillData(RiotChampionData.Yasuo, 0);

    /** Steel Tempest Definition */
    public static final RiotSkillData SteelTempest = new RiotSkillData(RiotChampionData.Yasuo, 1);

    /** Wind Wall Definition */
    public static final RiotSkillData WindWall = new RiotSkillData(RiotChampionData.Yasuo, 2);

    /** Sweeping Blade Definition */
    public static final RiotSkillData SweepingBlade = new RiotSkillData(RiotChampionData.Yasuo, 3);

    /** Last Breath Definition */
    public static final RiotSkillData LastBreath = new RiotSkillData(RiotChampionData.Yasuo, 4);

    /** Unholy Covenant Definition */
    public static final RiotSkillData UnholyCovenant = new RiotSkillData(RiotChampionData.Yorick, 0);

    /** Omen of War Definition */
    public static final RiotSkillData OmenOfWar = new RiotSkillData(RiotChampionData.Yorick, 1);

    /** Omen of Pestilence Definition */
    public static final RiotSkillData OmenOfPestilence = new RiotSkillData(RiotChampionData.Yorick, 2);

    /** Omen of Famine Definition */
    public static final RiotSkillData OmenOfFamine = new RiotSkillData(RiotChampionData.Yorick, 3);

    /** Omen of Death Definition */
    public static final RiotSkillData OmenOfDeath = new RiotSkillData(RiotChampionData.Yorick, 4);

    /** Cell Division Definition */
    public static final RiotSkillData CellDivision = new RiotSkillData(RiotChampionData.Zac, 0);

    /** Stretching Strike Definition */
    public static final RiotSkillData StretchingStrike = new RiotSkillData(RiotChampionData.Zac, 1);

    /** Unstable Matter Definition */
    public static final RiotSkillData UnstableMatter = new RiotSkillData(RiotChampionData.Zac, 2);

    /** Elastic Slingshot Definition */
    public static final RiotSkillData ElasticSlingshot = new RiotSkillData(RiotChampionData.Zac, 3);

    /** Let's Bounce! Definition */
    public static final RiotSkillData LetsBounce = new RiotSkillData(RiotChampionData.Zac, 4);

    /** Contempt for the Weak Definition */
    public static final RiotSkillData ContemptforTheWeak = new RiotSkillData(RiotChampionData.Zed, 0);

    /** Razor Shuriken Definition */
    public static final RiotSkillData RazorShuriken = new RiotSkillData(RiotChampionData.Zed, 1);

    /** Living Shadow Definition */
    public static final RiotSkillData LivingShadow = new RiotSkillData(RiotChampionData.Zed, 2);

    /** Shadow Slash Definition */
    public static final RiotSkillData ShadowSlash = new RiotSkillData(RiotChampionData.Zed, 3);

    /** Death Mark Definition */
    public static final RiotSkillData DeathMark = new RiotSkillData(RiotChampionData.Zed, 4);

    /** Short Fuse Definition */
    public static final RiotSkillData ShortFuse = new RiotSkillData(RiotChampionData.Ziggs, 0);

    /** Bouncing Bomb Definition */
    public static final RiotSkillData BouncingBomb = new RiotSkillData(RiotChampionData.Ziggs, 1);

    /** Satchel Charge Definition */
    public static final RiotSkillData SatchelCharge = new RiotSkillData(RiotChampionData.Ziggs, 2);

    /** Hexplosive Minefield Definition */
    public static final RiotSkillData HexplosiveMinefield = new RiotSkillData(RiotChampionData.Ziggs, 3);

    /** Mega Inferno Bomb Definition */
    public static final RiotSkillData MegaInfernoBomb = new RiotSkillData(RiotChampionData.Ziggs, 4);

    /** Heightened Learning Definition */
    public static final RiotSkillData HeightenedLearning = new RiotSkillData(RiotChampionData.Zilean, 0);

    /** Time Bomb Definition */
    public static final RiotSkillData TimeBomb = new RiotSkillData(RiotChampionData.Zilean, 1);

    /** Rewind Definition */
    public static final RiotSkillData Rewind = new RiotSkillData(RiotChampionData.Zilean, 2);

    /** Time Warp Definition */
    public static final RiotSkillData TimeWarp = new RiotSkillData(RiotChampionData.Zilean, 3);

    /** Chronoshift Definition */
    public static final RiotSkillData Chronoshift = new RiotSkillData(RiotChampionData.Zilean, 4);

    /** Rise of the Thorns Definition */
    public static final RiotSkillData RiseOfTheThorns = new RiotSkillData(RiotChampionData.Zyra, 0);

    /** Deadly Bloom Definition */
    public static final RiotSkillData DeadlyBloom = new RiotSkillData(RiotChampionData.Zyra, 1);

    /** Rampant Growth Definition */
    public static final RiotSkillData RampantGrowth = new RiotSkillData(RiotChampionData.Zyra, 2);

    /** Grasping Roots Definition */
    public static final RiotSkillData GraspingRoots = new RiotSkillData(RiotChampionData.Zyra, 3);

    /** Stranglethorns Definition */
    public static final RiotSkillData Stranglethorns = new RiotSkillData(RiotChampionData.Zyra, 4);

    /** Skill status. */
    public final RiotChampionData data;

    /** Skill status. */
    public final int index;

    /**
     * The skill definition.
     */
    private RiotSkillData(RiotChampionData data, int index) {
        this.data = data;
        this.index = index;
    }
}
