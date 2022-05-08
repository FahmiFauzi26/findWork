package com.example.findwork.pencarikerja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findwork.R;

public class DokumenDetailPencariKerja extends AppCompatActivity {
    Button btn_ubah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumen_detail_pencari_kerja);
        btn_ubah = findViewById(R.id.btn_ubah);
        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DokumenDetailPencariKerja.this, DokumenUbahPencariKerja.class));
            }
        });
    }
}