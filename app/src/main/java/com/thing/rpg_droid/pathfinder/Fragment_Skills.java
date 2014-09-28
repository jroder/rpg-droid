package com.thing.rpg_droid.pathfinder;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.thing.rpg_droid.app.Activity_Charsheet;
import com.thing.rpg_droid.app.CharSheet_PageInfo;
import com.thing.rpg_droid.app.ICharacter;
import com.thing.rpg_droid.app.ViewBinder;
import com.thing.rpg_droid.res.R;

import java.util.List;

@CharSheet_PageInfo(title = "Skills")
public class Fragment_Skills extends Fragment {

    private SkillListAdapter mCharSkillAdapter;

    public Fragment_Skills() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState)
    {
        ListView lListView = (ListView)pInflater.inflate(R.layout.pathfinder_fragment_skills, pContainer, false);

        ICharacter lChar = ((Activity_Charsheet)getActivity()).getCharacter();

        if (lChar instanceof Character)
        {
            mCharSkillAdapter = new SkillListAdapter(getActivity(),
                                                     ((Character) lChar).getSkillList());

            lListView.setAdapter(mCharSkillAdapter);
        }

        return lListView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    private static class SkillViewHolder
    {
        public TextView skillNameView;
        public TextView skillAbilityView;
        public TextView skillRanksView;
        public TextView skillMiscView;
        public TextView skillTotalView;
    }

    public static class SkillListAdapter extends BaseAdapter
    {
        private Context mContext;

        private List<Skill> mSkills;

        public SkillListAdapter(Context pContext, List<Skill> pSkills)
        {
            super();

            mContext = pContext;
            mSkills = pSkills;
        }

        public int getSkillCount()
        {
            return mSkills.size();
        }

        public Skill getSkill(int i)
        {
            return mSkills.get(i);
        }

        public void putSkill(Skill pSkill)
        {
            mSkills.add(pSkill);
        }

        public void removeSkill(int i)
        {
            mSkills.remove(i);
        }

        public void clearSkills()
        {
            mSkills.clear();
        }

        @Override
        public int getCount()
        {
            if (mSkills != null)
                return mSkills.size();
            else
                return 0;
        }

        @Override
        public int getViewTypeCount()
        {
            return 1;
        }

        @Override
        public Object getItem(int pPosition)
        {
            if (mSkills != null)
            {
                if (pPosition < mSkills.size())
                    return mSkills.get(pPosition);
                else
                    return null;
            }
            else
            {
                return null;
            }
        }

        @Override
        public long getItemId(int pPosition)
        {
            return pPosition;
        }

        @Override
        public View getView(int pPosition, View pConvertView, ViewGroup pParent)
        {
            ViewGroup lView = (ViewGroup) pConvertView;

            final Skill lItem = mSkills.get(pPosition);

            if (lView == null)
            {
                lView = (ViewGroup) LayoutInflater.from(mContext).inflate(
                        R.layout.pathfinder_view_skill, null);
//                final SkillViewHolder lHolder = new SkillViewHolder();
//                lHolder.skillNameView = (TextView) lView.findViewById(R.id.skill_name);
//                lHolder.skillAbilityView = (TextView) lView.findViewById(R.id.skill_ability);
//                lHolder.skillRanksView = (TextView) lView.findViewById(R.id.skill_ranks);
//                lHolder.skillMiscView = (TextView) lView.findViewById(R.id.skill_misc);
//                lHolder.skillTotalView = (TextView)lView.findViewById(R.id.skill_total);

                final ViewBinder lBinder = new ViewBinder(mContext);
                lBinder.addBinding((TextView)lView.findViewById(R.id.skill_name), new ViewBinder.EditableStringBinder() {
                    @Override
                    public String getValue(Object pBoundObj) { return ((Skill)pBoundObj).getName(); }

                    @Override
                    public void setValue(Object pBoundObj, String pValue) { ((Skill)pBoundObj).setName(pValue); }
                });

                lBinder.addBinding((TextView)lView.findViewById(R.id.skill_ranks), new ViewBinder.EditableNumericBinder() {
                    @Override
                    public int getValue(Object pBoundObj) { return ((Skill)pBoundObj).getRanks(); }

                    @Override
                    public int getMaximum(Object pBoundObj) { return 20; }

                    @Override
                    public int getMinimum(Object pBoundObj) { return 0; }

                    @Override
                    public void setValue(Object pBoundObj, int pValue) { ((Skill)pBoundObj).setRanks(pValue); }
                });

                lBinder.addBinding((TextView)lView.findViewById(R.id.skill_misc), new ViewBinder.EditableNumericBinder() {
                    @Override
                    public int getValue(Object pBoundObj) { return ((Skill)pBoundObj).getMisc(); }

                    @Override
                    public int getMaximum(Object pBoundObj) { return 20; }

                    @Override
                    public int getMinimum(Object pBoundObj) { return 0; }

                    @Override
                    public void setValue(Object pBoundObj, int pValue) { ((Skill)pBoundObj).setMisc(pValue); }
                });

                lBinder.addBinding((TextView)lView.findViewById(R.id.skill_total), new ViewBinder.NumericBinder() {
                    @Override
                    public int getValue(Object pBoundObj) { return ((Skill)pBoundObj).getTotal(); }
                });

                lView.setTag(lBinder);
            }

            ((ViewBinder)lView.getTag()).setBoundObject(lItem); //this will automatically update views.

//            if (lItem.getClassSkill())
//                ((SkillViewHolder)lView.getTag()).skillNameView.setTypeface(null, Typeface.BOLD);
//            else
//                ((SkillViewHolder)lView.getTag()).skillNameView.setTypeface(null, Typeface.NORMAL);
//            ((SkillViewHolder)lView.getTag()).skillNameView.setText(lItem.getName());
//            ((SkillViewHolder)lView.getTag()).skillAbilityView.setText(lItem.getAbility().toString());
//            ((SkillViewHolder)lView.getTag()).skillRanksView.setText(Integer.toString(lItem.getRanks()));
//            ((SkillViewHolder)lView.getTag()).skillMiscView.setText(Integer.toString(lItem.getMisc()));
//            ((SkillViewHolder)lView.getTag()).skillTotalView.setText(Integer.toString(lItem.getTotal()));

            return lView;
        }
    }

}
