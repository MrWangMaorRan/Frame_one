package com.jy.frame_one.interfaces.home;

/*import com.example.kuangjia.interfaces.IBasePersenter;
import com.example.kuangjia.interfaces.IBaseView;
import com.example.kuangjia.models.bean.BrandBean;
import com.example.kuangjia.models.bean.BrandGoodsBean;*/

import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.BrandBean;
import com.jy.frame_one.models.bean.BrandGoodsBean;

public interface BrandConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getBrandInfoReturn(BrandBean result);
        void getBrandGoodsReturn(BrandGoodsBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getBrandInfo(String id);
        void getBrandGoods(String brandId, int page, int size);
    }
}
