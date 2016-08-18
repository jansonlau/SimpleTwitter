// 2. Displays fragments (control view pager)
// HomeTimeline and MentionsTimeline logic moved into individual fragment class

package com.codepath.apps.simpletwitter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.simpletwitter.fragments.HomeTimelineFragment;
import com.codepath.apps.simpletwitter.fragments.MentionsTimelineFragment;

public class TimelineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // Find viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);

        // Set viewpager adapter
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));

        // Find sliding tabs
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        // Attach sliding tab to viewpager
        tabStrip.setViewPager(vpPager);
    }

    // Return order of fragments in view pager
    public class TweetsPagerAdapter extends FragmentPagerAdapter {
        private String tabTitles[] = { "Home", "Mentions" };

        // Adapter gets manager of fragments
        public TweetsPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager); // pass to base class
        }

        // Control order and creation of fragments
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new HomeTimelineFragment();
            }
            else if (position == 1) {
                return new MentionsTimelineFragment();
            }
            else {
                return null;
            }
        }

        // Returns tab title
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

        // Returns how many fragments there are to choose from
        @Override
        public int getCount() {
            return tabTitles.length;
        }
    }
}
