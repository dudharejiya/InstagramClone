package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class reelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reels);

        getSupportActionBar().hide();

        BottomNavigationView navigationView;
        navigationView = findViewById(R.id.bottomNavViewBarID);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(reelsActivity.this, MainActivity.class));
                        break;

                    case R.id.ic_search:
                        startActivity(new Intent(reelsActivity.this, searchActivity.class));
                        break;

                    case R.id.ic_post:
                        startActivity(new Intent(reelsActivity.this, postActivity.class));
                        break;

                    case R.id.ic_reels:
                        startActivity(new Intent(reelsActivity.this, reelsActivity.class));
                        break;

                    case R.id.ic_profile:
                        startActivity(new Intent(reelsActivity.this, ProfileActivity.class));
                        break;
                }
                return true;
            }
        });
    }
}