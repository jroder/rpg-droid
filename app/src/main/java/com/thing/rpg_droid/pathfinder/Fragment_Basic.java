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
import com.thing.rpg_droid.app.View_CharacterSheet_Field;
import com.thing.rpg_droid.res.R;

@CharSheet_PageInfo(title = "Details")
public class Fragment_Basic extends Fragment
{
    public Fragment_Basic()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    private void populateField(View lField, Object lValue)
    {
        if (lField instanceof View_CharacterSheet_Field)
        {
            if (lValue instanceof Integer)
            {
                ((View_CharacterSheet_Field) lField).setValue(Integer.toBinaryString((Integer)lValue));
            }
            else if (lValue instanceof String)
            {
                ((View_CharacterSheet_Field) lField).setValue((String)lValue);
            }
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
            populateField(lRoot.findViewById(R.id.charname), ((Character) lChar).getName());
            populateField(lRoot.findViewById(R.id.charlevel), ((Character) lChar).getLevel());
            populateField(lRoot.findViewById(R.id.charclass), ((Character) lChar).getClassName());
            populateField(lRoot.findViewById(R.id.race), ((Character) lChar).getRace());
            populateField(lRoot.findViewById(R.id.age), ((Character) lChar).getAge());
            populateField(lRoot.findViewById(R.id.gender), ((Character) lChar).getGender());
            populateField(lRoot.findViewById(R.id.height), ((Character) lChar).getAppearance().getHeight());
            populateField(lRoot.findViewById(R.id.weight), ((Character) lChar).getAppearance().getWeight());
            populateField(lRoot.findViewById(R.id.hair), ((Character) lChar).getAppearance().getHairColor());
            populateField(lRoot.findViewById(R.id.eyes), ((Character) lChar).getAppearance().getEyeColor());
//            populateField(lRoot.findViewById(R.id.spdBase), ((Character) lChar).);
//            populateField(lRoot.findViewById(R.id.spdSwim), ((Character) lChar).);
//            populateField(lRoot.findViewById(R.id.spdClimb), ((Character) lChar).);
//            populateField(lRoot.findViewById(R.id.spdBurrow), ((Character) lChar).);
//            populateField(lRoot.findViewById(R.id.spdFly), ((Character) lChar).);
//            populateField(lRoot.findViewById(R.id.spdFlyManeuver), ((Character) lChar).);

            populateField(lRoot.findViewById(R.id.strScore), ((Character) lChar).getAbility(Ability.AbilityName.STR));
            populateField(lRoot.findViewById(R.id.dexScore), ((Character) lChar).getAbility(Ability.AbilityName.DEX));
            populateField(lRoot.findViewById(R.id.refSave), ((Character) lChar).getSavingThrow(SavingThrow.SaveType.REFLEX).getBaseSave());
            populateField(lRoot.findViewById(R.id.conScore), ((Character) lChar).getAbility(Ability.AbilityName.CON));
            populateField(lRoot.findViewById(R.id.fortSave), ((Character) lChar).getSavingThrow(SavingThrow.SaveType.FORTITUDE).getBaseSave());
            populateField(lRoot.findViewById(R.id.intScore), ((Character) lChar).getAbility(Ability.AbilityName.INT));
            populateField(lRoot.findViewById(R.id.wisScore), ((Character) lChar).getAbility(Ability.AbilityName.WIS));
            populateField(lRoot.findViewById(R.id.wilSave), ((Character) lChar).getSavingThrow(SavingThrow.SaveType.WILLPOWER).getBaseSave());
            populateField(lRoot.findViewById(R.id.chaScore), ((Character) lChar).getAbility(Ability.AbilityName.CHA));

            populateField(lRoot.findViewById(R.id.baseAttack), ((Character) lChar).getBaseAttackBonus());
            populateField(lRoot.findViewById(R.id.spellResist), ((Character) lChar).getSpellResistance());
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
}
