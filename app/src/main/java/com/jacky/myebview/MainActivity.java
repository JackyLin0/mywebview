package com.jacky.myebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.jacky.myebview.R.id.webview;

public class MainActivity extends AppCompatActivity {
    WebView webView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(webview);

        WebViewClient client = new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String name = "Brad";
                webView.loadUrl("javascript:showName('" + name + "')");

            }
        };

        webView.setWebViewClient(client);


        webView.addJavascriptInterface(new BradJs(),"myjs");
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/Jacky.html");


    }

    public class BradJs{
        @JavascriptInterface //給JavaScript溝通的橋樑
        public void  getName(String info)
        {
            Log.v("TAG",info);

        }
    }
}
