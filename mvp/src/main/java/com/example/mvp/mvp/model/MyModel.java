package com.example.mvp.mvp.model;

import android.util.Log;


import com.example.mvp.mvp.base.MainContract;

import java.util.Random;

public class MyModel implements MainContract.IBaseModel {
    @Override
    public void LoadData(onResponseCallBack onResponseCallBack) {
        Random random = new Random();
        boolean b = random.nextBoolean();
        Log.e("MyModel", "LoadData: nextBoolean" + b);
        if (b) {
            onResponseCallBack.success("成功" + b);
        } else {
            onResponseCallBack.showError("失败" + b);
        }

    }
}
