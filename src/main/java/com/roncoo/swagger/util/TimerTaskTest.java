package com.roncoo.swagger.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zenngwei
 * @date 2019/6/11
 */
public class TimerTaskTest extends TimerTask {

    public void run() {
//        System.out.println("Time's up!!!!");
//        System.out.println("指定时间执行线程任务...");
        Date date = new Date(this.scheduledExecutionTime());
        System.out.println("本次执行该线程的时间为：" + date);
    }
}