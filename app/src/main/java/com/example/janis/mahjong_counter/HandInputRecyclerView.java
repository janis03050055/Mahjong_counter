package com.example.janis.mahjong_counter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HandInputRecyclerView extends RecyclerView.Adapter<HandInputRecyclerView.ViewHolder> {
    private List<String> mImagemahjong;
    private List<String> mImagemahjongName;
    private Context mContext;
    private int[][] mahjong = new int[5][9]; //[種類][細分]=數量

    public HandInputRecyclerView(List<String> Imagemahjong, List<String> ImagemahjongName, Context context){
        mImagemahjong = Imagemahjong;
        mImagemahjongName = ImagemahjongName;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_majonginput, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //點下該RecyclerView細項應該要發生甚麼事
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImagemahjong.get(position))
                .into(holder.imagemahjong);

        holder.parenthandinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mImagemahjong.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //radiobutton所選數量更動
        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int mahjong_count = group.indexOfChild(radioButton);//麻將張數
                //這一整個寫的超白癡不過我現在不想動腦
                switch (mahjong_count){
                    case 0:{
                        //條
                        if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][0] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][1] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][2] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][3] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][4] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][5] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][6] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][7] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][8] = 0;
                        }
                        //筒
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][0] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][1] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][2] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][3] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][4] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][5] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][6] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][7] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][8] = 0;
                        }
                        //萬
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][0] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][1] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][2] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][3] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][4] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][5] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][6] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][7] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][8] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.east))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][0] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.south))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][1] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.west))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][2] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.north))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][3] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.redmiddle))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][4] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.whiteboard))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][5] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.greenrich))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][6] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.spring))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][0] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.summer))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][1] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.fall))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][2] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.winter))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][3] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.plum))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][4] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.lan))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][5] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.bamboo))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][6] = 0;
                        }else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.orange))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][7] = 0;
                        }
                        break;
                    }
                    case 1:{
                        //條
                        if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][0] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][1] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][2] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][3] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][4] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][5] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][6] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][7] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][8] = 1;
                        }
                        //筒
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][0] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][1] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][2] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][3] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][4] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][5] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][6] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][7] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][8] = 1;
                        }
                        //萬
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][0] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][1] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][2] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][3] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][4] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][5] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][6] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][7] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][8] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.east))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][0] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.south))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][1] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.west))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][2] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.north))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][3] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.redmiddle))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][4] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.whiteboard))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][5] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.greenrich))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][6] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.spring))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][0] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.summer))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][1] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.fall))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][2] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.winter))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][3] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.plum))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][4] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.lan))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][5] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.bamboo))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][6] = 1;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.orange))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[4][7] = 1;
                        }
                        break;
                    }
                    case 2:{
                        //條
                        if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][0] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][1] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][2] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][3] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][4] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][5] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][6] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][7] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][8] = 2;
                        }
                        //筒
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][0] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][1] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][2] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][3] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][4] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][5] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][6] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][7] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][8] = 2;
                        }
                        //萬
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][0] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][1] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][2] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][3] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][4] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][5] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][6] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][7] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][8] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.east))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][0] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.south))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][1] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.west))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][2] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.north))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][3] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.redmiddle))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][4] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.whiteboard))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][5] = 2;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.greenrich))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][6] = 2;
                        }
                        break;
                    }
                    case 3:{
                        //條
                        if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][0] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][1] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][2] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][3] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][4] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][5] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][6] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][7] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][8] = 3;
                        }
                        //筒
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][0] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][1] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][2] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][3] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][4] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][5] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][6] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][7] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][8] = 3;
                        }
                        //萬
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][0] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][1] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][2] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][3] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][4] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][5] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][6] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][7] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][8] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.east))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][0] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.south))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][1] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.west))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][2] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.north))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][3] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.redmiddle))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][4] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.whiteboard))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][5] = 3;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.greenrich))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][6] = 3;
                        }
                        break;
                    }
                    case 4:{
                        //條
                        if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][0] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][1] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][2] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][3] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][4] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][5] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][6] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][7] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.b9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[0][8] = 4;
                        }
                        //筒
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][0] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][1] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][2] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][3] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][4] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][5] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][6] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][7] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.t9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[1][8] = 4;
                        }
                        //萬
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w1))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][0] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w2))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][1] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w3))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][2] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w4))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][3] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w5))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][4] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w6))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][5] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w7))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][6] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w8))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][7] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.w9))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[2][8] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.east))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][0] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.south))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][1] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.west))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][2] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.north))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][3] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.redmiddle))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][4] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.whiteboard))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][5] = 4;
                        }
                        else if(mImagemahjongName.get(position).equals(mContext.getResources().getString(R.string.greenrich))  ){
                            Toast.makeText(mContext, mImagemahjongName.get(position) + mahjong_count +"張", Toast.LENGTH_SHORT).show();
                            mahjong[3][6] = 4;
                        }
                        break;
                    }
                }
                //傳送陣列到顯示介面
                Intent intent = new Intent(holder.itemView.getContext(), Information.class);
                Bundle bundle = new Bundle();
                intent.putExtra("mahjong", mahjong);
                intent.putExtras(bundle);
                //holder.itemView.getContext().startActivity(intent);

            }
        });

    }



    @Override
    public int getItemCount() {
        return mImagemahjongName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imagemahjong;
        RadioGroup radioGroup;
        RadioButton radioButton0, radioButton1, radioButton2, radioButton3, radioButton4;
        RelativeLayout parenthandinput;

        public ViewHolder(View itemView) {
            super(itemView);
            imagemahjong = itemView.findViewById(R.id.image_mahjong);
            radioGroup = itemView.findViewById(R.id.radioButton_group);
            radioButton0 = itemView.findViewById(R.id.radioButton_0);
            radioButton0.setChecked(true);
            radioButton1 = itemView.findViewById(R.id.radioButton_1);
            radioButton2 = itemView.findViewById(R.id.radioButton_2);
            radioButton3 = itemView.findViewById(R.id.radioButton_3);
            radioButton4 = itemView.findViewById(R.id.radioButton_4);
            parenthandinput = itemView.findViewById(R.id.parent_handinput);



        }
    }
}
