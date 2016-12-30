package com.example.adbdemo.event;

import android.widget.CompoundButton;

import com.example.adbdemo.bean.User;

/**
 * Created by dell on 2016/9/29.
 */
public class ColorChangeEvent  {

    private User user;
    public ColorChangeEvent(User user){
        this.user= user;
    }

    public CompoundButton.OnCheckedChangeListener rb_redchangelistener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if( isChecked){
                user.isred.set(true);
            }else
                user.isred.set(false);
        }
    };

}
