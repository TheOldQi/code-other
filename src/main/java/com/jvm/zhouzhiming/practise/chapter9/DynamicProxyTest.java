package com.jvm.zhouzhiming.practise.chapter9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月22日 </P>
 * <P>UPDATE DATE: 2017年9月22日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        /* (non-Javadoc)
         * @see com.jvm.zhouzhiming.practise.chapter9.DynamicProxyTest.IHello#sayHello()
         */
        @Override
        public void sayHello() {
            System.out.println("Hello world!");
        }

    }

    static class DynamicProxy implements InvocationHandler {
        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    originalObj.getClass().getInterfaces(), this);
        }

        /* (non-Javadoc)
         * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            method.invoke(originalObj, args);
            System.out.println("bye");
            return null;
        }
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello ihello = (IHello) new DynamicProxy().bind(new Hello());
        ihello.sayHello();
    }
}
