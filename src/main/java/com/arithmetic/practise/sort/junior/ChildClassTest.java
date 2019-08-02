package com.arithmetic.practise.sort.junior;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年8月24日 </P>
 * <P>UPDATE DATE: 2017年8月24日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class ChildClassTest extends SupperClassTest {

    private Integer a = 2;


    public static void main(String[] args) {
        SupperClassTest b = new ChildClassTest();
        b.printClass();
    }
}
