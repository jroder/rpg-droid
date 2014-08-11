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
import android.widget.CheckBox;
import android.widget.TextView;

import com.thing.rpg_droid.res.R;

import java.util.ArrayList;

public class Adapters
{


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
                lView = (ViewGroup)LayoutInflater.from(this.getContext()).inflate(R.layout.pathfinder_view_ability, null);
                final SpellViewHolder lHolder = new SpellViewHolder();
                lHolder.nameView = (TextView)lView.findViewById(R.id.spell_name);
                lView.setTag(lHolder);
            }

            ((SpellViewHolder)lView.getTag()).nameView.setText(lItem.getName());

            //((AbilityViewHolder)lView.getTag()).value.setTag(lItem);//for updates

            return lView;
        }
    }
}
