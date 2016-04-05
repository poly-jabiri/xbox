package com.example.danialaswad.polynews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.support.v4.app.Fragment;

import com.example.danialaswad.polynews.newsbase.News;
import com.example.danialaswad.polynews.newsbase.NewsDBHelper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by danialaswad on 16/03/16.
 */
public class NewsListFragment extends Fragment{
    private NewsCustomAdapter customAdapter;
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private Context context;
    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static NewsListFragment newInstance(int sectionNumber) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public NewsListFragment() {
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();
        final NewsDBHelper dbHelper = new NewsDBHelper(getActivity());
        try {

            dbHelper.createDataBase();
            dbHelper.openDataBase();
            customAdapter = new NewsCustomAdapter(getActivity(),0,dbHelper.getNewsFromDb());
            GridView gridView = (GridView) getView().findViewById(R.id.news_list);
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context,MainActivity.class);
                    String title = ((News)parent.getItemAtPosition(position)).getTitle();
                    intent.putExtra("newsArticle",title);
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbHelper.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        return rootView;
    }
}
