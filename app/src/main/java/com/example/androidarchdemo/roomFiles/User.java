package com.example.androidarchdemo.roomFiles;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    int uId;

    @ColumnInfo(name = "Name")
    String uName;

    @ColumnInfo(name = "Password")
    String uPassword;

    @NonNull
    @ColumnInfo(name = "Mobile")
    String uMobile;

    @ColumnInfo(name = "Email")
    String uEmail;

    @ColumnInfo(name = "Designation")
    String uDesignation;

    public String getuName() {
        return uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuMobile() {
        return uMobile;
    }

    public String getuEmail() {
        return uEmail;
    }

    public String getuDesignation() {
        return uDesignation;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public void setuDesignation(String uDesignation) {
        this.uDesignation = uDesignation;
    }
}
