package com.example.rxjava.rxjavademo.demo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

// TODO 上节课后 有同学问我的问题
public class RxJavaDemo extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // RxAndroid有什么用
    @SuppressLint("CheckResult")
    private void test00() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("A");
            }
        })
        .observeOn(Schedulers.io()) // java
        .subscribeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        })
        ;
    }

    private void test01() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {}
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(String s) {}

            @Override
            public void onError(Throwable e) {}

            @Override
            public void onComplete() {}
        });


        // ---

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {}
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {}
        });
    }

    private void test02() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("Derry");
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null)
            if (!disposable.isDisposed())
                disposable.dispose();
    }
}
