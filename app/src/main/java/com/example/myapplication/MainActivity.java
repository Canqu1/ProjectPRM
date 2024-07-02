package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.RoomAdapter;
import com.example.myapplication.model.Room;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter2;
    private RecyclerView recylcleViewRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyleViewRoom();
    }
    private void recyleViewRoom(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recylcleViewRoom = findViewById(R.id.rcl_view);
        recylcleViewRoom.setLayoutManager(linearLayoutManager);
        ArrayList<Room> room = new ArrayList<>();
        room.add(new Room("r1","room1","dsads",0));
        room.add(new Room("r2","room2","dsads",0));
        room.add(new Room("r3","room3","dsads",0));
        room.add(new Room("r4","room4","dsads",0));
        room.add(new Room("r5","room5","dsads",0));
        adapter2 = new RoomAdapter(room);
        recylcleViewRoom.setAdapter(adapter2);

    }
}