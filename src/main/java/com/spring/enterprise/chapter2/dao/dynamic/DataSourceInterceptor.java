package com.spring.enterprise.chapter2.dao.dynamic;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * <P>Description:  实现读写分离. </P>
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
public class DataSourceInterceptor {

    public void beforeQuery(JoinPoint joinPoint) {
        System.out.println("switch datasource to 192.168.59.130");
        DataSourceHolder.setDatasource("read");
    }

    public void beforeUpdate(JoinPoint joinPoint) {
        System.out.println("switch datasource to 192.168.59.129");
        DataSourceHolder.setDatasource("write");
    }
}
