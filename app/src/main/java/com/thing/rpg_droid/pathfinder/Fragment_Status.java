package com.thing.rpg_droid.pathfinder;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thing.rpg_droid.app.Activity_Charsheet;
import com.thing.rpg_droid.app.CharSheet_PageInfo;
import com.thing.rpg_droid.app.ICharacter;
import com.thing.rpg_droid.app.ViewBinder;
import com.thing.rpg_droid.app.View_CharacterSheet_Field;
import com.thing.rpg_droid.res.R;

@CharSheet_PageInfo(title = "Status")
public class Fragment_Status extends Fragment {

    private ViewBinder mViewBinder = null;

    private Character mCharacter = null;

    public Fragment_Status() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View lRoot = inflater.inflate(R.layout.pathfinder_fragment_status, container, false);

        ICharacter lChar = ((Activity_Charsheet)getActivity()).getCharacter();

        if (lChar instanceof Character)
        {
            mCharacter = (Character)lChar;

            mViewBinder = new ViewBinder(this.getActivity());

            bindFields(lRoot);

            mViewBinder.update();
        }

        return lRoot;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void bindFields(View lRootView) {
        mViewBinder.addBinding((View_CharacterSheet_Field) lRootView.findViewById(R.id.charname), new ViewBinder.StringBinder() {
            @Override
            public String getValue(Object pBoundObj) {
                return mCharacter.getName();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field) lRootView.findViewById(R.id.stdac), new ViewBinder.NumericBinder() {
            @Override
            public int getValue(Object pBoundObj) {
                return mCharacter.getArmorClass().getAC(ArmorClass.AttackType.Normal);
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field) lRootView.findViewById(R.id.touchac), new ViewBinder.NumericBinder() {
            @Override
            public int getValue(Object pBoundObj) {
                return mCharacter.getArmorClass().getAC(ArmorClass.AttackType.Touch);
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field) lRootView.findViewById(R.id.ffac), new ViewBinder.NumericBinder() {
            @Override
            public int getValue(Object pBoundObj) {
                return mCharacter.getArmorClass().getAC(ArmorClass.AttackType.FlatFooted);
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field) lRootView.findViewById(R.id.initiative), new ViewBinder.NumericBinder() {
            @Override
            public int getValue(Object pBoundObj) {
                return mCharacter.getInitiative().getTotal();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field) lRootView.findViewById(R.id.spdBase), new ViewBinder.NumericBinder() {
            @Override
            public int getValue(Object pBoundObj) {
                return 0;
            }
        });

    }
}
