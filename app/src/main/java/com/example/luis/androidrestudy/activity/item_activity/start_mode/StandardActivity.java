package com.example.luis.androidrestudy.activity.item_activity.start_mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

/*
 standard是活动默认的启动模式，在不进行指定情况下，所有活动都采取这种启动方式
 即：每当启动一个新的活动，它就会在返回栈中入栈，并处于栈顶的位置。
 系统不会在乎这个活动是否已经在返回栈中存在，每次启动斗湖创建该活动的一个新的实例
 所以下列例子会在logcat中看到toString的不同显示，即地址不同
 */
public class StandardActivity extends LuisApplication {

    private Button mStandard;

    private static final String TAG = "StandardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_standard);

        initView();
    }

    private void initView() {
        mStandard = (Button) findViewById(R.id.btn_standard);
        mStandard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StandardActivity.this,StandardActivity.class));
            }
        });
    }



}
