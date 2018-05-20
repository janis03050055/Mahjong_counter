package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main extends AppCompatActivity {
    Button SelectPicture;
    private static final int PICK_IMAGE = 100; //點選返回也可重新選擇圖片
    Uri ImageUri; //圖片位址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //選擇圖片相關按鈕事件
        SelectPicture = findViewById(R.id.b_SelectPicture);
        SelectPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        //拍照相關按鈕事件

        //手動輸入相關按鈕事件
    }

    //開啟相簿
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //只可選擇圖片
        gallery.setType("image/*");
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override
    //當該新活動退出時, 會回調onActivityResult(int, int, Intent)方法
    protected void onActivityResult(int RequestCode, int ResultCode, Intent data) {
        super.onActivityResult(RequestCode, ResultCode, data);
        if(ResultCode == RESULT_OK && RequestCode == PICK_IMAGE){
            ImageUri = data.getData();
            //把值帶過去;
            Intent intent = new Intent(Main.this, PickImageFromGallery.class);
            intent.putExtra("imageUri", ImageUri);
            startActivity(intent);
        }
    }
}
