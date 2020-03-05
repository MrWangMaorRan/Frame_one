package com.jy.frame_one.persenter.sort;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.sort.GoodInfoConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.RelatedBean;
import com.jy.frame_one.models.bean.RelatedBottonBean;
import com.jy.frame_one.utils.RxUtils;

public class GoodInfoPersenter extends BasePersenter<GoodInfoConstract.View> implements GoodInfoConstract.Persenter  {

    @Override
    public void getRelatedData(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getRelatedData(id)
                .compose(RxUtils.<RelatedBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RelatedBean>(mView){

                    @Override
                    public void onNext(RelatedBean relatedBean) {
                        mView.getRelatedDataReturn(relatedBean);
                    }
                }));
    }

    @Override
    public void getBottonData(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBottonBean(id)
                .compose(RxUtils.<RelatedBottonBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<RelatedBottonBean>(mView){

                    @Override
                    public void onNext(RelatedBottonBean relatedBean) {
                        mView.getRelateBottonRetrun(relatedBean);
                    }
                }));
    }
}
