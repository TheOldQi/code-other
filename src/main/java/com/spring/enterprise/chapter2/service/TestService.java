package com.spring.enterprise.chapter2.service;

import com.spring.enterprise.chapter2.dao.LoginLogDao;
import com.spring.enterprise.chapter2.domain.LoginLogPo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * <P>Description:  读写分离测试. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/9/28</P>
 * <P>UPDATE DATE: 2017/9/28</P>
 *
 * @author qixiafei
 * @version 0.0.3-SNAPSHOT
 * @since java 1.7.0
 */
public class TestService {
    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath*:spring-context.xml");
        LoginLogDao dao = context.getBean(LoginLogDao.class);
        System.out.println(dao.list());
        LoginLogPo forIn = new LoginLogPo();
        forIn.setIp(Inet4Address.getLocalHost().getHostAddress());
        forIn.setLoginDate(new Date());
        forIn.setUserId(111);
        dao.insert(forIn);
    }
}
