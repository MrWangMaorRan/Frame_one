package com.jy.frame_one.interfaces.home;



import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.IndexBean;

public interface HomeConstract {
    interface View extends IBaseView {
        void getHomeDataReturn(IndexBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getHomeData();
    }
}
