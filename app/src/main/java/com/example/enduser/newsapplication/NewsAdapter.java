package com.example.enduser.newsapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by EndUser on 8/25/2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsObject> {
    public NewsAdapter(Activity context, ArrayList<NewsObject> list){
        super(context, 0, list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //assgins the listview
        View listView = convertView;
        //inflates listview if it isn't already isn't inflated
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.news_template,parent,false);

        }
        //creates an instance of the current news in the listview
        NewsObject currentNews = getItem(position);
        TextView title =(TextView) listView.findViewById(R.id.title);
        title.setText(currentNews.getTitleOfArticle());

        TextView time = (TextView) listView.findViewById(R.id.time);
        time.setText(timeFormat(currentNews.getTimeOfArtilcePost()));

        ImageView sourceImage = (ImageView)  listView.findViewById(R.id.image_cover);
        Picasso.with(getContext()).load(currentNews.getImageResource()).into(sourceImage);


        return listView;
    }
    //this method properly formats the time displayed
    public String timeFormat(String time){
        StringBuilder properDate = new StringBuilder();
        properDate.append(time.substring(0,10));

        String hourString = time.substring(11,time.length()-7);
        String minuteString = time.substring(14,16);
        int hour = Integer.parseInt(hourString);
        int timeModulus = hour%12;
        properDate.append(", ").append(timeModulus).append(":"+ minuteString);
        if( ((double) hour)/12 >=1){
            properDate.append("PM");
        }
        else{
            properDate.append("AM");
        }
        return properDate.toString();
    }
}
