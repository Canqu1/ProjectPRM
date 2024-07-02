package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplication.DAO.CustomerDAO;
import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.Customer;
import com.example.myapplication.Entities.User;

public class RegisterActivity extends AppCompatActivity {
    Button b1;
    TextView tx1;

    EditText ed1 , ed2 , ed3 , ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_register);
        b1 = (Button)findViewById(R.id.btn_register);
        ed1 = (EditText)findViewById(R.id.text_uname);
        ed2 = (EditText)findViewById(R.id.text_pwd);
        ed3 = (EditText)findViewById(R.id.text_email);
        ed4= (EditText)findViewById(R.id.text_fname);
        tx1 = (TextView)findViewById(R.id.text_success);
        tx1.setVisibility(View.GONE);

        FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                FRoomDatabase.class, "FRoomDB1").allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();
        CustomerDAO customerDAO = db.customerDao();


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User u = userDao.findByName(ed1.getText().toString());
                if(u != null){
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    tx1.setText("existing user");
                }else{
                    userDao.Upsert(new User(ed1.getText().toString(),ed2.getText().toString(),ed4.getText().toString(),ed3.getText().toString()));
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    tx1.setText("register success");
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                }
            }
        });

    }
}
