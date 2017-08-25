package com.example.enduser.newsapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by EndUser on 8/25/2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsObject> {
    public NewsAdapter(@NonNull Context context, @NonNull List<NewsObject> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //assgins the listview
        View listView = convertView;
        //inflates listview if it isn't already isn't inflated
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main,parent,false);

        }
        //creates an instance of the current news in the listview
        NewsObject currentNews = getItem(position);
        TextView title =(TextView) listView.findViewById(R.id.title);
        title.setText(currentNews.getTitleOfArticle());

        TextView time = (TextView) listView.findViewById(R.id.time);
        time.setText(currentNews.getTimeOfArtilcePost());

        ImageView sourceImage = (ImageView)  listView.findViewById(R.id.image_cover);
        Picasso.with(getContext()).load(currentNews.getImageResource()).into(sourceImage);


        return listView;
    }
}
