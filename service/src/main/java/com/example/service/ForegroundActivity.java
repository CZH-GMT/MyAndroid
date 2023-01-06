package com.example.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.service.service.ForegroundService;


public class ForegroundActivity extends AppCompatActivity {

    private Button mStartforegroundservice;
    private Button mStopforegroundservice;
    private Button startForegroundService;
    private Button stopForegroundService;
    private Button messengerService;
    private Button binderService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground);
        initViews();
    }

    private void initViews() {
        mStopforegroundservice = findViewById(R.id.stopForegroundService);
        mStartforegroundservice = findViewById(R.id.startForegroundService);
        messengerService = (Button) findViewById(R.id.messengerService);
        binderService = (Button) findViewById(R.id.binderService);

        //跳转messenger服务
        messengerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForegroundActivity.this,MessengerActivity.class));
            }
        });

        //跳转binder服务
        binderService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForegroundActivity.this,BinderActivity.class));
            }
        });

        Intent intent = new Intent(this, ForegroundService.class);
        mStartforegroundservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("cmd", 0);//0,开启前台服务,1,关闭前台服务
                startService(intent);
            }
        });

        mStopforegroundservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("cmd", 1);
                stopService(intent);
            }
        });
    }

}