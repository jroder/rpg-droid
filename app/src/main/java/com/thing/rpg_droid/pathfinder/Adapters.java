/**
 * Created by jon on 8/06/14.
 *
 */

package com.thing.rpg_droid.pathfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.thing.rpg_droid.res.R;
import java.util.ArrayList;
import java.util.Hashtable;

public class Adapters
{
    private static class AbilityViewHolder
    {
        public TextView nameView;
        public TextView scoreView;
        public TextView modView;
        public TextView adjView;
        public TextView tmpView;
    }

    public static class AbilityListAdapter extends ArrayAdapter
    {
        private Hashtable<Ability.AbilityName, Ability> mAbilities;

        private Ability.AbilityName[] mKeys;

        public AbilityListAdapter(Context pContext)
        {
            super(pContext, 0);
            mAbilities = new Hashtable<Ability.AbilityName, Ability>();
        }

        public AbilityListAdapter(Context pContext, Hashtable<Ability.AbilityName, Ability> pAbilities)
        {
            super(pContext, 0);
            mAbilities = pAbilities;
        }

        private void regenerateKeyList()
        {
            mKeys = mAbilities.keySet().toArray(new Ability.AbilityName[mAbilities.size()]);
        }

        public int getAbilityCount()
        {
            return mAbilities.size();
        }

        public Ability getAbility(Ability.AbilityName pName)
        {
            return mAbilities.get(pName);
        }

        public void putAbility(Ability.AbilityName pName, Ability pAbility)
        {
            mAbilities.put(pName, pAbility);
            regenerateKeyList();
        }

        public void removeAbility(Ability.AbilityName pName)
        {
            mAbilities.remove(pName);
            regenerateKeyList();
        }

        public void clearAbilities()
        {
            mAbilities.clear();
            regenerateKeyList();
        }

        @Override
        public View getView(int pPosition, View pConvertView, ViewGroup pParent)
        {
            ViewGroup lView = (ViewGroup)pConvertView;

            final Ability.AbilityName lKey = mKeys[pPosition];
            final Ability lItem = mAbilities.get(lKey);

            if (lView == null)
            {
                lView = (ViewGroup)LayoutInflater.from(this.getContext()).inflate(R.layout.pathfinder_ability, null);
                final AbilityViewHolder lHolder = new AbilityViewHolder();
                lHolder.nameView = (TextView)lView.findViewById(R.id.ability_name);
                lHolder.scoreView = (TextView)lView.findViewById(R.id.ability_score);
                lHolder.modView = (TextView)lView.findViewById(R.id.ability_mod);
                lHolder.adjView = (TextView)lView.findViewById(R.id.ability_adj);
                lHolder.tmpView = (TextView)lView.findViewById(R.id.ability_tmp);

                lView.setTag(lHolder);
            }

            ((AbilityViewHolder)lView.getTag()).nameView.setText(lKey.name());
            ((AbilityViewHolder)lView.getTag()).scoreView.setText(lItem.getScore());
            ((AbilityViewHolder)lView.getTag()).modView.setText(lItem.getModifier());
            ((AbilityViewHolder)lView.getTag()).adjView.setText(lItem.getTempAdjust());
            ((AbilityViewHolder)lView.getTag()).tmpView.setText(lItem.getCurrentModifier());

            //((AbilityViewHolder)lView.getTag()).value.setTag(lItem);//for updates

            return lView;
        }
    }

    private static class SkillViewHolder
    {
        public TextView nameView;
    }

    public static class SkillListAdapter extends ArrayAdapter
    {
        private ArrayList<Skill> mSkills;

        public SkillListAdapter(Context pContext)
        {
            super(pContext, 0);
            mSkills = new ArrayList<Skill>();
        }

        public SkillListAdapter(Context pContext, ArrayList<Skill> pSkills)
        {
            super(pContext, 0);
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
        public View getView(int pPosition, View pConvertView, ViewGroup pParent)
        {
            ViewGroup lView = (ViewGroup)pConvertView;

            final Skill lItem = mSkills.get(pPosition);

            if (lView == null)
            {
                lView = (ViewGroup)LayoutInflater.from(this.getContext()).inflate(R.layout.pathfinder_ability, null);
                final SkillViewHolder lHolder = new SkillViewHolder();
                lHolder.nameView = (TextView)lView.findViewById(R.id.skill_name);

                lView.setTag(lHolder);
            }

            ((AbilityViewHolder)lView.getTag()).nameView.setText(lItem.getName());

            //((AbilityViewHolder)lView.getTag()).value.setTag(lItem);//for updates

            return lView;
        }
    }

    private static class SpellViewHolder
    {
        public TextView nameView;
    }

    public static class SpellListAdapter extends ArrayAdapter
    {
        private ArrayList<Spell> mSpells;

        public SpellListAdapter(Context pContext)
        {
            super(pContext, 0);
            mSpells = new ArrayList<Spell>();
        }

        public SpellListAdapter(Context pContext, ArrayList<Spell> pSpells)
        {
            super(pContext, 0);
            mSpells = pSpells;
        }

        public int getSpellCount()
        {
            return mSpells.size();
        }

        public Spell getSpell(int i)
        {
            return mSpells.get(i);
        }

        public void putSpell(Spell pSpell)
        {
            mSpells.add(pSpell);
        }

        public void removeSpell(int i)
        {
            mSpells.remove(i);
        }

        public void clearSpells()
        {
            mSpells.clear();
        }

        @Override
        public View getView(int pPosition, View pConvertView, ViewGroup pParent)
        {
            ViewGroup lView = (ViewGroup)pConvertView;

            final Spell lItem = mSpells.get(pPosition);

            if (lView == null)
            {
                lView = (ViewGroup)LayoutInflater.from(this.getContext()).inflate(R.layout.pathfinder_ability, null);
                final SpellViewHolder lHolder = new SpellViewHolder();
                lHolder.nameView = (TextView)lView.findViewById(R.id.spell_name);
                lView.setTag(lHolder);
            }

            ((AbilityViewHolder)lView.getTag()).nameView.setText(lItem.getName());

            //((AbilityViewHolder)lView.getTag()).value.setTag(lItem);//for updates

            return lView;
        }
    }
}
