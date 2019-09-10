package com.example.latihanandroid;

import android.os.Bundle;

import com.example.latihanandroid.fragment.GedungFragment;
import com.example.latihanandroid.fragment.LahanFragment;
import com.example.latihanandroid.fragment.RuanganFragment;
import com.example.latihanandroid.fragment.SekolahFragment;
import com.example.latihanandroid.fragment.TingkatFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle t;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Beranda",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_manage:
                        Toast.makeText(MainActivity.this, "Cek Data",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_download_for_correction:
                        Toast.makeText(MainActivity.this, "Download Untuk Perbaikan", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_upload_data:
                        Toast.makeText(MainActivity.this, "Kirim Data Saja", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_download:
                        Toast.makeText(MainActivity.this, "Unduh Data Awal", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_upload:
                        Toast.makeText(MainActivity.this, "Kirim", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_backup:
                        Toast.makeText(MainActivity.this, "Backup", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_hidden:
                        Toast.makeText(MainActivity.this, "Sekolah Disembunyikan", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_bug:
                        Toast.makeText(MainActivity.this, "Kirim Diagnosa Bug", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_help:
                        Toast.makeText(MainActivity.this, "Bantuan", Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_about:
                        Toast.makeText(MainActivity.this, "Tentang", Toast.LENGTH_SHORT).show();break;

                    default:
                        return true;
                }


                return true;

            }
        });

        initViews();
            /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/



    }

    private void initViews() {
        // setting toolbar
        // setting view pager
       viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        // setting tabLayout
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        MainFragmentPagerAdapter mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        mainFragmentPagerAdapter.addFragment(new SekolahFragment(), getString(R.string.text_sekolah));
        mainFragmentPagerAdapter.addFragment(new GedungFragment(), getString(R.string.text_gedung));
        mainFragmentPagerAdapter.addFragment(new LahanFragment(), getString(R.string.text_lahanKosong));
        mainFragmentPagerAdapter.addFragment(new RuanganFragment(), getString(R.string.text_ruangan));
        mainFragmentPagerAdapter.addFragment(new TingkatFragment(), getString(R.string.text_lantai));
        viewPager.setAdapter(mainFragmentPagerAdapter);

    }
}
