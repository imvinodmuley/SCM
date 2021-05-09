package com.example.dapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class rewardfine extends AppCompatActivity {
    TabLayout tabs;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewardfine);

        tabs=(TabLayout)findViewById(R.id.tabs);
        viewPager=(ViewPager)findViewById(R.id.view_pager);


        tabs.addTab(tabs.newTab().setText("Rewards"));
        tabs.addTab(tabs.newTab().setText("Fine"));
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);


        final com.example.dapp.SectionsPagerAdapter adapter = new com.example.dapp.SectionsPagerAdapter(this,getSupportFragmentManager(), tabs.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}


