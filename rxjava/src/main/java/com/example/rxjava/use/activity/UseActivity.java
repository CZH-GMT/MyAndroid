package com.example.rxjava.use.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rxjava.R;
import com.example.rxjava.downloadiamge.RxDownImageActivity;
import com.example.rxjava.use.api.WanAndroidApi;
import com.example.rxjava.use.bean.ProjectBean;
import com.example.rxjava.use.bean.ProjectItem;
import com.example.rxjava.use.util.HttpUtil;
import com.jakewharton.rxbinding2.view.RxView;

import java.nio.channels.SelectableChannel;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;

/**
 * TODO 主要是使用场景
 *  1.Retrofit+RxJava查询xxx
 *  2.功能防抖 + 网络嵌套
 */
public class UseActivity extends AppCompatActivity {
    private final static String TAG = UseActivity.class.getSimpleName();

    private WanAndroidApi wanAndroidApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use);

        wanAndroidApi = HttpUtil.getRetrofit().create(WanAndroidApi.class);
    }

    /**
     * TODO Retrofit+RxJava 查询 项目分类  (总数据查询)
     *
     * @param view
     */
    @SuppressLint("CheckResult")
    public void getProjectAction(View view) {
        //获取网络API
        wanAndroidApi.getProject().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProjectBean>() {
                    @Override
                    public void accept(ProjectBean projectBean) throws Exception {
                        Log.d(TAG, "accept: " + projectBean); // UI 可以做事情
                        Toast.makeText(UseActivity.this, "accept: " + projectBean, Toast.LENGTH_SHORT).show();
                    }
                });

    }

    /**
     * TODO Retrofit+RxJava 查询  项目分类的49 去 获取项目列表数据  (Item)
     *
     * @param view
     */
    @SuppressLint("CheckResult")
    public void getProjectListAction(View view) {
        // 注意：这里的 294 是项目分类 所查询出来的数据
        // 上面的项目分类会查询出："id": 294,"id": 402,"id": 367,"id": 323,"id": 314, ...

        // id 写死的
        wanAndroidApi.getProjectItem(1, 294)
                // .....
                .subscribeOn(Schedulers.io()) // 上面 异步
                .observeOn(AndroidSchedulers.mainThread()) // 下面 主线程
                .subscribe(data -> {
                    Log.d(TAG, "getProjectListAction: " + data);
                    Toast.makeText(this, "getProjectListAction: " + data, Toast.LENGTH_SHORT).show();
                });
    }

    /**
     * RxJava
     * RxJs
     * Rxxxxx
     * RxBinding  防抖
     * <p>
     * TODO 功能防抖 + 网络嵌套（这种是负面教程，嵌套的太厉害了）
     * 2层嵌套
     * 6层
     */
    @SuppressLint("CheckResult")
    private void antiShakeActon() {
        // 注意：（项目分类）查询的id，通过此id再去查询(项目列表数据)

        // 对那个控件防抖动？
        Button bt_anti_shake = findViewById(R.id.bt_anti_shake);
        RxView.clicks(bt_anti_shake)
                .throttleFirst(2000, TimeUnit.MILLISECONDS)//两秒钟之内 响应一次
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        wanAndroidApi.getProject().compose(RxDownImageActivity.rxud())
                                .subscribe(new Consumer<ProjectBean>() {
                                    @Override
                                    public void accept(ProjectBean projectBean) throws Exception {
                                        for (ProjectBean.DataBean datum : projectBean.getData()) {
                                            wanAndroidApi.getProjectItem(1, datum.getId())
                                                    .compose(RxDownImageActivity.rxud())
                                                    .subscribe(new Consumer<ProjectItem>() {
                                                        @Override
                                                        public void accept(ProjectItem projectItem) throws Exception {
                                                            Log.d(TAG, "accept: " + projectItem); // 可以UI操作

                                                        }
                                                    });
                                        }
                                    }
                                });
                    }
                });
    }

    /**
     * TODO 功能防抖 + 网络嵌套 (解决嵌套的问题) flatMap
     */
    @SuppressLint("CheckResult")
    private void antiShakeActonUpdate() {
// 注意：项目分类查询的id，通过此id再去查询(项目列表数据)

        // 对那个控件防抖动？
        Button bt_anti_shake = findViewById(R.id.bt_anti_shake);
        RxView.clicks(bt_anti_shake)
                .throttleFirst(2000, TimeUnit.MICROSECONDS)// 2秒钟之内 响应你一次
                .observeOn(Schedulers.io())
                .flatMap(new Function<Object, ObservableSource<ProjectBean>>() {
                    @Override
                    public ObservableSource<ProjectBean> apply(Object o) throws Exception {
                        return wanAndroidApi.getProject();

                    }
                })
                .flatMap(new Function<ProjectBean, ObservableSource<ProjectBean.DataBean>>() {
                    @Override
                    public ObservableSource<ProjectBean.DataBean> apply(ProjectBean projectBean) throws Exception {
                        return Observable.fromIterable(projectBean.getData()); // 我自己搞一个发射器 发多次 10
                    }
                })
                .flatMap(new Function<ProjectBean.DataBean, ObservableSource<ProjectItem>>() {
                    @Override
                    public ObservableSource<ProjectItem> apply(ProjectBean.DataBean dataBean) throws Exception {
                        return wanAndroidApi.getProjectItem(1,dataBean.getId());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ProjectItem>() {
                    @Override
                    public void accept(ProjectItem projectItem) throws Exception {
                        // 如果我要更新UI  会报错2  不会报错1
                        Log.d(TAG, "accept: " + projectItem);
                    }
                });
    }
}