package com.example.luis.androidrestudy.activity.item_activity.recycler_view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

import java.io.Flushable;
import java.util.ArrayList;
import java.util.List;

public class TabFragment_Recycler extends Fragment {

    private int mTitleID;

    private List<Item> mDatas = new ArrayList<>();

    public static TabFragment_Recycler newInstance(int titleID) {
        Bundle args = new Bundle();
        args.putInt("RecyclerTab", titleID);
        TabFragment_Recycler fragment = new TabFragment_Recycler();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mTitleID = args.getInt("RecyclerTab");
        }
        initData();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_recyclerview_fragment, container, false);
        initView(view);
        return view;
    }

    private void initData() {
        for (int i = 0; i < 80; i++) {
            mDatas.add(new Item(R.mipmap.ic_launcher,"这是第"+i+"个item"));
        }
    }

    private void initView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.base_recyclerView);

        switch (mTitleID) {
            case 0:
                //第一个Tab内容
                LinearLayoutManager layoutManager = new LinearLayoutManager(LuisApplication.getContext());
                recyclerView.setLayoutManager(layoutManager);
                break;
            case 1:
                //第二个Tab内容
                GridLayoutManager layoutManager1 = new GridLayoutManager(LuisApplication.getContext(), 2);
                recyclerView.setLayoutManager(layoutManager1);
                break;
            case 2:
                //第三个Tab内容
                StaggeredGridLayoutManager layoutManager2 = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager2);
                break;
            default:
                break;
        }
        ItemAdapter adapter = new ItemAdapter(mDatas);

        recyclerView.setAdapter(adapter);
    }


}
