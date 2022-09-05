package com.example.rxjava.downloadiamge;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjava.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxDownImageActivity extends AppCompatActivity {
    // 打印logcat日志的标签
    private static final String TAG = RxDownImageActivity.class.getSimpleName();

    // 网络图片的链接地址
    private final static String PATH = "http://pic1.win4000.com/wallpaper/c/53cdd1f7c1f21.jpg";
    private ImageView image;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_down_image);
        initViews();
    }

    private void initViews() {
        image = findViewById(R.id.image);
    }

    /**
     * 封装我们的操作
     * Rx切换线程
     */
    public final static <UD> ObservableTransformer<UD, UD> rxud() {
        return new ObservableTransformer<UD, UD>() {
            @Override
            public ObservableSource<UD> apply(Observable<UD> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Function<UD, UD>() {
                            @Override
                            public UD apply(UD ud) throws Exception {
                                Log.d(TAG, "apply: 我监听到你了，居然再执行");
                                return ud;
                            }
                        });
            }
        };
    }

    //传统思维
    public void downloadImageAction(View view) {
        progressDialog = new ProgressDialog(RxDownImageActivity.this);
        progressDialog.setTitle("图片下载中-----");
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(PATH);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                        Message message = handler.obtainMessage();
                        message.obj = bitmap;
                        handler.sendMessage(message);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            image.setImageBitmap(bitmap);
            if (progressDialog == null) progressDialog.dismiss();
            return false;
        }
    });

    //Rx思维
    @SuppressLint("CheckResult")
    public void rxJavaDownloadImageAction(View view) {
        Observable.just(PATH)
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(String s) throws Exception {
                        URL url = new URL(PATH);
                        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                        int responseCode = urlConnection.getResponseCode();
                        if (responseCode == HttpURLConnection.HTTP_OK) {
                            InputStream inputStream = urlConnection.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            return bitmap;
                        }
                        return null;
                    }
                })
                //加水印
                /*.map(new Function<Bitmap, Bitmap>() {
           @Override
           public Bitmap apply(Bitmap bitmap) throws Exception {
               Paint paint = new Paint();
               paint.setTextSize(88);
               paint.setColor(Color.RED);
               return drawTextToBitmap(bitmap, "同学们大家好",paint, 88 , 88);
           }
       })*/
                //日志记录
                .map(new Function<Bitmap, Bitmap>() {
                    @Override
                    public Bitmap apply(Bitmap bitmap) throws Exception {
                        Log.d(TAG, "apply: 是这个时候下载了图片啊:" + System.currentTimeMillis());
                        return bitmap;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {
                    //订阅开始
                    @Override
                    public void onSubscribe(Disposable d) {
                        // 预备 开始 要分发
                        // TODO 第一步
                        progressDialog = new ProgressDialog(RxDownImageActivity.this);
                        progressDialog.setTitle("download run");
                        progressDialog.show();
                    }

                    //拿到事件
                    @Override
                    public void onNext(Bitmap bitmap) {
                        image.setImageBitmap(bitmap);
                    }

                    //错误事件
                    @Override
                    public void onError(Throwable e) {

                    }

                    //完成事件
                    @Override
                    public void onComplete() {
                        if (progressDialog != null)
                            progressDialog.dismiss();

                    }
                });
    }

    // 图片上绘制文字 加水印
    private final Bitmap drawTextToBitmap(Bitmap bitmap, String text, Paint paint, int paddingLeft, int paddingTop) {
        Bitmap.Config bitmapConfig = bitmap.getConfig();

        paint.setDither(true); // 获取跟清晰的图像采样
        paint.setFilterBitmap(true);// 过滤一些
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bitmap);

        canvas.drawText(text, paddingLeft, paddingTop, paint);
        return bitmap;
    }
}