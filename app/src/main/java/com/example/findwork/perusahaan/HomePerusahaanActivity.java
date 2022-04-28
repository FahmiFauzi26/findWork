package com.example.findwork.perusahaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.findwork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePerusahaanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_perusahaan);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPerusahaan);
        Button btnBuatLowongan = findViewById(R.id.btnBuatLowongan);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.homePerusahaan);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePerusahaan:
                        return true;
                    case R.id.kelolaPelamar:
                        startActivity(new Intent(getApplicationContext(), KelolaPelamarPerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.akunPerusahaan:
                        startActivity(new Intent(getApplicationContext(), AkunPerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        btnBuatLowongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePerusahaanActivity.this, BuatLowonganPerusahaanActivity.class));
            }
        });
    }
}