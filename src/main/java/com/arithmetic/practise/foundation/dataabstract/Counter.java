package com.arithmetic.practise.foundation.dataabstract;

/**
 * 计数器.
 *
 * @author qixiafei
 */
public class Counter {

    /**
     * 计数器的名字.
     */
    private String id;

    /**
     * 计数器当前值.
     */
    private int value;

    /**
     * 计数器计数次数.
     */
    private int operTime;

    /**
     * 构造一个新的计算器.
     *
     * @param id 计数器的名字
     */
    public Counter(final String id) {
        this.id = id;
        this.value = 0;
    }

    /**
     * 计数器增加1.
     */
    public synchronized void increment() {
        ++value;
        ++operTime;
    }

    /**
     * 查询该对象创建后计数器加1的次数.
     *
     * @return 该对象创建后计数器加1的次数
     */
    public synchronized int tally() {
        return operTime;
    }

    @Override
    public String toString() {
        return "Counter " + id + ": currentValue:" + value + ",operTime: " + operTime;
    }
}
