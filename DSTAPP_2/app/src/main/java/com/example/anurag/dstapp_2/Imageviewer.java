package com.example.anurag.dstapp_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Imageviewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageviewer);
        PhotoViewAttacher image1,image2,image3,image4;
        ImageView fimg = (ImageView) findViewById(R.id.fullimg);
        Intent i =getIntent();
        switch(i.getIntExtra("number",0)){
            case 1:
                fimg.setImageResource(R.drawable.pastimg1);

                break;
            case 2:
                fimg.setImageResource(R.drawable.pastimg2);
                break;
            case 3:
                fimg.setImageResource(R.drawable.pastimg3);
                break;
            case 4:
                fimg.setImageResource(R.drawable.pastimg4);
                break;
        }
        image1 = new PhotoViewAttacher(fimg);

    }
}
