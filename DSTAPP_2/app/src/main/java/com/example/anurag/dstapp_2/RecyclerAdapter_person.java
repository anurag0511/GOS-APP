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

public class RecyclerAdapter_person extends RecyclerView
        .Adapter<RecyclerAdapter_person
        .ContactHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter2";
    private ArrayList<contactm> mDataset;
    private static MyClickListener myClickListener;

    public static class ContactHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView title;
        ImageView message;
        ImageView picicon;
        ImageView email;
        ImageView call;
        public ContactHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            //dateTime = (TextView) itemView.findViewById(R.id.textView2);
            picicon=(ImageView)itemView.findViewById(R.id.titleicon1);
            message=(ImageView)itemView.findViewById(R.id.message_icon);
            call=(ImageView)itemView.findViewById(R.id.call_icon);
            email=(ImageView)itemView.findViewById(R.id.mail_icon);
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

    public RecyclerAdapter_person(ArrayList<contactm> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inlist, parent, false);

        ContactHolder ContactHolder = new ContactHolder(view);
        return ContactHolder;
    }

    @Override
    public void onBindViewHolder(final ContactHolder holder, int position) {
        final int posi = position;
        //int posi = mDataset.get(position);
        if(mDataset.get(position).isAdvisor()){
            holder.title.setText(mDataset.get(position).gettitle());
            holder.picicon.setImageResource(mDataset.get(position).getpicid());
            holder.email.setVisibility(View.GONE);
            holder.message.setVisibility(View.GONE);
            holder.call.setVisibility(View.GONE);
        }
        else{
            holder.title.setText(mDataset.get(position).gettitle());
            holder.email.setImageResource(mDataset.get(position).getemailid());
            holder.message.setImageResource(mDataset.get(position).getmessage());
            holder.call.setImageResource(mDataset.get(position).getcall());
            holder.picicon.setImageResource(mDataset.get(position).getpicid());

        }


        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mailintent = new Intent(Intent.ACTION_SEND);

                mailintent.setData(Uri.parse("mailto:"));
                mailintent.setType("text/plain");
                if(posi==0){
                    mailintent.putExtra(Intent.EXTRA_EMAIL, new String[]{"agmsbsgn@gmail.com"});
                }
                else if(posi==2){
                    mailintent.putExtra(Intent.EXTRA_EMAIL, new String[]{"narottam.sahoo@gmail.com"});
                }
                else{
                    mailintent.putExtra(Intent.EXTRA_EMAIL, new String[]{"oriya.samaj@gmail.com"});
                }

                mailintent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                mailintent.putExtra(Intent.EXTRA_TEXT, "Message Body");
                view.getContext().startActivity(mailintent);
            }
        });
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("smsto:"));
                sendIntent.setType("vnd.android-dir/mms-sms");
                sendIntent.putExtra("address"  , new String ("8980029052"));
                sendIntent.putExtra("sms_body"  , "Test ");
                view.getContext().startActivity(sendIntent);
            }
        });

        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                if(posi==0) {
                    callIntent.setData(Uri.parse("tel:8980029052"));
                }
                else if(posi==1){
                    callIntent.setData(Uri.parse("tel:9879006852"));
                }

                else if(posi==2){
                    callIntent.setData(Uri.parse("tel:9879553960"));
                }
                else if(posi==3){
                    callIntent.setData(Uri.parse("tel:7600056770"));
                }
                else if(posi==4){
                    callIntent.setData(Uri.parse("tel:9998654143"));
                }
                else if(posi==5){
                    callIntent.setData(Uri.parse("tel:9998654143"));
                }
                else if(posi==6){
                    callIntent.setData(Uri.parse("tel:8128650827"));
                }
                else if(posi==7){
                    callIntent.setData(Uri.parse("tel:9924116129"));
                }
                else if(posi==8){
                    callIntent.setData(Uri.parse("tel:9824735068"));
                }else if(posi==9){
                    callIntent.setData(Uri.parse("tel:9824735068"));
                }else if(posi==10){
                    callIntent.setData(Uri.parse("tel:9824735068"));
                }else{
                    callIntent.setData(Uri.parse("tel:9824735068"));
                }

                try{
                view.getContext().startActivity(callIntent);
            }catch(Exception e){
                    Log.d("meoww","call not possible");
                }
            }
        });
    }

    public void addItem(contactm dataObj, int index) {
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
