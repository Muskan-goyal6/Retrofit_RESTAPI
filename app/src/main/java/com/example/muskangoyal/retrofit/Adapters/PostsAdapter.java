package com.example.muskangoyal.retrofit.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Post;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private ArrayList<Post>posts;
    public PostsAdapter(ArrayList<Post>posts){this.posts=posts;}

    public void setPosts(ArrayList<Post>posts){
        this.posts=posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_post,viewGroup,false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int i) {
          Post post= posts.get(i);
          holder.tvPostTitle.setText(post.getTitle());
          holder.tvPostBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tvPostTitle,tvPostBody;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPostTitle=itemView.findViewById(R.id.tvPostTitle);
            tvPostBody=itemView.findViewById(R.id.tvPostBody);
        }
    }
}
