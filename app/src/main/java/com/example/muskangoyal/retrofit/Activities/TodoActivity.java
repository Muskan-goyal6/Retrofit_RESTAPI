package com.example.muskangoyal.retrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.muskangoyal.retrofit.Adapters.TodoAdapter;
import com.example.muskangoyal.retrofit.Api.Client;
import com.example.muskangoyal.retrofit.R;
import com.example.muskangoyal.retrofit.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends AppCompatActivity {
    RecyclerView rvTodo;
    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        rvTodo=findViewById(R.id.rvTodo);
        todoAdapter=new TodoAdapter(new ArrayList<Todo>());
        rvTodo.setLayoutManager(new LinearLayoutManager(this));
        rvTodo.setAdapter(todoAdapter);

        Client.getInstance().getApi().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                todoAdapter.setTodos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });

    }
}
