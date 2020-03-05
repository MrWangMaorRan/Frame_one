package com.jy.frame_one.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.models.bean.BrandDetialBean;

import java.util.List;

public class BrandDetailAdapter extends BaseAdapter {

    public BrandDetailAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.brand_detail_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        BrandDetialBean.DataBeanX.DataBean brandDetailBean= (BrandDetialBean.DataBeanX.DataBean) o;
        ImageView brand_detail_iv = (ImageView) holder.getView(R.id.brand_detail_iv);
        TextView brand_detail_title = (TextView) holder.getView(R.id.brand_detail_title);
        Glide.with(mContext).load(brandDetailBean.getApp_list_pic_url()).into(brand_detail_iv);
        brand_detail_title.setText(brandDetailBean.getName()+"丨"+brandDetailBean.getFloor_price()+"元起");
    }
}
