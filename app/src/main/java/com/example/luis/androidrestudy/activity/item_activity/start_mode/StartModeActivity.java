package com.example.luis.androidrestudy.activity.item_activity.start_mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.activity.item_activity.start_mode.singleInstance.SingleInstanceActivity;

public class StartModeActivity extends LuisApplication implements View.OnClickListener{

    private Button mStandard;
    private Button mSingleTop;
    private Button mSingleTask;
    private Button mSingleInstance;

    private static final String TAG = "StartModeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_start_mode);

        initView();

    }

    private void initView() {
        mStandard = (Button) findViewById(R.id.start_standard);
        mSingleTop = (Button) findViewById(R.id.start_singleTop);
        mSingleTask = (Button) findViewById(R.id.start_singleTask);
        mSingleInstance = (Button) findViewById(R.id.start_singleInstance);

        mStandard.setOnClickListener(this);
        mSingleTop.setOnClickListener(this);
        mSingleTask.setOnClickListener(this);
        mSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_standard:
                startActivity(new Intent(StartModeActivity.this, StandardActivity.class));
                break;
            case R.id.start_singleTask:
                startActivity(new Intent(StartModeActivity.this, SingleTaskActivity.class));
                break;
            case R.id.start_singleTop:
                startActivity(new Intent(StartModeActivity.this, SingleTopActivity.class));
                break;
            case R.id.start_singleInstance:
                startActivity(new Intent(StartModeActivity.this, SingleInstanceActivity.class));
                break;
            default:
                break;
        }
    }
}
