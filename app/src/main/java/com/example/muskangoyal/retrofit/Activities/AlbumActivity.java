package com.example.muskangoyal.retrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.muskangoyal.retrofit.Adapters.AlbumAdapter;
import com.example.muskangoyal.retrofit.Api.Client;
import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity extends AppCompatActivity {
    RecyclerView rvAlbum;
    AlbumAdapter albumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        rvAlbum=findViewById(R.id.rvAlbum);
        albumAdapter= new AlbumAdapter(new ArrayList<Album>());
        rvAlbum.setLayoutManager(new LinearLayoutManager(this));
        rvAlbum.setAdapter(albumAdapter);

        Client.getInstance().getApi().getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumAdapter.setAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}
