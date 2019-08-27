package com.example.luis.androidrestudy.activity.item_activity.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.utils.LogUtil;

import static com.example.luis.androidrestudy.activity.item_activity.fragement.FragmentTestActivity.firstFragment;
import static com.example.luis.androidrestudy.activity.item_activity.fragement.FragmentTestActivity.secondFragment;

public class LeftFragment extends Fragment {

    private static final String TAG = "LeftFragment";

    private Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, "左边的Fragment执行了onCreate一次");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG, "左边的Fragment执行了onCreateView一次");
        View view = inflater.inflate(R.layout.test_left_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        button = (Button) getActivity().findViewById(R.id.btn_replaceFragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                if (firstFragment.isVisible()) {
                    transaction.hide(firstFragment);
                    transaction.show(secondFragment);
                } else if (secondFragment.isVisible()) {
                    transaction.hide(secondFragment);
                    transaction.show(firstFragment);
                }

                transaction.commit();
            }
        });
    }
}
