package com.jy.frame_one.persenter.home;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.home.BrandDetailConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.BrandDetialBean;
import com.jy.frame_one.utils.RxUtils;

public class BrandDetailPersenter extends BasePersenter<BrandDetailConstract.View> implements BrandDetailConstract.Persenter {
    @Override
    public void getBrandDetail(int page,int sieze) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandDetailBean(page,sieze)
                .compose(RxUtils.<BrandDetialBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandDetialBean>(mView){

                    @Override
                    public void onNext(BrandDetialBean brandDetialBean) {
                        mView.getBrandDetailReturn(brandDetialBean);
                    }
                }));
    }
}
