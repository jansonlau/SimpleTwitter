package com.codepath.apps.simpletwitter.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.simpletwitter.R;
import com.codepath.apps.simpletwitter.TweetsArrayAdapter;
import com.codepath.apps.simpletwitter.models.Tweet;

import java.util.ArrayList;
import java.util.List;

public class TweetsListFragment extends Fragment {
    private ArrayList<Tweet> tweetsArray; // arrayList that powers arrayAdapter
    private TweetsArrayAdapter tweetsAdapter;
    private ListView lvTweets;

    // Inflate fragment view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, container, false); // Inflate view to parent (aka container) and false (don't inflate immediately)
        lvTweets = (ListView) v.findViewById(R.id.lvTweets);
        lvTweets.setAdapter(tweetsAdapter); // set adapter to listView
        return v;
    }

    // ON CREATE
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tweetsArray = new ArrayList<Tweet>();
        tweetsAdapter = new TweetsArrayAdapter(getActivity(), tweetsArray); // "this" is not an activity, it is a fragment so use getActivity()
    }

    public void addAll(List<Tweet> tweets) {
        tweetsAdapter.addAll(tweets);
    }
}
