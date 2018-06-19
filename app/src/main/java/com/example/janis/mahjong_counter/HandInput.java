package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class HandInput extends AppCompatActivity {

    private int[][] mahjong = new int[5][9]; //[種類][細分]=數量
    //台數計算
    private int[] rulescore = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    private int[] rulescore_get = new int[36];
    private List<String> taiscore_explain = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input);
        //宣告
        RadioGroup rg_w1 = findViewById(R.id.radioButton_group_w1);
        RadioGroup rg_w2 = findViewById(R.id.radioButton_group_w2);
        RadioGroup rg_w3 = findViewById(R.id.radioButton_group_w3);
        RadioGroup rg_w4 = findViewById(R.id.radioButton_group_w4);
        RadioGroup rg_w5 = findViewById(R.id.radioButton_group_w5);
        RadioGroup rg_w6 = findViewById(R.id.radioButton_group_w6);
        RadioGroup rg_w7 = findViewById(R.id.radioButton_group_w7);
        RadioGroup rg_w8 = findViewById(R.id.radioButton_group_w8);
        RadioGroup rg_w9 = findViewById(R.id.radioButton_group_w9);

        RadioGroup rg_b1 = findViewById(R.id.radioButton_group_b1);
        RadioGroup rg_b2 = findViewById(R.id.radioButton_group_b2);
        RadioGroup rg_b3 = findViewById(R.id.radioButton_group_b3);
        RadioGroup rg_b4 = findViewById(R.id.radioButton_group_b4);
        RadioGroup rg_b5 = findViewById(R.id.radioButton_group_b5);
        RadioGroup rg_b6 = findViewById(R.id.radioButton_group_b6);
        RadioGroup rg_b7 = findViewById(R.id.radioButton_group_b7);
        RadioGroup rg_b8 = findViewById(R.id.radioButton_group_b8);
        RadioGroup rg_b9 = findViewById(R.id.radioButton_group_b9);

        RadioGroup rg_t1 = findViewById(R.id.radioButton_group_t1);
        RadioGroup rg_t2 = findViewById(R.id.radioButton_group_t2);
        RadioGroup rg_t3 = findViewById(R.id.radioButton_group_t3);
        RadioGroup rg_t4 = findViewById(R.id.radioButton_group_t4);
        RadioGroup rg_t5 = findViewById(R.id.radioButton_group_t5);
        RadioGroup rg_t6 = findViewById(R.id.radioButton_group_t6);
        RadioGroup rg_t7 = findViewById(R.id.radioButton_group_t7);
        RadioGroup rg_t8 = findViewById(R.id.radioButton_group_t8);
        RadioGroup rg_t9 = findViewById(R.id.radioButton_group_t9);

        RadioGroup rg_east = findViewById(R.id.radioButton_group_east);
        RadioGroup rg_south = findViewById(R.id.radioButton_group_south);
        RadioGroup rg_west = findViewById(R.id.radioButton_group_west);
        RadioGroup rg_north = findViewById(R.id.radioButton_group_north);
        RadioGroup rg_redmiddle= findViewById(R.id.radioButton_group_redmiddle);
        RadioGroup rg_whiteboard = findViewById(R.id.radioButton_group_whiteboard);
        RadioGroup rg_greenrich = findViewById(R.id.radioButton_group_greenrich);

        RadioGroup rg_spring = findViewById(R.id.radioButton_group_spring);
        RadioGroup rg_summer = findViewById(R.id.radioButton_group_summer);
        RadioGroup rg_fall = findViewById(R.id.radioButton_group_fall);
        RadioGroup rg_winter = findViewById(R.id.radioButton_group_winter);
        RadioGroup rg_plum= findViewById(R.id.radioButton_group_plum);
        RadioGroup rg_lan = findViewById(R.id.radioButton_group_lan);
        RadioGroup rg_bamboo = findViewById(R.id.radioButton_group_bamboo);
        RadioGroup rg_orange = findViewById(R.id.radioButton_group_orange);

        Button b_next_step = findViewById(R.id.b_NextStep);


        //將所選擇之值存入陣列
        //萬
        rg_w1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w1_0:
                        mahjong[2][0] = 0;
                        break;
                    case R.id.radioButton_w1_1:
                        mahjong[2][0] = 1;
                        break;
                    case R.id.radioButton_w1_2:
                        mahjong[2][0] = 2;
                        break;
                    case R.id.radioButton_w1_3:
                        mahjong[2][0] = 3;
                        break;
                    case R.id.radioButton_w1_4:
                        mahjong[2][0] = 4;
                        break;
                }
            }
        });

        rg_w2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w2_0:
                        mahjong[2][1] = 0;
                        break;
                    case R.id.radioButton_w2_1:
                        mahjong[2][1] = 1;
                        break;
                    case R.id.radioButton_w2_2:
                        mahjong[2][1] = 2;
                        break;
                    case R.id.radioButton_w2_3:
                        mahjong[2][1] = 3;
                        break;
                    case R.id.radioButton_w2_4:
                        mahjong[2][1] = 4;
                        break;
                }
            }
        });
        rg_w3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w3_0:
                        mahjong[2][2] = 0;
                        break;
                    case R.id.radioButton_w3_1:
                        mahjong[2][2] = 1;
                        break;
                    case R.id.radioButton_w3_2:
                        mahjong[2][2] = 2;
                        break;
                    case R.id.radioButton_w3_3:
                        mahjong[2][2] = 3;
                        break;
                    case R.id.radioButton_w3_4:
                        mahjong[2][2] = 4;
                        break;
                }
            }
        });
        rg_w4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w4_0:
                        mahjong[2][3] = 0;
                        break;
                    case R.id.radioButton_w4_1:
                        mahjong[2][3] = 1;
                        break;
                    case R.id.radioButton_w4_2:
                        mahjong[2][3] = 2;
                        break;
                    case R.id.radioButton_w4_3:
                        mahjong[2][3] = 3;
                        break;
                    case R.id.radioButton_w4_4:
                        mahjong[2][3] = 4;
                        break;
                }
            }
        });
        rg_w5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w5_0:
                        mahjong[2][4] = 0;
                        break;
                    case R.id.radioButton_w5_1:
                        mahjong[2][4] = 1;
                        break;
                    case R.id.radioButton_w5_2:
                        mahjong[2][4] = 2;
                        break;
                    case R.id.radioButton_w5_3:
                        mahjong[2][4] = 3;
                        break;
                    case R.id.radioButton_w5_4:
                        mahjong[2][4] = 4;
                        break;
                }
            }
        });

        rg_w6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w6_0:
                        mahjong[2][5] = 0;
                        break;
                    case R.id.radioButton_w6_1:
                        mahjong[2][5] = 1;
                        break;
                    case R.id.radioButton_w6_2:
                        mahjong[2][5] = 2;
                        break;
                    case R.id.radioButton_w6_3:
                        mahjong[2][5] = 3;
                        break;
                    case R.id.radioButton_w6_4:
                        mahjong[2][5] = 4;
                        break;
                }
            }
        });


        rg_w7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w7_0:
                        mahjong[2][6] = 0;
                        break;
                    case R.id.radioButton_w7_1:
                        mahjong[2][6] = 1;
                        break;
                    case R.id.radioButton_w7_2:
                        mahjong[2][6] = 2;
                        break;
                    case R.id.radioButton_w7_3:
                        mahjong[2][6] = 3;
                        break;
                    case R.id.radioButton_w7_4:
                        mahjong[2][6] = 4;
                        break;
                }
            }
        });


        rg_w8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w8_0:
                        mahjong[2][7] = 0;
                        break;
                    case R.id.radioButton_w8_1:
                        mahjong[2][7] = 1;
                        break;
                    case R.id.radioButton_w8_2:
                        mahjong[2][7] = 2;
                        break;
                    case R.id.radioButton_w8_3:
                        mahjong[2][7] = 3;
                        break;
                    case R.id.radioButton_w8_4:
                        mahjong[2][7] = 4;
                        break;
                }
            }
        });


        rg_w9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_w9_0:
                        mahjong[2][8] = 0;
                        break;
                    case R.id.radioButton_w9_1:
                        mahjong[2][8] = 1;
                        break;
                    case R.id.radioButton_w9_2:
                        mahjong[2][8] = 2;
                        break;
                    case R.id.radioButton_w9_3:
                        mahjong[2][8] = 3;
                        break;
                    case R.id.radioButton_w9_4:
                        mahjong[2][8] = 4;
                        break;
                }
            }
        });


        //條
        rg_b1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b1_0:
                        mahjong[0][0] = 0;
                        break;
                    case R.id.radioButton_b1_1:
                        mahjong[0][0] = 1;
                        break;
                    case R.id.radioButton_b1_2:
                        mahjong[0][0] = 2;
                        break;
                    case R.id.radioButton_b1_3:
                        mahjong[0][0] = 3;
                        break;
                    case R.id.radioButton_b1_4:
                        mahjong[0][0] = 4;
                        break;
                }
            }
        });
        rg_b2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b2_0:
                        mahjong[0][1] = 0;
                        break;
                    case R.id.radioButton_b2_1:
                        mahjong[0][1] = 1;
                        break;
                    case R.id.radioButton_b2_2:
                        mahjong[0][1] = 2;
                        break;
                    case R.id.radioButton_b2_3:
                        mahjong[0][1] = 3;
                        break;
                    case R.id.radioButton_b2_4:
                        mahjong[0][1] = 4;
                        break;
                }
            }
        });
        rg_b3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b3_0:
                        mahjong[0][2] = 0;
                        break;
                    case R.id.radioButton_b3_1:
                        mahjong[0][2] = 1;
                        break;
                    case R.id.radioButton_b3_2:
                        mahjong[0][2] = 2;
                        break;
                    case R.id.radioButton_b3_3:
                        mahjong[0][2] = 3;
                        break;
                    case R.id.radioButton_b3_4:
                        mahjong[0][2] = 4;
                        break;
                }
            }
        });
        rg_b4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b4_0:
                        mahjong[0][3] = 0;
                        break;
                    case R.id.radioButton_b4_1:
                        mahjong[0][3] = 1;
                        break;
                    case R.id.radioButton_b4_2:
                        mahjong[0][3] = 2;
                        break;
                    case R.id.radioButton_b4_3:
                        mahjong[0][3] = 3;
                        break;
                    case R.id.radioButton_b4_4:
                        mahjong[0][3] = 4;
                        break;
                }
            }
        });
        rg_b5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b5_0:
                        mahjong[0][4] = 0;
                        break;
                    case R.id.radioButton_b5_1:
                        mahjong[0][4] = 1;
                        break;
                    case R.id.radioButton_b5_2:
                        mahjong[0][4] = 2;
                        break;
                    case R.id.radioButton_b5_3:
                        mahjong[0][4] = 3;
                        break;
                    case R.id.radioButton_b5_4:
                        mahjong[0][4] = 4;
                        break;
                }
            }
        });

        rg_b6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b6_0:
                        mahjong[0][5] = 0;
                        break;
                    case R.id.radioButton_b6_1:
                        mahjong[0][5] = 1;
                        break;
                    case R.id.radioButton_b6_2:
                        mahjong[0][5] = 2;
                        break;
                    case R.id.radioButton_b6_3:
                        mahjong[0][5] = 3;
                        break;
                    case R.id.radioButton_b6_4:
                        mahjong[0][5] = 4;
                        break;
                }
            }
        });


        rg_b7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b7_0:
                        mahjong[0][6] = 0;
                        break;
                    case R.id.radioButton_b7_1:
                        mahjong[0][6] = 1;
                        break;
                    case R.id.radioButton_b7_2:
                        mahjong[0][6] = 2;
                        break;
                    case R.id.radioButton_b7_3:
                        mahjong[0][6] = 3;
                        break;
                    case R.id.radioButton_b7_4:
                        mahjong[0][6] = 4;
                        break;
                }
            }
        });


        rg_b8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b8_0:
                        mahjong[0][7] = 0;
                        break;
                    case R.id.radioButton_b8_1:
                        mahjong[0][7] = 1;
                        break;
                    case R.id.radioButton_b8_2:
                        mahjong[0][7] = 2;
                        break;
                    case R.id.radioButton_b8_3:
                        mahjong[0][7] = 3;
                        break;
                    case R.id.radioButton_b8_4:
                        mahjong[0][7] = 4;
                        break;
                }
            }
        });


        rg_b9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_b9_0:
                        mahjong[0][8] = 0;
                        break;
                    case R.id.radioButton_b9_1:
                        mahjong[0][8] = 1;
                        break;
                    case R.id.radioButton_b9_2:
                        mahjong[0][8] = 2;
                        break;
                    case R.id.radioButton_b9_3:
                        mahjong[0][8] = 3;
                        break;
                    case R.id.radioButton_b9_4:
                        mahjong[0][8] = 4;
                        break;
                }
            }
        });


        //筒
        rg_t1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t1_0:
                        mahjong[1][0] = 0;
                        break;
                    case R.id.radioButton_t1_1:
                        mahjong[1][0] = 1;
                        break;
                    case R.id.radioButton_t1_2:
                        mahjong[1][0] = 2;
                        break;
                    case R.id.radioButton_t1_3:
                        mahjong[1][0] = 3;
                        break;
                    case R.id.radioButton_t1_4:
                        mahjong[1][0] = 4;
                        break;
                }
            }
        });
        rg_t2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t2_0:
                        mahjong[1][1] = 0;
                        break;
                    case R.id.radioButton_t2_1:
                        mahjong[1][1] = 1;
                        break;
                    case R.id.radioButton_t2_2:
                        mahjong[1][1] = 2;
                        break;
                    case R.id.radioButton_t2_3:
                        mahjong[1][1] = 3;
                        break;
                    case R.id.radioButton_t2_4:
                        mahjong[1][1] = 4;
                        break;
                }
            }
        });
        rg_t3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t3_0:
                        mahjong[1][2] = 0;
                        break;
                    case R.id.radioButton_t3_1:
                        mahjong[1][2] = 1;
                        break;
                    case R.id.radioButton_t3_2:
                        mahjong[1][2] = 2;
                        break;
                    case R.id.radioButton_t3_3:
                        mahjong[1][2] = 3;
                        break;
                    case R.id.radioButton_t3_4:
                        mahjong[1][2] = 4;
                        break;
                }
            }
        });
        rg_t4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t4_0:
                        mahjong[1][3] = 0;
                        break;
                    case R.id.radioButton_t4_1:
                        mahjong[1][3] = 1;
                        break;
                    case R.id.radioButton_t4_2:
                        mahjong[1][3] = 2;
                        break;
                    case R.id.radioButton_t4_3:
                        mahjong[1][3] = 3;
                        break;
                    case R.id.radioButton_t4_4:
                        mahjong[1][3] = 4;
                        break;
                }
            }
        });
        rg_t5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t5_0:
                        mahjong[1][4] = 0;
                        break;
                    case R.id.radioButton_t5_1:
                        mahjong[1][4] = 1;
                        break;
                    case R.id.radioButton_t5_2:
                        mahjong[1][4] = 2;
                        break;
                    case R.id.radioButton_t5_3:
                        mahjong[1][4] = 3;
                        break;
                    case R.id.radioButton_t5_4:
                        mahjong[1][4] = 4;
                        break;
                }
            }
        });

        rg_t6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t6_0:
                        mahjong[1][5] = 0;
                        break;
                    case R.id.radioButton_t6_1:
                        mahjong[1][5] = 1;
                        break;
                    case R.id.radioButton_t6_2:
                        mahjong[1][5] = 2;
                        break;
                    case R.id.radioButton_t6_3:
                        mahjong[1][5] = 3;
                        break;
                    case R.id.radioButton_t6_4:
                        mahjong[1][5] = 4;
                        break;
                }
            }
        });


        rg_t7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t7_0:
                        mahjong[1][6] = 0;
                        break;
                    case R.id.radioButton_t7_1:
                        mahjong[1][6] = 1;
                        break;
                    case R.id.radioButton_t7_2:
                        mahjong[1][6] = 2;
                        break;
                    case R.id.radioButton_t7_3:
                        mahjong[1][6] = 3;
                        break;
                    case R.id.radioButton_t7_4:
                        mahjong[1][6] = 4;
                        break;
                }
            }
        });


        rg_t8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t8_0:
                        mahjong[1][7] = 0;
                        break;
                    case R.id.radioButton_t8_1:
                        mahjong[1][7] = 1;
                        break;
                    case R.id.radioButton_t8_2:
                        mahjong[1][7] = 2;
                        break;
                    case R.id.radioButton_t8_3:
                        mahjong[1][7] = 3;
                        break;
                    case R.id.radioButton_t8_4:
                        mahjong[1][7] = 4;
                        break;
                }
            }
        });


        rg_t9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_t9_0:
                        mahjong[1][8] = 0;
                        break;
                    case R.id.radioButton_t9_1:
                        mahjong[1][8] = 1;
                        break;
                    case R.id.radioButton_t9_2:
                        mahjong[1][8] = 2;
                        break;
                    case R.id.radioButton_t9_3:
                        mahjong[1][8] = 3;
                        break;
                    case R.id.radioButton_t9_4:
                        mahjong[1][8] = 4;
                        break;
                }
            }
        });

        rg_east.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_east_0:
                        mahjong[3][0] = 0;
                        break;
                    case R.id.radioButton_east_1:
                        mahjong[3][0] = 1;
                        break;
                    case R.id.radioButton_east_2:
                        mahjong[3][0] = 2;
                        break;
                    case R.id.radioButton_east_3:
                        mahjong[3][0] = 3;
                        break;
                    case R.id.radioButton_east_4:
                        mahjong[3][0] = 4;
                        break;
                }
            }
        });

        rg_south.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_south_0:
                        mahjong[3][1] = 0;
                        break;
                    case R.id.radioButton_south_1:
                        mahjong[3][1] = 1;
                        break;
                    case R.id.radioButton_south_2:
                        mahjong[3][1] = 2;
                        break;
                    case R.id.radioButton_south_3:
                        mahjong[3][1] = 3;
                        break;
                    case R.id.radioButton_south_4:
                        mahjong[3][1] = 4;
                        break;
                }
            }
        });

        rg_west.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_west_0:
                        mahjong[3][2] = 0;
                        break;
                    case R.id.radioButton_west_1:
                        mahjong[3][2] = 1;
                        break;
                    case R.id.radioButton_west_2:
                        mahjong[3][2] = 2;
                        break;
                    case R.id.radioButton_west_3:
                        mahjong[3][2] = 3;
                        break;
                    case R.id.radioButton_west_4:
                        mahjong[3][2] = 4;
                        break;
                }
            }
        });

        rg_north.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_north_0:
                        mahjong[3][3] = 0;
                        break;
                    case R.id.radioButton_north_1:
                        mahjong[3][3] = 1;
                        break;
                    case R.id.radioButton_north_2:
                        mahjong[3][3] = 2;
                        break;
                    case R.id.radioButton_north_3:
                        mahjong[3][3] = 3;
                        break;
                    case R.id.radioButton_north_4:
                        mahjong[3][3] = 4;
                        break;
                }
            }
        });

        rg_redmiddle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_redmiddle_0:
                        mahjong[3][4] = 0;
                        break;
                    case R.id.radioButton_redmiddle_1:
                        mahjong[3][4] = 1;
                        break;
                    case R.id.radioButton_redmiddle_2:
                        mahjong[3][4] = 2;
                        break;
                    case R.id.radioButton_redmiddle_3:
                        mahjong[3][4] = 3;
                        break;
                    case R.id.radioButton_redmiddle_4:
                        mahjong[3][4] = 4;
                        break;
                }
            }
        });

        rg_whiteboard.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_whiteboard_0:
                        mahjong[3][5] = 0;
                        break;
                    case R.id.radioButton_whiteboard_1:
                        mahjong[3][5] = 1;
                        break;
                    case R.id.radioButton_whiteboard_2:
                        mahjong[3][5] = 2;
                        break;
                    case R.id.radioButton_whiteboard_3:
                        mahjong[3][5] = 3;
                        break;
                    case R.id.radioButton_whiteboard_4:
                        mahjong[3][5] = 4;
                        break;
                }
            }
        });

        rg_greenrich.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_greenrich_0:
                        mahjong[3][6] = 0;
                        break;
                    case R.id.radioButton_greenrich_1:
                        mahjong[3][6] = 1;
                        break;
                    case R.id.radioButton_greenrich_2:
                        mahjong[3][6] = 2;
                        break;
                    case R.id.radioButton_greenrich_3:
                        mahjong[3][6] = 3;
                        break;
                    case R.id.radioButton_greenrich_4:
                        mahjong[3][6] = 4;
                        break;
                }
            }
        });

        rg_spring.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_spring_0:
                        mahjong[4][0] = 0;
                        break;
                    case R.id.radioButton_spring_1:
                        mahjong[4][0] = 1;
                        break;
                }
            }
        });

        rg_summer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_summer_0:
                        mahjong[4][1] = 0;
                        break;
                    case R.id.radioButton_summer_1:
                        mahjong[4][1] = 1;
                        break;
                }
            }
        });

        rg_fall.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_fall_0:
                        mahjong[4][2] = 0;
                        break;
                    case R.id.radioButton_fall_1:
                        mahjong[4][2] = 1;
                        break;
                }
            }
        });

        rg_winter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_winter_0:
                        mahjong[4][3] = 0;
                        break;
                    case R.id.radioButton_winter_1:
                        mahjong[4][3] = 1;
                        break;
                }
            }
        });

        rg_plum.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_plum_0:
                        mahjong[4][4] = 0;
                        break;
                    case R.id.radioButton_plum_1:
                        mahjong[4][4] = 1;
                        break;
                }
            }
        });

        rg_lan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_lan_0:
                        mahjong[4][5] = 0;
                        break;
                    case R.id.radioButton_lan_1:
                        mahjong[4][5] = 1;
                        break;
                }
            }
        });

        rg_bamboo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_bamboo_0:
                        mahjong[4][6] = 0;
                        break;
                    case R.id.radioButton_bamboo_1:
                        mahjong[4][6] = 1;
                        break;
                }
            }
        });

        rg_orange.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.radioButton_orange_0:
                        mahjong[4][7] = 0;
                        break;
                    case R.id.radioButton_orange_1:
                        mahjong[4][7] = 1;
                        break;
                }
            }
        });


        //下一步
        b_next_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //計算台數

                totalTai();

                //debug 用
                String j;
                int k = 0;
                for(int i = 0;i<taiscore_explain.size();i++){
                    j = taiscore_explain.get( i );
                    k = rulescore_get[i];
                    Log.d("台數詳解",j);
                    Log.d("台數總計",String.valueOf(k));
                }


                //傳送詳細台數及台數名稱
                Intent intent = new Intent(HandInput.this, HandInputCheck.class);
                intent.putStringArrayListExtra("taiscore_explain", (ArrayList<String>) taiscore_explain);
                intent.putExtra("rulescore_get",rulescore_get);//實際獲得台數
                intent.putExtra("rulescore",rulescore);//規定台數
                startActivity(intent);

            }
        });
    }

    private void  totalTai(){
        //tai表示台數，符合該方法則台數相加
        int Rule_count = 0;
        boolean R_29 = false, R_19 = false, R_20 = false, R_7 = false, R_26 = false, R_14 = false;

        //Rule6:花牌(順風順花順季)，EX:東春梅、南夏蘭。算一台。by豐
        //東風春梅
        if(mahjong[4][8] == 0 && mahjong[4][0] == 1 && mahjong[4][4] == 1){
            rulescore_get[5] = rulescore[5];
            taiscore_explain.add(getResources().getString(R.string.Rule6_Name) + rulescore[5] + "台；");
        }
        //南風夏蘭
        else if(mahjong[4][8] == 1 && mahjong[4][1] == 1 && mahjong[4][5] == 1){
            rulescore_get[5] = rulescore[5];
            taiscore_explain.add(getResources().getString(R.string.Rule6_Name) + rulescore[5] + "台；");
        }
        //西風秋竹
        else if(mahjong[4][8] == 2 && mahjong[4][2] == 1 && mahjong[4][6] == 1){
            rulescore_get[5] = rulescore[5];
            taiscore_explain.add(getResources().getString(R.string.Rule6_Name) + rulescore[5] + "台；");
        }
        //北風冬菊
        else if(mahjong[4][8] == 3 && mahjong[4][3] == 1 && mahjong[4][7] == 1){
            rulescore_get[5] = rulescore[5];
            taiscore_explain.add(getResources().getString(R.string.Rule6_Name) + rulescore[5] + "台；");
        }



        Rule_count = 0;
        //Rule29:八仙過海，拿到全部八張花牌時，應完成補牌動作，才可喊胡，三家通賠一底八台。補進之牌，若造成手牌胡牌者，應另加計。補進之牌，若手牌沒有胡牌者，不得亮牌。by豐
        for(int i = 0 ; i <8 ; i++ ){
            if(mahjong[4][i]==1){
                Rule_count = Rule_count + 1;
            }
        }
        if(Rule_count == 8){
            rulescore_get[28] = rulescore[28];
            taiscore_explain.add(getResources().getString(R.string.Rule29_Name) + rulescore[28] + "台；");
            R_29 = true ;
        }

        //Rule16:花槓，胡牌時門前有『梅蘭竹菊』或『春夏秋冬』任一組。by豐
        //八仙過海與花槓不可累計
        if(((mahjong[4][0] == 1 && mahjong[4][1] == 1 && mahjong[4][2] == 1&& mahjong[4][3] == 1) ||(mahjong[4][4] == 1 && mahjong[4][5] == 1 && mahjong[4][6] == 1&& mahjong[4][7] == 1)) && !R_29 ){
            rulescore_get[15] = rulescore[15];
            taiscore_explain.add(getResources().getString(R.string.Rule16_Name) + rulescore[15] + "台；");
        }



        //Rule19:碰碰胡，胡牌全部由刻子再加一個對子組成。by豐、姸
        Rule_count = 0;//用來計算碰碰胡刻子
        for(int i = 0;i<4;i++){
            for (int j =0;j<9;j++){
                if(mahjong[i][j]==3){
                    Rule_count = Rule_count + 1; //先算刻子有幾個
                }
                if(mahjong[i][j]==2){
                    R_19 = true ;
                }
            }
        }
        if(Rule_count == 5 && R_19){
            rulescore_get[18] = rulescore[18];
            taiscore_explain.add(getResources().getString(R.string.Rule19_Name) + rulescore[18] + "台；");
        }



        //Rule17:三暗刻，手牌裡，有三組刻子（包括暗槓)。by豐
        //Rule22:四暗刻，胡牌時手裡有四組刻子（刻子代表三張一樣的），加五台。 by廢
        //Rule24:五暗刻，胡牌時手裡有五組刻子，加八台。 by豐
        Rule_count =  0;//用來計算四暗刻的組數
        for(int i = 0 ; i < 4 ; i++){
            for (int j =0;j<9;j++){
                if(mahjong[i][j]==3){
                    Rule_count = Rule_count + 1; //先算刻子有幾個
                }
            }
        }

        if(Rule_count == 5){ //Rule24:五暗刻
            rulescore_get[23] = rulescore[23];
            taiscore_explain.add(getResources().getString(R.string.Rule24_Name) + rulescore[23] + "台；");
        }else if(Rule_count == 4){ //Rule22:四暗刻
            rulescore_get[21] = rulescore[21];
            taiscore_explain.add(getResources().getString(R.string.Rule21_Name) + rulescore[21] + "台；");
        }else if(Rule_count == 3){ //Rule17:三暗刻
            rulescore_get[16] = rulescore[16];
            taiscore_explain.add(getResources().getString(R.string.Rule17_Name) + rulescore[16] + "台；");
        }


        //Rule8:三元牌(紅中白板發財，胡牌時有一張以上)，一台 By姸
        //Rule20:小三元，胡牌者中、發、白其中二組是刻子一組是對子。by豐
        //Rule25:大三元，胡牌時，有中、發、白三組刻子。 by豐
        Rule_count =  0;
        for(int i = 4;i<7;i++){
            if(mahjong[3][i]==3){
                Rule_count = Rule_count + 1; //先算刻子有幾個
            }
            if(mahjong[3][i]==2){//用來計算對子
                R_20 = true;
            }
            if(mahjong[3][i] !=0){
                R_7 = true;
            }
        }
        if(Rule_count == 3){ //Rule25:大三元，台數加八
            rulescore_get[24] = rulescore[24];
            taiscore_explain.add(getResources().getString(R.string.Rule25_Name) + rulescore[24] + "台；");
        }else if(Rule_count == 2 && R_20){//Rule20:小三元，台數加四
            rulescore_get[19] = rulescore[19];
            taiscore_explain.add(getResources().getString(R.string.Rule20_Name) + rulescore[19] + "台；");
        }else if (R_7){//Rule8:三元牌
            rulescore_get[7] = rulescore[7];
            taiscore_explain.add(getResources().getString(R.string.Rule8_Name) + rulescore[7] + "台；");
        }

        //Rule26:小四喜，胡牌者完成東、南、西、北其中三組刻子，一組對子。 by豐
        //Rule33:大四喜，手牌(含已露牌)有風牌之4種刻(槓)子，不分明暗，算清16台，不得加計門風、圈風台。 其餘另計。by豐
        Rule_count = 0;
        for(int i = 0;i<4;i++){
            if(mahjong[3][i]>=3){
                Rule_count = Rule_count + 1;
            }
            if(mahjong[3][i]==2){
                R_26 = true;
            }
        }

        if(Rule_count == 4 && R_26){//Rule26:小四喜，台數加八
            rulescore_get[25] = rulescore[25];
            taiscore_explain.add(getResources().getString(R.string.Rule26_Name) + rulescore[25] + "台；");
        }else if(Rule_count == 4){  //Rule33:大四喜，台數加十六
            rulescore_get[25] = rulescore[25];
            taiscore_explain.add(getResources().getString(R.string.Rule33_Name) + rulescore[32] + "台；");
        }



        //Rule21:混一色，胡牌者只有一種數字牌，及字牌混合所組成。by豐
        Rule_count = 0;
        for(int i = 0; i<3;i++){
            for(int j = 0;j<9;j++){
                if(mahjong[i][j]>0){//將數字牌數累計
                    Rule_count = Rule_count + 1;
                }
                if(mahjong[3][j]>0){//將字牌累計
                    Rule_count = Rule_count + 1;
                }
            }
            if(Rule_count > 16){
                rulescore_get[20] = rulescore[20];
                taiscore_explain.add(getResources().getString(R.string.Rule21_Name) + rulescore[20] + "台；");
            }
            Rule_count = 0;
        }



        //Rule27:清一色，整副牌為同一花色所組成，由筒、條或萬所組成的牌。by豐
        Rule_count = 0;
        for(int j = 0; j<3; j++){
            for(int i = 0; i<9 ; i++){
                if(mahjong[j][i]>0){//將牌數累計
                    Rule_count = Rule_count + mahjong[j][i];
                }
            }
            if(Rule_count > 16){//假設大於17就代表全部都是同一花色
                rulescore_get[26] = rulescore[26];
                taiscore_explain.add(getResources().getString(R.string.Rule27_Name) + rulescore[26] + "台；");
            }
            Rule_count = 0;//每一種花色都要歸零重算
        }


        //Rule28:字一色，全由字牌所組成之牌種，可與圈風、門風、三元牌複數計算。by豐
        Rule_count =  0;
        for(int i = 0;i<7;i++){
            if(mahjong[3][i]>0){
                Rule_count = Rule_count + 1;
            }
        }
        if(Rule_count >16){
            rulescore_get[27] = rulescore[27];
            taiscore_explain.add(getResources().getString(R.string.Rule28_Name) + rulescore[27] + "台；");
        }


        //Rule14:平胡，胡牌由五組順子及一個對子組成，胡他人牌非自摸。牌中無字、花牌、呈兩面聽狀態。釣將不算。
        for(int i=0;i<5;i++){    //萬筒條
            for(int j=0;j<9;j++){
                //無字無花無刻子
                if(mahjong[i][j] != 3 && mahjong[4][j] == 0 && mahjong[3][j] == 0){
                    if(i<3 && j<7 && mahjong[i][j]!=0 && mahjong[i][j+1] != 0 && mahjong[i][j+2] !=0){
                        Rule_count = Rule_count + 1;
                        mahjong[i][j] = mahjong[i][j] - 1;
                        mahjong[i][j+1] = mahjong[i][j+1] - 1;
                        mahjong[i][j+2] = mahjong[i][j+2] - 1;
                    }else if(mahjong[i][j] == 2){
                        R_14 = true;
                    }
                }

            }
        }
        if(Rule_count == 5 && R_14 ){
            rulescore_get[13] = rulescore[13];//台數加二台
            taiscore_explain.add(getResources().getString(R.string.Rule14_Name) + rulescore[13] + "台；");
        }
    }
}
