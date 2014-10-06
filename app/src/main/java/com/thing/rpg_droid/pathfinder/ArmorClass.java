package com.thing.rpg_droid.pathfinder;

/**
 * Created by jon on 14/06/14.
 */
public class ArmorClass {
    public enum AttackType {Normal, Touch, FlatFooted}

    private int mNaturalArmor = 0;

    private int mMiscModifier = 0;

    private Character mCharacter = null;

    public ArmorClass(Character pCharacter)
    {
        mCharacter = pCharacter;
    }

    public int getArmorBonus()
    {
        return 0;
        //TODO scrape equipped gear for armor bonus
    }

    public int getShieldBonus()
    {
        return 0;
        //TODO scrape equipped gear for shield bonus
    }

    public int getDexModifier()
    {
        return mCharacter.getAbility(Ability.AbilityName.DEX).getCurrentModifier();
    }

    public int getSizeModifier()
    {
        return - mCharacter.getSize().getValue();
    }

    public int getNaturalArmor()
    {
        return mNaturalArmor;
    }

    public void setNaturalArmor(int pValue)
    {
        mNaturalArmor = pValue;
    }

    public int getDeflectionModifier()
    {
        return 0;
        //TODO scrape gear and active spells for deflection
    }

    public int getMiscModifier()
    {
        return mMiscModifier;
    }

    public void setMiscModifier(int pValue)
    {
        mMiscModifier = pValue;
    }

    public int getAC(AttackType pType)
    {
        //TODO dodge bonus??

        switch (pType)
        {
            case Touch:
                return 10 + getDexModifier() + getSizeModifier() + getDeflectionModifier() + getMiscModifier();
            case FlatFooted:
                return 10 + getArmorBonus() + Math.min(getDexModifier(), 0) + getSizeModifier() + getNaturalArmor() +
                        getDeflectionModifier() + getMiscModifier();
            default:
                return 10 + getArmorBonus() + getShieldBonus() + getDexModifier() + getSizeModifier() + getNaturalArmor() +
                        getDeflectionModifier() + getMiscModifier();
        }
    }
}
