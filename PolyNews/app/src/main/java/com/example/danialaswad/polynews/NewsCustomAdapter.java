package com.example.danialaswad.polynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.danialaswad.polynews.newsbase.News;
import com.example.danialaswad.polynews.newsbase.NewsImage;

import java.util.List;

/**
 * Created by danialaswad on 23/03/16.
 */
public class NewsCustomAdapter extends ArrayAdapter<News> {


    public NewsCustomAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.array_newcustomadapter,null);
        }
        TextView date = (TextView) convertView.findViewById(R.id.news_date);
        date.setText(getItem(position).getNewsDate().getNews_date());

        TextView category = (TextView) convertView.findViewById(R.id.news_category);
        category.setText(getItem(position).getCategory().toString());

        ImageView imageView = (ImageView) convertView.findViewById(R.id.news_imageView);
        NewsImage image = new NewsImage(imageView);
        image.execute(getItem(position).getWebpage().getImageLink());

        TextView title = (TextView) convertView.findViewById(R.id.news_title);
        title.setText(getItem(position).getTitle());

        return convertView;
    }


}
