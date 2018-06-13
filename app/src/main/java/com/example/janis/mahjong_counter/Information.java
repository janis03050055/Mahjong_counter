package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if(extras != null)  //this line is necessary for getting any value
        {
            String[] mahjong = i.getStringArrayExtra("mahjong");
            Toast.makeText(this, "value="+mahjong[0]+""+mahjong[1], Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "value=", Toast.LENGTH_SHORT).show();
        }

    }
}
