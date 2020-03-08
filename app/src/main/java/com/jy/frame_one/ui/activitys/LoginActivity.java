package com.jy.frame_one.ui.activitys;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.jy.frame_one.R;
import com.jy.frame_one.base.BaseActivity;
import com.jy.frame_one.interfaces.shopping.LoginConstract;
import com.jy.frame_one.models.bean.UserBean;
import com.jy.frame_one.persenter.shopping.LoginPersenter;
import com.jy.frame_one.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginConstract.Persenter> implements LoginConstract.View {
    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.regist)
    TextView regist;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected LoginConstract.Persenter createPersenter() {
        return new LoginPersenter();
    }

    @Override
    public void loginReturn(UserBean result) {
        //登录成功以后存入sp
        SpUtils.getInstance().setValue("token",result.getData().getToken());
        String errmsg = result.getErrmsg();
        Toast.makeText(this,errmsg,Toast.LENGTH_SHORT).show();
        finish();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String nickname = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        persenter.login(nickname,password);
    }
}
