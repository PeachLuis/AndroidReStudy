package com.example.luis.androidrestudy.activity.item_activity.custom_layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.luis.androidrestudy.R;


public class TitleLayout extends LinearLayout implements View.OnClickListener {

    public TitleLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        Button back = (Button) findViewById(R.id.title_back);
        Button front = (Button) findViewById(R.id.title_front);

        back.setOnClickListener(this);
        front.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                DoToast("你点击了返回");
            case R.id.title_front:
                DoToast("你点击了前进");
        }
    }

    private void DoToast(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_LONG).show();
    }
}
