package com.example.watertank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
      Thread myThread = new Thread(){
          @Override
          public void run() {
              try {
                  sleep(2000);
                  Intent intent = new Intent(getApplicationContext(),LoginActivity.class);// Welcome後進入的頁面
                  startActivity(intent);
                  finish();
              } catch (InterruptedException e) {
                  e.printStackTrace();
                  
              }
          }
      };
      myThread.start();
    }
}
