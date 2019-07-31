package com.example.luis.androidrestudy.activity.item_activity.recycler_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

import java.util.ArrayList;
import java.util.List;

public class BaseRecyclerView extends LuisApplication {

    private TabLayout mTabLayout;

    private ViewPager mViewpager;

    private String[] mTitles = {"线性列表", "单排2个item", "瀑布流"};

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //因为是TabLayout，所以这里需要将actionBar隐藏
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_base_recycler_view);

        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.recycler_tabLayout);
        mViewpager = (ViewPager) findViewById(R.id.recycler_viewPager);

        //这里使用newInstance方法创建Fragment和添加新的Tab
        for (int i=0;i<mTitles.length;i++) {
            fragmentList.add(TabFragment_Recycler.newInstance(i));
            mTabLayout.addTab(mTabLayout.newTab());
        }

        //这里添加Adapter
        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        //这里添加一个接口
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTabLayout.setupWithViewPager(mViewpager);
    }


}
