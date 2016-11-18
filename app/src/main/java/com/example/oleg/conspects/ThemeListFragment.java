package com.example.oleg.conspects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardLayout;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.view.MaterialListAdapter;
import com.dexafree.materialList.view.MaterialListView;

import java.util.ArrayList;

/**
 * Created by Oleg on 15.10.2016.
 */

public class ThemeListFragment extends Fragment {
    ArrayList<ArrayList<String>> themeList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.theme_list_fragment, container, false);
        MaterialListView materialListView = (MaterialListView)rootView.findViewById(R.id.material_listview);
        Card mcard = new Card.Builder(rootView.getContext())
                .setTag("TestCard")
                .setTag("BASIC_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setLayout(R.layout.new_card_layout)
                .setTitle("I'm new")
                .setDescription("I've been generated on runtime!")
                .setDrawable(R.drawable.geometry_button)
                .endConfig()
                .build();
        MaterialListAdapter adapter = materialListView.getAdapter();
        adapter.add(mcard);

        CardListFragment fragment = new CardListFragment();
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_for_exp_list_in_card, fragment).commit();


        int a = 1;

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