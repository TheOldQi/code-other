package com.spring.enterprise.chapter7;

import org.springframework.stereotype.Component;

/**
 * <P>Description: 测试AOp . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/9/28</P>
 * <P>UPDATE DATE: 2017/9/28</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
@Component
public class AopTest implements AopTestInterface {

    public void methodA() {
        System.out.println("MethodA do");
    }

    public void methodB(String name) {
        System.out.println("MethodB do" + name);

    }
}
