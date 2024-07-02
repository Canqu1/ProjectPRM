package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Room;

import java.util.List;

@Dao
public interface RoomDAO {

    @Query("SELECT * FROM Room")
    List<Room> getAll();
    @Query("SELECT * FROM Room WHERE rid IN (:roomIds)")

    List<Room> loadAllByIds(int[] roomIds);
    @Upsert
    void insertAll(Room... rooms);

    @Delete
    void delete(Room room);
}
