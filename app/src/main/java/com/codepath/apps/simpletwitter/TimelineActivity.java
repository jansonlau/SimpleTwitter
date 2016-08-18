// 2. Calls getHomeTimeline (make network request)
// All the dots (tweet, user, getting network data) are connected here
// Converts tweetsArray into listView

package com.codepath.apps.simpletwitter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TimelineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
    }
}
