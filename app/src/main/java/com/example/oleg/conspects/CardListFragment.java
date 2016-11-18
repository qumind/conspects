package com.example.oleg.conspects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

/**
 * Created by root on 17.11.16.
 */
public class CardListFragment extends Fragment {
    ArrayList<ArrayList<String>> themeList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_list_fragment, container, false);

        ExpandableListView expandableListView = (ExpandableListView)rootView.findViewById(R.id.new_card_exp_list);
        initThemeList();
        ExpListAdapter adapter = new ExpListAdapter(rootView.getContext(),themeList);
        expandableListView.setAdapter(adapter);
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