package com.example.anurag.dstapp_2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CoreGroupFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public CoreGroupFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_core_group_fragment, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter_person(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    private ArrayList<contactm> getDataSet() {
        ArrayList results = new ArrayList<contactm>();
        //for (int index = 0; index < 20; index++) {
        contactm obj = new contactm(false, R.drawable.shirishku,"Shri Shirish Ku. Mishra\n"+"(President)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        //}

        results.add(obj);
        obj=new contactm(false, R.drawable.saratdalal,"Dr. Sarat Dalai\n"+"(Vice President)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.narsahoo,"Dr. Narottam Sahoo\n"+"(General Secretary)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.tapankupal,"Shri Tapan Ku. Pal\n"+"(Treasurer)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.chittaranjan,"Shri Chittaranjan Mohanty\n"+"Secretary\n"+"(Finance and Property)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.digvijayg,"Dr. Digvijaya Giri\n"+"Secretary\n"+"(Coordination)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.satyaranj,"Shri Satya Ranjan Mishra\n"+"Secretary\n"+"(Socio-Cultural)",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.ramaprusty,"Shri Ramakanta Prusty\n"+"Joint Secretary",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.basantdas,"Shri Basant Das\n",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.bhuyan,"Shri P K Bhuyan\n",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.senapati,"Shri A. Senapati\n",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj=new contactm(false, R.drawable.binayjena,"Shri Binay Jena\n",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);

        return results;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((RecyclerAdapter_person) mAdapter).setOnItemClickListener(new RecyclerAdapter_person
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                //Toast.makeText(getActivity(), "pressed position " + position, Toast.LENGTH_SHORT).show();
                Log.d("meoww","fefnkefnkef");
            }
        });
    }
}
