package com.example.kashif.jussay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kashif.jussay.APIClasses.JusSayAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingToUser extends AppCompatActivity implements Callback<String>{


    TextView name_tv;
    TextView user_id_tv;
    TextView address_tv;
    Button submit_btn;

    String category;
    String userName;
    String user_id;
    String userAddress;

    String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_to_user);


        name_tv = (TextView) findViewById(R.id.name);
        user_id_tv = (TextView) findViewById(R.id.username_et);
        address_tv = (TextView) findViewById(R.id.address_et);
        submit_btn = (Button) findViewById(R.id.submit_btn);

        final RadioGroup attribute_rg = (RadioGroup)findViewById(R.id.attributes_rg);


        Intent intent = getIntent();
        userName = intent.getExtras().getString("userName");
        user_id = intent.getExtras().getString("userId");
        userAddress = intent.getExtras().getString("userAddress");
        category = intent.getExtras().getString("category");

        name_tv.setText(userName);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = attribute_rg.getCheckedRadioButtonId();

                if (selectedId != -1) {

                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedId);
                    rating = selectedRadioButton.getText().toString();
                    giveRating(user_id, category, rating);
                    Toast.makeText(RatingToUser.this,"Rating Registered",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    Toast.makeText(RatingToUser.this,"empty state",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void giveRating(String user_id, String category, String rating){
        Call<String> call = JusSayAPIClient.getClient().giveRating("rate_users",user_id, category, rating );
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {

            String response_msg = response.body().toString().trim();
           // Toast.makeText(this, response_msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

    }
}
