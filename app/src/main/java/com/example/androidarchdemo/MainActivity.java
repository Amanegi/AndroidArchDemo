package com.example.androidarchdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidarchdemo.roomFiles.MyDatabase;
import com.example.androidarchdemo.roomFiles.User;
import com.example.androidarchdemo.roomFiles.UserDao;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnSave, btnShow;
    private TextInputEditText edtName, edtPassword, edtMobile, edtEmail, edtDesignation;
    private User user;
    private UserDao userDao;
    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = findViewById(R.id.btnSave);
        btnShow = findViewById(R.id.btnShow);
        edtName = findViewById(R.id.edtName);
        edtDesignation = findViewById(R.id.edtDesignation);
        edtEmail = findViewById(R.id.edtEmail);
        edtMobile = findViewById(R.id.edtMobile);
        edtPassword = findViewById(R.id.edtPassword);

        myDatabase = MyDatabase.getUserDatabaseInstance(this);
        userDao = myDatabase.getUserDao();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertTask().execute(edtName.getText().toString(),
                        edtPassword.getText().toString(),
                        edtMobile.getText().toString(),
                        edtEmail.getText().toString(),
                        edtDesignation.getText().toString());
                edtName.getText().clear();
                edtPassword.getText().clear();
                edtMobile.getText().clear();
                edtEmail.getText().clear();
                edtDesignation.getText().clear();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DisplayActivity.class));
            }
        });
    }

    class InsertTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            user = new User();
            user.setuName(strings[0]);
            user.setuPassword(strings[1]);
            user.setuMobile(strings[2]);
            user.setuEmail(strings[3]);
            user.setuDesignation(strings[4]);

            final long id = userDao.insertData(user);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (id == -1) {
                        Toast.makeText(MainActivity.this, "Data not saved!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return null;
        }
    }
}
