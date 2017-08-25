package com.example.enduser.newsapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Gets the latest news from the verge
    private String API_WEB_ADDRESS = "https://newsapi.org/v1/articles?source=the-verge&sortBy=top&apiKey=2ba3568a935d47f4971bfa683e064bdb";
    private NewsAdapter adapter;
    private ProgressBar loadingIndicator;
    private TextView emptyTextView;
    //TODO fix empty listview case
    //TODO fix time format
    //TODO add on click for the list view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main contains the listview layout
        setContentView(R.layout.activity_main);
        loadingIndicator = (ProgressBar) findViewById(R.id.loading_indicator);
        emptyTextView = (TextView) findViewById(R.id.empty_listview);
        //simple array list that takes strings
        ArrayList list = new ArrayList();
        ArrayList<NewsObject> newsObjectArrayList = new ArrayList<>();
        //find the listview
        ListView listView = (ListView) findViewById(R.id.list_view);
        adapter = new NewsAdapter(this, newsObjectArrayList);
        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.empty_listview));
        //Checks whether or not we have an internet connection
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        //creates a boolean stating whether we are connected or not
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            //sets the progress bar to visible
            emptyTextView.setVisibility(View.INVISIBLE);
            loadingIndicator.setVisibility(View.VISIBLE);
            //so it isn't displayed with the progress bar
            NetworkAsyncTask bookASYNCTask = new NetworkAsyncTask();
            bookASYNCTask.execute(API_WEB_ADDRESS);


        }
    }
    public class NetworkAsyncTask extends AsyncTask<String, Void, List<NewsObject>>{
        //will use the networksutil on another thread to fetch the JSOn data and turn it into a list for us to update our UI

        @Override
        protected List<NewsObject> doInBackground(String... params) {
            //if the string is valid we will run the network utils on it
            List<NewsObject> theNews = null;
            if(params != null && params.length >0){
                theNews = NetworkUtils.createNews(params[0]);
            }
            return theNews;
        }

        @Override
        protected void onPostExecute(List<NewsObject> newsObjects) {
            loadingIndicator.setVisibility(View.INVISIBLE);
            adapter.clear();
            if(newsObjects != null && !newsObjects.isEmpty()){
                adapter.addAll(newsObjects);
            }
        }
    }

}
