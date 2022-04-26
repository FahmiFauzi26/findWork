package com.example.findwork.perusahaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.findwork.R;

public class ResetPasswordPerusahaanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password_perusahaan);

        TextView btn_masuk_perusahaan = findViewById(R.id.btn_punya_akun);

        btn_masuk_perusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResetPasswordPerusahaanActivity.this, SignInPerusahaanActivity.class));
            }
        });
    }
}