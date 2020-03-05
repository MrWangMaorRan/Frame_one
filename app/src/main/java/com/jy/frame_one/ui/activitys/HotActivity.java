package com.jy.frame_one.ui.activitys;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.interfaces.home.HotConstract;
import com.jy.frame_one.models.bean.NewsDetailBean;
import com.jy.frame_one.persenter.home.HotPersenter;

import butterknife.BindView;

public class HotActivity extends BaseActivity<HotConstract.Persenter> implements HotConstract.View {

    @BindView(R.id.hot_banner)
    ImageView iv;
    @BindView(R.id.hot_name)
    TextView tv;

    @Override
    protected int getLayout() {
        return R.layout.activity_hot;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getNewsDetailBean();
    }

    @Override
    protected HotConstract.Persenter createPersenter() {
        return new HotPersenter();
    }

    @Override
    public void getNewsDetailReturn(NewsDetailBean result) {
        updateBanner(result.getData().getBannerInfo().getImg_url(),result.getData().getBannerInfo().getName());
    }

    private void updateBanner(String url,String name) {
        Glide.with(this).load(url).into(iv);
        tv.setText(name);
    }
}
