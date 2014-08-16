package com.thing.rpg_droid.pathfinder;

/**
 * Created by jon on 14/06/14.
 */
public class SavingThrow
{
    public enum SaveType { FORTITUDE, REFLEX, WILLPOWER }

    private int mBaseSave = 0;

    public SavingThrow()
    {

    }

    public int getBaseSave()
    {
        return mBaseSave;
    }

    public void setBaseSave(int pValue)
    {
        mBaseSave = pValue;
    }
}
