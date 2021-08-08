package com.tom.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author Alfalfa99
 * @version 1.0
 * @date 2020/10/22 14:37
 * 获取当前时间戳 <==> 获取当前标准时间
 */
@Component
public class DateTimeTransferUtil {



    public static Long getNowTimeStamp(){
        Long time = System.currentTimeMillis() / 1000;
        return time;

    }

    public static String getFormatTime(){
        String format = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(format, Locale.CHINA).format(new Date());
    }

    public static String helpCreateFolds(){
        return Calendar.getInstance().get(Calendar.YEAR) + "/" + (Calendar.getInstance().get(Calendar.MONTH)+1)+"/";
    }
}
