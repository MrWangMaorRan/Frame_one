package com.jy.frame_one.models.api;


import com.jy.frame_one.models.bean.AddShopBean;
import com.jy.frame_one.models.bean.AddressBean;
import com.jy.frame_one.models.bean.AdressSaveBean;
import com.jy.frame_one.models.bean.BrandBean;
import com.jy.frame_one.models.bean.BrandDetialBean;
import com.jy.frame_one.models.bean.BrandGoodsBean;
import com.jy.frame_one.models.bean.CartBean;
import com.jy.frame_one.models.bean.CartGoodsCheckBean;
import com.jy.frame_one.models.bean.CartGoodsDeleteBean;
import com.jy.frame_one.models.bean.CartGoodsUpdateBean;
import com.jy.frame_one.models.bean.HotCommoditBean;
import com.jy.frame_one.models.bean.IndexBean;
import com.jy.frame_one.models.bean.LookingBean;
import com.jy.frame_one.models.bean.NewsCommoditBean;
import com.jy.frame_one.models.bean.NewsDetailBean;
import com.jy.frame_one.models.bean.OrderInfoBean;
import com.jy.frame_one.models.bean.RegionBean;
import com.jy.frame_one.models.bean.RelatedBean;
import com.jy.frame_one.models.bean.RelatedBottonBean;
import com.jy.frame_one.models.bean.SortDetialBean;
import com.jy.frame_one.models.bean.SortDetialGoodsBean;
import com.jy.frame_one.models.bean.TabItemBean;
import com.jy.frame_one.models.bean.TopBean;
import com.jy.frame_one.models.bean.TopDetailBean;
import com.jy.frame_one.models.bean.TopRecommend;
import com.jy.frame_one.models.bean.TopicBean;
import com.jy.frame_one.models.bean.UserBean;
import com.jy.frame_one.models.bean.VerifyBean;
import com.jy.frame_one.models.bean.VtlNameBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShopApi {
    @GET("index")
    Flowable<IndexBean> getIndexData();
    //品牌直供的详情页数据接口
    @GET("brand/detail")
    Flowable<BrandBean> getBrandInfo(@Query("id") String id);
    //品牌直供详情的商品列表数据接口
    @GET("goods/list")
    Flowable<BrandGoodsBean> getBrandGoods(@Query("brandId") String brandId, @Query("page") int page, @Query("size") int size);
    //分类名字的接口
    @GET("catalog/index")
    Flowable<VtlNameBean> getVtlNames();
    @GET("catalog/current")
    Flowable<TabItemBean> getSortItems(@Query("id")int id);
    @GET("index")
    Flowable<TopicBean> getTopicData();
    @GET("goods/category")
    Flowable<SortDetialBean> getSortDetialTab(@Query("id")int id);
    @GET("goods/list")
    Flowable<SortDetialGoodsBean> getSortDetailGoods(@Query("categoryId")int id, @Query("page")int page, @Query("size") int size);
    //新品详情页面的banner
    @GET("goods/hot")
    Flowable<NewsDetailBean> getNewsDetailBean();
    @GET("/brand/list")
    Flowable<BrandDetialBean> getBrandDetailBean(@Query("page") int page, @Query("size") int size);
    //新品，首发，居家等商品购买页的RecyclerView数据
    @GET("goods/related")
    Flowable<LookingBean> getLookBean(@Query("id")int id);
    //新品标题打开的列表页
    @GET("goods/list")
    Flowable<NewsCommoditBean> getNewsCommoditBean(@Query("isNew") int isNews,@Query("page") int page,@Query("size") int size,@Query("order") String order,@Query("sort") String sort,@Query("categoryId") int categoryId);
    //人气推荐标题打开的列表页
    @GET("goods/list")
    Flowable<HotCommoditBean> getHotCommoditBean(@Query("isHot") int isHot,@Query("page") int page,@Query("size") int size,@Query("order") String order,@Query("sort") String sort,@Query("categoryId") int categoryId);
    //专题列表
    @GET("topic/list")
    Flowable<TopBean> getTop();
    //专题详情
    @GET("topic/detail")
    Flowable<TopDetailBean> getTopDetail(@Query("id") int id);
    //专题推荐
    @GET("topic/related")
    Flowable<TopRecommend> getTopRecommend(@Query("id") int id);
    //商品购买页面的数据接口
    @GET("goods/detail")
    Flowable<RelatedBean> getRelatedData(@Query("id") int id);

    //添加到购物车
    @POST("cart/add")
    @FormUrlEncoded
    Flowable<AddShopBean> addshop(@Field("goodsId") String goodsId, @Field("number") String number, @Field("productId")String productId);

    @GET("goods/related")
    Flowable<RelatedBottonBean> getBottonBean(@Query("id") int id);
    //验证码
    @GET("auth/verify")
    Flowable<VerifyBean> getVerify();
    //登录
    @POST("auth/login")
    @FormUrlEncoded
    Flowable<UserBean> login(@Field("nickname") String nickname, @Field("password") String password);

    //注册
    @POST("auth/register")
    @FormUrlEncoded
    Flowable<UserBean> regist(@Field("nickname") String nickname, @Field("password") String password,@Field("verify") String verify);


    //获取购物车的数据
    @GET("cart/index")
    Flowable<CartBean> getCartIndex();

    //购物车商品数据的选中或取消
    @POST("cart/checked")
    @FormUrlEncoded
    Flowable<CartGoodsCheckBean> setCartGoodsCheck(@Field("productIds") String pids, @Field("isChecked") int isChecked);


    //更新商品的数据
    @POST("cart/update")
    @FormUrlEncoded
    Flowable<CartGoodsUpdateBean> updateCartGoods(@Field("productId") String pids, @Field("goodsId") String goodsId, @Field("number") int number, @Field("id") int id);


    //删除商品
    @POST("cart/delete")
    @FormUrlEncoded
    Flowable<CartGoodsDeleteBean> deleteCartGoods(@Field("productIds") String pids);

    //地址列表
    @GET("address/list")
    Flowable<AddressBean> getAddress();

    //保存地址
    @POST("address/save")
    @FormUrlEncoded
    Flowable<AdressSaveBean> saveAdress(@FieldMap Map adressMap);

    //获取省市区的数据
    @GET("region/list?parentId=39")
    Flowable<RegionBean> getRegion(@Query("parentId") int parentId);


    //下单前的订单确认  地址ID+优惠券ID
    @GET("cart/checkout")
    Flowable<OrderInfoBean> getOrderInfo(@Query("addressId") int addressId, @Query("couponId") int couponId);




}
