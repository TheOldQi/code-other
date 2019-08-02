package com.concurrent.art.basic.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <P>Description: 数据库连接池. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/25</P>
 * <P>UPDATE DATE: 2017/12/25</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class DbPool {

    private LinkedList<Connection> pool = new LinkedList<>();
    static DbPool dbPool = new DbPool(10);
    // 实现所有线程一起运行
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 20;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread-" + i);
            t.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke :" + (threadCount + count));
        System.out.println("got connection:" + got);
        System.out.println("not got connection:" + notGot);
    }

    static class ConnectionRunner implements Runnable {
        // 尝试获取多少次
        int count;
        // 获取到的连接数
        AtomicInteger got;
        // 未获取到连接数
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            while (count > 0) {
                try {
                    // 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
                    // 分别统计连接获取的数量got和未获取到的数量notGot
                    Connection connection = dbPool.fetch(1000);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            dbPool.release(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }

    public DbPool(int initSize) {

        if (initSize > 0) {
            for (int i = 0; i < initSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void release(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetch(long millis) throws InterruptedException {
        synchronized (pool) {
            if (millis <= 0) {
                // 无限等待
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                // 超时等待
                long future = System.currentTimeMillis() + millis;
                long remain = millis;
                while (pool.isEmpty() && remain >= 0) {
                    pool.wait();
                    remain = future - System.currentTimeMillis();
                }
                if (!pool.isEmpty()) {
                    return pool.removeFirst();
                }
                //超时返回null
                return null;
            }
        }
    }

    /**
     * 获取数据库连接驱动，使用代理类对Connection接口做增强，将commit方法修改为只沉睡100毫秒.
     */
    static class ConnectionDriver {

        static class ConnectionHandler implements InvocationHandler {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("commit")) {
                    TimeUnit.MILLISECONDS.sleep(100);
                }
                return null;
            }
        }

        public static Connection createConnection() {
            return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
                    new Class<?>[]{Connection.class}, new ConnectionHandler());
        }
    }
}
