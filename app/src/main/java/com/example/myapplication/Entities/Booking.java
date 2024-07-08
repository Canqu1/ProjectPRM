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

    public Booking() {
    }

    public Booking(String service, String bookDate, int time, int customerId, int roomId) {
        this.service = service;
        this.bookDate = bookDate;
        this.time = time;
        this.customerId = customerId;
        this.roomId = roomId;
    }
}
