package com.example.enduser.newsapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Gets the latest news from the verge
    private String API_WEB_ADDRESS = "https://newsapi.org/v1/articles?source=the-verge&sortBy=top&apiKey=2ba3568a935d47f4971bfa683e064bdb";
    private ArrayAdapter<NewsObject> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main contains the listview layout
        setContentView(R.layout.activity_main);
        //simple array list that takes strings
        ArrayList list = new ArrayList();
        ArrayList<NewsObject> newsObjectArrayList= new ArrayList<>();
        //find the listview
        ListView listView = (ListView) findViewById(R.id.list_view);
       // NewsAdapter adapter = new NewsAdapter();
        listView.setAdapter(adapter);


    }
    public class NetworkAsyncTask extends AsyncTask<String, Void, List<NewsObject>>{
        //will use the networksutil on another thread to fetch the JSOn data and turn it into a list for us to update our UI

        @Override
        protected List<NewsObject> doInBackground(String... params) {
            //if the string is valid we will run the network utils on it
            List<NewsObject> theNews = null;
            if(params != null && params.length >0){
                theNews = NetworkUtils.createNews(API_WEB_ADDRESS);
            }
            return theNews;
        }
        //TODO update our UI method


        @Override
        protected void onPostExecute(List<NewsObject> newsObjects) {
            //TODO
        }
    }
}
