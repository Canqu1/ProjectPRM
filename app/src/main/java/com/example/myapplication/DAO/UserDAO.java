package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    List<User> getAll();
    @Query("DELETE FROM User WHERE uid IN (:userId)")
    void deleteById(int userId);
    @Query("SELECT * FROM User WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM User WHERE uid IN (:userId) LIMIT 1")
    User loadByIds(int userId);
    @Query("SELECT * FROM User WHERE username LIKE (:name) LIMIT 1")
    User findByName (String name);
    @Insert
    void insertAll(User... users);
    @Upsert
    void Upsert(User user);
    @Delete
    void delete(User user);

}
