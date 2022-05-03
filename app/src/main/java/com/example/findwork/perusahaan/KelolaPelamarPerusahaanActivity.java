package com.example.findwork.perusahaan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.findwork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class KelolaPelamarPerusahaanActivity extends AppCompatActivity {

    private TabLayout tabLayoutKelola;
    private ViewPager viewPagerKelola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_pelamar_perusahaan);

        tabLayoutKelola = findViewById(R.id.tabKelola);
        viewPagerKelola = findViewById(R.id.viewPagerKelola);

        tabLayoutKelola.setupWithViewPager(viewPagerKelola);

        VPKelolaAdapter vpKelolaAdapter = new VPKelolaAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpKelolaAdapter.addFragment(new PelamarFragment(), "Pelamar");
        vpKelolaAdapter.addFragment(new PantauanFragment(), "Pantauan");
        viewPagerKelola.setAdapter(vpKelolaAdapter);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPerusahaan);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.kelolaPelamar);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePerusahaan:
                        startActivity(new Intent(getApplicationContext(), HomePerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.kelolaPelamar:
                        return true;
                    case R.id.akunPerusahaan:
                        startActivity(new Intent(getApplicationContext(), AkunPerusahaanActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}