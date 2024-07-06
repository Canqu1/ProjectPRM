package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.RoomDAO;
import com.example.myapplication.R;
import com.example.myapplication.adapter.RoomAdapter;
import com.example.myapplication.Entities.Room;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private RecyclerView.Adapter adapter2;
    private RecyclerView recylcleViewRoom;
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recylcleViewRoom = view.findViewById(R.id.rcl_view);
        recylcleViewRoom.setLayoutManager(linearLayoutManager);
        FRoomDatabase db = androidx.room.Room.databaseBuilder(this.getContext(),
                        FRoomDatabase.class, "FRoomDB1")
                .addMigrations(FRoomDatabase.MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();
        RoomDAO roomDAO = db.roomDao();

        // Create an ArrayList of Room objects
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(new Room("r1", "room1", "dsads", 0));
        roomList.add(new Room("r2", "room2", "dsads", 0));
        roomList.add(new Room("r3", "room3", "dsads", 0));
        roomList.add(new Room("r4", "room4", "dsads", 0));
        roomList.add(new Room("r5", "room5", "dsads", 0));
        roomDAO.insertAll(roomList);
        adapter2 = new RoomAdapter(roomList);
        recylcleViewRoom.setAdapter(adapter2);
        adapter2 = new RoomAdapter(roomList);
        recylcleViewRoom.setAdapter(adapter2);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}