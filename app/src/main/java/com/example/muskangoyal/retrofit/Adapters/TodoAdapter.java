package com.example.muskangoyal.retrofit.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Todo;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private ArrayList<Todo>todos;
    public TodoAdapter(ArrayList<Todo>todos){
        this.todos=todos;
    }

    public void setTodos(ArrayList<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_todo,viewGroup,false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int i) {
         Todo todo= todos.get(i);
         holder.cbTodoTitle.setText(todo.getTitle());
         holder.cbTodoTitle.setChecked(todo.isCompleted());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder{
         CheckBox cbTodoTitle;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            cbTodoTitle=itemView.findViewById(R.id.cbTodoTitle);
        }
    }
}
