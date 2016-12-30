package com.example.adbdemo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dell on 2016/9/29.
 */
public class DateFromtUtil {

    public static String formt(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        return sdf.format(date);
    }
}
