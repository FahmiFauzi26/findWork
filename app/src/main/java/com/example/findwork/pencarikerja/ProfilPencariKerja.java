package com.example.findwork.pencarikerja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findwork.R;

public class ProfilPencariKerja extends AppCompatActivity {
    Button btn_simpan,btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_pencari_kerja);
        btn_back =findViewById(R.id.btn_back);
        btn_simpan = findViewById(R.id.btn_simpan);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilPencariKerja.this,AkunPencariKerjaActivity.class));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfilPencariKerja.this,AkunPencariKerjaActivity.class));
            }
        });

    }
}