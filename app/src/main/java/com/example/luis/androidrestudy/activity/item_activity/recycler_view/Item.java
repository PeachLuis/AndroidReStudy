package com.example.luis.androidrestudy.activity.item_activity.recycler_view;

import android.widget.ImageView;
import android.widget.TextView;

public class Item {

    private int mImageRes;

    private String mName;

    public Item(int mImageRes, String mName) {
        this.mImageRes = mImageRes;
        this.mName = mName;
    }

    public Item() {
    }

    public int getmImageRes() {
        return mImageRes;
    }

    public void setmImageRes(int mImageRes) {
        this.mImageRes = mImageRes;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
