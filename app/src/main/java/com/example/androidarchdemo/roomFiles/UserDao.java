package com.example.androidarchdemo.roomFiles;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    long insertData(User user);

    @Query("select * from User")
    List<User> getUsers();


}
