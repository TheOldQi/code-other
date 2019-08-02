package com.concurrent.art.basic.intro;

import java.util.concurrent.TimeUnit;

/**
 * <P>Description: 守护线程示例. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/21</P>
 * <P>UPDATE DATE: 2017/12/21</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class DeamonThread {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 睡一下等待主线程结束
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("守护线程finally被执行了");
                }
            }
        });
        //设为守护线程必须在线程启动之前.
        t.setName("守护线程");
        t.setDaemon(true);
        t.start();
    }

}
