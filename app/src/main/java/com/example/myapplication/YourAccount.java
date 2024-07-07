package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.myapplication.DAO.FRoomDatabase;
import com.example.myapplication.DAO.UserDAO;
import com.example.myapplication.Entities.User;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.fragment.ProfileFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class YourAccount extends AppCompatActivity {
    ImageView icon_arrowback_accountFragment;
    EditText edtDOB, edtName, edtEmail, edtPhone;
    TextView txtAccount;
    RadioButton btnMale, btnFmale;
    Button btnSave, btnCancel;
    Calendar calendar = Calendar.getInstance();

    public void findViewById() {
        icon_arrowback_accountFragment = findViewById(R.id._124);
        edtDOB = findViewById(R.id.edtDOB);
        txtAccount = findViewById(R.id.txtAccount);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        btnMale = findViewById(R.id.btnMale);
        btnFmale = findViewById(R.id.btnFmale);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }

    public void setOnClickListener() {
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String Format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.TAIWAN);

                edtDOB.setText(sdf.format(calendar.getTime()));
            }
        };

        edtDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(YourAccount.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YourAccount.this, MainActivity.class);
                i.putExtra("fragment", 4);
                overridePendingTransition(0, 0);
                startActivity(i);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize database
                FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                                FRoomDatabase.class, "FRoomDB1")
                        .allowMainThreadQueries()
                        .build();
                UserDAO userDao = db.userDao();
                int uid = getIntent().getIntExtra("uid", -1);
                String phonePattern = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
                String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

//                if (!edtPhone.getText().toString().matches(phonePattern)) {
//                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid phone number!", Toast.LENGTH_LONG);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    toast.show();
                if (!edtEmail.getText().toString().matches(emailPattern)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid email!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    User user = userDao.loadByIds(uid);
                    if (user != null) {
                        user.username = edtName.getText().toString();
                        user.dob = edtDOB.getText().toString();
                        user.email = edtEmail.getText().toString();
                        userDao.updateUser(user);
                        Intent i = new Intent(YourAccount.this, MainActivity.class);
                        i.putExtra("uid", user.uid);
                        i.putExtra("fragment", 5);
                        overridePendingTransition(0, 0);
                        startActivity(i);

                        Toast toast = Toast.makeText(getApplicationContext(), "Account update successful!", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
        });

        icon_arrowback_accountFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(YourAccount.this, MainActivity.class);
                i.putExtra("fragment", 4);
                startActivity(i);
            }
        });
    }

    public void others() {
        FRoomDatabase db = Room.databaseBuilder(getApplicationContext(),
                        FRoomDatabase.class, "FRoomDB1")
                .allowMainThreadQueries()
                .build();
        int uid = getIntent().getIntExtra("uid", -1);
        UserDAO userDao = db.userDao();
        User user = userDao.loadByIds(uid);
        if (user != null) {
            edtName.setText(user.username);
            edtDOB.setText(user.dob);
            edtEmail.setText(user.email);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_account);

        findViewById();
        others();
        setOnClickListener();
    }
}
