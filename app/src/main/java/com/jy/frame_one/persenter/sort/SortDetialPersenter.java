package com.jy.frame_one.persenter.sort;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.sort.SortConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.SortDetialBean;
import com.jy.frame_one.models.bean.SortDetialGoodsBean;
import com.jy.frame_one.utils.RxUtils;

public class SortDetialPersenter extends BasePersenter<SortConstract.DetailView> implements SortConstract.DetailPersenter {

    @Override
    public void getSortDetailTab(int id) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetialTab(id)
                .compose(RxUtils.<SortDetialBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetialBean>(mView) {
                    @Override
                    public void onNext(SortDetialBean sortDetialBean) {
                        mView.getSortDetailReturn(sortDetialBean);
                    }
                }));
    }

    @Override
    public void getSortDetailGoods(int id, int page, int size) {
        addSubscribe(HttpManager.getInstance().getShopApi().getSortDetailGoods(id,page,size)
                .compose(RxUtils.<SortDetialGoodsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<SortDetialGoodsBean>(mView) {
                    @Override
                    public void onNext(SortDetialGoodsBean sortDetialGoodsBean) {
                        mView.getSortDetailGoodsReturn(sortDetialGoodsBean);
                    }
                }));
    }
}
