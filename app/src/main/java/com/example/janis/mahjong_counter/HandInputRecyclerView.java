package com.example.janis.mahjong_counter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HandInputRecyclerView extends RecyclerView.Adapter<HandInputRecyclerView.ViewHolder> {

    private ArrayList<String> mImagemahjong;
    private Context mContext;

    public HandInputRecyclerView(ArrayList<String> imagemahjong, Context context){
        mImagemahjong = imagemahjong;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_majonginput, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
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
    }

    @Override
    public int getItemCount() {
        return mImagemahjong.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imagemahjong;
        RadioButton radioButton0, radioButton1, radioButton2, radioButton3, radioButton4;
        RelativeLayout parenthandinput;

        public ViewHolder(View itemView) {
            super(itemView);
            imagemahjong = itemView.findViewById(R.id.image_mahjong);
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
