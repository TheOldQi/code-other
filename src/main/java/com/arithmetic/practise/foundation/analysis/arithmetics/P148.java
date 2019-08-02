package com.arithmetic.practise.foundation.analysis.arithmetics;

import com.arithmetic.practise.foundation.analysis.framework.superclass.ArrayAnalysis;

public class P148 implements ArrayAnalysis {

    @Override
    public void exec(int[] a) {
        int sum = 0;
        for (int i = 0, len = a.length; i < len; i++)
            for (int j = i + 1; j < len; j++)
                if (a[i] == a[j])
                    sum++;
        System.out.println("找到的相同的整数对数量:" + sum);
    }

}
