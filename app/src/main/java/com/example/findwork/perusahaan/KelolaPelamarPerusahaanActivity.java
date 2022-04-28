package com.example.findwork.perusahaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.findwork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class KelolaPelamarPerusahaanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_pelamar_perusahaan);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPerusahaan);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.kelolaPelamar);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePerusahaan:
                        startActivity(new Intent(getApplicationContext(), HomePerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.kelolaPelamar:
                        return true;
                    case R.id.akunPerusahaan:
                        startActivity(new Intent(getApplicationContext(), AkunPerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}