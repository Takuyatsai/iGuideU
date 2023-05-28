package com.example.watertank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button click;
    TextView titletext;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        click = findViewById(R.id.button7);
        data = findViewById(R.id.textview6);
        titletext = findViewById(R.id.textView5);
        titletext.setText("     datatime      "+"     WaterLevel ");

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchDatalevel process = new fetchDatalevel();
                process.execute();
            }
        });
    }
    public void goback(View v){
        finish();
    }
}
