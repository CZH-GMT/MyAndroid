package com.example.broadcast.broadcast;

import android.app.Activity;

import java.util.ArrayList;

public class ActivityCollect {
    public static ArrayList<Activity> activityList = new ArrayList<>();


    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    //返回当前栈顶活动
    public static Activity getStackTopActivity() {
        return activityList.get(activityList.size() - 1);
    }


}
