package com.example.myandroid;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity implements DialogUtil.onViewListener {

    private ImageView mImage;
    private ImageView mImage1;
    private ImageView mImage2;
    private ImageView mImage3;
    private View inflate;
    private Button rcyadv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_dailog, null);
        initViews();
        judgeScreenDirection();


    }

    private void judgeScreenDirection() {
        //判断横竖屏方向
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Log.i("info", "landscape"); // 横屏

        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            Log.i("info", "portrait"); // 竖屏

        }
    }

    private void initViews() {
        mImage = findViewById(R.id.image);
        mImage1 = findViewById(R.id.image1);
        mImage2 = findViewById(R.id.image2);
        mImage3 = findViewById(R.id.image3);
        rcyadv = findViewById(R.id.rcyadv);


        rcyadv.setOnClickListener((v) -> {
            startActivity(new Intent(MainActivity.this,RcyActivity.class));
        });


        Button dialog = findViewById(R.id.dailog);
        Button dialogBuilder = findViewById(R.id.dialogBuilder);
        dialog.setOnClickListener((v) -> {
            showDialogs();
//
        });
        dialogBuilder.setOnClickListener((v) -> {
            showDialogBuilder();
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

    }

    private void showDialogBuilder() {
        DialogUtil builder = new DialogUtil.Builder()
                .context(this)
                .isOutsideClose(true)
                .dialogStyle(R.style.BoxDialog)
                .onViewListener(this)
                .gravity(Gravity.CENTER)
                .height(ActionBar.LayoutParams.WRAP_CONTENT)
                .width(ActionBar.LayoutParams.MATCH_PARENT)
                .view(inflate)
                .builder();
        builder.show();


    }

    private void showDialogs() {


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
        DialogUtil dialogUtil = new DialogUtil(MainActivity.this, inflate, true, R.style.BoxDialog, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM, this);
        dialogUtil.show();


    }

    @Override
    public void getView(View view) {
        Toast.makeText(this, view.getId() + "回调View", Toast.LENGTH_SHORT).show();

    }

    //中文英文排序 英文在中文的的后面
    private void extracted() {
        ArrayList<String> peopleName = new ArrayList<>();
        peopleName.add("adsdfdfdf");
        peopleName.add("aaewrtgdty");
        peopleName.add("丽莎");
        peopleName.add("马克");
        peopleName.add("安德烈");
        peopleName.add("fytyuyuiyuiui");
        peopleName.add("菲尔");
        peopleName.add("bsdsd");
        peopleName.add("byutrftry");
        peopleName.add("梅根");
        peopleName.add("卡特琳娜");
        peopleName.add("奥利弗");
        peopleName.add("瑞安");
        peopleName.add("不好吃");
        peopleName.add("埃米莉");
        peopleName.add("尼古拉斯");
        peopleName.add("fdsfdf");
        peopleName.add("rfdffg");
        peopleName.add("不因楼");

        for (int i = 0; i < peopleName.size(); i++) {
            String str = peopleName.get(i);
            if (str.length() == 0)
                return;
            String alphabet = str.substring(0, 1);
            /*判断首字符是否为中文，如果是中文便将首字符拼音的首字母和&符号加在字符串前面*/
            if (alphabet.matches("[\\u4e00-\\u9fa5]+")) {
                str = getAlphabet(str) + "&" + str;
                peopleName.set(i, str);
            }
        }

        Collections.sort(peopleName, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        /*遍历数组，去除标识符&及首字母*/
        for (int i = 0; i < peopleName.size(); i++) {
            String str = peopleName.get(i);
            if (str.contains("&") && str.indexOf("&") == 1) {
                peopleName.set(i,str.split("&")[1]) ;
            }
            System.out.println(peopleName.get(i));
        }
    }
    public static String getAlphabet(String str) {
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出拼音全部小写
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 不带声调
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String pinyin = null;
        try {
            pinyin = (String) PinyinHelper.toHanyuPinyinStringArray(str.charAt(0), defaultFormat)[0];
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return pinyin.substring(0, 1);
    }

}