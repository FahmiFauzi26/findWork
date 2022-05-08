package com.example.findwork.pencarikerja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findwork.R;

public class DokumenPencariKerja extends AppCompatActivity {
    Button btn_buatlowongan,btn_lihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumen_pencari_kerja);
        btn_buatlowongan = findViewById(R.id.btn_buatlowongan);
        btn_lihat = findViewById(R.id.btn_lihat);


        btn_buatlowongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DokumenPencariKerja.this,DokumenBuatPencariKerja.class));
            }
        });
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DokumenPencariKerja.this, DokumenDetailPencariKerja.class));
            }
        });
    }
}