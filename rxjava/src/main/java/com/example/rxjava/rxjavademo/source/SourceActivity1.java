package com.example.rxjava.rxjavademo.source;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * TODO RxJava Hook 点
 */
public class SourceActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
        // 我想用了多少给 Map操作   flatMap
        // Hook之前的监听
        RxJavaPlugins.setOnObservableAssembly(new Function<Observable, Observable>() {
            @Override
            public Observable apply(Observable observable) throws Exception {
                Log.d(Flag.TAG, "apply: 整个项目 全局 监听 到底有多少地方使用 RxJava:" + observable);

                // 伪代码
                /*if (observable  === ObservableMap)
                    return null;*/

                return null; // 不破坏人家的功能
            }
        });

        testHook();
    }

    /**
     * TODO RxJava Hook 点
     */
    @SuppressLint("CheckResult")
    public static void testHook() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) throws Exception {
                e.onNext("A");
            }
        })

                // null.map
        .map(new Function<Object, Boolean>() {
            @Override
            public Boolean apply(Object o) throws Exception {
                return true;
            }
        })

        .subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {

            }
        })   ;
    }
}
