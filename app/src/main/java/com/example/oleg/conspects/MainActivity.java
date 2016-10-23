package com.example.oleg.conspects;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Oleg on 15.10.2016.
 */

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    private ArrayAdapter<String> drawerListArrayAdapter;
    private android.support.v7.widget.Toolbar toolbar;
    private android.support.design.widget.NavigationView navigationView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //finding elements
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (android.support.design.widget.NavigationView) findViewById(R.id.navigation_view);


        View navHeaderLayout = navigationView.getHeaderView(R.layout.nav_drawer_header);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        Fragment chooseFragment = new ChooseFragment();
        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_frame, chooseFragment).commit();

        final Fragment themeListFragment = new ThemeListFragment();

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.nav_algebra_fragment:
                        Toast.makeText(getApplicationContext(), "Algebra fragment", Toast.LENGTH_SHORT);
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        Fragment aFragment = new ThemeListFragment();
                        fragmentTransaction1.replace(R.id.fragment_frame, aFragment);
                        fragmentTransaction1.commit();
                        return true;
                    case R.id.nav_geometry_fragment:
                        Toast.makeText(getApplicationContext(), "Algebra fragment", Toast.LENGTH_SHORT);
                        android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        Fragment gFragment = new ThemeListFragment();
                        fragmentTransaction2.replace(R.id.fragment_frame, gFragment);
                        fragmentTransaction2.commit();
                        return true;
                    case R.id.yakato_fignya:
                        Toast.makeText(getApplicationContext(), "Yakato fignya", Toast.LENGTH_SHORT);
                        return true;
                    default:
                        return true;
                }
            }
        });
    }
}