package com.example.vedanta.fleavatest.model;

import com.google.gson.annotations.SerializedName;

public class Spirit {

    @SerializedName("original_title")
    private String category;

    @SerializedName("overview")
    private String title;

    @SerializedName("backdrop_path")
    private String image;

    public Spirit(String category, String title, String image) {
        this.category = category;
        this.title = title;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
