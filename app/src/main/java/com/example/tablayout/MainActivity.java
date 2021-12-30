package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentContact(), "Contact");
        adapter.AddFragment(new FragmentGallery(), "Gallery");
        adapter.AddFragment(new FragmentFree(), "Free");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}