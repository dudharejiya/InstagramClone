package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Objects.requireNonNull(getSupportActionBar()).hide();

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView navigationView;
        navigationView = findViewById(R.id.bottomNavViewBarID);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                        break;

                    case R.id.ic_search:
                        startActivity(new Intent(ProfileActivity.this, searchActivity.class));
                        break;

                    case R.id.ic_post:
                        startActivity(new Intent(ProfileActivity.this, postActivity.class));
                        break;

                    case R.id.ic_reels:
                        startActivity(new Intent(ProfileActivity.this, reelsActivity.class));
                        break;

                    case R.id.ic_profile:
                        startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));
                        break;
                }
                return true;
            }
        });
    }
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MyPostsFragment();
                case 1:
                    return new MyVideosFragment();
                default:
                    throw new IllegalArgumentException("Invalid position");
            }
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Posts";
                case 1:
                    return "Videos";
                default:
                    return null;
            }
        }
        @Override
        public int getCount() {
            return 2;
        }
    }
}