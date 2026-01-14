package com.example.securewebview;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // THE SECRET SAUCE: This line blocks screenshots and screen recording
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                             WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        
        // Settings
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true); // Helps GitHub Pages load correctly

        // Keep navigation inside the app
        webView.setWebViewClient(new WebViewClient());

        // LOAD YOUR GITHUB PAGES URL HERE
        webView.loadUrl("https://pranavcm24032.github.io/ss/");
    }

    // Allow user to go back in browser history using phone back button
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}