package com.example.findwork.pencarikerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.findwork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomePencariKerjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pencari_kerja);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPencariKerja);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.homePencariKerja);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePencariKerja:
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
                        startActivity(new Intent(getApplicationContext(), AkunPencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}