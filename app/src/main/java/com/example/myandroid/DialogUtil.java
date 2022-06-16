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
    private int width, height, gravity;
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

    public DialogUtil(@NonNull Context context, View view, boolean isOutsideClose, int dialogStyle, int width, int height, int gravity, onViewListener onViewListener) {
        super(context, dialogStyle);
        this.onViewListener = onViewListener;
        this.view = view;
        this.isOutsideClose = isOutsideClose;
        this.dialogStyle = dialogStyle;
        this.width = width;
        this.height = height;
        this.gravity = gravity;
        onViewListener.getView(view);
    }

    public DialogUtil(Builder builder) {
        super(builder.context, builder.dialogStyle);
        this.onViewListener = builder.onViewListener;
        this.view = builder.view;
        this.isOutsideClose = builder.isOutsideClose;
        this.dialogStyle = builder.dialogStyle;
        this.width = builder.width;
        this.height = builder.height;
        this.gravity = builder.gravity;
        onViewListener.getView(builder.view);
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

    public static class Builder {
        //宽高
        private int width, height, gravity;
        //dialog style
        private int dialogStyle;
        //显示view
        private View view;
        //点击弹窗外面是否关闭
        private boolean isOutsideClose;
        //上下文
        private Context context;
        //控件监听返回view
        public onViewListener onViewListener;

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder context(Context context) {
            this.context = context;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder gravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder dialogStyle(int dialogStyle) {
            this.dialogStyle = dialogStyle;
            return this;
        }

        public Builder view(View view) {
            this.view = view;
            return this;
        }

        public Builder isOutsideClose(boolean isOutsideClose) {
            this.isOutsideClose = isOutsideClose;
            return this;
        }

        public Builder onViewListener(onViewListener onViewListener) {
            this.onViewListener = onViewListener;
            return this;
        }

        public DialogUtil builder() {
            return new DialogUtil(this);
        }

    }
}
