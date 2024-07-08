package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.myapplication.Entities.Room;

public class DetailActivity extends AppCompatActivity {
    private Button bookbtn;
    private TextView txtTitle, txtDescription;
    private ImageView picRoom;
    private Room object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.container_book);
        innitView();
        getBundle();
        setOnClickListener();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setOnClickListener() {
        bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this, FillDetail.class);
                i.putExtra("object", object);
                int uid = getIntent().getIntExtra("uid", -1);
                i.putExtra("uid", uid);
                startActivity(i);
            }
        });
    }

    @SuppressLint("DiscouragedApi")
    private void getBundle() {
        object = (Room) getIntent().getSerializableExtra("object");
        if (object != null) {
            String imagePath = object.getImg();
            if (imagePath != null && !imagePath.isEmpty()) {
                int drawableID = this.getResources().getIdentifier(imagePath, "drawable", this.getPackageName());
                Log.d("DetailActivity", "Image path: " + imagePath + ", Drawable ID: " + drawableID);

                if (drawableID != 0) {
                    Glide.with(this)
                            .load(drawableID)
                            .into(picRoom);
                } else {
                    Log.e("DetailActivity", "Drawable resource not found for image path: " + imagePath);
                    Glide.with(this)
                            .load(R.drawable.room1)
                            .into(picRoom);
                }
            } else {
                Log.e("DetailActivity", "Image path is null or empty");
                Glide.with(this)
                        .load(R.drawable.room1)
                        .into(picRoom);
            }
            txtTitle.setText(object.getTitle());
            txtDescription.setText(object.getDescription());
        } else {
            Log.e("DetailActivity", "Room object is null");
            txtTitle.setText("Default Title");
            txtDescription.setText("Default Description");
            Glide.with(this)
                    .load(R.drawable.room2)
                    .into(picRoom);
        }
    }

    private void innitView() {
        bookbtn = findViewById(R.id.book_room);
        txtTitle = findViewById(R.id.txtTitle);
        txtDescription = findViewById(R.id.description);
        picRoom = findViewById(R.id.img_detail);
    }
}
