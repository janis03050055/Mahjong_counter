package com.example.janis.mahjong_counter;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.support.design.widget.Snackbar;


public class Main extends AppCompatActivity {
    Button SelectPicture, TakePicture, HandInput;
    EditText editTextBaseScore , editTextMoreScore;
    TextView BaseScoreName, MoreScoreName;
    Uri ImageUri, TakePictureUri; //圖片位址
    View vMainView;
    int BaseScore = -1, MoreScore = -1, textSum = 0;
    private static final int PICK_IMAGE = 100; //點選返回也可重新選擇圖片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vMainView = findViewById(android.R.id.content);
        SelectPicture = findViewById(R.id.b_SelectPicture);
        TakePicture = findViewById(R.id.b_TakePicture);
        HandInput = findViewById(R.id.b_HandInput);
        editTextBaseScore = findViewById(R.id.editText_BaseScoreNumber);//底
        editTextMoreScore = findViewById(R.id.editText_MoreScoreNumber);//台
        BaseScoreName = findViewById(R.id.textView_BaseScoreName);
        MoreScoreName = findViewById(R.id.textView_MoreScoreName);

        //拍照相關按鈕事件
        TakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkScore())
                    openCamera();
            }
        });


        //選擇圖片相關按鈕事件
        SelectPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //底和台皆有輸入且合理就打開相簿
                if(checkScore())
                    openGallery();
            }
        });


        //手動輸入相關按鈕事件
        HandInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //底和台皆有輸入且合理就打開相簿
                if(checkScore()){
                    Intent gallery = new Intent(Main.this, HandInput.class);
                    startActivity(gallery);
                }

            }
        });


        //輸入底/台設定
        editTextBaseScore.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Snackbar.make(vMainView, R.string.OnChange + R.string.BaseScoreHint,Snackbar.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {
                //輸入字串長度，假設沒輸入字則預設-1
                textSum = s.toString().length();
                if(textSum > 0)BaseScore = Integer.parseInt(editTextBaseScore.getText().toString());
                else BaseScore = -1;
            }
        });
        editTextMoreScore.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Snackbar.make(vMainView, R.string.OnChange + R.string.MoreScoreHint,Snackbar.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {
                //輸入字串長度，假設沒輸入字則預設-1
                textSum = s.toString().length();
                if(textSum > 0) MoreScore = Integer.parseInt(editTextMoreScore.getText().toString());
                else  MoreScore = -1;
            }
        });





    }

    //開啟相機
    private void openCamera() {
        Intent camera = new Intent(Main.this, TakePicture.class);
        startActivity(camera);
    }

    //檢查所輸入底/台是否合理
    private boolean checkScore(){
        if(BaseScore < 0 || MoreScore < 0 ){
            AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
            builder.setMessage(R.string.HowManyScore)
                    .setCancelable(false)
                    .setPositiveButton("了解", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //將沒輸入的字變紅提醒使用者，底/台沒輸入或數字不合理
                            if(BaseScore < 0) BaseScoreName.setTextColor(Color.RED);
                            else BaseScoreName.setTextColor(Color.BLACK);

                            if(MoreScore < 0) MoreScoreName.setTextColor(Color.RED);
                            else MoreScoreName.setTextColor(Color.BLACK);

                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            return false;
        }else{
            BaseScoreName.setTextColor(Color.BLACK);
            MoreScoreName.setTextColor(Color.BLACK);
            return true;
        }
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
        /*if(ResultCode == RESULT_OK && RequestCode == 0){
            TakePictureUri = data.getData();
            //把值帶過去;
            Bitmap TakePictureBitmap = (Bitmap)data.getExtras().get("takePictureBitmap");
            Intent camera = new Intent(Main.this, TakePicture.class);
            camera.putExtra("takePictureBitmap", TakePictureBitmap);
            startActivity(camera);
        }*/



        //打開相簿
        if(ResultCode == RESULT_OK && RequestCode == PICK_IMAGE){
            ImageUri = data.getData();
            //把值帶過去;
            Intent gallery = new Intent(Main.this, PickImageFromGallery.class);
            gallery.putExtra("imageUri", ImageUri);
            startActivity(gallery);
        }
    }
}
