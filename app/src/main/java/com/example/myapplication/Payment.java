package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.DAO.BookingDAO;
import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Room;
import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Payment extends AppCompatActivity {
    private Room object;
    Button _300;
    TextView _emailpaymentdetail,_namehoteldetail,_textViewHotelname,_checkinhoteldetail,_checkouthoteldetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        findViewById();
        others();
        setOnClickListener();
    }

    private void setOnClickListener() {
        object = (Room) getIntent().getSerializableExtra("object");
        // Retrieve user ID from intent
        int uid = getIntent().getIntExtra("uid", -1);

        // Initialize database
        FRoomDatabase db = androidx.room.Room.databaseBuilder(this, FRoomDatabase.class, "FRoomDB1")
                .allowMainThreadQueries().build();
        UserDAO userDao = db.userDao();

        // Load user data from database
        User u = userDao.loadByIds(uid);
        _300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Booking Success", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent i = new Intent(Payment.this, MainActivity.class);
                BookingDAO bookingDAO = db.bookingDao();
                Booking b = new Booking(object.getTitle(),object.getImg(),0,u.uid,1);
                bookingDAO.insert(b);
                i.putExtra("fragment", 0);
                i.putExtra("uid",u.uid );
                startActivity(i);
            }
        });
    }

    private void others() {
        object = (Room) getIntent().getSerializableExtra("object");
        FRoomDatabase db = androidx.room.Room.databaseBuilder(this,
                        FRoomDatabase.class, "FRoomDB1")
                .addMigrations(FRoomDatabase.MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();

        int uid = getIntent().getExtras().getInt("uid", -1);

        if (object != null) {
            _namehoteldetail.setText(object.getTitle());
        } else {
            _namehoteldetail.setText("Unknown Room");
        }

        Calendar calendar = Calendar.getInstance();
        String format = "dd/MM/yyyy";
        SimpleDateFormat dateFrom = new SimpleDateFormat(format, Locale.TAIWAN);
        _checkinhoteldetail.setText(dateFrom.format(calendar.getTime()));
        _checkouthoteldetail.setText(dateFrom.format(calendar.getTime()));

        UserDAO userDao = db.userDao();
        User user = userDao.loadByIds(uid);

        if (user != null) {
            _namehoteldetail.setText(user.username);
            _emailpaymentdetail.setText(user.email);
        } else {
            _namehoteldetail.setText("Unknown User");
            _emailpaymentdetail.setText("Unknown Email");
        }
    }

    private void findViewById() {
        _checkouthoteldetail= findViewById(R.id._textViewCheckOut);
        _checkinhoteldetail = findViewById(R.id._textViewCheckIn);
        _300 = findViewById(R.id.buttonContinue);
        _emailpaymentdetail = findViewById(R.id._emailpaymentdetail);
        _namehoteldetail = findViewById(R.id._namehoteldetail);
        _textViewHotelname= findViewById(R.id._textViewHotelname);
    }
}