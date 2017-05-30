package com.example.kashif.jussay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kashif.jussay.APIClasses.JusSayAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements Callback<String> {


    private static final String REGISTER_SUCCESS_MSG = "\"inserted successfully\"";


    private EditText userName_editText;
    private EditText userId_editText;
    private EditText userPassword_editText;
    private EditText userEmail_editText;
    private EditText userPhone_editText;
    private EditText userAddress_editText;

    private Button signUp_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        userName_editText = (EditText) findViewById(R.id.name_et);
        userId_editText = (EditText) findViewById(R.id.username_et);
        userPassword_editText = (EditText) findViewById(R.id.user_password_et);
        userEmail_editText = (EditText) findViewById(R.id.email_et);
        userPhone_editText = (EditText) findViewById(R.id.mobile_no_et);
        userAddress_editText = (EditText) findViewById(R.id.address_et);

        signUp_button = (Button) findViewById(R.id.signup_btn);


        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String userName = userName_editText.getText().toString().trim();
                final String userId = userId_editText.getText().toString().trim();
                final String userPassword = userPassword_editText.getText().toString().trim();
                final String userEmail = userEmail_editText.getText().toString().trim();
                final String userPhone = userPhone_editText.getText().toString().trim();
                final String userAddress = userAddress_editText.getText().toString().trim();

                userSignUp(userId, userName, userEmail, userPassword, userPhone,  userAddress);
            }
        });

    }



    public void userSignUp(String userId, String userName, String userEmail, String password, String userPhone, String userAddress){

        Call<String> call = JusSayAPIClient.getClient().signUp("signup",userId, userName, userEmail, password, userPhone, userAddress);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {

        if (response.isSuccessful()) {

            String response_msg = response.body().toString().trim();
            if (response_msg.equals(REGISTER_SUCCESS_MSG)) {
                Toast.makeText(this, REGISTER_SUCCESS_MSG, Toast.LENGTH_SHORT).show();
                finish();
            }
            else{
                Toast.makeText(this, response_msg, Toast.LENGTH_SHORT).show();
            }

        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(this,t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
