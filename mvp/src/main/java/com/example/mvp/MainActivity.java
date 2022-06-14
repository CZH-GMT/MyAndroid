package com.example.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.present.Present;
import com.example.mvp.view.ViewInterface;

public class MainActivity<T> extends AppCompatActivity implements ViewInterface<T> {

    private Button mRandom;
    private Present<T> objectPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        objectPresent = new Present<T>(this);

    }

    private void initViews() {
        mRandom = findViewById(R.id.random);
        mRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               objectPresent.getModeData();
            }
        });
    }

    @Override
    public void success(T t) {
        Toast.makeText(this, "成功"+t, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failed(String code) {
        Toast.makeText(this, "失败"+code, Toast.LENGTH_SHORT).show();

    }


}