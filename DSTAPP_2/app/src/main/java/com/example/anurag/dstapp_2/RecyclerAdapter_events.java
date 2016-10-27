package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 16-03-2016.
 */

import android.Manifest;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RecyclerAdapter_events extends RecyclerView
        .Adapter<RecyclerAdapter_events
        .eventsHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<events> mDataset;
    private static MyClickListener myClickListener;

    public static class eventsHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView description;
        ImageView dateicon;
        ImageView timeicon;
        ImageView venueicon;
        ImageView contacticon;
        TextView date1;
        TextView time1;
        TextView venue1;
        TextView contact1;

        public eventsHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.desp);
            dateicon = (ImageView) itemView.findViewById(R.id.date_icon);
            timeicon = (ImageView) itemView.findViewById(R.id.time_icon);
            venueicon = (ImageView) itemView.findViewById(R.id.venue_icon);
            contacticon = (ImageView) itemView.findViewById(R.id.contact_icon);
            date1 = (TextView) itemView.findViewById(R.id.date);
            time1 = (TextView) itemView.findViewById(R.id.time);
            venue1 = (TextView) itemView.findViewById(R.id.venue);
            contact1 = (TextView) itemView.findViewById(R.id.contact);
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

    public RecyclerAdapter_events(ArrayList<events> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public eventsHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_list, parent, false);

        eventsHolder eventsHolder = new eventsHolder(view);
        return eventsHolder;
    }

    @Override
    public void onBindViewHolder(eventsHolder holder, final int position) {
        int posi = position;
        holder.label.setText(mDataset.get(position).gettitle());
        holder.description.setText(mDataset.get(position).getDescription());

        holder.dateicon.setImageResource(mDataset.get(position).getImage1());
        holder.timeicon.setImageResource(mDataset.get(position).getImage2());
        holder.venueicon.setImageResource(mDataset.get(position).getImage3());
        holder.contacticon.setImageResource(mDataset.get(position).getImage4());

        holder.date1.setText(mDataset.get(position).getDes1());
        holder.time1.setText(mDataset.get(position).getDes2());
        holder.venue1.setText(mDataset.get(position).getDes3());
        holder.contact1.setText(mDataset.get(position).getDes4());

        holder.label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),CoverpicViewer.class);
                view.getContext().startActivity(i);

            }
        });

        holder.dateicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri.Builder builder = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                    builder = CalendarContract.CONTENT_URI.buildUpon();
                }
                builder.appendPath("time");
                ContentUris.appendId(builder, Calendar.getInstance().getTimeInMillis());
                Intent intent = new Intent(Intent.ACTION_VIEW)
                        .setData(builder.build());
                intent.putExtra(CalendarContract.Events.TITLE, mDataset.get(position).gettitle());
                intent.putExtra(CalendarContract.Events.DESCRIPTION, mDataset.get(position).getDescription());
                view.getContext().startActivity(intent);


                // mimeType will popup the chooser any  for any implementing application (e.g. the built in calendar or applications such as "Business calendar"


            }
        });
        holder.date1.setOnClickListener(new View.OnClickListener() {
            //int posi = position;
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                Calendar beginCal = Calendar.getInstance();
                beginCal.set(2016, 04, 1, 18, 30);
                long startTime = beginCal.getTimeInMillis();

                Calendar endCal = Calendar.getInstance();
                endCal.set(2016, 04, 1, 22, 30);
                long endTime = endCal.getTimeInMillis();
                i.setType("vnd.android.cursor.item/event");
                i.putExtra(CalendarContract.Events.TITLE, mDataset.get(position).gettitle());
                i.putExtra(CalendarContract.Events.DESCRIPTION, mDataset.get(position).getDescription());
                // the time the event should start in millis. This example uses now as the start time and ends in 1 hour
                i.putExtra("beginTime", new Date().getTime());
                i.putExtra("endTime", new Date().getTime() + DateUtils.HOUR_IN_MILLIS);
                i.putExtra(CalendarContract.Events.EVENT_LOCATION, mDataset.get(position).getDes3());
                i.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginCal.getTimeInMillis());
                i.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endCal.getTimeInMillis());
                i.putExtra(CalendarContract.Events.STATUS, 1);
                //i.putExtra(Events.VISIBLE, 0);
                i.putExtra(CalendarContract.Events.HAS_ALARM, 1);
                // the action
                i.setAction(Intent.ACTION_EDIT);
                view.getContext().startActivity(i);
            }
        });

        holder.venueicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=23.2351846,72.6570028"));
                view.getContext().startActivity(intent);


            }
        });
        holder.venue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=23.2351846,72.6570028"));
                view.getContext().startActivity(intent);
            }
        });

        holder.contacticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + mDataset.get(position).getDes4()));
                if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                view.getContext().startActivity(callIntent);
            }
        });
    }

    public void addItem(events dataObj, int index) {
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
