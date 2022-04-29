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

import com.example.findwork.pencarikerja.HomePencariKerjaActivity;
import com.example.findwork.perusahaan.HomePerusahaanActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signupPerusahaan extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore mstore;
    ImageView btn_back;
    TextView btn_masuk;
    Button btn_daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_perusahaan);
        btn_back = findViewById(R.id.btn_back);
        btn_masuk = findViewById(R.id.btn_masuk);
        btn_daftar = findViewById(R.id.btn_daftar);



        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();
        if (mAuth.getCurrentUser() != null) {
            DocumentReference df = FirebaseFirestore.getInstance().collection("User Perusahaan").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.getString("isPerusahaan")!=null){
                        startActivity(new Intent(signupPerusahaan.this, HomePerusahaanActivity.class));
                        finish();
                    }
                    if(documentSnapshot.getString("isUser")!=null){
                        startActivity(new Intent(signupPerusahaan.this, HomePencariKerjaActivity.class));
                        finish();
                    }
                }
            });

        }
        if (mAuth.getCurrentUser() != null){
            showLogin();
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
                startActivity(new Intent(signupPerusahaan.this, signinPerusahaan.class));
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signupPerusahaan.this, MainActivity.class));
            }
        });
    }
    private void daftarkanUser() {
        EditText et_username = findViewById(R.id.et_nama_perusahaan);
        EditText et_email = findViewById(R.id.et_email);
        EditText et_password = findViewById(R.id.et_password);
        EditText et_repassword = findViewById(R.id.et_repassword);

        String username = et_username.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String repassword = et_repassword.getText().toString();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            Toast.makeText(this, "Tidak boleh kosong !", Toast.LENGTH_LONG).show();
            et_username.requestFocus();
            return;
        }


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



        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser uuser = mAuth.getCurrentUser();
//                            User user = new User(username, email, password, repassword);
                            DocumentReference df = mstore.collection("User Perusahaan").document((uuser.getUid()));
                            Map<String,Object> userInfo = new HashMap<>();
                            userInfo.put("Username",username);
                            userInfo.put("Email",email);
                            userInfo.put("Password",password);
                            userInfo.put("Repassword",repassword);
                            //level
                            userInfo.put("isPerusahaan","1");
                            //
                            df.set(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {

                                //                     GANTI FIRESTORE       FirebaseDatabase.getInstance().getReference("users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(signupPerusahaan.this, "Berhasil", Toast.LENGTH_LONG).show();

                                    showLogin();
                                }
                            });
                        } else {
                            Toast.makeText(signupPerusahaan.this, "Gagal daftar !",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
    private void showLogin() {
        Intent intent = new Intent(signupPerusahaan.this, signinPerusahaan.class);
        startActivity(intent);
        finish();
    }
}