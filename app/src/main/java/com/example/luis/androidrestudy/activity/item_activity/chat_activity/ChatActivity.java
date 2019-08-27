package com.example.luis.androidrestudy.activity.item_activity.chat_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends LuisApplication {

    private List<Message> mMessageList = new ArrayList<>();

    private EditText mInputText;

    private Button mSendMessage;

    private RecyclerView mMessageRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initData();
        initView();
    }

    private void initView() {
        mInputText = (EditText) findViewById(R.id.chat_inputMessage);
        mSendMessage = (Button) findViewById(R.id.chat_sendMessage);
        mMessageRecyclerView = (RecyclerView) findViewById(R.id.chat_recyclerView);

        mInputText.setImeOptions(EditorInfo.IME_ACTION_SEND);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mMessageRecyclerView.setLayoutManager(manager);
        final ChatAdapter adapter = new ChatAdapter(mMessageList);
        mMessageRecyclerView.setAdapter(adapter);

        mSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mInputText.getText().toString();
                //注意这里使用equals方法，这里的equals方法是String里面重写的Object类的，所以这里是比较内容，千万不能用==
                if (!content.equals("")) {
                    Message message = new Message(content, Message.TYPE_SENT);
                    mMessageList.add(message);
                    //当有消息发送的时候，刷新RecyclerView的显示
                    adapter.notifyItemInserted(mMessageList.size() - 1);
                    //将RecyclerView定位到最后一行
                    mMessageRecyclerView.scrollToPosition(mMessageList.size() - 1);
                    //清空输入框中内容
                    mInputText.setText("");
                }
            }
        });
    }

    private void initData() {
        Message message_1 = new Message("你好，大兄弟", Message.TYPE_RECEIVED);
        mMessageList.add(message_1);
        Message message_2 = new Message("你也挺好，啥事儿啊？", Message.TYPE_SENT);
        mMessageList.add(message_2);

    }
}
