package com.example.mvvm.presenter;

import android.text.TextUtils;

import com.example.mvvm.bean.User;
import com.example.mvvm.net.UserLoginNet;

/**
 * Created by dell on 2016/9/26.
 */
public class UserPresenter {

    /**
     * 利用回调将结果返回界面
     */
    private IoperationView view;
    //通过构造函数传入
    public UserPresenter(IoperationView view){
        this.view = view;
    }
    /**
     * 基础校验
     * @param user
     * @return
     */
    public boolean checkUser(User user) {
        if( user ==null || TextUtils.isEmpty(user.username.get())|| TextUtils.isEmpty(user.password.get()))
            return false;
        else
            return true;
    }
    /**
     * 模拟联网访问服务器
     * @param user
     */
    public void sendUser(final User user) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //耗时操作
                UserLoginNet loginNet = new UserLoginNet();
                boolean result = loginNet.sendUser(user);
                //耗时操作结果
                if(result){
                    //返回结果到V
                    view.success();
                }else{
                    //返回结果
                    view.failure();
                }
            }
        }).start();
    }
}
