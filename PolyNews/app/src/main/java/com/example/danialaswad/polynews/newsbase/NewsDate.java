package com.example.danialaswad.polynews.newsbase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danialaswad on 23/03/16.
 */

public class NewsDate {
    private Date date;
    private String news_date;
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SS";

    public NewsDate(String news_date){
        this.news_date = news_date;
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        try {
            date = format.parse(news_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDate(){
        return date.toString().substring(0,10);
    }

    public String getNews_date(){
        return news_date.substring(0,10);
    }
}
