package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class signInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        //creating objects
        Button skipToAppObj;
        TextView signUpTextObj;

        //giving reference to the objects
        skipToAppObj = findViewById(R.id.skipToAppID);
        signUpTextObj = findViewById(R.id.signUpTextID);

        skipToAppObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signInActivity.this, MainActivity.class));
            }
        });

        signUpTextObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signInActivity.this,signUpActivity.class));
            }
        });
    }
}