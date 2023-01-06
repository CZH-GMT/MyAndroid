package com.example.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.service.service.BinderService;


public class BinderActivity extends AppCompatActivity {

    private Button mBindservice;
    private Button mUnbindservice;
    private Button mGetdata;
    private String TAG = "mainActivity";
    private ServiceConnection serviceConnection;
    private BinderService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mBindservice = findViewById(R.id.bindService);
        mUnbindservice = findViewById(R.id.unBindService);
        mGetdata = findViewById(R.id.getData);

        Intent intent = new Intent(this, BinderService.class);

        mBindservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "绑定调用：bindService");
                bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
            }
        });

        mUnbindservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "解绑调用：unbindService");
                unbindService(serviceConnection);
            }
        });

        mGetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myService!=null) {
                    Log.e(TAG, "从服务端获取数据：" + myService.getCount());
                }else {
                    Log.e(TAG, "还没绑定呢，先绑定,无法从服务端获取数据");
                }
            }
        });

        serviceConnection = new ServiceConnection() {
            /**
             * 与服务器端交互的接口方法 绑定服务的时候被回调，在这个方法获取绑定Service传递过来的IBinder对象，
             * 通过这个IBinder对象，实现宿主和Service的交互。
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e(TAG, "onServiceConnected");

                BinderService.LocalBinder localBinder = (BinderService.LocalBinder) service;

                myService = localBinder.getMyService();
            }

            /**
             * 当取消绑定的时候被回调。但正常情况下是不被调用的，它的调用时机是当Service服务被意外销毁时，
             * 例如内存的资源不足时这个方法才被自动调用。
             */
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e(TAG, "onServiceDisconnected");

                myService = null;
            }
        };
    }


}