package com.wpl.huanxingdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wpl.huanxingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王鹏龙 on 2016/10/20.
 */
public class Adapter_Constact extends BaseAdapter {

    Context context;
    //初始化lsit
    List<String> usernames = new ArrayList<String>();
    private TextView tv;

    public Adapter_Constact(Context context) {
        this.context = context;
    }

    //封装方法更新lsitview
    public void addresst(List<String> usernames) {

        this.usernames.clear();
        this.usernames.addAll(usernames);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return usernames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView=View.inflate(context, R.layout.adapter_constact,null);
        }

        //控件
        tv = (TextView) convertView.findViewById(R.id.tv_adapter_item);

        //赋值
        tv.setText(usernames.get(position));


        return convertView;
    }
}
