package com.example.janis.mahjong_counter;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PickImageFromGallery extends AppCompatActivity {
    Button Reselect;
    ImageView ivSelectPhoto;//瀏覽圖片
    Uri ImageUri;//圖片位址
    private static final int PICK_IMAGE = 100;//點選返回也可重新選擇圖片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_image_from_gallery);
        ivSelectPhoto = (ImageView) findViewById(R.id.iv_SelectPhoto);

        //取得傳回來的圖片位置
        Intent intent = getIntent();
        ImageUri = intent.getParcelableExtra("imageUri");

        //預覽所選擇的圖片
        ivSelectPhoto.setImageURI(ImageUri);

        //重新選擇圖片相關按鈕事件
        Reselect = (Button)findViewById(R.id.b_Reselect);
        Reselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
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
            //取得圖片位置
            ImageUri = data.getData();
            //預覽圖片
            ivSelectPhoto.setImageURI(ImageUri);
        }
    }

}
