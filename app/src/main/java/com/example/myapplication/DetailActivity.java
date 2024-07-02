package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
//import com.example.pm.model.Room;
import com.example.myapplication.model.Room;

public class DetailActivity extends AppCompatActivity {
private TextView bookbtn;
private TextView txtTitle, txtDescription;
private ImageView picRoom;
private Room object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_detail);
        innitView();
        getBundle();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @SuppressLint("DiscouragedApi")
    private void getBundle() {
        object = (Room) getIntent().getSerializableExtra("object");
        int drawableID;
        drawableID = this.getResources().getIdentifier(object.getImg(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableID)
                .into(picRoom);
        txtTitle.setText(object.getTitle());
        txtDescription.setText(object.getDescription());

    }

    private void innitView() {
        bookbtn = findViewById(R.id.text_book_now);
        txtTitle=findViewById(R.id.txtTitle);
        txtDescription=findViewById(R.id.description);
        picRoom = findViewById(R.id.img_room);
    }
}