package com.example.findwork.perusahaan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.findwork.R;

public class SignInPerusahaanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_perusahaan);

        TextView btn_lupa_sandi = findViewById(R.id.lupaSandi);
        TextView btn_daftar_perusahaan = findViewById(R.id.btn_daftar_perusahaan);

        btn_lupa_sandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInPerusahaanActivity.this, ResetPasswordPerusahaanActivity.class));
            }
        });

        btn_daftar_perusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInPerusahaanActivity.this, SignUpPerusahaanActivity.class));
            }
        });
    }
}