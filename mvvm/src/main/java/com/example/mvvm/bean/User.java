package com.example.mvvm.bean;

import android.database.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

/**
 * Created by dell on 2016/9/22.
 */
public class User {
    public final ObservableField<String> username =new ObservableField<>();
    public final ObservableField<String> password =new ObservableField<>();
    public final ObservableBoolean isred = new ObservableBoolean();

}
