package com.example.luis.androidrestudy.activity.item_activity.start_mode;

import android.os.Bundle;
import android.util.Log;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class StartModeActivity_Base extends LuisApplication {

    private static final String TAG = "StartModeActivity_Base";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_single_top_aplus);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
