package com.jy.frame_one.ui.activitys;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.jy.frame_one.R;
import com.jy.frame_one.adapter.MainViewPagerAdapter;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.ui.fragments.home.HomeFragment;
import com.jy.frame_one.ui.fragments.me.MeFragment;
import com.jy.frame_one.ui.fragments.shoping.ShopingFragment;
import com.jy.frame_one.ui.fragments.sort.SortFragment;
import com.jy.frame_one.ui.fragments.topic.TopicFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        setSupportActionBar(mToobar);
        MainViewPagerAdapter myViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), initFragment());
        mViewpager.setAdapter(myViewPagerAdapter);
        mTablayout.setupWithViewPager(mViewpager);

        for (int i = 0; i <myViewPagerAdapter.getCount() ; i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            tab.setCustomView(intabview(i));
        }
    }

    @Override
    protected void initData() {

    }

    private View intabview(int i) {
        View view = View.inflate(this, R.layout.tab_view, null);
        ImageView iv = view.findViewById(R.id.tab_iv);
        TextView tv = view.findViewById(R.id.tab_tv);
        switch (i){
            case 0:
                iv.setImageResource(R.mipmap.home);
                tv.setText("首页");
                break;
            case 1:
                iv.setImageResource(R.mipmap.weicang);
                tv.setText("专题");
                break;
            case 2:
                iv.setImageResource(R.mipmap.menu);
                tv.setText("分类");
                break;
            case 3:
                iv.setImageResource(R.mipmap.cart);
                tv.setText("购物车");
                break;
            case 4:
                iv.setImageResource(R.mipmap.me);
                tv.setText("我的");
                break;
        }
        return view;
    }

    private List<Fragment> initFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        MeFragment meFragment = new MeFragment();
        ShopingFragment shopingFragment = new ShopingFragment();
        SortFragment sortFragment = new SortFragment();
        TopicFragment topicFragment = new TopicFragment();
        fragments.add(homeFragment);
        fragments.add(topicFragment);
        fragments.add(sortFragment);
        fragments.add(shopingFragment);
        fragments.add(meFragment);
        return fragments;
    }

    @Override
    protected IBasePersenter createPersenter() {
        return null;
    }
}
