package com.example.myandroid.stream;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myandroid.VideoInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Stream {

    public static void main(String[] args) {

    }

    private void initData() {
        ArrayList<VideoInfo> videoList = new ArrayList<>();

        videoList.add(new VideoInfo("路径一", "第一个文件"));
        videoList.add(new VideoInfo("路径二", "第二个文件"));


        videoList.forEach(this::s);
        for (Object o : videoList.toArray()) {
            System.out.println(Arrays.toString(new VideoInfo[]{(VideoInfo) o}));
        }

        //stream转换类型由videoInfo的集合转换成Video类型的集合
        List<Video> collect = videoList.stream().map(videoInfo -> {
            Video video = new Video(videoInfo.getPath(), videoInfo.getName());
            return video;
        }).collect(Collectors.toList());
    }

    private void s(VideoInfo videoInfo) {

    }

    public void s(String s) {
        System.out.println(s);
    }


}
