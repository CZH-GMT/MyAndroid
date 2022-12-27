package com.example.broadcast.broadcast.staticregistbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StaticBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "静态注册的广播-----重启", Toast.LENGTH_SHORT).show();
    }
}
