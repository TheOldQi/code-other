package com.arithmetic.practise.foundation.analysis.framework;

import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;
import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayTimeTrialer;
import com.arithmetic.practise.utils.RandomUtils;
import com.arithmetic.practise.utils.StopWatch;

/**
 * 实验程序
 *
 * @author qixiafei
 */
public class ArrayRandomTimeTrialer implements ArrayTimeTrialer {

    /**
     * 计算规模n的时候算法执行时间
     *
     * @param n
     * @return
     */
    @Override
    public double trial(int initSize, ArrayAnalysis analysis) {
        int max = 1000000;
        int[] a = new int[initSize];
        for (int i = 0; i < initSize; i++) {
            a[i] = RandomUtils.uniform(-max, max);
        }
        StopWatch watch = new StopWatch();
        analysis.exec(a);
        return watch.elapsedTime();
    }
}
