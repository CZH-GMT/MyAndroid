package com.example.broadcast.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.example.broadcast.R;

public class OfflinTextActivity extends BaseActivity {

    private Button offlines;
    private MyReceiver myReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offlin_text);
        initView();

        myReceiver = new MyReceiver();
    }

    private void initView() {
        offlines = (Button) findViewById(R.id.offlines);

        offlines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送本地广播的时候会因为context类型不同导致无法弹窗
                localBroadcastManager = LocalBroadcastManager.getInstance(OfflinTextActivity.this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("offline");
                localBroadcastManager.registerReceiver(myReceiver, intentFilter);
                Intent intent = new Intent("offline");
                localBroadcastManager.sendBroadcast(intent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myReceiver);
    }
}