package com.example.kashif.jussay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kashif.jussay.APIClasses.JusSayAPIClient;
import com.example.kashif.jussay.APIClasses.ShowMyRatingsList;
import com.example.kashif.jussay.APIClasses.ShowMyUsersLists;
import com.example.kashif.jussay.APIClasses.ShowRatings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowMyRatingsActivity extends AppCompatActivity implements Callback<ShowRatings>{

    TextView UserNametv;
    TextView friend_goodRating_tv;
    TextView friend_avgRating_tv;
    TextView friend_badRating_tv;
    TextView professional_goodRating_tv;
    TextView profession_avgRating_tv;
    TextView professional_badRating_tv;
    TextView collegue_goodRating_tv;
    TextView collegue_avgRating_tv;
    TextView collegue_badRating_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_ratings);



        UserNametv=(TextView)findViewById(R.id.user_name_et);
        friend_goodRating_tv=(TextView)findViewById(R.id.friendgood_no_tv);
        friend_avgRating_tv=(TextView)findViewById(R.id.friendavg_no_tv);
        friend_badRating_tv=(TextView)findViewById(R.id.friendbad_no_tv);
        collegue_goodRating_tv=(TextView)findViewById(R.id.colleguesgood_no_tv);
        collegue_avgRating_tv=(TextView)findViewById(R.id.colleguesavg_no_tv);
        collegue_badRating_tv=(TextView)findViewById(R.id.colleguesbad_no_tv);
        professional_goodRating_tv=(TextView)findViewById(R.id.professionalgood_no_tv);
        profession_avgRating_tv=(TextView)findViewById(R.id.professionalavg_no_tv);
        professional_badRating_tv=(TextView)findViewById(R.id.professionalbad_no_tv);


        Intent intent = getIntent();
        String userName = intent.getExtras().getString("userName");

        UserNametv.setText(userName);

        showMyRatingList(userName);


    }
    public void showMyRatingList(String userName){
       Call<ShowRatings> call = JusSayAPIClient.getClient().showRatingsOfUser("show_ratings", userName);
       call.enqueue(this);
    }
        @Override
        public void onResponse(Call<ShowRatings> call, Response<ShowRatings> response) {
            if (response.isSuccessful()){
               // Toast.makeText(this, response.body().showMyRatingsList.get(5).getGoodRating(), Toast.LENGTH_SHORT).show();

                professional_goodRating_tv.setText(response.body().showMyRatingsList.get(4).getGoodRating());
                professional_badRating_tv.setText(response.body().showMyRatingsList.get(4).getBadRating());
                profession_avgRating_tv.setText(response.body().showMyRatingsList.get(4).getAverageRating());

                friend_goodRating_tv.setText(response.body().showMyRatingsList.get(5).getGoodRating());
                friend_avgRating_tv.setText(response.body().showMyRatingsList.get(5).getAverageRating());
                friend_badRating_tv.setText(response.body().showMyRatingsList.get(5).getBadRating());

                collegue_goodRating_tv.setText(response.body().showMyRatingsList.get(6).getGoodRating());
                collegue_avgRating_tv.setText(response.body().showMyRatingsList.get(6).getAverageRating());
                collegue_badRating_tv.setText(response.body().showMyRatingsList.get(6).getBadRating());

            }
        }

        @Override
        public void onFailure(Call<ShowRatings> call, Throwable t) {

        }

}