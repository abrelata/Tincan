package com.tincan.tincan;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {
    public TabAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return new SpeedDial();
            case 1:
                return new RecentFragment();
            case 2:
                return new ContactsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
