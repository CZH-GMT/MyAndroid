package com.example.service.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Description:绑定服务实例--客户端
 */
public class BinderService extends Service {
    private int count;
    private boolean quit;
    private static final String TAG="MyService";

    public BinderService() {
    }

    private LocalBinder localBinder = new LocalBinder();

    public class LocalBinder extends Binder {
       public BinderService getMyService() {
            return BinderService.this;
        }
    }

    /**
     * 绑定服务时才会调用
     * 必须要实现的方法
     *
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"绑定接口onBind");
        return localBinder;
    }

    /**
     * 首次创建服务时，系统将调用此方法来执行一次性设置程序（在调用 onStartCommand() 或 onBind() 之前）。
     * 如果服务已在运行，则不会调用此方法。该方法只被调用一次
     */
    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate接口");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                }
            }
        });
        thread.start();
        super.onCreate();
    }

    /**
     * 每次通过startService()方法启动Service时都会被回调。
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand  intent="+intent.getExtras()+"flags="+flags+"startId"+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 公共方法
     * @return
     */
    public int getCount(){
        Log.d(TAG,"getCount");
        return count;
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.d(TAG,"bindService");
        return super.bindService(service, conn, flags);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.d(TAG,"unbindService");
        super.unbindService(conn);
    }

    /**
     * 服务销毁时的回调
     */
    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");
        this.quit = true;
        super.onDestroy();

    }
}