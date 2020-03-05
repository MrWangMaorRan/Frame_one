package com.jy.frame_one.persenter.topic;


import com.jy.frame_one.base.BasePersenter;
import com.jy.frame_one.common.CommonSubscriber;
import com.jy.frame_one.interfaces.topic.TopicConstract;
import com.jy.frame_one.models.HttpManager;
import com.jy.frame_one.models.bean.TopicBean;
import com.jy.frame_one.utils.RxUtils;

public class TopicPersenter extends BasePersenter<TopicConstract.View> implements TopicConstract.Persenter {
    @Override
    public void getTopicData() {
        addSubscribe(HttpManager.getInstance().getShopApi().getTopicData()
                .compose(RxUtils.<TopicBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<TopicBean>(mView){

                    @Override
                    public void onNext(TopicBean topicBean) {
                        mView.getTopicDataReturn(topicBean);
                    }
                }));
    }
}
