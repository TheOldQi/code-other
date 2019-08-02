package com.self.cnblog.desginmode.singleton;

/**
 * <P>Description: 只能运行与单线程的单例模式. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月19日 </P>
 * <P>UPDATE DATE: 2017年9月19日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class SingletonSingleThread {

    private static SingletonSingleThread instance;

    private SingletonSingleThread() {
    }

    public static SingletonSingleThread getInstance() {
        if (instance == null) {
            instance = new SingletonSingleThread();
        }
        return instance;
    }
}
