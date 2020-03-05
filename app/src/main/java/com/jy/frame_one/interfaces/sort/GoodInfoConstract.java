package com.jy.frame_one.interfaces.sort;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.RelatedBean;
import com.jy.frame_one.models.bean.RelatedBottonBean;

public interface GoodInfoConstract {
     interface View extends IBaseView {
        void getRelatedDataReturn(RelatedBean result);
        void getRelateBottonRetrun(RelatedBottonBean result);
    }

     interface Persenter extends IBasePersenter<View> {
        void getRelatedData(int id);
        void getBottonData(int id);
    }
}
