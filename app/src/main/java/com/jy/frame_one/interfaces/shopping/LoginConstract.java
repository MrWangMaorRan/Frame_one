package com.jy.frame_one.interfaces.shopping;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.UserBean;

public interface LoginConstract {
    interface View extends IBaseView {
        void loginReturn(UserBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void login(String nickname,String password);
    }
}
