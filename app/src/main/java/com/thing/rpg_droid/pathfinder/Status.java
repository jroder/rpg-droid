package com.thing.rpg_droid.pathfinder;

/**
 * Created by jon on 14/06/14.
 */
public class Status
{
    private int mCurrentDamage = 0;

    private int mCurrentNonLethalDamage = 0;


    public int getCurrentDamage()
    {
        return mCurrentDamage;
    }

    public void setCurrentDamage(int pValue)
    {
        mCurrentDamage = pValue;
    }

    public int getCurrentNonLethalDamage()
    {
        return mCurrentNonLethalDamage;
    }

    public void setCurrentNonLethalDamage(int pValue)
    {
        mCurrentNonLethalDamage = pValue;
    }

    //TODO other types of conditions.
}
