package com.jy.frame_one.persenter.shopping;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.shopping.LoginConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.UserBean;
import com.jy.frame_one.utils.RxUtils;

public class LoginPersenter extends BasePersenter<LoginConstract.View> implements LoginConstract.Persenter{
    @Override
    public void login(String nickname, String password) {
        addSubscribe(HttpManager.getInstance().getShopApi().login(nickname,password)
                .compose(RxUtils.<UserBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<UserBean>(mView){

                    @Override
                    public void onNext(UserBean userBean) {
                        if(userBean.getErrno() == 0){
                            mView.loginReturn(userBean);
                        }else{
                            mView.showError(userBean.getErrmsg());
                        }
                    }
                }));
    }
}
