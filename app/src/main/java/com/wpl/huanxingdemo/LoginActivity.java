package com.wpl.huanxingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.wpl.huanxingdemo.utils.ToastUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText zhanghao;
    private EditText mima;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //获取控件
        zhanghao = (EditText) findViewById(R.id.zhanghao);
        mima = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        //登陆按钮的点击事件
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String username = zhanghao.getText().toString().trim();
                String password = mima.getText().toString().trim();

                //逻辑判断
                if (null == username || username.equals("")) {
                    ToastUtil.show(getApplicationContext(), "用户名不能为空");
                    return;
                }

                if (null == password || password.equals("")) {
                    ToastUtil.show(getApplicationContext(), "密码名不能为空");
                    return;
                }

                //调用登陆方法
                Login(username, password);

                break;
        }
    }

    /**
     * 登陆
     * @param userName
     * @param password
     */
    public void Login(String userName, String password) {

        //在官方文档copy
        EMClient.getInstance().login(userName, password, new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.d("main", "登录聊天服务器成功！");

                //成功之后跳转至列表的activity
                COnstact();
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.d("main", "登录聊天服务器失败！");
            }
        });
    }


    /**
     * 跳转到获取联系人列表
     */
    public void COnstact() {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
