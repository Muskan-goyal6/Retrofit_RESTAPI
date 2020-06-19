package com.example.muskangoyal.retrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.muskangoyal.retrofit.Adapters.PostsAdapter;
import com.example.muskangoyal.retrofit.Api.Client;
import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    RecyclerView rvPost;
    PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPost=findViewById(R.id.rvPost);
        postsAdapter= new PostsAdapter(new ArrayList<Post>());
        rvPost.setLayoutManager(new LinearLayoutManager(this));
        rvPost.setAdapter(postsAdapter);

        Client.getInstance().getApi().getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                postsAdapter.setPosts(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}
