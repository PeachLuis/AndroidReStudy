package com.example.luis.androidrestudy;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.luis.androidrestudy.utils.ActivityCollectorUtil;

/*
 让所有的活动都继承于这个Application类，这种模式适用于多人协作的项目
 这样每当我们进入一个界面，该活动的类名就会在logcat中打印出来
 */
public class LuisApplication extends AppCompatActivity {

    private static final String TAG = "LuisApplication";

    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        ActivityCollectorUtil.addActivity(this);
        context = getApplicationContext();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtil.removeactivity(this);
    }

    public static Context getContext() {
        return context;
    }
}
