package com.jy.frame_one.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.common.Constant;
import com.jy.frame_one.models.bean.RelatedBottonBean;

import java.util.List;

public class RelateBottonAdapter extends BaseAdapter {

    public RelateBottonAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.layout_relatebotton_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        RelatedBottonBean.DataBean.GoodsListBean bottonBean= (RelatedBottonBean.DataBean.GoodsListBean) o;
        ImageView iv = (ImageView) holder.getView(R.id.botton_iv);
        TextView name = (TextView) holder.getView(R.id.bottom_name);
        TextView price = (TextView) holder.getView(R.id.bottom_price);
        Glide.with(mContext).load(bottonBean.getList_pic_url()).into(iv);
        name.setText(bottonBean.getName());
        price.setText(Constant.PRICE_MODEL.replace("$",bottonBean.getRetail_price()+""));
    }
}
