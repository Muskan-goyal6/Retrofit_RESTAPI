package com.example.muskangoyal.retrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.muskangoyal.retrofit.Adapters.PhotoAdapter;
import com.example.muskangoyal.retrofit.Adapters.PostsAdapter;
import com.example.muskangoyal.retrofit.Api.Client;
import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Photo;
import com.example.muskangoyal.retrofit.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
    RecyclerView rvPhoto;
    PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        rvPhoto=findViewById(R.id.rvPost);
        photoAdapter= new PhotoAdapter(new ArrayList<Photo>());
        rvPhoto.setLayoutManager(new LinearLayoutManager(this));
        rvPhoto.setAdapter(photoAdapter);

        Client.getInstance().getApi().getPhotos().enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photoAdapter.setPhotos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });
    }
}
