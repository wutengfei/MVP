package com.example.dell.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.myapplication.bean.User;
import com.example.dell.myapplication.net.UserLoginNet;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //1.用户界面展示
    //2.用户输入
    //3.按钮点击
    //4.判断用户输入
    //5.显示滚动条
    //6.一系列耗时工作
    //7.隐藏
    //8.提示用户

    private EditText etUsername;
    private EditText etPassword;
    private ProgressDialog dialog;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.password);
        dialog = new ProgressDialog(MainActivity.this);
    }

    public void login(View view){
        String username =etUsername.getText().toString();
        String password = etPassword.getText().toString();
        final User user = new User(username,password);

        dialog.setTitle("等待...");
        dialog.show();
        boolean falge = checkUser(user);//基础校验

        if( falge){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //耗时操作
                    UserLoginNet loginNet = new UserLoginNet();
                    boolean result = loginNet.sendUser(user);
                    //耗时操作结果
                    if(result){
                        //返回结果到V
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this,"欢迎归来",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        //返回结果
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this,"账号错误",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }).start();
        }else{
            Toast.makeText(MainActivity.this,"请填写账号密码",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 基础校验
     * @param user
     * @return
     */
    public boolean checkUser(User user) {
        if( user ==null || TextUtils.isEmpty(user.getUsername())|| TextUtils.isEmpty(user.getPassword()))
            return false;
        else
            return true;
    }
}
