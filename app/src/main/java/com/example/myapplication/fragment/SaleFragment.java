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

import com.example.myapplication.Entities.Event;
import com.example.myapplication.R;
import com.example.myapplication.adapter.EventAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SaleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SaleFragment extends Fragment {

    private RecyclerView.Adapter adapter2;
    private RecyclerView recylcleViewEvent;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recylcleViewRoom = view.findViewById(R.id.rvc_list_blog);
        recylcleViewRoom.setLayoutManager(linearLayoutManager);

        // Initialize recylcleViewEvent
        recylcleViewEvent = view.findViewById(R.id.rvc_list_blog);

        // Create an ArrayList of Room objects
        String des1 = "Statue painting dont need an introduction , and at stress relief room we provide you with a theraputic environment to paint statue with friend";
        String des2 = "Sharing a movie with your love one or your friend , come to our cozy cinema";
        String des3 = "Do you have a problem with your life , your job , your love ? We will try our best to help you ";
        String des4 = "Healthy life lead to happy life , your body health can drasticly improve your mental health ";
        String des5 = "Our monthly book talk , this week we have a special guest with us to talk about self improvement";

        ArrayList<Event> eventList = new ArrayList<>();
        eventList.add(new Event("Statue painting ", "event4", des1));
        eventList.add(new Event("Movie night", "event5", des2));
        eventList.add(new Event("Therapy advice ", "event3", des3));
        eventList.add(new Event("Diet Activity", "event2", des4));
        eventList.add(new Event("Book talk", "event1", des5));

        adapter2 = new EventAdapter(eventList);
        recylcleViewEvent.setAdapter(adapter2);
    }

    public SaleFragment() {
        // Required empty public constructor
    }

    public static SaleFragment newInstance(String param1, String param2) {
        SaleFragment fragment = new SaleFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale, container, false);
    }
}
