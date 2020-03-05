package com.jy.frame_one.ui.fragments.topic;



import com.jy.frame_one.R;
import com.jy.frame_one.adapter.TopicAdapter;
import com.jy.frame_one.base.BaseFragment;
import com.jy.frame_one.interfaces.topic.TopicConstract;
import com.jy.frame_one.models.bean.TopicBean;
import com.jy.frame_one.persenter.topic.TopicPersenter;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class TopicFragment extends BaseFragment<TopicConstract.Persenter> implements TopicConstract.View {

    @BindView(R.id.topic_recy)
    RecyclerView mTopic_recy;
    private ArrayList<TopicBean.DataBean.TopicListBean> topicBean;
    private TopicAdapter topicAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initView() {
        topicBean = new ArrayList<>();
        topicAdapter = new TopicAdapter(topicBean, context);
        mTopic_recy.setLayoutManager(new LinearLayoutManager(getContext()));
        mTopic_recy.setAdapter(topicAdapter);
    }

    @Override
    protected void initData() {
        persenter.getTopicData();
    }

    @Override
    protected TopicConstract.Persenter createPersenter() {
        return new TopicPersenter();
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        topicAdapter.updata(result.getData().getTopicList());
    }
}
