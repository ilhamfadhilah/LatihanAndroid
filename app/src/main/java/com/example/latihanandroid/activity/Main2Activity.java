package com.example.latihanandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.latihanandroid.R;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    static final int CAPTURE_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView =  findViewById(R.id.imageView);
        button = findViewById(R.id.btnCaptureImage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               captureimage();
            }
        });
    }

    private void captureimage(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, CAPTURE_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        imageView.setImageBitmap(imageBitmap);

    }
}
