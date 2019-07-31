package com.example.luis.androidrestudy.activity.item_activity.start_mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

/*
 效果：每次启动该活动时系统时，系统会自动检查返回栈中是否存在该活动的实例，
      如果发现已经存在就直接使用该实例，并且把在这个活动之上的所有活动全部出栈
      如果没有发现就会创建一个新的活动实例
 */
public class SingleTaskActivity extends LuisApplication {

    private Button mSingleTask;

    private static final String TAG = "SingleTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_single_task);

        initView();
    }

    private void initView() {
        mSingleTask = (Button) findViewById(R.id.btn_singleTask);
        mSingleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleTaskActivity.this, StartModeActivity_Base.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
