package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;

public class ProfileActivity extends AppCompatActivity {
    Button b1;
    EditText ed1 , ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_profile);
        b1 = (Button)findViewById(R.id.btn_upd);
        ed1 = (EditText)findViewById(R.id.edt_name);
        ed2 = (EditText)findViewById(R.id.edt_mail);
        int uid = getIntent().getExtras().getInt("uid");
        FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                FRoomDatabase.class, "FRoomDB1").allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();
        User u = userDao.loadByIds(uid);
        ed1.setText(u.username);
        ed2.setText(u.email);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(ed1.getText().toString()!="".trim() ||ed1.getText().toString()!="".trim()){
                    u.username = ed1.getText().toString();
                    u.email = ed2.getText().toString();
                    userDao.Upsert(u);
                    ed1.setText(u.username);
                    ed2.setText(u.email);
                }else{
                    System.out.println("fail");
                }
            }
        });

    }
}
