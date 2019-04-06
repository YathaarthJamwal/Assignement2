package com.example.yathaarth.assignement2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    Activity activity;
    SharedPreferences preferences;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        activity = this;

        Button button;
        button = findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed1 = findViewById(R.id.editName);
                EditText ed2 = findViewById(R.id.editDesc);
                String name = ed1.getText().toString();
                String desc = ed2.getText().toString();

               /* Intent intent=new Intent(activity,MainActivity.class);

                String name = ed1.getText().toString();
                intent.putExtra("Name",name);

                String desc = ed2.getText().toString();
                intent.putExtra("Desc",desc);

                intent.putExtra("Key",1);

                startActivity(intent);  */
            preferences = getSharedPreferences("ASSIGNMENT_2",MODE_PRIVATE);
            count = preferences.getInt("count",0);
            count++;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name"+count,name);
            editor.putString("desc"+count,desc);
            editor.putInt("count",count);
            editor.apply();

            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

            }
        });

    }

}
