package com.example.danialaswad.polynews.newsbase;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by danialaswad on 23/03/16.
 */
public class WebPage {

    private String webPage;

    public WebPage(String webPage){
        this.webPage = webPage;
    }

    public String getWebPageAdress(){
        return webPage;
    }

    public String getImageLink(){
        String imageLink;
        if (!webPage.contains("www.youtube.com")){
            return webPage;
        }
        else{
            imageLink = webPage.replace("https://www.youtube.com/watch?v=","");
            return "http://img.youtube.com/vi/v="+imageLink+"/default.jpg";
        }
    }

}
