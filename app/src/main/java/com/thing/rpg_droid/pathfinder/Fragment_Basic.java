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
    private ViewBinder mViewBinder = new ViewBinder();

    private Character mCharacter = null;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View lRoot =  inflater.inflate(R.layout.pathfinder_fragment_basic, container, false);

        ICharacter lChar = ((Activity_Charsheet)getActivity()).getCharacter();

        if (lChar instanceof Character)
        {
            mCharacter = (Character)lChar;

            bindFields(lRoot);
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
        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.charname), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getName();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.charlevel), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getLevel());
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.charclass), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getClassName();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.race), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getRace();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.age), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getAge());
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.gender), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getGender();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.height), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAppearance().getHeight();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.weight), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAppearance().getWeight();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.hair), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAppearance().getHairColor();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.eyes), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAppearance().getEyeColor();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdBase), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return null;
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdSwim), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return null;
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdClimb), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return null;
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdBurrow), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return null;
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdFly), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return null;
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spdFlyManeuver), new ViewBinder.StringBinder() {
            @Override
            public String getValue() {
                return null;
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.strScore), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAbility(Ability.AbilityName.STR).getDisplayString();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.dexScore), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAbility(Ability.AbilityName.DEX).getDisplayString();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.refSave), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getSavingThrow(SavingThrow.SaveType.REFLEX).getBaseSave());
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.conScore), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAbility(Ability.AbilityName.CON).getDisplayString();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.fortSave), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getSavingThrow(SavingThrow.SaveType.FORTITUDE).getBaseSave());
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.intScore), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAbility(Ability.AbilityName.INT).getDisplayString();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.wisScore), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAbility(Ability.AbilityName.WIS).getDisplayString();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.wilSave), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getSavingThrow(SavingThrow.SaveType.WILLPOWER).getBaseSave());
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.chaScore), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return mCharacter.getAbility(Ability.AbilityName.CHA).getDisplayString();
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.baseAttack), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getBaseAttackBonus());
            }
        });

        mViewBinder.addBinding((View_CharacterSheet_Field)lRootView.findViewById(R.id.spellResist), new ViewBinder.NumericBinder() {
            @Override
            public String getValue() {
                return Integer.toString(mCharacter.getSpellResistance());
            }
        });
    }

}
