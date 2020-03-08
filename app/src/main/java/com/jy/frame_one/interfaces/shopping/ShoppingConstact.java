package com.jy.frame_one.interfaces.shopping;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.CartBean;
import com.jy.frame_one.models.bean.CartGoodsCheckBean;
import com.jy.frame_one.models.bean.CartGoodsDeleteBean;
import com.jy.frame_one.models.bean.CartGoodsUpdateBean;
import com.jy.frame_one.models.bean.OrderInfoBean;

public interface ShoppingConstact {
    interface View extends IBaseView {
        void getCartIndexReturn(CartBean result);
        //设置购物车商品数据选中状态的返回
        void setCartGoodsCheckedReturn(CartGoodsCheckBean result);
        //更新购物车类表商品数据返回
        void updateCartGoodsReturn(CartGoodsUpdateBean result);
        //删除商品返回
        void deleteCartGoodsReturn(CartGoodsDeleteBean result);
    }

    interface Presenter extends IBasePersenter<View> {
        void getCartIndex();
        //设置购物车商品数据
        void setCartGoodsChecked(String pids, int isChecked);
        //更新购物车列表的商品数据
        void updateCartGoods(String pids, String goodsId, int number, int id);
        //删除商品
        void deleteCartGoods(String pids);

    }

    //订单功能
    interface OrderView extends IBaseView{
        void getCartIndexReturn(CartBean result);
        //设置购物车商品数据选中状态的返回
        void getOrderListReturn(OrderInfoBean result);
    }

    interface OrderPresenter extends IBasePersenter<OrderView>{
        void getCartIndex();
        //设置购物车商品数据
        //地址id+优惠券的ID
        void getOrderList(int addressId, int couponId);
    }
}
