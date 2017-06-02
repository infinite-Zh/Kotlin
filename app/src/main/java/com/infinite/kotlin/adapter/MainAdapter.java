package com.infinite.kotlin.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> titles;
    public MainAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }


//    @Override
//    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
//    }
}
