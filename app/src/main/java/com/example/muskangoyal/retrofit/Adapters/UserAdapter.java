package com.example.muskangoyal.retrofit.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<User> users;
    public UserAdapter(ArrayList<User>users){ this.users=users; }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_user,viewGroup,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int i) {
          User user=users.get(i);
          holder.tvUserName.setText(user.getName());
          holder.tvUserUsername.setText(user.getUsername());
          holder.tvUserEmail.setText(user.getEmail());
          holder.tvUserPhone.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
          TextView tvUserName,tvUserUsername,tvUserEmail, tvUserPhone;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
           tvUserName = itemView.findViewById(R.id.tvUserName);
           tvUserUsername=itemView.findViewById(R.id.tvUserUsername);
           tvUserEmail=itemView.findViewById(R.id.tvUserEmail);
           tvUserPhone=itemView.findViewById(R.id.tvUserPhone);
        }
    }

}
