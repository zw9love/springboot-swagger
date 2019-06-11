package com.roncoo.swagger.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author zenngwei
 * @date 2019/6/11
 */
public class TimerTest02 {
    Timer timer;

    public TimerTest02(){
        Date time = getTime();
        System.out.println("指定时间time=" + time);
        timer = new Timer();
        timer.schedule(new TimerTaskTest(), time);
    }

    public Date getTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 28);
        calendar.set(Calendar.SECOND, 00);
        Date time = calendar.getTime();

        return time;
    }

    public static void main(String[] args) {
        new TimerTest02();
    }
}
