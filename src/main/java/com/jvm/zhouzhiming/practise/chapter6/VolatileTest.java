package com.jvm.zhouzhiming.practise.chapter6;

/**
 * <p>
 * Description: .
 * </P>
 * <p>
 * CALLED BY: 齐霞飞
 * </P>
 * <p>
 * UPDATE BY: 齐霞飞
 * </P>
 * <p>
 * CREATE DATE: 2017年9月21日
 * </P>
 * <p>
 * UPDATE DATE: 2017年9月21日
 * </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class VolatileTest {

    private volatile String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            final VolatileTest obj = new VolatileTest();
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("getValue:" + obj.getValue());
                }

            });

            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    obj.setValue("xixi");
                    System.out.println("setValue:");
                }

            });
            a.start();
            b.start();

        }

    }

}
