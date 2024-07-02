package com.example.myapplication.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Role {
    @PrimaryKey(autoGenerate = true)
    public int rid;
    public String name;
}
