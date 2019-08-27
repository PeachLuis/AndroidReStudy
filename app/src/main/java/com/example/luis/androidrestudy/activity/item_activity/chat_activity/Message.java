package com.example.luis.androidrestudy.activity.item_activity.chat_activity;

public class Message {

    public static final int TYPE_RECEIVED = 0;

    public static final int TYPE_SENT = 1;

    private String mContent;

    private int mType;

    public Message(String content, int type) {
        mContent = content;
        mType = type;
    }

    public String getContent() {
        return mContent;
    }

    public int getType() {
        return mType;
    }
}
