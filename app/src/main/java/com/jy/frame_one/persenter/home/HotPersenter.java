package com.jy.frame_one.persenter.home;

import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.home.HotConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.NewsDetailBean;
import com.jy.frame_one.utils.RxUtils;
public class HotPersenter extends BasePersenter<HotConstract.View> implements HotConstract.Persenter {
    @Override
    public void getNewsDetailBean() {
        addSubscribe(HttpManager.getInstance().getShopApi().getNewsDetailBean()
                .compose(RxUtils.<NewsDetailBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<NewsDetailBean>(mView){

                    @Override
                    public void onNext(NewsDetailBean newsDetailBean) {
                        mView.getNewsDetailReturn(newsDetailBean);
                    }
                }));
    }
}
