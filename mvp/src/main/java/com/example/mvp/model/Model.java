package com.example.mvp.model;

import java.util.Random;

public class Model implements ModelInterface {


    @Override
    public void data(Callback callback) {
        Random random = new Random();
        boolean b = random.nextBoolean();

        if (b) {
            callback.success("成功" + b);
        } else {
            callback.failed("失败" + b);
        }
    }
}
