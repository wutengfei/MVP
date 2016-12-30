package com.example.mvp;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mvp.bean.User;
import com.example.mvp.presenter.IoperationView;
import com.example.mvp.presenter.UserPresenter;


public class MainActivity extends AppCompatActivity implements IoperationView {

    //1.用户界面展示
    //2.用户输入
    //3.按钮点击
    //4.判断用户输入
    //5.显示滚动条
    //6.一系列耗时工作
    //7.隐藏
    //8.提示用户

    //mvp在Activity中将视图层和业务层分离处理
    private EditText etUsername;
    private EditText etPassword;
    private ProgressDialog dialog;
    private User user;

    private UserPresenter userPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.password);
        dialog = new ProgressDialog(MainActivity.this);
        userPresenter = new UserPresenter(this);
    }

    public void login(View view){
        String username =etUsername.getText().toString();
        String password = etPassword.getText().toString();
        final User user = new User(username,password);
        //弹出对话框提示
        dialog.setTitle("等待...");
        dialog.show();
        //基础校验
        boolean falge = userPresenter.checkUser(user);
        if( falge){
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
