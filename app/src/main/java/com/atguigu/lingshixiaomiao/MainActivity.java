package com.atguigu.lingshixiaomiao;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.atguigu.lingshixiaomiao.fragment.ContentFragment;

public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置没有标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        initFragment();
    }

    private void initFragment() {
        //1.FragmentManger
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction ft  = fm.beginTransaction();
        //3.替换Fragment
        ft.replace(R.id.fl_main, new ContentFragment());
        //4.事务提交
        ft.commit();
    }
}
