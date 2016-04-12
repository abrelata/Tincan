package com.tincan.tincan;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View recent = inflater.inflate(R.layout.fragment_recent, container, false);
        ((TextView)recent.findViewById(R.id.textView)).setText("Recent");
        return recent;
    }
}
