package com.jy.frame_one.models.api;


import com.jy.frame_one.models.bean.FuLiBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface FuLiApi {

    @GET("data/%E7%A6%8F%E5%88%A9/10/3")
    Flowable<FuLiBean> getFuLi();
}
