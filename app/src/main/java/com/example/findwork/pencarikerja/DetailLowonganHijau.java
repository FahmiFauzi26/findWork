package com.example.findwork.pencarikerja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findwork.R;

public class DetailLowonganHijau extends AppCompatActivity {
    Button btn_telahdilamar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lowongan_hijau);
        btn_telahdilamar = findViewById(R.id.btn_telahdilamar);
        btn_telahdilamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailLowonganHijau.this,PerjalananPencariKerjaActivity.class));
            }
        });
    }
}