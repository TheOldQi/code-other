package com.concurrent.art.basic.communicate;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>Description: 线程的Join方法示例. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class Join {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Thread pre = null;
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new JoinRunner(pre), "Thread " + i);
            threads.add(t);
            pre = t;
        }
        for (Thread t : threads) {
            t.start();
        }
    }

    static class JoinRunner implements Runnable {
        private Thread pre;

        JoinRunner(Thread pre) {
            this.pre = pre;
        }

        @Override
        public void run() {
            if (pre != null) {
                try {
                    pre.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName());
        }
    }
}
