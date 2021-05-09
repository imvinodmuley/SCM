package com.example.dapp;

import android.content.Context;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    int totalTabs;

    private final Context myContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                fragment_rewards fragmentreward = new fragment_rewards();
                return fragmentreward;
            case 1:
                fragment_fine fragmentfine = new fragment_fine();
                return fragmentfine;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return totalTabs;
    }
}