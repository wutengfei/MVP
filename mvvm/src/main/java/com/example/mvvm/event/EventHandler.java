package com.example.mvvm.event;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.mvvm.bean.User;

import java.util.logging.Logger;


/**
 * Created by dell on 2016/9/29.
 */
public class EventHandler {
    private User user;
    public EventHandler(User user){
        this.user= user;
    }
    /**
     * username watcher
     */
    public TextWatcher usernameWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {    }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {      }
        @Override
        public void afterTextChanged(Editable s) {
            Log.i("watcher",s.toString());
            user.username.set(s.toString());
        }
    };
    /**
     * password watcher
     */
    public TextWatcher passwordWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {    }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {      }
        @Override
        public void afterTextChanged(Editable s) {
            Log.i("watcher",s.toString());
            user.password.set(s.toString());
        }
    };
    /**
     * color change listener
     */
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
