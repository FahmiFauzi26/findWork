package com.example.findwork.perusahaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.findwork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainPerusahaan extends AppCompatActivity {

    BottomNavigationView bottomNavigationPerusahaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perusahaan);

        bottomNavigationPerusahaan = findViewById(R.id.bottom_nav_perusahaan);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuHomePerusahaanFragment()).commit();

        bottomNavigationPerusahaan.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_lowongan:
                        selectedFragment = new MenuHomePerusahaanFragment();
                        break;
                    case R.id.nav_kelola:
                        selectedFragment = new MenuKelolaPelamarFragment();
                        break;
                    case R.id.nav_akun_perusahaan:
                        selectedFragment = new MenuAkunPerusahaanFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}