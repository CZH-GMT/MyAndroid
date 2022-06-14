package com.example.anotation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anotation.bean.UserParcelable;
import com.example.anotation.bean.UserSerializable;
import com.example.anotation.finviewidanotation.InjectView;
import com.example.anotation.util.InjectUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.text1)
    TextView text1;
    @InjectView(R.id.text2)
    TextView text2;
    @InjectView(R.id.text3)
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.InitViewId(MainActivity.this);
        text1.setText("text1");
        text2.setText("text2");
        text3.setText("text3");


        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<UserParcelable> userParcelableList = new ArrayList<>();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class)
                        .putExtra("name", "Lance")
                        .putExtra("attr","帅")
                        .putExtra("array", new int[]{1, 2, 3, 4, 5, 6})
                        .putExtra("userParcelable", new UserParcelable("Lance"))
                        .putExtra("userParcelables", new UserParcelable[]{new UserParcelable("Alvin")})
                        .putExtra("users",new UserSerializable[]{new UserSerializable("Jett")})
                        .putExtra("strs",new String[]{"1","2"})
                        .putParcelableArrayListExtra("userParcelableList", userParcelableList);
                startActivity(intent);
            }
        });

    }

}