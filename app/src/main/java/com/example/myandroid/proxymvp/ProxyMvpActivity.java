package com.example.myandroid.proxymvp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroid.R;


public class ProxyMvpActivity extends AppCompatActivity implements IViewInterface {

    private ProxyPresenter proxyPresenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_mvp);

        textView = findViewById(R.id.texts);

        proxyPresenter = new ProxyPresenter( this);
        proxyPresenter.getData();
    }

    @Override
    public void showData(String data) {
        textView.setText(data);
    }
}