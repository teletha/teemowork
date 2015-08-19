package teemowork.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link IcyBuildModel}.
 *
 * @version 2015-08-19T17:50:41.027
 */
public abstract class IcyBuild extends IcyBuildModel implements Manipulatable<IcyBuild> {

     /** The model manipulator for reuse. */
     private static final Manipulator MANIPULATOR = new Manipulator(null);

     /**
      * HIDE CONSTRUCTOR
      */
     protected IcyBuild() {
     }

     /**
     * Retrieve version property.
     */
     public Version version() {
         return this.version;
     }

     /**
     * Modify version property.
     */
     public IcyBuild version(Version value) {
         this.version = value;

         return this;
     }

     /**
     * Retrieve champion property.
     */
     public Champion champion() {
         return this.champion;
     }

     /**
     * Modify champion property.
     */
     public IcyBuild champion(Champion value) {
         this.champion = value;

         return this;
     }

     /**
     * Retrieve level property.
     */
     public int level() {
         return this.level;
     }

     /**
     * Modify level property.
     */
     public IcyBuild level(int value) {
         this.level = value;

         return this;
     }

     /**
     * Retrieve skillQLevel property.
     */
     public int skillQLevel() {
         return this.skillQLevel;
     }

     /**
     * Modify skillQLevel property.
     */
     public IcyBuild skillQLevel(int value) {
         this.skillQLevel = value;

         return this;
     }

     /**
     * Retrieve skillWLevel property.
     */
     public int skillWLevel() {
         return this.skillWLevel;
     }

     /**
     * Modify skillWLevel property.
     */
     public IcyBuild skillWLevel(int value) {
         this.skillWLevel = value;

         return this;
     }

     /**
     * Retrieve skillELevel property.
     */
     public int skillELevel() {
         return this.skillELevel;
     }

     /**
     * Modify skillELevel property.
     */
     public IcyBuild skillELevel(int value) {
         this.skillELevel = value;

         return this;
     }

     /**
     * Retrieve skillRLevel property.
     */
     public int skillRLevel() {
         return this.skillRLevel;
     }

     /**
     * Modify skillRLevel property.
     */
     public IcyBuild skillRLevel(int value) {
         this.skillRLevel = value;

         return this;
     }

     /**
     * Retrieve skillQActive property.
     */
     public boolean skillQActive() {
         return this.skillQActive;
     }

     /**
     * Modify skillQActive property.
     */
     public IcyBuild skillQActive(boolean value) {
         this.skillQActive = value;

         return this;
     }

     /**
     * Retrieve skillWActive property.
     */
     public boolean skillWActive() {
         return this.skillWActive;
     }

     /**
     * Modify skillWActive property.
     */
     public IcyBuild skillWActive(boolean value) {
         this.skillWActive = value;

         return this;
     }

     /**
     * Retrieve skillEActive property.
     */
     public boolean skillEActive() {
         return this.skillEActive;
     }

     /**
     * Modify skillEActive property.
     */
     public IcyBuild skillEActive(boolean value) {
         this.skillEActive = value;

         return this;
     }

     /**
     * Retrieve skillRActive property.
     */
     public boolean skillRActive() {
         return this.skillRActive;
     }

     /**
     * Modify skillRActive property.
     */
     public IcyBuild skillRActive(boolean value) {
         this.skillRActive = value;

         return this;
     }

     /**
     * Retrieve item1 property.
     */
     public Item item1() {
         return this.item1;
     }

     /**
     * Modify item1 property.
     */
     public IcyBuild item1(Item value) {
         this.item1 = value;

         return this;
     }

     /**
     * Retrieve item2 property.
     */
     public Item item2() {
         return this.item2;
     }

     /**
     * Modify item2 property.
     */
     public IcyBuild item2(Item value) {
         this.item2 = value;

         return this;
     }

     /**
     * Retrieve item3 property.
     */
     public Item item3() {
         return this.item3;
     }

     /**
     * Modify item3 property.
     */
     public IcyBuild item3(Item value) {
         this.item3 = value;

         return this;
     }

     /**
     * Retrieve item4 property.
     */
     public Item item4() {
         return this.item4;
     }

     /**
     * Modify item4 property.
     */
     public IcyBuild item4(Item value) {
         this.item4 = value;

         return this;
     }

     /**
     * Retrieve item5 property.
     */
     public Item item5() {
         return this.item5;
     }

     /**
     * Modify item5 property.
     */
     public IcyBuild item5(Item value) {
         this.item5 = value;

         return this;
     }

     /**
     * Retrieve item6 property.
     */
     public Item item6() {
         return this.item6;
     }

