package com.jy.frame_one.persenter.home;

import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.home.BrandConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.BrandBean;
import com.jy.frame_one.models.bean.BrandGoodsBean;
import com.jy.frame_one.utils.RxUtils;

public class BrandPersenter extends BasePersenter<BrandConstract.View> implements BrandConstract.Persenter {

    @Override

    public void getBrandInfo(String id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandInfo(id)
                .compose(RxUtils.<BrandBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandBean>(mView){

                    @Override
                    public void onNext(BrandBean brandBean) {
                        mView.getBrandInfoReturn(brandBean);
                    }
                }));
    }

    @Override
    public void getBrandGoods(String brandId, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getBrandGoods(brandId,page,size)
                .compose(RxUtils.<BrandGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandGoodsBean>(mView){

                    @Override
                    public void onNext(BrandGoodsBean brandGoodsBean) {
                        mView.getBrandGoodsReturn(brandGoodsBean);
                    }
                }));
    }
}
