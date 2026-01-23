package gr.aueb.cf.fragmentsappcf7.activities;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

        bottomNV.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.uploadItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new UploadFragment(), "UploadFragment").commit();
                        titleTV.setText("Upload");
                        break;
                    case R.id.postItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new PostFragment(), "PostFragment").commit();
                        titleTV.setText("Post");
                        break;
                    case R.id.homeItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new HomeFragment(), "HomeFragment").commit();
                        titleTV.setText("Home");
                        break;
                    case R.id.favorItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new FavoriteFragment(), "FavoriteFragment").commit();
                        titleTV.setText("My Favorites");
                        break;
                    case R.id.profileItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout, new ProfileFragment(), "ProfileFragment").commit();
                        titleTV.setText("My Profile");
                        break;

                }
            }
        });



        //setSupportActionBar(toolbar);

    }
}