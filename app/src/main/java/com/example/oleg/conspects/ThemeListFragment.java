package com.example.oleg.conspects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.SimpleExpandableListAdapter;

/**
 * Created by Oleg on 15.10.2016.
 */

public class ThemeListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.theme_list_fragment, container, false);
        return rootView;
    }
}
