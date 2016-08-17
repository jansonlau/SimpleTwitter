// Parse user information from JSONObject

package com.codepath.apps.simpletwitter.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    // GETTER FUNCTIONS
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public String getScreenName() {
        return screenName;
    }

    public long getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    // DECLARE USER VARIABLES
    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;

    // Parse user from JSON to User object
    public static User fromJSON(JSONObject jsonObject) {
        User user = new User();

        // Extract values from JSON and initialize these values
        try {
            user.name = jsonObject.getString("name");
            user.uid = jsonObject.getLong("id");
            user.screenName = jsonObject.getString("screen_name");
            user.profileImageUrl = jsonObject.getString("profile_image_url");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Return the User object
        return user;
    }
}
