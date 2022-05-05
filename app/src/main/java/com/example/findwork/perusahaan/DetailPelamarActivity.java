package com.example.findwork.perusahaan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findwork.MainActivity;
import com.example.findwork.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DetailPelamarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pelamar);

        findViewById(R.id.buttonTertarik).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTertarikAlertDialog();
            }
        });
    }

    private void showTertarikAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DetailPelamarActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(DetailPelamarActivity.this).inflate(
                R.layout.layout_dialog,(ConstraintLayout)findViewById(R.id.layoutDialogContainer)
        );
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText("Konfirmasi");
        ((TextView) view.findViewById(R.id.textMessage)).setText("Masukan Dalam Pantauan?");
        ((Button) view.findViewById(R.id.buttonYes)).setText("Masukan");
        ((Button) view.findViewById(R.id.buttonCancel)).setText("Batal");

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
//                Toast.makeText(DetailPelamarActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DetailPelamarActivity.this, MasukDalamPantauanActivity.class));
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