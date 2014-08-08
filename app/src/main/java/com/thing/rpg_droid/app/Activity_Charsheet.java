package com.thing.rpg_droid.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.thing.rpg_droid.pathfinder.Character;
import com.thing.rpg_droid.res.R;

import java.util.UUID;

public class Activity_Charsheet extends Activity implements ActionBar.TabListener {

    ICharacter mCharacter;

    PagerAdapter_Charsheet mSectionsPagerAdapter;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charsheet);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);



        Bundle lExtras = getIntent().getExtras();
        if ((lExtras != null) && (lExtras.containsKey("CharacterID")))
        {
            UUID lCharID = (UUID)lExtras.get("CharacterID");

            mCharacter = new Character();
            //load character
        }
        else
        {
            //what?
            mCharacter = new Character();
        }


        mSectionsPagerAdapter = new PagerAdapter_Charsheet(getFragmentManager(), mCharacter);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        //set up the action bar to match the view pager.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_charsheet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

}
