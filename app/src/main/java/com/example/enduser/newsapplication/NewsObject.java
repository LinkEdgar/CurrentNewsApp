package com.example.enduser.newsapplication;

/**
 * Created by EndUser on 8/24/2017.
 */

public class NewsObject {
    private String titleOfArticle;
    private String websiteLink;
    private String timeOfArtilcePost;
    private String imageResource;

    public NewsObject(){

    }
    public NewsObject(String title, String site, String time, String image){
        titleOfArticle = title;
        websiteLink = site;
        timeOfArtilcePost = time;
        imageResource = image;
    }

    public String getImageResource() {
        return imageResource;
    }

    public String getSourceOfArticle() {
        return websiteLink;
    }

    public String getTimeOfArtilcePost() {
        return timeOfArtilcePost;
    }

    public String getTitleOfArticle() {
        return titleOfArticle;
    }
}
