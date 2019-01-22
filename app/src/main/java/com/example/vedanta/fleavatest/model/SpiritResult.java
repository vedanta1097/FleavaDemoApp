package com.example.vedanta.fleavatest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpiritResult {

    @SerializedName("results")
    private List<Spirit> result;

    public SpiritResult(List<Spirit> result) {
        this.result = result;
    }

    public List<Spirit> getResult() {
        return result;
    }
}
