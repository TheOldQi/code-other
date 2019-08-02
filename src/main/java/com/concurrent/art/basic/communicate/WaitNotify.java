package com.concurrent.art.basic.communicate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <P>Description: 等待/通知示例. </P>
 * <p>这个示例中包含wait()/notify()的设计范式：</p>
 * <p>=========wait方=======：
 * 1、获得对象的锁
 * 2、检查条件，若不满足，wait()释放对象锁，被通知后仍要检查条件是否满足，若不满足继续调用wait()
 * 3、条件满足则执行逻辑</p>
 * <p>
 * 伪代码：
 * synchronized (对象) {
 * while (条件) {
 * try {
 * 对象.wait();
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 * }
 * .....
 * }</p>
 * <p>
 * =========notify方=======：
 * 1、获取对象锁
 * 2、改变条件
 * 3、通知所有等待在对象上的线程
 * </p>
 * <p>
 * 伪代码：
 * synchronized (对象) {
 * 改变条件;
 * 对象.notifyAll();
 * }
 * </p>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Wait(), "Thread - Wait");
        t1.start();
        // 睡一下保证t1已经拿到lock对象的锁
        TimeUnit.MILLISECONDS.sleep(20);
        new Thread(new Notify(), "Thread - Notify").start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " flag is true. wait @" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " flag is false. running @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " hold lock. notify @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                // 就算notifyAll了，其他等待用wait()释放锁的线程依然需要等待锁释放才会执行
                flag = false;
                System.out.println(Thread.currentThread().getName() + " set flag = false @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 走到这会释放lock对象锁，接下来Wait线程和Notify线程就会公平竞争执行权利，下面这块同步快和Wait线程的while循环下面的
            // 代码都有可能先抢到lock对象锁
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @"
                        + new SimpleDateFormat(" HH:mm:ss").format(new Date()));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
