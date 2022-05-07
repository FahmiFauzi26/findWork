package com.example.findwork.perusahaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.findwork.MainActivity;
import com.example.findwork.R;
import com.example.findwork.signin;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AkunPerusahaanActivity extends AppCompatActivity {
    Button btnProfilPerusahaan,buttonSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_perusahaan);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPerusahaan);
        btnProfilPerusahaan = findViewById(R.id.buttonProfil);
        buttonSignOut = findViewById(R.id.buttonSignOut);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.akunPerusahaan);

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
                        startActivity(new Intent(getApplicationContext(), KelolaPelamarPerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.akunPerusahaan:
                        return true;
                }
                return false;
            }
        });

        btnProfilPerusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AkunPerusahaanActivity.this, ProfilPerusahaanActivity.class));
            }
        });
        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });
    }
    private void logoutUser(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(AkunPerusahaanActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}