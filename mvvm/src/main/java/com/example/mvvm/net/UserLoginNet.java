package com.example.mvvm.net;

import android.text.TextUtils;

import com.example.mvvm.bean.User;


/**
 * Created by dell on 2016/9/22.
 */
public class UserLoginNet {

    public boolean sendUser(User user){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if( user !=null){
            if(TextUtils.equals(user.username.get(),"liang")&& TextUtils.equals(user.password.get(),"123"))
                return true;
        }
        return false;
    }
}
