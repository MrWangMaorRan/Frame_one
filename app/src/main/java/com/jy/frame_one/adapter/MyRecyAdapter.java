package com.jy.frame_one.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;


import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.models.bean.MyHomeItemBean;

import java.util.List;

public class MyRecyAdapter extends BaseAdapter {
    public MyRecyAdapter(List data, Context context) {
        super(data, context);
    }

    @Override
    public int getLayout() {
        return R.layout.me_item;
    }

    @Override
    public void bindData(BaseViewHolder holder, Object o) {
        MyHomeItemBean homeItemBean= (MyHomeItemBean) o;
        ImageView me_iv = (ImageView) holder.getView(R.id.me_recy_iv);
        TextView me_tv = (TextView) holder.getView(R.id.me_recy_tv);
        me_iv.setImageResource(homeItemBean.getImage());
        me_tv.setText(homeItemBean.getTitle());
    }
}
