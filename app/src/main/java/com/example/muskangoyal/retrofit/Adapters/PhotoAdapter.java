package com.example.muskangoyal.retrofit.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Photo;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private ArrayList<Photo>photos;
    public PhotoAdapter(ArrayList<Photo>photos){this.photos=photos;}

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_photo,viewGroup,false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int i) {
         Photo photo=photos.get(i);
         holder.tvPhotoTitle.setText(photo.getTitle());
         //holder.imgPhoto.setImageURI(photo.getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{
        //ImageView imgPhoto;
        TextView tvPhotoTitle;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            //imgPhoto=itemView.findViewById(R.id.imgPhoto);
            tvPhotoTitle=itemView.findViewById(R.id.tvPhotoTitle);
        }
    }
}
