package com.example.findwork;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.findwork.pencarikerja.HomePencariKerjaActivity;
import com.example.findwork.perusahaan.BerhasilBuatLowonganActivity;
import com.example.findwork.perusahaan.BuatLowonganPerusahaanActivity;
import com.example.findwork.perusahaan.HomePerusahaanActivity;
import com.example.findwork.perusahaan.SignInPerusahaanActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    Button btn_pekerja,btn_perusahaan;
    private FirebaseAuth mAuth;
    FirebaseFirestore mstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mstore = FirebaseFirestore.getInstance();

        if (mAuth.getCurrentUser() != null) {
            DocumentReference df = FirebaseFirestore.getInstance().collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.getString("isPerusahaan")!=null){
                        startActivity(new Intent(MainActivity.this,HomePerusahaanActivity.class));
                        finish();
                    }
                    if(documentSnapshot.getString("isUser")!=null){
                        startActivity(new Intent(MainActivity.this,HomePencariKerjaActivity.class));
                        finish();
                    }
                }
            });

        }

    btn_pekerja = findViewById(R.id.btn_pekerja);
    btn_perusahaan = findViewById(R.id.btn_sebagai_perusahaan);

        btn_pekerja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, signin.class));
            }
        });

//        btn_perusahaan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, SignInPerusahaanActivity.class));
//            }
//        });

        btn_perusahaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignInPerusahaanActivity.class));
            }
        });
    }

}