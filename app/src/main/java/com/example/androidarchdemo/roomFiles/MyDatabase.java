package com.example.androidarchdemo.roomFiles;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "UserDatabase";
    public static MyDatabase databaseInstance;

    public abstract UserDao getUserDao();

    public static MyDatabase getUserDatabaseInstance(Context context) {
        if (databaseInstance == null) {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME).build();
        }
        return databaseInstance;
    }

}
