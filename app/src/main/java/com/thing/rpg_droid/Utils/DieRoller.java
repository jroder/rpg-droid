package com.thing.rpg_droid.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by jon on 12/08/14.
 */
public class DieRoller
{
    private static Random mRandom = new Random();

    public static int Roll(DieType lType)
    {
        return mRandom.nextInt(lType.getMax() - lType.getMin() + 1) + lType.getMin();
    }

    public static List<Integer> Roll(DieType lType, int lCount)
    {
        return Roll(lType, lCount, 0);
    }

    public static List<Integer> Roll(DieType lType, int lCount, int lDiscardLowest)
    {
        if (lDiscardLowest >= lCount)
            throw new IllegalArgumentException("Die roll must return at least 1 result");

        ArrayList<Integer> lResult = new ArrayList<Integer>();

        for (int i = 0; i < lCount; i++)
            lResult.add(Roll(lType));

        Collections.sort(lResult);

        for (int i = 0; i < lDiscardLowest; i++)
            lResult.remove(0);

        return lResult;
    }

    public static int RollAndTotal(DieType lType, int lCount)
    {
        return RollAndTotal(lType, lCount, 0);
    }

    public static int RollAndTotal(DieType lType, int lCount, int lDiscardLowest)
    {
        List<Integer> lRolls = Roll(lType, lCount, lDiscardLowest);

        int lResult = 0;

        for(Integer lRoll : lRolls)
            lResult += lRoll;

        return lResult;
    }
}
