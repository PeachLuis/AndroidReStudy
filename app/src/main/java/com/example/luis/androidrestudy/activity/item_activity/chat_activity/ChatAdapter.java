package com.example.luis.androidrestudy.activity.item_activity.chat_activity;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.luis.androidrestudy.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Message> messageList;

    public ChatAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //这里绑定的是RecyclerView的子项item的布局
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_recyclerview_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Message message = messageList.get(i);

        //判断消息是发出的还是接受的
        if (message.getType() == Message.TYPE_RECEIVED) {
            //是收到的消息，则显示左边的布局，隐藏右边的布局
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMessage.setText(message.getContent());
        } else if (message.getType() == Message.TYPE_SENT) {
            //是发出的消息，则显示右边的布局，隐藏左边的布局
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.rightMessage.setText(message.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return messageList == null ? 0:messageList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMessage;

        TextView rightMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            leftLayout = (LinearLayout) itemView.findViewById(R.id.chat_left_layout);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.chat_right_layout);
            leftMessage = (TextView) itemView.findViewById(R.id.chat_left_message);
            rightMessage = (TextView) itemView.findViewById(R.id.chat_right_message);
        }
    }
}

