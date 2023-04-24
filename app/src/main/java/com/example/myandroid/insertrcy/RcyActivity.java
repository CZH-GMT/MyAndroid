package com.example.myandroid.insertrcy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroid.R;

import java.util.ArrayList;

public class RcyActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rcy);

        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            list.add("哈哈" + i);
        }
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(list, this);
        View addview = LayoutInflater.from(this).inflate(R.layout.layout_addview,recyclerview,false);
        myAdapter.rcyAddView(28, addview);
        recyclerview.setAdapter(myAdapter);


    }
}