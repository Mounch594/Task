package com.mounika.task;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
/**
 * Created by Mounika on 6/9/2017.
 */

public class TabsPager extends FragmentStatePagerAdapter {

    int tabCount;
    public TabsPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                VideoFragment videoFragment = new VideoFragment();
                return videoFragment;
            case 1:
                ImageFragment imageFragment = new ImageFragment();
                return imageFragment;
            case 2:
               MilestoneFragment milestoneFragment = new MilestoneFragment();
                return milestoneFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
