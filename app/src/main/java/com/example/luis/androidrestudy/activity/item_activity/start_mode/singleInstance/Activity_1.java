package com.example.luis.androidrestudy.activity.item_activity.start_mode.singleInstance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class Activity_1 extends LuisApplication {

    private Button mBtn;

    private static final String TAG = "Activity_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.activity_1);

        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn_activity1);

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_1.this, Activity_2.class));
            }
        });
    }
}
