// Parse tweet information from JSONObject (including User object)
// Store the data
// Display logic
// 3. Convert JSONArray to arrayList<Tweet>

package com.codepath.apps.simpletwitter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tweet {
    // GETTER FUNCTIONS
    public long getUid() {
        return uid;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    // DECLARE VARIABLES
    private User user;
    private String createdAt; // timestamp
    private String body;
    private long uid; // user ID

    // DESERIALIZE JSON
    public static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();

        // Extract values from JSON and initialize these values
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user")); // Call User's fromJSON function passing in JSONObject
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Return the Tweet object
        return tweet;
    }

    // Parse JSONArray to get arrayList
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject tweetJsonObject = jsonArray.getJSONObject(i); // get JSONObject
                Tweet tweet = fromJSON(tweetJsonObject);

                if (tweet != null) {
                    tweets.add(tweet);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue; // continue to parse tweets even if there is a failure
            }
        }
        return tweets;
    }
}
