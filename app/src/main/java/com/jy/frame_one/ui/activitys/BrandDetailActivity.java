package com.jy.frame_one.ui.activitys;


import com.jy.frame_one.R;
import com.jy.frame_one.adapter.BrandDetailAdapter;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.interfaces.home.BrandDetailConstract;
import com.jy.frame_one.models.bean.BrandDetialBean;
import com.jy.frame_one.persenter.home.BrandDetailPersenter;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class BrandDetailActivity extends BaseActivity<BrandDetailConstract.Persenter> implements BrandDetailConstract.View{

    @BindView(R.id.brand_detail_recy)
    RecyclerView brand_detail_recy;
    private ArrayList<BrandDetialBean.DataBeanX.DataBean> brandDetailList;
    private BrandDetailAdapter brandDetailAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_branddetail;
    }

    @Override
    protected void initView() {
        brandDetailList = new ArrayList<>();
        brandDetailAdapter = new BrandDetailAdapter(brandDetailList, this);
        brand_detail_recy.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        brand_detail_recy.setLayoutManager(new LinearLayoutManager(this));
        brand_detail_recy.setAdapter(brandDetailAdapter);
    }

    @Override
    protected void initData() {
        persenter.getBrandDetail(1,1000);
    }

    @Override
    protected BrandDetailConstract.Persenter createPersenter() {
        return new BrandDetailPersenter();
    }

    @Override
    public void getBrandDetailReturn(BrandDetialBean result) {
        brandDetailAdapter.updata(result.getData().getData());
    }
}
