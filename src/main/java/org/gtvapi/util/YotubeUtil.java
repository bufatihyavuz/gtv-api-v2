package org.gtvapi.util;

public class YotubeUtil {

    private static final String API_KEY = "AIzaSyDB2yiuGCcrxSDMfkYnrhwFZRQOWQyuvrk";
    private static final String API_URL = "https://www.googleapis.com/youtube/v3/videos?id=";

    public static String generateYoutubeApiRequestURL(String videoId, String apiParams){

        return API_URL + videoId+"&key="+API_KEY+"&part="+ apiParams;

    }
}
