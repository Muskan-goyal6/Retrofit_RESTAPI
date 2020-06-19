package com.example.muskangoyal.retrofit.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Album;
import com.example.muskangoyal.retrofit.models.Post;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private ArrayList<Album>albums;
    public AlbumAdapter(ArrayList<Album>albums){ this.albums=albums;}

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_album,viewGroup,false);
        return new AlbumViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int i) {
             Album album=albums.get(i);
             holder.tvAlbumTitle.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder{
        TextView tvAlbumTitle;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAlbumTitle=itemView.findViewById(R.id.tvAlbumTitle);
        }
    }
}
