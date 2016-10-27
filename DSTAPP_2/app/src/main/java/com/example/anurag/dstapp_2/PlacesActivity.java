package com.example.anurag.dstapp_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;
    private static String LOG_TAG = "PlacesActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
       toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter_places(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
    }
    private ArrayList<places> getDataSet() {
        ArrayList results = new ArrayList<places>();
        //for (int index = 0; index < 20; index++) {
        String x1="JCARC Complex,\n"+" Near Shanidev Temple,\n"+" Adalaj Inter Section, SG Highway,\n"+" Gandhinagar-382423\n";
        String y1="This temple built by Shri Jagannath Cultural Academy and Research Centre (JCARC) is a replica of the Puri Jagannath Temple.";
        String z1=x1+y1;
        places obj = new places(R.drawable.jagannath_temple,"Jagannath Temple",z1);
        //}

        results.add(obj);
        String x = "Akshardham is a unique Complex that combines art, architecture, education, research, exhibitions and devotion at one place. ";
        String z = "Address:\n"+"Indian Cultural Complex \n" +
                "Sector 20, 'J' Road,\n" +
                "Gandhinagar - 382 020\n";
        String y = z+x;
        obj = new places(R.drawable.aksharadham_temple,"Aksharadham Temple",y);
        //obj=new contactm(R.drawable.shape,"Person2",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);

        String x2="Sector -7,\n"+" Gandhinagar,\n"+" Gujarat 382007\n";
        String y2="Indroda Nature Park (INP) is spread over an area of about 400 ha in Gandhinagar- the capital city of Gujarat. The Park is divided into two parts on the banks of river Sabarmati. The western part is known as Indroda Nature Park and the eastern part of the river Sabarmati is known as Wilderness Park.";
        String z2=x2+y2;
        obj = new places(R.drawable.indrodapark,"Indroda Park",z2);
        results.add(obj);
        return results;
    }
      @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerAdapter_places) mAdapter).setOnItemClickListener(new RecyclerAdapter_places
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //Toast.makeText(PlacesActivity.this, "pressed position " + position, Toast.LENGTH_SHORT).show();
                Log.d("meoww","fefnkefnkef");
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, CardViewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
