package it.conwine.android.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import it.conwine.android.R;
import it.conwine.android.navfragments.DashboardFragment;
import it.conwine.android.navfragments.ProfileFragment;
import it.conwine.android.navfragments.SearchFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initializateComponent();
        loadFagment(new DashboardFragment());

    }

    private void initializateComponent() {
        bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void loadFagment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.dashboard:
                fragment = new DashboardFragment();
                break;
            case R.id.search:
                fragment = new SearchFragment();
                break;
            case R.id.profile:
                fragment = new ProfileFragment();
                break;
        }

        if (fragment != null){
            loadFagment(fragment);
        }

        return true;
    }







}