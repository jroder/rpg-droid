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

@CharSheet_PageInfo(title = "Details")
public class Fragment_Basic extends Fragment
{
    private ViewBinder mViewBinder = null;

    private Character mCharacter = null;

    public Fragment_Basic()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View lRoot =  inflater.inflate(R.layout.pathfinder_fragment_basic, container, false);

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

    private void bindFields(View lRootView)
    {
        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.charname), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getName(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.setName(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.charlevel), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getLevel(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 20; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.setLevel(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.charclass), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getClassName(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.setClassName(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.race), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getRace(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.setRace(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.age), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAge(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 1000; }

            @Override
            public int getMinimum(Object pBoundObj) { return 0; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.setAge(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.gender), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getGender(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.setGender(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.height), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getAppearance().getHeight(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.getAppearance().setHeight(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.weight), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getAppearance().getWeight(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.getAppearance().setWeight(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.hair), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getAppearance().getHairColor(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.getAppearance().setHairColor(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.eyes), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return mCharacter.getAppearance().getEyeColor(); }

            @Override
            public void setValue(Object pBoundObj, String pValue) { mCharacter.getAppearance().setEyeColor(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdBase), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return 0; }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdSwim), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return 0; }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdClimb), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return 0; }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdBurrow), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return 0; }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdFly), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return 0; }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdFlyManeuver), new ViewBinder.EditableStringBinder() {
            @Override
            public String getValue(Object pBoundObj) { return null; }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.strScore), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.STR).getScore(); }

            @Override
            public String getDisplayValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.STR).getDisplayString(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 30; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getAbility(Ability.AbilityName.STR).setScore(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.dexScore), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.DEX).getScore(); }

            @Override
            public String getDisplayValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.DEX).getDisplayString(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 30; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getAbility(Ability.AbilityName.DEX).setScore(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.refSave), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getSavingThrow(SavingThrow.SaveType.REFLEX).getBaseSave(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 20; }

            @Override
            public int getMinimum(Object pBoundObj) { return 0; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getSavingThrow(SavingThrow.SaveType.REFLEX).setBaseSave(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.conScore), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.CON).getScore(); }

            @Override
            public String getDisplayValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.CON).getDisplayString(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 30; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getAbility(Ability.AbilityName.CON).setScore(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.fortSave), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getSavingThrow(SavingThrow.SaveType.FORTITUDE).getBaseSave(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 20; }

            @Override
            public int getMinimum(Object pBoundObj) { return 0; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getSavingThrow(SavingThrow.SaveType.FORTITUDE).setBaseSave(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.intScore), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.INT).getScore(); }

            @Override
            public String getDisplayValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.INT).getDisplayString(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 30; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getAbility(Ability.AbilityName.INT).setScore(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.wisScore), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.WIS).getScore(); }

            @Override
            public String getDisplayValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.WIS).getDisplayString(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 30; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getAbility(Ability.AbilityName.WIS).setScore(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.wilSave), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getSavingThrow(SavingThrow.SaveType.WILLPOWER).getBaseSave(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 20; }

            @Override
            public int getMinimum(Object pBoundObj) { return 0; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getSavingThrow(SavingThrow.SaveType.WILLPOWER).setBaseSave(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.chaScore), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.CHA).getScore(); }

            @Override
            public String getDisplayValue(Object pBoundObj) { return mCharacter.getAbility(Ability.AbilityName.CHA).getDisplayString(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 30; }

            @Override
            public int getMinimum(Object pBoundObj) { return 1; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.getAbility(Ability.AbilityName.CHA).setScore(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.baseAttack1), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getBaseAttackBonus(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 20; }

            @Override
            public int getMinimum(Object pBoundObj) { return 0; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.setBaseAttackBonus(pValue); }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spellResist), new ViewBinder.EditableNumericBinder() {
            @Override
            public int getValue(Object pBoundObj) { return mCharacter.getSpellResistance(); }

            @Override
            public int getMaximum(Object pBoundObj) { return 20; }

            @Override
            public int getMinimum(Object pBoundObj) { return 0; }

            @Override
            public void setValue(Object pBoundObj, int pValue) { mCharacter.setSpellResistance(pValue); }
        });
    }

}
