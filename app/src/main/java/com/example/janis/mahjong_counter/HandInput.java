package com.example.janis.mahjong_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class HandInput extends AppCompatActivity {

    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input);

        initImageInput();

    }
    private void initImageInput(){
        Log.d("image123", "image");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        mImageUrls.add("https://imageshack.com/a/img924/5392/edJdop.png");
        mImageUrls.add("https://ideapit.com/timgs/201602/863io420160217130236.jpg");
        initHandInput();
    }

    private void initHandInput(){
        RecyclerView handInputRecyclerView = findViewById(R.id.recycler_mahjong);
        HandInputRecyclerView adapter = new HandInputRecyclerView(mImageUrls, this);
        handInputRecyclerView.setAdapter(adapter);
        handInputRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
