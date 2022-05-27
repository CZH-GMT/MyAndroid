package com.example.myandroid;

import android.app.ActionBar;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;


public class MainActivity extends AppCompatActivity implements DialogUtil.onViewListener{

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

        Button dialog = findViewById(R.id.dailog);

        dialog.setOnClickListener((v)-> {
            showDialogs();
//
        });

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

    private void showDialogs() {
//        DialogUtil dialogUtil = new DialogUtil(this);
//                dialogUtil.show();
//                new CustomDialog.Builder(MainActivity.this)
        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_dailog, null);

        TextView one = inflate.findViewById(R.id.one);
        TextView two = inflate.findViewById(R.id.two);
        TextView three = inflate.findViewById(R.id.three);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, one.getText() + "", Toast.LENGTH_SHORT).show();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, two.getText() + "", Toast.LENGTH_SHORT).show();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, three.getText() + "", Toast.LENGTH_SHORT).show();
            }
        });
        DialogUtil dialogUtil = new DialogUtil(MainActivity.this, inflate, true, R.style.BoxDialog, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM,this);
        dialogUtil.show();



    }

    @Override
    public void getView(View view) {
        Toast.makeText(this,view.getId()+"hhhhhhhhhhhhhhhhhhhhhhhhhhh" , Toast.LENGTH_SHORT).show();

    }
}