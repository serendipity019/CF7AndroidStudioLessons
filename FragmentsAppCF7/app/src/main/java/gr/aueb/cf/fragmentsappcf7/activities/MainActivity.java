package gr.aueb.cf.fragmentsappcf7.activities;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.cf.fragmentsappcf7.R;
import gr.aueb.cf.fragmentsappcf7.fragments.FavoriteFragment;
import gr.aueb.cf.fragmentsappcf7.fragments.HomeFragment;
import gr.aueb.cf.fragmentsappcf7.fragments.PostFragment;
import gr.aueb.cf.fragmentsappcf7.fragments.ProfileFragment;
import gr.aueb.cf.fragmentsappcf7.fragments.UploadFragment;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNV;
    private TextView titleTV;

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frameLayout);
        titleTV = findViewById(R.id.titleTV);
        bottomNV = findViewById(R.id.bottomNV);

        fragmentManager = getSupportFragmentManager();

        // When the app opens for the first time, the HomeFragment is displayed
        bottomNV.getMenu().getItem(2).setChecked(true);
        fragmentManager.beginTransaction().replace(R.id.frameLayout, new HomeFragment(), "HomeFragment").commit();
        titleTV.setText("Home");

        bottomNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                Fragment fragment = null;
                String title = "";

                if (itemId == R.id.uploadItem) {
                    fragment = new UploadFragment();
                    title = "Upload";
                } else if (itemId == R.id.postItem) {
                   fragment = new PostFragment();
                   title = "Post";
                } else if (itemId == R.id.homeItem) {
                    fragment = new HomeFragment();
                    title = "Home";
                } else if (itemId == R.id.favorItem) {
                    fragment = new FavoriteFragment();
                    title = "Favorites";
                } else if (itemId == R.id.profileItem) {
                    fragment = new ProfileFragment();
                    title = "My Profile";
                }

                if (fragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment, title).commit();
                    titleTV.setText(title);
                }

                return true;
            }
        });



        //setSupportActionBar(toolbar);

    }
}