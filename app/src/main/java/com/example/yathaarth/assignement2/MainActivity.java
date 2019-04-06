package com.example.yathaarth.assignement2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.example.yathaarth.assignement2.Adapters.RecyclerViewAdapter;
import com.example.yathaarth.assignement2.Models.SocialItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    ArrayList<SocialItem> items;

    SharedPreferences preferences;
    int count=0;
    int x=1;
    String name;
    String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton button = findViewById(R.id.floating_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddItemActivity.class);
                startActivity(i);
            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        items = new ArrayList<>();

        SocialItem facebook = new SocialItem("facebook","gffg",R.drawable.facebook);
        items.add(facebook);
        SocialItem twitter = new SocialItem("twitter","gffg",R.drawable.twitter);
        items.add(twitter);


      /* Intent intent = getIntent();
       int key = intent.getIntExtra("key",0);

        if(key==1)
        {
                String name = getIntent().getExtras().getString("Name");
                String desc = getIntent().getExtras().getString("Desc");
                SocialItem object = new SocialItem(name,desc,R.drawable.facebook);
                items.add(object);
        }  */

        preferences = getSharedPreferences("ASSIGNMENT_2",MODE_PRIVATE);
        count = preferences.getInt("count",0);
        while (x<=count){
            name = preferences.getString("name"+x,"Error");
            desc = preferences.getString("desc"+x,"Error");
            x++;
            SocialItem object = new SocialItem(name,desc,R.drawable.facebook);
            items.add(object);
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,items);
        recyclerView.setAdapter(adapter);


    }
}
