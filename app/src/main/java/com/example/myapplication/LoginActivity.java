package com.example.myapplication;

import static com.example.myapplication.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;

public class LoginActivity extends AppCompatActivity {
    Button b1;
    TextView txt_register;
    EditText ed1, ed2;

    public void findViewById() {
        b1 = findViewById(R.id.image_sign_in_button);
        ed1 = findViewById(R.id.text_email);
        ed2 = findViewById(R.id.txtpass);
        txt_register = findViewById(R.id.text_sign_up);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_login);
        findViewById();
        setOnClickListener();
        others();
    }

    private void others() {
        // Additional setup if needed
    }

    public void setOnClickListener() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailClient = ed1.getText().toString().trim();
                String passwordClient = ed2.getText().toString().trim();

                if (emailClient.isEmpty() || passwordClient.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter both email and password!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                                    FRoomDatabase.class, "FRoomDB1")
                            .addMigrations(FRoomDatabase.MIGRATION_1_2)
                            .allowMainThreadQueries()
                            .build();
                    UserDAO userDAO = db.userDao();

                    User userId = userDAO.findByName(emailClient);
                    if (userId != null && userId.password.equals(passwordClient)) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Log in successfully!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("uid", userId.uid);
                        userId.setRole("login");
                        startActivity(i);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "Incorrect account or password!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
        });

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
