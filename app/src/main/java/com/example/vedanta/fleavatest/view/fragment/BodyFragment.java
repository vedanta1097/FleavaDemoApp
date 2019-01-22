package com.example.vedanta.fleavatest.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vedanta.fleavatest.R;

public class BodyFragment extends Fragment {

    public BodyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Body");
        return inflater.inflate(R.layout.fragment_body, container, false);
    }
}
