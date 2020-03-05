package com.jy.frame_one.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.common.Constant;
import com.jy.frame_one.models.bean.IndexBean;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    public NewsAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_goods_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        IndexBean.DataBean.NewGoodsListBean goodsList= (IndexBean.DataBean.NewGoodsListBean) o;
        ImageView goods_iv = (ImageView) holder.getView(R.id.goods_iv);
        TextView goods_name = (TextView) holder.getView(R.id.goods_name);
        TextView goods_price = (TextView) holder.getView(R.id.goods_price);
        Glide.with(mContext).load(goodsList.getList_pic_url()).into(goods_iv);
        goods_name.setText(goodsList.getName());
        goods_price.setText(Constant.PRICE_MODEL.replace("$",goodsList.getRetail_price()));
    }
}
