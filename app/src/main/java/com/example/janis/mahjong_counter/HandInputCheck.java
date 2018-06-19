package com.example.janis.mahjong_counter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HandInputCheck extends AppCompatActivity {
    private List<String> taiscore_explain = new ArrayList<>();//放槍的人台數說明
    private List<String> taiscore_homeexplain_win = new ArrayList<>();//莊家贏各家都賠說明
    private List<String> taiscore_otherexplain = new ArrayList<>();//其餘多賠說明
    private int[] rulescore = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,4,4,4,4,5,8,8,8,8,8,8,8,16,16,16,16,0,1,1};
    private int[] rulescore_get = new int[36];
    private TextView tv_Explain;
    private CheckBox ck_R1, ck_R2, ck_R3, ck_R4, ck_R5, ck_R7, ck_R9, ck_R10, ck_R11, ck_R12, ck_R13, ck_R17, ck_R15, ck_R18, ck_R22, ck_R23, ck_R24, ck_R30, ck_R31, ck_R32,ck_R34, ck_R35, ck_R36;
    private Button b_NextStep;
    private EditText et_R34;
    //private int tai = 0, tai_home = 0, tai_other = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input_check);

        taiscore_explain = getIntent().getStringArrayListExtra("taiscore_explain");
        rulescore_get = getIntent().getIntArrayExtra("rulescore_get");
        rulescore = getIntent().getIntArrayExtra("rulescore");
        tv_Explain = findViewById(R.id.textView_Explain);
        b_NextStep = findViewById(R.id.b_NextStep);

        ck_R1 = findViewById(R.id.checkBox_Rule1);
        ck_R2 = findViewById(R.id.checkBox_Rule2);
        ck_R3 = findViewById(R.id.checkBox_Rule3);
        ck_R4 = findViewById(R.id.checkBox_Rule4);
        ck_R5 = findViewById(R.id.checkBox_Rule5);
        ck_R7 = findViewById(R.id.checkBox_Rule7);
        ck_R9 = findViewById(R.id.checkBox_Rule9);
        ck_R10 = findViewById(R.id.checkBox_Rule10);
        ck_R11 = findViewById(R.id.checkBox_Rule11);
        ck_R12 = findViewById(R.id.checkBox_Rule12);
        ck_R13 = findViewById(R.id.checkBox_Rule13);
        ck_R15 = findViewById(R.id.checkBox_Rule15);
        ck_R18 = findViewById(R.id.checkBox_Rule18);
        ck_R23 = findViewById(R.id.checkBox_Rule23);
        ck_R30 = findViewById(R.id.checkBox_Rule30);
        ck_R31 = findViewById(R.id.checkBox_Rule31);
        ck_R32 = findViewById(R.id.checkBox_Rule32);
        ck_R35 = findViewById(R.id.checkBox_Rule35);
        ck_R36 = findViewById(R.id.checkBox_Rule36);

        et_R34 = findViewById(R.id.editText_Rule34);
        //大四喜時門風及圈風不可加計，所以讓選項消失
        if(rulescore_get[25]>0){
            ck_R4.setVisibility(View.INVISIBLE);
            ck_R5.setVisibility(View.INVISIBLE);
        }
        //暗刻由於無法直接得知，所以初步判斷後使用者再判斷一次
        if(rulescore_get[16]<0) ck_R17.setVisibility(View.INVISIBLE);
        if(rulescore_get[21]<0) ck_R22.setVisibility(View.INVISIBLE);
        if(rulescore_get[23]<0) ck_R24.setVisibility(View.INVISIBLE);

        //三暗刻
        ck_R17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule17_Explain);
                }
            }
        });
        //四暗刻
        ck_R22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule22_Explain);
                }
            }
        });
        //五暗刻
        ck_R24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule24_Explain);
                }
            }
        });

        //宣告聽牌
        ck_R36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule36_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule36_Name) + rulescore[35] + "台；");

                    //天聽、地聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、地胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    rulescore_get[35] = rulescore[35];

                }else{
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule36_Name) + rulescore[35] + "台；");
                    rulescore_get[35] = 0 ;
                }
            }
        });

        //連莊
        ck_R34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    et_R34.setEnabled(true);
                    ck_R35.setChecked(true);
                }else {
                    et_R34.setEnabled(false);
                    et_R34.setText("0");
                    ck_R35.setChecked(false);
                }
            }
        });
        et_R34.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //輸入字串長度，假設沒輸入字則預設-1
                if(s.toString().length() > 0)rulescore_get[33] = Integer.parseInt(et_R34.getText().toString());
                else rulescore_get[33] = 0;
            }
        });
        //莊家
        ck_R35.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv_Explain.setText(R.string.Rule35_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule35_Name) + rulescore[34] + "台；");
                    rulescore_get[34] = rulescore[34];
                }else{
                    taiscore_explain.remove(getResources().getString(R.string.Rule35_Name) + rulescore[34] + "台；");
                    rulescore_get[34] = 0;
                }
            }
        });
        //自摸
        ck_R3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule3_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule3_Name) + rulescore[2] + "台；");

                    rulescore_get[2] = rulescore[2];

                }else{
                    ck_R1.setEnabled(true);ck_R2.setEnabled(true);
                    ck_R4.setEnabled(true);ck_R5.setEnabled(true);ck_R7.setEnabled(true);
                    ck_R9.setEnabled(true);ck_R11.setEnabled(true);ck_R12.setEnabled(true);
                    ck_R13.setEnabled(true);ck_R15.setEnabled(true);
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);


                    taiscore_explain.remove(getResources().getString(R.string.Rule3_Name) + rulescore[3] + "台；");
                    rulescore_get[2] = 0;
                }
            }
        });

        //門清
        ck_R1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule1_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule1_Name) + rulescore[0] + "台；");

                    //天聽、地聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、地胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    rulescore_get[0] = rulescore[0];;

                }else{
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule1_Name) + rulescore[0] + "台；");
                    rulescore_get[0] = 0;
                }
            }
        });


        //海底撈月
        ck_R13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule13_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule13_Name) + rulescore[12] + "台；");

                    //天胡、地胡
                    ck_R30.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R32.setEnabled(false);

                    //搶槓、河底撈魚
                    ck_R7.setChecked(false);ck_R12.setChecked(false);
                    ck_R7.setEnabled(false);ck_R12.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(true);

                    rulescore_get[12] = rulescore[12];

                }else{
                    ck_R30.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R7.setEnabled(true);ck_R12.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule13_Name) + rulescore[12] + "台；");
                    rulescore_get[12] = rulescore[0];
                }
            }
        });

        //河底撈魚
        ck_R12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule12_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule12_Name) + rulescore[11] + "台；");

                    //天胡、人胡
                    ck_R30.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R32.setEnabled(false);

                    //全求
                    ck_R15.setChecked(false);
                    ck_R15.setEnabled(false);

                    //槓上開花、海底撈月
                    ck_R11.setChecked(false);ck_R13.setChecked(false);
                    ck_R11.setEnabled(false);ck_R13.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(false);
                    ck_R3.setEnabled(false);

                    rulescore_get[11] = rulescore[11];

                }else{
                    ck_R30.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R11.setEnabled(true);ck_R13.setEnabled(true);
                    ck_R15.setEnabled(true);
                    ck_R3.setEnabled(true);
                    taiscore_explain.remove(getResources().getString(R.string.Rule12_Name) + rulescore[11] + "台；");
                    rulescore_get[11] = rulescore[0];
                }
            }
        });


        //槓上開花
        ck_R11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule11_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule11_Name) + rulescore[10] + "台；");

                    //天胡、地胡
                    ck_R30.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R32.setEnabled(false);

                    //搶槓、河底撈魚
                    ck_R7.setChecked(false);ck_R12.setChecked(false);
                    ck_R7.setEnabled(false);ck_R12.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(true);

                    rulescore_get[10] = rulescore[10];

                }else{
                    ck_R30.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R7.setEnabled(true);ck_R12.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule11_Name) + rulescore[10] + "台；");
                    rulescore_get[10] = rulescore[10];
                }
            }
        });

        //搶槓
        ck_R7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule7_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule7_Name) + rulescore[6] + "台；");
                    taiscore_otherexplain.add(getResources().getString(R.string.Rule7_Name) + rulescore[6] + "台；");
                    //天胡、人胡
                    ck_R30.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R32.setEnabled(false);

                    //全求
                    ck_R15.setChecked(false);
                    ck_R15.setEnabled(false);

                    //槓上開花、海底撈月
                    ck_R11.setChecked(false);ck_R13.setChecked(false);
                    ck_R11.setEnabled(false);ck_R13.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(false);
                    ck_R3.setEnabled(false);

                    rulescore_get[6] = rulescore[6];

                }else{
                    ck_R30.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R11.setEnabled(true);ck_R13.setEnabled(true);
                    ck_R15.setEnabled(true);ck_R3.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule7_Name) + rulescore[6] + "台；");
                    rulescore_get[6] = 0;
                }
            }
        });

        //風牌
        ck_R4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule4_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule4_Name) + rulescore[3] + "台；");
                    rulescore_get[3] = rulescore[3];
                }else{
                    taiscore_explain.remove(getResources().getString(R.string.Rule4_Name) + rulescore[3] + "台；");
                    rulescore_get[3] = 0;
                }
            }
        });

        //風圈
        ck_R5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule5_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule5_Name) + rulescore[4] + "台；");
                    rulescore_get[4] = rulescore[4];
                }else{
                    taiscore_explain.remove(getResources().getString(R.string.Rule5_Name) + rulescore[4] + "台；");
                    rulescore_get[4] = 0;
                }
            }
        });

        //全求
        ck_R15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule15_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule15_Name) + rulescore[14] + "台；");

                    //天聽、地聽、人聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、地胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    //不求、全求
                    ck_R2.setChecked(false);ck_R10.setChecked(false);
                    ck_R2.setEnabled(false);ck_R10.setEnabled(false);

                    //槓上開花、海底撈月
                    ck_R11.setChecked(false);ck_R13.setChecked(false);
                    ck_R11.setEnabled(false);ck_R13.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(false);
                    ck_R3.setEnabled(false);

                    rulescore_get[14] = rulescore[14];

                }else{
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R10.setEnabled(true);
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    ck_R11.setEnabled(true);ck_R13.setEnabled(true);
                    ck_R3.setEnabled(true);
                    taiscore_explain.remove(getResources().getString(R.string.Rule15_Name) + rulescore[14] + "台；");
                    rulescore_get[14] = 0;
                }
            }
        });

        //半求:手牌只剩一張牌單吊自摸，而其餘全吃或碰。
        //一定是自摸，天胡、地胡、人胡
        ck_R10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule10_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule10_Name) + rulescore[9] + "台；");

                    //天聽、地聽、人聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、地胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    //不求、全求
                    ck_R2.setChecked(false);ck_R15.setChecked(false);
                    ck_R2.setEnabled(false);ck_R15.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(true);

                    rulescore_get[9] = rulescore[9];
                }else{
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R15.setEnabled(true);
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    taiscore_explain.remove(getResources().getString(R.string.Rule10_Name) + rulescore[9] + "台；");
                    rulescore_get[9] = 0;
                }
            }
        });

        //不求:天胡、地胡、天聽、地聽、獨聽、人聽、半求、全求
        ck_R2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule2_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule2_Name) + rulescore[1] + "台；");

                    //天聽、地聽、人聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、地胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    //半求、全求
                    ck_R10.setChecked(false);ck_R15.setChecked(false);
                    ck_R10.setEnabled(false);ck_R15.setEnabled(false);

                    //自摸
                    ck_R3.setChecked(true);

                    rulescore_get[1] = rulescore[1];
                }else{
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    ck_R30.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R10.setEnabled(true);ck_R15.setEnabled(true);
                    ck_R31.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule2_Name) + rulescore[1] + "台；");
                    rulescore_get[1] = 0;
                }
            }
        });

        //獨聽:聽邊張、中洞、單吊。
        ck_R9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule9_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule9_Name) + rulescore[8] + "台；");


                    //地胡、人胡
                    ck_R30.setChecked(false);
                    ck_R30.setEnabled(false);

                    rulescore_get[8] = rulescore[8];
                }else{
                    ck_R30.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule9_Name) + rulescore[8] + "台；");
                    rulescore_get[8] = 0;
                }
            }
        });
        //地聽:天聽、地聽、獨聽、天胡、地胡、人胡、門清、不求不能算
        ck_R18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule18_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule18_Name) + rulescore[17] + "台；");
                    //天聽、地聽、人聽
                    ck_R23.setChecked(false);ck_R9.setChecked(false);
                    ck_R23.setEnabled(false);ck_R9.setEnabled(false);

                    //天胡、地胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    //門清
                    ck_R1.setChecked(false);
                    ck_R1.setEnabled(false);

                    //不求、半求、全求
                    ck_R2.setChecked(false);ck_R10.setChecked(false);ck_R15.setChecked(false);
                    ck_R2.setEnabled(false);ck_R10.setEnabled(false);ck_R15.setEnabled(false);


                    rulescore_get[17] = rulescore[17];
                }else{
                    ck_R23.setEnabled(true);ck_R9.setEnabled(true);
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R1.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R10.setEnabled(true);ck_R15.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule18_Name) + rulescore[17] + "台；");
                    rulescore_get[17] = 0;
                }
            }
        });

        //天聽:不可門清、不求、天胡、地聽、人聽
        ck_R23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule23_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule23_Name) + rulescore[22] + "台；");
                    //天聽、地聽、人聽
                    ck_R18.setChecked(false);ck_R9.setChecked(false);
                    ck_R18.setEnabled(false);ck_R9.setEnabled(false);

                    //天胡、地胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    //門清
                    ck_R1.setChecked(false);
                    ck_R1.setEnabled(false);

                    //不求、半求、全求
                    ck_R2.setChecked(false);ck_R10.setChecked(false);ck_R15.setChecked(false);
                    ck_R2.setEnabled(false);ck_R10.setEnabled(false);ck_R15.setEnabled(false);

                    rulescore_get[22] = rulescore[22];
                }else{
                    ck_R18.setEnabled(true);ck_R9.setEnabled(true);
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R1.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R10.setEnabled(true);ck_R15.setEnabled(true);

                    taiscore_explain.remove(getResources().getString(R.string.Rule23_Name) + rulescore[22] + "台；");
                    rulescore_get[22] = 0;
                }
            }
        });


        //計算天胡
        ck_R30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule30_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule30_Name) + rulescore[29] + "台；");
                    //天聽、地聽、人聽
                    ck_R9.setChecked(false);ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R9.setEnabled(false);ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //地胡、人胡
                    ck_R31.setChecked(false);ck_R32.setChecked(false);
                    ck_R31.setEnabled(false);ck_R32.setEnabled(false);

                    //門清、自摸
                    ck_R1.setChecked(false);ck_R3.setChecked(false);
                    ck_R1.setEnabled(false);ck_R3.setEnabled(false);

                    //不求、半求、全求
                    ck_R2.setChecked(false);ck_R10.setChecked(false);ck_R15.setChecked(false);
                    ck_R2.setEnabled(false);ck_R10.setEnabled(false);ck_R15.setEnabled(false);

                    //搶槓、槓上開花
                    ck_R7.setChecked(false);ck_R11.setChecked(false);
                    ck_R7.setEnabled(false);ck_R11.setEnabled(false);

                    //河底撈魚、海底撈月
                    ck_R12.setChecked(false);ck_R13.setChecked(false);
                    ck_R12.setEnabled(false);ck_R13.setEnabled(false);

                    rulescore_get[8] = rulescore[29];
                }else{
                    ck_R9.setEnabled(true);ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    ck_R31.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R1.setEnabled(true);ck_R3.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R10.setEnabled(true);ck_R15.setEnabled(true);
                    ck_R7.setEnabled(true);ck_R11.setEnabled(true);
                    ck_R12.setEnabled(true);ck_R13.setEnabled(true);
                    taiscore_explain.remove(getResources().getString(R.string.Rule30_Name) + rulescore[29] + "台；");
                    rulescore_get[29] = 0;
                }
            }
        });

        //計算人胡
        ck_R31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule31_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule31_Name) + rulescore[30] + "台；");
                    //天聽、地聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、地胡
                    ck_R30.setChecked(false);ck_R32.setChecked(false);
                    ck_R30.setEnabled(false);ck_R32.setEnabled(false);

                    //門清、自摸
                    ck_R1.setChecked(false);ck_R3.setChecked(false);
                    ck_R1.setEnabled(false);ck_R3.setEnabled(false);

                    //不求、半求、全求
                    ck_R2.setChecked(false);ck_R10.setChecked(false);ck_R15.setChecked(false);
                    ck_R2.setEnabled(false);ck_R10.setEnabled(false);ck_R15.setEnabled(false);

                    //槓上開花、海底撈月
                    ck_R11.setChecked(false);ck_R13.setChecked(false);
                    ck_R11.setEnabled(false);ck_R13.setEnabled(false);

                    rulescore_get[30] = rulescore[30];
                }else{
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    ck_R30.setEnabled(true);ck_R32.setEnabled(true);
                    ck_R1.setEnabled(true);ck_R3.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R10.setEnabled(true);ck_R15.setEnabled(true);
                    ck_R11.setEnabled(true);ck_R13.setEnabled(true);
                    taiscore_explain.remove(getResources().getString(R.string.Rule31_Name) + rulescore[30] + "台；");
                    rulescore_get[30] = rulescore[30];
                }
            }
        });

        //地胡
        ck_R32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //顯示提示訊息
                    tv_Explain.setText(R.string.Rule32_Explain);
                    taiscore_explain.add(getResources().getString(R.string.Rule32_Name) + rulescore[31] + "台；");
                    //天聽、地聽
                    ck_R18.setChecked(false);ck_R23.setChecked(false);
                    ck_R18.setEnabled(false);ck_R23.setEnabled(false);

                    //天胡、人胡
                    ck_R30.setChecked(false);ck_R31.setChecked(false);
                    ck_R30.setEnabled(false);ck_R31.setEnabled(false);

                    //門清、自摸
                    ck_R1.setChecked(false);ck_R3.setChecked(false);
                    ck_R1.setEnabled(false);ck_R3.setEnabled(false);

                    //不求、半求、全求
                    ck_R2.setChecked(false);ck_R10.setChecked(false);ck_R15.setChecked(false);
                    ck_R2.setEnabled(false);ck_R10.setEnabled(false);ck_R15.setEnabled(false);

                    //搶槓、河底撈魚
                    ck_R7.setChecked(false);ck_R12.setChecked(false);
                    ck_R7.setEnabled(false);ck_R12.setEnabled(false);

                    rulescore_get[31] = rulescore[31];
                }else{
                    ck_R18.setEnabled(true);ck_R23.setEnabled(true);
                    ck_R30.setEnabled(true);ck_R31.setEnabled(true);
                    ck_R1.setEnabled(true);ck_R3.setEnabled(true);
                    ck_R2.setEnabled(true);ck_R10.setEnabled(true);ck_R15.setEnabled(true);
                    ck_R7.setEnabled(true);ck_R12.setEnabled(true);
                    taiscore_explain.remove(getResources().getString(R.string.Rule31_Name) + rulescore[31] + "台；");
                    rulescore_get[31] = rulescore[0];
                }
            }
        });


        b_NextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                totalTai();
                //debug 用
                String j;
                for(int i = 0;i<taiscore_explain.size();i++){
                    j = taiscore_explain.get( i );
                    Log.d("台數詳解勾選",j);
                }
                // Log.d("台數總計公選",String.valueOf(tai));
                //傳送詳細台數及台數名稱
                Intent intent = new Intent(HandInputCheck.this, Information_pay.class);
                intent.putStringArrayListExtra("taiscore_explain", (ArrayList<String>) taiscore_explain);
                intent.putExtra("rulescore_get",rulescore_get);//實際獲得台數
                intent.putExtra("rulescore",rulescore);//規定台數
                startActivity(intent);
            }
        });
    }
    public void totalTai(){

        //獨聽自摸，平胡不成立
        if((ck_R9.isChecked() || ck_R3.isChecked()) && rulescore_get[13]>0){
            taiscore_explain.remove(getResources().getString(R.string.Rule14_Name) + rulescore[13] + "台；");
            rulescore_get[13] = 0;
        }

        //暗刻
        if(!ck_R17.isChecked()){
            taiscore_explain.remove(getResources().getString(R.string.Rule17_Name) + rulescore[16] + "台；");
            rulescore_get[16] = 0;
        }
        if(!ck_R22.isChecked()){
            taiscore_explain.remove(getResources().getString(R.string.Rule22_Name) + rulescore[21] + "台；");
            rulescore_get[21] = 0;
        }
        if(!ck_R24.isChecked()){
            taiscore_explain.remove(getResources().getString(R.string.Rule24_Name) + rulescore[23] + "台；");
            rulescore_get[23] = 0;
        }

        //連莊多兩倍
        if(ck_R34.isChecked() && rulescore_get[33]>0){
            rulescore_get[33] = rulescore_get[33] * 2;
        }
    }
}
