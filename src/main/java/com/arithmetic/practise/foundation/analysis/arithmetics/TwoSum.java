package com.arithmetic.practise.foundation.analysis.arithmetics;

import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;

public class TwoSum implements ArrayAnalysis {

    @Override
    public void exec(int[] a) {
        int count = 0;
        for (int i = 0, len = a.length; i < len; i++)
            for (int j = i + 1; j < len; j++)
                if (a[i] + a[j] == 0)
                    count++;
    }
}
