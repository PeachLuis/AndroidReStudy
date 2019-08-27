package com.example.luis.androidrestudy.activity.item_activity.fragement;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.utils.LogUtil;


public class RightFragment extends Fragment {

    private String shownText;

    private TextView textView;

    private static final String TAG = "RightFragment";

    public static RightFragment newInstance(String fragmentText) {
        Bundle args = new Bundle();
        args.putString("RightFragment_KEY", fragmentText);
        RightFragment fragment = new RightFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            shownText = args.getString("RightFragment_KEY");
        }
        LogUtil.d(TAG,"--"+shownText+"--"+"执行了onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG,"右边的Fragment执行了onCreateView一次");
        View view = inflater.inflate(R.layout.test_right_fragment, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        textView = (TextView) view.findViewById(R.id.right_fragment_text);
        textView.setText(shownText);
    }
}
