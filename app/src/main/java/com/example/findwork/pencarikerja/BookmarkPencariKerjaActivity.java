package com.example.findwork.pencarikerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.findwork.MainActivity;
import com.example.findwork.R;
import com.example.findwork.perusahaan.JobDetailActivity;
import com.example.findwork.perusahaan.modellowongan.RecyclerViewAdapterLowonganB;
import com.example.findwork.perusahaan.modellowongan.RecyclerViewAdapterLowonganS;
import com.example.findwork.signin;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class BookmarkPencariKerjaActivity extends AppCompatActivity {
    Button btn_lihat;
    private ArrayList<String> posisiLowongan = new ArrayList<>();
    private ArrayList<String> namaPerusahaan = new ArrayList<>();
    private ArrayList<String> alamatLowongan = new ArrayList<>();
    private ArrayList<String> minimalPendidikan = new ArrayList<>();
    private ArrayList<String> gaji = new ArrayList<>();
    private ArrayList<String> tenggatLowongan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark_pencari_kerja);


        btn_lihat = findViewById(R.id.btn_lihat);
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookmarkPencariKerjaActivity.this, JobDetailActivity.class));
            }
        });

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPencariKerja);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.bookmark);

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
                        return true;
                    case R.id.akunPencariKerja:
                        startActivity(new Intent(getApplicationContext(), AkunPencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });




//        getDataPekerjaan();

    }
    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recycleViewDaftarLowongan);
        RecyclerViewAdapterLowonganB adapter = new RecyclerViewAdapterLowonganB(posisiLowongan, namaPerusahaan, alamatLowongan, minimalPendidikan, gaji, tenggatLowongan, this);

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

//        posisiLowongan.add("Copywriter");
//        namaPerusahaan.add("PT Mencari Cinta Sejati");
//        alamatLowongan.add("Tanggerang, Banten");
//        minimalPendidikan.add("Minimal pendidikan SMA/SMK Sederakat");
//        gaji.add("Gaji : 4.000.000 - 5.000.000");
//        tenggatLowongan.add("Tenggat 04 Mei 2022");
//
//        posisiLowongan.add("Java Programmer");
//        namaPerusahaan.add("PT Mencari Cinta Sejati");
//        alamatLowongan.add("Tanggerang, Banten");
//        minimalPendidikan.add("Minimal pendidikan SMA/SMK Sederakat");
//        gaji.add("Gaji : 4.000.000 - 5.000.000");
//        tenggatLowongan.add("Tenggat 04 Mei 2022");

//        prosesRecyclerViewAdapter();
    }
}