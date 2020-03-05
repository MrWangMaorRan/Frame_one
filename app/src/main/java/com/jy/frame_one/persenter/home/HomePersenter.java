package com.jy.frame_one.persenter.home;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.home.HomeConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.IndexBean;
import com.jy.frame_one.utils.RxUtils;

public class HomePersenter  extends BasePersenter<HomeConstract.View> implements HomeConstract.Persenter {
    //获取主页的具体实现
    @Override
    public void getHomeData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getIndexData()
                .compose(RxUtils.<IndexBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<IndexBean>(mView){

                    @Override
                    public void onNext(IndexBean indexBean) {
                        mView.getHomeDataReturn(indexBean);
                    }
                }));
    }
}
