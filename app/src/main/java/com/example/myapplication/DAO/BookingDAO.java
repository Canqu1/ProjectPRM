package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.Booking;

import java.util.List;

@Dao
public interface    BookingDAO {
    @Query("SELECT * FROM Booking")
    List<Booking> getAll();
    @Query("SELECT * FROM Booking WHERE bid IN (:bookingIds)")
    List<Booking> loadAllByIds(int[] bookingIds);

    @Upsert
    void insertAll(Booking... bookings);
    @Upsert
    void insert(Booking booking);
    @Delete
    void delete(Booking booking);
    @Query("SELECT * FROM Booking WHERE customerId IN (:uid)")
    List<Booking> loadAllByUid(int uid);
    @Query("SELECT * FROM Booking WHERE roomId = :roomId")
    List<Booking> loadAllByRid(int roomId);

}