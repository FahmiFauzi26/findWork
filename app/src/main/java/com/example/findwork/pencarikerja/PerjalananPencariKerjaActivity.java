package com.example.findwork.pencarikerja;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.findwork.R;
import com.example.findwork.perusahaan.PantauanFragment;
import com.example.findwork.perusahaan.PelamarFragment;
import com.example.findwork.perusahaan.VPKelolaAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class PerjalananPencariKerjaActivity extends AppCompatActivity {
    private TabLayout tabLayoutKelola;
    private ViewPager viewPagerKelola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perjalanan_pencari_kerja);
        tabLayoutKelola = findViewById(R.id.tabKelola);
        viewPagerKelola = findViewById(R.id.viewPagerKelola);

        tabLayoutKelola.setupWithViewPager(viewPagerKelola);

        VPKelolaAdapter vpKelolaAdapter = new VPKelolaAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpKelolaAdapter.addFragment(new FragmentMelamar(), "Melamar");
        vpKelolaAdapter.addFragment(new FragmentTertarik(), "Tertarik");
        viewPagerKelola.setAdapter(vpKelolaAdapter);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavPencariKerja);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.perjalananSaya);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.homePencariKerja:
                        startActivity(new Intent(getApplicationContext(), HomePencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.perjalananSaya:
                        return true;
                    case R.id.bookmark:
                        startActivity(new Intent(getApplicationContext(), BookmarkPencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.akunPencariKerja:
                        startActivity(new Intent(getApplicationContext(), AkunPencariKerjaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}