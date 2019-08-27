package com.example.luis.androidrestudy.activity.item_activity.custom_layout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

public class CustomLayout extends LuisApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout);

        //隐藏系统自带acitonbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
