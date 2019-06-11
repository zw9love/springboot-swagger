package com.roncoo.swagger.util;

import java.util.Timer;

/**
 * @author zenngwei
 * @date 2019/6/11
 */
public class TimerTest01 {
    Timer timer;
    public TimerTest01(int time){
        timer = new Timer();
        timer.schedule(new TimerTaskTest(), time * 1000);
    }

    public static void main(String[] args) {
        System.out.println("timer begin....");
        new TimerTest01(3);
    }
}