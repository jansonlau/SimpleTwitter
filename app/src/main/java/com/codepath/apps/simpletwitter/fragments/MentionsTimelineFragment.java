package com.codepath.apps.simpletwitter.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.codepath.apps.simpletwitter.TwitterApplication;
import com.codepath.apps.simpletwitter.TwitterClient;
import com.codepath.apps.simpletwitter.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MentionsTimelineFragment extends TweetsListFragment {
    private TwitterClient client;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient(); // singleton client
        populateTimeline();
    }

    // Send API request for timeline from JSON
    // Populate the listView by creating Tweet objects from JSON

    // [ ] == JSONArray (ROOT)
    // { } == JSONObject
    private void populateTimeline() {
        client.getMentionsTimeline(new JsonHttpResponseHandler() {

            // SUCCESS
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                Log.d("DEBUG", response.toString());
                addAll(Tweet.fromJSONArray(response)); // Add list of tweets to array adapter which adds to fragment
            }

            // FAILURE
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                Log.d("DEBUG", errorResponse.toString());
            }
        });
    }
}
