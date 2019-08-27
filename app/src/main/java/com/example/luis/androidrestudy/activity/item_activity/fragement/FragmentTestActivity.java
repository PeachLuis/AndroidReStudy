package com.example.luis.androidrestudy.activity.item_activity.fragement;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.utils.LogUtil;

public class FragmentTestActivity extends AppCompatActivity{


    private FrameLayout rightLayout;

    private Bundle mSavedInstanceState;

    static LeftFragment leftFragment;

    static RightFragment firstFragment;

    static RightFragment secondFragment;

    private static final String TAG = "FragmentTestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.d(TAG,"执行onCreate");
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;

        setContentView(R.layout.activity_fragment_test);

        initView();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        LogUtil.d(TAG,"执行onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            rightLayout.setVisibility(View.GONE);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rightLayout.setVisibility(View.VISIBLE);
        }
    }

    private void initView() {
        LogUtil.d(TAG,"执行initView");
        rightLayout = (FrameLayout) findViewById(R.id.right_fragment);


        //该活动一onCreate就需要检测一下横竖屏，然后设置右边布局可见性，
        //因为onConfigurationChanged方法是只在进行了横竖屏切换后才执行的
        //注：这里需要注意rightLayout要先初始化，然后才能使用，所以这段代码放在这里，而不是initView之前
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            rightLayout.setVisibility(View.GONE);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rightLayout.setVisibility(View.VISIBLE);
        }

        initFragment();



    }

    private void initFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (mSavedInstanceState == null) {
            leftFragment = new LeftFragment();
            transaction.add(R.id.left_fragment, leftFragment, "LeftFragment");
        } else {
            leftFragment = (LeftFragment) manager.findFragmentById(R.id.left_fragment);
        }
        firstFragment = RightFragment.newInstance("这是第一个Fragment");
        secondFragment = RightFragment.newInstance("这里已经成功切换到第二个Fragment");
        transaction.add(R.id.right_fragment, firstFragment);
        transaction.add(R.id.right_fragment, secondFragment);
        if (leftFragment != null) {
            transaction.show(leftFragment);
        }
        transaction.show(firstFragment);
        transaction.hide(secondFragment);
        transaction.commit();
    }

    private void switchFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (firstFragment.isVisible()) {
            transaction.hide(firstFragment);
            transaction.show(secondFragment);
        } else if (secondFragment.isVisible()) {
            transaction.hide(secondFragment);
            transaction.show(secondFragment);
        }
        transaction.commit();
    }


}
