package com.example.luis.androidrestudy.activity.item_activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;
import com.example.luis.androidrestudy.activity.MainActivity;
import com.example.luis.androidrestudy.utils.LogUtil;

public class MenuActivity extends LuisApplication {

    private static final String TAG = "MenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popu_menu,menu);
        //返回true表示允许menu展示出来
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                DoToast("你添加了一个item");
                break;
            case R.id.remove_item:
                DoToast("你移除了一个item");
                break;
            default:
                break;
        }
        return true;
    }

    private void DoToast(String string) {
        Toast.makeText(MenuActivity.this,string,Toast.LENGTH_LONG).show();
    }
}
