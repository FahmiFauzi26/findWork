package com.example.findwork;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.example.findwork.pencarikerja.HomePencariKerjaActivity;
import com.example.findwork.perusahaan.HomePerusahaanActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class signin extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore mstore;
    TextView btn_lupasandi, btn_daftar;
    ImageView btn_back;
    Button btn_masuk;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        if (mAuth.getCurrentUser() != null) {
            DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.getString("isPerusahaan")!=null){
                        startActivity(new Intent(signin.this, HomePerusahaanActivity.class));
                        finish();
                    }
                    if(documentSnapshot.getString("isUser")!=null){
                        startActivity(new Intent(signin.this,HomePencariKerjaActivity.class));
                        finish();
                    }
                }
            });

        }
        btn_masuk = findViewById(R.id.btn_masuk);
        btn_lupasandi = findViewById(R.id.btn_lupasandi);
        btn_daftar = findViewById(R.id.btn_daftar);
        btn_back = findViewById(R.id.btn_back);
        btn_lupasandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, resetPasswords.class));
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
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        checkLevel(authResult.getUser().getUid());
                    }
                });
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            checkLevel(AuthResult);
//
//                        } else {
//                            Toast.makeText(signin.this, "Login gagal ! "
//                                    , Toast.LENGTH_LONG).show();
//
//                        }
//                    }
//                });

    }




    private void checkLevel(String uid){
        DocumentReference df = mstore.collection("Users").document(uid);
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d(TAG, "onSuccess: "+ documentSnapshot.getData());
                if(documentSnapshot.getString("isUser") != null)
                    startActivity(new Intent(signin.this, HomePencariKerjaActivity.class));
                finish();
            }
        });
    }
}