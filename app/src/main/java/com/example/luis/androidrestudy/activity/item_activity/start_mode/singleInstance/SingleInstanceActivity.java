package com.example.luis.androidrestudy.activity.item_activity.start_mode.singleInstance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

/*
 效果：指定了SingleInstance的活动会使用一个新的返回栈来管理活动
      可以实现多程序的共享活动室里
 */
public class SingleInstanceActivity extends LuisApplication {

    private Button mSingleInstance;

    private static final String TAG = "SingleInstanceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_single_instance);

        initView();
    }

    private void initView() {
        mSingleInstance = (Button) findViewById(R.id.btn_singleInstance);
        mSingleInstance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleInstanceActivity.this, Activity_1.class));
            }
        });
    }
}
