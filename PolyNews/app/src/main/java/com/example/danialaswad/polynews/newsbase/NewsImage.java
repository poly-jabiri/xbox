package com.example.danialaswad.polynews.newsbase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by danialaswad on 23/03/16.
 */
public class NewsImage extends AsyncTask<String,Void,Bitmap> {

    private ImageView imageView;

    public NewsImage(ImageView imageView){
        this.imageView = imageView;
    }


    @Override
    protected Bitmap doInBackground(String... params) {
        try {
            InputStream in = new URL(params[0]).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        //super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
