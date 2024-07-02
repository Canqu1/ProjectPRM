package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.Role;

import java.util.List;

@Dao
public interface RoleDAO {
    @Query("SELECT * FROM Role")
    List<Role> getAll();
    @Query("SELECT * FROM Role WHERE rid IN (:roleIds)")
    List<Role> loadAllByIds(int[] roleIds);

    @Upsert
    void insertAll(Role... roles);


    @Delete
    void delete(Role role);
}
