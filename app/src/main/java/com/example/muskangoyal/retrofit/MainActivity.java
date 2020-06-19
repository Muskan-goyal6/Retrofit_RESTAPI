package com.example.muskangoyal.retrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.muskangoyal.retrofit.Activities.AlbumActivity;
import com.example.muskangoyal.retrofit.Activities.PhotosActivity;
import com.example.muskangoyal.retrofit.Activities.PostsActivity;
import com.example.muskangoyal.retrofit.Activities.TodoActivity;
import com.example.muskangoyal.retrofit.Activities.UserActivity;

public class MainActivity extends AppCompatActivity {
     Button btnUser,btnpost,btnalbum,btntodo,btnphoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUser=findViewById(R.id.btnuser);
        btnpost=findViewById(R.id.btnpost);
        btnalbum=findViewById(R.id.btnalbum);
        btntodo=findViewById(R.id.btntodo);
        btnphoto=findViewById(R.id.btnphoto);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=null;
                switch (view.getId()){
                    case R.id.btnuser:
                        intent=new Intent(MainActivity.this,UserActivity.class);
                        break;
                    case R.id.btnpost:
                        intent=new Intent(MainActivity.this, PostsActivity.class);
                        break;
                    case R.id.btnalbum:
                        intent= new Intent(MainActivity.this, AlbumActivity.class);
                        break;
                    case R.id.btntodo:
                        intent=new Intent(MainActivity.this, TodoActivity.class);
                        break;
                    case R.id.btnphoto:
                        intent=new Intent(MainActivity.this, PhotosActivity.class);
                        break;
                }
                startActivity(intent);
            }
        };

        btnUser.setOnClickListener(onClickListener);
        btnpost.setOnClickListener(onClickListener);
        btnalbum.setOnClickListener(onClickListener);
        btntodo.setOnClickListener(onClickListener);
        btnphoto.setOnClickListener(onClickListener);

    }
}
