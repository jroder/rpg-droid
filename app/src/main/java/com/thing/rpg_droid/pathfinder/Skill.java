/**
 * Created by jon on 8/06/14.
 */

package com.thing.rpg_droid.pathfinder;

import java.util.HashMap;

public class Skill
{
    public static HashMap<String, Ability.AbilityName> standardList = new HashMap<String, Ability.AbilityName>();

    private String mName = "";

    private int mRanks = 0;

    private int mMisc = 0;

    private Ability.AbilityName mAbility;

    private boolean mClass = false;

    private Character mCharacter = null;

    public Skill(Character pCharacter)
    {
        mCharacter = pCharacter;
    }

    public Skill(Character pCharacter, int pRanks, int pMisc, String pName, Ability.AbilityName pAbility, boolean pClass)
    {
        this(pCharacter);
        mName = pName;
        mRanks = pRanks;
        mMisc = pMisc;
        mAbility = pAbility;
        mClass = pClass;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String pValue)
    {
        mName = pValue;
    }

    public int getRanks()
    {
        return mRanks;
    }

    public void setRanks(int pRanks)
    {
        mRanks = pRanks;
    }

    public int getMisc()
    {
        return mMisc;
    }

    public void setMisc(int pMisc)
    {
        mMisc = pMisc;
    }

    public Ability.AbilityName getAbility()
    {
        return mAbility;
    }

    public void setAbility(Ability.AbilityName pAbility)
    {
        mAbility = pAbility;
    }

    public boolean getClassSkill()
    {
        return mClass;
    }

    public void setClassSkill(boolean pValue)
    {
        mClass = pValue;
    }

    public int getTotal()
    {
        int lResult = 0;

        lResult += (mRanks + mMisc + mCharacter.getAbility(mAbility).getCurrentModifier());

        if (mClass && (mRanks > 0))
            lResult += 3;

        return lResult;
    }


    static
    {
        standardList.put("Acrobatics", Ability.AbilityName.DEX);
        standardList.put("Appraise", Ability.AbilityName.INT);
        standardList.put("Bluff", Ability.AbilityName.CHA);
        standardList.put("Climb", Ability.AbilityName.STR);
        standardList.put("Craft", Ability.AbilityName.INT);
        standardList.put("Diplomacy", Ability.AbilityName.CHA);
        standardList.put("Disable Device", Ability.AbilityName.DEX);
        standardList.put("Disguise", Ability.AbilityName.CHA);
        standardList.put("Escape Artist", Ability.AbilityName.DEX);
        standardList.put("Fly", Ability.AbilityName.DEX);
        standardList.put("Handle Animal", Ability.AbilityName.CHA);
        standardList.put("Heal", Ability.AbilityName.WIS);
        standardList.put("Intimidate", Ability.AbilityName.CHA);
        standardList.put("Knowledge - Arcana", Ability.AbilityName.INT);
        standardList.put("Knowledge - Dungeoneering", Ability.AbilityName.INT);
        standardList.put("Knowledge - Engineering", Ability.AbilityName.INT);
        standardList.put("Knowledge - Geography", Ability.AbilityName.INT);
        standardList.put("Knowledge - History", Ability.AbilityName.INT);
        standardList.put("Knowledge - Local", Ability.AbilityName.INT);
        standardList.put("Knowledge - Nature", Ability.AbilityName.INT);
        standardList.put("Knowledge - Nobility", Ability.AbilityName.INT);
        standardList.put("Knowledge - Planes", Ability.AbilityName.INT);
        standardList.put("Knowledge - Religion", Ability.AbilityName.INT);
        standardList.put("Linguistics", Ability.AbilityName.INT);
        standardList.put("Perception", Ability.AbilityName.WIS);
        standardList.put("Perform", Ability.AbilityName.CHA);
        standardList.put("Profession", Ability.AbilityName.WIS);
        standardList.put("Ride", Ability.AbilityName.DEX);
        standardList.put("Sense Motive", Ability.AbilityName.WIS);
        standardList.put("Sleight of Hand", Ability.AbilityName.DEX);
        standardList.put("Spellcraft", Ability.AbilityName.INT);
        standardList.put("Stealth", Ability.AbilityName.DEX);
        standardList.put("Survival", Ability.AbilityName.WIS);
        standardList.put("Swim", Ability.AbilityName.STR);
        standardList.put("Use Magic Device", Ability.AbilityName.CHA);
    }
}
