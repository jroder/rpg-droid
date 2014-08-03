package com.thing.rpg_droid.pathfinder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by jon on 3/08/14.
 */
public class PagerAdapter_Charsheet extends FragmentPagerAdapter{

    public PagerAdapter_Charsheet(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return Fragment_Status.newInstance(Integer.toString(position + 1),"");
            case 1: return Fragment_Basic.newInstance(Integer.toString(position + 1),"");
            case 2: return Fragment_Skills.newInstance(Integer.toString(position + 1),"");
            case 3: return Fragment_Spells_Abilities.newInstance(Integer.toString(position + 1),"");
            case 4: return Fragment_Gear.newInstance(Integer.toString(position + 1),"");
        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return Fragment_Status.getTitle();
            case 1: return Fragment_Basic.getTitle();
            case 2: return Fragment_Skills.getTitle();
            case 3: return Fragment_Spells_Abilities.getTitle();
            case 4: return Fragment_Gear.getTitle();
        }
        return null;
    }
}
