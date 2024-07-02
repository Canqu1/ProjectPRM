package com.example.myapplication.Entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String username;
    public String password;
    public String fullname;
    public String address;
    public String email;
    public String dob;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String fullname, String email) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
    }
}
