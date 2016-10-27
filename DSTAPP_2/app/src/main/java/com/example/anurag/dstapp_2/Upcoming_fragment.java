package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 13-03-2016.
 */
    import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
    import android.util.Log;
    import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Upcoming_fragment extends Fragment{
         private RecyclerView mRecyclerView;
         private RecyclerView.Adapter mAdapter;
         private RecyclerView.LayoutManager mLayoutManager;
         private static String LOG_TAG = "UpcomingFragment";

        public Upcoming_fragment() {
            // Required empty public constructor
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View rootView=inflater.inflate(R.layout.upcoming_fragment, container, false);

            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new RecyclerAdapter_events(getDataSet());
            mRecyclerView.setAdapter(mAdapter);
            return rootView;

        }
    private ArrayList<events> getDataSet() {
        ArrayList results = new ArrayList<events>();
        //for (int index = 0; index < 20; index++) {
        //contactm obj = new contactm(R.drawable.shape,"Person1",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        //}
        events obj = new events("Utkal Divas Celebration","Cultural programme and activities showcasing the glimpses of Odisha and Gujarat to mark the 81st foundation day of Odisha",R.drawable.calendar,"April 1st",R.drawable.clock,"18:30-22:30",R.drawable.location,"Rangmanch, Sector 22, Gandhinagar",R.drawable.ic_settings_phone_white_24px,"9409660185");
        results.add(obj);

        return results;
    }


    @Override
    public void onResume() {
        super.onResume();
        ((RecyclerAdapter_events) mAdapter).setOnItemClickListener(new RecyclerAdapter_events
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //Toast.makeText(getActivity(), "pressed position " + position, Toast.LENGTH_SHORT).show();
                Log.d("meoww","fefnkefnkef");
            }
        });
    }
    }


