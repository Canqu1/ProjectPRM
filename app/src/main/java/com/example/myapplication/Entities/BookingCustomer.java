package com.example.myapplication.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BookingCustomer {
    @Embedded
    public Booking booking;
    @Relation(
            parentColumn = "bid",
            entityColumn = "customerId"
    )
    public List<Customer> customers;
}
