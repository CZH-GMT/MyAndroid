package com.example.rxjava.use.api;

import com.example.rxjava.use.bean.ProjectBean;
import com.example.rxjava.use.bean.ProjectItem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WanAndroidApi {
    //总数居
    @GET("project/tree/json")
    Observable<ProjectBean> getProject();

    //item数据
    @GET("project/list/{pageIndex}/json")//?cid=294
    Observable<ProjectItem> getProjectItem(@Path("pageIndex") int pageIndex, @Query("cid") int cid);

}
