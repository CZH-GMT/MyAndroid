package com.example.anotation.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.anotation.finviewidanotation.InjectView;
import com.example.anotation.intentanotation.Autowired;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.temporal.ValueRange;
import java.util.Arrays;

public class InjectUtils {

    //finViewId
    public static void InitViewId(Activity activity) {
        //获取类
        Class<? extends Activity> aClass = activity.getClass();
        //获取成员属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //判断是否使用此注解
            if (field.isAnnotationPresent(InjectView.class)) {
                //获取注解
                InjectView annotation = field.getAnnotation(InjectView.class);
                //获取注解value
                int value = annotation.value();
                //找控件
                View id = activity.findViewById(value);
                //成员设置访问权限
                field.setAccessible(true);
                //反射赋值
                try {
                    field.set(activity, id);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //接受Intent传值
    public static void injectIntent(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        Intent intent = activity.getIntent();
        Bundle extras = intent.getExtras();

        if (extras == null) {
            return;
        }
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Autowired annotation = field.getAnnotation(Autowired.class);
                String key = TextUtils.isEmpty(annotation.value()) ? field.getName() : annotation.value();
                if (extras.containsKey(key)) {
                    // todo Parcelable数组类型不能直接设置，其他的都可以.
                    //获得数组单个元素类型
                    Object value = extras.get(key);
                    //获取类型
                    Class<?> componentType = field.getType().getComponentType();
                    //当前属性是数组并且是 Parcelable（子类）数组
                    if (field.getType().isArray() && Parcelable.class.isAssignableFrom(componentType)) {
                        Object[] objects = (Object[]) value;
                        //创建对应类型的数组并用objects进行拷贝
                        Object[] objects1 = Arrays.copyOf(objects, objects.length, (Class<? extends Object[]>) field.getType());
                        value = objects1;
                    }


                    field.setAccessible(true);
                    try {
                        field.set(activity, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }


            }
        }


    }
}
