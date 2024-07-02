package com.example.myapplication.Entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Customer {
    @PrimaryKey(autoGenerate = true)
    public int cid;

    public String name;
    public String address;
    public String email;
    public String dob;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

