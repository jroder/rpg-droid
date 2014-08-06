package com.thing.rpg_droid.app;

import android.app.Fragment;

/**
 * Created by jon on 6/08/14.
 */
public interface ICharacter
{
    int getPageCount();

    Class<? extends Fragment> getPageFragmentClass(int pIndex);
}
