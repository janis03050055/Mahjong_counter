package com.example.janis.mahjong_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandInput extends AppCompatActivity {

    private List<String> mImageUrls = new ArrayList<>();
    private List<String> mImageName = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input);

        initImageInput();

    }
    private void initImageInput(){
        Log.d("image123", "image");
        mImageUrls = Arrays.asList(getResources().getStringArray(R.array.mahjongImage));
        mImageName = Arrays.asList(getResources().getStringArray(R.array.mahjong));

        initHandInput();
    }

    private void initHandInput(){
        RecyclerView handInputRecyclerView = findViewById(R.id.recycler_mahjong);
        HandInputRecyclerView adapter = new HandInputRecyclerView(mImageUrls,mImageName, this);
        handInputRecyclerView.setAdapter(adapter);
        handInputRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
