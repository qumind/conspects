package com.example.oleg.conspects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;

/**
 * Created by Oleg on 15.10.2016.
 */

public class ThemeListFragment extends Fragment {
    ArrayList<ArrayList<String>> themeList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.theme_list_fragment, container, false);
        ExpandableListView list = (ExpandableListView) rootView.findViewById(R.id.theme_list);
        initThemeList();
        ExpListAdapter listAdapter = new ExpListAdapter(inflater.getContext(), themeList);
        list.setAdapter(listAdapter);
        return rootView;
    }

    private void initThemeList() {
        themeList = new ArrayList<ArrayList<String>>();
        ArrayList<String> subtheme = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                subtheme.add("Child" + Integer.toString(j));
            }
            themeList.add(subtheme);
            subtheme.clear();
        }
    }
}