package com.example.myapplication.DAO;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Category;
import com.example.myapplication.Entities.Customer;
import com.example.myapplication.Entities.Role;
import com.example.myapplication.Entities.Room;
import com.example.myapplication.Entities.User;

@Database(entities = {User.class, Role.class,Customer.class,Booking.class, Category.class, Room.class}, version = 1)
public abstract class FRoomDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
    public abstract RoleDAO roleDao();
    public abstract CustomerDAO customerDao();
    public abstract BookingDAO bookingDao();
}
