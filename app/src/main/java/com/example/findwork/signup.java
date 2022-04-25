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
import com.google.firebase.database.FirebaseDatabase;


public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    ImageView btn_back;
    TextView btn_masuk;
    Button btn_daftar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        btn_back = findViewById(R.id.btn_back);
        btn_masuk = findViewById(R.id.btn_masuk);
        btn_daftar = findViewById(R.id.btn_daftar);



        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null){
            finish();
            return;
        }

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftarkanUser();
            }
        });
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, signin.class));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signup.this, MainActivity.class));
            }
        });
    }
    private void daftarkanUser() {
        EditText et_username = findViewById(R.id.et_username);
        EditText et_email = findViewById(R.id.et_email);
        EditText et_password = findViewById(R.id.et_password);
        EditText et_repassword = findViewById(R.id.et_repassword);

        String username = et_username.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String repassword = et_repassword.getText().toString();


        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Email tidak valid !");
            et_email.requestFocus();
            return;}
        if (!repassword.equals(password)) {
            et_repassword.setError("Password harus sama !");
            return;
        }
        if (password.length() < 6) {
            et_password.setError("Less length");
            et_password.requestFocus();
            return;
        }
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            Toast.makeText(this, "Tidak boleh kosong !", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(username, email, password, repassword);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(signup.this, "Berhasil", Toast.LENGTH_LONG).show();

                                    showLogin();
                                }
                            });
                        } else {
                            Toast.makeText(signup.this, "Gagal daftar !",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
        private void showLogin() {
            Intent intent = new Intent(signup.this, signin.class);
            startActivity(intent);
            finish();
        }
    }
