package com.example.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;

/**
 * Description:Messenger服务端简单实例,服务端进程
 */
public class MessengerService extends Service {
    private String TAG = getClass().getSimpleName();
    public static final int MSG_SAY_HELLO = 1;

    public MessengerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind 已调用");
        // TODO: Return the communication channel to the service.
        return messenger.getBinder();
    }

    class ReceiveClientHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Log.e(TAG, "接收到客户端消息: receiver message from client! 内容为==" + msg.obj);

                    //回复消息
                    Messenger replyTo = msg.replyTo;
                    Message message = Message.obtain(null,MSG_SAY_HELLO);
                    Bundle bundle = new Bundle();
                    bundle.putString("serviceReply","服务端回复的消息");
                    message.setData(bundle);
                    try {
                        replyTo.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /**
     * 创建Messenger并传入Handler实例对象
     */
    private Messenger messenger = new Messenger(new ReceiveClientHandler());
}