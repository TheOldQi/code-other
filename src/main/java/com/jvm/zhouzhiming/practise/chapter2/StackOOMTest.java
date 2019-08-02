package com.jvm.zhouzhiming.practise.chapter2;

/**
 * <P>Description: 栈内存溢出.</P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/10/9</P>
 * <P>UPDATE DATE: 2017/10/9</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
public class StackOOMTest {

    public static void main(String[] args) {
//        JvmStackSOF sof = new JvmStackSOF();
//        try {
//
//            sof.stackLeak();
//        }catch (Throwable e){
//            System.out.println("stack length"+sof.stackLength);
//            throw  e;
//        }
        while (true) {
            Thread a = new Thread(new JvmStackOOM());
            a.start();
        }

    }

    /**
     * 单线程增加栈深度导致StackOverFlow，jvm参数 -Xss128k .
     */
    public static class JvmStackSOF {
        private int stackLength = 1;

        public void stackLeak() {
            stackLength++;
            stackLeak();
        }
    }

    /**
     * 多线程不断建立线程导致OutOfMemeryError,jvm参数-Xss200M
     */
    public static class JvmStackOOM implements Runnable {

        @Override
        public void run() {
            while (true) {
                // 不让线程结束
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
