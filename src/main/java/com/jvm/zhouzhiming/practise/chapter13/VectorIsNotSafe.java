package com.jvm.zhouzhiming.practise.chapter13;

import java.util.Vector;

/**
 * <P>Description: Vector也不是绝对线程安全的 - 那是不可能的，这个设定不是vector的线程安全问题. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月20日 </P>
 * <P>UPDATE DATE: 2017年9月20日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class VectorIsNotSafe {

    private static Vector<Integer> vector = new Vector<Integer>(1000, 100);

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });

            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }

            });
            removeThread.start();
            printThread.start();
            while (Thread.activeCount() > 20) {

            }
        }
    }
}
