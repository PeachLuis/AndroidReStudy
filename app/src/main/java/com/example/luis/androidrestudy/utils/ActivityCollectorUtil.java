package com.example.luis.androidrestudy.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/*
 作用：这是一个随时随地退出程序的工具类
 */
public class ActivityCollectorUtil {

    public static List<Activity> activities = new ArrayList<>();

    //添加活动
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    //移除活动
    public static void removeactivity(Activity activity) {
        activities.remove(activity);
    }

    //结束所有活动退出程序
    public static void finishAllActivities() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }

}
