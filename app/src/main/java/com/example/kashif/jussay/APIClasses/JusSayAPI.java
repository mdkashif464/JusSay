package com.example.kashif.jussay.APIClasses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kashif on 28/5/17.
 */

public interface JusSayAPI {

    @GET("api.php?action")
    public Call<String> loginUser(@Query("action") String action, @Query("username") String username, @Query("password") String password);

    @GET("api.php?action")
    public Call<ShowRatings> showRatingsOfUser(@Query("action") String action, @Query("user_id") String user_id);

    @GET("api.php?action")
    public Call<ShowAllUsersList> showAllUsersList(@Query("action") String action, @Query("user_id") String user_id);

    @POST("api.php?action")
    @FormUrlEncoded
    public Call<String> signUp(@Field("action") String action, @Field("username") String username, @Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("phone") String phone, @Field("address") String address );


    @POST("api.php?action")
    @FormUrlEncoded
    public Call<String> giveRating(@Field("action") String action, @Field("user_id") String user_id, @Field("category") String category, @Field("rating") String rating);


}
