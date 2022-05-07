package com.example.findwork.pencarikerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.findwork.R;
import com.example.findwork.perusahaan.modellowongan.RecyclerViewAdapterLowongan;
import com.example.findwork.perusahaan.modellowongan.RecyclerViewAdapterLowonganS;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomePencariKerjaActivity extends AppCompatActivity {

    private ArrayList<String> posisiLowongan = new ArrayList<>();
    private ArrayList<String> namaPerusahaan = new ArrayList<>();
    private ArrayList<String> alamatLowongan = new ArrayList<>();
    private ArrayList<String> minimalPendidikan = new ArrayList<>();
    private ArrayList<String> gaji = new ArrayList<>();
    private ArrayList<String> tenggatLowongan = new ArrayList<>();

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
        getDataPekerjaan();
    }
    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewDaftarLowongan);
        RecyclerViewAdapterLowonganS adapter = new RecyclerViewAdapterLowonganS(posisiLowongan, namaPerusahaan, alamatLowongan, minimalPendidikan, gaji, tenggatLowongan, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getDataPekerjaan() {
        posisiLowongan.add("Desainer Grafis");
        namaPerusahaan.add("PT Aksepta Strategi Indonesia");
        alamatLowongan.add("Magelang, Jawa Tengah");
        minimalPendidikan.add("Minimal pendidikan SMA/SMK Sederakat");
        gaji.add("Gaji : 4.000.000 - 5.000.000");
        tenggatLowongan.add("Tenggat 04 Mei 2022");

        posisiLowongan.add("Copywriter");
        namaPerusahaan.add("PT Mencari Cinta Sejati");
        alamatLowongan.add("Tanggerang, Banten");
        minimalPendidikan.add("Minimal pendidikan SMA/SMK Sederakat");
        gaji.add("Gaji : 4.000.000 - 5.000.000");
        tenggatLowongan.add("Tenggat 04 Mei 2022");

        posisiLowongan.add("Java Programmer");
        namaPerusahaan.add("PT Mencari Cinta Sejati");
        alamatLowongan.add("Tanggerang, Banten");
        minimalPendidikan.add("Minimal pendidikan SMA/SMK Sederakat");
        gaji.add("Gaji : 4.000.000 - 5.000.000");
        tenggatLowongan.add("Tenggat 04 Mei 2022");

        prosesRecyclerViewAdapter();
    }
}