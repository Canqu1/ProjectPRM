package com.example.myapplication.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Upsert;

import com.example.myapplication.Entities.Customer;
import com.example.myapplication.Entities.User;

import java.util.List;

@Dao
public interface CustomerDAO {
    @Query("SELECT * FROM Customer")
    List<Customer> getAll();
    @Query("SELECT * FROM Customer WHERE cid IN (:customerIds)")
    List<Customer> loadAllByIds(int[] customerIds);

    @Upsert
    void insertAll(Customer... customers);
    @Upsert
    void upsert(Customer customer);
    @Delete
    void delete(Customer customer);


}
