package com.example.myapplication.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BookingRoom {
    @Embedded
    public Room room;
    @Relation(
            parentColumn = "rid",
            entityColumn = "roomId"
    )
    public List<Booking> bookings;
}
