package com.jy.frame_one.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.models.bean.SortDetialGoodsBean;

import java.util.List;

public class SortDetailAdapter extends BaseAdapter {
    public SortDetailAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.sortgoos_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        SortDetialGoodsBean.DataBeanX.GoodsListBean tabs= (SortDetialGoodsBean.DataBeanX.GoodsListBean) o;
        ImageView image = (ImageView) holder.getView(R.id.sortgoods_iv);
        TextView text = (TextView) holder.getView(R.id.sprtgppds_tv);
        TextView text_price = (TextView) holder.getView(R.id.sprtgppds_price);
        Glide.with(mContext).load(tabs.getList_pic_url()).into(image);
        text.setText(tabs.getName());
        String price = mContext.getResources().getString(R.string.price_news_model);
        text_price.setText(price.replace("$",String.valueOf(tabs.getRetail_price())));
    }
}
