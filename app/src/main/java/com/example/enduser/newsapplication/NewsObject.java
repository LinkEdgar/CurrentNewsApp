package com.example.enduser.newsapplication;

/**
 * Created by EndUser on 8/24/2017.
 */

public class NewsObject {
    private String titleOfArticle;
    private String sourceOfArticle;
    private String timeOfArtilcePost;
    private int imageResourceid;

    public NewsObject(){

    }
    public NewsObject(String title, String source, String time, int image){
        titleOfArticle = title;
        sourceOfArticle = source;
        timeOfArtilcePost = time;
        imageResourceid = image;
    }

    public int getImageResourceid() {
        return imageResourceid;
    }

    public String getSourceOfArticle() {
        return sourceOfArticle;
    }

    public String getTimeOfArtilcePost() {
        return timeOfArtilcePost;
    }

    public String getTitleOfArticle() {
        return titleOfArticle;
    }
}
