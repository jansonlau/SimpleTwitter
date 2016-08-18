// 2. Calls getHomeTimeline (make network request)
// All the dots (tweet, user, getting network data) are connected here
// Converts tweetsArray into listView

package com.codepath.apps.simpletwitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codepath.apps.simpletwitter.fragments.TweetsListFragment;
import com.codepath.apps.simpletwitter.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity {
    // DECLARE TIMELINE VARIABLES
    private TwitterClient client;
//    private ArrayList<Tweet> tweetsArray; // arrayList that powers arrayAdapter
//    private TweetsArrayAdapter tweetsAdapter;
//    private ListView lvTweets;

    private TweetsListFragment fragmentTweetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // MOVED INTO TWEETSLISTFRAGMENT
//        // INITIALIZE TIMELINE VARIABLES
//        tweetsArray = new ArrayList<Tweet>();
//        tweetsAdapter = new TweetsArrayAdapter(this, tweetsArray);
//
//        lvTweets = (ListView) findViewById(R.id.lvTweets);
//        lvTweets.setAdapter(tweetsAdapter); // set adapter to listView

        if (savedInstanceState == null) { // Fragment not inflated yet
            fragmentTweetsList = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_timeline);
        }

        client = TwitterApplication.getRestClient(); // singleton client

        populateTimeline();
    }

    // Send API request for timeline from JSON
    // Populate the listView by creating Tweet objects from JSON

    // [ ] == JSONArray (ROOT)
    // { } == JSONObject
    private void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {

            // SUCCESS
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//                Log.d("DEBUG", response.toString());
//                tweetsAdapter.addAll(Tweet.fromJSONArray(response)); // call "fromJSONArray" function to convert JSONArray to arrayList<Tweet>
                fragmentTweetsList.addAll(Tweet.fromJSONArray(response)); // Add list of tweets to array adapter which adds to fragment
            }

            // FAILURE
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                Log.d("DEBUG", errorResponse.toString());
            }
        });
    }
}
