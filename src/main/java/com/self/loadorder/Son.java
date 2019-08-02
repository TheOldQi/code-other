package com.self.loadorder;

/**
 * <P>Description: 子类. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月12日 </P>
 * <P>UPDATE DATE: 2017年9月12日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class Son extends AbstractFather {

    {
        System.out.println("son block1 init.");
    }

    public Son() {
        super();
        System.out.println("son constructor init.");
    }

    static {
        System.out.println("son static block init.");
    }

    {
        System.out.println("son block2 init.");
    }
}
