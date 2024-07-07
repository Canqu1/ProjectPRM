package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
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

    @Query("SELECT uid FROM User WHERE email = :emailClient")
    User getUserIdByEmailAndPassword(String emailClient);

    @Query("SELECT * FROM User WHERE uid IN (:userId) LIMIT 1")
    User loadByIds(int userId);
    @Query("SELECT * FROM User WHERE email LIKE (:name) LIMIT 1")
    User findByName (String name);
    @Insert
    void insertAll(User users);
    @Upsert
    void Upsert(User user);
    @Query("SELECT * FROM user WHERE uid = :role LIMIT 1")
    User getUserByRole(String role);

    @Update
    void updateUser(User user);
    @Delete
    void delete(User user);

}
