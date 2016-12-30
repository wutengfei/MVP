package com.example.adbdemo.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import java.util.Date;

/**
 * Created by dell on 2016/9/29.
 */
public class User {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableBoolean isgay = new ObservableBoolean();
    public final ObservableInt age = new ObservableInt();
    public final ObservableField<Date> birthday = new ObservableField<Date>();
    public final ObservableBoolean isred = new ObservableBoolean();


    public User() {
    }

}
