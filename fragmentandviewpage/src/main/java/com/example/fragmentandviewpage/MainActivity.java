package com.example.fragmentandviewpage;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager2 mVp2;

    private ImageView imagme;
    private ImageView imagfx;
    private ImageView imaglxr;
    private ImageView imagwx;
    private ImageView isselect;

    private LinearLayout tablxr, tabwx, tabme, tabfx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initTabView();
    }

    private void initTabView() {

        imagme = findViewById(R.id.imagme);
        imagme.setOnClickListener(this);
        imagfx = findViewById(R.id.imagfx);
        imagfx.setOnClickListener(this);
        imaglxr = findViewById(R.id.imaglxr);
        imaglxr.setOnClickListener(this);
        imagwx = findViewById(R.id.imagwx);
        imagwx.setOnClickListener(this);


        tabfx = findViewById(R.id.tabfx);
        tabfx.setOnClickListener(this);
        tablxr = findViewById(R.id.tablxr);
        tablxr.setOnClickListener(this);
        tabwx = findViewById(R.id.tabwx);
        tabwx.setOnClickListener(this);
        tabme = findViewById(R.id.tabme);
        tabme.setOnClickListener(this);


        imagwx.setSelected(true);
        isselect = imagwx;
    }

    private void initViews() {
        mVp2 = findViewById(R.id.vp2);


        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("微信聊天"));
        fragments.add(BlankFragment.newInstance("通讯录"));
        fragments.add(BlankFragment.newInstance("发现"));
        fragments.add(BlankFragment.newInstance("我"));

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), getLifecycle(), fragments);
        mVp2.setAdapter(myFragmentAdapter);


        mVp2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });


    }

    private void changeTab(int position) {
        isselect.setSelected(false);
        switch (position) {
            case 0:
                imagwx.setSelected(true);
                isselect=imagwx;
                break;
            case 1:
                imaglxr.setSelected(true);
                isselect=imaglxr;
                break;
            case 2:
                imagfx.setSelected(true);
                isselect=imagfx;
                break;
            case 3:
                imagme.setSelected(true);
                isselect=imagme;
                break;

        }

    }

    @Override
    public void onClick(View v) {

    }
}