package com.atguigu.lingshixiaomiao.pager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.atguigu.lingshixiaomiao.base.BasePager;


public class HomePager extends BasePager {

    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        super.initData();

        //设置主页的内容
        TextView textView = new TextView(mActivity);
        textView.setText("首页的内容。。。");
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);

        //把当前TextView添加到FrameLayout中
        fl_base_content.addView(textView);
    }
}
