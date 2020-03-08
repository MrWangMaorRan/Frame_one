package com.jy.frame_one.persenter.shopping;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.shopping.ShoppingConstact;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.OrderInfoBean;
import com.jy.frame_one.utils.RxUtils;

public class OrderPresenter extends BasePersenter<ShoppingConstact.OrderView> implements ShoppingConstact.OrderPresenter {
    @Override
    public void getCartIndex() {

    }

    //获取订单信息
    @Override
    public void getOrderList(int addressId, int couponId) {
        addSubscribe(HttpManager.getInstance().getShopApi().getOrderInfo(addressId,couponId)
                .compose(RxUtils.<OrderInfoBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<OrderInfoBean>(mView){

                    @Override
                    public void onNext(OrderInfoBean orderInfoBean) {
                        mView.getOrderListReturn(orderInfoBean);
                    }
                }));
    }
}
