package com.example.goherbs;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebFrag extends Fragment {

    String baseURL = "https://goherbs.world";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View viewItem = inflater.inflate(R.layout.fragment_web, container, false);
//Start of WebView implementation
        WebView webView = viewItem.findViewById(R.id.realWebView);

        //webView.setVisibility(View.INVISIBLE);
        WebSettings settings = webView.getSettings();
        //settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT < 18) {
            //speed webview
            webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());//Something to do with webvoew client
        webView.loadUrl(baseURL);
        //webView.setVisibility(View.VISIBLE);

        //end of Webview implementation
        FragAdapter.lockPage(true,3);
        // Inflate the layout for this fragment
        return viewItem;
    }
}