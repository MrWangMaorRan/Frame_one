package com.jy.frame_one.common;



import com.jy.frame_one.appss.MyApp;

import java.io.File;

public class Constant {

    //练习的地址
    public static final String BASE_FULI_URL="http://gank.io/api/";
    //商城的基础地址
    public static final String BASE_SHOP_URL = "https://cdwan.cn/api/";

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/shop";

    public static final String PRICE_MODEL = "$元起";
}
