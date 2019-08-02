package com.self.loadorder;

/**
 * <P>Description: 抽象父类方法. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月12日 </P>
 * <P>UPDATE DATE: 2017年9月12日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public abstract class AbstractFather {


    {
        System.out.println("father block1 init.");
    }

    protected AbstractFather() {
        System.out.println("father constructor init.");
        System.out.println(A.a);
    }

    static {
        System.out.println("father static block init.");
    }

    {
        System.out.println("father block2 init.");
    }

    private static class A {
        private static String a;

        static {
            System.out.println("father's inner class static block init.");
        }

        {
            System.out.println("father's inner class block init.");
        }


    }
}
