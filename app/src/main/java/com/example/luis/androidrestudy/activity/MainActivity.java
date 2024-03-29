package com.example.luis.androidrestudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.activity.item_activity.TwoDialogActivity;
import com.example.luis.androidrestudy.activity.item_activity.chat_activity.ChatActivity;
import com.example.luis.androidrestudy.activity.item_activity.custom_layout.CustomLayout;
import com.example.luis.androidrestudy.activity.item_activity.fragement.FragmentTestActivity;
import com.example.luis.androidrestudy.activity.item_activity.intent.IntentActivity;
import com.example.luis.androidrestudy.activity.item_activity.LogActivity;
import com.example.luis.androidrestudy.activity.item_activity.MenuActivity;
import com.example.luis.androidrestudy.activity.item_activity.life.LifeActivity;
import com.example.luis.androidrestudy.activity.item_activity.list_view.BaseListView;
import com.example.luis.androidrestudy.activity.item_activity.recycler_view.BaseRecyclerView;
import com.example.luis.androidrestudy.activity.item_activity.start_mode.StartModeActivity;
import com.example.luis.androidrestudy.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LuisApplication {

    private static final String TAG = "MainActivity";

    private ListView mListView;

    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
        //为ListView添加数据
        mDatas.add(0,"Log的使用");
        mDatas.add(1,"Menu的使用");
        mDatas.add(2,"Intent的使用");
        mDatas.add(3,"活动的生命周期");
        mDatas.add(4,"活动的四大启动模式");
        mDatas.add(5,"活动的最佳实践");
        mDatas.add(6,"两种Dialog的基本使用");
        mDatas.add(7,"创建自定义控件");
        mDatas.add(8,"ListView的使用");
        mDatas.add(9,"RecyclerView的的使用");
        mDatas.add(10, "聊天的简单实现");
        mDatas.add(11, "横竖屏切换时显示不同的Fragment");
    }

    private void initView() {
        //创建适配器
        mListView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,mDatas);
        mListView.setAdapter(adapter);
        //为ListView的item设置点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,LogActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, MenuActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, IntentActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, LifeActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, StartModeActivity.class));
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this,"详情请看代码中Application和ActivityCollectorUtil类",Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this,TwoDialogActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this,CustomLayout.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, BaseListView.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, BaseRecyclerView.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, ChatActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, FragmentTestActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
