package com.spring.enterprise.chapter7;

import com.spring.enterprise.chapter2.domain.UserPo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <P>Description:  . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/9/28</P>
 * <P>UPDATE DATE: 2017/9/28</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
public class Entry {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        AopTest aopTest = (AopTest) proxy.getEnhancer(AopTest.class);
        aopTest.methodA();
        aopTest.methodB("qxf");

        UserPo userPo = (UserPo) proxy.getEnhancer(UserPo.class);
        userPo.setUserId(1234);
        System.out.println(userPo.getUserId());

    }
}
