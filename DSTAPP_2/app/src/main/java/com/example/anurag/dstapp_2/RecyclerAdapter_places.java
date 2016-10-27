package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 12-03-2016.
 */
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter_places extends RecyclerView
        .Adapter<RecyclerAdapter_places
        .placesHolder> {
    private static String LOG_TAG = "RecyclerView_Places";
    private ArrayList<places> mDataset;
    private static MyClickListener myClickListener;

    public static class placesHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        ImageView picicon;
        public placesHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.title_big);
            dateTime = (TextView) itemView.findViewById(R.id.small_title);
            picicon=(ImageView)itemView.findViewById(R.id.image);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public RecyclerAdapter_places(ArrayList<places> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public placesHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.places_list, parent, false);

        placesHolder placesHolder = new placesHolder(view);
        return placesHolder;
    }

    @Override
    public void onBindViewHolder(placesHolder holder, int position) {
        final int posi = position;
        holder.label.setText(mDataset.get(position).gettitle());
        holder.dateTime.setText(mDataset.get(position).getdescription());
        holder.picicon.setImageResource(mDataset.get(position).getimageid());
        holder.label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posi==0) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=23.178433,72.5766127"));
                    view.getContext().startActivity(intent);
                }
                else if (posi==1){
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=23.2318841,72.6719288"));
                    view.getContext().startActivity(intent);
                }
                else{
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?daddr=23.192653,72.6439926"));
                    view.getContext().startActivity(intent);
                }

            }
        });
    }

    public void addItem(places dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
