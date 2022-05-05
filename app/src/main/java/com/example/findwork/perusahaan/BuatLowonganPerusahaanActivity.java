package com.example.findwork.perusahaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findwork.MainActivity;
import com.example.findwork.R;

public class BuatLowonganPerusahaanActivity extends AppCompatActivity {

    Button btnBuatLowongan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_lowongan_perusahaan);

        btnBuatLowongan = findViewById(R.id.buttonBuatLowongan);

        btnBuatLowongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuatLowonganPerusahaanActivity.this, LowonganBerhasilDibuatActivity.class));
            }
        });
    }
}