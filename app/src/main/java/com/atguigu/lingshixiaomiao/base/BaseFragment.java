package com.atguigu.lingshixiaomiao.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：杨光福 on 2016/3/23 16:21
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：一个基类，左侧菜单和正文Framgment的基类
 */
public abstract class BaseFragment extends Fragment {


    /**
     * 上下文
     */
    public Activity mActivity;

    /**
     * 当BaseFragment被创建的时候回调这个方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }


    /**
     * 当Framgment作为视图被创建的时候回调
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return initView();//实例化子View的视图
    }

    /**
     * 强制孩子实现自己的视图
     * @return
     */
    public abstract View initView() ;

    /**
     * 当Activity被创建的时候回调这个方法
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();//当Activity被创建了的时候回调
    }

    /**
     * 当子类需要联网请求数据的时候，重写该方法即可
     */
    public void initData() {

    }


}
