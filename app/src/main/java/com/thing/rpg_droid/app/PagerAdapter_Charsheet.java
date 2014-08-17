package com.thing.rpg_droid.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jon on 3/08/14.
 */
public class PagerAdapter_Charsheet  extends FragmentPagerAdapter {

    Activity_Charsheet mActivity;

    public PagerAdapter_Charsheet(FragmentManager fm, Activity_Charsheet pActivity) {
        super(fm);

        mActivity = pActivity;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        ICharacter lChar = mActivity.getCharacter();

        if (lChar != null)
        {
            Class<? extends Fragment> pClass = lChar.getPageFragmentClass(position);

            try
            {
                Constructor<? extends Fragment> lConstructor = pClass.getConstructor(new Class[] { });

                return lConstructor.newInstance();
            }
            catch (NoSuchMethodException e)
            {
                e.printStackTrace();
            }
            catch (InvocationTargetException e)
            {
                e.printStackTrace();
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public int getCount() {

        ICharacter lChar = mActivity.getCharacter();

        if (lChar != null)
        {
            return lChar.getPageCount();
        }

        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        ICharacter lChar = mActivity.getCharacter();

        if (lChar != null)
        {
            Class<? extends Fragment> pClass = lChar.getPageFragmentClass(position);

            if (pClass.isAnnotationPresent(CharSheet_PageInfo.class))
            {
                CharSheet_PageInfo lTitleInfo = pClass.getAnnotation(CharSheet_PageInfo.class);
                return lTitleInfo.title();
            }
            else
            {
                return pClass.getSimpleName();
            }
        }

        return null;
    }
}
