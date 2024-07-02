package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Category;
import com.example.myapplication.Entities.Room;

import java.util.List;

@Dao
public interface CategoryDAO {
    @Query("SELECT * FROM Category")
    List<Category> getAll();
    @Query("SELECT * FROM Category WHERE catId IN (:categoryIds)")

    List<Category> loadAllByIds(int[] categoryIds);
    @Upsert
    void insertAll(Category... categories);

    @Delete
    void delete(Category category);
}
