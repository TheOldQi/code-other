package com.self.overflow;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月13日 </P>
 * <P>UPDATE DATE: 2017年9月13日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class OverFlowTest {


    public static void main(String[] args) {
        while (true) {
            A a = new A();
        }
    }

    private static class A {
        private B b = new B();

        {
            b.setA(this);
        }
    }

    private static class B {
        private A a;

        private void setA(A a) {
            this.a = a;
        }
    }
}
