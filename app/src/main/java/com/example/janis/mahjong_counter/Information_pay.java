package com.example.janis.mahjong_counter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Information_pay extends AppCompatActivity {
    private List<String> taiscore_explain = new ArrayList<>();//放槍的人台數說明
    private int[] rulescore_get = new int[37];
    private  int pay_normal_tai = 0, pay_normal_money = 0; //各家都給
    private  int pay_gun_tai = 0, pay_gun_money = 0; //放槍要給
    private  int pay_home_tai = 0, pay_home_money = 0; //莊家放槍要給
    private  int pay_tai = 0, pay_money = 0;
    private ImageButton ib_explain;
    private TextView tv_title, tv_pay_tai, tv_pay_money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_pay);
        taiscore_explain = getIntent().getStringArrayListExtra("taiscore_explain");
        rulescore_get = getIntent().getIntArrayExtra("rulescore_get");

        ib_explain = findViewById(R.id.imageButton_explain);

        tv_pay_tai = findViewById(R.id.tv_total_tai_num);
        tv_pay_money = findViewById(R.id.tv_total_money_num);
        tv_title = findViewById(R.id.textView16_title);

        for(int i = 0;i<rulescore_get.length-1;i++){
            pay_tai = pay_tai + rulescore_get[i];
        }

        //莊家贏
        if(rulescore_get[34] != 0){
            tv_pay_tai.setText(String.valueOf(pay_tai));
            //莊家自摸大家都給
            if(rulescore_get[2] != 0)tv_title.setText("莊家自摸大家都給");
            //放槍的人給
            else tv_title.setText("放槍的人給莊家");
        }//非莊家贏
        else {
            //自摸大家都給
            if(rulescore_get[2] != 0){
                pay_tai = pay_tai - rulescore_get[34];
                pay_tai = pay_tai - rulescore_get[33];
                tv_pay_tai.setText(String.valueOf(pay_tai));
                tv_title.setText("自摸大家都給贏家");
            }//放槍的人是莊家給
            else if(rulescore_get[36] == 100 ){
                tv_pay_tai.setText(String.valueOf(pay_tai));
                tv_title.setText("莊家給贏家");
            }//放槍的人是一般人給
            else {
                pay_tai = pay_tai - rulescore_get[34];
                pay_tai = pay_tai - rulescore_get[33];
                tv_pay_tai.setText(String.valueOf(pay_tai));
                tv_title.setText("放槍的人給贏家");
            }
        }

        ib_explain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Information_pay.this)
                        .setItems(taiscore_explain.toArray(new String[taiscore_explain.size()]), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //String name = taiscore_explain.get(which);
                                //Toast.makeText(getApplicationContext(), getString(R.string.u_eat) + name, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

    }
}
