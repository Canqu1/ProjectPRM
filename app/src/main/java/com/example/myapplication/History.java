package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DAO.BookingDAO;
import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.Entities.Booking;
import com.example.myapplication.adapter.RoomHistoryAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class History extends AppCompatActivity {
    TabLayout tabLayout;
    RecyclerView recyclerView;
    RoomHistoryAdapter roomHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        findViewById();
        others();
    }

    private void others() {
        int uid = getIntent().getIntExtra("uid", -1);

        // Initialize database
        FRoomDatabase db = androidx.room.Room.databaseBuilder(this, FRoomDatabase.class, "FRoomDB1")
                .allowMainThreadQueries().build();

        // Load user data from database
        BookingDAO bookingDAO = db.bookingDao();
        List<Booking> bList = bookingDAO.loadAllByUid(uid);
        roomHistoryAdapter = new RoomHistoryAdapter(bList);
        recyclerView.setAdapter(roomHistoryAdapter);
    }

    private void findViewById() {
        tabLayout = findViewById(R.id.tablayout_roomHistory);
        recyclerView = findViewById(R.id.viewPager_roomHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
