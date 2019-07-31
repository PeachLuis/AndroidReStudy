package com.example.luis.androidrestudy.activity.item_activity.start_mode.singleInstance;

import android.os.Bundle;
import android.util.Log;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class Activity_2 extends LuisApplication {

    private static final String TAG = "Activity_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_2);
    }
}
