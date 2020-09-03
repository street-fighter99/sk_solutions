package com.example.sk_solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class covidupdates extends AppCompatActivity {
    WebView mywebview;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidupdates);
        getSupportActionBar().hide();

        //resoursce linking

        mywebview = findViewById(R.id.mywebView);
        progressBar = findViewById(R.id.progressbarcovid);
        mywebview.loadUrl("https://www.covid19india.org");

        WebSettings webSettings = mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mywebview.setWebChromeClient(new WebChromeClient() {
            //to know the loading in percentages
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });


        mywebview.setWebViewClient(new WebViewClient() {
            @Override
            //to catch loading
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(view.VISIBLE);
            }

            @Override
            //when web page loading finished what to do
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(view.INVISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mywebview.canGoBack())
        {
            mywebview.goBack();
        }else{
            super.onBackPressed();
        }

    }
}