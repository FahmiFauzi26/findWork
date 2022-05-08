package com.example.findwork.pencarikerja;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.findwork.R;
import com.example.findwork.perusahaan.DetailPelamarActivity;
import com.example.findwork.perusahaan.MasukDalamPantauanActivity;

public class LamarPekerjaan extends AppCompatActivity {
    Button btn_lamarpekerjaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamar_pekerjaan);
        btn_lamarpekerjaan = findViewById(R.id.btn_lamarpekerjaan);
        btn_lamarpekerjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTertarikAlertDialog();
            }
        });
    }
    private void showTertarikAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LamarPekerjaan.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(LamarPekerjaan.this).inflate(
                R.layout.layout_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText("Konfirmasi");
        ((TextView) view.findViewById(R.id.textMessage)).setText("Kirim lamaran?");
        ((Button) view.findViewById(R.id.buttonYes)).setText("Kirim");
        ((Button) view.findViewById(R.id.buttonCancel)).setText("Batal");

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
//                Toast.makeText(DetailPelamarActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LamarPekerjaan.this, LamaranTerkirim.class));
            }
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
//                Toast.makeText(DetailPelamarActivity.this, "No", Toast.LENGTH_SHORT).show();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        }
        alertDialog.show();
    }
}