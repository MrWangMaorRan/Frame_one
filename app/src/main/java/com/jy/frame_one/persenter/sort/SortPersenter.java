package com.jy.frame_one.persenter.sort;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.sort.SortConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.TabItemBean;
import com.jy.frame_one.models.bean.VtlNameBean;
import com.jy.frame_one.utils.RxUtils;

public class SortPersenter extends BasePersenter<SortConstract.View> implements SortConstract.Persenter {
    @Override
    public void getSort() {
        addSubscribe(HttpManager.getInstance().getShopApi().getVtlNames()
                .compose(RxUtils.<VtlNameBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<VtlNameBean>(mView) {
                    @Override
                    public void onNext(VtlNameBean vtlNameBean) {
                        mView.getSortReturn(vtlNameBean);
                    }
                }));
    }

    @Override
    public void getSortItem(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortItems(id)
                .compose(RxUtils.<TabItemBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TabItemBean>(mView) {
                    @Override
                    public void onNext(TabItemBean tabItemBean) {
                        mView.getSortItemReturn(tabItemBean);
                    }
                }));
    }
}
