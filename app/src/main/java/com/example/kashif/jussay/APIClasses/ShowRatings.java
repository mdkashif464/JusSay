package com.example.kashif.jussay.APIClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kashif on 29/5/17.
 */

public class ShowRatings {


    @SerializedName("sources")
    @Expose
    public List<ShowMyRatingsList> showMyRatingsList;

}
