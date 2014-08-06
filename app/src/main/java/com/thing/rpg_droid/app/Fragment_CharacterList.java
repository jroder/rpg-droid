package com.thing.rpg_droid.app;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.thing.rpg_droid.res.R;

import java.util.ArrayList;
import java.util.UUID;

public class Fragment_CharacterList extends ListFragment
{
    private CharacterListItemAdapter mCharListAdapter;

    public Fragment_CharacterList()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ArrayList<CharacterListItem> lChars = null;

        if (getArguments() != null)
            lChars = getArguments().getParcelableArrayList("CharacterList");

        if (lChars == null)
        {
            lChars = new ArrayList<CharacterListItem>();

            lChars.add(new CharacterListItem(UUID.randomUUID(), "Argus Peabody","Magus","4"));
            //TODO load character list from file.
        }

        mCharListAdapter = new CharacterListItemAdapter(lChars);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater pInflater, ViewGroup pContainer, Bundle pSavedInstanceState)
    {
        ListView lListView = (ListView)pInflater.inflate(R.layout.fragment_characterlist, pContainer, false);

        lListView.setAdapter(mCharListAdapter);

        return lListView;
    }

    public static class CharacterListItem implements Parcelable
    {
        UUID characterID;
        String characterName;
        String characterClass;
        String characterLevel;

        public CharacterListItem(UUID pId, String pName, String pClass, String pLevel)
        {
            characterID = pId;
            characterName = pName;
            characterClass = pClass;
            characterLevel = pLevel;
        }

        public CharacterListItem(Parcel pIn)
        {
            characterID = UUID.fromString(pIn.readString());
            characterName = pIn.readString();
            characterClass = pIn.readString();
            characterLevel = pIn.readString();
        }

        public String getSummary()
        {
            if ((characterLevel != null) && !characterLevel.equals(""))
                return "Level " + characterLevel + " - " + characterClass;
            else
                return characterClass;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags)
        {
            out.writeString(characterID.toString());
            out.writeString(characterName);
            out.writeString(characterClass);
            out.writeString(characterLevel);
        }

        public static final Parcelable.Creator<CharacterListItem> CREATOR
                = new Parcelable.Creator<CharacterListItem>()
        {
            public CharacterListItem createFromParcel(Parcel in)
            {
                return new CharacterListItem(in);
            }

            public CharacterListItem[] newArray(int size)
            {
                return new CharacterListItem[size];
            }
        };
    }

    private static class CharacterListViewHolder
    {
        public UUID characterID;
        public ImageView gameView;  //image icon for game type
        public TextView nameView;   //name of char
        public TextView summaryView;//char summary
    }

    private class CharacterListItemAdapter extends BaseAdapter
    {
        private ArrayList<CharacterListItem> mCharItems;

        public CharacterListItemAdapter(ArrayList<CharacterListItem> pChars)
        {
            super();

            if (pChars != null)
                mCharItems = pChars;
            else
                mCharItems = new ArrayList<CharacterListItem>();
        }

        public void ClearItems()
        {
            mCharItems.clear();
        }

        public void AddItem(CharacterListItem pItem)
        {
            mCharItems.add(pItem);
        }

        public void InsertItem(CharacterListItem pItem, int pPos)
        {
            mCharItems.add(pPos, pItem);
        }

        @Override
        public int getCount()
        {
            if (mCharItems != null)
                return mCharItems.size() + 1;
            else
                return 1;
        }

        @Override
        public int getViewTypeCount()
        {
            return 1;
        }

        @Override
        public Object getItem(int pPosition)
        {
            if (mCharItems != null) {
                if (pPosition < mCharItems.size())
                    return mCharItems.get(pPosition);
                else
                    return null;
            }
            else {
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
            ViewGroup lView = (ViewGroup)pConvertView;

            if (pConvertView == null) {
                lView = (ViewGroup) getActivity().getLayoutInflater().inflate(R.layout.view_character_item, pParent, false);

                final CharacterListViewHolder lHolder = new CharacterListViewHolder();

                lHolder.gameView = (ImageView) lView.findViewById(R.id.ivGame);
                lHolder.nameView = (TextView) lView.findViewById(R.id.tvName);
                lHolder.summaryView = (TextView) lView.findViewById(R.id.tvSummary);

                lView.setOnClickListener(new View.OnClickListener() {

                     @Override
                     public void onClick(View pView)
                     {
                         Intent lIntent = new Intent(getActivity(), Activity_Charsheet.class);

                         lIntent.putExtra("CharacterID", lHolder.characterID);

                         startActivity(lIntent);
                     }
                } );

                lView.setTag(lHolder);
            }

            if (pPosition < mCharItems.size()) {
                final CharacterListItem lItem = mCharItems.get(pPosition);

                ((CharacterListViewHolder) lView.getTag()).characterID = lItem.characterID;
                ((CharacterListViewHolder) lView.getTag()).nameView.setTextColor(0xff4592ff);
                ((CharacterListViewHolder) lView.getTag()).nameView.setText(lItem.characterName);
                ((CharacterListViewHolder) lView.getTag()).summaryView.setText(lItem.getSummary());
            }
            else {
                ((CharacterListViewHolder) lView.getTag()).characterID = null;
                ((CharacterListViewHolder) lView.getTag()).nameView.setTextColor(0xff9a9a9a);
                ((CharacterListViewHolder) lView.getTag()).nameView.setText("Add Character");
                ((CharacterListViewHolder) lView.getTag()).summaryView.setText("");
            }

            return lView;
        }

        @Override
        public int getItemViewType(int pPosition)
        {
            if (pPosition < mCharItems.size()) {
                final CharacterListItem lItem = mCharItems.get(pPosition);
                if (lItem != null)
                    return 0;
                else
                    return IGNORE_ITEM_VIEW_TYPE;
            }
            else
            {
                return 0;
            }
        }
    }
}
