package com.example.androidarchdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidarchdemo.roomFiles.User;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
       // myViewModel.setContext(this);
        myViewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                MyAdapter myAdapter = new MyAdapter(DisplayActivity.this, users);
                recyclerView.setAdapter(myAdapter);
            }
        });

    }
}
