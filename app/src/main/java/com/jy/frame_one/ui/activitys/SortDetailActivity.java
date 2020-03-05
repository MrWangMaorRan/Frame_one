package com.jy.frame_one.ui.activitys;

import android.content.Intent;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;
import com.jy.frame_one.R;
import com.jy.frame_one.adapter.SortDetailAdapter;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.base.BaseAdapter;
import com.jy.frame_one.interfaces.sort.SortConstract;
import com.jy.frame_one.models.bean.SortDetialBean;
import com.jy.frame_one.models.bean.SortDetialGoodsBean;
import com.jy.frame_one.persenter.sort.SortDetialPersenter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class SortDetailActivity extends BaseActivity<SortConstract.DetailPersenter> implements SortConstract.DetailView, TabLayout.BaseOnTabSelectedListener, BaseAdapter.ItemClickHandler {

    @BindView(R.id.sort_tl)
    TabLayout sort_tl;
    @BindView(R.id.sort_name)
    TextView sort_name;
    @BindView(R.id.sort_title)
    TextView sort_title;
    @BindView(R.id.sort_recy)
    RecyclerView sort_recy;
    private List<SortDetialBean.DataBean.BrotherCategoryBean> tabs;
    private ArrayList<SortDetialGoodsBean.DataBeanX.GoodsListBean> goodsList;
    private SortDetailAdapter sortDetailAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_sortdetial;
    }

    @Override
    protected void initView() {
        sort_tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        sort_tl.addOnTabSelectedListener(this);

        goodsList = new ArrayList<>();
        sortDetailAdapter = new SortDetailAdapter(goodsList, this);
        sort_recy.setLayoutManager(new GridLayoutManager(this,2));
        sort_recy.setAdapter(sortDetailAdapter);
        sortDetailAdapter.setOnItemClickHandler(this);
    }

    @Override
    protected void initData() {
        int id = getIntent().getIntExtra("sortid", 0);
        persenter.getSortDetailTab(id);
    }

    @Override
    protected SortConstract.DetailPersenter createPersenter() {
        return (SortConstract.DetailPersenter) new SortDetialPersenter();
    }

    @Override
    public void getSortDetailReturn(SortDetialBean result) {

        int position=-1;
        tabs = result.getData().getBrotherCategory();
        //动态添加tab导航的内容
        for (int i=0;i<result.getData().getBrotherCategory().size();i++){
            SortDetialBean.DataBean.BrotherCategoryBean item=result.getData().getBrotherCategory().get(i);
            TabLayout.Tab tab=sort_tl.newTab();
            tab.setText(item.getName());
            tab.setTag(item.getId());
            sort_tl.addTab(tab);
            if (result.getData().getCurrentCategory().getId()==item.getId()){
                position=i;
            }
        }
        if(position >= 0){
            sort_tl.getTabAt(position).select();
        }
    }

    @Override
    public void getSortDetailGoodsReturn(SortDetialGoodsBean result) {
       sortDetailAdapter.updata(result.getData().getGoodsList());
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        SortDetialBean.DataBean.BrotherCategoryBean bean = tabs.get(tab.getPosition());
        sort_name.setText(bean.getFront_name());
        sort_title.setText(bean.getFront_desc());
        int id = (int) tab.getTag();
        persenter.getSortDetailGoods(id,1,1000);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void itemClick(int position, BaseAdapter.BaseViewHolder holder) {
        Intent intent = new Intent(this, GoodInfoActivity.class);
        intent.putExtra("ids",goodsList.get(position).getId());
        startActivity(intent);
    }
}
