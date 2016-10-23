package com.example.oleg.conspects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by Oleg on 15.10.2016.
 */

public class ChooseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.choose_fragment, container, false);

        ImageButton algebraButton = (ImageButton)rootView.findViewById(R.id.algebra_button);
        ImageButton geometryButton = (ImageButton)rootView.findViewById(R.id.geometry_button);

        algebraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_frame, new ThemeListFragment())
                        .commit();
            }
        });

        geometryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_frame, new ThemeListFragment())
                        .commit();
            }
        });

        return rootView;
    }
}
