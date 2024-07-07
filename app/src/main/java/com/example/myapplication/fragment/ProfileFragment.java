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
import android.widget.TextView;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;
import com.example.myapplication.LoginActivity;
import com.example.myapplication.R;
import com.example.myapplication.YourAccount;


public class ProfileFragment extends Fragment {

    Button btn_update , btnlog_out;
    TextView txtName, txtEmail;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //findViewById
        btn_update = view.findViewById(R.id.btn_upd);
        btnlog_out = view.findViewById(R.id.btn_logout);
        txtName = view.findViewById(R.id.edt_name);
        txtEmail = view.findViewById(R.id.edt_mail);

        int uid = getActivity().getIntent().getExtras().getInt("uid");
        FRoomDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(),
                FRoomDatabase.class, "FRoomDB1").allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();
        User u = userDao.loadByIds(uid);
        txtName.setText(u.username);
        txtEmail.setText(u.email);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), YourAccount.class);
                startActivity(i);
            }
        });
        btnlog_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}