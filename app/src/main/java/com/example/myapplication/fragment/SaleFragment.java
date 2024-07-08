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
import com.example.myapplication.Entities.Room;
import com.example.myapplication.R;
import com.example.myapplication.adapter.RoomAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView.Adapter adapter2;
    private RecyclerView recylcleViewRoom;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
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
        String des1 = "Statue painting dont need an introduction , and at stress relief room we provide you with a theraputic environment to paint statue with friend";
        String des2 = "Sharing a movie with your love one or your friend , come to our cozy cinema";
        String des3 = "Do you have a problem with your life , your job , your love ? We will try our best to help you ";
        String des4 = "Healthy life lead to happy life , your body health can drasticly improve your mental health ";
        String des5 = "Our monthly book talk , this week we have a special guest with us to talk about self improvement";
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(new Room("Statue painting ", "room1", des1, 0));
        roomList.add(new Room("Movie night", "room2", des2, 0));
        roomList.add(new Room("Therapy advice ", "room3", des3, 0));
        roomList.add(new Room("Diet Activity", "room4", des4, 0));
        roomList.add(new Room("Book talk", "room5", des5, 0));

    }
    public SaleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SaleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SaleFragment newInstance(String param1, String param2) {
        SaleFragment fragment = new SaleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale, container, false);
    }
}