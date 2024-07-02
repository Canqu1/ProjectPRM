package com.example.myapplication.Entities;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserCustomer {
    @Embedded
    public User user;
    @Relation(
            parentColumn = "uid",
            entityColumn = "customerId"
    )
    public Customer customer;

}
