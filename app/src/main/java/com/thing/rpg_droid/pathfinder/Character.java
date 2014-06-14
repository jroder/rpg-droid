/**
 * Created by jon on 8/06/14.
 */

package com.thing.rpg_droid.pathfinder;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.EnumMap;

public class Character
{ 
	private String mName = "";

    private String mClassName = "";
	
	private int mLevel = 1;

    private SizeModifier mSize = SizeModifier.Medium;
	
	private Appearance mAppearance = new Appearance();
	
	private EnumMap<Ability.AbilityName, Ability> mAbilities = new EnumMap<Ability.AbilityName, Ability>(Ability.AbilityName.class);

    private EnumMap<SavingThrow.SaveType, SavingThrow> mSavingThrows = new EnumMap<SavingThrow.SaveType, SavingThrow>(SavingThrow.SaveType.class);

    private EnumMap<BodySlot, IInventoryLocation> mEquipped = new EnumMap<BodySlot, IInventoryLocation>(BodySlot.class);

    private ArrayList<IInventoryLocation> mInventory = new ArrayList<IInventoryLocation>();

    private IInventoryLocation mDefault = null;

    //TODO gear referring to slot

	private ArrayList<Skill> mSkills = new ArrayList<Skill>();
	
	private ArrayList<Spell> mSpells = new ArrayList<Spell>();

    private ArmorClass mArmorClass = new ArmorClass();

    private int mBaseAttackBonus = 0;

    private int mTotalHitPoints = 0;
	
	public Character()
	{
		
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

    /***
     *
     * @param pStream
     */
    public void Save(OutputStream pStream)
    {

    }
	
	public String getName() { return mName; }
	
	public void setName(String pName) { mName = pName; }
	
	public Ability getAbility(Ability.AbilityName pName) { return mAbilities.get(pName); }
	
	public void setAbility(Ability.AbilityName pName, Ability pAbility) { mAbilities.put(pName, pAbility); }

    public SavingThrow getSavingThrow(SavingThrow.SaveType pType) { return mSavingThrows.get(pType); }

    public int getCMB()
    {
        return mBaseAttackBonus + getAbility(Ability.AbilityName.STR).getCurrentModifier() + mSize.getValue();
        //TODO other bonuses
    }

    public int getCMD()
    {
        return mBaseAttackBonus + getAbility(Ability.AbilityName.STR).getCurrentModifier()+
                getAbility(Ability.AbilityName.DEX).getCurrentModifier() + mSize.getValue() + 10;
        //TODO other bonuses
    }


}
