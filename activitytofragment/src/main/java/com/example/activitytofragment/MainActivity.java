package com.example.activitytofragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private Button mBtn2;
    private FrameLayout mFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            initViews();

    }

    private void initViews() {
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn2 = findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mFl = findViewById(R.id.fl);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                Bundle bundle = new Bundle();
                bundle.putString("message","avtivity--发送到--fragment");
                BlankFragment blankFragment = new BlankFragment();
                blankFragment.setArguments(bundle);
                Toast.makeText(this, "activity消息已发送", Toast.LENGTH_SHORT).show();
                replacefragment(blankFragment);
                break;
            case R.id.btn2:

                replacefragment(new ItemFragment());
                break;


        }

    }

    private void replacefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl, fragment)
              //添加到任务栈中 .addToBackStack(null)
                .commit();

    }
}