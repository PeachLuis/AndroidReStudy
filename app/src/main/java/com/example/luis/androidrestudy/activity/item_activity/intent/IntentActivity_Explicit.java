package com.example.luis.androidrestudy.activity.item_activity.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class IntentActivity_Explicit extends LuisApplication {

    private TextView mTextView_intent_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__explicit);

        initView();
    }

    private void initView() {
        mTextView_intent_data = (TextView) findViewById(R.id.text_intent_data);

        /*
         这里的数据是一个String，所以使用getStringExtra，通过key拿到数据
         */
        Intent intent = getIntent();
        final String gotData = intent.getStringExtra("editText_data");

        /*
         更新UI放在一个新的线程中更新
         */
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTextView_intent_data.setText(gotData);
            }
        });
    }
}
