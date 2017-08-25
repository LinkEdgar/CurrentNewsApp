package com.example.enduser.newsapplication;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by EndUser on 8/24/2017.
 */

public final class NetworkUtils {
    //takes a url and connects it, if the connection is successful it returns a string version of the  JSON object

    public String makeHttpConnection(URL url){
        //TODO complete method
        //used to save the final json string
        String jsonString = "";
        //used to establish a connection with a Url
        HttpURLConnection urlConnection = null;
        //reads the input from the connection
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(15000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            //checks for valid response
            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonString = readInputStream(inputStream);
            }
            else{
                Log.e("makeHttpConnection","Did not get a succesful response code");
            }

        }
        catch(IOException e){
            Log.e("MakeHttpConnection","Could not properly parse the Json file ");
        }
        finally{
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
        return jsonString;
    }
    //Reads the input stream and returns a string of the input stream
    public String readInputStream(InputStream inputStream) throws IOException {
        //used to build the json string
        StringBuilder stringBuilder = new StringBuilder();
        //builds a string if the received input was not null
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                Log.e("readInputStream", "Could assign the string variable line");
            }
            while(line != null){
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }
        //TODO complete method

        return stringBuilder.toString();
    }
    // converts a string into a url
    public URL stringToUrl(String stringUrl){
        //TODO complete method
        URL url = null;
        try{
            url = new URL(stringUrl);
        }
        catch(MalformedURLException e){
            Log.e("stringToUrl", "Could not create a URL");
        }

        return url;
    }
    //extracts all of the info we need from the JSON string and returns an ArrayList of a NewsObject type
    public ArrayList<NewsObject> extractJsonInformation(){
        //TODO complete method

        return null;
    }
    //TODO make a method that brings all of the newtwork utils together
    //this method brings it all together for one call

}
