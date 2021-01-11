package com.example.goherbs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    //View firstImage, secondImage, lastImage;
    static int i=0;
    private final Handler handler = new Handler();
    List<View> views = new ArrayList<>();
    static ViewPager viewPager;
    FragAdapter fragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager1);
        webView = findViewById(R.id.realWebView);
        fragAdapter = new FragAdapter(getSupportFragmentManager(), 1);

       // ImageAdapter imageAdapter = new ImageAdapter(views,this,webView);
        viewPager.setAdapter(fragAdapter);
        viewPager.setCurrentItem(0);
        //viewPager.setClickable(false);

        //Slide functionality instantiation start
        Runnable ViewPagerVisibleScroll = new Runnable() {
            @Override
            public void run() {
                if (i <= fragAdapter.getCount() - 1) {
                    viewPager.setCurrentItem(i, true);
                    // handler.postDelayed(TopChartAnimation, 100);
                    i++;
                }

            }

        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(ViewPagerVisibleScroll);
            }
        }, 500, 3000);
        //Slide functionality instantiation end

    }


    public void fade(View view ){
        view.animate().alpha(0f).setDuration(5000);
    }
    /*@Override
    public void onBackPressed() {// makes program exit to home screen
        Log.i("CDA", "onBackPressed Called");
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }*/


}