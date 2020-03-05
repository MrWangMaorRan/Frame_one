package com.jy.frame_one.persenter.test;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.test.TestConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.FuLiBean;
import com.jy.frame_one.utils.RxUtils;

public class TestPersenter extends BasePersenter<TestConstract.View> implements TestConstract.Persenter {
    @Override
    public void getFuLi() {
        addSubscribe(HttpManager.getInstance().getFuLiApi().getFuLi()
        .compose(RxUtils.<FuLiBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<FuLiBean>(mView) {
                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                        mView.getFuLiReturn(fuLiBean);
                    }
                }));

    }
}
