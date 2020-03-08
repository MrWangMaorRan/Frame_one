package com.jy.frame_one.persenter.shopping;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.shopping.RegisterConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.UserBean;
import com.jy.frame_one.models.bean.VerifyBean;
import com.jy.frame_one.utils.RxUtils;

public class RegisterPersenter extends BasePersenter<RegisterConstract.View> implements RegisterConstract.Persenter {
    @Override
    public void getVerify() {
        addSubscribe(HttpManager.getInstance().getShopApi().getVerify()
                .compose(RxUtils.<VerifyBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<VerifyBean>(mView){

                    @Override
                    public void onNext(VerifyBean verifyBean) {
                        mView.getVerifyReturn(verifyBean);
                    }
                }));
    }

    @Override
    public void getUser(String nickname,String password,String verify) {
        addSubscribe(HttpManager.getInstance().getShopApi().regist(nickname,password,verify)
                .compose(RxUtils.<UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserBean>(mView){

                    @Override
                    public void onNext(UserBean verifyBean) {
                        mView.getUserReturn(verifyBean);
                    }
                }));
    }
}
