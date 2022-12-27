package com.example.broadcast.broadcast;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static String TAG = "MyReceiver";

    /**
     * 事务处理代码
     * 在这里写上相关的处理代码，一般来说，不要此添加过多的逻辑或者是进行任何的耗时操作
     * 因为广播接收器中是不允许开启多线程的，过久的操作就会出现报错
     * 因此广播接收器更多的是扮演一种打开程序其他组件的角色，比如创建一条状态栏通知，或者启动某个服务
     *
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        //截断广播后面的广播收不到此广播
//        abortBroadcast();
        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            Log.e(TAG, "onReceive: 屏幕关闭");
        } else if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Log.e(TAG, "onReceive: 屏幕开启");
            //自定义广播
        } else if (intent.getAction().equals("customBroadcast")) {
            Toast.makeText(context, "接收到自定义广播", Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals("offline")) {
            Toast.makeText(context, "下线", Toast.LENGTH_SHORT).show();
            offlineDialog(context);
        }
    }

    private void offlineDialog(Context context) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ActivityCollect.getStackTopActivity());
//        此处context类型为Application Context
//        因此无法用来调用alertDialog
        alertDialog.setTitle("强制下线");
        alertDialog.setMessage("触发强制下线，点击确定回到起始界面");
        alertDialog.setCancelable(false);//设置取消按钮不可用
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollect.finishAll();
                Intent intent = new Intent(context, BroadcastActivity.class);
                //非Activity的Context都需要启动Activity都需要新建任务栈去放置。不仅仅是广播里面的context
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        alertDialog.show();


    }
}
