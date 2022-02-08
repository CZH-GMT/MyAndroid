package com.example.myandroid;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.request.BaseRequestOptions;

@GlideModule
public class MyGlide extends AppGlideModule {
    public MyGlide() {
    }


    @GlideOption
    public  static BaseRequestOptions<?> defaultImg(BaseRequestOptions<?> options){
        return options.placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background);
    }
}
