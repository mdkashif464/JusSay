package com.example.kashif.jussay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kashif.jussay.APIClasses.ShowMyUsersLists;
import com.google.gson.Gson;

public class GiveRatingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView showName_tv;
    private TextView showUserName_tv;
    private TextView showEmail_tv;
    private TextView showAddress_tv;

    Button friend_btn;

    String category;
    String userName;
    String user_id;
    String userEmail;
    String userAddress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_rating);


        showName_tv = (TextView) findViewById(R.id.name_tv);
        showUserName_tv = (TextView) findViewById(R.id.user_name_tv);
        showEmail_tv = (TextView) findViewById(R.id.email_tv);
        showAddress_tv = (TextView) findViewById(R.id.address_tv);
        friend_btn = (Button) findViewById(R.id.friend_btn);
        friend_btn.setOnClickListener(this);

        Intent intent = getIntent();
        String showMyUserLists = intent.getExtras().getString("intent_extras");
        Gson gson = new Gson();
        ShowMyUsersLists newshowMyUserLists = gson.fromJson(showMyUserLists, ShowMyUsersLists.class);


        userName = newshowMyUserLists.getuserName();
        user_id =  newshowMyUserLists.getuserName();
        userEmail = newshowMyUserLists.getEmail();
        userAddress = newshowMyUserLists.getAddress();


        showName_tv.setText(userName);
        showUserName_tv.setText(user_id);
        showEmail_tv.setText(userEmail);
        showAddress_tv.setText(userAddress);

    }

 public void ratePerson(View view){

     int id = view.getId();
     switch (id){

            case R.id.friend_btn:{
             category = "Friend";
                break;
         }
         case R.id.collegues_btn:{
             category = "Collegues";
             break;
         }
         case R.id.professionl_btn:{
             category = "Professional";
             break;
         }
         default:{
             break;
         }
        }

        Intent intent = new Intent(GiveRatingActivity.this, RatingToUser.class);
        intent.putExtra("category",category);
         intent.putExtra("userName",userName);
         intent.putExtra("userId",user_id);
         intent.putExtra("userAddress",userAddress);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.friend_btn:{
            category = "Friend";
            break;
        }
        case R.id.collegues_btn:{
            category = "Collegues";
            break;
        }
        case R.id.professionl_btn:{
            category = "Professional";
            break;
        }
        default:{
            break;
        }
    }

    Intent intent = new Intent(GiveRatingActivity.this, RatingToUser.class);
        intent.putExtra("category",category);
         intent.putExtra("userName",userName);
         intent.putExtra("userId",user_id);
         intent.putExtra("userAddress",userAddress);
    startActivity(intent);
    }
}
