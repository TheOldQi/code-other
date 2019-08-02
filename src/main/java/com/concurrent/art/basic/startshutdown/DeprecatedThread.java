package com.concurrent.art.basic.startshutdown;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <P>Description: 被弃用的线程方法，suspend()，resume(),stop(). </P>
 * <p>之所以被弃用是因为suspend()后线程会持有着锁，有可能引发死锁。
 * 而stop()方法会立即停止线程，可能会造成线程资源没有正确关闭，正式因为这些副作用所以这三个方法被弃用</p>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class DeprecatedThread {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runner(), "Thread-Runner");
//        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(3);
        t.suspend();
        System.out.println("线程" + t.getName() + "运行被暂停");
        TimeUnit.SECONDS.sleep(3);
        t.resume();
        System.out.println("线程" + t.getName() + "运行被恢复");
        TimeUnit.SECONDS.sleep(3);
        t.stop();
        System.out.println("线程" + t.getName() + "被终止");
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run  at" + dateFormat.format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
