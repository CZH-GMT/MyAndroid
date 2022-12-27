package com.example.broadcast.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "另一个接收器也接收到了", Toast.LENGTH_SHORT).show();
    }
}
