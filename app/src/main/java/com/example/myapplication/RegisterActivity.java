package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity {

    private TextView txLogin;
    private Button btnRegister;
    private EditText textUname, textPwd, textEmail, textRepwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_register);
        findViewById();
        setOnClickListener();
    }

    private void setOnClickListener() {
        txLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = textUname.getText().toString();
                String password = textPwd.getText().toString();
                String email = textEmail.getText().toString();
                String confirmPassword = textRepwd.getText().toString();

                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)
                        && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(confirmPassword)) {
                    if (password.equals(confirmPassword)) {
                        // Generate a random UID
                        //Random generator = new Random();
                        //int randomUid = generator.nextInt();

                        // Create a new User object
                        User newUser = new User(userName, password);

                        // Save the user to the database
                        FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                                FRoomDatabase.class, "FRoomDB1").allowMainThreadQueries().build();
                        UserDAO userDao = db.userDao();
                        userDao.insertAll(newUser);

                        // Show success message
                        Toast.makeText(RegisterActivity.this, "Account created successfully", Toast.LENGTH_LONG)
                                .show();

                        // Navigate to LoginActivity
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_LONG)
                                .show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
    private void findViewById() {
        txLogin = findViewById(R.id.txt_Login);
        btnRegister = findViewById(R.id.btn_register);
        textUname = findViewById(R.id.text_uname);
        textPwd = findViewById(R.id.text_pwd);
        textEmail = findViewById(R.id.text_email);
        textRepwd = findViewById(R.id.text_repwd);
    }
}
