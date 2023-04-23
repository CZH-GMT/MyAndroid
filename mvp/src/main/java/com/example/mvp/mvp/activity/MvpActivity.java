package com.example.mvp.mvp.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp.R;
import com.example.mvp.mvp.base.BaseActivity;
import com.example.mvp.mvp.base.MainContract;
import com.example.mvp.mvp.presenter.MyPresenter;


public class MvpActivity extends BaseActivity<MyPresenter, MainContract.IView> implements MainContract.IView {


    private TextView textView;

    @Override
    protected void initData() {
        presenter.loadData();
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.text1);
        textView.setOnClickListener(v -> presenter.loadData());
    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
    }

    @Override
    protected int initLayout(Bundle savedInstanceState) {
        return R.layout.activity_mvp;
    }

    @Override
    public void showError(String error) {
        textView.setText(error);
    }

    @Override
    public void showData(String data) {
        textView.setText(data);
    }

    @Override
    public void showProcess() {

    }

    @Override
    public void hitProcess() {

    }
}