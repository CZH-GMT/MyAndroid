package com.example.myandroid;

import android.graphics.Bitmap;

public class VideoInfo {

    //封面
    private Bitmap cover;
    //标题
    private String title;
    //资源地址
    private String path;
    //文件名称
    private String name;

    private long size;
    //视频时长
    private String duration;
    //展示类型
    private String showType;
    //分组id
    private int itemId;
    //是否选中
    private boolean isCheck;

    public VideoInfo() {
    }

    public VideoInfo(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public VideoInfo(Bitmap cover, String title, String path, String name, long size, String duration, String showType, int itemId, boolean isCheck) {
        this.cover = cover;
        this.title = title;
        this.path = path;
        this.name=name;
        this.size = size;
        this.duration = duration;
        this.showType = showType;
        this.itemId = itemId;
        this.isCheck = isCheck;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getCover() {
        return cover;
    }

    public void setCover(Bitmap cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}