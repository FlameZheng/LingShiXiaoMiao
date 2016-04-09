package com.atguigu.lingshixiaomiao.fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.atguigu.lingshixiaomiao.R;
import com.atguigu.lingshixiaomiao.base.BaseFragment;
import com.atguigu.lingshixiaomiao.base.BasePager;
import com.atguigu.lingshixiaomiao.pager.HomePager;
import com.atguigu.lingshixiaomiao.pager.MinePager;
import com.atguigu.lingshixiaomiao.pager.SalePager;
import com.atguigu.lingshixiaomiao.pager.SubjectPager;
import com.atguigu.lingshixiaomiao.view.NoscrollViewPager;

import java.util.ArrayList;

/**
 * 作用：正文的Fragment
 */
public class ContentFragment extends BaseFragment {

    private RadioGroup rg_content_fragment;
    //不可以滚动的ViewPager
    private NoscrollViewPager vp_content_fragment;
    /**
     * 页面的集合
     */
    private ArrayList<BasePager> basePagers;

    @Override
    public View initView() {
        View view  = View.inflate(mActivity, R.layout.content_fragment,null);
        rg_content_fragment = (RadioGroup) view.findViewById(R.id.rg_content_fragment);
        vp_content_fragment = (NoscrollViewPager) view.findViewById(R.id.vp_content_fragment);

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        System.out.println("ContentFragment的数据被初始化了");
        //默认选中首页
        rg_content_fragment.check(R.id.rb_home);

        //把五个页面加载到集合中--准备数据
        basePagers = new ArrayList<>();
        basePagers.add(new HomePager(mActivity));//添加首页页面
        basePagers.add(new SalePager(mActivity));//添加新闻页面
        basePagers.add(new SubjectPager(mActivity));//添加智慧服务页面
        basePagers.add(new MinePager(mActivity));//添加政要页面

        //设置ViewPager的适配器
        vp_content_fragment.setAdapter(new MyAdapter());

        //设置监听RadioGroup选中状态的改变
        rg_content_fragment.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
    }
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                case R.id.rb_home://切换到Viewpager第0个页面
                    vp_content_fragment.setCurrentItem(0,false);

                    break;
                case R.id.rb_subject://切换到Viewpager第1个页面
                    vp_content_fragment.setCurrentItem(1,false);

                    break;
                case R.id.rb_sale://切换到Viewpager第2个页面
                    vp_content_fragment.setCurrentItem(2,false);

                    break;
                case R.id.rb_mine://切换到Viewpager第3个页面
                    vp_content_fragment.setCurrentItem(3,false);

                    break;
            }
        }
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return basePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            BasePager basePager = basePagers.get(position);//position=0本质是HomePager
            View rootView = basePager.rootView;

            //调用各个页面的initData()方法
            basePager.initData();
            container.addView(rootView);
            return rootView;


        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
