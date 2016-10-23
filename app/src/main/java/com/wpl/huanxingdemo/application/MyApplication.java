package com.wpl.huanxingdemo.application;

import android.app.Application;
import android.util.Log;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;

import java.util.List;

/**
 * Created by 王鹏龙 on 2016/10/20.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        EMOptions options = new EMOptions();
        // 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);

        //初始化
        EaseUI.getInstance().init(getApplicationContext(), options);
        //在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        //EMClient.getInstance().setDebugMode(true);

        ChatListener();
    }

    /**
     * 聊天消息   copy
     */
    public void ChatListener() {


        EMMessageListener msgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                //收到消息

                Log.d("gggggg", messages.toString());
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                //收到透传消息
            }

            @Override
            public void onMessageReadAckReceived(List<EMMessage> messages) {
                //收到已读回执
            }

            @Override
            public void onMessageDeliveryAckReceived(List<EMMessage> message) {
                //收到已送达回执
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                //消息状态变动
            }
        };
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }
}
