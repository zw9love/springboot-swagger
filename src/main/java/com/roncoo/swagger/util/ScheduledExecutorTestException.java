package com.roncoo.swagger.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zenngwei
 * @date 2019/6/11
 */
public class ScheduledExecutorTestException {

    private ScheduledExecutorService scheduExec;

    public long start;

    ScheduledExecutorTestException(){
        this.scheduExec =  Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void timerOne(){
        scheduExec.schedule(new Runnable() {
            public void run() {
                throw new RuntimeException();
            }
        },1000,TimeUnit.MILLISECONDS);
    }

    public void timerTwo(){
        scheduExec.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("timerTwo invoked .....");
            }
        },2000,500,TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorTest test = new ScheduledExecutorTest();
        test.timerOne();
        test.timerTwo();
    }
}
