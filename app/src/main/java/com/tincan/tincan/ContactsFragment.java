package com.tincan.tincan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View contacts = inflater.inflate(R.layout.fragment_contacts, container, false);
        ((TextView)contacts.findViewById(R.id.textView)).setText("Contacts");
        return contacts;
    }
}
