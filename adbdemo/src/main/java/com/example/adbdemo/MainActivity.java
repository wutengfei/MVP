package com.example.adbdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.adbdemo.bean.User;
import com.example.adbdemo.databinding.ActivityMainBinding;
import com.example.adbdemo.event.ColorChangeEvent;

import java.util.Date;

/**
 * Created by dell on 2016/9/29.
 */
public class MainActivity extends AppCompatActivity {
    private User user;
    private  ColorChangeEvent colorChangeEvent ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        user = new User();
        initUser(user);
        colorChangeEvent= new ColorChangeEvent(user);
        binding.setUser(user);
        binding.setColorChangeEvent(colorChangeEvent);
    }

    private void initUser(User user) {
        user.age.set(21);
        user.birthday.set(new Date());
        user.name.set("zhouliang");
        user.isred.set(true);
        user.isgay.set(false);
    }


    public void changegay(View view){
        Toast.makeText(this,"change 1s later",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                user.isgay.set(!user.isgay.get());
            }
        }).start();

    }
}
