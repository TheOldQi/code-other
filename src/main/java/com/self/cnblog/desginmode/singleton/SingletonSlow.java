package com.self.cnblog.desginmode.singleton;

/**
 * <P>Description: 效率较低的单例实现. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017年9月19日 </P>
 * <P>UPDATE DATE: 2017年9月19日 </P>
 *
 * @author qixiafei
 * @version 0.0.1-SNAPSHOT
 * @since java 1.7.0
 */
public class SingletonSlow {

    private static SingletonSlow instance;

    private SingletonSlow() {
    }

    public synchronized static SingletonSlow getInstance() {
        if (instance == null) {
            instance = new SingletonSlow();
        }
        return instance;
    }
}
