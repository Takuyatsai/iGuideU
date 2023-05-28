package com.example.watertank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class QualityActivity extends AppCompatActivity {
    private WebView webView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_quality);
        getSupportActionBar().hide();

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://192.168.1.101:8081");

        button = findViewById(R.id.quality_button_back);

    }
    public void backtomain(View v){
        finish();
    }
}
