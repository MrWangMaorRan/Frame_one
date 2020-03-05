package com.jy.frame_one.interfaces.sort;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.SortDetialBean;
import com.jy.frame_one.models.bean.SortDetialGoodsBean;
import com.jy.frame_one.models.bean.TabItemBean;
import com.jy.frame_one.models.bean.VtlNameBean;

public interface SortConstract {
    interface View extends IBaseView {
        //返回数据结果
        void getSortReturn(VtlNameBean result);
        void getSortItemReturn(TabItemBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        //获取数据
        void getSort();
        void getSortItem(int id);
    }

    interface DetailView extends IBaseView {
        //返回数据结果
        void getSortDetailReturn(SortDetialBean result);
        void getSortDetailGoodsReturn(SortDetialGoodsBean result);
    }

    interface DetailPersenter extends IBasePersenter<DetailView> {
        //获取数据
        void getSortDetailTab(int id);
        void getSortDetailGoods(int id, int page, int size);
    }
}
