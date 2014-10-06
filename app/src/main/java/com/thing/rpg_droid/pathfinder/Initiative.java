package com.thing.rpg_droid.pathfinder;

/**
 * Created by jon on 4/10/14.
 */
public class Initiative {

    private Character mCharacter;

    private int mMiscBonus;

    public Initiative(Character pCharacter) {
        mCharacter = pCharacter;
    }

    public int getTotal() {
        return mCharacter.getAbility(Ability.AbilityName.DEX).getCurrentModifier() + mMiscBonus;
    }

    public int getMiscBonus() {
        return mMiscBonus;
    }

    public void setMiscBonus(int pValue) {
        mMiscBonus = pValue;
    }
}
