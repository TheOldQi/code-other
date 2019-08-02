package com.self;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月21日 </P>
 * <P>UPDATE DATE: 2017年9月21日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class NanoTimeTest {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Thread.sleep(10000);
        System.out.println((System.nanoTime() - start) / 1000000);
    }
}
