package com.jy.frame_one.interfaces.test;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.FuLiBean;

public interface TestConstract {
    interface View extends IBaseView {
        void getFuLiReturn(FuLiBean fuLi);
    }

    interface Persenter extends IBasePersenter<View> {
        void getFuLi();
    }
}
