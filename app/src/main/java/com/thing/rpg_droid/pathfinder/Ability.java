/**
 * Created by jon on 8/06/14.
 *
 */

package com.thing.rpg_droid.pathfinder;

public class Ability
{
    public enum AbilityName { STR, DEX, CON, INT, WIS, CHA }

    private int mScore = 10;

    private int mTempAdjust = 0;

    public Ability() { }

    public Ability (int pScore, int pTempAdjust)
    {
        mScore = pScore;
        mTempAdjust = pTempAdjust;
    }

    public int getScore() { return mScore; }

    public void setScore(int pScore) { mScore = pScore; }

    public int getTempAdjust() { return mTempAdjust; }

    public void setTempAdjust(int pTempAdjust) { mTempAdjust = pTempAdjust; }

    public int getCurrentScore() { return mScore + mTempAdjust; }

    public int getModifier() { return (int)Math.floor((getScore() - 10) / 2.0); }

    public int getCurrentModifier() { return (int)Math.floor((getCurrentScore() - 10) / 2.0); }

    public int getBonusSpells(int pSpellLevel)
    {
        if (pSpellLevel < 1)
            return 0;
        else
            return (int)Math.max(Math.ceil((getModifier() - (pSpellLevel - 1)) / 4.0), 0);
    }

    public String getDisplayString()
    {
        return Integer.toString(getScore()) + " [" + Integer.toString(getModifier()) + "]";
    }
}
