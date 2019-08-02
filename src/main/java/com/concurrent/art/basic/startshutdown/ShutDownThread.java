package com.concurrent.art.basic.startshutdown;

import java.util.concurrent.TimeUnit;

/**
 * <P>Description: 优雅的终止线程的方法. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class ShutDownThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new CountRunner(), "Thread - CountRunner");
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
        CountRunner countRunner = new CountRunner();
        Thread t2 = new Thread(countRunner, "Thread - CountRunner");
        t2.setDaemon(true);
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        countRunner.cancel();
        TimeUnit.SECONDS.sleep(10);
    }

    static class CountRunner implements Runnable {
        private long count = 0;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                count++;
            }
            System.out.println("count = " + count);
        }

        public void cancel() {
            on = false;
        }
    }
}
