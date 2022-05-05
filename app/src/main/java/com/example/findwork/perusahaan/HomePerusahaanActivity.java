package com.example.findwork.perusahaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.findwork.R;
import com.example.findwork.perusahaan.modellowongan.RecyclerViewAdapterLowongan;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomePerusahaanActivity extends AppCompatActivity {

    //cara 1
//    private RecyclerView recyclerView;
//    private LowonganAdapter lowonganAdapter;
//    private ArrayList<Lowongan> lowonganArrayList;

    //cara 2
    private ArrayList<String> posisiLowongan = new ArrayList<>();
    private ArrayList<String> namaPerusahaan = new ArrayList<>();
    private ArrayList<String> alamatLowongan = new ArrayList<>();
    private ArrayList<String> minimalPendidikan = new ArrayList<>();
    private ArrayList<String> gaji = new ArrayList<>();
    private ArrayList<String> tenggatLowongan = new ArrayList<>();

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

        //Cara 1
        //data lowongan
//        getDataLowongan();

//        recyclerView = findViewById(R.id.recycleViewDaftarLowongan);
//        lowonganAdapter = new LowonganAdapter(lowonganArrayList);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomePerusahaanActivity.this);
//
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(lowonganAdapter);

        //Cara 2
        getDataPekerjaan();
    }

    //data lowongan
//    public void getDataLowongan() {
//        lowonganArrayList = new ArrayList<>();
//        lowonganArrayList.add(new Lowongan("Desainer Grafis", "PT Aksepta Strategi Indonesia", "Magelang, Jawa Tengah", "Minimal pendidikan SMA/SMK Sederakat", "Gaji : 4.000.000 - 5.000.000", "Tenggat 04 Mei 2022"));
//        lowonganArrayList.add(new Lowongan("Desainer Grafis", "PT Aksepta Strategi Indonesia", "Magelang, Jawa Tengah", "Minimal pendidikan SMA/SMK Sederakat", "Gaji : 4.000.000 - 5.000.000", "Tenggat 04 Mei 2022"));
//        lowonganArrayList.add(new Lowongan("Desainer Grafis", "PT Aksepta Strategi Indonesia", "Magelang, Jawa Tengah", "Minimal pendidikan SMA/SMK Sederakat", "Gaji : 4.000.000 - 5.000.000", "Tenggat 04 Mei 2022"));
//        lowonganArrayList.add(new Lowongan("Desainer Grafis", "PT Aksepta Strategi Indonesia", "Magelang, Jawa Tengah", "Minimal pendidikan SMA/SMK Sederakat", "Gaji : 4.000.000 - 5.000.000", "Tenggat 04 Mei 2022"));
//    }

    //Cara 2
    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewDaftarLowongan);
        RecyclerViewAdapterLowongan adapter = new RecyclerViewAdapterLowongan(posisiLowongan, namaPerusahaan, alamatLowongan, minimalPendidikan, gaji, tenggatLowongan, this);

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