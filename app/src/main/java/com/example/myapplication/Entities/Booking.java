package com.example.myapplication.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Booking {
    @PrimaryKey(autoGenerate = true)
    public int bid;
    public String service;
    public String bookDate;
    public int time;
    public int customerId;
    public int roomId;

}
