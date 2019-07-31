package com.example.luis.androidrestudy.activity.item_activity.start_mode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

/*
 该启动模式需要在AndroidManifest中声明android：launchMode = "singleTop"
 效果：在启动活动时如果发现返回栈的栈顶已经是该活动，则认为可以直接使用它，不会再创建新的活动实例
 缺点：在下面的例子当中，如果不是在栈顶，SingleTopActivity会被创建2次
 */
public class SingleTopActivity extends LuisApplication {

    private Button mSingleTop;
    private Button mSingleTop_plus;

    private static final String TAG = "SingleTopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        setContentView(R.layout.activity_single_top);

        initView();
    }

    private void initView() {
        mSingleTop = (Button) findViewById(R.id.btn_singleTop);
        mSingleTop_plus = (Button) findViewById(R.id.btn_aplus_singleTop);

        mSingleTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleTopActivity.this, SingleTopActivity.class));
            }
        });
        mSingleTop_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SingleTopActivity.this, StartModeActivity_Base.class));
            }
        });
    }

}
