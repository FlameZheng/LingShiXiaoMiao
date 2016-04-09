package com.atguigu.lingshixiaomiao.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者：杨光福 on 2016/3/25 10:27
 * 微信：yangguangfu520
 * QQ号：541433511
 * 作用：xxxx
 */
public class NoscrollViewPager extends ViewPager {
    public NoscrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoscrollViewPager(Context context) {
        super(context);
    }

    /**
     * 屏幕ViewPager可以滑动
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }


    /**
     * 如果该方法，返回true就相应，当前控件的onTouchEvent被触发
     * 如果该方法返回false,把事件传递给子视图
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
