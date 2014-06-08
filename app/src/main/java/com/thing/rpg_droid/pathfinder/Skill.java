/**
 * Created by jon on 8/06/14.
 */

package com.thing.rpg_droid.pathfinder;

public class Skill
{
    private String mName = "";

    private int mRanks = 0;

    private int mMisc = 0;

    private Ability.AbilityName mAbility;

    private boolean mClass = false;

    public Skill () { }

    public Skill(int pRanks, int pMisc, Ability.AbilityName pAbility, boolean pClass)
    {
        mRanks = pRanks;
        mMisc = pMisc;
        mAbility = pAbility;
        mClass = pClass;
    }

    public String getName() { return mName; }

    public void setName(String pValue) { mName = pValue; }

    public int getRanks() { return mRanks; }

    public void setRanks(int pRanks) { mRanks = pRanks; }

    public int getMisc() { return mMisc; }

    public void setMisc(int pMisc) { mMisc = pMisc; }

    public Ability.AbilityName getAbility() { return mAbility; }

    public void setAbility(Ability.AbilityName pAbility) { mAbility = pAbility; }


}
