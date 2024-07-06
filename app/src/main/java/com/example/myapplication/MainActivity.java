package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.fragment.BookFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.ProfileFragment;
import com.example.myapplication.fragment.RecommentFragment;
import com.example.myapplication.fragment.SaleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    RecommentFragment recommentFragment = new RecommentFragment();
    BookFragment bookFragment = new BookFragment();
    SaleFragment saleFragment = new SaleFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    private RecyclerView.Adapter adapter2;
    private RecyclerView recylcleViewRoom;
    public void findViewById() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById();
        others();
        setOnClickListener();
    }

    private void setOnClickListener() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if(item.getItemId() == R.id.nav_home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.nav_recom){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, recommentFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.nav_book){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, bookFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.nav_sale){
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, saleFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.nav_user){
                     getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, profileFragment).commit();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    private void others() {
        Intent intent = getIntent();
        int fragment = intent.getIntExtra("fragment", 0);
        if(fragment == 1){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        } else if (fragment == 2){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, recommentFragment).commit();
            bottomNavigationView.getMenu().getItem(1).setChecked(true);
        } else if (fragment == 3){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, bookFragment).commit();
            bottomNavigationView.getMenu().getItem(2).setChecked(true);
        } else if (fragment == 4){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, saleFragment).commit();
            bottomNavigationView.getMenu().getItem(3).setChecked(true);
        } else if (fragment == 5){
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, profileFragment).commit();
            bottomNavigationView.getMenu().getItem(3).setChecked(true);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
        }
        
    }


}