package com.example.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.example.myapplication.YourAccount;

public class ProfileFragment extends Fragment {

    Button b1, btn_update, btnlog_out;
    TextView ed1, ed2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI elements
        b1 = view.findViewById(R.id.btn_upd);
        ed1 = view.findViewById(R.id.edt_name);
        ed2 = view.findViewById(R.id.edt_mail);
        btn_update = view.findViewById(R.id.btn_upd);
        btnlog_out = view.findViewById(R.id.btn_logout);

        // Retrieve user ID from intent
        int uid = requireActivity().getIntent().getIntExtra("uid", -1);

        // Initialize database
        FRoomDatabase db = Room.databaseBuilder(requireContext(), FRoomDatabase.class, "FRoomDB1")
                .allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();

        // Load user data from database
        User u = userDao.loadByIds(uid);
        if (u != null) {
            ed1.setText(u.username);
            ed2.setText(u.email);
        }

        // Set up button click listeners
        b1.setOnClickListener(v -> {
            if (!ed1.getText().toString().trim().isEmpty() && !ed2.getText().toString().trim().isEmpty()) {
                u.username = ed1.getText().toString();
                u.email = ed2.getText().toString();
                userDao.Upsert(u);
                ed1.setText(u.username);
                ed2.setText(u.email);
            } else {
                System.out.println("fail");
            }
        });

        btn_update.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), YourAccount.class);
            startActivity(i);
        });

        btnlog_out.setOnClickListener(v -> {
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
