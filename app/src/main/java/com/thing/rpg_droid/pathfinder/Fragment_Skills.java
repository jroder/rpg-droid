package com.thing.rpg_droid.pathfinder;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.thing.rpg_droid.app.CharSheet_PageInfo;
import com.thing.rpg_droid.res.R;

import java.util.ArrayList;

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

        ArrayList<Skill> lSkills = new ArrayList<Skill>();

        for (int i = 0; i < 20; i++)
        {
            lSkills.add(new Skill(0, 0, "Skill " + Integer.toString(i), Ability.AbilityName.STR, false));
        }

        mCharSkillAdapter = new SkillListAdapter(getActivity(), lSkills);
    }

    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState)
    {
        ListView lListView = (ListView)pInflater.inflate(R.layout.pathfinder_fragment_skills, pContainer, false);

        lListView.setAdapter(mCharSkillAdapter);

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
        public CheckBox classSkillView;
        public TextView skillNameView;
        public TextView skillAbilityView;
        public TextView skillRanksView;
        public TextView skillMiscView;
        public TextView skillTotalView;
    }

    public static class SkillListAdapter extends BaseAdapter
    {
        private Context mContext;

        private ArrayList<Skill> mSkills;

        public SkillListAdapter(Context pContext, ArrayList<Skill> pSkills)
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
                final SkillViewHolder lHolder = new SkillViewHolder();
                lHolder.classSkillView = (CheckBox) lView.findViewById(R.id.skill_class);
                lHolder.skillNameView = (TextView) lView.findViewById(R.id.skill_name);
                lHolder.skillAbilityView = (TextView) lView.findViewById(R.id.skill_ability);
                lHolder.skillRanksView = (TextView) lView.findViewById(R.id.skill_ranks);
                lHolder.skillMiscView = (TextView) lView.findViewById(R.id.skill_misc);
                lHolder.skillTotalView = (TextView)lView.findViewById(R.id.skill_total);

                lView.setTag(lHolder);
            }

            ((SkillViewHolder)lView.getTag()).classSkillView.setChecked(lItem.getClassSkill());
            ((SkillViewHolder)lView.getTag()).skillNameView.setText(lItem.getName());
            ((SkillViewHolder)lView.getTag()).skillAbilityView.setText(lItem.getAbility().toString());
            ((SkillViewHolder)lView.getTag()).skillRanksView.setText(Integer.toString(lItem.getRanks()));
            ((SkillViewHolder)lView.getTag()).skillMiscView.setText(Integer.toString(lItem.getMisc()));
            ((SkillViewHolder)lView.getTag()).skillTotalView.setText(Integer.toString(lItem.getTotal()));

            return lView;
        }
    }

}
