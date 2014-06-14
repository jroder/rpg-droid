package com.thing.rpg_droid.pathfinder;

/**
 * Created by jon on 14/06/14.
 */
public enum SizeModifier
{
    Fine(-8),
    Diminutive(-4),
    Tiny(-2),
    Small(-1),
    Medium(0),
    Large(1),
    Huge(2),
    Gargantuan(4),
    Colossal(8);

    private int mID;

    SizeModifier(int pID)
    {
        mID = pID;
    }

    public int getValue()
    {
        return mID;
    }
}
