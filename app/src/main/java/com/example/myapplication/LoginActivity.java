package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;

public class LoginActivity extends AppCompatActivity{
    ImageButton b1;
    TextView tx1;
    EditText ed1 , ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_login);
        b1 = (ImageButton)findViewById(R.id.image_sign_in_button);
        ed1 = (EditText)findViewById(R.id.text_uname);
        ed2 = (EditText)findViewById(R.id.text_pwd);
        tx1 = (TextView)findViewById(R.id.text_please_sign_in);
        //tx1.setVisibility(View.GONE);

        FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                FRoomDatabase.class, "FRoomDB1").allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User u = userDao.findByName(ed1.getText().toString());
                if(u == null){
                    tx1.setBackgroundColor(Color.RED);
                    tx1.setText("no user");
                }
                if(!u.password.equals(ed2.getText().toString()) ){
                    tx1.setBackgroundColor(Color.RED);
                    tx1.setText("Wrong password");
                }else{
                    tx1.setBackgroundColor(Color.RED);
                    tx1.setText("Logged in");
                    Intent i = new Intent(LoginActivity.this, ProfileActivity.class);
                    i.putExtra("uid",u.uid);
                    startActivity(i);
                }
            }
        });


    }
}
