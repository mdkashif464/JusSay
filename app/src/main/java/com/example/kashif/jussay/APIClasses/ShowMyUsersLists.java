package com.example.kashif.jussay.APIClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kashif on 30/5/17.
 */

public class ShowMyUsersLists {

    @SerializedName("username")
    @Expose
    private String userId;


    @SerializedName("name")
    @Expose
    private String userName;


    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("password")
    @Expose
    private String password;


    @SerializedName("phone")
    @Expose
    private String phone;


    @SerializedName("address")
    @Expose
    private String address;



    public String getUserId() {
        return userId;
    }


    public String getuserName() {
        return userName;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public String getPhone() {
        return phone;
    }


    public String getAddress() {
        return address;
    }
}
