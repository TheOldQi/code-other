package com.jvm.zhouzhiming.practise.chapter7;

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
public class ClassLoadTest {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }


}

class SuperClass {
    static {
        System.out.println("super init");
    }

}

class SubClass extends SuperClass {
    static {
        System.out.println("sub init");
    }

    public static final int value = 123;
}