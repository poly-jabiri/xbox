package com.example.danialaswad.polynews.newsbase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by danialaswad on 16/03/16.
 */
public class News implements Parcelable{
    private int id;
    private String title;
    private String content;
    private String author;
    private NewsDate newsDate;
    private Category category;
    private MediaType mediaType;
    private WebPage webpage;

    public News(int id, String title, String content, String author, String date, int category, int mediaType, String webpage) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.newsDate = new NewsDate(date);
        this.category = new Category(category);
        this.mediaType = MediaType.fromInt(mediaType);
        this.webpage = new WebPage(webpage);
    }

    protected News(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        author = in.readString();
        this.newsDate=new NewsDate(in.readString());
        this.category=new Category(in.readString());
        this.mediaType= MediaType.valueOf(in.readString());
        this.webpage=new WebPage(in.readString());
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public NewsDate getNewsDate() {
        return newsDate;
    }

    public Category getCategory() {
        return category;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public WebPage getWebpage() {
        return webpage;
    }

    @Override
    public int describeContents(){
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(content);
        dest.writeString(newsDate.toString());
        dest.writeString(category.toString());
        dest.writeString(mediaType.toString());
        dest.writeString(webpage.getImageLink());
    }

}