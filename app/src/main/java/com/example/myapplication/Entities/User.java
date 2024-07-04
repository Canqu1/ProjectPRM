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
    public String address;

    public String email;
    public String dob;
    public String role;

    public User() {
    }

    public User(int uid, String username, String password,  String address, String email, String dob, String role) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.role = role;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
