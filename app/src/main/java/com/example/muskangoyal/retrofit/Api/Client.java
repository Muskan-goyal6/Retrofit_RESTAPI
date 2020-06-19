package com.example.muskangoyal.retrofit.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private final Retrofit retrofit =
            new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    private final JsonPlaceholderApi api =
            retrofit.create(JsonPlaceholderApi.class);

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public JsonPlaceholderApi getApi() {
        return api;
    }

    private Client () {}
    private static final Client ourInstance = new Client();

    public static Client getInstance () {
        return ourInstance;
    }
}
