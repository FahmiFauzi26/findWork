package com.example.findwork.perusahaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.findwork.R;

public class JobDetailActivity extends AppCompatActivity {

    TextView posisiLowonganView, namaPerusahaanView, alamatLowonganView, minimalPendidikanView, gajiView, tenggatLowonganView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        posisiLowonganView = findViewById(R.id.posisiLowonganView);
        namaPerusahaanView = findViewById(R.id.namaPerusahaanView);
        alamatLowonganView = findViewById(R.id.alamatLowonganView);
        minimalPendidikanView = findViewById(R.id.minimalPendidikanView);
        gajiView = findViewById(R.id.gajiView);
        tenggatLowonganView = findViewById(R.id.tenggatLowonganView);

        getIncomingExtra();
    }

    private void getIncomingExtra() {
        if (getIntent().hasExtra("posisi_lowongan") && getIntent().hasExtra("nama_perusahaan") && getIntent().hasExtra("alamat_lowongan") && getIntent().hasExtra("minimal_pendidikan") && getIntent().hasExtra("gaji") && getIntent().hasExtra("tenggat_lowongan")) {
            String posisiLowongan = getIntent().getStringExtra("posisi_lowongan");
            String namaPerusahaan = getIntent().getStringExtra("nama_perusahaan");
            String alamatLowongan = getIntent().getStringExtra("alamat_lowongan");
            String minimalPendidikan = getIntent().getStringExtra("minimal_pendidikan");
            String gaji = getIntent().getStringExtra("gaji");
            String tenggatLowongan = getIntent().getStringExtra("tenggat_lowongan");

            setDataActivity(posisiLowongan, namaPerusahaan, alamatLowongan, minimalPendidikan, gaji, tenggatLowongan);
        }
    }

    private void setDataActivity(String posisiLowongan, String namaPerusahaan, String alamatLowongan, String minimalPendidikan, String gaji, String tenggatLowongan) {
        posisiLowonganView.setText(posisiLowongan);
        namaPerusahaanView.setText(namaPerusahaan);
        alamatLowonganView.setText(alamatLowongan);
        minimalPendidikanView.setText(minimalPendidikan);
        gajiView.setText(gaji);
        tenggatLowonganView.setText(tenggatLowongan);
    }
}