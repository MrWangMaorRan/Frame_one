package com.jy.frame_one.interfaces.home;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.NewsDetailBean;

public interface HotConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getNewsDetailReturn(NewsDetailBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getNewsDetailBean();
    }
}
