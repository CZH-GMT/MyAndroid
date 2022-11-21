package com.example.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.service.service.MessengerService;


public class MessengerActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private Button mBind;
    private Button mSendmsgtoservice;
    private Button mUnbind;
    private boolean isConnect = false;
    private Messenger receiverMessenger = new Messenger(new ReceiveHandler());

    private static class ReceiveHandler extends Handler {
        private String TAG = getClass().getSimpleName();

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MessengerService.MSG_SAY_HELLO:
                Log.e(TAG, "收到服务器回复的消息receiver message from service:" + msg.getData().getString("serviceReply"));
                break;
            }
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        initViews();
    }

    private void initViews() {
        mBind = findViewById(R.id.bind);
        mSendmsgtoservice = findViewById(R.id.sendMsgToService);
        mUnbind = findViewById(R.id.unBind);
        Intent intent = new Intent(this, MessengerService.class);
        mBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log("绑定");
                bindService(intent, serviceConnection, Service.BIND_AUTO_CREATE);
                isConnect = true;
            }
        });

        mSendmsgtoservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsgToService();

            }
        });
        mUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnect) {
                    log("解绑");
                    unbindService(serviceConnection);
                    isConnect = false;
                } else {
                    log("请先绑定");
                }
            }
        });
    }

    /**
     * 发送消到服务端
     */
    private void sendMsgToService() {
        if (isConnect) {
            log("客户端发送消息到service");
            // 创建与服务交互的消息实体Message
            Message obtain = Message.obtain();
            obtain.what = MessengerService.MSG_SAY_HELLO;
            obtain.obj = "这是客户端发送的消息";
            //把接收服务器端的回复的Messenger通过Message的replyTo参数传递给服务端
            obtain.replyTo=receiverMessenger;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            log("连接中断");
        }
    }

    private Messenger messenger;
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            /**
             * 通过服务端传递的IBinder对象,创建相应的Messenger
             * 通过该Messenger对象与服务端进行交互
             */
            log("连接到服务端");
            messenger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            isConnect = false;

        }
    };

    private void log(String s) {
        Log.e(TAG, s);
    }


}