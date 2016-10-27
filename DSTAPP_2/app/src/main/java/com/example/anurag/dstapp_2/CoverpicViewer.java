package com.example.anurag.dstapp_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class CoverpicViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverpic_viewer);
        PhotoViewAttacher image1;
        ImageView fimg = (ImageView) findViewById(R.id.fullimg);
        fimg.setImageResource(R.drawable.coverphoto);
        image1 = new PhotoViewAttacher(fimg);
    }
}
