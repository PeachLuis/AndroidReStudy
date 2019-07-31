package com.example.luis.androidrestudy.activity.item_activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class LogActivity extends LuisApplication implements View.OnClickListener{

    private Button mLog_v;
    private Button mLog_d;
    private Button mLog_i;
    private Button mLog_w;
    private Button mLog_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        initView();
    }

    private void initView() {
        mLog_v = (Button) findViewById(R.id.log_v);
        mLog_d = (Button) findViewById(R.id.log_d);
        mLog_i = (Button) findViewById(R.id.log_i);
        mLog_w = (Button) findViewById(R.id.log_w);
        mLog_e = (Button) findViewById(R.id.log_e);

        mLog_v.setOnClickListener(this);
        mLog_d.setOnClickListener(this);
        mLog_i.setOnClickListener(this);
        mLog_w.setOnClickListener(this);
        mLog_e.setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.log_v:
                Log.v("LogActivity", "等级1：verbose,没有什么意义");
                DoToast("Log.v()已完成，快查看logcat吧");
                break;
            case R.id.log_d:
                Log.d("LogActivity", "等级2：debug，比较常用");
                DoToast("Log.d()已完成，快查看logcat吧");
                break;
            case R.id.log_i:
                Log.i("LogActivity", "等级3：info，重要数据，常用");
                DoToast("Log.i()已完成，快查看logcat吧");
                break;
            case R.id.log_w:
                Log.w("LogActivity", "等级4：warm,警告数据");
                DoToast("Log.w()已完成，快查看logcat吧");
                break;
            case R.id.log_e:
                Log.e("LogActivity", "等级5：error，错误，常用于catch语句");
                DoToast("Log.e()已完成，快查看logcat吧");
                break;
            default:
                break;
        }
    }

    private void DoToast(String str) {
        Toast.makeText(LogActivity.this,str,Toast.LENGTH_LONG).show();
    }
}
