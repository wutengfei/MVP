package com.example.mvvm;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mvvm.bean.User;
import com.example.mvvm.databinding.ActivityMainBinding;
import com.example.mvvm.event.EventHandler;
import com.example.mvvm.presenter.IoperationView;
import com.example.mvvm.presenter.UserPresenter;


public class MainActivity extends AppCompatActivity implements IoperationView {

    //1.用户界面展示
    //2.用户输入
    //3.按钮点击
    //4.判断用户输入
    //5.显示滚动条
    //6.一系列耗时工作
    //7.隐藏
    //8.提示用户

    //mvvm在Activity中将视图层和model层分离处理
    private User user;
    private EventHandler event;
    private UserPresenter userPresenter;

    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        dialog = new ProgressDialog(this);

        userPresenter = new UserPresenter(this);
        user = new User();
        user.isred.set(true);
        // binding event
        event = new EventHandler(user);
        binding.setUser(user);
        binding.setEventhandler(event);
    }


    public void login(View view){

        //基础校验
        Toast.makeText(MainActivity.this,user.username.get()+" : "+user.password.get(),Toast.LENGTH_SHORT).show();
        boolean falge = userPresenter.checkUser(user);
        if( falge){ //弹出对话框提示
            dialog.setTitle("等待...");
            dialog.show();
            //发送到服务端
            userPresenter.sendUser(user);
        }else{

            Toast.makeText(MainActivity.this,"请填写账号密码",Toast.LENGTH_SHORT).show();
        }
    }

    //登录成功提示方法
    public void success(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                        dialog.dismiss();
                Toast.makeText(MainActivity.this,"欢迎归来",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //登录失败提示方法
    public void failure() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "请填写账号密码", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
