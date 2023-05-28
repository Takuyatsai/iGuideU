package com.example.watertank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity {
    Button getdata;
    TextView titletext;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();

        getdata=findViewById(R.id.button6);
        data=findViewById(R.id.textView3);
        titletext=findViewById(R.id.textView4);
        titletext.setText("             datatime        "+"      Temp "+"   Hum ");



    }
    public void getdata(View v){
        fetchDatatemp process = new fetchDatatemp();
        process.execute();
    }
    public void goback(View v){
        finish();
    }
}
