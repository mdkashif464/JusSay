package com.example.kashif.jussay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kashif.jussay.APIClasses.JusSayAPIClient;
import com.example.kashif.jussay.APIClasses.ShowAllUsersList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<String> {

    private static final String LOGIN_SUCCESS_MSG = "\"Successfully logged in\"";
    private static final String LOGIN_FAILURE_MSG = "Incorrect Phone/Password";

    private Button signUp_btn;
    private Button login_btn;

    LinearLayout login_layout;
    LinearLayout before_login_layout;

    EditText userName_editText;
    EditText password_editText;
    ImageButton submit_Image_btn;
    String userName;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp_btn = (Button) findViewById(R.id.signup_btn);
        login_btn = (Button) findViewById(R.id.login_btn);

        login_layout = (LinearLayout) findViewById(R.id.user_credential_layout) ;
        before_login_layout = (LinearLayout) findViewById(R.id.before_login_pic_layout);

        userName_editText = (EditText) findViewById(R.id.username_et);
        password_editText = (EditText) findViewById(R.id.password_et);
        submit_Image_btn = (ImageButton) findViewById(R.id.submit_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_layout.setVisibility(View.VISIBLE);
                before_login_layout.setVisibility(View.GONE);
            }
        });


        submit_Image_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = userName_editText.getText().toString().trim();
                password = password_editText.getText().toString().trim();

                loginUser(userName, password);

            }
        });


        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

    }


    public void loginUser(String userName, String password) {
        Call<String> call = JusSayAPIClient.getClient().loginUser("login", userName, password);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {

        if (response.isSuccessful()){

            String response_msg = response.body().toString().trim();
            if (response_msg.equals(LOGIN_SUCCESS_MSG)) {
                Toast.makeText(this, LOGIN_SUCCESS_MSG, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, ShowAllUsersActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
                finish();
            }

            else{

                Toast.makeText(this, LOGIN_FAILURE_MSG, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

        Toast.makeText(this,t.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
