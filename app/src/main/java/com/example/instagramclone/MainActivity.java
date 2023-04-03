package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @SuppressLint({"NotifyDataSetChanged", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate: starting.");
        Objects.requireNonNull(getSupportActionBar()).hide();

        RecyclerView recyclerView = findViewById(R.id.recyleViewPostID);
        RecyclerView recycleView2  = findViewById(R.id.recycleViewStoryID);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url1 = "https://meme-api.com/gimme";
        final String[] url2 = new String[100];

        final List<CardViewItem> cardViewItemList = new ArrayList<>();
        postRVadapter adapter = new postRVadapter(cardViewItemList);
        // Set the adapter to the RecyclerView
        recyclerView.setAdapter(adapter);

        fetchImageURLsAndUpdateUI(100, cardViewItemList, adapter);
        //image view object to for onclick event
        ImageView heartIconObj, dMIconObj;
        //creating object and giving references
        BottomNavigationView navigationView;

        //giving references to objects
        navigationView = findViewById(R.id.bottomNavViewBarID);
        heartIconObj = findViewById(R.id.heartIconID);
        dMIconObj = findViewById(R.id.DMIconID);


        List<CardItem> cardItemList = new ArrayList<>();
        // Add items to the cardItemList


        CardAdapter storyadapter = new CardAdapter(cardItemList);
        recycleView2.setAdapter(storyadapter);
        recycleView2.setLayoutManager(new LinearLayoutManager(this));


        heartIconObj.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, notificationActivity.class)));

        dMIconObj.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, directMessageActivity.class)));

        navigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.ic_home:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    break;

                case R.id.ic_search:
                    startActivity(new Intent(MainActivity.this, searchActivity.class));
                    break;

                case R.id.ic_post:
                    startActivity(new Intent(MainActivity.this, postActivity.class));
                    break;

                case R.id.ic_reels:
                    startActivity(new Intent(MainActivity.this, reelsActivity.class));
                    break;

                case R.id.ic_profile:
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    break;
            }
            return true;
        });

    }
    private void fetchImageURLsAndUpdateUI(int count, final List<CardViewItem> cardViewItemList, final postRVadapter adapter) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://meme-api.com/gimme";

        for (int i = 0; i < count; i++) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                String imageUrl = response.getString("url");
                                String title = response.getString("author");

                                cardViewItemList.add(new CardViewItem(title, imageUrl));
                                adapter.notifyDataSetChanged();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "This is error" + error, Toast.LENGTH_SHORT).show();
                        }
                    }
            );
            queue.add(jsonObjectRequest);
        }
    }
}


