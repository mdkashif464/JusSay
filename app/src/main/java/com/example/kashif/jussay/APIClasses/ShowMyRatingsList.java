package com.example.kashif.jussay.APIClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kashif on 30/5/17.
 */

public class ShowMyRatingsList {

    @SerializedName("user_id")
    @Expose
    private String userId;


    @SerializedName("category")
    @Expose
    private String category;


    @SerializedName("average_rating")
    @Expose
    private String averageRating;


    @SerializedName("bad_rating")
    @Expose
    private String badRating;


    @SerializedName("good_rating")
    @Expose
    private String goodRating;



    public String getUserId() {
        return userId;
    }


    public String getCategory() {
        return category;
    }


    public String getAverageRating() {
        return averageRating;
    }


    public String getBadRating() {
        return badRating;
    }

    public String getGoodRating() {
        return goodRating;
    }
}
