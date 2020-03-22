package com.jy.frame_one.ui.activitys;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import com.jy.frame_one.R;
import com.jy.frame_one.adapter.AdressAdapter;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.interfaces.shopping.ShoppingConstact;
import com.jy.frame_one.models.bean.AddressBean;
import com.jy.frame_one.persenter.shopping.AdressPresenter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class AdressListActivity extends BaseActivity<ShoppingConstact.AdressPresenter> implements ShoppingConstact.AdressView,
        BaseAdapter.ItemClickHandler {
    @BindView(R.id.recy_adress_list)
    RecyclerView recyAdressList;
    @BindView(R.id.txt_new)
    TextView txtNew;

    AdressAdapter adressAdapter;
    List<AddressBean.DataBean> list;

    @Override
    protected int getLayout() {
        return R.layout.activity_adress_list;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        adressAdapter = new AdressAdapter(list,this);
        recyAdressList.setLayoutManager(new LinearLayoutManager(this));
        recyAdressList.setAdapter(adressAdapter);

        //设置一个条目中组件点击事件的响应方法
        adressAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.img_editor:  //编辑地址的页面
                        AddressBean.DataBean item = (AddressBean.DataBean) v.getTag();
                        //进入地址编辑的页面
                        Intent intent = new Intent(AdressListActivity.this,AdressEditorActivity.class);
                        intent.putExtra("adress", (Parcelable) item);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
        persenter.getAdressList();
    }

    @Override
    protected ShoppingConstact.AdressPresenter createPersenter() {
        return new AdressPresenter();
    }

    //调整新建地址页面
    @OnClick(R.id.txt_new)
    public void onViewClicked() {
        Intent intent = new Intent(this,AdressEditorActivity.class);
        startActivity(intent);
    }

    //数据获取返回
    @Override
    public void getAdressListReturn(AddressBean result) {
        adressAdapter.updata(result.getData());
    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        AddressBean.DataBean item = list.get(position);
        //进入地址编辑的页面
        Intent intent = new Intent(this,AdressEditorActivity.class);
        intent.putExtra("adress", (Parcelable) item);
        startActivity(intent);
    }
}
