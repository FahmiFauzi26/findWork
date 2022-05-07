package com.example.findwork.pencarikerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.findwork.MainActivity;
import com.example.findwork.R;
import com.example.findwork.perusahaan.AkunPerusahaanActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AkunPencariKerjaActivity extends AppCompatActivity {
    Button buttonProfil,buttonSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_pencari_kerja);
        buttonProfil = findViewById(R.id.buttonProfil);
        buttonSignOut = findViewById(R.id.buttonSignOut);

        buttonProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AkunPencariKerjaActivity.this, ProfilPencariKerja.class));
            }
        });
        buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPencariKerja);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.akunPencariKerja);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePencariKerja:
                        startActivity(new Intent(getApplicationContext(), HomePencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.perjalananSaya:
                        startActivity(new Intent(getApplicationContext(), PerjalananPencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bookmark:
                        startActivity(new Intent(getApplicationContext(), BookmarkPencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.akunPencariKerja:
                        return true;
                }
                return false;
            }
        });
    }
    private void logoutUser(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(AkunPencariKerjaActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}