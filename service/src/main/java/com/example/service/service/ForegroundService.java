package com.example.service.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.myapplication2.R;

/**
 * Description:启动前台服务Demo
 */
public class ForegroundService extends Service {
    /**
     * id不可设置为0,否则不能设置为前台service
     */
    private static final int NOTIFICATION_DOWNLOAD_PROGRESS_ID = 0x0001;

    private boolean isRemove = false;//是否需要移除

    /**
     * Notification
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotification() {
        //使用兼容版本
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        //设置状态栏的通知图标
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //设置通知栏横条的图标
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background));
        //禁止用户点击删除按钮删除
        builder.setAutoCancel(false);
        //禁止滑动删除
        builder.setOngoing(false);
        //右上角的时间显示
        builder.setShowWhen(true);

        //设置通知栏的标题内容
        builder.setContentTitle("I am Foreground Service!!!");
        //不写这几行崩溃
        builder.setChannelId("notification_id");
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("notification_id", "notification_name", NotificationManager.IMPORTANCE_LOW);
        notificationManager.createNotificationChannel(channel);
        //创建通知
        Notification notification = builder.build();
        //设置为前台服务
        startForeground(NOTIFICATION_DOWNLOAD_PROGRESS_ID, notification);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int cmd = intent.getExtras().getInt("cmd");
        if (cmd == 0) {
            if (!isRemove) {
                createNotification();
            }
            isRemove = true;
        } else {
            if (isRemove) {
                stopForeground(true);
            }
            isRemove=false;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (isRemove){
            stopForeground(true);
        }
        isRemove=false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}