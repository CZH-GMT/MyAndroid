package com.example.myandroid;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;

public class DialogUtil extends Dialog {


    //宽高
    private int width, height,gravity;
    //dialog style
    private int dialogStyle;
    //显示view
    private View view;
    //点击弹窗外面是否关闭
    private boolean isOutsideClose;

    //控件监听返回view
    public onViewListener onViewListener;

    public interface onViewListener {
        void getView(View view);
    }

    public DialogUtil(@NonNull Context context, View view, boolean isOutsideClose, int dialogStyle, int width, int height,int gravity, onViewListener onViewListener) {
        super(context, dialogStyle);
        this.onViewListener=onViewListener;
        this.view = view;
        this.isOutsideClose = isOutsideClose;
        this.dialogStyle = dialogStyle;
        this.width = width;
        this.height = height;
        this.gravity=gravity;
        onViewListener.getView(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);

        setCanceledOnTouchOutside(isOutsideClose);
        //设置宽高
        Window window = getWindow();
        window.setWindowAnimations(R.style.dialogAnim);
        window.setGravity(gravity);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = width;
        attributes.height = height;
        window.setAttributes(attributes);

    }
}
