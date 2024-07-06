package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Room;

import java.util.List;

@Dao
public interface RoomDAO {

    @Insert
    void insert(Room room);

    @Insert
    void insertAll(List<Room> rooms);

    @Query("SELECT * FROM room WHERE rid = :roomId")
    Room getRoomById(int roomId);
}
