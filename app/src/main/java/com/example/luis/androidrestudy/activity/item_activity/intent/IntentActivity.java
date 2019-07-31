package com.example.luis.androidrestudy.activity.item_activity.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.luis.androidrestudy.R;
import com.example.luis.androidrestudy.LuisApplication;

public class IntentActivity extends LuisApplication implements View.OnClickListener {

    private Button mButton_intent_explicit;
    private Button mButton_intent_implicit;
    private Button mButton_intent_setData;
    private Button mBtton_intent_dial;
    private EditText mEditTxt_intent_data;
    private Button mButton_intent_data;
    private Button mButton_intent_returnData;
    private TextView mTextView_intent_returnData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        initView();
    }

    private void initView() {
        mButton_intent_explicit = (Button) findViewById(R.id.btn_intent_explicit);
        mButton_intent_implicit = (Button) findViewById(R.id.btn_intent_implicit);
        mButton_intent_setData = (Button) findViewById(R.id.btn_intent_setdata);
        mBtton_intent_dial = (Button) findViewById(R.id.btn_intent_dial);
        mEditTxt_intent_data = (EditText) findViewById(R.id.edit_intent_data);
        mButton_intent_data = (Button) findViewById(R.id.btn_intent_data);
        mButton_intent_returnData = (Button) findViewById(R.id.btn_intent_returnData);
        mTextView_intent_returnData = (TextView) findViewById(R.id.text_intent_returnData);

        mButton_intent_explicit.setOnClickListener(this);
        mButton_intent_implicit.setOnClickListener(this);
        mButton_intent_setData.setOnClickListener(this);
        mBtton_intent_dial.setOnClickListener(this);
        mButton_intent_data.setOnClickListener(this);
        mButton_intent_returnData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_intent_explicit:
                /*简单的显式跳转
                 可以简单地写为
                 startActivity(new Intent(IntentActivity.this, IntentActivity_Explicit.class));
                 */
                Intent intent = new Intent(IntentActivity.this, IntentActivity_Explicit.class);
                startActivity(intent);
                break;
            case R.id.btn_intent_implicit:
                /*隐式跳转
                 需要在AndroidManifest里面注册intent_filter
                 注意：必须action和category同时匹配上才能成功跳转
                 (action只能有一个，而category可以有多个，所以官方更推荐使用intent隐式跳转）
                 从而实现多个活动的跳转
                 注意：这里匹配的action最好写成完整包名，方便以后的维护
                 */
                Intent intent1 = new Intent("com.example.luis.androidrestudy.acticity.item_activity.ACTION_INTENT");
                //intent1.addCategory("MyCategory");
                startActivity(intent1);
                break;
            case R.id.btn_intent_setdata:
                /*
                 这是一种根据Uri跳转到网站的方法，但是这种方法是直接打开浏览器
                 可以将Action替换成自定义的WebView
                 注意：这里的网址Uri需要写数据协议部分，即http：//
                 */
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://www.bilibili.com"));
                startActivity(intent2);
                break;
            case R.id.btn_intent_dial:
                /*
                 通过setData方法实现拨打电话
                 */
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel:10086"));
                startActivity(intent3);
                break;
            case R.id.btn_intent_data:
                /*
                 该活动传递数据给要跳转的活动
                 第一个参数是key，第二个参数是value
                 */
                String data = mEditTxt_intent_data.getText().toString();
                Intent intent4 = new Intent(IntentActivity.this, IntentActivity_Explicit.class);
                intent4.putExtra("editText_data", data);
                startActivity(intent4);
                break;
            case R.id.btn_intent_returnData:
                /*
                 实现要跳转的活动返回数据给本活动
                 第一个参数是intent，第二个参数是请求码，用于在之后的回调中判断数据的来源
                 需要在此活动重写onActivityResult()方法，和在返回数据的活动中设置点击事件或者重写onBackPressed()方法
                 */
                Intent intent5 = new Intent(IntentActivity.this, IntentActivity_Implicit.class);
                startActivityForResult(intent5,1);
                break;
            default:
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    final String returnData = data.getStringExtra("data_return");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextView_intent_returnData.setText(returnData);
                        }
                    });
                }
                break;
            default:
                break;
        }
    }
}
