package com.example.muskangoyal.retrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.muskangoyal.retrofit.Adapters.UserAdapter;
import com.example.muskangoyal.retrofit.Api.Client;
import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {
    RecyclerView rvUser;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        rvUser=findViewById(R.id.rvUser);
        userAdapter=new UserAdapter(new ArrayList<User>());
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(userAdapter);

        Client.getInstance().getApi().getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                userAdapter.setUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }
}
