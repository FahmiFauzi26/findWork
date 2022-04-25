package com.example.findwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD:app/src/main/java/com/example/findwork/resetPassword.java
public class resetPassword extends AppCompatActivity {
    ImageView btn_back;
    TextView btn_masuk;
=======
public class ResetPassword extends AppCompatActivity {

>>>>>>> 5e987a4fc60e84e444f502ba7616dbd65b8f4fa6:app/src/main/java/com/example/findwork/ResetPassword.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        btn_back = findViewById(R.id.btn_back);
        btn_masuk = findViewById(R.id.btn_masuk);

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
}