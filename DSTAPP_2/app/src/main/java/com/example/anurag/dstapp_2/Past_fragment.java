package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 13-03-2016.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Past_fragment extends Fragment{

    public Past_fragment() {
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
        View rootView= inflater.inflate(R.layout.past_fragment, container, false);
        TextView iv = (TextView) rootView.findViewById(R.id.title);
        ImageView i1= (ImageView) rootView.findViewById(R.id.img1);
        ImageView i2= (ImageView) rootView.findViewById(R.id.img2);
        ImageView i3= (ImageView) rootView.findViewById(R.id.img3);
        ImageView i4= (ImageView) rootView.findViewById(R.id.img4);

        iv.setText("Ganesh Chaturthi");
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Imageviewer.class);
                i.putExtra("number",1);
                startActivity(i);
            }

        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Imageviewer.class);
                i.putExtra("number",2);
                startActivity(i);
            }

        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Imageviewer.class);
                i.putExtra("number",3);
                startActivity(i);
            }

        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Imageviewer.class);
                i.putExtra("number",4);
                startActivity(i);
            }

        });



        return rootView;

    }


}


