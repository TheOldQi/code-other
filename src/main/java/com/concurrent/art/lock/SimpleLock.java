package com.concurrent.art.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2017/12/29</P>
 * <P>UPDATE DATE: 2017/12/29</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class SimpleLock {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        // 加锁不要在try块中，如果加锁发生异常也会导致锁无故释放
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }
}
