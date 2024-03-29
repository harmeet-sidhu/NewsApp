package com.sidhutechpvtltd.www.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Loads a list of news by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class NewsLoader extends AsyncTaskLoader<List<NewsStory>> {
    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();
    /** Query URL */
    private String mUrl;
    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }
    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"Test: onStartLoading() called");
        forceLoad();
    }
    /**
     * This is on a background thread.
     */
    @Override
    public List<NewsStory> loadInBackground() {
        Log.i(LOG_TAG,"Test: loadInBackground() called");
        if (mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of news.
        List<NewsStory> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
