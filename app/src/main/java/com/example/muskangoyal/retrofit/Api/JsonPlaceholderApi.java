package com.example.muskangoyal.retrofit.Api;

import com.example.muskangoyal.retrofit.models.Album;
import com.example.muskangoyal.retrofit.models.Photo;
import com.example.muskangoyal.retrofit.models.Post;
import com.example.muskangoyal.retrofit.models.Todo;
import com.example.muskangoyal.retrofit.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderApi {
    @GET("/users")
    Call<ArrayList<User>>getUsers();
    @GET("/posts")
    Call<ArrayList<Post>>getPosts();
    @GET("/albums")
    Call<ArrayList<Album>>getAlbums();
    @GET("/todos")
    Call<ArrayList<Todo>>getTodos();
    @GET("/photos")
    Call<ArrayList<Photo>>getPhotos();
}
