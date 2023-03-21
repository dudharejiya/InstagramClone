package com.example.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Utils.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: starting.");


    }

    View BottomNavigationView;
    BottomNavigationView bottomNavigationView = (com.google.android.material.bottomnavigation.BottomNavigationView) ((BottomNavigationView) = findViewById(R.id.bottomNavViewBar));

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.ic_house:
                break;

            case R.id.ic_search:
                break;

            case R.id.ic_circle:
                break;

            case R.id.ic_alert:
                break;

            case R.id.ic_person:
                break;

        }
        return true;
    }
}


