package com.jvm.zhouzhiming.practise.chapter3;

/**
 * <P>Description: Gc时自救，利用finalize方法会且只会在对象的生命周期内被执行一次在对象要被垃圾回收之前
 * 将自己和静态变量的引用绑定在一期进行自救，但是当相同的代码第二次执行的时候，finalize不会再次执行，对应已被回收. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月4日 </P>
 * <P>UPDATE DATE: 2017年9月4日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class GcSaveSelf {

    private static GcSaveSelf SELF_HOLDER = null;

    private void isAlive() {
        System.out.println("I'm still alive!");
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        SELF_HOLDER = this;
    }

    public static void main(String[] args) {
        SELF_HOLDER = new GcSaveSelf();

        SELF_HOLDER = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (SELF_HOLDER != null) {
            SELF_HOLDER.isAlive();
        } else {
            System.out.println("I'm dead!");
        }

        SELF_HOLDER = null;
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (SELF_HOLDER != null) {
            SELF_HOLDER.isAlive();
        } else {
            System.out.println("I'm dead!");
        }

    }

}
