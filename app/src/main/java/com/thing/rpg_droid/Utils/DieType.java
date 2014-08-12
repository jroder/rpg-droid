package com.thing.rpg_droid.Utils;

/**
 * Created by jon on 12/08/14.
 */
public enum DieType
{
    D4 (1,4),
    D6 (1,6),
    D8 (1,8),
    D10 (1,10),
    D12 (1,12),
    D20 (1,20),
    D100 (1,100),
    Percentile (0,99);

    private int mMin;
    private int mMax;

    private DieType(int pMin, int pMax)
    {
        mMin = pMin;
        mMax = pMax;
    }

    public int getMin()
    {
        return mMin;
    }

    public int getMax()
    {
        return mMax;
    }
}
