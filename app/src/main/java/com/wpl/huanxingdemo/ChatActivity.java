package com.wpl.huanxingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;

public class ChatActivity extends AppCompatActivity {

    //传值
    public static final String CHAT_USERNAME = "chat_username";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        username = getIntent().getStringExtra(CHAT_USERNAME);
        Chat(username);
    }

    /**
     * 跳转
     * @param username
     */
    public void Chat(String username) {

        //new出EaseChatFragment或其子类的实例
        EaseChatFragment chatFragment = new EaseChatFragment();
        //传入参数
        Bundle args = new Bundle();
        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_USER_ID, username);
        chatFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
    }
}
