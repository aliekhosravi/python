package com.example.myapp;

import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
import com.example.myapp.MyActivity;
import com.example.myapp.R;

public class Activitysplash extends Activity {
    ///splash : نام اکتیویتی ما
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        //splahs : صفحه گرافیکی مربوط به این اکتیویتی
        setContentView(R.layout.splash);
        ////تعریف یک هندلر
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                ///main : نام صفحه ای که میخوایم  بعد از یک زمان مشخص واردش بشیم
                startActivity(new Intent(Activitysplash.this, MyActivity.class));
            }
        },4000);
    }}