package com.example.rxjava;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private String imageurl = "https://img2.baidu.com/it/u=3642339878,2140733972&fm=26&fmt=auto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImage = findViewById(R.id.image);
    }

    public void downloadImage(View view) {

        Observable.just(imageurl)
                .map(new Function<String, Bitmap>() {
                    @Override
                    public Bitmap apply(@NonNull String s) throws Exception {
                        try {
                            URL url = new URL(imageurl);
                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                            int responseCode = urlConnection.getResponseCode();
                            if (responseCode == 200) {
                                InputStream inputStream = urlConnection.getInputStream();
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                return bitmap;
                            }
                        } catch (Exception e) {
                            String message = e.getMessage();
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {

                    private ProgressDialog progressDialog;

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("正在加载");
                        progressDialog.show();
                    }

                    @Override
                    public void onNext(@NonNull Bitmap s) {
                        mImage.setImageBitmap(s);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (progressDialog!=null){
                            progressDialog.dismiss();
                        }

                    }
                });


    }


}