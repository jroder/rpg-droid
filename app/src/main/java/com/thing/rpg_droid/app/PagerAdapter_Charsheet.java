package com.thing.rpg_droid.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.thing.rpg_droid.pathfinder.Fragment_Status;

import java.util.Locale;

/**
 * Created by jon on 3/08/14.
 */
public class PagerAdapter_Charsheet  extends FragmentPagerAdapter {

    public PagerAdapter_Charsheet(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return Fragment_Status.newInstance(Integer.toString(position + 1), "");
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "";
        }
        return null;
    }
}
