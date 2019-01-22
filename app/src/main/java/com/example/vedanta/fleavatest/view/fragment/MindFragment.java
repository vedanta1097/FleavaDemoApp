package com.example.vedanta.fleavatest.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vedanta.fleavatest.R;

public class MindFragment extends Fragment {

    public MindFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Mind");
        return inflater.inflate(R.layout.fragment_mind, container, false);
    }
}
