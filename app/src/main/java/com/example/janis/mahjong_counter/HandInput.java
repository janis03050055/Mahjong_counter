package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HandInput extends AppCompatActivity {

    private List<String> mImageUrls = new ArrayList<>();
    private List<String> mImageName = new ArrayList<>();
    private int[][] mahjong = new int[5][9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_input);
        Button next_step = findViewById(R.id.b_NextStep);

        /*Intent i = getIntent();
        Bundle extras = i.getExtras();
        if(extras != null)  //this line is necessary for getting any value
        {
            mahjong = i.getIntArrayExtra("mahjong");
            Toast.makeText(this, "value="+mahjong[0]+""+mahjong[1], Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "value=", Toast.LENGTH_SHORT).show();
        }
        */
        next_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent information = new Intent(HandInput.this, Information.class);
                startActivity(information);
            }
        });

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
