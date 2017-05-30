package com.example.kashif.jussay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kashif.jussay.APIClasses.JusSayAPI;
import com.example.kashif.jussay.APIClasses.JusSayAPIClient;
import com.example.kashif.jussay.APIClasses.ShowAllUsersList;
import com.example.kashif.jussay.APIClasses.ShowMyUsersLists;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowAllUsersActivity extends AppCompatActivity implements Callback<ShowAllUsersList> {

    private RecyclerView allUsersListRecyclerView;
    AllUserListAdapter allUserListAdapter;
    private Button show_my_ratings_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_users);


        show_my_ratings_button = (Button) findViewById(R.id.show_my_ratings_btn);
        allUsersListRecyclerView = (RecyclerView) this.findViewById(R.id.show_all_users_rView);
        allUsersListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        allUserListAdapter = new AllUserListAdapter();
        allUsersListRecyclerView.setAdapter(allUserListAdapter);

        Intent intent = getIntent();
        final String userName = intent.getExtras().getString("userName");

// fetching all users list
        showAllUsersList(userName);


        show_my_ratings_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowAllUsersActivity.this,ShowMyRatingsActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
            }
        });
    }

    public void showAllUsersList(String userName){
        Call<ShowAllUsersList> call = JusSayAPIClient.getClient().showAllUsersList("show_all_users", userName);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ShowAllUsersList> call, Response<ShowAllUsersList> response) {

        if (response.isSuccessful()){
           // Toast.makeText(this, response.body().showMyUsersLists.get(1).getUserId(), Toast.LENGTH_SHORT).show();
            allUserListAdapter.setUsersList((ArrayList<ShowMyUsersLists>) response.body().showMyUsersLists);
        }
    }

    @Override
    public void onFailure(Call<ShowAllUsersList> call, Throwable t) {

    }
}
