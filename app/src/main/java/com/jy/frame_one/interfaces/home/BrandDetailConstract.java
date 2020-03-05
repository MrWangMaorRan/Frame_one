package com.jy.frame_one.interfaces.home;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.BrandDetialBean;

public interface BrandDetailConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getBrandDetailReturn(BrandDetialBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getBrandDetail(int page, int size);
    }
}
