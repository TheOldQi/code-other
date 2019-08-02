package com.concurrent.art.containerandframework;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <P>Description: 多线程情况下HashMap会导致死循环测试（无法重现）. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/1/4</P>
 * <P>UPDATE DATE: 2018/1/4</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class HashMapDeadCycle {
    private static final HashMap m = new HashMap();
    private static final ConcurrentHashMap m2 = new ConcurrentHashMap();

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        final AtomicInteger count = new AtomicInteger(100000);
        long start = System.currentTimeMillis();
        Thread t = new Thread(() -> {
            try {
                // 等待主线程开始wait
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始执行");
            for (int i = 0; i < 100000; i++) {
                new Thread(() -> {
                    m.put(UUID.randomUUID().toString(), "");
                    synchronized (main) {
                        main.notify();
                        count.decrementAndGet();

                    }
                }, "t1 - " + i).start();
            }
        });
        t.start();
        synchronized (main) {
            while (count.get() > 0) {
                main.wait();
            }
        }
        System.out.println("t1 elapse " + (System.currentTimeMillis() - start) + "map size :" + m.size());
        count.set(100000);
        long start2 = System.currentTimeMillis();
        Thread t2 = new Thread(() -> {
            try {
                // 等待主线程开始wait
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始执行");
            for (int i = 0; i < 100000; i++) {
                new Thread(() -> {
                    m2.put(UUID.randomUUID().toString(), "");
                    synchronized (main) {
                        main.notify();
                        count.decrementAndGet();
                    }
                }, "t2 - " + i).start();
            }
        });
        t2.start();
        synchronized (main) {
            while (count.get() > 0) {
                main.wait();
            }
        }
        System.out.println("t2 elapse " + (System.currentTimeMillis() - start2) + "map size :" + m2.size());
    }

}
