package com.concurrent.art.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <P>Description: 自定义互斥锁实现. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE DATE: 2018/1/3</P>
 * <P>UPDATE DATE: 2018/1/3</P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class MutexLock implements Lock {

    /**
     * 锁的同步器，锁的功能都是基于同步器实现的.
     */
    private static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -7502682040043717678L;

        /**
         * 是否处于占用状态.
         *
         * @return true 占用，false 未占用
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 尝试获取锁，所有的同步器获取锁的方法都是调用这个重写方法，必须保证线程安全，
         * 这里是使用的父类的Unsafe调用堆外直接内存的cas操作方法compareAndSetState().
         *
         * @param arg 额外的参数，在本示例中未使用，可以代表获取模式等任意自定义意义
         * @return true 获取锁成功，false 获取锁失败
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁.
         *
         * @param arg 可以代表任何意义，贯穿整个锁同步器,这里未定义
         * @return 锁释放是否成功，实际上当前实现只有成功或抛出异常
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        /**
         * 返回一个锁定条件，每个condition都包含队列.
         *
         * @return 一个condition
         */
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();


    /**
     * 获取锁，若失败会在队列中等待.
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 获取锁，若失败会在队列中等待，但是响应中断.
     *
     * @throws InterruptedException 线程中断
     */
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    /**
     * 尝试获取锁，无论成功失败立刻返回.
     *
     * @return true 获取锁成功， false 获取锁失败
     */
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    /**
     * 尝试获取锁，获取锁成功或到达超时时间后返回，响应线程中断信号.
     *
     * @param time 超时等待时间
     * @param unit 时间的单位
     * @return true 获取锁成功， false 获取锁失败或超时
     * @throws InterruptedException 被中断抛出异常
     */
    public boolean tryLock(final long time, final TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    /**
     * 释放锁，无论成功失败会立刻返回.
     */
    public void unlock() {
        sync.release(1);
    }

    /**
     * 新建一个锁的condition.
     *
     * @return condition
     */
    public Condition newCondition() {
        return sync.newCondition();
    }


}
