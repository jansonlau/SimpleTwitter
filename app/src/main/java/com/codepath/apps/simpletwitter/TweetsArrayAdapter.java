// Convert Tweet object into view (listView)

package com.codepath.apps.simpletwitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.simpletwitter.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {

    public TweetsArrayAdapter(Context context, List<Tweet> tweetsList) {
        super(context, android.R.layout.simple_list_item_1, tweetsList);
    }

    // BUILD AN ARRAY ADAPTER
    // Override and setup custom template

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get tweet
        Tweet tweet = getItem(position);

        // Inflate view
        if (convertView == null) { // view is not being recycled
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);
        }

        // Find subviews by id
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);

        // Populate data into subviews
        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());
        ivProfileImage.setImageResource(android.R.color.transparent); // set transparent to clear out old image

        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(ivProfileImage);

        // Return view
        return convertView;
    }
}
