package com.example.enduser.newsapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main contains the listview layout
        setContentView(R.layout.activity_main);
        //simple array list that takes strings
        ArrayList list = new ArrayList();
        list.add("yeet");
        list.add("Yo!");
        list.add("Yoshi");
        //find the listview
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);


    }
}
