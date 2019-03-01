package com.example.androidarchdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidarchdemo.roomFiles.User;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<User> userList;
    User user;

    public MyAdapter(Context context, List userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        user = userList.get(i);
        myViewHolder.txtName.setText(user.getuName());
        myViewHolder.txtPassword.setText(user.getuPassword());
        myViewHolder.txtMobile.setText(user.getuMobile());
        myViewHolder.txtEmail.setText(user.getuEmail());
        myViewHolder.txtDesigntion.setText(user.getuDesignation());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPassword, txtMobile, txtEmail, txtDesigntion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPassword = itemView.findViewById(R.id.txtPassword);
            txtMobile = itemView.findViewById(R.id.txtMobile);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtDesigntion = itemView.findViewById(R.id.txtDesignation);
        }
    }
}
