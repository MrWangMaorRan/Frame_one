package com.jy.frame_one.interfaces.topic;


import com.jy.frame_one.interfaces.IBasePersenter;
import com.jy.frame_one.interfaces.IBaseView;
import com.jy.frame_one.models.bean.TopicBean;

public interface TopicConstract {
    interface View extends IBaseView {
        void getTopicDataReturn(TopicBean result);
    }

    interface Persenter extends IBasePersenter<View> {
        void getTopicData();
    }
}
