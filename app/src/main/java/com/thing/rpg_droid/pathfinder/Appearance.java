/**
 * Created by jon on 8/06/14.
 */

package com.thing.rpg_droid.pathfinder;

public class Appearance
{
    private String mEyeColor = "";

    private String mHairColor = "";

    private String mHeight = "";

    private String mWeight = "";

    private String mNotes = "";

    public Appearance()
    {

    }

    public String getEyeColor()
    {
        return mEyeColor;
    }

    public void setEyeColor(String pValue)
    {
        mEyeColor = pValue;
    }

    public String getHairColor()
    {
        return mHairColor;
    }

    public void setHairColor(String pValue)
    {
        mHairColor = pValue;
    }

    public String getHeight()
    {
        return mHeight;
    }

    public void setHeight(String pValue)
    {
        mHeight = pValue;
    }

    public String getWeight()
    {
        return mWeight;
    }

    public void setWeight(String pValue)
    {
        mWeight = pValue;
    }

    public String getNotes()
    {
        return mNotes;
    }

    public void setNotes(String pValue)
    {
        mNotes = pValue;
    }
}
