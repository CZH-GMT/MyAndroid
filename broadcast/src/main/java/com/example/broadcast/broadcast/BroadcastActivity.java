package com.example.broadcast.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.broadcast.R;

public class BroadcastActivity extends AppCompatActivity {

    private MyReceiver myReceiver;
    private Button mScreenbroadcast;
    private Button mCustombroadcast;
    private Button sendOrderBroadcast;
    private Receive receive;
    private Button localBroadcast;
    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadcast localBroadcast1;
    private Button offline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        initViews();

        myReceiver = new MyReceiver();
        receive = new Receive();
        localBroadcast1 = new LocalBroadcast();

    }


    private void initViews() {
        mScreenbroadcast = findViewById(R.id.screenBroadcast);
        mCustombroadcast = findViewById(R.id.customBroadcast);
        sendOrderBroadcast = findViewById(R.id.sendOrderBroadcast);
        localBroadcast = findViewById(R.id.localBroadcast);
        offline = findViewById(R.id.offline);


        //监听屏幕亮度广播
        mScreenbroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenBroadcast();
            }
        });

        //自定义广播
        mCustombroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomBroadcast();
            }
        });
        //发送有序广播
        sendOrderBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrderBroadcast();
            }
        });
        //发送本地广播
        localBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLocalBroadcast();
            }
        });

        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastActivity.this, OfflinTextActivity.class);
                startActivity(intent);
            }
        });

    }


    /**
     * 发送本地广播
     */
    private void sendLocalBroadcast() {
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("hhhhhh");
        localBroadcastManager.registerReceiver(localBroadcast1, intentFilter);
        Intent intent = new Intent("hhhhhh");
        localBroadcastManager.sendBroadcast(intent);

//        localBroadcastManager.registerReceiver(receive, intentFilter);
//        localBroadcastManager.sendBroadcast(intent);
    }

    //发送有序广播

    /**
     * 有序广播三点
     * 1.intentFilter.setPriority(1000);不同的广播接收器设置优先级
     * 2.发送广播使用sendOrderedBroadcast（intent,null）
     * 3.abortBroadcast();截断广播  在A接收器使用之后在B接收器收不到广播
     */
    private void sendOrderBroadcast() {
        sendFirstBroadcast();
        sendSecondBroadcast();

    }

    private void sendSecondBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("customBroadcast");
        //设置优先级
        intentFilter.setPriority(100);
        Intent intent = new Intent("customBroadcast");
        intent.setPackage(getPackageName());
        registerReceiver(receive, intentFilter);
        sendOrderedBroadcast(intent, null);

    }

    private void sendFirstBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        //customBroadcast自定义广播内容
        intentFilter.addAction("customBroadcast");
        //设置优先级
        intentFilter.setPriority(1000);
        Intent intent = new Intent("customBroadcast");
        //静态接收的话8.0之后要写不然不生效
        intent.setPackage(getPackageName());
        registerReceiver(myReceiver, intentFilter);
        sendOrderedBroadcast(intent, null);
    }

    //发送自定义广播
    private void CustomBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        //customBroadcast自定义广播内容
        intentFilter.addAction("customBroadcast");
        Intent intent = new Intent("customBroadcast");
//        intent.addFlags(0x01000000);
        //静态8.0之后要写不然不生效，动态不写
        intent.setPackage(getPackageName());
        registerReceiver(myReceiver, intentFilter);
        sendBroadcast(intent);
    }

    //屏幕亮度广播
    private void ScreenBroadcast() {
        //意图过滤器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);

        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            //取消 注册
            unregisterReceiver(myReceiver);
            unregisterReceiver(receive);
            localBroadcastManager.unregisterReceiver(localBroadcast1);
        }
    }
}