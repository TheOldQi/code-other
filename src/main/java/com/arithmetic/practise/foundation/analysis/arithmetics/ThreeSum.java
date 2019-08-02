package com.arithmetic.practise.foundation.analysis.arithmetics;

import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;

public class ThreeSum implements ArrayAnalysis {

    /**
     * 统计和为0的三元组的数量
     *
     * @param a
     */
    @Override
    public void exec(int[] a) {
        int count = 0;
        for (int i = 0, len = a.length; i < len; i++)
            for (int j = i + 1; j < len; j++)
                for (int k = j + 1; k < len; k++) {
                    try {
                        if (a[i] + a[j] + a[k] == 0) {
                            count++;
                        }
                    } catch (Exception e) {

                    }
                }
    }
}
