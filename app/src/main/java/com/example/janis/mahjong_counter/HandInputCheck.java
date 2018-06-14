package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HandInputCheck extends AppCompatActivity {
    private List<String> taiscore_explain = new ArrayList<>();
    private int tai = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input_check);

        taiscore_explain = getIntent().getStringArrayListExtra("taiscore_explain");
        tai = getIntent().getIntExtra("tai",0);
        //debug 用
        String j;
        for(int i = 0;i<taiscore_explain.size();i++){
            j = taiscore_explain.get( i );
            Log.d("台數詳解勾選",j);
        }
        Log.d("台數總計公選",String.valueOf(tai));
    }
}
