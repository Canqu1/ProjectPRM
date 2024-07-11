package com.example.myapplication.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Booking {
    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

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