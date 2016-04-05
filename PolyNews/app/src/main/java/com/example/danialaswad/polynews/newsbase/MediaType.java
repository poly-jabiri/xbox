package com.example.danialaswad.polynews.newsbase;

/**
 * Created by danialaswad on 16/03/16.
 */
public enum MediaType {

    PHOTO("PHOTO"),VIDEO("VIDEO");
    private String media;

    MediaType(String media){
        this.media=media;
    }
    public static MediaType fromInt(int mediaType){
        switch (mediaType){
            case 0: return PHOTO;
            case 1: return VIDEO;
            default: return PHOTO;
        }
    }
}
