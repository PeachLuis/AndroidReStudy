package com.example.luis.androidrestudy.activity.item_activity.list_view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {

    private static final String TAG = "TabFragment";

    private int mType = 0;

    private ListView mListView;

    private List<String> mDatas = new ArrayList<>();

    /**
     * 使用newInstance方法动态添加Fragment
     * 注：这里的type是用来给Fragment排序，也可以使用String title，就可以直接将得到的数据设置为标题，反正差不了多少
     * @param type Tab处于第几个
     * @return TabFragment
     */
    public static TabFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("TabFragment_Type", type);
        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mType = args.getInt("TabFragment_Type");
        }
        Log.d(TAG, "第" + mType + "个Tab被创建");
    }

    /**
     * 这里使用newInstance方法来初始化Fragment的话
     * 则在onCreateView方法当中可以根据Tab标题不同，来填充不同的布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_listview_fragment, container, false);
        //对ListView的操作
        mListView = (ListView) view.findViewById(R.id.base_list_view);

        for (int i = 0; i < 100; i++) {
            mDatas.add("这是第" + i + "个item");
        }

        //这里采取switch语句设置不同Fragment的填充情况
        switch (mType) {
            case 0:
                mListView.setAdapter(new ArrayAdapter<String>(LuisApplication.getContext(), android.R.layout.simple_list_item_1,mDatas));
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(LuisApplication.getContext(), mDatas.get(position) + "  被点击", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 1:
                mListView.setAdapter(new ArrayAdapter<String>(LuisApplication.getContext(), android.R.layout.simple_list_item_checked,mDatas));
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(LuisApplication.getContext(), mDatas.get(position) + "  被点击", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case 2:
                mListView.setAdapter(new ArrayAdapter<String>(LuisApplication.getContext(), android.R.layout.simple_list_item_single_choice, mDatas));
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(LuisApplication.getContext(), mDatas.get(position) + "  被点击", Toast.LENGTH_LONG).show();
                    }
                });
                break;
            default:
                break;
        }
        return view;
    }


}
