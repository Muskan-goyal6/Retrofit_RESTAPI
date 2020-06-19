package com.example.muskangoyal.retrofit.models;

import android.net.Uri;

import retrofit2.http.Url;

public class Photo {
    private int albumId;
    private int id;
    private String title;
    private Uri thumbnailUrl;

    public Photo(int albumId, int id, String title, Uri thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Uri getThumbnailUrl() {
        return thumbnailUrl;
    }
}
