package com.example.luis.androidrestudy.activity.item_activity.intent;

import android.content.Intent;
import android.os.Bundle;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class IntentActivity_Implicit extends LuisApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__implicit);
    }

    /*
     重写按返回键后的逻辑处理
     这里setResult()第一个参数为返回码，第二个参数为intent
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "我是返回到IntentActivity的数据");
        setResult(RESULT_OK, intent);
        finish();
    }
}
