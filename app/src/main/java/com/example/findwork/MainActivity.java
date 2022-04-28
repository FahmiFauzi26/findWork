package com.example.findwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.findwork.pencarikerja.HomePencariKerjaActivity;
import com.example.findwork.perusahaan.HomePerusahaanActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_pekerja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_pekerja = findViewById(R.id.btn_pekerja);
        Button btn_perusahaan = findViewById(R.id.btn_sebagai_perusahaan);

        btn_pekerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, signin.class));
            }
        });

//        btn_perusahaan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, SignInPerusahaanActivity.class));
//            }
//        });

        btn_perusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HomePerusahaanActivity.class));
            }
        });
    }
}