package com.roncoo.swagger.util;

import java.util.Timer;

/**
 * @author zenngwei
 * @date 2019/6/11
 */
public class TimerTest03 {
    Timer timer;

    public TimerTest03(){
        timer = new Timer();
        timer.schedule(new TimerTaskTest(), 1000, 2000);
    }

    public static void main(String[] args) {
        new TimerTest03();
    }
}
