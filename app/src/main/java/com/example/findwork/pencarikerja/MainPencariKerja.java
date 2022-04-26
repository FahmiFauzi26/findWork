package com.example.findwork.pencarikerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.findwork.R;
import com.example.findwork.perusahaan.MenuAkunPerusahaanFragment;
import com.example.findwork.perusahaan.MenuHomePerusahaanFragment;
import com.example.findwork.perusahaan.MenuKelolaPelamarFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainPencariKerja extends AppCompatActivity {

    BottomNavigationView bottomNavigationPencariKerja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pencari_kerja);

        bottomNavigationPencariKerja = findViewById(R.id.bottom_nav_pencari_kerja);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuHomePencariKerjaFragment()).commit();

        bottomNavigationPencariKerja.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.nav_lowongan_kerja:
                        selectedFragment = new MenuHomePencariKerjaFragment();
                        break;
                    case R.id.nav_perjalanan_saya:
                        selectedFragment = new MenuPerjalananSayaFragment();
                        break;
                    case R.id.nav_bookmark:
                        selectedFragment = new MenuBookmarkFragment();
                        break;
                    case R.id.nav_akun_pencari_kerja:
                        selectedFragment = new MenuAkunPencariKerjaFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}