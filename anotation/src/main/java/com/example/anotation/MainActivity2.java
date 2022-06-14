package com.example.anotation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.anotation.bean.UserParcelable;
import com.example.anotation.bean.UserSerializable;
import com.example.anotation.intentanotation.Autowired;
import com.example.anotation.util.InjectUtils;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    int i, j;
    String k;

    @Autowired()
    String name;

    @Autowired("attr")
    String attr;

    @Autowired
    int[] array;

    @Autowired
    UserParcelable userParcelable;

    @Autowired
    UserParcelable[] userParcelables;

    @Autowired
    List<UserParcelable> userParcelableList;

    @Autowired("users")
    UserSerializable[] userSerializables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        InjectUtils.injectIntent(MainActivity2.this);
        System.out.println(toString());
        Toast.makeText(this, toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public String toString() {
        return "MainActivity2{" +
                "i=" + i +
                ", j=" + j +
                ", k='" + k + '\'' +
                ", name='" + name + '\'' +
                ", attr='" + attr + '\'' +
                ", array=" + Arrays.toString(array) +
                ", userParcelable=" + userParcelable +
                ", userParcelables=" + Arrays.toString(userParcelables) +
                ", userParcelableList=" + userParcelableList +
                ", userSerializables=" + Arrays.toString(userSerializables) +
                '}';
    }
}