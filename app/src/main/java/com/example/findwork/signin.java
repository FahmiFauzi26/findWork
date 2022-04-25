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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextView lupaSandi, btn_daftar;
    ImageView btn_back;
    Button btn_masuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            showCs();
            return;
        }
        btn_masuk = findViewById(R.id.btn_masuk);
        lupaSandi = findViewById(R.id.lupaSandi);
        btn_daftar = findViewById(R.id.btn_daftar);
        btn_back = findViewById(R.id.btn_back);
        lupaSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, resetPassword.class));
            }
        });
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, signup.class));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, MainActivity.class));
            }
        });
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

    }

    private void loginUser() {
        EditText et_loginEmail = findViewById(R.id.et_loginEmail);
        EditText et_loginPassword = findViewById(R.id.et_loginPassowrd);

        String email = et_loginEmail.getText().toString();
        String password = et_loginPassword.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_loginEmail.setError("Email tidak valid !");
            et_loginEmail.requestFocus();
            return;
        }
            if (password.isEmpty()) {
                et_loginPassword.setError("Tidak boleh kosong!");
                et_loginPassword.requestFocus();
                return;
            }
            if (email.isEmpty()) {
                et_loginEmail.setError("Tidak boleh kosong!");
                et_loginEmail.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                showCs();

                            } else {
                                Toast.makeText(signin.this, "Login gagal ! "
                                        , Toast.LENGTH_LONG).show();

                            }
                        }
                    });

        }


    private void showCs() {
        Intent intent = new Intent(this, comingSoon.class);
        startActivity(intent);
        finish();
    }
}