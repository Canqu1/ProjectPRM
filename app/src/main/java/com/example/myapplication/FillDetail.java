package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DAO.BookingDAO;
import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.Booking;
import com.example.myapplication.Entities.Room;
import com.example.myapplication.Entities.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FillDetail  extends AppCompatActivity {
    TextView _namehoteldetail, _checkinhoteldetail, _checkouthoteldetail, _roomtypehoteldetail, _pricehoteldetail;
    String hotel_details_id, number_of_day_other, CheckIn, Checkout, user_id;
    EditText _editTextFullName, _editTextPhone, _editTextEmail;
    String name_client, phone_client, email_client;
    Button _300, btn_continue;
    private Room object;
    FRoomDatabase db = androidx.room.Room.databaseBuilder(this,
                    FRoomDatabase.class, "FRoomDB1")
            .addMigrations(FRoomDatabase.MIGRATION_1_2)
            .allowMainThreadQueries()
            .build();
    public void findViewById() {
        _namehoteldetail = findViewById(R.id._namehoteldetail);
        _checkinhoteldetail = findViewById(R.id.checkin);
        _checkouthoteldetail = findViewById(R.id.checkout);
        _pricehoteldetail = findViewById(R.id._pricehoteldetail);
        _editTextFullName = findViewById(R.id._editTextFullName);
        _editTextPhone = findViewById(R.id._editTextPhone);
        _editTextEmail = findViewById(R.id._editTextEmail);
        _300 = findViewById(R.id._300);
        btn_continue = findViewById(R.id.buttonContinue);
    }
    private void setOnClickListener() {
        _300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(FillDetail.this, MainActivity.class);
                int uid = getIntent().getExtras().getInt("uid", -1);
                object = (Room) getIntent().getSerializableExtra("object");
                UserDAO userDao = db.userDao();
                User user = userDao.loadByIds(uid);
                BookingDAO bookingDAO = db.bookingDao();
                Booking b = new Booking(((Room)object).getTitle(),_checkinhoteldetail.toString(),3,uid,((Room)object).rid);
                bookingDAO.insert(b);
                i.putExtra("fragment", 0);
                startActivity(i);
            }
        });
    }

    private void others() {
        FRoomDatabase db = androidx.room.Room.databaseBuilder(this,
                        FRoomDatabase.class, "FRoomDB1")
                .addMigrations(FRoomDatabase.MIGRATION_1_2)
                .allowMainThreadQueries()
                .build();



        int uid = getIntent().getExtras().getInt("uid", -1);
        object = (Room) getIntent().getSerializableExtra("object");
        _namehoteldetail.setText(object.getTitle());
        Calendar calendar = Calendar.getInstance();
        String Format = "dd/MM/yyyy";
        SimpleDateFormat date_from = new SimpleDateFormat(Format, Locale.TAIWAN);
        _checkinhoteldetail.setText(date_from.format(calendar.getTime()));
        _checkouthoteldetail.setText(date_from.format(calendar.getTime()));

        UserDAO userDao = db.userDao();
        User user = userDao.loadByIds(uid);
        BookingDAO bookingDAO = db.bookingDao();

        if (user != null) {
            _editTextFullName.setText(user.username);
            _editTextEmail.setText(user.email);
        } else {
            _editTextFullName.setText("Unknown User");
            _editTextEmail.setText("Unknown Email");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_confirm);
        findViewById();
        others();
        setOnClickListener();
    }


}
