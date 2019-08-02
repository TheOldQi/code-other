package com.concurrent.art.basic.startshutdown;

import java.util.concurrent.TimeUnit;

/**
 * <P>Description: 线程中断. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class InterruptedThread {


    public static void main(String[] args) throws InterruptedException {
        Thread sleepT = new Thread(new SleepThread(), "sleepThread");
        sleepT.setDaemon(true);
        Thread busyT = new Thread(new BusyThread(), "busyThread");
        busyT.setDaemon(true);
        sleepT.start();
        busyT.start();
        // 睡眠5秒让sleep线程和busy线程重复运行
        TimeUnit.SECONDS.sleep(5);
        sleepT.interrupt();
        busyT.interrupt();
        System.out.println("SleepThread is Interrupted?" + sleepT.isInterrupted());
        System.out.println("BusyThread is Interrupted?" + busyT.isInterrupted());
    }

    static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
