package com.example.vedanta.fleavatest.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vedanta.fleavatest.R;
import com.example.vedanta.fleavatest.model.Spirit;
import com.example.vedanta.fleavatest.model.SpiritResult;
import com.example.vedanta.fleavatest.service.RestManager;
import com.example.vedanta.fleavatest.view.adapter.SpiritAdapter;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.vedanta.fleavatest.util.Constant.API_KEY;
import static com.example.vedanta.fleavatest.util.Constant.SPIRIT_URL;

public class SpiritFragment extends Fragment {

    private RestManager mRestManager;
    private LinearLayout mProgressBar;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Spirit");
        View rootView = inflater.inflate(R.layout.fragment_spirit, container, false);

        mProgressBar = rootView.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.INVISIBLE);

        mRecyclerView = rootView.findViewById(R.id.spirit_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRestManager = new RestManager();

        getSpirits();

        return rootView;
    }

    private void getSpirits() {
        mRecyclerView.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);

        Call<SpiritResult> call = mRestManager.getDataService(SPIRIT_URL).getSpirit(API_KEY, 1);

        call.enqueue(new Callback<SpiritResult>() {
            @Override
            public void onResponse(Call<SpiritResult> call, Response<SpiritResult> response) {
                if (response.isSuccessful()) {
                    SpiritResult result = response.body();
                    if (result != null) {
                        SpiritAdapter adapter = new SpiritAdapter(result.getResult(), getContext());
                        mRecyclerView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(getContext(), "error code: " + response.code(), Toast.LENGTH_LONG).show();
                }
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<SpiritResult> call, Throwable t) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public SpiritFragment() {
        // Required empty public constructor
    }
}
