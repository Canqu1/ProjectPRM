package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.Booking;

import java.util.List;

@Dao
public interface BookingDAO {
    @Query("SELECT * FROM Booking")
    List<Booking> getAll();
    @Query("SELECT * FROM Booking WHERE bid IN (:bookingIds)")
    List<Booking> loadAllByIds(int[] bookingIds);

    @Upsert
    void insertAll(Booking... bookings);

    @Delete
    void delete(Booking booking);


}
