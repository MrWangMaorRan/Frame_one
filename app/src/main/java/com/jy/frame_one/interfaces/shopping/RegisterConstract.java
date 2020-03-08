package com.jy.frame_one.interfaces.shopping;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.UserBean;
import com.jy.frame_one.models.bean.VerifyBean;

public interface RegisterConstract {
    interface View extends IBaseView {
        void getVerifyReturn(VerifyBean result);
        void getUserReturn(UserBean userBean);
    }

    interface Persenter extends IBasePersenter<View> {
        void getVerify();
        void getUser(String nickname, String password, String verify);
    }
}
