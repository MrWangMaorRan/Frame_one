package com.jy.frame_one.ui.activitys;

import android.util.Log;
import android.widget.FrameLayout;


import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.interfaces.test.TestConstract;
import com.jy.frame_one.models.bean.FuLiBean;
import com.jy.frame_one.persenter.test.TestPersenter;
import com.jy.frame_one.ui.fragments.home.HomeFragment;

import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

public class TestActivity extends BaseActivity<TestConstract.Persenter> implements TestConstract.View {

    @BindView(R.id.fl)
    FrameLayout frameLayout;


    @Override
    protected int getLayout() {
        return R.layout.test;
    }

    @Override
    protected void initView() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl,homeFragment).commit();
    }

    @Override
    protected void initData() {
        persenter.getFuLi();
    }

    @Override
    protected TestConstract.Persenter createPersenter() {
        return new TestPersenter();
    }

    @Override
    public void getFuLiReturn(FuLiBean fuLi) {
        Log.i("shuju",fuLi.toString());
    }
}
