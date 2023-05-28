package com.example.watertank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getSupportActionBar().hide();

        String method = getIntent().getStringExtra("method");
        ChartFragment chartFragment = new ChartFragment();
        Bundle bundle = new Bundle();
        bundle.putString("method",method);
        chartFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,chartFragment).commit();
    }
}
