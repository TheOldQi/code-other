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
public class SupperClassTest {
    private Integer a = 1;

    public Integer getA() {
        return this.a;
    }

    protected String getSuperClass() {
        return getClass().toString();
    }

    public void printClass() {
        System.out.println(getSuperClass());
    }
}
