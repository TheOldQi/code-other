package com.jvm.zhouzhiming.practise;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <P>Description: 测试Volatile. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月18日 </P>
 * <P>UPDATE DATE: 2017年9月18日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class VolatileTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        VolatileObj.increase();
                    }

                }
            });
            t.start();

        }

        while (Thread.activeCount() > 1) {

        }
        System.out.println(VolatileObj.a);
//		Thread.sleep(100000);
    }


    private static class VolatileObj {
        private static volatile int a;

        public static void increase() {
            a++;
        }
    }
}
