package com.example.findwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


class resetPassword extends AppCompatActivity {



    ///////////////////////////JANGAN DIPAKAI !///////


    EditText et_email;
    ImageView btn_back;
    TextView btn_masuk;
    Button btn_lupa;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        btn_back = findViewById(R.id.btn_back);
        btn_masuk = findViewById(R.id.btn_masuk);
        btn_lupa = findViewById(R.id.btn_lupa);
//        progressBar = findViewById(R.id.progressbar);
        et_email = findViewById(R.id.et_email);

        mAuth = FirebaseAuth.getInstance();

        btn_lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resetPassword.this, MainActivity.class));
            }
        });
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resetPassword.this, signin.class));
            }
        });
    }
    private void resetPassword(){
        String email = et_email.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Email tidak valid !");
            et_email.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            et_email.setError("Tidak boleh kosong !");
            et_email.requestFocus();
            return;
        }
//        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(resetPassword.this, "Silahkan cek email anda", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(resetPassword.this,"Gagal mengirim email",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}