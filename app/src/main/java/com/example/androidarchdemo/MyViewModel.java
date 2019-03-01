package com.example.androidarchdemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.AsyncTask;

import com.example.androidarchdemo.roomFiles.MyDatabase;
import com.example.androidarchdemo.roomFiles.User;
import com.example.androidarchdemo.roomFiles.UserDao;

import java.util.List;

public class MyViewModel extends ViewModel {
    private Context context;
    private UserDao userDao;
    private MyDatabase myDatabase;

   /* public void setContext(Context context) {
        this.context = context;
    }*/

    MutableLiveData<List<User>> userList;

    public LiveData<List<User>> getUserList() {
        if (userList == null) {
            userList = new MutableLiveData<>();
            myDatabase = MyDatabase.databaseInstance;
            userDao = myDatabase.getUserDao();
            new ShowTask().execute();
        }
        return userList;
    }

    class ShowTask extends AsyncTask<Void, Void, List<User>> {
        @Override
        protected List<User> doInBackground(Void... voids) {
            return userDao.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            userList.setValue(users);
        }
    }

}
