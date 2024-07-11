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
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;
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
        int uid = requireActivity().getIntent().getIntExtra("uid", -1);

        // Initialize database
        FRoomDatabase db = androidx.room.Room.databaseBuilder(requireContext(), FRoomDatabase.class, "FRoomDB1")
                .allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();

        // Load user data from database
        User u = userDao.loadByIds(uid);
        RoomDAO roomDAO = db.roomDao();

        // Create an ArrayList of Room objects
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(new Room(" Fury Room", "room1", "In this adrenaline-pumping experience, participants are invited to unleash their stress and frustration in a controlled environment. Armed with protective gear and a selection of blunt instruments such as baseball bats, sledgehammers, and crowbars, visitors are encouraged to vent their anger by smashing up a designated room filled with breakable objects like bottles, furniture, and electronics.\n" +
                "\n" +
                "Whether to blow off steam after a rough day or simply to indulge in a unique form of stress relief, \"Fury Room\" provides a safe and cathartic outlet for pent-up emotions. This unconventional activity offers a liberating and empowering way to release tension and embrace the exhilarating chaos of controlled destruction. Remember, it's not just about breaking things – it's about breaking free from the constraints of daily life.\n" +
                "\n" +
                "Come experience the ultimate release at \"Fury Room\" – where demolition meets self-liberation!", 0));
        roomList.add(new Room(" Movie Room", "room2", "Settle into the cozy comforts of the \"Movie Room,\" where every film lover's dreams come to life. This immersive cinematic sanctuary offers a state-of-the-art audiovisual experience, complete with plush recliners, ambient lighting, and high-definition screens for an unparalleled viewing extravaganza.\n" +
                "\n" +
                "From the latest blockbusters to the timeless classics, \"Movie Room\" caters to diverse tastes, offering a carefully curated selection of films across genres and languages. Whether it's a solo escape, a date night, or a gathering of friends, the \"Movie Room\" provides the perfect backdrop for shared moments and unforgettable storytelling.", 0));
        roomList.add(new Room(" Room Gravesend", "room3", "Dive into a world of excitement with our thrilling Escape Rooms! Perfect for friends, families, or team-building, our immersive experiences challenge you to solve puzzles and escape from captivating scenarios.\n" +
                "\n" +
                "Our rooms are meticulously designed for maximum immersion and challenge, offering an edge-of-your-seat experience. Paired with our friendly and supportive staff, we ensure a fun, memorable adventure for everyone.\n" +
                "\n" +
                "Choose The Panic Room Gravesend for an unparalleled escape room journey, where puzzles and top-notch service create unforgettable moments!", 0));
        roomList.add(new Room("paint room", "room4", "Step into the vibrant world of the \"Paint Room,\" where creativity knows no bounds and every brushstroke tells a unique story. This imaginative space is designed to inspire and unleash the artist within, offering a haven for both seasoned painters and those discovering the joy of artistic expression.\n" +
                "\n" +
                "With its inviting atmosphere and ample natural light, the \"Paint Room\" becomes a canvas in itself, encouraging the exploration of color, texture, and form. From tranquil landscapes to abstract wonders, from portraiture to experimental mixed media, the possibilities are as endless as the imagination.", 0));
        roomList.add(new Room("Singing Room", "room5", "In the \"Singing Room,\" music fills the air and creativity knows no bounds. This space is a haven for those who wish to express themselves through song, whether for professional practice, joyful moments of release, or the simple love of music.\n" +
                "\n" +
                "Filled with acoustic panels, soundproofing, and perhaps some comfortable seating, the \"Singing Room\" is designed to capture and enhance the beauty of your voice. It creates an environment where you can truly tune into the melodies within and let your vocals soar.\n" +
                "\n" +
                "From the powerful resonance of a trained soprano to the soulful crooning of a passionate amateur, the \"Singing Room\" offers an unfiltered outlet for the expression of emotions, dreams, and experiences. It's a place where notes come alive, and every lyric reverberates with personal meaning.", 0));
        roomDAO.insertAll(roomList);
        adapter2 = new RoomAdapter(roomList,u);
        recylcleViewRoom.setAdapter(adapter2);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}