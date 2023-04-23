package com.example.mvp.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter, V extends MainContract.IBaseView> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout(savedInstanceState));

        /**
         * 创建presenter
         */
        presenter = createPresenter();
        //绑定
        presenter.attachView((V) this);

        initView();
        initData();
    }

    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
        presenter.detachView();
    }

    protected abstract void initView();

    protected abstract P createPresenter();

    protected abstract int initLayout(Bundle savedInstanceState);
}
