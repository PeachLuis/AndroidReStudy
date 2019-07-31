package com.example.luis.androidrestudy.activity.item_activity.list_view;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

import java.util.ArrayList;
import java.util.List;

/*
 最简单的一种ListView的实现，不需要写Adapter，直接使用自带的适配器
 */
public class BaseListView extends LuisApplication {

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    private String[] mTabTitles = {"普通的List","带有钩的List","带有复选框的List"};

    private List<Fragment> fragments = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_base_list_view);

        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.base_tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.base_viewPager);

        //使用newInstance创建Fragment
        //使用addTab方法添加Tab，注意：这里最好不用setText，因为可能会导致Tab标题显示空白
        //原因：TabLayout源码中有个方法populateFromPagerAdapter（）中给标题添加了许多空白
        for (int position = 0; position < mTabTitles.length;position++) {
            fragments.add(TabFragment.newInstance(position));
            mTabLayout.addTab(mTabLayout.newTab());
        }

        //设置ViewPager的适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            //返回指定position位置的Fragment
            //网上也有在此处使用switch语句进行Fragment的切换
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            //设置Tab的标题在这里
            //因为如果在addTab后面使用setText会出现标题为空白
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTabTitles[position];
            }
        });

        //设置TabLayout的单个Tab的点击事件
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(mTabLayout.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*
          Tab绑定viewPager
          注意：这里使用位置并没有特殊要求，应该只要在绑定控件后都可以
         */
        mTabLayout.setupWithViewPager(mViewPager);


        setDefaultTab();
    }

    /**
     * 这个方法可要可不要，因为默认显示第一个Tab
     */
    private void setDefaultTab() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragments.get(0));
        transaction.commit();
    }
}
