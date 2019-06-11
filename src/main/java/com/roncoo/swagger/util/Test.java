package com.roncoo.swagger.util;

import java.util.Timer;
import java.util.TimerTask;

public class Test {

    public static void main(String[] args) {
        // 拿到都是毫秒
        // System.out.println(System.currentTimeMillis());
        // System.out.println(new Date().getTime());
        System.out.println(MyUtil.getRandomString()); // 随机24位字符串
    }
}

//public class TimerTest01 {
//    Timer timer;
//    public TimerTest01(int time){
//        timer = new Timer();
//        timer.schedule(new TimerTaskTest(), time * 1000);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("timer begin....");
//        new TimerTest01(3);
//    }
//}
//
//public class TimerTaskTest extends TimerTask {
//
//    public void run() {
//        System.out.println("Time's up!!!!");
//    }
//}
