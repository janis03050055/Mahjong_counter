package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class HandInputCheck extends AppCompatActivity {

    private int[][] mahjong = null;
    private String[][] mahjong_num = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input_check);

        Object[] objectArray = (Object[]) getIntent().getExtras().getSerializable("mahjong");
        if(objectArray!=null){
            mahjong_num = new String[objectArray.length][];
            for(int i=0;i<objectArray.length;i++){
                mahjong_num[i]=(String[]) objectArray[i];
            }
        }

        //Toast.makeText(this, mahjong[0][0]+"張一條", Toast.LENGTH_LONG).show();

    }
}
