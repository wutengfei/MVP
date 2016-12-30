package com.example.mvp.presenter;

/**
 * Created by dell on 2016/9/28.
 */
public interface IoperationView {
    /*
       操作正确方法，如果有需求可以提供参数，当然参数依然可以设计成接口
     */
    public void success();

    /**
     * 操作失败方法
     */
    public void failure();
}
