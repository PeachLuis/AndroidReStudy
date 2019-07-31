package com.example.luis.androidrestudy.activity.item_activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.R;

public class TwoDialogActivity extends LuisApplication implements View.OnClickListener {

    private Button mAlertDialog;
    private Button mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_dialog);

        initView();
    }

    private void initView() {
        mAlertDialog = (Button) findViewById(R.id.btn_alertDialog);
        mProgressDialog = (Button) findViewById(R.id.btn_progressDialog);

        mAlertDialog.setOnClickListener(this);
        mProgressDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alertDialog:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                alertDialog.setTitle("这是标题");
                alertDialog.setMessage("balabalabal");
                alertDialog.setCancelable(true);
                alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
                break;
            case R.id.btn_progressDialog:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(true);
                progressDialog.setTitle("标题");
                progressDialog.setMessage("加载中");
                progressDialog.show();

                break;
            default:
                break;
        }
    }
}
