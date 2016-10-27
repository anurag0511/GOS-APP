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

public class Advisors_fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public Advisors_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_advisors_fragment, container, false);
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
        contactm obj = new contactm(true, R.drawable.rndas,"Dr.R.N. Das, IAS\n"+"(Rtd).Hon,ble Advisor to State Planning Board",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        //}

        results.add(obj);
        obj=new contactm(true, R.drawable.sknanda,"Dr.S.K Nanda, IAS\n" +
                "Chairman & Managing Director,GSFC Ltd.",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj = new contactm(true, R.drawable.msahu,"Shri M. Sahu, IAS\n"+"Chairman,Gujarat CSR Authority",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj = new contactm(true, R.drawable.hkdash,"Shri H.K. Dash, IAS\n"+"Secretary,Inter State Council Secretariat,Govt of India",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
        results.add(obj);
        obj = new contactm(true, R.drawable.gcmurmu,"Shri G.C.Murmu, IAS\n"+"Joint Secretary,Dept. of Expenditure,Govt. of India",R.drawable.ic_mail_outline_white_24px,R.drawable.ic_textsms_black_24px,R.drawable.ic_settings_phone_white_24px);
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
