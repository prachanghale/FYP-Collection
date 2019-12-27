package com.example.fypcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fypcollection.Fragments.DashboardFragment;
import com.example.fypcollection.Fragments.MenuFragment;
import com.example.fypcollection.Fragments.RestaurantFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInterface();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new DashboardFragment()).commit();

        onNavBottomClick();
    }

    private void onNavBottomClick() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment layout = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        layout = new DashboardFragment();
                        break;
                    case R.id.restaurant:
                        layout = new RestaurantFragment();
                        break;
                    case R.id.menu:
                        layout = new MenuFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        layout).commit();
                return true;
            }
        });
    }

    private void userInterface() {
        navigationView = findViewById(R.id.bottom_navigation_view);
    }
}
