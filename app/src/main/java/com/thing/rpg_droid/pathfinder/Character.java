/**
 * Created by jon on 8/06/14.
 */

package com.thing.rpg_droid.pathfinder;

import android.app.Fragment;

import com.thing.rpg_droid.Utils.DieRoller;
import com.thing.rpg_droid.Utils.DieType;
import com.thing.rpg_droid.app.ICharacter;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Character implements ICharacter
{ 
	private String mName = "";

    private int mLevel = 1;

    private String mClassName = "";

    private int mAge = 20;

    private String mRace = "Human";

    private String mGender = "M";

    private Appearance mAppearance = new Appearance();

    private SizeModifier mSize = SizeModifier.Medium;

    private DieType mHitDie = DieType.D8;

    private int mBaseHitPoints = 0;

    private int mBaseAttackBonus = 0;

    private ArmorClass mArmorClass = new ArmorClass(this);

    private int mSpellResistance = 0;

    private Initiative mInitiative = new Initiative(this);

	private EnumMap<Ability.AbilityName, Ability> mAbilities = new EnumMap<Ability.AbilityName, Ability>(Ability.AbilityName.class);

    private EnumMap<SavingThrow.SaveType, SavingThrow> mSavingThrows = new EnumMap<SavingThrow.SaveType, SavingThrow>(SavingThrow.SaveType.class);

    private ArrayList<Skill> mSkills = new ArrayList<Skill>();

    private ArrayList<Spell> mSpells = new ArrayList<Spell>();

    private EnumMap<BodySlot, IInventoryLocation> mEquipped = new EnumMap<BodySlot, IInventoryLocation>(BodySlot.class);

    private ArrayList<IInventoryLocation> mInventory = new ArrayList<IInventoryLocation>();

    private IInventoryLocation mDefault = null;

    //TODO gear referring to slot

	public Character()
	{
        mName = "New Character";
        mClassName = "No Class";
        RandomizeAbilities();
        GenerateSkillList();
        GenerateSavingThrows();

        mBaseHitPoints = DieRoller.Roll(mHitDie);
	}

    /***
     *
     * @param pStream
     */
    public void Save(OutputStream pStream)
    {

    }

    private void RandomizeAbilities()
    {
        for (Ability.AbilityName lAbilityName : Ability.AbilityName.values())
        {
            mAbilities.put(lAbilityName, new Ability(DieRoller.RollAndTotal(DieType.D6, 4, 1), 0));
        }
    }

    private void InitializeSaves()
    {
        for (SavingThrow.SaveType lSaveType : SavingThrow.SaveType.values())
        {
            mSavingThrows.put(lSaveType, new SavingThrow());
        }
    }

    private void GenerateSkillList()
    {
        for (String lSkillName : Skill.standardList.keySet())
        {
            Skill lSkill = new Skill(this, 0, 0, lSkillName, Skill.standardList.get(lSkillName), false);

            mSkills.add(lSkill);
        }
    }

    private void GenerateSavingThrows()
    {
        for (SavingThrow.SaveType lThrowType : SavingThrow.SaveType.values())
        {
            mSavingThrows.put(lThrowType, new SavingThrow());
        }
    }

	public String getName() { return mName; }
	
	public void setName(String pName) { mName = pName; }

    public int getLevel() { return mLevel; }

    public void setLevel(int pValue) { mLevel = pValue; }

    public String getClassName() { return mClassName; }

    public void setClassName(String pValue) { mClassName = pValue; }

    public int getAge() { return mAge; }

    public void setAge(int pValue) { mAge = pValue; }

    public String getRace() { return mRace; }

    public void setRace(String pValue) { mRace = pValue; }

    public String getGender() { return mGender; }

    public void setGender(String pValue) { mGender = pValue; }

    public Appearance getAppearance() { return mAppearance; }

    public SizeModifier getSize() { return mSize; }

    public void setSize(SizeModifier pValue) { mSize = pValue; }

    public DieType getHitDie() { return mHitDie; }

    public void setHitDie(DieType pValue) { mHitDie = pValue; }

    public int getBaseHitPoints() { return mBaseHitPoints; }

    public void setBaseHitPoints(int pValue) { mBaseHitPoints = pValue; }

    public int getTotalHitPoints() { return 0; }//TODO get how.

    public int getBaseAttackBonus() { return mBaseAttackBonus; }

    public void setBaseAttackBonus(int pValue) { mBaseAttackBonus = pValue; }

    //TODO weapon attack bonuses?

    public int getCMB()
    {
        return mBaseAttackBonus + getAbility(Ability.AbilityName.STR).getCurrentModifier() + mSize.getValue();
        //TODO other bonuses
    }

    public ArmorClass getArmorClass() { return mArmorClass; }

    public int getCMD()
    {
        return mBaseAttackBonus + getAbility(Ability.AbilityName.STR).getCurrentModifier()+
                getAbility(Ability.AbilityName.DEX).getCurrentModifier() + mSize.getValue() + 10;
        //TODO other bonuses
    }

    public int getSpellResistance() { return mSpellResistance; }

    public void setSpellResistance(int pValue) { mSpellResistance = pValue; }

    public Initiative getInitiative() { return mInitiative; }
	
	public Ability getAbility(Ability.AbilityName pName) { return mAbilities.get(pName); }

    public SavingThrow getSavingThrow(SavingThrow.SaveType pType) { return mSavingThrows.get(pType); }

    public List<Skill> getSkillList() { return mSkills; }

    public List<Spell> getSpellList() { return mSpells; }




    @Override
    public int getPageCount()
    {
        return 5;
    }

    @Override
    public Class<? extends Fragment> getPageFragmentClass(int pIndex)
    {
        switch (pIndex)
        {
            case 0:return Fragment_Status.class;
            case 1:return Fragment_Basic.class;
            case 2:return Fragment_Skills.class;
            case 3:return Fragment_Spells_Abilities.class;
            case 4:return Fragment_Gear.class;
        }

        return null;
    }


    /***
     *
     * @param pStream
     * @return
     */
    static public Character Load(InputStream pStream)
    {
        return null;
    }
}
