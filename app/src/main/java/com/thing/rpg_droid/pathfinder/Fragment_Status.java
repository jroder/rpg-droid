package com.thing.rpg_droid.pathfinder;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thing.rpg_droid.app.CharSheet_PageInfo;
import com.thing.rpg_droid.res.R;

@CharSheet_PageInfo(title = "Status")
public class Fragment_Status extends Fragment {

    public Fragment_Status() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pathfinder_fragment_status, container, false);
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
