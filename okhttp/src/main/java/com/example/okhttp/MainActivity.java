package com.example.okhttp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button mGet;
    private Button mPost;
    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHttpClient = new OkHttpClient();

        initViews();


    }

    private void initViews() {
        mGet = findViewById(R.id.get);
        mPost = findViewById(R.id.post);



        mGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      Request request = new Request.Builder().url("https://blog.csdn.net/linchangjian_/article/details/82782397").build();
                      Call call = okHttpClient.newCall(request);
                      //                          Response execute = call.execute();//同步
                      call.enqueue(new Callback() {
                          @Override
                          public void onFailure(Call call, IOException e) {
//                              Log.e("logget", "get: "+e.getMessage());
                          }
                          @Override
                          public void onResponse(Call call, Response response) throws IOException {
                              String s = response.body().toString();
                              Log.e("logget", "onResponse: "+s );

                          }
                      });
//                          String string = execute.body().string();
//                          Log.e("logeget", "onClick: "+string );
                  }
              }).start();

            }
        });

        mPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FormBody formBody = new FormBody.Builder().add("q","1").add("b","2").build();
                        Request request = new Request.Builder().url("https://www.httpbin.org/post").post(formBody).build();
                        Call call = okHttpClient.newCall(request);
                        //                          Response execute = call.execute();//同步
                        call.enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
//                                Log.e("logpost", "post: "+e.getMessage());

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String s = response.body().toString();

                                Log.e("logpost", "onResponse: "+s );
                            }
                        });
//                          String string = execute.body().string();
//                          Log.e("logeget", "onClick: "+string );
                    }
                }).start();

            }
        });
    }

}