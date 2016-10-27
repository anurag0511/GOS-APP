package com.example.anurag.dstapp_2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;



public class CardViewActivity extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    DataObject obj;
    private Toolbar toolbar;
    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/gujcost.gujarat?fref=ts"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/gujcost.gujarat?fref=ts"));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter_firstpage(getDataSet());
        mRecyclerView.setAdapter(mAdapter);


        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }




    @Override
    protected void onResume() {
        super.onResume();
        ((RecyclerAdapter_firstpage) mAdapter).setOnItemClickListener(new RecyclerAdapter_firstpage
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                //Toast.makeText(CardViewActivity.this,"pressed position "+ position,Toast.LENGTH_SHORT).show();
                if(position==0){
                    Intent listintent = new  Intent(CardViewActivity.this,QueueActivity.class);

                    startActivity(listintent);
                }
                else if(position==1){
                    Intent placeintent = new  Intent(CardViewActivity.this,PlacesActivity.class);

                    startActivity(placeintent);
                }
                else if (position == 2){
                    Intent eventintent = new Intent(CardViewActivity.this,EventsActivity.class);
                    startActivity(eventintent);
                }
                else if (position == 3){
                   //startActivity(getOpenFacebookIntent(getApplicationContext()));
                    String url = "https://www.facebook.com/gandhinagarodiya.samaj.9?fref=ts";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                }
                else if(position==4){
                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                    sendIntent.setData(Uri.parse("smsto:"));
                    sendIntent.setType("vnd.android-dir/mms-sms");
                    sendIntent.putExtra("address"  , new String ("9824735068"));
                    sendIntent.putExtra("sms_body"  , "I want ot join GOS ");
                    startActivity(sendIntent);
                }
                else{
                    String url ="http://www.nuaodisha.com/OdiaPanji.aspx";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                }


            }
        });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        //for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("People ",
                    "Whom to meet",R.drawable.people);
            results.add( obj);
            obj = new DataObject("Places","where to go",R.drawable.map);
            results.add(obj);
            obj = new DataObject("Events","whats happening",R.drawable.tool);
            results.add(obj);
            obj = new DataObject("Facebook","See our fb page",R.drawable.social);
            results.add(obj);
            obj = new DataObject("Join Us","want to know us",R.drawable.people_add);
            results.add(obj);
            obj = new DataObject("Miscellaneous","Visit the odisha calendar",R.drawable.business);
            results.add(obj);
        //}
        return results;
    }


}
