package com.example.myandroid;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public class MainActivity extends AppCompatActivity {

    private ImageView mImage;
    private ImageView mImage1;
    private ImageView mImage2;
    private ImageView mImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();


    }

    private void initViews() {
        mImage = findViewById(R.id.image);
        mImage1 = findViewById(R.id.image1);
        mImage2 = findViewById(R.id.image2);
        mImage3 = findViewById(R.id.image3);
        RequestOptions override = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)//
                .error(R.drawable.ic_launcher_background)//error时请求
                .fallback(R.drawable.ic_launcher_background)
                .override(500, 500);//重写大小
        Glide.with(this)
                .load("https://tse3-mm.cn.bing.net/th/id/OIP-C.S3QOsgnlzrpbpAdOXF4YMAHaEo?w=265&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7")
                .apply(override)
                .into(mImage);


        DrawableCrossFadeFactory builder = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();//解决占位符
        Glide.with(this).asBitmap()
                .load("https://tse3-mm.cn.bing.net/th/id/OIP-C.S3QOsgnlzrpbpAdOXF4YMAHaEo?w=265&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7")
                .apply(override)
                //可能出现占位符.transition(BitmapTransitionOptions.withCrossFade(3000))
                .transition(BitmapTransitionOptions.withCrossFade(builder))
                .transform(new CircleCrop())//设置圆形
               // .transform(new GranularRoundedCorners(30,80,80,30))四个角不统一
                //.transform(new RoundedCorners(30))四个角统一
                .into(mImage1);

//注解glide
//        GlideApp.with(this).load("").placeholder();


    }
}