     /**
     * Modify item6 property.
     */
     public IcyBuild item6(Item value) {
         this.item6 = value;

         return this;
     }

     /**
      * Create model builder without base model.
      */
     public static final IcyBuild with() {
         return new Melty(null);
     }

     /**
      * Create model builder using the specified definition as base model.
      */
     public static final IcyBuild with(IcyBuild base) {
         return new Melty(base);
     }

     /**
      * Create model manipulator.
      */
     public static final Manipulator<IcyBuild>manipulate() {
         return MANIPULATOR;
     }

     /**
      * Immutable Model.
      */
     private static final class Icy extends IcyBuild {

         /**
          * HIDE CONSTRUCTOR
          */
         private Icy(Version version, Champion champion, int level, int skillQLevel, int skillWLevel, int skillELevel, int skillRLevel, boolean skillQActive, boolean skillWActive, boolean skillEActive, boolean skillRActive, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6) {
                 this.version = version;
                 this.champion = champion;
                 this.level = level;
                 this.skillQLevel = skillQLevel;
                 this.skillWLevel = skillWLevel;
                 this.skillELevel = skillELevel;
                 this.skillRLevel = skillRLevel;
                 this.skillQActive = skillQActive;
                 this.skillWActive = skillWActive;
                 this.skillEActive = skillEActive;
                 this.skillRActive = skillRActive;
                 this.item1 = item1;
                 this.item2 = item2;
                 this.item3 = item3;
                 this.item4 = item4;
                 this.item5 = item5;
                 this.item6 = item6;
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild melt() {
             return new Melty(this);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild version(Version value) {
             if (this.version == value) {
                 return this;
             }
             return new Icy(value, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild champion(Champion value) {
             if (this.champion == value) {
                 return this;
             }
             return new Icy(this.version, value, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild level(int value) {
             if (this.level == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, value, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillQLevel(int value) {
             if (this.skillQLevel == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, value, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillWLevel(int value) {
             if (this.skillWLevel == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, value, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillELevel(int value) {
             if (this.skillELevel == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, value, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillRLevel(int value) {
             if (this.skillRLevel == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, value, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillQActive(boolean value) {
             if (this.skillQActive == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, value, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillWActive(boolean value) {
             if (this.skillWActive == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, value, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillEActive(boolean value) {
             if (this.skillEActive == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, value, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild skillRActive(boolean value) {
             if (this.skillRActive == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, value, this.item1, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild item1(Item value) {
             if (this.item1 == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, value, this.item2, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild item2(Item value) {
             if (this.item2 == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, value, this.item3, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild item3(Item value) {
             if (this.item3 == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, value, this.item4, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild item4(Item value) {
             if (this.item4 == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, value, this.item5, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild item5(Item value) {
             if (this.item5 == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, value, this.item6);
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild item6(Item value) {
             if (this.item6 == value) {
                 return this;
             }
             return new Icy(this.version, this.champion, this.level, this.skillQLevel, this.skillWLevel, this.skillELevel, this.skillRLevel, this.skillQActive, this.skillWActive, this.skillEActive, this.skillRActive, this.item1, this.item2, this.item3, this.item4, this.item5, value);
         }

     }
     /**
      * Mutable Model.
      */
     private static final class Melty extends IcyBuild {

         /**
          * HIDE CONSTRUCTOR
          */
         private Melty(IcyBuild base) {
             if (base != null) {
                 this.version = base.version;
                 this.champion = base.champion;
                 this.level = base.level;
                 this.skillQLevel = base.skillQLevel;
                 this.skillWLevel = base.skillWLevel;
                 this.skillELevel = base.skillELevel;
                 this.skillRLevel = base.skillRLevel;
                 this.skillQActive = base.skillQActive;
                 this.skillWActive = base.skillWActive;
                 this.skillEActive = base.skillEActive;
                 this.skillRActive = base.skillRActive;
                 this.item1 = base.item1;
                 this.item2 = base.item2;
                 this.item3 = base.item3;
                 this.item4 = base.item4;
                 this.item5 = base.item5;
                 this.item6 = base.item6;
             }
         }

         /**
          * {@inheritDoc}
          */
         @Override
         public IcyBuild ice() {
             return new Icy(version, champion, level, skillQLevel, skillWLevel, skillELevel, skillRLevel, skillQActive, skillWActive, skillEActive, skillRActive, item1, item2, item3, item4, item5, item6);
         }
     }
     /**
      * Model Manipulator.
      */
     public static final class Manipulator<RootModel> extends icy.manipulator.Manipulator<RootModel,IcyBuild> {

         /** The accessor for version property. */
         private static final Accessor VERSION = Accessor.<IcyBuild, Version> of(IcyBuild::version,  IcyBuild::version);

         /** The accessor for champion property. */
         private static final Accessor CHAMPION = Accessor.<IcyBuild, Champion> of(IcyBuild::champion,  IcyBuild::champion);

         /** The accessor for level property. */
         private static final Accessor LEVEL = Accessor.<IcyBuild, Integer> of(IcyBuild::level,  IcyBuild::level);

         /** The accessor for skillQLevel property. */
         private static final Accessor SKILLQLEVEL = Accessor.<IcyBuild, Integer> of(IcyBuild::skillQLevel,  IcyBuild::skillQLevel);

         /** The accessor for skillWLevel property. */
         private static final Accessor SKILLWLEVEL = Accessor.<IcyBuild, Integer> of(IcyBuild::skillWLevel,  IcyBuild::skillWLevel);

         /** The accessor for skillELevel property. */
         private static final Accessor SKILLELEVEL = Accessor.<IcyBuild, Integer> of(IcyBuild::skillELevel,  IcyBuild::skillELevel);

         /** The accessor for skillRLevel property. */
         private static final Accessor SKILLRLEVEL = Accessor.<IcyBuild, Integer> of(IcyBuild::skillRLevel,  IcyBuild::skillRLevel);

         /** The accessor for skillQActive property. */
         private static final Accessor SKILLQACTIVE = Accessor.<IcyBuild, Boolean> of(IcyBuild::skillQActive,  IcyBuild::skillQActive);

         /** The accessor for skillWActive property. */
         private static final Accessor SKILLWACTIVE = Accessor.<IcyBuild, Boolean> of(IcyBuild::skillWActive,  IcyBuild::skillWActive);

         /** The accessor for skillEActive property. */
         private static final Accessor SKILLEACTIVE = Accessor.<IcyBuild, Boolean> of(IcyBuild::skillEActive,  IcyBuild::skillEActive);

         /** The accessor for skillRActive property. */
         private static final Accessor SKILLRACTIVE = Accessor.<IcyBuild, Boolean> of(IcyBuild::skillRActive,  IcyBuild::skillRActive);

         /** The accessor for item1 property. */
         private static final Accessor ITEM1 = Accessor.<IcyBuild, Item> of(IcyBuild::item1,  IcyBuild::item1);

         /** The accessor for item2 property. */
         private static final Accessor ITEM2 = Accessor.<IcyBuild, Item> of(IcyBuild::item2,  IcyBuild::item2);

         /** The accessor for item3 property. */
         private static final Accessor ITEM3 = Accessor.<IcyBuild, Item> of(IcyBuild::item3,  IcyBuild::item3);

         /** The accessor for item4 property. */
         private static final Accessor ITEM4 = Accessor.<IcyBuild, Item> of(IcyBuild::item4,  IcyBuild::item4);

         /** The accessor for item5 property. */
         private static final Accessor ITEM5 = Accessor.<IcyBuild, Item> of(IcyBuild::item5,  IcyBuild::item5);

         /** The accessor for item6 property. */
         private static final Accessor ITEM6 = Accessor.<IcyBuild, Item> of(IcyBuild::item6,  IcyBuild::item6);

         /**
          * Construct operator.
          */
         public Manipulator(Accessor<RootModel,IcyBuild> parent) {
             super(parent);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Version> version() {
             return parent.then(VERSION);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Champion> champion() {
             return parent.then(CHAMPION);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Integer> level() {
             return parent.then(LEVEL);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Integer> skillQLevel() {
             return parent.then(SKILLQLEVEL);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Integer> skillWLevel() {
             return parent.then(SKILLWLEVEL);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Integer> skillELevel() {
             return parent.then(SKILLELEVEL);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Integer> skillRLevel() {
             return parent.then(SKILLRLEVEL);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Boolean> skillQActive() {
             return parent.then(SKILLQACTIVE);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Boolean> skillWActive() {
             return parent.then(SKILLWACTIVE);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Boolean> skillEActive() {
             return parent.then(SKILLEACTIVE);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Boolean> skillRActive() {
             return parent.then(SKILLRACTIVE);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Item> item1() {
             return parent.then(ITEM1);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Item> item2() {
             return parent.then(ITEM2);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Item> item3() {
             return parent.then(ITEM3);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Item> item4() {
             return parent.then(ITEM4);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Item> item5() {
             return parent.then(ITEM5);
         }

         /**
          * Property operator.
          */
         public Accessor<RootModel,Item> item6() {
             return parent.then(ITEM6);
         }

     }
}
