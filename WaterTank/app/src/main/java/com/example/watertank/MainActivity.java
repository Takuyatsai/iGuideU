package com.example.watertank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView data;
    public static TextView data2;
    public static TextView data3;
    public static TextView test;
    private TextView name;
    private Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //account
        name=findViewById(R.id.name);
        btn_logout = findViewById(R.id.btn_logout);

        Intent intent = getIntent();
        String extraName = intent.getStringExtra("name")+",你好";
        name.setText(extraName);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        click=findViewById(R.id.button11); // 主頁面更新按鈕
        data=findViewById(R.id.updatedata); // 主頁面溫度顯示
        data2=findViewById(R.id.updatedata2); // 主頁面濕度顯示
        data3=findViewById(R.id.updatedata3); //主頁面水位顯示



        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //主頁面更新資料的監聽器
                updateDataMain process = new updateDataMain();
                process.execute();
                updateDataMain2 process2=new updateDataMain2();
                process2.execute();
                updateDataLevel process3=new updateDataLevel();
                process3.execute();
            }
        });
        Button call=findViewById(R.id.call); //主頁面聯絡廠商按鈕
        call.setOnClickListener(new View.OnClickListener() { //聯絡廠商的監聽器
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0905039970"));
                startActivity(intent);
            }
        });
    }
    public void waterlevel(View v){ // 進入水位檢測介面
        Intent it=new Intent(this,Main2Activity.class);
        startActivity(it);
    }
    public void temphum(View v){  //進入溫溼度介面
        Intent it =new Intent(this,Main3Activity.class);
        startActivity(it);
    }
    public void quality(View v){
        Intent it =new Intent(this,QualityActivity.class);
        startActivity(it);
    }

    public void Openbarchart(View view) {
        Intent intent = new Intent(this,ChartActivity.class);
        intent.putExtra("method","bars");
        startActivity(intent);
    }
}
