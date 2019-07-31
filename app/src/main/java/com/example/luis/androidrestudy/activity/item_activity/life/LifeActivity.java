package com.example.luis.androidrestudy.activity.item_activity.life;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class LifeActivity extends LuisApplication implements View.OnClickListener{

    private Button mNomalActivity;
    private Button mDialogActivity;

    private static final String TAG = "LifeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_life);

        /*
         恢复临时数据
         */
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }

        initView();
    }

    /*
     保存临时数据
     使用Bundle保存和取出数据完全类似于Intent
     注：Intent可以和Bundle结合使用，将数据存放在Bundle当中，然后用Intent来传Intent即可
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "这里是保存的临时数据";
        outState.putString("data_key",tempData);
    }

    private void initView() {
        mNomalActivity = (Button) findViewById(R.id.start_normal_activity);
        mDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        mNomalActivity.setOnClickListener(this);
        mDialogActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_normal_activity:
                startActivity(new Intent(LifeActivity.this, NormalActivity.class));
                break;
            case R.id.start_dialog_activity:
                startActivity(new Intent(LifeActivity.this, DialogActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
